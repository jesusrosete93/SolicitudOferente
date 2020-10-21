package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaAsignacionesForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2980827387629320627L;
	private String paquete;
	private String claveUnidadValuacion;
	private String nombreFrente;
	private String rfcOferente;
	private String fechaAsignacionInicio;
	private String fechaAsignacionFin;
	private int claveEstado;
	private String claveUnidadValuacionAnterior;
	private String fechaReasignacionInicio;
	private String fechaReasignacionFin;
	private int tipoReasignacion;
	private String errores;
	private List<String> camposAsignaciones;
	
	
	
	/**
	 * @return El valor de: paquete
	 */
	public String getPaquete() {
		return paquete;
	}
	/**
	 * @param Valor: paquete a asignar en: paquete
	 */
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	/**
	 * @return El valor de: nombreUnidadValuacion
	 */
	public String getClaveUnidadValuacion() {
		return claveUnidadValuacion;
	}
	/**
	 * @param Valor: nombreUnidadValuacion a asignar en: nombreUnidadValuacion
	 */
	public void setClaveUnidadValuacion(String claveUnidadValuacion) {
		this.claveUnidadValuacion = claveUnidadValuacion;
	}
	/**
	 * @return El valor de: nombreFrente
	 */
	public String getNombreFrente() {
		return nombreFrente;
	}
	/**
	 * @param Valor: nombreFrente a asignar en: nombreFrente
	 */
	public void setNombreFrente(String nombreFrente) {
		this.nombreFrente = nombreFrente;
	}
	/**
	 * @return El valor de: rfcOferente
	 */
	public String getRfcOferente() {
		return rfcOferente;
	}
	/**
	 * @param Valor: rfcOferente a asignar en: rfcOferente
	 */
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	/**
	 * @return El valor de: fechaAsignacionInicio
	 */
	public String getFechaAsignacionInicio() {
		return fechaAsignacionInicio;
	}
	/**
	 * @param Valor: fechaAsignacionInicio a asignar en: fechaAsignacionInicio
	 */
	public void setFechaAsignacionInicio(String fechaAsignacionInicio) {
		this.fechaAsignacionInicio = fechaAsignacionInicio;
	}
	/**
	 * @return El valor de: fechaAsignacionFin
	 */
	public String getFechaAsignacionFin() {
		return fechaAsignacionFin;
	}
	/**
	 * @param Valor: fechaAsignacionFin a asignar en: fechaAsignacionFin
	 */
	public void setFechaAsignacionFin(String fechaAsignacionFin) {
		this.fechaAsignacionFin = fechaAsignacionFin;
	}
	/**
	 * @return El valor de: claveEstado
	 */
	public int getClaveEstado() {
		return claveEstado;
	}
	/**
	 * @param Valor: claveEstado a asignar en: claveEstado
	 */
	public void setClaveEstado(int claveEstado) {
		this.claveEstado = claveEstado;
	}
	/**
	 * @return El valor de: claveUnidadValuacionAnterior
	 */
	public String getClaveUnidadValuacionAnterior() {
		return claveUnidadValuacionAnterior;
	}
	/**
	 * @param Valor: claveUnidadValuacionAnterior a asignar en: claveUnidadValuacionAnterior
	 */
	public void setClaveUnidadValuacionAnterior(String claveUnidadValuacionAnterior) {
		this.claveUnidadValuacionAnterior = claveUnidadValuacionAnterior;
	}
	/**
	 * @return El valor de: fechaReasignacionInicio
	 */
	public String getFechaReasignacionInicio() {
		return fechaReasignacionInicio;
	}
	/**
	 * @param Valor: fechaReasignacionInicio a asignar en: fechaReasignacionInicio
	 */
	public void setFechaReasignacionInicio(String fechaReasignacionInicio) {
		this.fechaReasignacionInicio = fechaReasignacionInicio;
	}
	/**
	 * @return El valor de: fechaReasignacionFin
	 */
	public String getFechaReasignacionFin() {
		return fechaReasignacionFin;
	}
	/**
	 * @param Valor: fechaReasignacionFin a asignar en: fechaReasignacionFin
	 */
	public void setFechaReasignacionFin(String fechaReasignacionFin) {
		this.fechaReasignacionFin = fechaReasignacionFin;
	}
	/**
	 * @return El valor de: tipoReasignacion
	 */
	public int getTipoReasignacion() {
		return tipoReasignacion;
	}
	/**
	 * @param Valor: tipoReasignacion a asignar en: tipoReasignacion
	 */
	public void setTipoReasignacion(int tipoReasignacion) {
		this.tipoReasignacion = tipoReasignacion;
	}
	/**
	 * @return El valor de: errores
	 */
	public String getErrores() {
		return errores;
	}
	/**
	 * @param Valor: errores a asignar en: errores
	 */
	public void setErrores(String errores) {
		this.errores = errores;
	}
	/**
	 * @return El valor de: camposAsignaciones
	 */
	public List<String> getCamposAsignaciones() {
		return camposAsignaciones;
	}
	/**
	 * @param Valor: camposAsignaciones a asignar en: camposAsignaciones
	 */
	public void setCamposAsignaciones(List<String> camposAsignaciones) {
		this.camposAsignaciones = camposAsignaciones;
	}
	

}
