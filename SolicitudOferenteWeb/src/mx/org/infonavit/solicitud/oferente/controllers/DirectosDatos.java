package mx.org.infonavit.solicitud.oferente.controllers;
//package mx.org.infonavit.reporteuvs.servlet;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.dialect.IngresDialect;
//
//import mx.org.infonavit.reporteuvs.cone.CalculadorDao;
//import mx.org.infonavit.reporteuvs.vo.EstadosCerradosVo;
//import mx.org.infonavit.reporteuvs.vo.MesDatoVo;
//
///**
// * Servlet implementation class DirectosDatos
// */
//public class DirectosDatos extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	CalculadorDao dao = new CalculadorDao();  
//	List<MesDatoVo> mespaquete =new MesDatoVo();
//	List<MesDatoVo> mesmai =new MesDatoVo();
//	List<MesDatoVo> totales =new MesDatoVo();
//	List<EstadosCerradosVo> EstadosCerradosVo =new EstadosCerradosVo();
//	List<EstadosCerradosVo> EstadosCerradosVoMai =new EstadosCerradosVo();
//	List<EstadosCerradosVo> IdEstadosPaquete =new EstadosCerradosVo();
//	List<EstadosCerradosVo> IdEstadosMai =new EstadosCerradosVo();
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DirectosDatos() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		  Calendar fecha = new GregorianCalendar();
//		   Calendar fecha2 = new GregorianCalendar();
//		   Calendar fecha3 = new GregorianCalendar();
//		   Calendar fecha4 = new GregorianCalendar();
//	        //Obtenemos el valor del año, mes, día,
//	        //hora, minuto y segundo del sistema
//	        //usando el método get y el parámetro correspondiente
//	        int anio = fecha.get(Calendar.YEAR);
//	        int mes = fecha.get(Calendar.MONTH);
//	        mes =mes+1;
//	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
//	        int hora = fecha.get(Calendar.HOUR_OF_DAY);
//	        int minuto = fecha.get(Calendar.MINUTE);
//	        int segundo = fecha.get(Calendar.SECOND);
//	        System.out.println("Fecha Actual: "
//	                           + dia + "/" + (mes) + "/" + anio);
//	        System.out.printf("Hora Actual: %02d:%02d:%02d %n",
//	                                              hora, minuto, segundo);
//	        
//	        
//		String bandera = request.getParameter("rango");
//		
//		if(bandera.equals("ACH")){
//			System.out.println("grafica por dia");			
//			String fechaIniciodia=dia+"-"+mes+"-"+anio;
//			System.out.println("grafica por dia: "+fechaIniciodia);
//			String sqlpaquete="SELECT CONVERT(VARCHAR(2), fecha_cierre, 108) 'hora', COUNT(*) as avaluos from avaluo with (nolock)" +
//					"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1'" +
//					"group by CONVERT(VARCHAR(2), fecha_cierre, 108) order by CONVERT(VARCHAR(2), fecha_cierre, 108)";
//			String sqlMAI="SELECT CONVERT(VARCHAR(2), fecha_cierre, 108) 'hora', COUNT(*) as avaluos from avaluo with (nolock)" +
//					"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2'" +
//					"group by CONVERT(VARCHAR(2), fecha_cierre, 108) order by CONVERT(VARCHAR(2), fecha_cierre, 108)";
//			try {
//				mespaquete=dao.dia(sqlpaquete);
//				mesmai=dao.dia(sqlMAI);
//				request.getSession().setAttribute("fechaIniciodia", fechaIniciodia);
//				request.getSession().setAttribute("mespaquete", mespaquete);
//				request.getSession().setAttribute("mesmai", mesmai);
//				response.sendRedirect("Jsp/Graficadia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}	
//		}else if(bandera.equals("ACS")){
//			String anio2 = null;
//			String mes2;
//			System.out.println("el año es "+anio +"pero el mes "+mes);
//			int a=mes;
//			int b=anio;
//			if (a==12){
//				b=b+1;
//				anio2=Integer.toString(b);
//				mes2="01";
//			}else{
//				if (a<9){
//					a=a+1;
//					mes2="0";
//					mes2=mes2+Integer.toString(a);
//					anio2=Integer.toString(anio);
//				}else{
//					a=a+1;
//					mes2=Integer.toString(a);
//					anio2=Integer.toString(anio);
//				}
//			}	
//			String mes1;
//			if(mes <9){
//				mes1="0"+Integer.toString(mes);
//			}else{
//				mes1=Integer.toString(mes);
//			}
//			
//			String sqlpaquete="select day(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//			"where fecha_cierre > '"+anio+"-"+mes1+"-01' and fecha_cierre < '"+anio2+"-"+mes2+"-01' and id_tipo_mercado='1'" +
//			"group by  day(fecha_cierre)";
//			String sqlMAI="select day(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//			"where fecha_cierre > '"+anio+"-"+mes1+"-01' and fecha_cierre < '"+anio2+"-"+mes2+"-01' and id_tipo_mercado='2' and tipo_linea='2'" +
//			"group by  day(fecha_cierre)";
//			String sql="select day(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//			"where fecha_cierre > '"+anio+"-"+mes1+"-01' and fecha_cierre < '"+anio2+"-"+mes2+"-01' " +
//			"group by  day(fecha_cierre)";
//			try {
//				String fechaIniciomes="";
//				mespaquete=dao.llenames(fechaIniciomes, sqlpaquete);
//				mesmai=dao.llenames(fechaIniciomes, sqlMAI);
//				totales=dao.llenames(fechaIniciomes, sql);
//				fechaIniciomes="01-"+mes1+anio;
//				request.getSession().setAttribute("fechaIniciomes", fechaIniciomes);
//				request.getSession().setAttribute("mespaquete", mespaquete);
//				request.getSession().setAttribute("totales", totales);
//				request.getSession().setAttribute("mesmai", mesmai);
//				response.sendRedirect("Jsp/GraficaMes.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}else if(bandera.equals("ACM")){
//			System.out.println("grafica por año de meses");	
//				System.out.println("entro en el if");
//				int b=anio;
//				b=b+1;
//				String anio2=Integer.toString(b);
//				String sqlpaquete="select MONTH(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//				"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+anio2+"-01-01' and id_tipo_mercado='1'" +
//				"group by  MONTH(fecha_cierre)";
//				String sqlMAI="select MONTH(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//				"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+anio2+"-01-01' and id_tipo_mercado='2' and tipo_linea='2'" +
//				"group by  MONTH(fecha_cierre)";
//				try {
//					String fechaIniciomes=Integer.toString(anio);
//					mespaquete=dao.llenames(fechaIniciomes, sqlpaquete);
//					mesmai=dao.llenames(fechaIniciomes, sqlMAI);
//					request.getSession().setAttribute("fechaInicio", fechaIniciomes);
//					request.getSession().setAttribute("mespaquete", mespaquete);
//					request.getSession().setAttribute("mesmai", mesmai);
//					response.sendRedirect("Jsp/Graficaanio.jsp"); 
//				} catch (SQLException e) {
//					// TODO Bloque catch generado automáticamente
//					e.printStackTrace();
//				}	
//		}else if(bandera.equals("ACA")){
//			
//
//			String anio1="2005";
//			String aniofin=Integer.toString(anio);
//			String fechaIniciomes=Integer.toString(anio);
//			System.out.println("grafica por mes la fecha: "+fechaIniciomes);
//			String sqlpaquete="select year(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//			"where fecha_cierre > '"+anio1+"-01-01' and fecha_cierre < '"+aniofin+"-12-31' and id_tipo_mercado='1'" +
//			"group by  year(fecha_cierre)";
//			String sqlMAI="select year(fecha_cierre) as dia,COUNT(*) as AvaCerrados from avaluo with (nolock)" +
//			"where fecha_cierre > '"+anio1+"-01-01' and fecha_cierre < '"+aniofin+"-12-31' and id_tipo_mercado='2' and tipo_linea='2'" +
//			"group by  year(fecha_cierre)";
//			try {
//				mespaquete=dao.llenames(fechaIniciomes, sqlpaquete);
//				mesmai=dao.llenames(fechaIniciomes, sqlMAI);
//				request.getSession().setAttribute("fechaInicio", fechaIniciomes);
//				request.getSession().setAttribute("mespaquete", mespaquete);
//				request.getSession().setAttribute("mesmai", mesmai);
//				response.sendRedirect("Jsp/Graficaanioext.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//		}else if(bandera.equals("ACEH")){
//			
//			System.out.println("grafica por dia");
//			
//			String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion order by descripcion";
//			
//			String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion order by descripcion";
//			
//			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			
//			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			try {
//				EstadosCerradosVo=dao.estados(sqlpaquete);
//				EstadosCerradosVoMai=dao.estados(sqlMAI);
//				IdEstadosPaquete=dao.estados2(sqlnue);
//				IdEstadosMai=dao.estados2(sqlnuemai);
//				String rango="100";
//				request.getSession().setAttribute("rango", rango);
//				request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
//				request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
//				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
//				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
//				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}else if(bandera.equals("ACES")){
//			
//			System.out.println("grafica por dia");
//			
//			String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion order by descripcion";
//			
//			String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion order by descripcion";
//			
//			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			
//			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			try {
//				EstadosCerradosVo=dao.estados(sqlpaquete);
//				EstadosCerradosVoMai=dao.estados(sqlMAI);
//				IdEstadosPaquete=dao.estados2(sqlnue);
//				IdEstadosMai=dao.estados2(sqlnuemai);
//				String rango="100";
//				request.getSession().setAttribute("rango", rango);
//				request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
//				request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
//				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
//				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
//				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}else if(bandera.equals("ACEM")){
//			
//			System.out.println("grafica por semana");
//			String anio2 = null;
//			String mes2;
//			System.out.println("el año es "+anio +"pero el mes "+mes);
//			int a=mes;
//			int b=anio;
//			if (a==12){
//				b=b+1;
//				anio2=Integer.toString(b);
//				mes2="01";
//			}else{
//				if (a<9){
//					a=a+1;
//					mes2="0";
//					mes2=mes2+Integer.toString(a);
//					anio2=Integer.toString(anio);
//				}else{
//					a=a+1;
//					mes2=Integer.toString(a);
//					anio2=Integer.toString(anio);
//				}
//			}	
//			String mes1;
//			if(mes <9){
//				mes1="0"+Integer.toString(mes);
//			}else{
//				mes1=Integer.toString(mes);
//			}
//			System.out.print("");
//			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes1+"-01 00:00' and fecha_cierre <= '"+anio2+"-"+mes2+"-01 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			System.out.print("este es SQL "+ sqlnue);
//			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-"+mes1+"-01 00:00' and fecha_cierre <= '"+anio2+"-"+mes2+"-01 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			System.out.print("el otro "+sqlnuemai);
//			try {
//				IdEstadosPaquete=dao.estados2(sqlnue);
//				IdEstadosMai=dao.estados2(sqlnuemai);
//				String rango="1000";
//				request.getSession().setAttribute("rango", rango);
//				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
//				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
//				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}else if(bandera.equals("ACEA")){
//			
//			System.out.println("grafica por semana");
//			
//			
//			System.out.println("el año es "+anio +"pero el mes ");
//			int a=mes;
//			int b=anio+1;
//			String anio2=Integer.toString(b);
//			
//			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-01-01 00:00' and fecha_cierre <= '"+anio2+"-01-01 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			
//			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '"+anio+"-01-01 00:00' and fecha_cierre <= '"+anio2+"-01-01 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			try {
//				IdEstadosPaquete=dao.estados2(sqlnue);
//				IdEstadosMai=dao.estados2(sqlnuemai);
//				String rango="10000";
//				request.getSession().setAttribute("rango", rango);
//				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
//				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
//				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}else if(bandera.equals("ACET")){
//			
//			System.out.println("grafica por semana");
//			
//			
//			System.out.println("el año es "+anio +"pero el mes ");
//			int a=mes;
//			int b=anio+1;
//			String anio2=Integer.toString(b);
//			
//			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '2005-01-01 00:00' and fecha_cierre <= '"+anio2+"-01-01 23:59' and id_tipo_mercado='1' " +
//					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			System.out.print("este es SQL "+ sqlnue);
//			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
//			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
//			"where fecha_cierre >= '2005-01-01 00:00' and fecha_cierre <= '"+anio2+"-01-01 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
//			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
//			System.out.print("este es SQL "+ sqlnuemai);
//			try {
//				IdEstadosPaquete=dao.estados2(sqlnue);
//				IdEstadosMai=dao.estados2(sqlnuemai);
//				String rango="100000";
//				request.getSession().setAttribute("rango", rango);
//				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
//				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
//				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
//			} catch (SQLException e) {
//				// TODO Bloque catch generado automáticamente
//				e.printStackTrace();
//			}
//			
//		}
//		
//		
//		
//		
//		
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
