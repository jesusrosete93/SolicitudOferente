package mx.org.infonavit.solicitud.oferente.domain;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * Clase que encapsula el reporte de solicitudes de Inex UV 
 * por paquete
 * @author Adrian Casas.
  */
public class ReporteInexUvPaqueteDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3230085584422364016L;
	private int totalViviendasPaquete;
	private int totalViviendasSolicitadas;
	private int totalViviendasSinSolicitud;
	private int totalVivienasEstado;
	private int totalProduccionOferente;
	private List<ReporteInexUvOferenteDomain> listado;
	private OferenteDomain oferente;
	private String tipoPaquete;
	
	
	
	public int getTotalViviendasPaquete() {
		return totalViviendasPaquete;
	}
	public void setTotalViviendasPaquete(int totalViviendasPaquete) {
		this.totalViviendasPaquete = totalViviendasPaquete;
	}
	public int getTotalViviendasSolicitadas() {
		return totalViviendasSolicitadas;
	}
	public void setTotalViviendasSolicitadas(int totalViviendasSolicitadas) {
		this.totalViviendasSolicitadas = totalViviendasSolicitadas;
	}
	public int getTotalViviendasSinSolicitud() {
		return totalViviendasSinSolicitud;
	}
	public void setTotalViviendasSinSolicitud(int totalViviendasSinSolicitud) {
		this.totalViviendasSinSolicitud = totalViviendasSinSolicitud;
	}
	public int getTotalVivienasEstado() {
		return totalVivienasEstado;
	}
	public void setTotalVivienasEstado(int totalVivienasEstado) {
		this.totalVivienasEstado = totalVivienasEstado;
	}
	public List<ReporteInexUvOferenteDomain> getListado() {
		return listado;
	}
	public void setListado(List<ReporteInexUvOferenteDomain> listado) {
		this.listado = listado;
	}
	public int getTotalProduccionOferente() {
		return totalProduccionOferente;
	}
	public void setTotalProduccionOferente(int totalProduccionOferente) {
		this.totalProduccionOferente = totalProduccionOferente;
	}
	public String getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	public OferenteDomain getOferente() {
		return oferente;
	}
	public void setOferente(OferenteDomain oferente) {
		this.oferente = oferente;
	}

}
