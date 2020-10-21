package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAsignacionesForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaAsignacionesParametrosValidator")
public class ConsultaAsignacionesParametrosValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaAsignacionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ConsultaAsignacionesForm forma = (ConsultaAsignacionesForm)object;
		
		
		if(    forma.getPaquete().trim().equals("") && forma.getClaveUnidadValuacion().trim().equals("-1")
			&& forma.getNombreFrente().trim().equals("") && forma.getRfcOferente().trim().equals("")
			&& forma.getFechaAsignacionInicio().trim().equals("") && forma.getFechaAsignacionFin().trim().equals("")
			&& forma.getClaveEstado()<0 && forma.getClaveUnidadValuacionAnterior().trim().equals("-1")
			&& forma.getFechaReasignacionInicio().trim().equals("") && forma.getFechaReasignacionFin().trim().equals("")
			&& forma.getTipoReasignacion()<0)
		{
			errors.reject("errores","error.consultas.parametros.vacios");
		}else if( !forma.getFechaAsignacionInicio().trim().equals("") && forma.getFechaAsignacionFin().trim().equals("") )
		{
			errors.rejectValue("errores", "error.campos.fechas.vacios",new Object[]{"Fecha asignación"},"");
		}else if( forma.getFechaAsignacionInicio().trim().equals("") && !forma.getFechaAsignacionFin().trim().equals("") )
		{
			errors.rejectValue("errores", "error.campos.fechas.vacios",new Object[]{"Fecha asignación"},"");
		}else if(forma.getFechaReasignacionInicio().trim().equals("") && !forma.getFechaReasignacionFin().trim().equals(""))
		{
			errors.rejectValue("errores", "error.campos.fechas.vacios",new Object[]{"Fecha Re asignación"},"");
		}else if(!forma.getFechaReasignacionInicio().trim().equals("") && forma.getFechaReasignacionFin().trim().equals(""))
		{
			errors.rejectValue("errores", "error.campos.fechas.vacios",new Object[]{"Fecha Re asignación"},"");
		}else
		{
			if(!forma.getPaquete().trim().equals(""))
			{
				if(forma.getPaquete().trim().length()!=16)
				{
					errors.rejectValue("errores","error.campo.longitud",new Object[]{"Paquete","16"},"");
				}else
				{
					if( !forma.getPaquete().trim().matches("[0-9]{16}"))
					{
						errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Paquete"},"");
					}
				}
			}
			
			if( !forma.getRfcOferente().trim().equals(""))
			{
				if( !forma.getRfcOferente().matches("[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"Rfc oferente","AAAA123456AA ó AAA123456A1"},"");
				}
			}
			
			if( !forma.getFechaAsignacionInicio().trim().equals("") && !forma.getFechaAsignacionFin().trim().equals("") )
			{
				if( !forma.getFechaAsignacionInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha asignación Del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaAsignacionFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha asignación Al","YYYY-MM-DD"},"");
					}else
					{
						if( Fechas.getDate_YYYYMMDD(forma.getFechaAsignacionFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaAsignacionInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaAsignacionFin(),"Fecha asignación",forma.getFechaAsignacionInicio()},"");
						}
					}
				}
				
				
			}

			

			
			if( !forma.getFechaReasignacionInicio().trim().equals("") && !forma.getFechaReasignacionFin().trim().equals("") )
			{
				if( !forma.getFechaReasignacionInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha re asignación Del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaReasignacionFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha re asignación Del","YYYY-MM-DD"},"");
					}else
					{
						if( Fechas.getDate_YYYYMMDD(forma.getFechaReasignacionFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaReasignacionInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaReasignacionFin(),"Fecha re asignación",forma.getFechaReasignacionInicio()},"");
						}

					}
				}
			}
		}
		
		
		
		
		
		
	}

}
