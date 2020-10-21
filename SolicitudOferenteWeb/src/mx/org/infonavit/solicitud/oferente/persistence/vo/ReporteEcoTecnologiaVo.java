package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;



public class ReporteEcoTecnologiaVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1748437274773741388L;

	private String claveTecnologia;
	private String oferta;
	private String IdVivienda;
	private String paquete;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String id_paquete;
	private String anioMES;
	private String numecotec;
	
	
	
	public ReporteEcoTecnologiaVo() {
		super();
		// TODO Apéndice de constructor generado automáticamente
	}
	
	
	
	public ReporteEcoTecnologiaVo(String claveTecnologia, String oferta,
			String idVivienda, String paquete, String fechaSolicitudInicio,
			String fechaSolicitudFin, String id_paquete) {
		super();
		this.claveTecnologia = claveTecnologia;
		this.oferta = oferta;
		IdVivienda = idVivienda;
		this.paquete = paquete;
		this.fechaSolicitudInicio = fechaSolicitudInicio;
		this.fechaSolicitudFin = fechaSolicitudFin;
		this.id_paquete = id_paquete;
	}
	
	public ReporteEcoTecnologiaVo(String claveTecnologia, String paquete,String anioMES,String numecotec) {
		super();
		this.claveTecnologia = claveTecnologia;
		this.paquete = paquete;
		this.anioMES = anioMES;
		this.numecotec= numecotec;
	}



	public String getClaveTecnologia() {
		return claveTecnologia;
	}
	public void setClaveTecnologia(String claveTecnologia) {
		this.claveTecnologia = claveTecnologia;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public String getIdVivienda() {
		return IdVivienda;
	}
	public void setIdVivienda(String idVivienda) {
		IdVivienda = idVivienda;
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
	public String getId_paquete() {
		return id_paquete;
	}
	public void setId_paquete(String id_paquete) {
		this.id_paquete = id_paquete;
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
