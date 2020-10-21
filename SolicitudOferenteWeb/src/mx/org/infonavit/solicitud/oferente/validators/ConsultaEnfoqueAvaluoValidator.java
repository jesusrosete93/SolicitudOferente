package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaEnfoqueForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaEnfoqueAvaluoValidator")
public class ConsultaEnfoqueAvaluoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaEnfoqueForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ConsultaEnfoqueForm forma = (ConsultaEnfoqueForm)object;
		
		if(    (forma.getPaquete()==null || forma.getPaquete().trim().equals("")) 
		    && (forma.getIdAvaluo()==null || forma.getIdAvaluo().trim().equals(""))
		    && ((forma.getFechaCierreInicio()==null || forma.getFechaCierreInicio().trim().equals("")) && (forma.getFechaCierreFin()==null || forma.getFechaCierreFin().trim().equals("")))
		    && (forma.getNombreUnidadValuacion()==null || forma.getNombreUnidadValuacion().isEmpty())
		    && (forma.getMetodo()==-1)
		    && (forma.getEdad()==0)
		    && (forma.getConservacion()==-1)
		    && ((forma.getValorOfertaMinimo()==null || forma.getValorOfertaMinimo().trim().equals("")) && (forma.getValorOfertaMaximo()==null || forma.getValorOfertaMaximo().trim().equals("")))
		    && ((forma.getSuperficieTerrenoMinimo()==null || forma.getSuperficieTerrenoMinimo().trim().equals("")) && (forma.getSuperficieTerrenoMaximo()==null || forma.getSuperficieTerrenoMinimo().trim().equals("")))
		    && ((forma.getSuperficieConstruccionMinimo()==null || forma.getSuperficieConstruccionMinimo().trim().equals("")) && (forma.getSuperficieConstruccionMaximo()==null || forma.getSuperficieConstruccionMaximo().trim().equals("")))
		    && ((forma.getValorUnitarioMinimo()==null || forma.getValorUnitarioMinimo().trim().equals("")) && (forma.getValorUnitarioMaximo()==null || forma.getValorUnitarioMaximo().trim().equals("")))
		    && ((forma.getValorMinimoFic()==null || forma.getValorMinimoFic().trim().equals("")) && (forma.getValorMaximoFic()==null || forma.getValorMaximoFic().trim().equals("")))
		    && ((forma.getValorMinimoZona()==null || forma.getValorMinimoZona().trim().equals("")) && (forma.getValorMaximoZona()==null || forma.getValorMaximoZona().trim().equals("")))
		    && ((forma.getValorMinimoUbicacion()==null || forma.getValorMinimoUbicacion().trim().equals("")) && (forma.getValorMaximoUbicacion()==null || forma.getValorMaximoUbicacion().trim().equals("")))
		    && ((forma.getValorMinimoSuperficie()==null || forma.getValorMinimoSuperficie().trim().equals("")) && (forma.getValorMaximoSuperficie()==null || forma.getValorMaximoSuperficie().trim().equals("")))
		    && ((forma.getValorMinimoEdadFactor()==null || forma.getValorMinimoEdadFactor().trim().equals("")) && (forma.getValorMaximoEdadFactor()==null || forma.getValorMaximoEdadFactor().trim().equals("")))
		    && ((forma.getValorMinimoConservacionFactor()==null || forma.getValorMinimoConservacionFactor().trim().equals("")) && (forma.getValorMaximoConservacionFactor()==null || forma.getValorMaximoConservacionFactor().trim().equals("")))
		    && ((forma.getValorMinimoOtros()==null || forma.getValorMinimoOtros().trim().equals("")) && (forma.getValorMaximoOtros()==null || forma.getValorMaximoOtros().trim().equals("")))
		    && ((forma.getValorMinimoResultante()==null || forma.getValorMinimoResultante().trim().equals("")) && (forma.getValorMaximoResultante()==null || forma.getValorMaximoResultante().trim().equals("")))
		  )
		{
			errors.rejectValue("errores","error.consultas.parametros.vacios");
		}else
		{
			if( ((forma.getFechaCierreInicio()!=null && !forma.getFechaCierreInicio().trim().equals("") ) && (forma.getFechaCierreFin()==null || forma.getFechaCierreFin().trim().equals("")))
					|| ((forma.getFechaCierreInicio()==null || forma.getFechaCierreInicio().trim().equals("") ) && (forma.getFechaCierreFin()!=null && !forma.getFechaCierreFin().trim().equals("")))	)
			{
				errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Fecha cierre"},"");
			}else if(forma.getFechaCierreInicio()!=null && !forma.getFechaCierreInicio().trim().equals("")  && forma.getFechaCierreFin()!=null && !forma.getFechaCierreFin().trim().equals("")  )
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
				
				if( ((forma.getValorOfertaMinimo()!=null && !forma.getValorOfertaMinimo().trim().equals("") ) && (forma.getValorOfertaMaximo()==null || forma.getValorOfertaMaximo().trim().equals("")))
					|| ((forma.getValorOfertaMinimo()==null || forma.getValorOfertaMinimo().trim().equals("") ) && (forma.getValorOfertaMaximo()!=null && !forma.getValorOfertaMaximo().trim().equals(""))) )
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Valor oferta"},"");
				}else{
					  if( ((forma.getValorOfertaMinimo()!=null && !forma.getValorOfertaMinimo().trim().equals("") ) && (forma.getValorOfertaMaximo()!=null && !forma.getValorOfertaMaximo().trim().equals(""))) )
					  {
						  if( Double.parseDouble(forma.getValorOfertaMinimo())>Double.parseDouble(forma.getValorOfertaMaximo())   )
						  {
							  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorOfertaMinimo(),"Valor oferta",forma.getValorOfertaMaximo()},"");
						  }
					  }
				}
				
				if( ((forma.getSuperficieTerrenoMinimo()!=null && !forma.getSuperficieTerrenoMinimo().trim().equals("") ) && (forma.getSuperficieTerrenoMaximo()==null || forma.getSuperficieTerrenoMaximo().trim().equals("")))
					|| ((forma.getSuperficieTerrenoMinimo()==null || forma.getSuperficieTerrenoMinimo().trim().equals("") ) && (forma.getSuperficieTerrenoMaximo()!=null && !forma.getSuperficieTerrenoMaximo().trim().equals(""))))
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Superficie terreno"},"");
				}else
				{
					 if( ((forma.getSuperficieTerrenoMinimo()!=null && !forma.getSuperficieTerrenoMinimo().trim().equals("") ) && (forma.getSuperficieTerrenoMaximo()!=null && !forma.getSuperficieTerrenoMaximo().trim().equals(""))) )
					  {
						  if( Double.parseDouble(forma.getSuperficieTerrenoMinimo())>Double.parseDouble(forma.getSuperficieTerrenoMaximo())   )
						  {
							  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getSuperficieTerrenoMinimo(),"Superficie terreno",forma.getSuperficieTerrenoMaximo()},"");
						  }
					  }
				}
				
				if( ((forma.getSuperficieConstruccionMinimo()!=null && !forma.getSuperficieConstruccionMinimo().trim().equals("") ) && (forma.getSuperficieConstruccionMaximo()==null || forma.getSuperficieConstruccionMaximo().trim().equals("")))
				   || ((forma.getSuperficieConstruccionMinimo()==null || forma.getSuperficieConstruccionMinimo().trim().equals("") ) && (forma.getSuperficieConstruccionMaximo()!=null && !forma.getSuperficieConstruccionMaximo().trim().equals(""))) )
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Superficie construcción"},"");
				}else
				{
					if( ((forma.getSuperficieConstruccionMinimo()!=null && !forma.getSuperficieConstruccionMinimo().trim().equals("") ) && (forma.getSuperficieConstruccionMaximo()!=null && !forma.getSuperficieConstruccionMaximo().trim().equals(""))) )
					  {
						  if( Double.parseDouble(forma.getSuperficieConstruccionMinimo())>Double.parseDouble(forma.getSuperficieConstruccionMaximo())   )
						  {
							  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getSuperficieConstruccionMinimo(),"Superficie construcción",forma.getSuperficieConstruccionMaximo()},"");
						  }
					  }
				}
				
				if( ((forma.getValorUnitarioMinimo()!=null && !forma.getValorUnitarioMinimo().trim().equals("") ) && (forma.getValorUnitarioMaximo()==null || forma.getValorUnitarioMaximo().trim().equals("")))
					|| ((forma.getValorUnitarioMinimo()==null || forma.getValorUnitarioMinimo().trim().equals("") ) && (forma.getValorUnitarioMaximo()!=null && !forma.getValorUnitarioMaximo().trim().equals("")))  )
				{
					errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Valor unitario"},"");
				}else
				{
					if( ((forma.getValorUnitarioMinimo()!=null && !forma.getValorUnitarioMinimo().trim().equals("") ) && (forma.getValorUnitarioMaximo()!=null && !forma.getValorUnitarioMaximo().trim().equals(""))) )
					  {
						  if( Double.parseDouble(forma.getValorUnitarioMinimo())>Double.parseDouble(forma.getValorUnitarioMaximo())   )
						  {
							  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorUnitarioMinimo(),"Valor unitario",forma.getValorUnitarioMaximo()},"");
						  }
					  }
				}
				
				if( ((forma.getValorMinimoFic()!=null && !forma.getValorMinimoFic().trim().equals("") ) && (forma.getValorMaximoFic()==null || forma.getValorMaximoFic().trim().equals("")))
						|| ((forma.getValorMinimoFic()==null || forma.getValorMinimoFic().trim().equals("") ) && (forma.getValorMaximoFic()!=null && !forma.getValorMaximoFic().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"FIC"},"");
					}else
					{
						if( ((forma.getValorMinimoFic()!=null && !forma.getValorMinimoFic().trim().equals("") ) && (forma.getValorMaximoFic()!=null && !forma.getValorMaximoFic().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoFic())>Double.parseDouble(forma.getValorMaximoFic())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoFic(),"Valor unitario",forma.getValorMaximoFic()},"");
							  }
						  }
					}
				
				
				
				if( ((forma.getValorMinimoZona()!=null && !forma.getValorMinimoZona().trim().equals("") ) && (forma.getValorMaximoZona()==null || forma.getValorMaximoZona().trim().equals("")))
						|| ((forma.getValorMinimoZona()==null || forma.getValorMinimoZona().trim().equals("") ) && (forma.getValorMaximoZona()!=null && !forma.getValorMaximoZona().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Zona"},"");
					}else
					{
						if( ((forma.getValorMinimoZona()!=null && !forma.getValorMinimoZona().trim().equals("") ) && (forma.getValorMaximoZona()!=null && !forma.getValorMaximoZona().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoZona())>Double.parseDouble(forma.getValorMaximoZona())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoZona(),"Zona",forma.getValorMaximoZona()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoUbicacion()!=null && !forma.getValorMinimoUbicacion().trim().equals("") ) && (forma.getValorMaximoUbicacion()==null || forma.getValorMaximoUbicacion().trim().equals("")))
						|| ((forma.getValorMinimoUbicacion()==null || forma.getValorMinimoUbicacion().trim().equals("") ) && (forma.getValorMaximoUbicacion()!=null && !forma.getValorMaximoUbicacion().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Ubicación"},"");
					}else
					{
						if( ((forma.getValorMinimoUbicacion()!=null && !forma.getValorMinimoUbicacion().trim().equals("") ) && (forma.getValorMaximoUbicacion()!=null && !forma.getValorMaximoUbicacion().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoUbicacion())>Double.parseDouble(forma.getValorMaximoUbicacion())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoUbicacion(),"Ubicación",forma.getValorMaximoUbicacion()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoSuperficie()!=null && !forma.getValorMinimoSuperficie().trim().equals("") ) && (forma.getValorMaximoSuperficie()==null || forma.getValorMaximoSuperficie().trim().equals("")))
						|| ((forma.getValorMinimoSuperficie()==null || forma.getValorMinimoSuperficie().trim().equals("") ) && (forma.getValorMaximoSuperficie()!=null && !forma.getValorMaximoSuperficie().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Superficie"},"");
					}else
					{
						if( ((forma.getValorMinimoSuperficie()!=null && !forma.getValorMinimoSuperficie().trim().equals("") ) && (forma.getValorMaximoSuperficie()!=null && !forma.getValorMaximoSuperficie().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoSuperficie())>Double.parseDouble(forma.getValorMaximoSuperficie())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoSuperficie(),"Superficie",forma.getValorMaximoSuperficie()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoEdadFactor()!=null && !forma.getValorMinimoEdadFactor().trim().equals("") ) && (forma.getValorMaximoEdadFactor()==null || forma.getValorMaximoEdadFactor().trim().equals("")))
						|| ((forma.getValorMinimoEdadFactor()==null || forma.getValorMinimoEdadFactor().trim().equals("") ) && (forma.getValorMaximoEdadFactor()!=null && !forma.getValorMaximoEdadFactor().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Edad"},"");
					}else
					{
						if( ((forma.getValorMinimoEdadFactor()!=null && !forma.getValorMinimoEdadFactor().trim().equals("") ) && (forma.getValorMaximoEdadFactor()!=null && !forma.getValorMaximoEdadFactor().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoEdadFactor())>Double.parseDouble(forma.getValorMaximoEdadFactor())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoEdadFactor(),"Edad",forma.getValorMaximoEdadFactor()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoConservacionFactor()!=null && !forma.getValorMinimoConservacionFactor().trim().equals("") ) && (forma.getValorMaximoConservacionFactor()==null || forma.getValorMaximoConservacionFactor().trim().equals("")))
						|| ((forma.getValorMinimoConservacionFactor()==null || forma.getValorMinimoConservacionFactor().trim().equals("") ) && (forma.getValorMaximoConservacionFactor()!=null && !forma.getValorMaximoConservacionFactor().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Conservación"},"");
					}else
					{
						if( ((forma.getValorMinimoConservacionFactor()!=null && !forma.getValorMinimoConservacionFactor().trim().equals("") ) && (forma.getValorMaximoConservacionFactor()!=null && !forma.getValorMaximoConservacionFactor().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoConservacionFactor())>Double.parseDouble(forma.getValorMaximoEdadFactor())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoConservacionFactor(),"Conservación",forma.getValorMaximoConservacionFactor()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoOtros()!=null && !forma.getValorMinimoOtros().trim().equals("") ) && (forma.getValorMaximoOtros()==null || forma.getValorMaximoOtros().trim().equals("")))
						|| ((forma.getValorMinimoOtros()==null || forma.getValorMinimoOtros().trim().equals("") ) && (forma.getValorMaximoOtros()!=null && !forma.getValorMaximoOtros().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Otros"},"");
					}else
					{
						if( ((forma.getValorMinimoOtros()!=null && !forma.getValorMinimoOtros().trim().equals("") ) && (forma.getValorMaximoOtros()!=null && !forma.getValorMaximoOtros().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoOtros())>Double.parseDouble(forma.getValorMaximoOtros())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoOtros(),"Otros",forma.getValorMaximoOtros()},"");
							  }
						  }
					}
				
				if( ((forma.getValorMinimoResultante()!=null && !forma.getValorMinimoResultante().trim().equals("") ) && (forma.getValorMaximoResultante()==null || forma.getValorMaximoResultante().trim().equals("")))
						|| ((forma.getValorMinimoResultante()==null || forma.getValorMinimoResultante().trim().equals("") ) && (forma.getValorMaximoResultante()!=null && !forma.getValorMaximoResultante().trim().equals("")))  )
					{
						errors.rejectValue("errores","error.campos.valor.rango.vacios", new Object[]{"Resultante"},"");
					}else
					{
						if( ((forma.getValorMinimoResultante()!=null && !forma.getValorMinimoResultante().trim().equals("") ) && (forma.getValorMaximoResultante()!=null && !forma.getValorMaximoResultante().trim().equals(""))) )
						  {
							  if( Double.parseDouble(forma.getValorMinimoResultante())>Double.parseDouble(forma.getValorMaximoResultante())   )
							  {
								  errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getValorMinimoResultante(),"Resultante",forma.getValorMaximoResultante()},"");
							  }
						  }
					}
		}
		
		
		
	}

}
