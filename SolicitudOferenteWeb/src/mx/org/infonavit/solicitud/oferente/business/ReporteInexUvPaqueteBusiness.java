package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.presentacion.ReporteInexUvPaqueteDomainUtils.generarListaUnidadesDomain;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.Arrays;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteInexUvPaqueteService;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.EstadoDomian;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvPaqueteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReporteInexUvPaqueteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/**
 * <p>
 * Clase que encapsula las reglas de negocio definidas para la 
 * generación del reporte de viviendas de paquete para el INEX 
 * de unidades de valuación desde el módulo de ofertas y sembrado.
 * </p>
 * 
 * @author Adrian Casas
 *
 */
@Service("ReporteInexUvPaqueteBusiness")
public class ReporteInexUvPaqueteBusiness implements ReporteInexUvPaqueteService<ReporteInexUvPaqueteDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvPaqueteBusiness.class);
	private static final String PREFIJO_LOG = "[RIUP] - ";
	private static final String PROCESO_REPORTE = " Generación del reporte de total de paquetes ";
	
	@Autowired
	@Qualifier("ReporteInexUvPaqueteDao")
	private AbstractReporteInexUvPaqueteDao<ReporteInexUvPaqueteVo> persistence;
	
	@Autowired
	@Qualifier("PaqueteBusiness")
	private PaqueteBusinessService servicePaquete;
	
	@Autowired
	@Qualifier("OferenteBusiness")
	private OferenteService serviceOferente;
	

	@Override
	public ReporteInexUvPaqueteDomain generarReporteInexUvPaquete(final String... criterios) throws BusinessException {
		ReporteInexUvPaqueteDomain domain = null;
		try
		{
		  domain = new ReporteInexUvPaqueteDomain();
		  LOGGER.info(PREFIJO_LOG+PROCESO_REPORTE+INICIO_OK);
		  LOGGER.debug(PREFIJO_LOG+PROCESO_REPORTE+"Criterios: "+Arrays.asList(criterios).toString());
		  ReporteInexUvPaqueteVo criteriosBusqueda = new ReporteInexUvPaqueteVo();
		  criteriosBusqueda.setPaquete(criterios[0]);
		  criteriosBusqueda.setRfcOferente(criterios[1]);
		  criteriosBusqueda.setFechaSolicitudInicio("");
		  criteriosBusqueda.setFechaSolicitudFin("");
		  domain.setTotalVivienasEstado(persistence.buscarTotalViviendasEstado(criteriosBusqueda));
		  domain.setTotalViviendasPaquete(persistence.buscarViviendasPaquete(criteriosBusqueda));
		  domain.setTotalViviendasSolicitadas(persistence.buscarSolicitudesPaquete(criteriosBusqueda));
		  domain.setTotalViviendasSinSolicitud(domain.getTotalViviendasPaquete()-domain.getTotalViviendasSolicitadas());
		  domain.setTotalProduccionOferente(domain.getTotalProduccionOferente()+persistence.buscarProduccionOferentePaquetesMayor(criteriosBusqueda));
		  domain.setTotalProduccionOferente(domain.getTotalProduccionOferente()+persistence.buscarProduccionOferentePaquetesMenor(criteriosBusqueda));
		  domain.setListado(generarListaUnidadesDomain(persistence.buscarTotalViviendasPorUnidad(criteriosBusqueda)));
		  
		  PaqueteDomain paquete = servicePaquete.buscarPaquetePorId(criterios[0]);
		  if( paquete!=null )
		  {
			  if( paquete.getRfcOferente().trim().length()==12){
				  paquete.setRfcOferente(" "+paquete.getRfcOferente());
				}
			  domain.setOferente(serviceOferente.consultarOferente(paquete.getRfcOferente()));
		  }else
		  {
			  OferenteDomain oferente = new OferenteDomain();
			  oferente.setNombreRazonSocial("");
			  domain.setOferente(oferente);
		  }
		  
		  
		  if( domain.getListado()!=null && !domain.getListado().isEmpty() )
		  {
			  CollectionUtils.forAllDo(domain.getListado(),new Closure(){
				@Override
				public void execute(Object arg0) {
					((ReporteInexUvOferenteDomain)arg0).setEstado(new EstadoDomian(criterios[0].substring(0,2),Estado.CATALOGO_ESTADOS.get(criterios[0].substring(0,2))));
				}
			  });
		  }
		  
		  LOGGER.info(PREFIJO_LOG+PROCESO_REPORTE+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_LOG+PROCESO_REPORTE+FIN_NOK);
			throw new BusinessException("Error en el proceso de generación del reporte de total de paquete",e);
		}
	 return domain;
	}

}
