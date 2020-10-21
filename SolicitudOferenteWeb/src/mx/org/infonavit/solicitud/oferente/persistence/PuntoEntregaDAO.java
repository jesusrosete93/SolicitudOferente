package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.PuntoEntregaVO;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;



@Repository("PuntoEntregaDAO")
public class PuntoEntregaDAO extends AbstractDao<PuntoEntregaVO> {
	
	
	
	private class PuntoEntregaMapper implements ParameterizedRowMapper<PuntoEntregaVO>
	{
		@Override
		public PuntoEntregaVO mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			
			return new PuntoEntregaVO(resultSet.getInt("id_registro"),resultSet.getInt("id_aplicacion"),
									  resultSet.getInt("id_operacion"),resultSet.getInt("id_servicio"),
									  validar(resultSet.getString("url"),""));
		}
		
	}

	
	@Override
	public PuntoEntregaVO buscar(PuntoEntregaVO registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PuntoEntregaVO> buscarLista(PuntoEntregaVO registro) {
		StringBuffer criterios = new StringBuffer();
		
		String query = "SELECT * FROM TC_Puntos_Entrega_WS WITH(NOLOCK) WHERE CRITERIOS";
		
		if( registro.getIdRegistro() > 0 )
		{
			if( criterios.length()>0)
			{
				criterios.append(" AND id_registro="+registro.getIdRegistro());
			}else
			{
				criterios.append(" id_registro="+registro.getIdRegistro());
			}
		}
		if( registro.getIdAplicacion() > 0 )
		{
			if( criterios.length()>0)
			{
				criterios.append(" AND id_aplicacion="+registro.getIdAplicacion());
			}else
			{
				criterios.append(" id_aplicacion="+registro.getIdAplicacion());
			}
		}
		if( registro.getIdOperacion() > 0 )
		{
			if( criterios.length()>0)
			{
				criterios.append(" AND id_operacion="+registro.getIdOperacion());
			}else
			{
				criterios.append(" id_operacion="+registro.getIdOperacion());
			}
		}
		if( registro.getIdServicio() > 0 )
		{
			if( criterios.length()>0)
			{
				criterios.append(" AND id_servicio="+registro.getIdServicio());
			}else
			{
				criterios.append(" id_servicio="+registro.getIdServicio());
			}
		}
		if( registro.getPuntoEntrega()!=null && !registro.getPuntoEntrega().trim().equals(""))
		{
			if( criterios.length()>0)
			{
				criterios.append(" AND url="+registro.getPuntoEntrega());
			}else
			{
				criterios.append(" url="+registro.getPuntoEntrega());
			}
		}
		
		try
		{
			
			return this.jdbcAvaluos.query(reemplazar(query,"CRITERIOS", criterios.toString()),new PuntoEntregaMapper());
		}catch(EmptyResultDataAccessException emptyResultDataAccessException)
		{
			return new ArrayList<PuntoEntregaVO>();
		}
	}

	@Override
	public String generarCriterios(PuntoEntregaVO registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(PuntoEntregaVO registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<PuntoEntregaVO> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<PuntoEntregaVO> buscarUnicos(PuntoEntregaVO registro) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
