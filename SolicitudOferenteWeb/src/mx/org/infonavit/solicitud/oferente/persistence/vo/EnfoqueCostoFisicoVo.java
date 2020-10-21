package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EnfoqueCostoFisicoVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9031453817379105905L;
	private int idRegistro;
	private String idAvaluo;
	private String idPaquete;
	private int idVivienda;
	private String valorOferta;
	private String valorOfertaMinimo;
	private String valorOfertaMaximo;
	private String superficieTerreno;
	private String superficieTerrenoMinimo;
	private String superficieTerrenoMaximo;
	private String valorUnitario;
	private String valorUnitarioMinimo;
	private String valorUnitarioMaximo;
	private String factorZona;
	private String factorUbicacion;
	private String factorFrente;
	private String factorForma;
	private String factorSuperficie;
	private String factorComercializacion;
	private String factorOtros;
	private String factorResultante;
	private String avaluos;
	
	public EnfoqueCostoFisicoVo() {
		super();
	}
	
	
	
	public EnfoqueCostoFisicoVo(String idAvaluo,String avaluos) {
		super();
		this.idAvaluo = idAvaluo;
		this.avaluos = avaluos;
	}



	public EnfoqueCostoFisicoVo(int idRegistro, String idAvaluo,
			String idPaquete, int idVivienda, String valorOferta,
			String superficieTerreno, String valorUnitario, String factorZona,
			String factorUbicacion, String factorFrente, String factorForma,
			String factorSuperficie, String factorComercializacion,
			String factorOtros, String factorResultante) {
		super();
		this.idRegistro = idRegistro;
		this.idAvaluo = idAvaluo;
		this.idPaquete = idPaquete;
		this.idVivienda = idVivienda;
		this.valorOferta = valorOferta;
		this.superficieTerreno = superficieTerreno;
		this.valorUnitario = valorUnitario;
		this.factorZona = factorZona;
		this.factorUbicacion = factorUbicacion;
		this.factorFrente = factorFrente;
		this.factorForma = factorForma;
		this.factorSuperficie = factorSuperficie;
		this.factorComercializacion = factorComercializacion;
		this.factorOtros = factorOtros;
		this.factorResultante = factorResultante;
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
	public String getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	public String getValorOferta() {
		return valorOferta;
	}
	public void setValorOferta(String valorOferta) {
		this.valorOferta = valorOferta;
	}
	public String getSuperficieTerreno() {
		return superficieTerreno;
	}
	public void setSuperficieTerreno(String superficieTerreno) {
		this.superficieTerreno = superficieTerreno;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getFactorZona() {
		return factorZona;
	}
	public void setFactorZona(String factorZona) {
		this.factorZona = factorZona;
	}
	public String getFactorUbicacion() {
		return factorUbicacion;
	}
	public void setFactorUbicacion(String factorUbicacion) {
		this.factorUbicacion = factorUbicacion;
	}
	public String getFactorFrente() {
		return factorFrente;
	}
	public void setFactorFrente(String factorFrente) {
		this.factorFrente = factorFrente;
	}
	public String getFactorForma() {
		return factorForma;
	}
	public void setFactorForma(String factorForma) {
		this.factorForma = factorForma;
	}
	public String getFactorSuperficie() {
		return factorSuperficie;
	}
	public void setFactorSuperficie(String factorSuperficie) {
		this.factorSuperficie = factorSuperficie;
	}
	public String getFactorComercializacion() {
		return factorComercializacion;
	}
	public void setFactorComercializacion(String factorComercializacion) {
		this.factorComercializacion = factorComercializacion;
	}
	public String getFactorOtros() {
		return factorOtros;
	}
	public void setFactorOtros(String factorOtros) {
		this.factorOtros = factorOtros;
	}
	public String getFactorResultante() {
		return factorResultante;
	}
	public void setFactorResultante(String factorResultante) {
		this.factorResultante = factorResultante;
	}

	public String getValorOfertaMinimo() {
		return valorOfertaMinimo;
	}

	public void setValorOfertaMinimo(String valorOfertaMinimo) {
		this.valorOfertaMinimo = valorOfertaMinimo;
	}

	public String getValorOfertaMaximo() {
		return valorOfertaMaximo;
	}

	public void setValorOfertaMaximo(String valorOfertaMaximo) {
		this.valorOfertaMaximo = valorOfertaMaximo;
	}

	public String getSuperficieTerrenoMinimo() {
		return superficieTerrenoMinimo;
	}

	public void setSuperficieTerrenoMinimo(String superficieTerrenoMinimo) {
		this.superficieTerrenoMinimo = superficieTerrenoMinimo;
	}

	public String getSuperficieTerrenoMaximo() {
		return superficieTerrenoMaximo;
	}

	public void setSuperficieTerrenoMaximo(String superficieTerrenoMaximo) {
		this.superficieTerrenoMaximo = superficieTerrenoMaximo;
	}

	public String getValorUnitarioMinimo() {
		return valorUnitarioMinimo;
	}

	public void setValorUnitarioMinimo(String valorUnitarioMinimo) {
		this.valorUnitarioMinimo = valorUnitarioMinimo;
	}

	public String getValorUnitarioMaximo() {
		return valorUnitarioMaximo;
	}

	public void setValorUnitarioMaximo(String valorUnitarioMaximo) {
		this.valorUnitarioMaximo = valorUnitarioMaximo;
	}



	/**
	 * @return the avaluos
	 */
	public String getAvaluos() {
		return avaluos;
	}



	/**
	 * @param avaluos the avaluos to set
	 */
	public void setAvaluos(String avaluos) {
		this.avaluos = avaluos;
	}


}
