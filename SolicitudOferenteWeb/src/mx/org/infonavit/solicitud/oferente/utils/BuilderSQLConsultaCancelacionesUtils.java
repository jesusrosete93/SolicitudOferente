package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCancelacioneaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLConsultaCancelacionesUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaCancelacionesUtils.class);
	
	
	public static List<String> CAMPOS_LIKE = new ArrayList<String>();
	
	static 
	{
		
	}
	
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosCancelacioneaDomain criterios)
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
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_UV_SQL.containsKey(propiedad))
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
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
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
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
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
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(columna);
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
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
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
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"<='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else
								{
									condicion.append("  "+campo.getAliasTabla()+"."+campo.getNombreColumna()+"='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}
							}
						}
					}
					if( BuilderMapeosBeanSQLUtils.MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL.containsKey(propiedad))
					{
						String columna =  BuilderMapeosBeanSQLUtils.MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL.get(propiedad);
						CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(columna);
						if( condicion.length()>0 )
						{
							if( CAMPOS_LIKE.contains(columna) )
							{
								condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+" LIKE '%"+BeanUtils.getProperty(criterios, propiedad)+"%'");
							}else
							{
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" AND "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
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
								if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Inicio")>0 )
								{
									condicion.append(" "+campo.getAliasTabla()+"."+campo.getNombreColumna()+">='"+BeanUtils.getProperty(criterios, propiedad)+"'");
								}else if( ( propiedad.startsWith("fecha") || propiedad.startsWith("vivienda") ) && propiedad.indexOf("Fin")>0 )
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
	public static String obtenerTablas(CriteriosCancelacioneaDomain criterios)
	{
		StringBuffer sentencia = null;
		
		boolean existeTablaHistoricoValorConcluido=false;
		boolean existeTablaAvaluoRespaldoCancelacion=false;
		
		
		//Campos
		if( !ConsultaAvaluosGenericaBusiness.DATOS.isEmpty() )
		{
			sentencia = new StringBuffer( reemplazar("SELECT CAMPOS FROM cancelacion_avaluo AS c WITH(NOLOCK)","CAMPOS",ConsultaAvaluosGenericaBusiness.DATOS.toString().replace("[","").replace("]","")) );
		}else
		{
			throw new IllegalArgumentException("No hay campos para generar la sentencia SQL");
		}
		
		//Tablas
		if( !criterios.getValorConcluidoInicio().trim().equals("") && !criterios.getValorConcluidoFin().equals("") )
		{
			existeTablaHistoricoValorConcluido=true;
			sentencia.append(" left join historico_valor_concluido as h WITH(NOLOCK) ON h.id_avaluo = c.id_avaluo");
			
		}
		
		
		if( !criterios.getClaveUnidadValuacion().trim().equals("")  ||  !criterios.getNombreUnidadValuacion().trim().equals("") )
		{
			
			sentencia.append(" left join avaluo_resp_cancelacion as a WITH(NOLOCK) on a.id_avaluo = c.id_avaluo");
			sentencia.append(" left join cat_uv as uv WITH(NOLOCK) on a.id_avaluo = c.id_avaluo");
			existeTablaAvaluoRespaldoCancelacion= true;
			
		}
		
	
		if(     !criterios.getIdConviviencia().trim().equals("") 
				|| (!criterios.getFechaCierreInicio().trim().equals("") && !criterios.getFechaCierreFin().trim().equals(""))
				|| (!criterios.getFechaSolicitudInicio().trim().equals("") && !criterios.getFechaSolicitudFin().trim().equals(""))
				|| !criterios.getEstatusAvaluo().trim().equals("")
		  )
		{
			if( !existeTablaAvaluoRespaldoCancelacion )
			{
				sentencia.append(" left join avaluo_resp_cancelacion as a WITH(NOLOCK) on a.id_avaluo = c.id_avaluo");
				existeTablaAvaluoRespaldoCancelacion= true;
			}
		}

				
		if( !existeTablaHistoricoValorConcluido )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join historico_valor_concluido as h WITH(NOLOCK) on h.id_avaluo = c.id_avaluo");
					existeTablaHistoricoValorConcluido=true;
					break;
				}
			}
		}
		if( !existeTablaAvaluoRespaldoCancelacion )
		{
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.keySet())
			{
				CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(key);
				if( ConsultaAvaluosGenericaBusiness.DATOS.contains(campo.getAliasTabla()+"."+campo.getNombreColumna()) )
				{
					sentencia.append(" left join avaluo_resp_cancelacion as a WITH(NOLOCK) on a.id_avaluo = c.id_avaluo");
					existeTablaAvaluoRespaldoCancelacion=true;
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
