package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EnfoqueMercadoDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171122505174084543L;
	private int idRegistro;
	private String idAvaluo;
	private String paquete;
	private int viviendad;
	private String edad;
	private int idConservacion;
	private String descripcionConservacion;
	private String valorOferta;
	private String superficieTerreno;
	private String superficieConstruccion;
	private String valorUnitario;
	private String factorFic;
	private String factorZona;
	private String factorUbicacion;
	private String factorSuperficie;
	private String factorEdad;
	private String factorConservacion;
	private String factorOtros;
	private String factorComercializacion;
	private String factorResultante;
	
	
	
	
	public EnfoqueMercadoDomain() {
		super();
	}
	public EnfoqueMercadoDomain(String idAvaluo) {
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
	public int getViviendad() {
		return viviendad;
	}
	public void setViviendad(int viviendad) {
		this.viviendad = viviendad;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public int getIdConservacion() {
		return idConservacion;
	}
	public void setIdConservacion(int idConservacion) {
		this.idConservacion = idConservacion;
	}
	public String getDescripcionConservacion() {
		return descripcionConservacion;
	}
	public void setDescripcionConservacion(String descripcionConservacion) {
		this.descripcionConservacion = descripcionConservacion;
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
	public String getSuperficieConstruccion() {
		return superficieConstruccion;
	}
	public void setSuperficieConstruccion(String superficieConstruccion) {
		this.superficieConstruccion = superficieConstruccion;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getFactorFic() {
		return factorFic;
	}
	public void setFactorFic(String factorFic) {
		this.factorFic = factorFic;
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
	public String getFactorSuperficie() {
		return factorSuperficie;
	}
	public void setFactorSuperficie(String factorSuperficie) {
		this.factorSuperficie = factorSuperficie;
	}
	public String getFactorEdad() {
		return factorEdad;
	}
	public void setFactorEdad(String factorEdad) {
		this.factorEdad = factorEdad;
	}
	public String getFactorConservacion() {
		return factorConservacion;
	}
	public void setFactorConservacion(String factorConservacion) {
		this.factorConservacion = factorConservacion;
	}
	public String getFactorOtros() {
		return factorOtros;
	}
	public void setFactorOtros(String factorOtros) {
		this.factorOtros = factorOtros;
	}
	public String getFactorComercializacion() {
		return factorComercializacion;
	}
	public void setFactorComercializacion(String factorComercializacion) {
		this.factorComercializacion = factorComercializacion;
	}
	public String getFactorResultante() {
		return factorResultante;
	}
	public void setFactorResultante(String factorResultante) {
		this.factorResultante = factorResultante;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EnfoqueMercadoDomain)
		{
			return ((EnfoqueMercadoDomain)obj).getIdAvaluo().trim().equals(this.idAvaluo.trim());
		}else
		{
			return false;
		}
	}
	

}
