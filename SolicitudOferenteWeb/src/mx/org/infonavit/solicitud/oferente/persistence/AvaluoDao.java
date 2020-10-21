package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaUPCUtils;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

@Repository("AvaluoDao")
public class AvaluoDao extends AbstractDao<AvaluoVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluoDao.class);
	private static final String SELECT = "SELECT * FROM avaluo WITH(NOLOCK)";
	
	private class AvaluoExtractor implements ResultSetExtractor<List<AvaluoVo>>
	{
		@Override
		public List<AvaluoVo> extractData(ResultSet resultSet) throws SQLException,DataAccessException {
			List<AvaluoVo> regreso = new ArrayList<AvaluoVo>();
			while(resultSet.next())
			{
				regreso.add( new AvaluoVo(	validar(resultSet.getString("id_avaluo"),"")
										   ,resultSet.getInt("id_uv")
										   ,validar(resultSet.getString("fecha_solicitud"),"")
										   ,validar(resultSet.getString("fecha_descarga"),"")
										   ,validar(resultSet.getString("fecha_envio"),"")
										   ,validar(resultSet.getString("fecha_cierre"),"")
										   ,validar(resultSet.getString("fecha_asociacion_factura"),"")
										   ,resultSet.getInt("id_estatus")
										   ,resultSet.getInt("id_vivienda")
										   ,validar(resultSet.getString("id_paquete"),"")
										   ,validar(resultSet.getString("nss"),"")
										   ,validar(resultSet.getString("rfc"),"")
										   ,resultSet.getBoolean("isai")
										   ,resultSet.getInt("id_proposito_avaluo")
										   ,resultSet.getInt("id_proposito_recuperacion")
										   ,validar(resultSet.getString("proposito_otro"),"")
										   ,validar(resultSet.getString("fecha_compromiso_termino"),"")
										   ,validar(resultSet.getString("fecha_caducidad"),"")
										   ,resultSet.getInt("id_tipo_mercado")
										   ,validar(resultSet.getString("id_convivencia"),"")
										   ,validar(resultSet.getString("identificacion"),"")
										   ,resultSet.getInt("tipo_linea")
										   ,validar(resultSet.getString("numero_credito"),"")
										   ,validar(resultSet.getString("fecha_tramite_credito"),"")
										   ,resultSet.getInt("tipo_tramite_credito")
										   ,resultSet.getInt("tipo_avaluo")
										   ,validar(resultSet.getString("monto_avaluo"),"")
										   ,validar(resultSet.getString("marca_carga_herramienta_caduco"),"")
										   ,""
//										   ,validar(resultSet.getString("marca_requisito_pago"),"")
										  )
							);
			}
		 return regreso;
		}
		
	}
	
	private class AvaluoMapper implements RowMapper<AvaluoVo>
	{
		@Override
		public AvaluoVo mapRow(ResultSet resultSet, int fetch) throws SQLException {
			return new AvaluoVo(validar(resultSet.getString("id_avaluo"),"")
							   ,resultSet.getInt("id_uv")
							   ,validar(resultSet.getString("fecha_solicitud"),"")
							   ,validar(resultSet.getString("fecha_descarga"),"")
							   ,validar(resultSet.getString("fecha_envio"),"")
							   ,validar(resultSet.getString("fecha_cierre"),"")
							   ,validar(resultSet.getString("fecha_asociacion_factura"),"")
							   ,resultSet.getInt("id_estatus")
							   ,resultSet.getInt("id_vivienda")
							   ,validar(resultSet.getString("id_paquete"),"")
							   ,validar(resultSet.getString("nss"),"")
							   ,validar(resultSet.getString("rfc"),"")
							   ,resultSet.getBoolean("isai")
							   ,resultSet.getInt("id_proposito_avaluo")
							   ,resultSet.getInt("id_proposito_recuperacion")
							   ,validar(resultSet.getString("proposito_otro"),"")
							   ,validar(resultSet.getString("fecha_compromiso_termino"),"")
							   ,validar(resultSet.getString("fecha_caducidad"),"")
							   ,resultSet.getInt("id_tipo_mercado")
							   ,validar(resultSet.getString("id_convivencia"),"")
							   ,validar(resultSet.getString("identificacion"),"")
							   ,resultSet.getInt("tipo_linea")
							   ,validar(resultSet.getString("numero_credito"),"")
							   ,validar(resultSet.getString("fecha_tramite_credito"),"")
							   ,resultSet.getInt("tipo_tramite_credito")
							   ,resultSet.getInt("tipo_avaluo")
							   ,validar(resultSet.getString("monto_avaluo"),"")
							   ,validar(resultSet.getString("marca_carga_herramienta_caduco"),"")
							   ,"");
//			validar(resultSet.getString("marca_requisito_pago"),"")
		}
	}

	@Override
	public AvaluoVo buscar(AvaluoVo registro) {
		String regreso = "";
		StringBuilder sentencia = new StringBuilder();
		regreso  = generarCriterios(registro,null);
		if( regreso!=null && !regreso.equals("") )
		{
			sentencia.append(SELECT).append(WHERE).append(regreso);
		}
//		LOGGER.info("Senetencia a ejecutar: "+sentencia.toString());
		return this.jdbcAvaluos.queryForObject(sentencia.toString(),new AvaluoMapper());
	}

	@Override
	public List<AvaluoVo> buscarLista(AvaluoVo registro) {
		String regreso = "";
		StringBuilder sentencia = new StringBuilder();
		regreso  = generarCriterios(registro,null);
		if( regreso!=null && !regreso.equals("") )
		{
			sentencia.append(SELECT).append(WHERE).append(regreso);
		}
		LOGGER.info("Senetencia a ejecutar: "+sentencia.toString());
		return this.jdbcAvaluos.query(sentencia.toString(),new AvaluoExtractor());
	}

	@Override
	public String generarCriterios(AvaluoVo registro, List<Object> parametros) {
		StringBuilder regreso = new StringBuilder("");
		if( registro.getIdPaquete()!=null && !registro.getIdPaquete().trim().equals(""))
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_paquete").append(IGUAL).append(COMILLA).append(registro.getIdPaquete()).append(COMILLA);
			}else
			{
				regreso.append("id_paquete").append(IGUAL).append(COMILLA).append(registro.getIdPaquete()).append(COMILLA);
			}
		}
		if( registro.getIdAvaluo()!=null && !registro.getIdAvaluo().trim().equals(""))
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
			}else
			{
				regreso.append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
			}
		}
		if( registro.getUnidadesValuacion()!=null && !registro.getUnidadesValuacion().isEmpty())
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_uv").append(IN).append(PARANETESIS_ABRE).append(BuilderSQLConsultaUPCUtils.getElementosIN(registro.getUnidadesValuacion())).append(PARANETESIS_CIERRA);
			}else
			{
				regreso.append("id_uv").append(IN).append(PARANETESIS_ABRE).append(BuilderSQLConsultaUPCUtils.getElementosIN(registro.getUnidadesValuacion())).append(PARANETESIS_CIERRA);
			}
		}
		if( registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals(""))
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}else
			{
				regreso.append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}
		}
		if( registro.getFechaCierreInicio()!=null && !registro.getFechaCierreInicio().trim().equals("") &&
		    registro.getFechaCierreFin()!=null && !registro.getFechaCierreFin().trim().equals("")
		  )
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("fecha_cierre").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFechaCierreInicio()).append(" 00:00:00").append(COMILLA)
				      .append(AND).append("fecha_cierre").append(MENOR_IGUAL).append(COMILLA).append(registro.getFechaCierreFin()).append(" 23:59:59").append(COMILLA);
			}else
			{
				regreso.append("fecha_cierre").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFechaCierreInicio()).append(" 00:00:00").append(COMILLA)
			           .append(AND).append("fecha_cierre").append(MENOR_IGUAL).append(COMILLA).append(registro.getFechaCierreFin()).append(" 23:59:59").append(COMILLA);
			}
		}
		if( regreso ==null || regreso.length()==0)
		{
			throw new IllegalArgumentException("No hay criterios para realizar la busqueda");
		}
	 return regreso.toString();
	}

	@Override
	public boolean guardar(AvaluoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<AvaluoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<AvaluoVo> buscarUnicos(AvaluoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
