package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.Inex;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaInexDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaInexForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposInexGeneralUtils;

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
 * <p>
 *  Clase que encapsula el procesamiento de peticiones para 
 *  la consulta del Inex General.
 * </p> 
 * @author Adrian Casas
 *
 */
@Controller
public class ConsultaInexGeneralController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaInexGeneralController.class);
	private static final String PREFIJO_LOG = "[CIGC] - ";
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	@Autowired
	@Qualifier("ConsultaInexGeneralParametrosValidator")
	private Validator validatorParam;
	
	@Autowired
	@Qualifier("ConsultaInexGeneralCamposValidator")
	private Validator validatorData;
	
	
	@RequestMapping(value="/initViewConsultaInex.htm",method=RequestMethod.GET)
	public String initConsultaInexGeneral(Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Inicialiando consulta Inex general...");
		model.addAttribute("inexs",Inex.CATALOGO_INEX_REGISTRADOS);
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("consultaInexGeneralForm", getForma());
		LOGGER.info(PREFIJO_LOG+"Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista initViewConsultaInex...");
		return "initViewConsultaInex";
	}
	
	
	@RequestMapping(value="/parametrosConsultaInexGeneral.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralParametros(@ModelAttribute("consultaInexGeneralForm") ConsultaInexForm forma,
												  BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Formulario["+forma+"]");
		validatorParam.validate(forma, result);
		
		if( result.hasErrors() )
		{
			model.addAttribute("inexs",Inex.CATALOGO_INEX_REGISTRADOS);
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "initViewConsultaInex";
		}
		else
		{
			LOGGER.info(PREFIJO_LOG+"Procesando criterios de busqueda...");
			LOGGER.info(PREFIJO_LOG+"Forma: ["+forma+"]");
			model.addAttribute("camposInexGeneral", BuilderMapeosBeanSQLUtils.generarMapeoCamposInexGeneral());
			model.addAttribute("consultaInexGeneralForm", forma);
			LOGGER.info(PREFIJO_LOG+"Redireccionanado a la vista ");
			return "initViewConsultaInexParametros";
		}
	}
	
	@RequestMapping(value="/consultarInexGeneral.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralDatos(@ModelAttribute("consultaInexGeneralForm") ConsultaInexForm forma, BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Procesando criterios y datos para busqueda de consulta inex general...");
		LOGGER.info(PREFIJO_LOG+"Forma["+forma+"]");
		
		validatorData.validate(forma,result);
		if( result.hasErrors())
		{
			LOGGER.info(PREFIJO_LOG+"Forma con errores");
			model.addAttribute("camposInexGeneral", BuilderMapeosBeanSQLUtils.generarMapeoCamposInexGeneral());
			model.addAttribute("consultaInexGeneralForm", forma);
			return "initViewConsultaInexParametros";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposInexGeneral()!=null && !forma.getCamposInexGeneral().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposInexGeneral());
			}
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionInexGeneral(CriteriosConsultaInexDomain.getObjetoDomain(forma));
			if(!informacion.isEmpty() )
			{
				LOGGER.info(PREFIJO_LOG+"Redireccionanado a mostrar datos");
				List<String> columnas = OrdenamientoCamposInexGeneralUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				if( columnas.contains("Id de unidad de valuacion"))
				{
					final int indice = columnas.indexOf("Id de unidad de valuacion");
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
				if( columnas.contains("Id del estado"))
				{
					final int indice = columnas.indexOf("Id del estado");
					CollectionUtils.forAllDo(informacion,new Closure(){
						@SuppressWarnings("unchecked")
						@Override
						public void execute(Object arg0) {
							List<String> registro = (List<String>) arg0;
							int idEstado = Integer.parseInt(registro.get(indice).substring(0,2));
							LOGGER.info("[CAC] - idEstado:["+idEstado+"]");
							registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(idEstado)));
						}
					});
				}
				
//				if( columnas.contains("Estatus unidad"))
//				{
//					final int indice = columnas.indexOf("Estatus unidad");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//						}
//					});
//				}
//				if( columnas.contains("Estatus perito"))
//				{
//					final int indice = columnas.indexOf("Estatus perito");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//						}
//					});
//				}
//				if( columnas.contains("Estatus cobertura"))
//				{
//					final int indice = columnas.indexOf("Estatus cobertura");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//						}
//					});
//				}
//				if( columnas.contains("Estatus controlador"))
//				{
//					final int indice = columnas.indexOf("Estatus controlador");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//						}
//					});
//				}
//				if( columnas.contains("Estado cobertura"))
//				{
//					final int indice = columnas.indexOf("Estado cobertura");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							if( ((String)registro.get(indice)).trim().matches("[0-9]{5}") )
//							{
//								String claveEstado = ((String)registro.get(indice)).substring(0,2);
//								registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(Integer.parseInt(claveEstado))));
//							}else
//							{
//								registro.set(indice,"Sin estado");
//							}
//						}
//					});
//				}
//				if( columnas.contains("Vivienda recuperada"))
//				{
//					final int indice = columnas.indexOf("Vivienda recuperada");
//					LOGGER.info("El indice es: "+indice);
//					CollectionUtils.forAllDo(informacion,new Closure(){
//						@SuppressWarnings("unchecked")
//						@Override
//						public void execute(Object arg0) {
//							List<String> registro = (List<String>) arg0;
//							if( ((String)registro.get(indice)).trim().equals("1") )
//							{
//								registro.set(indice,"Si");
//							}else
//							{
//								registro.set(indice,"No");
//							}
//						}
//					});
//				}
				
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
				
				
				
				
				LOGGER.debug(PREFIJO_LOG+"ColumnasJson:["+columnas+"]");
				LOGGER.debug(PREFIJO_LOG+"RegistrosJson: ["+informacionJson+"]");
				
				LOGGER.debug(PREFIJO_LOG+"Columnas:["+columnas+"]");
				LOGGER.debug(PREFIJO_LOG+"Registros encontrados: ["+informacion.size()+"]");
				
				model.addAttribute("columnas",columnas);
				model.addAttribute("registros",informacion);
				
				
				model.addAttribute("columnasJson",columnasJson);
				model.addAttribute("registrosJson",informacionJson);
				return "viewresultadoConsultaInexGeneral";
			
			}else
			{
				 LOGGER.info(PREFIJO_LOG+"Consulta sin rsultados");
				 model.addAttribute("mensaje","La consulta no tiene resultados que mostrar");
				 LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista viewConsultaVaciaFail...");
				 return "viewConsultaVaciaFail";		
			}
		}
	}
	
	
	@ModelAttribute("consultaInexGeneralForm")
	public ConsultaInexForm getForma()
	{
		ConsultaInexForm forma = new ConsultaInexForm();
		return forma; 
	}

}
