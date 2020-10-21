package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.DetalleAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DetalleAvaluoVo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;
import mx.org.infonavit.solicitud.oferente.utils.Cadenas;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

public class ProcesoDetalleAvaluo implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PDA] - ";
	private static final String PROCESO = " Proceso detalle avaluo ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoDetalleAvaluo.class);
	CriteriosCompartivoMercadoDomain criterios;
	private AbstractDao<DetalleAvaluoVo> persistence;
	private List<AvaluoDomain> avaluosDomain;
	
	
	public ProcesoDetalleAvaluo( AbstractDao<DetalleAvaluoVo> persistence,List<AvaluoDomain> avaluosDomain)
	{
		this.persistence = persistence;
		this.avaluosDomain = avaluosDomain;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		List<DetalleAvaluoVo> registros = new ArrayList<DetalleAvaluoVo>();
		
		
		
		
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		LOGGER.info(PREFIJO+PROCESO+" Criterios: "+this.criterios);
		registros = persistence.buscarLista( new DetalleAvaluoVo(0,0
				   					   							,0,""
				   					   							,"",""
				   					   							,"",""
				   					   							,""
				   					   							,Cadenas.getSecuencia(AvaluosUtils.obtenerIds(this.avaluosDomain),true)
				   					   	                        )
											);
		if( registros!=null && !registros.isEmpty())
		{
			final List<DetalleAvaluoDomain> listaDetalleDomain = AvaluoBusiness.getDetalleAvaluoDomain(registros);
//			LOGGER.info(PREFIJO+PROCESO+"Hay:["+listaDetalleDomain.size()+"], obteniendo objetos domians");
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
				@Override
				public void execute(Object arg0) {
					AvaluoDomain avaluo = (AvaluoDomain)arg0;
					DetalleAvaluoDomain detalleTemporal = new DetalleAvaluoDomain(avaluo.getIdAvaluo().trim());
//					LOGGER.info("Avaluo["+avaluo.getIdAvaluo()+"] - existe en listaDetalleDomain: "+(listaDetalleDomain.contains( detalleTemporal )));
					if( listaDetalleDomain.contains( detalleTemporal ) )
					{
						avaluo.setDetalleAvaluo(listaDetalleDomain.get(listaDetalleDomain.indexOf(detalleTemporal)));
					}else
					{
						avaluo.setDetalleAvaluo(new DetalleAvaluoDomain(avaluo.getIdAvaluo()));
					}
				}
			});
		}else
		{
			CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
				@Override
				public void execute(Object arg0) {
					AvaluoDomain avaluo = (AvaluoDomain)arg0;
						avaluo.setDetalleAvaluo(new DetalleAvaluoDomain(avaluo.getIdAvaluo()));
				}
			});
		}
	LOGGER.info(PREFIJO+PROCESO+FIN_OK);
     return this.avaluosDomain;
	}
}
