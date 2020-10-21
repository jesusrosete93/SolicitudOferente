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

import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

/**
 * @author 
 *
 */
@Repository("CatalogoCamposDao")
public class CatalogoCamposDao extends AbstractDao<CampoBdVo> {
	
	public static boolean TODOS;
	
	private static String FIND = " SELECT ct.id_tabla,ct.id_orden AS orden_tabla,ct.nombre AS nombre_tabla," +
								 " ct.alias,cct.nombre as nombre_columna,cct.etiqueta AS etiqueta_columna,cct.id_orden AS orden_columna" +
								 " FROM   TC_Campos_Tablas AS cct WITH(NOLOCK) INNER JOIN TC_Tablas AS ct ON ct.id_tabla= cct.id_tabla"+
								 " WHERE  cct.id_tabla=? ORDER BY ct.id_orden,cct.id_orden";
	private static String FIND_ALL = "SELECT ct.id_tabla,ct.id_orden AS orden_tabla,ct.nombre AS nombre_tabla," +
									 " ct.alias,cct.nombre as nombre_columna,cct.etiqueta AS etiqueta_columna,cct.id_orden AS orden_columna " +
									 " FROM TC_Campos_Tablas AS cct WITH(NOLOCK) INNER JOIN TC_Tablas AS ct ON ct.id_tabla= cct.id_tabla"+
									 " ORDER BY ct.id_orden,cct.id_orden";
	
	
	private class CatalogoCampoMapper implements RowMapper<CampoBdVo>
	{

		@Override
		public CampoBdVo mapRow(ResultSet resultSet, int fetch) throws SQLException {
			// TODO Auto-generated method stub
			return new CampoBdVo( resultSet.getInt("id_tabla"),
								  resultSet.getInt("orden_tabla"),
								  validar(resultSet.getString("nombre_tabla"),""),
								  validar(resultSet.getString("alias"),""),
								  validar(resultSet.getString("nombre_columna"),""),
								  validar(resultSet.getString("etiqueta_columna"),""),
								  resultSet.getInt("orden_columna"));
		}
		
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscar(java.lang.Object)
	 */
	@Override
	public CampoBdVo buscar(CampoBdVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscarLista(java.lang.Object)
	 */
	@Override
	public List<CampoBdVo> buscarLista(CampoBdVo registro) {
		try
		{
			if( CatalogoCamposDao.TODOS  )
			{
				return this.jdbcAvaluos.query(FIND_ALL,new CatalogoCampoMapper());
			}else
			{
				return this.jdbcAvaluos.query(FIND,new CatalogoCampoMapper(),registro.getIdTabla());
			}
			
		}catch (EmptyResultDataAccessException empty) {
			return new ArrayList<CampoBdVo>();
		}
	}

	@Override
	public String generarCriterios(CampoBdVo registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(CampoBdVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<CampoBdVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<CampoBdVo> buscarUnicos(CampoBdVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
