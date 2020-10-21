package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;


public class OrdenamientoCamposCUPCUtils {
	

	
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
		List<String> cobertura = new ArrayList<String>();
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
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(2).getAlias());
			}
			
		},cobertura);
		
		
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
			Map<Integer,String> camposUnidadValuacion = new TreeMap<Integer,String>();
			for( String campo : unidadValuacion )
			{
				camposUnidadValuacion.put(CatalogosBusines.CATALOGO_CAMPOS_UV.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposUnidadValuacion.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposUnidadValuacion.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposUnidadValuacion.get(orden)).getNombreColumna());
			}
		}
		if( !cobertura.isEmpty() )
		{
			Map<Integer,String> camposCobertura = new TreeMap<Integer,String>();
			for( String campo : cobertura )
			{
				camposCobertura.put(CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposCobertura.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(camposCobertura.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(camposCobertura.get(orden)).getNombreColumna());
			}
		}
		if( !controlador.isEmpty() )
		{
			Map<Integer,String> camposControlador = new TreeMap<Integer,String>();
			for( String campo : controlador )
			{
				camposControlador.put(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposControlador.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposControlador.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR.get(camposControlador.get(orden)).getNombreColumna());
			}
		}
		if( !perito.isEmpty() )
		{
			Map<Integer,String> camposPerito = new TreeMap<Integer,String>();
			for( String campo : perito )
			{
				camposPerito.put(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposPerito.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposPerito.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_PERITO.get(camposPerito.get(orden)).getNombreColumna());
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
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_COBERTURA.get(key);
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
