package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAsignacionesForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaAsignacionesCamposValidator")
public class ConsultaAsignacionesCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaAsignacionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ConsultaAsignacionesForm forma = (ConsultaAsignacionesForm)object;
		
		
		if( forma.getCamposAsignaciones()==null || forma.getCamposAsignaciones().isEmpty())
		{
			errors.rejectValue("errores","error.consultas.campos.vacios");
		}
		
		
		
	}

}
