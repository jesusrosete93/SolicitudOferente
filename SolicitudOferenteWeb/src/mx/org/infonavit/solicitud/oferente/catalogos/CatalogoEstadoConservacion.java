package mx.org.infonavit.solicitud.oferente.catalogos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EstadoConservacionVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CatalogoEstadoConservacion")
public class CatalogoEstadoConservacion {
	
	/**
	 * 
	 */
	private static final Logger LOGGER = LogManager.getLogger(CatalogoEstadoConservacion.class);
	/**
	 * 
	 */
	private static final String PREFIJO = "[CEC] - ";
	
	/**
	 * 
	 */
	private static final String PROCESO = " Carga de catalogo estado conservación ";
	/**
	 * 
	 */
	private static final String CATALOGO = " Catalogo estado conservación ";
	/**
	 * 
	 */
	public static Map<Integer,String> CATALOGO_ESTADO_CONSERVACION;
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("EstadoConservacionDao")
	public AbstractDao<EstadoConservacionVo> persistence;
	
	/**
	 * 
	 */
	public void cargarCatalogo()
	{
		try
		{
			LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
			
			List<EstadoConservacionVo> registros = persistence.buscarLista(null);
			
			if( registros!=null && !registros.isEmpty() )
			{
				CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION = new HashMap<Integer, String>();
				for( EstadoConservacionVo registro  : registros  )
				{
					CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION.put(registro.getIdEstadoConservacion(),registro.getDescripcion());
				}
			}
			LOGGER.info(PREFIJO+PROCESO+FIN_OK);
		}catch (Exception e) {
			CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION = new HashMap<Integer, String>();
			LOGGER.info(PREFIJO+PROCESO+FIN_NOK);
			LOGGER.error(PREFIJO+PROCESO+ERROR,e);
		}
	}
	/**
	 * 
	 */
	public static void mostrarCatalogo()
	{
		LOGGER.info(PREFIJO+CATALOGO+CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION);
	}

}
