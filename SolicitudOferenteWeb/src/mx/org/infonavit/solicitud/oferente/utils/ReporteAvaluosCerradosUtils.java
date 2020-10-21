package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.ReporteAvaluoCerradoDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ReporteAvaluosCerradosUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(ReporteAvaluosCerradosUtils.class);
	
	
	/**
	 * 
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return
	 */
	public static List<String>  generarRangoLimiteFechas(int tipoComparativa,String anioInicio,String anioFin,
											String mesAnio, String diaAnio,String diaMes,String fecha)
	{
		List<String> fechas = new ArrayList<String>();
		int limite = 0;

		if( tipoComparativa == 1)
		{
			limite = Integer.parseInt(anioFin)-Integer.parseInt(anioInicio);
			fechas.add(anioInicio+"-01-01");
			fechas.add(anioFin+"-12-31");
			fechas.add(String.valueOf(limite));
		}else if( tipoComparativa==2)
		{
			fechas.add(mesAnio+"-01-01");
			fechas.add(mesAnio+"-12-31");
			fechas.add("12");
		}else if( tipoComparativa==3 )
		{
			StringBuffer fechaInicio = new StringBuffer();
			StringBuffer fechaFin = new StringBuffer();
			fechaInicio.append(diaAnio);
			fechaFin.append(diaAnio);
			if(Integer.parseInt(diaMes) == 2)
			{
				
				fechaInicio.append("-02-01");
				GregorianCalendar gregorianCalendar = new GregorianCalendar();
				if( gregorianCalendar.isLeapYear(Integer.parseInt(diaAnio)))
				{
					fechaFin.append("-02-29");
					limite = 29;
				}else
				{
					fechaFin.append("-02-28");
					limite = 28;
				}
				
				fechas.add(fechaInicio.toString());
				fechas.add(fechaFin.toString());
				fechas.add(String.valueOf(limite));
				
			}else if( Integer.parseInt(diaMes) == 1 || Integer.parseInt(diaMes) == 3 || Integer.parseInt(diaMes) == 5
					  || Integer.parseInt(diaMes) == 7 || Integer.parseInt(diaMes) == 8 || Integer.parseInt(diaMes) == 10 || Integer.parseInt(diaMes) == 12)
			{
				limite = 31;
				if( Integer.parseInt(diaMes)>=1 && Integer.parseInt(diaMes)<=9 )
				{
					fechaInicio.append("-0"+diaMes+"-01");
					fechaFin.append("-0"+diaMes+"-31");
				}else if( Integer.parseInt(diaMes)>=10 && Integer.parseInt(diaMes)<=12 )
				{
					fechaInicio.append("-"+diaMes+"-01");
					fechaFin.append("-"+diaMes+"-31");
					
				}
			}else if( Integer.parseInt(diaMes) == 2 || Integer.parseInt(diaMes) == 4 || Integer.parseInt(diaMes) == 6
					  || Integer.parseInt(diaMes) == 9 || Integer.parseInt(diaMes) == 11 )
			{
				limite=30;
				if( Integer.parseInt(diaMes)>=1 && Integer.parseInt(diaMes)<=9 )
				{
					fechaInicio.append("-0"+diaMes+"-01");
					fechaFin.append("-0"+diaMes+"-30");
				}else if( Integer.parseInt(diaMes)>=10 && Integer.parseInt(diaMes)<=12 )
				{
					fechaInicio.append("-"+diaMes+"-01");
					fechaFin.append("-"+diaMes+"-30");
				}
			}
			fechas.add(fechaInicio.toString());
			fechas.add(fechaFin.toString());
			fechas.add(String.valueOf(limite));
		}else if( tipoComparativa==4)
		{
			fechas.add(fecha+" 00:00");
			fechas.add(fecha+" 23:59");
			fechas.add(2,"23");
		}
		LOGGER.info("[ACB] Fechas generadas "+ fechas.toString());
		return fechas;
		
	}
	
	/**
	 * 
	 * @param reporte
	 * @param tipoOrdenamiento
	 */
	public static void ordenarReporte(List<ReporteAvaluoCerradoDomain> reporte,int tipoOrdenamiento)
	{
	 switch( tipoOrdenamiento )
	 {
	 case 1:
		 	Collections.sort(reporte,new Comparator<ReporteAvaluoCerradoDomain>(){
		 		@Override
		 		public int compare(ReporteAvaluoCerradoDomain object1,ReporteAvaluoCerradoDomain object2) 
		 		{
		 			int regreso =  0;
		 			if( object1.getMes() < object2.getMes() )
		 			{
		 				regreso = -1;
		 			}else if( object1.getMes() > object2.getMes() )
		 			{
		 				regreso = 1;
		 			}else if( object1.getMes() == object2.getMes() )
		 			{
		 				regreso = 0;
		 			}
		 			return regreso;
		 		}
		 	});
	 break;
	 case 2:
		 	Collections.sort(reporte,new Comparator<ReporteAvaluoCerradoDomain>(){
		 		@Override
		 		public int compare(ReporteAvaluoCerradoDomain object1,ReporteAvaluoCerradoDomain object2) 
		 		{
		 			int regreso =  0;
		 			if( object1.getDia() < object2.getDia() )
		 			{
		 				regreso = -1;
		 			}else if( object1.getDia() > object2.getDia() )
		 			{
		 				regreso = 1;
		 			}else if( object1.getDia() == object2.getDia() )
		 			{
		 				regreso = 0;
		 			}
		 			return regreso;
		 		}
		 	});
	 break;
	 case 3:
		 	Collections.sort(reporte,new Comparator<ReporteAvaluoCerradoDomain>(){
		 		@Override
		 		public int compare(ReporteAvaluoCerradoDomain object1,ReporteAvaluoCerradoDomain object2) 
		 		{
		 			int regreso =  0;
		 			if( object1.getHora() < object2.getHora() )
		 			{
		 				regreso = -1;
		 			}else if( object1.getHora() > object2.getHora() )
		 			{
		 				regreso = 1;
		 			}else if( object1.getHora() == object2.getHora() )
		 			{
		 				regreso = 0;
		 			}
		 			return regreso;
		 		}
		 	});
	 break;

	 }
  }
	/**
	 * 
	 * @param estado
	 * @return
	 */
	public static String generarEstado(int estado)
	{
		String regreso = "";
		if( estado >=1 && estado <=9)
		{
			regreso = "0"+(estado);
		}
		if( estado >=10 && estado <=32)
		{
			regreso = String.valueOf(estado);
		}
		
		return regreso;
	}

}
