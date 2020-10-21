package mx.org.infonavit.solicitud.oferente.utils;
//package mx.org.infonavit.reporteuvs.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//import mx.org.infonavit.reporteuvs.business.CatalogosBusines;
//import mx.org.infonavit.reporteuvs.persistence.vo.CampoBdVo;
//
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.collections.Predicate;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//
//import sun.nio.cs.HistoricallyNamedCharset;
//
//public class OrdenamientoCamposAvaluosUtils {
//	
//	private static final Logger LOGGER = LogManager.getLogger(OrdenamientoCamposAvaluosUtils.class);
//	
//	/**
//	 * 
//	 * @param campos
//	 * @param idTabla
//	 * @return
//	 */
//	public static List<String> ordenarCampos(List<String> campos)
//	{
//		List<String> regreso = new ArrayList<String>();
//		
//		List<String> unidadValuacion = new ArrayList<String>();
//		List<String> vivienda = new ArrayList<String>();
//		List<String> avaluo = new ArrayList<String>();
//		List<String> cobertura = new ArrayList<String>();
//		List<String> detalleAvaluo = new ArrayList<String>();
//		List<String> controlador = new ArrayList<String>();
//		List<String> perito = new ArrayList<String>();
//		
//		
//		
//		
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(1).getAlias());
//			}
//			
//		},unidadValuacion);
//		
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(15).getAlias());
//			}
//			
//		},vivienda);
//		
//		
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(16).getAlias());
//			}
//			
//		},avaluo);
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(2).getAlias());
//			}
//			
//		},cobertura);
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(14).getAlias());
//			}
//			
//		},detalleAvaluo);
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(5).getAlias());
//			}
//			
//		},controlador);
//		CollectionUtils.select(campos,new Predicate(){
//
//			@Override
//			public boolean evaluate(Object arg0) {
//				// TODO Auto-generated method stub
//				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(6).getAlias());
//			}
//			
//		},perito);
//		
//		
//		
//		if( !unidadValuacion.isEmpty() )
//		{
//			Map<Integer,String> camposPaquete = new TreeMap<Integer,String>();
//			for( String campo : unidadValuacion )
//			{
//				camposPaquete.put(CatalogosBusines.CATALOGO_CAMPOS_UV.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposPaquete.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposPaquete.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposPaquete.get(orden)).getNombreColumna());
//			}
//		}
//		if( !vivienda.isEmpty() )
//		{
//			Map<Integer,String> camposBitacora = new TreeMap<Integer,String>();
//			for( String campo : vivienda )
//			{
//				camposBitacora.put(CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposBitacora.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(camposBitacora.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(camposBitacora.get(orden)).getNombreColumna());
//			}
//		}
//		if( !avaluo.isEmpty() )
//		{
//			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
//			for( String campo : avaluo )
//			{
//				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposTemporal.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(camposTemporal.get(orden)).getNombreColumna());
//			}
//		}
//		if( !cobertura.isEmpty() )
//		{
//			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
//			for( String campo : cobertura )
//			{
//				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposTemporal.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(camposTemporal.get(orden)).getNombreColumna());
//			}
//		}
//		if( !detalleAvaluo.isEmpty() )
//		{
//			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
//			for( String campo : detalleAvaluo )
//			{
//				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposTemporal.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(camposTemporal.get(orden)).getNombreColumna());
//			}
//		}
//		if( !controlador.isEmpty() )
//		{
//			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
//			for( String campo : controlador )
//			{
//				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposTemporal.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposTemporal.get(orden)).getNombreColumna());
//			}
//		}
//		if( !perito.isEmpty() )
//		{
//			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
//			for( String campo : perito )
//			{
//				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
//			}
//			for(Integer orden : camposTemporal.keySet())
//			{
//				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposTemporal.get(orden)).getNombreColumna());
//			}
//		}
//		
//		return regreso;
//	}
//	
//	
//	public static List<String> getColumnas(List<String> campos){
//		List<String> columnas = new ArrayList<String>();
//		
//		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.keySet())
//		{
//			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(key);
//			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
//			{
//				columnas.add(campo.getEtiquetaColumna());
//			}
//		}
//		for(String key : CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.keySet())
//		{
//			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(key);
//			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
//			{
//				columnas.add(campo.getEtiquetaColumna());
//			}
//		}
//		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.keySet())
//		{
//			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(key);
//			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
//			{
//				columnas.add(campo.getEtiquetaColumna());
//			}
//		}
//	
//
//		return columnas;
//	}
//	
//
//}
