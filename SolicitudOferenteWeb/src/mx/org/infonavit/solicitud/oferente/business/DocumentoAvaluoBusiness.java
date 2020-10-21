package mx.org.infonavit.solicitud.oferente.business;

import mx.org.infonavit.solicitud.oferente.domain.DocumentoAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DocumentoAvaluoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("DocumentoAvaluoBusiness")
public class DocumentoAvaluoBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(DocumentoAvaluoBusiness.class);
	private static final String PREFIJO = "[DAB] - ";
	
	
	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static DocumentoAvaluoDomain getDomain(DocumentoAvaluoVo registro)
	{
		DocumentoAvaluoDomain domain = null;
		try
		{
			if( registro!= null )
			{
				domain = new DocumentoAvaluoDomain();
				domain.setIdRegistro(registro.getIdRegistro());
				domain.setIdAvaluo(registro.getIdAvaluo());
				domain.setIdDocumento(registro.getIdDocumento());
				if( registro.getDocumento()!=null)
				{
					domain.setDocumento(registro.getDocumento().getBytes(1,(int)registro.getDocumento().length()));
				}else
				{
					domain.setDocumento(null);
				}
				
			}
			
		}catch (Exception e) {
			LOGGER.error(PREFIJO+"Error al obtener la imagen del avaluo: "+registro.getIdAvaluo(),e);
		}
	  return domain;
	}
	
	
	
	

}
