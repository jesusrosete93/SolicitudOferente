package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.presentacion.ReporteInexUvOferenteDomainUtils.generarListaDomain;

import java.util.Arrays;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteInexUvOferenteService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReportesDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ReporteInexUvBusiness")
public class ReporteInexUvBusiness implements ReporteInexUvOferenteService<ReporteInexUvOferenteDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvBusiness.class);
	private static final String PREFIJO_LOG = "[RIB] - ";
	
	@Autowired
	@Qualifier("ReporteInexUvOferenteDao")
	private AbstractReportesDao<ReporteInexUvOferenteVo> persistence;
	
	@Autowired
	@Qualifier("OferenteBusiness")
	private OferenteService serviceOferente;
	
	@Autowired
	@Qualifier("PaqueteBusiness")
	private PaqueteBusinessService servicePaquete;

	@Override
	public List<ReporteInexUvOferenteDomain> generarReporteInexUvOferente(String... criterios) throws BusinessException {
		
		List<ReporteInexUvOferenteDomain> regreso = null;
		final ReporteInexUvOferenteVo registro = new ReporteInexUvOferenteVo();
		boolean tieneRfc=false;
		try
		{
			LOGGER.info(PREFIJO_LOG+"Generación reporte Inex UV Oferente...");
			LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(criterios).toString());
			registro.setEstado(criterios[0]);
			registro.setFechaSolicitudInicio(criterios[1]);
			registro.setFechaSolicitudFin(criterios[2]);
			registro.setPaquete(criterios[3]);
			registro.setRfcOferente(criterios[4]);
			
			regreso = generarListaDomain(persistence.buscarReporteInexOferente(registro));
			
			if( regreso!=null && !regreso.isEmpty() )
			{
				if( registro.getRfcOferente()!= null && !registro.getRfcOferente().trim().equals("") )
				{
					CollectionUtils.forAllDo(regreso,new Closure(){
																	@Override
																	public void execute(Object arg0) {
																		((ReporteInexUvOferenteDomain)arg0).setOferente(serviceOferente.consultarOferente(registro.getRfcOferente()));
																	}
												});
				}else if( registro.getPaquete()!=null && !registro.getPaquete().trim().equals("") )
				{
					final PaqueteDomain paquete = servicePaquete.buscarPaquetePorId(registro.getPaquete());
					if( paquete!=null)
					{
						CollectionUtils.forAllDo(regreso,new Closure(){
																			@Override
																			public void execute(Object arg0) {
																				((ReporteInexUvOferenteDomain)arg0).setOferente(serviceOferente.consultarOferente(paquete.getRfcOferente()));
																			}
																	});
					}else
					{
						CollectionUtils.forAllDo(regreso,new Closure(){
																			@Override
																			public void execute(Object arg0) {
																				OferenteDomain oferente = new OferenteDomain();
																				oferente.setNombreRazonSocial("");
																				((ReporteInexUvOferenteDomain)arg0).setOferente(oferente);
																			}
																	});
					}
				}else
				{
					CollectionUtils.forAllDo(regreso,new Closure(){
																	@Override
																	public void execute(Object arg0) {
																		OferenteDomain oferente = new OferenteDomain();
																		oferente.setNombreRazonSocial("");
																		((ReporteInexUvOferenteDomain)arg0).setOferente(oferente);
																	}
												});
				}
			}
		 return regreso;
		}catch (Exception e) {
			throw new BusinessException("Error en la generación del reporte de UV Inex oferente",e);
		}
	}

}
