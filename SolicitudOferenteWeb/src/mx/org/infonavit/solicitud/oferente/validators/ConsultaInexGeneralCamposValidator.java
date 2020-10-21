package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaInexForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaInexGeneralCamposValidator")
public class ConsultaInexGeneralCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaInexForm forma = (ConsultaInexForm)arg0;
		
		if( forma.getCamposInexGeneral()==null || forma.getCamposInexGeneral().isEmpty()  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar al menos un dato"},"");
		}
	}

}
