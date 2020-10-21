package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class ReporteEcoUvEcoTecnologiaDomain extends GenericValueObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4463078708015625153L;

	private TecnologiaDomain tecnoDomain;
	private PaqueteEcoDomain paqueEco;
	private ViviendaDomain vivienda;
	private String id;
	
	
	public ReporteEcoUvEcoTecnologiaDomain() {
		super();
		
	}
	
	public ReporteEcoUvEcoTecnologiaDomain(TecnologiaDomain tecnoDomain,
			PaqueteEcoDomain paqueEco) {
		super();
		this.tecnoDomain = tecnoDomain;
		this.paqueEco = paqueEco;
	}
	
	public ReporteEcoUvEcoTecnologiaDomain(TecnologiaDomain tecnoDomain,
			PaqueteEcoDomain paqueEco, ViviendaDomain vivienda, String id) {
		super();
		this.tecnoDomain = tecnoDomain;
		this.paqueEco = paqueEco;
		this.vivienda = vivienda;
		this.id = id;
	}
	
	public TecnologiaDomain getTecnoDomain() {
		return tecnoDomain;
	}
	public void setTecnoDomain(TecnologiaDomain tecnoDomain) {
		this.tecnoDomain = tecnoDomain;
	}
	public PaqueteEcoDomain getPaqueEco() {
		return paqueEco;
	}
	public void setPaqueEco(PaqueteEcoDomain paqueEco) {
		this.paqueEco = paqueEco;
	}
	public ViviendaDomain getVivienda() {
		return vivienda;
	}
	public void setVivienda(ViviendaDomain vivienda) {
		this.vivienda = vivienda;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}
