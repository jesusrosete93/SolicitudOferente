package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaReasignacionInexForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaReasignacionInexCamposValidator")
public class ConsultaReasignacionInexCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaReasignacionInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaReasignacionInexForm forma = (ConsultaReasignacionInexForm)arg0;
		
		if( (forma.getCamposReasignacion()==null || forma.getCamposReasignacion().isEmpty()) && ( forma.getCamposPaquete()==null || forma.getCamposPaquete().isEmpty())  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar al menos un dato"},"");
		}
	}

}
