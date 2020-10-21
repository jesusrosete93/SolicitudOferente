/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoSubValuadoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Atlas
 *
 */
@Repository("AvaluoSubValuadoDao")
public class AvaluoSubValuadoDao extends AbstractDao<AvaluoSubValuadoVo> {
	
	private static Logger LOGGER = LogManager.getLogger(AvaluoSubValuadoDao.class);
	
	/**
	 * 
	 * @author Atlas
	 *
	 */
	private class AvaluoSubvaluadoMapper implements RowMapper<AvaluoSubValuadoVo>
	{
		@Override
		public AvaluoSubValuadoVo mapRow(ResultSet resultSet, int fecth)
				throws SQLException {
			// TODO Auto-generated method stub
			return new AvaluoSubValuadoVo(validar(resultSet.getString("id_paquete"),"")
										  ,resultSet.getInt("id_vivienda")
										  ,validar(resultSet.getString("id_avaluo"),"")
										  ,validar(resultSet.getString("cp"),"")
										  ,validar(resultSet.getString("fecha_cierre"),"")
										  ,resultSet.getInt("edad")
										  ,resultSet.getDouble("superficie_construida")
										  ,resultSet.getDouble("superficie_terreno_vivienda")
										  ,validar(resultSet.getString("id_tipo_inmueble_valuado"),"")
										  ,validar(resultSet.getString("id_clase_gral_inmueble"),"")
										  ,resultSet.getDouble("cus")
										  ,resultSet.getDouble("cus_calc_ava")
										  ,resultSet.getDouble("valor_concluido")
										  ,resultSet.getDouble("valor_comparativo_m2")
										  ,resultSet.getDouble("promedioComp")
										  ,resultSet.getDouble("valor_comparativo_menor")
										  ,resultSet.getDouble("valor_comparativo_mayor")
										  ,validar(resultSet.getString("mensaje"),"")
										  ,resultSet.getInt("ban")
										  ,resultSet.getInt("id_uv")
										  ,validar(resultSet.getString("descripcion"),"")
										  );
		}
		
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscar(java.lang.Object)
	 */
	@Override
	public AvaluoSubValuadoVo buscar(AvaluoSubValuadoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.org.infonavit.reporteuvs.persistence.AbstractDao#buscarLista(java.lang.Object)
	 */
	@Override
	public List<AvaluoSubValuadoVo> buscarLista(AvaluoSubValuadoVo registro) {
		// TODO Auto-generated method stub
		List<Object> parametros = new ArrayList<Object>();
		String criterios = generarCriterios(registro,parametros);
		LOGGER.info("[ASD] - parametros:"+ parametros);
		LOGGER.info("[ASD] - criterios:"+ criterios);
		String query    = "SELECT a.id_paquete, a.id_vivienda, s.*, a.id_uv,c.descripcion "+ 
						  "FROM sobrevaluados as s "+
						  "LEFT JOIN avaluo as a on a.id_avaluo = s.id_avaluo "+
						  "LEFT JOIN cat_uv as c on c.id_uv = a.id_uv WHERE "+criterios+" "+
						  "ORDER BY id_avaluo";
		LOGGER.info("[ASD] - Query: ["+query+"]");
		return this.jdbcAvaluos.query(query,parametros.toArray(),new AvaluoSubvaluadoMapper());
	}

	@Override
	public String generarCriterios(AvaluoSubValuadoVo registro, List<Object> valores) {
		// TODO Auto-generated method stub
		StringBuffer criterios = new StringBuffer();
	
		
		if( !registro.getIdAvaluo().trim().equals(""))
		{
			if( criterios.length()==0)
			{
				criterios.append(" s.id_avaluo=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append(" s.id_avaluo=?");
			}
			valores.add(registro.getIdAvaluo());
		}
		if( !registro.getIdPaquete().trim().equals(""))
		{
			if( criterios.length()==0)
			{
				criterios.append(" a.id_paquete=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("a.id_paquete=?");
			}
			valores.add(registro.getIdPaquete());
		}
		if( registro.getIdVivienda()>0)
		{
			if( criterios.length()==0)
			{
				criterios.append(" a.id_vivienda=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("a.id_vivienda=?");
			}
			valores.add(new Integer(registro.getIdVivienda()));
		}	
		if( registro.getIdUnidadValuacion()>0)
		{
			if( criterios.length()==0)
			{
				criterios.append(" a.id_uv=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("a.id_uv=?");
			}
			valores.add(new Integer(registro.getIdUnidadValuacion()));
		}		
		if( registro.getBandera()>0)
		{
			if( criterios.length()==0)
			{
				criterios.append(" s.ban=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("s.ban=?");
			}
			valores.add(new Integer(registro.getBandera()));
		}	
		if( !registro.getCodigoPostal().trim().equals(""))
		{
			if( criterios.length()==0)
			{
				criterios.append(" s.cp=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("s.cp=?");
			}
			valores.add(registro.getCodigoPostal());
		}
		if( !registro.getFechaCierreInicio().trim().equals("") && !registro.getFechaCierreFin().trim().equals(""))
		{
			if( criterios.length()==0)
			{
				criterios.append(" s.fecha_cierre>=? AND s.fecha_cierre<=?");
			}else
			{
				criterios.append(" AND ");
				criterios.append("s.fecha_cierre>=? AND s.fecha_cierre<=?");
			}
			valores.add(registro.getFechaCierreInicio());
			valores.add(registro.getFechaCierreFin());
		}
		if( criterios==null || criterios.length()==0)
		{
			throw new IllegalArgumentException("No hay criterios para realizar la busqueda");
		}
		return criterios.toString();
	}

	@Override
	public boolean guardar(AvaluoSubValuadoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<AvaluoSubValuadoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<AvaluoSubValuadoVo> buscarUnicos(AvaluoSubValuadoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
