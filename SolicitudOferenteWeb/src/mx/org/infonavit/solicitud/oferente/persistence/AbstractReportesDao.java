/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Encapsula las siguientes operaciones 
 * hacia la base de datos con la que se opera.
 * 
 *  <ul>
 *      <li>Buscar</li>
 *      <li>Actualizar</li>
 *      <li>Borrar</li>
 *  
 * @author Adrian Alberto Casa Lopez
 * @since 0.0
 * @version 0.0
 */
public abstract class AbstractReportesDao<T>{
	
	/**
	 * Realiza la ocnexión hacia la base de datos. 
	 */
	@Autowired
	@Qualifier("jdbcVivienda")
	protected JdbcTemplate  jdbcVivienda;
	/**
	 * Realiza la ocnexión hacia la base de datos de tablas comunes. 
	 */
	@Autowired
	@Qualifier("jdbcTablasComunes")
	protected JdbcTemplate  jdbcTablasComunes;
	/**
	 * Realiza la ocnexión hacia la base de datos de avaluos. 
	 */
	@Autowired
	@Qualifier("jdbcAvaluos")
	protected JdbcTemplate  jdbcAvaluos;
	

	
	
	/**
	 * 
	 * @param registro
	 * @return
	 */
	public abstract List<T> buscarReporteInexOferente(T criterios);
	public abstract String  generarCriteriosBusqueda(T criterios);
	
	
	
	
	
	

	
	
	

}
