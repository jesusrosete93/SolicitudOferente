package mx.org.infonavit.solicitud.oferente.validators;


import java.util.regex.Pattern;

import mx.org.infonavit.solicitud.oferente.forms.CambioLoginForm;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("CambioLoginValidator")
public class CambioLoginValidator implements Validator{
	
	private static final Logger LOGGER = LogManager.getLogger(Validator.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return CambioLoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		CambioLoginForm forma = (CambioLoginForm)object;
		LOGGER.info("[CLV] - Validando forma para cambio de login...");
		boolean vacio = false;
		
		Pattern pattern = Pattern.compile("\\W");
		
		if( forma.getContraseniaActual().trim().equals("") || forma.getContraseniaNueva().trim().equals("") || forma.getContraseniaConfirma().trim().equals("")){
			errors.rejectValue("errores","error.campos.vacios",new Object[]{"Contraseña anterior, Constraseña nueva y Confirma contraseña"},"");
			vacio=true;
		}
		if( !vacio ){
			
			if( forma.getContraseniaActual().trim().length() < 8 || forma.getContraseniaNueva().trim().length() < 8 || forma.getContraseniaConfirma().trim().length() < 8 ){
				errors.rejectValue("errores","error.campos.longitud",new Object[]{"Contraseña anterior, Constraseña nueva y Confirma contraseña","8"}, "");
			}else if(!forma.getContraseniaNueva().trim().equals(forma.getContraseniaConfirma())){
			    errors.rejectValue("errores", "login.usuario.error", new Object[]{"Contrase&ntilde;a nueva y Confirmar contrase&ntilde;a"},"");	
			}else if( pattern.matcher(forma.getContraseniaActual()).find() ){
				errors.rejectValue("errores","error.campo.numero.letra", new Object[]{"Contraseña anterior"}, "");
			}else if( pattern.matcher(forma.getContraseniaNueva()).find() ){
				errors.rejectValue("errores","error.campo.numero.letra", new Object[]{"Constraseña nueva"}, "");
			}else if( pattern.matcher(forma.getContraseniaConfirma()).find() ){
				errors.rejectValue("errores","error.campo.numero.letra", new Object[]{"Confirma contraseña"}, "");
			}
		}
		LOGGER.info("[CLV] - Finaliza la validación de forma para cambio de login");
	}
	
	
	
	
	

}
