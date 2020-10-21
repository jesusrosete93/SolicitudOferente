package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ReporteInexUvOferenteForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ReporteInexUvOferenteValidator")
public class ReporteInexUvOferenteValidator implements Validator {
	
	private static final String EXPRESION_REGULAR_FECHA ="\\d{2}-\\d{2}-\\d{4}";
	private static final String EXPRESION_REGULAR_PAQUETE ="\\d{16}";
	private static final String EXPRESION_REGULAR_RFC_OFERENTE = "[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}";
	
	

	@Override
	public boolean supports(Class<?> arg0) {
		return ReporteInexUvOferenteForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object objeto, Errors errores) {
		ReporteInexUvOferenteForm forma = (ReporteInexUvOferenteForm)objeto;
		if(    
				forma.getRfcOferente().trim().equals("")
			&& forma.getEstado().trim().equals("-1") 
		    && forma.getFechaSolicitudInicio().trim().equals("")
		    && forma.getFechaSolicitudFin().trim().equals("")
		    && forma.getPaquete().trim().equals("") 
		   )
			{
				errores.rejectValue("errores", "error.consultas.parametros.vacios");
			}else
			{
				if( !forma.getPaquete().trim().equals("") && !forma.getPaquete().trim().matches(EXPRESION_REGULAR_PAQUETE))
				{
					errores.rejectValue("errores","error.campo.numerico.longitud",new Object[]{"Paquete","16"},"");
				}
				if( forma.getRfcOferente() !=null && !forma.getRfcOferente().trim().equals("") && !forma.getRfcOferente().trim().matches(EXPRESION_REGULAR_RFC_OFERENTE) ){
					errores.rejectValue("rfc", "error.rfc.formato", new Object[]{forma.getRfcOferente()},"");
		         }
				if(  (forma.getFechaSolicitudInicio()!=null && forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
				    	  &&
				    	  (forma.getFechaSolicitudFin()==null || forma.getFechaSolicitudFin().trim().equals("") || !forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
				      )
					{
						errores.rejectValue("errores","error.campos.valor.rango.vacios.formato",new Object[]{"Rango fecha solicitud A:","DD-MM-YYYY"},"");
					}else if( (forma.getFechaSolicitudInicio()==null || forma.getFechaSolicitudInicio().trim().equals("") || !forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
					    	    &&
				    		  (forma.getFechaSolicitudFin()!=null && forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
							) 
					{
					    errores.rejectValue("errores","error.campos.valor.rango.vacios.formato",new Object[]{"Fecha solicitud De:","DD-MM-YYYY"},"");
					}else if( (forma.getFechaSolicitudInicio()!=null && forma.getFechaSolicitudInicio().matches(EXPRESION_REGULAR_FECHA))
				    	    &&
				    		  (forma.getFechaSolicitudFin()!=null && forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))
							
							)
					{
						if ( Fechas.getDate_YYYYMMDD(forma.getFechaSolicitudFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaSolicitudInicio())) )
						{
							errores.rejectValue("errores","error.campo.fechas.rango",new Object[]{"Fecha solicitud",forma.getFechaSolicitudInicio(),forma.getFechaSolicitudFin()},"");
						}
					}
			}

	}

}
