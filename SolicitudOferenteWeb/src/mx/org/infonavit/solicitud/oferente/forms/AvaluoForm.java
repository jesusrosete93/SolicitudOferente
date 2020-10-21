package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

import java.lang.String;
import java.util.List;

public class AvaluoForm extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4687361940250234691L;
	private String idAvaluo;
	private String idConviviencia;
	private String paquete;
	private int viviendaInicio;
	private int viviendaFin;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int estatusAvaluo;
	private int tipoMercado;
	private List<String> estados;
	private String errores;
	private List<String> camposAvaluos;
	
	
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
	 * @return El valor de: idConviviencia
	 */
	public String getIdConviviencia() {
		return idConviviencia;
	}
	/**
	 * @param Valor: idConviviencia a asignar en: idConviviencia
	 */
	public void setIdConviviencia(String idConviviencia) {
		this.idConviviencia = idConviviencia;
	}
	/**
	 * @return El valor de: paquete
	 */
	public String getPaquete() {
		return paquete;
	}
	/**
	 * @param Valor: paquete a asignar en: paquete
	 */
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	/**
	 * @return El valor de: viviendaInicio
	 */
	public int getViviendaInicio() {
		return viviendaInicio;
	}
	/**
	 * @param Valor: viviendaInicio a asignar en: viviendaInicio
	 */
	public void setViviendaInicio(int viviendaInicio) {
		this.viviendaInicio = viviendaInicio;
	}
	/**
	 * @return El valor de: viviendaFin
	 */
	public int getViviendaFin() {
		return viviendaFin;
	}
	/**
	 * @param Valor: viviendaFin a asignar en: viviendaFin
	 */
	public void setViviendaFin(int viviendaFin) {
		this.viviendaFin = viviendaFin;
	}
	
	/**
	 * @return El valor de: fechaSolicitudInicio
	 */
	public String getFechaSolicitudInicio() {
		return fechaSolicitudInicio;
	}
	/**
	 * @param Valor: fechaSolicitudInicio a asignar en: fechaSolicitudInicio
	 */
	public void setFechaSolicitudInicio(String fechaSolicitudInicio) {
		this.fechaSolicitudInicio = fechaSolicitudInicio;
	}
	/**
	 * @return El valor de: fechaSolicitudFin
	 */
	public String getFechaSolicitudFin() {
		return fechaSolicitudFin;
	}
	/**
	 * @param Valor: fechaSolicitudFin a asignar en: fechaSolicitudFin
	 */
	public void setFechaSolicitudFin(String fechaSolicitudFin) {
		this.fechaSolicitudFin = fechaSolicitudFin;
	}
	/**
	 * @return El valor de: estatusAvaluo
	 */
	public int getEstatusAvaluo() {
		return estatusAvaluo;
	}
	/**
	 * @param Valor: estatusAvaluo a asignar en: estatusAvaluo
	 */
	public void setEstatusAvaluo(int estatusAvaluo) {
		this.estatusAvaluo = estatusAvaluo;
	}
	/**
	 * @return El valor de: tipoMercado
	 */
	public int getTipoMercado() {
		return tipoMercado;
	}
	/**
	 * @param Valor: tipoMercado a asignar en: tipoMercado
	 */
	public void setTipoMercado(int tipoMercado) {
		this.tipoMercado = tipoMercado;
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
	 * @return El valor de: camposAvaluos
	 */
	public List<String> getCamposAvaluos() {
		return camposAvaluos;
	}
	/**
	 * @param Valor: camposAvaluos a asignar en: camposAvaluos
	 */
	public void setCamposAvaluos(List<String> camposAvaluos) {
		this.camposAvaluos = camposAvaluos;
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
	 * @return El valor de: estados
	 */
	public List<String> getEstados() {
		return estados;
	}
	/**
	 * @param Valor: estados a asignar en: estados
	 */
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	
	
	

}
