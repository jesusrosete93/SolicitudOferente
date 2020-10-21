package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un oferente del catalogo de oferentes en el SELAI</p>
 * @author Adrian Casas
 *
 */
public class OferenteDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6839775058770794587L;
	private String nombreRazonSocial;
	private String rfc;
	private String representanteLegal;
	private String curp;
	
	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}
	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getRepresentanteLegal() {
		return representanteLegal;
	}
	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	

}
