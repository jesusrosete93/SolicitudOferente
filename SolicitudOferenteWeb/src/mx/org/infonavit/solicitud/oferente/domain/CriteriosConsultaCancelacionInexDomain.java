package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaCancelacionInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosConsultaCancelacionInexDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6830210181717821447L;
	private String paquete;
	private String rfcOferente;
	private String estado;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String fechaCancelacionInicio;
	private String fechaCancelacionFin;
	private String tipoPaquete;
	
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getRfcOferente() {
		return rfcOferente;
	}
	public void setRfcOferente(String rfcOferente) {
		this.rfcOferente = rfcOferente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaSolicitudInicio() {
		return fechaSolicitudInicio;
	}
	public void setFechaSolicitudInicio(String fechaSolicitudInicio) {
		this.fechaSolicitudInicio = fechaSolicitudInicio;
	}
	public String getFechaSolicitudFin() {
		return fechaSolicitudFin;
	}
	public void setFechaSolicitudFin(String fechaSolicitudFin) {
		this.fechaSolicitudFin = fechaSolicitudFin;
	}
	
	
	public String getFechaCancelacionInicio() {
		return fechaCancelacionInicio;
	}
	public void setFechaCancelacionInicio(String fechaCancelacionInicio) {
		this.fechaCancelacionInicio = fechaCancelacionInicio;
	}
	public String getFechaCancelacionFin() {
		return fechaCancelacionFin;
	}
	public void setFechaCancelacionFin(String fechaCancelacionFin) {
		this.fechaCancelacionFin = fechaCancelacionFin;
	}
	public String getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	public static CriteriosConsultaCancelacionInexDomain  getObjetoDomain(ConsultaCancelacionInexForm forma)
	{
		CriteriosConsultaCancelacionInexDomain domain = new CriteriosConsultaCancelacionInexDomain();
		 
	    if( forma.getPaquete()!=null && !forma.getPaquete().trim().equals(""))domain.setPaquete((forma.getPaquete().trim()));
		if( forma.getRfcOferente()!=null && !forma.getRfcOferente().trim().equals(""))domain.setRfcOferente((forma.getRfcOferente().trim().length()==12?" "+forma.getRfcOferente():forma.getRfcOferente().trim()));
		if( forma.getEstado()!=-1)domain.setEstado((forma.getEstado()>=10?String.valueOf(forma.getEstado())+"000":"0"+String.valueOf(forma.getEstado())+"000"));
		if( forma.getFechaSolicitudInicio()!=null && !forma.getFechaSolicitudInicio().trim().equals(""))domain.setFechaSolicitudInicio(Fechas.cambiarFormatoFecha(forma.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd") );
		if( forma.getFechaSolicitudFin()!=null && !forma.getFechaSolicitudFin().trim().equals(""))domain.setFechaSolicitudFin(Fechas.cambiarFormatoFecha(forma.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd"));
		if( forma.getFechaCancelacionInicio()!=null && !forma.getFechaCancelacionInicio().trim().equals(""))domain.setFechaCancelacionInicio(Fechas.cambiarFormatoFecha(forma.getFechaCancelacionInicio(),"dd-MM-yyyy","yyyy-MM-dd") );
		if( forma.getFechaCancelacionFin()!=null && !forma.getFechaCancelacionFin().trim().equals(""))domain.setFechaCancelacionFin(Fechas.cambiarFormatoFecha(forma.getFechaCancelacionFin(),"dd-MM-yyyy","yyyy-MM-dd"));
		if( forma.getTipoPaquete()!=-1)domain.setTipoPaquete((forma.getTipoPaquete()==1?"N":"V"));
		
		return domain;
	}

}
