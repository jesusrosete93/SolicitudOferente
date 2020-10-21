package mx.org.infonavit.solicitud.oferente.forms;


import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
public class ConsultaAvaluosForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9195332520728156836L;
	private UnidadValuacionForm unidadValuacion;
	private CoberturaForm cobertura;
	private ViviendaForm vivienda;
	private AvaluoForm avaluo;
	private DetalleAvaluoForm detalleAvaluo;
	private ControladorForm controlador;
	private PeritoForm perito;
	
	
	
	private String errores;
	
	/**
	 * @return El valor de: avaluo
	 */
	public AvaluoForm getAvaluo() {
		return avaluo;
	}
	/**
	 * @param Valor: avaluo a asignar en: avaluo
	 */
	public void setAvaluo(AvaluoForm avaluo) {
		this.avaluo = avaluo;
	}
	/**
	 * @return El valor de: unidadValuacion
	 */
	public UnidadValuacionForm getUnidadValuacion() {
		return unidadValuacion;
	}
	/**
	 * @param Valor: unidadValuacion a asignar en: unidadValuacion
	 */
	public void setUnidadValuacion(UnidadValuacionForm unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
	}
	/**
	 * @return El valor de: cobertura
	 */
	public CoberturaForm getCobertura() {
		return cobertura;
	}
	/**
	 * @param Valor: cobertura a asignar en: cobertura
	 */
	public void setCobertura(CoberturaForm cobertura) {
		this.cobertura = cobertura;
	}
	/**
	 * @return El valor de: controlador
	 */
	public ControladorForm getControlador() {
		return controlador;
	}
	/**
	 * @param Valor: controlador a asignar en: controlador
	 */
	public void setControlador(ControladorForm controlador) {
		this.controlador = controlador;
	}
	/**
	 * @return El valor de: perito
	 */
	public PeritoForm getPerito() {
		return perito;
	}
	/**
	 * @param Valor: perito a asignar en: perito
	 */
	public void setPerito(PeritoForm perito) {
		this.perito = perito;
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
	/**
	 * @return El valor de: vivienda
	 */
	public ViviendaForm getVivienda() {
		return vivienda;
	}
	/**
	 * @param Valor: vivienda a asignar en: vivienda
	 */
	public void setVivienda(ViviendaForm vivienda) {
		this.vivienda = vivienda;
	}
	/**
	 * @return El valor de: detalleAvaluo
	 */
	public DetalleAvaluoForm getDetalleAvaluo() {
		return detalleAvaluo;
	}
	/**
	 * @param Valor: detalleAvaluo a asignar en: detalleAvaluo
	 */
	public void setDetalleAvaluo(DetalleAvaluoForm detalleAvaluo) {
		this.detalleAvaluo = detalleAvaluo;
	}

}
