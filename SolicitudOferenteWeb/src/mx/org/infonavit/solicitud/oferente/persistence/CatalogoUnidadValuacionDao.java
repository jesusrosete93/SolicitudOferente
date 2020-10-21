/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.UnidadValuacionVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



/**
 * @author Atlas
 *
 */
@Repository("CatalogoUnidadValuacionDao")
public class CatalogoUnidadValuacionDao extends	AbstractDao<UnidadValuacionVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(CatalogoUnidadValuacionDao.class);
	private static final String FIND = "SELECT * FROM cat_uv WITH(NOLOCK)";
	
	
	private class UnidadValuacionMapper implements RowMapper<UnidadValuacionVo>
	{

		@Override
		public UnidadValuacionVo mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			// TODO Auto-generated method stub
			return new UnidadValuacionVo(resultSet.getInt("id_uv"),
										 validar(resultSet.getString("descripcion"),"")
										 ,resultSet.getInt("id_estatus")
										);
		}
		
	}


	@Override
	public UnidadValuacionVo buscar(UnidadValuacionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UnidadValuacionVo> buscarLista(UnidadValuacionVo registro) {
		try
		{
			LOGGER.debug("Query: "+FIND);
			return this.jdbcAvaluos.query(FIND,new UnidadValuacionMapper());
		}catch (EmptyResultDataAccessException empty) {
			return new ArrayList<UnidadValuacionVo>();
		}
	}


	@Override
	public String generarCriterios(UnidadValuacionVo registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean guardar(UnidadValuacionVo registro) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean guardar(List<UnidadValuacionVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Set<UnidadValuacionVo> buscarUnicos(UnidadValuacionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
