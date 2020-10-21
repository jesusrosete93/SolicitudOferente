package mx.org.infonavit.solicitud.oferente.controllers;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogosController {
	
	
	private static final Logger LOGGER = LogManager.getLogger(CatalogosController.class);
	
	
	@Autowired
	private CatalogosBusines serviceCatalogosBusines;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/initConsultaCatalogos.htm",method=RequestMethod.GET)
	public String initConsultaCatalogos()
	{
		LOGGER.info("Cargando vista para la consulta de catalogos...");
		return "viewInitCatalogos";
	}
	
	@RequestMapping(value="/initCargaCatalogos.htm",method=RequestMethod.GET)
	public String inicializarCargaCatalogos()
	{
		LOGGER.info("Cargando vista para la carga de catalogos...");
		return "viewInitCargaCatalogos";
	}
	
	
	@RequestMapping(value="/cargarCatalogos.htm",method=RequestMethod.POST)
	public String handlerRequestCargarCatalogos(Model model)
	{
		try
		{
			serviceCatalogosBusines.cargarCatalogos();
			model.addAttribute("mensaje","Carga de catalogos exitosa");
			return "viewCatalogosSuccess";
		}catch (Exception e) {
			LOGGER.error("Error en la carga de catalogos",e);
			model.addAttribute("mensaje","Error al cargar los catalogos");
			return "viewCatalogosFail";
		}
		 
	}
}
