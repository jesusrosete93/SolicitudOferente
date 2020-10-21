package mx.org.infonavit.solicitud.oferente.business.services;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;

public interface ReporteEcoTecnologiasService<T> {
	
	public List<T> generarReporteEcoTecnologias(String... criterios)throws BusinessException;


}
