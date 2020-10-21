package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.AvaluoMAIBusiness;
import mx.org.infonavit.solicitud.oferente.business.BitacoraAvaluoMapBusiness;
import mx.org.infonavit.solicitud.oferente.business.PeticionBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.ResumenEnvioAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.forms.EnvioAvaluoForm;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoFotosAvaluo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnvioAvaluoController {
	
	private static final Logger LOGGER = LogManager.getLogger(EnvioAvaluoController.class);
	private static final String PREFIJO_MENSAJE = "[EAC] - ";
	
	@Autowired
	@Qualifier("EnvioAvaluoValidator")
	private Validator validator;
	
	@Autowired
	private AvaluoMAIBusiness service;
	
	@Autowired
	private PeticionBusiness servicePeticion;
	
	@Autowired
	private BitacoraAvaluoMapBusiness serviceBitacora;
	
	
	@RequestMapping(value="initEnvioAvaluoMai.htm",method=RequestMethod.GET)
	public String inicializarEnvioAvaluos(Model model)
	{
		LOGGER.info(PREFIJO_MENSAJE+"Inicializando vista para envio de avaluos...");
		model.addAttribute("envioForm", getForm());
		LOGGER.info(PREFIJO_MENSAJE+" redireccionanado a la vista:viewEnvioAvaluoInit");
		return "viewEnvioAvaluoInit";
	}
	
	@RequestMapping(value="buscarAvaluosMai.htm",method=RequestMethod.POST)
	public String procesarPeticionEnvioAvaluo(@ModelAttribute("envioForm") EnvioAvaluoForm forma,
											  BindingResult result,Model model,HttpServletRequest request)
	{
		LOGGER.info(PREFIJO_MENSAJE+"Procesando petición para el envio de avaluos...");
		ExecutorService executor = null;
		try
		{
			validator.validate(forma,result);
			if( result.hasErrors())
			{
				LOGGER.info(PREFIJO_MENSAJE+" Forma con errores, redireccionanado a la vista:viewEnvioAvaluoInit");
				return "viewEnvioAvaluoInit";
			}else
			{
				List<AvaluoCerradoMaiDomain> avaluos = service.consultarAvaluosCerrados(forma.getFechaCierreInicio(),forma.getFechaCierreFin());
				
				CollectionUtils.forAllDo(avaluos,new Closure(){
					@Override
					public void execute(Object object) {
						AvaluoCerradoMaiDomain.formatearObjeto((AvaluoCerradoMaiDomain)object);
					}
				});
				
				
				if( avaluos!=null && !avaluos.isEmpty())
				{
					LOGGER.info(PREFIJO_MENSAJE+"Total de avaluos cerrados encontrados: "+avaluos.size());
					int NUMERO_DE_THREADS = 4;
					int NUMERO_DE_REGISTROS = avaluos.size();
					
					LOGGER.info(PREFIJO_MENSAJE+"Threads: "+NUMERO_DE_THREADS);
					LOGGER.info(PREFIJO_MENSAJE+"Avaluos encontrados: "+NUMERO_DE_REGISTROS);
					
					
					int minimoDeRegstrosPorThread = NUMERO_DE_REGISTROS / NUMERO_DE_THREADS;
					int maximoDeRegistrosPorThread = minimoDeRegstrosPorThread + 1;
					int threadsConMaximodDeRegistros = NUMERO_DE_REGISTROS - NUMERO_DE_THREADS * minimoDeRegstrosPorThread;
					int inicio = 0;
					
					LOGGER.info(PREFIJO_MENSAJE+"minimoDeRegstrosPorThread: "+minimoDeRegstrosPorThread);
					LOGGER.info(PREFIJO_MENSAJE+"maximoDeRegistrosPorThread: "+maximoDeRegistrosPorThread);
					LOGGER.info(PREFIJO_MENSAJE+"threadsConMaximodDeRegistros: "+threadsConMaximodDeRegistros);
					
					List<Future<List<AvaluoCerradoMaiDomain>>> listaFuture = new ArrayList<Future<List<AvaluoCerradoMaiDomain>>>();
					executor  = Executors.newFixedThreadPool(NUMERO_DE_THREADS);
					
					
					
					for (int i = 0; i < NUMERO_DE_THREADS; i++) 
					{
						int registros = (i < threadsConMaximodDeRegistros ? maximoDeRegistrosPorThread : minimoDeRegstrosPorThread);
				        int fin = inicio + registros;
				        LOGGER.info(PREFIJO_MENSAJE+"Thread["+i+"] registros:["+avaluos.subList(inicio, fin).size()+"]  elementos:"+AvaluosUtils.obtenerIdsAavaluos(avaluos.subList(inicio, fin)));
				        listaFuture.add(executor.submit(new ProcesoFotosAvaluo( avaluos.subList(inicio, fin),servicePeticion,serviceBitacora) ));
				        inicio = fin;
					 }
					
					List<AvaluoCerradoMaiDomain> envioCompleto = new ArrayList<AvaluoCerradoMaiDomain>();
					List<AvaluoCerradoMaiDomain> envioAvaluo = new ArrayList<AvaluoCerradoMaiDomain>();
					List<AvaluoCerradoMaiDomain> todos = new ArrayList<AvaluoCerradoMaiDomain>();
					
					for( Future<List<AvaluoCerradoMaiDomain>> f : listaFuture  )
					{
						LOGGER.info(PREFIJO_MENSAJE+"Validando procesados...");
						for( AvaluoCerradoMaiDomain avaluo : f.get() )
						{
							LOGGER.info(PREFIJO_MENSAJE+"Avaluo: "+avaluo.getIdAvaluo() + " Resultado envio1:["+avaluo.getResultadoEnvio1()+"] - mensaje:["+avaluo.getRespuestaEnvio1()+"]"+" Resultado envio2:["+avaluo.getResultadoEnvio2()+"] - mensaje:["+avaluo.getRespuestaEnvio2()+"]");
							
							if( avaluo.isEnvioAvaluo() && avaluo.isEnvioFoto() )
							{
								if( !envioCompleto.contains(envioCompleto.indexOf(avaluo)))
								{
									envioCompleto.add(avaluo);
								}
							}else if( avaluo.isEnvioAvaluo() && !avaluo.isEnvioFoto() )
							{
								if( !envioAvaluo.contains(envioAvaluo.indexOf(avaluo)))
								{
									envioAvaluo.add(avaluo);
								}
							}
							if( !todos.contains(todos.indexOf(avaluo)))
							{
								todos.add(avaluo);
							}
						}
					}
					executor.shutdown();
					
					if( !executor.awaitTermination(60,TimeUnit.SECONDS))
					{
						executor.shutdownNow();
					}
					
					ResumenEnvioAvaluoDomain resumenEnvioDomain = new ResumenEnvioAvaluoDomain();
					resumenEnvioDomain.setTotalAvaluos(avaluos.size());
					resumenEnvioDomain.setFechaInicio(forma.getFechaCierreInicio());
					resumenEnvioDomain.setFechaFin(forma.getFechaCierreFin());
					resumenEnvioDomain.setEnviadosConFoto(envioCompleto.size());
					resumenEnvioDomain.setEnviadosSinFoto(envioAvaluo.size());
					LOGGER.info(PREFIJO_MENSAJE+"Periodo - Fecha Inicio["+forma.getFechaCierreInicio()+"] FechaFin["+forma.getFechaCierreFin()+"]");
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos encontrados: "+(todos.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos enviados con foto: "+(envioCompleto.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos enviados sin foto: "+(envioAvaluo.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Resumen: "+(resumenEnvioDomain.toString()));
					LOGGER.info(PREFIJO_MENSAJE+"Finaliza el envio de avaluos");
//					String datos = "";
//					ObjectMapper mapper = new ObjectMapper();
//					datos = mapper.writeValueAsString(todos);
//					LOGGER.info("[CASC] - Datos formato Json: ["+datos+"]");
					model.addAttribute("resumen",resumenEnvioDomain);
					model.addAttribute("avaluos",todos);
//					model.addAttribute("avaluosJson",datos);
					LOGGER.info(PREFIJO_MENSAJE+" redireccionanado a la vista:viewResultadoEnvio");
					return "viewResultadoConsultaEnvio";
				}else
				{
					if( executor!=null )
					{
						executor.shutdown();
						if( !executor.awaitTermination(60,TimeUnit.SECONDS))
						{
							executor.shutdownNow();
						}
					}
					LOGGER.info("No hay avaluos cerrados");
					result.rejectValue("errores","error.general.mensaje",new Object[]{"No existen avaluos cerrados para el rango de fechas proporcionado"},"");
					return "viewEnvioAvaluoInit";
				}
			}
		}catch (Exception e) {
			executor.shutdownNow();
			Thread.currentThread().interrupt();
			LOGGER.info(PREFIJO_MENSAJE+"No hay avaluos cerrados");
			model.addAttribute("mensaje","Error al procesar la petición");
			return "viewEnvioAvaluoInit";
		}
	}
	
	
	@ModelAttribute("envioForm")
	public EnvioAvaluoForm getForm()
	{
		return new EnvioAvaluoForm();
	}
	
	
	public static void main (String args[])
	{
		List<String> lista = new ArrayList<String>();
		
		int NUMERO_THREADS = 4;
		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		lista.add("6");
		lista.add("7");
		lista.add("8");
		lista.add("9");
		lista.add("10");
		
		int TAMANIO = lista.size();
		
		System.out.println("Threads: "+NUMERO_THREADS);
		System.out.println("Elementos: "+TAMANIO);
		
		
		int minItemsPerThread = TAMANIO / NUMERO_THREADS;
		System.out.println("Minimo Elementos por thread: "+minItemsPerThread); 
		
		int maxItemsPerThread = minItemsPerThread + 1;
		System.out.println("Maximo Elementos por thread: "+maxItemsPerThread);
		
		int threadsWithMaxItems = lista.size() - 4 * minItemsPerThread;
		System.out.println("Maximo de elementos de 1 thread: "+threadsWithMaxItems);
		
		
		 int start = 0;
		 for (int i = 0; i < NUMERO_THREADS; i++) {
		        int itemsCount = (i < threadsWithMaxItems ? maxItemsPerThread : minItemsPerThread);
		        int end = start + itemsCount;
		        System.out.println("Iteración: "+(i) +" De:: "+start+ " A:"+(end));
//		        Runnable r = new Processor(items.subList(start, end));
//		        futures.add(exec.submit(r));
		        start = end;
		    }

		
		

	   
		
	}
	

}
