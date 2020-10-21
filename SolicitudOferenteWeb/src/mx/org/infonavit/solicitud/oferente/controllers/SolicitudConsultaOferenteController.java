package mx.org.infonavit.solicitud.oferente.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.BusinessException;
import mx.org.infonavit.solicitud.oferente.business.services.ConsultaSolicitudOferenteService;
import mx.org.infonavit.solicitud.oferente.business.services.ReporteEcoTecnologiasService;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.domain.OferenteSolicitudDomain;
import mx.org.infonavit.solicitud.oferente.domain.ReporteEcoUvEcoTecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.domain.SolicitudOferenteDomain;
import mx.org.infonavit.solicitud.oferente.forms.ReporteECcoTecnologiaForm;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteBusquedaForm;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteCancelacionForm;
import mx.org.infonavit.solicitud.oferente.forms.SolicitudOferenteModificacionForm;
import mx.org.infonavit.solicitud.oferente.persistence.vo.SolicitudOferenteVo;
import mx.org.infonavit.solicitud.oferente.utils.ConsultaSolicitudOferenteTecnologia;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonReporteEcoTecnologia;
import mx.org.infonavit.solicitud.oferente.utils.RespuestaJsonReporteInexUvOferente;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SolicitudConsultaOferenteController {
	
	private static final Logger LOGGER = LogManager.getLogger(SolicitudConsultaOferenteController.class);
	private static final String PREFIJO_LOG = "[RIUOC ECOTEC] - ";
	
	@Autowired
	@Qualifier("ConsultaSolicitudOferenteBusiness")
	private ConsultaSolicitudOferenteService<OferenteSolicitudDomain> service;
	
	@Autowired
	@Qualifier("ReporteEcoTecnologiaValidator")
	private Validator validator;
	
	@Autowired
	private MessageSource mensajes;
	
	
	
	@RequestMapping(value="/initSolicitudConsulta.htm",method=RequestMethod.GET)
	public String initConsultaSolicitud(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		SolicitudOferenteBusquedaForm forma = new SolicitudOferenteBusquedaForm();
		LOGGER.info(PREFIJO_LOG + "Inicializando vista para reporte de solicitud oferentes...");
		model.addAttribute("estados",Estado.CATALOGO_ESTADOS);
		model.addAttribute("reporteSolicitudOferente",forma);
		return "viewReporteSolicitudOferente";
	}
	
	@RequestMapping(value="/reporteSolicitudOfernte.json",method=RequestMethod.POST)
	public @ResponseBody ConsultaSolicitudOferenteTecnologia procesarPeticionReporte(@ModelAttribute("reporteSolicitudOferente")SolicitudOferenteBusquedaForm formulario,BindingResult result)
	{
		ConsultaSolicitudOferenteTecnologia respuesta = new ConsultaSolicitudOferenteTecnologia();
		LOGGER.info(PREFIJO_LOG+"Procesando petición para generar reporte...");
		LOGGER.info(PREFIJO_LOG+"Valores: "+formulario.toString());
		
			
				LOGGER.info(PREFIJO_LOG+"Formulario sin errores, obteniendo reporte");
				List<OferenteSolicitudDomain> reporte;
				try {
					reporte = service.generarReporteConsultaSolicitud(
							Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd")
							,Fechas.cambiarFormatoFecha(formulario.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd"),
							formulario.getId_estatus(),formulario.getId_paquete(),formulario.getId_tipo_solicitud(),
							formulario.getId_estado());
				
				if( reporte!=null && !reporte.isEmpty())
				{
					respuesta.setCodigoRespuesta("0000");
					respuesta.setDescripcionRespuesta("Reporte generado, exitosamente");
					respuesta.setListado(reporte);
					LOGGER.debug(PREFIJO_LOG+"Resultados 2: "+Arrays.asList(reporte).toString());
				}else
				{
					respuesta.setCodigoRespuesta("0003");
					respuesta.setDescripcionRespuesta("No se encontraron registros");
					respuesta.setListado(new ArrayList<OferenteSolicitudDomain>());
				}
				} catch (BusinessException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
	
			
	 return respuesta;
	}
	
	

	@RequestMapping(value="showDetailEmpresa.htm",method=RequestMethod.POST)
	public String showDetalle(@ModelAttribute(value="reporteSolicitudOferente") SolicitudOferenteBusquedaForm formulario)
	
	{
//		if(!id.equals("0")){
//			SolicitudOferenteVo SolicitudOferenteVo = new SolicitudOferenteVo();
//			SolicitudOferenteVo.setIdOferente(id);
//			try
//			{
//				oferente = empresa.getEmpresas().get(empresa.getEmpresas().indexOf(oferente));
//				LOGGER.info("Datos -- "+oferente.toString());
//				service.buscarCorreos(oferente);
//				service.buscarFiliales(oferente);
//				service.buscarTelefonos(oferente);
//				service.buscarLocalidades(oferente);
//				
//				
//				service.buscarRepresentantes(oferente);
//				model.addAttribute("oferente",oferente);
//				model.addAttribute("empresa",empresa);
				
//			}catch(Exception exception)
//			{
//				LOGGER.info("Error en la consulta de empresas",exception);
//		
//				return "error";
//			}
			
			return "detalleSolicitud";
			
		
//		}
		
			
	}
	


}
