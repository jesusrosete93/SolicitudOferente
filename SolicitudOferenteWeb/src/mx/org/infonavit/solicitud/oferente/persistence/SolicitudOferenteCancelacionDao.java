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
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteIDVo;
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



@Repository("SolicitudOferenteCancelacionDao")
public class SolicitudOferenteCancelacionDao extends AbstractSolicitudOferenteDao<SolicitudOferenteVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudOferenteCancelacionDao.class);
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
	public String generarCriteriosBusqueda(SolicitudOferenteVo objeto) {
		StringBuilder criterios = new StringBuilder();
		if( objeto.getId_solicitud() != null  )
		
		{
				criterios.append("'20014008',");
		}else
		{
			criterios.append("'20014008',");
		}
		if( objeto.getTipo_linea()!= null  )
		
		{
			
			criterios.append("'").append(objeto.getTipo_linea().trim()).append(COMILLA).append(",");
		}else
		{
			criterios.append("'12',");
		}
		if( objeto.getFecha_solicitud()!= null  )
			
		{	
				
			criterios.append("'").append(objeto.getFecha_solicitud().trim()).append(COMILLA).append(",");
		}else
		{
			criterios.append("'2020-01-01 00:00:00 ',");
		}
			if( objeto.getFecha_respuesta()== null  )
			
			{	
					
					criterios.append("' ',");
			}else
			{
				criterios.append("' ',");
			}
				if( objeto.getId_tipo_solicitud()!= null  )
				{
					
						
					criterios.append("'").append(objeto.getId_tipo_solicitud().trim()).append(COMILLA).append(",");
				}else
				{
					criterios.append("'15',");
				}
				if( objeto.getId_estatus()!= null  )
				{
					
						
					criterios.append("'").append(objeto.getId_estatus().trim()).append(COMILLA).append(",");
				}else
				{
					criterios.append("'16',");
				}
					if( objeto.getId_estado()!= null  )
					{
						
							
						criterios.append("'").append(objeto.getId_estado().trim()).append(COMILLA).append(",");
					}else
					{
						criterios.append("'00',");
					}
					if( objeto.getId_oferente()!= null  )
					{
						
						criterios.append("'").append(objeto.getId_oferente().trim()).append(COMILLA).append(",");
					
					}else
					{
						criterios.append("'18',");
					}
						if( objeto.getRfc_oferente() != null  )
						{
							
								
							criterios.append("'").append(objeto.getRfc_oferente().trim()).append(COMILLA).append(",");
						}else
						{
							criterios.append("'19',");
						}
						if( objeto.getNombre_razon_social() != null  )
						{
							
							
								
							criterios.append("'").append(objeto.getNombre_razon_social().trim()).append(COMILLA).append(",");
						}else
						{
							criterios.append("'20',");
						}
							if( objeto.getId_oferta_vivienda()!= null  )
							{
								
									
								criterios.append("'").append(objeto.getId_oferta_vivienda().trim()).append(COMILLA).append(",");
							
							}else
							{
								criterios.append("'21',");
							}
							if( objeto.getId_orden_verificacion()!= null  )
							{
								
									
								criterios.append("'").append(objeto.getId_orden_verificacion().trim()).append(COMILLA).append(",");
							
							}else
							{
								criterios.append("'22',");
							}
								if( objeto.getNombre_frente()!= null  )
								{
									
										
									criterios.append("'").append(objeto.getNombre_frente().trim()).append(COMILLA).append(",");
								
								}else
								{
									criterios.append("'23',");
								}
								if( objeto.getNum_viviendas()!= null && !objeto.getNum_viviendas().trim().equals("")   )
								{
									
										
									criterios.append("'").append(objeto.getNum_viviendas().trim()).append(COMILLA).append(",");
								}else
								{
									criterios.append("'24',");
								}
								if( objeto.getId_paquete()!= null && !objeto.getId_paquete().trim().equals("")  )
								{
									
										
									criterios.append("'").append(objeto.getId_paquete().trim()).append(COMILLA).append(",");
								}else
								{
									criterios.append("'81',");
								}
								
									if( objeto.getId_modificacion()!= null  )
									{
										
											
										criterios.append("'").append(objeto.getId_modificacion().trim()).append(COMILLA).append(",");
									}else
									{
										criterios.append("'26',");
									}
									if( objeto.getNum_viviendas_declinacion_modificacion() != null && !objeto.getNum_viviendas_declinacion_modificacion().trim().equals("")  )
									{
	
										criterios.append("'").append(objeto.getNum_viviendas_declinacion_modificacion().trim()).append(COMILLA).append(",");
									}else
									{
										criterios.append("'27',");
									}
										if( objeto.getComentarios()!= null  )
										{
											
												
											criterios.append("'").append(objeto.getComentarios().trim()).append(COMILLA).append(",");
										
										}else
										{
											criterios.append("'28',");
										}
										if( objeto.getId_programa() != null  )
										
											
											{
												
											criterios.append("'").append(objeto.getId_programa().trim()).append(COMILLA).append(",");
										}else
										{
											criterios.append("''");
										}
											
										

									
		
		
		  if( criterios==null || criterios.length()==0)
			  throw new IllegalArgumentException("No hay criterios para realizar búsqueda de ecotecnologias");
	
		return criterios.toString();
	}

	


	@Override
	public List<SolicitudOferenteVo> buscarLista(SolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public Set<SolicitudOferenteVo> buscarUnicos(SolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public SolicitudOferenteVo buscar(SolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public String generarCriterios(SolicitudOferenteVo registro,
			List<Object> parametros) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void guardarSolicitud(SolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		
	}


	@Override
	public boolean guardarArchivos(String String) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}





	@Override
	public boolean guardar(String[] criterios) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}


	@Override
	public boolean guardarLista(final List<SolicitudOferenteVo> registros) {
		int registrado = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		final String sentencia = "INSERT INTO TBL_Solicitudes_Oferente VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatementCreator psc = new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conexion)throws SQLException {
				PreparedStatement ps = conexion.prepareStatement(sentencia);
				ps.setString(1, ((SolicitudOferenteVo) registros).getId_solicitud());
				ps.setString(2, ((SolicitudOferenteVo) registros).getTipo_linea());
				ps.setString(3, ((SolicitudOferenteVo) registros).getFecha_solicitud());
				ps.setString(4, ((SolicitudOferenteVo) registros).getFecha_respuesta());
				ps.setString(5, ((SolicitudOferenteVo) registros).getId_tipo_solicitud());
				ps.setString(6, ((SolicitudOferenteVo) registros).getId_estatus());
				ps.setString(7, ((SolicitudOferenteVo) registros).getId_estado());
				ps.setString(8, ((SolicitudOferenteVo) registros).getId_oferente());
				ps.setString(9, ((SolicitudOferenteVo) registros).getRfc_oferente());
				ps.setString(10, ((SolicitudOferenteVo) registros).getNombre_razon_social());
				ps.setString(11, ((SolicitudOferenteVo) registros).getId_oferta_vivienda());
				ps.setString(12, ((SolicitudOferenteVo) registros).getId_orden_verificacion());
				ps.setString(13, ((SolicitudOferenteVo) registros).getNombre_frente());
				ps.setString(14, ((SolicitudOferenteVo) registros).getNum_viviendas());
				ps.setString(15, ((SolicitudOferenteVo) registros).getId_paquete());
				ps.setString(16, ((SolicitudOferenteVo) registros).getId_modificacion());
				ps.setString(17, ((SolicitudOferenteVo) registros).getNum_viviendas_declinacion_modificacion());
				ps.setString(18, ((SolicitudOferenteVo) registros).getComentarios());
				ps.setString(19, ((SolicitudOferenteVo) registros).getId_programa());
				return ps;
				
				
			}};

		
			LOGGER.debug(PREFIJO_LOG+ " Sentencia a ejecutar " + sentencia.toString());	
			registrado = this.jdbcVivienda.update(psc,keyHolder);
			
			return registrado==1?true:false;
	}




	@Override
	public boolean guardarOferenteSolicitud(final SolicitudOferenteVo registro) {
		return false;
	}




	@Override
	public boolean updateSolicitud(SolicitudIDSolicitudOferenteVo registro) {
		int actualizados = 0;
		actualizados = this.jdbcVivienda.update  ("update TBL_Consecutivo_Solicitud set consecutivo = ? where anio = ? " +
				"and id_estado = ? and id_tipo_solicitud = ?",registro.getConsecutivo(), registro.getAnio (), registro.getId_estado(), registro.getId_tipo_solicitud ());
		return actualizados==1?true:false;
	}




	@Override
	public List<SolicitudOferenteVo> buscarSolicitud(SolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}




	@Override
	public int guardarOferenteSolicitudInt(final SolicitudOferenteIDVo registro) {
		
		
		
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
				ps.setString(5,  registro.getId_tipo_solicitud());
				ps.setString(6,  registro.getId_estatus());
				ps.setString(7,  registro.getId_estado());
				ps.setString(8,  registro.getId_oferente());
				ps.setString(9,  registro.getRfc_oferente());
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
		System.out.println("Quesry Executed Successfully");
		return keyHolder.getKey().intValue();
	}





}
