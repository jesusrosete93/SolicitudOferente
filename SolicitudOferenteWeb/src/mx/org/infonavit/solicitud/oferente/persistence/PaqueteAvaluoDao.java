/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteAvaluoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Atlas
 *
 */
@Repository("PaqueteAvaluoDao")
public class PaqueteAvaluoDao extends AbstractDao<PaqueteAvaluoVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(PaqueteAvaluoDao.class);
	/**
	 * 
	 * @author Atlas
	 *
	 */
	private class PaqueteMapper implements RowMapper<PaqueteAvaluoVo>
	{
		@Override
		public PaqueteAvaluoVo mapRow(ResultSet rs, int arg1) throws SQLException {
			PaqueteAvaluoVo registro = new PaqueteAvaluoVo( );
			registro.setIdPaquete					( validar( rs.getString( "id_paquete" ),"" ) );
			registro.setTipoPaquete				( validar( rs.getString( "tipo_paquete" ),"" ) );
			
		  return registro;	
		}
	}
	@Override
	public PaqueteAvaluoVo buscar(PaqueteAvaluoVo registro) {
		LOGGER.debug("[CVD] - Buscando información en la tabla: cedulapresentacion, generando criterios de busqueda...");
		String criterios = generarCriterios(registro,null);
		String query     = "";
		if( criterios ==null || criterios.length()==0)
			throw new IllegalArgumentException("No hay cirterios para realizar la busqueda");
		try
		{
			query = reemplazar("SELECT * FROM paquete WITH(NOLOCK) WHERE CRITERIOS","CRITERIOS",criterios);
			LOGGER.debug("[CVD] - Query ha ejecutar: "+query);
			return this.jdbcAvaluos.queryForObject(query,new PaqueteMapper());
		}catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	@Override
	public List<PaqueteAvaluoVo> buscarLista(PaqueteAvaluoVo registro) {
		
		return null;
	}
	@Override
	public Set<PaqueteAvaluoVo> buscarUnicos(PaqueteAvaluoVo registro) {
		
		return null;
	}
	@Override
	public String generarCriterios(PaqueteAvaluoVo criterios, List<Object> parametros) {

		StringBuffer regreso = new StringBuffer();
		
		if( criterios.getIdPaquete()!=null && !criterios.getIdPaquete().trim().equals(""))
		{
			if( regreso.length()>0)
			{
				regreso.append(" AND id_paquete='"+criterios.getIdPaquete()+"'");
			}else
			{
				regreso.append(" id_paquete='"+criterios.getIdPaquete()+"'");
				
			}
			
		}
	  return regreso.toString();
	}
	@Override
	public boolean guardar(PaqueteAvaluoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean guardar(List<PaqueteAvaluoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

		

	

	


	

}
