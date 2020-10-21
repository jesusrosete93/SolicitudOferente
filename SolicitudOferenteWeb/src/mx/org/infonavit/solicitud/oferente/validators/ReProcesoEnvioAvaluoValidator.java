package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ReProcesoAvaluoForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ReProcesoEnvioAvaluoValidator")
public class ReProcesoEnvioAvaluoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ReProcesoAvaluoForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ReProcesoAvaluoForm forma = (ReProcesoAvaluoForm)object;
		

	    if(forma.getFechaEnvioInicio().trim().equals("") && !forma.getFechaEnvioFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha envío"},"");
		}else if(!forma.getFechaEnvioInicio().trim().equals("") && forma.getFechaEnvioFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha envío"},"");
		}else if( !forma.getFechaEnvioInicio().trim().equals("") && !forma.getFechaEnvioFin().trim().equals("") )
		{
			if( !forma.getFechaEnvioInicio().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
			{
				errors.rejectValue("errores","error.campo.formato",new Object[]{"Fecha envío Del","YYYY-MM-DD"},"");
			}else
			{
				if( !forma.getFechaEnvioFin().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"Fecha envío Al","YYYY-MM-DD"},"");
				}else
				{
					if ( Fechas.getDate_YYYYMMDD(forma.getFechaEnvioFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaEnvioInicio())) )
					{
						errors.rejectValue("errores","error.campo.fechas.rango",new Object[]{"Cierre Del: "+forma.getFechaEnvioInicio(),"Cierre Al:"+forma.getFechaEnvioFin()},"");
					}
				}
			}
		}
	}
}
