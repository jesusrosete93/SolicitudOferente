package mx.org.infonavit.solicitud.oferente.forms;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * Clase que encapsula el formulario utilizado en la consulta de Inex.
 * @author Adrian Casas
 */
public class ConsultaInexForm extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6249581141355715568L;
	private int numeroInex;
	private String fecha;
	private int idUnidadValuacion;
	private int idEstado;
	private List<String> camposInexGeneral;
	private String errores;
	
	public int getNumeroInex() {
		return numeroInex;
	}
	public void setNumeroInex(int numeroInex) {
		this.numeroInex = numeroInex;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public List<String> getCamposInexGeneral() {
		return camposInexGeneral;
	}
	public void setCamposInexGeneral(List<String> camposInexGeneral) {
		this.camposInexGeneral = camposInexGeneral;
	}
	public String getErrores() {
		return errores;
	}
	public void setErrores(String errores) {
		this.errores = errores;
	}

}
