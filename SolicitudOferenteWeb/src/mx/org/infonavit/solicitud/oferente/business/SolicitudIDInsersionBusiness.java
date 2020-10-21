package mx.org.infonavit.solicitud.oferente.business;


import static mx.org.infonavit.solicitud.oferente.domain.utitls.OferenteSolicitudOfeIDDomainUtils.getObjetoOferenteDomainDeVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDInsertService;
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudExtraccionOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudIDOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;


@Service("SolicitudIDInsersionBusiness")
public class SolicitudIDInsersionBusiness implements SolicitudOferenteIDInsertService {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudIDInsersionBusiness.class);
	
	@Autowired
	@Qualifier("SolicitudOferenteInsertarTBLConsecutivoIDSolicitudDao")
	private AbstractSolicitudExtraccionOferenteDao<SolicitudOferenteIDVo> persistence;

	@Override
	public SolicitudIDDomain insertOferenteID(SolicitudOferenteIDVo registro) {
		try
		{
			LOGGER.info("Guardando informacion TBL_Consecutivo_Solicitud :["+registro+"]");
			SolicitudOferenteIDVo criterios = new SolicitudOferenteIDVo();
			criterios.setAnio(registro.getAnio());
			criterios.setId_estado(registro.getId_estado());
			criterios.setId_tipo_solicitud(registro.getId_tipo_solicitud());
			criterios.setConsecutivo(registro.getConsecutivo());
			return  getObjetoOferenteDomainDeVo(persistence.guardarSolicitud(criterios));

		}catch (Exception e) {
			LOGGER.error("Error al consultar la información solicitud:["+registro+"]",e);
			return null;
		}
		
	}

	private SolicitudIDDomain getObjetoOferenteDomainDeVo(
			boolean guardarSolicitud) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	private SolicitudIDDomain getObjetoOferenteDomainDeVo(SolicitudOferenteIDVo solicitudOferenteIDVo) {
		
//		SolicitudIDDomain regreso = null;
//		if( solicitudOferenteIDVo != null)
//		{
//		regreso = new SolicitudIDDomain();
//		try {
//		BeanUtils.copyProperties(regreso, solicitudOferenteIDVo);
//		} catch (IllegalAccessException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		} catch (InvocationTargetException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		}
//		}else
//		{
//		regreso = new SolicitudIDDomain();
//		}
		return null;
	}






}
