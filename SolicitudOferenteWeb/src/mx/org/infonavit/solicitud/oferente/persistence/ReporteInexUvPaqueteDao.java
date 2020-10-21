package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;
/**
 * <p>
 * Clase que encapsula las operaciones de consulta a la base de datos avaluos
 * ejecutando sentencias sql en especifico para la obtención de datos para el reporte de
 * <b>Consultas de Totales del Paquete</b>.
 * </p>  
 * @author Adrian Casas
 *
 */
@Repository("ReporteInexUvPaqueteDao")
public class ReporteInexUvPaqueteDao extends AbstractReporteInexUvPaqueteDao<ReporteInexUvPaqueteVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvOferenteDao.class);
	private static final String PREFIJO_LOG = "[RIUPD] - ";
	
	private class ReporteInexUvPaqueteExtractor implements ResultSetExtractor<List<ReporteInexUvPaqueteVo>>
	{
		@Override
		public List<ReporteInexUvPaqueteVo> extractData(ResultSet resulSet)	throws SQLException, DataAccessException {
			List<ReporteInexUvPaqueteVo> regreso = new ArrayList<ReporteInexUvPaqueteVo>();
			while(resulSet.next())
			{
				ReporteInexUvPaqueteVo registro = new ReporteInexUvPaqueteVo();
				registro.setIdUnidadValuacion(resulSet.getInt("id_uv"));
				registro.setNombreUnidadValuacion(validar(resulSet.getString("descripcion"),""));
				registro.setNumeroViviendasUnidadValuacion(resulSet.getInt("total_vivienda"));
				regreso.add(registro);
			}
		 return regreso;
		}
	}
	
	
//	private class ReporteInexUvPaqueteMapper implements RowMapper<ReporteInexUvPaqueteVo>
//	{
//
//		@Override
//		public ReporteInexUvPaqueteVo mapRow(ResultSet resultSet, int arg1)
//				throws SQLException {
//
//			ReporteInexUvPaqueteVo registro = new ReporteInexUvPaqueteVo();
//			registro.setIdUnidadValuacion(resultSet.getInt("id_uv"));
//			registro.setNombreUnidadValuacion(validar(resultSet.getString("descripcion"),""));
//			registro.setNumeroViviendasUnidadValuacion(resultSet.getInt("total_vivienda"));
//			return registro;
//		}
//	}

	@Override
	public int buscarSolicitudesPaquete(ReporteInexUvPaqueteVo criterios) {
		String sentencia = "select count(*) as num_solictadas from avaluo WITH(NOLOCK) "+ 
							"where id_paquete = ? ";
		int regreso = -1;
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			regreso = this.jdbcAvaluos.queryForObject(sentencia,new Object[]{criterios.getPaquete()},Integer.class);
			LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
	 return regreso;
	}

	@Override
	public int buscarTotalViviendasEstado(ReporteInexUvPaqueteVo criterios) {
		String sentencia = "select count(*) as total from avaluo WITH(NOLOCK) "+
							"where id_paquete in " +
							"( "+
							       " select id_paquete from paquete WITH(NOLOCK) "+ 
							       " where substring(id_paquete,1,2) = substring('"+criterios.getPaquete()+"',1,2) "  +
							       " and rfc in " +
							       "("+
							             " select rfc from paquete WITH(NOLOCK) "+
							             " where id_paquete = '"+criterios.getPaquete()+"'"+
							       ")"+
							       "and tipo_paquete = 'N'"+
							")";
		int regreso = -1;
		try
			{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			regreso = this.jdbcAvaluos.queryForObject(sentencia,Integer.class);
			LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
		return regreso;
	}

	@Override
	public List<ReporteInexUvPaqueteVo> buscarTotalViviendasPorUnidad(ReporteInexUvPaqueteVo criterios) {
		String sentencia = "select a.id_uv, c.descripcion, count(*) as total_vivienda"+ 
							" from avaluo as a WITH(NOLOCK) "+ 
							" left join cat_uv as c on c.id_uv = a.id_uv "+  
							" where id_paquete =? "+
							" group by a.id_uv, c.descripcion ";
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			return this.jdbcAvaluos.query(sentencia,new Object[]{criterios.getPaquete()},new ReporteInexUvPaqueteExtractor());
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
			return new ArrayList<ReporteInexUvPaqueteVo>();
		}
	}

	@Override
	public int buscarViviendasPaquete(ReporteInexUvPaqueteVo criterios) {
		String sentencia = "select num_viviendas from paquete WITH(NOLOCK) where id_paquete = ?";
		int regreso = -1;
		try
			{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			regreso = this.jdbcAvaluos.queryForObject(sentencia,new Object[]{criterios.getPaquete()},Integer.class);
			LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
		return regreso;
	}

	@Override
	public int buscarProduccionOferentePaquetesMayor(ReporteInexUvPaqueteVo criterios) {
		int regreso = -1;
		String sentencia = "select count(*) as va_mayor from avaluo with(nolock) "+
							" where id_paquete in "+
							"( select id_paquete from paquete with(nolock) "+
							"   where substring(id_paquete, 1,2) = substring('"+criterios.getPaquete()+"',1,2) "  +
							"       and rfc = ? "+
							"       and tipo_paquete = 'N' " +
							"       and num_viviendas > 100 " +  
							")";
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			LOGGER.debug(PREFIJO_LOG+"Rfc oferente: ["+criterios.getRfcOferente()+"]");
			regreso = this.jdbcAvaluos.queryForObject(sentencia,new Object[]{criterios.getRfcOferente()},Integer.class);
			LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
		return regreso;
		
	}

	@Override
	public int buscarProduccionOferentePaquetesMenor(ReporteInexUvPaqueteVo criterios) {
		int regreso = -1;
		String sentencia = "select ISNULL(sum(num_viviendas),0) as va_menot from paquete with(nolock) "+
						   "where substring(id_paquete, 1,2) = substring('"+criterios.getPaquete()+"',1,2) "  +
						   "and rfc = ? "+
						   "and tipo_paquete = 'N' "+
						   "and num_viviendas <= 100 ";
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			LOGGER.debug(PREFIJO_LOG+"Paquete:"+criterios.getPaquete());
			LOGGER.debug(PREFIJO_LOG+"Rfc oferente: ["+criterios.getRfcOferente()+"]");
			regreso = this.jdbcAvaluos.queryForObject(sentencia,new Object[]{criterios.getRfcOferente()},Integer.class);
			LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
	  return regreso;
	}

	@Override
	public List<Integer> buscarInexRegistrados() {
		List<Integer> regreso = null;
		String sentencia = "select distinct(id_inex) as id_inex from  inex_uv_gral with(nolock)";
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar: " +sentencia);
			regreso = this.jdbcAvaluos.query(sentencia,new ResultSetExtractor<List<Integer>>(){
																								@Override
																								public List<Integer> extractData(ResultSet resultSet)
																										throws SQLException, DataAccessException {
																									List<Integer> regreso = new ArrayList<Integer>();
																									while(resultSet.next())
																									{
																										regreso.add(resultSet.getInt("id_inex"));
																									}
																								  return regreso;
																								}
																							});
		    LOGGER.debug(PREFIJO_LOG+"Resultado sentencia:"+regreso);
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error(PREFIJO_LOG+"Error no hay datos:",e);
		}
	  return regreso;
	}
	

	

	
}
