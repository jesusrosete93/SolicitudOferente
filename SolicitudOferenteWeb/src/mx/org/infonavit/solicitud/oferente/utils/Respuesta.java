package mx.org.infonavit.solicitud.oferente.utils;

import java.util.List;

public class Respuesta<T> extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8420152921610234990L;
	private String codigo;
	private String mensaje;
	private List<T> elementos;
	private T  objeto;
	
	
	
	public Respuesta() {
		super();
	}
	
	
	
	public Respuesta(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}



	public Respuesta(String codigo, String mensaje, List<T> elementos) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.elementos = elementos;
	}
	
	
	public Respuesta(String codigo, String mensaje, List<T> elementos, T objeto) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.elementos = elementos;
		this.objeto = objeto;
	}
	
	
	/**
	 * @return el valor de: codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param asigna el valor: codigo al atributo: codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return el valor de: mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param asigna el valor: mensaje al atributo: mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return el valor de: elementos
	 */
	public List<T> getElementos() {
		return elementos;
	}
	/**
	 * @param asigna el valor: elementos al atributo: elementos
	 */
	public void setElementos(List<T> elementos) {
		this.elementos = elementos;
	}
	/**
	 * @return el valor de: objeto
	 */
	public T getObjeto() {
		return objeto;
	}
	/**
	 * @param asigna el valor: objeto al atributo: objeto
	 */
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

}
