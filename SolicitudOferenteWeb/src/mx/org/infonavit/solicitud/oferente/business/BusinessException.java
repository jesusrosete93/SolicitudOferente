package mx.org.infonavit.solicitud.oferente.business;

public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4382918837714988294L;
	private String descripcion;
	private Throwable error;
	
	public BusinessException() {
		super();
	}

	public BusinessException(String descripcion, Throwable error) {
		super(descripcion,error);
		this.descripcion = descripcion;
		this.error = error;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

	


	
}
