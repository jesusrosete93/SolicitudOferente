package mx.org.infonavit.solicitud.oferente.business;

import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PeticionVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class PeticionBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(PeticionBusiness.class);
	
	@Autowired
	@Qualifier("PeticionDao")
	private AbstractDao<PeticionVo> persistencePeticion;
	
	/**
	 * 
	 * @param peticion
	 * @param request
	 * @param response
	 */
	public boolean guardarPeticion(PeticionVo peticion)
	{
		boolean regreso = false;
		LOGGER.info("[PB] - Bitacorizando peticion...");
		try
		{
			peticion.setXmlRequest(peticion.getXmlRequest().toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", ""));
			peticion.setXmlResponse(peticion.getXmlResponse().toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", ""));
//			LOGGER.info("[PB] - PeticionVo a bitacorizar["+peticion+"]");
			
			if( persistencePeticion.guardar(peticion) )
			{
				regreso = true;
				LOGGER.info("[PB] - Se bitacoriza petición");
			}else
			{
				LOGGER.info("[PB] - No se bitacoriza petición");
			}
		}
//		catch (JAXBException jaxbException  ) {
//			LOGGER.error("[PB] - Error de JAXB al convertir a XML los objetos:CapturaRemotaRequest y CapturaRemotaResponse  ",jaxbException);
//		}
		catch (Exception exception) {
			LOGGER.error("[PB] - Error inesperado en el proceso de registro de la petición en la base de datos",exception);
		}
		return regreso;
	}

}
