package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaSolicitudesInexForm extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 274468904978331603L;
	private String errores;
	private String paquete;
	private String rfcOferente;
	private int idEstado;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private List<String> camposPaquete;
	private List<String> camposAvaluo;
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
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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
	public List<String> getCamposPaquete() {
		return camposPaquete;
	}
	public void setCamposPaquete(List<String> camposPaquete) {
		this.camposPaquete = camposPaquete;
	}
	public List<String> getCamposAvaluo() {
		return camposAvaluo;
	}
	public void setCamposAvaluo(List<String> camposAvaluo) {
		this.camposAvaluo = camposAvaluo;
	}
	public List<String> getCamposOferente() {
		return camposOferente;
	}
	public void setCamposOferente(List<String> camposOferente) {
		this.camposOferente = camposOferente;
	}

}
