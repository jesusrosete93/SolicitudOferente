package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class PaqueteEcoDomain extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int paquete;
	private int oferta;
	private int idVivienda;
	
	
	public int getPaquete() {
		return paquete;
	}
	public void setPaquete(int paquete) {
		this.paquete = paquete;
	}
	public int getOferta() {
		return oferta;
	}
	public void setOferta(int oferta) {
		this.oferta = oferta;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	
	
	

}
