package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.RegistrosVo;

@Repository("RegistrosConsultaDao")
public class RegistrosConsultaDao extends AbstractDao<RegistrosVo> {
	
	private class RegistrosMapper implements RowMapper<RegistrosVo>
	{
		@Override
		public RegistrosVo mapRow(ResultSet resultSet, int arg1) throws SQLException {
			
			return new RegistrosVo(resultSet.getInt("registros"));
		}
		
	}

	@Override
	public RegistrosVo buscar(RegistrosVo registro) {
		return this.jdbcAvaluos.queryForObject(registro.getSentencia(),new RegistrosMapper());
	}

	@Override
	public List<RegistrosVo> buscarLista(RegistrosVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarCriterios(RegistrosVo registro, List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(RegistrosVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<RegistrosVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<RegistrosVo> buscarUnicos(RegistrosVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
