package mx.org.infonavit.solicitud.oferente.controllers;
//package mx.org.infonavit.reporteuvs.servlet;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.openjpa.jdbc.kernel.exps.Substring;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.hibernate.dialect.IngresDialect;
//
//import com.ibm.ws.wim.dao.DAOHelper;
//
//import mx.org.infonavit.reporteuvs.avanzado.BussinesAvanzada;
//import mx.org.infonavit.reporteuvs.bussines.ActionDatos;
//import mx.org.infonavit.reporteuvs.bussines.ConsultDatos;
//import mx.org.infonavit.reporteuvs.cone.CalculadorDao;
//import mx.org.infonavit.reporteuvs.vo.Consultatotal;
//import mx.org.infonavit.reporteuvs.vo.PaqueteMaiVO;
//
///**
// * Servlet implementation class Informacion
// */
//public class Informacion extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	CalculadorDao dao=new CalculadorDao();
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Informacion() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		int bandera=0;
//		
//					   Calendar fecha = new GregorianCalendar();
//					   Calendar fecha2 = new GregorianCalendar();
//					   Calendar fecha3 = new GregorianCalendar();
//					   Calendar fecha4 = new GregorianCalendar();
//				        //Obtenemos el valor del año, mes, día,
//				        //hora, minuto y segundo del sistema
//				        //usando el método get y el parámetro correspondiente
//				        int anio = fecha.get(Calendar.YEAR);
//				        int mes = fecha.get(Calendar.MONTH);
//				        int dia = fecha.get(Calendar.DAY_OF_MONTH);
//				        int hora = fecha.get(Calendar.HOUR_OF_DAY);
//				        int minuto = fecha.get(Calendar.MINUTE);
//				        int segundo = fecha.get(Calendar.SECOND);
//				        System.out.println("Fecha Actual: "
//				                           + dia + "/" + (mes+1) + "/" + anio);
//				        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
//				                                              hora, minuto, segundo);
//				        
//		 	       String uvs[]=request.getParameterValues("tags[]");
//		 	       String estados[]=request.getParameterValues("estados[]");
//		 	       String fecha_inicio=request.getParameter("fecha_inicio");
//		 	       String fecha_termino=request.getParameter("fecha_termino");
//		 	       String paquete=request.getParameter("paquete");
//		 	       String avaluo=request.getParameter("avaluo");
//		 	       String cuvs=request.getParameter("cuvs");
//		 	       String paqueteEntrga=request.getParameter("tipo_paquete");
//		 	       String Nss=request.getParameter("NSS");
//		 	       String Controlador=request.getParameter("controlador");
//		 	       String Perito=request.getParameter("perito");
//		 	       String boton=request.getParameter("buscar");
//		 	       String boton2=request.getParameter("buscarAvanzada");
//		 	       if(paqueteEntrga == null){paqueteEntrga="nada";}
//		 	       if(estados == null) {
//		 	    	   System.out.println("aqui si entro bien jeje");
//		 	    	   String estad[]=new String[1];
//		 	    	   estad[0]="0";
//		 	    	   estados=estad;
//		 	       }
//		 	       System.out.println("llego al actionDatos paquete: "+paquete);
//		 	       System.out.println("llego al actionDatos avaluos: "+avaluo);
//		 	       System.out.println("llego al actionDatos cuvs: "+cuvs);
//		 	       System.out.println("llego al actionDatos Nss: "+Nss);
//		 	       System.out.println("llego al actionDatos Controlador: "+Controlador);
//		 	       System.out.println("llego al actionDatos Perito: "+Perito);
//		 	       System.out.println("llego al actionDatos boton: "+boton);
//		 	      System.out.println("llego al actionDatos boton2: "+boton2);
//		 	       ActionDatos action = new ActionDatos();
//		 	       HttpSession sesion = request.getSession();
//		 			String user = (String) sesion.getAttribute("user");
//		 			int NumCosnsult= action.datos(uvs,estados,fecha_inicio,fecha_termino,paquete,avaluo,cuvs,user, sesion, Nss, Controlador, Perito);
//		 			String where=action.where1(uvs, estados, fecha_inicio, fecha_termino,paquete, avaluo, cuvs, user, sesion, NumCosnsult , Nss, Controlador, Perito);
//		 			
//		 			if(NumCosnsult==0){
//		 				
//		 			if(fecha_inicio.length()<7){
//		 				fecha3.add(Calendar.DAY_OF_YEAR, -366);
//		 				fecha_inicio=fecha3.get(Calendar.YEAR)+"-"+fecha3.get(Calendar.MONTH)+"-"+fecha3.get(Calendar.DAY_OF_MONTH);
//		 			}
//		 				
//		 			if(fecha_termino.length()<7){
//		 				String anio_inicio=fecha_inicio.substring(0,4);
//		 				int anio_int=Integer.parseInt(anio_inicio);		 				
//		 				anio_int=anio_int+1;
//		 				String mes_inicio=fecha_inicio.substring(5,7);
//		 				int mes_int=Integer.parseInt(mes_inicio);
//		 				where=where+" a.fecha_cierre between ('"+fecha_inicio+" 00:00') and ('"+anio_int+"-"+mes_int+"-01 23:59') ";
//		 				bandera=1;
//		 				}else{
//		 				String anio_inicio=fecha_inicio.substring(0,4);
//		 				int anio_int=Integer.parseInt(anio_inicio);
//		 				String mes_inicio=fecha_inicio.substring(5,7);
//		 				int mes_int=Integer.parseInt(mes_inicio);
//		 				String dia_inicio=fecha_inicio.substring(8,10);
//		 				int dia_int=Integer.parseInt(dia_inicio);
//		 				fecha.set(anio_int, mes_int, dia_int);//fecha inicio
//		 				fecha2.set(anio_int, mes_int, dia_int);
//		 				fecha2.add(Calendar.DAY_OF_YEAR, 366);//fecha con 1 año de diferencia a fecha inicio
//		 				String anio_termino=fecha_termino.substring(0,4);
//		 				int anio_int2=Integer.parseInt(anio_termino);
//		 				String mes_termino=fecha_termino.substring(5,7);
//		 				int mes_int2=Integer.parseInt(mes_termino);
//		 				String dia_termino=fecha_termino.substring(8,10);
//		 				int dia_int2=Integer.parseInt(dia_termino);
//		 				fecha3.set(anio_int2, mes_int2, dia_int2);//fecha termino
//		 				if(fecha3.before(fecha2)){
//		 					System.out.println("entra porque la fecha termino es menor a un año");
//		 					where=where+" a.fecha_cierre between ('"+fecha_inicio+" 00:00') and ('"+fecha_termino+" 23:59') ";
//		 					bandera=1;
//		 				}
//		 				
//		 				//mandarlo a la chingada
//		 				
//		 				 
//		 			}
//		 			}else{
//		 				bandera=1;
//		 			}
////		 	     llenado de VO
//		 			if(bandera == 1){
//		 				List<Consultatotal> consulta=null;
//			 			List<PaqueteMaiVO> consultaMai=null;
//			 			
//		 				System.out.println("");
//		 			System.out.println("empiesa el llenado de el VO");
//		 			System.out.println("esto es lo que quiere: "+paqueteEntrga);
//		 			
//		 			
////		 			---------------------aqui corta
////		 			if(boton != null || boton.equals("consulta simplificada")){
//		 			if(boton != null){
//		 			
//		 			if( paqueteEntrga.equals("si")){
//		 				consulta=action.llenaVO(where, user);
//		 				action.txt(consulta, response);
//		 			}else if(paqueteEntrga.equals("no")){
//		 				consultaMai=action.llenaMaiVO(where, user);
//		 				action.txt2(consultaMai, response);
//		 			}else{
//		 				System.out.println("asta aqui llego");
//		 				System.out.println("contenido del where: "+where );
//		 				
//		 			consulta=action.llenaVO(where, user);
//		 			System.out.println("termina consulta");
//		 			consultaMai=action.llenaMaiVO(where, user);
//		 			System.out.println("termina consulta mai");
//		 			System.out.println("mostrar datos:"+consulta.size()); 	
//		 			
//		 			System.out.println("entro en la consulta normal");
//	 				action.txt(consulta, response);
//		 			action.txt2(consultaMai, response);
//		 			}
//		 			try {
//						dao.eliminar(user);
//					} catch (SQLException e) {
//						// TODO Bloque catch generado automáticamente
//						e.printStackTrace();
//					}
//		 			}else{
//		 				System.out.println("entro en la consulta avansada");
//		 				BussinesAvanzada BuA =new BussinesAvanzada();
//		 				try {
//							BuA.control(where, user,paqueteEntrga, response, request);
//						} catch (Exception e) {
//							// TODO Bloque catch generado automáticamente
//							e.printStackTrace();
//						}
//						
//						
//						
//						
//						
//		 			}
//		 			}
//		 			else{
//		 				response.sendRedirect("Jsp/Fallodatos.jsp");
//		 			}
//		 			return;	
//		 			
//		 	
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//}
