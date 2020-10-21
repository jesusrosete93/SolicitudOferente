package mx.org.infonavit.solicitud.oferente.business.services;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;

public interface PaqueteBusinessService {
	
	public PaqueteDomain buscarPaquetePorId(String numeroPaquete)throws BusinessException;
	
}
