/**
 * Clase que encapsula la información de 
 * un estado de la republica.
 */
package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EstadoDomian extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1254151079045668457L;
	private String idEstado;
	private String nombre;
	
	public EstadoDomian() {
		super();
	}
	
	public EstadoDomian(String idEstado, String nombre) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		

}
