package mx.org.infonavit.solicitud.oferente.business;
//package mx.org.infonavit.coberturacalidad.procesos;
//
//import static mx.org.infonavit.coberturacalidad.utilerias.Cadenas.formatoMoneda;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.concurrent.Callable;
//
//import org.apache.log4j.Logger;
//
//import mx.org.infonavit.coberturacalidad.vo.InformacionViviendaVo;
//import mx.org.infonavit.servicios.spp.utilerias.ServiciosSPP;
//import mx.org.infonavit.spp.servicios.conciliacion.ConciliacionRequest;
//import mx.org.infonavit.spp.servicios.conciliacion.ConciliacionResponse;
//import mx.org.infonavit.spp.servicios.conciliacion.ObjectFactory;
//import mx.org.infonavit.spp.servicios.conciliacion.WsServiceConciliacionCoberturaCalidadSppHttpEndpointProxy;
//
//
//
//public class ConciliacionSpp implements Callable<List<InformacionViviendaVo>>
//{
//	private static final Logger LOGGER = Logger.getLogger(ConciliacionSpp.class);
//	private List<InformacionViviendaVo> viviendasInfonavit;
//	private WsServiceConciliacionCoberturaCalidadSppHttpEndpointProxy serviceSpp;
//	public ConciliacionSpp(List<InformacionViviendaVo> viviendasInfonavit,WsServiceConciliacionCoberturaCalidadSppHttpEndpointProxy servicioSpp)
//	{
//		this.viviendasInfonavit	= viviendasInfonavit;
//		this.serviceSpp			= servicioSpp;
//	}
//	
//	
//	@Override
//	public List<InformacionViviendaVo> call() throws Exception {
//		List<InformacionViviendaVo> concialidadasSpp = new ArrayList<InformacionViviendaVo>();
//    	
//		
//		
//	    for (InformacionViviendaVo vivienda: this.viviendasInfonavit) 
//        {
//        		ConciliacionRequest requestSpp = new ConciliacionRequest();
//        		ObjectFactory factory = new ObjectFactory();
//        		try
//        		{
//        			ConciliacionResponse responseSpp = null; 
//        			requestSpp.setUsuario	( factory.createConciliacionRequestUsuario(ServiciosSPP.USUARIO) );
//					requestSpp.setPassword	( factory.createConciliacionRequestPassword(ServiciosSPP.CONTRASENIA) );
//					requestSpp.setCuv		( factory.createConciliacionRequestCuv(vivienda.getCuv()));
//					
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Invocando servicio de conciliación...");
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - EP["+serviceSpp._getDescriptor().getEndpoint()+"]");
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Peticion:["+requestSpp+"] - U["+requestSpp.getUsuario().getValue()+"] P["+requestSpp.getPassword().getValue()+"]");
//					long timeStartFuture1 = Calendar.getInstance().getTimeInMillis();
//					responseSpp = serviceSpp.consultarVivienda(requestSpp);
//					long timeEndFuture1 = Calendar.getInstance().getTimeInMillis();
//					long timeNeededFuture1 = timeEndFuture1 - timeStartFuture1;
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Respuesta en:["+timeNeededFuture1+"] ms");
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Respuesta :["+responseSpp+"]");
//					if( responseSpp.isResultado().booleanValue() )
//					{
//						if( conciliar(vivienda,responseSpp))
//						{
//							vivienda.setIdEstatusConciliacionEcc(2);
//							vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//						}else
//						{
//							vivienda.setIdEstatusConciliacionEcc(3);
//							vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//						}
//					}else
//					{
//						LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Conciliación con SPP, exitosa");
//						vivienda.setIdEstatusConciliacionEcc(3);
//						vivienda.setIntentoConciliacion(vivienda.getIdEstatusConciliacionEcc());
//						vivienda.setMotivoConciliacionEcc("Respuesta del servicio: "+responseSpp.getMensaje().getValue());
//					}
//					LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Estatus asignado :["+vivienda.getIdEstatusConciliacionEcc()+"]");
//					concialidadasSpp.add(vivienda);
//        		}catch (Exception exception) {
//        			LOGGER.error("[CSPP] - Cuv["+vivienda.getCuv()+"] - Error al comunicarce con el servicio de RUV",exception);
//        			vivienda.setIdEstatusConciliacionEcc(3);
//        			vivienda.setIntentoConciliacion(vivienda.getIntentoConciliacion());
//        			vivienda.setMotivoConciliacionRuv("Error en el llamado al servicio de RUV");
//        			LOGGER.info("[CSPP] - Cuv["+vivienda.getCuv()+"] - Estatus asignado :["+vivienda.getIdEstatusConciliacionEcc()+"]");
//					concialidadasSpp.add(vivienda);
//    	  			continue;
//				}
//        }
//    return concialidadasSpp;
//	}
//	
//	/**
//	 * 
//	 * @param viviendaInfonavit
//	 * @param responseRuv
//	 * @return
//	 */
//	public static boolean conciliar(InformacionViviendaVo viviendaInfonavit, ConciliacionResponse responseSpp )
//	{
//		boolean regreso = false;
//		
//
//		StringBuffer sb = new StringBuffer();
//		StringBuffer motivos = new StringBuffer();
//		sb.append("\n\t\tINFONAVIT\t\t|\tSPP");
//		sb.append("\n\t\tOrden:["+viviendaInfonavit.getIdOrdenVerificacion().trim()+"]\t|\tOrden:["+responseSpp.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim()+"]");
//		sb.append("\n\t\tCuv:["+viviendaInfonavit.getCuv().trim()+"]\t|\tCuv:["+responseSpp.getVivienda().getValue().getCuv().getValue().toString().trim()+"]");
//		sb.append("\n\t\tVivienda:["+viviendaInfonavit.getIdVivienda()+"]\t\t|\tVivienda:["+responseSpp.getVivienda().getValue().getIdVivienda().intValue()+"]");
//		sb.append("\n\t\tPrecio:["+viviendaInfonavit.getPrecio().toString().trim()+"]\t|\tPrecio:["+responseSpp.getVivienda().getValue().getCosto().toString().trim()+"]");
//		LOGGER.info("[CSPP] - Cuv["+viviendaInfonavit.getCuv()+"] - Valores a conciliar: "+sb.toString());
//		if(     viviendaInfonavit.getIdOrdenVerificacion().trim().equals(responseSpp.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim())
//			&&  viviendaInfonavit.getCuv().trim().equals(responseSpp.getVivienda().getValue().getCuv().getValue().trim())
//			&&	viviendaInfonavit.getIdVivienda()==responseSpp.getVivienda().getValue().getIdVivienda()
//			&&  viviendaInfonavit.getPrecio().equals(responseSpp.getVivienda().getValue().getCosto())
//			)
//		{
//			regreso = true;
//			viviendaInfonavit.setMotivoConciliacionEcc("");
//			LOGGER.info("[CSPP] - Cuv["+viviendaInfonavit.getCuv()+"] - Conciliación con SPP, exitosa");
//		}else
//		{
//			LOGGER.info("[CSPP] - Cuv["+viviendaInfonavit.getCuv()+"] - Conciliación con SPP, no exitosa");
//			if( !viviendaInfonavit.getIdOrdenVerificacion().trim().equals(responseSpp.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().toString().trim()) )
//			{
//				motivos.append("Orden verificación de vivienda diferente, RUV["+responseSpp.getOrdenVerificacion().getValue().getIdOrdenVerificacion().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getIdOrdenVerificacion()+"]");
//			}
//			if( viviendaInfonavit.getIdVivienda()!=responseSpp.getVivienda().getValue().getIdVivienda().intValue() )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nId vivienda diferente, SPP["+responseSpp.getVivienda().getValue().getIdVivienda().intValue()+"], INFONAVIT["+viviendaInfonavit.getIdVivienda()+"]");
//				}else
//				{
//					motivos.append("Id vivienda diferente, SPP["+responseSpp.getVivienda().getValue().getIdVivienda().intValue()+"], INFONAVIT["+viviendaInfonavit.getIdVivienda()+"]");
//				}
//				
//			}
//			if( !viviendaInfonavit.getCuv().trim().equals(responseSpp.getVivienda().getValue().getCuv().getValue().trim()) )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nCuv de vivienda diferente, SPP["+responseSpp.getVivienda().getValue().getCuv().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getCuv().trim()+"]");
//				}else
//				{
//					motivos.append("Cuv de vivienda diferente, SPP["+responseSpp.getVivienda().getValue().getCuv().getValue().trim()+"], INFONAVIT["+viviendaInfonavit.getCuv().trim()+"]");
//				}	
//			}
//			if( !viviendaInfonavit.getPrecio().equals(responseSpp.getVivienda().getValue().getCosto()) )
//			{
//				if( motivos.length()>0)
//				{
//					motivos.append("\nPrecio de vivienda diferente, SPP["+formatoMoneda(responseSpp.getVivienda().getValue().getCosto())+"], INFONAVIT["+formatoMoneda(viviendaInfonavit.getPrecio())+"]");
//				}else
//				{
//					motivos.append("Precio de vivienda diferente, SPP["+formatoMoneda(responseSpp.getVivienda().getValue().getCosto())+"], INFONAVIT["+formatoMoneda(viviendaInfonavit.getPrecio())+"]");
//				}	
//			}
//			viviendaInfonavit.setMotivoConciliacionEcc(motivos.toString());
//			LOGGER.info("[CSPP] - Cuv["+viviendaInfonavit.getCuv()+"] - Motivos: ["+motivos.toString()+"]");
//		}
//	
//	  return regreso;
//	}
//}
