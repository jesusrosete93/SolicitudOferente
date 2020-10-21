package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosAsignacionesDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAsignacionesForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposAsignacionesUtils;

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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value={"asignacionesForm"}, types={mx.org.infonavit.solicitud.oferente.forms.ConsultaAsignacionesForm.class})
@Controller
public class ConsultaAsignacionesController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaAsignacionesController.class);

	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	
	@Autowired
	@Qualifier("ConsultaAsignacionesParametrosValidator")
	private Validator validatorParametros;
	@Autowired
	@Qualifier("ConsultaAsignacionesCamposValidator")
	private Validator validatorCampos;
	
	
	@RequestMapping(value="/initConsultaAsignaciones.htm",method=RequestMethod.GET)
	public String intiConsulta(Model model)
	{
		LOGGER.info("[CAC] - Inicialiando consulta de asignaciones...");
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("asignacionesForm",getForma());
		LOGGER.info("[CAC] - Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info("[CAC] - Redireccionando a la captura de parametros");
		return "initViewConsultaA";
	}
	
	
	@RequestMapping(value="/processParamAsignaciones.htm",method=RequestMethod.POST)
	public String processConsultaParametros(@ModelAttribute("asignacionesForm")ConsultaAsignacionesForm forma,
											 BindingResult result,  Model model,HttpServletRequest request)
	{
		forma = (ConsultaAsignacionesForm) request.getSession().getAttribute("asignacionesForm");
		validatorParametros.validate(forma,result);
		
		if( result.hasErrors())
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "initViewConsultaA";
		}else
		{
			model.addAttribute("camposAR",BuilderMapeosBeanSQLUtils.generarMapeoCamposAsignaciones());
			model.addAttribute("cancelacionForm",forma);
			return "viewConsultaA";
		}
	}
	
	
	@RequestMapping(value="/processConsultaAsignaciones.htm",method=RequestMethod.POST)
	public String processConsultaAsignaciones(@ModelAttribute("asignacionesForm")ConsultaAsignacionesForm forma,
											 BindingResult result,  Model model,HttpServletRequest request)
	{
		forma = (ConsultaAsignacionesForm) request.getSession().getAttribute("asignacionesForm");
		validatorCampos.validate(forma,result);
		if( result.hasErrors())
		{
			model.addAttribute("camposAR",BuilderMapeosBeanSQLUtils.generarMapeoCamposAsignaciones());
			return "viewConsultaA";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposAsignaciones()!=null && !forma.getCamposAsignaciones().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposAsignaciones());
			}
			
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionAsignaciones(CriteriosAsignacionesDomain.getObjetoDomain(forma));
			
			if( !informacion.isEmpty() )
			{
				List<String> columnas = OrdenamientoCamposAsignacionesUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				
				if( columnas.contains("Unidad valuacion"))
				{
					final int indice = columnas.indexOf("Unidad valuacion");
					LOGGER.info("El indice es: "+indice);
					CollectionUtils.forAllDo(informacion,new Closure(){
						@SuppressWarnings("unchecked")
						@Override
						public void execute(Object arg0) {
							List<String> registro = (List<String>) arg0;
							registro.set(indice,CatalogosBusines.CATALOGO_UNIDADES_VALUACION.get((String)registro.get(indice)));
						}
					});
				}
				if( columnas.contains("Unidad Anterior"))
				{
					final int indice = columnas.indexOf("Unidad Anterior");
					LOGGER.info("El indice es: "+indice);
					CollectionUtils.forAllDo(informacion,new Closure(){
						@SuppressWarnings("unchecked")
						@Override
						public void execute(Object arg0) {
							List<String> registro = (List<String>) arg0;
							registro.set(indice,CatalogosBusines.CATALOGO_UNIDADES_VALUACION.get((String)registro.get(indice)));
						}
					});
				}
				LOGGER.info("[CUPC] - Registros encontrados:["+informacion.size()+"]");
				LOGGER.info("[CUPC] - Columnas a mostrar:["+columnas+"]");
				model.addAttribute("columnas",columnas);
				model.addAttribute("datos",informacion);
				LOGGER.info("[CUPCC] - Redireccionanado a mostrar datos");
				return "viewResultadoConsultaA";
			}else
			{
				 LOGGER.info("[CUPC] - No existen resultados");
				 model.addAttribute("mensaje","No hay resultados para los criterios dados");
				 LOGGER.info("[CUPC] - Redireccionando a la vista de consulta vacia");
				 return "viewConsultaVaciaFail";	
			}
		
			
			
		}
		
		
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handlerException(HttpServletRequest request,Exception exception)
	{
		LOGGER.info("[CAC] - Excepción interceptada en el controller, eliminando datos de sesión",exception);
		ConsultaAvaluosForm forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		ModelAndView model = new ModelAndView();
		LOGGER.info("[CAC] - Forma["+forma+"]");
		request.getSession().removeAttribute("asignacionesForm");
		model.addObject("mensaje","Ups!, ocurrio un error inesperado en el aplicativo");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("asignacionesForm");
		LOGGER.info("[CAC] - "+(forma!=null?forma:"No hay datos del formulario"));
		LOGGER.info("[CAC] - Redireccionando a la pantalla de errores");
		model.setViewName("viewFail");
		return model;

	}
	
	@ModelAttribute("asignacionesForm")
	public ConsultaAsignacionesForm getForma()
	{
		return new ConsultaAsignacionesForm();
	}
	
}
