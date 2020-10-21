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
 * @author Adrian Casas
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractReporteInexUvPaqueteDao<T> {
	

	
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
	

	public abstract List<T> buscarTotalViviendasPorUnidad(T criterios);
	public abstract int buscarViviendasPaquete(T criterios);
	public abstract int buscarSolicitudesPaquete(T criterios);
	public abstract int buscarTotalViviendasEstado(T criterios);
	public abstract int buscarProduccionOferentePaquetesMenor(T criterios);
	public abstract int buscarProduccionOferentePaquetesMayor(T criterios);
	public abstract List<Integer> buscarInexRegistrados();
	
	
	
	
	
	
	

	
	
	



}
