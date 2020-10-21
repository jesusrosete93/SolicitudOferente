package mx.org.infonavit.solicitud.oferente.business.services;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteEcoDomain;

public interface ClaveEcoBusinessService {
	
	public PaqueteEcoDomain buscarClaveEco(String numeroPaquete)throws BusinessException;
	
}
