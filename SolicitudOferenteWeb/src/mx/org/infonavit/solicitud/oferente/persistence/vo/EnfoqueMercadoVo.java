package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class EnfoqueMercadoVo extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6124985682568324575L;
	private int idRegistro;
	private String idAvaluo;
	private String idPaquete;
	private int idVivienda;
	private String edad;
	private int idConservacion;
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
	private String valorUnitarioInicio;
	private String valorUnitarioMaximo;
	private String avaluos;
	
	
	public EnfoqueMercadoVo() {
		super();
	}
	
	
	
	
	
	
	public EnfoqueMercadoVo(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}






	public EnfoqueMercadoVo(String factorFic, String factorZona,
			String factorUbicacion, String factorSuperficie, String factorEdad,
			String factorConservacion, String factorOtros,
			String factorComercializacion, String factorResultante,
			String valorUnitarioInicio, String valorUnitarioMaximo,String avaluos) {
		super();
		this.factorFic = factorFic;
		this.factorZona = factorZona;
		this.factorUbicacion = factorUbicacion;
		this.factorSuperficie = factorSuperficie;
		this.factorEdad = factorEdad;
		this.factorConservacion = factorConservacion;
		this.factorOtros = factorOtros;
		this.factorComercializacion = factorComercializacion;
		this.factorResultante = factorResultante;
		this.valorUnitarioInicio = valorUnitarioInicio;
		this.valorUnitarioMaximo = valorUnitarioMaximo;
		this.avaluos=avaluos;
	}



	public EnfoqueMercadoVo(int idRegistro, String idAvaluo, String idPaquete,
			int idVivienda, String edad, int idConservacion,
			String valorOferta, String superficieTerreno,
			String superficieConstruccion, String valorUnitario,
			String factorFic, String factorZona, String factorUbicacion,
			String factorSuperficie, String factorEdad,
			String factorConservacion, String factorOtros,
			String factorComercializacion, String factorResultante) {
		super();
		this.idRegistro = idRegistro;
		this.idAvaluo = idAvaluo;
		this.idPaquete = idPaquete;
		this.idVivienda = idVivienda;
		this.edad = edad;
		this.idConservacion = idConservacion;
		this.valorOferta = valorOferta;
		this.superficieTerreno = superficieTerreno;
		this.superficieConstruccion = superficieConstruccion;
		this.valorUnitario = valorUnitario;
		this.factorFic = factorFic;
		this.factorZona = factorZona;
		this.factorUbicacion = factorUbicacion;
		this.factorSuperficie = factorSuperficie;
		this.factorEdad = factorEdad;
		this.factorConservacion = factorConservacion;
		this.factorOtros = factorOtros;
		this.factorComercializacion = factorComercializacion;
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

	public String getValorUnitarioMaximo() {
		return valorUnitarioMaximo;
	}

	public void setValorUnitarioMaximo(String valorUnitarioMaximo) {
		this.valorUnitarioMaximo = valorUnitarioMaximo;
	}



	public String getValorUnitarioInicio() {
		return valorUnitarioInicio;
	}



	public void setValorUnitarioInicio(String valorUnitarioInicio) {
		this.valorUnitarioInicio = valorUnitarioInicio;
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
