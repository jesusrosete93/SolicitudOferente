/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoCerradoVo;

/**
 * @author Adrian Casas
 *
 */
@Repository("ReporteAvaluoCerradoDao")
public class ReporteAvaluoCerradoDao extends AbstractDao<AvaluoCerradoVo> {
	
	public static int TIPO_REPORTE;
	public static boolean POR_ESTADO;
	public static boolean POR_UNIDAD;
	
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteAvaluoCerradoDao.class);
	
	private static final String AVALUOS_CERRADOS_ANIO= " SELECT YEAR(fecha_cierre) AS Anio,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
													   " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
													   " GROUP BY  YEAR(fecha_cierre),id_tipo_mercado";

	private static final String AVALUOS_CERRADOS_MES =" SELECT MONTH(fecha_cierre) AS Mes,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
													  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' and tipo_linea='2'))"+
													  " GROUP BY  MONTH(fecha_cierre),id_tipo_mercado"+
													  " ORDER BY MONTH(fecha_cierre),id_tipo_mercado";

	private static final String AVALUOS_CERRADOS_DIA =" SELECT DAY(fecha_cierre) AS dia,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
													  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
													  " GROUP BY  DAY(fecha_cierre),id_tipo_mercado ORDER BY DAY(fecha_cierre)";		
		
	private static final String AVALUOS_CERRADOS_HORA =" SELECT CONVERT(VARCHAR(2), fecha_cierre, 108) 'hora', COUNT(*) as Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
													   " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
													   " GROUP BY CONVERT(VARCHAR(2), fecha_cierre, 108),id_tipo_mercado ORDER BY CONVERT(VARCHAR(2), fecha_cierre, 108)";
	
	
	private static final String AVALUOS_CERRADOS_ESTADO_ANIO= " SELECT YEAR(fecha_cierre) AS Anio,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
															  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))" +
															  " AND SUBSTRING(id_avaluo,1,2)=?"+
															  " GROUP BY  YEAR(fecha_cierre),id_tipo_mercado";

	private static final String AVALUOS_CERRADOS_ESTADO_MES =" SELECT MONTH(fecha_cierre) AS Mes,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
												  			 " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' and tipo_linea='2'))"+
												  			 " AND SUBSTRING(id_avaluo,1,2)=?"+
												  			 " GROUP BY  MONTH(fecha_cierre),id_tipo_mercado"+
												  			 " ORDER BY MONTH(fecha_cierre),id_tipo_mercado";

	private static final String AVALUOS_CERRADOS_ESTADO_DIA =" SELECT DAY(fecha_cierre) AS dia,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
															  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
															  " AND SUBSTRING(id_avaluo,1,2)=?"+
															  " GROUP BY  DAY(fecha_cierre),id_tipo_mercado ORDER BY DAY(fecha_cierre)";		

	private static final String AVALUOS_CERRADOS_ESTADO_HORA =" SELECT CONVERT(VARCHAR(2), fecha_cierre, 108) 'hora', COUNT(*) as Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
												   			  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
												   			  " AND SUBSTRING(id_avaluo,1,2)=?"+
												   			  " GROUP BY CONVERT(VARCHAR(2), fecha_cierre, 108),id_tipo_mercado ORDER BY CONVERT(VARCHAR(2), fecha_cierre, 108)";
	private static final String AVALUOS_CERRADOS_UV_ANIO=  " SELECT YEAR(fecha_cierre) AS Anio,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
														   " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))" +
														   " AND id_uv=?"+
														   " GROUP BY  YEAR(fecha_cierre),id_tipo_mercado";
	
	private static final String AVALUOS_CERRADOS_UV_MES = " SELECT MONTH(fecha_cierre) AS Mes,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
														  " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' and tipo_linea='2'))"+
														  " AND id_uv=?"+
														  " GROUP BY  MONTH(fecha_cierre),id_tipo_mercado"+
														  " ORDER BY MONTH(fecha_cierre),id_tipo_mercado";	
	
	private static final String AVALUOS_CERRADOS_UV_DIA =	" SELECT DAY(fecha_cierre) AS dia,COUNT(*) AS Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
															" WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
															" AND id_uv=?"+
															" GROUP BY  DAY(fecha_cierre),id_tipo_mercado ORDER BY DAY(fecha_cierre)";		
	
	private static final String AVALUOS_CERRADOS_UV_HORA = " SELECT CONVERT(VARCHAR(2), fecha_cierre, 108) 'hora', COUNT(*) as Cerrados,id_tipo_mercado FROM avaluo WITH(NOLOCK)"+
														   " WHERE fecha_cierre >= ? AND fecha_cierre <= ? AND ( (id_tipo_mercado='1') OR (id_tipo_mercado='2' AND tipo_linea='2'))"+
														   " AND id_uv=?"+
														   " GROUP BY CONVERT(VARCHAR(2), fecha_cierre, 108),id_tipo_mercado ORDER BY CONVERT(VARCHAR(2), fecha_cierre, 108)";

	private class AvaluoCerradoMapper implements RowMapper<AvaluoCerradoVo>
	{

		@Override
		public AvaluoCerradoVo mapRow(ResultSet resultSet, int fetch)
				throws SQLException {
			AvaluoCerradoVo regreso = new AvaluoCerradoVo();
			
			switch(ReporteAvaluoCerradoDao.TIPO_REPORTE)
			{
			case 1:
					regreso.setTituloCerrados(resultSet.getString("Anio"));
					break;
			
			case 2:
					regreso.setTituloCerrados(resultSet.getString("Mes"));
					break;
			case 3:
					regreso.setTituloCerrados(resultSet.getString("dia"));
					break;
			case 4:
					regreso.setTituloCerrados(resultSet.getString("hora"));
					break;				
			}
			regreso.setAvaluosCerrados(resultSet.getInt("Cerrados"));
			regreso.setTipoMercado(resultSet.getInt("id_tipo_mercado"));
			return regreso;
		}
		
	}
	
	
	@Override
	public AvaluoCerradoVo buscar(AvaluoCerradoVo registro) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public List<AvaluoCerradoVo> buscarLista(AvaluoCerradoVo registro) {
		// TODO Auto-generated method stub
		List<AvaluoCerradoVo> regreso = new ArrayList<AvaluoCerradoVo>();
		try
		{
			if( ReporteAvaluoCerradoDao.POR_ESTADO)
			{
				switch(ReporteAvaluoCerradoDao.TIPO_REPORTE)
				{
					case 1:
						LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_ESTADO_ANIO+"] criterios: ["+registro+"]");
						regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_ESTADO_ANIO,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getEstado());
						break;
					case 2:
						LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_ESTADO_MES+"] criterios: ["+registro+"]");
						regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_ESTADO_MES,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getEstado());
						break;
					case 3:
						LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_ESTADO_DIA+"] criterios: ["+registro+"]");
						regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_ESTADO_DIA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getEstado());
						break;
					case 4:
						LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_ESTADO_HORA+"] criterios: ["+registro+"]");
						regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_ESTADO_HORA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getEstado());
						break;
				}
			}else 
			{
				if( ReporteAvaluoCerradoDao.POR_UNIDAD)
				{
					switch(ReporteAvaluoCerradoDao.TIPO_REPORTE)
					{
						case 1:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_UV_ANIO+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_UV_ANIO,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getUnidadValuacion());
							break;
						case 2:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_UV_MES+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_UV_MES,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getUnidadValuacion());
							break;
						case 3:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_UV_DIA+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_UV_DIA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getUnidadValuacion());
							break;
						case 4:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_UV_HORA+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_UV_HORA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin(),registro.getUnidadValuacion());
							break;
					}
				}else
				{
					switch(ReporteAvaluoCerradoDao.TIPO_REPORTE)
					{
						case 1:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_ANIO+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_ANIO,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin());
							break;
						case 2:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_MES+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_MES,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin());
							break;
						case 3:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_DIA+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_DIA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin());
							break;
						case 4:
							LOGGER.debug("[ACD] - Ejecutando sentencia ["+AVALUOS_CERRADOS_HORA+"] criterios: ["+registro+"]");
							regreso = this.jdbcAvaluos.query(AVALUOS_CERRADOS_HORA,new AvaluoCerradoMapper(),registro.getFechaInicio(),registro.getFechaFin());
							break;
					}
				}
			}
			return regreso;
		}catch (EmptyResultDataAccessException e) {
			
			return new ArrayList<AvaluoCerradoVo>();
		}
	}

	@Override
	public String generarCriterios(AvaluoCerradoVo registro, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(AvaluoCerradoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<AvaluoCerradoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<AvaluoCerradoVo> buscarUnicos(AvaluoCerradoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
