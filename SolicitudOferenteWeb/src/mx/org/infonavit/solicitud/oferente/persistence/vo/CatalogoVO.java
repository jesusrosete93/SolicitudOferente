package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CatalogoVO extends GenericValueObject{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3703488619902729962L;
	private String clave;
	private String descripcion;
	
	
	
	
	public CatalogoVO() {
		super();
	}




	public CatalogoVO(String clave, String descripcion) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
	}




	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}




	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
