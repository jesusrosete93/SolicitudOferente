package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteEcoTecnologiasService;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReporteECcoTecnologiaForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonReporteEcoTecnologia;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonReporteInexUvOferente;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReporteOferenteEjemploController {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteOferenteEjemploController.class);
	private static final String PREFIJO_LOG = "[RIUOC OFEEJMPLO] - ";
	
//	@Autowired
//	@Qualifier("EcoTecnologiasBusiness")
//	private ReporteEcoTecnologiasService<ReporteEcoUvEcoTecnologiaDomain> service;
//	
//	@Autowired
//	@Qualifier("ReporteEcoTecnologiaValidator")
//	private Validator validator;
//	
//	@Autowired
//	private MessageSource mensajes;
	
	
	
	@RequestMapping(value="/initReporteOferenteEjm.htm",method=RequestMethod.GET)
	public String initReporteEcoTec(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		ReporteECcoTecnologiaForm forma = new ReporteECcoTecnologiaForm();
		LOGGER.info(PREFIJO_LOG + "Inicializando vista para reporte de Oferente Ejemplo...");

		model.addAttribute("reporteEcoTec",forma);
		return "viewReporteOerenteEjm";
	}
	
	@RequestMapping(value="/initReporteOferenteEjmVer2.htm",method=RequestMethod.GET)
	public String initReporteOfe(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		ReporteECcoTecnologiaForm forma = new ReporteECcoTecnologiaForm();
		LOGGER.info(PREFIJO_LOG + "Inicializando vista para reporte de Oferente Ejemplo...");

		model.addAttribute("reporteEcoTec",forma);
		return "viewReporteOerenteEjm2";
	}
	
//	@RequestMapping(value="/reporteEcoTecnologias.json",method=RequestMethod.POST)
//	public @ResponseBody RespuestaJsonReporteEcoTecnologia procesarPeticionReporte(@ModelAttribute("reporteEcoTec")ReporteECcoTecnologiaForm formulario,BindingResult result)
//	{
//		RespuestaJsonReporteEcoTecnologia respuesta = new RespuestaJsonReporteEcoTecnologia();
//		LOGGER.info(PREFIJO_LOG+"Procesando petición para generar reporte...");
//		LOGGER.info(PREFIJO_LOG+"Valores: "+formulario.toString());
//		try
//		{
//			validator.validate(formulario,result);
//			if( result.hasErrors())
//			{
//				LOGGER.info(PREFIJO_LOG+"Formulario con errores");
//				Map<String,String> errores = new HashMap<String, String>();
//				for( FieldError  fe :  result.getFieldErrors())
//				{
//					if( fe.getCode().trim().equals("error.consulta.solo.un.criterio"))
//					{
//						respuesta.setCodigoRespuesta("0001");
//						respuesta.setMensajeError(mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
//						break;
//					}else
//					{
//						respuesta.setCodigoRespuesta("0002");
//						if( fe.getDefaultMessage()!=null && !fe.getDefaultMessage().trim().equals("") && fe.getDefaultMessage().trim().contains("Failed to convert property value of type [java.lang.String] to required type [int] for property 'vivienda'; nested exception is java.lang.NumberFormatException") )
//						{
//							LOGGER.info(PREFIJO_LOG+"Error: El dato Vivienda tiene que ser númerico");
//							errores.put("errores","El dato Vivienda tiene que ser númerico");
//							break;
//						}else
//						{
//							LOGGER.info(PREFIJO_LOG+"Error: "+mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
//							errores.put(fe.getField(),mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
//							break;
//						}
//						
//					}
//				}
//				respuesta.setErrores(true);
//				respuesta.setCodigoRespuesta("9999");
//				respuesta.setMensajesError(errores);
//				return respuesta;
//			}else
//			{
//				
////				formulario.setCveEcoTecnologia(formulario.getCveEcoTecnologia().trim());
//				LOGGER.info("valor de la clave Ecotecnologia: "+formulario.getCveEcoTecnologia());
////				if( formulario.getCveEcoTecnologia().trim().length()==8){
////					formulario.setCveEcoTecnologia(" "+formulario.getCveEcoTecnologia());
////				}
//				LOGGER.info(PREFIJO_LOG+"Formulario sin errores, obteniendo reporte");
//				List<ReporteEcoUvEcoTecnologiaDomain> reporte = service.generarReporteEcoTecnologias(
//																								Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd")
//																								,Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd")
//																								,formulario.getDesarrollador()
//																								,formulario.getCveEcoTecnologia());
//				if( reporte!=null && !reporte.isEmpty())
//				{
//					respuesta.setCodigoRespuesta("0000");
//					respuesta.setDescripcionRespuesta("Reporte generado, exitosamente");
//					respuesta.setListado(reporte);
//					LOGGER.debug(PREFIJO_LOG+"Resultados 2: "+Arrays.asList(reporte).toString());
//				}else
//				{
//					respuesta.setCodigoRespuesta("0003");
//					respuesta.setDescripcionRespuesta("No se encontraron registros");
//					respuesta.setListado(new ArrayList<ReporteEcoUvEcoTecnologiaDomain>());
//				}
//			}
//		}catch (BusinessException e) {
//			LOGGER.error(PREFIJO_LOG+e.getDescripcion(),e.getError());
//			respuesta.setCodigoRespuesta("9000");
//			respuesta.setDescripcionRespuesta(e.getMessage());
//			
//		}catch (Exception e) {
//			LOGGER.error(PREFIJO_LOG+"Error al procesar petición de generación de reporte",e);
//			respuesta.setCodigoRespuesta("9001");
//			respuesta.setDescripcionRespuesta("Error en la consulta de la información de la bitacora de Ro");
//		}
//	 return respuesta;
//	}
//	


}
