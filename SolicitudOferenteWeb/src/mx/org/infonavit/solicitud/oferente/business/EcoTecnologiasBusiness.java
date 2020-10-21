package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.presentacion.ReporteEcoTecnologiaDomainUtils.generarListaECODomain;

import java.util.Arrays;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteEcoTecnologiasService;
import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteEcoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReportesEcoDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("EcoTecnologiasBusiness")
public class EcoTecnologiasBusiness implements ReporteEcoTecnologiasService<ReporteEcoUvEcoTecnologiaDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(EcoTecnologiasBusiness.class);
	private static final String PREFIJO_LOG = "[RIB] - ";
	
	
	@Autowired
	@Qualifier("ReporteEcoTecnologiasDao")
	private AbstractReportesEcoDao<ReporteEcoTecnologiaVo> persistenceEco;
			
//	@Autowired
//	@Qualifier("ClaveEcoBusiness")
//	private EcoTecOFeBusiness serviceEco;
	
//	@Autowired
//	@Qualifier("ClaveEcoBusiness")
//	private ClaveEcoBusiness serviceTec;

	@Override
	public List<ReporteEcoUvEcoTecnologiaDomain> generarReporteEcoTecnologias(String... criterios) throws BusinessException {

		
			List<ReporteEcoUvEcoTecnologiaDomain> regreso = null;
			final ReporteEcoTecnologiaVo registro = new ReporteEcoTecnologiaVo();
		
			boolean tieneRfc=false;
			try
			{
				LOGGER.info(PREFIJO_LOG+"Generación reporte ECO UV Tecnologia...");
				LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(criterios).toString());
//				if(registro.getPaquete().length() == 12)
					
				
				registro.setClaveTecnologia(criterios[0]);
				registro.setPaquete(criterios[1]);
				registro.setFechaSolicitudInicio(criterios[2]);
				registro.setFechaSolicitudFin(criterios[3]);
				
				
//				regreso = generarListaDomain(persistence.buscarReporteInexOferente(registro));
//				regreso = generarListaEcoTecDomain(persistenceEco.buscarReporteEcoTecnologias(registro));
				regreso = generarListaECODomain(persistenceEco.buscarReporteEcoTecnologias(registro));
				
				if( regreso!=null && !regreso.isEmpty() )
				{
					if( registro.getFechaSolicitudFin()!= null && !registro.getFechaSolicitudFin().trim().equals("") )
					{
						CollectionUtils.forAllDo(regreso,new Closure(){
																		@Override
																		public void execute(Object arg0) {
//																		((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(serviceEco.consultareECO(registro.getClaveTecnologia()));
																		}
													});
					}
					else if( registro.getFechaSolicitudFin()!=null && !registro.getFechaSolicitudFin().trim().equals("") )
					{
//						final PaqueteEcoDomain ecoTecnologia = serviceEco.buscarClaveEco(registro.getClaveTecnologia());
//						if( ecoTecnologia!=null)
//						{
//							CollectionUtils.forAllDo(regreso,new Closure(){
//																				@Override
//																				public void execute(Object arg0) {
//																					((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(serviceEco.consultareECO(registro.getPaquete()));
//																				}
//																		});
						}else if( registro.getPaquete()!=null && !registro.getPaquete().trim().equals("") )
						{
							CollectionUtils.forAllDo(regreso,new Closure(){
																				@Override
																				public void execute(Object arg0) {
	//																			((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(serviceEco.consultareECO(registro.getPaquete()));
																				}
																		});
						
					}else
					{
						CollectionUtils.forAllDo(regreso,new Closure(){
																		@Override
																		public void execute(Object arg0) {
//																			TecnologiaDomain tecnologia = new TecnologiaDomain(null, null,null,null);
//																			
//																			tecnologia.setPaquete(registro.getPaquete());
//																			tecnologia.setClaveTecnologia("");
//																			tecnologia.setanioMES("3");
//																			tecnologia.setnumecotec("4");
//																			
//																			
//																			((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(tecnologia);
																		
																		}
													});
					}
				}
			 return regreso;
			}catch (Exception e) {
				throw new BusinessException("Error en la generación del reporte de Ecotecnologias",e);
			}

		}



}
