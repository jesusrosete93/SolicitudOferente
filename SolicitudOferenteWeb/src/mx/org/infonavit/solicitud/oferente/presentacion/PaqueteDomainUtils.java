package mx.org.infonavit.solicitud.oferente.presentacion;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteInexUvOferenteDomain;
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
public class PaqueteDomainUtils {
	/**
	 * <p>
	 * Método que convierte un objeto de tipo {@link ReporteInexUvPaqueteVo}
	 * a una lista de objetos de tipo {@link PaqueteDomain}.
	 * </p>
	 * @param registro objeto tipo {@link PaqueteVo}
	 * @return objeto tipo {@link PaqueteDomain} con los valores
	 */
	public static PaqueteDomain generarDomain(PaqueteVo registro)
	{
		PaqueteDomain domain = new PaqueteDomain();
		
		if( registro!=null )
		{
			domain.setIdentificador(registro.getIdPaquete());
			domain.setIdOferente(registro.getIdOferente());
			domain.setRfcOferente(registro.getRfcOferente());
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
	public static List<PaqueteDomain> generarListaUnidadesDomain(List<PaqueteVo> registros)
	{
		List<PaqueteDomain> regreso = new ArrayList<PaqueteDomain>();
		if( registros!=null && !registros.isEmpty() )
		{
			for( PaqueteVo registro : registros )
			{
				regreso.add( generarDomain(registro) );
			}
		}
	  return regreso;
	}

}
