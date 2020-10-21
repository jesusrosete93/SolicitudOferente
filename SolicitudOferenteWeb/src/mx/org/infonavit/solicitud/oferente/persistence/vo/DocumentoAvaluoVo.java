package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.sql.Blob;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class DocumentoAvaluoVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7595456867084703193L;
	private int idRegistro;
	private String idAvaluo;
	private int idDocumento;
	private Blob documento;
	private String tipoDocumento;
	private String fechaAlta;
	private String observaciones;
	
	
	public DocumentoAvaluoVo() {
		super();
	}
	
	
	
	public DocumentoAvaluoVo(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}



	public DocumentoAvaluoVo(int idRegistro, String idAvaluo, int idDocumento,
			Blob documento, String tipoDocumento, String fechaAlta,
			String observaciones) {
		super();
		this.idRegistro = idRegistro;
		this.idAvaluo = idAvaluo;
		this.idDocumento = idDocumento;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.fechaAlta = fechaAlta;
		this.observaciones = observaciones;
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
	 * @return the idDocumento
	 */
	public int getIdDocumento() {
		return idDocumento;
	}
	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}
	/**
	 * @return the documento
	 */
	public Blob getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Blob documento) {
		this.documento = documento;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
