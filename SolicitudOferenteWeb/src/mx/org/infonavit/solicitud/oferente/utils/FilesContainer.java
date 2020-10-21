package mx.org.infonavit.solicitud.oferente.utils;

import org.springframework.web.multipart.MultipartFile;

public class FilesContainer extends GenericValueObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -405342188215603371L;
	private MultipartFile file;
	private String nombre;
	private String fechaReferencia;
	private String referencia;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFechaReferencia() {
		return fechaReferencia;
	}
	public void setFechaReferencia(String fechaReferencia) {
		this.fechaReferencia = fechaReferencia;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
