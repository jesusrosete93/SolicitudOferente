/*
 * Created on Jun 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package mx.org.infonavit.solicitud.oferente.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Fechas {
	
	private static final Logger LOGGER = LogManager.getLogger(Fechas.class);
	private static final String PREFIJO = "[F] -";

	public static String getFechaHora() 
	{
		Calendar 		calendar 	= Calendar.getInstance();
		Date 			trialTime 	= new Date();
		calendar.setTime(trialTime);
	 	String mes	= ""+(1 + calendar.get(Calendar.MONTH)) ;
	  	if(mes.length()==1)
	  	{
			mes = "0"+ mes;
	  	}
	  
	  	String fecha 	=	calendar.get(Calendar.YEAR) 		+ "-" +	  
		//(1 + calendar.get(Calendar.MONTH)) 	+ "-" +
		mes	+ "-" +
		calendar.get(Calendar.DAY_OF_MONTH) + " " +  
		(calendar.get(Calendar.HOUR_OF_DAY))  + ":" + 
		calendar.get(Calendar.MINUTE) 		+ ":" + 
		calendar.get(Calendar.SECOND);
			
	  return fecha;
	}
	public static String getFechaHoraVencimiento() 
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 100);
	
		/* INICIO Obtener el dia martes*/
	
		int diaDeLaSemana= 0;
		diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Dia de la semana:"+diaDeLaSemana);
			
		switch (diaDeLaSemana){
			case 1:
				calendar.add(Calendar.DATE, -5);
				break;
			case 2:
				calendar.add(Calendar.DATE, -6);
				break;
			case 3: 
				calendar.add(Calendar.DATE, 100);
				break;
			case 4:
				calendar.add(Calendar.DATE, -1);
				break;
			case 5:
				calendar.add(Calendar.DATE, -2);
				break;
			case 6:
				calendar.add(Calendar.DATE, -3);
				break;
			case 7:
				calendar.add(Calendar.DATE, -4);
				break;
		}
		
		/* FIN obtener el dia martes*/
			
