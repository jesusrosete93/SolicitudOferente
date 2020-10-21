package mx.org.infonavit.solicitud.oferente.catalogos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.services.CatalogoBusinessService;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReporteInexUvPaqueteDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("Inex")
public class Inex implements CatalogoBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(Inex.class);
	private static final String PREFIJO_LOG = "[CIGB] - ";
	private static final String CARGA_CATALOGO_INEXS = " Cargando catalogo Inex's ";
	private static final String TEXTO_CATALOGO_INEXS = " Catalogo campos Inex's ";
	public static List<Integer> CATALOGO_INEX_REGISTRADOS;
	
	
	@Autowired
	@Qualifier("ReporteInexUvPaqueteDao")
	private AbstractReporteInexUvPaqueteDao<Object> persistence;
	
	@Override
	public void cargarCatalogo(String... criterios) {
		
		try
		{
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_INEXS+INICIO_OK);
			CampoBdVo criteriosBusqueda = new CampoBdVo();
			criteriosBusqueda.setIdTabla(21);
			List<Integer> registros = persistence.buscarInexRegistrados();
			if( registros!=null && !registros.isEmpty())
			{
				Inex.CATALOGO_INEX_REGISTRADOS = registros;
			}
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_INEXS+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_INEXS+FIN_NOK);
			LOGGER.error(PREFIJO_LOG+CARGA_CATALOGO_INEXS+ERROR,e);
		}
		
	}

	public static void mostrarCatalogo() {
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_INEXS+Inex.CATALOGO_INEX_REGISTRADOS);
	}

}
