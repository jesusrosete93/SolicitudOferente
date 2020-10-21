package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ReporteECcoTecnologiaForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ReporteEcoTecnologiaValidator")
public class ReporteEcoTecnologiaValidator implements Validator {
	
	private static final String EXPRESION_REGULAR_FECHA ="\\d{2}-\\d{2}-\\d{4}";
	private static final String EXPRESION_REGULAR_PAQUETE ="\\D{8}";
	private static final String EXPRESION_REGULAR_RFC_OFERENTE = "[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}";
	
	

	@Override
	public boolean supports(Class<?> arg0) {
		return ReporteECcoTecnologiaForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object objeto, Errors errores) {
		ReporteECcoTecnologiaForm forma = (ReporteECcoTecnologiaForm)objeto;
		if(    forma.getCveEcoTecnologia().trim().equals("")
			&& forma.getDesarrollador().trim().equals("")
		    && forma.getFechaSolicitudInicio().trim().equals("")
		    && forma.getFechaSolicitudFin().trim().equals("")
		   )
			{
				errores.rejectValue("errores", "error.consultas.parametros.vacios");
				
			}else
			{
				
				if(forma.getCveEcoTecnologia() !=null && !forma.getCveEcoTecnologia().trim().equals("")
						  && (forma.getFechaSolicitudFin()==null || forma.getFechaSolicitudFin().trim().equals("") )		
						  )
						{
							errores.rejectValue("errores", "error.consultas.parametros.vacios.fechasEco");
						}else if( forma.getCveEcoTecnologia() ==null && forma.getCveEcoTecnologia().trim().equals("")   ){
							errores.rejectValue("errores", "error.consultas.parametros.vacios", new Object[]{forma.getCveEcoTecnologia()},"");
				         }
				
				if(forma.getDesarrollador() !=null && !forma.getDesarrollador().trim().equals("")
				  && (forma.getFechaSolicitudFin()==null || forma.getFechaSolicitudFin().trim().equals("") || !forma.getFechaSolicitudFin().matches(EXPRESION_REGULAR_FECHA))		
				  )
				{
					errores.rejectValue("errores", "error.consultas.parametros.vacios.fechasEco");
				}else if( forma.getDesarrollador() !=null && !forma.getDesarrollador().trim().equals("") && !forma.getDesarrollador().trim().matches(EXPRESION_REGULAR_RFC_OFERENTE) ){
					errores.rejectValue("errores", "error.rfc.formato", new Object[]{forma.getDesarrollador()},"");
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
