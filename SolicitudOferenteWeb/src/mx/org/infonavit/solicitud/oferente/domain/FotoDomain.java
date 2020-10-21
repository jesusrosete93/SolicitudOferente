package mx.org.infonavit.solicitud.oferente.domain;

import org.simpleframework.xml.Element;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;



public class FotoDomain extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2377178967745123687L;
	private int idRegistro;
	@Element(name="FOLIO_AVALUO")
	private String idAvaluo;
	private int idImagen;
	private byte[] archivo;
	private String tipoArchivo;
	private String pieFoto;
	private String fechaAlta;
	private String observaciones;
	
	@Element(name="ESTATUS_AVALUO")
	private String estatusAvaluo;
	@Element(name="FECHA_ENTREGA")
	private String fechaEntrega;
	@Element(name="FOTOGRAFIA_FACHADA")
	private String fotografiaFachada;
	@Element(name="FOTOGRAFIA_ENTORNO")
	private String fotografiaEntorno;
	@Element(name="DOCUMENTO_PDF")
	private String documentoPdf;
	
	
	public FotoDomain() {
		super();
	}
	
	public FotoDomain(int idRegistro, String idAvaluo, int idImagen,
			byte[] archivo, String tipoArchivo, String pieFoto,
			String fechaAlta, String observaciones) {
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
	
	
	
	
	/**
	 * Constructor utilizado para generar un objeto de tipo {@link FotoDomain}
	 * para el proceso de envío de avalúo para Nexura
	 * @param idAvaluo
	 * @param estatusAvaluo
	 * @param fechaEntrega
	 * @param fotografiaFachada
	 * @param fotografiaEntorno
	 * @param documentoPdf
	 */
	public FotoDomain(String idAvaluo, String estatusAvaluo,
			String fechaEntrega, String fotografiaFachada,
			String fotografiaEntorno, String documentoPdf) {
		super();
		this.idAvaluo = idAvaluo;
		this.estatusAvaluo = estatusAvaluo;
		this.fechaEntrega = fechaEntrega;
		this.fotografiaFachada = fotografiaFachada;
		this.fotografiaEntorno = fotografiaEntorno;
		this.documentoPdf = documentoPdf;
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
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
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

	/**
	 * @return the estatusAvaluo
	 */
	public String getEstatusAvaluo() {
		return estatusAvaluo;
	}

	/**
	 * @param estatusAvaluo the estatusAvaluo to set
	 */
	public void setEstatusAvaluo(String estatusAvaluo) {
		this.estatusAvaluo = estatusAvaluo;
	}

	/**
	 * @return the fechaEntrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the fotografiaFachada
	 */
	public String getFotografiaFachada() {
		return fotografiaFachada;
	}

	/**
	 * @param fotografiaFachada the fotografiaFachada to set
	 */
	public void setFotografiaFachada(String fotografiaFachada) {
		this.fotografiaFachada = fotografiaFachada;
	}

	/**
	 * @return the fotografiaEntorno
	 */
	public String getFotografiaEntorno() {
		return fotografiaEntorno;
	}

	/**
	 * @param fotografiaEntorno the fotografiaEntorno to set
	 */
	public void setFotografiaEntorno(String fotografiaEntorno) {
		this.fotografiaEntorno = fotografiaEntorno;
	}

	/**
	 * @return the documentoPdf
	 */
	public String getDocumentoPdf() {
		return documentoPdf;
	}

	/**
	 * @param documentoPdf the documentoPdf to set
	 */
	public void setDocumentoPdf(String documentoPdf) {
		this.documentoPdf = documentoPdf;
	}

}
