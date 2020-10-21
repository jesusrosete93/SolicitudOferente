package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ReporteAvaluosCerradosForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ReporteAvaluosCerradosValidator")
public class ReporteAvaluosCerradosValidator implements Validator {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteAvaluosCerradosValidator.class);

	@Override
	public boolean supports(Class<?> parametro) {
		// TODO Auto-generated method stub
		return ReporteAvaluosCerradosForm.class.isAssignableFrom(parametro);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		ReporteAvaluosCerradosForm forma = (ReporteAvaluosCerradosForm)object;
		LOGGER.info("[RAC] - Validando forma..., F["+forma+"]");
		if( forma.getTipoReporte()==1)
		{
			LOGGER.info("[RAC] - Reporte de avaluos cerrados");
			if( forma.getTipoComparativa()==1)
			{
				if( Integer.parseInt(forma.getAnioInicio())>Integer.parseInt(forma.getAnioFin()))
				{
					errors.rejectValue("errores","error.campo.fechas.rango", new Object[]{forma.getAnioInicio(),forma.getAnioFin()},"");
				}
			}else if(forma.getTipoComparativa()==4)
			  {
				LOGGER.info("[RAC] - Reporte de avaluos cerrados - comparativa por hora");
				if( forma.getFechaHora()==null ||  forma.getFechaHora().trim().equals("") )
				{
					errors.rejectValue("errores","error.campo.vacio", new Object[]{"Fecha"},"");
				}else
				{
					if( !forma.getFechaHora().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores", "error.campo.formato", new Object[]{"Fecha","yyyy-mm-dd"},"");
					}
				}
			  }
			
		}else if( forma.getTipoReporte()==2)
		{
			if( forma.getIdEstado()==-1)
			{
				errors.rejectValue("errores","error.campo.vacio", new Object[]{"Estado"},"");
			}else
			{
				LOGGER.info("[RAC] - Reporte de avaluos cerrados por estado");
				if( forma.getTipoComparativa()==1)
				{
					if( Integer.parseInt(forma.getAnioInicio())>Integer.parseInt(forma.getAnioFin()))
					{
						errors.rejectValue("errores","error.campo.fechas.rango", new Object[]{forma.getAnioInicio(),forma.getAnioFin()},"");
					}
				}else if(forma.getTipoComparativa()==4)
				  {
					LOGGER.info("[RAC] - Reporte de avaluos cerrados - comparativa por hora");
					if( forma.getFechaHora()==null ||  forma.getFechaHora().trim().equals("") )
					{
						errors.rejectValue("errores","error.campo.vacio", new Object[]{"Fecha"},"");
					}else
					{
						if( !forma.getFechaHora().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
						{
							errors.rejectValue("errores", "error.campo.formato", new Object[]{"Fecha","yyyy-mm-dd"},"");
						}
					}
				  }
			}
		}else if( forma.getTipoReporte()==3)
		{
			LOGGER.info("[RACV] - Reporte de avaluos cerrados por unidad");
			if( forma.getIdUnidadValudacion()==-1)
			{
				errors.rejectValue("errores","error.campo.vacio", new Object[]{"Unidad valuación"},"");
			}else
			{
				if( forma.getTipoComparativa()==1)
				{
					if( Integer.parseInt(forma.getAnioInicio())>Integer.parseInt(forma.getAnioFin()))
					{
						errors.rejectValue("errores","error.campo.fechas.rango", new Object[]{forma.getAnioInicio(),forma.getAnioFin()},"");
					}
				}else if(forma.getTipoComparativa()==4)
				  {
					LOGGER.info("[RAC] - Reporte de avaluos cerrados - comparativa por hora");
					if( forma.getFechaHora()==null ||  forma.getFechaHora().trim().equals("") )
					{
						errors.rejectValue("errores","error.campo.vacio", new Object[]{"Fecha"},"");
					}else
					{
						if( !forma.getFechaHora().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
						{
							errors.rejectValue("errores", "error.campo.formato", new Object[]{"Fecha","yyyy-mm-dd"},"");
						}
					}
				  }
			}
		}

		
		
	}
	
	

}
