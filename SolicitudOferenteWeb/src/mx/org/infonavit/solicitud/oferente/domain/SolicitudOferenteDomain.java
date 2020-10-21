package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class SolicitudOferenteDomain extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id_solicitud;
	private String tipo_linea;
	private String fecha_solicitud;
	private String fecha_respuesta;
	private String id_tipo_solicitud;
	private String id_estatus;
	private String id_estado;
	private String id_oferente;
	private String rfc_oferente;
	private String nombre_razon_social;
	private String id_oferta_vivienda;
	private String id_orden_verificacion;
	private String nombre_frente;
	private String num_viviendas;
	private String id_paquete;
	private String id_modificacion;
	private String num_viviendas_declinacion_modificacion;
	private String comentarios;
	private String id_programa;
	
	private String id_documento;
	private String fecha_alta;
	private String nombre_archivo;
	private String archivo;
	private String tipo_archivo;
	
	
	
	


	public SolicitudOferenteDomain(String id_solicitud, String id_tipo_solicitud,String fecha_solicitud,
			 String id_oferente,String nombre_razon_social,String id_estado,String id_paquete,String id_oferta_vivienda,String id_estatus) {
		super();
		this.id_solicitud = id_solicitud;
		this.id_tipo_solicitud = id_tipo_solicitud;
		this.fecha_solicitud = fecha_solicitud;
		this.id_oferente = id_oferente;
		this.nombre_razon_social = nombre_razon_social;
		this.id_estado = id_estado;
		this.id_paquete = id_paquete;
		this.id_oferta_vivienda = id_oferta_vivienda;
		this.id_estatus = id_estatus;
	}


	public SolicitudOferenteDomain( String id_solicitud,
			String tipo_linea, String fecha_solicitud, String fecha_respuesta,
			String id_tipo_solicitud, String id_estatus, String id_estado,
			String id_oferente, String rfc_oferente,
			String nombre_razon_social, String id_oferta_vivienda,
			String id_orden_verificacion, String nombre_frente,
			String num_viviendas, String id_paquete, String id_modificacion,
			String num_viviendas_declinacion_modificacion, String comentarios,
			String id_programa, String id_documento, String fecha_alta,
			String nombre_archivo, String archivo, String tipo_archivo) {
		super();
		
		this.id_solicitud = id_solicitud;
		this.tipo_linea = tipo_linea;
		this.fecha_solicitud = fecha_solicitud;
		this.fecha_respuesta = fecha_respuesta;
		this.id_tipo_solicitud = id_tipo_solicitud;
		this.id_estatus = id_estatus;
		this.id_estado = id_estado;
		this.id_oferente = id_oferente;
		this.rfc_oferente = rfc_oferente;
		this.nombre_razon_social = nombre_razon_social;
		this.id_oferta_vivienda = id_oferta_vivienda;
		this.id_orden_verificacion = id_orden_verificacion;
		this.nombre_frente = nombre_frente;
		this.num_viviendas = num_viviendas;
		this.id_paquete = id_paquete;
		this.id_modificacion = id_modificacion;
		this.num_viviendas_declinacion_modificacion = num_viviendas_declinacion_modificacion;
		this.comentarios = comentarios;
		this.id_programa = id_programa;
		this.id_documento = id_documento;
		this.fecha_alta = fecha_alta;
		this.nombre_archivo = nombre_archivo;
		this.archivo = archivo;
		this.tipo_archivo = tipo_archivo;
	}


	public SolicitudOferenteDomain() {
		// TODO Apéndice de constructor generado automáticamente
	}




	public String getId_solicitud() {
		return id_solicitud;
	}


	public void setId_solicitud(String id_solicitud) {
		this.id_solicitud = id_solicitud;
	}


	public String getTipo_linea() {
		return tipo_linea;
	}


	public void setTipo_linea(String tipo_linea) {
		this.tipo_linea = tipo_linea;
	}


	public String getFecha_solicitud() {
		return fecha_solicitud;
	}


	public void setFecha_solicitud(String fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}


	public String getFecha_respuesta() {
		return fecha_respuesta;
	}


	public void setFecha_respuesta(String fecha_respuesta) {
		this.fecha_respuesta = fecha_respuesta;
	}


	public String getId_tipo_solicitud() {
		return id_tipo_solicitud;
	}


	public void setId_tipo_solicitud(String id_tipo_solicitud) {
		this.id_tipo_solicitud = id_tipo_solicitud;
	}


	public String getId_estatus() {
		return id_estatus;
	}


	public void setId_estatus(String id_estatus) {
		this.id_estatus = id_estatus;
	}


	public String getId_estado() {
		return id_estado;
	}


	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}


	public String getId_oferente() {
		return id_oferente;
	}


	public void setId_oferente(String id_oferente) {
		this.id_oferente = id_oferente;
	}


	public String getRfc_oferente() {
		return rfc_oferente;
	}


	public void setRfc_oferente(String rfc_oferente) {
		this.rfc_oferente = rfc_oferente;
	}


	public String getNombre_razon_social() {
		return nombre_razon_social;
	}


	public void setNombre_razon_social(String nombre_razon_social) {
		this.nombre_razon_social = nombre_razon_social;
	}


	public String getId_oferta_vivienda() {
		return id_oferta_vivienda;
	}


	public void setId_oferta_vivienda(String id_oferta_vivienda) {
		this.id_oferta_vivienda = id_oferta_vivienda;
	}


	public String getId_orden_verificacion() {
		return id_orden_verificacion;
	}


	public void setId_orden_verificacion(String id_orden_verificacion) {
		this.id_orden_verificacion = id_orden_verificacion;
	}


	public String getNombre_frente() {
		return nombre_frente;
	}


	public void setNombre_frente(String nombre_frente) {
		this.nombre_frente = nombre_frente;
	}


	public String getNum_viviendas() {
		return num_viviendas;
	}


	public void setNum_viviendas(String num_viviendas) {
		this.num_viviendas = num_viviendas;
	}


	public String getId_modificacion() {
		return id_modificacion;
	}


	public void setId_modificacion(String id_modificacion) {
		this.id_modificacion = id_modificacion;
	}


	public String getNum_viviendas_declinacion_modificacion() {
		return num_viviendas_declinacion_modificacion;
	}


	public void setNum_viviendas_declinacion_modificacion(String num_viviendas_declinacion_modificacion) {
		this.num_viviendas_declinacion_modificacion = num_viviendas_declinacion_modificacion;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getId_programa() {
		return id_programa;
	}


	public void setId_programa(String id_programa) {
		this.id_programa = id_programa;
	}


	public String getId_paquete() {
		return id_paquete;
	}


	public void setId_paquete(String id_paquete) {
		this.id_paquete = id_paquete;
	}


	public String getId_documento() {
		return id_documento;
	}


	public void setId_documento(String id_documento) {
		this.id_documento = id_documento;
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
