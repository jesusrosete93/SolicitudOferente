package mx.org.infonavit.solicitud.oferente.business;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import mx.org.infonavit.solicitud.oferente.domain.FotoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.FotoAvaluoVo;

public class ImagenAvaluoBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(ImagenAvaluoBusiness.class);
	
	
	public static FotoDomain getDomain(FotoAvaluoVo imagen)
	{
		FotoDomain regreso = null;
		try
		{
			if( imagen != null )
			{
				regreso = new FotoDomain();
				regreso.setIdAvaluo(imagen.getIdAvaluo());
				regreso.setIdImagen(imagen.getIdImagen());
				regreso.setArchivo(imagen.getArchivo().getBytes(1,(int)imagen.getArchivo().length()));
			}
		}catch (Exception e) {
			LOGGER.error("Error al obtener la imagen del avaluo: "+imagen.getIdAvaluo(),e);
		}
	  return regreso;
	}

}
