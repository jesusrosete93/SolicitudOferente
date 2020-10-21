package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class PeticionVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8161407691541563936L;
	private int idPeticion;
	private int idAplicacion;
	private int idOperacion;
	private boolean resultadoPeticion;
	private String fechaPeticion;
	private String xmlRequest;
	private String xmlResponse;
	private String tiempoAtencion;
	
	
	
	
	
	public PeticionVo() {
		super();
	}
	
	public PeticionVo(int idAplicacion, boolean resultadoPeticion,
					  String xmlRequest, String xmlResponse,
					  String tiempoAtencion) {
		super();
		this.idAplicacion = idAplicacion;
		this.resultadoPeticion = resultadoPeticion;
		this.xmlRequest = xmlRequest;
		this.xmlResponse = xmlResponse;
		this.tiempoAtencion = tiempoAtencion;
	}




	public PeticionVo(int idPeticion, int idAplicacion, int idOperacion, String fechaPeticion,
			String xmlRequest, String xmlResponse, String tiempoAtencion) {
		super();
		this.idPeticion = idPeticion;
		this.idAplicacion = idAplicacion;
		this.idOperacion = idOperacion;
		this.fechaPeticion = fechaPeticion;
		this.xmlRequest = xmlRequest;
		this.xmlResponse = xmlResponse;
		this.tiempoAtencion = tiempoAtencion;
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
	/**
	 * @return the resultadoPeticion
	 */
	public boolean isResultadoPeticion() {
		return resultadoPeticion;
	}

	/**
	 * @param resultadoPeticion the resultadoPeticion to set
	 */
	public void setResultadoPeticion(boolean resultadoPeticion) {
		this.resultadoPeticion = resultadoPeticion;
	}

	/**
	 * @return the fechaPeticion
	 */
	public String getFechaPeticion() {
		return fechaPeticion;
	}
	/**
	 * @param fechaPeticion the fechaPeticion to set
	 */
	public void setFechaPeticion(String fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}
	/**
	 * @return the xmlRequest
	 */
	public String getXmlRequest() {
		return xmlRequest;
	}
	/**
	 * @param xmlRequest the xmlRequest to set
	 */
	public void setXmlRequest(String xmlRequest) {
		this.xmlRequest = xmlRequest;
	}
	/**
	 * @return the xmlResponse
	 */
	public String getXmlResponse() {
		return xmlResponse;
	}
	/**
	 * @param xmlResponse the xmlResponse to set
	 */
	public void setXmlResponse(String xmlResponse) {
		this.xmlResponse = xmlResponse;
	}
	/**
	 * @return the tiempoAtencion
	 */
	public String getTiempoAtencion() {
		return tiempoAtencion;
	}
	/**
	 * @param tiempoAtencion the tiempoAtencion to set
	 */
	public void setTiempoAtencion(String tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
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
	
	

}
