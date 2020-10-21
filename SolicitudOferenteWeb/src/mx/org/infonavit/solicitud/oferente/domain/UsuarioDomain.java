package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class UsuarioDomain extends GenericValueObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -538824050184790965L;
	private String idUsuario;
	private String nombre;
	
	
	/**
	 * @return El valor de: idUsuario
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param Valor: idUsuario a asignar en: idUsuario
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return El valor de: nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param Valor: nombre a asignar en: nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
