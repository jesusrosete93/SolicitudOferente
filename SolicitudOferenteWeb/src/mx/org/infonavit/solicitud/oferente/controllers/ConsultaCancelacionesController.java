package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCancelacioneaDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionesForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCancelacionesUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultaCancelacionesController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaCancelacionesController.class);

	@Autowired
	@Qualifier("ConsultaCancelacionesParametrosValidator")
	private Validator validatorParametros;
	@Autowired
	@Qualifier("ConsultaCancelacionesCamposValidator")
	private Validator validatorCampos;
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	
	@RequestMapping(value="/initConsultaCancelaciones.htm",method=RequestMethod.GET)
	public String intiConsulta(Model model)
	{
		LOGGER.info("[CCC] - Inicializando formulario para consulta de cancelacines");
		model.addAttribute("cancelacionForm",getForma());
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		LOGGER.info("[CCC] - Redireccionanado a la vista de consulta de cancelaciones");
		return "initViewConsultaC";
	}
	
	
	@RequestMapping(value="/processParamCancelaciones.htm",method=RequestMethod.POST)
	public String processParametrosCancelaciones(@ModelAttribute("cancelacionForm")ConsultaCancelacionesForm forma,
											 	 BindingResult result,  Model model)
	{
		LOGGER.info("[CCC] - Procesando petición de parametros");
		validatorParametros.validate(forma,result);
		
		if( result.hasErrors())
		{
			LOGGER.info("[CCC] - Formulario con erroress");
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "initViewConsultaC";
		}else
		{
			LOGGER.info("[CCC] - Forma sin errores, redireccionanado a la seleccion de campos..");
			model.addAttribute("camposCancelaciones",BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelaciones());
			model.addAttribute("cancelacionForm",forma);
			return "viewConsultaC";
		}
	}
	
	
	@RequestMapping(value="/processConsultaCancelaciones.htm",method=RequestMethod.POST)
	public String processConsultaCancelaciones(@ModelAttribute("cancelacionForm")ConsultaCancelacionesForm forma,
											 BindingResult result,  Model model)
	{
		LOGGER.info("[CCC] - Procesando petición de campos para consulta de cancelaciones");
		validatorCampos.validate(forma,result);
		
		if( result.hasErrors())
		{
			LOGGER.info("[CCC] - Fornulario con errores");
			model.addAttribute("camposCancelaciones",BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelaciones());
			return "viewConsultaC";
		}else
		{
			LOGGER.info("[CCC] - Formulario sin errores");
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposCancelaciones()!=null && !forma.getCamposCancelaciones().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposCancelaciones());
			}
			
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionCancelacionAvaluos(CriteriosCancelacioneaDomain.getObjectDomain(forma));
			
			if( !informacion.isEmpty() )
			{
				LOGGER.info("[CUPCC] - Redireccionanado a mostrar datos");
				
				List<String> columnas = OrdenamientoCamposCancelacionesUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				
				LOGGER.debug("[CUPC] - Registros encontrados:["+informacion.size()+"]");
				LOGGER.debug("[CUPC] - Columnas a mostrar:["+columnas+"]");
				
				model.addAttribute("columnas",columnas);
				model.addAttribute("datos",informacion);
				return "viewResultadoConsultaC";
			}else
			{
				result.rejectValue("errores", "error.consulta.vacia");
				model.addAttribute("camposCancelaciones",BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelaciones());
				return "viewConsultaC";		
			}
		}
		
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handlerException(HttpServletRequest request,Exception exception)
	{
		LOGGER.info("[CAC] - Excepción interceptada en el controller, eliminando datos de sesión",exception);
		ConsultaAvaluosForm forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		ModelAndView model = new ModelAndView();
		LOGGER.info("[CAC] - FOrma["+forma+"]");
		request.getSession().removeAttribute("consultaAvaluosForm");
		model.addObject("mensaje","Ups!, ocurrio un error inesperado en el aplicativo");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		LOGGER.info("[CAC] - "+(forma!=null?forma:"No hay datos del formulario"));
		LOGGER.info("[CAC] - Redireccionando a la pantalla de errores");
		model.setViewName("viewFail");
		return model;

	}

	
	@ModelAttribute("cancelacionForm")
	public ConsultaCancelacionesForm getForma()
	{
		return new ConsultaCancelacionesForm();
	}
	
}
