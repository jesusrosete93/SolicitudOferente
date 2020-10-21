package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaCancelacionInexParametrosValidator")
public class ConsultaCancelacionInexParametrosValidator implements Validator {
	
	private static final String EXPRESION_REGULAR_PAQUETE ="[0-9]{16}";
	private static final String EXPRESION_REGULAR_RFC ="[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}";
    

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaCancelacionInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaCancelacionInexForm forma = (ConsultaCancelacionInexForm)arg0;
		
		if(   forma.getPaquete().trim().equals("") && forma.getRfcOferente().trim().equals("") 
		   && forma.getEstado()==-1 
		   && forma.getFechaCancelacionInicio().trim().equals("") && forma.getFechaCancelacionFin().trim().equals("")
		   && forma.getFechaSolicitudInicio().trim().equals("") && forma.getFechaSolicitudFin().trim().equals("")
		   && forma.getTipoPaquete()==-1
		  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else
		{
			//Validaciones de la fecha de cancelación - - - -
			if( !forma.getFechaCancelacionInicio().trim().equals("") && !forma.getFechaCancelacionFin().trim().equals("") )
			{
				if( !forma.getFechaCancelacionInicio().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha solicitud Del","DD-MM-YYYY"},"");
				}else
				{
					if( !forma.getFechaCancelacionFin().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia UV Al","DD-MM-YYYY"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD( Fechas.cambiarFormatoFecha(forma.getFechaCancelacionFin(),"dd-MM-yyyy","yyyy-MM-dd") )
								.before(Fechas.getDate_YYYYMMDD(Fechas.cambiarFormatoFecha(forma.getFechaCancelacionInicio(),"dd-MM-yyyy","yyyy-MM-dd"))) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaCancelacionInicio(),"Fecha solicitud",forma.getFechaCancelacionFin()},"");
						}
					}
				}
			}
	
			//Validaciones para la fecha de solicitud - - - 
			if( !forma.getFechaSolicitudInicio().trim().equals("") && !forma.getFechaSolicitudFin().trim().equals("") )
			{
				if( !forma.getFechaSolicitudInicio().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha solicitud Del","DD-MM-YYYY"},"");
				}else
				{
					if( !forma.getFechaSolicitudFin().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia UV Al","DD-MM-YYYY"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD( Fechas.cambiarFormatoFecha(forma.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd") )
								.before(Fechas.getDate_YYYYMMDD(Fechas.cambiarFormatoFecha(forma.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd"))) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaSolicitudInicio(),"Fecha solicitud",forma.getFechaSolicitudFin()},"");
						}
					}
				}
			}
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
