package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.List;
import java.util.concurrent.Callable;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ElementosAdicionalesDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ElementosAdicionalesVo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;
import mx.org.infonavit.solicitud.oferente.utils.Cadenas;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

public class ProcesoElementosAdicionales implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PDA] - ";
	private static final String PROCESO = " Proceso elementos adicionales avaluo ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoElementosAdicionales.class);
	CriteriosCompartivoMercadoDomain criterios;
	private AbstractDao<ElementosAdicionalesVo> persistence;
	private List<AvaluoDomain> avaluosDomain;
	
	
	public ProcesoElementosAdicionales(AbstractDao<ElementosAdicionalesVo> persistence,List<AvaluoDomain> avaluosDomain)
	{
		this.persistence = persistence;
		this.avaluosDomain = avaluosDomain;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		List<ElementosAdicionalesVo> registros = persistence.buscarLista(new ElementosAdicionalesVo("",Cadenas.getSecuencia(AvaluosUtils.obtenerIds(this.avaluosDomain),true)));
		
		if( registros!=null && !registros.isEmpty())
		{
			final List<ElementosAdicionalesDomain> listadoDomain = AvaluoBusiness.getElementosAdicionalesDomain(registros);
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
																		@Override
																		public void execute(Object arg0) {
																			AvaluoDomain avaluo = (AvaluoDomain)arg0;
																			ElementosAdicionalesDomain elemento = new ElementosAdicionalesDomain(avaluo.getIdAvaluo().trim());
//																			LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - existe en listadoDomain: "+(listadoDomain.contains( elemento )));
																			if( listadoDomain.contains( elemento ) )
																			{
																				((AvaluoDomain)arg0).setElementosAdicionales(listadoDomain.get(listadoDomain.indexOf(elemento)));
																			}else
																			{
																				avaluo.setElementosAdicionales(new ElementosAdicionalesDomain(avaluo.getIdAvaluo()));
																			}
																		}
																	});
			
		}else
		{
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
																	@Override
																	public void execute(Object arg0) {
																		AvaluoDomain avaluo = (AvaluoDomain)arg0;
																		avaluo.setElementosAdicionales(new ElementosAdicionalesDomain(avaluo.getIdAvaluo()));
																	}
																});
		}
		LOGGER.info(PREFIJO+PROCESO+FIN_OK);
      return this.avaluosDomain;
	}
}
