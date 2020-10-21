package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosSancionesDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class BuilderSQLConsultaSancionesUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaSancionesUtils.class);
	
	
	public static List<String> CAMPOS_LIKE = new ArrayList<String>();
	
	static 
	{
		CAMPOS_LIKE.add("descripcion");
		CAMPOS_LIKE.add("ClaveSHF");
		CAMPOS_LIKE.add("paterno");
		CAMPOS_LIKE.add("materno");
		CAMPOS_LIKE.add("nombre");
	}
	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosSancionesDomain criterios)
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
			LOGGER.debug("[BSQLS] - Popiedad:["+propiedad+"]");
			if( propiedad.equalsIgnoreCase("serialVersionUID"))
			{
				continue;
			}else
			{
				if( BeanUtils.getProperty(criterios,propiedad)!=null &&  !BeanUtils.getProperty(criterios,propiedad).trim().equals("") )
				{
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_SANCION_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_SANCION_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.startsWith("fecha") && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+" 00:00'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+" 23:59'");
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
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+" 00:00'");
								}else if( propiedad.startsWith("fecha") && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+" 23:59'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.containsKey(propiedad) && !propiedad.trim().equals("claveUnidadValuacion"))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(columna);
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_DELEGACION_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_DELEGACION_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(columna);
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CONTROLADOR_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CONTROLADOR_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(columna);
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PERITO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_PERITO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(columna);
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
	public static String obtenerTablas(CriteriosSancionesDomain criterios)
	{
		StringBuffer sentencia = null;
		
		boolean existeTablaCatalogoUV=false;
		boolean existeTablaDelegacion=false;
		boolean existeTablaControlador=false;
		boolean existeTablaPerito=false;
		
		boolean existeTablaSancionado=false;
		boolean existeTablaTipoSancion=false;
		boolean existeTablaSancionador=false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM sancion AS sa WITH(NOLOCK)", "CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Tablas por criterios de busqueda - - - -
		if(     !criterios.getNombreUnidadValuacion().trim().equals("") ||
				!criterios.getClaveSHFUnidadValuacion().trim().equals("") || !criterios.getSiglasUnidadValuacion().trim().equals("") )
		{
			existeTablaCatalogoUV=true;
			sentencia.append(" LEFT JOIN cat_uv AS uv WITH(NOLOCK) ON uv.id_uv = sa.id_registro ");
		}
	
		if(  !criterios.getClaveEstadoCobertura().trim().equals("")  )
		{
			existeTablaDelegacion=true;
			sentencia.append("LEFT JOIN cat_delegacion AS cd WITH(NOLOCK) ON cd.id_estado = sa.id_estado");
		}
		
		if(  !criterios.getClaveSHFControlador().equals("") ||
				 !criterios.getApellidoPaternoControlador().trim().equals("") ||	
				 !criterios.getApellidoMaternoControlador().trim().equals("") ||
				 !criterios.getNombreControlador().trim().equals("") 
		   )
			{
				existeTablaControlador=true;
				sentencia.append(" LEFT JOIN cat_controlador AS cc WITH(NOLOCK) ON CAST(cc.id_controlador_shf AS int) = CAST(sa.id_registro AS int)");
			}

		if(  !criterios.getClaveSHFPerito().equals("") ||
				 !criterios.getApellidoPaternoPerito().trim().equals("") ||	
				 !criterios.getApellidoMaternoPerito().trim().equals("") ||
				 !criterios.getNombrePerito().trim().equals("") 
		  ) 
			{
				existeTablaPerito=true;
				sentencia.append(" LEFT JOIN cat_perito AS pe WITH(NOLOCK) ON CAST(pe.id_perito_shf AS INT) = CAST(sa.id_registro AS INT) ");
			}

				
		if( !existeTablaCatalogoUV )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cat_uv AS uv WITH(NOLOCK) ON uv.id_uv = sa.id_registro ");
					break;
				}
			}
		}
		if( !existeTablaDelegacion )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append("LEFT JOIN cat_delegacion AS cd WITH(NOLOCK) ON cd.id_estado = sa.id_estado");
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
					sentencia.append(" LEFT JOIN cat_controlador AS cc WITH(NOLOCK) ON CAST(cc.id_controlador_shf AS int) = CAST(sa.id_registro AS int)");
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
					sentencia.append(" LEFT JOIN cat_perito AS pe WITH(NOLOCK) ON CAST(pe.id_perito_shf AS INT) = CAST(sa.id_registro AS INT) ");
					break;
				}
			}
		}
		
		
		if(!existeTablaSancionado)
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cat_sancionado AS CS WITH(NOLOCK) ON cs.id_sancionado = sa.id_sancionado ");
					break;
				}
			}
		}
		
		if(!existeTablaTipoSancion)
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cat_tipo_sancion AS cts WITH(NOLOCK) ON cts.id_tipo_sancion = sa.id_tipo_sancion");
					break;
				}
			}
		}
		
		if(!existeTablaSancionador)
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cat_sancionador AS csr WITH(NOLOCK) on csr.id_sancionador = sa.id_sancionador ");
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
