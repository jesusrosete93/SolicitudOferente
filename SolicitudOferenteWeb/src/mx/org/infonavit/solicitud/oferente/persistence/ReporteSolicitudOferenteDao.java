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
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteConsultaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

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



@Repository("ReporteSolicitudOferenteDao")
public class ReporteSolicitudOferenteDao extends AbstractReportesConsultaOferente<SolicitudOferenteConsultaVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteSolicitudOferenteDao.class);
	private static final String PREFIJO_LOG = "[EcoTecCon] - ";
	
	private class ReporteInexUvOferenteExtractor implements ResultSetExtractor<List<SolicitudOferenteConsultaVo>>
	{
		@Override
		public List<SolicitudOferenteConsultaVo> extractData(ResultSet resultSet)throws SQLException, DataAccessException {
			List<SolicitudOferenteConsultaVo> regreso = new ArrayList<SolicitudOferenteConsultaVo>();
			while( resultSet.next() )
			{
				regreso.add(new SolicitudOferenteConsultaVo(resultSet.getString("id_solicitud"),resultSet.getString("id_tipo_solicitud"),
						resultSet.getString("fecha_solicitud"),resultSet.getString("id_oferente")
						,resultSet.getString("nombre_razon_social"),resultSet.getString("id_estado"),resultSet.getString("id_paquete")
						,resultSet.getString("id_oferta_vivienda"), resultSet.getString("id_estatus")));			
			}
			return regreso;
		}
	}


	
	@Override
	public List<SolicitudOferenteConsultaVo> buscarReporteEcoTecnologias(SolicitudOferenteConsultaVo criterios) {

		StringBuilder sentencia = new StringBuilder("   SELECT id_solicitud ,id_tipo_solicitud" +
				" ,fecha_solicitud,id_oferente,nombre_razon_social,id_estado,id_paquete,id_oferta_vivienda,id_estatus "+
                   "FROM TBL_Solicitudes_Oferente  ");
			
			String criterio = generarCriteriosBusqueda(criterios);
				if( criterio.length()>0 )
					sentencia.append(WHERE).append(criterio);

	
try
{
    LOGGER.debug(PREFIJO_LOG+"Sentencia a ejecutar de la consulta" + sentencia.toString());
            return this.jdbcVivienda.query(sentencia.toString(),new ReporteInexUvOferenteExtractor());
       }catch (EmptyResultDataAccessException e) {
            return new ArrayList<SolicitudOferenteConsultaVo>();
}
	}


	@Override
	public String generarCriteriosBusqueda(SolicitudOferenteConsultaVo criterios) {
		StringBuilder criterio = new StringBuilder();
		
		if( criterios.getFechaSolicitudInicio()!=null && !criterios.getFechaSolicitudInicio().trim().equals("")
				&& criterios.getFechaSolicitudFin()!=null && !criterios.getFechaSolicitudFin().trim().equals("") 
			   )
			  {
//				  if( criterio.length()>0)
					
					criterio.append("fecha_solicitud ").append(" between").append(COMILLA).append(criterios.getFechaSolicitudInicio()).append(COMILLA)
						.append(AND).append(COMILLA).append(criterios.getFechaSolicitudFin()).append(COMILLA);
			  }
		
		if( criterios.getId_estatus()!=null && !criterios.getId_estatus().trim().equals("") )
		{
			if( criterio.length()>0)
				 
				criterio.append(AND);
			criterio.append("id_estatus").append(IGUAL).append("'").append(criterios.getId_estatus().trim()).append(COMILLA);
		}
		
		if( criterios.getId_paquete()!=null && !criterios.getId_paquete().trim().equals("") )
		{
			if( criterio.length()>0)
				 
			criterio.append(AND);
			criterio.append("id_paquete").append(IGUAL).append("'").append(criterios.getId_paquete().trim()).append(COMILLA);
		}
		
		if( criterios.getId_tipo_solicitud()!=null && !criterios.getId_tipo_solicitud().trim().equals("") )
		{
		if( criterio.length()>0)
				 
			criterio.append(AND);
			criterio.append("id_tipo_solicitud").append(IGUAL).append("'").append(criterios.getId_tipo_solicitud().trim()).append(COMILLA);
		}
		
		if( criterios.getId_estado()!=null && !criterios.getId_estado().trim().equals("") )
		{
		if( criterio.length()>0)
				 
			criterio.append(AND);
			criterio.append("id_estado").append(IGUAL).append("'").append(criterios.getId_estado().trim()).append(COMILLA);
		}
		  
		
		  if( criterio==null || criterio.length()==0)
			  throw new IllegalArgumentException("No hay criterios para realizar búsqueda de ecotecnologias");
	
		return criterio.toString();
	}








}
