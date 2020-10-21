package mx.org.infonavit.solicitud.oferente.persistence;

import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
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

import mx.org.infonavit.solicitud.oferente.persistence.vo.ArchivoSolicitudOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteInexUvPaqueteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudIDSolicitudOferenteVo;
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



@Repository("SolicitudOferenteArchivosDao")
public class SolicitudOferenteArchivosDao extends AbstractSolicitudOferenteArchivosDao<ArchivoSolicitudOferenteVo> {
	
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudOferenteArchivosDao.class);
	private static final String PREFIJO_LOG = "[EcoTecCon] - ";
	

	@Override
	public boolean guardaArchivo(List<ArchivoSolicitudOferenteVo> registros) {

		int actualizados = 0;
		final String sentencia = "INSERT INTO TBL_Documentos_Solicitud  VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatementCreator psc = new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conexion)throws SQLException {
			PreparedStatement stmt = conexion.prepareStatement(sentencia);
			
			stmt.setString(1,  ((ArchivoSolicitudOferenteVo) stmt).getId_solicitud());	
			stmt.setString(2,  ((ArchivoSolicitudOferenteVo) stmt).getId_oferente());	
			stmt.setString(3,  ((ArchivoSolicitudOferenteVo) stmt).getFecha_alta());	
			stmt.setString(4,  ((ArchivoSolicitudOferenteVo) stmt).getNombre_archivo());	
			stmt.setString(5,  ((ArchivoSolicitudOferenteVo) stmt).getArchivo());	
			stmt.setString(6,  ((ArchivoSolicitudOferenteVo) stmt).getTipo_archivo());	

			return stmt;	
			
		}};
		
		
		return actualizados==1?true:false;
	}

	@Override
	public boolean updateSolicitud(SolicitudIDSolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		return false;
	}

	@Override
	public void guardarSolicitud(ArchivoSolicitudOferenteVo registro) {
		// TODO Apéndice de método generado automáticamente
		
	}
		

	
	




}
