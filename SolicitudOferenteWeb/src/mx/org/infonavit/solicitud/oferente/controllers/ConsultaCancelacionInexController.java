package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.TipoPaquete;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaCancelacionInexDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionInexForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCancelacionInexUtils;

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
 *  la consulta de cancelaciones de avalúo para el proceso Inex de unidades de valuación.
 * </p> 
 * @author Adrian Casas
 *
 */
@Controller
public class ConsultaCancelacionInexController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaCancelacionInexController.class);
	private static final String PREFIJO_LOG = "[CCIC] - ";
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	@Autowired
	@Qualifier("ConsultaCancelacionInexParametrosValidator")
	private Validator validatorParam;
	
	@Autowired
	@Qualifier("ConsultaCancelacionInexCamposValidator")
	private Validator validatorData;
	
	
	@RequestMapping(value="/initViewConsultaCancelacionInex.htm",method=RequestMethod.GET)
	public String initConsultaCancelacionInexGeneral(Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Inicialiando consulta Inex general...");
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("cancelacionInexForm", getForma());
		model.addAttribute("tiposPaquete",TipoPaquete.CATALOGO_TIPO_PAQUETE);
		LOGGER.info(PREFIJO_LOG+"Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista initViewConsultaPaquetesInex...");
		return "initViewConsultaCancelacionInex";
	}
	
	
	@RequestMapping(value="/parametrosConsultaCancelacionInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaCancelacionInexParametros(@ModelAttribute("cancelacionInexForm") ConsultaCancelacionInexForm forma,
												             BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Formulario["+forma+"]");
		validatorParam.validate(forma, result);
		
		if( result.hasErrors() )
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			model.addAttribute("tiposPaquete",TipoPaquete.CATALOGO_TIPO_PAQUETE);
			return "initViewConsultaCancelacionInex";
		}
		else
		{
			LOGGER.info(PREFIJO_LOG+"Procesando criterios de busqueda...");
			LOGGER.info(PREFIJO_LOG+"Forma: ["+forma+"]");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionPaqueteInex());
			model.addAttribute("camposCancelacion", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionInex());
			model.addAttribute("cancelacionInexForm", forma);
			LOGGER.info(PREFIJO_LOG+"Redireccionanado a la vista ");
			return "initViewConsultaCancelacionInexParametros";
		}
	}
	
	@RequestMapping(value="/consultarCancelacionInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaCancelacionInexDatos(@ModelAttribute("cancelacionInexForm") ConsultaCancelacionInexForm forma, BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Procesando criterios y datos para busqueda de consulta solicitudes inex...");
		LOGGER.info(PREFIJO_LOG+"Forma["+forma+"]");
		
		validatorData.validate(forma,result);
		if( result.hasErrors())
		{
			LOGGER.info(PREFIJO_LOG+"Forma con errores");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionPaqueteInex());
			model.addAttribute("camposCancelacion", BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelacionInex());
			model.addAttribute("cancelacionInexForm", forma);
			return "initViewConsultaCancelacionInexParametros";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposPaquete()!=null && !forma.getCamposPaquete().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposPaquete());
			}
			if( forma.getCamposCancelacion()!=null && !forma.getCamposCancelacion().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposCancelacion());
			}
			if( forma.getCamposOferente()!=null && !forma.getCamposOferente().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposOferente());
			}
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarCancelacionInex(CriteriosConsultaCancelacionInexDomain.getObjetoDomain(forma));
			if(!informacion.isEmpty() )
			{
				LOGGER.info(PREFIJO_LOG+"Redireccionanado a mostrar datos");
				List<String> columnas = OrdenamientoCamposCancelacionInexUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				LOGGER.info(PREFIJO_LOG+"Columnas: "+columnas);
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
				if( columnas.contains("Unidad de valuación"))
				{
					final int indice = columnas.indexOf("Unidad de valuación");
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
							if( registro.get(indice)!=null && !registro.get(indice).trim().equals(""))
							{
								int idEstado = Integer.parseInt(registro.get(indice).substring(0,2));
								LOGGER.info("[CAC] - idEstado:["+idEstado+"]");
								registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(idEstado)));
							}
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
				return "viewResultadoConsultaCancelacionInex";
			
			}else
			{
				 LOGGER.info(PREFIJO_LOG+"Consulta sin rsultados");
				 model.addAttribute("mensaje","La consulta no tiene resultados que mostrar");
				 LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista viewConsultaVaciaFail...");
				 return "viewConsultaVaciaFail";		
			}
		}
	}
	
	
	@ModelAttribute("cancelacionInexForm")
	public ConsultaCancelacionInexForm getForma()
	{
		ConsultaCancelacionInexForm forma = new ConsultaCancelacionInexForm();
		return forma; 
	}

}
