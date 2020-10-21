package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.OferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
/**
 * <p>Clase que encapsula la informción que se realiza hacia la tabla: cat_oferente 
 * @author Jesus Rosete
 */
@Repository("EcoTecnologiasDao")
public class EcoTecnologiasDao extends AbstractECODao<EcoTecnologiasVo> {
	
	private class OferenteMapper implements RowMapper<EcoTecnologiasVo>
	{
		@Override
		public EcoTecnologiasVo mapRow(ResultSet resultSet, int arg1) throws SQLException {
			return new EcoTecnologiasVo(validar(resultSet.getString("claveTecnologia"),"")
					                    ,validar(resultSet.getString("paquete"),""));
							     
		}
	}

	@Override
	public EcoTecnologiasVo buscar(EcoTecnologiasVo registro) {
		try
		{
			return this.jdbcVivienda.queryForObject("SELECT * FROM TBL_Ecotecnologias WITH(NOLOCK) WHERE ClaveTecnologia=?", new OferenteMapper(),registro.getClaveTecnologia());
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean guardar(EcoTecnologiasVo registro) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean guardar(List<EcoTecnologiasVo> registros) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public List<EcoTecnologiasVo> buscarLista(EcoTecnologiasVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Set<EcoTecnologiasVo> buscarUnicos(EcoTecnologiasVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String generarCriterios(EcoTecnologiasVo registro,
			List<Object> parametros) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



}
