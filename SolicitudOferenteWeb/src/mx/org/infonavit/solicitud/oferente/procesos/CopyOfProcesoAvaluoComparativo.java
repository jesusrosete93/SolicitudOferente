package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DetalleAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ElementosAdicionalesVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueCostoFisicoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueMercadoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ViviendaVo;

import org.apache.log4j.Logger;

public class CopyOfProcesoAvaluoComparativo implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PAC] - ";
	private static final String PROCESO = " Proceso busqueda de información de enfoque de avaluos ";
	private static final Logger LOGGER = Logger.getLogger(CopyOfProcesoAvaluoComparativo.class);
	private AbstractDao<AvaluoVo> persistenceAvaluo;
	private AbstractDao<ViviendaVo> persistenceVivienda;
	private AbstractDao<DetalleAvaluoVo> persistenceDetalleAvaluo; 
	private AbstractDao<ElementosAdicionalesVo> persistenceEA;
	private AbstractDao<EnfoqueMercadoVo> persistenceEnfoqueMercado;
	private AbstractDao<EnfoqueCostoFisicoVo> persistenceEnfoqueCosto;
	
	
	
	private List<AvaluoDomain> avaluos;
	
	public CopyOfProcesoAvaluoComparativo( AbstractDao<AvaluoVo> persistenceA,AbstractDao<ViviendaVo> persistenceV
									,AbstractDao<DetalleAvaluoVo> persistenceDA,AbstractDao<ElementosAdicionalesVo> persistenceEA
									,AbstractDao<EnfoqueMercadoVo> persistenceEM,AbstractDao<EnfoqueCostoFisicoVo> persistenceEC
									,List<AvaluoDomain> lista)
	{
		this.avaluos = lista;
		this.persistenceAvaluo = persistenceA;
		this.persistenceVivienda=persistenceV;
		this.persistenceDetalleAvaluo = persistenceDA;
		this.persistenceEA = persistenceEA;
		this.persistenceEnfoqueMercado = persistenceEM;
		this.persistenceEnfoqueCosto = persistenceEC;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		List<AvaluoDomain> regreso = new ArrayList<AvaluoDomain>();
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		
		if( this.avaluos!=null && !this.avaluos.isEmpty() )
		{
			for(AvaluoDomain avaluo : avaluos)
			{
				avaluo = AvaluoBusiness.getDomain(persistenceAvaluo.buscar(new AvaluoVo(avaluo.getIdAvaluo(),new ArrayList<String>(),"","","","")));
				avaluo.setViviendaD(AvaluoBusiness.getViviendaDomain(persistenceVivienda.buscar(new ViviendaVo(avaluo.getPaquete(),avaluo.getVivienda()))));
				avaluo.setDetalleAvaluo(AvaluoBusiness.getDetalleAvaluoDomain(persistenceDetalleAvaluo.buscar(new DetalleAvaluoVo(avaluo.getIdAvaluo()))));
				avaluo.setElementosAdicionales(AvaluoBusiness.getElementosAdicionalesDomain(persistenceEA.buscar(new ElementosAdicionalesVo(avaluo.getIdAvaluo(),""))));
				avaluo.setEnfoquesMercado(AvaluoBusiness.getEnfoqueMercadoDomain(persistenceEnfoqueMercado.buscarLista(new EnfoqueMercadoVo(avaluo.getIdAvaluo()))));
				avaluo.setEnfoquesCFD(AvaluoBusiness.getEnfoqueCostoDomain(persistenceEnfoqueCosto.buscarLista(new EnfoqueCostoFisicoVo(avaluo.getIdAvaluo(),""))));
				regreso.add(avaluo);
			}
		}else
		{
			LOGGER.info(PREFIJO+PROCESO+"No hay avaluos que procesar");
		}
    return regreso;
	}
}
