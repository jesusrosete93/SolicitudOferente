/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.validators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluoSubValuadoForm;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Encapsula las validaciones realziadas para 
 * la forma: {@link ConsultaAvaluoSubValuadoForm}
 * @author Adrian Casas Avansis Desarrollos SA de CV
 *
 */
@Component("ConsultaAvaluoSubValuadoValidator")
public class ConsultaAvaluoSubValuadoValidator implements Validator {
	
	private static Logger LOGGER = LogManager.getLogger(ConsultaAsignacionesCamposValidator.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaAvaluoSubValuadoForm.class.isAssignableFrom(arg0);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object arg0, Errors errors) {
		ConsultaAvaluoSubValuadoForm forma = (ConsultaAvaluoSubValuadoForm)arg0;
		
		if(   forma.getIdPaquete().trim().equals("") && forma.getIdVivienda()==0
		   && forma.getIdUnidadValuacion()==0 && forma.getIdAvaluo().trim().equals("")
		   && forma.getBandera()==0 && forma.getCodigoPostal().trim().equals("")
		   && forma.getFechaCierreInicio().trim().equals("") && forma.getFechaCierreFin().trim().equals("")
		  )
		{
			errors.rejectValue("errores","error.consultas.parametros.vacios");
		}else
		{
			if( !forma.getIdAvaluo().trim().equals("") && !forma.getIdAvaluo().trim().matches("[0-9]{17}") )
			{
				errors.rejectValue("idAvaluo","error.campo.formato",new Object[]{"Avalúo","Solo números"},"");
			}
			if(  !forma.getIdPaquete().trim().equals("")  && !forma.getIdPaquete().trim().matches("[0-9]{16}") && !forma.getIdPaquete().trim().matches("^paquete-mai-[0-9]*")
			    )
			  {
				  errors.rejectValue("idPaquete","error.campo.formato",new Object[]{"Paquete","Solo números o paquete-mai-9171"},""); 
			  }
			
			if( !String.valueOf(forma.getIdVivienda()).matches("\\d") ) 
			{
				 errors.rejectValue("idVivienda","error.campo.formato", new Object[]{"Vivienda","Solo numeros"},"");
			}
			
			if( !forma.getCodigoPostal().trim().equals("") && !forma.getCodigoPostal().matches("[0-9]{5}"))
			{
				errors.rejectValue("codigoPostal","error.campo.formato", new Object[]{"Codigo postal","Solo numeros"},"");
			}
			
			if(   (forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals(""))
			   || (!forma.getFechaCierreInicio().trim().equals("") && forma.getFechaCierreFin().trim().equals(""))		
			  )
			  {
				errors.rejectValue("fechaCierreInicio","error.campos.valor.rango.vacios", new Object[]{"Fecha cierre"},"");
  			  }else if ( !forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals("")
  					     && (!forma.getFechaCierreInicio().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") || !forma.getFechaCierreFin().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")))
  			  {
  				errors.rejectValue("fechaCierreInicio","error.campo.formato", new Object[]{"Fecha cierre"},"AAAA-MM-DD ((A)Año,(M)Mes,(D)Día)");
  			  }else if ( !forma.getFechaCierreInicio().trim().equals("") && !forma.getFechaCierreFin().trim().equals("")
					     && (forma.getFechaCierreInicio().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") && forma.getFechaCierreFin().trim().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")))
  			  {
  				SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
  				try
  				{
  					Date fechaCierreInicio = SDF.parse(forma.getFechaCierreInicio());
  					Date fechaCierreFin    = SDF.parse(forma.getFechaCierreFin());
  					
  					if(fechaCierreFin.before(fechaCierreInicio) )
  					{
  						errors.rejectValue("fechaCierreInicio","error.campo.fechas.rango", new Object[]{"Fecha cierre",forma.getFechaCierreInicio(),forma.getFechaCierreFin()},"");
  						
  					}
  					
  				}catch(Exception ex)
  				{
  					LOGGER.error("[CASV] - Error al parsear las fechas FCI["+forma.getFechaCierreInicio()+"] y FCF:["+forma.getFechaCierreFin()+"]");
  					errors.rejectValue("fechaCierreInicio","error.campo.formato", new Object[]{"Fecha cierre"},"AAAA-MM-DD ((A)Año,(M)Mes,(D)Día)");
  				}
  			  }
		}
	}
	
	
	public static void main(String args[])
	{
		List<Object> parameters = new ArrayList<Object>();
		
		parameters.add("paquete");
		parameters.add(new Integer(1));
		parameters.add(new Boolean(true));
		
				
		Object[] p = parameters.toArray(new Object[]{parameters.size()});
		
		for(int s =0; s<p.length;s++)
		{
			System.out.println(p[s].getClass());
		}
		
		
//		ConsultaAvaluoSubValuadoForm forma = new ConsultaAvaluoSubValuadoForm();
//		
//		forma.setIdAvaluo("");
//		forma.setIdPaquete("0502712200306514");
//		forma.setIdVivienda(1);
//		forma.setBandera(0);
//		forma.setIdUnidadValuacion(0);
//		forma.setCodigoPostal("");
//		forma.setFechaCierreInicio("");
//		forma.setFechaCierreFin("");
//		
//		System.out.println("Matchea: "+forma.getIdPaquete().matches("^paquete-mai-[0-9]*"));
//		
//		DataBinder dataBinder = new DataBinder(forma);
//		
//		dataBinder.setValidator(new ConsultaAvaluoSubValuadoValidator());
//		dataBinder.validate();
//		
//		if( dataBinder.getBindingResult().hasErrors())
//		{
//			System.out.println("Hay errores en la forma");
//			ResourceBundleMessageSource rmb = new ResourceBundleMessageSource();
//			rmb.setBasename("D://wsBodoke//ReporteUVs//WebContent//WEB-INF//config//resources//messages");
//			rmb.setUseCodeAsDefaultMessage(true);
//			
//			 
//			
//			 for(ObjectError oe : dataBinder.getBindingResult().getAllErrors()  )
//			 {
//				 System.out.println(oe.getCode());
//				 if( oe.getArguments()!=null)
//				 {
//					 for(int s=0;s<oe.getArguments().length;s++ )
//					 {
//						 System.out.println("Argumentos: "+oe.getArguments()[s].toString());
//					 }
//				 }
//			 }
//		}else
//		{
//			System.out.println("No hay errores en la forma");
//		}
	}

}
