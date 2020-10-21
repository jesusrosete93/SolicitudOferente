/**
 * Clase que encapsula la 
 */

package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteInexUvPaqueteService;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvPaqueteDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReporteInexUvPaqueteForm;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonReporteInexUvPaquete;

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
public class ReporteInexUvPaqueteController {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvPaqueteController.class);
	private static final String PREFIJO_LOG = "[RIUOC] - ";
	
	@Autowired
	@Qualifier("ReporteInexUvPaqueteBusiness")
	private ReporteInexUvPaqueteService<ReporteInexUvPaqueteDomain> service;
	
	@Autowired
	@Qualifier("ReporteInexUvPaqueteValidator")
	private Validator validator;
	
	@Autowired
	private MessageSource mensajes;
	
	@Autowired
	@Qualifier("PaqueteBusiness")
	private PaqueteBusinessService servicePaquete;
	
	
	@RequestMapping(value="/initReporteInexUvPaq.htm",method=RequestMethod.GET)
	public String initReporteInexUvOferente(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		LOGGER.info(PREFIJO_LOG+"Inicializando vista para reporte de paquete...");
		ReporteInexUvPaqueteForm forma = new ReporteInexUvPaqueteForm();
		model.addAttribute("reportePForm",forma);
		return "viewReporteInexUvPaquete";
	}
	
	
	@RequestMapping(value="/reporteInexUvPaquete.json",method=RequestMethod.POST)
	public @ResponseBody RespuestaJsonReporteInexUvPaquete procesarPeticionReporte(@ModelAttribute("reportePForm")ReporteInexUvPaqueteForm formulario,BindingResult result)
	{
		RespuestaJsonReporteInexUvPaquete respuesta = new RespuestaJsonReporteInexUvPaquete();
		LOGGER.info(PREFIJO_LOG+"Procesando petición para generar reporte...");
		LOGGER.info(PREFIJO_LOG+"Valores: "+formulario.toString());
		try
		{
			validator.validate(formulario,result);
			if( result.hasErrors())
			{
				respuesta.setErrores(true);
				LOGGER.info(PREFIJO_LOG+"Formulario con errores");
				Map<String,String> errores = new HashMap<String, String>();
				for( FieldError  fe :  result.getFieldErrors())
				{
					if( fe.getCode().trim().equals("error.consulta.solo.un.criterio"))
					{
						respuesta.setCodigoRespuesta("0001");
						respuesta.setMensajeError(mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
						break;
					}else
					{
						respuesta.setCodigoRespuesta("0002");
						if( fe.getDefaultMessage()!=null && !fe.getDefaultMessage().trim().equals("") && fe.getDefaultMessage().trim().contains("Failed to convert property value of type [java.lang.String] to required type [int] for property 'vivienda'; nested exception is java.lang.NumberFormatException") )
						{
							LOGGER.info(PREFIJO_LOG+"Error: El dato Vivienda tiene que ser númerico");
							errores.put("errores","El dato Vivienda tiene que ser númerico");
							break;
						}else
						{
							LOGGER.info(PREFIJO_LOG+"Error: "+mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
							errores.put(fe.getField(),mensajes.getMessage(fe.getCode(),fe.getArguments(),null));
							break;
						}
					}
				}
				respuesta.setCodigoRespuesta("9999");
				respuesta.setMensajesError(errores);
				return respuesta;
			}else
			{
				if( true )
				{
					LOGGER.info(PREFIJO_LOG+"Formulario sin errores, obteniendo reporte");
					PaqueteDomain paquete =  servicePaquete.buscarPaquetePorId(formulario.getPaquete());
					formulario.setRfcOferente(paquete.getRfcOferente());
					
					if( formulario.getRfcOferente().trim().length()==12){
						formulario.setRfcOferente(" "+formulario.getRfcOferente());
					}
					
					ReporteInexUvPaqueteDomain reporte = service.generarReporteInexUvPaquete(  formulario.getPaquete(),formulario.getRfcOferente() );
					reporte.setTipoPaquete(paquete.getTipoPaquete());
					if( reporte!=null )
					{
						respuesta.setCodigoRespuesta("0000");
						respuesta.setDescripcionRespuesta("Reporte generado, exitosamente");
						respuesta.setObjeto(reporte);
					}else
					{
						respuesta.setCodigoRespuesta("0003");
						respuesta.setDescripcionRespuesta("No se encontraron registros");
					}
				}else
				{
					respuesta.setCodigoRespuesta("0004");
					respuesta.setDescripcionRespuesta("El paquete: "+formulario.getPaquete()+" no pertenece al oferente");
				}
			}
		}catch (BusinessException e) {
			LOGGER.error(PREFIJO_LOG+e.getDescripcion(),e.getError());
			respuesta.setCodigoRespuesta("9000");
			respuesta.setDescripcionRespuesta(e.getMessage());
			
		}catch (Exception e) {
			LOGGER.error(PREFIJO_LOG+"Error al procesar petición de generación de reporte",e);
			respuesta.setCodigoRespuesta("9001");
			respuesta.setDescripcionRespuesta("Error al procesar la petición para la generación del reporte");
		}
	 return respuesta;
	}
	
	
	
	
	
	
	
	
	

}
