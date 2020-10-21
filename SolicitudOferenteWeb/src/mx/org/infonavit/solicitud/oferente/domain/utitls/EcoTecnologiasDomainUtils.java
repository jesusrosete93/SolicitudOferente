package mx.org.infonavit.solicitud.oferente.domain.utitls;

import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;

public class EcoTecnologiasDomainUtils {
	
	/**
	 * <p>Método que convierte un objeto {@link OferenteVo} a un objeto {@link OferenteDomain}</p>
	 * @param registro objeto con los valores de un registro de la tabla: TBL_Ecotecnologias
	 * @return objeto de dominio con la información
	 */
	public static ReporteEcoTecnologiaVo getTecnologiaDomain(ReporteEcoTecnologiaVo registro)
	{
		if( registro!=null)
		{
			ReporteEcoTecnologiaVo regreso = new ReporteEcoTecnologiaVo(null, null,null,null);
			regreso.setClaveTecnologia(registro.getClaveTecnologia());
			regreso.setPaquete(registro.getPaquete());
			regreso.setanioMES(regreso.getanioMES());
			regreso.setnumecotec(regreso.getanioMES());
			
			
			return regreso;
		}else
		{
			return null;
		}
	}

}
