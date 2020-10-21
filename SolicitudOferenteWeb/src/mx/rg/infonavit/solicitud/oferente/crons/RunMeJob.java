/*
 * Creado el 13/10/2011
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package mx.rg.infonavit.solicitud.oferente.crons;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;










/**
 * @author Administrador
 *
 * Para cambiar la plantilla para este comentario de tipo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
public class RunMeJob  implements Job

	{

		
			


		public void execute(JobExecutionContext context)
		throws JobExecutionException {
		
			  ResourceBundle resourceBundle     = ResourceBundle.getBundle("mx/configuraciones/UrlServlet");
			  String  URLServlet =resourceBundle.getString("URLLanzador") ;

		System.out.println(URLServlet);
		System.out.println("cada minuto es esto =D");
		
		try{
			
			
			URL url = new URL(URLServlet);
							url.openConnection();
							url.openStream();
			
			
		  }
	    catch(Exception e)
		{
		e.printStackTrace();
				
		}

	}
	}



