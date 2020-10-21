package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;


import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudIDDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

public class OferenteSolicitudIDDomainUtils {
	
	
	public static SolicitudIDDomain generarDomainSolicitarID(SolicitudOferenteIDVo registro)
	{
		if( registro!=null)
		{
			SolicitudIDDomain domain = new SolicitudIDDomain();
			domain.setConsecutivo(registro.getConsecutivo());
			
			return domain;
			
		}else
		{
			return null;
		}
	}
	
	}
	



