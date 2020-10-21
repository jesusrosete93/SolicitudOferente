package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaInexForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaInexGeneralParametrosValidator")
public class ConsultaInexGeneralParametrosValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaInexForm forma = (ConsultaInexForm)arg0;
		
		if( forma.getNumeroInex()==-1 && forma.getFecha().trim().equals("") && (forma.getIdUnidadValuacion()==-1 || forma.getIdUnidadValuacion()==0) && forma.getIdEstado()==-1 )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else
		{
			if( forma.getFecha()!=null && !forma.getFecha().trim().equals("") && !forma.getFecha().trim().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
			{
				errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha","YYYY-MM-DD"},"");
			}
		}
	}
}
