/*
 * Creado el 04-16-2009
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * <p>
 * 	Clase que encapsula la información de un registro de la tabla paquete de la base de datos de avaluos.
 * </p>
 * @author adrian.casas
 *
 */
public class PaqueteAvaluoVo extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7668216512784637212L;
	private String idPaquete;
	private String tipoPaquete;
	
	public PaqueteAvaluoVo() {
		super();
	}
	
	public PaqueteAvaluoVo(String idPaquete) {
		super();
		this.idPaquete = idPaquete;
	}
	public String getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	public String getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
		
	

}
