package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;



public class ReporteInexUvOferenteVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1748437274773741388L;
	private String idEstado;
	private int idUnidadValuacion;
	private String nombreUnidad;
	private int totalViviendas;
	private String rfcOferente;
	private String paquete;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String estado;
	
	public ReporteInexUvOferenteVo() {
		super();
	}
	
	
	
	public ReporteInexUvOferenteVo(String rfcOferente, String paquete,
			String fechaSolicitudInicio, String fechaSolicitudFin,String estado) {
		super();
		this.rfcOferente = rfcOferente;
		this.paquete = paquete;
		this.fechaSolicitudInicio = fechaSolicitudInicio;
		this.fechaSolicitudFin = fechaSolicitudFin;
		this.estado = estado;
	}



	public ReporteInexUvOferenteVo(String idEstado, int idUnidadValuacion,
			String nombreUnidad, int totalViviendas) {
		super();
		this.idEstado = idEstado;
		this.idUnidadValuacion = idUnidadValuacion;
		this.nombreUnidad = nombreUnidad;
		this.totalViviendas = totalViviendas;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
	public int getTotalViviendas() {
		return totalViviendas;
	}
	public void setTotalViviendas(int totalViviendas) {
		this.totalViviendas = totalViviendas;
	}

	public String getRfcOferente() {
		return rfcOferente;
	}

	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
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



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
