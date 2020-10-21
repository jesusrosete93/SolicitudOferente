package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
/**
 * <p>Clase que encapsula la informción que se realiza hacia la tabla: cat_oferente 
 * @author Adrian Casas
 */
@Repository("OferenteDao")
public class OferenteDao extends AbstractDao<OferenteVo> {
	
	private class OferenteMapper implements RowMapper<OferenteVo>
	{
		@Override
		public OferenteVo mapRow(ResultSet resultSet, int arg1) throws SQLException {
			return new OferenteVo(validar(resultSet.getString("nombre_razon_social"),"")
								 ,validar(resultSet.getString("rfc"),"")
								 ,validar(resultSet.getString("representante_legal"),"")
								 ,validar(resultSet.getString("curp"),""));
		}
	}

	@Override
	public OferenteVo buscar(OferenteVo registro) {
		try
		{
			return this.jdbcAvaluos.queryForObject("SELECT * FROM cat_oferente WITH(NOLOCK) WHERE rfc=?", new OferenteMapper(),registro.getRfc());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<OferenteVo> buscarLista(OferenteVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OferenteVo> buscarUnicos(OferenteVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarCriterios(OferenteVo registro, List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(OferenteVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<OferenteVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

}
