package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteExtraccionService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteExtraccionDomain;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteExtraccionForm;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonSolicitudCancelacionOferente;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonSolicitudExtraccionOferente;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistroSolicitudExtraccionOferenteController {
	
	private static final Logger LOGGER = LogManager.getLogger(RegistroSolicitudExtraccionOferenteController.class);
	private static final String PREFIJO_MENSAJE = "[EAC] - ";
	
//	@Autowired
//	@Qualifier("EnvioAvaluoValidator")
//	private Validator validator;
	
	@Autowired
	@Qualifier("SolicitudOferenteCancelacionBusiness")
	private SolicitudOferenteService <SolicitudOferenteDomain> service;
	
	
	
	
	@RequestMapping(value="initSolicitudExtraccionOferente.htm",method=RequestMethod.GET)
	public String inicializarSolicitudExtraccionOferente(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		SolicitudOferenteExtraccionForm forma = new SolicitudOferenteExtraccionForm();
		LOGGER.info(PREFIJO_MENSAJE+"Inicializando vista para solicitud de oferente...");
		
		model.addAttribute("estados",Estado.CATALOGO_ESTADOS);
		model.addAttribute("solicitudExtraccion", forma);
		
		return "viewSolicitudOferenteExtraccion";
	}
	@RequestMapping(value="/insertarSolicitudExtraccion.json",method=RequestMethod.POST)
	public @ResponseBody RespuestaJsonSolicitudCancelacionOferente procesarPeticionRegistroCanclacionOferente(@ModelAttribute("solicitudExtraccion")SolicitudOferenteExtraccionForm formulario,BindingResult result) throws BusinessException
	
	{
         LOGGER.info("Ingresa a insersion 2: "+formulario.getId_oferente());
		
		RespuestaJsonSolicitudCancelacionOferente respuesta = new RespuestaJsonSolicitudCancelacionOferente();
		
		
	
			SolicitudIDDomain reporte = service.registrarSolicitudCancelacionB(
						
					formulario.getId_solicitud(),
					formulario.getTipo_linea(),
					formulario.getFecha_solicitud(),
					formulario.getFecha_respuesta(),
					formulario.getId_estatus(),
					formulario.getId_tipo_solicitud(),
					formulario.getRfc_oferente(),
					formulario.getId_estado(),
					formulario.getId_oferente(),
					formulario.getNombre_razon_social(),
					formulario.getId_oferta_vivienda(),
					formulario.getId_orden_verificacion(),
					formulario.getNombre_frente(),
					formulario.getNum_viviendas(),
					formulario.getId_paquete(),
					formulario.getId_modificacion(),
					formulario.getNum_viviendas_declinacion_modificacion(),
					formulario.getComentarios(),
					formulario.getId_programa()	);
				
	
			if( reporte!=null )
			{
				respuesta.setCodigoRespuesta("0003");
				respuesta.setDescripcionRespuesta("TU ID_REGISTRO ES: " + reporte.getId_solicitud());
				
				
			
			}else
			{
				respuesta.setCodigoRespuesta("0003");
				respuesta.setDescripcionRespuesta("No se puedo hacer el registro de solicitud"+ reporte.getId_solicitud());
				
				
			}

				

			return respuesta;
							
							
	}
		}

			
