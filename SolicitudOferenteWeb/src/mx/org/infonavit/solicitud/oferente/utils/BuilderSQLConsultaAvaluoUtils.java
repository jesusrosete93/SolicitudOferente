package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLConsultaAvaluoUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaAvaluoUtils.class);
	
	
	public static List<String> CAMPOS_LIKE = new ArrayList<String>();
	public static List<String> CAMPOS_IN = new ArrayList<String>();
	
	
	
	static 
	{
		CAMPOS_LIKE.add("nombre");
		CAMPOS_LIKE.add("paterno");
		CAMPOS_LIKE.add("materno");
		CAMPOS_LIKE.add("descripcion");
		CAMPOS_LIKE.add("id_paquete");
		CAMPOS_IN.add("id_estado");
		CAMPOS_IN.add("id_uv");
	}
	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosConsultaAvaluoDomain criterios)
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
			if( propiedad.equals("tipoLinea"))
			{
				LOGGER.info("En el tipo liena");
			}
			if( propiedad.equalsIgnoreCase("serialVersionUID"))
			{
				continue;
			}else
			{
				if( validarPropiedadVacia(propiedad,criterios, field, clase) )
				{
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
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
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.indexOf("Fin")>0 )
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
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else if( BuilderSQLConsultaUPCUtils.CAMPOS_IN.contains(columna) )
							{
								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
								Collection<?> elementos = (Collection<?>)objects;
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getElementosIN(elementos)+") ");
								
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
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
									}else
									{
										condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									}
								}
							}
						}
					}
