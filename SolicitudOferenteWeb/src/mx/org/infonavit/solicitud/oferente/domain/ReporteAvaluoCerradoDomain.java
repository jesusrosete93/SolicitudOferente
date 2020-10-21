package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ReporteAvaluoCerradoDomain extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7797397304121003295L;
	private String estado;
	private String unidadValuacion;
	private int cerradosPaquete;
	private int cerradosMercadoAbierto;
	private String unidadTiempo;
	private int anio;
	private int mes;
	private String nombreMes;
	private int dia;
	private int hora;
	
	
	
	/**
	 * @return El valor de: mes
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * @param Valor: mes a asignar en: mes
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * @return El valor de: dia
	 */
	public int getDia() {
		return dia;
	}
	/**
	 * @param Valor: dia a asignar en: dia
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}
	/**
	 * @return El valor de: hora
	 */
	public int getHora() {
		return hora;
	}
	/**
	 * @param Valor: hora a asignar en: hora
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}
	/**
	 * @return El valor de: estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param Valor: estado a asignar en: estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return El valor de: cerradosPaquete
	 */
	public int getCerradosPaquete() {
		return cerradosPaquete;
	}
	/**
	 * @param Valor: cerradosPaquete a asignar en: cerradosPaquete
	 */
	public void setCerradosPaquete(int cerradosPaquete) {
		this.cerradosPaquete = cerradosPaquete;
	}
	/**
	 * @return El valor de: cerradosMercadoAbierto
	 */
	public int getCerradosMercadoAbierto() {
		return cerradosMercadoAbierto;
	}
	/**
	 * @param Valor: cerradosMercadoAbierto a asignar en: cerradosMercadoAbierto
	 */
	public void setCerradosMercadoAbierto(int cerradosMercadoAbierto) {
		this.cerradosMercadoAbierto = cerradosMercadoAbierto;
	}
	/**
	 * @return El valor de: unidadTiempo
	 */
	public String getUnidadTiempo() {
		return unidadTiempo;
	}
	/**
	 * @param Valor: unidadTiempo a asignar en: unidadTiempo
	 */
	public void setUnidadTiempo(String unidadTiempo) {
		this.unidadTiempo = unidadTiempo;
	}
	/**
	 * @return El valor de: anio
	 */
	public int getAnio() {
		return anio;
	}
	/**
	 * @param Valor: anio a asignar en: anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}
	/**
	 * @return El valor de: unidadValuacion
	 */
	public String getUnidadValuacion() {
		return unidadValuacion;
	}
	/**
	 * @param Valor: unidadValuacion a asignar en: unidadValuacion
	 */
	public void setUnidadValuacion(String unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
	}
	/**
	 * @return El valor de: nombreMes
	 */
	public String getNombreMes() {
		return nombreMes;
	}
	/**
	 * @param Valor: nombreMes a asignar en: nombreMes
	 */
	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}

}
