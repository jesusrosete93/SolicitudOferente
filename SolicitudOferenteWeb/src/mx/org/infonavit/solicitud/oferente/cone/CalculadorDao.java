///*
// * Creado el 20/12/2010
// *
// * Para cambiar la plantilla para este archivo generado vaya a
// * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
// */
package mx.org.infonavit.solicitud.oferente.cone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.naming.NamingException;




//import mx.org.infonavit.reporteuvs.vo.Consultatotal;
//import mx.org.infonavit.reporteuvs.vo.ConsultatotalANDoferente;
//import mx.org.infonavit.reporteuvs.vo.Detalle_Avaluo;
//import mx.org.infonavit.reporteuvs.vo.Detalle_equipamiento_urbano;
//import mx.org.infonavit.reporteuvs.vo.Dtc;
//import mx.org.infonavit.reporteuvs.vo.Elementos_adicionales;
//import mx.org.infonavit.reporteuvs.vo.EstadoVO;
import mx.org.infonavit.solicitud.oferente.vo.AvaluosEstadosUnidadesVO;
import mx.org.infonavit.solicitud.oferente.vo.EstadosCerradosVo;
//import mx.org.infonavit.reporteuvs.vo.MesDatoVo;
//import mx.org.infonavit.reporteuvs.vo.PaqueteMaiVO;
//import mx.org.infonavit.reporteuvs.vo.PaqueteMaiVOANDoferente;
//import mx.org.infonavit.reporteuvs.vo.PaquetePrincipal;
//import mx.org.infonavit.reporteuvs.vo.UnidadesValuacionVO;
//import mx.org.infonavit.reporteuvs.vo.ViviendaVO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import com.ibm.ws.webservices.xml.waswebservices.parameter;
//
///**
// * @author LAPC
// * 
// *         Para cambiar la plantilla para este comentario de tipo generado vaya
// *         a Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y
// *         comentarios
// */
public class CalculadorDao {
	private static final Logger LOG = LogManager.getLogger("CalculadorDao");
//
//	
//	public String EstatuVivienda(int estatuVivienda) throws SQLException  {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		String sql = "select descripcion from cat_estatus where id_estatus='"+estatuVivienda+"'";
//		String resultado="";
//		System.out.println("el sql ya formado"+sql);
//		try {
//			System.out.println("empiesa el metodo a trbajar");
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			System.out.println("despues de conexion y antes del crearestatement");
//			stmnt = conexion.createStatement();
//			System.out.println(sql);
//			result = stmnt.executeQuery(sql);	
//			if (result != null){
//				if (result.next()) {
//			resultado = result.getString("descripcion");
//				}
//			}else{
//				System.out.println("algo esta mal");
//				resultado="sin estarus";
//			}
//		} catch (NamingException e) {
//			System.out.println("falla en algun momento");
//			LOG.debug("Error en CalculadorDao.tomarIdUv: " + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return resultado;
//	}
//	
//	public int existeAva(String idAvaluo)throws SQLException {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		String sql = "select COUNT(*) from avaluo with(nolock) where id_avaluo='"+idAvaluo+"'";
//		int resultado=0;
//		System.out.println("el sql ya formado"+sql);
//		try {
//			System.out.println("empiesa el metodo a trbajar");
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			System.out.println("despues de conexion y antes del crearestatement");
//			stmnt = conexion.createStatement();
//			System.out.println(sql);
//			result = stmnt.executeQuery(sql);	
//			if (result != null){
//				if (result.next()) {
//					resultado=result.getInt(1);
//				}
//			}else{
//				System.out.println("algo esta mal");
//				resultado=0;
//			}
//		} catch (NamingException e) {
//			System.out.println("falla en query Existe Avaluo");
//			LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return resultado;
//	}
//
//	public int ejecutaInsert(String insert) throws SQLException {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		Statement stmnt = null;
//		int result=0;
//		System.out.println("el sql ya formado"+insert);
//		try {
//			System.out.println("empiesa el metodo a trbajar");
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			System.out.println("despues de conexion y antes del crearestatement");
//			stmnt = conexion.createStatement();
//			result=stmnt.executeUpdate(insert);
//		} catch (NamingException e) {
//			System.out.println("falla en query insert pdf");
//			LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//		} finally {
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return result;
//	}
//	
//	
////	public List<DocumentoAvaluo> tomarIuvs(final String avaluo) throws SQLException {
////		ConexionAvaluosbd cone = null;
////		Connection conexion = null;
////		ResultSet result = null;
////		Statement stmnt = null;
////		String sql = "";
////		List<DocumentoAvaluo> lstuvs = null;
////		DocumentoAvaluo rst = null;
////		try {
////			cone = new ConexionAvaluosbd();
////			conexion = cone.getConexion();
////			stmnt = conexion.createStatement();
////			sql = "select id_registro, id_avaluo, id_documento, tipo_archivo, fecha_alta, observaciones " +
////					"from documentos_avaluo with(NOLOCK) " +
////					"where id_avaluo='"+avaluo+"'";
////			result = stmnt.executeQuery(sql);
////			lstuvs = new ArrayList<DocumentoAvaluo>();
////			while (result.next()) {
////				rst = new DocumentoAvaluo();
////				rst.setId_registro(result.getInt("id_registro"));
////				rst.setId_avaluo(result.getString("id_avaluo"));
////				rst.setId_documento(result.getInt("id_documento"));
////				rst.setTipo_archivo(result.getString("tipo_archivo"));
////				rst.setFecha_alta(result.getString("fecha_alta"));
////				rst.setObservaciones(result.getString("observaciones"));
////				lstuvs.add(rst);
////			}
////		} catch (NamingException e) {
////			LOG.debug("Error en CalculadorDao.tomarIuvs" + e.getMessage());
////		} finally {
////			result.close();
////			stmnt.close();
////			cone.close(conexion);
////		}
////
////		return lstuvs;
////	}
//	
//	
//	
//	public List<UnidadesValuacionVO> tomarIuvs() throws SQLException {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		String sql = "";
//		List<UnidadesValuacionVO> lstuvs = null;
//		UnidadesValuacionVO rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			sql = "select id_uv, descripcion, id_estatus from cat_uv with(NOLOCK) where descripcion != 'unidad antigua' and descripcion != ' ' and descripcion != 'Sin uv' order by descripcion ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<UnidadesValuacionVO>();
//			while (result.next()) {
//				rst = new UnidadesValuacionVO();
//				rst.setId_uv(result.getString("id_uv"));
//				rst.setDescripcion(result.getString("descripcion"));
//				rst.setId_estatus(result.getString("id_estatus"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	public List<EstadoVO> tomarEstados() throws SQLException {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		String sql = "";
//		List<EstadoVO> lstuvs = null;
//		EstadoVO rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<EstadoVO>();
//			while (result.next()) {
//				rst = new EstadoVO();
//				rst.setId_estado(result.getString("id_estado"));
//				rst.setEstado(result.getString("descripcion"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	public void inse(String insert) throws SQLException {
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		Statement stmnt = null;
//		int result=0;
//		//System.out.println("el sql ya formado"+insert);
//		try {
//			//System.out.println("empiesa el metodo a trbajar");
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			//System.out.println("despues de conexion y antes del crearestatement");
//			stmnt = conexion.createStatement();
//			result=stmnt.executeUpdate(insert);
//		} catch (NamingException e) {
//			System.out.println("falla en query insert pdf");
//			LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//		} finally {
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return;
//	}
//
//	public List<Consultatotal> datosSQL(String sql) throws SQLException{
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<Consultatotal> lstuvs = null;
//		Consultatotal rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<Consultatotal>();
//			while (result.next()) {
//				rst = new Consultatotal();
////				rst.setId_estado(result.getString("id_estado"));
//				rst.setD_clave_shf(result.getString("clave_shf"));
//				rst.setD_fecha_avaluo(result.getString("fecha_avaluo"));
//				rst.setA_id_avaluo(result.getString("id_avaluo"));
//				rst.setA_id_paquete(result.getString("id_paquete"));
//				rst.setA_id_uv(result.getString("id_uv"));
//				rst.setUv_descripcion(result.getString("descripcion"));
//				rst.setD_id_controlador_shf(result.getString("id_controlador_shf"));
//				rst.setC_paterno(result.getString("paterno"));
//				rst.setC_materno(result.getString("materno"));
//				rst.setC_nombre(result.getString("nombre"));
//				rst.setP_id_perito_shf(result.getString("id_perito_shf"));
//				rst.setP_paterno(result.getString("paterno"));
//				rst.setP_materno(result.getString("materno"));
//				rst.setP_nombre(result.getString("nombre"));
//				rst.setCalle(result.getString("calle"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setCp(result.getString("cp"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setTx_localidad(result.getString("tx_localidad"));
//				rst.setLote(result.getString("lote"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setD_longitud(result.getString("longitud"));
//				rst.setD_latitud(result.getString("latitud"));
//				rst.setD_altitud(result.getString("altitud"));
//				rst.setD_superficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//				rst.setD_superficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//				rst.setD_superficie_construida(result.getString("superficie_construida"));
//				rst.setD_superficie_accesorias(result.getString("superficie_accesorias"));
//				rst.setD_superficie_vendible(result.getString("superficie_vendible"));
//				rst.setD_valor_comparativo_total(result.getString("valor_comparativo_total"));
//				rst.setD_valor_comparativo_m2(result.getString("valor_comparativo_m2"));
//				rst.setD_valor_terreno_total(result.getString("valor_terreno_total"));
//				rst.setD_valor_terreno_m2(result.getString("valor_terreno_m2"));
//				rst.setD_valor_construccion_total(result.getString("valor_construccion_total"));
//				rst.setD_valor_construccion_m2(result.getString("valor_construccion_m2"));
//				rst.setD_valor_residual(result.getString("valor_residual"));
//				rst.setD_valor_hipotetico(result.getString("valor_hipotetico"));
//				rst.setD_valor_concluido(result.getString("valor_concluido"));
//				rst.setD_id_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//				rst.setD_edad_contruccion(result.getString("edad_contruccion"));
//				rst.setD_num_recamaras(result.getString("num_recamaras"));
//				rst.setD_num_banios(result.getString("num_banios"));
//				rst.setD_num_medios_banios(result.getString("num_medios_banios"));
//				rst.setD_num_estacionamiento(result.getString("num_estacionamiento"));
//				rst.setV_precio_venta(result.getString("precio_venta"));
//				rst.setV_nss(result.getString("nss"));
//				rst.setC_cuv(result.getString("cuv"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//	
//	
//	public List<ConsultatotalANDoferente> datosSQLOferente(String sql) throws SQLException{
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<ConsultatotalANDoferente> lstuvs = null;
//		ConsultatotalANDoferente rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<ConsultatotalANDoferente>();
//			while (result.next()) {
//				rst = new ConsultatotalANDoferente();
////				rst.setId_estado(result.getString("id_estado"));
//				rst.setD_clave_shf(result.getString("clave_shf"));
//				rst.setD_fecha_avaluo(result.getString("fecha_avaluo"));
//				rst.setA_id_avaluo(result.getString("id_avaluo"));
//				rst.setA_id_paquete(result.getString("id_paquete"));
//				rst.setA_id_uv(result.getString("id_uv"));
//				rst.setUv_descripcion(result.getString("descripcion"));
//				rst.setD_id_controlador_shf(result.getString("id_controlador_shf"));
//				rst.setC_paterno(result.getString("paterno"));
//				rst.setC_materno(result.getString("materno"));
//				rst.setC_nombre(result.getString("nombre"));
//				rst.setP_id_perito_shf(result.getString("id_perito_shf"));
//				rst.setP_paterno(result.getString("paterno"));
//				rst.setP_materno(result.getString("materno"));
//				rst.setP_nombre(result.getString("nombre"));
//				rst.setCalle(result.getString("calle"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setCp(result.getString("cp"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setTx_localidad(result.getString("tx_localidad"));
//				rst.setLote(result.getString("lote"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setD_longitud(result.getString("longitud"));
//				rst.setD_latitud(result.getString("latitud"));
//				rst.setD_altitud(result.getString("altitud"));
//				rst.setD_superficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//				rst.setD_superficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//				rst.setD_superficie_construida(result.getString("superficie_construida"));
//				rst.setD_superficie_accesorias(result.getString("superficie_accesorias"));
//				rst.setD_superficie_vendible(result.getString("superficie_vendible"));
//				rst.setD_valor_comparativo_total(result.getString("valor_comparativo_total"));
//				rst.setD_valor_comparativo_m2(result.getString("valor_comparativo_m2"));
//				rst.setD_valor_terreno_total(result.getString("valor_terreno_total"));
//				rst.setD_valor_terreno_m2(result.getString("valor_terreno_m2"));
//				rst.setD_valor_construccion_total(result.getString("valor_construccion_total"));
//				rst.setD_valor_construccion_m2(result.getString("valor_construccion_m2"));
//				rst.setD_valor_residual(result.getString("valor_residual"));
//				rst.setD_valor_hipotetico(result.getString("valor_hipotetico"));
//				rst.setD_valor_concluido(result.getString("valor_concluido"));
//				rst.setD_id_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//				rst.setD_edad_contruccion(result.getString("edad_contruccion"));
//				rst.setD_num_recamaras(result.getString("num_recamaras"));
//				rst.setD_num_banios(result.getString("num_banios"));
//				rst.setD_num_medios_banios(result.getString("num_medios_banios"));
//				rst.setD_num_estacionamiento(result.getString("num_estacionamiento"));
//				rst.setV_precio_venta(result.getString("precio_venta"));
//				rst.setV_nss(result.getString("nss"));
//				rst.setC_cuv(result.getString("cuv"));
//				rst.setRfc(result.getString("rfc"));
//				rst.setNombre_razon_social(result.getString("nombre_razon_social"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	public void eliminar(String user) throws SQLException {
//			ConexionAvaluosbd cone = null;
//			Connection conexion = null;
//			Statement stmnt = null;
//			ResultSet result=null;
//			String sql="delete paquete_isai_prueba where usuario='"+user+"'";
//			//System.out.println("el sql ya formado"+insert);
//			try {
//				//System.out.println("empiesa el metodo a trbajar");
//				cone = new ConexionAvaluosbd();
//				conexion = cone.getConexion();
//				//System.out.println("despues de conexion y antes del crearestatement");
//				stmnt = conexion.createStatement();
//				result=stmnt.executeQuery(sql);
//			} catch (NamingException e) {
//				System.out.println("falla en query insert pdf");
//				LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//			} finally {
//				stmnt.close();
//				cone.close(conexion);
//			}
//			return;
//		}
//
//	public List<PaqueteMaiVO> datosMaiSQL(String sql) throws SQLException{
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<PaqueteMaiVO> lstuvs = null;
//		PaqueteMaiVO rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<PaqueteMaiVO>();
//			while (result.next()) {
//				rst = new PaqueteMaiVO();
//				rst.setD_clave_shf(result.getString("clave_shf"));
//				rst.setD_fecha_avaluo(result.getString("fecha_avaluo"));
//				rst.setA_id_avaluo(result.getString("id_avaluo"));
//				rst.setA_id_paquete(result.getString("id_paquete"));
//				rst.setA_id_uv(result.getString("id_uv"));
//				rst.setUv_descripcion(result.getString("descripcion"));
//				rst.setD_id_controlador_shf(result.getString("id_controlador_shf"));
//				rst.setC_paterno(result.getString("paterno"));
//				rst.setC_materno(result.getString("materno"));
//				rst.setC_nombre(result.getString("nombre"));
//				rst.setP_id_perito_shf(result.getString("id_perito_shf"));
//				rst.setP_paterno(result.getString("paterno"));
//				rst.setP_materno(result.getString("materno"));
//				rst.setP_nombre(result.getString("nombre"));
//				rst.setCalle(result.getString("calle"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setCp(result.getString("cp"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setTx_localidad(result.getString("tx_localidad"));
//				rst.setLote(result.getString("lote"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setD_longitud(result.getString("longitud"));
//				rst.setD_latitud(result.getString("latitud"));
//				rst.setD_altitud(result.getString("altitud"));
//				rst.setD_superficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//				rst.setD_superficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//				rst.setD_superficie_construida(result.getString("superficie_construida"));
//				rst.setD_superficie_accesorias(result.getString("superficie_accesorias"));
//				rst.setD_superficie_vendible(result.getString("superficie_vendible"));
//				rst.setD_valor_comparativo_total(result.getString("valor_comparativo_total"));
//				rst.setD_valor_comparativo_m2(result.getString("valor_comparativo_m2"));
//				rst.setD_valor_terreno_total(result.getString("valor_terreno_total"));
//				rst.setD_valor_terreno_m2(result.getString("valor_terreno_m2"));
//				rst.setD_valor_construccion_total(result.getString("valor_construccion_total"));
//				rst.setD_valor_construccion_m2(result.getString("valor_construccion_m2"));
//				rst.setD_valor_residual(result.getString("valor_residual"));
//				rst.setD_valor_hipotetico(result.getString("valor_hipotetico"));
//				rst.setD_valor_concluido(result.getString("valor_concluido"));
//				rst.setD_id_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//				rst.setD_edad_contruccion(result.getString("edad_contruccion"));
//				rst.setD_num_recamaras(result.getString("num_recamaras"));
//				rst.setD_num_banios(result.getString("num_banios"));
//				rst.setD_num_medios_banios(result.getString("num_medios_banios"));
//				rst.setD_num_estacionamiento(result.getString("num_estacionamiento"));
//				rst.setV_precio_venta(result.getString("precio_venta"));
//				rst.setV_nss(result.getString("nss"));
//				rst.setC_cuv(result.getString("cuv"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//	
//	
//	public List<PaqueteMaiVOANDoferente> datosMaiSQLOferente(String sql) throws SQLException{
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<PaqueteMaiVOANDoferente> lstuvs = null;
//		PaqueteMaiVOANDoferente rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<PaqueteMaiVOANDoferente>();
//			while (result.next()) {
//				rst = new PaqueteMaiVOANDoferente();
//				rst.setD_clave_shf(result.getString("clave_shf"));
//				rst.setD_fecha_avaluo(result.getString("fecha_avaluo"));
//				rst.setA_id_avaluo(result.getString("id_avaluo"));
//				rst.setA_id_paquete(result.getString("id_paquete"));
//				rst.setA_id_uv(result.getString("id_uv"));
//				rst.setUv_descripcion(result.getString("descripcion"));
//				rst.setD_id_controlador_shf(result.getString("id_controlador_shf"));
//				rst.setC_paterno(result.getString("paterno"));
//				rst.setC_materno(result.getString("materno"));
//				rst.setC_nombre(result.getString("nombre"));
//				rst.setP_id_perito_shf(result.getString("id_perito_shf"));
//				rst.setP_paterno(result.getString("paterno"));
//				rst.setP_materno(result.getString("materno"));
//				rst.setP_nombre(result.getString("nombre"));
//				rst.setCalle(result.getString("calle"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setCp(result.getString("cp"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setTx_localidad(result.getString("tx_localidad"));
//				rst.setLote(result.getString("lote"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setD_longitud(result.getString("longitud"));
//				rst.setD_latitud(result.getString("latitud"));
//				rst.setD_altitud(result.getString("altitud"));
//				rst.setD_superficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//				rst.setD_superficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//				rst.setD_superficie_construida(result.getString("superficie_construida"));
//				rst.setD_superficie_accesorias(result.getString("superficie_accesorias"));
//				rst.setD_superficie_vendible(result.getString("superficie_vendible"));
//				rst.setD_valor_comparativo_total(result.getString("valor_comparativo_total"));
//				rst.setD_valor_comparativo_m2(result.getString("valor_comparativo_m2"));
//				rst.setD_valor_terreno_total(result.getString("valor_terreno_total"));
//				rst.setD_valor_terreno_m2(result.getString("valor_terreno_m2"));
//				rst.setD_valor_construccion_total(result.getString("valor_construccion_total"));
//				rst.setD_valor_construccion_m2(result.getString("valor_construccion_m2"));
//				rst.setD_valor_residual(result.getString("valor_residual"));
//				rst.setD_valor_hipotetico(result.getString("valor_hipotetico"));
//				rst.setD_valor_concluido(result.getString("valor_concluido"));
//				rst.setD_id_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//				rst.setD_edad_contruccion(result.getString("edad_contruccion"));
//				rst.setD_num_recamaras(result.getString("num_recamaras"));
//				rst.setD_num_banios(result.getString("num_banios"));
//				rst.setD_num_medios_banios(result.getString("num_medios_banios"));
//				rst.setD_num_estacionamiento(result.getString("num_estacionamiento"));
//				rst.setV_precio_venta(result.getString("precio_venta"));
//				rst.setV_nss(result.getString("nss"));
//				rst.setC_cuv(result.getString("cuv"));
//				rst.setRfc(result.getString("rfc"));
//				rst.setNombre_razon_social(result.getString("nombre_razon_social"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	public void CargaTemPa(String where, String user) throws SQLException{
//		// TODO Apéndice de método generado automáticamente
//		String sql;
//		
//		sql="select d.clave_shf, d.fecha_avaluo, a.id_avaluo, a.id_paquete, a.id_uv, uv.descripcion, d.id_controlador_shf, c.paterno as paternoControlador, c.materno as maternoControlador, c.nombre as nombreControlador,"
//			+"p.id_perito_shf, p.paterno, p.materno, p.nombre,rtrim ( v.calle ) as calle , rtrim ( v.condominio ) as condominio, rtrim ( v.cp ) as cp, rtrim ( v.edificio ) as edificio,"
//			+"rtrim ( v.entre_calle_1 ) as entre_calle_1, rtrim ( v.entre_calle_2 ) as entre_calle_2, substring(a.id_paquete,1,5) as localidad, rtrim ( m.tx_municipio ) as tx_localidad,"
//			+"rtrim ( v.lote ) as lote, rtrim ( v.manzana ) as manzana, rtrim ( v.nivel ) as nivel, d.longitud, d.latitud, d.altitud, d.superficie_terreno_conjunto,"
//			+"d.superficie_terreno_vivienda, d.superficie_construida, d.superficie_accesorias, d.superficie_vendible, d.valor_comparativo_total,"
//			+"d.valor_comparativo_m2, d.valor_terreno_total, d.valor_terreno_m2, d.valor_construccion_total, d.valor_construccion_m2, d.valor_residual, d.valor_hipotetico, d.valor_concluido,"
//			+"d.id_tipo_inmueble_valuado , d.edad_contruccion, d.num_recamaras, d.num_banios, d.num_medios_banios, d.num_estacionamiento, v.precio_venta, v.NSS, v.cuv, a.id_vivienda, a.id_tipo_mercado, a.tipo_linea "
//			+"into #Temppaqueteava"+user+" from avaluo as a with (nolock) "
//			+"left join detalle_avaluo as d with (nolock) on a.id_avaluo = d.id_avaluo "
//			+"left join cat_controlador as c with (nolock) on d.id_controlador_shf = c.id_controlador_shf "
//			+"left join cat_perito as p with (nolock) on d.id_perito_shf = p.id_perito_shf "
//			+"left join cat_uv as uv with (nolock) on a.id_uv = uv.id_uv "
//			+"left join vivienda as v with (nolock) on a.id_paquete = v.id_paquete and a.id_vivienda = v.id_vivienda "
//			+"left join municipio as m with (nolock) on substring (a.id_paquete,1,5) = m.cv_infonavit where a.id_tipo_mercado = '1' and "+where;
//	
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		Statement stmnt = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			System.out.println("sql: " +sql);
//			stmnt.executeUpdate(sql);
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return;
//		
//	}
//
//	public void CargaTemPaMai(String where, String user) throws SQLException{
//		// TODO Apéndice de método generado automáticamente
//	String sql;
//		
//		sql="select d.clave_shf, d.fecha_avaluo, a.id_avaluo, a.id_paquete, a.id_uv, uv.descripcion, d.id_controlador_shf,  c.paterno as paternoControlador, c.materno as maternoControlador, c.nombre as nombreControlador,"+
//			"p.id_perito_shf, p.paterno, p.materno, p.nombre, rtrim ( v.calle ) as calle , rtrim ( v.condominio ) as condominio, rtrim ( v.cp ) as cp, rtrim ( v.edificio ) as edificio, "+
//			"rtrim ( v.entre_calle_1 ) as entre_calle_1, rtrim ( v.entre_calle_2 ) as entre_calle_2, mai.id_municipio as localidad, rtrim ( m.tx_municipio ) as tx_localidad, "+
//			"rtrim ( v.lote ) as lote, rtrim ( v.manzana ) as manzana, rtrim ( v.nivel ) as nivel, d.longitud, d.latitud, d.altitud, d.superficie_terreno_conjunto, "+
//			"d.superficie_terreno_vivienda, d.superficie_construida, d.superficie_accesorias, d.superficie_vendible, d.valor_comparativo_total, "+
//			"d.valor_comparativo_m2, d.valor_terreno_total, d.valor_terreno_m2, d.valor_construccion_total, d.valor_construccion_m2, d.valor_residual, d.valor_hipotetico, d.valor_concluido, "+
//			"d.id_tipo_inmueble_valuado , d.edad_contruccion, d.num_recamaras, d.num_banios, d.num_medios_banios, d.num_estacionamiento, v.precio_venta, v.NSS, v.cuv, v.id_vivienda "+ 
//			"into #Temppaquetemaiava"+user+" from avaluo as a with (nolock) "+
//			"left join detalle_mai as mai with ( nolock ) on a.id_paquete = mai.id_paquete and a.id_vivienda = mai.id_vivienda "+
//			"left join vivienda as v with (nolock) on a.id_paquete = v.id_paquete and a.id_vivienda = v.id_vivienda "+
//			"left join detalle_avaluo as d with (nolock) on a.id_avaluo = d.id_avaluo "+
//			"left join municipio as m with (nolock) on mai.id_municipio = m.cv_infonavit "+
//			"left join cat_controlador as c with (nolock) on d.id_controlador_shf = c.id_controlador_shf "+
//			"left join cat_perito as p with (nolock) on d.id_perito_shf = p.id_perito_shf "+
//			"left join cat_uv as uv with (nolock) on a.id_uv = uv.id_uv where a.id_tipo_mercado = '2' and a.tipo_linea = 2 and "+where;
//	
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		Statement stmnt = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
//			System.out.println("sql: " +sql);
//			stmnt.executeUpdate(sql);
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return;
//		
//	}
//
//	public int cargarVariables(String sql, String user) throws SQLException{
//		// TODO Apéndice de método generado automáticamente
//		
//
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		int resultado = 0;
//		System.out.println("el sql ya formado"+sql);
//		try {
//			System.out.println("empiesa el metodo a trbajar");
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			System.out.println("despues de conexion y antes del crearestatement");
//			stmnt = conexion.createStatement();
//			System.out.println(sql+user);
//			result = stmnt.executeQuery(sql+user);	
//			if (result != null){
//				if (result.next()) {
//			resultado = result.getInt(1);
//				}
//			}else{
//				System.out.println("algo esta mal");
//				resultado=0;
//			}
//		} catch (NamingException e) {
//			System.out.println("falla en algun momento");
//			LOG.debug("Error en CalculadorDao.tomarIdUv: " + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return resultado;
//	}
//
//
//	public List<Detalle_equipamiento_urbano> llenaDetalle_equipamiento_urbano(List<Detalle_equipamiento_urbano> detalle_equipamiento_urbano,
//			String tabla) throws SQLException{
//		String sql="select d.id_equipamiento_urbano, d.id_avaluo, d.id_vivienda, d.id_paquete, d.distancia, r.id_tipo_mercado, r.tipo_linea from "+tabla+" as r left join detalle_equipamiento_urbano as d with (nolock) on r.id_avaluo = d.id_avaluo";
//		//sql="select * from "+tabla+"";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<Detalle_equipamiento_urbano> lstuvs = null;
//		Detalle_equipamiento_urbano rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			System.out.println("ejecuto el query");
//			lstuvs = new ArrayList<Detalle_equipamiento_urbano>();
//			while (result.next()) {
////				System.out.println("empiesa el llenado");
//				rst = new Detalle_equipamiento_urbano();
//				rst.setId_avaluo(result.getString("id_avaluo"));
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_vivienda(result.getString("id_vivienda"));
//				rst.setId_tipo_mercado(result.getString("id_tipo_mercado"));
//				rst.setId_equipamiento_urbano(result.getString("id_equipamiento_urbano"));
//				rst.setDistancia(result.getString("distancia"));
//				rst.setTipo_linea(result.getString("tipo_linea"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	public List<Detalle_equipamiento_urbano> llenaDetalle_equipamiento_urbanoMai(List<Detalle_equipamiento_urbano> detalle_equipamiento_urbano,
//			String tabla) throws SQLException{
//		String sql="select d.id_equipamiento_urbano, d.id_avaluo, d.id_vivienda, d.id_paquete, d.distancia from "+tabla+" as r left join detalle_equipamiento_urbano as d with (nolock) on r.id_avaluo = d.id_avaluo";
//		//sql="select * from "+tabla+"";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<Detalle_equipamiento_urbano> lstuvs = null;
//		Detalle_equipamiento_urbano rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			System.out.println("ejecuto el query");
//			lstuvs = new ArrayList<Detalle_equipamiento_urbano>();
//			while (result.next()) {
////				System.out.println("empiesa el llenado");
//				rst = new Detalle_equipamiento_urbano();
//				rst.setId_avaluo(result.getString("id_avaluo"));
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_vivienda(result.getString("id_vivienda"));
//				rst.setId_equipamiento_urbano(result.getString("id_equipamiento_urbano"));
//				rst.setDistancia(result.getString("distancia"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//
//		return lstuvs;
//	}
//
//	
//	public List<Elementos_adicionales> llenaElementos_adicionales(
//			List<Elementos_adicionales> elementos_adicionales, String tabla) throws SQLException{
//			String sql="select r.id_paquete, r.id_vivienda, r.id_tipo_mercado, r.tipo_linea, d.* from "+tabla+" as r left join elementos_adicionales as d with (nolock) on r.id_avaluo = d.id_avaluo";
//			ConexionAvaluosbd cone = null;
//			Connection conexion = null;
//			ResultSet result = null;
//			Statement stmnt = null;
//			List<Elementos_adicionales> lstuvs = null;
//			Elementos_adicionales rst = null;
//			System.out.println("antes de la ejecucion");
//			try {
//				cone = new ConexionAvaluosbd();
//				conexion = cone.getConexion();
//				stmnt = conexion.createStatement();
////				sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//				System.out.println("sql: " +sql);
//				result = stmnt.executeQuery(sql);
//				lstuvs = new ArrayList<Elementos_adicionales>();
//				while (result.next()) {
//					rst = new Elementos_adicionales();
//					rst.setId_avaluo(result.getString("id_avaluo"));
//					rst.setId_paquete(result.getString("id_paquete"));
//					rst.setId_vivienda(result.getString("id_vivienda"));
//					rst.setId_tipo_mercado(result.getString("id_tipo_mercado"));
//					rst.setTipo_linea(result.getString("tipo_linea"));
//					rst.setId_sist_desc_agua_residuales(result.getString("id_sist_desc_agua_residuales"));
//					rst.setId_tratamiento_agua(result.getString("id_tratamiento_agua"));
//					rst.setId_sist_reuso_agua_restratada(result.getString("id_sist_reuso_agua_restratada"));
//					rst.setId_trat_reut_aguas_jabonosas(result.getString("id_trat_reut_aguas_jabonosas"));
//					rst.setId_sist_reuso_agua_jabonosa(result.getString("id_sist_reuso_agua_jabonosa"));
//					rst.setId_captacion_agua_pluvial(result.getString("id_captacion_agua_pluvial"));
//					rst.setId_separacion_basura(result.getString("id_separacion_basura"));
//					rst.setId_cont_elab_composta(result.getString("id_cont_elab_composta"));
//					rst.setId_foto_alumbrado_publico(result.getString("id_foto_alumbrado_publico"));
//					rst.setId_red_agua_purificada(result.getString("id_red_agua_purificada"));
//					rst.setId_sen_braile_numonom_edificio(result.getString("id_sen_braile_numonom_edificio"));
//					rst.setId_senbraile_calle_inter(result.getString("id_senbraile_calle_inter"));
//					rst.setId_num_piso_inc_fin_barandal(result.getString("id_num_piso_inc_fin_barandal"));
//					rst.setId_num_depto_por_piso(result.getString("id_num_depto_por_piso"));
//					rst.setId_boton_eleva_braile(result.getString("id_boton_eleva_braile"));
//					rst.setOtro_tipo_insta_conjunto(result.getString("otro_tipo_insta_conjunto"));
//					rst.setId_wc_economiza_agua_seis(result.getString("id_wc_economiza_agua_seis"));
//					rst.setId_wc_economiza_agua_cinco(result.getString("id_wc_economiza_agua_cinco"));
//					rst.setId_wc_economiza_agua_cuatro(result.getString("id_wc_economiza_agua_cuatro"));
//					rst.setId_econo_agua_doble_boton(result.getString("id_econo_agua_doble_boton"));
//					rst.setId_regadera_ahorra_agua(result.getString("id_regadera_ahorra_agua"));
//					rst.setId_sen_braile_agua_fria_cal_regadera(result.getString("id_sen_braile_agua_fria_cal_regadera"));
//					rst.setId_regadera_ahorra_agua_banio(result.getString("id_regadera_ahorra_agua_banio"));
//					rst.setId_sen_braile_agua_fria_cal_banio(result.getString("id_sen_braile_agua_fria_cal_banio"));
//					rst.setId_regadera_ahorra_agua_cocina(result.getString("id_regadera_ahorra_agua_cocina"));
//					rst.setId_sen_braile_agua_fria_cal_cocina(result.getString("id_sen_braile_agua_fria_cal_cocina"));
//					rst.setId_calentador_gas(result.getString("id_calentador_gas"));
//					rst.setId_calentador_paso(result.getString("id_calentador_paso"));
//					rst.setId_sen_braile_enciende_apaga_boiler(result.getString("id_sen_braile_enciende_apaga_boiler"));
//					rst.setId_calentador_solar(result.getString("id_calentador_solar"));
//					rst.setId_aire_acondicionado(result.getString("id_aire_acondicionado"));
//					rst.setId_braile_aire_acondicionado(result.getString("id_braile_aire_acondicionado"));
//					rst.setId_ubica_aire_acondicionado(result.getString("id_ubica_aire_acondicionado"));
//					rst.setId_aislan_termico_techo_nommx(result.getString("id_aislan_termico_techo_nommx"));
//					rst.setId_aislante_rmicomurofide(result.getString("id_aislante_rmicomurofide"));
//					rst.setId_aislan_termico_puerta_ventana(result.getString("id_aislan_termico_puerta_ventana"));
//					rst.setId_sist_encendido_luces(result.getString("id_sist_encendido_luces"));
//					rst.setId_captacion_energia(result.getString("id_captacion_energia"));
//					rst.setId_voz_datos_internet(result.getString("id_voz_datos_internet"));
//					rst.setId_sumin_agua_purificada(result.getString("id_sumin_agua_purificada"));
//					rst.setId_interfon(result.getString("id_interfon"));
//					rst.setId_circuitos_electricidad(result.getString("id_circuitos_electricidad"));
//					rst.setId_protec_solar_ventana(result.getString("id_protec_solar_ventana"));
//					rst.setInstalacion_especial_vivienda_otro(result.getString("instalacion_especial_vivienda_otro"));
//					rst.setId_caseta_vigilancia(result.getString("id_caseta_vigilancia"));
//					rst.setId_locales_comerciales(result.getString("id_locales_comerciales"));
//					rst.setId_barda_perimetral(result.getString("id_barda_perimetral"));
//					rst.setId_elevador(result.getString("id_elevador"));
//					rst.setId_estacionamiento_techado(result.getString("id_estacionamiento_techado"));
//					rst.setId_estacionamiento_visitas(result.getString("id_estacionamiento_visitas"));
//					rst.setId_estacionamiento_discapacitados(result.getString("id_estacionamiento_discapacitados"));
//					rst.setId_rampa_banqueta_discapacitados(result.getString("id_rampa_banqueta_discapacitados"));
//					rst.setId_juegos_infantiles(result.getString("id_juegos_infantiles"));
//					rst.setId_canchas_deportivas(result.getString("id_canchas_deportivas"));
//					rst.setOtro_tipo_obras_complementarias(result.getString("otro_tipo_obras_complementarias"));
//					rst.setId_estacionamiento_techado_vivienda(result.getString("id_estacionamiento_techado_vivienda"));
//					rst.setId_rampa_acceso_interior_vivienda(result.getString("id_rampa_acceso_interior_vivienda"));
//					rst.setId_textura_especial_piso(result.getString("id_textura_especial_piso"));
//					rst.setId_accesoria(result.getString("id_accesoria"));
//					rst.setId_cisterna(result.getString("id_cisterna"));
//					rst.setId_ducto_clima(result.getString("id_ducto_clima"));
//					rst.setId_jaula_tendido(result.getString("id_jaula_tendido"));
//					rst.setId_rejas_proteccion_ventanas(result.getString("id_rejas_proteccion_ventanas"));
//					rst.setId_banio_discapacitados(result.getString("id_banio_discapacitados"));
//					rst.setId_banio_discapacitados_plantabaja(result.getString("id_banio_discapacitados_plantabaja"));
//					rst.setId_banio_discapacitados_regadera_sardinel(result.getString("id_banio_discapacitados_regadera_sardinel"));
//					rst.setId_banio_discapacitados_piso_antiderrapante(result.getString("id_banio_discapacitados_piso_antiderrapante"));
//					rst.setId_banio_discapacitados_charola_regadera(result.getString("id_banio_discapacitados_charola_regadera"));
//					rst.setId_banio_discapacitados_pendiente_rejilla_captacion(result.getString("id_banio_discapacitados_pendiente_rejilla_captacion"));
//					rst.setId_banio_discapacitados_salida_regadera_telefono(result.getString("id_banio_discapacitados_salida_regadera_telefono"));
//					rst.setId_banio_discapacitados_adecuar_lavabo(result.getString("id_banio_discapacitados_adecuar_lavabo"));
//					rst.setId_banio_discapacitados_maneral_palanca(result.getString("id_banio_discapacitados_maneral_palanca"));
//					rst.setId_cocina_discapacitados_adecuar_tarja(result.getString("id_cocina_discapacitados_adecuar_tarja"));
//					rst.setId_marco_movible_discapacitados(result.getString("id_marco_movible_discapacitados"));
//					rst.setId_banio_discapacitados_colocacion_espejo(result.getString("id_banio_discapacitados_colocacion_espejo"));
//					rst.setId_banio_discapacitados_pasamanos(result.getString("id_banio_discapacitados_pasamanos"));
//					rst.setId_banio_discapacitados_areas_circulacion(result.getString("id_banio_discapacitados_areas_circulacion"));
//					rst.setId_pasillos(result.getString("id_pasillos"));
//					rst.setId_cocina(result.getString("id_cocina"));
//					rst.setId_banio(result.getString("id_banio"));
//					rst.setId_recamara(result.getString("id_recamara"));
//					rst.setId_accesos_vivienda_puerta(result.getString("id_accesos_vivienda_puerta"));
//					rst.setId_accesos_espacios_interiores(result.getString("id_accesos_espacios_interiores"));
//					rst.setOtro_tipo_obras_complementarias_vivienda(result.getString("otro_tipo_obras_complementarias_vivienda"));
//					rst.setId_drenaje_pretratado_aguas_negras(result.getString("id_drenaje_pretratado_aguas_negras"));
//					rst.setId_captacion_solar_calentamiento_agua(result.getString("id_captacion_solar_calentamiento_agua"));
//					rst.setId_reductor_sedimentos_calcificados_conjunto(result.getString("id_reductor_sedimentos_calcificados_conjunto"));
//					rst.setId_camaras_seguridad(result.getString("id_camaras_seguridad"));
//					rst.setId_doble_descarga_inodoro_normal(result.getString("id_doble_descarga_inodoro_normal"));
//					rst.setId_llaves_ahorro_agua_lavabos_banio(result.getString("id_llaves_ahorro_agua_lavabos_banio"));
//					rst.setId_reduccion_flujo_llaves_lavabo(result.getString("id_reduccion_flujo_llaves_lavabo"));
//					rst.setId_regadera_ahorrador_integrado(result.getString("id_regadera_ahorrador_integrado"));
//					rst.setId_reduccion_flujo_llave_cocina(result.getString("id_reduccion_flujo_llave_cocina"));
//					rst.setId_valvula_regula_flujo_suministro(result.getString("id_valvula_regula_flujo_suministro"));
//					rst.setId_captacion_agua_pluvial_vivienda(result.getString("id_captacion_agua_pluvial_vivienda"));
//					rst.setId_calentador_solar_tubos_evacuados(result.getString("id_calentador_solar_tubos_evacuados"));
//					rst.setId_calentador_solar_tubos_respaldo_gas(result.getString("id_calentador_solar_tubos_respaldo_gas"));
//					rst.setId_calentador_solar_plano_respaldo_gas_paso(result.getString("id_calentador_solar_plano_respaldo_gas_paso"));
//					rst.setId_calentador_solar_tubos_respaldo_electrico(result.getString("id_calentador_solar_tubos_respaldo_electrico"));
//					rst.setId_calentador_solar_plano_respaldo_electrico(result.getString("id_calentador_solar_plano_respaldo_electrico"));
//					rst.setId_ventilador_solar_corriente_directa(result.getString("id_ventilador_solar_corriente_directa"));
//					rst.setId_ventilador_solar_corriente_alterna(result.getString("id_ventilador_solar_corriente_alterna"));
//					rst.setId_ventilador_cuerda_alta_potencia(result.getString("id_ventilador_cuerda_alta_potencia"));
//					rst.setId_ventilador_cuerda_baja_potencia(result.getString("id_ventilador_cuerda_baja_potencia"));
//					rst.setId_focos_ahorradores(result.getString("id_focos_ahorradores"));
//					rst.setId_focos_led_luz_dirigida(result.getString("id_focos_led_luz_dirigida"));
//					rst.setId_focos_led_luz_difusa(result.getString("id_focos_led_luz_difusa"));
//					rst.setId_iluminacion_natural(result.getString("id_iluminacion_natural"));
//					rst.setId_estabilizador_estatico(result.getString("id_estabilizador_estatico"));
//					rst.setId_dispositivo_ahorrador_gas(result.getString("id_dispositivo_ahorrador_gas"));
//					rst.setId_mantenimiento_contratado_desarrollador(result.getString("id_mantenimiento_contratado_desarrollador"));
//					rst.setId_filtros_purificadores_agua(result.getString("id_filtros_purificadores_agua"));
//					rst.setId_desinfeccion_agua_tinaco(result.getString("id_desinfeccion_agua_tinaco"));
//					rst.setId_reductor_sedimentos_calcificados_vivienda(result.getString("id_reductor_sedimentos_calcificados_vivienda"));
//					rst.setId_pintura_reflejante_techo(result.getString("id_pintura_reflejante_techo"));
//					rst.setId_pintura_reflejante_muro(result.getString("id_pintura_reflejante_muro"));
//					rst.setId_aislante_tuberia(result.getString("id_aislante_tuberia"));
//					rst.setId_tuberia_termica(result.getString("id_tuberia_termica"));
//					rst.setId_pintura_fotocatalitica(result.getString("id_pintura_fotocatalitica"));
//					rst.setId_doble_vidrio_ventanas(result.getString("id_doble_vidrio_ventanas"));
//					rst.setId_vidrios_pelicula_reflectiva(result.getString("id_vidrios_pelicula_reflectiva"));
//					rst.setId_vidrios_dobles_marco_pvc(result.getString("id_vidrios_dobles_marco_pvc"));
//					rst.setId_vidrios_pelicula_reflectiva_marcos_pvc(result.getString("id_vidrios_pelicula_reflectiva_marcos_pvc"));
//					rst.setId_hidromaceteros(result.getString("id_hidromaceteros"));
//					rst.setNum_hidromaceteros(result.getString("num_hidromaceteros"));
//					rst.setId_optimizador_tension_electrica(result.getString("id_optimizador_tension_electrica"));
//					lstuvs.add(rst);
//				}
//			} catch (NamingException e) {
//				LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//			} finally {
//				result.close();
//				stmnt.close();
//				cone.close(conexion);
//			}
//
//			return lstuvs;
//		}
//
//	public List<Elementos_adicionales> llenaElementos_adicionalesMai(
//			List<Elementos_adicionales> elementos_adicionales, String tabla) throws SQLException{
//			String sql="select r.id_paquete, r.id_vivienda, d.* from "+tabla+" as r left join elementos_adicionales as d with (nolock) on r.id_avaluo = d.id_avaluo";
//			ConexionAvaluosbd cone = null;
//			Connection conexion = null;
//			ResultSet result = null;
//			Statement stmnt = null;
//			List<Elementos_adicionales> lstuvs = null;
//			Elementos_adicionales rst = null;
//			System.out.println("antes de la ejecucion");
//			try {
//				cone = new ConexionAvaluosbd();
//				conexion = cone.getConexion();
//				stmnt = conexion.createStatement();
////				sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//				System.out.println("sql: " +sql);
//				result = stmnt.executeQuery(sql);
//				lstuvs = new ArrayList<Elementos_adicionales>();
//				while (result.next()) {
//					rst = new Elementos_adicionales();
//					rst.setId_avaluo(result.getString("id_avaluo"));
//					rst.setId_paquete(result.getString("id_paquete"));
//					rst.setId_vivienda(result.getString("id_vivienda"));
//					rst.setId_sist_desc_agua_residuales(result.getString("id_sist_desc_agua_residuales"));
//					rst.setId_tratamiento_agua(result.getString("id_tratamiento_agua"));
//					rst.setId_sist_reuso_agua_restratada(result.getString("id_sist_reuso_agua_restratada"));
//					rst.setId_trat_reut_aguas_jabonosas(result.getString("id_trat_reut_aguas_jabonosas"));
//					rst.setId_sist_reuso_agua_jabonosa(result.getString("id_sist_reuso_agua_jabonosa"));
//					rst.setId_captacion_agua_pluvial(result.getString("id_captacion_agua_pluvial"));
//					rst.setId_separacion_basura(result.getString("id_separacion_basura"));
//					rst.setId_cont_elab_composta(result.getString("id_cont_elab_composta"));
//					rst.setId_foto_alumbrado_publico(result.getString("id_foto_alumbrado_publico"));
//					rst.setId_red_agua_purificada(result.getString("id_red_agua_purificada"));
//					rst.setId_sen_braile_numonom_edificio(result.getString("id_sen_braile_numonom_edificio"));
//					rst.setId_senbraile_calle_inter(result.getString("id_senbraile_calle_inter"));
//					rst.setId_num_piso_inc_fin_barandal(result.getString("id_num_piso_inc_fin_barandal"));
//					rst.setId_num_depto_por_piso(result.getString("id_num_depto_por_piso"));
//					rst.setId_boton_eleva_braile(result.getString("id_boton_eleva_braile"));
//					rst.setOtro_tipo_insta_conjunto(result.getString("otro_tipo_insta_conjunto"));
//					rst.setId_wc_economiza_agua_seis(result.getString("id_wc_economiza_agua_seis"));
//					rst.setId_wc_economiza_agua_cinco(result.getString("id_wc_economiza_agua_cinco"));
//					rst.setId_wc_economiza_agua_cuatro(result.getString("id_wc_economiza_agua_cuatro"));
//					rst.setId_econo_agua_doble_boton(result.getString("id_econo_agua_doble_boton"));
//					rst.setId_regadera_ahorra_agua(result.getString("id_regadera_ahorra_agua"));
//					rst.setId_sen_braile_agua_fria_cal_regadera(result.getString("id_sen_braile_agua_fria_cal_regadera"));
//					rst.setId_regadera_ahorra_agua_banio(result.getString("id_regadera_ahorra_agua_banio"));
//					rst.setId_sen_braile_agua_fria_cal_banio(result.getString("id_sen_braile_agua_fria_cal_banio"));
//					rst.setId_regadera_ahorra_agua_cocina(result.getString("id_regadera_ahorra_agua_cocina"));
//					rst.setId_sen_braile_agua_fria_cal_cocina(result.getString("id_sen_braile_agua_fria_cal_cocina"));
//					rst.setId_calentador_gas(result.getString("id_calentador_gas"));
//					rst.setId_calentador_paso(result.getString("id_calentador_paso"));
//					rst.setId_sen_braile_enciende_apaga_boiler(result.getString("id_sen_braile_enciende_apaga_boiler"));
//					rst.setId_calentador_solar(result.getString("id_calentador_solar"));
//					rst.setId_aire_acondicionado(result.getString("id_aire_acondicionado"));
//					rst.setId_braile_aire_acondicionado(result.getString("id_braile_aire_acondicionado"));
//					rst.setId_ubica_aire_acondicionado(result.getString("id_ubica_aire_acondicionado"));
//					rst.setId_aislan_termico_techo_nommx(result.getString("id_aislan_termico_techo_nommx"));
//					rst.setId_aislante_rmicomurofide(result.getString("id_aislante_rmicomurofide"));
//					rst.setId_aislan_termico_puerta_ventana(result.getString("id_aislan_termico_puerta_ventana"));
//					rst.setId_sist_encendido_luces(result.getString("id_sist_encendido_luces"));
//					rst.setId_captacion_energia(result.getString("id_captacion_energia"));
//					rst.setId_voz_datos_internet(result.getString("id_voz_datos_internet"));
//					rst.setId_sumin_agua_purificada(result.getString("id_sumin_agua_purificada"));
//					rst.setId_interfon(result.getString("id_interfon"));
//					rst.setId_circuitos_electricidad(result.getString("id_circuitos_electricidad"));
//					rst.setId_protec_solar_ventana(result.getString("id_protec_solar_ventana"));
//					rst.setInstalacion_especial_vivienda_otro(result.getString("instalacion_especial_vivienda_otro"));
//					rst.setId_caseta_vigilancia(result.getString("id_caseta_vigilancia"));
//					rst.setId_locales_comerciales(result.getString("id_locales_comerciales"));
//					rst.setId_barda_perimetral(result.getString("id_barda_perimetral"));
//					rst.setId_elevador(result.getString("id_elevador"));
//					rst.setId_estacionamiento_techado(result.getString("id_estacionamiento_techado"));
//					rst.setId_estacionamiento_visitas(result.getString("id_estacionamiento_visitas"));
//					rst.setId_estacionamiento_discapacitados(result.getString("id_estacionamiento_discapacitados"));
//					rst.setId_rampa_banqueta_discapacitados(result.getString("id_rampa_banqueta_discapacitados"));
//					rst.setId_juegos_infantiles(result.getString("id_juegos_infantiles"));
//					rst.setId_canchas_deportivas(result.getString("id_canchas_deportivas"));
//					rst.setOtro_tipo_obras_complementarias(result.getString("otro_tipo_obras_complementarias"));
//					rst.setId_estacionamiento_techado_vivienda(result.getString("id_estacionamiento_techado_vivienda"));
//					rst.setId_rampa_acceso_interior_vivienda(result.getString("id_rampa_acceso_interior_vivienda"));
//					rst.setId_textura_especial_piso(result.getString("id_textura_especial_piso"));
//					rst.setId_accesoria(result.getString("id_accesoria"));
//					rst.setId_cisterna(result.getString("id_cisterna"));
//					rst.setId_ducto_clima(result.getString("id_ducto_clima"));
//					rst.setId_jaula_tendido(result.getString("id_jaula_tendido"));
//					rst.setId_rejas_proteccion_ventanas(result.getString("id_rejas_proteccion_ventanas"));
//					rst.setId_banio_discapacitados(result.getString("id_banio_discapacitados"));
//					rst.setId_banio_discapacitados_plantabaja(result.getString("id_banio_discapacitados_plantabaja"));
//					rst.setId_banio_discapacitados_regadera_sardinel(result.getString("id_banio_discapacitados_regadera_sardinel"));
//					rst.setId_banio_discapacitados_piso_antiderrapante(result.getString("id_banio_discapacitados_piso_antiderrapante"));
//					rst.setId_banio_discapacitados_charola_regadera(result.getString("id_banio_discapacitados_charola_regadera"));
//					rst.setId_banio_discapacitados_pendiente_rejilla_captacion(result.getString("id_banio_discapacitados_pendiente_rejilla_captacion"));
//					rst.setId_banio_discapacitados_salida_regadera_telefono(result.getString("id_banio_discapacitados_salida_regadera_telefono"));
//					rst.setId_banio_discapacitados_adecuar_lavabo(result.getString("id_banio_discapacitados_adecuar_lavabo"));
//					rst.setId_banio_discapacitados_maneral_palanca(result.getString("id_banio_discapacitados_maneral_palanca"));
//					rst.setId_cocina_discapacitados_adecuar_tarja(result.getString("id_cocina_discapacitados_adecuar_tarja"));
//					rst.setId_marco_movible_discapacitados(result.getString("id_marco_movible_discapacitados"));
//					rst.setId_banio_discapacitados_colocacion_espejo(result.getString("id_banio_discapacitados_colocacion_espejo"));
//					rst.setId_banio_discapacitados_pasamanos(result.getString("id_banio_discapacitados_pasamanos"));
//					rst.setId_banio_discapacitados_areas_circulacion(result.getString("id_banio_discapacitados_areas_circulacion"));
//					rst.setId_pasillos(result.getString("id_pasillos"));
//					rst.setId_cocina(result.getString("id_cocina"));
//					rst.setId_banio(result.getString("id_banio"));
//					rst.setId_recamara(result.getString("id_recamara"));
//					rst.setId_accesos_vivienda_puerta(result.getString("id_accesos_vivienda_puerta"));
//					rst.setId_accesos_espacios_interiores(result.getString("id_accesos_espacios_interiores"));
//					rst.setOtro_tipo_obras_complementarias_vivienda(result.getString("otro_tipo_obras_complementarias_vivienda"));
//					rst.setId_drenaje_pretratado_aguas_negras(result.getString("id_drenaje_pretratado_aguas_negras"));
//					rst.setId_captacion_solar_calentamiento_agua(result.getString("id_captacion_solar_calentamiento_agua"));
//					rst.setId_reductor_sedimentos_calcificados_conjunto(result.getString("id_reductor_sedimentos_calcificados_conjunto"));
//					rst.setId_camaras_seguridad(result.getString("id_camaras_seguridad"));
//					rst.setId_doble_descarga_inodoro_normal(result.getString("id_doble_descarga_inodoro_normal"));
//					rst.setId_llaves_ahorro_agua_lavabos_banio(result.getString("id_llaves_ahorro_agua_lavabos_banio"));
//					rst.setId_reduccion_flujo_llaves_lavabo(result.getString("id_reduccion_flujo_llaves_lavabo"));
//					rst.setId_regadera_ahorrador_integrado(result.getString("id_regadera_ahorrador_integrado"));
//					rst.setId_reduccion_flujo_llave_cocina(result.getString("id_reduccion_flujo_llave_cocina"));
//					rst.setId_valvula_regula_flujo_suministro(result.getString("id_valvula_regula_flujo_suministro"));
//					rst.setId_captacion_agua_pluvial_vivienda(result.getString("id_captacion_agua_pluvial_vivienda"));
//					rst.setId_calentador_solar_tubos_evacuados(result.getString("id_calentador_solar_tubos_evacuados"));
//					rst.setId_calentador_solar_tubos_respaldo_gas(result.getString("id_calentador_solar_tubos_respaldo_gas"));
//					rst.setId_calentador_solar_plano_respaldo_gas_paso(result.getString("id_calentador_solar_plano_respaldo_gas_paso"));
//					rst.setId_calentador_solar_tubos_respaldo_electrico(result.getString("id_calentador_solar_tubos_respaldo_electrico"));
//					rst.setId_calentador_solar_plano_respaldo_electrico(result.getString("id_calentador_solar_plano_respaldo_electrico"));
//					rst.setId_ventilador_solar_corriente_directa(result.getString("id_ventilador_solar_corriente_directa"));
//					rst.setId_ventilador_solar_corriente_alterna(result.getString("id_ventilador_solar_corriente_alterna"));
//					rst.setId_ventilador_cuerda_alta_potencia(result.getString("id_ventilador_cuerda_alta_potencia"));
//					rst.setId_ventilador_cuerda_baja_potencia(result.getString("id_ventilador_cuerda_baja_potencia"));
//					rst.setId_focos_ahorradores(result.getString("id_focos_ahorradores"));
//					rst.setId_focos_led_luz_dirigida(result.getString("id_focos_led_luz_dirigida"));
//					rst.setId_focos_led_luz_difusa(result.getString("id_focos_led_luz_difusa"));
//					rst.setId_iluminacion_natural(result.getString("id_iluminacion_natural"));
//					rst.setId_estabilizador_estatico(result.getString("id_estabilizador_estatico"));
//					rst.setId_dispositivo_ahorrador_gas(result.getString("id_dispositivo_ahorrador_gas"));
//					rst.setId_mantenimiento_contratado_desarrollador(result.getString("id_mantenimiento_contratado_desarrollador"));
//					rst.setId_filtros_purificadores_agua(result.getString("id_filtros_purificadores_agua"));
//					rst.setId_desinfeccion_agua_tinaco(result.getString("id_desinfeccion_agua_tinaco"));
//					rst.setId_reductor_sedimentos_calcificados_vivienda(result.getString("id_reductor_sedimentos_calcificados_vivienda"));
//					rst.setId_pintura_reflejante_techo(result.getString("id_pintura_reflejante_techo"));
//					rst.setId_pintura_reflejante_muro(result.getString("id_pintura_reflejante_muro"));
//					rst.setId_aislante_tuberia(result.getString("id_aislante_tuberia"));
//					rst.setId_tuberia_termica(result.getString("id_tuberia_termica"));
//					rst.setId_pintura_fotocatalitica(result.getString("id_pintura_fotocatalitica"));
//					rst.setId_doble_vidrio_ventanas(result.getString("id_doble_vidrio_ventanas"));
//					rst.setId_vidrios_pelicula_reflectiva(result.getString("id_vidrios_pelicula_reflectiva"));
//					rst.setId_vidrios_dobles_marco_pvc(result.getString("id_vidrios_dobles_marco_pvc"));
//					rst.setId_vidrios_pelicula_reflectiva_marcos_pvc(result.getString("id_vidrios_pelicula_reflectiva_marcos_pvc"));
//					rst.setId_hidromaceteros(result.getString("id_hidromaceteros"));
//					rst.setNum_hidromaceteros(result.getString("num_hidromaceteros"));
//					rst.setId_optimizador_tension_electrica(result.getString("id_optimizador_tension_electrica"));
//					lstuvs.add(rst);
//				}
//			} catch (NamingException e) {
//				LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//			} finally {
//				result.close();
//				stmnt.close();
//				cone.close(conexion);
//			}
//
//			return lstuvs;
//		}
//
//	
//	
//	public List<Detalle_Avaluo> llenaDetalle_Avaluo(List<Detalle_Avaluo> detalle_avaluo,
//			String tabla)throws SQLException{
//			String sql="select r.id_paquete, r.id_vivienda, r.id_tipo_mercado, r.tipo_linea, d.* from "+tabla+" as r left join detalle_avaluo as d with (nolock) on r.id_avaluo = d.id_avaluo";
//			ConexionAvaluosbd cone = null;
//			Connection conexion = null;
//			ResultSet result = null;
//			Statement stmnt = null;
//			List<Detalle_Avaluo> lstuvs = null;
//			Detalle_Avaluo rst = null;
//			System.out.println("antes de la ejecucion");
//			try {
//				cone = new ConexionAvaluosbd();
//				conexion = cone.getConexion();
//				stmnt = conexion.createStatement();
////				sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//				System.out.println("sql: " +sql);
//				result = stmnt.executeQuery(sql);
//				lstuvs = new ArrayList<Detalle_Avaluo>();
//				while (result.next()) {
//					rst = new Detalle_Avaluo();
//					rst.setId_avaluo(result.getString("id_avaluo"));
//					rst.setId_paquete(result.getString("id_paquete"));
//					rst.setId_vivienda(result.getString("id_vivienda"));
//					rst.setId_tipo_mercado(result.getString("id_tipo_mercado"));
//					rst.setTipo_linea(result.getString("tipo_linea"));
//					rst.setClave_shf(result.getString("clave_shf"));
//					rst.setClave_uv(result.getString("clave_uv"));
//					rst.setFecha_avaluo(result.getString("fecha_avaluo"));
//					rst.setClave_unica_vivienda(result.getString("clave_unica_vivienda"));
//					rst.setClasificacion_zona(result.getString("clasificacion_zona"));
//					rst.setNiveles_zona(result.getString("niveles_zona"));
//					rst.setConstrucciones_valor(result.getString("construcciones_valor"));
//					rst.setId_rec_aguas_residuales(result.getString("id_rec_aguas_residuales"));
//					rst.setDrenaje_pluvial_calle(result.getString("drenaje_pluvial_calle"));
//					rst.setDrenaje_pluvial_zona(result.getString("drenaje_pluvial_zona"));
//					rst.setSist_mixto_drenaje(result.getString("sist_mixto_drenaje"));
//					rst.setFosa_septica(result.getString("fosa_septica"));
//					rst.setElect_acometica_inmueble(result.getString("elect_acometica_inmueble"));
//					rst.setId_material_vialidades(result.getString("id_material_vialidades"));
//					rst.setVialidades_valor(result.getString("vialidades_valor"));
//					rst.setId_alumbrado_publico(result.getString("id_alumbrado_publico"));
//					rst.setId_material_banquetas(result.getString("id_material_banquetas"));
//					rst.setBanqueta_valor(result.getString("banqueta_valor"));
//					rst.setId_material_guarniciones(result.getString("id_material_guarniciones"));
//					rst.setGuarniciones_valor(result.getString("guarniciones_valor"));
//					rst.setNivel_infraestructura(result.getString("nivel_infraestructura"));
//					rst.setId_gas_natural(result.getString("id_gas_natural"));
//					rst.setId_sumin_telefonico(result.getString("id_sumin_telefonico"));
//					rst.setAcometida_telefonico(result.getString("acometida_telefonico"));
//					rst.setNomenclatura_calles(result.getString("nomenclatura_calles"));
//					rst.setTrans_urbano_dist(result.getString("trans_urbano_dist"));
//					rst.setTrans_urbano_frec(result.getString("trans_urbano_frec"));
//					rst.setTrans_suburbano_dist(result.getString("trans_suburbano_dist"));
//					rst.setTrans_suburbano_frec(result.getString("trans_suburbano_frec"));
//					rst.setRec_municipal_desechos(result.getString("rec_municipal_desechos"));
//					rst.setId_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//					rst.setTipo_inm_valuado_valor(result.getString("tipo_inm_valuado_valor"));
//					rst.setDomicilio_localidad_inmueble(result.getString("domicilio_localidad_inmueble"));
//					rst.setCodigo_postal_inmueble(result.getString("codigo_postal_inmueble"));
//					rst.setColonia_inmueble(result.getString("colonia_inmueble"));
//					rst.setCalle_inmueble(result.getString("calle_inmueble"));
//					rst.setNum_exterior_inmueble(result.getString("num_exterior_inmueble"));
//					rst.setNum_interior_inmueble(result.getString("num_interior_inmueble"));
//					rst.setId_conf_inmueble(result.getString("id_conf_inmueble"));
//					rst.setId_topografia_inmueble(result.getString("id_topografia_inmueble"));
//					rst.setUso_suelo(result.getString("uso_suelo"));
//					rst.setCus(result.getString("cus"));
//					rst.setDensidad_habitacional(result.getString("densidad_habitacional"));
//					rst.setUso_actual(result.getString("uso_actual"));
//					rst.setNum_recamaras(result.getString("num_recamaras"));
//					rst.setNum_banios(result.getString("num_banios"));
//					rst.setNum_estacionamiento(result.getString("num_estacionamiento"));
//					rst.setId_calidad_proyecto(result.getString("id_calidad_proyecto"));
//					rst.setId_clase_gral_inmueble(result.getString("id_clase_gral_inmueble"));
//					rst.setId_estado_conservacion(result.getString("id_estado_conservacion"));
//					rst.setEdad_contruccion(result.getString("edad_contruccion"));
//					rst.setVida_util_remanente(result.getString("vida_util_remanente"));
//					rst.setNiveles_construccion(result.getString("niveles_construccion"));
//					rst.setGrado_terminacion_obra(result.getString("grado_terminacion_obra"));
//					rst.setGrado_avance_areas_comunes(result.getString("grado_avance_areas_comunes"));
//					rst.setSuperficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//					rst.setSuperficie_construida(result.getString("superficie_construida"));
//					rst.setSuperficie_accesorias(result.getString("superficie_accesorias"));
//					rst.setSuperficie_vendible(result.getString("superficie_vendible"));
//					rst.setIndivisos_construccion(result.getString("indivisos_construccion"));
//					rst.setIndivisos_terreno(result.getString("indivisos_terreno"));
//					rst.setId_inst_hidraulicas(result.getString("id_inst_hidraulicas"));
//					rst.setMat_inst_hidraulicas(result.getString("mat_inst_hidraulicas"));
//					rst.setId_inst_sanitarias(result.getString("id_inst_sanitarias"));
//					rst.setMat_inst_sanitarias(result.getString("mat_inst_sanitarias"));
//					rst.setId_inst_electricas(result.getString("id_inst_electricas"));
//					rst.setId_elementos_adicionales(result.getString("id_elementos_adicionales"));
//					rst.setElementos_adicionales_valor(result.getString("elementos_adicionales_valor"));
//					rst.setValor_comparativo_total(result.getString("valor_comparativo_total"));
//					rst.setValor_comparativo_m2(result.getString("valor_comparativo_m2"));
//					rst.setValor_terreno_total(result.getString("valor_terreno_total"));
//					rst.setValor_terreno_m2(result.getString("valor_terreno_m2"));
//					rst.setValor_construccion_total(result.getString("valor_construccion_total"));
//					rst.setValor_construccion_m2(result.getString("valor_construccion_m2"));
//					rst.setValor_residual(result.getString("valor_residual"));
//					rst.setValor_concluido(result.getString("valor_concluido"));
//					rst.setId_ubica_inmueble_terreno(result.getString("id_ubica_inmueble_terreno"));
//					rst.setSuperficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//					rst.setId_vigilancia(result.getString("id_vigilancia"));
//					rst.setSenalizacion_vial(result.getString("senalizacion_vial"));
//					rst.setId_suministro_electricidad(result.getString("id_suministro_electricidad"));
//					rst.setId_agua_potable(result.getString("id_agua_potable"));
//					rst.setIndice_saturacion_zona(result.getString("indice_saturacion_zona"));
//					rst.setId_uso_construcciones(result.getString("id_uso_construcciones"));
//					rst.setId_ref_proximidad_urbana(result.getString("id_ref_proximidad_urbana"));
//					rst.setId_clase_zona(result.getString("id_clase_zona"));
//					rst.setId_perito_shf(result.getString("id_perito_shf"));
//					rst.setId_densidad_poblacion(result.getString("id_densidad_poblacion"));
//					rst.setId_controlador_shf(result.getString("id_controlador_shf"));
//					rst.setLongitud(result.getString("longitud"));
//					rst.setLatitud(result.getString("latitud"));
//					rst.setAltitud(result.getString("altitud"));
//					rst.setOtro_tipo_sistema(result.getString("otro_tipo_sistema"));
//					rst.setId_existencia_trans_urbano(result.getString("id_existencia_trans_urbano"));
//					rst.setId_existencia_tran_suburbano(result.getString("id_existencia_tran_suburbano"));
//					rst.setRec_municipal_desechos_frec(result.getString("rec_municipal_desechos_frec"));
//					rst.setId_nivel_infraurbana(result.getString("id_nivel_infraurbana"));
//					rst.setId_existencia_iglesia(result.getString("id_existencia_iglesia"));
//					rst.setId_existencia_mercados(result.getString("id_existencia_mercados"));
//					rst.setId_existencia_plaza_publica(result.getString("id_existencia_plaza_publica"));
//					rst.setId_existencia_parques_jardines(result.getString("id_existencia_parques_jardines"));
//					rst.setId_existencia_escuelas(result.getString("id_existencia_escuelas"));
//					rst.setId_existencia_hospitales(result.getString("id_existencia_hospitales"));
//					rst.setId_existencia_bancos(result.getString("id_existencia_bancos"));
//					rst.setId_existencia_acceso_estacion_urbano(result.getString("id_existencia_acceso_estacion_urbano"));
//					rst.setId_existenciaaccesoestacionsuburbano(result.getString("id_existenciaaccesoestacionsuburbano"));
//					rst.setId_existenciacentrocomunitario(result.getString("id_existenciacentrocomunitario"));
//					rst.setIdnivelequipamientourbano(result.getString("idnivelequipamientourbano"));
//					rst.setReportedensidad(result.getString("reportedensidad"));
//					rst.setId_existe_espacio_uso_multiple(result.getString("id_existe_espacio_uso_multiple"));
//					rst.setNum_medios_banios(result.getString("num_medios_banios"));
//					rst.setResultado_calidad_proyecto(result.getString("resultado_calidad_proyecto"));
//					rst.setComentarios_estado_conservacion(result.getString("comentarios_estado_conservacion"));
//					rst.setMat_inst_electricas(result.getString("mat_inst_electricas"));
//					rst.setValor_hipotetico(result.getString("valor_hipotetico"));
//					rst.setDensidadhabitacionalhabitantes(result.getString("densidadhabitacionalhabitantes"));
//					rst.setDensidadhabitacionalviviendas(result.getString("densidadhabitacionalviviendas"));
//					rst.setId_supermercados(result.getString("id_supermercados"));
//					rst.setId_locales_comerciales(result.getString("id_locales_comerciales"));
//					rst.setNum_locales_comerciales(result.getString("num_locales_comerciales"));
//					rst.setId_existencia_parques(result.getString("id_existencia_parques"));
//					rst.setId_existencia_jardines(result.getString("id_existencia_jardines"));
//					rst.setId_canchas_deportivas(result.getString("id_canchas_deportivas"));
//					rst.setId_centro_deportivo(result.getString("id_centro_deportivo"));
//					rst.setId_escuelas_primarias(result.getString("id_escuelas_primarias"));
//					rst.setId_escuelas_secundarias(result.getString("id_escuelas_secundarias"));
//					rst.setId_escuelas_preparatoria(result.getString("id_escuelas_preparatoria"));
//					rst.setId_universidad(result.getString("id_universidad"));
//					rst.setId_otras_escuelas(result.getString("id_otras_escuelas"));
//					rst.setId_servicios_salud_primer_nivel(result.getString("id_servicios_salud_primer_nivel"));
//					rst.setId_servicios_salud_segundo_nivel(result.getString("id_servicios_salud_segundo_nivel"));
//					rst.setId_servicios_salud_tercer_nivel(result.getString("id_servicios_salud_tercer_nivel"));
//					rst.setId_terreno_colinda(result.getString("id_terreno_colinda"));
//					rst.setId_terreno_ubicado(result.getString("id_terreno_ubicado"));
//					rst.setId_riesgo_social(result.getString("id_riesgo_social"));
//					rst.setId_riesgo_comercial(result.getString("id_riesgo_comercial"));
//					lstuvs.add(rst);
//				}
//			} catch (NamingException e) {
//				LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//			} finally {
//				result.close();
//				stmnt.close();
//				cone.close(conexion);
//			}
//
//			return lstuvs;
//	}
//
//	
//	
//	public List<Detalle_Avaluo> llenaDetalle_AvaluoMai(List<Detalle_Avaluo> detalle_avaluo,
//			String tabla)throws SQLException{
//			String sql="select r.id_paquete, r.id_vivienda, d.* from "+tabla+" as r left join detalle_avaluo as d with (nolock) on r.id_avaluo = d.id_avaluo";
//			ConexionAvaluosbd cone = null;
//			Connection conexion = null;
//			ResultSet result = null;
//			Statement stmnt = null;
//			List<Detalle_Avaluo> lstuvs = null;
//			Detalle_Avaluo rst = null;
//			System.out.println("antes de la ejecucion");
//			try {
//				cone = new ConexionAvaluosbd();
//				conexion = cone.getConexion();
//				stmnt = conexion.createStatement();
////				sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//				System.out.println("sql: " +sql);
//				result = stmnt.executeQuery(sql);
//				lstuvs = new ArrayList<Detalle_Avaluo>();
//				while (result.next()) {
//					rst = new Detalle_Avaluo();
//					rst.setId_avaluo(result.getString("id_avaluo"));
//					rst.setId_paquete(result.getString("id_paquete"));
//					rst.setId_vivienda(result.getString("id_vivienda"));
//					rst.setClave_shf(result.getString("clave_shf"));
//					rst.setClave_uv(result.getString("clave_uv"));
//					rst.setFecha_avaluo(result.getString("fecha_avaluo"));
//					rst.setClave_unica_vivienda(result.getString("clave_unica_vivienda"));
//					rst.setClasificacion_zona(result.getString("clasificacion_zona"));
//					rst.setNiveles_zona(result.getString("niveles_zona"));
//					rst.setConstrucciones_valor(result.getString("construcciones_valor"));
//					rst.setId_rec_aguas_residuales(result.getString("id_rec_aguas_residuales"));
//					rst.setDrenaje_pluvial_calle(result.getString("drenaje_pluvial_calle"));
//					rst.setDrenaje_pluvial_zona(result.getString("drenaje_pluvial_zona"));
//					rst.setSist_mixto_drenaje(result.getString("sist_mixto_drenaje"));
//					rst.setFosa_septica(result.getString("fosa_septica"));
//					rst.setElect_acometica_inmueble(result.getString("elect_acometica_inmueble"));
//					rst.setId_material_vialidades(result.getString("id_material_vialidades"));
//					rst.setVialidades_valor(result.getString("vialidades_valor"));
//					rst.setId_alumbrado_publico(result.getString("id_alumbrado_publico"));
//					rst.setId_material_banquetas(result.getString("id_material_banquetas"));
//					rst.setBanqueta_valor(result.getString("banqueta_valor"));
//					rst.setId_material_guarniciones(result.getString("id_material_guarniciones"));
//					rst.setGuarniciones_valor(result.getString("guarniciones_valor"));
//					rst.setNivel_infraestructura(result.getString("nivel_infraestructura"));
//					rst.setId_gas_natural(result.getString("id_gas_natural"));
//					rst.setId_sumin_telefonico(result.getString("id_sumin_telefonico"));
//					rst.setAcometida_telefonico(result.getString("acometida_telefonico"));
//					rst.setNomenclatura_calles(result.getString("nomenclatura_calles"));
//					rst.setTrans_urbano_dist(result.getString("trans_urbano_dist"));
//					rst.setTrans_urbano_frec(result.getString("trans_urbano_frec"));
//					rst.setTrans_suburbano_dist(result.getString("trans_suburbano_dist"));
//					rst.setTrans_suburbano_frec(result.getString("trans_suburbano_frec"));
//					rst.setRec_municipal_desechos(result.getString("rec_municipal_desechos"));
//					rst.setId_tipo_inmueble_valuado(result.getString("id_tipo_inmueble_valuado"));
//					rst.setTipo_inm_valuado_valor(result.getString("tipo_inm_valuado_valor"));
//					rst.setDomicilio_localidad_inmueble(result.getString("domicilio_localidad_inmueble"));
//					rst.setCodigo_postal_inmueble(result.getString("codigo_postal_inmueble"));
//					rst.setColonia_inmueble(result.getString("colonia_inmueble"));
//					rst.setCalle_inmueble(result.getString("calle_inmueble"));
//					rst.setNum_exterior_inmueble(result.getString("num_exterior_inmueble"));
//					rst.setNum_interior_inmueble(result.getString("num_interior_inmueble"));
//					rst.setId_conf_inmueble(result.getString("id_conf_inmueble"));
//					rst.setId_topografia_inmueble(result.getString("id_topografia_inmueble"));
//					rst.setUso_suelo(result.getString("uso_suelo"));
//					rst.setCus(result.getString("cus"));
//					rst.setDensidad_habitacional(result.getString("densidad_habitacional"));
//					rst.setUso_actual(result.getString("uso_actual"));
//					rst.setNum_recamaras(result.getString("num_recamaras"));
//					rst.setNum_banios(result.getString("num_banios"));
//					rst.setNum_estacionamiento(result.getString("num_estacionamiento"));
//					rst.setId_calidad_proyecto(result.getString("id_calidad_proyecto"));
//					rst.setId_clase_gral_inmueble(result.getString("id_clase_gral_inmueble"));
//					rst.setId_estado_conservacion(result.getString("id_estado_conservacion"));
//					rst.setEdad_contruccion(result.getString("edad_contruccion"));
//					rst.setVida_util_remanente(result.getString("vida_util_remanente"));
//					rst.setNiveles_construccion(result.getString("niveles_construccion"));
//					rst.setGrado_terminacion_obra(result.getString("grado_terminacion_obra"));
//					rst.setGrado_avance_areas_comunes(result.getString("grado_avance_areas_comunes"));
//					rst.setSuperficie_terreno_vivienda(result.getString("superficie_terreno_vivienda"));
//					rst.setSuperficie_construida(result.getString("superficie_construida"));
//					rst.setSuperficie_accesorias(result.getString("superficie_accesorias"));
//					rst.setSuperficie_vendible(result.getString("superficie_vendible"));
//					rst.setIndivisos_construccion(result.getString("indivisos_construccion"));
//					rst.setIndivisos_terreno(result.getString("indivisos_terreno"));
//					rst.setId_inst_hidraulicas(result.getString("id_inst_hidraulicas"));
//					rst.setMat_inst_hidraulicas(result.getString("mat_inst_hidraulicas"));
//					rst.setId_inst_sanitarias(result.getString("id_inst_sanitarias"));
//					rst.setMat_inst_sanitarias(result.getString("mat_inst_sanitarias"));
//					rst.setId_inst_electricas(result.getString("id_inst_electricas"));
//					rst.setId_elementos_adicionales(result.getString("id_elementos_adicionales"));
//					rst.setElementos_adicionales_valor(result.getString("elementos_adicionales_valor"));
//					rst.setValor_comparativo_total(result.getString("valor_comparativo_total"));
//					rst.setValor_comparativo_m2(result.getString("valor_comparativo_m2"));
//					rst.setValor_terreno_total(result.getString("valor_terreno_total"));
//					rst.setValor_terreno_m2(result.getString("valor_terreno_m2"));
//					rst.setValor_construccion_total(result.getString("valor_construccion_total"));
//					rst.setValor_construccion_m2(result.getString("valor_construccion_m2"));
//					rst.setValor_residual(result.getString("valor_residual"));
//					rst.setValor_concluido(result.getString("valor_concluido"));
//					rst.setId_ubica_inmueble_terreno(result.getString("id_ubica_inmueble_terreno"));
//					rst.setSuperficie_terreno_conjunto(result.getString("superficie_terreno_conjunto"));
//					rst.setId_vigilancia(result.getString("id_vigilancia"));
//					rst.setSenalizacion_vial(result.getString("senalizacion_vial"));
//					rst.setId_suministro_electricidad(result.getString("id_suministro_electricidad"));
//					rst.setId_agua_potable(result.getString("id_agua_potable"));
//					rst.setIndice_saturacion_zona(result.getString("indice_saturacion_zona"));
//					rst.setId_uso_construcciones(result.getString("id_uso_construcciones"));
//					rst.setId_ref_proximidad_urbana(result.getString("id_ref_proximidad_urbana"));
//					rst.setId_clase_zona(result.getString("id_clase_zona"));
//					rst.setId_perito_shf(result.getString("id_perito_shf"));
//					rst.setId_densidad_poblacion(result.getString("id_densidad_poblacion"));
//					rst.setId_controlador_shf(result.getString("id_controlador_shf"));
//					rst.setLongitud(result.getString("longitud"));
//					rst.setLatitud(result.getString("latitud"));
//					rst.setAltitud(result.getString("altitud"));
//					rst.setOtro_tipo_sistema(result.getString("otro_tipo_sistema"));
//					rst.setId_existencia_trans_urbano(result.getString("id_existencia_trans_urbano"));
//					rst.setId_existencia_tran_suburbano(result.getString("id_existencia_tran_suburbano"));
//					rst.setRec_municipal_desechos_frec(result.getString("rec_municipal_desechos_frec"));
//					rst.setId_nivel_infraurbana(result.getString("id_nivel_infraurbana"));
//					rst.setId_existencia_iglesia(result.getString("id_existencia_iglesia"));
//					rst.setId_existencia_mercados(result.getString("id_existencia_mercados"));
//					rst.setId_existencia_plaza_publica(result.getString("id_existencia_plaza_publica"));
//					rst.setId_existencia_parques_jardines(result.getString("id_existencia_parques_jardines"));
//					rst.setId_existencia_escuelas(result.getString("id_existencia_escuelas"));
//					rst.setId_existencia_hospitales(result.getString("id_existencia_hospitales"));
//					rst.setId_existencia_bancos(result.getString("id_existencia_bancos"));
//					rst.setId_existencia_acceso_estacion_urbano(result.getString("id_existencia_acceso_estacion_urbano"));
//					rst.setId_existenciaaccesoestacionsuburbano(result.getString("id_existenciaaccesoestacionsuburbano"));
//					rst.setId_existenciacentrocomunitario(result.getString("id_existenciacentrocomunitario"));
//					rst.setIdnivelequipamientourbano(result.getString("idnivelequipamientourbano"));
//					rst.setReportedensidad(result.getString("reportedensidad"));
//					rst.setId_existe_espacio_uso_multiple(result.getString("id_existe_espacio_uso_multiple"));
//					rst.setNum_medios_banios(result.getString("num_medios_banios"));
//					rst.setResultado_calidad_proyecto(result.getString("resultado_calidad_proyecto"));
//					rst.setComentarios_estado_conservacion(result.getString("comentarios_estado_conservacion"));
//					rst.setMat_inst_electricas(result.getString("mat_inst_electricas"));
//					rst.setValor_hipotetico(result.getString("valor_hipotetico"));
//					rst.setDensidadhabitacionalhabitantes(result.getString("densidadhabitacionalhabitantes"));
//					rst.setDensidadhabitacionalviviendas(result.getString("densidadhabitacionalviviendas"));
//					rst.setId_supermercados(result.getString("id_supermercados"));
//					rst.setId_locales_comerciales(result.getString("id_locales_comerciales"));
//					rst.setNum_locales_comerciales(result.getString("num_locales_comerciales"));
//					rst.setId_existencia_parques(result.getString("id_existencia_parques"));
//					rst.setId_existencia_jardines(result.getString("id_existencia_jardines"));
//					rst.setId_canchas_deportivas(result.getString("id_canchas_deportivas"));
//					rst.setId_centro_deportivo(result.getString("id_centro_deportivo"));
//					rst.setId_escuelas_primarias(result.getString("id_escuelas_primarias"));
//					rst.setId_escuelas_secundarias(result.getString("id_escuelas_secundarias"));
//					rst.setId_escuelas_preparatoria(result.getString("id_escuelas_preparatoria"));
//					rst.setId_universidad(result.getString("id_universidad"));
//					rst.setId_otras_escuelas(result.getString("id_otras_escuelas"));
//					rst.setId_servicios_salud_primer_nivel(result.getString("id_servicios_salud_primer_nivel"));
//					rst.setId_servicios_salud_segundo_nivel(result.getString("id_servicios_salud_segundo_nivel"));
//					rst.setId_servicios_salud_tercer_nivel(result.getString("id_servicios_salud_tercer_nivel"));
//					rst.setId_terreno_colinda(result.getString("id_terreno_colinda"));
//					rst.setId_terreno_ubicado(result.getString("id_terreno_ubicado"));
//					rst.setId_riesgo_social(result.getString("id_riesgo_social"));
//					rst.setId_riesgo_comercial(result.getString("id_riesgo_comercial"));
//					lstuvs.add(rst);
//				}
//			} catch (NamingException e) {
//				LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//			} finally {
//				result.close();
//				stmnt.close();
//				cone.close(conexion);
//			}
//
//			return lstuvs;
//	}
//
//	
//	
//	public List<ViviendaVO> llenaViviendaVO(List<ViviendaVO> vivienda, String tabla)
//	throws SQLException{
//		String sql="select r.id_tipo_mercado, r.tipo_linea, r.id_avaluo, d.* from "+tabla+" as r left join vivienda as d with (nolock) on r.id_paquete = d.id_paquete and r.id_vivienda = d.id_vivienda";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<ViviendaVO> lstuvs = null;
//		ViviendaVO rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<ViviendaVO>();
//			while (result.next()) {
//				rst = new ViviendaVO();
//				rst.setId_avaluo(result.getString("id_avaluo"));
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_vivienda(result.getString("id_vivienda"));
//				rst.setId_tipo_mercado(result.getString("id_tipo_mercado"));
//				rst.setTipo_linea(result.getString("tipo_linea"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setCp(result.getString("cp"));
//				rst.setColonia(result.getString("colonia"));
//				rst.setSupermanzana(result.getString("supermanzana"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setLote(result.getString("lote"));
//				rst.setCalle(result.getString("calle"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setNum_exterior(result.getString("num_exterior"));
//				rst.setNum_interior(result.getString("num_interior"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setEntrada(result.getString("entrada"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setTelefono(result.getString("telefono"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setFecha_solicitud(result.getString("fecha_solicitud"));
//				rst.setEstatus_avaluo(result.getString("estatus_avaluo"));
//				rst.setFecha_dtu(result.getString("fecha_dtu"));
//				rst.setExiste_dtu(result.getString("existe_dtu"));
//				rst.setNSS(result.getString("NSS"));
//				rst.setFecha_compromiso_termino(result.getString("fecha_compromiso_termino"));
//				rst.setPrecio_venta(result.getString("precio_venta"));
//				rst.setCuv(result.getString("cuv"));
//				rst.setTipo_vivienda(result.getString("tipo_vivienda"));
//				rst.setNum_notario(result.getString("num_notario"));
//				rst.setNombre_notario	(result.getString("nombre_notario"));	
//				rst.setPlaza(result.getString("plaza"));
//				rst.setNum_escritura(result.getString("num_escritura"));
//				rst.setLibro(result.getString("libro"));
//				rst.setVolumen(result.getString("volumen"));
//				rst.setVivienda_verde_costo(result.getString("vivienda_verde_costo"));
//				rst.setVivienda_verde_ahorro(result.getString("vivienda_verde_ahorro"));
//				rst.setNiveles_edificio(result.getString("niveles_edificio"));
//				rst.setNiveles_vivienda(result.getString("niveles_vivienda"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return lstuvs;
//}
//
//	
//	
//	public List<ViviendaVO> llenaViviendaVOMai(List<ViviendaVO> vivienda, String tabla)
//	throws SQLException{
//		String sql="select r.id_avaluo, d.* from "+tabla+" as r left join vivienda as d with (nolock) on r.id_paquete = d.id_paquete and r.id_vivienda = d.id_vivienda";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<ViviendaVO> lstuvs = null;
//		ViviendaVO rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<ViviendaVO>();
//			while (result.next()) {
//				rst = new ViviendaVO();
//				rst.setId_avaluo(result.getString("id_avaluo"));
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_vivienda(result.getString("id_vivienda"));
//				rst.setLocalidad(result.getString("localidad"));
//				rst.setCp(result.getString("cp"));
//				rst.setColonia(result.getString("colonia"));
//				rst.setSupermanzana(result.getString("supermanzana"));
//				rst.setManzana(result.getString("manzana"));
//				rst.setLote(result.getString("lote"));
//				rst.setCalle(result.getString("calle"));
//				rst.setEntre_calle_1(result.getString("entre_calle_1"));
//				rst.setEntre_calle_2(result.getString("entre_calle_2"));
//				rst.setNum_exterior(result.getString("num_exterior"));
//				rst.setNum_interior(result.getString("num_interior"));
//				rst.setCondominio(result.getString("condominio"));
//				rst.setEntrada(result.getString("entrada"));
//				rst.setEdificio(result.getString("edificio"));
//				rst.setTelefono(result.getString("telefono"));
//				rst.setNivel(result.getString("nivel"));
//				rst.setFecha_solicitud(result.getString("fecha_solicitud"));
//				rst.setEstatus_avaluo(result.getString("estatus_avaluo"));
//				rst.setFecha_dtu(result.getString("fecha_dtu"));
//				rst.setExiste_dtu(result.getString("existe_dtu"));
//				rst.setNSS(result.getString("NSS"));
//				rst.setFecha_compromiso_termino(result.getString("fecha_compromiso_termino"));
//				rst.setPrecio_venta(result.getString("precio_venta"));
//				rst.setCuv(result.getString("cuv"));
//				rst.setTipo_vivienda(result.getString("tipo_vivienda"));
//				rst.setNum_notario(result.getString("num_notario"));
//				rst.setNombre_notario	(result.getString("nombre_notario"));	
//				rst.setPlaza(result.getString("plaza"));
//				rst.setNum_escritura(result.getString("num_escritura"));
//				rst.setLibro(result.getString("libro"));
//				rst.setVolumen(result.getString("volumen"));
//				rst.setVivienda_verde_costo(result.getString("vivienda_verde_costo"));
//				rst.setVivienda_verde_ahorro(result.getString("vivienda_verde_ahorro"));
//				rst.setNiveles_edificio(result.getString("niveles_edificio"));
//				rst.setNiveles_vivienda(result.getString("niveles_vivienda"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return lstuvs;
//}
//
//	public List<PaquetePrincipal> llenaPaquetePrincipal(List<PaquetePrincipal> paqueteVO,
//			String tabla) throws SQLException{
//		String sql="select r.id_tipo_mercado, r.tipo_linea, d.* from "+tabla+" as r left join paquete as d with (nolock) on r.id_paquete = d.id_paquete ";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<PaquetePrincipal> lstuvs = null;
//		PaquetePrincipal rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<PaquetePrincipal>();
//			while (result.next()) {
//				rst = new PaquetePrincipal();
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_uv(result.getString("id_uv"));
//				rst.setNum_viviendas(result.getString("num_viviendas"));
//				rst.setNombre_frente(result.getString("nombre_frente"));
//				rst.setFecha_aprobacion_oferta(result.getString("fecha_aprobacion_oferta"));
//				rst.setFecha_estimada_entrega(result.getString("fecha_estimada_entrega"));
//				rst.setFecha_asignacion(result.getString("fecha_asignacion"));
//				rst.setId_regimen(result.getString("id_regimen"));
//				rst.setRfc(result.getString("rfc"));
//				rst.setId_estado(result.getString("id_estado"));
//				rst.setId_municipio(result.getString("id_municipio"));
//				rst.setId_tipo_mercado(result.getString("id_tipo_mercado"));
//				rst.setTipo_linea(result.getString("tipo_linea"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return lstuvs;
//	}
//
//	
//	
//	public List<PaquetePrincipal> llenaPaquetePrincipalMai(List<PaquetePrincipal> paqueteVO,
//			String tabla) throws SQLException{
//		String sql="select  d.* from "+tabla+" as r left join paquete as d with (nolock) on r.id_paquete = d.id_paquete ";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<PaquetePrincipal> lstuvs = null;
//		PaquetePrincipal rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<PaquetePrincipal>();
//			while (result.next()) {
//				rst = new PaquetePrincipal();
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_uv(result.getString("id_uv"));
//				rst.setNum_viviendas(result.getString("num_viviendas"));
//				rst.setNombre_frente(result.getString("nombre_frente"));
//				rst.setFecha_aprobacion_oferta(result.getString("fecha_aprobacion_oferta"));
//				rst.setFecha_estimada_entrega(result.getString("fecha_estimada_entrega"));
//				rst.setFecha_asignacion(result.getString("fecha_asignacion"));
//				rst.setId_regimen(result.getString("id_regimen"));
//				rst.setRfc(result.getString("rfc"));
//				rst.setId_estado(result.getString("id_estado"));
//				rst.setId_municipio(result.getString("id_municipio"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return lstuvs;
//	}
//
//	
//	
//	
//	public List<Dtc> llenaCUV(List<Dtc> dtcmai, String tabla) throws SQLException{
//		String sql="select d.* from "+tabla+" as r left join dtc as d with (nolock) on r.id_paquete = d.id_paquete and r.id_vivienda = d.id_vivienda";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<Dtc> lstuvs = null;
//		Dtc rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			lstuvs = new ArrayList<Dtc>();
//			while (result.next()) {
//				rst = new Dtc();
//				rst.setId_paquete(result.getString("id_paquete"));
//				rst.setId_vivienda(result.getString("id_vivienda"));
//				rst.setId_dtc(result.getString("id_dtc"));
//				rst.setCalificacion(result.getString("calificacion"));
//				rst.setEstatus(result.getString("estatus"));
//				rst.setZona_restricciones_motivo(result.getString("zona_restricciones_motivo"));
//				rst.setId_zona_afectacion(result.getString("id_zona_afectacion"));
//				rst.setZona_afectacion_motivo(result.getString("zona_afectacion_motivo"));
//				rst.setId_zona_areas_inundable(result.getString("id_zona_areas_inundable"));
//				rst.setZona_areas_inundable_motivo(result.getString("zona_areas_inundable_motivo"));
//				rst.setId_vialidades_pavimentos(result.getString("id_vialidades_pavimentos"));
//				rst.setId_vialidades_guarniciones(result.getString("id_vialidades_guarniciones"));
//				rst.setId_vialidades_accesos(result.getString("id_vialidades_accesos"));
//				rst.setId_infraes_agua_potable(result.getString("id_infraes_agua_potable"));
//				rst.setInfraes_agua_potable_motivo(result.getString("infraes_agua_potable_motivo"));
//				rst.setId_infraes_drenaje(result.getString("id_infraes_drenaje"));
//				rst.setInfraes_drenaje_motivo(result.getString("infraes_drenaje_motivo"));
//				rst.setId_infraes_energia_electrica(result.getString("id_infraes_energia_electrica"));
//				rst.setInfraes_energia_electrica_motivo(result.getString("infraes_energia_electrica_motivo"));
//				rst.setId_infraes_alumbrado_publico(result.getString("id_infraes_alumbrado_publico"));
//				rst.setId_obra_cimentacion(result.getString("id_obra_cimentacion"));
//				rst.setObra_cimentacion_motivo(result.getString("obra_cimentacion_motivo"));
//				rst.setId_obra_estructura(result.getString("id_obra_estructura"));
//				rst.setObra_estructura_motivo(result.getString("obra_estructura_motivo"));
//				rst.setId_obra_muros(result.getString("id_obra_muros"));
//				rst.setObra_muros_motivo(result.getString("obra_muros_motivo"));
//				rst.setId_obra_losas(result.getString("id_obra_losas"));
//				rst.setObra_losas_motivo(result.getString("obra_losas_motivo"));
//				rst.setId_obra_bardas(result.getString("id_obra_bardas"));
//				rst.setObra_bardas_motivo(result.getString("obra_bardas_motivo"));
//				rst.setObra_impermeabilizacion_motivo(result.getString("obra_impermeabilizacion_motivo"));
//				rst.setId_infra_inst_hidraulicas(result.getString("id_infra_inst_hidraulicas"));
//				rst.setId_infra_inst_sanitaria(result.getString("id_infra_inst_sanitaria"));
//				rst.setId_infra_inst_electrica(result.getString("id_infra_inst_electrica"));
//				rst.setId_calidad_funcionalidad(result.getString("id_calidad_funcionalidad"));
//				rst.setCalidad_estado_conservacion_motivo(result.getString("calidad_estado_conservacion_motivo"));
//				rst.setId_vida_util_remanente(result.getString("id_vida_util_remanente"));
//				rst.setVida_util_remanente_motivo(result.getString("vida_util_remanente_motivo"));
//				rst.setId_equipamiento_educacion(result.getString("id_equipamiento_educacion"));
//				rst.setId_equipamiento_salud(result.getString("id_equipamiento_salud"));
//				rst.setId_equipamiento_recreacion(result.getString("id_equipamiento_recreacion"));
//				rst.setId_equipamiento_transporte(result.getString("id_equipamiento_transporte"));
//				rst.setId_equipamiento_vigilancia(result.getString("id_equipamiento_vigilancia"));
//				rst.setId_equipamiento_rec_basura(result.getString("id_equipamiento_rec_basura"));
//				rst.setId_obra_impermeabilizacion(result.getString("id_obra_impermeabilizacion"));
//				rst.setId_calidad_estado_conservacion(result.getString("id_calidad_estado_conservacion"));
//				rst.setId_equipamiento_abasto(result.getString("id_equipamiento_abasto"));
//				rst.setId_infra_insta_gas(result.getString("id_infra_insta_gas"));
//				rst.setId_zona_restricciones(result.getString("id_zona_restricciones"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//		}
//		return lstuvs;
//	}
//
//	public List<MesDatoVo> llenames(String fechaIniciomes, String sql) throws SQLException{
//		
//		//sql="select * from "+tabla+"";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<MesDatoVo> lstuvs = null;
//		MesDatoVo rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			System.out.println("ejecuto el query");
//			lstuvs = new ArrayList<MesDatoVo>();
//			while (result.next()) {
////				System.out.println("empiesa el llenado");
//				rst = new MesDatoVo();
//				rst.setDia(result.getString("Dia"));
//				rst.setCantidadPaquete(result.getString("AvaCerrados"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//	}
//		return lstuvs;
//	}
//
//	public List<MesDatoVo> dia(String sql) throws SQLException{
//		
//		//sql="select * from "+tabla+"";
//		ConexionAvaluosbd cone = null;
//		Connection conexion = null;
//		ResultSet result = null;
//		Statement stmnt = null;
//		List<MesDatoVo> lstuvs = null;
//		MesDatoVo rst = null;
//		System.out.println("antes de la ejecucion");
//		try {
//			cone = new ConexionAvaluosbd();
//			conexion = cone.getConexion();
//			stmnt = conexion.createStatement();
////			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
//			System.out.println("sql: " +sql);
//			result = stmnt.executeQuery(sql);
//			System.out.println("ejecuto el query");
//			lstuvs = new ArrayList<MesDatoVo>();
//			while (result.next()) {
////				System.out.println("empiesa el llenado");
//				rst = new MesDatoVo();
//				rst.setDia(result.getString("hora"));
//				rst.setCantidadPaquete(result.getString("avaluos"));
//				lstuvs.add(rst);
//			}
//		} catch (NamingException e) {
//			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//		} finally {
//			result.close();
//			stmnt.close();
//			cone.close(conexion);
//	}
//		return lstuvs;
//	}
//	
public List<EstadosCerradosVo> estados(String sql) throws SQLException{
		
		//sql="select * from "+tabla+"";
		ConexionAvaluosbd cone = null;
		Connection conexion = null;
		ResultSet result = null;
		Statement stmnt = null;
		List<EstadosCerradosVo> lstuvs = null;
		EstadosCerradosVo rst = null;
		System.out.println("antes de la ejecucion");
		try {
			cone = new ConexionAvaluosbd();
			conexion = cone.getConexion();
			stmnt = conexion.createStatement();
//			sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
			System.out.println("sql: " +sql);
			result = stmnt.executeQuery(sql);
			System.out.println("ejecuto el query");
			lstuvs = new ArrayList<EstadosCerradosVo>();
			while (result.next()) {
//				System.out.println("empiesa el llenado");
				rst = new EstadosCerradosVo();
				rst.setEstado(result.getString("descripcion"));
				rst.setAvaluosCerrados(result.getString("avaluos"));
				lstuvs.add(rst);
			}
		} catch (NamingException e) {
			LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
		} finally {
			result.close();
			stmnt.close();
			cone.close(conexion);
	}
		return lstuvs;
	}


public List<EstadosCerradosVo> estados2(String sql) throws SQLException{
	
	//sql="select * from "+tabla+"";
	ConexionAvaluosbd cone = null;
	Connection conexion = null;
	ResultSet result = null;
	Statement stmnt = null;
	List<EstadosCerradosVo> lstuvs = null;
	EstadosCerradosVo rst = null;
	System.out.println("antes de la ejecucion");
	try {
		cone = new ConexionAvaluosbd();
		conexion = cone.getConexion();
		stmnt = conexion.createStatement();
//		sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
		System.out.println("sql: " +sql);
		result = stmnt.executeQuery(sql);
		System.out.println("ejecuto el query");
		lstuvs = new ArrayList<EstadosCerradosVo>();
		while (result.next()) {
//			System.out.println("empiesa el llenado");
			rst = new EstadosCerradosVo();
			rst.setEstado(result.getString("descripcion"));
			rst.setAvaluosCerrados(result.getString("avaluos"));
			rst.setId_estado(result.getString("id_estado"));
			lstuvs.add(rst);
		}
	} catch (NamingException e) {
		LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
	} finally {
		result.close();
		stmnt.close();
		cone.close(conexion);
}
	return lstuvs;
}


//public String diaString(int a){
//	String b = null;
//	if(a==0){
//		b="Enero";
//	}else if(a==1){
//		b="Febrero";
//	}else if(a==2){
//		b="Marzo";
//	}else if(a==3){
//		b="Abril";
//	}else if(a==4){
//		b="Mayo";
//	}else if(a==5){
//		b="Junio";
//	}else if(a==6){
//		b="Julio";
//	}else if(a==7){
//		b="Agosto";
//	}else if(a==8){
//		b="Septiembre";
//	}else if(a==9){
//		b="Octubre";
//	}else if(a==10){
//		b="Noviembre";
//	}else if(a==11){
//		b="Diciembre";
//	}
//		return b;
//	}
//
public  List<AvaluosEstadosUnidadesVO> UvsEstado(String sql)  throws SQLException{
	
	//sql="select * from "+tabla+"";
	ConexionAvaluosbd cone = null;
	Connection conexion = null;
	ResultSet result = null;
	Statement stmnt = null;
	List<AvaluosEstadosUnidadesVO> lstuvs = null;
	AvaluosEstadosUnidadesVO rst = null;
	System.out.println("antes de la ejecucion");
	try {
		cone = new ConexionAvaluosbd();
		conexion = cone.getConexion();
		stmnt = conexion.createStatement();
//		sql = "select id_estado, descripcion from cat_delegacion with(NOLOCK) ";
		System.out.println("sql: " +sql);
		result = stmnt.executeQuery(sql);
		System.out.println("ejecuto el query");
		lstuvs = new ArrayList<AvaluosEstadosUnidadesVO>();
		while (result.next()) {
//			System.out.println("empiesa el llenado");
			rst = new AvaluosEstadosUnidadesVO();
			rst.setIdUV(result.getString("id_uv"));
			rst.setAvaluosCerrados(result.getString("avaluosCerrados"));
			rst.setDescripcion(result.getString("descripcion"));
			lstuvs.add(rst);
		}
	} catch (NamingException e) {
		LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
	} finally {
		result.close();
		stmnt.close();
		cone.close(conexion);
}
	return lstuvs;
}

//public void droptablas(String user) throws SQLException {
//	
//	String sql = "drop table #Temppaqueteava"+user;
//	String sql2 = "drop table #Temppaquetemaiava"+user;
//	ConexionAvaluosbd cone = null;
//	Connection conexion = null;
//	Statement stmnt = null;
//	System.out.println("antes de la ejecucion");
//	try {
//		cone = new ConexionAvaluosbd();
//		conexion = cone.getConexion();
//		stmnt = conexion.createStatement();
//		System.out.println("sql: " +sql);
//		stmnt.executeUpdate(sql);
//		System.out.println("sql2: " +sql2);
//		stmnt.executeUpdate(sql2);
//	} catch (NamingException e) {
//		LOG.debug("Error en CalculadorDao.uvs" + e.getMessage());
//	} finally {
//		stmnt.close();
//		cone.close(conexion);
//	}
//
//	return;
//}
//
//public String infomacionID(String sql)throws SQLException {
//	ConexionAvaluosbd cone = null;
//	Connection conexion = null;
//	ResultSet result = null;
//	Statement stmnt = null;
//	String nombre = null;
//	System.out.println("el sql ya formado"+sql);
//	try {
//		System.out.println("empiesa el metodo a trbajar");
//		cone = new ConexionAvaluosbd();
//		conexion = cone.getConexion();
//		System.out.println("despues de conexion y antes del crearestatement");
//		stmnt = conexion.createStatement();
//		System.out.println(sql);
//		result = stmnt.executeQuery(sql);
//		nombre="";
//		if (result != null){
//			if (result.next()) {
//				nombre=nombre+result.getString("paterno")+" ";
//				nombre=nombre+result.getString("materno")+" ";
//				nombre=nombre+result.getString("nombre");
//			}
//		}else{
//			System.out.println("algo esta mal");
//			nombre="no encontrado";
//		}
//	} catch (NamingException e) {
//		System.out.println("falla en query Existe Avaluo");
//		LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//	} finally {
//		result.close();
//		stmnt.close();
//		cone.close(conexion);
//	}
//	return nombre;
//}
//
//public String rfcOferente(String sql)throws SQLException {
//	ConexionAvaluosbd cone = null;
//	Connection conexion = null;
//	ResultSet result = null;
//	Statement stmnt = null;
//	String rfc=null;
//	System.out.println("el sql ya formado"+sql);
//	try {
//		System.out.println("empiesa el metodo a trbajar");
//		cone = new ConexionAvaluosbd();
//		conexion = cone.getConexion();
//		System.out.println("despues de conexion y antes del crearestatement");
//		stmnt = conexion.createStatement();
//		System.out.println(sql);
//		result = stmnt.executeQuery(sql);
//		if (result != null){
//			if (result.next()) {
//				rfc=result.getString("rfc");	
//			}
//		}else{
//			System.out.println("algo esta mal");
//		}
//	} catch (NamingException e) {
//		System.out.println("falla en query Existe Avaluo");
//		LOG.debug("Error en CalculadorDao.existeAva: " + e.getMessage());
//	} finally {
//		result.close();
//		stmnt.close();
//		cone.close(conexion);
//	}
//	return rfc;
//}
//
}