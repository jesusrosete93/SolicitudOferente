package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class AvaluoVo extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9188677103606644979L;
	

	private String idAvaluo;
	private int idUv;
	private List<String> unidadesValuacion;
	private String fechaSolicitud;
	private String fechaDescarga;
	private String fechaEnvio;
	private String fechaCierre;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private String fechaAsociacionFactura;
	private int idEstatus;
	private int idVivienda;
	private String idPaquete;
	private String nss;
	private String rfc;
	private boolean isai;
	private int idPropositoAvaluo;
	private int idPropositoRecuperacion;
	private String propositoOtro;
	private String fechaCompromisoTermino;
	private String fechaCaducidad;
	private int idTipoMercado;
	private String idConviviencia;
	private String identificacion;
	private int tipoLinea;
	private String numeroCredito;
	private String fechaTramiteCredito;
	private int tipoTramiteCredito;
	private int tipoAvaluo;
	private String montoAvaluo;
	private String marcaCargaHerramientaCaduco;
	private String marcaRequisitoPago;
	private String avaluos;
	
	
	public AvaluoVo() {
		super();
	}
	
	
	
	public AvaluoVo(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}



	public AvaluoVo(String idAvaluo, List<String> unidadesValuacion,
			String fechaCierreInicio, String fechaCierreFin, String idPaquete,String avaluos) {
		super();
		this.idAvaluo = idAvaluo;
		this.unidadesValuacion = unidadesValuacion;
		this.fechaCierreInicio = fechaCierreInicio;
		this.fechaCierreFin = fechaCierreFin;
		this.idPaquete = idPaquete;
		this.avaluos = avaluos;
	}



	public AvaluoVo(String idAvaluo, int idUv, String fechaSolicitud,
			String fechaDescarga, String fechaEnvio, String fechaCierre,
			String fechaAsociacionFactura, int idEstatus, int idVivienda,
			String idPaquete, String nss, String rfc, boolean isai,
			int idPropositoAvaluo, int idPropositoRecuperacion,
			String propositoOtro, String fechaCompromisoTermino,
			String fechaCaducidad, int idTipoMercado, String idConviviencia,
			String identificacion, int tipoLinea, String numeroCredito,
			String fechaTramiteCredito, int tipoTramiteCredito, int tipoAvaluo,
			String montoAvaluo, String marcaCargaHerramientaCaduco,
			String marcaRequisitoPago) {
		super();
		this.idAvaluo = idAvaluo;
		this.idUv = idUv;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaDescarga = fechaDescarga;
		this.fechaEnvio = fechaEnvio;
		this.fechaCierre = fechaCierre;
		this.fechaAsociacionFactura = fechaAsociacionFactura;
		this.idEstatus = idEstatus;
		this.idVivienda = idVivienda;
		this.idPaquete = idPaquete;
		this.nss = nss;
		this.rfc = rfc;
		this.isai = isai;
		this.idPropositoAvaluo = idPropositoAvaluo;
		this.idPropositoRecuperacion = idPropositoRecuperacion;
		this.propositoOtro = propositoOtro;
		this.fechaCompromisoTermino = fechaCompromisoTermino;
		this.fechaCaducidad = fechaCaducidad;
		this.idTipoMercado = idTipoMercado;
		this.idConviviencia = idConviviencia;
		this.identificacion = identificacion;
		this.tipoLinea = tipoLinea;
		this.numeroCredito = numeroCredito;
		this.fechaTramiteCredito = fechaTramiteCredito;
		this.tipoTramiteCredito = tipoTramiteCredito;
		this.tipoAvaluo = tipoAvaluo;
		this.montoAvaluo = montoAvaluo;
		this.marcaCargaHerramientaCaduco = marcaCargaHerramientaCaduco;
		this.marcaRequisitoPago = marcaRequisitoPago;
	}
	public String getIdAvaluo() {
		return idAvaluo;
	}
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	public int getIdUv() {
		return idUv;
	}
	public void setIdUv(int idUv) {
		this.idUv = idUv;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getFechaDescarga() {
		return fechaDescarga;
	}
	public void setFechaDescarga(String fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getFechaAsociacionFactura() {
		return fechaAsociacionFactura;
	}
	public void setFechaAsociacionFactura(String fechaAsociacionFactura) {
		this.fechaAsociacionFactura = fechaAsociacionFactura;
	}
	public int getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	public String getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public boolean isIsai() {
		return isai;
	}
	public void setIsai(boolean isai) {
		this.isai = isai;
	}
	public int getIdPropositoAvaluo() {
		return idPropositoAvaluo;
	}
	public void setIdPropositoAvaluo(int idPropositoAvaluo) {
		this.idPropositoAvaluo = idPropositoAvaluo;
	}
	public int getIdPropositoRecuperacion() {
		return idPropositoRecuperacion;
	}
	public void setIdPropositoRecuperacion(int idPropositoRecuperacion) {
		this.idPropositoRecuperacion = idPropositoRecuperacion;
	}
	public String getPropositoOtro() {
		return propositoOtro;
	}
	public void setPropositoOtro(String propositoOtro) {
		this.propositoOtro = propositoOtro;
	}
	public String getFechaCompromisoTermino() {
		return fechaCompromisoTermino;
	}
	public void setFechaCompromisoTermino(String fechaCompromisoTermino) {
		this.fechaCompromisoTermino = fechaCompromisoTermino;
	}
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getIdTipoMercado() {
		return idTipoMercado;
	}
	public void setIdTipoMercado(int idTipoMercado) {
		this.idTipoMercado = idTipoMercado;
	}
	public String getIdConviviencia() {
		return idConviviencia;
	}
	public void setIdConviviencia(String idConviviencia) {
		this.idConviviencia = idConviviencia;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public int getTipoLinea() {
		return tipoLinea;
	}
	public void setTipoLinea(int tipoLinea) {
		this.tipoLinea = tipoLinea;
	}
	public String getNumeroCredito() {
		return numeroCredito;
	}
	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
	public String getFechaTramiteCredito() {
		return fechaTramiteCredito;
	}
	public void setFechaTramiteCredito(String fechaTramiteCredito) {
		this.fechaTramiteCredito = fechaTramiteCredito;
	}
	public int getTipoTramiteCredito() {
		return tipoTramiteCredito;
	}
	public void setTipoTramiteCredito(int tipoTramiteCredito) {
		this.tipoTramiteCredito = tipoTramiteCredito;
	}
	public int getTipoAvaluo() {
		return tipoAvaluo;
	}
	public void setTipoAvaluo(int tipoAvaluo) {
		this.tipoAvaluo = tipoAvaluo;
	}
	public String getMontoAvaluo() {
		return montoAvaluo;
	}
	public void setMontoAvaluo(String montoAvaluo) {
		this.montoAvaluo = montoAvaluo;
	}
	public String getMarcaCargaHerramientaCaduco() {
		return marcaCargaHerramientaCaduco;
	}
	public void setMarcaCargaHerramientaCaduco(String marcaCargaHerramientaCaduco) {
		this.marcaCargaHerramientaCaduco = marcaCargaHerramientaCaduco;
	}
	public String getMarcaRequisitoPago() {
		return marcaRequisitoPago;
	}
	public void setMarcaRequisitoPago(String marcaRequisitoPago) {
		this.marcaRequisitoPago = marcaRequisitoPago;
	}
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}

	public List<String> getUnidadesValuacion() {
		return unidadesValuacion;
	}
	public void setUnidadesValuacion(List<String> unidadesValuacion) {
		this.unidadesValuacion = unidadesValuacion;
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



	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AvaluoDomain)
		{
			if( ((AvaluoVo)obj).getIdAvaluo()!=null && ((AvaluoVo)obj).getIdAvaluo().trim().equals("")
				&& this.idAvaluo!=null && !this.idAvaluo.trim().equals(""))
			{
				return ((AvaluoVo)obj).getIdAvaluo().trim().equals(this.idAvaluo.trim());
			}else
			{
				return false;
			}
		}else
		{
			return false;
		}
	}
	
}
