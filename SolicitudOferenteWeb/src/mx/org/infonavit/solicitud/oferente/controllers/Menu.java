package mx.org.infonavit.solicitud.oferente.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Clase que atiende peticiones del 
 * menu del aplicativo.
 * @author Adrian Casas Avansis Desarrollos SA de CV
 *
 */
@Controller
public class Menu {
	
	@RequestMapping(value="/welcome.htm", method=RequestMethod.GET)
	public String initApp()
	{
		return "welcome";
	}
	
}
