package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class TecnologiaDomain extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String claveTecnologia;
	private String FechaRegistro;
	private String Estatus;
	private String paquete;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String anioMES;
	private String numecotec;
	
	
	
	
	public TecnologiaDomain(String claveTecnologia, String paquete,String anioMES,String numecotec) {
		super();
		this.claveTecnologia = claveTecnologia;
		this.paquete = paquete;
		this.anioMES = anioMES;
		this.numecotec =numecotec;
	}
	
	
	public String getClaveTecnologia() {
		return claveTecnologia;
	}
	public void setClaveTecnologia(String claveTecnologia) {
		this.claveTecnologia = claveTecnologia;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public String getEstatus() {
		return Estatus;
	}
	public void setEstatus(String estatus) {
		Estatus = estatus;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
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
	
	public String getanioMES() {
		return anioMES;
	}
	public void setanioMES(String anioMES) {
		this.anioMES = anioMES;
	}
	
	public String getnumecotec() {
		return numecotec;
	}
	public void setnumecotec(String numecotec) {
		this.numecotec = numecotec;
	}
	

}
