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

import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;

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



@Repository("ReporteEcoTecnologiasDao")
public class ReporteEcoTecnologiasDao extends AbstractReportesEcoDao<ReporteEcoTecnologiaVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteEcoTecnologiasDao.class);
	private static final String PREFIJO_LOG = "[EcoTecCon] - ";
	
	private class ReporteInexUvOferenteExtractor implements ResultSetExtractor<List<ReporteEcoTecnologiaVo>>
	{
		@Override
		public List<ReporteEcoTecnologiaVo> extractData(ResultSet resultSet)throws SQLException, DataAccessException {
			List<ReporteEcoTecnologiaVo> regreso = new ArrayList<ReporteEcoTecnologiaVo>();
			while( resultSet.next() )
			{
				regreso.add(new ReporteEcoTecnologiaVo(resultSet.getString("claveTecnologia")
						,resultSet.getString("paquete")
						,resultSet.getString("anioMES")
						,resultSet.getString("numecotec")));			
			}
			return regreso;
		}
	}

	@Override
	public List<ReporteEcoTecnologiaVo> buscarReporteEcoTecnologias(ReporteEcoTecnologiaVo objeto) 
	{
		StringBuilder sentencia = new StringBuilder("select x.paquete,x.claveTecnologia,x.anioMES, count(x.claveTecnologia) "+
													"as numecotec from ( select viv.idVivienda,viv.idNumeroCedula as "+
													"paquete,viv.nss,viv.cuv,viv.fecha_dtu,ecos.claveTecnologia,"+
													"cast(YEAR(fecha_dtu) as varchar(4)) + '-' + cast(MONTH(fecha_dtu)as varchar(2)) as "+
													"anioMES from vivienda as viv with(NOLOCK)left join "+
													" (select * from TBL_Ecotecnologias with(NOLOCK) where estatus = '1') "+
													"as ecos  on (ecos.idVivienda = viv.idVivienda and ecos.Paquete = viv.idNumeroCedula) "+
													"left join cedulapresentacion as cp with (NOLOCK) on viv.idNumeroCedula = cp.idNumeroCedula ");
												
		String criterios = generarCriteriosBusqueda(objeto);
		if( criterios.length()>0 )
			 sentencia.append(WHERE).append(criterios);
		
//		 if( objeto.getPaquete()!=null && !objeto.getPaquete().trim().equals(""))
//			{
//			 	sentencia.append(ESPACIO).append(" group by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
//			 	sentencia.append(ESPACIO).append(" order by substring(id_paquete,1,2), a.id_uv ,c.descripcion");
//			}
		sentencia.append(ESPACIO).append("and ind_sit_nss = 4");
		sentencia.append(ESPACIO).append(") as x group by x.paquete,x.claveTecnologia,x.anioMES");
		try
		{
			LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar"+sentencia.toString());
			return this.jdbcVivienda.query(sentencia.toString(),new ReporteInexUvOferenteExtractor());
		}catch (EmptyResultDataAccessException e) {
			return new ArrayList<ReporteEcoTecnologiaVo>();
		}
	}

	@Override
	public String generarCriteriosBusqueda(ReporteEcoTecnologiaVo objeto) {
		StringBuilder criterios = new StringBuilder();
		if( objeto.getFechaSolicitudFin()!=null && !objeto.getFechaSolicitudFin().trim().equals("") )
		{
			if( criterios.length()>0)
				 
				criterios.append(AND);
			criterios.append("ClaveTecnologia").append(IGUAL).append("'").append(objeto.getFechaSolicitudFin().trim()).append(COMILLA);
		}
		
		if( objeto.getFechaSolicitudInicio()!=null && !objeto.getFechaSolicitudInicio().trim().equals(""))
		{
			if( criterios.length()>0)
				criterios.append(AND);
			if(objeto.getFechaSolicitudInicio().length() == 12)
			{
				criterios.append("cp.rfcOferente").append(IGUAL).append("' ").append(objeto.getFechaSolicitudInicio()).append(COMILLA);
			}else
			criterios.append("cp.rfcOferente").append(IGUAL).append(COMILLA).append(objeto.getFechaSolicitudInicio()).append(COMILLA);
		}
		if( objeto.getPaquete()!=null && !objeto.getPaquete().trim().equals("")
			&& objeto.getClaveTecnologia()!=null && !objeto.getClaveTecnologia().trim().equals("") 
		   )
		  {
			  if( criterios.length()>0)
					criterios.append(AND);
				criterios.append(PARENTESIS_ABRE).append("fecha_dtu").append(MAYOR_IGUAL).append(COMILLA).append(objeto.getClaveTecnologia()).append(COMILLA)
					     .append(AND)
						 .append("fecha_dtu").append(MENOR_IGUAL).append(COMILLA).append(objeto.getPaquete()).append(COMILLA)
						 .append(PARENTESIS_CIERRA);
		  }
//			
//			--and substring(id_paquete,1,2) = '01' ---variable
//			--and id_paquete = '0100119200305210'  --- variable
//			--and (fecha_solicitud >= '2019-01-01' and fecha_solicitud <= '2019-02-20') --- variable
		
//		group by substring(id_paquete,1,2), a.id_uv ,c.descripcion
//		order by substring(id_paquete,1,2), a.id_uv ,c.descripcion
		
		
		
		  if( criterios==null || criterios.length()==0)
			  throw new IllegalArgumentException("No hay criterios para realizar búsqueda de ecotecnologias");
	
		return criterios.toString();
	}

}
