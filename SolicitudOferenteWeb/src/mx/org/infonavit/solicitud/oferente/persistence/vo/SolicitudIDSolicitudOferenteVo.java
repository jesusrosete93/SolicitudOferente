package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.util.Calendar;
import java.util.Date;

import mx.org.infonavit.solicitud.oferente.test.Solicitud;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class SolicitudIDSolicitudOferenteVo extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String anio;

	private String id_estado;
	private String id_tipo_solicitud;
	private String consecutivo;
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getId_estado() {
		return id_estado;
	}
	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}
	public String getId_tipo_solicitud() {
		return id_tipo_solicitud;
	}
	public void setId_tipo_solicitud(String id_tipo_solicitud) {
		this.id_tipo_solicitud = id_tipo_solicitud;
	}
	public String getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}


	
	




	

	
	
	
	
	
	
	

}
