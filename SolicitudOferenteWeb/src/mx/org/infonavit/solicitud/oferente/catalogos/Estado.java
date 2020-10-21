package mx.org.infonavit.solicitud.oferente.catalogos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Clase que encapsula la carga del catalogo de estados
 * de la republica mexicana utilzados en el aplicativo 
 * módulo de ofrtas y sembrado.
 * @author Adrian Casas 
 *
 */
@Service("Estado")
public class Estado {
	
	private static final Logger LOGGER = LogManager.getLogger(Estado.class);
	private static final String PREFIJO_LOG = "[E] - ";
	private static final String PROCESO_CARGA_CATALOGO = "Carga catalogo de estados";
	
	public static final Map<String,String> CATALOGO_ESTADOS = new TreeMap<String, String>();

	
	public void cargarCatalogoEstados()
	{
		LOGGER.info(PREFIJO_LOG+PROCESO_CARGA_CATALOGO+INICIO_OK);
		Estado.CATALOGO_ESTADOS.put("01","AGUASCALIENTES");
		Estado.CATALOGO_ESTADOS.put("02","BAJA CALIFORNIA");
		Estado.CATALOGO_ESTADOS.put("03","BAJA CALIFORNIA SUR");
		Estado.CATALOGO_ESTADOS.put("04","CAMPECHE");
		Estado.CATALOGO_ESTADOS.put("05","COAHUILA DE ZARAGOZA");
		Estado.CATALOGO_ESTADOS.put("06","COLIMA");
		Estado.CATALOGO_ESTADOS.put("07","CHIAPAS");
		Estado.CATALOGO_ESTADOS.put("08","CHIHUAHUA");
		Estado.CATALOGO_ESTADOS.put("09","DISTRITO FEDERAL");
		Estado.CATALOGO_ESTADOS.put("10","DURANGO");
		Estado.CATALOGO_ESTADOS.put("11","GUANAJUATO");
		Estado.CATALOGO_ESTADOS.put("12","GUERRERO");
		Estado.CATALOGO_ESTADOS.put("13","HIDALGO");
		Estado.CATALOGO_ESTADOS.put("14","JALISCO");
		Estado.CATALOGO_ESTADOS.put("15","ESTADO DE MEXICO");
		Estado.CATALOGO_ESTADOS.put("16","MICHOACAN DE OCAMPO");
		Estado.CATALOGO_ESTADOS.put("17","MORELOS");
		Estado.CATALOGO_ESTADOS.put("18","NAYARIT");
		Estado.CATALOGO_ESTADOS.put("19","NUEVO LEON");
		Estado.CATALOGO_ESTADOS.put("20","OAXACA");
		Estado.CATALOGO_ESTADOS.put("21","PUEBLA");
		Estado.CATALOGO_ESTADOS.put("22","QUERETARO DE ARTEAGA");
		Estado.CATALOGO_ESTADOS.put("23","QUINTANA ROO");
		Estado.CATALOGO_ESTADOS.put("24","SAN LUIS POTOSI");
		Estado.CATALOGO_ESTADOS.put("25","SINALOA");
		Estado.CATALOGO_ESTADOS.put("26","SONORA");
		Estado.CATALOGO_ESTADOS.put("27","TABASCO");
		Estado.CATALOGO_ESTADOS.put("28","TAMAULIPAS");
		Estado.CATALOGO_ESTADOS.put("29","TLAXCALA");
		Estado.CATALOGO_ESTADOS.put("30","VERACRUZ LLAVE");
		Estado.CATALOGO_ESTADOS.put("31","YUCATAN");
		Estado.CATALOGO_ESTADOS.put("32","ZACATECAS");
		LOGGER.info(PREFIJO_LOG+PROCESO_CARGA_CATALOGO+FIN_OK);
	}
	
	public static void mostrarCatalogoEstados()
	{
		LOGGER.info(PREFIJO_LOG+"Catalogo estados: "+Estado.CATALOGO_ESTADOS);
	}
	
}
