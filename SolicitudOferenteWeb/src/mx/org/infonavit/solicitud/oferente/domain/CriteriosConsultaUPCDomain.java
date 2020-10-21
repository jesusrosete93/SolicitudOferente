package mx.org.infonavit.solicitud.oferente.domain;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaUPCForm;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosConsultaUPCDomain extends GenericValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6050523120469578513L;
	private String claveUnidadValuacion;
	private List<String> unidadesValuacion;
	private String estatusUnidadValuacion;
	private String fechaVigenciaInicioUnidadValacion;
	private String fechaVigenciaFinUnidadValuacion;
	private String claveSHFUnidadValuacion;
	private String siglasUnidadValuacion;
	private String unidadViviendaRecuperada;
	private List<String> estadosCobertura;
	private String estatusCobertura;
	private String claveSHFControlador;
	private String nombreControlador;
	private String apellidoPaternoControlador;
	private String apellidoMaternoControlador;
	private String curpControlador;
	private String rfcControlador;
	private String fechaVigenciaInicioControlador;
	private String fechaVigenciaFinControlador;
	private String estatusControlador;
	private String claveSHFPerito;
	private String nombrePerito;
	private String apellidoPaternoPerito;
	private String apellidoMaternoPerito;
	private String curpPerito;
	private String rfcPerito;
	private String fechaVigenciaInicioPerito;
	private String fechaVigenciaFinPerito;
	private String estatusPerito;
	
	
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
	public List<String> getUnidadesValuacion() {
		return unidadesValuacion;
	}
	/**
	 * @param Valor: nombreUnidadValuacion a asignar en: nombreUnidadValuacion
	 */
	public void setUnidadesValuacion(List<String> unidadesValuacion) {
		this.unidadesValuacion = unidadesValuacion;
	}
	/**
	 * @return El valor de: estatusUnidadValuacion
	 */
	public String getEstatusUnidadValuacion() {
		return estatusUnidadValuacion;
	}
	/**
	 * @param Valor: estatusUnidadValuacion a asignar en: estatusUnidadValuacion
	 */
	public void setEstatusUnidadValuacion(String estatusUnidadValuacion) {
		this.estatusUnidadValuacion = estatusUnidadValuacion;
	}
	/**
	 * @return El valor de: fechaVigenciaInicioUnidadValacion
	 */
	public String getFechaVigenciaInicioUnidadValacion() {
		return fechaVigenciaInicioUnidadValacion;
	}
	/**
	 * @param Valor: fechaVigenciaInicioUnidadValacion a asignar en: fechaVigenciaInicioUnidadValacion
	 */
	public void setFechaVigenciaInicioUnidadValacion(
			String fechaVigenciaInicioUnidadValacion) {
		this.fechaVigenciaInicioUnidadValacion = fechaVigenciaInicioUnidadValacion;
	}
	/**
	 * @return El valor de: fechaVigenciaFinUnidadValuacion
	 */
	public String getFechaVigenciaFinUnidadValuacion() {
		return fechaVigenciaFinUnidadValuacion;
	}
	/**
	 * @param Valor: fechaVigenciaFinUnidadValuacion a asignar en: fechaVigenciaFinUnidadValuacion
	 */
	public void setFechaVigenciaFinUnidadValuacion(
			String fechaVigenciaFinUnidadValuacion) {
		this.fechaVigenciaFinUnidadValuacion = fechaVigenciaFinUnidadValuacion;
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
	 * @return El valor de: unidadViviendaRecuperada
	 */
	public String getUnidadViviendaRecuperada() {
		return unidadViviendaRecuperada;
	}
	/**
	 * @param Valor: unidadViviendaRecuperada a asignar en: unidadViviendaRecuperada
	 */
	public void setUnidadViviendaRecuperada(String unidadViviendaRecuperada) {
		this.unidadViviendaRecuperada = unidadViviendaRecuperada;
	}
	
	
	/**
	 * @return El valor de: estadosCobertura
	 */
	public List<String> getEstadosCobertura() {
		return estadosCobertura;
	}
	/**
	 * @param Valor: estadosCobertura a asignar en: estadosCobertura
	 */
	public void setEstadosCobertura(List<String> estadosCobertura) {
		this.estadosCobertura = estadosCobertura;
	}
	/**
	 * @return El valor de: estatusCobertura
	 */
	public String getEstatusCobertura() {
		return estatusCobertura;
	}
	/**
	 * @param Valor: estatusCobertura a asignar en: estatusCobertura
	 */
	public void setEstatusCobertura(String estatusCobertura) {
		this.estatusCobertura = estatusCobertura;
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
	 * @return El valor de: curpControlador
	 */
	public String getCurpControlador() {
		return curpControlador;
	}
	/**
	 * @param Valor: curpControlador a asignar en: curpControlador
	 */
	public void setCurpControlador(String curpControlador) {
		this.curpControlador = curpControlador;
	}
	/**
	 * @return El valor de: rfcControlador
	 */
	public String getRfcControlador() {
		return rfcControlador;
	}
	/**
	 * @param Valor: rfcControlador a asignar en: rfcControlador
	 */
	public void setRfcControlador(String rfcControlador) {
		this.rfcControlador = rfcControlador;
	}
	/**
	 * @return El valor de: fechaVigenciaInicioControlador
	 */
	public String getFechaVigenciaInicioControlador() {
		return fechaVigenciaInicioControlador;
	}
	/**
	 * @param Valor: fechaVigenciaInicioControlador a asignar en: fechaVigenciaInicioControlador
	 */
	public void setFechaVigenciaInicioControlador(
			String fechaVigenciaInicioControlador) {
		this.fechaVigenciaInicioControlador = fechaVigenciaInicioControlador;
	}
	/**
	 * @return El valor de: fechaVigenciaFinControlador
	 */
	public String getFechaVigenciaFinControlador() {
		return fechaVigenciaFinControlador;
	}
	/**
	 * @param Valor: fechaVigenciaFinControlador a asignar en: fechaVigenciaFinControlador
	 */
	public void setFechaVigenciaFinControlador(String fechaVigenciaFinControlador) {
		this.fechaVigenciaFinControlador = fechaVigenciaFinControlador;
	}
	/**
	 * @return El valor de: estatusControlador
	 */
	public String getEstatusControlador() {
		return estatusControlador;
	}
	/**
	 * @param Valor: estatusControlador a asignar en: estatusControlador
	 */
	public void setEstatusControlador(String estatusControlador) {
		this.estatusControlador = estatusControlador;
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
	 * @return El valor de: curpPerito
	 */
	public String getCurpPerito() {
		return curpPerito;
	}
	/**
	 * @param Valor: curpPerito a asignar en: curpPerito
	 */
	public void setCurpPerito(String curpPerito) {
		this.curpPerito = curpPerito;
	}
	/**
	 * @return El valor de: rfcPerito
	 */
	public String getRfcPerito() {
		return rfcPerito;
	}
	/**
	 * @param Valor: rfcPerito a asignar en: rfcPerito
	 */
	public void setRfcPerito(String rfcPerito) {
		this.rfcPerito = rfcPerito;
	}
	/**
	 * @return El valor de: fechaVigenciaInicioPerito
	 */
	public String getFechaVigenciaInicioPerito() {
		return fechaVigenciaInicioPerito;
	}
	/**
	 * @param Valor: fechaVigenciaInicioPerito a asignar en: fechaVigenciaInicioPerito
	 */
	public void setFechaVigenciaInicioPerito(String fechaVigenciaInicioPerito) {
		this.fechaVigenciaInicioPerito = fechaVigenciaInicioPerito;
	}
	/**
	 * @return El valor de: fechaVigenciaFinPerito
	 */
	public String getFechaVigenciaFinPerito() {
		return fechaVigenciaFinPerito;
	}
	/**
	 * @param Valor: fechaVigenciaFinPerito a asignar en: fechaVigenciaFinPerito
	 */
	public void setFechaVigenciaFinPerito(String fechaVigenciaFinPerito) {
		this.fechaVigenciaFinPerito = fechaVigenciaFinPerito;
	}
	/**
	 * @return El valor de: estatusPerito
	 */
	public String getEstatusPerito() {
		return estatusPerito;
	}
	/**
	 * @param Valor: estatusPerito a asignar en: estatusPerito
	 */
	public void setEstatusPerito(String estatusPerito) {
		this.estatusPerito = estatusPerito;
	}
	
	public static CriteriosConsultaUPCDomain getObjetoDomain(ConsultaUPCForm forma)
	{
		CriteriosConsultaUPCDomain domain = new CriteriosConsultaUPCDomain();
		
		if( forma.getUnidadValuacionForm().getClaveUnidadValuacion()!=0 )
		{
			if( domain.getUnidadesValuacion()==null )
			{
				List<String> elementos = new ArrayList<String>();
				elementos.add(String.valueOf( forma.getUnidadValuacionForm().getClaveUnidadValuacion()));
				domain.setUnidadesValuacion(elementos);
			}else
			{
				domain.getUnidadesValuacion().add(String.valueOf(forma.getUnidadValuacionForm().getClaveUnidadValuacion()));
			}
		}
			
		
		if( forma.getUnidadValuacionForm().getNombreUnidadValuacion()==null )
		{
			if( domain.getUnidadesValuacion()==null || domain.getUnidadesValuacion().isEmpty() )
			{
				domain.setUnidadesValuacion(new ArrayList<String>());
			}
		}else
		{
			if( forma.getUnidadValuacionForm().getNombreUnidadValuacion()!=null && !forma.getUnidadValuacionForm().getNombreUnidadValuacion().isEmpty() )
			{
				if( domain.getUnidadesValuacion()!=null && !domain.getUnidadesValuacion().isEmpty())
				{
					domain.getUnidadesValuacion().addAll(forma.getUnidadValuacionForm().getNombreUnidadValuacion());
				}else
				{
					domain.setUnidadesValuacion(forma.getUnidadValuacionForm().getNombreUnidadValuacion());
				}
			}
		}
		
		domain.setEstatusUnidadValuacion(String.valueOf(forma.getUnidadValuacionForm().getEstatusUnidadValuacion()<0?"":forma.getUnidadValuacionForm().getEstatusUnidadValuacion()));
		domain.setFechaVigenciaInicioUnidadValacion(forma.getUnidadValuacionForm().getFechaVigenciaInicio());
		domain.setFechaVigenciaFinUnidadValuacion(forma.getUnidadValuacionForm().getFechaVigenciaFin());
		domain.setClaveSHFUnidadValuacion(forma.getUnidadValuacionForm().getClaveSHF());
		domain.setSiglasUnidadValuacion(forma.getUnidadValuacionForm().getSiglas());
		domain.setUnidadViviendaRecuperada(String.valueOf(forma.getUnidadValuacionForm().getUnidadViviendaRecuperada()<0?"":forma.getUnidadValuacionForm().getUnidadViviendaRecuperada()));
		domain.setEstatusCobertura(String.valueOf(forma.getCoberturaForm().getEstatus()<0?"":forma.getCoberturaForm().getEstatus()));
		domain.setEstadosCobertura(( forma.getCoberturaForm().getEstados()==null || forma.getCoberturaForm().getEstados().isEmpty() )?new ArrayList<String>():forma.getCoberturaForm().getEstados());
		domain.setClaveSHFControlador(forma.getControladorForm().getClaveSHF());
		domain.setNombreControlador(forma.getControladorForm().getNombre().trim().equals("NOMBRE")?"":forma.getControladorForm().getNombre().trim());
		domain.setApellidoPaternoControlador(forma.getControladorForm().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getControladorForm().getApellidoPaterno().trim());
		domain.setApellidoMaternoControlador(forma.getControladorForm().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getControladorForm().getApellidoMaterno().trim());
		domain.setCurpControlador(forma.getControladorForm().getCurp());
		domain.setRfcControlador(forma.getControladorForm().getRfc());
		domain.setFechaVigenciaInicioControlador(forma.getControladorForm().getFechaVigenciaInicio());
		domain.setFechaVigenciaFinControlador(forma.getControladorForm().getFechaVigenciaFin());
		domain.setEstatusControlador(String.valueOf(forma.getControladorForm().getEstatusControlador()<0?"":forma.getControladorForm().getEstatusControlador()));
		domain.setClaveSHFPerito(forma.getPeritoForm().getClaveSHF());
		domain.setNombrePerito(forma.getPeritoForm().getNombre().trim().equals("NOMBRE")?"":forma.getPeritoForm().getNombre().trim());
		domain.setApellidoPaternoPerito(forma.getPeritoForm().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getPeritoForm().getApellidoPaterno().trim());
		domain.setApellidoMaternoPerito(forma.getPeritoForm().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getPeritoForm().getApellidoMaterno().trim());
		domain.setCurpPerito(forma.getPeritoForm().getCurp());
		domain.setRfcPerito(forma.getPeritoForm().getRfc());
		domain.setFechaVigenciaInicioPerito(forma.getPeritoForm().getFechaVigenciaInicio());
		domain.setFechaVigenciaFinPerito(forma.getPeritoForm().getFechaVigenciaFin());
		domain.setEstatusPerito(String.valueOf(forma.getPeritoForm().getEstatusPerito()<0?"":forma.getPeritoForm().getEstatusPerito()));
		return domain;
	}
		
}
