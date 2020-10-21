/*
 * Creado el 11/04/2005
 * AVANSIS
 */
package mx.org.infonavit.solicitud.oferente.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Luis Antonio Ramírez Álvarez
 *	
 * Clase para hacer operaciones con cadenas.
 */
public final class Cadenas 
{
	private static final Logger		log;
	private static final int 		UNO;
	private static final int 		ZERO;
	public final static char 		IZQUIERDA;
	public final static char 		DERECHA;
	public static final String 	ERROR = " Error en el proceso ";
	public static final String 	WHERE = " WHERE ";
	public static final String 	VALUES = " VALUES ( ";
	public static final String 	AND = " AND ";
	public static final String 	IN = " IN ";
	public static final String 	COMILLA = "'";
	public static final String 	COMILLAS = "' ";
	public static final String 	IGUAL = "=";
	public static final String 	COMA = ",";
	public static final String 	VACIO = "";
	public static final String 	ENTRE = "between";
	public static final String 	PARANETESIS_ABRE = "(";
	public static final String 	PARANETESIS_CIERRA = ")";
	public static final String 	MAYOR_IGUAL = ">=";
	public static final String 	MAYOR_QUE = ">";
	public static final String 	MENOR_IGUAL = "<=";
	public static final String 	MENOR_QUE = "<";
	public static final String 	OR = " OR ";
	public static final String 	PUNTO = ".";
	public static final String 	INICIO_OK = "Inicio OK";
	public static final String 	FIN_OK = "Fin OK";
	public static final String 	FIN_NOK = "";
	public static final String 	PORCENTAJE = "%";
	private final static HashSet<String> 	CARACTERES_VALIDOS;	
	private final static String 	CADENA_VACIA;
	private final static String 	REGRESO;
	private static final String 	SIN_DATO;
	private static final String 	SIN_FECHA;
	private static final String 	FECHA_INVALIDA;
	public static final String PARENTESIS_ABRE   = "(";
	public static final String PARENTESIS_CIERRA   = ")";
	public static final String ESPACIO   = " ";
	public static final String NOT_LIKE   = " NOT LIKE ";
	
	
	
		static	
			{
				log	= LogManager.getLogger( Cadenas.class );
				HashSet<String>	aux;
					aux = new HashSet<String>( );
					aux.add( "-" );
					aux.add( "_" );
					CARACTERES_VALIDOS	= aux;
					ZERO				= 0;
					UNO					= 1;
					CADENA_VACIA		= "";
					IZQUIERDA			= 'I';
					DERECHA				= 'D';
					REGRESO				= "Valor Devuelto ";
					SIN_DATO			= "Sin datos";
					SIN_FECHA			= "Sin fecha";
					FECHA_INVALIDA		= "01/01/1900";
			}


	/**
	 * metodo para validar que una cadena contenga solo letras o numeros o '_' o '-'o  
	 * @param cadena cadena que se va a validar
	 * @return true si la cadena es valida, false en caso contrario
	 */
	public static final boolean valida( String cadena )
		{
			char [] arreglo;
			boolean	regreso;
			int 	indice;
				regreso 	= true;
				arreglo 	= cadena.toCharArray( );					
				for( indice = ZERO ; indice <= arreglo.length - UNO ; indice++ )
					{
						if( !Character.isLetterOrDigit( arreglo[ indice ] ) )
							if ( !CARACTERES_VALIDOS.contains( String.valueOf( arreglo[ indice ] ) ) )	
								{
									regreso = false;
									break;
								}
					}
				log.debug( REGRESO + regreso );
			return regreso;	
		}

