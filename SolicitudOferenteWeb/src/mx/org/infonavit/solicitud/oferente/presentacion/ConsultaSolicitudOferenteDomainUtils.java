package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;


import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteConsultaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

public class ConsultaSolicitudOferenteDomainUtils {
	
	

	public static OferenteSolicitudDomain generarDomain(SolicitudOferenteConsultaVo registro)
	{
		OferenteSolicitudDomain domain = new OferenteSolicitudDomain();
		
		if( registro!=null )
		{
			domain.setSolicitudOferenteDomain(new SolicitudOferenteDomain(registro.getId_solicitud(),
					registro.getId_tipo_solicitud(),registro.getFecha_solicitud(),
					registro.getId_oferente(),registro.getNombre_razon_social(),registro.getId_estado(),
					registro.getId_paquete(),registro.getId_oferta_vivienda(),registro.getId_estatus()));
			
			
		}
	  return domain;
	}
	
	public static List<OferenteSolicitudDomain> generarListaSolicitudOferente(List<SolicitudOferenteConsultaVo> registros)
	{
		List<OferenteSolicitudDomain> regreso = null;
		if( registros!=null && !registros.isEmpty() )
		{
			regreso = new ArrayList<OferenteSolicitudDomain>();
			for( SolicitudOferenteConsultaVo registro : registros )
			{
				if( registro!=null)
				{
					regreso.add( generarDomain(registro) );
				}
			}
		}
	  return regreso;
	}

}
