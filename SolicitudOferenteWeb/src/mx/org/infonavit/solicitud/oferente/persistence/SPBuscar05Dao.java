package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.vo.SpBuscar05ResultadosVo;


@Repository("SPBuscar05Dao")
public class SPBuscar05Dao extends AbstractDao<SpBuscar05ResultadosVo>{
	
	private static Logger LOGGER = LogManager.getLogger(SPBuscar05Dao.class);

	@Override
	public SpBuscar05ResultadosVo buscar(final SpBuscar05ResultadosVo registro) {
		
		LOGGER.info("[SPB05] - Ejecutando store procedure: SP_buscar05");
		LOGGER.info("[SPB05] - Parametros: FI["+registro.getFechaInicio()+"] FF["+registro.getFechaFin()+"] P["+registro.getParametro()+"]");
		
		List<SqlParameter> parametros = Arrays.asList(new SqlParameter(Types.VARCHAR)
													  ,new SqlParameter(Types.VARCHAR)
													  ,new SqlParameter(Types.VARCHAR)
													 );
		
		Map<String,Object> t = this.jdbcAvaluos.call(new CallableStatementCreator(){

			@Override
			public CallableStatement createCallableStatement(Connection con)
					throws SQLException {
				CallableStatement callableStatement = con.prepareCall("{call SP_busca05(?,?,?)}");
	            callableStatement.setString(1, registro.getFechaInicio());
	            callableStatement.setString(2, registro.getFechaFin());
	            callableStatement.setString(3, registro.getParametro());
	            return callableStatement;
			}
			
		},parametros);
		LOGGER.info("[SPB05] - Resultado del setore: " + t);
		
		return null;
	}

	@Override
	public List<SpBuscar05ResultadosVo> buscarLista(
			SpBuscar05ResultadosVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarCriterios(SpBuscar05ResultadosVo registro,
			List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(SpBuscar05ResultadosVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<SpBuscar05ResultadosVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<SpBuscar05ResultadosVo> buscarUnicos(
			SpBuscar05ResultadosVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
