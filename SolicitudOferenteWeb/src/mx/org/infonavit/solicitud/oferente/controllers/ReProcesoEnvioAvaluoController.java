package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.AvaluoMAIBusiness;
import mx.org.infonavit.solicitud.oferente.business.BitacoraAvaluoMapBusiness;
import mx.org.infonavit.solicitud.oferente.business.PeticionBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.BitacioraEnvioAvaluoMapDomain;
import mx.org.infonavit.solicitud.oferente.domain.ResumenEnvioAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReProcesoAvaluoForm;
import mx.org.infonavit.solicitud.oferente.persistence.vo.BitacoraEnvioAvaluoMapVo;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoFotosAvaluo;
import mx.org.infonavit.solicitud.oferente.utils.AvaluosUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
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
public class ReProcesoEnvioAvaluoController {
	
	private static final Logger LOGGER = LogManager.getLogger(ReProcesoEnvioAvaluoController.class);
	private static final String PREFIJO_MENSAJE = "[EAC] - ";
	
	@Autowired
	@Qualifier("ReProcesoEnvioAvaluoValidator")
	private Validator validator;
	

	
	@Autowired
	private PeticionBusiness servicePeticion;
	
	@Autowired
	private BitacoraAvaluoMapBusiness serviceBitacora;
	
	
	@Autowired
	private AvaluoMAIBusiness service;
	
	
	
