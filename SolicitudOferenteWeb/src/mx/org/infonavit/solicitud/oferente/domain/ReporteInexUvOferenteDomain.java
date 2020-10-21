/**
 * Clase que encapsula el resultado del reporte de Inex de unidades de valuación 
 * del oferente.
 */
package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ReporteInexUvOferenteDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8364367593401447600L;
	private OferenteDomain oferente;
	private EstadoDomian estado;
	private UnidadValuacionDomain unidadValuacion;
	private int numeroViviendas;
	
	
	public ReporteInexUvOferenteDomain() {
		super();
	}
	
	public ReporteInexUvOferenteDomain(EstadoDomian estado,
			UnidadValuacionDomain unidadValuacion, int numeroViviendas) {
		super();
		this.estado = estado;
		this.unidadValuacion = unidadValuacion;
		this.numeroViviendas = numeroViviendas;
	}
	
	public ReporteInexUvOferenteDomain(OferenteDomain oferente,
			EstadoDomian estado, UnidadValuacionDomain unidadValuacion,
			int numeroViviendas) {
		super();
		this.oferente = oferente;
		this.estado = estado;
		this.unidadValuacion = unidadValuacion;
		this.numeroViviendas = numeroViviendas;
	}

	public EstadoDomian getEstado() {
		return estado;
	}
	public void setEstado(EstadoDomian estado) {
		this.estado = estado;
	}
	public UnidadValuacionDomain getUnidadValuacion() {
		return unidadValuacion;
	}
	public void setUnidadValuacion(UnidadValuacionDomain unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
	}
	public int getNumeroViviendas() {
		return numeroViviendas;
	}
	public void setNumeroViviendas(int numeroViviendas) {
		this.numeroViviendas = numeroViviendas;
	}

	public OferenteDomain getOferente() {
		return oferente;
	}

	public void setOferente(OferenteDomain oferente) {
		this.oferente = oferente;
	}
	
	
}
