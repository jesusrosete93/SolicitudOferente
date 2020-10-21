package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CampoBdVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1471986430312510822L;
	private int idTabla;
	private int ordenTabla;
	private String nombreTabla;
	private String aliasTabla;
	private String nombreColumna;
	private String etiquetaColumna;
	private int ordenCampo;
	
	
	public CampoBdVo() {
		super();
	}
	
	public CampoBdVo(int idTabla) {
		super();
		this.idTabla = idTabla;
	}


	public CampoBdVo(int idTabla, int ordenTabla, String nombreTabla,
			String aliasTabla, String nombreColumna,String etiquetaColumna, int ordenCampo) {
		super();
		this.idTabla = idTabla;
		this.ordenTabla = ordenTabla;
		this.nombreTabla = nombreTabla;
		this.aliasTabla = aliasTabla;
		this.nombreColumna = nombreColumna;
		this.etiquetaColumna=etiquetaColumna;
		this.ordenCampo = ordenCampo;
	}

	/**
	 * @return El valor de: idTabla
	 */
	public int getIdTabla() {
		return idTabla;
	}





	/**
	 * @param Valor: idTabla a asignar en: idTabla
	 */
	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}





	/**
	 * @return El valor de: ordenTabla
	 */
	public int getOrdenTabla() {
		return ordenTabla;
	}





	/**
	 * @param Valor: ordenTabla a asignar en: ordenTabla
	 */
	public void setOrdenTabla(int ordenTabla) {
		this.ordenTabla = ordenTabla;
	}





	/**
	 * @return El valor de: nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}





	/**
	 * @param Valor: nombreTabla a asignar en: nombreTabla
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}





	/**
	 * @return El valor de: aliasTabla
	 */
	public String getAliasTabla() {
		return aliasTabla;
	}





	/**
	 * @param Valor: aliasTabla a asignar en: aliasTabla
	 */
	public void setAliasTabla(String aliasTabla) {
		this.aliasTabla = aliasTabla;
	}





	/**
	 * @return El valor de: nombreColumna
	 */
	public String getNombreColumna() {
		return nombreColumna;
	}





	/**
	 * @param Valor: nombreColumna a asignar en: nombreColumna
	 */
	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}





	/**
	 * @return El valor de: etiquetaColumna
	 */
	public String getEtiquetaColumna() {
		return etiquetaColumna;
	}

	/**
	 * @param Valor: etiquetaColumna a asignar en: etiquetaColumna
	 */
	public void setEtiquetaColumna(String etiquetaColumna) {
		this.etiquetaColumna = etiquetaColumna;
	}

	/**
	 * @return El valor de: ordenCampo
	 */
	public int getOrdenCampo() {
		return ordenCampo;
	}





	/**
	 * @param Valor: ordenCampo a asignar en: ordenCampo
	 */
	public void setOrdenCampo(int ordenCampo) {
		this.ordenCampo = ordenCampo;
	}





	


	
	
	
	
		
}
