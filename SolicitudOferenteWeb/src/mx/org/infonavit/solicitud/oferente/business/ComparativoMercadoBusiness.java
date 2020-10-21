package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ComparativoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.ComparativoDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DetalleAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ElementosAdicionalesVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueCostoFisicoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueMercadoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ViviendaVo;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoAvaluo;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoDetalleAvaluo;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoElementosAdicionales;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoEnfoqueCostoFisico;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoEnfoqueMercado;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoVivienda;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLComparativosUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ComparativoMercadoBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(ComparativoMercadoBusiness.class);
	private static final String PREFIJO_LOG = "[CMB] - ";
	private static final String PROCESO_BUSQUEDA = " Proceso de busqueda de comparativo ";
	
	@Autowired
	@Qualifier("AvaluoDao")
	private AbstractDao<AvaluoVo> persistenceAvaluo;
	
	@Autowired
	@Qualifier("DetalleAvaluoDao")
	private AbstractDao<DetalleAvaluoVo> persistenceDetalleAvaluo; 
	
	
	@Autowired
	@Qualifier("EnfoqueMercadoDao")
	private AbstractDao<EnfoqueMercadoVo> persistenceEnfoqueMercado;
	
	@Autowired
	@Qualifier("EnfoqueCostoFisicoDao")
	private AbstractDao<EnfoqueCostoFisicoVo> persistenceEnfoqueCosto;
	
	@Autowired
	@Qualifier("ViviendaDao")
	private AbstractDao<ViviendaVo> persistenceVivienda;
	
	@Autowired
	@Qualifier("ElementoAdicionalesDao")
	private AbstractDao<ElementosAdicionalesVo> persistenceEA;
	
	@Autowired
	@Qualifier("ComparativoDao")
	private AbstractDao<AvaluoVo> persistenceComparativo;
	
	
	
	public ComparativoMercadoDomain buscarInformacion(CriteriosCompartivoMercadoDomain criterios) throws Exception
	{
		ExecutorService executor = null;
		ComparativoMercadoDomain regreso  = new ComparativoMercadoDomain();
		
		LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+INICIO_OK);
		LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+criterios);
		
		ComparativoDao.FIND = BuilderSQLComparativosUtils.generarSentencia(criterios);
		List<AvaluoVo> registrosAvaluos = persistenceComparativo.buscarLista(null);
		
		
		if( registrosAvaluos!=null && !registrosAvaluos.isEmpty()  )
		{
			LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+" Encontrados: ["+registrosAvaluos.size()+"], obteniendo domain...");	
			List<AvaluoDomain> avaluosDomain =  AvaluoBusiness.getListadoAvaluoDomain(registrosAvaluos);
			LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+" Encontrados: ["+registrosAvaluos.size()+"], domain obtenidos: ["+avaluosDomain.size()+"], procesando...");			
//			final List<AvaluoDomain> avaluosDomain = AvaluoBusiness.getListadoAvaluoDomain(persistenceAvaluo.buscarLista(new AvaluoVo("",new ArrayList<String>(),"","","",Cadenas.getSecuencia(AvaluosUtils.obtenerIds(temporal),true))));
			
			Future<List<AvaluoDomain>> futureTaskAvaluo 				= null;
			Future<List<AvaluoDomain>> futureTaskVivienda 				= null;
			Future<List<AvaluoDomain>> futureTaskDetalle 				= null;
			Future<List<AvaluoDomain>> futureTaskElementosAdicionales 	= null;
			Future<List<AvaluoDomain>> futureTaskEnfoqueMercado 		= null;
			Future<List<AvaluoDomain>> futureTaskEnfoqueCosto			= null;
			
			executor =  Executors.newFixedThreadPool(1);
			futureTaskAvaluo 				= executor.submit(new ProcesoAvaluo(persistenceAvaluo,avaluosDomain));
			futureTaskVivienda 				= executor.submit(new ProcesoVivienda(persistenceVivienda,avaluosDomain));
			futureTaskElementosAdicionales	= executor.submit(new ProcesoElementosAdicionales(persistenceEA,avaluosDomain));
			futureTaskDetalle  				= executor.submit(new ProcesoDetalleAvaluo(persistenceDetalleAvaluo,avaluosDomain));
			futureTaskEnfoqueMercado 		= executor.submit(new ProcesoEnfoqueMercado(persistenceEnfoqueMercado,avaluosDomain));
			futureTaskEnfoqueCosto			= executor.submit(new ProcesoEnfoqueCostoFisico(persistenceEnfoqueCosto,avaluosDomain));
			

			final List<AvaluoDomain> avaluos	   			= futureTaskAvaluo.get();
			final List<AvaluoDomain> vivienda	   			= futureTaskVivienda.get();
			final List<AvaluoDomain> detalleAvaluo 			= futureTaskDetalle.get();
			final List<AvaluoDomain> elementosAdicionales	= futureTaskElementosAdicionales.get();
			final List<AvaluoDomain> enfoqueMercadoAvaluo 	= futureTaskEnfoqueMercado.get();
			final List<AvaluoDomain> enfoqueCostoFisico	 	= futureTaskEnfoqueCosto.get();
			
			LOGGER.info(PREFIJO_LOG+" avaluos: "+avaluosDomain.size());
			LOGGER.info(PREFIJO_LOG+" vivienda: "+vivienda.size());
			LOGGER.info(PREFIJO_LOG+" detalleAvaluo: "+detalleAvaluo.size());
			LOGGER.info(PREFIJO_LOG+" elementosAdicionales: "+elementosAdicionales.size());
			LOGGER.info(PREFIJO_LOG+" enfoqueMercadoAvaluo: "+enfoqueMercadoAvaluo.size());
			LOGGER.info(PREFIJO_LOG+" enfoqueCostoFisico: "+enfoqueCostoFisico.size());
			
			regreso.setAvaluosDomain(avaluosDomain);
			LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+" - Avaluos encontrados: "+(regreso.getAvaluosDomain().size()));
			executor.shutdown();
			if( !executor.awaitTermination(60,TimeUnit.SECONDS))
			{
				executor.shutdownNow();
			}
		}else
		{
		  LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+"No hay avaluos que procesar");
		}
		LOGGER.info(PREFIJO_LOG+PROCESO_BUSQUEDA+FIN_OK);
	    return regreso;
	}

}
