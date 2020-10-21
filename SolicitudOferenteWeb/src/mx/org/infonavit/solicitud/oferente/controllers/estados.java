package mx.org.infonavit.solicitud.oferente.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.cone.CalculadorDao;
import mx.org.infonavit.solicitud.oferente.vo.EstadosCerradosVo;
import mx.org.infonavit.solicitud.oferente.vo.MesDatoVo;

/**
 * Servlet implementation class estados
 */
public class estados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CalculadorDao dao=new CalculadorDao();
	List<EstadosCerradosVo> EstadosCerradosVo =new EstadosCerradosVo();
	List<EstadosCerradosVo> EstadosCerradosVoMai =new EstadosCerradosVo();
	List<EstadosCerradosVo> IdEstadosPaquete =new EstadosCerradosVo();
	List<EstadosCerradosVo> IdEstadosMai =new EstadosCerradosVo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("reporte por estados");
		System.out.println("");
		String fechaInicio=request.getParameter("fechaInicio");
		String fechafin=request.getParameter("fechafin");
		String fechaMes=request.getParameter("fechaMes");
		String fechaDia=request.getParameter("fechaDia");
		String bandera=request.getParameter("bandera");
		System.out.println();
		System.out.println("valor de la bandera: "+bandera);
		if(bandera.equals("1")){
			System.out.println("grafica por año");	
			System.out.println("valor de fechaFin: "+fechafin);
			if(fechafin.equals("no")){
				System.out.println("entro en el if");
				String anio=fechaInicio;
				int b=Integer.parseInt(anio);
				b=b+1;
				String anio2=Integer.toString(b);
				System.out.println("grafica por mes la fecha: "+fechaInicio);
				String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
						"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
						"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+anio2+"-01-01' and id_tipo_mercado='1' " +
						"group by descripcion order by descripcion";
				String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
						"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
						"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+anio2+"-01-01' and id_tipo_mercado='2' and tipo_linea='2' " +
								"group by descripcion order by descripcion";
				try {
					EstadosCerradosVo=dao.estados(sqlpaquete);
					EstadosCerradosVoMai=dao.estados(sqlMAI);
					request.getSession().setAttribute("fechaInicio", fechaInicio);
					request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
					request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
					response.sendRedirect("Jsp/GraficadiaEstadoAnio.jsp"); 
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
			}else{
				String anio=fechaInicio;
				String aniofin=fechafin;
				int b=Integer.parseInt(anio);
				b=b+1;
				String anio2=Integer.toString(b);
				System.out.println("grafica por mes la fecha: "+fechaInicio);
				String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
						"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
						"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+aniofin+"-12-31' and id_tipo_mercado='1' " +
								"group by descripcion order by descripcion";
				
				String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
						"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
						"where fecha_cierre > '"+anio+"-01-01' and fecha_cierre < '"+aniofin+"-12-31' and id_tipo_mercado='2' and tipo_linea='2' " +
								"group by descripcion order by descripcion";
				try {
					EstadosCerradosVo=dao.estados(sqlpaquete);
					EstadosCerradosVoMai=dao.estados(sqlMAI);
					request.getSession().setAttribute("fechaInicio", fechaInicio);
					request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
					request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
					response.sendRedirect("Jsp/GraficadiaEstadoAnio.jsp"); 
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
			}
		}else if (bandera.equals("2")){
			String anio=fechaInicio;
			String mes= fechaMes;
			String anio2 = null;
			String mes2;
			System.out.println("el año es "+anio +"pero el mes "+mes);
			int a=Integer.parseInt(mes);
			int b=Integer.parseInt(anio);
			if (a==12){
				b=b+1;
				anio2=Integer.toString(b);
				mes2="01";
			}else{
				if (a<9){
					a=a+1;
					mes2="0";
					mes2=mes2+Integer.toString(a);
					anio2=anio;
				}else{
					a=a+1;
					mes2=Integer.toString(a);
					anio2=anio;
				}
			}	
			
			System.out.println("grafica por mes la fecha: "+fechaMes);
			String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
					"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
					"where fecha_cierre > '"+anio+"-"+mes+"-01' and fecha_cierre < '"+anio2+"-"+mes2+"-01' and id_tipo_mercado='1' " +
							"group by descripcion order by descripcion";
			
			
			String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
					"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
					"where fecha_cierre > '"+anio+"-"+mes+"-01' and fecha_cierre < '"+anio2+"-"+mes2+"-01' and id_tipo_mercado='2' and tipo_linea='2' " +
					"group by descripcion order by descripcion";
			
			try {
				EstadosCerradosVo=dao.estados(sqlpaquete);
				EstadosCerradosVoMai=dao.estados(sqlMAI);
				request.getSession().setAttribute("fechaInicio", fechaInicio);
				request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
				request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
				response.sendRedirect("Jsp/GraficadiaEstadoMes.jsp"); 
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}else{
			System.out.println("grafica por dia");
			String dia=fechaDia;
			String anio=fechaInicio;
			String mes= fechaMes;
			String sqlpaquete="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
					"group by descripcion order by descripcion";
			
			String sqlMAI="select descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
			"group by descripcion order by descripcion";
			
			String sqlnue="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='1' " +
					"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
			
			String sqlnuemai="select SUBSTRING(a.id_avaluo, 1,2) as id_estado, descripcion, COUNT(*) as avaluos from avaluo a with (nolock) " +
			"left join cat_delegacion with (nolock) on SUBSTRING(a.id_avaluo, 1,2)+'000'=id_estado " +
			"where fecha_cierre >= '"+anio+"-"+mes+"-"+dia+" 00:00' and fecha_cierre <= '"+anio+"-"+mes+"-"+dia+" 23:59' and id_tipo_mercado='2' and tipo_linea='2' " +
			"group by descripcion, SUBSTRING(a.id_avaluo, 1,2) order by descripcion";
			try {
				EstadosCerradosVo=dao.estados(sqlpaquete);
				EstadosCerradosVoMai=dao.estados(sqlMAI);
				IdEstadosPaquete=dao.estados2(sqlnue);
				IdEstadosMai=dao.estados2(sqlnuemai);
				String rango="100";
				request.getSession().setAttribute("rango", rango);
				request.getSession().setAttribute("fechaInicio", fechaInicio);
				request.getSession().setAttribute("mespaquete", EstadosCerradosVo);
				request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
				request.getSession().setAttribute("IdEstadosPaquete", IdEstadosPaquete);
				request.getSession().setAttribute("IdEstadosMai", IdEstadosMai);
				response.sendRedirect("Jsp/GraficadiaEstadoDia.jsp"); 
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
