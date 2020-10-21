package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * 
 * @author adrian.casas
 *
 */
public class EstadoConservacionVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4944067812235899928L;
	private int idEstadoConservacion;
	private String descripcion;
	
	public EstadoConservacionVo() {
		super();
	}
	
	public EstadoConservacionVo(int idEstadoConservacion, String descripcion) {
		super();
		this.idEstadoConservacion = idEstadoConservacion;
		this.descripcion = descripcion;
	}
	public int getIdEstadoConservacion() {
		return idEstadoConservacion;
	}
	public void setIdEstadoConservacion(int idEstadoConservacion) {
		this.idEstadoConservacion = idEstadoConservacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
