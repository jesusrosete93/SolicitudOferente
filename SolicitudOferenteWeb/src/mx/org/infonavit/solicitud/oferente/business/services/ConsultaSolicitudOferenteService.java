package mx.org.infonavit.solicitud.oferente.business.services;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;

public interface ConsultaSolicitudOferenteService<T> {
	
	public List<T> generarReporteConsultaSolicitud(String... criterios)throws BusinessException;


}