//					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_COBERTURA_SQL.containsKey(propiedad))
//					{
//						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_COBERTURA_SQL.get(propiedad);
//						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(columna);
//						if( condicion.length()>0 )
//						{
//							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
//							{
//								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
//							}else if(BuilderSQLConsultaUPCUtils.CAMPOS_IN.contains(columna))
//							{
//								String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
//								Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
//								Collection<?> elementos = (Collection<?>)objects;
//								if( !elementos.isEmpty() )
//								{
////									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getEstadosIN(elementos)+") ");
//									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" IN ("+getEstadosIN(elementos)+") ");
//								}
//							}else
//							{
//								if(  propiedad.indexOf("Inicio")>0 )
//								{
//									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}else if(  propiedad.indexOf("Fin")>0 )
//								{
//									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}else
//								{
//									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}
//							}
//						}else
//						{
//							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
//							{
//								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
//							}else
//							{
//								if(  propiedad.indexOf("Inicio")>0 )
//								{
//									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}else if(  propiedad.indexOf("Fin")>0 )
//								{
//									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}else
//								{
//									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
//								}
//							}
//						}
//					}
					
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_VIVIENDA_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_VIVIENDA_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									if( propiedad.startsWith("fecha"))
									{
										condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+" 00:00'");
									}else
									{
										condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									}
									
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									if( propiedad.startsWith("fecha"))
									{
									  condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+" 23:59'");
									}else
									{
									  condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");	
									}
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_AVALUO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_AVALUO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									if( propiedad.startsWith("fecha"))
									{
										condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+" 00:00'");
									}else
									{
										condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									}
									
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									if( propiedad.startsWith("fecha"))
									{
									  condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+" 23:59'");
									}else
									{
									  condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");	
									}
								}else if( propiedad.trim().equals("estadosAvaluo"))
								{
									condicion.append(" AND SUBSTRING("+campo.getAliasTabla()+"."+campo.getNombreColumna()+",0,3) IN ("+getEstadosAvaluosIN(criterios.getEstadosAvaluo())+")");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( propiedad.trim().equals("estadosAvaluo"))
								{
									condicion.append("  SUBSTRING("+campo.getAliasTabla()+"."+campo.getNombreColumna()+",0,3) IN ("+getEstadosAvaluosIN(criterios.getEstadosAvaluo())+")");
									
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_DETALLE_AVALUO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_DETALLE_AVALUO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(columna);
						if( condicion.length()>0 )
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
									
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
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
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
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
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}else
						{
							if( BuilderSQLConsultaAvaluoUtils.CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if(  propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if(  propiedad.indexOf("Fin")>0 )
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
	public static String obtenerTablas(CriteriosConsultaAvaluoDomain criterios)
	{
		StringBuffer sentencia = null;
		boolean existeTablaUnidadValuacion=false;
		boolean existeTablaDetalleAvaluo=false;
		boolean existeTablaPerito=false;
		boolean existeTablaControlador=false;
		boolean existeTablaCobertura=false;
		boolean existeTablaVivienda= false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM avaluo AS a WITH(NOLOCK) ","CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Obtención de tablas por criterios de busqueda
		if( !criterios.getNss().trim().equals("") || !criterios.getCodigoPostal().trim().equals("") )
		{
			sentencia.append(" LEFT JOIN vivienda  AS v WITH(NOLOCK) ON a.id_paquete = v.id_paquete AND a.id_vivienda=v.id_vivienda");
			existeTablaVivienda=true;
		}
		
		
		
		if( !criterios.getUnidadesValuacion().isEmpty() || 
			!criterios.getUnidadViviendaRecuperada().trim().equals(""))
		{
			
			sentencia.append(" LEFT JOIN cat_uv  AS uv WITH(NOLOCK) ON uv.id_uv = a.id_uv");
			existeTablaUnidadValuacion=true;
			
		}
		
//		if( 	!criterios.getEstadosCobertura().isEmpty() || 
//				!criterios.getEstatusCobertura().equals("") )
//			{
//			    sentencia.append(" LEFT JOIN cobertura_uv  AS cb WITH(NOLOCK) ON cb.id_uv = a.id_uv");
//			    existeTablaCobertura=true;
//				
//			}
		if(	!criterios.getValorConcluidoInicio().trim().equals("") || !criterios.getValorConcluidoFin().equals("") || 
			!criterios.getMetrosConstruccionInicio().trim().equals("") || !criterios.getMetrosConstruccionFin().trim().equals("") ||
			!criterios.getMetrosTerrenoInicio().trim().equals("") || !criterios.getMetrosTerrenoFin().trim().equals("") 
		  )
		  {
			sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
			existeTablaDetalleAvaluo=true;
		  }
		
		if(	!criterios.getClaveSHFControlador().trim().equals("") || !criterios.getApellidoPaternoControlador().equals("") || 
			!criterios.getApellidoMaternoControlador().trim().equals("") || !criterios.getNombreControlador().trim().equals("") ||
			!criterios.getEstatusControlador().trim().equals("") 
		  )
		  {
			existeTablaControlador=true;
			
			if( !existeTablaDetalleAvaluo )
			{
			 sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
			 existeTablaDetalleAvaluo=true;
			}
			sentencia.append(" LEFT JOIN cat_controlador AS cc WITH(NOLOCK) ON cc.id_controlador_shf = d.id_controlador_shf");
		  }
		if(	!criterios.getClaveSHFPerito().trim().equals("") || !criterios.getApellidoPaternoPerito().equals("") || 
			!criterios.getApellidoMaternoPerito().trim().equals("") || !criterios.getNombrePerito().trim().equals("") || 
			!criterios.getEstatusPerito().trim().equals("") 
			  )
			  {
				existeTablaPerito=true;
				if( !existeTablaDetalleAvaluo )
				{
				 sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
				 existeTablaDetalleAvaluo=true;
				}
				sentencia.append(" LEFT JOIN cat_perito AS pe WITH(NOLOCK) ON pe.id_perito_shf = d.id_perito_shf");
			  }
		
		//Obtención de tablas por campos a obtener - - -  -
		if( !existeTablaUnidadValuacion )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cat_uv  AS uv WITH(NOLOCK) ON uv.id_uv = a.id_uv");
					break;
				}
			}
		}
		if( !existeTablaCobertura )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN cobertura_uv  AS cb WITH(NOLOCK) ON cb.id_uv = a.id_uv");
					break;
				}
			}
		}
		
		if( !existeTablaVivienda )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN vivienda AS v WITH(NOLOCK) ON v.id_paquete = a.id_paquete and v.id_vivienda = a.id_vivienda");
					break;
				}
			}
		}
		
		if( !existeTablaDetalleAvaluo )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
					existeTablaDetalleAvaluo=true;
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
					if( !existeTablaDetalleAvaluo )
					{
						sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
						existeTablaDetalleAvaluo=true;
					}
					
					sentencia.append(" LEFT JOIN cat_controlador AS cc WITH(NOLOCK) ON cc.id_controlador_shf = d.id_controlador_shf");
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
					if( !existeTablaDetalleAvaluo )
					{
						sentencia.append(" LEFT JOIN detalle_avaluo AS d WITH(NOLOCK) ON d.id_avaluo = a.id_avaluo");
						existeTablaDetalleAvaluo=true;
					}
					
					sentencia.append(" LEFT JOIN cat_perito AS pe WITH(NOLOCK) ON pe.id_perito_shf = d.id_perito_shf");
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
	 * Obtiene una cadena de texto con el formato de instrucción IN SQL de los
	 * elementos de la lista, en este caso son id de estados.
	 * @param estados listado de estados
	 * @return cadena de texto con los elementos de la lista separados por comas y entre comillas simples
	 */
	public static String getEstadosAvaluosIN(Collection<?> estados)
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
					sb.append(",'0"+estado+"'");
				}else
				{
					sb.append("'0"+estado+"'");
				}
			}else
			{
				if( sb.length()!=0)
				{
					sb.append(",'"+estado+"'");
				}else
				{
					sb.append("'"+estado+"'");
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
	public static boolean validarPropiedadVacia(String propiedad,CriteriosConsultaAvaluoDomain criterios,Field field,Class<?> clase) throws Exception
	{
		if( Collection.class.isAssignableFrom(field.getType()))
		{
			String targetMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + (field.getName().substring(1));
			Object objects = clase.getMethod(targetMethodName).invoke(criterios, new Object[] {});
			Collection<?> elementos = (Collection<?>)objects;
			if( !elementos.isEmpty() )
			{
				return true;
			}else
			{
				return false;
			}
		}else
		{
			if( BeanUtils.getProperty(criterios,propiedad)!=null )
			{
				if( !BeanUtils.getProperty(criterios,propiedad).trim().equals("") )
				{
					return true;
				}else
				{
					return false;
				}
			}else
			{
		      return false;
			}	
			
		}
	}


}

