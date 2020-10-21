package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ReProcesoAvaluoForm  extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6463649666171630291L;
	private String fechaEnvioInicio;
	private String fechaEnvioFin;
	private String errores;
	/**
	 * @return the fechaEnvioInicio
	 */
	public String getFechaEnvioInicio() {
		return fechaEnvioInicio;
	}
	/**
	 * @param fechaEnvioInicio the fechaEnvioInicio to set
	 */
	public void setFechaEnvioInicio(String fechaEnvioInicio) {
		this.fechaEnvioInicio = fechaEnvioInicio;
	}
	/**
	 * @return the fechaEnvioFin
	 */
	public String getFechaEnvioFin() {
		return fechaEnvioFin;
	}
	/**
	 * @param fechaEnvioFin the fechaEnvioFin to set
	 */
	public void setFechaEnvioFin(String fechaEnvioFin) {
		this.fechaEnvioFin = fechaEnvioFin;
	}
	/**
	 * @return the errores
	 */
	public String getErrores() {
		return errores;
	}
	/**
	 * @param errores the errores to set
	 */
	public void setErrores(String errores) {
		this.errores = errores;
	}

}
