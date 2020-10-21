package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ViviendaForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5302636346441033324L;
	private String nss;
	private String codigoPostal;
	private List<String> camposVivienda;
	
	
	/**
	 * @return El valor de: nss
	 */
	public String getNss() {
		return nss;
	}
	/**
	 * @param Valor: nss a asignar en: nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	/**
	 * @return El valor de: codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param Valor: codigoPostal a asignar en: codigoPostal
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return El valor de: camposVivienda
	 */
	public List<String> getCamposVivienda() {
		return camposVivienda;
	}
	/**
	 * @param Valor: camposVivienda a asignar en: camposVivienda
	 */
	public void setCamposVivienda(List<String> camposVivienda) {
		this.camposVivienda = camposVivienda;
	}

}
