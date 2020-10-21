package mx.org.infonavit.solicitud.oferente.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class SpBuscar05ResultadosVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3957043497655503681L;
	private String fechaInicio;
	private String fechaFin;
	private String parametro;
	
	
	public SpBuscar05ResultadosVo() {
		super();
	}
	
	
	public SpBuscar05ResultadosVo(String fechaInicio, String fechaFin,
			String parametro) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.parametro = parametro;
	}
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
	 * @return El valor de: parametro
	 */
	public String getParametro() {
		return parametro;
	}
	/**
	 * @param Valor: parametro a asignar en: parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

}
