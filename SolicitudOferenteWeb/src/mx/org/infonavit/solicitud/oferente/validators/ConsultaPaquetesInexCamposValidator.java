package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.PaquetesForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaPaquetesInexCamposValidator")
public class ConsultaPaquetesInexCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return PaquetesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		PaquetesForm forma = (PaquetesForm)arg0;
		
		if( forma.getCamposPaquetes()==null || forma.getCamposPaquetes().isEmpty()  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar al menos un dato"},"");
		}
	}

}
