package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository("ComparativoDao")
public class ComparativoDao extends AbstractDao<AvaluoVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(ComparativoDao.class);
	
	public static String FIND;
	
	private class ComparativoMapperExractor implements ResultSetExtractor<List<AvaluoVo>>
	{
		@Override
		public List<AvaluoVo> extractData(ResultSet resultSet) throws SQLException,
				DataAccessException {
			resultSet.setFetchSize(10000);
			List<AvaluoVo> regreso = new ArrayList<AvaluoVo>();
			while(resultSet.next())
			{
				regreso.add(new AvaluoVo(resultSet.getString("id_avaluo"),null,"","","",""));
//				regreso.add(new AvaluoVo(validar(resultSet.getString("id_avaluo"),"")
//						   ,resultSet.getInt("id_uv")
//						   ,validar(resultSet.getString("fecha_solicitud"),"")
//						   ,validar(resultSet.getString("fecha_descarga"),"")
//						   ,validar(resultSet.getString("fecha_envio"),"")
//						   ,validar(resultSet.getString("fecha_cierre"),"")
//						   ,validar(resultSet.getString("fecha_asociacion_factura"),"")
//						   ,resultSet.getInt("id_estatus")
//						   ,resultSet.getInt("id_vivienda")
//						   ,validar(resultSet.getString("id_paquete"),"")
//						   ,validar(resultSet.getString("nss"),"")
//						   ,validar(resultSet.getString("rfc"),"")
//						   ,resultSet.getBoolean("isai")
//						   ,resultSet.getInt("id_proposito_avaluo")
//						   ,resultSet.getInt("id_proposito_recuperacion")
//						   ,validar(resultSet.getString("proposito_otro"),"")
//						   ,validar(resultSet.getString("fecha_compromiso_termino"),"")
//						   ,validar(resultSet.getString("fecha_caducidad"),"")
//						   ,resultSet.getInt("id_tipo_mercado")
//						   ,validar(resultSet.getString("id_convivencia"),"")
//						   ,validar(resultSet.getString("identificacion"),"")
//						   ,resultSet.getInt("tipo_linea")
//						   ,validar(resultSet.getString("numero_credito"),"")
//						   ,validar(resultSet.getString("fecha_tramite_credito"),"")
//						   ,resultSet.getInt("tipo_tramite_credito")
//						   ,resultSet.getInt("tipo_avaluo")
//						   ,validar(resultSet.getString("monto_avaluo"),"")
//						   ,validar(resultSet.getString("marca_carga_herramienta_caduco"),"")
//						   ,""));
//						   ,validar(resultSet.getString("marca_requisito_pago"),"")));
			}
		  return regreso;
		}
		
	}


	@Override
	public AvaluoVo buscar(AvaluoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaluoVo> buscarLista(AvaluoVo registro) {
		LOGGER.info("Sentencia a ejecutar: "+ComparativoDao.FIND);
		return this.jdbcAvaluos.query(FIND, new ComparativoMapperExractor());
	}

	@Override
	public String generarCriterios(AvaluoVo registro, List<Object> parametros) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
