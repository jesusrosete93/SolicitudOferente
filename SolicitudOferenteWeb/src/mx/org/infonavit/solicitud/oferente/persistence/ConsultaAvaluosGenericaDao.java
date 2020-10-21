/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * @author Atlas
 *
 */
@Repository("ConsultaAvaluosGenericaDao")
public class ConsultaAvaluosGenericaDao extends AbstractGenericoDao<List<String>> {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaAvaluosGenericaDao.class);
	
	public static String FIND;
	
	private class ConsultaAvaluosGenericaMapper implements RowMapper<List<String>>
	{
		@Override
		public List<String> mapRow(ResultSet resultSet, int fetch)
				throws SQLException {
			resultSet.setFetchSize(30000);
			List<String> registros = new ArrayList<String>();
			int totalColumnas =  resultSet.getMetaData().getColumnCount();

			for(int i=1; i<=totalColumnas;i++)
			{
				registros.add(validar(resultSet.getString(i),""));
			}
			
			return registros;
		}
		
	}

	@Override
	public List<String> buscar(List<String> registro) {
		// TODO Auto-generated method stub
		return this.jdbcAvaluos.queryForObject(FIND,new ConsultaAvaluosGenericaMapper() );
	}




	@Override
	public List<List<String>> buscarLista(List<String> registro) {
		LOGGER.debug("[CAGD] - Sentencia["+FIND+"]");
		return this.jdbcAvaluos.query(FIND,new ConsultaAvaluosGenericaMapper() );
	}




	
	@Override
	public String generarCriterios(List<String> registro,
			List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}
