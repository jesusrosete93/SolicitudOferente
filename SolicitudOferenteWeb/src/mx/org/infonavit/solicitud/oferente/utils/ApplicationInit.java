package mx.org.infonavit.solicitud.oferente.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.FactoryConfigurationError;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.business.PropertiesBusiness;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;










public class ApplicationInit implements ServletContextListener {
	
	
	private static Logger LOGGER;
	private static String FECHA_INICIAL;
	
	@Autowired
	private CatalogosBusines serviceCatalogo;
	
	@Autowired
	private PropertiesBusiness serviceProperties;
	
	
	
	
	/**
	 * 
	 */
	public ApplicationInit(){
		super();
		final	Calendar 			calendar 			= Calendar.getInstance();
		final	SimpleDateFormat	simpleDateFormat	= new SimpleDateFormat( "dd-MM-yy hh:mm:ss" );
		FECHA_INICIAL = simpleDateFormat.format( calendar.getTime() );
	}

	/**
	 * 
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//Obtenemos el contexto de Servlet para tener acceso a los parámetros de finalización.
		final	ServletContext	servletContext 			= sce.getServletContext	();
		final	Calendar 			calendar 			= Calendar.getInstance();
		final	SimpleDateFormat	simpleDateFormat	= new SimpleDateFormat( "dd-MM-yy hh:mm:ss" );
		final	String				fechaFinal 			= simpleDateFormat.format( calendar.getTime() );

			if ( LOGGER == null )
				{
				System.out.println( "" );
				System.out.println("---------------------------------------------------------------------" );
				System.out.println("\tAplicación ["+servletContext.getServletContextName()+"] Finalizada " + fechaFinal);
				System.out.println("---------------------------------------------------------------------");
				System.out.println( "" );
				}
			else
				{
				System.out.println( "" );
				LOGGER.info("---------------------------------------------------------------------" );
				LOGGER.info("\tAplicación ["+servletContext.getServletContextName()+"] Finalizada " + fechaFinal);
				LOGGER.info("---------------------------------------------------------------------");
				System.out.println( "" );
				}

	}
	/**
	 * 
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//Obtenemos el contexto de Servlet para tener acceso a los parámetros - - - - - - - - - - - - - - - - - - - -
		final	ServletContext	servletContext 			= sce.getServletContext	();
		final	String	realPath		 				= servletContext.getRealPath		( "" );
		final   String  log4jConfig						= servletContext.getInitParameter   ( "log4jConfiguration" );
		final	String  logPath							= servletContext.getInitParameter	( "PATH_LOG" );
		final	String  appContextConfig				= servletContext.getInitParameter	( "appContextConfig" );
		final	String  constantesConfig				= servletContext.getInitParameter	( "CONSTANTES_SETTINGS" );
		
		
		//Asignamos la ruta donde se guardara el Log - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
		System.setProperty("reporteuvs.log.file",logPath);
		
		
		try{
			DOMConfigurator.configure(realPath+log4jConfig);
			
			LOGGER = LogManager.getLogger(ApplicationInit.class.getName());
			
			//Se valida si existe el parametro en web.xml - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
			if ( log4jConfig == null || log4jConfig.equals( "" ) ) 
					throw new FactoryConfigurationError ( 	"No existe parámetro de configuración " +
															"<param-name>log4jConfig</param-name> " +
															"dentro del Descriptor de la Aplicación" );
															
															
			// Se obtiene la configuración para Log4J - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 												
			 WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext)
				.getAutowireCapableBeanFactory()
				.autowireBean(this);	            
      
			serviceCatalogo.cargarCatalogos();
			CatalogosBusines.displayInformation();
			
			System.out.println("a: "+realPath+appContextConfig);
			Resources.CONTEXT = new ClassPathXmlApplicationContext("application-context.xml");
			Resources.CONSTANTES_CONFIG = realPath + constantesConfig;
			serviceProperties.cargarProperties();
			PropertiesBusiness.mostrarProperties();
			System.out.println( "" );
			LOGGER.info( "* * * Iniciando aplicación: ["+servletContext.getServletContextName()+"]..." );
			LOGGER.info( "---------------------------------------------------------------------" );
			LOGGER.info( "\tFecha Inicio: [ " + FECHA_INICIAL							+" ] " );
			LOGGER.info( "\tContexto    : [ " + servletContext.getServletContextName()	+" ] " );
			LOGGER.info( "\tRuta Física : [ " + servletContext.getRealPath( "" )		+" ] " );
			LOGGER.info( "\tHost        : [ " + servletContext.getAttribute("com.ibm.websphere.servlet.application.host") +" ] " );  
			LOGGER.info( "---------------------------------------------------------------------");
			System.out.println( "" );
			
			
			
			} 
		catch ( FactoryConfigurationError factoryConfigurationError ) 
			{
			System.err.println(	"* * * Iniciando Aplicación: ["+servletContext.getServletContextName()+"] ..." + factoryConfigurationError.getMessage() );
			System.err.println(	"---------------------------------------------------------------------" );
			System.err.println(	"\tFecha Inicio: [ " + FECHA_INICIAL								+" ] " );
			System.err.println(	"\tContexto    : [ " + servletContext.getServletContextName()	+" ] " );
			System.err.println(	"\tRuta Física : [ " + servletContext.getRealPath( "" )			+" ] " );
			System.err.println(	"\tHost        : [ " + servletContext.getAttribute("com.ibm.websphere.servlet.application.host") +" ] " );  
			System.err.println(	"---------------------------------------------------------------------");
			}

	}

}
