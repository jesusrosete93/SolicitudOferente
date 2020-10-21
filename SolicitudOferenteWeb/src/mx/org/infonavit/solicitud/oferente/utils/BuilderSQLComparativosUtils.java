package mx.org.infonavit.solicitud.oferente.utils;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IN;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MAYOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MENOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PARANETESIS_ABRE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PARANETESIS_CIERRA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;
import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCancelacioneaDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BuilderSQLComparativosUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLComparativosUtils.class);
	
//	private static final String SENTENCIA = "SELECT a.id_avaluo,a.id_uv,a.fecha_solicitud,a.fecha_descarga,a.fecha_envio,a.fecha_cierre,a.fecha_asociacion_factura,a.id_estatus,a.id_vivienda,a.id_paquete,a.nss,a.rfc,a.isai,a.id_proposito_avaluo,a.id_proposito_recuperacion,a.proposito_otro,a.fecha_compromiso_termino,a.fecha_caducidad,a.id_tipo_mercado,a.id_convivencia,a.identificacion,a.tipo_linea,a.numero_credito,a.fecha_tramite_credito,a.tipo_tramite_credito,a.tipo_avaluo,a.monto_avaluo,a.marca_carga_herramienta_caduco from avaluo as a with(nolock) ";
//	private static final String SENTENCIA = "SELECT a.id_avaluo,a.id_uv,a.fecha_solicitud,a.fecha_descarga,a.fecha_envio,a.fecha_cierre,a.fecha_asociacion_factura,a.id_estatus,a.id_vivienda,a.id_paquete,a.nss,a.rfc,a.isai,a.id_proposito_avaluo,a.id_proposito_recuperacion,a.proposito_otro,a.fecha_compromiso_termino,a.fecha_caducidad,a.id_tipo_mercado,a.id_convivencia,a.identificacion,a.tipo_linea,a.numero_credito,a.fecha_tramite_credito,a.tipo_tramite_credito,a.tipo_avaluo,a.monto_avaluo,a.marca_carga_herramienta_caduco from avaluo as a with(nolock) ";
	private static final String SENTENCIA = "SELECT distinct(a.id_avaluo) as id_avaluo from avaluo as a with(nolock) ";
											
											
	
		
	/**
	 * Genera una cadena de texto con formato SQL
	 * @param criterios parametros de busqueda
	 * @return sentencia SQL
	 */
	public static String generarSentencia(CriteriosCompartivoMercadoDomain criterios)
	{
		StringBuilder sentencia = null;
		StringBuffer condicion = new StringBuffer();
		
		sentencia = new StringBuilder(SENTENCIA);
		try
		{
			if( criterios.validarCriteriosAvaluo())
			{
				if( criterios.getPaquete()!=null && !criterios.getPaquete().trim().equals(""))
				{
					if( condicion.length()>0 )
					{
						condicion.append(AND).append("a.id_paquete").append(IGUAL).append(COMILLA).append(criterios.getPaquete()).append(COMILLA);
					}else
					{
						condicion.append("a.id_paquete").append(IGUAL).append(COMILLA).append(criterios.getPaquete()).append(COMILLA);
					}
				}
				if( criterios.getIdAvaluo()!=null && !criterios.getIdAvaluo().trim().equals(""))
				{
					if( condicion.length()>0 )
					{
						condicion.append(AND).append("a.id_avaluo").append(IGUAL).append(COMILLA).append(criterios.getIdAvaluo()).append(COMILLA);
					}else
					{
						condicion.append("a.id_avaluo").append(IGUAL).append(COMILLA).append(criterios.getIdAvaluo()).append(COMILLA);
					}
				}
				if( criterios.getUnidadesValuacion()!=null && !criterios.getUnidadesValuacion().isEmpty())
				{
					if( condicion.length()>0 )
					{
						condicion.append(AND).append("a.id_uv").append(IN).append(PARANETESIS_ABRE).append(BuilderSQLConsultaUPCUtils.getElementosIN(criterios.getUnidadesValuacion())).append(PARANETESIS_CIERRA);
					}else
					{
						condicion.append("a.id_uv").append(IN).append(PARANETESIS_ABRE).append(BuilderSQLConsultaUPCUtils.getElementosIN(criterios.getUnidadesValuacion())).append(PARANETESIS_CIERRA);
					}
				}
				if( criterios.getFechaCierreInicio()!=null && !criterios.getFechaCierreInicio().trim().equals("") &&
				    criterios.getFechaCierreFin()!=null && !criterios.getFechaCierreFin().trim().equals("")
				  )
				{
					if( condicion.length()>0 )
					{
						condicion.append(AND).append("a.fecha_cierre").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getFechaCierreInicio()).append(" 00:00:00").append(COMILLA)
						      .append(AND).append("a.fecha_cierre").append(MENOR_IGUAL).append(COMILLA).append(criterios.getFechaCierreFin()).append(" 23:59:59").append(COMILLA);
					}else
					{
						condicion.append("a.fecha_cierre").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getFechaCierreInicio()).append(" 00:00:00").append(COMILLA)
					           .append(AND).append("a.fecha_cierre").append(MENOR_IGUAL).append(COMILLA).append(criterios.getFechaCierreFin()).append(" 23:59:59").append(COMILLA);
					}
				}
			}
			if( criterios.validarCriteriosDetalleAvaluo())
			{
				sentencia.append(" LEFT JOIN detalle_avaluo as d with(nolock) ON d.id_avaluo=a.id_avaluo ");
				if( criterios.getMetodo()>0 )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("d.id_metodo_conclusion_avaluo").append(IGUAL).append(criterios.getMetodo());
					}else
					{
						condicion.append("d.id_metodo_conclusion_avaluo").append(IGUAL).append(criterios.getMetodo());
					}
				}
				if( criterios.getEdad()>0 )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("d.edad_contruccion").append(MAYOR_IGUAL).append(criterios.getEdad());
					}else
					{
						condicion.append("d.edad_contruccion").append(MAYOR_IGUAL).append(criterios.getEdad());
					}
				}
				if( criterios.getConservacion()>0 )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("d.id_estado_conservacion").append(IGUAL).append(criterios.getConservacion());
					}else
					{
						condicion.append("d.id_estado_conservacion").append(IGUAL).append(criterios.getConservacion());
					}
				}
				if( criterios.getSuperficieTerrenoMinimo()!=null && !criterios.getSuperficieTerrenoMinimo().trim().equals("") && criterios.getSuperficieTerrenoMaximo()!=null && !criterios.getSuperficieTerrenoMaximo().trim().equals("") )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("d.superficie_terreno_vivienda").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getSuperficieTerrenoMinimo()).append(COMILLA).append(AND).append("d.superficie_terreno_vivienda").append(MENOR_IGUAL).append(COMILLA).append(criterios.getSuperficieTerrenoMaximo()).append(COMILLA);
					}else
					{
						condicion.append("d.superficie_terreno_vivienda").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getSuperficieTerrenoMinimo()).append(COMILLA).append(AND).append("d.superficie_terreno_vivienda").append(MENOR_IGUAL).append(COMILLA).append(criterios.getSuperficieTerrenoMaximo()).append(COMILLA);
					}
				}
				
				if( criterios.getSuperficieConstruccionMinimo()!=null && !criterios.getSuperficieConstruccionMinimo().trim().equals("") && criterios.getSuperficieConstruccionMaximo()!=null && !criterios.getSuperficieConstruccionMaximo().trim().equals("") )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("d.superficie_construida").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getSuperficieConstruccionMinimo()).append(COMILLA).append(AND).append("d.superficie_construida").append(MENOR_IGUAL).append(COMILLA).append(criterios.getSuperficieConstruccionMaximo()).append(COMILLA);
					}else
					{
						condicion.append("d.superficie_construida").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getSuperficieConstruccionMinimo()).append(COMILLA).append(AND).append("d.superficie_construida").append(MENOR_IGUAL).append(COMILLA).append(criterios.getSuperficieConstruccionMaximo()).append(COMILLA);
					}
				}
			}
			
			if( criterios.validarCriteriosFactor() )
			{
				sentencia.append(" LEFT JOIN enfoque_mercado as em with(nolock) ON em.id_avaluo=a.id_avaluo ");
				if( criterios.getValorOfertaMinimo()!=null && !criterios.getValorOfertaMinimo().trim().equals("") && criterios.getValorOfertaMaximo()!=null && !criterios.getValorOfertaMaximo().trim().equals("") )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.valor_oferta").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorOfertaMinimo()).append(COMILLA).append(AND).append("em.valor_oferta").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorOfertaMaximo()).append(COMILLA);
					}else
					{
						condicion.append("em.valor_oferta").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorOfertaMinimo()).append(COMILLA).append(AND).append("em.valor_oferta").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorOfertaMaximo()).append(COMILLA);
					}
				}
				if( criterios.getValorUnitarioInicio()!=null && !criterios.getValorUnitarioInicio().trim().equals("") && criterios.getValorUnitarioMaximo()!=null && !criterios.getValorUnitarioMaximo().trim().equals("") )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.valor_unitario").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorUnitarioInicio()).append(COMILLA).append(AND).append("em.valor_unitario").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorUnitarioMaximo()).append(COMILLA);
					}else
					{
						condicion.append("em.valor_unitario").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorUnitarioInicio()).append(COMILLA).append(AND).append("em.valor_unitario").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorUnitarioMaximo()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoFic()!=null && !criterios.getValorMinimoFic().trim().equals("")) && (criterios.getValorMaximoFic()!=null && !criterios.getValorMaximoFic().trim().equals(""))  ) 
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_fic").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoFic()).append(COMILLA)
								 .append(AND).append("em.factor_fic").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoFic()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_fic").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoFic()).append(COMILLA)
						 		 .append(AND).append("em.factor_fic").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoFic()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoZona()!=null && !criterios.getValorMinimoZona().trim().equals("")) && (criterios.getValorMaximoZona()!=null && !criterios.getValorMaximoZona().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_zona").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoZona()).append(COMILLA)
								 .append(AND).append("em.factor_zona").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoZona()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_zona").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoZona()).append(COMILLA)
						 		 .append(AND).append("em.factor_zona").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoZona()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoUbicacion()!=null && !criterios.getValorMinimoUbicacion().trim().equals("")) && (criterios.getValorMaximoUbicacion()!=null && !criterios.getValorMaximoUbicacion().trim().equals("")) ) 
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_ubicacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoUbicacion()).append(COMILLA)
								 .append(AND).append("em.factor_ubicacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoUbicacion()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_ubicacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoUbicacion()).append(COMILLA)
						 		 .append(AND).append("em.factor_ubicacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoUbicacion()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoSuperficie()!=null && !criterios.getValorMinimoSuperficie().trim().equals("")) && (criterios.getValorMaximoSuperficie()!=null && !criterios.getValorMaximoSuperficie().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_superficie").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoSuperficie()).append(COMILLA)
								 .append(AND).append("em.factor_superficie").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoSuperficie()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_superficie").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoSuperficie()).append(COMILLA)
						 		 .append(AND).append("em.factor_superficie").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoSuperficie()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoEdadFactor()!=null && !criterios.getValorMinimoEdadFactor().trim().equals("")) && (criterios.getValorMaximoEdadFactor()!=null && !criterios.getValorMaximoEdadFactor().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_edad").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoEdadFactor()).append(COMILLA)
								 .append(AND).append("em.factor_edad").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoEdadFactor()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_edad").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoEdadFactor()).append(COMILLA)
						 		 .append(AND).append("em.factor_edad").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoEdadFactor()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoConservacionFactor()!=null && !criterios.getValorMinimoConservacionFactor().trim().equals("")) && (criterios.getValorMaximoConservacionFactor()!=null && !criterios.getValorMaximoConservacionFactor().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_conservacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoConservacionFactor()).append(COMILLA)
						         .append(AND).append("em.factor_conservacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoConservacionFactor()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_conservacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoConservacionFactor()).append(COMILLA)
				         		 .append(AND).append("em.factor_conservacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoConservacionFactor()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoOtros()!=null && !criterios.getValorMinimoOtros().trim().equals("")) && (criterios.getValorMaximoOtros()!=null && !criterios.getValorMaximoOtros().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_otros").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoOtros()).append(COMILLA)
								 .append(AND).append("em.factor_otros").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoOtros()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_otros").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoOtros()).append(COMILLA)
						 		 .append(AND).append("em.factor_otros").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoOtros()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoComercializacion()!=null && !criterios.getValorMinimoComercializacion().trim().equals("")) && (criterios.getValorMaximoComercializacion()!=null && !criterios.getValorMaximoComercializacion().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_comercializacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoComercializacion()).append(COMILLA)
						         .append(AND).append("em.factor_comercializacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoComercializacion()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_comercializacion").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoComercializacion()).append(COMILLA)
				         		 .append(AND).append("em.factor_comercializacion").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoComercializacion()).append(COMILLA);
					}
				}
				if( (criterios.getValorMinimoResultante()!=null && !criterios.getValorMinimoResultante().trim().equals("")) && (criterios.getValorMaximoResultante()!=null && !criterios.getValorMaximoResultante().trim().equals("")) )
				{
					if( condicion.length()>0)
					{
						condicion.append(AND).append("em.factor_resultante").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoResultante()).append(COMILLA)
						         .append(AND).append("em.factor_resultante").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoResultante()).append(COMILLA);
					}else
					{
						condicion.append("em.factor_resultante").append(MAYOR_IGUAL).append(COMILLA).append(criterios.getValorMinimoResultante()).append(COMILLA)
				         	     .append(AND).append("em.factor_resultante").append(MENOR_IGUAL).append(COMILLA).append(criterios.getValorMaximoResultante()).append(COMILLA);
						
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
			sentencia = new StringBuilder("");
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
