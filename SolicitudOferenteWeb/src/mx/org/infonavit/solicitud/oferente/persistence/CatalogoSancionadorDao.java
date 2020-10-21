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

import mx.org.infonavit.solicitud.oferente.persistence.vo.EstatusVo;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author 
 *
 */
@Repository("CatalogoSancionadorDao")
public class CatalogoSancionadorDao extends AbstractDao<EstatusVo> {
	
	
	
	private static String FIND = " SELECT * FROM cat_sancionador WITH(NOLOCK)";

	
	private class CatalogoEstatusMapper implements RowMapper<EstatusVo>
	{

		@Override
		public EstatusVo mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new EstatusVo( resultSet.getInt("id_sancionador"),
								  validar(resultSet.getString("descripcion"),"")
								  );
		}
		
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscar(java.lang.Object)
	 */
	@Override
	public EstatusVo buscar(EstatusVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscarLista(java.lang.Object)
	 */
	@Override
	public List<EstatusVo> buscarLista(EstatusVo registro) {
		try
		{
			return this.jdbcAvaluos.query(FIND,new CatalogoEstatusMapper());
		}catch (EmptyResultDataAccessException empty) {
			return new ArrayList<EstatusVo>();
		}
	}

	@Override
	public String generarCriterios(EstatusVo registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(EstatusVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<EstatusVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<EstatusVo> buscarUnicos(EstatusVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
