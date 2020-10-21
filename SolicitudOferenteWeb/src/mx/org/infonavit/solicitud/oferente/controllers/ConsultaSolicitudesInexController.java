package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.TipoPaquete;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaSolicitudesInex;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaSolicitudesInexForm;
import mx.org.infonavit.solicitud.oferente.utils.BuilderMapeosBeanSQLUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposSolicitudesInexUtils;

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
 *  la consulta de solicitudes de avalúo para el proceso Inex de unidades de valuación.
 * </p> 
 * @author Adrian Casas
 *
 */
@Controller
public class ConsultaSolicitudesInexController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaSolicitudesInexController.class);
	private static final String PREFIJO_LOG = "[CSIC] - ";
	
	@Autowired
	private ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness;
	
	@Autowired
	@Qualifier("ConsultaSolicitudesInexParametrosValidator")
	private Validator validatorParam;
	
	@Autowired
	@Qualifier("ConsultaSolicitudesInexCamposValidator")
	private Validator validatorData;
	
	
	@RequestMapping(value="/initViewConsultaSolicitudesInex.htm",method=RequestMethod.GET)
	public String initConsultaInexGeneral(Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Inicialiando consulta Inex general...");
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("solicitudesInexForm", getForma());
		LOGGER.info(PREFIJO_LOG+"Valor inicial de formulario: ["+getForma()+"]");
		LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista initViewConsultaPaquetesInex...");
		return "initViewConsultaSolicitudesInex";
	}
	
	
	@RequestMapping(value="/parametrosConsultaSolicitudesInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralParametros(@ModelAttribute("solicitudesInexForm") ConsultaSolicitudesInexForm forma,
												             BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Formulario["+forma+"]");
		validatorParam.validate(forma, result);
		
		if( result.hasErrors() )
		{
			model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
			return "initViewConsultaSolicitudesInex";
		}
		else
		{
			LOGGER.info(PREFIJO_LOG+"Procesando criterios de busqueda...");
			LOGGER.info(PREFIJO_LOG+"Forma: ["+forma+"]");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudesPaqueteInex());
			model.addAttribute("camposAvaluo", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudesAvaluoInex());
			model.addAttribute("solicitudesInexForm", forma);
			LOGGER.info(PREFIJO_LOG+"Redireccionanado a la vista ");
			return "initViewConsultaSolicitudesInexParametros";
		}
	}
	
	@RequestMapping(value="/consultarSolicitudesInex.htm",method=RequestMethod.POST)
	public String handleRequestConsultaInexGeneralDatos(@ModelAttribute("solicitudesInexForm") ConsultaSolicitudesInexForm forma, BindingResult result,Model model)
	{
		LOGGER.info(PREFIJO_LOG+"Procesando criterios y datos para busqueda de consulta solicitudes inex...");
		LOGGER.info(PREFIJO_LOG+"Forma["+forma+"]");
		
		validatorData.validate(forma,result);
		if( result.hasErrors())
		{
			LOGGER.info(PREFIJO_LOG+"Forma con errores");
			model.addAttribute("camposOferente", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudOferenteInex());
			model.addAttribute("camposPaquete", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudesPaqueteInex());
			model.addAttribute("camposAvaluo", BuilderMapeosBeanSQLUtils.generarMapeoCamposSolicitudesAvaluoInex());
			model.addAttribute("solicitudesInexForm", forma);
			return "initViewConsultaSolicitudesInexParametros";
		}else
		{
			ConsultaAvaluosGenericaBusiness.DATOS = new ArrayList<String>();
			if( forma.getCamposPaquete()!=null && !forma.getCamposPaquete().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposPaquete());
			}
			if( forma.getCamposAvaluo()!=null && !forma.getCamposAvaluo().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposAvaluo());
			}
			if( forma.getCamposOferente()!=null && !forma.getCamposOferente().isEmpty())
			{
				ConsultaAvaluosGenericaBusiness.DATOS.addAll(forma.getCamposOferente());
			}
			List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarSolicitudesInex(CriteriosConsultaSolicitudesInex.getObjetoDomain(forma));
			if(!informacion.isEmpty() )
			{
				LOGGER.info(PREFIJO_LOG+"Redireccionanado a mostrar datos");
				List<String> columnas = OrdenamientoCamposSolicitudesInexUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
				
				if( columnas.contains("Unidad valuacion"))
				{
					final int indice = columnas.indexOf("Unidad valuacion");
					LOGGER.debug(PREFIJO_LOG+"El indice es: "+indice);
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
							LOGGER.debug(PREFIJO_LOG+"idEstado:["+idEstado+"]");
							registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(idEstado)));
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
							String estatus = registro.get(indice);
							LOGGER.debug(PREFIJO_LOG+"idestatus:["+estatus+"]");
							if( !estatus.trim().equals("") )
							{
								registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get(estatus));
							}
							
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
							LOGGER.debug(PREFIJO_LOG+"tipoPaquete:["+tipoPaquete+"]");
							registro.set(indice,TipoPaquete.CATALOGO_TIPO_PAQUETES.get(tipoPaquete));
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
				return "viewResultadoConsultaSolicitudesInex";
			
			}else
			{
				 LOGGER.info(PREFIJO_LOG+"Consulta sin rsultados");
				 model.addAttribute("mensaje","La consulta no tiene resultados que mostrar");
				 LOGGER.info(PREFIJO_LOG+"Redireccionando a la vista viewConsultaVaciaFail...");
				 return "viewConsultaVaciaFail";		
			}
		}
	}
	
	
	@ModelAttribute("solicitudesInexForm")
	public ConsultaSolicitudesInexForm getForma()
	{
		ConsultaSolicitudesInexForm forma = new ConsultaSolicitudesInexForm();
		return forma; 
	}

}
