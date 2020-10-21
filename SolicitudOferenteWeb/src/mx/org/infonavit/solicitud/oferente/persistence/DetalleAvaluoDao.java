package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import mx.org.infonavit.solicitud.oferente.persistence.vo.DetalleAvaluoVo;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("DetalleAvaluoDao")
public class DetalleAvaluoDao extends AbstractDao<DetalleAvaluoVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(DetalleAvaluoDao.class);
	private static final String SELECT = "SELECT * FROM detalle_avaluo WITH(NOLOCK)";
	
	private class DetalleExtractor implements ResultSetExtractor<List<DetalleAvaluoVo>>
	{
		@Override
		public List<DetalleAvaluoVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<DetalleAvaluoVo> regreso = new ArrayList<DetalleAvaluoVo>();
			while(resultSet.next())
			{
				regreso.add(new DetalleAvaluoVo( validar(resultSet.getString("id_avaluo"),"")
										,resultSet.getInt("id_vivienda")
										,validar(resultSet.getString("id_paquete"),"")
										,validar(resultSet.getString("clave_shf"),"")
										,validar(resultSet.getString("clave_uv"),"")
										,validar(resultSet.getString("fecha_avaluo"),"")
										,validar(resultSet.getString("clave_unica_vivienda"),"")
										,validar(resultSet.getString("clasificacion_zona"),"")
										,resultSet.getInt("niveles_zona")
										,validar(resultSet.getString("construcciones_valor"),"")
										,resultSet.getInt("id_rec_aguas_residuales")
										,validar(resultSet.getString("drenaje_pluvial_calle"),"")
										,validar(resultSet.getString("drenaje_pluvial_zona"),"")
										,validar(resultSet.getString("sist_mixto_drenaje"),"")
										,validar(resultSet.getString("fosa_septica"),"")
										,resultSet.getBoolean("elect_acometica_inmueble")
										,resultSet.getInt("id_material_vialidades")
										,validar(resultSet.getString("vialidades_valor"),"")
										,resultSet.getInt("id_alumbrado_publico")
										,resultSet.getInt("id_material_banquetas")
										,validar(resultSet.getString("banqueta_valor"),"")
										,resultSet.getInt("id_material_guarniciones")
										,validar(resultSet.getString("guarniciones_valor"),"")
										,validar(resultSet.getString("nivel_infraestructura"),"")
										,resultSet.getInt("id_gas_natural")
										,resultSet.getInt("id_sumin_telefonico")
										,resultSet.getBoolean("acometida_telefonico")
										,resultSet.getBoolean("nomenclatura_calles")
										,resultSet.getInt("trans_urbano_dist")
										,resultSet.getInt("trans_urbano_frec")
										,resultSet.getInt("trans_suburbano_dist")
										,resultSet.getInt("trans_suburbano_frec")
										,resultSet.getBoolean("rec_municipal_desechos")
										,resultSet.getInt("id_tipo_inmueble_valuado")
										,validar(resultSet.getString("tipo_inm_valuado_valor"),"")
										,validar(resultSet.getString("domicilio_localidad_inmueble"),"")
										,validar(resultSet.getString("codigo_postal_inmueble"),"")
										,validar(resultSet.getString("colonia_inmueble"),"")
										,validar(resultSet.getString("calle_inmueble"),"")
										,validar(resultSet.getString("num_exterior_inmueble"),"")
										,validar(resultSet.getString("num_interior_inmueble"),"")
										,resultSet.getInt("id_conf_inmueble")
										,resultSet.getInt("id_topografia_inmueble")
										,validar(resultSet.getString("uso_suelo"),"")
										,validar(resultSet.getString("cus"),"")
										,validar(resultSet.getString("densidad_habitacional"),"")
										,validar(resultSet.getString("uso_actual"),"")
										,resultSet.getInt("num_recamaras")
										,resultSet.getInt("num_banios")
										,resultSet.getInt("num_estacionamiento")
										,resultSet.getInt("id_calidad_proyecto")
										,resultSet.getInt("id_clase_gral_inmueble")
										,resultSet.getInt("id_estado_conservacion")
										,resultSet.getInt("edad_contruccion")
										,resultSet.getInt("vida_util_remanente")
										,resultSet.getInt("niveles_construccion")
										,validar(resultSet.getString("grado_terminacion_obra"),"")
										,validar(resultSet.getString("grado_avance_areas_comunes"),"")
										,validar(resultSet.getString("superficie_terreno_vivienda"),"")
										,validar(resultSet.getString("superficie_construida"),"")
										,validar(resultSet.getString("superficie_accesorias"),"")
										,validar(resultSet.getString("superficie_vendible"),"")
										,validar(resultSet.getString("indivisos_construccion"),"")
										,validar(resultSet.getString("indivisos_terreno"),"")
										,resultSet.getInt("id_inst_hidraulicas")
										,validar(resultSet.getString("mat_inst_hidraulicas"),"")
										,resultSet.getInt("id_inst_sanitarias")
										,validar(resultSet.getString("mat_inst_sanitarias"),"")
										,resultSet.getInt("id_inst_electricas")
										,resultSet.getInt("id_elementos_adicionales")
										,validar(resultSet.getString("elementos_adicionales_valor"),"")
										,validar(resultSet.getString("valor_comparativo_total"),"")
										,validar(resultSet.getString("valor_comparativo_m2"),"")
										,validar(resultSet.getString("valor_terreno_total"),"")
										,validar(resultSet.getString("valor_terreno_m2"),"")
										,validar(resultSet.getString("valor_construccion_total"),"")
										,validar(resultSet.getString("valor_construccion_m2"),"")
										,validar(resultSet.getString("valor_residual"),"")
										,validar(resultSet.getString("valor_concluido"),"")
										,resultSet.getInt("id_ubica_inmueble_terreno")
										,validar(resultSet.getString("superficie_terreno_conjunto"),"")
										,resultSet.getInt("id_vigilancia")
										,resultSet.getBoolean("senalizacion_vial")
										,resultSet.getInt("id_suministro_electricidad")
										,resultSet.getInt("id_agua_potable")
										,validar(resultSet.getString("indice_saturacion_zona"),"")
										,resultSet.getInt("id_uso_construcciones")
										,resultSet.getInt("id_ref_proximidad_urbana")
										,resultSet.getInt("id_clase_zona")
										,validar(resultSet.getString("id_perito_shf"),"")
										,resultSet.getInt("id_densidad_poblacion")
										,validar(resultSet.getString("id_controlador_shf"),"")
										,validar(resultSet.getString("longitud"),"")
										,validar(resultSet.getString("latitud"),"")
										,validar(resultSet.getString("altitud"),"")
										,validar(resultSet.getString("otro_tipo_sistema"),"")
										,resultSet.getInt("id_existencia_trans_urbano")
										,resultSet.getInt("id_existencia_tran_suburbano")
										,resultSet.getInt("rec_municipal_desechos_frec")
										,resultSet.getInt("id_nivel_infraurbana")
										,resultSet.getInt("id_existencia_iglesia")
										,resultSet.getInt("id_existencia_mercados")
										,resultSet.getInt("id_existencia_plaza_publica")
										,resultSet.getInt("id_existencia_parques_jardines")
										,resultSet.getInt("id_existencia_escuelas")
										,resultSet.getInt("id_existencia_hospitales")
										,resultSet.getInt("id_existencia_bancos")
										,resultSet.getInt("id_existencia_acceso_estacion_urbano")
										,resultSet.getInt("id_existenciaaccesoestacionsuburbano")
										,resultSet.getInt("id_existenciacentrocomunitario")
										,resultSet.getInt("idnivelequipamientourbano")
										,resultSet.getInt("reportedensidad")
										,resultSet.getInt("id_existe_espacio_uso_multiple")
										,resultSet.getInt("num_medios_banios")
										,validar(resultSet.getString("resultado_calidad_proyecto"),"")
										,validar(resultSet.getString("comentarios_estado_conservacion"),"")
										,validar(resultSet.getString("mat_inst_electricas"),"")
										,validar(resultSet.getString("valor_hipotetico"),"")
										,resultSet.getInt("densidadhabitacionalhabitantes")
										,resultSet.getInt("densidadhabitacionalviviendas")
										,resultSet.getInt("id_supermercados")
										,resultSet.getInt("id_locales_comerciales")
										,resultSet.getInt("num_locales_comerciales")
										,resultSet.getInt("id_existencia_parques")
										,resultSet.getInt("id_existencia_jardines")
										,resultSet.getInt("id_canchas_deportivas")
										,resultSet.getInt("id_centro_deportivo")
										,resultSet.getInt("id_escuelas_primarias")
										,resultSet.getInt("id_escuelas_secundarias")
										,resultSet.getInt("id_escuelas_preparatoria")
										,resultSet.getInt("id_universidad")
										,resultSet.getInt("id_otras_escuelas")
										,resultSet.getInt("id_servicios_salud_primer_nivel")
										,resultSet.getInt("id_servicios_salud_segundo_nivel")
										,resultSet.getInt("id_servicios_salud_tercer_nivel")
										,resultSet.getInt("id_terreno_colinda")
										,resultSet.getInt("id_terreno_ubicado")
										,resultSet.getInt("id_riesgo_social")
										,resultSet.getInt("id_riesgo_comercial")
										,("fecha_visita_inmueble")
										,resultSet.getInt("id_metodo_conclusion_avaluo")
										,validar(resultSet.getString("marca_vivienda_usada_menor_tres"),"")
									  ));
			}
		 return regreso;
		}
		
	}
	
	private class DetalleAvaluoMapper implements RowMapper<DetalleAvaluoVo>
	{
		@Override
		public DetalleAvaluoVo mapRow(ResultSet resultSet, int fetch)
				throws SQLException {
			// TODO Auto-generated method stub
			return new DetalleAvaluoVo( validar(resultSet.getString("id_avaluo"),"")
										,resultSet.getInt("id_vivienda")
										,validar(resultSet.getString("id_paquete"),"")
										,validar(resultSet.getString("clave_shf"),"")
										,validar(resultSet.getString("clave_uv"),"")
										,validar(resultSet.getString("fecha_avaluo"),"")
										,validar(resultSet.getString("clave_unica_vivienda"),"")
										,validar(resultSet.getString("clasificacion_zona"),"")
										,resultSet.getInt("niveles_zona")
										,validar(resultSet.getString("construcciones_valor"),"")
										,resultSet.getInt("id_rec_aguas_residuales")
										,validar(resultSet.getString("drenaje_pluvial_calle"),"")
										,validar(resultSet.getString("drenaje_pluvial_zona"),"")
										,validar(resultSet.getString("sist_mixto_drenaje"),"")
										,validar(resultSet.getString("fosa_septica"),"")
										,resultSet.getBoolean("elect_acometica_inmueble")
										,resultSet.getInt("id_material_vialidades")
										,validar(resultSet.getString("vialidades_valor"),"")
										,resultSet.getInt("id_alumbrado_publico")
										,resultSet.getInt("id_material_banquetas")
										,validar(resultSet.getString("banqueta_valor"),"")
										,resultSet.getInt("id_material_guarniciones")
										,validar(resultSet.getString("guarniciones_valor"),"")
										,validar(resultSet.getString("nivel_infraestructura"),"")
										,resultSet.getInt("id_gas_natural")
										,resultSet.getInt("id_sumin_telefonico")
										,resultSet.getBoolean("acometida_telefonico")
										,resultSet.getBoolean("nomenclatura_calles")
										,resultSet.getInt("trans_urbano_dist")
										,resultSet.getInt("trans_urbano_frec")
										,resultSet.getInt("trans_suburbano_dist")
										,resultSet.getInt("trans_suburbano_frec")
										,resultSet.getBoolean("rec_municipal_desechos")
										,resultSet.getInt("id_tipo_inmueble_valuado")
										,validar(resultSet.getString("tipo_inm_valuado_valor"),"")
										,validar(resultSet.getString("domicilio_localidad_inmueble"),"")
										,validar(resultSet.getString("codigo_postal_inmueble"),"")
										,validar(resultSet.getString("colonia_inmueble"),"")
										,validar(resultSet.getString("calle_inmueble"),"")
										,validar(resultSet.getString("num_exterior_inmueble"),"")
										,validar(resultSet.getString("num_interior_inmueble"),"")
										,resultSet.getInt("id_conf_inmueble")
										,resultSet.getInt("id_topografia_inmueble")
										,validar(resultSet.getString("uso_suelo"),"")
										,validar(resultSet.getString("cus"),"")
										,validar(resultSet.getString("densidad_habitacional"),"")
										,validar(resultSet.getString("uso_actual"),"")
										,resultSet.getInt("num_recamaras")
										,resultSet.getInt("num_banios")
										,resultSet.getInt("num_estacionamiento")
										,resultSet.getInt("id_calidad_proyecto")
										,resultSet.getInt("id_clase_gral_inmueble")
										,resultSet.getInt("id_estado_conservacion")
										,resultSet.getInt("edad_contruccion")
										,resultSet.getInt("vida_util_remanente")
										,resultSet.getInt("niveles_construccion")
										,validar(resultSet.getString("grado_terminacion_obra"),"")
										,validar(resultSet.getString("grado_avance_areas_comunes"),"")
										,validar(resultSet.getString("superficie_terreno_vivienda"),"")
										,validar(resultSet.getString("superficie_construida"),"")
										,validar(resultSet.getString("superficie_accesorias"),"")
										,validar(resultSet.getString("superficie_vendible"),"")
										,validar(resultSet.getString("indivisos_construccion"),"")
										,validar(resultSet.getString("indivisos_terreno"),"")
										,resultSet.getInt("id_inst_hidraulicas")
										,validar(resultSet.getString("mat_inst_hidraulicas"),"")
										,resultSet.getInt("id_inst_sanitarias")
										,validar(resultSet.getString("mat_inst_sanitarias"),"")
										,resultSet.getInt("id_inst_electricas")
										,resultSet.getInt("id_elementos_adicionales")
										,validar(resultSet.getString("elementos_adicionales_valor"),"")
										,validar(resultSet.getString("valor_comparativo_total"),"")
										,validar(resultSet.getString("valor_comparativo_m2"),"")
										,validar(resultSet.getString("valor_terreno_total"),"")
										,validar(resultSet.getString("valor_terreno_m2"),"")
										,validar(resultSet.getString("valor_construccion_total"),"")
										,validar(resultSet.getString("valor_construccion_m2"),"")
										,validar(resultSet.getString("valor_residual"),"")
										,validar(resultSet.getString("valor_concluido"),"")
										,resultSet.getInt("id_ubica_inmueble_terreno")
										,validar(resultSet.getString("superficie_terreno_conjunto"),"")
										,resultSet.getInt("id_vigilancia")
										,resultSet.getBoolean("senalizacion_vial")
										,resultSet.getInt("id_suministro_electricidad")
										,resultSet.getInt("id_agua_potable")
										,validar(resultSet.getString("indice_saturacion_zona"),"")
										,resultSet.getInt("id_uso_construcciones")
										,resultSet.getInt("id_ref_proximidad_urbana")
										,resultSet.getInt("id_clase_zona")
										,validar(resultSet.getString("id_perito_shf"),"")
										,resultSet.getInt("id_densidad_poblacion")
										,validar(resultSet.getString("id_controlador_shf"),"")
										,validar(resultSet.getString("longitud"),"")
										,validar(resultSet.getString("latitud"),"")
										,validar(resultSet.getString("altitud"),"")
										,validar(resultSet.getString("otro_tipo_sistema"),"")
										,resultSet.getInt("id_existencia_trans_urbano")
										,resultSet.getInt("id_existencia_tran_suburbano")
										,resultSet.getInt("rec_municipal_desechos_frec")
										,resultSet.getInt("id_nivel_infraurbana")
										,resultSet.getInt("id_existencia_iglesia")
										,resultSet.getInt("id_existencia_mercados")
										,resultSet.getInt("id_existencia_plaza_publica")
										,resultSet.getInt("id_existencia_parques_jardines")
										,resultSet.getInt("id_existencia_escuelas")
										,resultSet.getInt("id_existencia_hospitales")
										,resultSet.getInt("id_existencia_bancos")
										,resultSet.getInt("id_existencia_acceso_estacion_urbano")
										,resultSet.getInt("id_existenciaaccesoestacionsuburbano")
										,resultSet.getInt("id_existenciacentrocomunitario")
										,resultSet.getInt("idnivelequipamientourbano")
										,resultSet.getInt("reportedensidad")
										,resultSet.getInt("id_existe_espacio_uso_multiple")
										,resultSet.getInt("num_medios_banios")
										,validar(resultSet.getString("resultado_calidad_proyecto"),"")
										,validar(resultSet.getString("comentarios_estado_conservacion"),"")
										,validar(resultSet.getString("mat_inst_electricas"),"")
										,validar(resultSet.getString("valor_hipotetico"),"")
										,resultSet.getInt("densidadhabitacionalhabitantes")
										,resultSet.getInt("densidadhabitacionalviviendas")
										,resultSet.getInt("id_supermercados")
										,resultSet.getInt("id_locales_comerciales")
										,resultSet.getInt("num_locales_comerciales")
										,resultSet.getInt("id_existencia_parques")
										,resultSet.getInt("id_existencia_jardines")
										,resultSet.getInt("id_canchas_deportivas")
										,resultSet.getInt("id_centro_deportivo")
										,resultSet.getInt("id_escuelas_primarias")
										,resultSet.getInt("id_escuelas_secundarias")
										,resultSet.getInt("id_escuelas_preparatoria")
										,resultSet.getInt("id_universidad")
										,resultSet.getInt("id_otras_escuelas")
										,resultSet.getInt("id_servicios_salud_primer_nivel")
										,resultSet.getInt("id_servicios_salud_segundo_nivel")
										,resultSet.getInt("id_servicios_salud_tercer_nivel")
										,resultSet.getInt("id_terreno_colinda")
										,resultSet.getInt("id_terreno_ubicado")
										,resultSet.getInt("id_riesgo_social")
										,resultSet.getInt("id_riesgo_comercial")
										,("fecha_visita_inmueble")
										,resultSet.getInt("id_metodo_conclusion_avaluo")
										,validar(resultSet.getString("marca_vivienda_usada_menor_tres"),"")
									  );
		}
	}

	@Override
	public DetalleAvaluoVo buscar(DetalleAvaluoVo registro) {
		try
		{
			return this.jdbcAvaluos.queryForObject("SELECT * FROM detalle_Avaluo WITH(NOLOCK) WHERE id_avaluo=?",new DetalleAvaluoMapper(),registro.getIdAvaluo()) ;
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public List<DetalleAvaluoVo> buscarLista(DetalleAvaluoVo registro) {
		String regreso = "";
		StringBuilder sentencia = new StringBuilder();
		regreso  = generarCriterios(registro,null);
		if( regreso!=null && !regreso.equals("") )
		{
			sentencia.append(SELECT).append(WHERE).append(regreso);
		}
		LOGGER.info("Senetencia a ejecutar: "+sentencia.toString());
		return this.jdbcAvaluos.query(sentencia.toString(),new DetalleExtractor());
	}

	@Override
	public String generarCriterios(DetalleAvaluoVo registro,List<Object> parametros) {
		StringBuilder regreso = new StringBuilder();
		
		if( registro.getIdMetodoConclusionAvaluo()>0 )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("id_metodo_conclusion_avaluo").append(IGUAL).append(registro.getIdMetodoConclusionAvaluo());
			}else
			{
				regreso.append("id_metodo_conclusion_avaluo").append(IGUAL).append(registro.getIdMetodoConclusionAvaluo());
			}
		}
		if( registro.getEdadContruccion()>0 )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("edad_contruccion").append(IGUAL).append(registro.getEdadContruccion());
			}else
			{
				regreso.append("edad_contruccion").append(IGUAL).append(registro.getEdadContruccion());
			}
		}
		if( registro.getIdEstadoConservacion()>0 )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("id_estado_conservacion").append(IGUAL).append(registro.getIdEstadoConservacion());
			}else
			{
				regreso.append("id_estado_conservacion").append(IGUAL).append(registro.getIdEstadoConservacion());
			}
		}
		if( registro.getValorOfertaMinimo()!=null && !registro.getValorOfertaMinimo().trim().equals("") && registro.getValorOfertaMaximo()!=null && !registro.getValorOfertaMaximo().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("valor_concluido").append(MAYOR_IGUAL).append(COMILLA).append(registro.getValorOfertaMinimo()).append(COMILLA).append(AND).append("valor_concluido").append(MENOR_IGUAL).append(COMILLA).append(registro.getValorOfertaMaximo()).append(COMILLA);
			}else
			{
				regreso.append("valor_concluido").append(MAYOR_IGUAL).append(COMILLA).append(registro.getValorOfertaMinimo()).append(COMILLA).append(AND).append("valor_concluido").append(MENOR_IGUAL).append(COMILLA).append(registro.getValorOfertaMaximo()).append(COMILLA);
			}
		}
		
		if( registro.getSuperficieTerrenoMinimo()!=null && !registro.getSuperficieTerrenoMinimo().trim().equals("") && registro.getSuperficieTerrenoMaximo()!=null && !registro.getSuperficieTerrenoMaximo().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("superficie_terreno_vivienda").append(MAYOR_IGUAL).append(COMILLA).append(registro.getSuperficieTerrenoMinimo()).append(COMILLA).append(AND).append("superficie_terreno_vivienda").append(MENOR_IGUAL).append(COMILLA).append(registro.getSuperficieTerrenoMaximo()).append(COMILLA);
			}else
			{
				regreso.append("superficie_terreno_vivienda").append(MAYOR_IGUAL).append(COMILLA).append(registro.getSuperficieTerrenoMinimo()).append(COMILLA).append(AND).append("superficie_terreno_vivienda").append(MENOR_IGUAL).append(COMILLA).append(registro.getSuperficieTerrenoMaximo()).append(COMILLA);
			}
		}
		
		if( registro.getSuperficieConstruccionMinimo()!=null && !registro.getSuperficieConstruccionMinimo().trim().equals("") && registro.getSuperficieConstruccionMaximo()!=null && !registro.getSuperficieConstruccionMaximo().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("superficie_construida").append(MAYOR_IGUAL).append(COMILLA).append(registro.getSuperficieConstruccionMinimo()).append(COMILLA).append(AND).append("superficie_construida").append(MENOR_IGUAL).append(COMILLA).append(registro.getSuperficieConstruccionMaximo()).append(COMILLA);
			}else
			{
				regreso.append("superficie_construida").append(MAYOR_IGUAL).append(COMILLA).append(registro.getSuperficieConstruccionMinimo()).append(COMILLA).append(AND).append("superficie_construida").append(MENOR_IGUAL).append(COMILLA).append(registro.getSuperficieConstruccionMaximo()).append(COMILLA);
			}
		}
		
		if( registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals("")  )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}else
			{
				regreso.append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}
		}
		
		if( regreso==null || regreso.length()==0)
		{
			throw new IllegalArgumentException("No hay criterios para realizar la busqueda");
		}
		
		return regreso.toString(); 
	}

	@Override
	public boolean guardar(DetalleAvaluoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<DetalleAvaluoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<DetalleAvaluoVo> buscarUnicos(DetalleAvaluoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}