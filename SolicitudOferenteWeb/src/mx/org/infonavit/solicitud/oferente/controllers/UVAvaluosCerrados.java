package mx.org.infonavit.solicitud.oferente.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.cone.CalculadorDao;
import mx.org.infonavit.solicitud.oferente.vo.AvaluosEstadosUnidadesVO;

/**
 * Servlet implementation class UVAvaluosCerrados
 */
public class UVAvaluosCerrados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<AvaluosEstadosUnidadesVO> aeu=new AvaluosEstadosUnidadesVO();
	CalculadorDao dao=new CalculadorDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UVAvaluosCerrados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fechaInicio=request.getParameter("f_rangeStart");
		String anioInicio=fechaInicio.substring(0,4);
		String mesInicio=fechaInicio.substring(5,7);
		String diaInicio=fechaInicio.substring(8);
		String fechaTermino=request.getParameter("f_rangeStart2");
		String anioFin=fechaTermino.substring(0,4);
		String mesFin=fechaTermino.substring(5,7);
		String diaFin=fechaTermino.substring(8);
		String estado=request.getParameter("estado");
		String uV[]=request.getParameterValues("UV");
		
		System.out.println("fecha inicio: "+fechaInicio);
		System.out.println("fecha termino: "+fechaTermino);
		System.out.println("estados: "+estado);
		System.out.println("UV: "+uV.length);
		
		String where=null;
		String sql=null;
		int opcion;
		if(uV.length>0){
			opcion=uV.length;
		}else{
			opcion=0;
		}
		if(estado.equals("0")){
			System.out.println("entro en el if de 0 "+estado);
			where="";
		}else{
			System.out.println("no es cero y agrego datos "+estado);
			where = "and SUBSTRING(a.id_avaluo, 1,2)= '"+estado+"' ";
		}
		
		if(opcion==0){
			System.out.println("la opcion es 0 "+opcion);
			sql="select a.id_uv, b.descripcion, COUNT(*) as avaluosCerrados from avaluo a with (nolock) " +
			"left join cat_uv b on b.id_uv=a.id_uv " +
			"where fecha_cierre >= '"+anioInicio+"-"+mesInicio+"-"+diaInicio+" 00:00' and fecha_cierre <= '"+anioFin+"-"+mesFin+"-"+diaFin+" 00:00' "+where+" " +
			"group by b.descripcion, a.id_uv " +
			"order by b.descripcion";
			
		}else if(opcion == 1){
			System.out.println("la opcion es uno "+opcion);
			int o=uV[0].length();
			if(o==1){
			where=where+" and b.descripcion != 'unidad antigua' and b.descripcion != ' ' and b.descripcion != 'Sin uv' ";
			}else{
				where=where+" and a.id_uv='"+uV[0].substring(0,4)+"'";
			}
			sql="select a.id_uv, b.descripcion, COUNT(*) as avaluosCerrados from avaluo a with (nolock) " +
			"left join cat_uv b on b.id_uv=a.id_uv " +
			"where fecha_cierre >= '"+anioInicio+"-"+mesInicio+"-"+diaInicio+" 00:00' and fecha_cierre <= '"+anioFin+"-"+mesFin+"-"+diaFin+" 00:00'  "+where+" " +
			"group by b.descripcion, a.id_uv " +
			"order by b.descripcion";
			
		}else{			
			System.out.println("la opcion tiene muchos "+opcion);
			for(int a=0; a<uV.length; a++){
				if(a==0){
				String subuv;
				subuv=uV[a].substring(0,4);
				where=where+" and a.id_uv in ('"+subuv+"'";
			}else{
				String subuv;
				subuv=uV[a].substring(0,4);
				if(a==uV.length-1){
					where=where+",'"+subuv+"')";	
				}else{
					where=where+",'"+subuv+"'";
				}}
		}
			
			sql="select a.id_uv, b.descripcion, COUNT(*) as avaluosCerrados from avaluo a with (nolock) " +
			"left join cat_uv b on b.id_uv=a.id_uv " +
			"where fecha_cierre >= '"+anioInicio+"-"+mesInicio+"-"+diaInicio+" 00:00' and fecha_cierre <= '"+anioFin+"-"+mesFin+"-"+diaFin+" 00:00' "+where+" " +
			"group by b.descripcion, a.id_uv " +
			"order by b.descripcion";
			
		}
		
		
		
		System.out.println(sql);
		try {
			aeu=dao.UvsEstado(sql);
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("aeu", aeu);
//		request.getSession().setAttribute("mesmai", EstadosCerradosVoMai);
		response.sendRedirect("Jsp/UnidadValuadorasC.jsp"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
