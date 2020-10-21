package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaReasignacionInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>
 * Clase que encapasula los criterios de búsqueda utilzados para la consulta de reasignaciones p
 * para el proceso Inex de unidades de valuación.
 * </p>
 * @author Grupo EonLux
 *
 */
public class CriteriosConsultaReasignacionInexDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6830210181717821447L;
	private String paquete;
	private String rfcOferente;
	private String estado;
	private String fechaReasignacionInicio;
	private String fechaReasignacionFin;
	private int unidadAnterior;
	private int unidadNueva;
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



	public String getFechaReasignacionInicio() {
		return fechaReasignacionInicio;
	}



	public void setFechaReasignacionInicio(String fechaReasignacionInicio) {
		this.fechaReasignacionInicio = fechaReasignacionInicio;
	}



	public String getFechaReasignacionFin() {
		return fechaReasignacionFin;
	}



	public void setFechaReasignacionFin(String fechaReasignacionFin) {
		this.fechaReasignacionFin = fechaReasignacionFin;
	}



	public int getUnidadAnterior() {
		return unidadAnterior;
	}



	public void setUnidadAnterior(int unidadAnterior) {
		this.unidadAnterior = unidadAnterior;
	}



	public int getUnidadNueva() {
		return unidadNueva;
	}



	public void setUnidadNueva(int unidadNueva) {
		this.unidadNueva = unidadNueva;
	}


	public String getTipoPaquete() {
		return tipoPaquete;
	}



	public void setTipoPaquete(String tipoPaquete) {
		this.tipoPaquete = tipoPaquete;
	}



	public static CriteriosConsultaReasignacionInexDomain  getObjetoDomain(ConsultaReasignacionInexForm forma)
	{
		CriteriosConsultaReasignacionInexDomain domain = new CriteriosConsultaReasignacionInexDomain();
		 
	    if( forma.getPaquete()!=null && !forma.getPaquete().trim().equals(""))domain.setPaquete((forma.getPaquete().trim()));
		if( forma.getRfcOferente()!=null && !forma.getRfcOferente().trim().equals(""))domain.setRfcOferente((forma.getRfcOferente().trim().length()==12?" "+forma.getRfcOferente():forma.getRfcOferente().trim()));
		if( forma.getEstado()!=-1)domain.setEstado((forma.getEstado()>=10?String.valueOf(forma.getEstado())+"000":"0"+String.valueOf(forma.getEstado())+"000"));
		if( forma.getFechaReasignacionInicio()!=null && !forma.getFechaReasignacionInicio().trim().equals(""))domain.setFechaReasignacionInicio(Fechas.cambiarFormatoFecha(forma.getFechaReasignacionInicio(),"dd-MM-yyyy","yyyy-MM-dd") );
		if( forma.getFechaReasignacionFin()!=null && !forma.getFechaReasignacionFin().trim().equals(""))domain.setFechaReasignacionFin(Fechas.cambiarFormatoFecha(forma.getFechaReasignacionFin(),"dd-MM-yyyy","yyyy-MM-dd") );
		if( forma.getIdUnidadAnterior()>0 )domain.setUnidadAnterior(forma.getIdUnidadAnterior());
		if( forma.getIdUnidadNueva()>0 )domain.setUnidadNueva(forma.getIdUnidadNueva());
		if( forma.getTipoPaquete()!=-1)domain.setTipoPaquete((forma.getTipoPaquete()==1?"N":"V"));
		
		return domain;
	}

}
