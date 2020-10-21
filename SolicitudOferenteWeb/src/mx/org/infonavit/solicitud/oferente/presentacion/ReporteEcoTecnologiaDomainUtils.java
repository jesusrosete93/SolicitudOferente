package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;


import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;

public class ReporteEcoTecnologiaDomainUtils {
	
	

	public static ReporteEcoUvEcoTecnologiaDomain generarDomain(ReporteEcoTecnologiaVo registro)
	{
		ReporteEcoUvEcoTecnologiaDomain domain = new ReporteEcoUvEcoTecnologiaDomain();
		
		if( registro!=null )
		{
//			domain.setEstado(new EstadoDomian(registro.getEstado(),Estado.CATALOGO_ESTADOS.get(registro.getIdEstado())));
//			domain.setUnidadValuacion(CatalogosBusines.UNIDADES_VALUACION.get(registro.getIdUnidadValuacion()));
//			domain.setNumeroViviendas(registro.getTotalViviendas());
//			domain.setClaveEcotecnologia(registro.getClaveEcotecnologia());
//			domain.setUnidadValuacion(new UnidadValuacionDomain(registro.getIdUnidadValuacion(),registro.getNombreUnidadValuacion()));
			domain.setTecnoDomain(new TecnologiaDomain(registro.getClaveTecnologia(),registro.getPaquete(),registro.getanioMES(),registro.getnumecotec()));

			domain.setId(registro.getId_paquete());
			
		}
	  return domain;
	}
	
	public static List<ReporteEcoUvEcoTecnologiaDomain> generarListaECODomain(List<ReporteEcoTecnologiaVo> registros)
	{
		List<ReporteEcoUvEcoTecnologiaDomain> regreso = null;
		if( registros!=null && !registros.isEmpty() )
		{
			regreso = new ArrayList<ReporteEcoUvEcoTecnologiaDomain>();
			for( ReporteEcoTecnologiaVo registro : registros )
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
