package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.MetodoConclusionAvaluoVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("MetodoConclusionAvaluoDao")
public class MetodoConclusionAvaluoDao extends	AbstractDao<MetodoConclusionAvaluoVo> {
	
	private class MetodoConclusionAvaluoMapper implements RowMapper<MetodoConclusionAvaluoVo>
	{
		@Override
		public MetodoConclusionAvaluoVo mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			return new MetodoConclusionAvaluoVo(resultSet.getInt("id_metodo_conclusion")
										   ,validar(resultSet.getString("descripcion"),""));
		}
		
	}

	@Override
	public MetodoConclusionAvaluoVo buscar(MetodoConclusionAvaluoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MetodoConclusionAvaluoVo> buscarLista(MetodoConclusionAvaluoVo registro) {
		return this.jdbcAvaluos.query("SELECT * FROM cat_metodo_conclusion_avaluo WITH(NOLOCK)",new MetodoConclusionAvaluoMapper());
	}

	@Override
	public String generarCriterios(MetodoConclusionAvaluoVo registro,List<Object> parametros) {
		return null;
	}

	@Override
	public boolean guardar(MetodoConclusionAvaluoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<MetodoConclusionAvaluoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<MetodoConclusionAvaluoVo> buscarUnicos(
			MetodoConclusionAvaluoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
