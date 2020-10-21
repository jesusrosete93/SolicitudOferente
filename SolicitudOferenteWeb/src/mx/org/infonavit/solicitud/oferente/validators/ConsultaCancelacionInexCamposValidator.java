package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionInexForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaCancelacionInexCamposValidator")
public class ConsultaCancelacionInexCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaCancelacionInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaCancelacionInexForm forma = (ConsultaCancelacionInexForm)arg0;
		
		if( (forma.getCamposCancelacion()==null || forma.getCamposCancelacion().isEmpty()) && ( forma.getCamposPaquete()==null || forma.getCamposPaquete().isEmpty())  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar al menos un dato"},"");
		}
	}

}
