package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionesForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaCancelacionesCamposValidator")
public class ConsultaCancelacionesCamposValidator implements Validator {
	private static final Logger LOGGER = LogManager.getLogger(ConsultaCancelacionesParametrosValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaCancelacionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsultaCancelacionesForm forma = (ConsultaCancelacionesForm)object;
		LOGGER.info("[CCCV] - Validando formuluario..");
		LOGGER.info("[CCCV] - F["+forma+"]");
		if( forma.getCamposCancelaciones()==null || forma.getCamposCancelaciones().isEmpty())
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de seleccionar los datos a mostrar"},"");
		}
	}

}
