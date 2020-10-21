package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaSancionesForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaSancionesCamposValidator")
public class ConsultaSancionesCamposValidator implements Validator {
	private static final Logger LOGGER = LogManager.getLogger(ConsultaCancelacionesParametrosValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaSancionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsultaSancionesForm forma = (ConsultaSancionesForm)object;
		LOGGER.info("[CCCV] - Validando formulario..");
		LOGGER.info("[CCCV] - F["+forma+"]");
		if( forma.getUnidad().getCamposUnidadValuacion()==null &&
		    forma.getCobertura().getCamposCobertura()==null && 
		    forma.getControlador().getCamposControlador()==null &&
		    forma.getPerito().getCamposPerito()==null &&
		    forma.getSancion().getCamposSancion()==null)
			{
				errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar datos a mostrar"},"");
			}
	}

}
