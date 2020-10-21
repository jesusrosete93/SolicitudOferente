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

import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.AND;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.COMILLA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ESPACIO;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MAYOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.MENOR_IGUAL;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PARENTESIS_ABRE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.PARENTESIS_CIERRA;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.WHERE;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;


@Repository("ReporteInexUvOferenteDao")
public class ReporteInexUvOferenteDao extends AbstractReportesDao<ReporteInexUvOferenteVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteInexUvOferenteDao.class);
	private static final String PREFIJO_LOG = "[RIUOD] - ";
	
	private class ReporteInexUvOferenteExtractor implements ResultSetExtractor<List<ReporteInexUvOferenteVo>>
	{
		@Override
		public List<ReporteInexUvOferenteVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<ReporteInexUvOferenteVo> regreso = new ArrayList<ReporteInexUvOferenteVo>();
			while( resultSet.next() )
			{
				regreso.add(new ReporteInexUvOferenteVo(validar(resultSet.getString("estado"),"")
														,resultSet.getInt("id_uv")
														,validar(resultSet.getString("descripcion"),"")
														,resultSet.getInt("total_viviendas")));
			}
			return regreso;
		}
	}

	@Override
	public List<ReporteInexUvOferenteVo> buscarReporteInexOferente(ReporteInexUvOferenteVo objeto) 
	{
		StringBuilder sentencia = new StringBuilder(" select substring(id_paquete,1,2) as estado, a.id_uv, c.descripcion, count(*) as total_viviendas "+
													" from avaluo as a WITH(NOLOCK)  "+
													" left join cat_uv as c on c.id_uv = a.id_uv ");
		String criterios = generarCriteriosBusqueda(objeto);
		if( criterios.length()>0 )
			 sentencia.append(WHERE).append(criterios);
		
//		 if( objeto.getPaquete()!=null && !objeto.getPaquete().trim().equals(""))
//			{
//			 	sentencia.append(ESPACIO).append(" group by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
//			 	sentencia.append(ESPACIO).append(" order by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
//			}
		sentencia.append(ESPACIO).append(" group by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
	 	sentencia.append(ESPACIO).append(" order by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar"+sentencia.toString());
			return this.jdbcAvaluos.query(sentencia.toString(),new ReporteInexUvOferenteExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<ReporteInexUvOferenteVo>();
		}
	}

	@Override
	public String generarCriteriosBusqueda(ReporteInexUvOferenteVo objeto) {
		StringBuilder criterios = new StringBuilder();
		if( objeto.getRfcOferente()!=null && !objeto.getRfcOferente().trim().equals(""))
		{
			if( criterios.length()>0)
				criterios.append(AND);
			criterios.append("id_paquete in "+
							"("+
							       "select id_paquete from paquete WITH(NOLOCK)"+ 
							       "where rfc = '"+objeto.getRfcOferente()+"' "+
							       "and tipo_paquete = 'N'"+
							")");
		}
		if( objeto.getEstado()!=null && !objeto.getEstado().trim().equals("") )
		{
			if( criterios.length()>0)
				criterios.append(AND);
			criterios.append("substring(id_paquete,1,2)").append(IGUAL).append(COMILLA).append(objeto.getEstado()).append(COMILLA);
		}
		if( objeto.getPaquete()!=null && !objeto.getPaquete().trim().equals(""))
		{
			if( criterios.length()>0)
				criterios.append(AND);
			criterios.append("id_paquete").append(IGUAL).append(COMILLA).append(objeto.getPaquete()).append(COMILLA);
		}
		if( objeto.getFechaSolicitudInicio()!=null && !objeto.getFechaSolicitudInicio().trim().equals("")
			&& objeto.getFechaSolicitudFin()!=null && !objeto.getFechaSolicitudFin().trim().equals("") 
		   )
		  {
			  if( criterios.length()>0)
					criterios.append(AND);
				criterios.append(PARENTESIS_ABRE).append("fecha_solicitud").append(MAYOR_IGUAL).append(COMILLA).append(objeto.getFechaSolicitudInicio()).append(COMILLA)
					     .append(AND)
						 .append("fecha_solicitud").append(MENOR_IGUAL).append(COMILLA).append(objeto.getFechaSolicitudFin()).append(COMILLA)
						 .append(PARENTESIS_CIERRA);
		  }
//			
//			--and substring(id_paquete,1,2) = '01' ---variable
//			--and id_paquete = '0100119200305210'  --- variable
//			--and (fecha_solicitud >= '2019-01-01' and fecha_solicitud <= '2019-02-20') --- variable
		
//		group by substring(id_paquete,1,2), a.id_uv ,c.descripcion
//		order by substring(id_paquete,1,2), a.id_uv ,c.descripcion
		
		
		
		  if( criterios==null || criterios.length()==0)
			  throw new IllegalArgumentException("No hay criterios para realizar búsqueda de avaluos oferente");
	
		return criterios.toString();
	}

}
