package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class TablaBdVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324918547805806340L;
	
	private int idTabla;
	private String nombre;
	private String etiqueta;
	private String alias;
	private String descripcion;
	
	
	public TablaBdVo() {
		super();
	}
	
	
	public TablaBdVo(int idTabla, String nombre, String etiqueta, String alias,
			String descripcion) {
		super();
		this.idTabla = idTabla;
		this.nombre = nombre;
		this.etiqueta = etiqueta;
		this.alias = alias;
		this.descripcion = descripcion;
	}
	/**
	 * @return El valor de: idTabla
	 */
	public int getIdTabla() {
		return idTabla;
	}
	/**
	 * @param Valor: idTabla a asignar en: idTabla
	 */
	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
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
	/**
	 * @return El valor de: etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}
	/**
	 * @param Valor: etiqueta a asignar en: etiqueta
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	/**
	 * @return El valor de: alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param Valor: alias a asignar en: alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
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
