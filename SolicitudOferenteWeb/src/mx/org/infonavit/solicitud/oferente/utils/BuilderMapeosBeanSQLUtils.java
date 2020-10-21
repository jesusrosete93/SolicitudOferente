package mx.org.infonavit.solicitud.oferente.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposBitacoraReasignacion;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposInexGeneral;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

public class BuilderMapeosBeanSQLUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(BuilderSQLConsultaUPCUtils.class);

	public static Map<String,String> MAPEO_BEAN_UV_SQL;
	public static Map<String,String> MAPEO_BEAN_COBERTURA_SQL;
	public static Map<String,String> MAPEO_BEAN_CONTROLADOR_SQL;
	public static Map<String,String> MAPEO_BEAN_PERITO_SQL;
	public static Map<String,String> MAPEO_BEAN_PAQUETE_SQL;
	public static Map<String,String> MAPEO_BEAN_OFERENTE_SQL;
	public static Map<String,String> MAPEO_BEAN_BITACORA_REASIGNACION_SQL;
	public static Map<String,String> MAPEO_BEAN_TEMPORAL_REASIGNACIONES_SQL;
	public static Map<String,String> MAPEO_BEAN_CANCELACIONES_SQL;
	public static Map<String,String> MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL;
	public static Map<String,String> MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL;
	public static Map<String,String> MAPEO_BEAN_DETALLE_AVALUO_SQL;
	public static Map<String,String> MAPEO_BEAN_VIVIENDA_SQL;
	public static Map<String,String> MAPEO_BEAN_AVALUO_SQL;
	public static Map<String,String> MAPEO_BEAN_SANCION_SQL;
	public static Map<String,String> MAPEO_BEAN_DELEGACION_SQL;
	public static Map<String,String> MAPEO_BEAN_INEX_GENERAL_SQL;
	public static Map<String,String> MAPEO_BEAN_INEX_PAQUETES_SQL;
	public static Map<String,String> MAPEO_BEAN_INEX_REASIGNACION_SQL;
	
	
	
	
	static
	{
		//UV - - - - - - - - -
		MAPEO_BEAN_UV_SQL = new HashMap<String, String>();
		MAPEO_BEAN_UV_SQL.put("unidadesValuacion","id_uv");
		MAPEO_BEAN_UV_SQL.put("estatusUnidadValuacion","id_estatus");
		MAPEO_BEAN_UV_SQL.put("fechaVigenciaInicioUnidadValacion","fecha_vigencia");
		MAPEO_BEAN_UV_SQL.put("fechaVigenciaFinUnidadValuacion","fecha_vigencia");
		MAPEO_BEAN_UV_SQL.put("claveSHFUnidadValuacion","ClaveSHF");
		MAPEO_BEAN_UV_SQL.put("siglasUnidadValuacion","siglas");
		MAPEO_BEAN_UV_SQL.put("unidadViviendaRecuperada","recuperada");
		
		//Cobertura - - - - - -
		MAPEO_BEAN_COBERTURA_SQL = new HashMap<String, String>();
		MAPEO_BEAN_COBERTURA_SQL.put("estadosCobertura","id_estado");
		MAPEO_BEAN_COBERTURA_SQL.put("estatusCobertura","estatus");
		
		
		
		//Controlador - - - - - - - - - - - 
		MAPEO_BEAN_CONTROLADOR_SQL = new HashMap<String, String>();
		MAPEO_BEAN_CONTROLADOR_SQL.put("claveSHFControlador","id_controlador_shf");
		MAPEO_BEAN_CONTROLADOR_SQL.put("nombreControlador","nombre");
		MAPEO_BEAN_CONTROLADOR_SQL.put("apellidoPaternoControlador","paterno");
		MAPEO_BEAN_CONTROLADOR_SQL.put("apellidoMaternoControlador","materno");
		MAPEO_BEAN_CONTROLADOR_SQL.put("curpControlador","curp");
		MAPEO_BEAN_CONTROLADOR_SQL.put("rfcControlador","rfc");
		MAPEO_BEAN_CONTROLADOR_SQL.put("fechaVigenciaInicioControlador","fecha_vigencia");
		MAPEO_BEAN_CONTROLADOR_SQL.put("fechaVigenciaFinControlador","fecha_vigencia");
		MAPEO_BEAN_CONTROLADOR_SQL.put("estatusControlador","id_estatus");

		//Perito - - - - - - -- - - - -- 
		MAPEO_BEAN_PERITO_SQL = new HashMap<String,String>();
		MAPEO_BEAN_PERITO_SQL.put("claveSHFPerito","id_perito_shf");
		MAPEO_BEAN_PERITO_SQL.put("nombrePerito","nombre");
		MAPEO_BEAN_PERITO_SQL.put("apellidoPaternoPerito","paterno");
		MAPEO_BEAN_PERITO_SQL.put("apellidoMaternoPerito","materno");
		MAPEO_BEAN_PERITO_SQL.put("curpPerito","curp");
		MAPEO_BEAN_PERITO_SQL.put("rfcPerito","rfc");
		MAPEO_BEAN_PERITO_SQL.put("fechaVigenciaInicioPerito","fecha_vigencia");
		MAPEO_BEAN_PERITO_SQL.put("fechaVigenciaFinPerito","fecha_vigencia");
		MAPEO_BEAN_PERITO_SQL.put("estatusPerito","id_estatus");
		
		MAPEO_BEAN_PAQUETE_SQL = new HashMap<String, String>();
		MAPEO_BEAN_PAQUETE_SQL.put("paquete","id_paquete");
		MAPEO_BEAN_PAQUETE_SQL.put("unidadValuacion","id_uv");
		MAPEO_BEAN_PAQUETE_SQL.put("frente","nombre_frente");
		MAPEO_BEAN_PAQUETE_SQL.put("rfcOferente","rfc");
		MAPEO_BEAN_PAQUETE_SQL.put("fechaAsignacionInicio","fecha_asignacion");
		MAPEO_BEAN_PAQUETE_SQL.put("fechaAsignacionFin","fecha_asignacion");
		MAPEO_BEAN_PAQUETE_SQL.put("estado","id_estado");
		MAPEO_BEAN_PAQUETE_SQL.put("tipoPaquete","tipo_paquete");
		
		MAPEO_BEAN_OFERENTE_SQL = new HashMap<String, String>();
		MAPEO_BEAN_OFERENTE_SQL.put("oferente","nombre_razon_social");
		
		
		
		MAPEO_BEAN_BITACORA_REASIGNACION_SQL = new HashMap<String, String>();
		MAPEO_BEAN_BITACORA_REASIGNACION_SQL.put("unidadAnterior","id_uv_ant");
		MAPEO_BEAN_BITACORA_REASIGNACION_SQL.put("unidadNueva","id_uv_nuevo");
		MAPEO_BEAN_BITACORA_REASIGNACION_SQL.put("fechaReasignacionInicio","fecha");
		MAPEO_BEAN_BITACORA_REASIGNACION_SQL.put("fechaReasignacionFin","fecha");
		
		MAPEO_BEAN_TEMPORAL_REASIGNACIONES_SQL = new HashMap<String, String>();
		MAPEO_BEAN_TEMPORAL_REASIGNACIONES_SQL.put("tipoReasignacion","tipo_reasignacion");
		
		
		MAPEO_BEAN_CANCELACIONES_SQL= new HashMap<String, String>();
		MAPEO_BEAN_CANCELACIONES_SQL.put("idAvaluo", "id_avaluo");
		MAPEO_BEAN_CANCELACIONES_SQL.put("paquete", "id_paquete");
		MAPEO_BEAN_CANCELACIONES_SQL.put("viviendaInicio", "id_vivienda");
		MAPEO_BEAN_CANCELACIONES_SQL.put("viviendaFin", "id_vivienda");
		MAPEO_BEAN_CANCELACIONES_SQL.put("fechaCancelacionInicio", "fecha");
		MAPEO_BEAN_CANCELACIONES_SQL.put("fechaCancelacionFin", "fecha");
		MAPEO_BEAN_CANCELACIONES_SQL.put("fechaSolicitudInicio", "fecha_solicitud");
		MAPEO_BEAN_CANCELACIONES_SQL.put("fechaSolicitudFin", "fecha_solicitud");
		
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL = new HashMap<String, String>();
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("claveUnidadValuacion", "id_uv");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("idConviviencia", "id_convivencia");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("fechaSolicitudInicio", "fecha_solicitud");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("fechaSolicitudFin", "fecha_solicitud");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("fechaCierreInicio", "fecha_cierre");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("fechaCierreFin", "fecha_cierre");
		MAPEO_BEAN_CANCELACIONES_RESPALDO_SQL.put("estatusAvaluo", "id_estatus");
		
		
		MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL = new HashMap<String, String>();
		MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL.put("valorConcluidoInicio","valor_concluido");
		MAPEO_BEAN_HISTORICO_VALOR_CONCLUIDO_SQL.put("valorConcluidoFin","valor_concluido");
		
		
		
		MAPEO_BEAN_AVALUO_SQL = new HashMap<String,String>();
		MAPEO_BEAN_AVALUO_SQL.put("idAvaluo","id_avaluo");
		MAPEO_BEAN_AVALUO_SQL.put("idConviviencia","id_convivencia");
		MAPEO_BEAN_AVALUO_SQL.put("idPaquete","id_paquete");
		MAPEO_BEAN_AVALUO_SQL.put("viviendaInicio","id_vivienda");
		MAPEO_BEAN_AVALUO_SQL.put("viviendaFin","id_vivienda");
		MAPEO_BEAN_AVALUO_SQL.put("nss","nss");
		MAPEO_BEAN_AVALUO_SQL.put("fechaSolicitudInicio","fecha_solicitud");
		MAPEO_BEAN_AVALUO_SQL.put("fechaSolicitudFin","fecha_solicitud");
		MAPEO_BEAN_AVALUO_SQL.put("fechaCierreInicio","fecha_cierre");
		MAPEO_BEAN_AVALUO_SQL.put("fechaCierreFin","fecha_cierre");
		MAPEO_BEAN_AVALUO_SQL.put("estatusAvaluo","id_estatus");
		MAPEO_BEAN_AVALUO_SQL.put("tipoMercado","id_tipo_mercado");
		MAPEO_BEAN_AVALUO_SQL.put("tipoLinea","tipo_linea");
		MAPEO_BEAN_AVALUO_SQL.put("estadosAvaluo","id_avaluo");

		
		MAPEO_BEAN_DETALLE_AVALUO_SQL = new HashMap<String, String>();
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("valorConcluidoInicio","valor_concluido");
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("valorConcluidoFin","valor_concluido");
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("metrosConstruccionInicio","valor_construccion_m2");
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("metrosConstruccionFin","valor_construccion_m2");
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("metrosTerrenoInicio","valor_terreno_m2");
		MAPEO_BEAN_DETALLE_AVALUO_SQL.put("metrosTerrenoFin","valor_terreno_m2");

		MAPEO_BEAN_VIVIENDA_SQL = new HashMap<String, String>();
		MAPEO_BEAN_VIVIENDA_SQL.put("nss","nss");
		MAPEO_BEAN_VIVIENDA_SQL.put("codigoPostal","cp");
		
		
		MAPEO_BEAN_SANCION_SQL = new HashMap<String, String>();
		MAPEO_BEAN_SANCION_SQL.put("claveUnidadValuacion","id_registro");
		MAPEO_BEAN_SANCION_SQL.put("fechaSancionInicio","fecha");
		MAPEO_BEAN_SANCION_SQL.put("fechaSancionFin","fecha");
		MAPEO_BEAN_SANCION_SQL.put("tipoSancion","id_tipo_sancion");
		MAPEO_BEAN_SANCION_SQL.put("sancionado","id_sancionado");
		MAPEO_BEAN_SANCION_SQL.put("estatusSancion","id_estatus");
		
		MAPEO_BEAN_DELEGACION_SQL = new HashMap<String, String>();
		MAPEO_BEAN_DELEGACION_SQL.put("claveEstadoCobertura","id_delegacion");
		
		//Inex General - - - -
		MAPEO_BEAN_INEX_GENERAL_SQL = new HashMap<String, String>();
		MAPEO_BEAN_INEX_GENERAL_SQL.put("numeroInex","id_inex");
		MAPEO_BEAN_INEX_GENERAL_SQL.put("fechaInex","fecha");
		MAPEO_BEAN_INEX_GENERAL_SQL.put("idUnidad","id_uv");
		MAPEO_BEAN_INEX_GENERAL_SQL.put("idEstado","id_estado");
		
		
		//Inex General - - - -
		MAPEO_BEAN_INEX_PAQUETES_SQL = new HashMap<String, String>();
		MAPEO_BEAN_INEX_PAQUETES_SQL.put("numeroInex","id_inex");
		MAPEO_BEAN_INEX_PAQUETES_SQL.put("fechaInex","fecha");
		MAPEO_BEAN_INEX_PAQUETES_SQL.put("idUnidad","id_uv");
		MAPEO_BEAN_INEX_PAQUETES_SQL.put("idEstado","id_estado");
		
		//Reasignación Inex
		MAPEO_BEAN_INEX_REASIGNACION_SQL = new HashMap<String, String>();
		MAPEO_BEAN_INEX_REASIGNACION_SQL.put("paquete", "id_paquete");
		MAPEO_BEAN_INEX_REASIGNACION_SQL.put("fechaReasignacionInicio", "fecha");
		MAPEO_BEAN_INEX_REASIGNACION_SQL.put("fechaReasignacionFin", "fecha");
		MAPEO_BEAN_INEX_REASIGNACION_SQL.put("unidadAnterior", "id_uv_ant");
		MAPEO_BEAN_INEX_REASIGNACION_SQL.put("unidadNueva", "id_uv_nuevo");
		
		
		

	}
	
	/**
	 * Genera un mapeo de etiqueta y nombre de los campos de los catalogos
	 * @param identificdor de la tabla a crear el mapeo
	 * @return mapeo
	 */
	public static Map<String,String> generarMapeoCamposUPC(int tabla)
	{
		Map<String,String> mapeo = new LinkedHashMap<String, String>();
		
		switch (tabla) {
		case 1:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
				{
					CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
					mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
				}
			break;
		case 2:
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.keySet())
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		break;
		case 3:
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADORES_UV.keySet())
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADORES_UV.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		break;
		case 4:
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITOS_UV.keySet())
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PERITOS_UV.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		break;
		case 5:
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.keySet())
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		break;
		case 6:
			for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITO.keySet())
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		break;
		default:
			LOGGER.info("[CSSQL] - Sin definir tabla para construcción de campos");
			break;
		}
		
		return mapeo;
		
	}

	
	/**
	 * 
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposAsignaciones()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> camposPaquete = Arrays.asList(new String[]{"id_paquete","id_uv","frente","rfc","fecha_asignacion","id_estado"});
		List<String> camposBitacora = Arrays.asList(new String[]{"id_uv_ant","fecha"});
		List<String> camposTemporal = Arrays.asList(new String[]{"tipo_reasignacion"});

		
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			if( camposPaquete.contains(key) ){
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.keySet())
		{
			if( camposBitacora.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
			
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.keySet())
		{
			if( camposTemporal.contains(key) ){
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
			
		}
		return mapeo;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposCancelaciones()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> camposCancelacion = Arrays.asList(new String[]{"id_avaluo","id_paquete","id_vivienda","fecha","fecha_asignacion","id_estado"});
		List<String> camposHistoricoValorConcluido = Arrays.asList(new String[]{"valor_concluido"});
		List<String> camposCancelacionRespaldo = Arrays.asList(new String[]{"id_uv","id_convivencia","fecha_solicitud","fecha_cierre","id_estatus"});

		
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.keySet())
		{
			if( camposCancelacion.contains(key) ){
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.keySet())
		{
			if( camposHistoricoValorConcluido.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
			
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.keySet())
		{
			if( camposCancelacionRespaldo.contains(key) ){
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
			
		}
		return mapeo;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposAvaluos(int tabla)
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> camposUnidadValuacion = Arrays.asList(new String[]{"id_uv","descripcion","id_estatus","ClaveSHF","siglas","recuperada"});
		List<String> camposVivienda = Arrays.asList(new String[]{"id_paquete","id_vivienda","nss","cuv","manzana","lote","cp","calle","colonia",
																 "num_exterior","num_interior","fecha_solicitud","fecha_dtu","fecha_compromiso_termino",
																 "precio_venta","tipo_vivienda"});
		List<String> camposAvaluo = Arrays.asList(new String[]{"id_avaluo","estado","id_convivencia","fecha_descarga","fecha_envio","fecha_cierre","id_estatus",
															   "fecha_compromiso_termino","fecha_caducidad","id_tipo_mercado"});
		List<String> camposDetallAvaluo = Arrays.asList(new String[]{"clave_shf","fecha_avaluo","num_recamaras","num_banios","num_estacionamiento",
																	 "edad_contruccion","vida_util_remanente","superficie_terreno_vivienda",
																	 "superficie_construida","valor_comparativo_total","valor_comparativo_m2",
																	 "valor_terreno_total","valor_terreno_m2","valor_construccion_total",
																	 "valor_construccion_m2","valor_residual","valor_concluido","longitud","latitud",
																	 "altitud"});
		List<String> camposControlador = Arrays.asList(new String[]{"id_controlador_shf","paterno","materno","nombre"});
		List<String> camposPerito = Arrays.asList(new String[]{"id_perito_shf","paterno","materno","nombre"});

		
		switch( tabla )
		{
			case 1:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
				{
					if( camposUnidadValuacion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 2:
				
			break;
			case 3:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.keySet())
				{
					if( camposVivienda.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 4:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_AVALUO.keySet())
				{
					if( camposAvaluo.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 5:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.keySet())
				{
					if( camposDetallAvaluo.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 6:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.keySet())
				{
					if( camposControlador.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 7:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITO.keySet())
				{
					if( camposPerito.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
		}
	return mapeo;
  }
	
	
	/**
	 * 
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposSanciones(int tabla)
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		
		List<String> camposSancion = Arrays.asList(new String[]{"fecha","descripcion","descripcion","descripcion","descripcion","motivo","id_estatus"});
		List<String> camposUnidadValuacion = Arrays.asList(new String[]{"id_uv","descripcion","ClaveSHF"});
		List<String> camposDelegacion = Arrays.asList(new String[]{"descripcion"});
		List<String> camposControlador = Arrays.asList(new String[]{"id_controlador_shf","paterno","materno","nombre"});
		List<String> camposPerito = Arrays.asList(new String[]{"id_perito_shf","paterno","materno","nombre"});

		
		switch( tabla )
		{
			case 1:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCION.keySet())
				{
					if( camposSancion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.keySet())
				{
					if( camposSancion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
						break;
					}
				}
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.keySet())
				{
					if( camposSancion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
						break;
					}
				}
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.keySet())
				{
					if( camposSancion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
						break;
					}
				}
			break;
			case 2:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
				{
					if( camposUnidadValuacion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 3:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.keySet())
				{
					if( camposDelegacion.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 4:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.keySet())
				{
					if( camposControlador.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
			case 5:
				for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITO.keySet())
				{
					if( camposPerito.contains(key) ){
						CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(key);
						mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
					}
				}
			break;
		}
	return mapeo;
  }
	
	
	/**
	 * <p>
	 * 	Método que genera los campos para la consulta de Inex. 
	 * </p>
	 */
	public static Map<String, String> generarMapeoCamposInexGeneral()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		
		List<String> campos = Arrays.asList(new String[]{"id_inex","fecha","id_uv","id_estado","variable1","variable2","variable3","variable4","variable5","desempate1","desempate2","calificacion_total","orden","estatus"});
		for(String key : CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.keySet())
		{
			if( campos.contains(key) ){
				CampoBdVo elemento = CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	 return mapeo;
    }
	
	/**
	 * <p>
	 * 	Método que genera los campos de la tabla: paquete utilizados para la consulta de paquetes para el Inex. 
	 * </p>
	 */
	public static Map<String, String> generarMapeoCamposPaquetesInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
			mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
		}
	  return mapeo;
    }
	/**
	 * <p>
     *  Método que genera los campos de la tabla: oferente para la consulta 
	 *  de paquetes inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposPaquetesOferenteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"nombre_razon_social"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: paquete para la consulta 
	 *  de paquetes Inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposSolicitudesPaqueteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"id_uv","id_estado","rfc","tipo_paquete"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	
	/**
	 * <p>
	 * 	Método que genera los campos de la tabla: avaluo para la consulta 
	 *  de paquetes Inex. 
	 * </p>
	 * @return objeto tipo {@link Map} que contiene los campos utilizados.
	 */
	public static Map<String,String> generarMapeoCamposPaquetesAvaluoInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"fecha_solicitud"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_AVALUO.keySet())
		{
			if( campos.contains(key))
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
	}
	
	
	/**
	 * <p>
	 * Método que obtiene los datos de la tabla de avaluo para la consulta de solicutdes Inex.
	 * </p>
	 * @return
	 */
	public static Map<String,String> generarMapeoCamposSolicitudesAvaluoInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"id_avaluo","fecha_solicitud","fecha_cierre","id_estatus","id_vivienda","id_paquete","id_convivencia"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_AVALUO.keySet())
		{
			if( campos.contains(key))
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
	}
	
	
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: cancelacion_avaluo para la consulta 
	 *  de cancelaciones Inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposCancelacionInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"id_avaluo","id_uv","fecha","id_vivienda","id_paquete","fecha_solicitud","fecha"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	/**
	 * <p>
     *  Método que genera los campos de la tabla: cancelacion_avaluo para la consulta 
	 *  de cancelaciones Inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposCancelacionPaqueteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"rfc","id_estado","tipo_paquete"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: bitacora_Reasignacion_Inex para la consulta 
	 *  de reasignaciones de unidades de valuación.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposReasignacionInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"id_uv_ant","id_uv_nuevo","fecha","motivo"});
		for(String key : CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	/**
	 * <p>
     *  Método que genera los campos de la tabla: paquete para la consulta 
	 *  de reasignaciones de unidades de valuación.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposReasignacionPaqueteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"id_estado","rfc","tipo_paquete"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: oferente para la consulta 
	 *  de reasignaciones de unidades de valuación inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposReasignacionOferenteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"nombre_razon_social"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: oferente para la consulta 
	 *  de reasignaciones de unidades de valuación inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposCancelacionOferenteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"nombre_razon_social"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
	/**
	 * <p>
     *  Método que genera los campos de la tabla: oferente para la consulta 
	 *  de reasignaciones de unidades de valuación inex.
	 * </p>
	 * @return
	 */
	public static Map<String, String> generarMapeoCamposSolicitudOferenteInex()
	{
		Map<String, String> mapeo = new LinkedHashMap<String, String>();
		List<String> campos = Arrays.asList(new String[]{"nombre_razon_social"});
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			if( campos.contains(key) )
			{
				CampoBdVo elemento = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
				mapeo.put(elemento.getAliasTabla()+"."+elemento.getNombreColumna(),elemento.getEtiquetaColumna());
			}
		}
	  return mapeo;
    }
	
}

