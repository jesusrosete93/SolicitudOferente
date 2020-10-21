package mx.org.infonavit.solicitud.oferente.business.services;



import mx.org.infonavit.solicitud.oferente.business.BusinessException;

public interface ReporteInexUvPaqueteService<T> {
	
	public T generarReporteInexUvPaquete(String... criterios)throws BusinessException;

}
