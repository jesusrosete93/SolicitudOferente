package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.sql.Blob;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class FotoAvaluoVo extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3159345155027997907L;
	private int idRegistro;
	private String idAvaluo;
	private int idImagen;
	private Blob archivo;
	private String tipoArchivo;
	private String pieFoto;
	private String fechaAlta;
	private String observaciones;
	
	public FotoAvaluoVo() {
		super();
	}
	
	
	
	public FotoAvaluoVo(String idAvaluo, int idImagen) {
		super();
		this.idAvaluo = idAvaluo;
		this.idImagen = idImagen;
	}



	public FotoAvaluoVo(int idRegistro, String idAvaluo, int idImagen,
			Blob archivo, String tipoArchivo, String pieFoto, String fechaAlta,
			String observaciones) {
		super();
		this.idRegistro = idRegistro;
		this.idAvaluo = idAvaluo;
		this.idImagen = idImagen;
		this.archivo = archivo;
		this.tipoArchivo = tipoArchivo;
		this.pieFoto = pieFoto;
		this.fechaAlta = fechaAlta;
		this.observaciones = observaciones;
	}
	public int getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getIdAvaluo() {
		return idAvaluo;
	}
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	public int getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}
	public Blob getArchivo() {
		return archivo;
	}
	public void setArchivo(Blob archivo) {
		this.archivo = archivo;
	}
	public String getTipoArchivo() {
		return tipoArchivo;
	}
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}
	public String getPieFoto() {
		return pieFoto;
	}
	public void setPieFoto(String pieFoto) {
		this.pieFoto = pieFoto;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
