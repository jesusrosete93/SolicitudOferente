package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;
/**
 * <p>
 * 	Clase que encapsula la conversión de objetos tipo {@link ReporteInexUvPaqueteVo} a
 *  objetos de dominio del siguiente tipo:
 *  	<ul>
 *  	 <li>{@link ReporteInexUvOferenteDomain}</li>
 *      </ul>
 * </p> 
 * @author Adrian Casas 
 *
 */
public class ReporteInexUvPaqueteDomainUtils {
	/**
	 * <p>
	 * Método que convierte un objeto de tipo {@link ReporteInexUvPaqueteVo}
	 * a una lista de objetos de tipo {@link ReporteInexUvOferenteDomain}.
	 * </p>
	 * @param registro objeto tipo {@link ReporteInexUvPaqueteVo}
	 * @return objeto tipo {@link ReporteInexUvOferenteDomain} con los valores
	 */
	public static ReporteInexUvOferenteDomain generarDomain(ReporteInexUvPaqueteVo registro)
	{
		ReporteInexUvOferenteDomain domain = new ReporteInexUvOferenteDomain();
		
		if( registro!=null )
		{
			domain.setUnidadValuacion(new UnidadValuacionDomain(registro.getIdUnidadValuacion(),registro.getNombreUnidadValuacion()));
			domain.setNumeroViviendas(registro.getNumeroViviendasUnidadValuacion());
		}
	  return domain;
	}
	
	/**
	 * <p>
	 * Método que convierte una lista de objetos de tipo {@link ReporteInexUvPaqueteVo}
	 * a una lista de objetos de tipo {@link ReporteInexUvOferenteDomain}.
	 * </p>
	 * @param registros lista con objetos tipo {@link ReporteInexUvPaqueteVo}
	 * @return lista de objeto tipo {@link ReporteInexUvOferenteDomain} con los valores
	 */
	public static List<ReporteInexUvOferenteDomain> generarListaUnidadesDomain(List<ReporteInexUvPaqueteVo> registros)
	{
		List<ReporteInexUvOferenteDomain> regreso = new ArrayList<ReporteInexUvOferenteDomain>();
		if( registros!=null && !registros.isEmpty() )
		{
			for( ReporteInexUvPaqueteVo registro : registros )
			{
				regreso.add( generarDomain(registro) );
			}
		}
	  return regreso;
	}

}
