package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaReasignacionInexForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2947299411687054042L;
	private String errores;
	private String paquete;
	private String rfcOferente;
	private int estado;
	private String fechaReasignacionInicio;
	private String fechaReasignacionFin;
	private int idUnidadNueva;
	private int idUnidadAnterior;
	private int tipoPaquete;
	private List<String> camposReasignacion;
	private List<String> camposPaquete;
	private List<String> camposOferente;
	
	
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getRfcOferente() {
		return rfcOferente;
	}
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getFechaReasignacionInicio() {
		return fechaReasignacionInicio;
	}
	public void setFechaReasignacionInicio(String fechaReasignacionInicio) {
		this.fechaReasignacionInicio = fechaReasignacionInicio;
	}
	public String getFechaReasignacionFin() {
		return fechaReasignacionFin;
	}
	public void setFechaReasignacionFin(String fechaReasignacionFin) {
		this.fechaReasignacionFin = fechaReasignacionFin;
	}
	public int getIdUnidadNueva() {
		return idUnidadNueva;
	}
	public void setIdUnidadNueva(int idUnidadNueva) {
		this.idUnidadNueva = idUnidadNueva;
	}
	public int getIdUnidadAnterior() {
		return idUnidadAnterior;
	}
	public void setIdUnidadAnterior(int idUnidadAnterior) {
		this.idUnidadAnterior = idUnidadAnterior;
	}
	public List<String> getCamposReasignacion() {
		return camposReasignacion;
	}
	public void setCamposReasignacion(List<String> camposReasignacion) {
		this.camposReasignacion = camposReasignacion;
	}
	public List<String> getCamposPaquete() {
		return camposPaquete;
	}
	public void setCamposPaquete(List<String> camposPaquete) {
		this.camposPaquete = camposPaquete;
	}
	public int getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(int tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	public List<String> getCamposOferente() {
		return camposOferente;
	}
	public void setCamposOferente(List<String> camposOferente) {
		this.camposOferente = camposOferente;
	}
	
	
		

}
