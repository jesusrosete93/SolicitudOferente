package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.AvaluosSubValuadosBusiness;
import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoSubValuadoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluoSubValuadoForm;

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
/**
 * Encapsula la consulta de 
 * avalúos subvaluados.
 * @author Adrian Casas Avansis Desarrollos SA de CV.
 *
 */
@Controller
public class ConsultaAvaluosSubvaluadosController {
	
	/**
	 * Permite enviar a la consola y al archivo de log 
	 * mensajes de texto.
	 */
	private static Logger LOGGER = LogManager.getLogger(ConsultaAvaluosSubvaluadosController.class);
	
	@Autowired
	private AvaluosSubValuadosBusiness serviceAvaluos;
	
	/**
	 * Permite validar los parametros de entrada
	 * con los cuales se puede realizar la busqueda.
	 */
	@Autowired
	@Qualifier("ConsultaAvaluoSubValuadoValidator")
	private Validator validator;
	
	/**
	 * Inicializa la vista para iniciar 
	 * con la consulta de avaluos subvaluados.
	 * @param model modelo del aplicativo que contiene: formularios y objetos de negocio.
	 * @return nombre de la vista.
	 */
	@RequestMapping(value="/initConsultaAS.htm",method=RequestMethod.GET)
	public String inicializarFormulario(Model model)
	{
		LOGGER.info("[CASC] - Inicializando formulario para consulta de avaluos subvaluados");
		model.addAttribute("consultaASForm",new ConsultaAvaluoSubValuadoForm());
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("catalogoSubvaluados",CatalogosBusines.CATALOGO_SUBVALUADOS);
		LOGGER.info("[CASC] - Redireccionanado a la vista de consulta de avaluos subvaluados");
		return "viewInitConsultaAS";
	}
	/**
	 * Procesa la petición del usuario para generar un reporte de avaluos subvaluados
	 * @param forma objeto que contiene los parametros de busqueda
	 * @param result objeto que contiene los posibles errores que los parametros de busqueda pueden llegar a tener
	 * @param model objeto que contiene el reporte de avaluos
	 * @return nombre de la vista
	 */
	@RequestMapping(value="/consultaAS.htm",method=RequestMethod.POST)
	public String processRequest(@ModelAttribute("consultaASForm")ConsultaAvaluoSubValuadoForm forma,
		 	 					BindingResult result,  Model model)
	{
		LOGGER.info("[CASC] - Petición dara consulta de avaluos subvaluados, inicio...");
		LOGGER.info("[CASC] - Petición dara consulta de avaluos subvaluados, forma valores: "+forma);
		validator.validate(forma,result);
		
		if( result.hasErrors())
		{
			LOGGER.info("[CASC] - Petición dara consulta de avaluos subvaluados, forma con errores");
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			model.addAttribute("catalogoSubvaluados",CatalogosBusines.CATALOGO_SUBVALUADOS);
			return "viewInitConsultaAS";
		}else
		{
			LOGGER.info("[CASC] - Petición dara consulta de avaluos subvaluados, forma sin errores, procesando..");
			
			
			List<AvaluoSubValuadoDomain> reporte = serviceAvaluos.buscarAvaluosSubvaluados(
																  AvaluosSubValuadosBusiness.
																  	generarObjetoAvaluoSubValuadoVo
																  	(
																		forma.getIdAvaluo(),forma.getIdPaquete(),forma.getIdVivienda(),
																		forma.getIdUnidadValuacion(),forma.getBandera(),forma.getCodigoPostal(),
																		forma.getBandera(),forma.getFechaCierreInicio(),forma.getFechaCierreFin())
																	);
			
			if( !reporte.isEmpty() )
			{
				LOGGER.info("[CASC] - Redireccionanado a mostrar datos");
				String datos = "";
				model.addAttribute("avaluos",reporte);
				try
				{
				ObjectMapper mapper = new ObjectMapper();
				datos = mapper.writeValueAsString(reporte);
				LOGGER.info("[CASC] - Datos formato Json: ["+datos+"]");
				}catch (Exception e) {
					LOGGER.info("[CASC] - Error al convertit a Json el reporte de avaluos subvaluados",e);
				}
				model.addAttribute("avaluosJson",datos);
				return "viewResultadosAS";
			}else
			{
				result.rejectValue("errores", "error.consulta.vacia");
				model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
				model.addAttribute("catalogoSubvaluados",CatalogosBusines.CATALOGO_SUBVALUADOS);
				return "viewInitConsultaAS";		
			}
		}
		
	}

}
