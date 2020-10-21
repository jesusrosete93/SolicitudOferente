package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAsignacionesForm;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosAsignacionesDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312903803378220349L;
	private String paquete;
	private String unidadValuacion;
	private String frente;
	private String rfcOferente;
	private String fechaAsignacionInicio;
	private String fechaAsignacionFin;
	private String estado;
	private String unidadValuacionAnterior;
	private String fechaReAsignacionInicio;
	private String fechaReAsignacionFin;
	private String tipoReasignacion;
	
	
	
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
	 * @return El valor de: frente
	 */
	public String getFrente() {
		return frente;
	}
	/**
	 * @param Valor: frente a asignar en: frente
	 */
	public void setFrente(String frente) {
		this.frente = frente;
	}
	/**
	 * @return El valor de: rfcOferente
	 */
	public String getRfcOferente() {
		return rfcOferente;
	}
	/**
	 * @param Valor: rfcOferente a asignar en: rfcOferente
	 */
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	/**
	 * @return El valor de: fechaAsignacionInicio
	 */
	public String getFechaAsignacionInicio() {
		return fechaAsignacionInicio;
	}
	/**
	 * @param Valor: fechaAsignacionInicio a asignar en: fechaAsignacionInicio
	 */
	public void setFechaAsignacionInicio(String fechaAsignacionInicio) {
		this.fechaAsignacionInicio = fechaAsignacionInicio;
	}
	/**
	 * @return El valor de: fechaAsignacionFin
	 */
	public String getFechaAsignacionFin() {
		return fechaAsignacionFin;
	}
	/**
	 * @param Valor: fechaAsignacionFin a asignar en: fechaAsignacionFin
	 */
	public void setFechaAsignacionFin(String fechaAsignacionFin) {
		this.fechaAsignacionFin = fechaAsignacionFin;
	}
	/**
	 * @return El valor de: estado
	 */
	public String getEstado() {
		
		String cadena = "";
		
		if( this.estado!=null && !this.estado.trim().equals(""))
		{
			if( Integer.parseInt(this.estado)>=1 && Integer.parseInt(this.estado)<=9)
			{
				cadena = "0"+this.estado+"000";
			}
			if( Integer.parseInt(this.estado)>=10 && Integer.parseInt(this.estado)<=32)
			{
				cadena = this.estado+"000";
			}
			return cadena;
		}else
		{
			return "";
		}
	}
	/**
	 * @param Valor: estado a asignar en: estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return El valor de: unidadValuacionAnterior
	 */
	public String getUnidadValuacionAnterior() {
		return unidadValuacionAnterior;
	}
	/**
	 * @param Valor: unidadValuacionAnterior a asignar en: unidadValuacionAnterior
	 */
	public void setUnidadValuacionAnterior(String unidadValuacionAnterior) {
		this.unidadValuacionAnterior = unidadValuacionAnterior;
	}
	/**
	 * @return El valor de: fechaReAsignacionInicio
	 */
	public String getFechaReAsignacionInicio() {
		return fechaReAsignacionInicio;
	}
	/**
	 * @param Valor: fechaReAsignacionInicio a asignar en: fechaReAsignacionInicio
	 */
	public void setFechaReAsignacionInicio(String fechaReAsignacionInicio) {
		this.fechaReAsignacionInicio = fechaReAsignacionInicio;
	}
	/**
	 * @return El valor de: fechaReAsignacionFin
	 */
	public String getFechaReAsignacionFin() {
		return fechaReAsignacionFin;
	}
	/**
	 * @param Valor: fechaReAsignacionFin a asignar en: fechaReAsignacionFin
	 */
	public void setFechaReAsignacionFin(String fechaReAsignacionFin) {
		this.fechaReAsignacionFin = fechaReAsignacionFin;
	}
	/**
	 * @return El valor de: tipoReasignacion
	 */
	public String getTipoReasignacion() {
		return tipoReasignacion;
	}
	/**
	 * @param Valor: tipoReasignacion a asignar en: tipoReasignacion
	 */
	public void setTipoReasignacion(String tipoReasignacion) {
		this.tipoReasignacion = tipoReasignacion;
	}
	
	
	public static CriteriosAsignacionesDomain getObjetoDomain(ConsultaAsignacionesForm forma)
	{
		CriteriosAsignacionesDomain domain = new CriteriosAsignacionesDomain();
		
		domain.setPaquete(forma.getPaquete());
		domain.setUnidadValuacion(forma.getClaveUnidadValuacion().trim().equals("-1")?"":forma.getClaveUnidadValuacion().trim());
		domain.setFrente(forma.getNombreFrente());
		domain.setRfcOferente(forma.getRfcOferente());
		domain.setFechaAsignacionInicio(forma.getFechaAsignacionInicio());
		domain.setFechaAsignacionFin(forma.getFechaAsignacionFin());
		domain.setEstado(String.valueOf(forma.getClaveEstado()<0?"":forma.getClaveEstado()));
		domain.setUnidadValuacionAnterior(forma.getClaveUnidadValuacionAnterior().trim().equals("-1")?"":forma.getClaveUnidadValuacionAnterior().trim());
		domain.setFechaReAsignacionInicio(forma.getFechaReasignacionInicio());
		domain.setFechaReAsignacionFin(forma.getFechaReasignacionFin());
		domain.setTipoReasignacion(String.valueOf(forma.getTipoReasignacion()<0?"":forma.getTipoReasignacion()));
		
		return domain;
		
		
	}

}
