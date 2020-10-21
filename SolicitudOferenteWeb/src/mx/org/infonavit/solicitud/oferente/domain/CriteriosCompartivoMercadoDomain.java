package mx.org.infonavit.solicitud.oferente.domain;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosCompartivoMercadoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6846998641985249683L;
	private String paquete;
	private String idAvaluo;
	private int idUv;
	private List<String> unidadesValuacion;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int metodo;
	private int edad;
	private int conservacion;
	private String valorOfertaMinimo;
	private String valorOfertaMaximo;
	private String superficieTerrenoMinimo;
	private String superficieTerrenoMaximo;
	private String superficieConstruccionMinimo;
	private String superficieConstruccionMaximo;
	private String valorUnitarioInicio;
	private String valorUnitarioMaximo;
	private String valorMinimoFic;
	private String valorMaximoFic;
	private String valorMinimoZona;
	private String valorMaximoZona;
	private String valorMinimoUbicacion;
	private String valorMaximoUbicacion;
	private String valorMinimoSuperficie;
	private String valorMaximoSuperficie;
	private String valorMinimoEdadFactor;
	private String valorMaximoEdadFactor;
	private String valorMinimoConservacionFactor;
	private String valorMaximoConservacionFactor;
	private String valorMinimoOtros;
	private String valorMaximoOtros;
	private String valorMinimoComercializacion;
	private String valorMaximoComercializacion;
	private String valorMinimoResultante;
	private String valorMaximoResultante;
	private boolean criteriosAvaluos;
	private boolean criteriosDetalleAvaluo;
	private boolean criteriosComparativos;
	
	
	
	public boolean validarCriterioIdAvaluo()
	{
		if(    (this.paquete==null && this.paquete.trim().equals(""))
			    && (this.idAvaluo!=null && !this.idAvaluo.trim().equals(""))
			    && (this.idUv==0)
			    && (   (this.fechaCierreInicio==null || this.fechaCierreInicio.trim().equals(""))
			    	&& (this.fechaCierreFin==null || this.fechaCierreFin.trim().equals("")) 
			        )
			    &&  (this.metodo==0)
			    &&  (this.edad==0)
			    &&  (this.conservacion==0)
			    &&  (   (this.valorOfertaMinimo==null || this.valorOfertaMinimo.trim().equals(""))
			    	 && (this.valorOfertaMaximo==null || this.valorOfertaMaximo.trim().equals("")) 
			         )	
			    &&  (   (this.superficieTerrenoMinimo==null || this.superficieTerrenoMinimo.trim().equals(""))
			    	 && (this.superficieTerrenoMaximo==null || this.superficieTerrenoMaximo.trim().equals("")) 
			         )
			    &&  (   (this.superficieConstruccionMinimo==null || this.superficieConstruccionMinimo.trim().equals(""))
			    	 && (this.superficieConstruccionMaximo==null || this.superficieConstruccionMaximo.trim().equals("")) 
			         )
			    && ( (this.valorMinimoFic==null || this.valorMinimoFic.trim().equals("")) && (this.valorMaximoFic==null || this.valorMaximoFic.trim().equals(""))  )
			    && ( (this.valorMinimoZona==null || this.valorMinimoZona.trim().equals("")) && (this.valorMaximoZona==null || this.valorMaximoZona.trim().equals("")) )
			    && ( (this.valorMinimoUbicacion==null || this.valorMinimoUbicacion.trim().equals("")) && (this.valorMaximoUbicacion==null || this.valorMaximoUbicacion.trim().equals("")) )
			    && ( (this.valorMinimoSuperficie==null || this.valorMinimoSuperficie.trim().equals("")) && (this.valorMinimoSuperficie==null || this.valorMinimoSuperficie.trim().equals("")) )
			    && ( (this.valorMinimoEdadFactor==null || this.valorMinimoEdadFactor.trim().equals("")) && (this.valorMaximoEdadFactor==null || this.valorMaximoEdadFactor.trim().equals("")) )  
			    && ( (this.valorMinimoConservacionFactor==null || this.valorMinimoConservacionFactor.trim().equals("")) && (this.valorMaximoConservacionFactor==null || this.valorMaximoConservacionFactor.trim().equals("")) )
			    && ( (this.valorMinimoOtros!=null || this.valorMinimoOtros.trim().equals("")) && (this.valorMaximoOtros!=null || this.valorMaximoOtros.trim().equals("")) )
			    && ( (this.valorMinimoComercializacion==null || !this.valorMinimoComercializacion.trim().equals("")) && (this.valorMaximoComercializacion==null || !this.valorMaximoComercializacion.trim().equals("")) ) 
			    && ( (this.valorMinimoResultante!=null || this.valorMinimoResultante.trim().equals("")) && (this.valorMaximoResultante!=null || this.valorMaximoResultante.trim().equals(""))  )
			    &&   (   (this.valorUnitarioInicio==null || this.valorUnitarioInicio.trim().equals(""))
		    	       && (this.valorUnitarioMaximo==null || this.valorUnitarioMaximo.trim().equals("")) 
		        )
				  )
			  {
			    return true;	
			  }else
			  {
				  return false;
			  }
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean validarCriteriosAvaluo()
	{
		if(    (this.paquete!=null && !this.paquete.trim().equals(""))
		    || (this.idAvaluo!=null && !this.idAvaluo.trim().equals(""))
		    || (this.unidadesValuacion!=null && !this.unidadesValuacion.isEmpty())
		    || (   (this.fechaCierreInicio!=null && !this.fechaCierreInicio.trim().equals(""))
		    	&& (this.fechaCierreFin!=null && !this.fechaCierreFin.trim().equals("")) 
		        )	    		
		  )
		  {
		    return true;	
		  }else
		  {
			  return false;
		  }
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean validarCriteriosDetalleAvaluo()
	{
		if(    (this.metodo>0)
		    || (this.edad>0)
		    || (this.conservacion>0)
		    || (   (this.superficieTerrenoMinimo!=null && !this.superficieTerrenoMinimo.trim().equals(""))
		    	&& (this.superficieTerrenoMaximo!=null && !this.superficieTerrenoMaximo.trim().equals("")) 
		        )
		    || (   (this.superficieConstruccionMinimo!=null && !this.superficieConstruccionMinimo.trim().equals(""))
		    	&& (this.superficieConstruccionMaximo!=null && !this.superficieConstruccionMaximo.trim().equals("")) 
		        )
		  )
		  {
		    return true;	
		  }else
		  {
			  return false;
		  }
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean validarCriteriosFactor()
	{
//		 && ( (this.valorMinimoFic==null && this.valorMinimoFic.trim().equals("")) && (this.valorMaximoFic==null && this.valorMaximoFic.trim().equals(""))  )
//		    && ( (this.valorMinimoZona==null && this.valorMinimoZona.trim().equals("")) && (this.valorMaximoZona==null && this.valorMaximoZona.trim().equals("")) )
//		    && ( (this.valorMinimoUbicacion==null && this.valorMinimoUbicacion.trim().equals("")) && (this.valorMaximoUbicacion==null && this.valorMaximoUbicacion.trim().equals("")) )
//		    && ( (this.valorMinimoSuperficie==null && this.valorMinimoSuperficie.trim().equals("")) && (this.valorMinimoSuperficie==null && this.valorMinimoSuperficie.trim().equals("")) )
//		    && ( (this.valorMinimoEdadFactor==null && this.valorMinimoEdadFactor.trim().equals("")) && (this.valorMaximoEdadFactor==null && this.valorMaximoEdadFactor.trim().equals("")) )  
//		    && ( (this.valorMinimoConservacionFactor==null && this.valorMinimoConservacionFactor.trim().equals("")) && (this.valorMaximoConservacionFactor==null && this.valorMaximoConservacionFactor.trim().equals("")) )
//		    && ( (this.valorMinimoOtros!=null && this.valorMinimoOtros.trim().equals("")) && (this.valorMaximoOtros!=null && this.valorMaximoOtros.trim().equals("")) )
//		    && ( (this.valorMinimoComercializacion==null && !this.valorMinimoComercializacion.trim().equals("")) && (this.valorMaximoComercializacion==null && !this.valorMaximoComercializacion.trim().equals("")) ) 
//		    && ( (this.valorMinimoResultante!=null && this.valorMinimoResultante.trim().equals("")) && (this.valorMaximoResultante!=null && this.valorMaximoResultante.trim().equals(""))  )
		
		
		
		if(    	   ( (this.valorMinimoFic!=null && !this.valorMinimoFic.trim().equals("")) && (this.valorMaximoFic!=null && !this.valorMaximoFic.trim().equals(""))  )
			    || ( (this.valorMinimoZona!=null && !this.valorMinimoZona.trim().equals("")) && (this.valorMaximoZona!=null && !this.valorMaximoZona.trim().equals("")) )
			    || ( (this.valorMinimoUbicacion!=null && !this.valorMinimoUbicacion.trim().equals("")) && (this.valorMaximoUbicacion!=null && !this.valorMaximoUbicacion.trim().equals("")) )
			    || ( (this.valorMinimoSuperficie!=null && !this.valorMinimoSuperficie.trim().equals("")) && (this.valorMinimoSuperficie!=null && !this.valorMinimoSuperficie.trim().equals("")) )
			    || ( (this.valorMinimoEdadFactor!=null && !this.valorMinimoEdadFactor.trim().equals("")) && (this.valorMaximoEdadFactor!=null && !this.valorMaximoEdadFactor.trim().equals("")) )
			    || ( (this.valorMinimoConservacionFactor!=null && !this.valorMinimoConservacionFactor.trim().equals("")) && (this.valorMaximoConservacionFactor!=null && !this.valorMaximoConservacionFactor.trim().equals("")) )
			    || ( (this.valorMinimoOtros!=null && !this.valorMinimoOtros.trim().equals("")) && (this.valorMaximoOtros!=null && !this.valorMaximoOtros.trim().equals("")) )
			    || ( (this.valorMinimoComercializacion!=null && !this.valorMinimoComercializacion.trim().equals("")) && (this.valorMaximoComercializacion!=null && !this.valorMaximoComercializacion.trim().equals("")) )
			    || ( (this.valorMinimoResultante!=null && !this.valorMinimoResultante.trim().equals("")) && (this.valorMaximoResultante!=null && !this.valorMaximoResultante.trim().equals(""))  )
			    ||   (   (this.valorUnitarioInicio!=null && !this.valorUnitarioInicio.trim().equals(""))
		    	       && (this.valorUnitarioMaximo!=null && !this.valorUnitarioMaximo.trim().equals(""))
		    	||   (   (this.valorOfertaMinimo!=null && !this.valorOfertaMinimo.trim().equals(""))
		    	       && (this.valorOfertaMaximo!=null && !this.valorOfertaMaximo.trim().equals("")))		    	       
		        )
			  )
			  {
			    return true;	
			  }else
			  {
				  return false;
			  }
	}


	public String getPaquete() {
		return paquete;
	}



	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}



	public String getIdAvaluo() {
		return idAvaluo;
	}



	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}



	public int getIdUv() {
		return idUv;
	}



	public void setIdUv(int idUv) {
		this.idUv = idUv;
	}



	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}



	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}



	public String getFechaCierreFin() {
		return fechaCierreFin;
	}



	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}



	public int getMetodo() {
		return metodo;
	}



	public void setMetodo(int metodo) {
		this.metodo = metodo;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public int getConservacion() {
		return conservacion;
	}



	public void setConservacion(int conservacion) {
		this.conservacion = conservacion;
	}



	public String getValorOfertaMinimo() {
		return valorOfertaMinimo;
	}



	public void setValorOfertaMinimo(String valorOfertaMinimo) {
		this.valorOfertaMinimo = valorOfertaMinimo;
	}



	public String getValorOfertaMaximo() {
		return valorOfertaMaximo;
	}



	public void setValorOfertaMaximo(String valorOfertaMaximo) {
		this.valorOfertaMaximo = valorOfertaMaximo;
	}



	public String getSuperficieTerrenoMinimo() {
		return superficieTerrenoMinimo;
	}



	public void setSuperficieTerrenoMinimo(String superficieTerrenoMinimo) {
		this.superficieTerrenoMinimo = superficieTerrenoMinimo;
	}



	public String getSuperficieTerrenoMaximo() {
		return superficieTerrenoMaximo;
	}



	public void setSuperficieTerrenoMaximo(String superficieTerrenoMaximo) {
		this.superficieTerrenoMaximo = superficieTerrenoMaximo;
	}



	public String getSuperficieConstruccionMinimo() {
		return superficieConstruccionMinimo;
	}

	public void setSuperficieConstruccionMinimo(String superficieConstruccionMinimo) {
		this.superficieConstruccionMinimo = superficieConstruccionMinimo;
	}

	public String getValorUnitarioInicio() {
		return valorUnitarioInicio;
	}



	public void setValorUnitarioInicio(String valorUnitarioInicio) {
		this.valorUnitarioInicio = valorUnitarioInicio;
	}



	public String getValorUnitarioMaximo() {
		return valorUnitarioMaximo;
	}



	public void setValorUnitarioMaximo(String valorUnitarioMaximo) {
		this.valorUnitarioMaximo = valorUnitarioMaximo;
	}



	public String getSuperficieConstruccionMaximo() {
		return superficieConstruccionMaximo;
	}

	public void setSuperficieConstruccionMaximo(String superficieConstruccionMaximo) {
		this.superficieConstruccionMaximo = superficieConstruccionMaximo;
	}

	public boolean isCriteriosAvaluos() {
		return criteriosAvaluos;
	}

	public void setCriteriosAvaluos(boolean criteriosAvaluos) {
		this.criteriosAvaluos = criteriosAvaluos;
	}



	public boolean isCriteriosDetalleAvaluo() {
		return criteriosDetalleAvaluo;
	}



	public void setCriteriosDetalleAvaluo(boolean criteriosDetalleAvaluo) {
		this.criteriosDetalleAvaluo = criteriosDetalleAvaluo;
	}



	public boolean isCriteriosComparativos() {
		return criteriosComparativos;
	}



	public void setCriteriosComparativos(boolean criteriosComparativos) {
		this.criteriosComparativos = criteriosComparativos;
	}

	public List<String> getUnidadesValuacion() {
		return unidadesValuacion;
	}

	public void setUnidadesValuacion(List<String> unidadesValuacion) {
		this.unidadesValuacion = unidadesValuacion;
	}


	/**
	 * @return the valorMinimoFic
	 */
	public String getValorMinimoFic() {
		return valorMinimoFic;
	}


	/**
	 * @param valorMinimoFic the valorMinimoFic to set
	 */
	public void setValorMinimoFic(String valorMinimoFic) {
		this.valorMinimoFic = valorMinimoFic;
	}


	/**
	 * @return the valorMaximoFic
	 */
	public String getValorMaximoFic() {
		return valorMaximoFic;
	}


	/**
	 * @param valorMaximoFic the valorMaximoFic to set
	 */
	public void setValorMaximoFic(String valorMaximoFic) {
		this.valorMaximoFic = valorMaximoFic;
	}


	/**
	 * @return the valorMinimoZona
	 */
	public String getValorMinimoZona() {
		return valorMinimoZona;
	}


	/**
	 * @param valorMinimoZona the valorMinimoZona to set
	 */
	public void setValorMinimoZona(String valorMinimoZona) {
		this.valorMinimoZona = valorMinimoZona;
	}


	/**
	 * @return the valorMaximoZona
	 */
	public String getValorMaximoZona() {
		return valorMaximoZona;
	}


	/**
	 * @param valorMaximoZona the valorMaximoZona to set
	 */
	public void setValorMaximoZona(String valorMaximoZona) {
		this.valorMaximoZona = valorMaximoZona;
	}


	/**
	 * @return the valorMinimoUbicacion
	 */
	public String getValorMinimoUbicacion() {
		return valorMinimoUbicacion;
	}


	/**
	 * @param valorMinimoUbicacion the valorMinimoUbicacion to set
	 */
	public void setValorMinimoUbicacion(String valorMinimoUbicacion) {
		this.valorMinimoUbicacion = valorMinimoUbicacion;
	}


	/**
	 * @return the valorMaximoUbicacion
	 */
	public String getValorMaximoUbicacion() {
		return valorMaximoUbicacion;
	}


	/**
	 * @param valorMaximoUbicacion the valorMaximoUbicacion to set
	 */
	public void setValorMaximoUbicacion(String valorMaximoUbicacion) {
		this.valorMaximoUbicacion = valorMaximoUbicacion;
	}


	/**
	 * @return the valorMinimoSuperficie
	 */
	public String getValorMinimoSuperficie() {
		return valorMinimoSuperficie;
	}


	/**
	 * @param valorMinimoSuperficie the valorMinimoSuperficie to set
	 */
	public void setValorMinimoSuperficie(String valorMinimoSuperficie) {
		this.valorMinimoSuperficie = valorMinimoSuperficie;
	}


	/**
	 * @return the valorMaximoSuperficie
	 */
	public String getValorMaximoSuperficie() {
		return valorMaximoSuperficie;
	}


	/**
	 * @param valorMaximoSuperficie the valorMaximoSuperficie to set
	 */
	public void setValorMaximoSuperficie(String valorMaximoSuperficie) {
		this.valorMaximoSuperficie = valorMaximoSuperficie;
	}


	/**
	 * @return the valorMinimoEdadFactor
	 */
	public String getValorMinimoEdadFactor() {
		return valorMinimoEdadFactor;
	}


	/**
	 * @param valorMinimoEdadFactor the valorMinimoEdadFactor to set
	 */
	public void setValorMinimoEdadFactor(String valorMinimoEdadFactor) {
		this.valorMinimoEdadFactor = valorMinimoEdadFactor;
	}


	/**
	 * @return the valorMaximoEdadFactor
	 */
	public String getValorMaximoEdadFactor() {
		return valorMaximoEdadFactor;
	}


	/**
	 * @param valorMaximoEdadFactor the valorMaximoEdadFactor to set
	 */
	public void setValorMaximoEdadFactor(String valorMaximoEdadFactor) {
		this.valorMaximoEdadFactor = valorMaximoEdadFactor;
	}


	/**
	 * @return the valorMinimoConservacionFactor
	 */
	public String getValorMinimoConservacionFactor() {
		return valorMinimoConservacionFactor;
	}


	/**
	 * @param valorMinimoConservacionFactor the valorMinimoConservacionFactor to set
	 */
	public void setValorMinimoConservacionFactor(
			String valorMinimoConservacionFactor) {
		this.valorMinimoConservacionFactor = valorMinimoConservacionFactor;
	}


	/**
	 * @return the valorMaximoConservacionFactor
	 */
	public String getValorMaximoConservacionFactor() {
		return valorMaximoConservacionFactor;
	}


	/**
	 * @param valorMaximoConservacionFactor the valorMaximoConservacionFactor to set
	 */
	public void setValorMaximoConservacionFactor(
			String valorMaximoConservacionFactor) {
		this.valorMaximoConservacionFactor = valorMaximoConservacionFactor;
	}


	/**
	 * @return the valorMinimoOtros
	 */
	public String getValorMinimoOtros() {
		return valorMinimoOtros;
	}


	/**
	 * @param valorMinimoOtros the valorMinimoOtros to set
	 */
	public void setValorMinimoOtros(String valorMinimoOtros) {
		this.valorMinimoOtros = valorMinimoOtros;
	}


	/**
	 * @return the valorMaximoOtros
	 */
	public String getValorMaximoOtros() {
		return valorMaximoOtros;
	}


	/**
	 * @param valorMaximoOtros the valorMaximoOtros to set
	 */
	public void setValorMaximoOtros(String valorMaximoOtros) {
		this.valorMaximoOtros = valorMaximoOtros;
	}


	/**
	 * @return the valorMinimoComercializacion
	 */
	public String getValorMinimoComercializacion() {
		return valorMinimoComercializacion;
	}


	/**
	 * @param valorMinimoComercializacion the valorMinimoComercializacion to set
	 */
	public void setValorMinimoComercializacion(String valorMinimoComercializacion) {
		this.valorMinimoComercializacion = valorMinimoComercializacion;
	}


	/**
	 * @return the valorMaximoComercializacion
	 */
	public String getValorMaximoComercializacion() {
		return valorMaximoComercializacion;
	}


	/**
	 * @param valorMaximoComercializacion the valorMaximoComercializacion to set
	 */
	public void setValorMaximoComercializacion(String valorMaximoComercializacion) {
		this.valorMaximoComercializacion = valorMaximoComercializacion;
	}


	/**
	 * @return the valorMinimoResultante
	 */
	public String getValorMinimoResultante() {
		return valorMinimoResultante;
	}


	/**
	 * @param valorMinimoResultante the valorMinimoResultante to set
	 */
	public void setValorMinimoResultante(String valorMinimoResultante) {
		this.valorMinimoResultante = valorMinimoResultante;
	}


	/**
	 * @return the valorMaximoResultante
	 */
	public String getValorMaximoResultante() {
		return valorMaximoResultante;
	}


	/**
	 * @param valorMaximoResultante the valorMaximoResultante to set
	 */
	public void setValorMaximoResultante(String valorMaximoResultante) {
		this.valorMaximoResultante = valorMaximoResultante;
	}
	
	
	
	
	
	

}
