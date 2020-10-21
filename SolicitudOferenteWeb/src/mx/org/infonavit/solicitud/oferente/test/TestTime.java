package mx.org.infonavit.solicitud.oferente.test;

import java.util.Calendar;
import java.util.Date;

import mx.org.infonavit.solicitud.oferente.utils.Fechas;

public class TestTime {
	
	public static void main(String args[])
	{
		Fechas fecha =new Fechas();
		
		System.out.println("La fecha actual es:"+ fecha.getFechaHora() );
	}

	public static String getFechaHora()
	{
	 Calendar calendar = Calendar.getInstance();
	 Date trialTime = new Date();
	 calendar.setTime(trialTime);
	 String mes = ""+(1 + calendar.get(Calendar.MONTH)) ;
	 if(mes.length()==1){
	mes = "0"+ mes;
	 }
	 
	 
	 String fecha = calendar.get(Calendar.YEAR) + "-" +  
	mes + "-" +
	calendar.get(Calendar.DAY_OF_MONTH) + " " +  
	(calendar.get(Calendar.HOUR_OF_DAY))  + ":" +
	calendar.get(Calendar.MINUTE) + ":" +
	calendar.get(Calendar.SECOND);
	 
	 return fecha;
	}
	
}
