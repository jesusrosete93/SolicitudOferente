package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaSancionesForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaSancionesParametrosValidator")
public class ConsultaSancionesParametrosValidator implements Validator {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaSancionesParametrosValidator.class);

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaSancionesForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsultaSancionesForm forma = (ConsultaSancionesForm)object;
		LOGGER.info("[CSPV] - Validando formulario...");
		LOGGER.info("[CSPV] - F["+forma+"]");
		
		if( forma.getUnidad().getClaveUnidadValuacion()==0 && forma.getUnidad().getNombreUnidadValuacion().equals("-1") &&
			forma.getUnidad().getClaveSHF().trim().equals("") && forma.getUnidad().getSiglas().trim().equals("") &&
			forma.getCobertura().getEstados().isEmpty() &&  
			forma.getControlador().getClaveSHF().trim().equals("") &&
			forma.getControlador().getApellidoPaterno().trim().equals("PATERNO") &&
			forma.getControlador().getApellidoMaterno().trim().equals("MATERNO") &&
			forma.getControlador().getNombre().trim().equals("NOMBRE") &&
			forma.getPerito().getClaveSHF().trim().equals("") &&
			forma.getPerito().getApellidoPaterno().trim().equals("PATERNO") &&
			forma.getPerito().getApellidoMaterno().trim().equals("MATERNO") && 
			forma.getPerito().getNombre().trim().equals("NOMBRE") &&
			forma.getSancion().getFechaSancionInicio().trim().equals("") && forma.getSancion().getFechaSancionFin().trim().equals("") && 
			forma.getSancion().getTipoSancion() ==-1 && forma.getSancion().getSancionado()==-1 && forma.getSancion().getEstatusSancion()==-1
			)
		{
			errors.rejectValue("errores","error.consultas.parametros.vacios");
		}else if( !forma.getSancion().getFechaSancionInicio().trim().equals("") && forma.getSancion().getFechaSancionFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha sanción"},"");
		}else if( forma.getSancion().getFechaSancionInicio().trim().equals("") && !forma.getSancion().getFechaSancionFin().trim().equals(""))
		{
			errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha sanción"},"");
		}else
		{
			
		}
	}

}
