package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.EnvioAvaluoForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("EnvioAvaluoValidator")
public class EnvioAvaluoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return EnvioAvaluoForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		EnvioAvaluoForm forma = (EnvioAvaluoForm)object;
		
		if(    (forma.getFechaCierreInicio()==null || "".equals(forma.getFechaCierreInicio().trim()))
			&& (forma.getFechaCierreInicio()==null || "".equals(forma.getFechaCierreInicio().trim()))
		  )
		  {
			errors.rejectValue("errores","error.campos.vacios",new Object[]{"Fecha Cierre Del-Al"},"");
		  }else
		  {
			    if(forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals(""))
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha Cierre"},"");
				}else if(!forma.getFechaCierreInicio().trim().equals("") && forma.getFechaCierreFin().trim().equals(""))
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha Cierre"},"");
				}else if( !forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals("") )
				{

					if( !forma.getFechaCierreInicio().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
					{
						errors.rejectValue("errores","error.campo.formato",new Object[]{"Fecha Cierre Del","YYYY-MM-DD"},"");
					}else
					{
						if( !forma.getFechaCierreFin().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))
						{
							errors.rejectValue("errores","error.campo.formato",new Object[]{"Fecha Cierre Al","YYYY-MM-DD"},"");
						}else
						{
							if ( Fechas.getDate_YYYYMMDD(forma.getFechaCierreFin()).before(Fechas.getDate_YYYYMMDD(forma.getFechaCierreInicio())) )
							{
								errors.rejectValue("errores","error.campo.fechas.rango",new Object[]{"Cierre Del: "+forma.getFechaCierreInicio(),"Cierre Al:"+forma.getFechaCierreFin()},"");
							}
						}
					}
				}
		  }
	}
}
