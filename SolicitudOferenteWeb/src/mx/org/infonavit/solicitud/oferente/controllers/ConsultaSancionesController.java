package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosSancionesDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaSancionesForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposSancionesUtils;

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

@SessionAttributes(value={"sancionesForm"}, types={mx.org.infonavit.solicitud.oferente.forms.ConsultaSancionesForm.class})
@Controller
public class ConsultaSancionesController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaSancionesController.class);

	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	
	@Autowired
	@Qualifier("ConsultaSancionesParametrosValidator")
	private Validator validatorParametros;
	@Autowired
	@Qualifier("ConsultaSancionesCamposValidator")
	private Validator validatorCampos;
	
	
	@RequestMapping(value="/initConsultaSanciones.htm",method=RequestMethod.GET)
	public String intiConsulta(Model model)
	{
		LOGGER.info("[CAC] - Inicialiando consulta de sanciones...");
		model.addAttribute("sancionesForm",getForma());
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("estatusSancion",CatalogosBusines.CATALOGO_ESTATUS_SANCION);
		model.addAttribute("sancionados",CatalogosBusines.CATALOGO_SANCIONADO);
		model.addAttribute("sancionador",CatalogosBusines.CATALOGO_SANCIONADOR);
		model.addAttribute("tipoSancion",CatalogosBusines.CATALOGO_TIPO_SANCION);
		LOGGER.info("[CAC] - Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info("[CAC] - Redireccionando a la captura de parametros");
		return "viewInitConsultaSanciones";
	}
	
	
	@RequestMapping(value="/processParamSanciones.htm",method=RequestMethod.POST)
	public String processConsultaParametros(@ModelAttribute("sancionesForm")ConsultaSancionesForm forma,
											 BindingResult result,  Model model,HttpServletRequest request)
	{
		forma = (ConsultaSancionesForm) request.getSession().getAttribute("sancionesForm");
		validatorParametros.validate(forma,result);
		
		if( result.hasErrors())
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			model.addAttribute("estatusSancion",CatalogosBusines.CATALOGO_ESTATUS_SANCION);
			model.addAttribute("sancionados",CatalogosBusines.CATALOGO_SANCIONADO);
			model.addAttribute("tipoSancion",CatalogosBusines.CATALOGO_TIPO_SANCION);
			return "viewInitConsultaSanciones";
		}else
		{
			model.addAttribute("camposSanciones",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(1));
			model.addAttribute("camposUnidad",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(2));
			model.addAttribute("camposDelegacion",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(3));
			model.addAttribute("camposControlador",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(4));
			model.addAttribute("camposPerito",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(5));
			model.addAttribute("sancionesForm",forma);
			return "viewConsultaSancionesCampos";
		}
	}
	
	
	@RequestMapping(value="/processConsultaSanciones.htm",method=RequestMethod.POST)
	public String processConsultaAsignaciones(@ModelAttribute("sancionesForm")ConsultaSancionesForm forma,
											 BindingResult result,  Model model,HttpServletRequest request)
	{
		forma = (ConsultaSancionesForm) request.getSession().getAttribute("sancionesForm");
		validatorCampos.validate(forma,result);
		if( result.hasErrors())
		{
			model.addAttribute("camposSanciones",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(1));
			model.addAttribute("camposUnidad",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(2));
			model.addAttribute("camposDelegacion",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(3));
			model.addAttribute("camposControlador",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(4));
			model.addAttribute("camposPerito",BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(5));
			return "viewConsultaSancionesCampos";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getUnidad().getCamposUnidadValuacion()!=null && !forma.getUnidad().getCamposUnidadValuacion().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getUnidad().getCamposUnidadValuacion());
			}
			if( forma.getCobertura().getCamposCobertura()!=null && !forma.getCobertura().getCamposCobertura().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCobertura().getCamposCobertura());
			}
			if( forma.getControlador().getCamposControlador()!=null && !forma.getControlador().getCamposControlador().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getControlador().getCamposControlador());
			}
			if( forma.getPerito().getCamposPerito()!=null && !forma.getPerito().getCamposPerito().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getPerito().getCamposPerito());
			}
			if( forma.getSancion().getCamposSancion()!=null && !forma.getSancion().getCamposSancion().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getSancion().getCamposSancion());
			}

			
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionSanciones(CriteriosSancionesDomain.getObjetoDomain(forma));
			
			if( !informacion.isEmpty() )
			{
				List<String> columnas = OrdenamientoCamposSancionesUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				
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
				return "viewResultadoSancionesAvaluos";
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
		request.getSession().removeAttribute("sancionesForm");
		model.addObject("mensaje","Ups!, ocurrio un error inesperado en el aplicativo");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("sancionesForm");
		LOGGER.info("[CAC] - "+(forma!=null?forma:"No hay datos del formulario"));
		LOGGER.info("[CAC] - Redireccionando a la pantalla de errores");
		model.setViewName("viewFail");
		return model;

	}
	
	@ModelAttribute("sancionesForm")
	public ConsultaSancionesForm getForma()
	{
		return new ConsultaSancionesForm();
	}
	
}


