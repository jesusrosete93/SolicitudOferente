package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un registro de la tabla: cat_oferente</p>
 * @author Adrina Casas 
 *
 */
public class OferenteVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1201098900480125774L;
	private String nombreRazonSocial;
	private String rfc;
	private String representanteSocial;
	private String curp;
	
	
	
	
	public OferenteVo() {
		super();
	}
	public OferenteVo(String nombreRazonSocial, String rfc,
			String representanteSocial, String curp) {
		super();
		this.nombreRazonSocial = nombreRazonSocial;
		this.rfc = rfc;
		this.representanteSocial = representanteSocial;
		this.curp = curp;
	}
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
	public String getRepresentanteSocial() {
		return representanteSocial;
	}
	public void setRepresentanteSocial(String representanteSocial) {
		this.representanteSocial = representanteSocial;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	

}
