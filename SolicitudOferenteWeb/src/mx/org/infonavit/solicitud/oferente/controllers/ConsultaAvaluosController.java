/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposConsultaAvaluosUtil;
import mx.org.infonavit.solicitud.oferente.utils.Resources;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Atlas
 *
 */
@SessionAttributes(value={"consultaAvaluosForm"}, types={mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm.class})
@Controller
public class ConsultaAvaluosController {

	private final static Logger LOGGER = LogManager.getLogger(ConsultaAvaluosController.class);
	
	@Autowired
	@Qualifier("ConsultaAvaluosValidator")
	private Validator parametrosValidator;
	
	@Autowired
	@Qualifier("ConsultaAvaluosCamposValidator")
	private Validator camposValidator;
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;

	@RequestMapping(value="/initConsultaAvaluos.htm",method=RequestMethod.GET)
	public String initConsultaAvaluos(Model model) {
		LOGGER.info("[CAC] - Inicializando forma para consulta de avauluos...");
		model.addAttribute("consultaAvaluosForm",getForma());
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		LOGGER.info("[CAC] - Redireccionando al formulario de consulta de avaluos...");
		return "viewInitConsultaAvaluos";
	}

	@RequestMapping(value="/consultaAvaluosParametros.htm",method=RequestMethod.POST)
	public String handleRequestConsultaAvaluosParametros(@ModelAttribute("consultaAvaluosForm") ConsultaAvaluosForm forma, 
														 BindingResult result, Model model,HttpServletRequest request) {
		LOGGER.info("[CAC] - Procesando parametros de la forma...");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		LOGGER.info("[CAC] - Forma["+forma.toString()+"]");
		
		parametrosValidator.validate(forma,result);
		
		if( result.hasErrors() )
		{
			LOGGER.info("[CAC] - Forma con errores");
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "viewInitConsultaAvaluos";
		}else
		{
			LOGGER.info("[CAC] - Forma sin errores");
			model.addAttribute("camposUnidadValuacion",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(1));
			model.addAttribute("camposVivienda",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(3));
			model.addAttribute("camposAvaluo",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(4));
			model.addAttribute("camposDetalleAvaluo",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(5));
			model.addAttribute("camposControlador",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(6));
			model.addAttribute("camposPerito",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(7));
			LOGGER.info("[CAC] - Redireccionando al formulario de seleccion de campos de avaluos...");
			return "viewConsultaAvaluosCampos";
		}
		
		
		
	}

	@RequestMapping(value="/findConsultaAvaluos.htm",method=RequestMethod.POST)
	public String handleRequestConsultaAvaluosCampos(@ModelAttribute("consultaAvaluosForm") ConsultaAvaluosForm forma,
													 BindingResult results, Model model,SessionStatus sessionStatus,HttpServletRequest request) throws Exception 
		{
		LOGGER.info("[CAC] - Procesando campos de la forma...");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		LOGGER.info("[CAC] - Forma["+forma.toString()+"]");
		
		camposValidator.validate(forma, results);
		
		if( results.hasErrors() )
		{
			LOGGER.info("[CAC] - Forma con errores");
			model.addAttribute("camposUnidadValuacion",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(1));
			model.addAttribute("camposCobertura",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(2));
			model.addAttribute("camposVivienda",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(3));
			model.addAttribute("camposAvaluo",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(4));
			model.addAttribute("camposDetalleAvaluo",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(5));
			model.addAttribute("camposControlador",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(6));
			model.addAttribute("camposPerito",BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(7));
			return "viewConsultaAvaluosCampos";
		}else
		{
			LOGGER.info("[CAC] - Forma sin errores");
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getUnidadValuacion().getCamposUnidadValuacion()!=null && !forma.getUnidadValuacion().getCamposUnidadValuacion().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getUnidadValuacion().getCamposUnidadValuacion());
			}
			if( forma.getVivienda().getCamposVivienda()!=null && !forma.getVivienda().getCamposVivienda().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getVivienda().getCamposVivienda());
			}
			if( forma.getAvaluo().getCamposAvaluos()!=null && !forma.getAvaluo().getCamposAvaluos().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getAvaluo().getCamposAvaluos());
			}
			if( forma.getDetalleAvaluo().getCamposDetalleAvaluo()!=null && !forma.getDetalleAvaluo().getCamposDetalleAvaluo().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getDetalleAvaluo().getCamposDetalleAvaluo());
			}
			if( forma.getControlador().getCamposControlador()!=null && !forma.getControlador().getCamposControlador().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getControlador().getCamposControlador());
			}
			if( forma.getPerito().getCamposPerito()!=null && !forma.getPerito().getCamposPerito().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getPerito().getCamposPerito());
			}
			
			
