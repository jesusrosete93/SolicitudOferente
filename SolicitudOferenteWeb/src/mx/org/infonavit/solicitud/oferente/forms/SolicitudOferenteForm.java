package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class SolicitudOferenteForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3310881838197030107L;
	private String errores;
	private String desarrollador;
	private String cveEcoTecnologia;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String estado;
	private String id_oferente;
	
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String getCveEcoTecnologia() {
		return cveEcoTecnologia;
	}
	public void setCveEcoTecnologia(String cveEcoTecnologia) {
		this.cveEcoTecnologia = cveEcoTecnologia;
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
	public String getId_oferente() {
		return id_oferente;
	}
	public void setId_oferente(String id_oferente) {
		this.id_oferente = id_oferente;
	}

	
	
}
