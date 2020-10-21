package mx.org.infonavit.solicitud.oferente.domain;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ComparativoMercadoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4246345499683074478L;
	List<AvaluoDomain> avaluosDomain;
	
	
	
	public List<AvaluoDomain> getAvaluosDomain() {
		return avaluosDomain;
	}
	public void setAvaluosDomain(List<AvaluoDomain> avaluosDomain) {
		this.avaluosDomain = avaluosDomain;
	}
	
}
