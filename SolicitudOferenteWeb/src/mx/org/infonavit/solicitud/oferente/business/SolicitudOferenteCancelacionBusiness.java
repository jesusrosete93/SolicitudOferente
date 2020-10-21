package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.presentacion.SolicitudOferenteCancelacionDomainUtils.generarSolicitudC;
import java.util.Arrays;
import java.util.List;


import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDActualizarService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDInsertService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDService;



@Service("SolicitudOferenteCancelacionBusiness")
public class SolicitudOferenteCancelacionBusiness  implements SolicitudOferenteService<OferenteSolicitudDomain> {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudOferenteCancelacionBusiness.class);
	private static final String PREFIJO_LOG = "[RIB] - ";
	
	
	@Autowired
	@Qualifier("SolicitudOferenteCancelacionDao")
	private AbstractSolicitudOferenteDao <SolicitudOferenteVo> persistence;
	
	
	
	@Autowired
	@Qualifier("SolicitudIDSolicitudBusiness")
	private SolicitudOferenteIDService serviceIDSolicitud;
	
	@Autowired
	@Qualifier("SolicitudIDInsersionBusiness")
	private SolicitudOferenteIDInsertService serviceInsert;
	
	
	@Autowired
	@Qualifier("SolicitudIDActualizarSolicitudBusiness")
	private SolicitudOferenteIDActualizarService persistenciaActualizar;
	





	@Override
	public SolicitudIDDomain registrarSolicitudCancelacionB(String... criterios) throws BusinessException {
		
		SolicitudIDDomain regreso = null;
		regreso = new SolicitudIDDomain();
		
		final SolicitudOferenteIDVo registro = new SolicitudOferenteIDVo();
		
		try
		{
		
		LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud cancelacion...");
		LOGGER.debug(PREFIJO_LOG+"Parametros: "+Arrays.asList(criterios).toString());
		
//		registro.setId_solicitud(criterios[0]);
		registro.setTipo_linea(criterios[1]);
		registro.setFecha_solicitud(criterios[2]);
		registro.setFecha_respuesta(criterios[3]);
		registro.setId_estatus(criterios[4]);
		registro.setId_tipo_solicitud(criterios[5]);
		registro.setRfc_oferente(criterios[6]);
		registro.setId_estado(criterios[7]);
		registro.setId_oferente(criterios[8]);
		registro.setNombre_razon_social(criterios[9]);
		registro.setId_oferta_vivienda(criterios[10]);
		registro.setId_orden_verificacion(criterios[11]);
		registro.setNombre_frente(criterios[12]);
		registro.setNum_viviendas(criterios[13]);
		registro.setId_paquete(criterios[14]);
		registro.setId_modificacion(criterios[15]);
		registro.setNum_viviendas_declinacion_modificacion(criterios[16]);
		registro.setComentarios(criterios[17]);
		registro.setId_programa(criterios[18]);
		
		String anio = (registro.getFecha_solicitud().substring(2, 4));
		String id_solicitud= "";
		 
		String tipo_solicitud=  registro.getId_tipo_solicitud();
		registro.setAnio(anio);
		
		int consecutivo_registro = 0;
		SolicitudIDDomain consecutivo = serviceIDSolicitud.consultarOferenteID(registro);
		if(  consecutivo.getConsecutivo() == null || consecutivo.getConsecutivo().equals(""))
		{
			
			consecutivo_registro =1;
			registro.setConsecutivo(consecutivo_registro + "");
			LOGGER.info(PREFIJO_LOG+"Generación Insersion ...");
			 serviceInsert.insertOferenteID(registro);
		}else 
		{
			
			 consecutivo_registro =Integer.parseInt(consecutivo.getConsecutivo());
			 consecutivo_registro = consecutivo_registro+1;
			 registro.setConsecutivo(consecutivo_registro + "");
			 LOGGER.info(PREFIJO_LOG+"Generación actualizacion...");
//			SolicitudIDDomain consecutivoActualizar = persistenciaActualizar.consultarOferenteID(registro);
		    persistenciaActualizar.updateSolicitud(registro);
		}
		
		if(consecutivo_registro < 10)
		{
			id_solicitud = anio+ registro.getId_estado()+ tipo_solicitud + "00" + consecutivo_registro;
			
		}else if(consecutivo_registro >= 10 && consecutivo_registro < 100 )
		{
			id_solicitud = anio+ registro.getId_estado()+ tipo_solicitud + "0" + consecutivo_registro;
		}else
		{
			id_solicitud = anio+ registro.getId_estado()+ tipo_solicitud  + consecutivo_registro;
		}

		registro.setId_solicitud(id_solicitud);
		
		
		regreso = guardarOferenteSolicitudInt(persistence.guardarOferenteSolicitudInt(registro));
		
		 regreso.setId_solicitud(registro.getId_solicitud());
		 return regreso;
		}catch (Exception e) {

			LOGGER.info(PREFIJO_LOG+"Generación insersion solicitud solicitud : " + registro.getId_solicitud());
			registro.getId_solicitud();
		}
		regreso.setId_solicitud(registro.getId_solicitud());
		return regreso;
		
		
	}

	private SolicitudIDDomain updateSolicitud(SolicitudIDDomain updateSolicitud) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	private SolicitudIDDomain guardarOferenteSolicitudInt(int guardarOferenteSolicitudInt) {
		
return null;
	}

	@Override
	public List<OferenteSolicitudDomain> registrarSolicitudCancelacion(
			String... criterios) throws BusinessException {
		// TODO Apéndice de método generado automáticamente
		return null;
	}





	
	




			


}
