package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.tree.RowMapper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudIDSolicitudOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.WHERE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;

@Repository("SolicitudOferenteCancelacionActualizarSolicitudDao")
public class SolicitudOferenteCancelacionActualizarSolicitudDao extends AbstractSolicitudUpdateOferenteDao<SolicitudOferenteIDVo> {

	private static final Logger LOGGER = LogManager
			.getLogger(SolicitudOferenteCancelacionActualizarSolicitudDao.class);
	private static final String PREFIJO_LOG = "[Consulta tbl_consecutivo adquier consecutivo] - ";

	private class SolicitudOferenteExtractor implements ResultSetExtractor<SolicitudOferenteIDVo> {
		@Override
		public SolicitudOferenteIDVo extractData(ResultSet resultSet)throws SQLException, DataAccessException {
//			SolicitudOferenteIDVo regreso = null;
//			regreso = new SolicitudOferenteIDVo();
			SolicitudOferenteIDVo registro = new SolicitudOferenteIDVo();
			
			registro.setConsecutivo(resultSet.getString("consecutivo"));

			
			return registro;
		}
	}
	
	@Override
	public boolean updateSolicitud(SolicitudOferenteIDVo registro) {
		int actualizados = 0;
		LOGGER.info(PREFIJO_LOG+ " Sentencia a ejecutar 1  " + actualizados);	
		actualizados = this.jdbcVivienda.update(
				"update TBL_Consecutivo_Solicitud set consecutivo = ?  where anio = ? "
						+ "and id_estado = ? and id_tipo_solicitud = ?  ",
						registro.getConsecutivo(), registro.getAnio(),registro.getId_estado(), registro.getId_tipo_solicitud());
		LOGGER.info(PREFIJO_LOG+ " Sentencia a ejecutar 2 " + actualizados);	
		return actualizados == 1 ? true : false;
	}
	
	@Override
	public boolean updateSolicitud(SolicitudIDSolicitudOferenteVo registro) {
		int actualizados = 0;
		LOGGER.info(PREFIJO_LOG+ " Sentencia a ejecutar 1  " + registro.toString());	
		actualizados = this.jdbcVivienda.update(
				"update TBL_Consecutivo_Solicitud set  where anio = ? "
						+ "and id_estado = ? and id_tipo_solicitud = ? and consecutivo = ? ",
				registro.getAnio(),registro.getId_estado(), registro.getId_tipo_solicitud(),
				registro.getConsecutivo());
		LOGGER.info(PREFIJO_LOG+ " Sentencia a ejecutar 2 " + registro.toString());	
		return actualizados == 1 ? true : false;
	}

	@Override
	public SolicitudOferenteIDVo buscar(SolicitudOferenteIDVo registro) {

		StringBuilder sentencia = new StringBuilder("Select consecutivo from TBL_Consecutivo_Solicitud  ");

		String criterio = generarCriteriosBusqueda(registro);
		if (criterio.length() > 0)
			sentencia.append(WHERE).append(criterio);

		try {
			LOGGER.debug(PREFIJO_LOG + "Sentencia a ejecutar de la consulta"+ sentencia.toString());
			return this.jdbcVivienda.query(sentencia.toString(),new SolicitudOferenteExtractor());
		} catch (EmptyResultDataAccessException e) {
			return new SolicitudOferenteIDVo();
		}
	}

	@Override
	public String generarCriteriosBusqueda(SolicitudOferenteIDVo registro) {
		StringBuilder criterio = new StringBuilder();
		if (registro.getAnio() != null && !registro.getAnio().trim().equals("")) {
			   
			if(criterio.length()>0)
			{
				criterio.append(AND);
				criterio.append("anio").append(" = ").append(COMILLA).append(registro.getAnio()).append(COMILLA);
			}else
				criterio.append("anio").append(" = ").append(COMILLA).append(registro.getAnio()).append(COMILLA);
		}
		if (registro.getId_estado() != null) {
			if(criterio.length()>0)
			{
				criterio.append(AND);
				criterio.append("id_estado").append(" = ").append(COMILLA).append(registro.getId_estado()).append(COMILLA);
			}else
				criterio.append("id_estado").append(" = ").append(COMILLA).append(registro.getId_estado()).append(COMILLA);

		}
		if (registro.getId_tipo_solicitud() != null) {
			if(criterio.length()>0)
			{
				criterio.append(AND);
				criterio.append("id_tipo_solicitud").append(" = ").append(COMILLA).append(registro.getId_tipo_solicitud()).append(COMILLA);
			}else
				criterio.append("id_tipo_solicitud").append(" = ").append(COMILLA).append(registro.getId_tipo_solicitud()).append(COMILLA);

		}

		return criterio.toString();
	}



	@Override
	public List<SolicitudOferenteIDVo> buscarLista(
			SolicitudOferenteIDVo registro) {

		return null;

	}

	@Override
	public List<SolicitudOferenteIDVo> guardarOferenteSolicitud(
			SolicitudOferenteIDVo criterios) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void guardarSolicitud(SolicitudOferenteIDVo registro) {
		// TODO Apéndice de método generado automáticamente

	}

	@Override
	public boolean guardar(SolicitudOferenteIDVo registro) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public boolean guardar(List<SolicitudOferenteIDVo> registros) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public Set<SolicitudOferenteIDVo> buscarUnicos(
			SolicitudOferenteIDVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String generarCriterios(SolicitudOferenteIDVo registro,
			List<Object> parametros) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



}
