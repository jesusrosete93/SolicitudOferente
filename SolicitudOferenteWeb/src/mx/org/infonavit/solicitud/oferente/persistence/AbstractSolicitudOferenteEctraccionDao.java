/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudIDSolicitudOferenteVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteExtraccionVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;

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
public abstract class AbstractSolicitudOferenteEctraccionDao<T>{
	
	/**
	 * Realiza la ocnexión hacia la base de datos. 
	 */
	@Autowired
	@Qualifier("jdbcVivienda")
	protected JdbcTemplate  jdbcVivienda;
	@Autowired
	@Qualifier("jdbcAvaluos")
	protected JdbcTemplate  jdbcAvaluos;
	@Autowired
	@Qualifier("jdbcTablasComunes")
	protected JdbcTemplate  jdbcTablasComunes;

	
	
	/**
	 * 
	 * @param registro
	 * @return 
	 * @return
	 */
	
	public abstract boolean guardarOferenteSolicitud(SolicitudOferenteExtraccionVo  registro);
	public abstract int guardarOferenteSolicitudInt(SolicitudOferenteExtraccionVo  registro);
	public abstract List<T>  guardarArchivos(SolicitudOferenteExtraccionVo  registro);
	public abstract boolean updateSolicitud(SolicitudOferenteExtraccionVo  registro);
	public abstract  void guardarSolicitud(T registro);
	public abstract boolean guardar(String[] criterios);
	public abstract boolean guardarLista(List<T> registros);
	public abstract List<T> buscarLista(T registro);
	public abstract List<T> buscarSolicitud(T registro);
	public abstract Set<T> buscarUnicos(T registro);
	public abstract T buscar(T registro);
	public abstract String generarCriterios(T registro,List<Object> parametros);
	public abstract String  generarCriteriosBusqueda(T criterios);
	public String[] guardarLista(String[] criterios) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
	
	
	
	
	
	
	

	
	
	

}
