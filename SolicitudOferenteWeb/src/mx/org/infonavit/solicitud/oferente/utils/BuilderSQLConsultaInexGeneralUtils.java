package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PUNTO;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.WHERE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.Collection;

import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposInexGeneral;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaInexDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLConsultaInexGeneralUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaInexGeneralUtils.class);
	private static final String PREFIJO_LOG = "[BSCING] - ";

	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosConsultaInexDomain criterios)
	{
		StringBuilder sentencia = new StringBuilder("SELECT CAMPOS FROM inex_uv_gral AS igral WITH(NOLOCK)");
		StringBuilder condicion = new StringBuilder("");
		final Class<?>   clase = criterios.getClass();
		final Field[] declaredFields = clase.getDeclaredFields();
		try
		{
			
			
			for ( short i = 0; i < declaredFields.length; i++ )
			{
				final	Field 	field	= declaredFields[ i ];
				final   String propiedad =  field.getName();
				LOGGER.debug(PREFIJO_LOG+" Popiedad:["+propiedad+"]");
				if( propiedad.equalsIgnoreCase("serialVersionUID"))
				{
					continue;
				}else
				{
					if( validarPropiedadVacia(propiedad,criterios, field, clase)  )
					{
						if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_INEX_GENERAL_SQL.containsKey(propiedad))
						{
							String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_INEX_GENERAL_SQL.get(propiedad);
							CampoBdVo campo = CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(columna);
							if( condicion.length()>0 )condicion.append(AND);
//								if( propiedad.trim().equals("fechaInex")  )
//								{
//									condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna())
//											 .append(MAYOR_QUE).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(COMILLA);
//								}else
//								{
//									condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna())
//											 .append(IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(COMILLA);
//								}
								condicion.append(campo.getAliasTabla()).append(PUNTO).append(campo.getNombreColumna())
								 		 .append(IGUAL).append(COMILLA).append(BeanUtils.getProperty(criterios, propiedad)).append(COMILLA);
						}
					}
				}
			}
			if( condicion.toString().length() > 0 )
			{
				sentencia.append(WHERE);
				sentencia.append(condicion.toString());
			}else
			{
				throw new IllegalArgumentException("No hay criterios de busqueda para generar la sentencia");
			}
		}catch (IllegalArgumentException e) {
			throw e;
		}catch(Exception exception)
		{
			LOGGER.error(PREFIJO_LOG+"Error a generar la condición sql para la consulta de Inex general",exception);
		}
		LOGGER.debug(PREFIJO_LOG+"Sentencia generada: "+sentencia.toString());
		
		return reemplazar(sentencia.toString(),"CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) ;
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param criterios
	 * @param field
	 * @param clase
	 * @return
	 * @throws Exception
	 */
	public static boolean validarPropiedadVacia(String propiedad,CriteriosConsultaInexDomain criterios,Field field,Class<?> clase) throws Exception
	{
		if( Collection.class.isAssignableFrom(field.getType()))
		{
			String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
			Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
			Collection<?> elementos = (Collection<?>)objects;
			if( elementos!=null && !elementos.isEmpty() )
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			if( BeanUtils.getProperty(criterios,propiedad)!=null && !BeanUtils.getProperty(criterios,propiedad).trim().equals("") && !BeanUtils.getProperty(criterios,propiedad).trim().equals("0") )
			{
				return true;
			}else
			{
		      return false;
			}	
			
		}
	}
	
	
	
}