//			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionAvaluo(CriteriosConsultaAvaluoDomain.getObjetoDomain(forma));
			
			if( consultaAvaluosGenericaBusiness.consultarInformacionAvaluo(CriteriosConsultaAvaluoDomain.getObjetoDomain(forma)) == 1 )
			{
				List<List<String>> informacion = consultaAvaluosGenericaBusiness.getInformacion();
				if( !informacion.isEmpty() )
				{
					LOGGER.info("[CUPCC] - Redireccionanado a mostrar datos");
					
					List<String> columnas = OrdenamientoCamposConsultaAvaluosUtil.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
					
					if( columnas.contains("Estatus unidad"))
					{
						final int indice = columnas.indexOf("Estatus unidad");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
							}
						});
					}
					if( columnas.contains("Estatus perito"))
					{
						final int indice = columnas.indexOf("Estatus perito");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
							}
						});
					}
					if( columnas.contains("Estatus cobertura"))
					{
						final int indice = columnas.indexOf("Estatus cobertura");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
							}
						});
					}
					if( columnas.contains("Estatus controlador"))
					{
						final int indice = columnas.indexOf("Estatus controlador");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
							}
						});
					}
					if( columnas.contains("Estatus avaluo"))
					{
						final int indice = columnas.indexOf("Estatus avaluo");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								String estatusAvaluo = ((String)registro.get(indice));
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get(String.valueOf(Integer.parseInt(estatusAvaluo))));
							}
						});
					}
					if( columnas.contains("Tipo mercado"))
					{
						final int indice = columnas.indexOf("Tipo mercado");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								String tipoMercado = ((String)registro.get(indice));
								registro.set(indice,CatalogosBusines.CATALOGO_TIPO_MERCADO.get(String.valueOf(Integer.parseInt(tipoMercado))));
							}
						});
					}
					if( columnas.contains("Tipo linea"))
					{
						final int indice = columnas.indexOf("Tipo linea");
						LOGGER.info("El indice es: "+indice);
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								String tipoLinea = ((String)registro.get(indice));
								registro.set(indice,CatalogosBusines.CATALOGO_TIPO_LINEA.get(String.valueOf(Integer.parseInt(tipoLinea))));
							}
						});
					}
					if( columnas.contains("Vivienda recuperada"))
					{
						final int indice = columnas.indexOf("Vivienda recuperada");
						LOGGER.info("El indice es: "+indice);
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								if( ((String)registro.get(indice)).trim().equals("1") )
								{
									registro.set(indice,"Si");
								}else
								{
									registro.set(indice,"No");
								}
							}
						});
					}
					if( columnas.contains("Estado avaluo"))
					{
						final int indice = columnas.indexOf("Estado avaluo");
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								int idEstado = Integer.parseInt(registro.get(indice));
								LOGGER.info("[CAC] - idEstado:["+idEstado+"]");
								registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(idEstado)));
							}
						});
					}
					
					LOGGER.debug("[CUPC] - Columnas:["+columnas+"]");
					LOGGER.debug("[CUPC] - Registros encontrados: ["+informacion.size()+"]");
					
					model.addAttribute("columnas",columnas);
					model.addAttribute("registros",informacion);
				
				LOGGER.info("[CAC] - Redireccionando a la vista de resultados...");
				return "viewResultadoConsultaAvaluos";
			  }else
				{
				  LOGGER.info("[CAC] - No existen resultados");
				  model.addAttribute("mensaje","No hay resultados para los criterios dados");
				  LOGGER.info("[CAC] - Redireccionando a la vista de consulta vacia");
				  return "viewConsultaVaciaFail";		
				}
			}else
			{
				  LOGGER.info("[CAC] - Consulta con demasiados resultados");
				  model.addAttribute("mensaje","La consulta regresa mas de: "+Resources.REGISTROS_POR_CONSULTA+" no es posible ejecutarla");
				  LOGGER.info("[CAC] - Redireccionando a la vista de consulta vacia");
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
		LOGGER.info("[CAC] - FOrma["+forma+"]");
		request.getSession().removeAttribute("consultaAvaluosForm");
		model.addObject("mensaje","Ups!, ocurrio un error inesperado en el aplicativo");
		forma = (ConsultaAvaluosForm) request.getSession().getAttribute("consultaAvaluosForm");
		LOGGER.info("[CAC] - "+(forma!=null?forma:"No hay datos del formulario"));
		LOGGER.info("[CAC] - Redireccionando a la pantalla de errores");
		model.setViewName("viewFail");
		return model;

	}
	
	@ModelAttribute(value="consultaAvaluosForm")
	public ConsultaAvaluosForm getForma() {
		
		return new ConsultaAvaluosForm();
	}
	
	


}
