package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.presentacion.ClaveTecnologiaDomainUtils.generarEcoDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.business.services.ClaveEcoBusinessService;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteEcoDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractECODao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;

@Service("ClaveEcoBusiness")
public class ClaveEcoBusiness implements ClaveEcoBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(ClaveEcoBusiness.class);
	private static final String PREFIJO_LOG = "[PB] - ";
	
	@Autowired
	@Qualifier("EcoTecnologiasDao")
	private AbstractECODao<ReporteEcoTecnologiaVo> persistence;
	
//	@Autowired
//	@Qualifier("EcoTecnologiasDao")
//	private AbstractECODao<EcoTecnologiasVo> persistencePaqueteAvaluo;

	@Override
	public PaqueteEcoDomain buscarClaveEco(String numeroPaquete) throws BusinessException {
		TecnologiaDomain domain = null;
		try
		{
			LOGGER.info(PREFIJO_LOG+"Buscando información del paquete: "+numeroPaquete);
	//		domain = generarEcoDomain(persistence.buscar(new EcoTecnologiasVo(numeroPaquete,"")));
			
	//		ReporteEcoTecnologiaVo reporteEcoTecnologiaVo = persistence.buscar(new ReporteEcoTecnologiaVo(claveTecnologia,oferta));
//			if( reporteEcoTecnologiaVo!=null)
//			{
//					
//				
//			
//			}
			
			
			
			return null;
		}catch (Exception e) {
			throw new BusinessException("Error al consultar el paquete: "+numeroPaquete,e);
		}
	}

}
