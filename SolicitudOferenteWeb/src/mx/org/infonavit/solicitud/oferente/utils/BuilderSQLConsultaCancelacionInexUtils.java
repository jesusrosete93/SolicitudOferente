package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MAYOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MENOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PUNTO;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.WHERE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaCancelacionInexDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * <p>
 *     Clase que encapsula el procedimiento de creaci�n de la sentencia SQL para la 
 *     consulta de cancelaciones Inex. 
 * </p> 
 * @author Adrian Casas
 */
public class BuilderSQLConsultaCancelacionInexUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaCancelacionInexUtils.class);
	private static final String PREFIJO_LOG = "[BSQLCCIU] - ";

	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosConsultaCancelacionInexDomain criterios)
	{
		StringBuffer sentencia = null;
		StringBuffer condicion = new StringBuffer();
		
		final Class<?>   clase = criterios.getClass();
		final Field[] declaredFields = clase.getDeclaredFields();
		try
		{
		  sentencia = new StringBuffer( obtenerTablas(criterios) );
		for ( short i = 0; i < declaredFields.length; i++ )
		{
			final	Field 	field	= declaredFields[ i ];
			final   String propiedad =  field.getName();
			LOGGER.debug(PREFIJO_LOG+"Popiedad:["+propiedad+"]");
			if( propiedad.equalsIgnoreCase("serialVersionUID"))
			{
				continue;
			}else
			{
				if( BeanUtils.getProperty(criterios,propiedad)!=null &&  !BeanUtils.getProperty(criterios,propiedad).trim().equals("") )
				{
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PAQUETE_SQL.containsKey(propiedad))
					{
						if( propiedad.trim().equals("paquete"))
						{

						}else
						{
							String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PAQUETE_SQL.get(propiedad);
							CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(columna);
							if( condicion.length()>0 )condicion.append(AND);
							
							condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna()).append(IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(COMILLA);
						}
					}
					
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_SQL.containsKey(propiedad) )
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(columna);
						if( condicion.length()>0 )condicion.append(AND);

						if( ( propiedad.startsWith("fechaSolicitud") || propiedad.startsWith("fechaCancelacion")) && propiedad.indexOf("Inicio")>0 )
						{
							condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna()).append(MAYOR_IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(" 00:00").append(COMILLA);
						}else if( (propiedad.startsWith("fechaSolicitud") || propiedad.startsWith("fechaCancelacion")) && propiedad.indexOf("Fin")>0 )
						{
							condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna()).append(MENOR_IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(" 23:59").append(COMILLA);
						}else
						{
							condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna()).append(IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(COMILLA);
						}
					}
				}
			}
		}
		
			if( condicion.toString().length() > 0 )
			{
				sentencia.append(WHERE);
				sentencia.append( condicion.toString());
			}else
			{
				throw new IllegalArgumentException("No hay criterios de busqueda para generar la sentencia");
			}
		}catch (IllegalArgumentException e) {
			throw e;
		}catch(Exception exception)
		{
			LOGGER.error(PREFIJO_LOG+"Error a generar la condici�n sql",exception);
			sentencia = new StringBuffer("");
		}
		return sentencia.toString();
	}
	
	
	
	/**
	 * Genera una cadena de texto con las tablas .
	 * @param criterios parametros de busqueda
	 * @return cadena de texto
	 */
	public static String obtenerTablas(CriteriosConsultaCancelacionInexDomain criterios)
	{
		StringBuffer sentencia = null;
		
		boolean existeTablaPaquete=false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM cancelacion_avaluo  AS c WITH(NOLOCK)", "CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Tablas por criterios de busqueda - - - -
		if( (criterios.getRfcOferente()!=null && !criterios.getRfcOferente().trim().equals("")) 
			|| (criterios.getEstado()!=null  && !criterios.getEstado().trim().equals("")) )
		{
			existeTablaPaquete=true;
			sentencia.append(" LEFT JOIN paquete  AS p WITH(NOLOCK) ON p.id_paquete = c.id_paquete ");
		}
	

		if( !existeTablaPaquete )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN paquete  AS p WITH(NOLOCK) ON p.id_paquete = c.id_paquete ");
					break;
				}
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
			if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
			{
				sentencia.append(" LEFT JOIN cat_oferente AS o WITH(NOLOCK) ON p.rfc=o.rfc ");
				break;
			}
		}
		
		if( sentencia==null)
		{
			throw new IllegalArgumentException("No hay tablas a las cuales se les realize la consulta");
		}
		
		return sentencia.toString();
	}
	
	
	


}
