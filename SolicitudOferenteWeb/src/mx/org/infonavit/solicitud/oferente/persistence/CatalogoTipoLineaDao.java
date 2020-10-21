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

import mx.org.infonavit.solicitud.oferente.persistence.vo.CatalogoVO;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author 
 *
 */
@Repository("CatalogoTipoLineaDao")
public class CatalogoTipoLineaDao extends AbstractDao<CatalogoVO> {
	
	
	
	private static String FIND_ALL = " SELECT * FROM TC_tipo_linea WITH(NOLOCK) ";
	
	
	private class CatalogoCampoMapper implements RowMapper<CatalogoVO>
	{

		@Override
		public CatalogoVO mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new CatalogoVO( validar(resultSet.getString("id_tipo_linea"),""),validar(resultSet.getString("descripcion"),"") );
		}
		
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscar(java.lang.Object)
	 */
	@Override
	public CatalogoVO buscar(CatalogoVO registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscarLista(java.lang.Object)
	 */
	@Override
	public List<CatalogoVO> buscarLista(CatalogoVO registro) {
		try
		{
			return this.jdbcAvaluos.query(FIND_ALL,new CatalogoCampoMapper());
			
		}catch (EmptyResultDataAccessException empty) {
			return new ArrayList<CatalogoVO>();
		}
	}

	@Override
	public String generarCriterios(CatalogoVO registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(CatalogoVO registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<CatalogoVO> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<CatalogoVO> buscarUnicos(CatalogoVO registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
