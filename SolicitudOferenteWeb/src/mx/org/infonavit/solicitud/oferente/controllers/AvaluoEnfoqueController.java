package mx.org.infonavit.solicitud.oferente.controllers;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ComparativoMercadoBusiness;
import mx.org.infonavit.solicitud.oferente.catalogos.CatalogoEstadoConservacion;
import mx.org.infonavit.solicitud.oferente.catalogos.CatalogoMetodoConclusionAvaluo;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ComparativoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaEnfoqueForm;
import mx.org.infonavit.solicitud.oferente.utils.GenerarExcelUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Clase que atiende las peticiones 
 * para las consultas de los avaluos 
 * con ifnormación de enfoque
 * 
 * @author EON LUX Adrian Casas
 *
 */
@Component("AvaluoEnfoqueController")
@Controller
public class AvaluoEnfoqueController {
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluoEnfoqueController.class);
	private static final String PREFIJO = "[AEC] - ";
	private static final String PROCESO = " Consulta de avaluos comparativos ";
	private static final String EXPORTAR = " Proceso exportación ";
	
	@Autowired
	@Qualifier("ConsultaEnfoqueAvaluoValidator")
	private Validator validator;
	
	@Autowired
	private ComparativoMercadoBusiness serviceComparativo;
	
	
	@RequestMapping(value="/initViewConsultaAE.htm",method=RequestMethod.GET)
	public String inicializarConsulta(Model model)
	{
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		model.addAttribute("metodoConclusion",CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION);
		model.addAttribute("estadoConservacion",CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION);
		model.addAttribute("consultaEnfoqueForm", getForma());
		LOGGER.info(PREFIJO+PROCESO+" Inicializando formulario para consulta"+getForma());
		LOGGER.info(PREFIJO+PROCESO+" - Redireccionando al formulario");
		return "initViewConsultaAE";
	}
	
	@RequestMapping(value="/consultaAE.htm",method=RequestMethod.POST)
	public String procesarPeticion(@ModelAttribute("consultaEnfoqueForm") ConsultaEnfoqueForm forma,
												  BindingResult result,Model model,HttpServletRequest request)
	{
		HttpSession sesion = request.getSession();
		String regreso = "";
		LOGGER.info(PREFIJO+PROCESO+" Consultando avaluos, valores de la forma:"+getForma());
		CriteriosCompartivoMercadoDomain criterios = new CriteriosCompartivoMercadoDomain();
		
		validator.validate(forma, result);
		try
		{
			if( result.hasErrors() )
			{
				model.addAttribute("estados",CatalogosBusines.CATALOGO_DELEGACIONES);
				model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
				model.addAttribute("metodoConclusion",CatalogoMetodoConclusionAvaluo.CATALOGO_METODO_CONCLUSION);
				model.addAttribute("estadoConservacion",CatalogoEstadoConservacion.CATALOGO_ESTADO_CONSERVACION);
				return "initViewConsultaAE";
			}else
			{
				//Crietrios por avaluo - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
				criterios.setPaquete( forma.getPaquete()!=null && !forma.getPaquete().trim().equals("") ? forma.getPaquete() : "" );
				criterios.setIdAvaluo( forma.getIdAvaluo()!=null && !forma.getIdAvaluo().trim().equals("") ? forma.getIdAvaluo() : "" );
				criterios.setUnidadesValuacion( forma.getNombreUnidadValuacion()!=null && !forma.getNombreUnidadValuacion().isEmpty() ? forma.getNombreUnidadValuacion() : new ArrayList<String>() );
				criterios.setFechaCierreInicio( forma.getFechaCierreInicio()!=null && !forma.getFechaCierreInicio().trim().equals("") ? forma.getFechaCierreInicio(): ""  ); 
				criterios.setFechaCierreFin( forma.getFechaCierreFin()!=null && !forma.getFechaCierreFin().trim().equals("") ? forma.getFechaCierreFin(): "" );
				
				//Criterios por detalle avaluo - - - - - - - - - - - - - - - - - - - - - - - - -
				criterios.setMetodo( forma.getMetodo()  );
				criterios.setEdad(forma.getEdad());
				criterios.setConservacion( forma.getConservacion() );
				criterios.setValorOfertaMinimo(forma.getValorOfertaMinimo()!=null && !forma.getValorOfertaMinimo().trim().equals("") ? forma.getValorOfertaMinimo(): "");
				criterios.setValorOfertaMaximo(forma.getValorOfertaMaximo()!=null && !forma.getValorOfertaMaximo().trim().equals("") ? forma.getValorOfertaMaximo(): "");
				criterios.setSuperficieTerrenoMinimo(forma.getSuperficieTerrenoMinimo()!=null && !forma.getSuperficieTerrenoMinimo().trim().equals("") ? forma.getSuperficieTerrenoMinimo().trim() : "" );
				criterios.setSuperficieTerrenoMaximo(forma.getSuperficieTerrenoMaximo()!=null && !forma.getSuperficieTerrenoMaximo().trim().equals("") ? forma.getSuperficieTerrenoMaximo().trim() : "" );
				criterios.setSuperficieConstruccionMinimo(forma.getSuperficieConstruccionMinimo()!=null && !forma.getSuperficieConstruccionMinimo().trim().equals("") ? forma.getSuperficieConstruccionMinimo().trim() : "" );
				criterios.setSuperficieConstruccionMaximo(forma.getSuperficieConstruccionMaximo()!=null && !forma.getSuperficieConstruccionMaximo().trim().equals("") ? forma.getSuperficieConstruccionMaximo().trim() : "" );
				
				//Criterios por enfoque mercado - - - - - - - - - - - - - - - - - - - - - - - - -
				criterios.setValorUnitarioInicio( forma.getValorUnitarioMinimo()!=null && !forma.getValorUnitarioMinimo().trim().equals("") ? forma.getValorUnitarioMinimo().trim() : "" );
				criterios.setValorUnitarioMaximo( forma.getValorUnitarioMaximo()!=null && !forma.getValorUnitarioMaximo().trim().equals("") ? forma.getValorUnitarioMaximo().trim() : "");
				criterios.setValorMinimoFic( forma.getValorMinimoFic()!=null && !forma.getValorMinimoFic().trim().equals("") ? forma.getValorMinimoFic().trim() : "" );
				criterios.setValorMaximoFic( forma.getValorMaximoFic()!=null && !forma.getValorMaximoFic().trim().equals("") ? forma.getValorMaximoFic().trim() : "" );
				criterios.setValorMinimoZona( forma.getValorMinimoZona()!=null && !forma.getValorMinimoZona().trim().equals("") ? forma.getValorMinimoZona().trim() : ""  );
				criterios.setValorMaximoZona( forma.getValorMaximoZona()!=null && !forma.getValorMaximoZona().trim().equals("") ? forma.getValorMaximoZona().trim() : ""  );
				criterios.setValorMinimoUbicacion(forma.getValorMinimoUbicacion()!=null && !forma.getValorMinimoUbicacion().trim().equals("") ? forma.getValorMinimoUbicacion().trim() : "");
				criterios.setValorMaximoUbicacion(forma.getValorMaximoUbicacion()!=null && !forma.getValorMaximoUbicacion().trim().equals("") ? forma.getValorMaximoUbicacion().trim() : "");
				criterios.setValorMinimoEdadFactor(forma.getValorMinimoEdadFactor()!=null && !forma.getValorMinimoEdadFactor().trim().equals("") ? forma.getValorMinimoEdadFactor().trim() : "");
				criterios.setValorMaximoEdadFactor(forma.getValorMaximoEdadFactor()!=null && !forma.getValorMaximoEdadFactor().trim().equals("") ? forma.getValorMaximoEdadFactor().trim() : "");
				criterios.setValorMinimoConservacionFactor(forma.getValorMinimoConservacionFactor()!=null && !forma.getValorMinimoConservacionFactor().trim().equals("") ? forma.getValorMinimoConservacionFactor().trim() : "");
				criterios.setValorMaximoConservacionFactor(forma.getValorMaximoConservacionFactor()!=null && !forma.getValorMaximoConservacionFactor().trim().equals("") ? forma.getValorMaximoConservacionFactor().trim() : "");
				criterios.setValorMinimoOtros(forma.getValorMinimoOtros()!=null && !forma.getValorMinimoOtros().trim().equals("") ? forma.getValorMinimoOtros().trim() : "");
				criterios.setValorMaximoOtros(forma.getValorMaximoOtros()!=null && !forma.getValorMaximoOtros().trim().equals("") ? forma.getValorMaximoOtros().trim() : "");
				criterios.setValorMinimoComercializacion(forma.getValorMinimoComercializacion()!=null && !forma.getValorMinimoComercializacion().trim().equals("") ? forma.getValorMinimoComercializacion().trim() : "");
				criterios.setValorMaximoComercializacion(forma.getValorMaximoComercializacion()!=null && !forma.getValorMaximoComercializacion().trim().equals("") ? forma.getValorMaximoComercializacion().trim() : "");
				criterios.setValorMinimoResultante(forma.getValorMinimoResultante()!=null && !forma.getValorMinimoResultante().trim().equals("") ? forma.getValorMinimoResultante().trim() : "");
				criterios.setValorMaximoResultante(forma.getValorMaximoResultante()!=null && !forma.getValorMaximoResultante().trim().equals("") ? forma.getValorMaximoResultante().trim() : "");

				
				ComparativoMercadoDomain domain =  serviceComparativo.buscarInformacion(criterios);
				
				if( domain.getAvaluosDomain()==null || domain.getAvaluosDomain().isEmpty() )
				{
					model.addAttribute("mensaje","La cosnulta no arrojo ningun resultado");
					regreso = "viewConsultaVaciaFail";
				}else
				{
					sesion.setAttribute("lista",domain.getAvaluosDomain());
					String datos = "";
					model.addAttribute("domain",domain);
					try
					{
					ObjectMapper mapper = new ObjectMapper();
					datos = mapper.writeValueAsString(domain.getAvaluosDomain());
					}catch (Exception e) {
						LOGGER.info("[CASC] - Error al convertit a Json el reporte de avaluos subvaluados",e);
					}
					model.addAttribute("domainJson",datos);
					LOGGER.info("[CASC] - Redireccionando a viewConsultaAE...");
					regreso  = "viewConsultaAE";
				}
	   		 LOGGER.info(PREFIJO+PROCESO+FIN_OK);
			}
			
			
		
		}catch (Exception e) {
			LOGGER.info(PREFIJO+PROCESO+FIN_NOK);
			LOGGER.error(PREFIJO+PROCESO+ERROR,e);
			model.addAttribute("mensaje", "Ocurrio un error al intentar consulta la información de los avaluos/comparativos");
			regreso = "viewFail";
		}
 	 return regreso;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/exportarCEM.htm",method=RequestMethod.POST)
	public String procesarPeticion(HttpServletRequest request,HttpServletResponse response, Model model)
	{
		HttpSession sesion = request.getSession();
		String regreso = "";
		LOGGER.info(PREFIJO+PROCESO+EXPORTAR+INICIO_OK);
		List<AvaluoDomain> lista = null;
		try
		{
			lista = (List<AvaluoDomain>) sesion.getAttribute("lista");
			HSSFWorkbook archivo = GenerarExcelUtils.generarReporteComparativos(lista);
		    response.setHeader("Content-Disposition","attachment; filename=\"" +"Comparativos.xls"+"\"");
		    response.setContentType("application/vnd.ms-excel");
		    archivo.write(response.getOutputStream());
		    LOGGER.info(PREFIJO+PROCESO+EXPORTAR+FIN_OK);
			return null;
		}catch (Exception e) {
			LOGGER.info(PREFIJO+PROCESO+EXPORTAR+FIN_NOK);
			LOGGER.error(PREFIJO+PROCESO+EXPORTAR+ERROR,e);
			model.addAttribute("mensaje", "Ocurrio un error al intentar exportar la información de los avaluos/comparativos");
			regreso = "viewFail";
		}
 	 return regreso;
	}
	
	@ModelAttribute("consultaEnfoqueForm")
	public ConsultaEnfoqueForm getForma()
	{
		return new ConsultaEnfoqueForm();
	}

}
