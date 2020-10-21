package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposInexGeneral;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * <p>
 * 	Clase que encapsula el ordenamiento y generación de columnas para la consula de Inex.
 * </p>
 * @author Adrian Casas
 *
 */
public class OrdenamientoCamposInexGeneralUtils {
	

	
	/**
	 * <p>
	 * Método que genera el ordenamiento de los campos.
	 * </p>
	 * @param campos
	 * @return 
	 */
	public static List<String> ordenarCampos(List<String> campos)
	{
		List<String> regreso = new ArrayList<String>();
		List<String> inexGeneral = new ArrayList<String>();
		
		CollectionUtils.select(campos,new Predicate(){

			@Override
			public boolean evaluate(Object arg0) {
				return ((String)arg0).startsWith(CatalogosBusines.CATALOGO_TABLAS_AVALUOS.get(21).getAlias());
			}			
		},inexGeneral);
		
		if( !inexGeneral.isEmpty() )
		{
			Map<Integer,String> camposInex = new TreeMap<Integer,String>();
			for( String campo : inexGeneral )
			{
				camposInex.put(CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(campo.substring(campo.indexOf(".")+1,campo.length())).getOrdenCampo(),campo.substring(campo.indexOf(".")+1,campo.length()));
			}
			for(Integer orden : camposInex.keySet())
			{
				regreso.add(CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(camposInex.get(orden)).getAliasTabla()+"."+CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(camposInex.get(orden)).getNombreColumna());
			}
		}
	 return regreso;
	}
	
	/**
	 * <p>
	 * Método que genera las columnas de acuerdo a los campos seleccionados para la consulta.
	 * </p>
	 * @param campos listado de criterios para la búsqueda.
	 * @return listado con el nombre de las columnas.
	 */
	public static List<String> getColumnas(List<String> campos){
		List<String> columnas = new ArrayList<String>();
		
		for(String key : CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.keySet())
		{
			CampoBdVo campo = CamposInexGeneral.CATALOGO_CAMPOS_INEX_GENERAL.get(key);
			if( campos.contains(campo.getAliasTabla().trim()+"."+campo.getNombreColumna().trim())) 
			{
				columnas.add(campo.getEtiquetaColumna());
			}
		}
	 return columnas;
	}
	

}
