package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.TipoPaquete;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaPaquetesDomain;
import mx.org.infonavit.solicitud.oferente.forms.PaquetesForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposPaquetesInexUtils;

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
 *  la consulta de los paquetes para el proceso Inex de unidades de valuación.
 * </p> 
 * @author Adrian Casas
 *
 */
@Controller
public class ConsultaPaquetesInexController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaPaquetesInexController.class);
	private static final String PREFIJO_LOG = "[CPIC] - ";
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	@Autowired
	@Qualifier("ConsultaPaquetesInexParametrosValidator")
	private Validator validatorParam;
	
	@Autowired
	@Qualifier("ConsultaPaquetesInexCamposValidator")
	private Validator validatorData;
	
	
	@RequestMapping(value="/initViewConsultaPaquetesInex.htm",method=RequestMethod.GET)
	public String initConsultaInexGeneral(Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Inicialiando consulta Inex general...");
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("tiposPaquete",TipoPaquete.CATALOGO_TIPO_PAQUETE);
		model.addAttribute("formaPaquetesForm", getForma());
		LOGGER.info(PREFIJO_LOG+"Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista initViewConsultaPaquetesInex...");
		return "initViewConsultaPaquetesInex";
	}
	
	
	@RequestMapping(value="/parametrosConsultaPaquetesInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralParametros(@ModelAttribute("formaPaquetesForm") PaquetesForm forma,
												             BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Formulario["+forma+"]");
		validatorParam.validate(forma, result);
		
		if( result.hasErrors() )
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			model.addAttribute("tiposPaquete",TipoPaquete.CATALOGO_TIPO_PAQUETE);
			return "initViewConsultaPaquetesInex";
		}
		else
		{
			LOGGER.info(PREFIJO_LOG+"Procesando criterios de busqueda...");
			LOGGER.info(PREFIJO_LOG+"Forma: ["+forma+"]");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposPaquetesOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposPaquetesInex());
			model.addAttribute("formaPaquetesForm", forma);
			LOGGER.info(PREFIJO_LOG+"Redireccionanado a la vista ");
			return "initViewConsultaPaquetesInexParametros";
		}
	}
	
	@RequestMapping(value="/consultarPaquetesInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralDatos(@ModelAttribute("formaPaquetesForm") PaquetesForm forma, BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Procesando criterios y datos para busqueda de consulta inex general...");
		LOGGER.info(PREFIJO_LOG+"Forma["+forma+"]");
		
		validatorData.validate(forma,result);
		if( result.hasErrors())
		{
			LOGGER.info(PREFIJO_LOG+"Forma con errores");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposPaquetesOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposPaquetesInex());
			model.addAttribute("formaPaquetesForm", forma);
			return "initViewConsultaPaquetesInexParametros";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposPaquetes()!=null && !forma.getCamposPaquetes().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposPaquetes());
			}
			if( forma.getCamposOferente()!=null && !forma.getCamposOferente().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposOferente());
			}
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarPaquetesInex(CriteriosConsultaPaquetesDomain.getDomain(forma));
			if(!informacion.isEmpty() )
			{
				LOGGER.info(PREFIJO_LOG+"Redireccionanado a mostrar datos");
				List<String> columnas = OrdenamientoCamposPaquetesInexUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				
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
				if( columnas.contains("Estado"))
				{
					final int indice = columnas.indexOf("Estado");
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
		
				if( columnas.contains("Tipo paquete"))
				{
					final int indice = columnas.indexOf("Tipo paquete");
					CollectionUtils.forAllDo(informacion,new Closure(){
						@SuppressWarnings("unchecked")
						@Override
						public void execute(Object arg0) {
							List<String> registro = (List<String>) arg0;
							String tipoPaquete = registro.get(indice).trim();
							LOGGER.info("[CAC] - tipoPaquete:["+tipoPaquete+"]");
							registro.set(indice,TipoPaquete.CATALOGO_TIPO_PAQUETES.get(tipoPaquete));
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
					LOGGER.error(PREFIJO_LOG+"Error al converitr a json las columnas:["+columnas+"] y los datos:["+informacion+"]");
				}
				
				
				
				
				LOGGER.debug(PREFIJO_LOG+"ColumnasJson:["+columnas+"]");
				LOGGER.debug(PREFIJO_LOG+"RegistrosJson: ["+informacionJson+"]");
				
				LOGGER.debug(PREFIJO_LOG+"Columnas:["+columnas+"]");
				LOGGER.debug(PREFIJO_LOG+"Registros encontrados: ["+informacion.size()+"]");
				
				model.addAttribute("columnas",columnas);
				model.addAttribute("registros",informacion);
				
				
				model.addAttribute("columnasJson",columnasJson);
				model.addAttribute("registrosJson",informacionJson);
				return "viewResultadoConsultaPaquetesInex";
			
			}else
			{
				 LOGGER.info(PREFIJO_LOG+"Consulta sin rsultados");
				 model.addAttribute("mensaje","La consulta no tiene resultados que mostrar");
				 LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista viewConsultaVaciaFail...");
				 return "viewConsultaVaciaFail";		
			}
		}
	}
	
	
	@ModelAttribute("formaPaquetesForm")
	public PaquetesForm getForma()
	{
		PaquetesForm forma = new PaquetesForm();
		return forma; 
	}

}
