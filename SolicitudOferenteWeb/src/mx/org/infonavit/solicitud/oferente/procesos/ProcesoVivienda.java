package mx.org.infonavit.solicitud.oferente.procesos;



import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ViviendaVo;

import org.apache.log4j.Logger;

public class ProcesoVivienda implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO = "[PDA] - ";
	private static final String PROCESO = " Proceso vivienda avaluo ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoVivienda.class);
	CriteriosCompartivoMercadoDomain criterios;
	private AbstractDao<ViviendaVo> persistence;
	private List<AvaluoDomain> avaluosDomain;
	
	
	public ProcesoVivienda(AbstractDao<ViviendaVo> persistence,List<AvaluoDomain> avaluosDomain)
	{
		this.persistence = persistence;
		this.avaluosDomain = avaluosDomain;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		List<AvaluoDomain> regreso =  new ArrayList<AvaluoDomain>();
		ExecutorService executor = null;
		
		LOGGER.info(PREFIJO+INICIO_OK);
		LOGGER.info(PREFIJO+"Total de avaluos cerrados encontrados: "+avaluosDomain.size());
		try
		{
			int NUMERO_DE_THREADS = 20;
			int NUMERO_DE_REGISTROS = this.avaluosDomain.size();
			
			LOGGER.info(PREFIJO+"Threads: "+NUMERO_DE_THREADS);
			LOGGER.info(PREFIJO+"Avaluos encontrados: "+NUMERO_DE_REGISTROS);
			
			
			int minimoDeRegstrosPorThread = NUMERO_DE_REGISTROS / NUMERO_DE_THREADS;
			int maximoDeRegistrosPorThread = minimoDeRegstrosPorThread + 1;
			int threadsConMaximodDeRegistros = NUMERO_DE_REGISTROS - NUMERO_DE_THREADS * minimoDeRegstrosPorThread;
			int inicio = 0;
			
			LOGGER.info(PREFIJO+"minimoDeRegstrosPorThread: "+minimoDeRegstrosPorThread);
			LOGGER.info(PREFIJO+"maximoDeRegistrosPorThread: "+maximoDeRegistrosPorThread);
			LOGGER.info(PREFIJO+"threadsConMaximodDeRegistros: "+threadsConMaximodDeRegistros);
			
			List<Future<List<AvaluoDomain>>> listaFuture = new ArrayList<Future<List<AvaluoDomain>>>();
			executor  = Executors.newFixedThreadPool(NUMERO_DE_THREADS);
			

			for (int i = 0; i < NUMERO_DE_THREADS; i++) 
			{
				int registros = (i < threadsConMaximodDeRegistros ? maximoDeRegistrosPorThread : minimoDeRegstrosPorThread);
		        int fin = inicio + registros;
		        LOGGER.info(PREFIJO+PROCESO+"Thread["+i+"] registros:["+this.avaluosDomain.subList(inicio, fin).size()+"]");
		        listaFuture.add(executor.submit(new ProcesoViviendasConsulta("ProcesoVivienda"+(i),  this.persistence, this.avaluosDomain.subList(inicio, fin) ) ));
		        inicio = fin;
			}
			for( Future<List<AvaluoDomain>> f : listaFuture  )
			{
//				LOGGER.info(PREFIJO+"Validando procesados...");
				for( AvaluoDomain avaluo : f.get() )
				{
//					LOGGER.info(PREFIJO+"Avaluo: "+avaluo.getIdAvaluo());
					if( !regreso.contains(avaluo) )
					{
						regreso.add(avaluo);
					}
				}
			}
			LOGGER.info(PREFIJO+PROCESO+"Avaluos domain obtenidos: "+regreso.size());
			LOGGER.info(PREFIJO+PROCESO+FIN_OK);
		}catch (Exception e) 
		{
			LOGGER.info(PREFIJO+PROCESO+PROCESO+FIN_NOK);
			LOGGER.info(PREFIJO+PROCESO+PROCESO,e);
			throw new Exception("Error en el proceso de vivienda",e);
		}finally
		{
			if( executor!=null )
			{
				executor.shutdown();
				if( !executor.awaitTermination(60,TimeUnit.SECONDS))
				{
					executor.shutdownNow();
				}
			}
		}
	 return regreso;
	}
	
	
	
	private class ProcesoViviendasConsulta implements Callable<List<AvaluoDomain>>
	{
		private List<AvaluoDomain> avaluosDomainInner;
		private String nombreThread;
		public ProcesoViviendasConsulta(String nombreThread, AbstractDao<ViviendaVo> persistenceVivienda,List<AvaluoDomain> registros)
		{
			this.nombreThread = nombreThread;
			this.avaluosDomainInner = registros;
		}
		
		@Override
		public List<AvaluoDomain> call() throws Exception {
			List<AvaluoDomain> regreso = new ArrayList<AvaluoDomain>();
			LOGGER.info(PREFIJO+"["+this.nombreThread+"] - Consultando información de: ["+this.avaluosDomainInner.size()+"]");
			try
			{
				for(AvaluoDomain domain : this.avaluosDomainInner)
				{
					domain.setViviendaD( AvaluoBusiness.getViviendaDomain( persistence.buscar( new ViviendaVo( domain.getPaquete(),domain.getVivienda() ) ) ) );
					regreso.add( domain );
				}
				LOGGER.info(PREFIJO+"["+this.nombreThread+"] - Regresando: ["+regreso.size()+"]");
			}catch (Exception e) {
				LOGGER.error(PREFIJO+"["+this.nombreThread+"] - Error en la consulta de: ["+avaluosDomainInner.size()+"]",e);
				throw new Exception("["+this.nombreThread+"] - Error en la consulta de:["+avaluosDomainInner.size()+"]",e);
			}
			
			return regreso;
		}
	}
	
	
//	@Override
//	public List<AvaluoDomain> call() throws Exception {
//		LOGGER.info(PREFIJO+INICIO_OK);
//		CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
//																	@Override
//																	public void execute(Object arg0) {
//																		AvaluoDomain registro = (AvaluoDomain)arg0;
//																		registro.setViviendaD(AvaluoBusiness.getViviendaDomain(persistence.buscar(new ViviendaVo(registro.getPaquete(),registro.getVivienda()))));
//																	}
//																}
//														);
//		 LOGGER.info(PREFIJO+FIN_OK);
//         return this.avaluosDomain;
//	}
}
