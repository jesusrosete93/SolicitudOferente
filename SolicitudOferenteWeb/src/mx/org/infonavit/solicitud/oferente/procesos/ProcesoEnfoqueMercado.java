package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueMercadoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueMercadoVo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;
import mx.org.infonavit.solicitud.oferente.utils.Cadenas;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

public class ProcesoEnfoqueMercado implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PAC] - ";
	private static final String PROCESO = " Busqueda de avaluos ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoEnfoqueMercado.class);
	CriteriosCompartivoMercadoDomain criterios;
	private AbstractDao<EnfoqueMercadoVo> persistence;
	private List<AvaluoDomain> avaluosDomain;
	
	public ProcesoEnfoqueMercado(AbstractDao<EnfoqueMercadoVo> persistence,List<AvaluoDomain> avaluosDomain)
	{
		this.persistence = persistence; 
		this.avaluosDomain = avaluosDomain;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		List<EnfoqueMercadoVo> registros =  null;
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		LOGGER.info(PREFIJO+PROCESO+" Criterios: "+this.criterios);
		registros = persistence.buscarLista(new EnfoqueMercadoVo("",""
				                                                ,"","",""
				                                                ,"",""
				                                                ,"",""
				                                                ,"",""
				                                                ,Cadenas.getSecuencia(AvaluosUtils.obtenerIds(this.avaluosDomain),true)));
		if( registros!=null && !registros.isEmpty())
		{
			final List<EnfoqueMercadoDomain> enfoqueMercadoDomai = AvaluoBusiness.getEnfoqueMercadoDomain(registros);
//			LOGGER.info(PREFIJO+PROCESO+" - Hay:["+enfoqueMercadoDomai.size()+"], obteniendo objetos domians");
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
				@Override
				public void execute(Object arg0) {
					final AvaluoDomain avaluo = (AvaluoDomain)arg0;
					EnfoqueMercadoDomain eMTemporal = new EnfoqueMercadoDomain(avaluo.getIdAvaluo().trim());
//					LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - existe en enfoqueMercadoDomai: "+(enfoqueMercadoDomai.contains( eMTemporal )));
					if( enfoqueMercadoDomai.contains( eMTemporal ) )
					{
//						LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - existe en enfoqueMercadoDomai: "+(enfoqueMercadoDomai.contains( eMTemporal )));
						List<EnfoqueMercadoDomain> enfoquesAvaluo = new ArrayList<EnfoqueMercadoDomain>();
						CollectionUtils.select(enfoqueMercadoDomai, new Predicate(){
																					@Override
																					public boolean evaluate(Object arg0) {
																						EnfoqueMercadoDomain emd = (EnfoqueMercadoDomain)arg0;
//																						LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - EMIDAvaluo["+emd.getIdAvaluo()+"] - emd.getIdAvaluo().trim().equals(avaluo.getIdAvaluo().trim()): "+(emd.getIdAvaluo().trim().equals(avaluo.getIdAvaluo().trim())));
																						return emd.getIdAvaluo().trim().equals(avaluo.getIdAvaluo().trim());
																					}
																	},enfoquesAvaluo);
//						LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - total enfoqusMercadoDomain: "+(enfoquesAvaluo.size()));
						avaluo.setEnfoquesMercado(enfoquesAvaluo);
					}else
					{
//						LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - No existe en enfoqueMercadoDomai: "+(enfoqueMercadoDomai.contains( eMTemporal )));
						avaluo.setEnfoquesMercado(new ArrayList<EnfoqueMercadoDomain>());
					}
				}
			});
		}else
		{
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
																		@Override
																		public void execute(Object arg0) {
																			((AvaluoDomain)arg0).setEnfoquesMercado(new ArrayList<EnfoqueMercadoDomain>());
																		}
																	});
		}
	 LOGGER.info(PREFIJO+PROCESO+FIN_OK);
     return this.avaluosDomain;
	}
}
