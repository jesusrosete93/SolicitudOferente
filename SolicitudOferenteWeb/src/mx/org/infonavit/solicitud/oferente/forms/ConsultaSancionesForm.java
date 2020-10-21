package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ConsultaSancionesForm extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7152098590937916602L;
	private String errores;
	private UnidadValuacionForm unidad;
	private CoberturaForm cobertura;
	private ControladorForm controlador;
	private PeritoForm perito;
	private SancionesForm sancion;
	
	
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
	 * @return El valor de: unidad
	 */
	public UnidadValuacionForm getUnidad() {
		return unidad;
	}
	/**
	 * @param Valor: unidad a asignar en: unidad
	 */
	public void setUnidad(UnidadValuacionForm unidad) {
		this.unidad = unidad;
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
	 * @return El valor de: sancion
	 */
	public SancionesForm getSancion() {
		return sancion;
	}
	/**
	 * @param Valor: sancion a asignar en: sancion
	 */
	public void setSancion(SancionesForm sancion) {
		this.sancion = sancion;
	}
	
	
	

}
