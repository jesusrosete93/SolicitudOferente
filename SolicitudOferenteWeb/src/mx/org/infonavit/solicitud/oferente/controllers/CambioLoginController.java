package mx.org.infonavit.solicitud.oferente.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.UsuarioBusiness;
import mx.org.infonavit.solicitud.oferente.forms.CambioLoginForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/cambioContrasenia.htm")
public class CambioLoginController {
	
	private static Logger LOGGER = LogManager.getLogger(CambioLoginController.class);
	
	@Autowired
	@Qualifier("CambioLoginValidator")
	private Validator validator;
	
	@Autowired
	@Qualifier("serviceUsuario")
	private UsuarioBusiness serviceUsuario;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request,@RequestParam("idUsuario")String idUsuario)
	{
		LOGGER.info("[CLC] - Inicializando forma para cambio de login...");
		CambioLoginForm forma = getForm();
		forma.setIdUsuario(idUsuario);
		model.addAttribute("cambioLoginForm",forma);
		LOGGER.info("[CLC] - Redireccionando para cambio de contraseña");
		return "initViewCambioContrasenia";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="cambioLoginForm") CambioLoginForm forma
						     ,BindingResult result,ModelMap model
						     ,HttpServletRequest request
							 ,HttpServletResponse response){
		LOGGER.info("[CLC] - Procesando petición para cambio de contraseña...");
		String regreso="";
		validator.validate(forma,result);
		
		if( result.hasErrors()){
			LOGGER.info("[CLC] - Forma con errores.");
			LOGGER.info("[CLC] - Peticion de cambio de contraseña, procesada");
		    regreso = "initViewCambioContrasenia";	
		}else{
			LOGGER.info("[CLC] - Forma sin errores");
			LOGGER.info("[CLC] - Cambiando contraseña...");
			int respuesta = serviceUsuario.cambiarContrasenia(forma.getIdUsuario(),forma.getContraseniaActual(),forma.getContraseniaNueva());
			
			if(respuesta==1){
					LOGGER.info("[CLC] - Exito en el cambio de contraseña.");
					request.getSession().setAttribute("usuario",serviceUsuario.getUsuario());
				    regreso = "viewLoginSuccess";
				    model.addAttribute("mensaje",serviceUsuario.getDetalleOperacion());
			
			}else{
					LOGGER.info("[CLC] - Error en el cambio de contraseña.");
					regreso="initViewCambioContrasenia";
					result.rejectValue("errores","error.general.mensaje", new Object[]{serviceUsuario.getDetalleOperacion()},"");
			}
		} 
		LOGGER.info("[CLC] - Peticion de cambio de contraseña, procesada");
		return regreso;
	}
	
	
	
	@ModelAttribute("cambioLoginForm")
	public CambioLoginForm getForm(){
		CambioLoginForm formulario = new CambioLoginForm();
		return formulario;
	}
	 

}
