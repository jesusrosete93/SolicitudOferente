package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;


public class OrdenamientoCamposConsultaAvaluosUtil {
	
	
	
	/**
	 * 
	 * @param campos
	 * @param idTabla
	 * @return
	 */
	public static List<String> ordenarCampos(List<String> campos)
	{
		List<String> regreso = new ArrayList<String>();
		
		List<String> unidadValuacion = new ArrayList<String>();
		List<String> vivienda = new ArrayList<String>();
		List<String> avaluo = new ArrayList<String>();
		List<String> detalleAvaluo = new ArrayList<String>();
		List<String> controlador = new ArrayList<String>();
		List<String> perito = new ArrayList<String>();
		
		
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(1).getAlias());
			}
			
		},unidadValuacion);
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(15).getAlias());
			}
			
		},vivienda);
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(16).getAlias());
			}
			
		},avaluo);
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(14).getAlias());
			}
			
		},detalleAvaluo);
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(5).getAlias());
			}
			
		},controlador);
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(6).getAlias());
			}
			
		},perito);
		
		
		
		if( !unidadValuacion.isEmpty() )
		{
			Map<Integer,String> camposPaquete = new TreeMap<Integer,String>();
			for( String campo : unidadValuacion )
			{
				camposPaquete.put(CatalogosBusines.CATALOGO_CAMPOS_UV.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposPaquete.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposPaquete.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposPaquete.get(orden)).getNombreColumna());
			}
		}
	
		if( !vivienda.isEmpty() )
		{
			Map<Integer,String> camposBitacora = new TreeMap<Integer,String>();
			for( String campo : vivienda )
			{
				camposBitacora.put(CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposBitacora.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(camposBitacora.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(camposBitacora.get(orden)).getNombreColumna());
			}
		}
		if( !avaluo.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : avaluo )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				if( orden == 2 )
				{
					regreso.add("substring(a.id_avaluo,0,3) AS Estado");
				}else
				{
					regreso.add(CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(camposTemporal.get(orden)).getNombreColumna());
				}
				
			}
		}
		
		if( !detalleAvaluo.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : detalleAvaluo )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		if( !controlador.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : controlador )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		if( !perito.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : perito )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		
		return regreso;
	}
	
	
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		boolean estado = false;
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_AVALUO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_AVALUO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
			if( !estado && campos.contains("substring(a.id_avaluo,0,3) AS Estado")) 
			{
				columnas.add("Estado avaluo");
				estado=true;
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PERITO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}

		return columnas;
	}
	

}
