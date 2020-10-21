package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.PaquetesForm;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>
 * 	Clase que encapsula los criterios de búsqueda para la consulta de paquetes.
 * </p> 
 * @author Adrian Casas
 */
public class CriteriosConsultaPaquetesDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6351680130836002882L;
	private String unidadValuacion;
	private String rfcOferente;
	private String estado;
	private String paquete;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String tipoPaquete;
	
	
	private CriteriosConsultaPaquetesDomain(Builder builder) {
		this.unidadValuacion=builder.getUnidadValuacion();
		this.rfcOferente=builder.getRfcOferente();
		this.estado=builder.getEstado();
		this.paquete=builder.getPaquete();
		this.fechaSolicitudInicio=builder.getFechaSolicitudInicio();
		this.fechaSolicitudFin=builder.getFechaSolicitudFin();
		this.tipoPaquete=builder.getTipoPaquete();
	}
	public String getUnidadValuacion() {
		return unidadValuacion;
	}
	public void setIdUnidadValuacion(String unidadValuacion) {
		this.unidadValuacion = unidadValuacion;
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
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
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
	public String getTipoPaquete() {
		return tipoPaquete;
	}
	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}
	
	public static class Builder 
	{
		private String unidadValuacion;
		private String rfcOferente;
		private String estado;
		private String paquete;
		private String fechaSolicitudInicio;
		private String fechaSolicitudFin;
		private String tipoPaquete;
		
		
		public Builder setUnidadValuacion(String unidadValuacion) {
			this.unidadValuacion = unidadValuacion;
			return this;
		}
		public Builder setRfcOferente(String rfcOferente) {
			this.rfcOferente = rfcOferente;
			return this;
		}
		public Builder setEstado(String estado) {
			this.estado = estado;
			return this;
		}
		public Builder setPaquete(String paquete) {
			this.paquete = paquete;
			return this;
		}
		public Builder setFechaSolicitudInicio(String fechaSolicitudInicio) {
			this.fechaSolicitudInicio = fechaSolicitudInicio;
			return this;
		}
		public Builder setFechaSolicitudFin(String fechaSolicitudFin) {
			this.fechaSolicitudFin = fechaSolicitudFin;
			return this;
		}
		public Builder setTipoPaquete(String tipoPaquete) {
			this.tipoPaquete = tipoPaquete;
			return this;
		}
		public String getUnidadValuacion() {
			return unidadValuacion;
		}
		public String getRfcOferente() {
			return rfcOferente;
		}
		public String getEstado() {
			return estado;
		}
		public String getPaquete() {
			return paquete;
		}
		public String getFechaSolicitudInicio() {
			return fechaSolicitudInicio;
		}
		public String getFechaSolicitudFin() {
			return fechaSolicitudFin;
		}
		public String getTipoPaquete() {
			return tipoPaquete;
		}
		public CriteriosConsultaPaquetesDomain build() {
			return new CriteriosConsultaPaquetesDomain(this);
		}
	}
	
		
	/**
	 * <p>
	 * Método que obtiene el objeto {@link CriteriosConsultaPaquetesDomain} a partir del
	 * objeto {@link PaquetesForm} para generar los criterios de búsqueda aplicandoles el formato correspondiente
	 *  </p>
	 * @param forma objeto que contiene los criterios capturados por el usuario
	 * @return objeto de dominio con los criterios utilizados en el proceso de consulta
	 */
	public static CriteriosConsultaPaquetesDomain getDomain(PaquetesForm forma)
	{
		Builder builder = new Builder();
		if( forma.getIdUnidadValuacion()!=-1)builder.setUnidadValuacion(String.valueOf(forma.getIdUnidadValuacion()));
		if( forma.getRfcOferente()!=null && !forma.getRfcOferente().trim().equals(""))builder.setRfcOferente((forma.getRfcOferente().trim().length()==12?" "+forma.getRfcOferente():forma.getRfcOferente().trim()));
		if( forma.getIdEstado()!=-1)builder.setEstado((forma.getIdEstado()>=10?String.valueOf(forma.getIdEstado())+"000":"0"+String.valueOf(forma.getIdEstado())+"000"));
		if( forma.getPaquete()!=null && forma.getPaquete().trim().matches("[0-9]{16}"))builder.setPaquete(forma.getPaquete().trim());
		if( forma.getTipoPaquete()!=-1)builder.setTipoPaquete((forma.getTipoPaquete()==1?"N":"V"));
		return builder.build();
	}

	

}
