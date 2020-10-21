package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MAYOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MENOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.WHERE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.BitacoraEnvioAvaluoMapVo;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("BitacoraEnvioAvaluoMapDao")
public class BitacoraEnvioAvaluoMapDao extends 	AbstractDao<BitacoraEnvioAvaluoMapVo> {
	
	private class BitacoraEnvioAvaluoMapExtractor implements ResultSetExtractor<List<BitacoraEnvioAvaluoMapVo>>
	{
		@Override
		public List<BitacoraEnvioAvaluoMapVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			List<BitacoraEnvioAvaluoMapVo> regreso = new ArrayList<BitacoraEnvioAvaluoMapVo>();
			while(resultSet.next())
			{
				regreso.add(new BitacoraEnvioAvaluoMapVo(resultSet.getInt("id_registro")
										   ,resultSet.getTimestamp("fecha_registro")
										   ,validar(resultSet.getString("id_avaluo"),"")
										   ,resultSet.getInt("id_operacion")
										   ,resultSet.getBoolean("resultado_operacion")
										   ,resultSet.getString("detalle_resultado")
										   ,resultSet.getInt("id_peticion"))
							);
			}
			return regreso;
		}
	}
	private class BitacoraEnvioAvaluoMapMapper implements RowMapper<BitacoraEnvioAvaluoMapVo>
	{
		@Override
		public BitacoraEnvioAvaluoMapVo mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			return new BitacoraEnvioAvaluoMapVo(resultSet.getInt("id_registro")
											   ,resultSet.getTimestamp("fecha_registro")
											   ,validar(resultSet.getString("id_avaluo"),"")
											   ,resultSet.getInt("id_operacion")
											   ,resultSet.getBoolean("resultado_operacion")
											   ,resultSet.getString("detalle_resultado")
											   ,resultSet.getInt("id_peticion")
											   );
		}
	}

	@Override
	public BitacoraEnvioAvaluoMapVo buscar(BitacoraEnvioAvaluoMapVo registro) {
		StringBuffer query = new StringBuffer("SELECT * FROM TBL_Bitacora_Avaluo_Map WITH(NOLOCK)");
		String criterios = "";
		try
		{
			criterios = generarCriterios(registro, null);
			if( criterios!=null && !criterios.trim().equals(""))
			{
				query.append(WHERE).append(criterios);
			}
			return this.jdbcAvaluos.queryForObject(query.toString(),new BitacoraEnvioAvaluoMapMapper());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<BitacoraEnvioAvaluoMapVo> buscarLista(BitacoraEnvioAvaluoMapVo registro) {
		StringBuffer query = new StringBuffer("SELECT * FROM TBL_Bitacora_Avaluo_Map WITH(NOLOCK)");
		String criterios = "";
		try
		{
			criterios = generarCriterios(registro, null);
			if( criterios!=null && !criterios.trim().equals(""))
			{
				query.append(WHERE).append(criterios);
			}
			return this.jdbcAvaluos.query(query.toString(),new BitacoraEnvioAvaluoMapExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<BitacoraEnvioAvaluoMapVo>();
		}
	}

	@Override
	public String generarCriterios(BitacoraEnvioAvaluoMapVo registro,List<Object> parametros) {
		StringBuffer criterios = new StringBuffer();
		if( registro.getIdRegistro()>=0)
		{
			if( criterios.length()>0)
			{
				criterios.append("id_registro").append(IGUAL).append(registro.getIdRegistro());
			}else
			{
				criterios.append(AND).append("id_registro").append(IGUAL).append(registro.getIdRegistro());
			}
		}
		if( registro.getFechaRegistroInicio()!=null && !registro.getFechaRegistroInicio().trim().equals("")
			&& registro.getFechaRegistroFin()!=null && !registro.getFechaRegistroFin().trim().equals(""))
		{
			if( criterios.length()>0)
			{
				criterios.append("fecha_registro").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFechaRegistroInicio()).append(COMILLA)
						 .append(AND)
						 .append("fecha_registro").append(MENOR_IGUAL).append(COMILLA).append(registro.getFechaRegistroFin()).append(COMILLA);
			}else
			{
				criterios.append(AND)
						 .append("fecha_registro").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFechaRegistroInicio()).append(COMILLA)
				 		 .append(AND)
				 		 .append("fecha_registro").append(MENOR_IGUAL).append(COMILLA).append(registro.getFechaRegistroFin()).append(COMILLA);
			}
		}
		if( registro.getIdAvaluo()!=null && !registro.getIdAvaluo().trim().equals("") )
			{
				if( criterios.length()>0)
				{
					criterios.append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
							 
				}else
				{
					criterios.append(AND)
							 .append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
				}
			}
		if( registro.getResultado()>0 )
		{
			if( criterios.length()>0)
			{
				criterios.append("id_operacion").append(IGUAL).append(registro.getResultado()==1?true:false);
						 
			}else
			{
				criterios.append(AND)
						 .append("id_operacion").append(IGUAL).append(registro.getResultado()==1?true:false);
			}
		}
		return criterios.toString();
	}

	@Override
	public boolean guardar(BitacoraEnvioAvaluoMapVo registro) {
		int registrados = 0;
		registrados=this.jdbcAvaluos.update("INSERT INTO TBL_Bitacora_Avaluo_Map VALUES(GETDATE(),?,?,?,?,?)",registro.getIdAvaluo(),registro.getIdOperacion(),registro.isResultadoOperacion(),registro.getDetalleResultado(),registro.getIdPeticion());
		return registrados == 1 ? true : false;
	}

	@Override
	public boolean guardar(List<BitacoraEnvioAvaluoMapVo> registros) {
		return false;
	}

	@Override
	public Set<BitacoraEnvioAvaluoMapVo> buscarUnicos(
			BitacoraEnvioAvaluoMapVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
