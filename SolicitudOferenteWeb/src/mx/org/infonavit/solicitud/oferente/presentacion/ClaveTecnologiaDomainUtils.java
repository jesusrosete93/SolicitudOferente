package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteVo;
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
public class ClaveTecnologiaDomainUtils {
	/**
	 * <p>
	 * Método que convierte un objeto de tipo {@link ReporteInexUvPaqueteVo}
	 * a una lista de objetos de tipo {@link PaqueteDomain}.
	 * </p>
	 * @param registro objeto tipo {@link PaqueteVo}
	 * @return objeto tipo {@link PaqueteDomain} con los valores
	 */
	public static TecnologiaDomain generarEcoDomain(EcoTecnologiasVo registro)
	{
		TecnologiaDomain domain = new TecnologiaDomain(null, null,null,null);
		
		if( registro!=null )
		{
			
			domain.setClaveTecnologia(registro.getClaveTecnologia());
			domain.setPaquete(registro.getPaquete());
		}
	  return domain;
	}
	
	/**
	 * <p>
	 * Método que convierte una lista de objetos de tipo {@link PaqueteVo}
	 * a una lista de objetos de tipo {@link PaqueteDomain}.
	 * </p>
	 * @param registros lista con objetos tipo {@link PaqueteVo}
	 * @return lista de objeto tipo {@link PaqueteDomain} con los valores
	 */
	public static List<TecnologiaDomain> generarListaEcoTecDomain(List<EcoTecnologiasVo> registros)
	{
		List<TecnologiaDomain> regreso = new ArrayList<TecnologiaDomain>();
		if( registros!=null && !registros.isEmpty() )
		{
			for( EcoTecnologiasVo registro : registros )
			{
				regreso.add( generarEcoDomain(registro) );
			}
		}
	  return regreso;
	}

}
