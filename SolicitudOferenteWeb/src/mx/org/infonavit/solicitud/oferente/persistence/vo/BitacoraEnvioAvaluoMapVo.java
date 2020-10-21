package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.sql.Timestamp;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class BitacoraEnvioAvaluoMapVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6213956844148820543L;
	private int idRegistro;
	private Timestamp fechaRegistro;
	private String idAvaluo;
	private int idOperacion;
	private boolean resultadoOperacion;
	private String detalleResultado;
	
	private String fechaRegistroInicio;
	private String fechaRegistroFin;
	private int resultado;
	private int idPeticion;
	
		
	
	public BitacoraEnvioAvaluoMapVo() {
		super();
	}
	public BitacoraEnvioAvaluoMapVo(int idRegistro, Timestamp fechaRegistro,
			String idAvaluo, int idOperacion, boolean resultadoOperacion,
			String detalleResultado,int idPeticion) {
		super();
		this.idRegistro = idRegistro;
		this.fechaRegistro = fechaRegistro;
		this.idAvaluo = idAvaluo;
		this.idOperacion = idOperacion;
		this.resultadoOperacion = resultadoOperacion;
		this.detalleResultado = detalleResultado;
		this.idPeticion = idPeticion;
	}
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
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
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
	 * @return the fechaRegistroInicio
	 */
	public String getFechaRegistroInicio() {
		return fechaRegistroInicio;
	}
	/**
	 * @param fechaRegistroInicio the fechaRegistroInicio to set
	 */
	public void setFechaRegistroInicio(String fechaRegistroInicio) {
		this.fechaRegistroInicio = fechaRegistroInicio;
	}
	/**
	 * @return the fechaRegistroFin
	 */
	public String getFechaRegistroFin() {
		return fechaRegistroFin;
	}
	/**
	 * @param fechaRegistroFin the fechaRegistroFin to set
	 */
	public void setFechaRegistroFin(String fechaRegistroFin) {
		this.fechaRegistroFin = fechaRegistroFin;
	}
	/**
	 * @return the resultado
	 */
	public int getResultado() {
		return resultado;
	}
	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(int resultado) {
		this.resultado = resultado;
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
