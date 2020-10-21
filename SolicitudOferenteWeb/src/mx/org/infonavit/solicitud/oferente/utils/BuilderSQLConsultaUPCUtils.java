package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaUPCDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLConsultaUPCUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaUPCUtils.class);
	
	
	public static List<String> CAMPOS_LIKE = new ArrayList<String>();
	public static List<String> CAMPOS_IN = new ArrayList<String>();
	
	
	
	static 
	{
		CAMPOS_LIKE.add("nombre");
		CAMPOS_LIKE.add("paterno");
		CAMPOS_LIKE.add("materno");
		CAMPOS_LIKE.add("descripcion");
		CAMPOS_IN.add("id_estado");
		CAMPOS_IN.add("id_uv");
	}
	
	
	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosConsultaUPCDomain criterios)
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
				if( validarPropiedadVacia(propiedad,criterios, field, clase)  )
				{
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else if( BuilderSQLConsultaUPCUtils.CAMPOS_IN.contains(columna) )
							{
								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
								Collection<?> elementos = (Collection<?>)objects;
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getElementosIN(elementos)+") ");
								
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
									if( propiedad.trim().equals("unidadViviendaRecuperada")  )
									{
										if( BeanUtils.getProperty(criterios, propiedad).trim().equals("2") )
										{
											condicion.append(" AND ("+campo.getAliasTabla()+"."+campo.getNombreColumna()+"!='1' OR "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IS NULL) ");
										}else
										{
											condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
										}
									}else
									{
										condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									}
									
								}
							}
						}else
						{
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else if( BuilderSQLConsultaUPCUtils.CAMPOS_IN.contains(columna) )
							{
								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
								Collection<?> elementos = (Collection<?>)objects;
								if( propiedad.trim().equals("estadosCobertura"))
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getEstadosIN(elementos)+") ");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getElementosIN(elementos)+") ");
								}
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
									if( propiedad.trim().equals("unidadViviendaRecuperada")  )
									{
										if( BeanUtils.getProperty(criterios, propiedad).trim().equals("2") )
										{
											condicion.append("  ("+campo.getAliasTabla()+"."+campo.getNombreColumna()+"!='1' OR "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IS NULL) ");
										}else
										{
											condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
										}
									}else if( propiedad.trim().equals("clavesUnidadesValuacion"))
									{
										String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
										Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
										Collection<?> elementos = (Collection<?>)objects;
										if( !elementos.isEmpty() )
										{
											condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getElementosIN(elementos)+") ");
										}
										
									}else
									{
										condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									}
									
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_COBERTURA_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_COBERTURA_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else if(propiedad.trim().equals("estadosCobertura"))
							{
								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
								Collection<?> elementos = (Collection<?>)objects;
								if( !elementos.isEmpty() )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getEstadosIN(elementos)+") ");
								}
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
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else if(propiedad.trim().equals("estadosCobertura"))
							{
								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
								Collection<?> elementos = (Collection<?>)objects;
								if( !elementos.isEmpty() )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getEstadosIN(elementos)+") ");
								}
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CONTROLADOR_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CONTROLADOR_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
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
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PERITO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PERITO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
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
							if( BuilderSQLConsultaUPCUtils.CAMPOS_LIKE.contains(columna) )
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
	public static String obtenerTablas(CriteriosConsultaUPCDomain criterios)
	{
		StringBuffer sentencia = null;
		boolean existeTablaControlador=false;
		boolean existeTablaPerito=false;
		boolean existeTablaCobertura=false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM CAT_UV AS uv WITH(NOLOCK) ","CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Tablas
		if( !criterios.getEstatusCobertura().trim().equals("") || !criterios.getEstadosCobertura().isEmpty() )
		{
			existeTablaCobertura=true;
			sentencia.append(" left join cobertura_UV  AS cb WITH(NOLOCK) on uv.id_uv = cb.id_uv");
			
		}
	
		if(  !criterios.getClaveSHFControlador().equals("") ||
			 !criterios.getApellidoPaternoControlador().trim().equals("") ||	
			 !criterios.getApellidoMaternoControlador().trim().equals("") ||
			 !criterios.getNombreControlador().trim().equals("") ||
			 !criterios.getCurpControlador().trim().equals("") ||
			 !criterios.getRfcControlador().trim().equals("") ||
			 !criterios.getFechaVigenciaInicioControlador().trim().equals("") ||
			 !criterios.getFechaVigenciaFinControlador().trim().equals("") ||
			 !criterios.getEstatusControlador().trim().equals("") 
			  )
		{
			existeTablaControlador=true;
			sentencia.append(" left join controlador_uv as cu WITH(NOLOCK) on cu.id_uv = uv.id_uv");
			sentencia.append(" left join cat_controlador as cc WITH(NOLOCK) on cc.id_controlador_shf = cu.id_controlador_shf");
		}

		if(  !criterios.getClaveSHFPerito().equals("") ||
			 !criterios.getApellidoPaternoPerito().trim().equals("") ||	
			 !criterios.getApellidoMaternoPerito().trim().equals("") ||
			 !criterios.getNombrePerito().trim().equals("") ||
			 !criterios.getCurpPerito().trim().equals("") ||
			 !criterios.getRfcPerito().trim().equals("") ||
			 !criterios.getFechaVigenciaInicioPerito().trim().equals("") ||
			 !criterios.getFechaVigenciaFinPerito().trim().equals("") ||
			 !criterios.getEstatusPerito().trim().equals("") ) 

		{
			existeTablaPerito=true;
			sentencia.append(" left join perito_uv as pu WITH(NOLOCK) on pu.id_uv = uv.id_uv ");
			sentencia.append(" left join cat_perito as pe WITH(NOLOCK) on pe.id_perito_shf = pu.id_perito_shf");
		}
		
		if( !existeTablaCobertura )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join cobertura_UV  as cb WITH(NOLOCK) on uv.id_uv = cb.id_uv");
					break;
				}
			}
		}
		if( !existeTablaControlador )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join controlador_uv as cu WITH(NOLOCK) on cu.id_uv = uv.id_uv");
					sentencia.append(" left join cat_controlador as cc WITH(NOLOCK) on cc.id_controlador_shf = cu.id_controlador_shf");
					break;
				}
			}
		}
		
		if( !existeTablaPerito)
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITO.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join perito_uv as pu WITH(NOLOCK) on pu.id_uv = uv.id_uv ");
					sentencia.append(" left join cat_perito as pe WITH(NOLOCK) on pe.id_perito_shf = pu.id_perito_shf");
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
	
	/**
	 * Obtiene una cadena de texto con el formato de instrucción IN SQL de los
	 * elementos de la lista, en este caso son id de estados.
	 * @param estados listado de estados
	 * @return cadena de texto con los elementos de la lista separados por comas y entre comillas simples
	 */
	public static String getEstadosIN(Collection<?> estados)
	{
		StringBuffer sb = new StringBuffer();
		
		Iterator<?> iterator = estados.iterator();
		while( iterator.hasNext())
		{
			String estado = (String)iterator.next();
			if( Integer.parseInt(estado) <= 9 )
			{
				if( sb.length()!=0)
				{
					sb.append(",'0"+estado+"000'");
				}else
				{
					sb.append("'0"+estado+"000'");
				}
			}else
			{
				if( sb.length()!=0)
				{
					sb.append(",'"+estado+"000'");
				}else
				{
					sb.append("'"+estado+"000'");
				}
			}
		}
 	  return sb.toString();
	}
	/**
	 * Obtiene una cadena de texto en formato de instrucción IN SQL de
	 * los elementos de la lista
	 * @param estados listado de estados
	 * @return cadena de texto con los elementos de la lista separados por comas y entre comillas simples
	 */
	public static String getElementosIN(Collection<?> elementos)
	{
		StringBuffer sb = new StringBuffer();
		

		Iterator<?> iterator = elementos.iterator();
		while( iterator.hasNext())
		{
			if( sb.length()!=0)
			{
				sb.append(",'"+(String)iterator.next()+"'");
			}else
			{
				sb.append("'"+(String)iterator.next()+"'");
			}
		}
	
		
		return sb.toString();
	}
	
	
	
	/**
	 * 
	 * @param criterios
	 * @param field
	 * @param clase
	 * @return
	 * @throws Exception
	 */
	public static boolean validarPropiedadVacia(String propiedad,CriteriosConsultaUPCDomain criterios,Field field,Class<?> clase) throws Exception
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
			if( BeanUtils.getProperty(criterios,propiedad)!=null && !BeanUtils.getProperty(criterios,propiedad).trim().equals("") )
			{
				return true;
			}else
			{
		      return false;
			}	
			
		}
	}
	
	
	
}
