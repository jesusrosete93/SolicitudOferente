/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * @author Adrian Casas
 *
 */
public class AvaluoCerradoVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7179704601168064992L;
	private String tituloCerrados;
	private int avaluosCerrados;
	private String fechaInicio;
	private String fechaFin;
	private int tipoMercado;
	private String estado;
	private int unidadValuacion;
	
	
	public AvaluoCerradoVo() {
		super();
	}
	
	public AvaluoCerradoVo(String fechaInicio, String fechaFin) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public AvaluoCerradoVo(String fechaInicio, String fechaFin,String estado) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}
	
	public AvaluoCerradoVo(String fechaInicio, String fechaFin,int unidad) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.unidadValuacion = unidad;
	}
	
	public AvaluoCerradoVo(String titluoCerrados, int avaluosCerrados,
			String fechaInicio, String fechaFin, int tipoMercado) {
		super();
		this.tituloCerrados = titluoCerrados;
		this.avaluosCerrados = avaluosCerrados;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoMercado = tipoMercado;
	}
	
	public AvaluoCerradoVo(String tituloCerrados, int avaluosCerrados,
			String fechaInicio, String fechaFin, int tipoMercado,
			String estado, int unidadValuacion) {
		super();
		this.tituloCerrados = tituloCerrados;
		this.avaluosCerrados = avaluosCerrados;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoMercado = tipoMercado;
		this.estado = estado;
		this.unidadValuacion = unidadValuacion;
	}

	/**
	 * @return El valor de: titluoCerrados
	 */
	public String getTituloCerrados() {
		return tituloCerrados;
	}
	/**
	 * @param Valor: titluoCerrados a asignar en: titluoCerrados
	 */
	public void setTituloCerrados(String tituloCerrados) {
		this.tituloCerrados = tituloCerrados;
	}
	/**
	 * @return El valor de: avaluosCerrados
	 */
	public int getAvaluosCerrados() {
		return avaluosCerrados;
	}
	/**
	 * @param Valor: avaluosCerrados a asignar en: avaluosCerrados
	 */
	public void setAvaluosCerrados(int avaluosCerrados) {
		this.avaluosCerrados = avaluosCerrados;
	}


	/**
	 * @return El valor de: fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}


	/**
	 * @param Valor: fechaInicio a asignar en: fechaInicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	/**
	 * @return El valor de: fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}


	/**
	 * @param Valor: fechaFin a asignar en: fechaFin
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	/**
	 * @return El valor de: tipoMercado
	 */
	public int getTipoMercado() {
		return tipoMercado;
	}


	/**
	 * @param Valor: tipoMercado a asignar en: tipoMercado
	 */
	public void setTipoMercado(int tipoMercado) {
		this.tipoMercado = tipoMercado;
	}

	/**
	 * @return El valor de: estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param Valor: estado a asignar en: estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return El valor de: unidadValuacion
	 */
	public int getUnidadValuacion() {
		return unidadValuacion;
	}

	/**
	 * @param Valor: unidadValuacion a asignar en: unidadValuacion
	 */
	public void setUnidadValuacion(int unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
	}

}
