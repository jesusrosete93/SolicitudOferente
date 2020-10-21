package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ReporteECcoTecnologiaForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3310881838197030107L;
	private String errores;
	private String desarrollador;
	private String cveEcoTecnologia;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	
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

	
	
}
