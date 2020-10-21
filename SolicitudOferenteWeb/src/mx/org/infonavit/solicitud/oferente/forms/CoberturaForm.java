package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CoberturaForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2441035580768424695L;
	private List<String> estados;
	private int estatus;
	private List<String> camposCobertura;
	
	/**
	 * @return El valor de: estado
	 */
	public List<String> getEstados() {
		return estados;
	}
	/**
	 * @param Valor: estado a asignar en: estado
	 */
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	/**
	 * @return El valor de: estatus
	 */
	public int getEstatus() {
		return estatus;
	}
	/**
	 * @param Valor: estatus a asignar en: estatus
	 */
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return El valor de: camposCobertura
	 */
	public List<String> getCamposCobertura() {
		return camposCobertura;
	}
	/**
	 * @param Valor: camposCobertura a asignar en: camposCobertura
	 */
	public void setCamposCobertura(List<String> camposCobertura) {
		this.camposCobertura = camposCobertura;
	}
	
}
