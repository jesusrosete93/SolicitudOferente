package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaUPCForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3135582902747345071L;
	private UnidadValuacionForm unidadValuacionForm;
	private CoberturaForm coberturaForm;
	private ControladorForm controladorForm;
	private PeritoForm peritoForm;
	private String errores;
	/**
	 * @return El valor de: unidadValuacionForm
	 */
	public UnidadValuacionForm getUnidadValuacionForm() {
		return unidadValuacionForm;
	}
	/**
	 * @param Valor: unidadValuacionForm a asignar en: unidadValuacionForm
	 */
	public void setUnidadValuacionForm(UnidadValuacionForm unidadValuacionForm) {
		this.unidadValuacionForm = unidadValuacionForm;
	}
	/**
	 * @return El valor de: coberturaForm
	 */
	public CoberturaForm getCoberturaForm() {
		return coberturaForm;
	}
	/**
	 * @param Valor: coberturaForm a asignar en: coberturaForm
	 */
	public void setCoberturaForm(CoberturaForm coberturaForm) {
		this.coberturaForm = coberturaForm;
	}
	/**
	 * @return El valor de: controladorForm
	 */
	public ControladorForm getControladorForm() {
		return controladorForm;
	}
	/**
	 * @param Valor: controladorForm a asignar en: controladorForm
	 */
	public void setControladorForm(ControladorForm controladorForm) {
		this.controladorForm = controladorForm;
	}
	/**
	 * @return El valor de: peritoForm
	 */
	public PeritoForm getPeritoForm() {
		return peritoForm;
	}
	/**
	 * @param Valor: peritoForm a asignar en: peritoForm
	 */
	public void setPeritoForm(PeritoForm peritoForm) {
		this.peritoForm = peritoForm;
	}
	/**
	 * @return El valor de: errores
	 */
	public String getErrores() {
		return errores;
	}
	/**
	 * @param Valor: errores a asignar en: errores
	 */
	public void setErrores(String errores) {
		this.errores = errores;
	}

}
