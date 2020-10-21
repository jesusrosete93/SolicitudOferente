package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un registro de la tabla: cat_oferente</p>
 * @author Jesus Rosete
 *
 */
public class EcoTecnologiasVo extends GenericValueObject {
	
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
	
	
	public EcoTecnologiasVo() {
		super();
	}
	
	
	public EcoTecnologiasVo(String claveTecnologia, String paquete) {
		super();
		this.claveTecnologia = claveTecnologia;
		this.paquete = paquete;
		
	}
	
	
//	public EcoTecnologiasVo(String claveTecnologia, String fechaRegistro,
//			String estatus, String paquete, String fechaSolicitudInicio,
//			String fechaSolicitudFin) {
//		super();
//		this.claveTecnologia = claveTecnologia;
//		FechaRegistro = fechaRegistro;
//		Estatus = estatus;
//		this.paquete = paquete;
//		this.fechaSolicitudInicio = fechaSolicitudInicio;
//		this.fechaSolicitudFin = fechaSolicitudFin;
//	}
	
	public EcoTecnologiasVo(String claveTecnologia) {
		super();
		this.claveTecnologia = claveTecnologia;
		
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
	
	
	
	
	
	
	
	

}
