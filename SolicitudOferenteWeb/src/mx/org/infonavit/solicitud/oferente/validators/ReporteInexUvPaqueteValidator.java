package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ReporteInexUvPaqueteForm;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ReporteInexUvPaqueteValidator")
public class ReporteInexUvPaqueteValidator implements Validator {
	
//	private static final String EXPRESION_REGULAR_FECHA ="\\d{2}-\\d{2}-\\d{4}";
	private static final String EXPRESION_REGULAR_PAQUETE ="\\d{16}";
	

	@Override
	public boolean supports(Class<?> arg0) {
		return ReporteInexUvPaqueteForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object objeto, Errors errores) {
		ReporteInexUvPaqueteForm forma = (ReporteInexUvPaqueteForm)objeto;
		if( forma.getPaquete().trim().equals("")  )
			{
				errores.rejectValue("errores", "error.consultas.parametros.vacios");
			}else
			{
				if( !forma.getPaquete().trim().equals("") && !forma.getPaquete().trim().matches(EXPRESION_REGULAR_PAQUETE))
				{
					errores.rejectValue("errores","error.campo.numerico.longitud",new Object[]{"Paquete","16"},"");
				}
//				if(  (forma.getFechaSolicitudInicio()!=null && forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
//				    	  &&
//				    	  (forma.getFechaSolicitudFin()==null || forma.getFechaSolicitudFin().trim().equals("") || !forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
//				      )
//					{
//						errores.rejectValue("errores","error.campos.valor.rango.vacios.formato",new Object[]{"Rango fecha solicitud A:","DD-MM-YYYY"},"");
//					}else if( (forma.getFechaSolicitudInicio()==null || forma.getFechaSolicitudInicio().trim().equals("") || !forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
//					    	    &&
//				    		  (forma.getFechaSolicitudFin()!=null && forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
//							) 
//					{
//					    errores.rejectValue("errores","error.campos.valor.rango.vacios.formato",new Object[]{"Fecha solicitud De:","DD-MM-YYYY"},"");
//					}else if( (forma.getFechaSolicitudInicio()!=null && forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
//				    	    &&
//				    		  (forma.getFechaSolicitudFin()!=null && forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
//							
//							)
//					{
//						if ( FechaUtils.getDate_YYYYMMDD(FechaUtils.cambiarFormatoFecha(forma.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd"))
//								       .before(FechaUtils.getDate_YYYYMMDD(FechaUtils.cambiarFormatoFecha(forma.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd")))
//						   )
//						{
//							errores.rejectValue("errores","error.campo.fechas.rango",new Object[]{"Fecha solicitud",forma.getFechaSolicitudInicio(),forma.getFechaSolicitudFin()},"");
//						}
//					}
			}

	}

}
