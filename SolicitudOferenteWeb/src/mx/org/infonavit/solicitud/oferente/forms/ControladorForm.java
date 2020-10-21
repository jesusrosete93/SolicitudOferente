package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ControladorForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7329612031898134434L;
	private String claveSHF;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String curp;
	private String rfc;
	private String fechaVigenciaInicio;
	private String fechaVigenciaFin;
	private int	   estatusControlador;
	private List<String> camposControlador;
	/**
	 * @return El valor de: claveSHF
	 */
	public String getClaveSHF() {
		return claveSHF;
	}
	/**
	 * @param Valor: claveSHF a asignar en: claveSHF
	 */
	public void setClaveSHF(String claveSHF) {
		this.claveSHF = claveSHF;
	}
	/**
	 * @return El valor de: nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param Valor: nombre a asignar en: nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return El valor de: apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @param Valor: apellidoPaterno a asignar en: apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * @return El valor de: apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param Valor: apellidoMaterno a asignar en: apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return El valor de: curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param Valor: curp a asignar en: curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return El valor de: rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param Valor: rfc a asignar en: rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return El valor de: fechaVigenciaInicio
	 */
	public String getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}
	/**
	 * @param Valor: fechaVigenciaInicio a asignar en: fechaVigenciaInicio
	 */
	public void setFechaVigenciaInicio(String fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}
	/**
	 * @return El valor de: fechaVigenciaFin
	 */
	public String getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}
	/**
	 * @param Valor: fechaVigenciaFin a asignar en: fechaVigenciaFin
	 */
	public void setFechaVigenciaFin(String fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}
	/**
	 * @return El valor de: estatusControlador
	 */
	public int getEstatusControlador() {
		return estatusControlador;
	}
	/**
	 * @param Valor: estatusControlador a asignar en: estatusControlador
	 */
	public void setEstatusControlador(int estatusControlador) {
		this.estatusControlador = estatusControlador;
	}
	/**
	 * @return El valor de: camposControlador
	 */
	public List<String> getCamposControlador() {
		return camposControlador;
	}
	/**
	 * @param Valor: camposControlador a asignar en: camposControlador
	 */
	public void setCamposControlador(List<String> camposControlador) {
		this.camposControlador = camposControlador;
	}

}
