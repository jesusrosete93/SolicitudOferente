package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosAsignacionesDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLConsultaAsignacionesUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaAsignacionesUtils.class);
	
	
	public static List<String> CAMPOS_LIKE = new ArrayList<String>();
	
	static 
	{
		CAMPOS_LIKE.add("nombre_frente");
		
	}
	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosAsignacionesDomain criterios)
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
			LOGGER.debug("[BSQLU] - Popiedad:["+propiedad+"]");
			if( propiedad.equalsIgnoreCase("serialVersionUID"))
			{
				continue;
			}else
			{
				if( !BeanUtils.getProperty(criterios,propiedad).trim().equals("") )
				{
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PAQUETE_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PAQUETE_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_BITACORA_REASIGNACION_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_BITACORA_REASIGNACION_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_TEMPORAL_REASIGNACIONES_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_TEMPORAL_REASIGNACIONES_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
				}
			}
		}
		
			if( condicion.toString().length() > 0 )
			{
				sentencia.append(" WHERE ");
				sentencia.append( condicion.toString());
			}else
			{
				throw new IllegalArgumentException("No hay criterios de busqueda para generar la sentencia");
			}
		}catch (IllegalArgumentException e) {
			throw e;
		}catch(Exception exception)
		{
			LOGGER.error("[BSQLU] - Error a generar la condición sql",exception);
			sentencia = new StringBuffer("");
		}
		return sentencia.toString();
	}
	
	
	
	/**
	 * Genera una cadena de texto con las tablas .
	 * @param criterios parametros de busqueda
	 * @return cadena de texto
	 */
	public static String obtenerTablas(CriteriosAsignacionesDomain criterios)
	{
		StringBuffer sentencia = null;
		
		boolean existeTablaBitacora=false;
		boolean existeTablaTemporal=false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM paquete AS p WITH(NOLOCK) ","CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Tablas
		if( !criterios.getUnidadValuacionAnterior().trim().equals("") && !criterios.getFechaReAsignacionInicio().equals("") && criterios.getFechaReAsignacionFin().trim().equals("") )
		{
			existeTablaBitacora=true;
			sentencia.append(" left join bitacora_Reasignacion_Inex as bi WITH(NOLOCK) on bi.id_paquete = p.id_paquete");
			
		}
	
		if(  !criterios.getTipoReasignacion().equals("")  )
		{
			existeTablaTemporal=true;
			sentencia.append(" left join temporalasignaciones as te WITH(NOLOCK) on te.idpaquete = p.id_paquete");
		}

				
		if( !existeTablaBitacora )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join bitacora_Reasignacion_Inex as bi WITH(NOLOCK) on bi.id_paquete = p.id_paquete");
					break;
				}
			}
		}
		if( !existeTablaTemporal )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join temporalasignaciones as te WITH(NOLOCK) on te.idpaquete = p.id_paquete");
					break;
				}
			}
		}
		
		
		
		if( sentencia==null)
		{
			throw new IllegalArgumentException("No hay tablas a las cuales se les realize la consulta");
		}
		
		return sentencia.toString();
	}
	
	
	


}
