package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>
 * 	Clase que encapsula el formulario que se muestra para la consulta de paquetes Inex.
 * </p>
 * @author Adrian Casas
 */
public class PaquetesForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5305337519853209933L;
	
	private int idUnidadValuacion;
	private String rfcOferente;
	private int idEstado;
	private String paquete;
	private int tipoPaquete;
	private List<String> camposPaquetes;
	private List<String> camposOferente;
	private String errores;
	
	
	
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	public String getRfcOferente() {
		return rfcOferente;
	}
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public int getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(int tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	public List<String> getCamposPaquetes() {
		return camposPaquetes;
	}
	public void setCamposPaquetes(List<String> camposPaquetes) {
		this.camposPaquetes = camposPaquetes;
	}
	public List<String> getCamposOferente() {
		return camposOferente;
	}
	public void setCamposOferente(List<String> camposOferente) {
		this.camposOferente = camposOferente;
	}
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}

}
