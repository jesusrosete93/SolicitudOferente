package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueCostoFisicoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueCostoFisicoVo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;
import mx.org.infonavit.solicitud.oferente.utils.Cadenas;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

public class ProcesoEnfoqueCostoFisico implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PAC] - ";
	private static final String PROCESO = " Proceso enfoque costo fisico avaluos ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoEnfoqueCostoFisico.class);
	private AbstractDao<EnfoqueCostoFisicoVo> persistence;
	private List<AvaluoDomain> avaluosDomain;
	
	public ProcesoEnfoqueCostoFisico(AbstractDao<EnfoqueCostoFisicoVo> persistence, List<AvaluoDomain> avaluosDomain)
	{
		this.persistence = persistence;
		this.avaluosDomain =  avaluosDomain;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		if( this.avaluosDomain==null || this.avaluosDomain.isEmpty() )
		{
			throw new IllegalArgumentException("No hay avaluos para consultar el enfoque costo fisico");
		}else
		{
			List<EnfoqueCostoFisicoVo> registros = persistence.buscarLista(new EnfoqueCostoFisicoVo("",Cadenas.getSecuencia(AvaluosUtils.obtenerIds(this.avaluosDomain),true)));
			if( registros!=null && !registros.isEmpty())
			{
				final List<EnfoqueCostoFisicoDomain> listadoEnfoqueFisicoDomain = AvaluoBusiness.getEnfoqueCostoDomain(registros);
				CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
																			@Override
																			public void execute(Object arg0) {
																				final AvaluoDomain avaluo = (AvaluoDomain)arg0;
																				EnfoqueCostoFisicoDomain eFTemporal = new EnfoqueCostoFisicoDomain(avaluo.getIdAvaluo().trim());
																				if( listadoEnfoqueFisicoDomain.contains( eFTemporal ) )
																				{
//																					LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - existe en listadoEnfoqueFisicoDomain: "+(listadoEnfoqueFisicoDomain.contains( eFTemporal )));
																					List<EnfoqueCostoFisicoDomain> enfoquefisicoAvaluo = new ArrayList<EnfoqueCostoFisicoDomain>();
																					CollectionUtils.select(listadoEnfoqueFisicoDomain, new Predicate(){
																																				@Override
																																				public boolean evaluate(Object arg0) {
																																					EnfoqueCostoFisicoDomain emd = (EnfoqueCostoFisicoDomain)arg0;
																																					return emd.getIdAvaluo().trim().equals(avaluo.getIdAvaluo().trim());
																																				}
																																},enfoquefisicoAvaluo);
//																					LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - total enfoqusFisicoDomain: "+(enfoquefisicoAvaluo.size()));
																					avaluo.setEnfoquesCFD(enfoquefisicoAvaluo);
																				}else
																				{
																					avaluo.setEnfoquesCFD(new ArrayList<EnfoqueCostoFisicoDomain>());
																				}
																			}
																		});
			}else
			{
				CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
																			@Override
																			public void execute(Object arg0) {
																				((AvaluoDomain)arg0).setEnfoquesCFD(new ArrayList<EnfoqueCostoFisicoDomain>());
																			}
																		});
			}
		}
	 LOGGER.info(PREFIJO+PROCESO+FIN_OK);
	 return this.avaluosDomain;
	}
}
