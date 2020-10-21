package mx.org.infonavit.solicitud.oferente.utils;

import java.util.List;
import java.util.Map;

public class RespuestaJson<T> {
	
	private T objeto;
	private List<T> listado; 
	private String codigoRespuesta;
	private String descripcionRespuesta;
	private boolean errores;
	private Map<String,String> mensajesError;
	private String mensajeError;
	
	public RespuestaJson() {
		super();
	}

	public RespuestaJson(T objeto, List<T> listado, String codigoRespuesta,
			String descripcionRespuesta, boolean errores,
			Map<String, String> mensajesError, String mensajeError) {
		super();
		this.objeto = objeto;
		this.listado = listado;
		this.codigoRespuesta = codigoRespuesta;
		this.descripcionRespuesta = descripcionRespuesta;
		this.errores = errores;
		this.mensajesError = mensajesError;
		this.mensajeError = mensajeError;
	}

	public T getObjeto() {
		return objeto;
	}

	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}

	public List<T> getListado() {
		return listado;
	}

	public void setListado(List<T> listado) {
		this.listado = listado;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public boolean isErrores() {
		return errores;
	}

	public void setErrores(boolean errores) {
		this.errores = errores;
	}

	public Map<String, String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(Map<String, String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
		
	
}
