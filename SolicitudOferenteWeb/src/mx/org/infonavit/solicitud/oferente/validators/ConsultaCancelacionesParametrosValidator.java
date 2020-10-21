package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionesForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaCancelacionesParametrosValidator")
public class ConsultaCancelacionesParametrosValidator implements Validator {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaCancelacionesParametrosValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaCancelacionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsultaCancelacionesForm forma = (ConsultaCancelacionesForm)object;
		LOGGER.info("[CCPV] - Validando formulario...");
		LOGGER.info("[CCPV] - F["+forma+"]");
		
		if( forma.getClaveUnidadValuacion().trim().equals("") &&
			forma.getNombreUnidadValuacion().trim().equals("-1") &&
		    forma.getIdAvaluo().trim().equals("") && forma.getIdConviviencia().trim().equals("")
		 && forma.getPaquete().trim().equals("") && forma.getViviendaInicio()==0 && forma.getViviendaFin()==0
		 && forma.getFechaCancelacionInicio().equals("") && forma.getFechaCancelacionFin().trim().equals("")
		 && forma.getFechaSolicitudInicio().trim().equals("") && forma.getFechaSolicitudFin().trim().equals("")
		 && forma.getFechaCierreInicio().trim().equals("") && forma.getFechaCierreFin().trim().equals("")
		 && forma.getValorConcluidoInicio().trim().equals("") && forma.getValorConcluidoFin().trim().equals("")
		 && forma.getEstatusAvaluo()==0)
		{
			errors.rejectValue("errores","error.consultas.parametros.vacios");
		}else if( !forma.getFechaCancelacionInicio().trim().equals("") && forma.getFechaCancelacionFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha cancelación"},"");
		}else if( forma.getFechaCancelacionInicio().trim().equals("") && !forma.getFechaCancelacionFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha cancelación"},"");
		}else if( !forma.getFechaCierreInicio().trim().equals("") && forma.getFechaCierreFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha cierre"},"");
		}else if( forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha cierre"},"");
		}else if( !forma.getFechaSolicitudInicio().trim().equals("") && forma.getFechaSolicitudFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
		}else if( forma.getFechaSolicitudInicio().trim().equals("") && !forma.getFechaSolicitudFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
		}else if( !forma.getValorConcluidoInicio().trim().equals("") && forma.getValorConcluidoFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Valor concluido"},"");
		}else if( forma.getValorConcluidoInicio().trim().equals("") && !forma.getValorConcluidoFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Valor concluido"},"");
		}else
		{
			if( !forma.getClaveUnidadValuacion().trim().equals(""))
			{
				if( !forma.getClaveUnidadValuacion().matches("[0-9]{4}"))
				{
					errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Clave unidad valuación"},"");
				}
			}
			
			
			if(!forma.getIdAvaluo().trim().equals(""))
			{
				if(forma.getIdAvaluo().trim().length()!=17)
				{
					errors.rejectValue("errores","error.campo.longitud",new Object[]{"Id avalúo","17"},"");
				}else
				{
					if( !forma.getIdAvaluo().trim().matches("[0-9]{17}"))
					{
						errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Id avalúo"},"");
					}
						
				}
			}
			if(!forma.getIdConviviencia().trim().equals(""))
			{
				if(forma.getIdConviviencia().trim().length()!=10)
				{
					errors.rejectValue("errores","error.campo.longitud",new Object[]{"Id conviviencia","10"},"");
				}else
				{
					if( !forma.getIdConviviencia().trim().matches("[0-9]{10}"))
					{
						errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Id conviviencia"},"");
					}
				}
			}
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
			
			if( !forma.getFechaCancelacionInicio().trim().equals("") && !forma.getFechaCancelacionFin().trim().equals("") )
			{
				if( !forma.getFechaCancelacionInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha cancelación Del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaCancelacionFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha cancelación Al","YYYY-MM-DD"},"");
					}else
					{
						if( Fechas.getDate_YYYYMMDD(forma.getFechaCancelacionFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaCancelacionInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaCancelacionInicio(),"Fecha cierre",forma.getFechaCancelacionFin()},"");
						}
					}
				}
			}
			
			
			if( !forma.getFechaSolicitudInicio().trim().equals("") && !forma.getFechaSolicitudFin().trim().equals("") )
			{
				if( !forma.getFechaSolicitudInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha solicitud Del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaSolicitudFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha solicitud Al","YYYY-MM-DD"},"");
					}else
					{
						if( Fechas.getDate_YYYYMMDD(forma.getFechaSolicitudFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaSolicitudInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaSolicitudInicio(),"Fecha cierre",forma.getFechaSolicitudFin()},"");
						}
					}
				}
				
				
				
				
			}
			
			if( !forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals("") )
			{
				if( !forma.getFechaCierreInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha cierre Del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getFechaCierreFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha cierre Del","YYYY-MM-DD"},"");
					}else
					{
						if( Fechas.getDate_YYYYMMDD(forma.getFechaCierreFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaCierreInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getFechaCierreInicio(),"Fecha cierre",forma.getFechaCancelacionFin()},"");
						}

					}
				}
			}
			
			
			
			if( !forma.getValorConcluidoInicio().trim().equals("") && !forma.getValorConcluidoFin().trim().equals("") )
			{
				if( Double.parseDouble(forma.getValorConcluidoFin()) > Double.parseDouble(forma.getValorConcluidoInicio()) ) 
				{
					errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorConcluidoFin(),"Valor concluido:",forma.getValorConcluidoInicio()},"");
				}
			}
		}
	}

}
