package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaSolicitudesInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosConsultaSolicitudesInex extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6830210181717821447L;
	private String paquete;
	private String rfcOferente;
	private String estado;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	
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
	
	
	public static CriteriosConsultaSolicitudesInex  getObjetoDomain(ConsultaSolicitudesInexForm forma)
	{
		CriteriosConsultaSolicitudesInex domain = new CriteriosConsultaSolicitudesInex();
		 
	    if( forma.getPaquete()!=null && !forma.getPaquete().trim().equals(""))domain.setPaquete((forma.getPaquete().trim()));
		if( forma.getRfcOferente()!=null && !forma.getRfcOferente().trim().equals(""))domain.setRfcOferente((forma.getRfcOferente().trim().length()==12?" "+forma.getRfcOferente():forma.getRfcOferente().trim()));
		if( forma.getIdEstado()!=-1)domain.setEstado((forma.getIdEstado()>=10?String.valueOf(forma.getIdEstado())+"000":"0"+String.valueOf(forma.getIdEstado())+"000"));
		if( forma.getFechaSolicitudInicio()!=null && !forma.getFechaSolicitudInicio().trim().equals(""))domain.setFechaSolicitudInicio(Fechas.cambiarFormatoFecha(forma.getFechaSolicitudInicio(),"dd-MM-yyyy","yyyy-MM-dd") );
		if( forma.getFechaSolicitudFin()!=null && !forma.getFechaSolicitudFin().trim().equals(""))domain.setFechaSolicitudFin(Fechas.cambiarFormatoFecha(forma.getFechaSolicitudFin(),"dd-MM-yyyy","yyyy-MM-dd"));
		
		return domain;
	}

}
