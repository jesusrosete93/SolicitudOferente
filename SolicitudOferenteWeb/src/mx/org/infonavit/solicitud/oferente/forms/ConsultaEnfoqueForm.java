package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * Clase que representa el formulario 
 * que se muestra en el tablero de avalúos 
 * para las consultas de enfoque de avaluos
 * 
 * @author Adrian Casas EON LUX 
 */
public class ConsultaEnfoqueForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2097663376701334546L;
	private String errores;
	private String paquete;
	private String idAvaluo;
	private List<String> nombreUnidadValuacion;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int    metodo;
	private int edad;
	private int conservacion;
	private String valorOfertaMaximo;
	private String valorOfertaMinimo;
	private String superficieTerrenoMaximo;
	private String superficieTerrenoMinimo;
	private String superficieConstruccionMaximo;
	private String superficieConstruccionMinimo;
	private String valorUnitarioMaximo;
	private String valorUnitarioMinimo;
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
	
	

	
	/**
	 * @return the errores
	 */
	public String getErrores() {
		return errores;
	}




	/**
	 * @param errores the errores to set
	 */
	public void setErrores(String errores) {
		this.errores = errores;
	}




	/**
	 * @return the paquete
	 */
	public String getPaquete() {
		return paquete;
	}




	/**
	 * @param paquete the paquete to set
	 */
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}




	/**
	 * @return the idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}




	/**
	 * @param idAvaluo the idAvaluo to set
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}




	/**
	 * @return the nombreUnidadValuacion
	 */
	public List<String> getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}




	/**
	 * @param nombreUnidadValuacion the nombreUnidadValuacion to set
	 */
	public void setNombreUnidadValuacion(List<String> nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}




	/**
	 * @return the fechaCierreInicio
	 */
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}




	/**
	 * @param fechaCierreInicio the fechaCierreInicio to set
	 */
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}




	/**
	 * @return the fechaCierreFin
	 */
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}




	/**
	 * @param fechaCierreFin the fechaCierreFin to set
	 */
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}




	/**
	 * @return the metodo
	 */
	public int getMetodo() {
		return metodo;
	}




	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(int metodo) {
		this.metodo = metodo;
	}




	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}




	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}




	/**
	 * @return the conservacion
	 */
	public int getConservacion() {
		return conservacion;
	}




	/**
	 * @param conservacion the conservacion to set
	 */
	public void setConservacion(int conservacion) {
		this.conservacion = conservacion;
	}




	/**
	 * @return the valorOfertaMaximo
	 */
	public String getValorOfertaMaximo() {
		return valorOfertaMaximo;
	}




	/**
	 * @param valorOfertaMaximo the valorOfertaMaximo to set
	 */
	public void setValorOfertaMaximo(String valorOfertaMaximo) {
		this.valorOfertaMaximo = valorOfertaMaximo;
	}




	/**
	 * @return the valorOfertaMinimo
	 */
	public String getValorOfertaMinimo() {
		return valorOfertaMinimo;
	}




	/**
	 * @param valorOfertaMinimo the valorOfertaMinimo to set
	 */
	public void setValorOfertaMinimo(String valorOfertaMinimo) {
		this.valorOfertaMinimo = valorOfertaMinimo;
	}




	/**
	 * @return the superficieTerrenoMaximo
	 */
	public String getSuperficieTerrenoMaximo() {
		return superficieTerrenoMaximo;
	}




	/**
	 * @param superficieTerrenoMaximo the superficieTerrenoMaximo to set
	 */
	public void setSuperficieTerrenoMaximo(String superficieTerrenoMaximo) {
		this.superficieTerrenoMaximo = superficieTerrenoMaximo;
	}




	/**
	 * @return the superficieTerrenoMinimo
	 */
	public String getSuperficieTerrenoMinimo() {
		return superficieTerrenoMinimo;
	}




	/**
	 * @param superficieTerrenoMinimo the superficieTerrenoMinimo to set
	 */
	public void setSuperficieTerrenoMinimo(String superficieTerrenoMinimo) {
		this.superficieTerrenoMinimo = superficieTerrenoMinimo;
	}




	/**
	 * @return the superficieConstruccionMaximo
	 */
	public String getSuperficieConstruccionMaximo() {
		return superficieConstruccionMaximo;
	}




	/**
	 * @param superficieConstruccionMaximo the superficieConstruccionMaximo to set
	 */
	public void setSuperficieConstruccionMaximo(String superficieConstruccionMaximo) {
		this.superficieConstruccionMaximo = superficieConstruccionMaximo;
	}




	/**
	 * @return the superficieConstruccionMinimo
	 */
	public String getSuperficieConstruccionMinimo() {
		return superficieConstruccionMinimo;
	}




	/**
	 * @param superficieConstruccionMinimo the superficieConstruccionMinimo to set
	 */
	public void setSuperficieConstruccionMinimo(String superficieConstruccionMinimo) {
		this.superficieConstruccionMinimo = superficieConstruccionMinimo;
	}




	/**
	 * @return the valorUnitarioMaximo
	 */
	public String getValorUnitarioMaximo() {
		return valorUnitarioMaximo;
	}




	/**
	 * @param valorUnitarioMaximo the valorUnitarioMaximo to set
	 */
	public void setValorUnitarioMaximo(String valorUnitarioMaximo) {
		this.valorUnitarioMaximo = valorUnitarioMaximo;
	}




	/**
	 * @return the valorUnitarioMinimo
	 */
	public String getValorUnitarioMinimo() {
		return valorUnitarioMinimo;
	}




	/**
	 * @param valorUnitarioMinimo the valorUnitarioMinimo to set
	 */
	public void setValorUnitarioMinimo(String valorUnitarioMinimo) {
		this.valorUnitarioMinimo = valorUnitarioMinimo;
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




	public void resetAll()
	{
		 this.errores="";
		 this.paquete="";
		 this.idAvaluo="";
		 this.nombreUnidadValuacion=null;
		 this.fechaCierreInicio="";
		 this.fechaCierreFin="";
		 this.metodo=0;
		 this.edad=0;
		 this.conservacion=0;
		 this.valorOfertaMaximo="";
		 this.valorOfertaMinimo="";
		 this.superficieTerrenoMaximo="";
		 this.superficieTerrenoMinimo="";
		 this.superficieConstruccionMaximo="";
		 this.superficieConstruccionMinimo="";
		 this.valorUnitarioMaximo="";
		 this.valorUnitarioMinimo="";
		 this.valorMinimoFic="";
		 this.valorMaximoFic="";
		 this.valorMinimoZona="";
		 this.valorMaximoZona="";
		 this.valorMinimoUbicacion="";
		 this.valorMaximoUbicacion="";
		 this.valorMinimoSuperficie="";
		 this.valorMaximoSuperficie="";
		 this.valorMinimoEdadFactor="";
		 this.valorMaximoEdadFactor="";
		 this.valorMinimoConservacionFactor="";
		 this.valorMaximoConservacionFactor="";
		 this.valorMinimoOtros="";
		 this.valorMaximoOtros="";
		 this.valorMinimoComercializacion="";
		 this.valorMaximoComercializacion="";
		 this.valorMinimoResultante="";
		 this.valorMaximoResultante="";
	}
	

}
