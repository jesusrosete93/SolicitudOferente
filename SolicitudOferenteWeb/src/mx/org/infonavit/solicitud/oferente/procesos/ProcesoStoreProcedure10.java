/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.procesos;

import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.utils.Resources;
import mx.org.infonavit.solicitud.oferente.vo.SpBuscar10ResultadosVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Atlas
 *
 */
@Component("ProcesoStoreProcedure10")
@Scope("prototype")
public class ProcesoStoreProcedure10 implements Runnable {
	
	private SpBuscar10ResultadosVo criterios;
	@Autowired
	@Qualifier("SPBuscar10Dao")
	private AbstractDao<SpBuscar10ResultadosVo> persistence;
	
	public ProcesoStoreProcedure10() {
		super();
	}

	public ProcesoStoreProcedure10(SpBuscar10ResultadosVo criterios) {
		super();
		this.criterios = criterios;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		this.persistence = (AbstractDao<SpBuscar10ResultadosVo>) Resources.CONTEXT.getBean("SPBuscar10Dao");
		persistence.buscar(getCriterios());
	}

	/**
	 * @return El valor de: criterios
	 */
	public SpBuscar10ResultadosVo getCriterios() {
		return criterios;
	}

	/**
	 * @param Valor: criterios a asignar en: criterios
	 */
	public void setCriterios(SpBuscar10ResultadosVo criterios) {
		this.criterios = criterios;
	}

}
