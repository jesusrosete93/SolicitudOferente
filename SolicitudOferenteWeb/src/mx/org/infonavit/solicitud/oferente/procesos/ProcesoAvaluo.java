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
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;

import org.apache.log4j.Logger;

public class ProcesoAvaluo implements Callable<List<AvaluoDomain>>
{
	private static final String PREFIJO_MENSAJE = "[PAC] - ";
	private static final String PROCESO = " Proceso de avaluos ";
	private static final Logger LOGGER = Logger.getLogger(ProcesoAvaluo.class);
	private AbstractDao<AvaluoVo> persistenceAvaluo;
	private List<AvaluoDomain> avaluosDomain;
	

	
	
	public ProcesoAvaluo( AbstractDao<AvaluoVo> persistenceAvaluo,List<AvaluoDomain> registros)
	{
		this.persistenceAvaluo = persistenceAvaluo;
		this.avaluosDomain = registros;
	}
	
	
	@Override
	public List<AvaluoDomain> call() throws Exception {
		List<AvaluoDomain> regreso =  new ArrayList<AvaluoDomain>();
		ExecutorService executor = null;
		LOGGER.info(PREFIJO_MENSAJE+PROCESO+INICIO_OK);
		LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Total de avaluos cerrados encontrados: "+avaluosDomain.size());
		try
		{
			int NUMERO_DE_THREADS = 20;
			int NUMERO_DE_REGISTROS = this.avaluosDomain.size();
			
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Threads: "+NUMERO_DE_THREADS);
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Avaluos encontrados: "+NUMERO_DE_REGISTROS);
			
			
			int minimoDeRegstrosPorThread = NUMERO_DE_REGISTROS / NUMERO_DE_THREADS;
			int maximoDeRegistrosPorThread = minimoDeRegstrosPorThread + 1;
			int threadsConMaximodDeRegistros = NUMERO_DE_REGISTROS - NUMERO_DE_THREADS * minimoDeRegstrosPorThread;
			int inicio = 0;
			
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+"minimoDeRegstrosPorThread: "+minimoDeRegstrosPorThread);
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+"maximoDeRegistrosPorThread: "+maximoDeRegistrosPorThread);
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+"threadsConMaximodDeRegistros: "+threadsConMaximodDeRegistros);
			
			List<Future<List<AvaluoDomain>>> listaFuture = new ArrayList<Future<List<AvaluoDomain>>>();
			executor  = Executors.newFixedThreadPool(NUMERO_DE_THREADS);
			

			for (int i = 0; i < NUMERO_DE_THREADS; i++) 
			{
				int registros = (i < threadsConMaximodDeRegistros ? maximoDeRegistrosPorThread : minimoDeRegstrosPorThread);
		        int fin = inicio + registros;
		        LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Thread["+i+"] registros:["+this.avaluosDomain.subList(inicio, fin).size()+"]");
		        listaFuture.add(executor.submit(new ProcesoAvaluosConsulta("ProcesoAvaluo"+(i),  this.persistenceAvaluo, this.avaluosDomain.subList(inicio, fin) ) ));
		        inicio = fin;
			}
			for( Future<List<AvaluoDomain>> f : listaFuture  )
			{
//				LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Validando procesados...");
				for( AvaluoDomain avaluo : f.get() )
				{
//					LOGGER.info(PREFIJO_MENSAJE+PROCESO+"Avaluo: "+avaluo.getIdAvaluo());
					if( !regreso.contains(avaluo) )
					{
						regreso.add(avaluo);
					}
				}
			}
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+PROCESO+" - Avaluos domain obtenidos: "+regreso.size());
		
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+PROCESO+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+PROCESO+FIN_NOK);
			LOGGER.info(PREFIJO_MENSAJE+PROCESO+PROCESO,e);
			throw new Exception("Error en el proceso de avaluo",e);
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
	
	
	
	private class ProcesoAvaluosConsulta implements Callable<List<AvaluoDomain>>
	{
		private List<AvaluoDomain> avaluosDomainInner;
		private String nombreThread;
		public ProcesoAvaluosConsulta(String nombreThread, AbstractDao<AvaluoVo> persistenceAvaluo,List<AvaluoDomain> registros)
		{
			this.nombreThread = nombreThread;
			this.avaluosDomainInner = registros;
		}
		
		@Override
		public List<AvaluoDomain> call() throws Exception {
			List<AvaluoDomain> regreso = new ArrayList<AvaluoDomain>();
			LOGGER.info(PREFIJO_MENSAJE+"["+this.nombreThread+"] - Consultando información de: ["+this.avaluosDomainInner.size()+"]");
			try
			{
				for(AvaluoDomain domain : this.avaluosDomainInner)
				{
					regreso.add( AvaluoBusiness.getDomain(persistenceAvaluo.buscar(new AvaluoVo(domain.getIdAvaluo()))) );
				}
				LOGGER.info(PREFIJO_MENSAJE+"["+this.nombreThread+"] - Regresando: ["+regreso.size()+"]");
			}catch (Exception e) {
				LOGGER.error(PREFIJO_MENSAJE+"["+this.nombreThread+"] - Error en la consulta de: ["+avaluosDomainInner.size()+"]",e);
				throw new Exception("["+this.nombreThread+"] - Error en la consulta de:["+avaluosDomainInner.size()+"]",e);
			}
			return regreso;
		}
	}
	
//	List<AvaluoVo> registros =  null;
//	LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
//	registros = persistenceAvaluo.buscarLista(new AvaluoVo("",new ArrayList<String>(),"","","",Cadenas.getSecuencia(AvaluosUtils.obtenerIds(this.avaluosDomain),true)));
//	if( registros!=null && !registros.isEmpty() )
//	{
//		final List<AvaluoDomain> regreso = AvaluoBusiness.getListadoAvaluoDomain(registros);
//		CollectionUtils.forAllDo(this.avaluosDomain,new Closure(){
//			@Override
//			public void execute(Object arg0) {
//				AvaluoDomain avaluo = (AvaluoDomain)arg0;
//				if( regreso.contains(avaluo)  )
//				{
//					try {
//						BeanUtils.copyProperties(avaluo,regreso.get(regreso.indexOf(avaluo)));
//					} catch (Exception e) {
//						LOGGER.error(PREFIJO+" Error en la copia de atributos");
//					}
//				}
//			}
//		});
//	}else
//	{
//		LOGGER.info(PREFIJO+PROCESO+"No hay avaluos que procesar");
//	}
//return this.avaluosDomain;
}
