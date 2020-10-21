package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaSolicitudesInexForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaSolicitudesInexCamposValidator")
public class ConsultaSolicitudesInexCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaSolicitudesInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaSolicitudesInexForm forma = (ConsultaSolicitudesInexForm)arg0;
		
		if( (forma.getCamposAvaluo()==null || forma.getCamposAvaluo().isEmpty()) && ( forma.getCamposPaquete()==null || forma.getCamposPaquete().isEmpty())  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar al menos un dato"},"");
		}
	}

}
