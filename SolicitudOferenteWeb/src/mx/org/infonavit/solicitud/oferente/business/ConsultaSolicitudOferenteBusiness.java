package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.presentacion.ConsultaSolicitudOferenteDomainUtils.generarListaSolicitudOferente;

import java.util.Arrays;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.services.ConsultaSolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteEcoTecnologiasService;
import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteEcoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReportesConsultaOferente;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReportesEcoDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteConsultaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("ConsultaSolicitudOferenteBusiness")
public class ConsultaSolicitudOferenteBusiness implements ConsultaSolicitudOferenteService<OferenteSolicitudDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaSolicitudOferenteBusiness.class);
	private static final String PREFIJO_LOG = "[RIB] - ";
	
	
	@Autowired
	@Qualifier("ReporteSolicitudOferenteDao")
	private AbstractReportesConsultaOferente<SolicitudOferenteConsultaVo> persistenceEco;
			


	@Override
	public List<OferenteSolicitudDomain> generarReporteConsultaSolicitud(String... criterios) throws BusinessException {

		
			List<OferenteSolicitudDomain> regreso = null;
			final SolicitudOferenteConsultaVo registro = new SolicitudOferenteConsultaVo();
		
//			boolean tieneRfc=false;
//			try
//			{
				LOGGER.info(PREFIJO_LOG+"Generación reporte ECO UV Tecnologia...");
				LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(criterios).toString());
//				if(registro.getPaquete().length() == 12)
					
				registro.setFechaSolicitudInicio(criterios[0]);
				registro.setFechaSolicitudFin(criterios[1]);
				registro.setId_estatus(criterios[2]);
				registro.setId_paquete(criterios[3]);
				registro.setId_tipo_solicitud(criterios[4]);
				registro.setId_estado(criterios[5]);
//				regreso = generarListaSolicitudOferente(persistenceEco.buscarReporteEcoTecnologias(registro));
				regreso = generarListaSolicitudOferente(persistenceEco.buscarReporteEcoTecnologias(registro));

					
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
//						}else if( registro.getPaquete()!=null && !registro.getPaquete().trim().equals("") )
//						{
//							CollectionUtils.forAllDo(regreso,new Closure(){
//																				@Override
//																				public void execute(Object arg0) {
//	//																			((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(serviceEco.consultareECO(registro.getPaquete()));
//																				}
//																		});
//						
//					}else
//					{
//						CollectionUtils.forAllDo(regreso,new Closure(){
//																		@Override
//																		public void execute(Object arg0) {
//																			TecnologiaDomain tecnologia = new TecnologiaDomain(null, null,null,null);
//																			
//																			tecnologia.setPaquete(registro.getPaquete());
//																			tecnologia.setClaveTecnologia("");
//																			tecnologia.setanioMES("3");
//																			tecnologia.setnumecotec("4");
//																			
//																			
//																			((ReporteEcoUvEcoTecnologiaDomain)arg0).setTecnoDomain(tecnologia);
//																		
//																		}
//													});
					}
				}
				
			 return regreso;
//			}catch (Exception e) {
//				throw new BusinessException("Error en la generación del reporte de Ecotecnologias",e);
//			}

		}



}
