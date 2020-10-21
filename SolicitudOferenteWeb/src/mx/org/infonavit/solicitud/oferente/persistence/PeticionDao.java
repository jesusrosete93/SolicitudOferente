package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.PeticionVo;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;



@Repository("PeticionDao")
public class PeticionDao extends AbstractDao<PeticionVo> {
	
	



	@Override
	public PeticionVo buscar(PeticionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionVo> buscarLista(PeticionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generarCriterios(PeticionVo registro, List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(final PeticionVo registro) {
//		String SAVE = "INSERT INTO TBL_Bitacora_Peticiones VALUES(?,getdate(),?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		PreparedStatementCreator pscr = new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO TBL_Bitacora_Peticiones VALUES(getdate(),?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1,registro.getIdAplicacion());
				ps.setInt(2,registro.getIdOperacion());
				ps.setString(3,registro.getTiempoAtencion());
				ps.setBoolean(4,registro.isResultadoPeticion());
				ps.setString(5,registro.getXmlRequest());
				ps.setString(6,registro.getXmlResponse());
				return ps;
			}
			
		};
		
		int regreso = this.jdbcAvaluos.update(pscr,keyHolder); 
		
		registro.setIdPeticion(keyHolder.getKey().intValue());
		
		return regreso==1?true:false;

	}

	@Override
	public boolean guardar(List<PeticionVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<PeticionVo> buscarUnicos(PeticionVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	

}
