package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * 
 * @author adrian.casas
 *
 */
public class UnidadValuacionDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5676539738634263379L;
	private int idUnidadValuacion;
	private String nombreUnidad;
	private int estatus;
	private String descripcionEstatus;
	private String rfc;
	private String siglas;
	private String claveShf;
	
	public UnidadValuacionDomain() {
		super();
	}
	
	public UnidadValuacionDomain(int idUnidadValuacion, String nombreUnidad) {
		super();
		this.idUnidadValuacion = idUnidadValuacion;
		this.nombreUnidad = nombreUnidad;
	}



	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public String getClaveShf() {
		return claveShf;
	}
	public void setClaveShf(String claveShf) {
		this.claveShf = claveShf;
	}

}
