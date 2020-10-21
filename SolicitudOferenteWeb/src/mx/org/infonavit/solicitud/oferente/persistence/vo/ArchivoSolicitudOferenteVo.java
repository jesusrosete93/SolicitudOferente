package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.util.Calendar;
import java.util.Date;

import mx.org.infonavit.solicitud.oferente.test.Solicitud;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ArchivoSolicitudOferenteVo extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id_solicitud;
	private String id_oferente;
	private String fecha_alta;
	private String nombre_archivo;
	private String archivo;
	private String tipo_archivo;
	public String getId_solicitud() {
		return id_solicitud;
	}
	public void setId_solicitud(String id_solicitud) {
		this.id_solicitud = id_solicitud;
	}
	public String getId_oferente() {
		return id_oferente;
	}
	public void setId_oferente(String id_oferente) {
		this.id_oferente = id_oferente;
	}
	public String getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getTipo_archivo() {
		return tipo_archivo;
	}
	public void setTipo_archivo(String tipo_archivo) {
		this.tipo_archivo = tipo_archivo;
	}
	
	
	
	
	
	
	
	
	

}
