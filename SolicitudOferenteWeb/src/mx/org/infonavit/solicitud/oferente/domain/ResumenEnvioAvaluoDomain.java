package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ResumenEnvioAvaluoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3961256958233936704L;
	private int totalAvaluos;
	private int enviadosConFoto;
	private int enviadosSinFoto;
	private String fechaInicio;
	private String fechaFin;
	
	
	/**
	 * @return the totalAvaluos
	 */
	public int getTotalAvaluos() {
		return totalAvaluos;
	}
	/**
	 * @param totalAvaluos the totalAvaluos to set
	 */
	public void setTotalAvaluos(int totalAvaluos) {
		this.totalAvaluos = totalAvaluos;
	}
	/**
	 * @return the enviadosConFoto
	 */
	public int getEnviadosConFoto() {
		return enviadosConFoto;
	}
	/**
	 * @param enviadosConFoto the enviadosConFoto to set
	 */
	public void setEnviadosConFoto(int enviadosConFoto) {
		this.enviadosConFoto = enviadosConFoto;
	}
	/**
	 * @return the enviadosSinFoto
	 */
	public int getEnviadosSinFoto() {
		return enviadosSinFoto;
	}
	/**
	 * @param enviadosSinFoto the enviadosSinFoto to set
	 */
	public void setEnviadosSinFoto(int enviadosSinFoto) {
		this.enviadosSinFoto = enviadosSinFoto;
	}
	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

}
