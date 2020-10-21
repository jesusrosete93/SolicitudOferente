package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class OrdenamientoCamposAsignacionesUtils {
	
	
	
	/**
	 * 
	 * @param campos
	 * @param idTabla
	 * @return
	 */
	public static List<String> ordenarCampos(List<String> campos)
	{
		List<String> regreso = new ArrayList<String>();
		
		List<String> paquete = new ArrayList<String>();
		List<String> bitacora = new ArrayList<String>();
		List<String> temporal = new ArrayList<String>();
		
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(11).getAlias());
			}
			
		},paquete);
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(12).getAlias());
			}
			
		},bitacora);
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(13).getAlias());
			}
			
		},temporal);
		
		
		
		if( !paquete.isEmpty() )
		{
			Map<Integer,String> camposPaquete = new TreeMap<Integer,String>();
			for( String campo : paquete )
			{
				camposPaquete.put(CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposPaquete.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(camposPaquete.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(camposPaquete.get(orden)).getNombreColumna());
			}
		}
		if( !bitacora.isEmpty() )
		{
			Map<Integer,String> camposBitacora = new TreeMap<Integer,String>();
			for( String campo : bitacora )
			{
				camposBitacora.put(CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposBitacora.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(camposBitacora.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(camposBitacora.get(orden)).getNombreColumna());
			}
		}
		if( !temporal.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : temporal )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		return regreso;
	}
	
	
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
	

		return columnas;
	}
	

}
