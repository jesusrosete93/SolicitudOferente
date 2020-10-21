package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class PuntoEntregaVO extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5444732359182522887L;
	private int idRegistro;
	private int idAplicacion;
	private int idOperacion;
	private int idServicio;
	private String puntoEntrega;
	
	
	public PuntoEntregaVO() {
		super();
	}
	
	
	public PuntoEntregaVO(int idRegistro, int idAplicacion,
			int idOperacion, int idServicio, String puntoEntrega) {
		super();
		this.idRegistro = idRegistro;
		this.idAplicacion = idAplicacion;
		this.idOperacion = idOperacion;
		this.idServicio = idServicio;
		this.puntoEntrega = puntoEntrega;
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
	 * @return the idAplicacion
	 */
	public int getIdAplicacion() {
		return idAplicacion;
	}
	/**
	 * @param idAplicacion the idAplicacion to set
	 */
	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
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
	 * @return the idServicio
	 */
	public int getIdServicio() {
		return idServicio;
	}
	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	/**
	 * @return the puntoEntrega
	 */
	public String getPuntoEntrega() {
		return puntoEntrega;
	}
	/**
	 * @param puntoEntrega the puntoEntrega to set
	 */
	public void setPuntoEntrega(String puntoEntrega) {
		this.puntoEntrega = puntoEntrega;
	}

}
