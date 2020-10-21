package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import mx.org.infonavit.solicitud.oferente.business.AvaluosCerradosBusiness;
import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.domain.ReporteAvaluoCerradoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReporteAvaluosCerradosForm;
import mx.org.infonavit.solicitud.oferente.utils.ReporteAvaluosCerradosUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(value={"reporteAvaluosCerradosForm"}, types={mx.org.infonavit.solicitud.oferente.forms.ReporteAvaluosCerradosForm.class})
@Controller
public class AvaluosCerradosUnidadController {
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluosCerradosUnidadController.class);
	
	@Autowired
	@Qualifier("ReporteAvaluosCerradosValidator")
	public Validator validator;
	
	@Autowired
	private AvaluosCerradosBusiness serviceAvaluoCerrado;
	
	
	@RequestMapping(value="initReporteAvaluosCerradosUnidad.htm",method=RequestMethod.GET)
	public String initAvaluosCerradosAnio(Model model,HttpServletRequest request)
	{
		request.getSession().removeAttribute("reporteAvaluosCerradosForm");
		LOGGER.info("[ACCU] - Inicializando vista para reporte de avaluos cerrados...");
		model.addAttribute("anios",generarAnios());
		model.addAttribute("meses",CatalogosBusines.CATALOGO_MESES);
		model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
		LOGGER.info("[ACCU] - Forma inicializada["+getForma()+"] ");
		model.addAttribute("reporteAvaluosCerradosForm",getForma());
		LOGGER.info("[ACCU] - Redireccionando a: formulario de avaluos cerrados...");
		return "initViewAvaluosCerradosUV";
		
	}
	
	@RequestMapping(value="getReporteAvaluosCerradosUnidad.htm",method=RequestMethod.POST)
	public String handlerRequestReporteAvaluosCerrados(@ModelAttribute("reporteAvaluosCerradosForm") ReporteAvaluosCerradosForm forma,
													   BindingResult result,Model model)
	{
		LOGGER.info("[ACCU] - Procesando petición de generación de reporte de avaluos cerrados...");
		LOGGER.info("[ACCU] - Forma ["+forma+"]");
		validator.validate(forma,result);
		
		if( result.hasErrors())
		{
			LOGGER.info("[ACCU] - Forma con errores");
			model.addAttribute("anios",generarAnios());
			model.addAttribute("meses",CatalogosBusines.CATALOGO_MESES);
			model.addAttribute("unidades",CatalogosBusines.CATALOGO_UNIDADES_VALUACION);
			return "initViewAvaluosCerradosUV";
		}else
		{
			LOGGER.info("[ACCU] - Forma sin errores");
			boolean existeInformacion = serviceAvaluoCerrado.validarInformacionReporteUnidad(	forma.getTipoComparativa(),
																					 			forma.getAnioInicio(), forma.getAnioFin(),
																					 			forma.getMesAnio(),forma.getDiaAnio(),
																					 			forma.getDiaMes(),forma.getFechaHora(),forma.getIdUnidadValudacion());
			if( existeInformacion )
			{
				LOGGER.info("[ACCU] - Redireccionando al vista de cerrados por unidad");
				List<String> fechas = ReporteAvaluosCerradosUtils.generarRangoLimiteFechas(forma.getTipoComparativa(),
																						   forma.getAnioInicio(), forma.getAnioFin(),
																						   forma.getMesAnio(),forma.getDiaAnio(),
																						   forma.getDiaMes(),forma.getFechaHora());


				model.addAttribute("anio",forma.getMesAnio());
				model.addAttribute("periodo",fechas.get(0) +" al "+fechas.get(1));
				model.addAttribute("unidad",CatalogosBusines.CATALOGO_UNIDADES_VALUACION.get(String.valueOf(forma.getIdUnidadValudacion())));
				if( forma.getTipoComparativa()==1)
				{
					return "viewReporteAvaluosAnioUV";
				}else if( forma.getTipoComparativa()==2 )
				{
					return "viewReporteAvaluosMesUV";
				}else if( forma.getTipoComparativa()==3 )
				{
					return "viewReporteAvaluosDiaUV";
				}else if( forma.getTipoComparativa()==4)
				{
					return "viewReporteAvaluosHoraUV";
				}else
				{
					return "";
				}
				
			}else
			{
				LOGGER.info("[ACCU] - Redireccionando a reporte vacio");
				model.addAttribute("mensaje","No hay información para generar el reporte");
				return "viewReporteAvaluosVacio";
			}
			
			
		}
	}
	
	
	@RequestMapping(value="reporteAvaluosCerradosUnidad.htm",method=RequestMethod.GET)
	public @ResponseBody List<ReporteAvaluoCerradoDomain> handlerAvaluosCerrados(HttpServletRequest request)
	{
		LOGGER.info("[ACCU] - Procesando petición de generación de reporte de avaluos cerrados...");
		ReporteAvaluosCerradosForm forma = (ReporteAvaluosCerradosForm) request.getSession().getAttribute("reporteAvaluosCerradosForm");
		LOGGER.info("[ACCU] - Forma ["+forma+"]");
		
		List<ReporteAvaluoCerradoDomain>  reporte = serviceAvaluoCerrado.generarReporteAvaluosCerradosUnidad( forma.getTipoComparativa(),
																									    	forma.getAnioInicio(),
																									    	forma.getAnioFin(),
																									    	forma.getMesAnio(),
																									    	forma.getDiaAnio(),
																									    	forma.getDiaMes(),
																									    	forma.getFechaHora(),
																									    	forma.getIdUnidadValudacion());
		LOGGER.info("[ACCU] - Reporte: "+reporte);
		return reporte;
	}
	
		
	@ModelAttribute("reporteAvaluosCerradosForm")
	public ReporteAvaluosCerradosForm getForma()
	{
		return new ReporteAvaluosCerradosForm();
	}
	
	
	
	
	public Map<String,String> generarAnios()
	{
		Map<String, String> anios = new TreeMap<String, String>(new Comparator<String>(){

			@Override
			public int compare(String object1, String object2) {
				if (Integer.parseInt(object1) > Integer.parseInt(object2)) {
		            return -1;
		        } else {
		            return 1;
		        } // 
			}
			
		});
		for(int i = 2005; i<=Calendar.getInstance().get(Calendar.YEAR);i++)
		{
			anios.put(String.valueOf(i),String.valueOf(i));
		}
		
	 return anios; 
	}
	
	
	
	
	
	public static void main (String args[])
	{
		int anio =  Calendar.getInstance().get(Calendar.YEAR);
		System.out.println("anio: "+anio);
		Map<String, String> anios = new TreeMap<String, String>(new Comparator<String>(){

			@Override
			public int compare(String object1, String object2) {
				if (Integer.parseInt(object1) > Integer.parseInt(object2)) {
		            return -1;
		        } else {
		            return 1;
		        } // 
			}
			
		});
		for(int i = 2005; i<=anio;i++)
		{
			anios.put(String.valueOf(i),String.valueOf(i));
		}
		
		System.out.println("Anios; "+anios);
		
		
	}
	
	

}
