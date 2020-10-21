package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class UnidadValuacionForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8737158436942020155L;
	//Datos de unidad de valuación - - - - - -- 
	private int claveUnidadValuacion;
	private List<String> nombreUnidadValuacion;
	private int estatusUnidadValuacion;
	private String fechaVigenciaInicio;
	private String fechaVigenciaFin;
	private String claveSHF;
	private String siglas;
	private int unidadViviendaRecuperada;
	private List<String> camposUnidadValuacion;
	
	
	
	
	
	/**
	 * @return El valor de: claveUnidadValuacion
	 */
	public int getClaveUnidadValuacion() {
		return claveUnidadValuacion;
	}
	/**
	 * @param Valor: claveUnidadValuacion a asignar en: claveUnidadValuacion
	 */
	public void setClaveUnidadValuacion(int claveUnidadValuacion) {
		this.claveUnidadValuacion = claveUnidadValuacion;
	}
	/**
	 * @return El valor de: unidadValuacion
	 */
	public List<String> getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}
	/**
	 * @param Valor: unidadValuacion a asignar en: unidadValuacion
	 */
	public void setNombreUnidadValuacion(List<String> nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}
	/**
	 * @return El valor de: estatusUnidadValuacion
	 */
	public int getEstatusUnidadValuacion() {
		return estatusUnidadValuacion;
	}
	/**
	 * @param Valor: estatusUnidadValuacion a asignar en: estatusUnidadValuacion
	 */
	public void setEstatusUnidadValuacion(int estatusUnidadValuacion) {
		this.estatusUnidadValuacion = estatusUnidadValuacion;
	}
	/**
	 * @return El valor de: fechaVigenciaInicio
	 */
	public String getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}
	/**
	 * @param Valor: fechaVigenciaInicio a asignar en: fechaVigenciaInicio
	 */
	public void setFechaVigenciaInicio(String fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}
	/**
	 * @return El valor de: fechaVigenciaFin
	 */
	public String getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}
	/**
	 * @param Valor: fechaVigenciaFin a asignar en: fechaVigenciaFin
	 */
	public void setFechaVigenciaFin(String fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}
	/**
	 * @return El valor de: claveSHF
	 */
	public String getClaveSHF() {
		return claveSHF;
	}
	/**
	 * @param Valor: claveSHF a asignar en: claveSHF
	 */
	public void setClaveSHF(String claveSHF) {
		this.claveSHF = claveSHF;
	}
	/**
	 * @return El valor de: siglas
	 */
	public String getSiglas() {
		return siglas;
	}
	/**
	 * @param Valor: siglas a asignar en: siglas
	 */
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	/**
	 * @return El valor de: unidadViviendaRecuperada
	 */
	public int getUnidadViviendaRecuperada() {
		return unidadViviendaRecuperada;
	}
	/**
	 * @param Valor: unidadViviendaRecuperada a asignar en: unidadViviendaRecuperada
	 */
	public void setUnidadViviendaRecuperada(int unidadViviendaRecuperada) {
		this.unidadViviendaRecuperada = unidadViviendaRecuperada;
	}
	/**
	 * @return El valor de: camposUnidadValuacion
	 */
	public List<String> getCamposUnidadValuacion() {
		return camposUnidadValuacion;
	}
	/**
	 * @param Valor: camposUnidadValuacion a asignar en: camposUnidadValuacion
	 */
	public void setCamposUnidadValuacion(List<String> camposUnidadValuacion) {
		this.camposUnidadValuacion = camposUnidadValuacion;
	}
	
	

}
