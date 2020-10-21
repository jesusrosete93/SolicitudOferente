package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaCancelacionInexForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2947299411687054042L;
	private String errores;
	private String paquete;
	private String rfcOferente;
	private int estado;
	private String fechaCancelacionInicio;
	private String fechaCancelacionFin;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private int tipoPaquete;
	private List<String> camposCancelacion;
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
	public String getFechaCancelacionInicio() {
		return fechaCancelacionInicio;
	}
	public void setFechaCancelacionInicio(String fechaCancelacionInicio) {
		this.fechaCancelacionInicio = fechaCancelacionInicio;
	}
	public String getFechaCancelacionFin() {
		return fechaCancelacionFin;
	}
	public void setFechaCancelacionFin(String fechaCancelacionFin) {
		this.fechaCancelacionFin = fechaCancelacionFin;
	}
	public String getFechaSolicitudInicio() {
		return fechaSolicitudInicio;
	}
	public void setFechaSolicitudInicio(String fechaSolicitudInicio) {
		this.fechaSolicitudInicio = fechaSolicitudInicio;
	}
	public String getFechaSolicitudFin() {
		return fechaSolicitudFin;
	}
	public void setFechaSolicitudFin(String fechaSolicitudFin) {
		this.fechaSolicitudFin = fechaSolicitudFin;
	}
	public List<String> getCamposCancelacion() {
		return camposCancelacion;
	}
	public void setCamposCancelacion(List<String> camposCancelacion) {
		this.camposCancelacion = camposCancelacion;
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
