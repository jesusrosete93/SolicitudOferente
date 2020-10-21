package mx.org.infonavit.solicitud.oferente.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.org.infonavit.solicitud.oferente.business.PropertiesBusiness;
import mx.org.infonavit.solicitud.oferente.utils.Resources;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class PropertiesAction
 */
public class PropertiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LogManager.getLogger(PropertiesController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertiesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("propertiesConsulta","1");
		if(request.getParameter("n4me")!=null && request.getParameter("n4me").toString().equals("initConfig"))
		{
			request.getRequestDispatcher("/Jsp/propertiesConfig/initProperties.jsp").forward(request, response);
		}else
		{
			request.getRequestDispatcher("/Jsp/propertiesConfig/initProperties.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if( request.getParameter("consulta")!=null)
		{
			request.setAttribute("registros",Resources.REGISTROS_POR_CONSULTA);
			request.setAttribute("url",Resources.EP_SERVICIO_NEXURA);
			request.getRequestDispatcher("/Jsp/propertiesConfig/consultaProperties.jsp").forward(request, response);
		}else if(request.getParameter("modifica")!=null)
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream(Resources.CONSTANTES_CONFIG));
			request.setAttribute("registros",Resources.REGISTROS_POR_CONSULTA);
			request.setAttribute("url",Resources.EP_SERVICIO_NEXURA);
			request.getRequestDispatcher("/Jsp/propertiesConfig/modificaProperties.jsp").forward(request, response);
		}else if(request.getParameter("Cancelar")!=null)
		{
			request.getRequestDispatcher("/Jsp/propertiesConfig/initProperties.jsp").forward(request, response);;
		}else if(request.getParameter("modificaProperties")!=null)
		{
			PropertiesBusiness propertiesService = new PropertiesBusiness();
			propertiesService.modificarProperties(Integer.parseInt(String.valueOf(request.getParameter("registros"))),(String)request.getParameter("url"));
			propertiesService.cargarProperties();
			PropertiesBusiness.mostrarProperties();
			request.setAttribute("mensaje","Cambio exitoso");
			request.getRequestDispatcher("/Jsp/propertiesConfig/success.jsp").forward(request, response);;
		}
		else
		{
			response.sendRedirect("/Jsp/propertiesConfig/initProperties.jsp");
		}
		
	}

}
