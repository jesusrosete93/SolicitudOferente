package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;


public class OrdenamientoCamposCancelacionesUtils {
	
	
	
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
		List<String> cancelacionAvaluo = new ArrayList<String>();
		List<String> historicoValorConcluido = new ArrayList<String>();
		List<String> respaldoCancelacionAvaluo = new ArrayList<String>();
		
		
		
		
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
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(8).getAlias());
			}
			
		},cancelacionAvaluo);
		
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(9).getAlias());
			}
			
		},historicoValorConcluido);
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				// TODO Auto-generated method stub
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(10).getAlias());
			}
			
		},respaldoCancelacionAvaluo);
	
		
		
		
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
		if( !cancelacionAvaluo.isEmpty() )
		{
			Map<Integer,String> camposBitacora = new TreeMap<Integer,String>();
			for( String campo : cancelacionAvaluo )
			{
				camposBitacora.put(CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposBitacora.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(camposBitacora.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(camposBitacora.get(orden)).getNombreColumna());
			}
		}
		if( !historicoValorConcluido.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : historicoValorConcluido )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		if( !respaldoCancelacionAvaluo.isEmpty() )
		{
			Map<Integer,String> camposTemporal = new TreeMap<Integer,String>();
			for( String campo : respaldoCancelacionAvaluo )
			{
				camposTemporal.put(CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposTemporal.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(camposTemporal.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(camposTemporal.get(orden)).getNombreColumna());
			}
		}
		
		return regreso;
	}
	
	
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
	

		return columnas;
	}
	

}
