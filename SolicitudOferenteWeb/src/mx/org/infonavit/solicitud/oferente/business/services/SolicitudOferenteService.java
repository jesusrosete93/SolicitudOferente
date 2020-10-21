package mx.org.infonavit.solicitud.oferente.business.services;


import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;



public interface SolicitudOferenteService<T>  {
	
	
//	void solicitudOferente(T criterios);
//	List<SolicitudOferenteDomain> registrarSolicitudCancelacion(String... criterios)throws BusinessException;
	
	public List<T> registrarSolicitudCancelacion(String... criterios)throws BusinessException;

//	boolean registrarSolicitudCancelacionB(SolicitudOferenteDomain domain);

	public SolicitudIDDomain registrarSolicitudCancelacionB(String... criterios)throws BusinessException;

//	boolean registrarSolicitudCancelacionB(SolicitudOferenteDomain domain);

}
