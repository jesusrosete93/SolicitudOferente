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

@Service("CamposInexGeneral")
public class CamposInexGeneral implements CatalogoBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(CamposInexGeneral.class);
	private static final String PREFIJO_LOG = "[CIGB] - ";
	private static final String CARGA_CATALOGO_CAMPOS_INEX_GENERAL = " Cargando catalogo campos Inex General ";
	private static final String TEXTO_CATALOGO_CAMPOS_INEX_GENERAL = " Catalogo campos Inex General ";
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_INEX_GENERAL;
	
	
	@Autowired
	@Qualifier("CatalogoCamposDao")
	AbstractDao<CampoBdVo> persistence;
	
	@Override
	public void cargarCatalogo(String... criterios) {
		
		try
		{
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_INEX_GENERAL+INICIO_OK);
			CampoBdVo criteriosBusqueda = new CampoBdVo();
			criteriosBusqueda.setIdTabla(21);
			List<CampoBdVo> registros = persistence.buscarLista(criteriosBusqueda);
			if( registros!=null && !registros.isEmpty())
			{
				CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo registro : registros )
				{
					CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.put(registro.getNombreColumna(),registro);
				}
			}
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_INEX_GENERAL+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_INEX_GENERAL+FIN_NOK);
			LOGGER.error(PREFIJO_LOG+CARGA_CATALOGO_CAMPOS_INEX_GENERAL+ERROR,e);
		}
		
	}
	
	

	public static void mostrarCatalogo() {
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_CAMPOS_INEX_GENERAL+CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL);
	}

}
