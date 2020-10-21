package mx.org.infonavit.solicitud.oferente.catalogos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.MetodoConclusionAvaluoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;
/**
 * 
 * @author adrian.casas
 *
 */
@Service("CatalogoMetodoConclusionAvaluo")
public class CatalogoMetodoConclusionAvaluo {
	
	/**
	 * 
	 */
	private static final Logger LOGGER = LogManager.getLogger(CatalogoMetodoConclusionAvaluo.class);
	/**
	 * 
	 */
	private static final String PREFIJO = "[MCA] - ";
	
	/**
	 * 
	 */
	private static final String PROCESO = " Carga de catalogo metodo conclusión avaluos ";
	/**
	 * 
	 */
	private static final String CATALOGO = " Catalogo método conclusión avaluos ";
	/**
	 * 
	 */
	public static Map<Integer,String> CATALOGO_METODO_CONCLUSION;
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("MetodoConclusionAvaluoDao")
	public AbstractDao<MetodoConclusionAvaluoVo> persistence;
	
	/**
	 * 
	 */
	public void cargarCatalogo()
	{
		try
		{
			LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
			
			List<MetodoConclusionAvaluoVo> registros = persistence.buscarLista(null);
			
			if( registros!=null && !registros.isEmpty() )
			{
				CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION = new HashMap<Integer, String>();
				for( MetodoConclusionAvaluoVo registro  : registros  )
				{
					CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION.put(registro.getIdMetodo(),registro.getDescripcion());
				}
			}
			LOGGER.info(PREFIJO+PROCESO+FIN_OK);
		}catch (Exception e) {
			CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION = new HashMap<Integer, String>();
			LOGGER.info(PREFIJO+PROCESO+FIN_NOK);
			LOGGER.error(PREFIJO+PROCESO+ERROR,e);
		}
	}
	/**
	 * 
	 */
	public static void mostrarCatalogo()
	{
		LOGGER.info(PREFIJO+CATALOGO+CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION);
	}

}

