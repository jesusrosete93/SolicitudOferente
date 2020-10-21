package mx.org.infonavit.solicitud.oferente.business;
//package mx.org.infonavit.coberturacalidad.procesos;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.concurrent.Callable;
//
//import org.apache.log4j.Logger;
//
//import mx.org.infonavit.coberturacalidad.vo.InformacionViviendaVo;
//import mx.org.infonavit.servicios.ruv.conciliacion.ConciliacionResponse;
//import mx.org.infonavit.servicios.ruv.conciliacion.ServicioConciliacionRuvProxy;
//import mx.org.infonavit.servicios.ruv.utilerias.ServiciosRUV;
//
//public class ConciliacionRuv implements Callable<List<InformacionViviendaVo>>
//{
//	private static final Logger LOGGER = Logger.getLogger(ConciliacionRuv.class);
//	private List<InformacionViviendaVo> viviendasInfonavit;
//	private ServicioConciliacionRuvProxy serviceRuv;
//	public ConciliacionRuv(List<InformacionViviendaVo> viviendasInfonavit,ServicioConciliacionRuvProxy servicioRuv)
//	{
//		this.viviendasInfonavit	= viviendasInfonavit;
//		this.serviceRuv			= servicioRuv;
//	}
//	
//	
//	@Override
//	public List<InformacionViviendaVo> call() throws Exception {
//		List<InformacionViviendaVo> concialidadasRuv = new ArrayList<InformacionViviendaVo>();
//    	
//		
//		
//	    for (InformacionViviendaVo vivienda : this.viviendasInfonavit) 
//        {
//        		mx.org.infonavit.servicios.ruv.conciliacion.ConciliacionRequest 
//				requestRuv = new mx.org.infonavit.servicios.ruv.conciliacion.ConciliacionRequest();
//        		try
//        		{
//        			mx.org.infonavit.servicios.ruv.conciliacion.ConciliacionResponse responseRuv = null; 
//					requestRuv.setUsuario( ServiciosRUV.USUARIO );
//					requestRuv.setPassword( ServiciosRUV.CONTRASENIA );
//					requestRuv.setCuv( vivienda.getCuv() );
//					
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Invocando servicio de conciliación de RUV...");
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - EP["+serviceRuv._getDescriptor().getEndpoint()+"]");
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Peticion:["+requestRuv+"]");
//					long timeStartFuture1 = Calendar.getInstance().getTimeInMillis();
//					responseRuv = serviceRuv.consultarVivienda(requestRuv);
//					long timeEndFuture1 = Calendar.getInstance().getTimeInMillis();
//					long timeNeededFuture1 = timeEndFuture1 - timeStartFuture1;
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Respuesta en:["+timeNeededFuture1+"] ms");
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Respuesta :["+responseRuv+"]");
//					if( responseRuv.isResultado().booleanValue() )
//					{
//						if( conciliar(vivienda,responseRuv))
//						{
//							vivienda.setIdEstatusConciliacionRuv(2);
//							vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//						}else
//						{
//							vivienda.setIdEstatusConciliacionRuv(3);
//							vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//						}
//					}else
//					{
//						LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Conciliación con RUV, no exitosa");
//						vivienda.setIdEstatusConciliacionRuv(3);
//						vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//						vivienda.setMotivoConciliacionRuv("Respuesta del servicio: "+responseRuv.getMensaje().getValue());
//					}
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Estatus asignado :["+vivienda.getIdEstatusConciliacionRuv()+"]");
//					concialidadasRuv.add(vivienda);
//        		}catch (Exception exception) {
//        			LOGGER.error("[CRUV] - Cuv["+vivienda.getCuv()+"] - Error al comunicarce con el servicio de RUV",exception);
//        			vivienda.setIdEstatusConciliacionRuv(3);
//					vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//					vivienda.setMotivoConciliacionRuv("Error en el llamado al servicio de RUV");
//					LOGGER.info("[CRUV] - Cuv["+vivienda.getCuv()+"] - Estatus asignado :["+vivienda.getIdEstatusConciliacionRuv()+"]");
//					concialidadasRuv.add(vivienda);
//    	  			continue;
//				}
//        }
//    return concialidadasRuv;
//	}
//	
//	/**
//	 * 
//	 * @param viviendaInfonavit
//	 * @param responseRuv
//	 * @return
//	 */
//	public static boolean conciliar(InformacionViviendaVo viviendaInfonavit, ConciliacionResponse responseRuv )
//	{
//		boolean regreso = false;
//		StringBuffer motivos = new StringBuffer();
//		viviendaInfonavit.setPrecio(viviendaInfonavit.getPrecio().setScale(3));
//
//		StringBuffer sb = new StringBuffer();
//		sb.append("\n\t\tINFONAVIT\t\t|\tRUV");
//		sb.append("\n\t\tOrden:["+viviendaInfonavit.getIdOrdenVerificacion().trim()+"]\t|\tOrden:["+responseRuv.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim()+"]");
//		sb.append("\n\t\tCuv:["+viviendaInfonavit.getCuv().trim()+"]\t|\tCuv:["+responseRuv.getVivienda().getValue().getCuv().getValue().toString().trim()+"]");
//		sb.append("\n\t\tVivienda:["+viviendaInfonavit.getIdVivienda()+"]\t\t|\tVivienda:["+responseRuv.getVivienda().getValue().getIdVivienda().intValue()+"]");
//		sb.append("\n\t\tPrecio:["+viviendaInfonavit.getPrecio()+"]\t|\tPrecio:["+responseRuv.getVivienda().getValue().getCosto()+"]");
//		LOGGER.info("[CRUV] - Cuv["+viviendaInfonavit.getCuv()+"] - Valores a conciliar: "+sb.toString());
//		if(     viviendaInfonavit.getIdOrdenVerificacion().trim().equals(responseRuv.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim())
//			&&  viviendaInfonavit.getCuv().trim().equals(responseRuv.getVivienda().getValue().getCuv().getValue().trim())
//			&&	viviendaInfonavit.getIdVivienda()==responseRuv.getVivienda().getValue().getIdVivienda()
//			&&  viviendaInfonavit.getPrecio().equals(responseRuv.getVivienda().getValue().getCosto())
//			)
//		{
//			regreso = true;
//			viviendaInfonavit.setMotivoConciliacionRuv("");
//			LOGGER.info("[CRUV] - Cuv["+viviendaInfonavit.getCuv()+"] - Conciliación con RUV, exitosa");
//			
//		}else
//		{
//			LOGGER.info("[CRUV] - Cuv["+viviendaInfonavit.getCuv()+"] - Conciliación con RUV, no exitosa");
//			if( !viviendaInfonavit.getIdOrdenVerificacion().trim().equals(responseRuv.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().toString().trim()) )
//			{
//				motivos.append("Orden verificación de vivienda diferente, RUV["+responseRuv.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getIdOrdenVerificacion()+"]");
//			}
//			if( viviendaInfonavit.getIdVivienda()!=responseRuv.getVivienda().getValue().getIdVivienda().intValue() )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nId vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getIdVivienda().intValue()+"], INFONAVIT["+viviendaInfonavit.getIdVivienda()+"]");
//				}else
//				{
//					motivos.append("Id vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getIdVivienda().intValue()+"], INFONAVIT["+viviendaInfonavit.getIdVivienda()+"]");
//				}
//				
//			}
//			if( !viviendaInfonavit.getCuv().trim().equals(responseRuv.getVivienda().getValue().getCuv().getValue().trim()) )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nCuv de vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getCuv().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getCuv().trim()+"]");
//				}else
//				{
//					motivos.append("Cuv de vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getCuv().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getCuv().trim()+"]");
//				}	
//			}
//			if( !viviendaInfonavit.getPrecio().equals(responseRuv.getVivienda().getValue().getCosto()) )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nPrecio de vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getCosto()+"], INFONAVIT["+viviendaInfonavit.getPrecio()+"]");
//				}else
//				{
//					motivos.append("Precio de vivienda diferente, RUV["+responseRuv.getVivienda().getValue().getCosto()+"], INFONAVIT["+viviendaInfonavit.getPrecio()+"]");
//				}	
//			}
//			viviendaInfonavit.setMotivoConciliacionRuv(motivos.toString());
//			LOGGER.info("[CRUV] - Cuv["+viviendaInfonavit.getCuv()+"] - Motivos: ["+motivos.toString()+"]");
//		}
//	
//	  return regreso;
//	}
//}
