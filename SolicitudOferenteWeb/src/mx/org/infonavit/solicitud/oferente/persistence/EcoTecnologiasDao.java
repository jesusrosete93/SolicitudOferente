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
 * <p>Clase que encapsula la informci�n que se realiza hacia la tabla: cat_oferente 
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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return false;
	}

	@Override
	public boolean guardar(List<EcoTecnologiasVo> registros) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return false;
	}

	@Override
	public List<EcoTecnologiasVo> buscarLista(EcoTecnologiasVo registro) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public Set<EcoTecnologiasVo> buscarUnicos(EcoTecnologiasVo registro) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}

	@Override
	public String generarCriterios(EcoTecnologiasVo registro,
			List<Object> parametros) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
	}



}
