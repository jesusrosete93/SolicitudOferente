package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaSancionesForm;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosSancionesDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7530436808607362876L;
	private String claveUnidadValuacion;
	private String nombreUnidadValuacion;
	private String claveSHFUnidadValuacion;
	private String siglasUnidadValuacion;
	private String claveEstadoCobertura;
	private String claveSHFControlador;
	private String nombreControlador;
	private String apellidoPaternoControlador;
	private String apellidoMaternoControlador;
	private String claveSHFPerito;
	private String nombrePerito;
	private String apellidoPaternoPerito;
	private String apellidoMaternoPerito;
	private String fechaSancionInicio;
	private String fechaSancionFin;
	private String tipoSancion;
	private String sancionado;
	private String estatusSancion;
	
	
	/**
	 * @return El valor de: claveUnidadValuacion
	 */
	public String getClaveUnidadValuacion() {
		return claveUnidadValuacion;
	}
	/**
	 * @param Valor: claveUnidadValuacion a asignar en: claveUnidadValuacion
	 */
	public void setClaveUnidadValuacion(String claveUnidadValuacion) {
		this.claveUnidadValuacion = claveUnidadValuacion;
	}
	/**
	 * @return El valor de: nombreUnidadValuacion
	 */
	public String getNombreUnidadValuacion() {
		return nombreUnidadValuacion;
	}
	/**
	 * @param Valor: nombreUnidadValuacion a asignar en: nombreUnidadValuacion
	 */
	public void setNombreUnidadValuacion(String nombreUnidadValuacion) {
		this.nombreUnidadValuacion = nombreUnidadValuacion;
	}
	/**
	 * @return El valor de: claveSHFUnidadValuacion
	 */
	public String getClaveSHFUnidadValuacion() {
		return claveSHFUnidadValuacion;
	}
	/**
	 * @param Valor: claveSHFUnidadValuacion a asignar en: claveSHFUnidadValuacion
	 */
	public void setClaveSHFUnidadValuacion(String claveSHFUnidadValuacion) {
		this.claveSHFUnidadValuacion = claveSHFUnidadValuacion;
	}
	/**
	 * @return El valor de: siglasUnidadValuacion
	 */
	public String getSiglasUnidadValuacion() {
		return siglasUnidadValuacion;
	}
	/**
	 * @param Valor: siglasUnidadValuacion a asignar en: siglasUnidadValuacion
	 */
	public void setSiglasUnidadValuacion(String siglasUnidadValuacion) {
		this.siglasUnidadValuacion = siglasUnidadValuacion;
	}
	/**
	 * @return El valor de: claveEstadoCobertura
	 */
	public String getClaveEstadoCobertura() {
		
		String regreso = "";
		
		if( this.claveEstadoCobertura!=null && !this.claveEstadoCobertura.trim().equals(""))
		{
			if( Integer.parseInt(this.claveEstadoCobertura)>=1 && Integer.parseInt(this.claveEstadoCobertura)<=9)
			{
				regreso = "0"+this.claveEstadoCobertura+"000";
			}
			if( Integer.parseInt(this.claveEstadoCobertura)>=10 && Integer.parseInt(this.claveEstadoCobertura)<=32)
			{
				regreso = this.claveEstadoCobertura+"000";
			}
		}
		
		return regreso;
	}
	/**
	 * @param Valor: claveEstadoCobertura a asignar en: claveEstadoCobertura
	 */
	public void setClaveEstadoCobertura(String claveEstadoCobertura) {
		this.claveEstadoCobertura = claveEstadoCobertura;
	}
	/**
	 * @return El valor de: claveSHFControlador
	 */
	public String getClaveSHFControlador() {
		return claveSHFControlador;
	}
	/**
	 * @param Valor: claveSHFControlador a asignar en: claveSHFControlador
	 */
	public void setClaveSHFControlador(String claveSHFControlador) {
		this.claveSHFControlador = claveSHFControlador;
	}
	/**
	 * @return El valor de: nombreControlador
	 */
	public String getNombreControlador() {
		return nombreControlador;
	}
	/**
	 * @param Valor: nombreControlador a asignar en: nombreControlador
	 */
	public void setNombreControlador(String nombreControlador) {
		this.nombreControlador = nombreControlador;
	}
	/**
	 * @return El valor de: apellidoPaternoControlador
	 */
	public String getApellidoPaternoControlador() {
		return apellidoPaternoControlador;
	}
	/**
	 * @param Valor: apellidoPaternoControlador a asignar en: apellidoPaternoControlador
	 */
	public void setApellidoPaternoControlador(String apellidoPaternoControlador) {
		this.apellidoPaternoControlador = apellidoPaternoControlador;
	}
	/**
	 * @return El valor de: apellidoMaternoControlador
	 */
	public String getApellidoMaternoControlador() {
		return apellidoMaternoControlador;
	}
	/**
	 * @param Valor: apellidoMaternoControlador a asignar en: apellidoMaternoControlador
	 */
	public void setApellidoMaternoControlador(String apellidoMaternoControlador) {
		this.apellidoMaternoControlador = apellidoMaternoControlador;
	}
	/**
	 * @return El valor de: claveSHFPerito
	 */
	public String getClaveSHFPerito() {
		return claveSHFPerito;
	}
	/**
	 * @param Valor: claveSHFPerito a asignar en: claveSHFPerito
	 */
	public void setClaveSHFPerito(String claveSHFPerito) {
		this.claveSHFPerito = claveSHFPerito;
	}
	/**
	 * @return El valor de: nombrePerito
	 */
	public String getNombrePerito() {
		return nombrePerito;
	}
	/**
	 * @param Valor: nombrePerito a asignar en: nombrePerito
	 */
	public void setNombrePerito(String nombrePerito) {
		this.nombrePerito = nombrePerito;
	}
	/**
	 * @return El valor de: apellidoPaternoPerito
	 */
	public String getApellidoPaternoPerito() {
		return apellidoPaternoPerito;
	}
	/**
	 * @param Valor: apellidoPaternoPerito a asignar en: apellidoPaternoPerito
	 */
	public void setApellidoPaternoPerito(String apellidoPaternoPerito) {
		this.apellidoPaternoPerito = apellidoPaternoPerito;
	}
	/**
	 * @return El valor de: apellidoMaternoPerito
	 */
	public String getApellidoMaternoPerito() {
		return apellidoMaternoPerito;
	}
	/**
	 * @param Valor: apellidoMaternoPerito a asignar en: apellidoMaternoPerito
	 */
	public void setApellidoMaternoPerito(String apellidoMaternoPerito) {
		this.apellidoMaternoPerito = apellidoMaternoPerito;
	}
	/**
	 * @return El valor de: fechaSancionInicio
	 */
	public String getFechaSancionInicio() {
		return fechaSancionInicio;
	}
	/**
	 * @param Valor: fechaSancionInicio a asignar en: fechaSancionInicio
	 */
	public void setFechaSancionInicio(String fechaSancionInicio) {
		this.fechaSancionInicio = fechaSancionInicio;
	}
	/**
	 * @return El valor de: fechaSancionFin
	 */
	public String getFechaSancionFin() {
		return fechaSancionFin;
	}
	/**
	 * @param Valor: fechaSancionFin a asignar en: fechaSancionFin
	 */
	public void setFechaSancionFin(String fechaSancionFin) {
		this.fechaSancionFin = fechaSancionFin;
	}
	/**
	 * @return El valor de: tipoSancion
	 */
	public String getTipoSancion() {
		return tipoSancion;
	}
	/**
	 * @param Valor: tipoSancion a asignar en: tipoSancion
	 */
	public void setTipoSancion(String tipoSancion) {
		this.tipoSancion = tipoSancion;
	}
	/**
	 * @return El valor de: sancionando
	 */
	public String getSancionado() {
		return sancionado;
	}
	/**
	 * @param Valor: sancionando a asignar en: sancionando
	 */
	public void setSancionando(String sancionado) {
		this.sancionado = sancionado;
	}
	/**
	 * @return El valor de: estatusSancion
	 */
	public String getEstatusSancion() {
		return estatusSancion;
	}
	/**
	 * @param Valor: estatusSancion a asignar en: estatusSancion
	 */
	public void setEstatusSancion(String estatusSancion) {
		this.estatusSancion = estatusSancion;
	}
	
	
	public static CriteriosSancionesDomain getObjetoDomain(ConsultaSancionesForm forma)
	{
		CriteriosSancionesDomain domain = new CriteriosSancionesDomain();
		domain.setClaveUnidadValuacion(String.valueOf(forma.getUnidad().getClaveUnidadValuacion()==0?"":forma.getUnidad().getClaveUnidadValuacion()));
		if( forma.getUnidad().getNombreUnidadValuacion()==null || forma.getUnidad().getNombreUnidadValuacion().isEmpty() )
		{
			domain.setNombreUnidadValuacion("");
		}else
		{
			if( forma.getUnidad().getNombreUnidadValuacion()!=null && !forma.getUnidad().getNombreUnidadValuacion().isEmpty() )
			{
				if( forma.getUnidad().getNombreUnidadValuacion().size()==1 && forma.getUnidad().getNombreUnidadValuacion().get(0).trim().equals(""))
				{
					domain.setNombreUnidadValuacion("");
				}else
				{
					domain.setNombreUnidadValuacion(forma.getUnidad().getNombreUnidadValuacion().toString());
				}
			}
		}
		domain.setClaveSHFUnidadValuacion(forma.getUnidad().getClaveSHF());
		domain.setSiglasUnidadValuacion(forma.getUnidad().getSiglas());
		domain.setClaveEstadoCobertura(forma.getCobertura().getEstados().isEmpty()?"":forma.getCobertura().getEstados().toString());
		domain.setClaveSHFControlador(forma.getControlador().getClaveSHF());
		domain.setNombreControlador(forma.getControlador().getNombre().trim().equals("NOMBRE")?"":forma.getControlador().getNombre().trim());
		domain.setApellidoPaternoControlador(forma.getControlador().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getControlador().getApellidoPaterno().trim());
		domain.setApellidoMaternoControlador(forma.getControlador().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getControlador().getApellidoMaterno().trim());
		domain.setClaveSHFPerito(forma.getPerito().getClaveSHF());
		domain.setNombrePerito(forma.getPerito().getNombre().trim().equals("NOMBRE")?"":forma.getPerito().getNombre().trim());
		domain.setApellidoPaternoPerito(forma.getPerito().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getPerito().getApellidoPaterno().trim());
		domain.setApellidoMaternoPerito(forma.getPerito().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getPerito().getApellidoMaterno().trim());
		domain.setFechaSancionInicio(forma.getSancion().getFechaSancionInicio().trim());
		domain.setFechaSancionFin(forma.getSancion().getFechaSancionFin().trim());
		domain.setTipoSancion(forma.getSancion().getTipoSancion()==-1?"":String.valueOf(forma.getSancion().getTipoSancion()));
		domain.setSancionando(forma.getSancion().getSancionado()==-1?"":String.valueOf(forma.getSancion().getSancionado()));
		domain.setEstatusSancion(forma.getSancion().getEstatusSancion()==-1?"":String.valueOf(forma.getSancion().getEstatusSancion()));
		
		return domain;
	}

}
