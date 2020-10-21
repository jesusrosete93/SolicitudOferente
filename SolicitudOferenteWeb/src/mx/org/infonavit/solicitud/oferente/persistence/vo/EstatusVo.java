package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EstatusVo extends GenericValueObject {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2390882003407665185L;
	private int idEstatus;
	private String descripcion;
	
	public EstatusVo() {
		super();
	}
	
	public EstatusVo(int idEstatus, String descripcion) {
		super();
		this.idEstatus = idEstatus;
		this.descripcion = descripcion;
	}
	/**
	 * @return El valor de: idEstatus
	 */
	public int getIdEstatus() {
		return idEstatus;
	}
	/**
	 * @param Valor: idEstatus a asignar en: idEstatus
	 */
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	/**
	 * @return El valor de: descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param Valor: descripcion a asignar en: descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
