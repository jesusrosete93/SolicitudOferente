package mx.org.infonavit.solicitud.oferente.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.org.infonavit.solicitud.oferente.forms.LoginForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("LoginValidator")
public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		LoginForm forma = (LoginForm)object;
		boolean vacio = false;
		
		Pattern pattern = Pattern.compile("\\W");
		
		
		if( forma.getUser().trim().equals("") && forma.getPassword().trim().equals("")){
			errors.rejectValue("errores","error.campos.vacios",new Object[]{"Usuario y Constraseña"},"");
			vacio=true;
		}else if(forma.getUser().trim().equals("") && !forma.getPassword().trim().equals("")){
			errors.rejectValue("user","error.campo.vacio",new Object[]{"Usuario"},"");
			vacio=true;
		}else if(!forma.getUser().trim().equals("") && forma.getPassword().trim().equals("")){
			errors.rejectValue("password","error.campo.vacio",new Object[]{"Constraseña"},"");
			vacio=true;
		}	
		
		
		if( !vacio ){
			
			if( forma.getUser().trim().length()<8){
				errors.rejectValue("user","error.campo.longitud", new Object[]{"Usuario","8"}, "");
			}else if( forma.getPassword().trim().length() < 8 ){
				errors.rejectValue("password","error.campo.longitud.rango", new Object[]{"Contraseña","8"}, "");
			}else if( pattern.matcher(forma.getUser()).find() ){
				errors.rejectValue("user","error.campo.numero.letra", new Object[]{"Usuario"}, "");
			}else if( pattern.matcher(forma.getPassword()).find() ){
				errors.rejectValue("user","error.campo.numero.letra", new Object[]{"Contraseña"}, "");
			}
			
			
			
			
			
			
		}
	}
	
	
	public static void main(String args[]){
		Pattern pattern = Pattern.compile("\\W");
		
		
		Matcher userMatch = pattern.matcher("IECALA01");
		Matcher passMatch = pattern.matcher("Prueba01");
		
		System.out.println("VAlor match user: " + userMatch.find());
		System.out.println("VAlor match pass: " + passMatch.find());
		
		
	}
	
	

}
