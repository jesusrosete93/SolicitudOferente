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
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

public class SolicitudOferenteExtraccionDomainUtils {
	
	
	public static OferenteSolicitudDomain generarDomain(SolicitudOferenteVo registro)
	{
		OferenteSolicitudDomain domain = new OferenteSolicitudDomain();
		
		if( registro!=null )
		{
			
			domain.setSolicitudOferenteDomain(new SolicitudOferenteDomain(registro.getId_solicitud(),registro.getTipo_linea(),
					registro.getFecha_respuesta(),registro.getFecha_solicitud(),registro.getId_tipo_solicitud(),registro.getId_estatus(),registro.getId_estado(),
					registro.getId_oferente(),registro.getRfc_oferente(),registro.getNombre_razon_social(),registro.getId_oferta_vivienda(),registro.getId_orden_verificacion(),
					registro.getNombre_frente(),registro.getNum_viviendas(),registro.getId_modificacion(),registro.getNum_viviendas_declinacion_modificacion(),registro.getComentarios(),
					registro.getId_programa(),registro.getId_programa(),registro.getId_programa(),registro.getId_programa(),registro.getId_programa(),registro.getId_programa(), registro.getId_programa()));
			
		}
	  return domain;
	}

	
	public static List<OferenteSolicitudDomain> generarSolicitudExtraccion(List<SolicitudOferenteVo> registros)
	{
		List<OferenteSolicitudDomain> regreso = null;
		if( registros!=null && !registros.isEmpty() )
		{
			regreso = new ArrayList<OferenteSolicitudDomain>();
			for( SolicitudOferenteVo registro : registros )
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
