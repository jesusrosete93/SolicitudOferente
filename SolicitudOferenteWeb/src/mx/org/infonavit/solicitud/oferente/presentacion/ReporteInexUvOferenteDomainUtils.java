package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.EstadoDomian;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;

public class ReporteInexUvOferenteDomainUtils {
	
	
	public static ReporteInexUvOferenteDomain generarDomain(ReporteInexUvOferenteVo registro)
	{
		ReporteInexUvOferenteDomain domain = new ReporteInexUvOferenteDomain();
		
		if( registro!=null )
		{
			domain.setEstado(new EstadoDomian(registro.getEstado(),Estado.CATALOGO_ESTADOS.get(registro.getIdEstado())));
			domain.setUnidadValuacion(CatalogosBusines.UNIDADES_VALUACION.get(registro.getIdUnidadValuacion()));
			domain.setNumeroViviendas(registro.getTotalViviendas());
		}
	  return domain;
	}
	
	public static List<ReporteInexUvOferenteDomain> generarListaDomain(List<ReporteInexUvOferenteVo> registros)
	{
		List<ReporteInexUvOferenteDomain> regreso = null;
		if( registros!=null && !registros.isEmpty() )
		{
			regreso = new ArrayList<ReporteInexUvOferenteDomain>();
			for( ReporteInexUvOferenteVo registro : registros )
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
