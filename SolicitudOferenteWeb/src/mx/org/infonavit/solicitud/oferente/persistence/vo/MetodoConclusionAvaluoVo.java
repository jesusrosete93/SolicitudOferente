package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * 
 * @author adrian.casas
 *
 */
public class MetodoConclusionAvaluoVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6843965573323555785L;
	private int idMetodo;
	private String descripcion;
	
	public MetodoConclusionAvaluoVo() {
		super();
	}
	
	public MetodoConclusionAvaluoVo(int idMetodo, String descripcion) {
		super();
		this.idMetodo = idMetodo;
		this.descripcion = descripcion;
	}
	
	public int getIdMetodo() {
		return idMetodo;
	}
	public void setIdMetodo(int idMetodo) {
		this.idMetodo = idMetodo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
