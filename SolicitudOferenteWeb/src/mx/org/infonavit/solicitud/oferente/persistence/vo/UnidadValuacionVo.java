package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;


public class UnidadValuacionVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2930416220287458037L;
	private int idUnidadValuacion;
	private String nombreUnidadValuacion;
	private int estatus;
	
	public UnidadValuacionVo() {
		super();
	}
	
	public UnidadValuacionVo(int idUnidadValuacion,String nombreUnidadValuacion,int estatus) {
		super();
		this.idUnidadValuacion = idUnidadValuacion;
		this.nombreUnidadValuacion = nombreUnidadValuacion;
		this.estatus=estatus;
	}
	/**
	 * @return El valor de: idUnidadValuacion
	 */
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	/**
	 * @param Valor: idUnidadValuacion a asignar en: idUnidadValuacion
	 */
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	/**
	 * @return El valor de: nombreUnidadValuacion
	 */
	public String getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}
	/**
	 * @param Valor: nombreUnidadValuacion a asignar en: nombreUnidadValuacion
	 */
	public void setNombreUnidadValuacion(String nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	
	

}
