package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * Representa el formulario que contiene
 * los parametros de entrada por los cuales se 
 * puede ejecutar una busqueda de avaluos 
 * clasificados como subvaluados.
 * @author Adrian Casas Avansis Desarrollos SA de CV
 *
 */
public class ConsultaAvaluoSubValuadoForm extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7783653127068911031L;
	private String errores;
	private String idAvaluo;
	private String idPaquete;
	private int    idVivienda;
	private int    idUnidadValuacion;
	private int    bandera;
	private String codigoPostal;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	/**
	 * @return El valor de: idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}
	/**
	 * @param Valor: idAvaluo a asignar en: idAvaluo
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	/**
	 * @return El valor de: idPaquete
	 */
	public String getIdPaquete() {
		return idPaquete;
	}
	/**
	 * @param Valor: idPaquete a asignar en: idPaquete
	 */
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	/**
	 * @return El valor de: idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}
	/**
	 * @param Valor: idVivienda a asignar en: idVivienda
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	/**
	 * @return El valor de: idUnidadValuacion
	 */
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	/**
	 * @param Valor: idUnidadValuacion a asignar en: idUnidadValuacion
	 */
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	/**
	 * @return El valor de: bandera
	 */
	public int getBandera() {
		return bandera;
	}
	/**
	 * @param Valor: bandera a asignar en: bandera
	 */
	public void setBandera(int bandera) {
		this.bandera = bandera;
	}
	/**
	 * @return El valor de: codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param Valor: codigoPostal a asignar en: codigoPostal
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return El valor de: fechaCierreInicio
	 */
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}
	/**
	 * @param Valor: fechaCierreInicio a asignar en: fechaCierreInicio
	 */
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}
	/**
	 * @return El valor de: fechaCierreFin
	 */
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}
	/**
	 * @param Valor: fechaCierreFin a asignar en: fechaCierreFin
	 */
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
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
