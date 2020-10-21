/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.CatalogoVO;

/**
 * @author Atlas
 *
 */
@Repository("CatalogoClaseInmuebleDao")
public class CatalogoClaseInmuebleDao extends AbstractDao<CatalogoVO> {
	
	
	private class CatalogoInmuebleMapper implements RowMapper<CatalogoVO>
	{

		@Override
		public CatalogoVO mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new CatalogoVO(resultSet.getString("id_clase_gral_inmueble"),resultSet.getString("descripcion"));
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
		// TODO Auto-generated method stub
		return this.jdbcAvaluos.query("SELECT * FROM cat_clase_gral_inmueble WITH(NOLOCK)", new CatalogoInmuebleMapper());
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#generarCriterios(java.lang.Object, java.util.List)
	 */
	@Override
	public String generarCriterios(CatalogoVO registro, List<Object> parametros) {
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
