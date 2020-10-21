package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.presentacion.PaqueteDomainUtils.generarDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteVo;

@Service("PaqueteBusiness")
public class PaqueteBusiness implements PaqueteBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(PaqueteBusiness.class);
	private static final String PREFIJO_LOG = "[PB] - ";
	
	@Autowired
	@Qualifier("PaqueteDao")
	private AbstractDao<PaqueteVo> persistence;
	
	@Autowired
	@Qualifier("PaqueteAvaluoDao")
	private AbstractDao<PaqueteAvaluoVo> persistencePaqueteAvaluo;

	@Override
	public PaqueteDomain buscarPaquetePorId(String numeroPaquete) throws BusinessException {
		PaqueteDomain domain = null;
		try
		{
			LOGGER.info(PREFIJO_LOG+"Buscando información del paquete: "+numeroPaquete);
			domain = generarDomain(persistence.buscar(new PaqueteVo(numeroPaquete,"")));
			
			PaqueteAvaluoVo paqueteAvaluo = persistencePaqueteAvaluo.buscar(new PaqueteAvaluoVo(numeroPaquete));
			if( paqueteAvaluo!=null)
			{
				if( paqueteAvaluo.getTipoPaquete().trim().equals("N"))
				{
					domain.setTipoPaquete("Paquete nuevo");
				}
				if( paqueteAvaluo.getTipoPaquete().trim().equals("V"))
				{
					domain.setTipoPaquete("Paquete anterior al Inex");
				}
			}else
			{
				domain.setTipoPaquete("");
			}
			
			
			
			return domain;
		}catch (Exception e) {
			throw new BusinessException("Error al consultar el paquete: "+numeroPaquete,e);
		}
	}

}
