package mx.org.infonavit.solicitud.oferente.business;

import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.UnidadValuacionVo;

import org.springframework.stereotype.Service;

@Service
public class UnidadValuacionBusiness {
	
	public static UnidadValuacionDomain getDomain(UnidadValuacionVo registro)
	{
		UnidadValuacionDomain domain = null;
		if( registro!=null )
		{
			domain = new UnidadValuacionDomain();
			domain.setIdUnidadValuacion(registro.getIdUnidadValuacion());
			domain.setNombreUnidad(registro.getNombreUnidadValuacion());
		}
	 return domain;
	}

}
