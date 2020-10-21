package mx.org.infonavit.solicitud.oferente.business.services;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;

public interface PaqueteBusinessValidator {
	
	public boolean validarPaqueteOferente(String paquete,String idOferente) throws BusinessException;

}
