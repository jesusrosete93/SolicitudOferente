package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoCerradoMaiVo;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;



@Repository("AvaluoCerradoMAIDao")
public class AvaluoCerradoMAIDao extends AbstractDao<AvaluoCerradoMaiVo> {
	
	private class AvaluoCerradoMaiExtractor implements ResultSetExtractor<List<AvaluoCerradoMaiVo>>
	{
		@Override
		public List<AvaluoCerradoMaiVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<AvaluoCerradoMaiVo> regreso = new ArrayList<AvaluoCerradoMaiVo>();
			
			while( resultSet.next() )
			{
				regreso.add(new AvaluoCerradoMaiVo(   validar(resultSet.getString("folio_control"),""),validar(resultSet.getString("fecha_entrega"),"")
													 ,resultSet.getInt("id_uv"),validar(resultSet.getString("id_avaluo"),"")
													 ,validar(resultSet.getString("id_convivencia"),"")
													 ,resultSet.getInt("id_estatus"),validar(resultSet.getString("fecha_cierre"),"")
													 ,validar(resultSet.getString("fecha_visita_inmueble"),""),validar(resultSet.getString("viv_rec"),"")
													 ,resultSet.getInt("id_tipo_inmueble_valuado"),resultSet.getInt("estado")
													 ,validar(resultSet.getString("localidad"),""),validar(resultSet.getString("id_municipio"),"")
													 ,validar(resultSet.getString("cp"),""),validar(resultSet.getString("colonia"),"")
													 ,validar(resultSet.getString("calle"),""),validar(resultSet.getString("conjunto"),"")
													 ,validar(resultSet.getString("num_exterior"),""),validar(resultSet.getString("edificio"),"")
													 ,validar(resultSet.getString("num_interior"),""),validar(resultSet.getString("manzana"),"")
													 ,validar(resultSet.getString("supermanzana"),""),validar(resultSet.getString("lote"),"")
													 ,validar(resultSet.getString("condominio"),""),validar(resultSet.getString("niveles_vivienda"),"")
													 ,validar(resultSet.getString("niveles_vivienda"),""),validar(resultSet.getString("entre_calle_1"),"")
													 ,validar(resultSet.getString("entre_calle_2"),"")
													 ,validar(resultSet.getString("tipo_vivienda"),"")
													 ,validar(resultSet.getString("latitud"),"")
													 ,validar(resultSet.getString("longitud"),""),validar(resultSet.getString("altitud"),"")
													 ,resultSet.getInt("id_material_vialidades"),resultSet.getInt("id_material_banquetas")
													 ,validar(resultSet.getString("edad_contruccion"),"")
													 ,validar(resultSet.getString("id_vialidades_accesos"),""),validar(resultSet.getString("id_infraes_agua_potable"),"")
													 ,validar(resultSet.getString("id_infraes_energia_electrica"),""),validar(resultSet.getString("id_infraes_alumbrado_publico"),"")
													 ,validar(resultSet.getString("grado_terminacion_obra"),""),resultSet.getInt("id_estado_conservacion")
													 ,resultSet.getInt("id_uso_construcciones"),resultSet.getInt("id_sumin_telefonico")
													 ,validar(resultSet.getString("colindancias"),""),resultSet.getInt("nomenclatura_calles")
													 ,validar(resultSet.getString("id_zona_restricciones"),"") ,validar(resultSet.getString("id_zona_afectacion"),"")
													 ,validar(resultSet.getString("id_zona_areas_inundable"),"")
								                     ));
			}
		  return regreso;
		}
	}
		
	

	@Override
	public AvaluoCerradoMaiVo buscar(AvaluoCerradoMaiVo registro) {
		List<AvaluoCerradoMaiVo> registros = null;
		String sentencia =  "select "+
							" '' as folio_control, getdate () as fecha_entrega "+
							" , a.id_uv , a.id_avaluo, a.id_convivencia, a.id_estatus, a.fecha_cierre, d.fecha_visita_inmueble "+
							" , '' as viv_rec "+
							" , d.id_tipo_inmueble_valuado "+
							" , substring(a.id_avaluo,1,2) as estado "+
							" , v.localidad, m.id_municipio, v.cp, v.colonia, v.calle "+
							" , '' as conjunto "+
							" , v.num_exterior, v.edificio, v.num_interior, v.manzana, v.supermanzana, v.lote "+
							" , v.condominio, v.niveles_vivienda, v.niveles_edificio, v.entre_calle_1 "+
							" , v.entre_calle_2, v.tipo_vivienda " +
							" , d.latitud, d.longitud, d.altitud, d.id_material_vialidades, d.id_material_banquetas "+
							" , d.edad_contruccion "+
							" , c.id_vialidades_accesos "+
							" , c.id_infraes_agua_potable "+
							" , c.id_infraes_energia_electrica, c.id_infraes_alumbrado_publico, d.grado_terminacion_obra "+
							" , d.id_estado_conservacion, d.id_uso_construcciones, d.id_sumin_telefonico "+
							" ,'' as colindancias "+
							" , d.nomenclatura_calles, c.id_zona_restricciones, c.id_zona_afectacion, c.id_zona_areas_inundable "+
							" from avaluo as a with(nolock) "+
							" left join vivienda as v with(nolock)  on a.id_paquete = v.id_paquete and a.id_vivienda = v.id_vivienda "+
							" left join detalle_avaluo as d with(nolock) on a.id_avaluo = d.id_avaluo "+
							" left join detalle_mai as m with(nolock) on a.id_paquete = m.id_paquete and a.id_vivienda = m.id_vivienda "+
							" left join dtc as c with(nolock) on a.id_avaluo = c.id_dtc "+
							" where a.id_tipo_mercado = 2 and a.tipo_linea = 2 "+
							" and a.id_avaluo=?";
		try
		{
			registros = this.jdbcAvaluos.query(sentencia,new AvaluoCerradoMaiExtractor(),registro.getIdAvaluo());
			if( registros!=null && !registros.isEmpty())
			{
				return registros.get(0);
			}else
			{
				return null;
			}
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<AvaluoCerradoMaiVo> buscarLista(final AvaluoCerradoMaiVo registro) {
		try
		{
			String sentencia =  "select "+
			" '' as folio_control, getdate () as fecha_entrega "+
			" , a.id_uv , a.id_avaluo, a.id_convivencia, a.id_estatus, a.fecha_cierre, d.fecha_visita_inmueble "+
			" , '' as viv_rec "+
			" , d.id_tipo_inmueble_valuado "+
			" , substring(a.id_avaluo,1,2) as estado "+
			" , v.localidad, m.id_municipio, v.cp, v.colonia, v.calle "+
			" , '' as conjunto "+
			" , v.num_exterior, v.edificio, v.num_interior, v.manzana, v.supermanzana, v.lote "+
			" , v.condominio, v.niveles_vivienda, v.niveles_edificio, v.entre_calle_1 "+
			" , v.entre_calle_2, v.tipo_vivienda " +
			" , d.latitud, d.longitud, d.altitud, d.id_material_vialidades, d.id_material_banquetas "+
			" , d.edad_contruccion "+
			" , c.id_vialidades_accesos "+
			" , c.id_infraes_agua_potable "+
			" , c.id_infraes_energia_electrica, c.id_infraes_alumbrado_publico, d.grado_terminacion_obra "+
			" , d.id_estado_conservacion, d.id_uso_construcciones, d.id_sumin_telefonico "+
			" ,'' as colindancias "+
			" , d.nomenclatura_calles, c.id_zona_restricciones, c.id_zona_afectacion, c.id_zona_areas_inundable "+
			" from avaluo as a with(nolock) "+
			" left join vivienda as v with(nolock)  on a.id_paquete = v.id_paquete and a.id_vivienda = v.id_vivienda "+
			" left join detalle_avaluo as d with(nolock) on a.id_avaluo = d.id_avaluo "+
			" left join detalle_mai as m with(nolock) on a.id_paquete = m.id_paquete and a.id_vivienda = m.id_vivienda "+
			" left join dtc as c with(nolock) on a.id_avaluo = c.id_dtc "+
			" where a.id_tipo_mercado = 2 and a.tipo_linea = 2 "+
			" and a.fecha_cierre >= ? and a.fecha_cierre <= ?";

			return this.jdbcAvaluos.query(sentencia,new AvaluoCerradoMaiExtractor(),registro.getFechaCierreInicio()+" 00:00:00 ",registro.getFechaCierreFin()+" 23:59:59");
		}catch (EmptyResultDataAccessException exception) {
			return new ArrayList<AvaluoCerradoMaiVo>();
		}
	}	

	@Override
	public String generarCriterios(AvaluoCerradoMaiVo registro,
			List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(AvaluoCerradoMaiVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<AvaluoCerradoMaiVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<AvaluoCerradoMaiVo> buscarUnicos(AvaluoCerradoMaiVo registro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
