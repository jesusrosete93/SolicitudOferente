package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class AvaluoSubValuadoVo extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7505848449259972031L;
	private String idPaquete;
	private int idVivienda;
	private String idAvaluo;
	private String codigoPostal;
	private String fechaCierre;
	private int edad;
	private double superficieConstruida;
	private double superficieTerrenoVivienda;
	private String idTipoInmuebleValuado;
	private String idClaseGeneralInmueble;
	private double cus;
	private double cusCalculadoAva;
	private double valorConcluido;
	private double valorComparativoM2;
	private double promedioComp;
	private double valorComparativoMenor;
	private double valorComparativoMayor;
	private String mensaje;
	private int    bandera;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int idUnidadValuacion;
	private String nombreUnidadValuacion;
	
	
	
	
	/**
	 * 
	 */
	public AvaluoSubValuadoVo() {
		super();
	}
	
	/**
	 * 
	 * @param idPaquete
	 * @param idVivienda
	 * @param idAvaluo
	 * @param codigoPostal
	 * @param fechaCierre
	 * @param edad
	 * @param superficieConstruida
	 * @param superficieTerrenoVivienda
	 * @param idTipoInmuebleValuado
	 * @param idClaseGeneralInmueble
	 * @param cus
	 * @param cusCalculadoAva
	 * @param valorConcluido
	 * @param valorComparativoM2
	 * @param promedioComp
	 * @param valorComparativoMenor
	 * @param valorComparativoMayor
	 * @param mensaje
	 * @param bandera
	 */
	public AvaluoSubValuadoVo(String idPaquete, int idVivienda,
			String idAvaluo, String codigoPostal, String fechaCierre, int edad,
			double superficieConstruida, double superficieTerrenoVivienda,
			String idTipoInmuebleValuado, String idClaseGeneralInmueble,
			double cus, double cusCalculadoAva, double valorConcluido,
			double valorComparativoM2, double promedioComp,
			double valorComparativoMenor, double valorComparativoMayor,
			String mensaje, int bandera,int idUnidadValuacion,String nombreUnidadValuacion) {
		super();
		this.idPaquete = idPaquete;
		this.idVivienda = idVivienda;
		this.idAvaluo = idAvaluo;
		this.codigoPostal = codigoPostal;
		this.fechaCierre = fechaCierre;
		this.edad = edad;
		this.superficieConstruida = superficieConstruida;
		this.superficieTerrenoVivienda = superficieTerrenoVivienda;
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
		this.idClaseGeneralInmueble = idClaseGeneralInmueble;
		this.cus = cus;
		this.cusCalculadoAva = cusCalculadoAva;
		this.valorConcluido = valorConcluido;
		this.valorComparativoM2 = valorComparativoM2;
		this.promedioComp = promedioComp;
		this.valorComparativoMenor = valorComparativoMenor;
		this.valorComparativoMayor = valorComparativoMayor;
		this.mensaje = mensaje;
		this.bandera = bandera;
		this.idUnidadValuacion=idUnidadValuacion;
		this.nombreUnidadValuacion=nombreUnidadValuacion;
	}
	/**
	 * @return El valor de: idPaquete
	 */
	public String getIdPaquete() {
		return idPaquete;
	}
	/**
	 * @param Valor: idPaquete a asignar en: idPaquete
	 */
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	/**
	 * @return El valor de: idVivienda
	 */
	public int getIdVivienda() {
		return idVivienda;
	}
	/**
	 * @param Valor: idVivienda a asignar en: idVivienda
	 */
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	/**
	 * @return El valor de: idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}
	/**
	 * @param Valor: idAvaluo a asignar en: idAvaluo
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	/**
	 * @return El valor de: codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param Valor: codigoPostal a asignar en: codigoPostal
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return El valor de: fechaCierre
	 */
	public String getFechaCierre() {
		return fechaCierre;
	}
	/**
	 * @param Valor: fechaCierre a asignar en: fechaCierre
	 */
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	/**
	 * @return El valor de: edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param Valor: edad a asignar en: edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return El valor de: superficieConstruida
	 */
	public double getSuperficieConstruida() {
		return superficieConstruida;
	}
	/**
	 * @param Valor: superficieConstruida a asignar en: superficieConstruida
	 */
	public void setSuperficieConstruida(double superficieConstruida) {
		this.superficieConstruida = superficieConstruida;
	}
	/**
	 * @return El valor de: superficieTerrenoVivienda
	 */
	public double getSuperficieTerrenoVivienda() {
		return superficieTerrenoVivienda;
	}
	/**
	 * @param Valor: superficieTerrenoVivienda a asignar en: superficieTerrenoVivienda
	 */
	public void setSuperficieTerrenoVivienda(double superficieTerrenoVivienda) {
		this.superficieTerrenoVivienda = superficieTerrenoVivienda;
	}
	/**
	 * @return El valor de: idTipoInmuebleValuado
	 */
	public String getIdTipoInmuebleValuado() {
		return idTipoInmuebleValuado;
	}
	/**
	 * @param Valor: idTipoInmuebleValuado a asignar en: idTipoInmuebleValuado
	 */
	public void setIdTipoInmuebleValuado(String idTipoInmuebleValuado) {
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
	}
	/**
	 * @return El valor de: idClaseGeneralInmueble
	 */
	public String getIdClaseGeneralInmueble() {
		return idClaseGeneralInmueble;
	}
	/**
	 * @param Valor: idClaseGeneralInmueble a asignar en: idClaseGeneralInmueble
	 */
	public void setIdClaseGeneralInmueble(String idClaseGeneralInmueble) {
		this.idClaseGeneralInmueble = idClaseGeneralInmueble;
	}
	/**
	 * @return El valor de: cus
	 */
	public double getCus() {
		return cus;
	}
	/**
	 * @param Valor: cus a asignar en: cus
	 */
	public void setCus(double cus) {
		this.cus = cus;
	}
	/**
	 * @return El valor de: cusCalculadoAva
	 */
	public double getCusCalculadoAva() {
		return cusCalculadoAva;
	}
	/**
	 * @param Valor: cusCalculadoAva a asignar en: cusCalculadoAva
	 */
	public void setCusCalculadoAva(double cusCalculadoAva) {
		this.cusCalculadoAva = cusCalculadoAva;
	}
	/**
	 * @return El valor de: valorConcluido
	 */
	public double getValorConcluido() {
		return valorConcluido;
	}
	/**
	 * @param Valor: valorConcluido a asignar en: valorConcluido
	 */
	public void setValorConcluido(double valorConcluido) {
		this.valorConcluido = valorConcluido;
	}
	/**
	 * @return El valor de: valorComparativoM2
	 */
	public double getValorComparativoM2() {
		return valorComparativoM2;
	}
	/**
	 * @param Valor: valorComparativoM2 a asignar en: valorComparativoM2
	 */
	public void setValorComparativoM2(double valorComparativoM2) {
		this.valorComparativoM2 = valorComparativoM2;
	}
	/**
	 * @return El valor de: promedioComp
	 */
	public double getPromedioComp() {
		return promedioComp;
	}
	/**
	 * @param Valor: promedioComp a asignar en: promedioComp
	 */
	public void setPromedioComp(double promedioComp) {
		this.promedioComp = promedioComp;
	}
	/**
	 * @return El valor de: valorComparativoMenor
	 */
	public double getValorComparativoMenor() {
		return valorComparativoMenor;
	}
	/**
	 * @param Valor: valorComparativoMenor a asignar en: valorComparativoMenor
	 */
	public void setValorComparativoMenor(double valorComparativoMenor) {
		this.valorComparativoMenor = valorComparativoMenor;
	}
	/**
	 * @return El valor de: valorComparativoMayor
	 */
	public double getValorComparativoMayor() {
		return valorComparativoMayor;
	}
	/**
	 * @param Valor: valorComparativoMayor a asignar en: valorComparativoMayor
	 */
	public void setValorComparativoMayor(double valorComparativoMayor) {
		this.valorComparativoMayor = valorComparativoMayor;
	}
	/**
	 * @return El valor de: mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param Valor: mensaje a asignar en: mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return El valor de: bandera
	 */
	public int getBandera() {
		return bandera;
	}
	/**
	 * @param Valor: bandera a asignar en: bandera
	 */
	public void setBandera(int bandera) {
		this.bandera = bandera;
	}

	/**
	 * @return El valor de: fechaCierreInicio
	 */
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}

	/**
	 * @param Valor: fechaCierreInicio a asignar en: fechaCierreInicio
	 */
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}

	/**
	 * @return El valor de: fechaCierreFin
	 */
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}

	/**
	 * @param Valor: fechaCierreFin a asignar en: fechaCierreFin
	 */
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}

	/**
	 * @return El valor de: idUnidadValuacion
	 */
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}

	/**
	 * @param Valor: idUnidadValuacion a asignar en: idUnidadValuacion
	 */
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}

	/**
	 * @return El valor de: nombreUnidadValuacion
	 */
	public String getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}

	/**
	 * @param Valor: nombreUnidadValuacion a asignar en: nombreUnidadValuacion
	 */
	public void setNombreUnidadValuacion(String nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}
	

}
