package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EnvioAvaluoForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2139327093117219399L;
	private String errores;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	
	
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}

}
