package mx.org.infonavit.solicitud.oferente.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import mx.org.infonavit.solicitud.oferente.business.AvaluoBusiness;
import mx.org.infonavit.solicitud.oferente.business.AvaluoMAIBusiness;
import mx.org.infonavit.solicitud.oferente.business.BitacoraAvaluoMapBusiness;
import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.ComparativoMercadoBusiness;
import mx.org.infonavit.solicitud.oferente.business.ConsultaAvaluosGenericaBusiness;
import mx.org.infonavit.solicitud.oferente.business.PeticionBusiness;
import mx.org.infonavit.solicitud.oferente.business.services.PaqueteBusinessService;
import mx.org.infonavit.solicitud.oferente.controllers.AvaluoEnfoqueController;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ComparativoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCompartivoMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaInexDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaReasignacionInexDomain;
import mx.org.infonavit.solicitud.oferente.domain.PaqueteDomain;
import mx.org.infonavit.solicitud.oferente.domain.ResumenEnvioAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaEnfoqueForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaInexForm;
import mx.org.infonavit.solicitud.oferente.forms.ConsultaReasignacionInexForm;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DocumentoAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.FotoAvaluoVo;
import mx.org.infonavit.solicitud.oferente.procesos.ProcesoFotosAvaluo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static Logger LOGGER;
	
	public static void main(String[] args) throws Exception
	{
		System.setProperty("reporteuvs.log.file","C:/logs/reporteUV.log");
		DOMConfigurator.configure("C:/wsReporteUvsProd/ReporteUVs/WebContent/WEB-INF/config/logging/Log4j.cfg.xml");
		LOGGER = LogManager.getLogger(Test.class);
		ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("application-context.xml");
		CatalogosBusines catalogos = (CatalogosBusines) CONTEXT.getBean("CatalogosBusines");
		catalogos.cargarCatalogos();
		CatalogosBusines.displayInformation();
		
		ConsultaAvaluosGenericaBusiness consultaAvaluosGenericaBusiness = CONTEXT.getBean(ConsultaAvaluosGenericaBusiness.class);
		
		
		//Pruebas consulta reasignaciones
		ConsultaReasignacionInexForm forma = new ConsultaReasignacionInexForm();
		forma.setPaquete("1234567890123456");
		forma.setRfcOferente("GPE9710214X5");
		forma.setEstado(2);
		forma.setFechaReasignacionInicio("01-01-2011");
		forma.setFechaReasignacionFin("01-01-2011");
		forma.setIdUnidadNueva(6121);
		forma.setIdUnidadAnterior(6122);
		
		CriteriosConsultaReasignacionInexDomain domain = CriteriosConsultaReasignacionInexDomain.getObjetoDomain(forma);
		List<String> campos = Arrays.asList(new String[]{"b.id_uv_ant","b.id_uv_nuevo","b.fecha","b.motivo","p.rfc","p.id_estado"});
        ConsultaAvaluosGenericaBusiness.DATOS = campos;
        LOGGER.info("Mapeo reasignacion: "+BuilderMapeosBeanSQLUtils.generarMapeoCamposReasignacionInex());
        LOGGER.info("Mapeo paquete: "+BuilderMapeosBeanSQLUtils.generarMapeoCamposReasignacionPaqueteInex());
        String sentencia =  BuilderSQLConsultaReasignacionInexUtils.generarSentencia(domain);
        LOGGER.info("Sentencia: "+sentencia);
        List<String> columnas = OrdenamientoCamposReasignacionInexUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
        List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarBitacoraReasignacionInex(domain); 
        LOGGER.info("Registros encontrados - "+informacion.size());
        LOGGER.info("Columnas - "+columnas);

		
		
//		
//		
//		ConsultaInexForm consultaInexForm = new ConsultaInexForm();
//		consultaInexForm.setFecha("08-02-2019");
//		consultaInexForm.setIdEstado(1);
//		consultaInexForm.setIdUnidadValuacion(9205);
//		consultaInexForm.setNumeroInex(1);
//		
//		CriteriosConsultaInexDomain domainInex = CriteriosConsultaInexDomain.getObjetoDomain(consultaInexForm);
//		
//		List<String> campos = Arrays.asList(new String[]{"igral.id_inex"});
////		List<String> campos = Arrays.asList(new String[]{"igral.id_inex","igral.fecha","igral.id_uv","igral.id_estado","igral.variable1","igral.variable2","igral.variable3","igral.variable4","igral.variable5","igral.desempate1","igral.desempate2","igral.calificacion_total","igral.orden","igral.estatus"});
//		ConsultaAvaluosGenericaBusiness.DATOS = campos;
//		LOGGER.info("Mapeo: "+BuilderMapeosBeanSQLUtils.generarMapeoCamposInexGeneral());
//		String sentencia =  BuilderSQLConsultaInexGeneralUtils.generarSentencia(domainInex);
//		
//		LOGGER.info("Sentencia: "+sentencia);
//		
//		 
//		List<String> columnas = OrdenamientoCamposInexGeneralUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
//		List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionInexGeneral(domainInex); 
//		LOGGER.info("Registros encontrados - "+informacion.size());
//		LOGGER.info("Columnas - "+columnas);
//		LOGGER.info("Registros  - "+informacion);			
		
// Avaluos subvaluados - - - - -		
//		AvaluosSubValuadosBusiness service = CONTEXT.getBean(AvaluosSubValuadosBusiness.class);
//		ConsultaAvaluoSubValuadoForm forma = new ConsultaAvaluoSubValuadoForm();
//		
//		forma.setIdAvaluo("");
//		forma.setIdPaquete("");
//		forma.setIdVivienda(0);
//		forma.setBandera(0);
//		forma.setIdUnidadValuacion(0);
//		forma.setCodigoPostal("");
//		forma.setFechaCierreInicio("2013-06-01");
//		forma.setFechaCierreFin("2013-06-01");
//		List<AvaluoSubValuadoDomain> reporte = service.buscarAvaluosSubvaluados(
//																				  AvaluosSubValuadosBusiness.
//																				  	generarObjetoAvaluoSubValuadoVo
//																				  	(
//																						forma.getIdAvaluo(),forma.getIdPaquete(),forma.getIdVivienda(),
//																						forma.getIdUnidadValuacion(),forma.getBandera(),forma.getCodigoPostal(),
//																						forma.getBandera(),forma.getFechaCierreInicio(),forma.getFechaCierreFin())
//																					);
//		LOGGER.info("[T] - "+reporte);
		
		//-----------------Consulta de Unidades peritos y valuadores UPC------------------
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(1));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(2));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(5));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposUPC(6));
//	
//		ConsultaUPCForm forma = new ConsultaUPCForm();
//		
//		UnidadValuacionForm unidadForm = new UnidadValuacionForm();
//		unidadForm.setEstatusUnidadValuacion(-1);
//		unidadForm.setUnidadViviendaRecuperada(-1);
//		
//		CoberturaForm coberturaForm = new CoberturaForm();
//		coberturaForm.setEstatus(-1);
//		
//		ControladorForm controladorForm = new ControladorForm();
//		controladorForm.setClaveSHF("");
//		controladorForm.setCurp("");
//		controladorForm.setEstatusControlador(-1);
//		controladorForm.setFechaVigenciaFin("");
//		controladorForm.setFechaVigenciaInicio("");
//		controladorForm.setRfc("");
//		controladorForm.setNombre("NOMBRE");
//		controladorForm.setApellidoPaterno("PATERNO");
//		controladorForm.setApellidoMaterno("MATERNO");
//		PeritoForm peritoForm =new PeritoForm();
//		peritoForm.setClaveSHF("");
//		peritoForm.setCurp("");
//		peritoForm.setEstatusPerito(-1);
//		peritoForm.setFechaVigenciaFin("");
//		peritoForm.setFechaVigenciaInicio("");
//		peritoForm.setRfc("");
//		peritoForm.setNombre("NOMBRE");
//		peritoForm.setApellidoPaterno("PATERNO");
//		peritoForm.setApellidoMaterno("MATERNO");
//		
//		
//		
//		forma.setUnidadValuacionForm(unidadForm);
//		forma.setCoberturaForm(coberturaForm);
//		forma.setControladorForm(controladorForm);
//		forma.setPeritoForm(peritoForm);
//		
//		List<String> unidades = Arrays.asList(new String[]{"9250","9237","9254","9220","9232","9240","9242","9205","9197","9241","9273","9218","9227","9259","9275","9289","9239","9258","9213","9207","9236","9171","9202","9208","6143","9189","9204","6125","9172","9283","9230","6146","9287","9261","9199","9244","9256","9246","9224","6129","9193","9247","9176","9206","9252","9286","6128","9276","9288","9190","9285","9282","9201","9217","6130","9215","9280","6144","9188","6127","6138","9251","9264","9175","9234","9221","6142","9281","9278","9272","9225","9249","9277","9228","9267","9255","9262","9219","9226","6140","9260","9248","9257","9196","9174","6148","6145","9268","9279","9178","9284","9210","9269","9245","9270","6150","6131","9266","9187","9198","9211","9274","9216","9235","9200"});
//		List<String> campos = Arrays.asList(new String[]{"pe.id_perito_shf","pe.paterno","pe.materno","pe.nombre","pe.fecha_alta","pe.fecha_vigencia","pe.id_estatus","pe.puesto","pe.curp","pe.rfc","pe.direccion","pe.telefono","pe.e_mail","pe.cedula_profesional","cc.id_controlador_shf","cc.paterno","cc.materno","cc.nombre","cc.fecha_alta","cc.fecha_vigencia","cc.id_estatus","cc.curp","cc.rfc","cc.direccion","cc.telefono","cc.e_mail","cc.cedula_profesional","cc.puesto"});
//	
//				
//		forma.getUnidadValuacionForm().setNombreUnidadValuacion(unidades); 
//		ConsultaAvaluosGenericaBusiness.DATOS = campos;
//		CriteriosConsultaUPCDomain domain = CriteriosConsultaUPCDomain.getObjetoDomain(forma);
//		
//		LOGGER.info("Valor de domain["+domain+"]");
//		LOGGER.info("Unidades a consulta ["+unidades+"]");
//		
//		
//		
//		
//
//		List<String> columnas = OrdenamientoCamposCUPCUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
//		List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionUPC(domain); 
//		LOGGER.info("Registros encontrados - "+informacion.size());
//		LOGGER.info("Columnas - "+columnas);
////		LOGGER.info("Registros  - "+informacion);
//		
//		if( columnas.contains("Estatus unidad"))
//		{
//			final int indice = columnas.indexOf("Estatus unidad");
//			LOGGER.info("El indice es: "+indice);
//			CollectionUtils.forAllDo(informacion,new Closure(){
//				@SuppressWarnings("unchecked")
//				@Override
//				public void execute(Object arg0) {
//					List<String> registro = (List<String>) arg0;
//					registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//				}
//			});
//		}
//		if( columnas.contains("Estatus perito"))
//		{
//			final int indice = columnas.indexOf("Estatus perito");
//			LOGGER.info("El indice es: "+indice);
//			CollectionUtils.forAllDo(informacion,new Closure(){
//				@SuppressWarnings("unchecked")
//				@Override
//				public void execute(Object arg0) {
//					List<String> registro = (List<String>) arg0;
//					registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//				}
//			});
//		}
//		if( columnas.contains("Estatus cobertura"))
//		{
//			final int indice = columnas.indexOf("Estatus cobertura");
//			LOGGER.info("El indice es: "+indice);
//			CollectionUtils.forAllDo(informacion,new Closure(){
//				@SuppressWarnings("unchecked")
//				@Override
//				public void execute(Object arg0) {
//					List<String> registro = (List<String>) arg0;
//					registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//				}
//			});
//		}
//		if( columnas.contains("Estatus controlador"))
//		{
//			final int indice = columnas.indexOf("Estatus controlador");
//			LOGGER.info("El indice es: "+indice);
//			CollectionUtils.forAllDo(informacion,new Closure(){
//				@SuppressWarnings("unchecked")
//				@Override
//				public void execute(Object arg0) {
//					List<String> registro = (List<String>) arg0;
//					registro.set(indice,CatalogosBusines.CATALOGO_ESTATUS.get((String)registro.get(indice)));
//				}
//			});
//		}
//		
//		LOGGER.info("[T] - Catalogo: "+CatalogosBusines.CATALOGO_DELEGACIONES);
//		
//		if( columnas.contains("Estado cobertura"))
//		{
//			final int indice = columnas.indexOf("Estado cobertura");
//			LOGGER.info("El indice de estado cobertura es: "+indice);
//			CollectionUtils.forAllDo(informacion,new Closure(){
//				@SuppressWarnings("unchecked")
//				@Override
//				public void execute(Object arg0) {
//					List<String> registro = (List<String>) arg0;
//					LOGGER.info("[T] Registro antes: "+registro);
//					
//					if( ((String)registro.get(indice)).trim().matches("[0-9]{5}") )
//					{
//						String claveEstado = ((String)registro.get(indice)).substring(0,2);
//						LOGGER.info("[T] - Clave estado: "+claveEstado);
//						LOGGER.info("[T] - CAsteado: "+String.valueOf(Integer.parseInt(claveEstado)));
//						LOGGER.info("[T] - Estado: "+CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(Integer.parseInt(claveEstado))));
//						
//						registro.set(indice,CatalogosBusines.CATALOGO_DELEGACIONES.get(String.valueOf(Integer.parseInt(claveEstado))));
//					}else
//					{
//						registro.set(indice,"Sin estado");
//					}
//					LOGGER.info("[T] Registro despes: "+registro.size());
//				}
//			});
//		}
//		LOGGER.info("Registros decodificada  - "+informacion.size());
//		
//		CollectionUtils.forAllDo(informacion,new Closure(){
//			@SuppressWarnings("unchecked")
//			@Override
//			public void execute(Object arg0) {
//				List<String> registro = (List<String>) arg0;
//				LOGGER.info("[T] - registro: "+registro);
//				CollectionUtils.transform(registro,new Transformer(){
//					@Override
//					public Object transform(Object arg0) {
//						LOGGER.info("[T] - dato:"+arg0);
//						return arg0=((String)arg0).subSequence(((String)arg0).indexOf("=")+1,((String)arg0).length());
//					}
//					
//				});
//			}
//		});
//		LOGGER.info("Registros transformados  - "+informacion.size());
		

			
		
		
		
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAsignaciones());
//		CriteriosAsignacionesDomain criteriosAsignaciones = new CriteriosAsignacionesDomain();
//		criteriosAsignaciones.setPaquete("");
//		criteriosAsignaciones.setUnidadValuacion("");
//		criteriosAsignaciones.setFrente("");
//		criteriosAsignaciones.setRfcOferente("");
//		criteriosAsignaciones.setFechaAsignacionInicio("");
//		criteriosAsignaciones.setFechaAsignacionFin("");
//		criteriosAsignaciones.setEstado("");
//		criteriosAsignaciones.setUnidadValuacionAnterior("");
//		criteriosAsignaciones.setFechaReAsignacionInicio("");
//		criteriosAsignaciones.setFechaReAsignacionFin("");
//		criteriosAsignaciones.setTipoReasignacion("19");
//		
//		List<String> campos = Arrays.asList(new String[]{"p.id_paquete","p.id_uv","p.fecha_asignacion","p.rfc","p.id_estado","bi.id_uv_ant","bi.fecha","te.tipo_reasignacion"});
//		ConsultaAvaluosGenericaBusiness.DATOS = campos;
//		LOGGER.info(consultaAvaluosGenericaBusiness.consultarInformacionAsignaciones(criteriosAsignaciones));
		
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposCancelaciones());
//		CriteriosCancelacioneaDomain criteriosCancelaciones = new CriteriosCancelacioneaDomain();
//		criteriosCancelaciones.setClaveUnidadValuacion("");
//		criteriosCancelaciones.setNombreUnidadValuacion("EGP EVALUACION Y GESTION DE PROYECTOS, ","A. DE C.V.");
//		criteriosCancelaciones.setIdAvaluo("");
//		criteriosCancelaciones.setIdConviviencia("");
//		criteriosCancelaciones.setPaquete("");
//		criteriosCancelaciones.setViviendaInicio("");
//		criteriosCancelaciones.setViviendaFin("");
//		criteriosCancelaciones.setFechaCancelacionInicio("");
//		criteriosCancelaciones.setFechaCancelacionFin("");
//		criteriosCancelaciones.setFechaSolicitudInicio("");
//		criteriosCancelaciones.setFechaSolicitudFin("");
//		criteriosCancelaciones.setFechaCierreInicio("");
//		criteriosCancelaciones.setFechaCierreFin("");
//		criteriosCancelaciones.setValorConcluidoInicio("");
//		criteriosCancelaciones.setValorConcluidoFin("");
//		criteriosCancelaciones.setEstatusAvaluo("");
////		
//		List<String> campos = Arrays.asList(new String[]{"c.id_avaluo","c.id_vivienda","c.id_paquete","c.fecha","h.valor_concluido","a.id_uv","a.fecha_solicitud","a.fecha_cierre","a.id_estatus","a.id_convivencia"});
//		ConsultaAvaluosGenericaBusiness.DATOS = campos;
////		
//		List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionCancelacionAvaluos(criteriosCancelaciones);
//		List<String> columnas = OrdenamientoCamposCancelacionesUtils.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
////		
////		
//		LOGGER.info("[Test] - Registros encontrados - "+informacion.size());
//		LOGGER.info("[Test] - Columnas - "+columnas);

		
		
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(1));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(3));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(4));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(5));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(6));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposAvaluos(7));
////		
//		ConsultaAvaluosForm forma = new ConsultaAvaluosForm();
////		
//		UnidadValuacionForm unidadForm = new UnidadValuacionForm();
//		unidadForm.setUnidadViviendaRecuperada(-1);
//		CoberturaForm coberturaForm = new CoberturaForm();
//		ControladorForm controladorForm = new ControladorForm();
//		controladorForm.setNombre("NOMBRE");
//		controladorForm.setApellidoPaterno("PATERNO");
//		controladorForm.setApellidoMaterno("MATERNO");
//		controladorForm.setEstatusControlador(-1);
//		PeritoForm peritoForm =new PeritoForm();
//		peritoForm.setNombre("NOMBRE");
//		peritoForm.setApellidoPaterno("CANO");
//		peritoForm.setApellidoMaterno("MATERNO");
//		peritoForm.setEstatusPerito(-1);
//		AvaluoForm avaluoForm = new AvaluoForm();
//		avaluoForm.setEstatusAvaluo(-1);
//		DetalleAvaluoForm detalleAvaluoForm = new DetalleAvaluoForm();
//		ViviendaForm viviendaForm = new ViviendaForm();
////		
////		
//		forma.setUnidadValuacion(unidadForm);
//		forma.setCobertura(coberturaForm);
//		forma.setControlador(controladorForm);
//		forma.setPerito(peritoForm);
//		forma.setVivienda(viviendaForm);
//		forma.setDetalleAvaluo(detalleAvaluoForm);
//		forma.setAvaluo(avaluoForm);
//		
//		forma.getAvaluo().setEstados(Arrays.asList(new String[]{"31"}));
//				
////		
//		CriteriosConsultaAvaluoDomain criterios = CriteriosConsultaAvaluoDomain.getObjetoDomain(forma);
////		
////
//		List<String> campos = Arrays.asList(new String[]{"a.estado","a.id_avaluo","a.fecha_descarga","a.fecha_envio","a.fecha_cierre","a.id_estatus","a.fecha_compromiso_termino","a.fecha_caducidad","a.id_tipo_mercado","a.id_convivencia"});
//		ConsultaAvaluosGenericaBusiness.DATOS = campos;
////		
//		List<List<String>> informacion = consultaAvaluosGenericaBusiness.consultarInformacionAvaluo(criterios);
////		
//		List<String> columnas = OrdenamientoCamposConsultaAvaluosUtil.getColumnas(ConsultaAvaluosGenericaBusiness.DATOS);
//		LOGGER.info("Registros encontrados - "+informacion.size());
//		LOGGER.info("Columnas - "+columnas);
//		
		
