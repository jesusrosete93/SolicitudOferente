package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;



public class ReporteInexUvPaqueteForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3310881838197030107L;
	private String errores;
	private String paquete;
	private String idOferente;
	private String rfcOferente;
	
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getIdOferente() {
		return idOferente;
	}
	public void setIdOferente(String idOferente) {
		this.idOferente = idOferente;
	}
	public String getRfcOferente() {
		return rfcOferente;
	}
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	
	
	
}
