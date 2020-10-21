package mx.org.infonavit.solicitud.oferente.persistence;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import java.sql.Connection;

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
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteExtraccionVo;
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
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.VALUES;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;



@Repository("SolicitudOferenteExtraccionDao")
public class SolicitudOferenteExtraccionDao extends AbstractSolicitudOferenteEctraccionDao<SolicitudOferenteExtraccionVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudOferenteExtraccionDao.class);
	private static final String PREFIJO_LOG = "[EcoTecCon] - ";
	
	
	private class SolicitudOferenteExtractor implements ResultSetExtractor<List<SolicitudOferenteVo>>
	{
		@Override
		public List<SolicitudOferenteVo> extractData(ResultSet resultSet)throws SQLException, DataAccessException {
			List<SolicitudOferenteVo> regreso = new ArrayList<SolicitudOferenteVo>();
			while( resultSet.next() )
			{
//	regreso.add(new SolicitudOferenteVo(resultSet.getString("id_oferente")));				
			}
			return regreso;
		}
	}
	
	@Override
	public List<SolicitudOferenteExtraccionVo> guardarArchivos(final SolicitudOferenteExtraccionVo registro){
		final String sentencia = " insert into TBL_Documentos_Solicitud  VALUES (?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcVivienda.update(new PreparedStatementCreator(){
		@Override
		public PreparedStatement createPreparedStatement(Connection conexion)throws SQLException {

		LOGGER.debug(PREFIJO_LOG+ " Sentencia a ejecutar " + sentencia.toString());
		PreparedStatement ps = conexion.prepareStatement(sentencia);
		ps.setString(1,  registro.getId_documento());
		ps.setString(2,  registro.getId_oferente());
		ps.setString(3,  registro.getFecha_alta());
		ps.setString(4,  registro.getNombre_archivo());
		ps.setByte(5, registro.getArchivo());
		ps.setString(6,  registro.getTipo_archivo());
		return ps;

		       }
		   },
		   keyHolder);
		
		System.out.println(keyHolder.getKey()); 
		return (List<SolicitudOferenteExtraccionVo>) keyHolder.getKey();
		}


	
//
//	@Override
//	public List<SolicitudOferenteVo> guardarOferenteSolicitud(final SolicitudOferenteVo objeto) {
//		
//		StringBuilder sentencia = new StringBuilder ("INSERT INTO TBL_Documentos_Solicitud "+
//	  "(id_solicitud,id_oferente,fecha_alta,nombre_archivo,archivo ,tipo_archivo )");
//	
//		LOGGER.info(PREFIJO_LOG + "insersion" + sentencia);
//		
//		String criterios = generarCriteriosBusqueda(objeto);
//		if( criterios.length()>0 )
//			 sentencia.append(VALUES).append(criterios);
//		
//		sentencia.append(ESPACIO).append(")");
//		
//		try
//		{
//			LOGGER.debug(PREFIJO_LOG+ " Sentencia a ejecutar " + sentencia.toString());									
//		return this.jdbcVivienda.query(sentencia.toString(),new SolicitudOferenteExtractor());
//		}catch (EmptyResultDataAccessException e) {
//			return new ArrayList<SolicitudOferenteVo>();
//		}
//	}

	
	@Override
	public String generarCriteriosBusqueda(SolicitudOferenteExtraccionVo objeto) {
		StringBuilder criterios = new StringBuilder();
//		if( objeto.getId_documento() != null  )
//		
//		{
//				criterios.append("'20014002',");
//		}else
//		{
//			criterios.append("'20014004',");
//		}
//		if( objeto.getId_solicitud()!= null  )
//		
//		{
//			
//			criterios.append("'").append(objeto.getTipo_linea().trim()).append(COMILLA).append(",");
//		}else
//		{
//			criterios.append("'12',");
//		}
//		if( objeto.getId_oferente()!= null  )
//			
//		{	
//				
//			criterios.append("'").append(objeto.getFecha_solicitud().trim()).append(COMILLA).append(",");
//		}else
//		{
//			criterios.append("'2020-01-01 00:00:00 ',");
//		}
//			if( objeto.getNombre_archivo()== null  )
//			
//			{	
//					
//					criterios.append("' ',");
//			}else
//			{
//				criterios.append("' ',");
//			}
//				if( objeto.getArchivo()!= null  )
//				{
//					
//						
//					criterios.append("'").append(objeto.getId_tipo_solicitud().trim()).append(COMILLA).append(",");
//				}else
//				{
//					criterios.append("'15',");
//				}if( objeto.getTipo_archivo()!= null  )
//				{
//					
//						
//					criterios.append("'").append(objeto.getId_tipo_solicitud().trim()).append(COMILLA).append(",");
//				}else
//				{
//					criterios.append("'15',");
//				}
//				
//											
										

									
		
		
		  if( criterios==null || criterios.length()==0)
			  throw new IllegalArgumentException("No hay criterios para realizar búsqueda de ecotecnologias");
	
		return criterios.toString();
	}



	@Override
	public boolean guardarOferenteSolicitud(
			SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}


	
	@Override
	public int guardarOferenteSolicitudInt(final SolicitudOferenteExtraccionVo registro) {
		
		
		
		final String sentencia = "INSERT INTO TBL_Solicitudes_Oferente  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcVivienda.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conexion)throws SQLException {
				
				LOGGER.debug(PREFIJO_LOG+ " Sentencia a ejecutar " + sentencia.toString());	
				PreparedStatement ps = conexion.prepareStatement(sentencia);
				ps.setString(1,  registro.getId_solicitud());
				ps.setString(2,  registro.getTipo_linea());
				ps.setString(3,  registro.getFecha_solicitud());
				ps.setString(4,  registro.getFecha_respuesta());
				ps.setString(5,  registro.getId_estatus());
				ps.setString(6,  registro.getId_tipo_solicitud());
				ps.setString(7,  registro.getRfc_oferente());
				ps.setString(8,  registro.getId_estado());
				ps.setString(9,  registro.getId_oferente());
				ps.setString(10, registro.getNombre_razon_social());
				ps.setString(11, registro.getId_oferta_vivienda());
				ps.setString(12, registro.getId_orden_verificacion());
				ps.setString(13, registro.getNombre_frente());
				ps.setString(14, registro.getNum_viviendas());
				ps.setString(15, registro.getId_paquete());
				ps.setString(16, registro.getId_modificacion());
				ps.setString(17, registro.getNum_viviendas_declinacion_modificacion());
				ps.setString(18, registro.getComentarios());
				ps.setString(19, registro.getId_programa());
				return ps;
				
	        }
		    },
		    keyHolder);
		
		return keyHolder.getKey().intValue();
	}



	@Override
	public boolean updateSolicitud(SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}



	@Override
	public void guardarSolicitud(SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		
	}



	@Override
	public boolean guardar(String[] criterios) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}



	@Override
	public boolean guardarLista(List<SolicitudOferenteExtraccionVo> registros) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}



	@Override
	public List<SolicitudOferenteExtraccionVo> buscarLista(
			SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



	@Override
	public List<SolicitudOferenteExtraccionVo> buscarSolicitud(
			SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



	@Override
	public Set<SolicitudOferenteExtraccionVo> buscarUnicos(
			SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



	@Override
	public SolicitudOferenteExtraccionVo buscar(
			SolicitudOferenteExtraccionVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}



	@Override
	public String generarCriterios(SolicitudOferenteExtraccionVo registro,
			List<Object> parametros) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

							






}
