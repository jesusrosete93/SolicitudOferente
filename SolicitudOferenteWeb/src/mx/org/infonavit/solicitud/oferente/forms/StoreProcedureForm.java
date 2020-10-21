package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class StoreProcedureForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errores;
	private String fechaInicio;
	private String fechaFin;
	private String numeroAvaluo;
	
	
	
	/**
	 * @return El valor de: fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param Valor: fechaInicio a asignar en: fechaInicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return El valor de: fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param Valor: fechaFin a asignar en: fechaFin
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return El valor de: numeroAvaluo
	 */
	public String getNumeroAvaluo() {
		return numeroAvaluo;
	}
	/**
	 * @param Valor: numeroAvaluo a asignar en: numeroAvaluo
	 */
	public void setNumeroAvaluo(String numeroAvaluo) {
		this.numeroAvaluo = numeroAvaluo;
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
