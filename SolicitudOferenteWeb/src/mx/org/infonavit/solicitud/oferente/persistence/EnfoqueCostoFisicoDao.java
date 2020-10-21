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

import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueCostoFisicoVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("EnfoqueCostoFisicoDao")
public class EnfoqueCostoFisicoDao extends AbstractDao<EnfoqueCostoFisicoVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(EnfoqueCostoFisicoDao.class);
	
//	private static final String SELECT = "SELECT * FROM enfoque_costos_fisico WITH(NOLOCK) ";
	
	
	private class EnfoqueFisicoExtractor implements ResultSetExtractor<List<EnfoqueCostoFisicoVo>>{
		@Override
		public List<EnfoqueCostoFisicoVo> extractData(ResultSet resultSet)throws SQLException, DataAccessException {
			List<EnfoqueCostoFisicoVo> regreso = new ArrayList<EnfoqueCostoFisicoVo>();
			while( resultSet.next() )
			{
				regreso.add(new EnfoqueCostoFisicoVo(   resultSet.getInt("id_registro")
														,validar(resultSet.getString("id_avaluo"),"")
														,validar(resultSet.getString("id_paquete"),"")
														,resultSet.getInt("id_vivienda")
														,validar(resultSet.getString("valor_oferta"),"")
														,validar(resultSet.getString("superficie_terreno"),"")
														,validar(resultSet.getString("valor_unitario"),"")
														,validar(resultSet.getString("factor_zona"),"")
														,validar(resultSet.getString("factor_ubicacion"),"")
														,validar(resultSet.getString("factor_frente"),"")
														,validar(resultSet.getString("factor_forma"),"")
														,validar(resultSet.getString("factor_superficie"),"")
														,validar(resultSet.getString("factor_comercializacion"),"")
														,validar(resultSet.getString("factor_otros"),"")
														,validar(resultSet.getString("factor_resultante"),"")));
			}
		 return regreso;
		}
		
	}
	
	private class EnfoqueFisicoMapper implements RowMapper<EnfoqueCostoFisicoVo>
	{
		@Override
		public EnfoqueCostoFisicoVo mapRow(ResultSet resultSet, int fecth)
				throws SQLException {
			return new EnfoqueCostoFisicoVo( resultSet.getInt("id_registro")
											,validar(resultSet.getString("id_avaluo"),"")
											,validar(resultSet.getString("id_paquete"),"")
											,resultSet.getInt("id_vivienda")
											,validar(resultSet.getString("valor_oferta"),"")
											,validar(resultSet.getString("superficie_terreno"),"")
											,validar(resultSet.getString("valor_unitario"),"")
											,validar(resultSet.getString("factor_zona"),"")
											,validar(resultSet.getString("factor_ubicacion"),"")
											,validar(resultSet.getString("factor_frente"),"")
											,validar(resultSet.getString("factor_forma"),"")
											,validar(resultSet.getString("factor_superficie"),"")
											,validar(resultSet.getString("factor_comercializacion"),"")
											,validar(resultSet.getString("factor_otros"),"")
											,validar(resultSet.getString("factor_resultante"),""));
		}
	}

	@Override
	public EnfoqueCostoFisicoVo buscar(EnfoqueCostoFisicoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnfoqueCostoFisicoVo> buscarLista(EnfoqueCostoFisicoVo registro) {
		
		try
		{
			String query = "SELECT * FROM enfoque_costos_fisico WITH(NOLOCK)";
			if( registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals(""))
			{
				query +=" WHERE id_avaluo IN ("+registro.getAvaluos()+")";
			}
			LOGGER.info("Sentencia a ejecutar: "+query);
			return this.jdbcAvaluos.query(query,new EnfoqueFisicoExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<EnfoqueCostoFisicoVo>();
		}
	}

	@Override
	public String generarCriterios(EnfoqueCostoFisicoVo registro,
			List<Object> parametros) {
		return null;
	}

	@Override
	public boolean guardar(EnfoqueCostoFisicoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<EnfoqueCostoFisicoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<EnfoqueCostoFisicoVo> buscarUnicos(EnfoqueCostoFisicoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
