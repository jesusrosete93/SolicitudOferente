package mx.org.infonavit.solicitud.oferente.business.services;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;

public interface ReporteInexUvOferenteService<T> {
	
	public List<T> generarReporteInexUvOferente(String... criterios)throws BusinessException;

}
