package mx.rg.infonavit.solicitud.oferente.crons;
//package mx.rg.infonavit.reportesuvs.crons;
//import java.io.IOException;
//import java.util.ResourceBundle;
//
//import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import mx.org.infonavit.avaluos.solicitarAvaluos.consultas.business.NegociocronuvProxy;
//
///**
// * @version 	1.0
// * @author
// */
//public class Lanzadorcron extends HttpServlet implements Servlet {
//
//	/**
//	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
//	*/
//	public void doGet(HttpServletRequest req, HttpServletResponse resp)
//		throws ServletException, IOException 
//		{
//
//        doPost(req,resp);
//	   }
//
//	/**
//	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
//	*/
//	public void doPost(HttpServletRequest req, HttpServletResponse resp)
//		throws ServletException, IOException {
//
//			System.out.println("ENTRANDO AL SERVLET DEL CRON RUNMEJOB...");
//				
//				try
//				    {
//				    
//					ResourceBundle resourceBundle     = ResourceBundle.getBundle("mx/configuraciones/UrlServlet");
//					String  url =resourceBundle.getString("URLWSNegocio") ;
//					System.out.println( url);
//					NegociocronuvProxy ws = new NegociocronuvProxy();
//					ws.setEndpoint(url);
//					ws.procesoinex();
//					}
//					catch(Exception e)
//					{
//					e.printStackTrace();
//					}
//	
//	
//	}
//	
//
//}
