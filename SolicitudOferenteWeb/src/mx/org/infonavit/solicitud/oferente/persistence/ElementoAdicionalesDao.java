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

import mx.org.infonavit.solicitud.oferente.persistence.vo.ElementosAdicionalesVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("ElementoAdicionalesDao")
public class ElementoAdicionalesDao extends AbstractDao<ElementosAdicionalesVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(ElementoAdicionalesDao.class);
	
	private class ElementosAdicionalesExtractor implements ResultSetExtractor<List<ElementosAdicionalesVo>>
	{

		@Override
		public List<ElementosAdicionalesVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<ElementosAdicionalesVo> regreso = new ArrayList<ElementosAdicionalesVo>();
			while(resultSet.next())
			{
				regreso.add(new ElementosAdicionalesVo(	 validar(resultSet.getString("id_avaluo"),"")
												,resultSet.getInt("id_sist_desc_agua_residuales")
												,resultSet.getInt("id_tratamiento_agua")
												,resultSet.getInt("id_sist_reuso_agua_restratada")
												,resultSet.getInt("id_trat_reut_aguas_jabonosas")
												,resultSet.getInt("id_sist_reuso_agua_jabonosa")
												,resultSet.getInt("id_captacion_agua_pluvial")
												,resultSet.getInt("id_separacion_basura")
												,resultSet.getInt("id_cont_elab_composta")
												,resultSet.getInt("id_foto_alumbrado_publico")
												,resultSet.getInt("id_red_agua_purificada")
												,resultSet.getInt("id_sen_braile_numonom_edificio")
												,resultSet.getInt("id_senbraile_calle_inter")
												,resultSet.getInt("id_num_piso_inc_fin_barandal")
												,resultSet.getInt("id_num_depto_por_piso")
												,resultSet.getInt("id_boton_eleva_braile")
												,validar(resultSet.getString("otro_tipo_insta_conjunto"),"")
												,resultSet.getInt("id_wc_economiza_agua_seis")
												,resultSet.getInt("id_wc_economiza_agua_cinco")
												,resultSet.getInt("id_wc_economiza_agua_cuatro")
												,resultSet.getInt("id_econo_agua_doble_boton")
												,resultSet.getInt("id_regadera_ahorra_agua")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_regadera")
												,resultSet.getInt("id_regadera_ahorra_agua_banio")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_banio")
												,resultSet.getInt("id_regadera_ahorra_agua_cocina")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_cocina")
												,resultSet.getInt("id_calentador_gas")
												,resultSet.getInt("id_calentador_paso")
												,resultSet.getInt("id_sen_braile_enciende_apaga_boiler")
												,resultSet.getInt("id_calentador_solar")
												,resultSet.getInt("id_aire_acondicionado")
												,resultSet.getInt("id_braile_aire_acondicionado")
												,resultSet.getInt("id_ubica_aire_acondicionado")
												,resultSet.getInt("id_aislan_termico_techo_nommx")
												,resultSet.getInt("id_aislante_rmicomurofide")
												,resultSet.getInt("id_aislan_termico_puerta_ventana")
												,resultSet.getInt("id_sist_encendido_luces")
												,resultSet.getInt("id_captacion_energia")
												,resultSet.getInt("id_voz_datos_internet")
												,resultSet.getInt("id_sumin_agua_purificada")
												,resultSet.getInt("id_interfon")
												,resultSet.getInt("id_circuitos_electricidad")
												,resultSet.getInt("id_protec_solar_ventana")
												,validar(resultSet.getString("instalacion_especial_vivienda_otro"),"")
												,resultSet.getInt("id_caseta_vigilancia")
												,resultSet.getInt("id_locales_comerciales")
												,resultSet.getInt("id_barda_perimetral")
												,resultSet.getInt("id_elevador")
												,resultSet.getInt("id_estacionamiento_techado")
												,resultSet.getInt("id_estacionamiento_visitas")
												,resultSet.getInt("id_estacionamiento_discapacitados")
												,resultSet.getInt("id_rampa_banqueta_discapacitados")
												,resultSet.getInt("id_juegos_infantiles")
												,resultSet.getInt("id_canchas_deportivas")
												,validar(resultSet.getString("otro_tipo_obras_complementarias"),"")
												,resultSet.getInt("id_estacionamiento_techado_vivienda")
												,resultSet.getInt("id_rampa_acceso_interior_vivienda")
												,resultSet.getInt("id_textura_especial_piso")
												,resultSet.getInt("id_accesoria")
												,resultSet.getInt("id_cisterna")
												,resultSet.getInt("id_ducto_clima")
												,resultSet.getInt("id_jaula_tendido")
												,resultSet.getInt("id_rejas_proteccion_ventanas")
												,resultSet.getInt("id_banio_discapacitados")
												,resultSet.getInt("id_banio_discapacitados_plantabaja")
												,resultSet.getInt("id_banio_discapacitados_regadera_sardinel")
												,resultSet.getInt("id_banio_discapacitados_piso_antiderrapante")
												,resultSet.getInt("id_banio_discapacitados_charola_regadera")
												,resultSet.getInt("id_banio_discapacitados_pendiente_rejilla_captacion")
												,resultSet.getInt("id_banio_discapacitados_salida_regadera_telefono")
												,resultSet.getInt("id_banio_discapacitados_adecuar_lavabo")
												,resultSet.getInt("id_banio_discapacitados_maneral_palanca")
												,resultSet.getInt("id_cocina_discapacitados_adecuar_tarja")
												,resultSet.getInt("id_marco_movible_discapacitados")
												,resultSet.getInt("id_banio_discapacitados_colocacion_espejo")
												,resultSet.getInt("id_banio_discapacitados_pasamanos")
												,resultSet.getInt("id_banio_discapacitados_areas_circulacion")
												,resultSet.getInt("id_pasillos")
												,resultSet.getInt("id_cocina")
												,resultSet.getInt("id_banio")
												,resultSet.getInt("id_recamara")
												,resultSet.getInt("id_accesos_vivienda_puerta")
												,resultSet.getInt("id_accesos_espacios_interiores")
												,validar(resultSet.getString("otro_tipo_obras_complementarias_vivienda"),"")
												,resultSet.getInt("id_drenaje_pretratado_aguas_negras")
												,resultSet.getInt("id_captacion_solar_calentamiento_agua")
												,resultSet.getInt("id_reductor_sedimentos_calcificados_conjunto")
												,resultSet.getInt("id_camaras_seguridad")
												,resultSet.getInt("id_doble_descarga_inodoro_normal")
												,resultSet.getInt("id_llaves_ahorro_agua_lavabos_banio")
												,resultSet.getInt("id_reduccion_flujo_llaves_lavabo")
												,resultSet.getInt("id_regadera_ahorrador_integrado")
												,resultSet.getInt("id_reduccion_flujo_llave_cocina")
												,resultSet.getInt("id_valvula_regula_flujo_suministro")
												,resultSet.getInt("id_captacion_agua_pluvial_vivienda")
												,resultSet.getInt("id_calentador_solar_tubos_evacuados")
												,resultSet.getInt("id_calentador_solar_tubos_respaldo_gas")
												,resultSet.getInt("id_calentador_solar_plano_respaldo_gas_paso")
												,resultSet.getInt("id_calentador_solar_tubos_respaldo_electrico")
												,resultSet.getInt("id_calentador_solar_plano_respaldo_electrico")
												,resultSet.getInt("id_ventilador_solar_corriente_directa")
												,resultSet.getInt("id_ventilador_solar_corriente_alterna")
												,resultSet.getInt("id_ventilador_cuerda_alta_potencia")
												,resultSet.getInt("id_ventilador_cuerda_baja_potencia")
												,resultSet.getInt("id_focos_ahorradores")
												,resultSet.getInt("id_focos_led_luz_dirigida")
												,resultSet.getInt("id_focos_led_luz_difusa")
												,resultSet.getInt("id_iluminacion_natural")
												,resultSet.getInt("id_estabilizador_estatico")
												,resultSet.getInt("id_dispositivo_ahorrador_gas")
												,resultSet.getInt("id_mantenimiento_contratado_desarrollador")
												,resultSet.getInt("id_filtros_purificadores_agua")
												,resultSet.getInt("id_desinfeccion_agua_tinaco")
												,resultSet.getInt("id_reductor_sedimentos_calcificados_vivienda")
												,resultSet.getInt("id_pintura_reflejante_techo")
												,resultSet.getInt("id_pintura_reflejante_muro")
												,resultSet.getInt("id_aislante_tuberia")
												,resultSet.getInt("id_tuberia_termica")
												,resultSet.getInt("id_pintura_fotocatalitica")
												,resultSet.getInt("id_doble_vidrio_ventanas")
												,resultSet.getInt("id_vidrios_pelicula_reflectiva")
												,resultSet.getInt("id_vidrios_dobles_marco_pvc")
												,resultSet.getInt("id_vidrios_pelicula_reflectiva_marcos_pvc")
												,resultSet.getInt("id_hidromaceteros")
												,resultSet.getInt("num_hidromaceteros")
												,resultSet.getInt("id_optimizador_tension_electrica")
												,resultSet.getInt("id_refrigerador")
												,resultSet.getInt("id_lavadora")
												,resultSet.getInt("id_estufa")
												,resultSet.getInt("id_paneles_fotovoltaicos")
												,resultSet.getInt("id_captacion_agua")
												,resultSet.getInt("id_ahorrador_energia_electrica")
												,validar(resultSet.getString("urlComparativaUno"),"")
												,validar(resultSet.getString("urlComparativaDos"),"")
												,validar(resultSet.getString("urlComparativaTres"),"")
												,validar(resultSet.getString("urlComparativaCuatro"),"")
												,validar(resultSet.getString("urlComparativaCinco"),"")
												,validar(resultSet.getString("urlComparativaSeis"),"")
												,validar(resultSet.getString("ladaUno"),"")
												,validar(resultSet.getString("ladaDos"),"")
												,validar(resultSet.getString("ladaTres"),"")
												,validar(resultSet.getString("ladaCuatro"),"")
												,validar(resultSet.getString("ladaCinco"),"")
												,validar(resultSet.getString("ladaSeis"),"")
												,validar(resultSet.getString("telefonoUno"),"")
												,validar(resultSet.getString("telefonoDos"),"")
												,validar(resultSet.getString("telefonoTres"),"")
												,validar(resultSet.getString("telefonoCuatro"),"")
												,validar(resultSet.getString("telefonoCinco"),"")
												,validar(resultSet.getString("telefonoSeis"),"")
												,validar(resultSet.getString("nombreVecinalUno"),"")
												,validar(resultSet.getString("nombreVecinalDos"),"")
												,validar(resultSet.getString("nombreVecinalTres"),"")
												,validar(resultSet.getString("nombreVecinalCuatro"),"")
												,validar(resultSet.getString("nombreVecinalCinco"),"")
												,validar(resultSet.getString("nombreVecinalSeis"),"")
										));
			}
		 return regreso;
		}
		
	}
	
	private class ElementosAdicionalesMapper implements RowMapper<ElementosAdicionalesVo>
	{
		
		@Override
		public ElementosAdicionalesVo mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			// TODO Auto-generated method stub
			return new ElementosAdicionalesVo(	 validar(resultSet.getString("id_avaluo"),"")
												,resultSet.getInt("id_sist_desc_agua_residuales")
												,resultSet.getInt("id_tratamiento_agua")
												,resultSet.getInt("id_sist_reuso_agua_restratada")
												,resultSet.getInt("id_trat_reut_aguas_jabonosas")
												,resultSet.getInt("id_sist_reuso_agua_jabonosa")
												,resultSet.getInt("id_captacion_agua_pluvial")
												,resultSet.getInt("id_separacion_basura")
												,resultSet.getInt("id_cont_elab_composta")
												,resultSet.getInt("id_foto_alumbrado_publico")
												,resultSet.getInt("id_red_agua_purificada")
												,resultSet.getInt("id_sen_braile_numonom_edificio")
												,resultSet.getInt("id_senbraile_calle_inter")
												,resultSet.getInt("id_num_piso_inc_fin_barandal")
												,resultSet.getInt("id_num_depto_por_piso")
												,resultSet.getInt("id_boton_eleva_braile")
												,validar(resultSet.getString("otro_tipo_insta_conjunto"),"")
												,resultSet.getInt("id_wc_economiza_agua_seis")
												,resultSet.getInt("id_wc_economiza_agua_cinco")
												,resultSet.getInt("id_wc_economiza_agua_cuatro")
												,resultSet.getInt("id_econo_agua_doble_boton")
												,resultSet.getInt("id_regadera_ahorra_agua")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_regadera")
												,resultSet.getInt("id_regadera_ahorra_agua_banio")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_banio")
												,resultSet.getInt("id_regadera_ahorra_agua_cocina")
												,resultSet.getInt("id_sen_braile_agua_fria_cal_cocina")
												,resultSet.getInt("id_calentador_gas")
												,resultSet.getInt("id_calentador_paso")
												,resultSet.getInt("id_sen_braile_enciende_apaga_boiler")
												,resultSet.getInt("id_calentador_solar")
												,resultSet.getInt("id_aire_acondicionado")
												,resultSet.getInt("id_braile_aire_acondicionado")
												,resultSet.getInt("id_ubica_aire_acondicionado")
												,resultSet.getInt("id_aislan_termico_techo_nommx")
												,resultSet.getInt("id_aislante_rmicomurofide")
												,resultSet.getInt("id_aislan_termico_puerta_ventana")
												,resultSet.getInt("id_sist_encendido_luces")
												,resultSet.getInt("id_captacion_energia")
												,resultSet.getInt("id_voz_datos_internet")
												,resultSet.getInt("id_sumin_agua_purificada")
												,resultSet.getInt("id_interfon")
												,resultSet.getInt("id_circuitos_electricidad")
												,resultSet.getInt("id_protec_solar_ventana")
												,validar(resultSet.getString("instalacion_especial_vivienda_otro"),"")
												,resultSet.getInt("id_caseta_vigilancia")
												,resultSet.getInt("id_locales_comerciales")
												,resultSet.getInt("id_barda_perimetral")
												,resultSet.getInt("id_elevador")
												,resultSet.getInt("id_estacionamiento_techado")
												,resultSet.getInt("id_estacionamiento_visitas")
												,resultSet.getInt("id_estacionamiento_discapacitados")
												,resultSet.getInt("id_rampa_banqueta_discapacitados")
												,resultSet.getInt("id_juegos_infantiles")
												,resultSet.getInt("id_canchas_deportivas")
												,validar(resultSet.getString("otro_tipo_obras_complementarias"),"")
												,resultSet.getInt("id_estacionamiento_techado_vivienda")
												,resultSet.getInt("id_rampa_acceso_interior_vivienda")
												,resultSet.getInt("id_textura_especial_piso")
												,resultSet.getInt("id_accesoria")
												,resultSet.getInt("id_cisterna")
												,resultSet.getInt("id_ducto_clima")
												,resultSet.getInt("id_jaula_tendido")
												,resultSet.getInt("id_rejas_proteccion_ventanas")
												,resultSet.getInt("id_banio_discapacitados")
												,resultSet.getInt("id_banio_discapacitados_plantabaja")
												,resultSet.getInt("id_banio_discapacitados_regadera_sardinel")
												,resultSet.getInt("id_banio_discapacitados_piso_antiderrapante")
												,resultSet.getInt("id_banio_discapacitados_charola_regadera")
												,resultSet.getInt("id_banio_discapacitados_pendiente_rejilla_captacion")
												,resultSet.getInt("id_banio_discapacitados_salida_regadera_telefono")
												,resultSet.getInt("id_banio_discapacitados_adecuar_lavabo")
												,resultSet.getInt("id_banio_discapacitados_maneral_palanca")
												,resultSet.getInt("id_cocina_discapacitados_adecuar_tarja")
												,resultSet.getInt("id_marco_movible_discapacitados")
												,resultSet.getInt("id_banio_discapacitados_colocacion_espejo")
												,resultSet.getInt("id_banio_discapacitados_pasamanos")
												,resultSet.getInt("id_banio_discapacitados_areas_circulacion")
												,resultSet.getInt("id_pasillos")
												,resultSet.getInt("id_cocina")
												,resultSet.getInt("id_banio")
												,resultSet.getInt("id_recamara")
												,resultSet.getInt("id_accesos_vivienda_puerta")
												,resultSet.getInt("id_accesos_espacios_interiores")
												,validar(resultSet.getString("otro_tipo_obras_complementarias_vivienda"),"")
												,resultSet.getInt("id_drenaje_pretratado_aguas_negras")
												,resultSet.getInt("id_captacion_solar_calentamiento_agua")
												,resultSet.getInt("id_reductor_sedimentos_calcificados_conjunto")
												,resultSet.getInt("id_camaras_seguridad")
												,resultSet.getInt("id_doble_descarga_inodoro_normal")
												,resultSet.getInt("id_llaves_ahorro_agua_lavabos_banio")
												,resultSet.getInt("id_reduccion_flujo_llaves_lavabo")
												,resultSet.getInt("id_regadera_ahorrador_integrado")
												,resultSet.getInt("id_reduccion_flujo_llave_cocina")
												,resultSet.getInt("id_valvula_regula_flujo_suministro")
												,resultSet.getInt("id_captacion_agua_pluvial_vivienda")
												,resultSet.getInt("id_calentador_solar_tubos_evacuados")
												,resultSet.getInt("id_calentador_solar_tubos_respaldo_gas")
												,resultSet.getInt("id_calentador_solar_plano_respaldo_gas_paso")
												,resultSet.getInt("id_calentador_solar_tubos_respaldo_electrico")
												,resultSet.getInt("id_calentador_solar_plano_respaldo_electrico")
												,resultSet.getInt("id_ventilador_solar_corriente_directa")
												,resultSet.getInt("id_ventilador_solar_corriente_alterna")
												,resultSet.getInt("id_ventilador_cuerda_alta_potencia")
												,resultSet.getInt("id_ventilador_cuerda_baja_potencia")
												,resultSet.getInt("id_focos_ahorradores")
												,resultSet.getInt("id_focos_led_luz_dirigida")
												,resultSet.getInt("id_focos_led_luz_difusa")
												,resultSet.getInt("id_iluminacion_natural")
												,resultSet.getInt("id_estabilizador_estatico")
												,resultSet.getInt("id_dispositivo_ahorrador_gas")
												,resultSet.getInt("id_mantenimiento_contratado_desarrollador")
												,resultSet.getInt("id_filtros_purificadores_agua")
												,resultSet.getInt("id_desinfeccion_agua_tinaco")
												,resultSet.getInt("id_reductor_sedimentos_calcificados_vivienda")
												,resultSet.getInt("id_pintura_reflejante_techo")
												,resultSet.getInt("id_pintura_reflejante_muro")
												,resultSet.getInt("id_aislante_tuberia")
												,resultSet.getInt("id_tuberia_termica")
												,resultSet.getInt("id_pintura_fotocatalitica")
												,resultSet.getInt("id_doble_vidrio_ventanas")
												,resultSet.getInt("id_vidrios_pelicula_reflectiva")
												,resultSet.getInt("id_vidrios_dobles_marco_pvc")
												,resultSet.getInt("id_vidrios_pelicula_reflectiva_marcos_pvc")
												,resultSet.getInt("id_hidromaceteros")
												,resultSet.getInt("num_hidromaceteros")
												,resultSet.getInt("id_optimizador_tension_electrica")
												,resultSet.getInt("id_refrigerador")
												,resultSet.getInt("id_lavadora")
												,resultSet.getInt("id_estufa")
												,resultSet.getInt("id_paneles_fotovoltaicos")
												,resultSet.getInt("id_captacion_agua")
												,resultSet.getInt("id_ahorrador_energia_electrica")
												,validar(resultSet.getString("urlComparativaUno"),"")
												,validar(resultSet.getString("urlComparativaDos"),"")
												,validar(resultSet.getString("urlComparativaTres"),"")
												,validar(resultSet.getString("urlComparativaCuatro"),"")
												,validar(resultSet.getString("urlComparativaCinco"),"")
												,validar(resultSet.getString("urlComparativaSeis"),"")
												,validar(resultSet.getString("ladaUno"),"")
												,validar(resultSet.getString("ladaDos"),"")
												,validar(resultSet.getString("ladaTres"),"")
												,validar(resultSet.getString("ladaCuatro"),"")
												,validar(resultSet.getString("ladaCinco"),"")
												,validar(resultSet.getString("ladaSeis"),"")
												,validar(resultSet.getString("telefonoUno"),"")
												,validar(resultSet.getString("telefonoDos"),"")
												,validar(resultSet.getString("telefonoTres"),"")
												,validar(resultSet.getString("telefonoCuatro"),"")
												,validar(resultSet.getString("telefonoCinco"),"")
												,validar(resultSet.getString("telefonoSeis"),"")
												,validar(resultSet.getString("nombreVecinalUno"),"")
												,validar(resultSet.getString("nombreVecinalDos"),"")
												,validar(resultSet.getString("nombreVecinalTres"),"")
												,validar(resultSet.getString("nombreVecinalCuatro"),"")
												,validar(resultSet.getString("nombreVecinalCinco"),"")
												,validar(resultSet.getString("nombreVecinalSeis"),"")
);
		}
		
	}

	@Override
	public ElementosAdicionalesVo buscar(ElementosAdicionalesVo registro) {
		try
		{
			return this.jdbcAvaluos.queryForObject("SELECT * FROM elementos_adicionales WITH(NOLOCK) WHERE id_avaluo=?", new ElementosAdicionalesMapper(),registro.getId_avaluo());
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<ElementosAdicionalesVo> buscarLista(ElementosAdicionalesVo registro) {
		try
		{
			String query = "SELECT * FROM elementos_adicionales WITH(NOLOCK)";
			if( registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals(""))
			{
				query += " WHERE id_avaluo IN ("+registro.getAvaluos()+")";
			}
			LOGGER.info("Sentencia: "+query);
			return this.jdbcAvaluos.query(query, new ElementosAdicionalesExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<ElementosAdicionalesVo>();
		}
	}

	@Override
	public String generarCriterios(ElementosAdicionalesVo registro,
			List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(ElementosAdicionalesVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<ElementosAdicionalesVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<ElementosAdicionalesVo> buscarUnicos(
			ElementosAdicionalesVo registro) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
