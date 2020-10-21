package mx.org.infonavit.solicitud.oferente.controllers;
//package mx.org.infonavit.reporteuvs.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
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
//
///**
// * Servlet implementation class ArchivosControlador
// */
//public class ArchivosControlador extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ArchivosControlador() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
//	throws ServletException, IOException {
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
//						user=user+"_Controlador";
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
//			            	sesion.setAttribute("Controlador",nombrear);
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
//
//}
