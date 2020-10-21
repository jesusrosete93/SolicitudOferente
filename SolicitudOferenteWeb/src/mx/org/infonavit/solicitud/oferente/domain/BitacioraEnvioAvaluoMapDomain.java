package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class BitacioraEnvioAvaluoMapDomain extends GenericValueObject {
	
	private static final long serialVersionUID = -6213956844148820543L;
	private int idRegistro;
	private String fechaRegistro;
	private String idAvaluo;
	private int idOperacion;
	private String descripcionOperacion;
	private boolean resultadoOperacion;
	private String descripcionResultado;
	private String detalleResultado;
	private int idPeticion;
	
	
	/**
	 * @return the idRegistro
	 */
	public int getIdRegistro() {
		return idRegistro;
	}
	/**
	 * @param idRegistro the idRegistro to set
	 */
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	/**
	 * @return the fechaRegistro
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}
	/**
	 * @param idAvaluo the idAvaluo to set
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	/**
	 * @return the idOperacion
	 */
	public int getIdOperacion() {
		return idOperacion;
	}
	/**
	 * @param idOperacion the idOperacion to set
	 */
	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}
	/**
	 * @return the descripcionOperacion
	 */
	public String getDescripcionOperacion() {
		return descripcionOperacion;
	}
	/**
	 * @param descripcionOperacion the descripcionOperacion to set
	 */
	public void setDescripcionOperacion(String descripcionOperacion) {
		this.descripcionOperacion = descripcionOperacion;
	}
	/**
	 * @return the resultadoOperacion
	 */
	public boolean isResultadoOperacion() {
		return resultadoOperacion;
	}
	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(boolean resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	/**
	 * @return the descripcionResultado
	 */
	public String getDescripcionResultado() {
		return descripcionResultado;
	}
	/**
	 * @param descripcionResultado the descripcionResultado to set
	 */
	public void setDescripcionResultado(String descripcionResultado) {
		this.descripcionResultado = descripcionResultado;
	}
	/**
	 * @return the detalleResultado
	 */
	public String getDetalleResultado() {
		return detalleResultado;
	}
	/**
	 * @param detalleResultado the detalleResultado to set
	 */
	public void setDetalleResultado(String detalleResultado) {
		this.detalleResultado = detalleResultado;
	}
	/**
	 * @return the idPeticion
	 */
	public int getIdPeticion() {
		return idPeticion;
	}
	/**
	 * @param idPeticion the idPeticion to set
	 */
	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}
	
	
}
