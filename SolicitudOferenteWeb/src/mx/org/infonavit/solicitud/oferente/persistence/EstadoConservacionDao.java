package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.EstadoConservacionVo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("EstadoConservacionDao")
public class EstadoConservacionDao extends	AbstractDao<EstadoConservacionVo> {
	
	private class EstadoConservacionMapper implements RowMapper<EstadoConservacionVo>
	{
		@Override
		public EstadoConservacionVo mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			return new EstadoConservacionVo(resultSet.getInt("id_estado_conservacion")
										   ,validar(resultSet.getString("descripcion"),""));
		}
		
	}

	@Override
	public EstadoConservacionVo buscar(EstadoConservacionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoConservacionVo> buscarLista(EstadoConservacionVo registro) {
		return this.jdbcAvaluos.query("SELECT * FROM cat_estado_conservacion WITH(NOLOCK)",new EstadoConservacionMapper());
	}

	@Override
	public String generarCriterios(EstadoConservacionVo registro,List<Object> parametros) {
		return null;
	}

	@Override
	public boolean guardar(EstadoConservacionVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<EstadoConservacionVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<EstadoConservacionVo> buscarUnicos(EstadoConservacionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
