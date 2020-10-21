package mx.org.infonavit.solicitud.oferente.domain;

import java.text.DecimalFormat;

import mx.org.infonavit.solicitud.oferente.business.CatalogosBusines;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoSubValuadoVo;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * 
 * @author Adrian Casas 
 *
 */
public class AvaluoSubValuadoDomain extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1186450904437353074L;
	private String idPaquete;
	private int idVivienda;
	private String idAvaluo;
	private String codigoPostal;
	private String fechaCierre;
	private int edad;
	private String superficieConstruida;
	private String superficieTerrenoVivienda;
	private String idTipoInmuebleValuado;
	private String idClaseGeneralInmueble;
	private String cus;
	private String cusCalculadoAva;
	private String valorConcluido;
	private String valorComparativoM2;
	private String promedioComp;
	private String valorComparativoMenor;
	private String valorComparativoMayor;
	private String mensaje;
	private int    bandera;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int idUnidadValuacion;
	private String nombreUnidadValuacion;
	
	
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
	public String getSuperficieConstruida() {
		return superficieConstruida;
	}
	/**
	 * @param Valor: superficieConstruida a asignar en: superficieConstruida
	 */
	public void setSuperficieConstruida(String superficieConstruida) {
		this.superficieConstruida = superficieConstruida;
	}
	/**
	 * @return El valor de: superficieTerrenoVivienda
	 */
	public String getSuperficieTerrenoVivienda() {
		return superficieTerrenoVivienda;
	}
	/**
	 * @param Valor: superficieTerrenoVivienda a asignar en: superficieTerrenoVivienda
	 */
	public void setSuperficieTerrenoVivienda(String superficieTerrenoVivienda) {
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
	public String getCus() {
		return cus;
	}
	/**
	 * @param Valor: cus a asignar en: cus
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}
	/**
	 * @return El valor de: cusCalculadoAva
	 */
	public String getCusCalculadoAva() {
		return cusCalculadoAva;
	}
	/**
	 * @param Valor: cusCalculadoAva a asignar en: cusCalculadoAva
	 */
	public void setCusCalculadoAva(String cusCalculadoAva) {
		this.cusCalculadoAva = cusCalculadoAva;
	}
	/**
	 * @return El valor de: valorConcluido
	 */
	public String getValorConcluido() {
		return valorConcluido;
	}
	/**
	 * @param Valor: valorConcluido a asignar en: valorConcluido
	 */
	public void setValorConcluido(String valorConcluido) {
		this.valorConcluido = valorConcluido;
	}
	/**
	 * @return El valor de: valorComparativoM2
	 */
	public String getValorComparativoM2() {
		return valorComparativoM2;
	}
	/**
	 * @param Valor: valorComparativoM2 a asignar en: valorComparativoM2
	 */
	public void setValorComparativoM2(String valorComparativoM2) {
		this.valorComparativoM2 = valorComparativoM2;
	}
	/**
	 * @return El valor de: promedioComp
	 */
	public String getPromedioComp() {
		return promedioComp;
	}
	/**
	 * @param Valor: promedioComp a asignar en: promedioComp
	 */
	public void setPromedioComp(String promedioComp) {
		this.promedioComp = promedioComp;
	}
	/**
	 * @return El valor de: valorComparativoMenor
	 */
	public String getValorComparativoMenor() {
		return valorComparativoMenor;
	}
	/**
	 * @param Valor: valorComparativoMenor a asignar en: valorComparativoMenor
	 */
	public void setValorComparativoMenor(String valorComparativoMenor) {
		this.valorComparativoMenor = valorComparativoMenor;
	}
	/**
	 * @return El valor de: valorComparativoMayor
	 */
	public String getValorComparativoMayor() {
		return valorComparativoMayor;
	}
	/**
	 * @param Valor: valorComparativoMayor a asignar en: valorComparativoMayor
	 */
	public void setValorComparativoMayor(String valorComparativoMayor) {
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
	
	/**
	 * 
	 * @return
	 */
	public static AvaluoSubValuadoDomain getObjetoDomain(AvaluoSubValuadoVo registro)
	{
		DecimalFormat decimalFormat = new DecimalFormat("####.####");
		
		AvaluoSubValuadoDomain regreso = new AvaluoSubValuadoDomain();
		
		
		
		regreso.setIdPaquete(registro.getIdPaquete());
		regreso.setIdVivienda(registro.getIdVivienda());
		regreso.setIdAvaluo(registro.getIdAvaluo());
		regreso.setCodigoPostal(registro.getCodigoPostal());
		regreso.setFechaCierre(registro.getFechaCierre());
		regreso.setEdad(registro.getEdad());
		regreso.setSuperficieConstruida(decimalFormat.format(registro.getSuperficieConstruida()));
		regreso.setSuperficieTerrenoVivienda(decimalFormat.format(registro.getSuperficieTerrenoVivienda()));
		regreso.setIdTipoInmuebleValuado(CatalogosBusines.CATALOGO_TIPO_INMUEBLE_VALUADO.get(registro.getIdTipoInmuebleValuado())==null?"Sin clasificación":CatalogosBusines.CATALOGO_TIPO_INMUEBLE_VALUADO.get(registro.getIdTipoInmuebleValuado())  );
		regreso.setIdClaseGeneralInmueble(CatalogosBusines.CATALOGO_CLASE_INMUEBLE.get(registro.getIdClaseGeneralInmueble())==null?"Sin clasificación":CatalogosBusines.CATALOGO_CLASE_INMUEBLE.get(registro.getIdClaseGeneralInmueble()));
		regreso.setCus(decimalFormat.format(registro.getCus()));
		regreso.setCusCalculadoAva(decimalFormat.format(registro.getCusCalculadoAva()));
		regreso.setValorConcluido(decimalFormat.format(registro.getValorConcluido()));
		regreso.setValorComparativoM2(decimalFormat.format(registro.getValorComparativoM2()));
		regreso.setPromedioComp(decimalFormat.format(registro.getPromedioComp()));
		regreso.setValorComparativoMenor(decimalFormat.format(registro.getValorComparativoMenor()));
		regreso.setValorComparativoMayor(decimalFormat.format(registro.getValorComparativoMayor()));
		regreso.setMensaje(registro.getMensaje());
		regreso.setBandera(registro.getBandera());
		regreso.setIdUnidadValuacion(registro.getIdUnidadValuacion());
		regreso.setNombreUnidadValuacion(registro.getNombreUnidadValuacion());
		
		return regreso;
	}

}
