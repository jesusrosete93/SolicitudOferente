/**
 * Clase que encapsula la 
 */

package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteInexUvOferenteService;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReporteInexUvOferenteForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
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
public class ReporteInexUvOferenteController {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvOferenteController.class);
	private static final String PREFIJO_LOG = "[RIUOC] - ";
	
	@Autowired
	@Qualifier("ReporteInexUvBusiness")
	private ReporteInexUvOferenteService<ReporteInexUvOferenteDomain> service;
	
	@Autowired
	@Qualifier("ReporteInexUvOferenteValidator")
	private Validator validator;
	
	@Autowired
	private MessageSource mensajes;
	
	
	@RequestMapping(value="/initReporteInexUvOfe.htm",method=RequestMethod.GET)
	public String initReporteInexUvOferente(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		ReporteInexUvOferenteForm forma = new ReporteInexUvOferenteForm();
		LOGGER.info(PREFIJO_LOG+"Inicializando vista para reporte de oferentes...");
		model.addAttribute("estados",Estado.CATALOGO_ESTADOS);
		model.addAttribute("reporteOForm",forma);
		return "viewReporteInexUvOferente";
	}
	
	
	@RequestMapping(value="/reporteINexUvOferente.json",method=RequestMethod.POST)
	public @ResponseBody RespuestaJsonReporteInexUvOferente procesarPeticionReporte(@ModelAttribute("reporteOForm")ReporteInexUvOferenteForm formulario,BindingResult result)
	{
		RespuestaJsonReporteInexUvOferente respuesta = new RespuestaJsonReporteInexUvOferente();
		LOGGER.info(PREFIJO_LOG+"Procesando petición para generar reporte...");
		LOGGER.info(PREFIJO_LOG+"Valores: "+formulario.toString());
		try
		{
//			validator.validate(formulario,result);
			if( result.hasErrors())
			{
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
				respuesta.setErrores(true);
				respuesta.setCodigoRespuesta("9999");
				respuesta.setMensajesError(errores);
				return respuesta;
			}else
			{
//				formulario.setRfcOferente(formulario.getRfcOferente().trim());
//				LOGGER.info("valor del rfc: "+formulario.getRfcOferente());
//				if( formulario.getRfcOferente().trim().length()==12){
//					formulario.setRfcOferente(" "+formulario.getRfcOferente());
//				}
				LOGGER.info(PREFIJO_LOG+"Formulario sin errores, obteniendo reporte");
				List<ReporteInexUvOferenteDomain> reporte = service.generarReporteInexUvOferente((formulario.getEstado().trim().equals("-1")?"":formulario.getEstado())
																								,Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd")
																								,Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd")
																								,formulario.getPaquete()
																								,formulario.getRfcOferente());
				if( reporte!=null && !reporte.isEmpty())
				{
					respuesta.setCodigoRespuesta("0000");
					respuesta.setDescripcionRespuesta("Reporte generado, exitosamente");
					respuesta.setListado(reporte);
					LOGGER.debug(PREFIJO_LOG+"Resultados ofe: "+Arrays.asList(reporte).toString());
				}else
				{
					respuesta.setCodigoRespuesta("0003");
					respuesta.setDescripcionRespuesta("No se encontraron registros");
					respuesta.setListado(new ArrayList<ReporteInexUvOferenteDomain>());
				}
			}
		}catch (BusinessException e) {
			LOGGER.error(PREFIJO_LOG+e.getDescripcion(),e.getError());
			respuesta.setCodigoRespuesta("9000");
			respuesta.setDescripcionRespuesta(e.getMessage());
			
		}catch (Exception e) {
			LOGGER.error(PREFIJO_LOG+"Error al procesar petición de generación de reporte",e);
			respuesta.setCodigoRespuesta("9001");
			respuesta.setDescripcionRespuesta("Error en la cosnulta de la información de la bitacora de Ro");
		}
	 return respuesta;
	}
	
	
	@RequestMapping(value="test.json",method=RequestMethod.GET)
	public @ResponseBody RespuestaJsonReporteInexUvOferente validacion()
	{
		RespuestaJsonReporteInexUvOferente r = new RespuestaJsonReporteInexUvOferente();
		r.setCodigoRespuesta("0001");
		r.setDescripcionRespuesta("descripcion");
		return r;
	}
	
	
	
	
	

}
