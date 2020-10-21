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

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.TablaBdVo;

/**
 * @author Atlas
 *
 */
@Repository("CatalogoTablasDao")
public class CatalogoTablasDao extends AbstractDao<TablaBdVo> {
	
	private static String FIND = "SELECT * FROM TC_Tablas WITH(NOLOCK) ORDER BY id_orden";
	
	private class CatalogoTablasMapper implements RowMapper<TablaBdVo>
	{

		@Override
		public TablaBdVo mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new TablaBdVo(resultSet.getInt("id_tabla"),
								 validar(resultSet.getString("nombre")),
								 validar(resultSet.getString("etiqueta")),
								 validar(resultSet.getString("alias")),
								 validar(resultSet.getString("descripcion")));
		}
		
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscar(java.lang.Object)
	 */
	@Override
	public TablaBdVo buscar(TablaBdVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscarLista(java.lang.Object)
	 */
	@Override
	public List<TablaBdVo> buscarLista(TablaBdVo registro) {
		// TODO Auto-generated method stub
		try
		{
			return this.jdbcAvaluos.query(FIND,new CatalogoTablasMapper());
		}catch (EmptyResultDataAccessException empty) {
			return new ArrayList<TablaBdVo>();
		}
		
	}

	@Override
	public String generarCriterios(TablaBdVo registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(TablaBdVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<TablaBdVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<TablaBdVo> buscarUnicos(TablaBdVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
