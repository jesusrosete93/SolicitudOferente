package mx.org.infonavit.solicitud.oferente.catalogos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import mx.org.infonavit.solicitud.oferente.business.services.CatalogoBusinessService;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CamposBitacoraReasignacion")
public class CamposBitacoraReasignacion implements CatalogoBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(CamposBitacoraReasignacion.class);
	private static final String PREFIJO_LOG = "[CR] - ";
	private static final String CARGA_CATALOGO_CAMPOS_BITACORA_REASIGNACION = " Cargando catalogo campos bitcora reasignacion ";
	private static final String TEXTO_CATALOGO_CAMPOS_BITACORA_REASIGNACION = " Catalogo campos bitacora reasignacion ";
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_BITACORA_REASIGNACION;
	
	
	@Autowired
	@Qualifier("CatalogoCamposDao")
	AbstractDao<CampoBdVo> persistence;
	
	@Override
	public void cargarCatalogo(String... criterios) {
		
		try
		{
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_BITACORA_REASIGNACION+INICIO_OK);
			CampoBdVo criteriosBusqueda = new CampoBdVo();
			criteriosBusqueda.setIdTabla(22);
			List<CampoBdVo> registros = persistence.buscarLista(criteriosBusqueda);
			if( registros!=null && !registros.isEmpty())
			{
				CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo registro : registros )
				{
					CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.put(registro.getNombreColumna(),registro);
				}
			}
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_BITACORA_REASIGNACION+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_BITACORA_REASIGNACION+FIN_NOK);
			LOGGER.error(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_BITACORA_REASIGNACION+ERROR,e);
		}
		
	}
	
	
	/**
	 * <p>
	 * Método que muestra en archivo log los datos que contiene el catalogo.
	 * </p>
	 */
	public static void mostrarCatalogo() {
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_CAMPOS_BITACORA_REASIGNACION+CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION);
	}

}
