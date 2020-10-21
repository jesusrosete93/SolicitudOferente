package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.PaquetesForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaPaquetesInexParametrosValidator")
public class ConsultaPaquetesInexParametrosValidator implements Validator {
	
	private static final String EXPRESION_REGULAR_PAQUETE ="[0-9]{16}";
	private static final String EXPRESION_REGULAR_RFC ="[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}";
    

	@Override
	public boolean supports(Class<?> arg0) {
		return PaquetesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		PaquetesForm forma = (PaquetesForm)arg0;
		
		if(   forma.getIdUnidadValuacion()==-1 && forma.getRfcOferente().trim().equals("") 
		   && forma.getIdEstado()==-1 && forma.getPaquete().trim().equals("") 
		   && forma.getTipoPaquete()==-1
		  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else
		{
			if( !forma.getRfcOferente().trim().equals("") && !forma.getRfcOferente().trim().matches(EXPRESION_REGULAR_RFC) )
			{
				errors.rejectValue("errores","error.campo.formato",new Object[]{"Rfc oferente","AAAA123456AA ó AAA123456A1"},"");
			}
			if( !forma.getPaquete().trim().equals("") && !forma.getPaquete().trim().matches(EXPRESION_REGULAR_PAQUETE))
			{
				errors.rejectValue("errores","error.campo.formato",new Object[]{"Paquete","123456789012345"},"");
			}
		}
	}
}
