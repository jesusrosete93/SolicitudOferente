package mx.org.infonavit.solicitud.oferente.domain.utitls;

import mx.org.infonavit.solicitud.oferente.domain.OferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;

public class OferenteDomainUtils {
	
	/**
	 * <p>Método que convierte un objeto {@link OferenteVo} a un objeto {@link OferenteDomain}</p>
	 * @param registro objeto con los valores de un registro de la tabla: cat_oferente
	 * @return objeto de dominio con la información
	 */
	public static OferenteDomain getObjetoOferenteDomainDeVo(OferenteVo registro)
	{
		if( registro!=null)
		{
			OferenteDomain regreso = new OferenteDomain();
			regreso.setNombreRazonSocial(registro.getNombreRazonSocial());
			regreso.setRfc(registro.getRfc());
			regreso.setRepresentanteLegal(registro.getRepresentanteSocial());
			regreso.setCurp(registro.getCurp());
			return regreso;
		}else
		{
			return null;
		}
	}

}
