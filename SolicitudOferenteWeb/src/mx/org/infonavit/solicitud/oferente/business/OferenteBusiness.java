package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.domain.utitls.OferenteDomainUtils.getObjetoOferenteDomainDeVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.business.services.OferenteService;
import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;

@Service("OferenteBusiness")
public class OferenteBusiness implements OferenteService {
	
	private static final Logger LOGGER = LogManager.getLogger(OferenteBusiness.class);
	
	@Autowired
	@Qualifier("OferenteDao")
	private AbstractDao<OferenteVo> persistence;

	@Override
	public OferenteDomain consultarOferente(String rfc) {
		try
		{
			LOGGER.info("Consultando la información del oferente con rfc:["+rfc+"]");
			OferenteVo criterios = new OferenteVo();
			criterios.setRfc(rfc);
			return getObjetoOferenteDomainDeVo(persistence.buscar(criterios));
		}catch (Exception e) {
			LOGGER.error("Error al consultar la información del oferente con rfc:["+rfc+"]",e);
			return null;
		}
		
	}

}
