package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class DetalleAvaluoForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5302636346441033324L;
	private String valorConcluidoInicio;
	private String valorConcluidoFin;
	private String metrosConstruccionInicio;
	private String metrosConstruccionFin;
	private String metrosTerrenoInicio;
	private String metrosTerrenoFin;
	private List<String> camposDetalleAvaluo;
	
	
	/**
	 * @return El valor de: camposDetalleAvaluo
	 */
	public List<String> getCamposDetalleAvaluo() {
		return camposDetalleAvaluo;
	}
	/**
	 * @param Valor: camposDetalleAvaluo a asignar en: camposDetalleAvaluo
	 */
	public void setCamposDetalleAvaluo(List<String> camposDetalleAvaluo) {
		this.camposDetalleAvaluo = camposDetalleAvaluo;
	}
	/**
	 * @return El valor de: valorConcluidoInicio
	 */
	public String getValorConcluidoInicio() {
		return valorConcluidoInicio;
	}
	/**
	 * @param Valor: valorConcluidoInicio a asignar en: valorConcluidoInicio
	 */
	public void setValorConcluidoInicio(String valorConcluidoInicio) {
		this.valorConcluidoInicio = valorConcluidoInicio;
	}
	/**
	 * @return El valor de: valorConcluidoFin
	 */
	public String getValorConcluidoFin() {
		return valorConcluidoFin;
	}
	/**
	 * @param Valor: valorConcluidoFin a asignar en: valorConcluidoFin
	 */
	public void setValorConcluidoFin(String valorConcluidoFin) {
		this.valorConcluidoFin = valorConcluidoFin;
	}
	/**
	 * @return El valor de: metrosConstruccionInicio
	 */
	public String getMetrosConstruccionInicio() {
		return metrosConstruccionInicio;
	}
	/**
	 * @param Valor: metrosConstruccionInicio a asignar en: metrosConstruccionInicio
	 */
	public void setMetrosConstruccionInicio(String metrosConstruccionInicio) {
		this.metrosConstruccionInicio = metrosConstruccionInicio;
	}
	/**
	 * @return El valor de: metrosConstruccionFin
	 */
	public String getMetrosConstruccionFin() {
		return metrosConstruccionFin;
	}
	/**
	 * @param Valor: metrosConstruccionFin a asignar en: metrosConstruccionFin
	 */
	public void setMetrosConstruccionFin(String metrosConstruccionFin) {
		this.metrosConstruccionFin = metrosConstruccionFin;
	}
	/**
	 * @return El valor de: metrosTerrenoInicio
	 */
	public String getMetrosTerrenoInicio() {
		return metrosTerrenoInicio;
	}
	/**
	 * @param Valor: metrosTerrenoInicio a asignar en: metrosTerrenoInicio
	 */
	public void setMetrosTerrenoInicio(String metrosTerrenoInicio) {
		this.metrosTerrenoInicio = metrosTerrenoInicio;
	}
	/**
	 * @return El valor de: metrosTerrenoFin
	 */
	public String getMetrosTerrenoFin() {
		return metrosTerrenoFin;
	}
	/**
	 * @param Valor: metrosTerrenoFin a asignar en: metrosTerrenoFin
	 */
	public void setMetrosTerrenoFin(String metrosTerrenoFin) {
		this.metrosTerrenoFin = metrosTerrenoFin;
	}
	/**
	 * @return El valor de: serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	
	
}
