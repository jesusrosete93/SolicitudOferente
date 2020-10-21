package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaUPCForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaUPCCamposValidator")
public class ConsultaUPCCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaUPCForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaUPCForm forma = (ConsultaUPCForm)arg0;
		
		if( forma.getUnidadValuacionForm().getCamposUnidadValuacion()==null &&
		    forma.getCoberturaForm().getCamposCobertura()==null && 
		    forma.getControladorForm().getCamposControlador()==null &&
		    forma.getPeritoForm().getCamposPerito()==null )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar datos"},"");
		}
	}

}
