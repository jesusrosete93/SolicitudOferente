package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class MesDatoVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2646397085626401816L;
	String dia;
	String cantidadPaquete;
	String cantidadMai;
	
	
	
	
	public MesDatoVo() {
		super();
	}
	
	public MesDatoVo(String dia, String cantidadPaquete, String cantidadMai) {
		super();
		this.dia = dia;
		this.cantidadPaquete = cantidadPaquete;
		this.cantidadMai = cantidadMai;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getCantidadPaquete() {
		return cantidadPaquete;
	}
	public void setCantidadPaquete(String cantidadPaquete) {
		this.cantidadPaquete = cantidadPaquete;
	}
	public String getCantidadMai() {
		return cantidadMai;
	}
	public void setCantidadMai(String cantidadMai) {
		this.cantidadMai = cantidadMai;
	}
		
	
}
