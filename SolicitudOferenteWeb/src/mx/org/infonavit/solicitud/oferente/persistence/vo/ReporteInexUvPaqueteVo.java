package mx.org.infonavit.solicitud.oferente.persistence.vo;

public class ReporteInexUvPaqueteVo {
	
	private String rfcOferente;
	private String paquete;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	
	private int totalViviendasPaquete;
	private int totalVivienasSolicitadas;
	private int totalSolicitudesEstado;
	
	private int idUnidadValuacion;
	private String nombreUnidadValuacion;
	private int numeroViviendasUnidadValuacion;
	
	public ReporteInexUvPaqueteVo() {
		super();
	}
	
	public ReporteInexUvPaqueteVo(String paquete, String fechaSolicitudInicio,
			String fechaSolicitudFin, int totalViviendasPaquete,
			int totalVivienasSolicitadas, int totalSolicitudesEstado,
			int idUnidadValuacion, String nombreUnidadValuacion,
			int numeroViviendasUnidadValuacion) {
		super();
		this.paquete = paquete;
		this.fechaSolicitudInicio = fechaSolicitudInicio;
		this.fechaSolicitudFin = fechaSolicitudFin;
		this.totalViviendasPaquete = totalViviendasPaquete;
		this.totalVivienasSolicitadas = totalVivienasSolicitadas;
		this.totalSolicitudesEstado = totalSolicitudesEstado;
		this.idUnidadValuacion = idUnidadValuacion;
		this.nombreUnidadValuacion = nombreUnidadValuacion;
		this.numeroViviendasUnidadValuacion = numeroViviendasUnidadValuacion;
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
	public int getTotalViviendasPaquete() {
		return totalViviendasPaquete;
	}
	public void setTotalViviendasPaquete(int totalViviendasPaquete) {
		this.totalViviendasPaquete = totalViviendasPaquete;
	}
	public int getTotalVivienasSolicitadas() {
		return totalVivienasSolicitadas;
	}
	public void setTotalVivienasSolicitadas(int totalVivienasSolicitadas) {
		this.totalVivienasSolicitadas = totalVivienasSolicitadas;
	}
	public int getTotalSolicitudesEstado() {
		return totalSolicitudesEstado;
	}
	public void setTotalSolicitudesEstado(int totalSolicitudesEstado) {
		this.totalSolicitudesEstado = totalSolicitudesEstado;
	}
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}

	public String getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}
	public void setNombreUnidadValuacion(String nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}

	public int getNumeroViviendasUnidadValuacion() {
		return numeroViviendasUnidadValuacion;
	}

	public void setNumeroViviendasUnidadValuacion(int numeroViviendasUnidadValuacion) {
		this.numeroViviendasUnidadValuacion = numeroViviendasUnidadValuacion;
	}

	public String getRfcOferente() {
		return rfcOferente;
	}

	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	
	

}
