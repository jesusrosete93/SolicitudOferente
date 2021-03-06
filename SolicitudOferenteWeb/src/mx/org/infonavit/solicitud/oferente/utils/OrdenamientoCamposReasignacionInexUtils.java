package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposBitacoraReasignacion;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * <p>
 * 	Clase que encapsula el ordenamiento y generaci�n de columnas para la consula a la bitacora de reasignaci�nes de unidades de valuaci�n
 *  vinculado al proceso de Inex de unidades de valuaci�n.
 * </p>
 * @author Grupo EonLux
 *
 */
public class OrdenamientoCamposReasignacionInexUtils {
	

	
	/**
	 * <p>
	 * M�todo que genera el ordenamiento de los campos.
	 * </p>
	 * @param campos lista de dtos seleccionados por le usuario para mostar en el resultado de la consulta
	 * @return  listado de las columnas 
	 */
	public static List<String> ordenarCampos(List<String> campos)
	{
		List<String> regreso     			= new ArrayList<String>();
		List<String> bitacoraReasignacion 	= new ArrayList<String>();
		List<String> paquete     			= new ArrayList<String>();
		List<String> oferente     			= new ArrayList<String>();
		
	
		//Obtiene las columnas que incluira la sentencia SQL de la tabla cat_oferente
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(23).getAlias());
			}			
		},oferente);
		//Obtiene las columnas que incluira la sentencia SQL de la tabla paquete
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(11).getAlias());
			}			
		},paquete);
		//Obtiene las columnas que incluira la sentencia SQL de la tabla avaluo
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(22).getAlias());
			}			
		},bitacoraReasignacion);
		
		
		if( !oferente.isEmpty() )
		{
			Map<Integer,String> camposOferente = new TreeMap<Integer,String>();
			for( String campo : oferente )
			{
				camposOferente.put(CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposOferente.keySet())
			{
				regreso.add(CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(camposOferente.get(orden)).getAliasTabla()+"."+CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(camposOferente.get(orden)).getNombreColumna());
			}
		}
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
		if( !bitacoraReasignacion.isEmpty() )
		{
			Map<Integer,String> camposBitacoraReasignacion = new TreeMap<Integer,String>();
			for( String campo : bitacoraReasignacion )
			{
				camposBitacoraReasignacion.put(CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposBitacoraReasignacion.keySet())
			{
				regreso.add(CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(camposBitacoraReasignacion.get(orden)).getAliasTabla()+"."+CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(camposBitacoraReasignacion.get(orden)).getNombreColumna());
			}
		}
		
	 return regreso;
	}
	
	/**
	 * <p>
	 * M�todo que genera las columnas de acuerdo a los campos seleccionados para la consulta.
	 * </p>
	 * @param campos listado de criterios para la b�squeda.
	 * @return listado con el nombre de las columnas.
	 */
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_OFERENTE.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.keySet())
		{
			CampoBdVo campo = CatalogosBusines.CATALOGO_CAMPOS_PAQUETE.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		for(String key : CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.keySet())
		{
			CampoBdVo campo = CamposBitacoraReasignacion.CATALOGO_CAMPOS_BITACORA_REASIGNACION.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
		
	 return columnas;
	}
	

}
