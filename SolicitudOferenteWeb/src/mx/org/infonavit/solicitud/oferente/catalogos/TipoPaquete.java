package mx.org.infonavit.solicitud.oferente.catalogos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import mx.org.infonavit.solicitud.oferente.business.services.CatalogoBusinessService;
import mx.org.infonavit.solicitud.oferente.domain.TipoPaqueteDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("TipoPaquete")
public class TipoPaquete implements CatalogoBusinessService {
	
	private static final Logger LOGGER = LogManager.getLogger(TipoPaquete.class);
	private static final String PREFIJO_LOG = "[TP] - ";
	private static final String CARGA_CATALOGO_TIPO_PAQUETE = " Cargando catalogo tipo paquete Inex ";
	private static final String TEXTO_CATALOGO_TIPO_PAQUETE  = " Catalogo campos tipo paquete Inex ";
	private static final String TEXTO_CATALOGO_TIPO_PAQUETES  = " Catalogo tipos paquete ";
	public static Map<Integer,TipoPaqueteDomain> CATALOGO_TIPO_PAQUETE_DOMAIN;
	public static Map<String,String> CATALOGO_TIPO_PAQUETES;
	public static Map<Integer,String> CATALOGO_TIPO_PAQUETE;
	
	
	@Override
	public void cargarCatalogo(String... criterios) {
		
		try
		{
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_TIPO_PAQUETE+INICIO_OK);

			TipoPaquete.CATALOGO_TIPO_PAQUETE = new LinkedHashMap<Integer,String>();
			TipoPaquete.CATALOGO_TIPO_PAQUETE_DOMAIN = new LinkedHashMap<Integer,TipoPaqueteDomain>();
			
			TipoPaquete.CATALOGO_TIPO_PAQUETE.put(1,"Nuevo");
			TipoPaquete.CATALOGO_TIPO_PAQUETE.put(2,"Anterior al Inex");
			
			TipoPaquete.CATALOGO_TIPO_PAQUETE_DOMAIN.put(1,new TipoPaqueteDomain(1,"Nuevo"));
			TipoPaquete.CATALOGO_TIPO_PAQUETE_DOMAIN.put(2,new TipoPaqueteDomain(2,"Anterior al Inex"));
			
			TipoPaquete.CATALOGO_TIPO_PAQUETES = new HashMap<String, String>();
			TipoPaquete.CATALOGO_TIPO_PAQUETES.put("N","Nuevo");
			TipoPaquete.CATALOGO_TIPO_PAQUETES.put("V","Anterior al Inex");
			
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_TIPO_PAQUETE+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_LOG+CARGA_CATALOGO_TIPO_PAQUETE+FIN_NOK);
			LOGGER.error(PREFIJO_LOG+CARGA_CATALOGO_TIPO_PAQUETE+ERROR,e);
		}
		
	}
	
	

	public static void mostrarCatalogo() {
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_TIPO_PAQUETE+TipoPaquete.CATALOGO_TIPO_PAQUETE);
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_TIPO_PAQUETE+TipoPaquete.CATALOGO_TIPO_PAQUETE);
		LOGGER.info(PREFIJO_LOG+TEXTO_CATALOGO_TIPO_PAQUETES+TipoPaquete.CATALOGO_TIPO_PAQUETES);
	}

}
