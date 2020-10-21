package mx.org.infonavit.solicitud.oferente.forms;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CambioLoginForm extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2865636301484975963L;
	private String idUsuario;
	private String contraseniaActual;
	private String contraseniaNueva;
	private String contraseniaConfirma;
	private String errores;
	
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}
	public String getContraseniaActual() {
		return contraseniaActual;
	}
	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}
	public String getContraseniaNueva() {
		return contraseniaNueva;
	}
	public void setContraseniaNueva(String contraseniaNueva) {
		this.contraseniaNueva = contraseniaNueva;
	}
	public String getContraseniaConfirma() {
		return contraseniaConfirma;
	}
	public void setContraseniaConfirma(String contraseniaConfirma) {
		this.contraseniaConfirma = contraseniaConfirma;
	}

}
