
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
 * Clase que establece la comunicación con la base de datos de Avaluos.
 */
public class ConexionAvaluosbd {

    private static Context 				contexto;
	private static DataSource 			dsAvaluoWS;
	private	static String				jdbcAvaluoWS;
	
	public static final Logger LOG = LogManager.getLogger("ConexionAvaluosbd");
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
						jdbcAvaluoWS		= "jdbc/avaluosWS";
						contexto 			= new InitialContext( );
						dsAvaluoWS 	= ( DataSource ) contexto.lookup( jdbcAvaluoWS );
						LOG.info("Conexion Avaluos creada jdbc/avaluosWS...");
					}
					catch (NamingException e)
					{
						// Avansis  SA de  CV 		May 31, 2006   IEMABM01
						LOG.error(" CLASE   : com.org.infonavit.reasignarpaqueteweb.dao");
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
	public ConexionAvaluosbd() throws SQLException, NamingException
		{
			
			if(dsAvaluoWS==null)
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

			return dsAvaluoWS.getConnection();
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
			        LOG.info("Conexion Seguridad cerrada...");
				}
				
			}
			catch (SQLException e)
			{
				LOG.error(" CLASE   : com.org.infonavit.reasignarpaqueteweb.dao");
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
