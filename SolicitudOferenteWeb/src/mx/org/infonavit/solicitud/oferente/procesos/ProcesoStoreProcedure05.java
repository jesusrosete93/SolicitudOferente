/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.procesos;

import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.utils.Resources;
import mx.org.infonavit.solicitud.oferente.vo.SpBuscar05ResultadosVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Atlas
 *
 */
@Component("ProcesoStoreProcedure05")
@Scope("prototype")
public class ProcesoStoreProcedure05 implements Runnable {
	
	private SpBuscar05ResultadosVo criterios;
	@Autowired
	@Qualifier("SPBuscar05Dao")
	private AbstractDao<SpBuscar05ResultadosVo> persistence;
	
	public ProcesoStoreProcedure05() {
		super();
	}

	public ProcesoStoreProcedure05(SpBuscar05ResultadosVo criterios) {
		super();
		this.criterios = criterios;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		this.persistence = (AbstractDao<SpBuscar05ResultadosVo>) Resources.CONTEXT.getBean("SPBuscar05Dao");
		persistence.buscar(getCriterios());
	}

	/**
	 * @return El valor de: criterios
	 */
	public SpBuscar05ResultadosVo getCriterios() {
		return criterios;
	}

	/**
	 * @param Valor: criterios a asignar en: criterios
	 */
	public void setCriterios(SpBuscar05ResultadosVo criterios) {
		this.criterios = criterios;
	}

}
