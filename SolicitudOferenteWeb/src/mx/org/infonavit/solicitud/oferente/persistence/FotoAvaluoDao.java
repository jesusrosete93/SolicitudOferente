package mx.org.infonavit.solicitud.oferente.persistence;
//package mx.org.infonavit.reporteuvs.persistence;
//
//import static mx.org.infonavit.reporteuvs.utils.Cadenas.AND;
//import static mx.org.infonavit.reporteuvs.utils.Cadenas.COMILLA;
//import static mx.org.infonavit.reporteuvs.utils.Cadenas.IGUAL;
//import static mx.org.infonavit.reporteuvs.utils.Cadenas.WHERE;
//import static mx.org.infonavit.reporteuvs.utils.Cadenas.validar;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Set;
//
//import mx.org.infonavit.reporteuvs.persistence.vo.FotoAvaluoVo;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.stereotype.Repository;
//
//@Repository("FotoAvaluoDao")
//public class FotoAvaluoDao extends AbstractDao<FotoAvaluoVo> {
//	
//	public static boolean FOTO = false;
//	
//	private class FotoAvaluoExtractor implements ResultSetExtractor<FotoAvaluoVo>
//	{
//		@Override
//		public FotoAvaluoVo extractData(ResultSet resultSet) throws SQLException,DataAccessException {
//			if( resultSet!=null && resultSet.next() )
//			{
//				return new FotoAvaluoVo( resultSet.getInt("id_registro"),validar(resultSet.getString("id_avaluo"),"")
//        			    				,resultSet.getInt("id_imagen"),resultSet.getBlob("archivo"),validar(resultSet.getString("tipo_archivo"),"")
//        			    				,validar(resultSet.getString("pie_foto"),""),validar(resultSet.getString("fecha_alta"),""),validar(resultSet.getString("observaciones"),""));
//				
//				
////				if( FotoAvaluoDao.FOTO )
////				{
////					return new FotoAvaluoVo( resultSet.getInt("id_registro"),validar(resultSet.getString("id_avaluo"),"")
////			                			    ,resultSet.getInt("id_imagen"),resultSet.getBlob("archivo"),validar(resultSet.getString("tipo_archivo"),"")
////			                			    ,validar(resultSet.getString("pie_foto"),""),validar(resultSet.getString("fecha_alta"),""),validar(resultSet.getString("observaciones"),""));
////				}else{
////					return new FotoAvaluoVo( resultSet.getInt("id_registro"),validar(resultSet.getString("id_avaluo"),"")
////            			    				,resultSet.getInt("id_imagen"),null,validar(resultSet.getString("tipo_archivo"),"")
////            			    				,validar(resultSet.getString("pie_foto"),""),validar(resultSet.getString("fecha_alta"),""),validar(resultSet.getString("observaciones"),""));
////				}
//			}else
//			{
//				return null;
//			}
//		}
//	}
//	
////	private class FotoAvaluoMapper implements RowMapper<FotoAvaluoVo>
////	{
////		@Override
////		public FotoAvaluoVo mapRow(ResultSet resultSet, int arg1)
////				throws SQLException {
////
////			if( FotoAvaluoDao.FOTO )
////			{
////				return new FotoAvaluoVo( resultSet.getInt("id_registro"),validar(resultSet.getString("id_avaluo"),"")
////		                			    ,resultSet.getInt("id_imagen"),resultSet.getBlob("archivo"),validar(resultSet.getString("tipo_archivo"),"")
////		                			    ,validar(resultSet.getString("pie_foto"),""),validar(resultSet.getString("fecha_alta"),""),validar(resultSet.getString("observaciones"),""));
////			}else{
////				return new FotoAvaluoVo( resultSet.getInt("id_registro"),validar(resultSet.getString("id_avaluo"),"")
////        			    				,resultSet.getInt("id_imagen"),null,validar(resultSet.getString("tipo_archivo"),"")
////        			    				,validar(resultSet.getString("pie_foto"),""),validar(resultSet.getString("fecha_alta"),""),validar(resultSet.getString("observaciones"),""));
////			}
////		
////		}
////	}
//
//
//	@Override
//	public FotoAvaluoVo buscar(FotoAvaluoVo registro) {
//		try
//		{
//			String sentencia = "SELECT * FROM fotos_avaluo WITH(NOLOCK) ";
//			String criterios = generarCriterios(registro,null);
//			
//			if( criterios!=null && !criterios.trim().equals(""))
//			{
//			 sentencia = sentencia + WHERE + criterios;
//			}
//			
////			return this.jdbcAvaluos.queryForObject(sentencia,new FotoAvaluoMapper());
//			return this.jdbcAvaluosDoc.query(sentencia,new FotoAvaluoExtractor());
//		}catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		
//		 
//	}
//
//	@Override
//	public List<FotoAvaluoVo> buscarLista(FotoAvaluoVo registro) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String generarCriterios(FotoAvaluoVo registro, List<Object> parametros) 
//	{
//		StringBuilder sb = new StringBuilder();
//		if( registro.getIdRegistro()!=0)
//		{
//			if( sb.length()>0 )
//			{
//				sb.append(AND).append("id_registro").append(IGUAL).append(registro.getIdRegistro());
//			}else
//			{
//				sb.append("id_registro").append(IGUAL).append(registro.getIdRegistro());
//			}
//		}
//		if( registro.getIdAvaluo()!=null && !registro.getIdAvaluo().trim().equals("") )
//		{
//			if( sb.length()>0 )
//			{
//				sb.append(AND).append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
//			}else
//			{
//				sb.append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
//			}
//		}
//		if( registro.getIdImagen()!=0 )
//		{
//			if( sb.length()>0 )
//			{
//				sb.append(AND).append("id_imagen").append(IGUAL).append(registro.getIdImagen());
//			}else
//			{
//				sb.append("id_imagen").append(IGUAL).append(registro.getIdImagen());
//			}
//		}
//		
//		if( sb==null)
//		{
//			throw new IllegalAccessError("No hay criterios para realiar la busquedad de foto");
//		}
//	return sb.toString();	
//   }
//
//	@Override
//	public boolean guardar(FotoAvaluoVo registro) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean guardar(List<FotoAvaluoVo> registros) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Set<FotoAvaluoVo> buscarUnicos(FotoAvaluoVo registro) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
