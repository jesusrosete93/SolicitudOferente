package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un oferente del catalogo de oferentes en el SELAI</p>
 * @author Adrian Casas
 *
 */
public class OferenteSolicitudDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6839775058770794587L;
	private SolicitudOferenteDomain solicitudOferenteDomain;
	
	public OferenteSolicitudDomain() {
		super();
		
	}

	public OferenteSolicitudDomain(
			SolicitudOferenteDomain solicitudOferenteDomain) {
		super();
		this.solicitudOferenteDomain = solicitudOferenteDomain;
	}

	public SolicitudOferenteDomain getSolicitudOferenteDomain() {
		return solicitudOferenteDomain;
	}

	public void setSolicitudOferenteDomain(SolicitudOferenteDomain solicitudOferenteDomain) {
		this.solicitudOferenteDomain = solicitudOferenteDomain;
	}
	


	
	
}
