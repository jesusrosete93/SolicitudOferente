package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.AvaluoMAIBusiness;
import mx.org.infonavit.solicitud.oferente.business.BitacoraAvaluoMapBusiness;
import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.PeticionBusiness;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.ResumenEnvioAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.forms.EnvioAvaluoForm;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteDeclinacionForm;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteForm;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoFotosAvaluo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonSolicitudCancelacionOferente;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistroSolicitudDeclinacionOferenteController {
	
	private static final Logger LOGGER = LogManager.getLogger(RegistroSolicitudDeclinacionOferenteController.class);
	private static final String PREFIJO_MENSAJE = "[EAC] - ";
	
//	@Autowired
//	@Qualifier("EnvioAvaluoValidator")
//	private Validator validator;
//	
	@Autowired
	@Qualifier("SolicitudOferenteCancelacionBusiness")
	private SolicitudOferenteService <SolicitudOferenteDomain> service;
	


	@RequestMapping(value="initSolicitudDeclinacionOferente.htm",method=RequestMethod.GET)
	public String inicializarSolicitudDeclinacionOferente(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		SolicitudOferenteDeclinacionForm forma = new SolicitudOferenteDeclinacionForm();
		LOGGER.info(PREFIJO_MENSAJE+"Inicializando vista para solicitud de oferente...");
		model.addAttribute("estados",Estado.CATALOGO_ESTADOS);
		model.addAttribute("solicitudDeclinacion", forma);
		
		return "viewSolicitudOferenteDeclinacion";
	}


	@RequestMapping(value="/insertarSolicitudDeclinacion.json",method=RequestMethod.POST)
	public @ResponseBody RespuestaJsonSolicitudCancelacionOferente procesarPeticionRegistroCanclacionOferente(@ModelAttribute("solicitudDeclinacion")SolicitudOferenteDeclinacionForm formulario,BindingResult result) throws BusinessException
	
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
