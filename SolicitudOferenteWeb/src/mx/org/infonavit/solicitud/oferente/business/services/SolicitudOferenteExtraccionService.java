package mx.org.infonavit.solicitud.oferente.business.services;


import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteExtraccionDomain;



public interface SolicitudOferenteExtraccionService<T>  {
	
	
//	void solicitudOferente(T criterios);
//	List<SolicitudOferenteDomain> registrarSolicitudCancelacion(String... criterios)throws BusinessException;
	
//	public List<T> registrarSolicitudCancelacion(String... criterios)throws BusinessException;

//	boolean registrarSolicitudCancelacionB(SolicitudOferenteDomain domain);

//	public List<T> registrarSolicitudCancelacionB(String... criterios)throws BusinessException;

	public List<SolicitudOferenteExtraccionDomain> solicitudOferenteExtracService(
			String id_registro, String id_solicitud, String tipo_linea,
			String fecha_solicitud, String fecha_respuesta,
			String id_tipo_solicitud, String id_estatus, String id_estado,
			String id_oferente, String nombre_razon_social,
			String id_oferta_vivienda, String id_orden_verificacion,
			String nombre_frente, String num_viviendas, String id_paquete,
			String id_modificacion,
			String num_viviendas_declinacion_modificacion, String comentarios,
			String id_programa, String id_documento, String fecha_alta,String nombre_archivo,
			byte[] archivo, String tipo_archivo);

//	boolean registrarSolicitudCancelacionB(SolicitudOferenteDomain domain);

}
