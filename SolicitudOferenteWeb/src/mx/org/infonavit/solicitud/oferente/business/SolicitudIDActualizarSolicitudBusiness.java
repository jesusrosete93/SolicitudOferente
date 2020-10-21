package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.domain.utitls.OferenteSolicitudOfeIDDomainUtils.getObjetoOferenteDomainDeVo;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDActualizarService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudBuscarOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudIDOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudUpdateOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;


@Service("SolicitudIDActualizarSolicitudBusiness")
public class SolicitudIDActualizarSolicitudBusiness implements SolicitudOferenteIDActualizarService {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudIDActualizarSolicitudBusiness.class);
	
	@Autowired
	@Qualifier("SolicitudOferenteCancelacionActualizarSolicitudDao")
	private AbstractSolicitudUpdateOferenteDao<SolicitudOferenteIDVo> persistence;

	@Override
	public SolicitudIDDomain updateSolicitud(SolicitudOferenteIDVo registro) {
		try
		{
			LOGGER.info("Realizando el update a TBL_Consecutivo_Solicitud:["+registro+"]");
			SolicitudOferenteIDVo criterios = new SolicitudOferenteIDVo();
			criterios.setAnio(registro.getAnio());
			criterios.setId_estado(registro.getId_estado());
			criterios.setId_tipo_solicitud(registro.getId_tipo_solicitud());
			criterios.setConsecutivo(registro.getConsecutivo());
			return  getObjetoOferenteDomainDeVo(persistence.updateSolicitud(criterios));

		}catch (Exception e) {
			LOGGER.error("Error al consultar la información solicitud:["+registro+"]",e);
			return null;
		}
		
	}

	private SolicitudIDDomain getObjetoOferenteDomainDeVo(boolean b) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}






}
