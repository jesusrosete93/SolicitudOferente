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

import mx.org.infonavit.solicitud.oferente.persistence.vo.ViviendaVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("ViviendaDao")
public class ViviendaDao extends AbstractDao<ViviendaVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(ViviendaDao.class);
	
	private class ViviendaExtractor implements ResultSetExtractor<List<ViviendaVo>>
	{
		@Override
		public List<ViviendaVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<ViviendaVo> regreso = new ArrayList<ViviendaVo>();
			while(resultSet.next())
			{
				regreso.add(new ViviendaVo(resultSet.getInt("id_vivienda")
											,validar(resultSet.getString("id_paquete"),"")
											,validar(resultSet.getString("localidad"),"")
											,validar(resultSet.getString("cp"),"")
											,validar(resultSet.getString("colonia"),"")
											,validar(resultSet.getString("supermanzana"),"")
											,validar(resultSet.getString("manzana"),"")
											,validar(resultSet.getString("lote"),"")
											,validar(resultSet.getString("calle"),"")
											,validar(resultSet.getString("entre_calle_1"),"")
											,validar(resultSet.getString("entre_calle_2"),"")
											,validar(resultSet.getString("num_exterior"),"")
											,validar(resultSet.getString("num_interior"),"")
											,validar(resultSet.getString("condominio"),"")
											,validar(resultSet.getString("entrada"),"")
											,validar(resultSet.getString("edificio"),"")
											,validar(resultSet.getString("telefono"),"")
											,validar(resultSet.getString("nivel"),"")
											,validar(resultSet.getString("fecha_solicitud"),"")
											,resultSet.getInt("estatus_avaluo")
											,validar(resultSet.getString("fecha_dtu"),"")
											,validar(resultSet.getString("existe_dtu"),"")
											,validar(resultSet.getString("NSS"),"")
											,validar(resultSet.getString("fecha_compromiso_termino"),"")
											,validar(resultSet.getString("precio_venta"),"")
											,validar(resultSet.getString("cuv"),"")
											,validar(resultSet.getString("tipo_vivienda"),"")
											,validar(resultSet.getString("num_notario"),"")
											,validar(resultSet.getString("nombre_notario"),"")
											,validar(resultSet.getString("plaza"),"")
											,validar(resultSet.getString("num_escritura"),"")
											,validar(resultSet.getString("libro"),"")
											,validar(resultSet.getString("volumen"),"")
											,validar(resultSet.getString("vivienda_verde_costo"),"")
											,validar(resultSet.getString("vivienda_verde_ahorro"),"")
											,validar(resultSet.getString("niveles_edificio"),"")
											,validar(resultSet.getString("niveles_vivienda"),"")
											,validar(resultSet.getString("vivienda_recuperada"),"")
											,validar(resultSet.getString("cofinanciamiento"),"")
											,validar(resultSet.getString("apoyo_infonavit"),"")
											));
			}
		 return regreso;
		}
	}
	
	
	private class ViviendaMapper implements RowMapper<ViviendaVo>
	{
		@Override
		public ViviendaVo mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new ViviendaVo(resultSet.getInt("id_vivienda")
								,validar(resultSet.getString("id_paquete"),"")
								,validar(resultSet.getString("localidad"),"")
								,validar(resultSet.getString("cp"),"")
								,validar(resultSet.getString("colonia"),"")
								,validar(resultSet.getString("supermanzana"),"")
								,validar(resultSet.getString("manzana"),"")
								,validar(resultSet.getString("lote"),"")
								,validar(resultSet.getString("calle"),"")
								,validar(resultSet.getString("entre_calle_1"),"")
								,validar(resultSet.getString("entre_calle_2"),"")
								,validar(resultSet.getString("num_exterior"),"")
								,validar(resultSet.getString("num_interior"),"")
								,validar(resultSet.getString("condominio"),"")
								,validar(resultSet.getString("entrada"),"")
								,validar(resultSet.getString("edificio"),"")
								,validar(resultSet.getString("telefono"),"")
								,validar(resultSet.getString("nivel"),"")
								,validar(resultSet.getString("fecha_solicitud"),"")
								,resultSet.getInt("estatus_avaluo")
								,validar(resultSet.getString("fecha_dtu"),"")
								,validar(resultSet.getString("existe_dtu"),"")
								,validar(resultSet.getString("NSS"),"")
								,validar(resultSet.getString("fecha_compromiso_termino"),"")
								,validar(resultSet.getString("precio_venta"),"")
								,validar(resultSet.getString("cuv"),"")
								,validar(resultSet.getString("tipo_vivienda"),"")
								,validar(resultSet.getString("num_notario"),"")
								,validar(resultSet.getString("nombre_notario"),"")
								,validar(resultSet.getString("plaza"),"")
								,validar(resultSet.getString("num_escritura"),"")
								,validar(resultSet.getString("libro"),"")
								,validar(resultSet.getString("volumen"),"")
								,validar(resultSet.getString("vivienda_verde_costo"),"")
								,validar(resultSet.getString("vivienda_verde_ahorro"),"")
								,validar(resultSet.getString("niveles_edificio"),"")
								,validar(resultSet.getString("niveles_vivienda"),"")
								,validar(resultSet.getString("vivienda_recuperada"),"")
								,validar(resultSet.getString("cofinanciamiento"),"")
								,validar(resultSet.getString("apoyo_infonavit"),"")
								);
		}
	}

	@Override
	public ViviendaVo buscar(ViviendaVo registro) {
		// TODO Auto-generated method stub
		try
		{
			return this.jdbcAvaluos.queryForObject("SELECT * FROM vivienda WITH(NOLOCK) WHERE id_paquete=? AND id_vivienda=?",new ViviendaMapper(),registro.getId_paquete(),registro.getId_vivienda()) ;
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public List<ViviendaVo> buscarLista(ViviendaVo registro) {
		try
		{
			String query = "SELECT * FROM vivienda WITH(NOLOCK)";
			if(registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals(""))
			{
				query += " WHERE id_avaluo IN ("+registro.getAvaluos()+")";
			}
			LOGGER.info("query: "+query);
			return this.jdbcAvaluos.query(query,new ViviendaExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<ViviendaVo>();
		}
	}

	@Override
	public String generarCriterios(ViviendaVo registro, List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(ViviendaVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<ViviendaVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<ViviendaVo> buscarUnicos(ViviendaVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
