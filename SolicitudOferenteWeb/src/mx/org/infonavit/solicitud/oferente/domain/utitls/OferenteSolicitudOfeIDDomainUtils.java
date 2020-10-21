package mx.org.infonavit.solicitud.oferente.domain.utitls;

import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

public class OferenteSolicitudOfeIDDomainUtils {
	
	/**
	 * <p>Método que convierte un objeto {@link OferenteVo} a un objeto {@link OferenteDomain}</p>
	 * @param registro objeto con los valores de un registro de la tabla: cat_oferente
	 * @return objeto de dominio con la información
	 */
	public static SolicitudIDDomain getObjetoOferenteDomainDeVo(SolicitudOferenteIDVo registro)
	{
		if( registro!=null)
		{
			SolicitudIDDomain regreso = new SolicitudIDDomain();

			
			regreso.setConsecutivo(registro.getConsecutivo());
			return regreso;
		}else
		{
			return null;
		}
	}

}
