package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.StoreProcedureForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("StoreProcedureFormValidator")
public class StoreProcedureFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return StoreProcedureForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		StoreProcedureForm forma = (StoreProcedureForm)object;
		if( forma.getFechaInicio().trim().equals("") && forma.getFechaFin().trim().equals(""))
		{
			
			errors.rejectValue("errores","error.consultas.parametros.vacios");
		}else
		{
			if( !forma.getFechaInicio().trim().equals("") && !forma.getFechaFin().trim().equals("") )
			{
				if( !forma.getFechaInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha inicio","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha fin","YYYY-MM-DD"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD(forma.getFechaFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaInicio(),"Fecha vigencia UV",forma.getFechaFin()},"");
							
						}
					}
				}
			}
		}
		
		
		
	}

}


