package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;


public class RegistrosVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8640919670986876222L;
	private int registros;
	private String sentencia;
	
	
	
	public RegistrosVo() {
		super();
	}
	
	
	
	
	public RegistrosVo(String sentencia) {
		super();
		this.sentencia = sentencia;
	}




	public RegistrosVo(int registros) {
		super();
		this.registros = registros;
	}
	/**
	 * @return El valor de: registros
	 */
	public int getRegistros() {
		return registros;
	}
	/**
	 * @param Valor: registros a asignar en: registros
	 */
	public void setRegistros(int registros) {
		this.registros = registros;
	}
	/**
	 * @return El valor de: sentencia
	 */
	public String getSentencia() {
		return sentencia;
	}
	/**
	 * @param Valor: sentencia a asignar en: sentencia
	 */
	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}

}
