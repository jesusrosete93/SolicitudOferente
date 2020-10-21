
package mx.org.infonavit.solicitud.oferente.cone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * Empresa : Avansis S.A de C.V 
 * @author : Ing. Luis Alberto Pérez Couto
 * 
 * Clase que establece la comunicación con la base de datos.
 */
public class Conexionbd {

    private static Context 				contexto;
	private static DataSource 			dsTrenViviendaWS;
	private	static String				jdbcTrenVivienda;
	
	private static final Logger LOG = LogManager.getLogger("Conexionbd");
	
	     /**
	     * Activa objeto datasource.
		 * @throws SQLException
		 * @throws NamingException
		 * @throws Exception
		 */
	private void tomarDs() throws SQLException, NamingException
	{
		
					try
					{
						//jdbcTrenVivienda		= "jdbc/TablasComunes";
						jdbcTrenVivienda		= "jdbc/tablas_comunes";
						
						contexto 			= new InitialContext( );
						dsTrenViviendaWS 	= ( DataSource ) contexto.lookup( jdbcTrenVivienda );
						LOG.info("Conexion Tablas Comunes Creada ...");
					}
					catch (NamingException e)
					{
						// Avansis  SA de  CV 		May 31, 2006   IEMABM01
						LOG.error(" ERROR   : " + e.getMessage());
				
						throw e;
					}
	
	}
	/***
	 * Constructor de la clase.
	 * @throws SQLException
	 * @throws NamingException
	 * @throws Exception
	 */
	public Conexionbd() throws SQLException, NamingException
		{
			
			if(dsTrenViviendaWS==null)
			{
			tomarDs();
			}
			
		}
	
	/***
	 * Tomar conexión de base de datos activa
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public  Connection getConexion() throws SQLException
		{
			//System.out.println( "ConexionFactory.getConexion( ) - " + objeto.getClass( ).getName( ) );

			return dsTrenViviendaWS.getConnection();
		}

     /***
      * Cerrar conexión de base de datos activa.
      * @param cnx
      */
		public  void close(final Connection cnx)
		{
			//System.out.println( "ConexionFactory.close( ) - " + objeto.getClass( ).getName( ) );
			try
			{
				if(cnx!=null && !cnx.isClosed())
				{
					cnx.close();
			       LOG.info("Conexion Tablas Comunes cerrada...");
				}
				
			}
			catch (SQLException e)
			{
				
				LOG.error(" ERROR   : " + e.getMessage());
		    }
		}
	
	
	/**
		 * <br>Fecha: Feb 18, 2011
		  * Avansis - Adrian Casas
		  *@param resultSet
		 */
		public void closeResultSet(final ResultSet resultSet )
		{
			try
			{
				if(resultSet!=null )
				{
					resultSet.close();
				}
			
			}
			catch (SQLException e)
			{
				LOG.error(" ERROR   : " + e.getMessage());
			}
		
		}
	
		/**
		 * <br>Fecha: Feb 18, 2011
		  * Avansis - Adrian Casas
		  *@param statement
		 */
		public void closeStatement(final Statement statement )
		{
			try
			{
				if(statement!=null )
				{
					statement.close();
				}
	
			}
			catch (SQLException e)
			{
				LOG.error(" ERROR   : " + e.getMessage());
			}
		}
	
	

}
