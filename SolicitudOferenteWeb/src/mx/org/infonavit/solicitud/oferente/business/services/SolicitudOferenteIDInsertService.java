package mx.org.infonavit.solicitud.oferente.business.services;



import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;


public interface SolicitudOferenteIDInsertService {
	
//	 SolicitudIDDomain updateSolicitud(SolicitudOferenteIDVo registro);

	SolicitudIDDomain insertOferenteID(SolicitudOferenteIDVo registro);

//	SolicitudIDDomain consultarOferenteID(String consecutivo);
	


}
