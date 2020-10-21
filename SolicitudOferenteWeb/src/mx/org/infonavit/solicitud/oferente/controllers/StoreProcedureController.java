package mx.org.infonavit.solicitud.oferente.controllers;

import mx.org.infonavit.solicitud.oferente.forms.StoreProcedureForm;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoStoreProcedure05;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoStoreProcedure10;
import mx.org.infonavit.solicitud.oferente.vo.SpBuscar05ResultadosVo;
import mx.org.infonavit.solicitud.oferente.vo.SpBuscar10ResultadosVo;

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
public class StoreProcedureController {
	
	private static final Logger LOGGER = LogManager.getLogger(StoreProcedureController.class);
	private static final String PREFIJO_MENSAJE = "[SPPC] - ";
	
	@Autowired
	@Qualifier("StoreProcedureFormValidator")
	private Validator validator;
	
	
	

	
	@RequestMapping(value="/initEjecucionSP10.htm",method=RequestMethod.GET)
	public String inicializarFormularioSP10(Model model)
	{
		LOGGER.info(PREFIJO_MENSAJE + " Inicializando vista viewInitSP10... ");
		model.addAttribute("sp10Form",new StoreProcedureForm());
		LOGGER.info(PREFIJO_MENSAJE + " Redireccionando a la vista: viewInitSP10");
		return "viewInitSP10";
	}

	@RequestMapping(value="/ejecucionSP10.htm",method=RequestMethod.POST)
	public String procesarPeticionSP10(@ModelAttribute("sp10Form") StoreProcedureForm forma,
			  BindingResult result,Model model)
	{
		String regreso = "";
		LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar10, validando parametros...");
		try
		{
			validator.validate(forma,result);
			if( result.hasErrors())
			{
				LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar10 - Hay errores en los parametros a buscar ");
				regreso = "viewInitSP10";
			}else
			{
				LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar10 - I["+forma+"] ");
				
				Thread thread = new Thread( new ProcesoStoreProcedure10(new SpBuscar10ResultadosVo(forma.getFechaInicio(),forma.getFechaFin(),"")) );
				thread.start();
				model.addAttribute("mensaje","Se ejecuta correctamente el store procedure: SP_buscar10");
				regreso = "viewSuccess";
			}
			
		}catch(Exception e)
		{
			regreso = "viewInitSP10";
			result.rejectValue("errores", "error.general.mensaje", new Object[]{"Ups!, Ocurrio un error al procesar la petición"},"");
			LOGGER.error(PREFIJO_MENSAJE + " ERROR Procesando petición para ejecución del SPBuscar10",e);
		}
		
		LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar10 - Redireccionando a la vista:"+regreso);
		return regreso;
	}
	
	@RequestMapping(value="/initEjecucionSP05.htm",method=RequestMethod.GET)
	public String inicializarFormularioSP05(Model model)
	{
		LOGGER.info(PREFIJO_MENSAJE + " Inicializando vista viewInitSP05... ");
		model.addAttribute("sp05Form",new StoreProcedureForm());
		LOGGER.info(PREFIJO_MENSAJE + " Redireccionando a la vista: viewInitSP05");
		return "viewInitSP05";
	}

	@RequestMapping(value="/ejecucionSP05.htm",method=RequestMethod.POST)
	public String procesarPeticionSP05(@ModelAttribute("sp05Form") StoreProcedureForm forma,
			  BindingResult result,Model model)
	{
		String regreso = "";
		LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar05, validando parametros...");
		try
		{
			validator.validate(forma,result);
			if( result.hasErrors())
			{
				LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar05 - Hay errores en los parametros a buscar ");
				regreso = "viewInitSP05";
			}else
			{
				LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscar05 - I["+forma+"] ");
				Thread thread = new Thread(new ProcesoStoreProcedure05( new SpBuscar05ResultadosVo(forma.getFechaInicio(),forma.getFechaFin(),"" )));
				thread.start();
				
				model.addAttribute("mensaje","Se ejecuta correctamente el store procedure: SP_buscar05");
				regreso = "viewSuccess";
			}
			
		}catch(Exception e)
		{
			LOGGER.error(PREFIJO_MENSAJE + " ERROR Procesando petición para ejecución del SPBuscar05",e);
			result.rejectValue("errores", "error.general.mensaje", new Object[]{"Ups!, Ocurrio un error al procesar la petición"},"");
			regreso = "viewInitSP05";
			
		}
		
		LOGGER.info(PREFIJO_MENSAJE + " Procesando petición para ejecución del SPBuscars05 - Redireccionando a la vista:"+regreso);
		return regreso;
	}
	

}