//		Date 			trialTime 	= new Date();
		String mes	= ""+(1 + calendar.get(Calendar.MONTH)) ;
		if(mes.length()==1)
		{
			mes = "0"+ mes;
		}
	    String fecha 	=	calendar.get(Calendar.YEAR) 		+ "-" +	  
		//(1 + calendar.get(Calendar.MONTH)) 	+ "-" +
		mes	+ "-" +
		calendar.get(Calendar.DAY_OF_MONTH) + " " +  
		(calendar.get(Calendar.HOUR_OF_DAY))  + ":" + 
		calendar.get(Calendar.MINUTE) 		+ ":" + 
		calendar.get(Calendar.SECOND);
		
	return fecha;
		
	}
	/**
	   * Aplica el formato yyyy-MM-dd hh:mm a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static String getFecha_YYYYMMDDHHMM(Date date) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    try
		    {
		    	if( date !=null)
		    	{
		    		return formatter.format(date);
		    	}else
		    	{
		    		return "";
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error("[F] - Error al formatear el objeto date",e);
				return "";
			}
	  }
	 /**
	   * Aplica el formato yyyy-MM-dd HH:mm:ss a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static String getFecha_YYYYMMDDHHMMSS(Date date) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    try
		    {
		    	if( date !=null)
		    	{
		    		return formatter.format(date);
		    	}else
		    	{
		    		return "";
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error("[F] - Error al formatear el objeto date",e);
				return "";
			}
	  }
	  /**
	   * Aplica el formato yyyy-MM-dd HH:mm:ss a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static String getFecha_YYYYMMDDHHMMSS(Timestamp timeStamp) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    try
		    {
		    	if( timeStamp !=null)
		    	{
		    		return formatter.format(timeStamp);
		    	}else
		    	{
		    		return "";
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error("[F] - Error al formatear el objeto date",e);
				return "";
			}
	  }
	  /**
	   * Aplica el formato yyyyMMdd_HHmm a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static String getFecha_YYYYMMDD_HHMM(Date date) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmm");
		    try
		    {
		    	if( date !=null)
		    	{
		    		return formatter.format(date);
		    	}else
		    	{
		    		return "";
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al formatear el objeto date",e);
				return "";
			}
	  }
	  
	  /**
	   * Aplica el formato yyyy-MM-dd HH:mm a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static Date getDate_YYYYMMDDHHMM(String fecha) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    try
		    {
		    	if( fecha !=null && !fecha.trim().equals(""))
		    	{
		    		return  formatter.parse(fecha);
		    	}else
		    	{
		    		return null;
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al formatear el objeto date",e);
				return null;
			}
	  }
	  
	  /**
	   * Aplica el formato yyyy-MM-dd HH:mm:ss a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static Date getDate_YYYYMMDDHHMMSS(String fecha) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    try
		    {
		    	if( fecha !=null && !fecha.trim().equals(""))
		    	{
		    		return  formatter.parse(fecha);
		    	}else
		    	{
		    		return null;
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al formatear el objeto date",e);
				return null;
			}
	  }
	  /**
	   * Aplica el formato yyyy-MM-dd a un objeto de tipo: Date
	   * y lo devuelve como cadena de texto 
	   * @param date fecha a la que se le aplica el formato
	   * @return fecha formateada
	   */
	  public static Date getDate_YYYYMMDD(String fecha) 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    try
		    {
		    	if( fecha !=null && !fecha.trim().equals(""))
		    	{
		    		return  formatter.parse(fecha);
		    	}else
		    	{
		    		return null;
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al formatear el objeto date",e);
				return null;
			}
	  }
	  
	  /**
	   * Regresa el año actual que se consulta desde la JVM
	   * y lo devuelve como cadena de texto 
	   * @return año actual en formato yyyy (2015,2016 etc)
	   */
	  public static String getAnioActual() 
	  {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		    try
		    {
		    	return  formatter.format(Calendar.getInstance().getTime());
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al obtener año actual",e);
				return "";
			}
	  }
	  
	  /**
	   * 
	   * @param fecha
	   * @return
	   */
	  public static long  getUnixTimeStamp(String fecha)
	  {
		  long regreso=0;
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    try
		    {
		    	if( fecha !=null && !fecha.trim().equals(""))
		    	{
		    		regreso = formatter.parse(fecha).getTime()/1000L;
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error(PREFIJO+" Error al obtener el timestamp",e);
			}
		  return regreso;
	  }
	  
	  /**
	   * <p>Método que cambia el formato de una cadena de texto que 
	   * contiene el valor de una fecha al formato que se indique.
	   * <br>
	   * Ejemplo: 12-10-2018 (dd-MM-yyyy) a 2018-10-12 (yyyy-MM-dd)
	   * </p> 
	   * @param fecha Cadena de texto que contiene la fecha a la que se le quiere cambiar el formato
	   * @param formatoFecha Formato tipo fecha que tiene la cadena de texto que representa una fecha 
	   * @param formatoNuevo Formato de fecha nuevo que se requiere aplicar 
	   * @return Cadena de texto con el formato nuevo.
	   */
	  public static String cambiarFormatoFecha(String fecha,String formatoFecha,String formatoNuevo)
	  {
		  SimpleDateFormat formatoOriginal = new SimpleDateFormat(formatoFecha);
		  SimpleDateFormat formatoNuevoFecha    = new SimpleDateFormat(formatoNuevo);
		    try
		    {
		    	if(!fecha.trim().equals(""))
		    	{
		    		return formatoNuevoFecha.format(formatoOriginal.parse(fecha));
		    	}else
		    	{
		    		return "";
		    	}
		    	
		    }catch (Exception e) {
				LOGGER.error("[F] - Error al formatear el objeto date",e);
				return "";
			}
	  }
	  
}
