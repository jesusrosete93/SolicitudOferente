package mx.org.infonavit.solicitud.oferente.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.forms.LoginForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LoginController {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class.getName());
	
	@Autowired
	@Qualifier("LoginValidator")
	private Validator validator;

	
    @Autowired
    private AuthenticationSuccessHandler successHandler;
	
	
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		LOGGER.info("[LC] - Cargando forma para login...");
		model.addAttribute("forma",getForm());
		LOGGER.info("[LC] - Redireccionando para acceso al aplicativo");
		return "initViewLogin";
	}
	
	
	@RequestMapping(value="/loginFailed.htm",method=RequestMethod.GET)
	public String loginFailed(Model model){
		model.addAttribute("error","true");
		return "initViewLogin";
	}
	
	
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 		return "initViewLogin";
 	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="loginForm") LoginForm forma
						     ,BindingResult result,ModelMap model
						     ,HttpServletRequest request
							 ,HttpServletResponse response) throws IOException, ServletException{
		validator.validate(forma,result);
		LOGGER.info("[LC] - Procesando petición para login al aplicativo...");
		LOGGER.info("[LC] - Valores de la forma:"+forma.toString());
		
		
		
		if( result.hasErrors()){
			LOGGER.info("[LC] - Froma con errores");
		    return "initViewLogin";	
		}else{
			String ipHostRemoto = "";
			if (request != null) {
			       ipHostRemoto = request.getHeader("X-FORWARDED-FOR");
			         if (ipHostRemoto == null || "".equals(ipHostRemoto)) {
			                        ipHostRemoto = request.getRemoteAddr();
			                        LOGGER.info("[LC] - IP HOST REMOTO: " + ipHostRemoto);
			         }
			}
			
			LOGGER.info("[LC] - Froma sin errores, autenticando...");
			LOGGER.info("[LC] - Usuario:"+forma.getUser()+" ip host remoto:"+ipHostRemoto);
			Authentication token = new UsernamePasswordAuthenticationToken(forma.getUser(),forma.getPassword());
			try
			{
				Authentication authentication = authenticationManager.authenticate(token);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				successHandler.onAuthenticationSuccess(request,response,authentication);
				LOGGER.info("[LC] - Usuario:"+forma.getUser() +" - Autenticación exitosa...");
				return null;
			}catch(AuthenticationException authenticationException){
				LOGGER.info("[LC] - Usuario:"+forma.getUser() +" - Error en la autenticación");
				LOGGER.info("[LC] - Error en la autenticación",authenticationException);
				if( authenticationException.getMessage().trim().equals("CC")){
					LOGGER.info("[LC] - Redireccionando para cambio de ocntraseña...");
					return "redirect:cambioContrasenia.htm?idUsuario="+forma.getUser();
				}else{
					result.rejectValue("errores","error.general.mensaje",new Object[]{authenticationException.getMessage()},"");
					return "initViewLogin";	
				}
				
			}
			
		} 
		

	}
	
	
	
	@ModelAttribute("loginForm")
	public LoginForm getForm(){
		LoginForm formulario = new LoginForm();
		return formulario;
	}
	 

}
