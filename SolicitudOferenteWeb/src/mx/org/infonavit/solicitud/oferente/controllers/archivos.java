package mx.org.infonavit.solicitud.oferente.controllers;
//package mx.org.infonavit.reporteuvs.servlet;
//
////import java.io.IOException;
////import java.util.List;
////
////import javax.servlet.ServletException;
////import javax.servlet.http.HttpServlet;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import mx.org.infonavit.reportesuvs.archivo.ArchivoR;
//import mx.org.infonavit.reporteuvs.cone.CalculadorDao;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.openjpa.jdbc.kernel.exps.Substring;
//
//import com.ibm.crypto.pkcs11impl.provider.Session;
//import com.ibm.ws.portletcontainer.ext.ExtInformationProviderWrapper;
//
//
//
//import java.io.File;
//import java.io.IOException;
//import java.net.InetAddress;
//
//import jxl.*;
//import jxl.read.biff.BiffException;
//
//
//
///**
// * Servlet implementation class archivos
// */
//public class archivos extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public archivos() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//		}
//	
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//		
//		HttpSession sesion = request.getSession();
//		String user = (String) sesion.getAttribute("user");
//		CalculadorDao dao = new CalculadorDao();
//		try {
//			dao.eliminar(user);
//		} catch (SQLException e) {
//			// TODO Bloque catch generado automáticamente
//			e.printStackTrace();
//		}
//		String userprin = (String) sesion.getAttribute("user");
//						System.out.println("user: "+user);
//						user=user+"_paquete";
//						
//			if(ServletFileUpload.isMultipartContent(request)){
//			    try {
//			        List<FileItem> multiparts = new ServletFileUpload(
//			                                 new DiskFileItemFactory()).parseRequest(request);
//			      
//			        for(FileItem item : multiparts){
//			        	
//			            if(!item.isFormField()){
//			            	
//			            	ArchivoR archivo =new ArchivoR();
//			            	String nombrear=archivo.procesa(item, user, userprin);
//			            	sesion.setAttribute("paquete",nombrear);
//			            	response.sendRedirect("Jsp/ExitoArchivo.jsp"); 
//			            }
//			        }
//			    } catch (Exception ex) {
//			    	response.sendRedirect("Jsp/FalloArchivo.jsp"); 
//			    }          
//			 
//			}else{
//				response.sendRedirect("Jsp/FalloArchivo.jsp"); 
//				System.out.println("no tiene documento adjunto");
//			}
//			
//			}
//}
