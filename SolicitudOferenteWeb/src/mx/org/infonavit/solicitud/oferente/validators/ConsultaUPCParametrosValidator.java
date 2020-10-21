package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaUPCForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaUPCParametrosValidator")
public class ConsultaUPCParametrosValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaUPCForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		ConsultaUPCForm forma = (ConsultaUPCForm)arg0;
		
		if( (forma.getUnidadValuacionForm().getClaveUnidadValuacion()==0 || String.valueOf(forma.getUnidadValuacionForm().getClaveUnidadValuacion()).trim().equals("")) 
			 && ( forma.getUnidadValuacionForm().getNombreUnidadValuacion()==null || forma.getUnidadValuacionForm().getNombreUnidadValuacion().isEmpty() ) &&
			forma.getUnidadValuacionForm().getEstatusUnidadValuacion()<0 && forma.getUnidadValuacionForm().getFechaVigenciaInicio().trim().equals("") &&
			forma.getUnidadValuacionForm().getFechaVigenciaFin().trim().equals("") && forma.getUnidadValuacionForm().getClaveSHF().trim().equals("") &&
			forma.getUnidadValuacionForm().getSiglas().trim().equals("") && forma.getUnidadValuacionForm().getUnidadViviendaRecuperada()<0 &&
			(forma.getCoberturaForm().getEstados()==null || forma.getCoberturaForm().getEstados().isEmpty()) && forma.getCoberturaForm().getEstatus()<0 &&
			forma.getControladorForm().getClaveSHF().trim().equals("") && 
			(forma.getControladorForm().getApellidoPaterno().trim().equals("") || forma.getControladorForm().getApellidoPaterno().trim().equals("PATERNO")) &&
			(forma.getControladorForm().getApellidoMaterno().trim().equals("") || forma.getControladorForm().getApellidoMaterno().trim().equals("MATERNO")) && 
			(forma.getControladorForm().getNombre().trim().equals("") || forma.getControladorForm().getNombre().trim().equals("NOMBRE"))&&
			forma.getControladorForm().getCurp().trim().equals("") && forma.getControladorForm().getRfc().trim().equals("") &&
			forma.getControladorForm().getFechaVigenciaInicio().trim().equals("") && forma.getControladorForm().getFechaVigenciaFin().trim().equals("") &&
			forma.getControladorForm().getEstatusControlador()<0 &&	forma.getPeritoForm().getClaveSHF().trim().equals("") && 
			(forma.getPeritoForm().getApellidoPaterno().equals("") || forma.getPeritoForm().getApellidoPaterno().trim().equals("PATERNO"))&&
			(forma.getPeritoForm().getApellidoMaterno().trim().equals("") || forma.getPeritoForm().getApellidoMaterno().trim().equals("MATERNO")) && 
			(forma.getPeritoForm().getNombre().trim().equals("") || forma.getPeritoForm().getNombre().trim().equals("NOMBRE")) &&
			forma.getPeritoForm().getCurp().trim().equals("") && forma.getPeritoForm().getRfc().trim().equals("") &&
			forma.getPeritoForm().getFechaVigenciaInicio().trim().equals("") && forma.getPeritoForm().getFechaVigenciaFin().trim().equals("") &&
			forma.getPeritoForm().getEstatusPerito()<0
			)
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else if(forma.getUnidadValuacionForm().getFechaVigenciaInicio().trim().equals("") && !forma.getUnidadValuacionForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha Vigencia UV"},"");
		}else if(!forma.getUnidadValuacionForm().getFechaVigenciaInicio().trim().equals("") && forma.getUnidadValuacionForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha Vigencia UV"},"");
		}else if(forma.getControladorForm().getFechaVigenciaInicio().trim().equals("") && !forma.getControladorForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha vigencia controlador"},"");
		}else if(!forma.getControladorForm().getFechaVigenciaInicio().trim().equals("") && forma.getControladorForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha vigencia controlador"},"");
		}else if(forma.getPeritoForm().getFechaVigenciaInicio().trim().equals("") && !forma.getPeritoForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha vigencia perito"},"");
		}else if(!forma.getPeritoForm().getFechaVigenciaInicio().trim().equals("") && forma.getPeritoForm().getFechaVigenciaFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha vigencia perito"},"");
		}else
		{
			if( forma.getUnidadValuacionForm().getClaveUnidadValuacion()!=0)
			{
				if( !String.valueOf(forma.getUnidadValuacionForm().getClaveUnidadValuacion()).matches("[0-9]{4}"))
				{
					errors.rejectValue("errores","error.campo.numerico.longitud",new Object[]{"Clave unidad","4"},"");
				}
			}
			if( !forma.getUnidadValuacionForm().getFechaVigenciaInicio().trim().equals("") && !forma.getUnidadValuacionForm().getFechaVigenciaFin().trim().equals("") )
			{
				if( !forma.getUnidadValuacionForm().getFechaVigenciaInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia UV del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getUnidadValuacionForm().getFechaVigenciaFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia UV al","YYYY-MM-DD"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD(forma.getUnidadValuacionForm().getFechaVigenciaFin()).before(Fechas.getDate_YYYYMMDD(forma.getUnidadValuacionForm().getFechaVigenciaInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getUnidadValuacionForm().getFechaVigenciaInicio(),"Fecha vigencia UV",forma.getUnidadValuacionForm().getFechaVigenciaFin()},"");
							
						}
					}
				}
			}
			if( !forma.getControladorForm().getFechaVigenciaInicio().trim().equals("") && !forma.getControladorForm().getFechaVigenciaFin().trim().equals("") )
			{
				if( !forma.getControladorForm().getFechaVigenciaInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia controlador del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getControladorForm().getFechaVigenciaFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia controlador al","YYYY-MM-DD"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD(forma.getControladorForm().getFechaVigenciaFin()).before(Fechas.getDate_YYYYMMDD(forma.getControladorForm().getFechaVigenciaInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getControladorForm().getFechaVigenciaInicio(),"Fecha vigencia controlador",forma.getControladorForm().getFechaVigenciaFin()},"");
							
						}
					}
				}
			}
			
			if( !forma.getControladorForm().getApellidoPaterno().trim().equals("") || !forma.getControladorForm().getApellidoPaterno().trim().equals("PATERNO"))
			{
				if(!forma.getControladorForm().getApellidoPaterno().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Paterno - Controlador"},"");
				}
			}
			if( !forma.getControladorForm().getApellidoMaterno().trim().equals("") || !forma.getControladorForm().getApellidoMaterno().trim().equals("MATERNO"))
			{
				if(!forma.getControladorForm().getApellidoMaterno().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Materno - Controlador"},"");
				}
			}
			if( !forma.getControladorForm().getNombre().trim().equals("") || !forma.getControladorForm().getNombre().trim().equals("NOMBRE"))
			{
				if(!forma.getControladorForm().getNombre().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Nombre - Controlador"},"");
				}
			}
			
			if( !forma.getPeritoForm().getFechaVigenciaInicio().trim().equals("") && !forma.getPeritoForm().getFechaVigenciaFin().trim().equals("") )
			{
				if( !forma.getPeritoForm().getFechaVigenciaInicio().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
				{
					errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia perito del","YYYY-MM-DD"},"");
				}else
				{
					if( !forma.getPeritoForm().getFechaVigenciaFin().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"El campo: Fecha vigencia perito al","YYYY-MM-DD"},"");
					}else
					{
						if ( Fechas.getDate_YYYYMMDD(forma.getPeritoForm().getFechaVigenciaFin()).before(Fechas.getDate_YYYYMMDD(forma.getPeritoForm().getFechaVigenciaInicio())) )
						{
							errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getPeritoForm().getFechaVigenciaInicio(),"Fecha vigencia controlador",forma.getPeritoForm().getFechaVigenciaFin()},"");
							
						}
					}
				}
			}
			if( !forma.getControladorForm().getCurp().trim().equals("") )
			{
				if( forma.getControladorForm().getCurp().trim().length()!=18)
				{
					errors.rejectValue("errores","error.campo.longitud",new Object[]{"Curp controlador","18"},"");
				}else
				{
					if( !forma.getControladorForm().getCurp().trim().matches("[A-Z0-9]{18}") )
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"Curp controlador","Letras y números"},"");	
					}
				}
			}
			if( !forma.getControladorForm().getRfc().trim().equals(""))
			{
				if(!forma.getControladorForm().getRfc().matches("[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}"))	
				{
					  errors.rejectValue("errores","error.campo.formato",new Object[]{"Rfc controlador","ABCD123245AC4 ó ABC12345AZ9"},"");
				}
			}
			
			
			
			
			
			if( !forma.getPeritoForm().getCurp().trim().equals("") )
			{
				if( forma.getPeritoForm().getCurp().trim().length()!=18)
				{
					errors.rejectValue("errores","error.campo.longitud",new Object[]{"Curp perito","18"},"");
				}else
				{
					if( !forma.getPeritoForm().getCurp().trim().matches("[A-Z0-9]{18}") )
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"Curp perito","Letras y números"},"");	
					}
				}
			}
			if( !forma.getPeritoForm().getRfc().trim().equals(""))
			{
				if(!forma.getPeritoForm().getRfc().matches("[A-Z]{3,4}[0-9]{6}[A-Z0-9]{3}"))	
				{
					  errors.rejectValue("errores","error.campo.formato",new Object[]{"Rfc perito","ABCD123245AC4 ó ABC12345AZ9"},"");
				}
			}
			
			if( !forma.getPeritoForm().getApellidoPaterno().trim().equals("") || !forma.getPeritoForm().getApellidoPaterno().trim().equals("PATERNO"))
			{
				if(!forma.getPeritoForm().getApellidoPaterno().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Paterno - Controlador"},"");
				}
			}
			if( !forma.getPeritoForm().getApellidoMaterno().trim().equals("") || !forma.getPeritoForm().getApellidoMaterno().trim().equals("MATERNO"))
			{
				if(!forma.getPeritoForm().getApellidoMaterno().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Materno - Controlador"},"");
				}
			}
			if( !forma.getPeritoForm().getNombre().trim().equals("") || !forma.getPeritoForm().getNombre().trim().equals("NOMBRE"))
			{
				if(!forma.getPeritoForm().getNombre().matches("[A-Z]+"))
				{
					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Nombre - Controlador"},"");
				}
			}
			
			
		}
	}
	

}
