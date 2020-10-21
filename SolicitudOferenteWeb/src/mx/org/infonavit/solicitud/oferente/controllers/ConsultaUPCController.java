package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaUPCDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaUPCForm;
import mx.org.infonavit.solicitud.oferente.forms.UnidadValuacionForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCUPCUtils;
import mx.org.infonavit.solicitud.oferente.utils.Resources;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
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
 * Esta clase procesa las peticiones 
 * para la consulta de peritos y controladores
 * @author Adrian Alverto Casas Lopez Avansis Desarrollos SA de CV
 *
 */
@Controller
public class ConsultaUPCController {
	
	private static Logger LOGGER = LogManager.getLogger(ConsultaUPCController.class);
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	@Autowired
	@Qualifier("ConsultaUPCParametrosValidator")
	private Validator validatorParam;
	
	@Autowired
	@Qualifier("ConsultaUPCCamposValidator")
	private Validator validatorData;
	
	
	@RequestMapping(value="/initViewConsultaUPC.htm",method=RequestMethod.GET)
	public String initConsultaUPC(Model model)
	{
		LOGGER.info("[CUPCC] - Inicialiando consulta UPC...");
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("consultaUPCForm", getForma());
		LOGGER.info("[CUPCC] - Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info("[CUPCC] - Redireccionando al formulario");
		return "initViewConsultaUPC";
	}
	
	
	@RequestMapping(value="/parametrosConsultaUPC.htm",method=RequestMethod.POST)
	public String handleRequestConsultaUPCParametros(@ModelAttribute("consultaUPCForm") ConsultaUPCForm forma,
												  BindingResult result,Model model)
	{
		LOGGER.info("[CUPCC] - Formulario["+forma+"]");
		validatorParam.validate(forma, result);
		
		if( result.hasErrors() )
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "initViewConsultaUPC";
		}
		else
		{
			LOGGER.info("[CUPCC] - Procesando criterios de busqueda...");
			LOGGER.info("[CUPCC] - Forma: ["+forma+"]");
			model.addAttribute("camposUV", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(1));
			model.addAttribute("camposCob", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(2));
			model.addAttribute("camposControlador", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(5));
			model.addAttribute("camposPerito", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(6));
			model.addAttribute("consultaUPCForm", forma);
			LOGGER.info("[CUPCC] - Redireccionanado a los datos");
			return "viewConsultaUPC";
		}
		
		
		
	}
	
	@RequestMapping(value="/processConsultaUPC.htm",method=RequestMethod.POST)
	public String handleRequestConsultaUPCDatos(@ModelAttribute("consultaUPCForm") ConsultaUPCForm forma,
												  BindingResult result,Model model)
	{
		LOGGER.info("[CUPCC] - Procesando criterios y datos para busqueda...");
		LOGGER.info("[CUPCC] - Forma["+forma+"]");
		
		validatorData.validate(forma,result);
		
		if( result.hasErrors())
		{
			LOGGER.info("[CUPCC] - Forma con errores");
			model.addAttribute("camposUV", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(1));
			model.addAttribute("camposCob", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(2));
			model.addAttribute("camposControlador", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(5));
			model.addAttribute("camposPerito", BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(6));
			model.addAttribute("consultaUPCForm", forma);
			return "viewConsultaUPC";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getUnidadValuacionForm().getCamposUnidadValuacion()!=null && !forma.getUnidadValuacionForm().getCamposUnidadValuacion().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getUnidadValuacionForm().getCamposUnidadValuacion());
			}
			if( forma.getCoberturaForm().getCamposCobertura()!=null && !forma.getCoberturaForm().getCamposCobertura().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCoberturaForm().getCamposCobertura());
			}
			if( forma.getControladorForm().getCamposControlador()!=null && !forma.getControladorForm().getCamposControlador().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getControladorForm().getCamposControlador());
			}
			if( forma.getPeritoForm().getCamposPerito()!=null && !forma.getPeritoForm().getCamposPerito().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getPeritoForm().getCamposPerito());
			}
			
			if(consultaAvaluosGenericaBusiness.consultarInformacionUPC(CriteriosConsultaUPCDomain.getObjetoDomain(forma))==1)
			{
				List<List<String>> informacion = consultaAvaluosGenericaBusiness.getInformacion();
				if( !informacion.isEmpty() )
				{
					LOGGER.info("[CUPCC] - Redireccionanado a mostrar datos");
					
					List<String> columnas = OrdenamientoCamposCUPCUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
					
					if( columnas.contains("Estatus unidad"))
					{
						final int indice = columnas.indexOf("Estatus unidad");
						LOGGER.info("El indice es: "+indice);
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
						LOGGER.info("El indice es: "+indice);
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
						LOGGER.info("El indice es: "+indice);
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
						LOGGER.info("El indice es: "+indice);
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
							}
						});
					}
					if( columnas.contains("Estado cobertura"))
					{
						final int indice = columnas.indexOf("Estado cobertura");
						LOGGER.info("El indice es: "+indice);
						CollectionUtils.forAllDo(informacion,new Closure(){
							@SuppressWarnings("unchecked")
							@Override
							public void execute(Object arg0) {
								List<String> registro = (List<String>) arg0;
								if( ((String)registro.get(indice)).trim().matches("[0-9]{5}") )
								{
									String claveEstado = ((String)registro.get(indice)).substring(0,2);
									registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(Integer.parseInt(claveEstado))));
								}else
								{
									registro.set(indice,"Sin estado");
								}
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
					
					ObjectMapper mapper= new ObjectMapper();
					String informacionJson = "";
					String columnasJson    = "";
					try
					{
						columnasJson     = mapper.writeValueAsString(columnas);
						informacionJson  = mapper.writeValueAsString(informacion);
					}catch(Exception e)
					{
						LOGGER.error("[CUPC] - Error al converitr a json las columnas:["+columnas+"] y los datos:["+informacion+"]");
					}
					
					
					
					
					LOGGER.debug("[CUPC] - ColumnasJson:["+columnas+"]");
					LOGGER.debug("[CUPC] - RegistrosJson: ["+informacionJson+"]");
					
					LOGGER.debug("[CUPC] - Columnas:["+columnas+"]");
					LOGGER.debug("[CUPC] - Registros encontrados: ["+informacion.size()+"]");
					
					model.addAttribute("columnas",columnas);
					model.addAttribute("registros",informacion);
					
					
					model.addAttribute("columnasJson",columnasJson);
					model.addAttribute("registrosJson",informacionJson);
					return "viewResultadoConsultaUPC";
				}else
				{
					model.addAttribute("mensaje","No hay resultados para los criterios dados");
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
	
	
	@ModelAttribute("consultaUPCForm")
	public ConsultaUPCForm getForma()
	{
		ConsultaUPCForm forma = new ConsultaUPCForm();
		UnidadValuacionForm unidadValuacionForm = new UnidadValuacionForm();
		
		forma.setUnidadValuacionForm(unidadValuacionForm);
		
		return forma; 
	}

}
