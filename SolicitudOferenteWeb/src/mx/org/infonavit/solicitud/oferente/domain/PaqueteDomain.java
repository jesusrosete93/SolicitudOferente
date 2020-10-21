/*
 * Created on Jun 23, 2007
 * Avansis - Luis Ramirez
 */
package mx.org.infonavit.solicitud.oferente.domain;

import java.lang.reflect.Field;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;





/**
 * Encapsula algunos datos de un paquete.
 * <ul>
 * 	<li>Identificador.</li>
 * 	<li>Frente.</li>
 * 	<li>Referencia.</li>
 * 	<li>Estado.</li>
 * </ul>
 * <br>Fecha: Jun 23, 2007
 * @author Avansis - Luis Antonio Ramirez.
 */
public final class PaqueteDomain extends GenericValueObject
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4380766696163634793L;
	private String identificador;
	private String referencia;
	private String frente;
	private String estado;
	private String rfcOferente;
	private String idOferente;
	private String tipoPaquete;
	
	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @return
	 */
	public String getFrente()
	{
		return frente;
	}

	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @return
	 */
	public String getIdentificador()
	{
		return identificador;
	}

	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @return
	 */
	public String getReferencia()
	{
		return referencia;
	}

	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param string
	 */
	public void setFrente(String string)
	{
		frente = string;
	}

	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param string
	 */
	public void setIdentificador(String string)
	{
		identificador = string;
	}

	/**
	 * 
	 * <br>Fecha: Jun 23, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param string
	 */
	public void setReferencia(String string)
	{
		referencia = string;
	}
	/**
	 * Obtiene el valor de un atributo del objeto.
	 * @param campo atributo del objeto.
	 * @return valor del atributo.
	 */
	public Object getValor( Field campo )
		{
			Object regreso;
				regreso = null;
				try 
					{
						regreso =  campo.get( this );
					} 
				catch ( IllegalArgumentException ignored ){} 
				catch ( IllegalAccessException ignored ){}
				catch ( ClassCastException ignored ){}
				catch ( NullPointerException ignored ){}
			return regreso;
		}	
	/**
	 * 
	 * <br>Fecha: Jun 27, 2007
	 * @author Avansis - Luis Ramirez.
	 * @return
	 */
	public String getEstado()
	{
		return estado;
	}

	/**
	 * 
	 * <br>Fecha: Jun 27, 2007
	 * @author Avansis - Luis Ramirez.
	 * @param string
	 */
	public void setEstado(String string)
	{
		estado = string;
	}

	public String getRfcOferente() {
		return rfcOferente;
	}

	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}

	public String getIdOferente() {
		return idOferente;
	}

	public void setIdOferente(String idOferente) {
		this.idOferente = idOferente;
	}

	public String getTipoPaquete() {
		return tipoPaquete;
	}

	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}

}
