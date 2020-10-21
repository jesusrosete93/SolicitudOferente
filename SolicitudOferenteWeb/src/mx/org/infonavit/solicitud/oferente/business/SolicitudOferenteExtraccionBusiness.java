package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.presentacion.SolicitudOferenteCancelacionDomainUtils.generarSolicitudC;
import java.util.Arrays;
import java.util.List;


import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteExtraccionService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteExtraccionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudOferenteEctraccionDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteExtraccionVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("SolicitudOferenteExtraccionBusiness")
public class SolicitudOferenteExtraccionBusiness  implements SolicitudOferenteExtraccionService<SolicitudOferenteExtraccionDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudOferenteExtraccionBusiness.class);
	private static final String PREFIJO_LOG = "[RIB] - ";
	
	
	@Autowired
	@Qualifier("SolicitudOferenteExtraccionDao")
	private AbstractSolicitudOferenteEctraccionDao<SolicitudOferenteExtraccionDomain> persistence;
	
//	@Override
//	public List<SolicitudOferenteExtraccionDomain> solicitudOferenteExtracService(String... criterios) throws BusinessException {
//		List<SolicitudOferenteExtraccionDomain> regreso = null;
//		final SolicitudOferenteVo registro = new SolicitudOferenteVo();
//		
//		try
//		{
//		
//		LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud cancelacion...");
//		LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(criterios).toString());
//		
//		registro.setId_solicitud(criterios[0]);
//		registro.setTipo_linea(criterios[1]);
//		registro.setFecha_solicitud(criterios[2]);
//		registro.setFecha_respuesta(criterios[3]);
//		registro.setId_estatus(criterios[4]);
//		registro.setId_tipo_solicitud(criterios[5]);
//		registro.setRfc_oferente(criterios[6]);
//		registro.setId_estado(criterios[7]);
//		registro.setId_oferente(criterios[8]);
//		registro.setNombre_razon_social(criterios[9]);
//		registro.setId_oferta_vivienda(criterios[10]);
//		registro.setId_orden_verificacion(criterios[11]);
//		registro.setNombre_frente(criterios[12]);
//		registro.setNum_viviendas(criterios[13]);
//		registro.setId_paquete(criterios[14]);
//		registro.setId_modificacion(criterios[15]);
//		registro.setNum_viviendas_declinacion_modificacion(criterios[16]);
//		registro.setComentarios(criterios[17]);
//		registro.setId_programa(criterios[18]);
//		
//
//
//		LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(registro).toString());
//		regreso = guardarOferenteSolicitudInt(persistence.guardarOferenteSolicitudInt(registro));
//		LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(registro).toString());
//		
//		if(regreso == null )
//		{
//			 return regreso;
//		}
//		
//		 return regreso;
//		}catch (Exception e) {
//			LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud solicitud : " + registro.getId_solicitud());
//		}
//		return regreso;
//	}




	private List<SolicitudOferenteExtraccionDomain> guardarOferenteSolicitudInt(
			int guardarOferenteSolicitudInt) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}




	private List<SolicitudOferenteExtraccionDomain> generarSolicitudC(
			int i) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}




	@Override
	public List<SolicitudOferenteExtraccionDomain> solicitudOferenteExtracService(String id_registro, String id_solicitud, String tipo_linea,
			String fecha_solicitud, String fecha_respuesta,String id_tipo_solicitud, String id_estatus, String id_estado,
			String id_oferente, String nombre_razon_social,String id_oferta_vivienda, String id_orden_verificacion,String nombre_frente, String num_viviendas, String id_paquete,
			String id_modificacion,String num_viviendas_declinacion_modificacion, String comentarios,
			String id_programa, String id_documento, String fecha_alta,String nombre_archivo,byte[] archivo, String tipo_archivo) {
		{
			
			List<SolicitudOferenteExtraccionDomain> regreso = null;
			final SolicitudOferenteExtraccionVo registro = new SolicitudOferenteExtraccionVo();
			
			try
			{
			
			LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud cancelacion...");
			
			
			registro.setId_solicitud(id_registro);
			registro.setTipo_linea(id_solicitud);
			registro.setFecha_solicitud(tipo_linea);
			registro.setFecha_respuesta(fecha_solicitud);
			registro.setId_estatus(fecha_respuesta);
			registro.setId_tipo_solicitud(id_tipo_solicitud);
			registro.setRfc_oferente(id_estatus);
			registro.setId_estado(id_estado);
			registro.setId_oferente(id_oferente);
			registro.setNombre_razon_social(nombre_razon_social);
			registro.setId_oferta_vivienda(id_oferta_vivienda);
			registro.setId_orden_verificacion(id_orden_verificacion);
			registro.setNombre_frente(nombre_frente);
			registro.setNum_viviendas(num_viviendas);
			registro.setId_paquete(id_paquete);
			registro.setId_modificacion(id_modificacion);
			registro.setNum_viviendas_declinacion_modificacion(num_viviendas_declinacion_modificacion);
			registro.setComentarios(comentarios);
			registro.setId_programa(id_programa);
			registro.setId_documento(id_documento);
			registro.setId_oferente(id_oferente);
			registro.setFecha_alta(fecha_alta);
			registro.setArchivo(archivo);
			registro.setNombre_archivo(nombre_archivo);
			registro.setTipo_archivo(tipo_archivo);
			
		


			LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(registro).toString());
			regreso = guardarArchivos(persistence.guardarArchivos(registro));
			regreso = guardarOferenteSolicitudInt(persistence.guardarOferenteSolicitudInt(registro));
			LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(registro).toString());
			
			if(regreso == null )
			{
				 return regreso;
			}
			
			 return regreso;
			}catch (Exception e) {
				LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud solicitud : " + registro.getId_solicitud());
			}
			return regreso;
		}
	}




	private List<SolicitudOferenteExtraccionDomain> guardarArchivos(
			List<SolicitudOferenteExtraccionDomain> list) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}







	
	




			


}
