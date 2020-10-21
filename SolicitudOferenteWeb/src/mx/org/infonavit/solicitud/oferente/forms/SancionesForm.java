package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class SancionesForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1060376356094731526L;
	private String errores;
	private List<String> camposSancion;
	private String fechaSancionInicio;
	private String fechaSancionFin;
	private int tipoSancion;
	private int sancionado;
	private int estatusSancion;
	
	
	
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
	 * @return El valor de: campos
	 */
	public List<String> getCamposSancion() {
		return camposSancion;
	}
	/**
	 * @param Valor: campos a asignar en: campos
	 */
	public void setCamposSancion(List<String> campos) {
		this.camposSancion = campos;
	}
	/**
	 * @return El valor de: fechaSancionInicio
	 */
	public String getFechaSancionInicio() {
		return fechaSancionInicio;
	}
	/**
	 * @param Valor: fechaSancionInicio a asignar en: fechaSancionInicio
	 */
	public void setFechaSancionInicio(String fechaSancionInicio) {
		this.fechaSancionInicio = fechaSancionInicio;
	}
	/**
	 * @return El valor de: fechaSancionFin
	 */
	public String getFechaSancionFin() {
		return fechaSancionFin;
	}
	/**
	 * @param Valor: fechaSancionFin a asignar en: fechaSancionFin
	 */
	public void setFechaSancionFin(String fechaSancionFin) {
		this.fechaSancionFin = fechaSancionFin;
	}
	/**
	 * @return El valor de: tipoSancion
	 */
	public int getTipoSancion() {
		return tipoSancion;
	}
	/**
	 * @param Valor: tipoSancion a asignar en: tipoSancion
	 */
	public void setTipoSancion(int tipoSancion) {
		this.tipoSancion = tipoSancion;
	}
	/**
	 * @return El valor de: sancionado
	 */
	public int getSancionado() {
		return sancionado;
	}
	/**
	 * @param Valor: sancionado a asignar en: sancionado
	 */
	public void setSancionado(int sancionado) {
		this.sancionado = sancionado;
	}
	/**
	 * @return El valor de: estatusSancion
	 */
	public int getEstatusSancion() {
		return estatusSancion;
	}
	/**
	 * @param Valor: estatusSancion a asignar en: estatusSancion
	 */
	public void setEstatusSancion(int estatusSancion) {
		this.estatusSancion = estatusSancion;
	}

}
