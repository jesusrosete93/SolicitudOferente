package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un oferente del catalogo de oferentes en el SELAI</p>
 * @author Jesus Rosete
 *
 */
public class EcoTecnologiasDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6839775058770794587L;
	private String claveEcotecnologia;
	private String desarrollador;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	
	public String getclaveEcotecnologia() {
		return claveEcotecnologia;
	}
	public void setdesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	public String getClaveEcotecnologia() {
		return claveEcotecnologia;
	}
	public void setClaveEcotecnologia(String claveEcotecnologia) {
		this.claveEcotecnologia = claveEcotecnologia;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
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
