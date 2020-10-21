package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;


public class OrdenamientoCamposSancionesUtils {
	
	
	
	/**
	 * 
	 * @param campos
	 * @param idTabla
	 * @return
	 */
	public static List<String> ordenarCampos(List<String> campos)
	{
		List<String> regreso = new ArrayList<String>();
		
		List<String> sancion = new ArrayList<String>();
		List<String> catalogoSancionado = new ArrayList<String>();
		List<String> catalogoTipoSancion = new ArrayList<String>();
		List<String> catalogoSancionador = new ArrayList<String>();
		List<String> catalogoUV = new ArrayList<String>();
		List<String> delegacion = new ArrayList<String>();
		List<String> controlador = new ArrayList<String>();
		List<String> perito = new ArrayList<String>();
		
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(7).getAlias());
			}
			
		},sancion);
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(17).getAlias());
			}
			
		},catalogoSancionado);
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(18).getAlias());
			}
			
		},catalogoTipoSancion);
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(19).getAlias());
			}
			
		},catalogoSancionador);

		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(1).getAlias());
			}
			
		},catalogoUV);
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(20).getAlias());
			}
			
		},delegacion);
	
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
		
		
		if( !sancion.isEmpty() )
		{
			Map<Integer,String> camposSancion = new TreeMap<Integer,String>();
			for( String campo : sancion )
			{
				camposSancion.put(CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposSancion.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(camposSancion.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(camposSancion.get(orden)).getNombreColumna());
			}
		}
		if( !catalogoSancionado.isEmpty() )
		{
			Map<Integer,String> camposSancionado = new TreeMap<Integer,String>();
			for( String campo : catalogoSancionado )
			{
				camposSancionado.put(CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO .get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposSancionado.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.get(camposSancionado.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.get(camposSancionado.get(orden)).getNombreColumna());
			}
		}
		if( !catalogoTipoSancion.isEmpty() )
		{
			Map<Integer,String> camposTipoSancion = new TreeMap<Integer,String>();
			for( String campo : catalogoTipoSancion )
			{
				camposTipoSancion.put(CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION .get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTipoSancion.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.get(camposTipoSancion.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.get(camposTipoSancion.get(orden)).getNombreColumna());
			}
		}
		if( !catalogoSancionador.isEmpty() )
		{
			Map<Integer,String> camposSancionador = new TreeMap<Integer,String>();
			for( String campo : catalogoSancionador )
			{
				camposSancionador.put(CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR .get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposSancionador.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.get(camposSancionador.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.get(camposSancionador.get(orden)).getNombreColumna());
			}
		}
		if( !catalogoUV.isEmpty() )
		{
			Map<Integer,String> camposCatalogoUV = new TreeMap<Integer,String>();
			for( String campo : catalogoUV )
			{
				camposCatalogoUV.put(CatalogosBusines.CATALOGO_CAMPOS_UV.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposCatalogoUV.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposCatalogoUV.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_UV.get(camposCatalogoUV.get(orden)).getNombreColumna());
			}
		}
		if( !delegacion.isEmpty() )
		{
			Map<Integer,String> camposCobertura = new TreeMap<Integer,String>();
			for( String campo : delegacion )
			{
				camposCobertura.put(CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposCobertura.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(camposCobertura.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(camposCobertura.get(orden)).getNombreColumna());
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
	
	/**
	 * Obtiene el nombre de las columnas 
	 * @param campos
	 * @return
	 */
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCION.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCION.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_UV.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_UV.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_DELEGACION.get(key);
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
