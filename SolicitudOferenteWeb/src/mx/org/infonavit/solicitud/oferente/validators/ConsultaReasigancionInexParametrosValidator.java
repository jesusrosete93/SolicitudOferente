package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaReasignacionInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaReasigancionInexParametrosValidator")
public class ConsultaReasigancionInexParametrosValidator implements Validator {
	
	private static final String EXPRESION_REGULAR_PAQUETE ="[0-9]{16}";
	private static final String EXPRESION_REGULAR_RFC ="[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}";
    

	@Override
	public boolean supports(Class<?> arg0) {
		return ConsultaReasignacionInexForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaReasignacionInexForm forma = (ConsultaReasignacionInexForm)arg0;
		
		if(   forma.getPaquete().trim().equals("") && forma.getRfcOferente().trim().equals("") 
		   && forma.getEstado()==-1 
		   && forma.getFechaReasignacionInicio().trim().equals("") && forma.getFechaReasignacionInicio().trim().equals("")
		   && forma.getFechaReasignacionFin().trim().equals("") && forma.getFechaReasignacionFin().trim().equals("")
		   && forma.getIdUnidadNueva()==-1 && forma.getIdUnidadAnterior()==-1 && forma.getTipoPaquete()==-1
		  )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else
		{
			//Validaciones de la fecha de reasignación - - - -
			if( !forma.getFechaReasignacionInicio().trim().equals("") && !forma.getFechaReasignacionFin().trim().equals("") )
			{
				if( !forma.getFechaReasignacionInicio().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha reasignación Del","DD-MM-YYYY"},"");
				}else
				{
					if( !forma.getFechaReasignacionFin().matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha reasignación Al","DD-MM-YYYY"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD( Fechas.cambiarFormatoFecha(forma.getFechaReasignacionFin(),"dd-MM-yyyy","yyyy-MM-dd") )
								.before(Fechas.getDate_YYYYMMDD(Fechas.cambiarFormatoFecha(forma.getFechaReasignacionInicio(),"dd-MM-yyyy","yyyy-MM-dd"))) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaReasignacionInicio(),"Fecha reasignación",forma.getFechaReasignacionFin()},"");
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