	@RequestMapping(value="initReProcesoAvaluoMai.htm",method=RequestMethod.GET)
	public String procesarPeticionReprocesoEnvioAvaluosMai(Model model)
	{
		LOGGER.info(PREFIJO_MENSAJE+" Atendiendo petición consulta de avaluos pendientes de enviar...");
		model.addAttribute("reProcesoForm", getForm());
		LOGGER.info(PREFIJO_MENSAJE+" redireccionanado a la vista:viewReProcesoEnvioAvaluoInit");
		return "viewReProcesoEnvioAvaluoInit";
	}
	
	
	@RequestMapping(value="findPendientesAvaluoMai.htm",method=RequestMethod.POST)
	public String procesarPeticionEnvioAvaluo(@ModelAttribute("reProcesoForm") ReProcesoAvaluoForm forma,
											  BindingResult result,Model model,HttpServletRequest request)
	{
		LOGGER.info(PREFIJO_MENSAJE+"Procesando petición para el envio de avaluos...");
		try
		{
			validator.validate(forma,result);
			if( result.hasErrors())
			{
				LOGGER.info(PREFIJO_MENSAJE+" Forma con errores, redireccionanado a la vista:viewReProcesoEnvioAvaluoInit");
				return "viewReProcesoEnvioAvaluoInit";
			}else
			{
				List<BitacioraEnvioAvaluoMapDomain> registros = null;
				if( forma.getFechaEnvioInicio().trim().equals("") && forma.getFechaEnvioFin().trim().equals("") )
				{
					registros = serviceBitacora.consultarBitacoras("","","",0,-1);
				}
				
				if( !forma.getFechaEnvioInicio().trim().equals("") && !forma.getFechaEnvioFin().trim().equals("") )
				{
					registros = serviceBitacora.consultarBitacoras("",forma.getFechaEnvioInicio(),forma.getFechaEnvioFin(),0,-1);
				}
				
				if( registros!=null && !registros.isEmpty())
				{
					String datos = "";
					
					ObjectMapper mapper = new ObjectMapper();
					datos = mapper.writeValueAsString(registros);
					request.getSession().setAttribute("avaluos",registros);
					model.addAttribute("avaluosJson",datos);
					return "viewReProcesoConsultaResultado";
				}else
				{
					result.rejectValue("errores","error.consulta.vacia");
					return "viewReProcesoEnvioAvaluoInit";
				}
			}
		}catch (Exception e) {
			LOGGER.error(PREFIJO_MENSAJE+"Error al procesar petición de consulta de avaluos pendientes de enviar",e);
			request.getSession().removeAttribute("avaluos");
			result.rejectValue("errores","error.general.mensaje",new Object[]{"Ups! Ocurrio un error al intentar procesar la petición de busqueda"},"");
			return "viewReProcesoEnvioAvaluoInit";
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="sendPendientes.htm",method=RequestMethod.POST)
	public String procesarPeticionEnvioPendientes(@ModelAttribute("reProcesoForm") ReProcesoAvaluoForm forma,
											  BindingResult result,Model model,HttpServletRequest request)
	{
		LOGGER.info(PREFIJO_MENSAJE+"Procesando petición para el envio de avaluos...");
		try
		{
			List<BitacoraEnvioAvaluoMapVo> elementos = (List<BitacoraEnvioAvaluoMapVo>) request.getSession().getAttribute("avaluos");
			
			if( elementos!=null && elementos.isEmpty())
			{
				List<AvaluoCerradoMaiDomain> avaluos= new ArrayList();
				for( BitacoraEnvioAvaluoMapVo elemento : elementos )
				{
					avaluos.add(service.consultarAvaluo(elemento.getIdAvaluo()));
				}
				
				if( avaluos!=null && !avaluos.isEmpty() )
				{
					LOGGER.info(PREFIJO_MENSAJE+" Total de avaluos pendientes: "+avaluos.size());
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
					ExecutorService executor  = Executors.newFixedThreadPool(NUMERO_DE_THREADS);
					
					
					
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
					ResumenEnvioAvaluoDomain resumenEnvioDomain = new ResumenEnvioAvaluoDomain();
					resumenEnvioDomain.setTotalAvaluos(avaluos.size());
					resumenEnvioDomain.setEnviadosConFoto(envioCompleto.size());
					resumenEnvioDomain.setEnviadosSinFoto(envioAvaluo.size());
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos encontrados: "+(todos.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos enviados con foto: "+(envioCompleto.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Total avaluos enviados sin foto: "+(envioAvaluo.size()));
					LOGGER.info(PREFIJO_MENSAJE+"Resumen: "+(resumenEnvioDomain.toString()));
					LOGGER.info(PREFIJO_MENSAJE+"Finaliza el envio de avaluos pendientes");
					String datos = "";
					try
					{
					ObjectMapper mapper = new ObjectMapper();
					datos = mapper.writeValueAsString(todos);
					LOGGER.info("[CASC] - Datos formato Json: ["+datos+"]");
					}catch (Exception e) {
						LOGGER.info(PREFIJO_MENSAJE+"Error al convertit a Json el reporte de avaluos subvaluados",e);
					}
					
					model.addAttribute("resumen",resumenEnvioDomain);
					model.addAttribute("avaluos",todos);
					model.addAttribute("avaluosJson",datos);
					LOGGER.info(PREFIJO_MENSAJE+" redireccionanado a la vista:viewReProcesoEnvioAvaluoResultado");
					return "viewReProcesoEnvioAvaluoResultado";
				}else
				{
					result.rejectValue("errroes","error.general.mensaje",new Object[]{"No hay avluos por enviar"},"");
					return "viewReProcesoConsultaResultado";
				}

			}else
			{
				result.rejectValue("errroes","error.general.mensaje",new Object[]{"No hay avaluos por enviar"},"");
				return "viewReProcesoConsultaResultado";
			}
		}catch (Exception e) {
			LOGGER.error(PREFIJO_MENSAJE+"Error al procesar petición de consulta de avaluos pendientes de enviar",e);
			request.getSession().removeAttribute("avaluos");
			result.rejectValue("errroes","error.general.mensaje",new Object[]{"Ups! Ocurrio un error al enviar avaluos pendientes"},"");
			return "viewReProcesoConsultaResultado";
		}
	}
	
	
	
	@ModelAttribute("reProcesoForm")
	public ReProcesoAvaluoForm getForm()
	{
		return new ReProcesoAvaluoForm();
	}
}
