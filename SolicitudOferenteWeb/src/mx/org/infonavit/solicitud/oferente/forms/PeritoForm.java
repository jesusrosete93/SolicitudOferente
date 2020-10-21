package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class PeritoForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8667373650216264620L;
	private String claveSHF;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String curp;
	private String rfc;
	private String fechaVigenciaInicio;
	private String fechaVigenciaFin;
	private int	   estatusPerito;
	private List<String> camposPerito;
	
	
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
	 * @return El valor de: estatusPerito
	 */
	public int getEstatusPerito() {
		return estatusPerito;
	}
	/**
	 * @param Valor: estatusPerito a asignar en: estatusPerito
	 */
	public void setEstatusPerito(int estatusPerito) {
		this.estatusPerito = estatusPerito;
	}
	/**
	 * @return El valor de: camposPerito
	 */
	public List<String> getCamposPerito() {
		return camposPerito;
	}
	/**
	 * @param Valor: camposPerito a asignar en: camposPerito
	 */
	public void setCamposPerito(List<String> camposPerito) {
		this.camposPerito = camposPerito;
	}

}
