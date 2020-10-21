package mx.org.infonavit.solicitud.oferente.business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import mx.org.infonavit.solicitud.oferente.utils.Resources;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PropertiesBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(PropertiesBusiness.class);
	
	/**
	 * Asigna los valores del archivo de properties para 
	 * la configuración de bitacora
	 */
	public void cargarProperties()
	{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(Resources.CONSTANTES_CONFIG));
			Resources.REGISTROS_POR_CONSULTA = Integer.parseInt(prop.getProperty("registros"));
			Resources. EP_SERVICIO_NEXURA = prop.getProperty("url");
		} catch (FileNotFoundException e) {
			LOGGER.error("[PB] - Error al leer properties de la bitacora",e);
			Resources.REGISTROS_POR_CONSULTA  = 1000;
			Resources. EP_SERVICIO_NEXURA = "";
		} catch (IOException e) {
			LOGGER.error("[PB] - Error al leer properties de la bitacora",e);
			Resources. EP_SERVICIO_NEXURA = "";
		}
	}
	
	
	public void modificarProperties(int registros,String url)
	{
		Properties prop = new Properties();
		OutputStream output = null;
		InputStream  input = null;

		try {

			input = new FileInputStream(Resources.CONSTANTES_CONFIG);
			prop.load(input);
			input.close();
			
			//Asignando 
			prop.setProperty("registros",String.valueOf(registros));
			prop.setProperty("url",url);
			
			
			System.out.println("Escribiendo....");
			output = new FileOutputStream(Resources.CONSTANTES_CONFIG);
			prop.store(output,"Valores constantes");
			output.close();
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Muestra los valores cargados para las bitacoras de SAP HANNA
	 */
	public static void mostrarProperties()
	{
		LOGGER.info("[PB] - Registros permitidos por consulta: ["+Resources.REGISTROS_POR_CONSULTA+"]");
		LOGGER.info("[PB] - Servicio Nexura: ["+Resources.EP_SERVICIO_NEXURA+"]");
	}
		
}
