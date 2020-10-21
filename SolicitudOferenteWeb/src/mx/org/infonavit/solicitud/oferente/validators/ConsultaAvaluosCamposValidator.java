package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaUPCForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaAvaluosCamposValidator")
public class ConsultaAvaluosCamposValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaUPCForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaAvaluosForm forma = (ConsultaAvaluosForm)arg0;
		
		if( forma.getUnidadValuacion().getCamposUnidadValuacion()==null &&
		    forma.getVivienda().getCamposVivienda() == null &&
		    forma.getAvaluo().getCamposAvaluos() == null &&
		    forma.getDetalleAvaluo().getCamposDetalleAvaluo() == null &&
		    forma.getControlador().getCamposControlador()==null &&
		    forma.getPerito().getCamposPerito()==null )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar datos"},"");
		}
	}

}
