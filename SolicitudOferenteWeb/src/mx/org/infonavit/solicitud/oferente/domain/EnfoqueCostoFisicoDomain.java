package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EnfoqueCostoFisicoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6563646802102945642L;
	private int idRegistro;
	private String idAvaluo;
	private String paquete;
	private int vivieda;
	private String valorOferta;
	private String superficieTerreno;
	private String valorUnitario;
	private String factorZona;
	private String factorUbicacion;
	private String factorFrente;
	private String factorForma;
	private String factorSuperficie;
	private String factorComercializacion;
	private String factorOtros;
	private String factorResultante;
	
	public EnfoqueCostoFisicoDomain() {
		super();
	}
	
	
	
	public EnfoqueCostoFisicoDomain(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
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
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public int getVivieda() {
		return vivieda;
	}
	public void setVivieda(int vivieda) {
		this.vivieda = vivieda;
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
	public String getFactorForma() {
		return factorForma;
	}
	public void setFactorForma(String factorForma) {
		this.factorForma = factorForma;
	}






	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnfoqueCostoFisicoDomain)
		{
			return ((EnfoqueCostoFisicoDomain)obj).getIdAvaluo().trim().equals(this.idAvaluo.trim());
		}else
		{
			return false;
		}
			
		
	}

	

}
