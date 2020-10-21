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
import mx.org.infonavit.solicitud.oferente.business.services.SolicitudOferenteIDService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractSolicitudIDOferenteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;


@Service("SolicitudIDSolicitudBusiness")
public class SolicitudIDSolicitudBusiness implements SolicitudOferenteIDService {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudIDSolicitudBusiness.class);
	
	@Autowired
	@Qualifier("SolicitudOferenteCancelacionBuscarIDSolicitudDao")
	private AbstractSolicitudIDOferenteDao<SolicitudOferenteIDVo> persistence;

	@Override
	public SolicitudIDDomain consultarOferenteID(SolicitudOferenteIDVo registro) {
		try
		{
			LOGGER.info("Consultando la información del consecutivo:["+registro+"]");
			SolicitudOferenteIDVo criterios = new SolicitudOferenteIDVo();
			criterios.setAnio(registro.getAnio());
			criterios.setId_estado(registro.getId_estado());
			criterios.setId_tipo_solicitud(registro.getId_tipo_solicitud());

			return  getObjetoOferenteDomainDeVo(persistence.buscar(criterios));

		}catch (Exception e) {
			LOGGER.error("Error al consultar la información solicitud:["+registro+"]",e);
			return null;
		}
		
	}

	private SolicitudIDDomain getObjetoOferenteDomainDeVo(SolicitudOferenteIDVo solicitudOferenteIDVo) {
		
		SolicitudIDDomain regreso = null;
		if( solicitudOferenteIDVo != null)
		{
		regreso = new SolicitudIDDomain();
		try {
		BeanUtils.copyProperties(regreso, solicitudOferenteIDVo);
		} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}else
		{
		regreso = new SolicitudIDDomain();
		}
		return regreso;
	}






}
