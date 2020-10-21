package mx.org.infonavit.solicitud.oferente.domain;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class AvaluoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7472261647294396111L;
	private String idAvaluo;
	private UnidadValuacionDomain unidadValuacion;
	private String fechaSolicitud;
	private String fechaDescarga;
	private String fechaEnvio;
	private String fechaCierre;
	private String fechaAsociacionFactura;
	private int estatus;
	private String descripcionEstatus;
	private int vivienda;
	private String paquete;
	private String nss;
	private String rfc;
	private String isai;
	private String iConviviencia;
	private ViviendaDomain viviendaD;
	private ElementosAdicionalesDomain elementosAdicionales;
	private DetalleAvaluoDomain detalleAvaluo;
	private List<EnfoqueCostoFisicoDomain> enfoquesCFD;
	private List<EnfoqueMercadoDomain> enfoquesMercado;
	
	
	
	
	public AvaluoDomain() {
		super();
	}
	public AvaluoDomain(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}
	
	public AvaluoDomain(String idAvaluo, UnidadValuacionDomain unidadValuacion,
						String fechaSolicitud, String fechaDescarga, String fechaEnvio,
						String fechaCierre, String fechaAsociacionFactura, int estatus,
						String descripcionEstatus, int vivienda, String paquete,
						String nss, String rfc, String isai, String conviviencia) {
		super();
		this.idAvaluo = idAvaluo;
		this.unidadValuacion = unidadValuacion;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaDescarga = fechaDescarga;
		this.fechaEnvio = fechaEnvio;
		this.fechaCierre = fechaCierre;
		this.fechaAsociacionFactura = fechaAsociacionFactura;
		this.estatus = estatus;
		this.descripcionEstatus = descripcionEstatus;
		this.vivienda = vivienda;
		this.paquete = paquete;
		this.nss = nss;
		this.rfc = rfc;
		this.isai = isai;
		iConviviencia = conviviencia;
	}
	public String getIdAvaluo() {
		return idAvaluo;
	}
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	public UnidadValuacionDomain getUnidadValuacion() {
		return unidadValuacion;
	}
	public void setUnidadValuacion(UnidadValuacionDomain unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
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
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}
	public int getVivienda() {
		return vivienda;
	}
	public void setVivienda(int vivienda) {
		this.vivienda = vivienda;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
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
	public String getIsai() {
		return isai;
	}
	public void setIsai(String isai) {
		this.isai = isai;
	}
	public List<EnfoqueCostoFisicoDomain> getEnfoquesCFD() {
		return enfoquesCFD;
	}
	public void setEnfoquesCFD(List<EnfoqueCostoFisicoDomain> enfoquesCFD) {
		this.enfoquesCFD = enfoquesCFD;
	}
	public List<EnfoqueMercadoDomain> getEnfoquesMercado() {
		return enfoquesMercado;
	}
	public void setEnfoquesMercado(List<EnfoqueMercadoDomain> enfoquesMercado) {
		this.enfoquesMercado = enfoquesMercado;
	}
	public DetalleAvaluoDomain getDetalleAvaluo() {
		return detalleAvaluo;
	}
	public void setDetalleAvaluo(DetalleAvaluoDomain detalleAvaluo) {
		this.detalleAvaluo = detalleAvaluo;
	}
	public ViviendaDomain getViviendaD() {
		return viviendaD;
	}
	public void setViviendaD(ViviendaDomain viviendaD) {
		this.viviendaD = viviendaD;
	}
	public ElementosAdicionalesDomain getElementosAdicionales() {
		return elementosAdicionales;
	}
	public void setElementosAdicionales(
			ElementosAdicionalesDomain elementosAdicionales) {
		this.elementosAdicionales = elementosAdicionales;
	}
	public String getIConviviencia() {
		return iConviviencia;
	}
	public void setIConviviencia(String conviviencia) {
		iConviviencia = conviviencia;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AvaluoDomain)
		{
			if( ((AvaluoDomain)obj).getIdAvaluo()!=null && !((AvaluoDomain)obj).getIdAvaluo().trim().equals("")
				&& this.idAvaluo!=null && !this.idAvaluo.trim().equals(""))
			{
				return ((AvaluoDomain)obj).getIdAvaluo().trim().equals(this.idAvaluo.trim());
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