//		List<ReporteAvaluoCerradoDomain> reporte=  avaluosCerradosBusiness.generarReporteAvaluosCerrados(1,"2009","2015","","","","");
//		
//		List<ReporteAvaluoCerradoDomain> reporte=  avaluosCerradosBusiness.generarReporteAvaluosCerradosEstado(2,"","","05","2010","","",1);
//		
//		List<ReporteAvaluoCerradoDomain> reporte=  avaluosCerradosBusiness.generarReporteAvaluosCerradosUnidad(1,"2006","2010","","","","",6131);
//		
//		LOGGER.info("[T] - reporte ["+reporte+"]");
		
		
//		
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(1));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(2));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(3));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(4));
//		LOGGER.info("[T] - Mapeo generado :"+BuilderMapeosBeanSQLUtils.generarMapeoCamposSanciones(5));
//		
		
		

		
//		final String user="CEINENOT";
//		final String pwd="Control01";
//		
//		// Recipient's email ID needs to be mentioned.
//	      String to = "adrian.casas@softtek.com";
//
//	      // Sender's email ID needs to be mentioned
//	      String from = "aacasas@infonavit.org.mx";
//
//	      // Assuming you are sending email from localhost
//	      String host = "10.90.1.29";
//
//	      // Get system properties
//	      Properties properties = System.getProperties();
//
//	      // Setup mail server
//
//	      properties.setProperty("mail.smtp.host", ","st);
//	      properties.setProperty("mail.smtp.auth", "true");
//	      properties.setProperty("mail.debug", "true");
//	      properties.setProperty("mail.smtp.port", "25");
//	      
//	      // Get the default Session object.
//	      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
//	          protected PasswordAuthentication getPasswordAuthentication() {
//	              return new PasswordAuthentication("username", "password");
//	          }
//	      });
//	      session.setDebug(true);
//
//	      try{
//	         // Create a default MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	         
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.addRecipient(Message.RecipientType.TO,
//	                                  new InternetAddress(to));
//
//	         // Set Subject: header field
//	         message.setSubject("This is the Subject Line!");
//
//	         // Now set the actual message
//	         message.setText("This is actual message");
//	         
//	         message.saveChanges();
//
//	         
//	         
//	         // Send message
////	         Transport.send(message);
//	         Transport transport = session.getTransport("smtp");
//	         transport.connect(host,user,pwd);
//	         transport.sendMessage(message,message.getAllRecipients());
//	         transport.close();
//	         System.out.println("Sent message successfully....");
//	      }catch (MessagingException mex) {
//	         mex.printStackTrace();
//	      }
//	   }

		
//		AbstractDao<SpBuscar10ResultadosVo> persistenceSP = (AbstractDao<SpBuscar10ResultadosVo>) CONTEXT.getBean("SPBuscar10Dao");
		
		

		

//		SP_buscar10 '2017-06-26','2017-06-29',''
//		persistenceSP.buscar(new SpBuscar10ResultadosVo("2017-06-26","2017-06-29",""));
		
		
//		SP_busca05 '2017-06-26','2017-06-29',''

//		String query = "SELECT a.id_avaluo, substring(a.id_avaluo,0,3) AS Estado, a.fecha_descarga, a.fecha_envio, a.fecha_cierre, a.id_estatus, a.fecha_compromiso_termino, a.fecha_caducidad, a.id_tipo_mercado, a.id_convivencia FROM avaluo AS a WITH(NOLOCK)  WHERE  a.fecha_solicitud>='2016-12-01' AND a.fecha_solicitud<='2016-12-31 23:59'";
//		String cadena = query.substring(query.indexOf("SELECT")+"SELECT".length(), query.indexOf("FROM")-1);
//		LOGGER.info("query: ["+query+"]");
//		LOGGER.info("cadena: ["+cadena.trim()+"]");
//		
//		
//		String queryRegistro = Cadenas.reemplazar(query,cadena," COUNT(*) AS registros ");
//		LOGGER.info("queryRegistros: ["+queryRegistro.trim()+"]");
		
		//ConsultaEnfoques - - - - - - - - 
//		ConsultaEnfoqueForm forma = new ConsultaEnfoqueForm();
//		forma.resetAll();
		
//		forma.setPaquete("paquete-mai-9254");
//		forma.setValorOfertaMinimo("410000");
//		forma.setValorOfertaMaximo("460000");
//		List<String> unidades = new ArrayList<String>();
//		unidades.add("9176");
//		forma.setNombreUnidadValuacion(unidades);
		
//		forma.setFic("1.41");

//		forma.setEdad(280);
		
//		forma.setFechaCierreInicio("2013-01-01");
//		forma.setFechaCierreFin("2018-09-01");
		
//		forma.setValorOfertaMinimo("100000");
//		forma.setValorOfertaMaximo("700000");
//		forma.setValorMinimoFic("0.97");
//		forma.setValorMaximoFic("1.06");
//		
//		forma.setValorMinimoZona("1");
//		forma.setValorMaximoZona("2");
//		
//		forma.setValorMinimoUbicacion("0.98");
//		forma.setValorMaximoUbicacion("1");
//		
//		
//		forma.setValorMinimoSuperficie("0.87");
//		forma.setValorMaximoSuperficie("1.01");
//		
//		
//		forma.setValorMinimoEdadFactor("0.45");
//		forma.setValorMaximoEdadFactor("0.23");
//		
//		forma.setValorMinimoOtros("1.32");
//		forma.setValorMaximoOtros("12.98");
//		
//		forma.setValorMinimoComercializacion("0.43");
//		forma.setValorMaximoComercializacion("1.3");
//		
//		forma.setValorMinimoResultante("0.9000");
//		forma.setValorMaximoResultante("0.9999");
		
//		forma.setSuperficieTerrenoMinimo("100");
//		forma.setSuperficieTerrenoMaximo("200");
		
//		CriteriosCompartivoMercadoDomain criterios = new CriteriosCompartivoMercadoDomain();
//		//Crietrios por avaluo - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		criterios.setPaquete( forma.getPaquete()!=null && !forma.getPaquete().trim().equals("") ? forma.getPaquete() : "" );
//		criterios.setIdAvaluo( forma.getIdAvaluo()!=null && !forma.getIdAvaluo().trim().equals("") ? forma.getIdAvaluo() : "" );
//		criterios.setUnidadesValuacion( forma.getNombreUnidadValuacion()!=null && !forma.getNombreUnidadValuacion().isEmpty() ? forma.getNombreUnidadValuacion() : new ArrayList<String>() );
//		criterios.setFechaCierreInicio( forma.getFechaCierreInicio()!=null && !forma.getFechaCierreInicio().trim().equals("") ? forma.getFechaCierreInicio(): ""  ); 
//		criterios.setFechaCierreFin( forma.getFechaCierreFin()!=null && !forma.getFechaCierreFin().trim().equals("") ? forma.getFechaCierreFin(): "" );
		
		//Criterios por detalle avaluo - - - - - - - - - - - - - - - - - - - - - - - - -
//		criterios.setMetodo( forma.getMetodo()  );
//		criterios.setEdad(forma.getEdad());
//		criterios.setConservacion( forma.getConservacion() );
//		criterios.setValorOfertaMinimo(forma.getValorOfertaMinimo()!=null && !forma.getValorOfertaMinimo().trim().equals("") ? forma.getValorOfertaMinimo(): "");
//		criterios.setValorOfertaMaximo(forma.getValorOfertaMaximo()!=null && !forma.getValorOfertaMaximo().trim().equals("") ? forma.getValorOfertaMaximo(): "");
//		criterios.setSuperficieTerrenoMinimo(forma.getSuperficieTerrenoMinimo()!=null && !forma.getSuperficieTerrenoMinimo().trim().equals("") ? forma.getSuperficieTerrenoMinimo().trim() : "" );
//		criterios.setSuperficieTerrenoMaximo(forma.getSuperficieTerrenoMaximo()!=null && !forma.getSuperficieTerrenoMaximo().trim().equals("") ? forma.getSuperficieTerrenoMaximo().trim() : "" );
//		criterios.setSuperficieConstruccionMinimo(forma.getSuperficieConstruccionMinimo()!=null && !forma.getSuperficieConstruccionMinimo().trim().equals("") ? forma.getSuperficieConstruccionMinimo().trim() : "" );
//		criterios.setSuperficieConstruccionMaximo(forma.getSuperficieConstruccionMaximo()!=null && !forma.getSuperficieConstruccionMaximo().trim().equals("") ? forma.getSuperficieConstruccionMaximo().trim() : "" );
		
		//Criterios por enfoque mercado - - - - - - - - - - - - - - - - - - - - - - - - -
//		criterios.setValorUnitarioInicio( forma.getValorUnitarioMinimo()!=null && forma.getValorUnitarioMinimo().trim().equals("") ? forma.getValorUnitarioMinimo().trim() : "" );
//		criterios.setValorUnitarioMaximo( forma.getValorUnitarioMaximo()!=null && forma.getValorUnitarioMaximo().trim().equals("") ? forma.getValorUnitarioMaximo().trim() : "");
		
//		criterios.setValorMinimoFic( forma.getValorMinimoFic()!=null && !forma.getValorMinimoFic().trim().equals("") ? forma.getValorMinimoFic().trim() : "" );
//		criterios.setValorMaximoFic( forma.getValorMaximoFic()!=null && !forma.getValorMaximoFic().trim().equals("") ? forma.getValorMaximoFic().trim() : "" );
//		criterios.setValorMinimoZona( forma.getValorMinimoZona()!=null && !forma.getValorMinimoZona().trim().equals("") ? forma.getValorMinimoZona().trim() : ""  );
//		criterios.setValorMaximoZona( forma.getValorMaximoZona()!=null && !forma.getValorMaximoZona().trim().equals("") ? forma.getValorMaximoZona().trim() : ""  );
//		criterios.setValorMinimoUbicacion(forma.getValorMinimoUbicacion()!=null && !forma.getValorMinimoUbicacion().trim().equals("") ? forma.getValorMinimoUbicacion().trim() : "");
//		criterios.setValorMaximoUbicacion(forma.getValorMaximoUbicacion()!=null && !forma.getValorMaximoUbicacion().trim().equals("") ? forma.getValorMaximoUbicacion().trim() : "");
//		criterios.setValorMinimoEdadFactor(forma.getValorMinimoEdadFactor()!=null && !forma.getValorMinimoEdadFactor().trim().equals("") ? forma.getValorMinimoEdadFactor().trim() : "");
//		criterios.setValorMaximoEdadFactor(forma.getValorMaximoEdadFactor()!=null && !forma.getValorMaximoEdadFactor().trim().equals("") ? forma.getValorMaximoEdadFactor().trim() : "");
//		criterios.setValorMinimoConservacionFactor(forma.getValorMinimoConservacionFactor()!=null && !forma.getValorMinimoConservacionFactor().trim().equals("") ? forma.getValorMinimoConservacionFactor().trim() : "");
//		criterios.setValorMaximoConservacionFactor(forma.getValorMaximoConservacionFactor()!=null && !forma.getValorMaximoConservacionFactor().trim().equals("") ? forma.getValorMaximoConservacionFactor().trim() : "");
//		criterios.setValorMinimoOtros(forma.getValorMinimoOtros()!=null && !forma.getValorMinimoOtros().trim().equals("") ? forma.getValorMinimoOtros().trim() : "");
//		criterios.setValorMaximoOtros(forma.getValorMaximoOtros()!=null && !forma.getValorMaximoOtros().trim().equals("") ? forma.getValorMaximoOtros().trim() : "");
//		criterios.setValorMinimoComercializacion(forma.getValorMinimoComercializacion()!=null && !forma.getValorMinimoComercializacion().trim().equals("") ? forma.getValorMinimoComercializacion().trim() : "");
//		criterios.setValorMaximoComercializacion(forma.getValorMaximoComercializacion()!=null && !forma.getValorMaximoComercializacion().trim().equals("") ? forma.getValorMaximoComercializacion().trim() : "");
//		criterios.setValorMinimoResultante(forma.getValorMinimoResultante()!=null && !forma.getValorMinimoResultante().trim().equals("") ? forma.getValorMinimoResultante().trim() : "");
//		criterios.setValorMaximoResultante(forma.getValorMaximoResultante()!=null && !forma.getValorMaximoResultante().trim().equals("") ? forma.getValorMaximoResultante().trim() : "");
//		
//		
		
		
		
		
//		ComparativoMercadoBusiness serviceCompartaivo = (ComparativoMercadoBusiness) CONTEXT.getBean(ComparativoMercadoBusiness.class);
//		ComparativoMercadoDomain domain = serviceCompartaivo.buscarInformacion(criterios);
//		
//		
//		
//		if( domain.getAvaluosDomain()!=null && !domain.getAvaluosDomain().isEmpty() )
//		{
//			LOGGER.info("Respuesta total de avaluos encontrados "+(domain.getAvaluosDomain()!=null && !domain.getAvaluosDomain().isEmpty()?domain.getAvaluosDomain().size():"0"));
//		}
		
//		HSSFWorkbook reporte = null;
//		if(domain.getAvaluosDomain()!=null && !domain.getAvaluosDomain().isEmpty() )
//		{
//			reporte = GenerarExcelUtils.generarReporteComparativos(domain.getAvaluosDomain());
//			FileOutputStream fos = new FileOutputStream(new File("C:/logs/reporteCom.xls"));
//			
//			reporte.write(fos);
//			
//			fos.close();
//			
//		}
		
		
		//Proceso de envio de avaluos - - - - - 
//		AvaluoMAIBusiness serviceACM = CONTEXT.getBean(AvaluoMAIBusiness.class);
//		PeticionBusiness servicePeticion = CONTEXT.getBean(PeticionBusiness.class);
//		BitacoraAvaluoMapBusiness serviceBitacora = CONTEXT.getBean(BitacoraAvaluoMapBusiness.class);
//		
//		
//		String fechaInicio = "2017-08-01";
//		String fechaFin = "2017-08-01";
//		List<AvaluoCerradoMaiDomain> avaluosCerrados = serviceACM.consultarAvaluosCerrados(fechaInicio,fechaFin);
//		
//		if( avaluosCerrados!=null && !avaluosCerrados.isEmpty())
//		{
//			CollectionUtils.forAllDo(avaluosCerrados,new Closure(){
//				@Override
//				public void execute(Object object) {
//					AvaluoCerradoMaiDomain.formatearObjeto((AvaluoCerradoMaiDomain)object);
//				}
//			});
//			
//			
//		int NUMERO_DE_THREADS = 4;
//		int NUMERO_DE_REGISTROS = avaluosCerrados.size();
//		
//		LOGGER.info("Threads: "+NUMERO_DE_THREADS);
//		LOGGER.info("Avaluos encontrados: "+NUMERO_DE_REGISTROS);
//		
//		int minimoDeRegstrosPorThread = NUMERO_DE_REGISTROS / NUMERO_DE_THREADS;
//		int maximoDeRegistrosPorThread = minimoDeRegstrosPorThread + 1;
//		int threadsConMaximodDeRegistros = NUMERO_DE_REGISTROS - NUMERO_DE_THREADS * minimoDeRegstrosPorThread;
//		int inicio = 0;
//		
//		LOGGER.info("minimoDeRegstrosPorThread: "+minimoDeRegstrosPorThread);
//		LOGGER.info("maximoDeRegistrosPorThread: "+maximoDeRegistrosPorThread);
//		LOGGER.info("threadsConMaximodDeRegistros: "+threadsConMaximodDeRegistros);
//
//		List<Future<List<AvaluoCerradoMaiDomain>>> listaFuture = new ArrayList<Future<List<AvaluoCerradoMaiDomain>>>();
//		ExecutorService executor  = Executors.newFixedThreadPool(NUMERO_DE_THREADS);
//		
//		for (int i = 0; i < NUMERO_DE_THREADS; i++) 
//		{
//			int registros = (i < threadsConMaximodDeRegistros ? maximoDeRegistrosPorThread : minimoDeRegstrosPorThread);
//	        int fin = inicio + registros;
//	        LOGGER.info("Thread["+i+"] registros:["+avaluosCerrados.subList(inicio, fin).size()+"]  elementos:"+AvaluosUtils.obtenerIdsAavaluos(avaluosCerrados.subList(inicio, fin)));
//	        listaFuture.add(executor.submit(new ProcesoFotosAvaluo(avaluosCerrados.subList(inicio, fin),servicePeticion,serviceBitacora) ));
//	        inicio = fin;
//		}
//			List<AvaluoCerradoMaiDomain> envioCompleto = new ArrayList<AvaluoCerradoMaiDomain>();
//			List<AvaluoCerradoMaiDomain> envioAvaluo = new ArrayList<AvaluoCerradoMaiDomain>();
//			List<AvaluoCerradoMaiDomain> todos = new ArrayList<AvaluoCerradoMaiDomain>();
//			
//			for( Future<List<AvaluoCerradoMaiDomain>> f : listaFuture  )
//			{
//				LOGGER.info("Validando procesados...");
//				for( AvaluoCerradoMaiDomain avaluo : f.get() )
//				{
//					LOGGER.info("Avaluo: "+avaluo.getIdAvaluo() + " Resultado envio1:["+avaluo.getResultadoEnvio1()+"] - mensaje:["+avaluo.getRespuestaEnvio1()+"]"+" Resultado envio2:["+avaluo.getResultadoEnvio2()+"] - mensaje:["+avaluo.getRespuestaEnvio2()+"]");
//					
//					if( avaluo.isEnvioAvaluo() && avaluo.isEnvioFoto() )
//					{
//						if( !envioCompleto.contains(envioCompleto.indexOf(avaluo)))
//						{
//							envioCompleto.add(avaluo);
//						}
//					}else if( avaluo.isEnvioAvaluo() && !avaluo.isEnvioFoto() )
//					{
//						if( !envioAvaluo.contains(envioAvaluo.indexOf(avaluo)))
//						{
//							envioAvaluo.add(avaluo);
//						}
//					}
//					if( !todos.contains(todos.indexOf(avaluo)))
//					{
//						todos.add(avaluo);
//					}
//				}
//			}
//			executor.shutdown();
//			ResumenEnvioAvaluoDomain resumenEnvioDomain = new ResumenEnvioAvaluoDomain();
//			resumenEnvioDomain.setFechaInicio(fechaInicio);
//			resumenEnvioDomain.setFechaFin(fechaFin);
//			resumenEnvioDomain.setEnviadosConFoto(envioCompleto.size());
//			resumenEnvioDomain.setEnviadosSinFoto(envioAvaluo.size());
//			LOGGER.info("Periodo - Fecha Inicio["+fechaInicio+"] FechaFin["+fechaFin+"]");
//			LOGGER.info(" Total avaluos encontrados: "+(avaluosCerrados.size())+ "| Total avaluos enviados: "+(envioAvaluo.size()));
//			LOGGER.info("Resumen: "+(resumenEnvioDomain.toString()));
//			LOGGER.info("Finaliza el envio de avaluos");
//		}else
//		{
//			LOGGER.info("No hay avaluos cerrados");
//		}
		
		//Ejemplo de paarticion de una lista, las particiones se conceptualizan como los numero sde threads
		//Creando la lista - - -
//		List<String> arrayList = new ArrayList<String>();
//	    for (int i = 0; i < 294; i++) {
//	        arrayList.add(String.valueOf(i+1));
//	    }
//		
//		LOGGER.info("Total de avaluos cerrados encontrados: "+arrayList);
//		int NUMERO_DE_THREADS = 4;
//		int NUMERO_DE_REGISTROS = arrayList.size();
//		
//		LOGGER.info("Threads: "+NUMERO_DE_THREADS);
//		LOGGER.info("Avaluos encontrados: "+NUMERO_DE_REGISTROS);
//		
//		int minimoDeRegstrosPorThread = NUMERO_DE_REGISTROS / NUMERO_DE_THREADS;
//		int maximoDeRegistrosPorThread = minimoDeRegstrosPorThread + 1;
//		int threadsConMaximodDeRegistros = NUMERO_DE_REGISTROS - NUMERO_DE_THREADS * minimoDeRegstrosPorThread;
//		int inicio = 0;
//		
//		LOGGER.info("minimoDeRegstrosPorThread: "+minimoDeRegstrosPorThread);
//		LOGGER.info("maximoDeRegistrosPorThread: "+maximoDeRegistrosPorThread);
//		LOGGER.info("threadsConMaximodDeRegistros: "+threadsConMaximodDeRegistros);
//		
//		for (int i = 0; i < NUMERO_DE_THREADS; i++) {
//	        int registros = (i < threadsConMaximodDeRegistros ? maximoDeRegistrosPorThread : minimoDeRegstrosPorThread);
//	        int fin = inicio + registros;
//	        LOGGER.info("Thread["+i+"] registros:["+arrayList.subList(inicio, fin).size()+"]  elementos:"+arrayList.subList(inicio, fin));
//	        inicio = fin;
//	    }

		
		//Obtener cadena de archivo con Bass64 binary - - - 
//		String encodeFile = null;
//		byte[] contenido = FileUtils.readFileToByteArray(new File("C:/Users/adrian.casas/Pictures/ImagenesGPS/Fachada1.jpeg"));
//		encodeFile = Base64.encodeBase64String(contenido);
//		FileUtils.writeStringToFile(new File("C:/logs/encode.txt"),encodeFile);
//		System.out.println("Finaliza escritura");
//		
		
//		StringWriter writer = null;
//		Serializer serializer = null;
//		
//		writer = new StringWriter();
//		serializer = new Persister();
//		
//		FotoDomain foto = new FotoDomain("30176129273100686","4","1514557200","","","");
//
//		serializer.write(foto, writer);
//		
//		String xmlEntrada = writer.toString().replace("<fotoDomain>","").replace("</fotoDomain>","");
//		
//		LOGGER.info("Xml a enviar para la imagen:"+ xmlEntrada.toString());
		

		
}
	
}