	/**
	* metodo para validar que una cadena contenga solo letras o numeros o '_' o '-'o  
	* @param cadena cadena que se va a validar
	* @return true si la cadena es valida, false en caso contrario
	*/
   	public static final String validar( String cadena, String valorDefault )
	{
		try
		{
			if (cadena != null){
				cadena = cadena.trim();
			}
			else{
				cadena = valorDefault;
			}
		}
		catch (Exception e){
			cadena = valorDefault; // Error toma valor por default
		}
		
			return cadena.trim();
		
	 }
	/**
	 * Reemplaza una cadena dentro de otra
	 * @param fuente - cadena donde se encuentra la cadena a buscar.
	 * @param anterior - cadena buscada.
	 * @param nueva - cadena que sera puesta en la cadena fuente.
	 * @return si existe la cadena se reemplaza y se devuelve, si no existe se devuenve la misma cadena.
	 */
	public static final String reemplazar( String fuente, String anterior, String nueva )
		{
			String			regreso;
			StringBuffer 	aux;
			int				i;
				aux		= new StringBuffer( );
				regreso	= fuente;
				i 		= fuente.indexOf( anterior );
				aux.append( fuente );
				if ( i > ZERO )
					regreso = aux.substring( ZERO , i ) + nueva + aux.substring( ( i + anterior.length( ) ) ); 
				if( fuente.trim( ).equals( anterior.trim( ) ) )
					regreso = nueva;
			return regreso;
		}
	/**
	 * Obtiene una cadena de longitud predeterminada rellena con caracteres
	 * @param cad Cadena a rellenar
	 * @param lon Longitud a rellenar
	 * @param rel Caracter de relleno
	 * @param tip Tipo de relleno {I=Izq,D=Der}
	 * @return cadena rellenada
	 */
	public static String rellenar( String cad, int lon, char rel, char tip )
		{
			String 	aux;
			int 	indice;
				aux = CADENA_VACIA;
				if( tip != IZQUIERDA && tip != DERECHA ) 
					tip = IZQUIERDA;
				if( cad.length( ) > lon ) 
					aux = cad.substring( ZERO, lon );
				else
					{
						if( tip == DERECHA ) aux = cad;
						for ( indice = ZERO; indice < ( lon - cad.length( ) ) ; indice++ )
						   aux = aux + rel;
						if( tip == IZQUIERDA ) aux = aux + cad;
					}
			return aux;
		}
	/**
	 * Valida que una cadena tenga datos validos.
	 * <b>El dato no debe ser:
	 * <ul>
	 * 	<li>Nulo.</li>
	 * 	<li>Espacios.</li>
	 * 	<li>Cadena vacia.</li>
	 * </ul>
	 * <br>Fecha: May 21, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param dato dato a validar.
	 * @return dato cuando es una cadena valida, 'Sin datos' en caso contrario.
	 */
	public static final String getDato( String dato )
		{
			String regreso;
				log.debug( dato );
				regreso = SIN_DATO;
				if( dato != null )
					{
						if( !dato.trim( ).equals( CADENA_VACIA ) )
							regreso = dato.trim( );
					}
				log.debug( REGRESO + regreso );
			return regreso;
		}
	/**
	 * Valida que una cadena tenga una fecha valida.
	 * <b>El dato no debe ser:
	 * <ul>
	 * 	<li>Nulo.</li>
	 * 	<li>Espacios.</li>
	 * 	<li>Cadena vacia.</li>
	 * 	<li>Comenzar con '1900-01-01'.</li>
	 * </ul>
	 * <br>Fecha: May 21, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param dato dato a validar.
	 * @return dato cuando es una cadena valida, 'Sin datos' en caso contrario.
	 */
	public static final String getFecha( String dato )
		{
			String regreso;
				log.debug( dato );
				regreso = getDato( dato );
				if( !dato.endsWith( SIN_DATO ) && !dato.startsWith( FECHA_INVALIDA ) )
					regreso = dato.trim( );
				else 
					regreso = SIN_FECHA;
				log.debug( REGRESO + regreso );
			return regreso;
		}
	/**
	 * Valida una cadena.
	 * <br>Fecha: Jun 27, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param valor Valor de la cadena.
	 * @return Cadena contenida en el valor; una cadena vacia en caso de aque no se a una cadea o sea nulo.
	 */
	public static final String validar( Object valor )
		{
			String regreso;
				regreso = CADENA_VACIA;
				try
					{
						regreso = ( ( String ) valor ).trim();
					}
				catch ( ClassCastException ignored ){}
				catch ( NullPointerException ignored ){}
			return regreso.trim( );
		}
	/**
	 * Valida que una cadena tenga una longitud maxima.
	 * Si la cadena es null o menor a la longitud buscada, se regresa la misma cadena.
	 * Si la cadena tiene longitud mayor a la longitud deseada, 
	 * se devuelve una cadena con la longitud deseada de los primeros caractes 
	 * de la cadena de derecha a izquierda.
	 * <br>Fecha: Jun 28, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param cadena  Cadena a validar.
	 * @param longitud Longitud maxima de la cadena.
	 * @return Cadena valida.
	 */
	public static final String validarMaximo( String cadena, int longitud )
		{
			String regreso;
				regreso = cadena;
				try
					{
						if( cadena.length( ) > longitud )
							regreso = cadena.substring( ZERO, ( longitud - 1 ) );
					}
				catch ( NullPointerException ignored ){}
			return regreso;
		}
	
	/**
	 * Aplica a una cadena de texto normalmente con valor numerico 
	 * el formato monedo utilizado en México: "." para decimales y: ","  para separar miles.
	 * @param cadena valor númerico al que se le aplica el formato
	 * @return cadena de texto con el valor númerico formateado
	 */
	public static String formatoMoneda(String cadena){
		if( cadena!=null && !cadena.trim().equals(""))
		{
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("es","MX"));
			return numberFormat.format(new BigDecimal(cadena));
		}else
		{
			return "";
		}
		
	}
	
	/**
	 * Aplica a un objeto de tipo BigDecimal el formato monedo utilizado en México.
	 * "." para decimales y: ","  para separar miles.
	 * @param objeto tipo: BigDeicimal que tiene el valor al que se le aplica el formato
	 * @return cadena de texto con el valor númerico formateado
	 */
	public static String formatoMoneda(BigDecimal valor){
		if( valor!=null )
		{
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("es","MX"));
			return numberFormat.format(valor);
		}else
		{
			return "";
		}
	}
	
	/**
	 * Obtiene una secuencia de valores separadas por comas.
	 * <br>El indicador de cadena establece si los valores se toman como cadenas. 
	 * <ul>
	 * 	<li>true: cadenas. Rodeados por comillas ('valor_01', 'valor_02', ...).</li>
	 * 	<li>false: enteros. NO rodeados por comillas ( 1, 2, ...).</li>
	 * </ul>
	 * <br>Fecha: Jun 30, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param elementos Valores con los que se forma la secuencia.
	 * @param cadena Indicador de cadenas.
	 * @return
	 */
	public static final String getSecuencia( List<String> elementos, boolean cadena )
		{
			StringBuffer	regreso = new StringBuffer();
			if( elementos!=null && !elementos.isEmpty() )
			{
				for( String elemento : elementos  )
				{
					if( regreso.length()>0 )
						regreso.append(COMA);
					if( cadena )
					{
						regreso.append(COMILLA).append(elemento).append(COMILLA);
					}else
					{
						regreso.append(elemento);
					}
				}
			}
			return regreso.toString( );
		}
}
