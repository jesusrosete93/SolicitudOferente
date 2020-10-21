package mx.org.infonavit.solicitud.oferente.domain;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class CriteriosConsultaAvaluoDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1348213538996785367L;
	private String claveUnidadValuacion;
	private List<String> unidadesValuacion;
	private String estatusUnidadValuacion;
	private String unidadViviendaRecuperada;
	private List<String> estadosAvaluo;
	private String estatusCobertura;
	private String codigoPostal;
	private String idAvaluo;
	private String idConviviencia;
	private String idPaquete;
	private String viviendaInicio;
	private String viviendaFin;
	private String nss;
	private String fechaSolicitudInicio;
	private String fechaSolicitudFin;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private String valorConcluidoInicio;
	private String valorConcluidoFin;
	private String metrosConstruccionInicio;
	private String metrosConstruccionFin;
	private String metrosTerrenoInicio;
	private String metrosTerrenoFin;
	private String estatusAvaluo;
	private String tipoLinea;
	private String tipoMercado;
	private String claveSHFControlador;
	private String apellidoPaternoControlador;
	private String apellidoMaternoControlador;
	private String nombreControlador;
	private String estatusControlador;
	private String claveSHFPerito;
	private String apellidoPaternoPerito;
	private String apellidoMaternoPerito;
	private String nombrePerito;
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
	 * @return El valor de: estadosAvaluo
	 */
	public List<String> getEstadosAvaluo() {
		return estadosAvaluo;
	}
	/**
	 * @param Valor: estadosCobertura a asignar en: estadosCobertura
	 */
	public void setEstadosAvaluo(List<String> estadosAvaluo) {
		this.estadosAvaluo = estadosAvaluo;
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
	 * @return El valor de: codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param Valor: codigoPostal a asignar en: codigoPostal
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return El valor de: idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}
	/**
	 * @param Valor: idAvaluo a asignar en: idAvaluo
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	/**
	 * @return El valor de: idConviviencia
	 */
	public String getIdConviviencia() {
		return idConviviencia;
	}
	/**
	 * @param Valor: idConviviencia a asignar en: idConviviencia
	 */
	public void setIdConviviencia(String idConviviencia) {
		this.idConviviencia = idConviviencia;
	}
	/**
	 * @return El valor de: idPaquete
	 */
	public String getIdPaquete() {
		return idPaquete;
	}
	/**
	 * @param Valor: idPaquete a asignar en: idPaquete
	 */
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	/**
	 * @return El valor de: viviendaInicio
	 */
	public String getViviendaInicio() {
		return viviendaInicio;
	}
	/**
	 * @param Valor: viviendaInicio a asignar en: viviendaInicio
	 */
	public void setViviendaInicio(String viviendaInicio) {
		this.viviendaInicio = viviendaInicio;
	}
	/**
	 * @return El valor de: viviendaFin
	 */
	public String getViviendaFin() {
		return viviendaFin;
	}
	/**
	 * @param Valor: viviendaFin a asignar en: viviendaFin
	 */
	public void setViviendaFin(String viviendaFin) {
		this.viviendaFin = viviendaFin;
	}
	/**
	 * @return El valor de: nss
	 */
	public String getNss() {
		return nss;
	}
	/**
	 * @param Valor: nss a asignar en: nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}
	/**
	 * @return El valor de: fechaSolicitudInicio
	 */
	public String getFechaSolicitudInicio() {
		return fechaSolicitudInicio;
	}
	/**
	 * @param Valor: fechaSolicitudInicio a asignar en: fechaSolicitudInicio
	 */
	public void setFechaSolicitudInicio(String fechaSolicitudInicio) {
		this.fechaSolicitudInicio = fechaSolicitudInicio;
	}
	/**
	 * @return El valor de: fechaSolicitudFin
	 */
	public String getFechaSolicitudFin() {
		return fechaSolicitudFin;
	}
	/**
	 * @param Valor: fechaSolicitudFin a asignar en: fechaSolicitudFin
	 */
	public void setFechaSolicitudFin(String fechaSolicitudFin) {
		this.fechaSolicitudFin = fechaSolicitudFin;
	}
	/**
	 * @return El valor de: fechaCierreInicio
	 */
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}
	/**
	 * @param Valor: fechaCierreInicio a asignar en: fechaCierreInicio
	 */
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}
	/**
	 * @return El valor de: fechaCierreFin
	 */
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}
	/**
	 * @param Valor: fechaCierreFin a asignar en: fechaCierreFin
	 */
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}
	/**
	 * @return El valor de: valorConcluidoInicio
	 */
	public String getValorConcluidoInicio() {
		return valorConcluidoInicio;
	}
	/**
	 * @param Valor: valorConcluidoInicio a asignar en: valorConcluidoInicio
	 */
	public void setValorConcluidoInicio(String valorConcluidoInicio) {
		this.valorConcluidoInicio = valorConcluidoInicio;
	}
	/**
	 * @return El valor de: valorConcluidoFin
	 */
	public String getValorConcluidoFin() {
		return valorConcluidoFin;
	}
	/**
	 * @param Valor: valorConcluidoFin a asignar en: valorConcluidoFin
	 */
	public void setValorConcluidoFin(String valorConcluidoFin) {
		this.valorConcluidoFin = valorConcluidoFin;
	}
	/**
	 * @return El valor de: metrosConstruccionInicio
	 */
	public String getMetrosConstruccionInicio() {
		return metrosConstruccionInicio;
	}
	/**
	 * @param Valor: metrosConstruccionInicio a asignar en: metrosConstruccionInicio
	 */
	public void setMetrosConstruccionInicio(String metrosConstruccionInicio) {
		this.metrosConstruccionInicio = metrosConstruccionInicio;
	}
	/**
	 * @return El valor de: metrosConstruccionFin
	 */
	public String getMetrosConstruccionFin() {
		return metrosConstruccionFin;
	}
	/**
	 * @param Valor: metrosConstruccionFin a asignar en: metrosConstruccionFin
	 */
	public void setMetrosConstruccionFin(String metrosConstruccionFin) {
		this.metrosConstruccionFin = metrosConstruccionFin;
	}
	/**
	 * @return El valor de: metrosTerrenonicio
	 */
	public String getMetrosTerrenoInicio() {
		return metrosTerrenoInicio;
	}
	/**
	 * @param Valor: metrosTerrenonicio a asignar en: metrosTerrenonicio
	 */
	public void setMetrosTerrenoInicio(String metrosTerrenoInicio) {
		this.metrosTerrenoInicio = metrosTerrenoInicio;
	}
	/**
	 * @return El valor de: metrosTerrenoFin
	 */
	public String getMetrosTerrenoFin() {
		return metrosTerrenoFin;
	}
	/**
	 * @param Valor: metrosTerrenoFin a asignar en: metrosTerrenoFin
	 */
	public void setMetrosTerrenoFin(String metrosTerrenoFin) {
		this.metrosTerrenoFin = metrosTerrenoFin;
	}
	/**
	 * @return El valor de: estatusAvaluo
	 */
	public String getEstatusAvaluo() {
		return estatusAvaluo;
	}
	/**
	 * @param Valor: estatusAvaluo a asignar en: estatusAvaluo
	 */
	public void setEstatusAvaluo(String estatusAvaluo) {
		this.estatusAvaluo = estatusAvaluo;
	}
	/**
	 * @return El valor de: tipoMercado
	 */
	public String getTipoMercado() {
		return tipoMercado;
	}
	/**
	 * @param Valor: tipoMercado a asignar en: tipoMercado
	 */
	public void setTipoMercado(String tipoMercado) {
		this.tipoMercado = tipoMercado;
	}
	/**
	 * @return El valor de: claveShfControlador
	 */
	public String getClaveSHFControlador() {
		return claveSHFControlador;
	}
	/**
	 * @param Valor: claveShfControlador a asignar en: claveShfControlador
	 */
	public void setClaveSHFControlador(String claveShfControlador) {
		this.claveSHFControlador = claveShfControlador;
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
	 * @return El valor de: claveShfPerito
	 */
	public String getClaveSHFPerito() {
		return claveSHFPerito;
	}
	/**
	 * @param Valor: claveShfPerito a asignar en: claveShfPerito
	 */
	public void setClaveSHFPerito(String claveShfPerito) {
		this.claveSHFPerito = claveShfPerito;
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
	/**
	 * @return El valor de: tipoLinea
	 */
	public String getTipoLinea() {
		return tipoLinea;
	}
	/**
	 * @param Valor: tipoLinea a asignar en: tipoLinea
	 */
	public void setTipoLinea(String tipoLinea) {
		this.tipoLinea = tipoLinea;
	}
	/**
	 * @return El valor de: clavesUnidadesValuacion
	 */
	public List<String> getUnidadesValuacion() {
		return unidadesValuacion;
	}
	/**
	 * @param Valor: clavesUnidadesValuacion a asignar en: clavesUnidadesValuacion
	 */
	public void setUnidadesValuacion(List<String> unidadesValuacion) {
		this.unidadesValuacion = unidadesValuacion;
	}
	/**
	 * 
	 * @param forma
	 * @return
	 */
	public static CriteriosConsultaAvaluoDomain getObjetoDomain(ConsultaAvaluosForm forma )
	{
		CriteriosConsultaAvaluoDomain domain = new CriteriosConsultaAvaluoDomain();
		
		if( forma.getUnidadValuacion().getClaveUnidadValuacion()!=0 )
		{
			if( domain.getUnidadesValuacion()==null )
			{
				List<String> elementos = new ArrayList<String>();
				elementos.add(String.valueOf( forma.getUnidadValuacion().getClaveUnidadValuacion()));
				domain.setUnidadesValuacion(elementos);
			}else
			{
				domain.getUnidadesValuacion().add(String.valueOf(forma.getUnidadValuacion().getClaveUnidadValuacion()));
			}
		}
		if( forma.getUnidadValuacion().getNombreUnidadValuacion()==null )
		{
			if( domain.getUnidadesValuacion()==null || domain.getUnidadesValuacion().isEmpty() )
			{
				domain.setUnidadesValuacion(new ArrayList<String>());
			}
		}else
		{
			if( forma.getUnidadValuacion().getNombreUnidadValuacion()!=null && !forma.getUnidadValuacion().getNombreUnidadValuacion().isEmpty() )
			{
				if( domain.getUnidadesValuacion()!=null && !domain.getUnidadesValuacion().isEmpty())
				{
					domain.getUnidadesValuacion().addAll(forma.getUnidadValuacion().getNombreUnidadValuacion());
				}else
				{
					domain.setUnidadesValuacion(forma.getUnidadValuacion().getNombreUnidadValuacion());
				}
			}
		}
		domain.setUnidadViviendaRecuperada(forma.getUnidadValuacion().getUnidadViviendaRecuperada()==-1?"":String.valueOf(forma.getUnidadValuacion().getUnidadViviendaRecuperada()));
		domain.setEstadosAvaluo(forma.getAvaluo().getEstados()==null || forma.getAvaluo().getEstados().isEmpty()?new ArrayList<String>():forma.getAvaluo().getEstados());
		domain.setCodigoPostal(forma.getVivienda().getCodigoPostal()==null?"":forma.getVivienda().getCodigoPostal().trim());
		domain.setIdAvaluo(forma.getAvaluo().getIdAvaluo()==null?"":forma.getAvaluo().getIdAvaluo());
		domain.setIdConviviencia(forma.getAvaluo().getIdConviviencia()==null?"":forma.getAvaluo().getIdConviviencia());
		domain.setIdPaquete(forma.getAvaluo().getPaquete()==null?"":forma.getAvaluo().getPaquete());
		domain.setViviendaInicio(forma.getAvaluo().getViviendaInicio()==0?"":String.valueOf(forma.getAvaluo().getViviendaInicio()));
		domain.setViviendaFin(forma.getAvaluo().getViviendaFin()==0?"":String.valueOf(forma.getAvaluo().getViviendaFin()));
		domain.setNss(forma.getVivienda().getNss()==null?"":forma.getVivienda().getNss());
		domain.setFechaSolicitudInicio(forma.getAvaluo().getFechaSolicitudInicio()==null?"":forma.getAvaluo().getFechaSolicitudInicio());
		domain.setFechaSolicitudFin(forma.getAvaluo().getFechaSolicitudFin()==null?"":forma.getAvaluo().getFechaSolicitudFin());
		domain.setFechaCierreInicio(forma.getAvaluo().getFechaCierreInicio()==null?"":forma.getAvaluo().getFechaCierreInicio());
		domain.setFechaCierreFin(forma.getAvaluo().getFechaCierreFin()==null?"":forma.getAvaluo().getFechaCierreFin());
		domain.setValorConcluidoInicio(forma.getDetalleAvaluo().getValorConcluidoInicio()==null?"":forma.getDetalleAvaluo().getValorConcluidoInicio());
		domain.setValorConcluidoFin(forma.getDetalleAvaluo().getValorConcluidoFin()==null?"":forma.getDetalleAvaluo().getValorConcluidoFin());
		domain.setMetrosConstruccionInicio(forma.getDetalleAvaluo().getMetrosConstruccionInicio()==null?"":forma.getDetalleAvaluo().getMetrosConstruccionInicio());
		domain.setMetrosConstruccionFin(forma.getDetalleAvaluo().getMetrosConstruccionFin()==null?"":forma.getDetalleAvaluo().getMetrosConstruccionFin());
		domain.setMetrosTerrenoInicio(forma.getDetalleAvaluo().getMetrosTerrenoInicio()==null?"":forma.getDetalleAvaluo().getMetrosTerrenoInicio());
		domain.setMetrosTerrenoFin(forma.getDetalleAvaluo().getMetrosTerrenoFin()==null?"":forma.getDetalleAvaluo().getMetrosTerrenoFin());
		domain.setEstatusAvaluo(forma.getAvaluo().getEstatusAvaluo()==-1?"":String.valueOf(forma.getAvaluo().getEstatusAvaluo()));
		
		switch( forma.getAvaluo().getTipoMercado() )
		{
		case -1:
				domain.setTipoMercado("");    
				domain.setTipoLinea("");
			    break;
		case 1:	
				domain.setTipoMercado("1");
				domain.setTipoLinea("2");
			    break;
		case 2:	
				domain.setTipoMercado("2");
				domain.setTipoLinea("2");
				break;
		case 3:	
				domain.setTipoMercado("2");
				domain.setTipoLinea("3");
				break;
		default:
				domain.setTipoMercado("");
				domain.setTipoLinea("");
	    	 	break;
		}
		domain.setClaveSHFControlador(forma.getControlador().getClaveSHF()==null?"":forma.getControlador().getClaveSHF());
		domain.setApellidoPaternoControlador(forma.getControlador().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getControlador().getApellidoPaterno().trim());
		domain.setApellidoMaternoControlador(forma.getControlador().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getControlador().getApellidoMaterno().trim());
		domain.setNombreControlador(forma.getControlador().getNombre().trim().equals("NOMBRE")?"":forma.getControlador().getNombre().trim());
		domain.setEstatusControlador(forma.getControlador().getEstatusControlador()==-1?"":String.valueOf(forma.getControlador().getEstatusControlador()));
		domain.setClaveSHFPerito(forma.getPerito().getClaveSHF()==null?"":forma.getPerito().getClaveSHF());
		domain.setApellidoPaternoPerito(forma.getPerito().getApellidoPaterno().trim().equals("PATERNO")?"":forma.getPerito().getApellidoPaterno().trim());
		domain.setApellidoMaternoPerito(forma.getPerito().getApellidoMaterno().trim().equals("MATERNO")?"":forma.getPerito().getApellidoMaterno().trim());
		domain.setNombrePerito(forma.getPerito().getNombre().trim().equals("NOMBRE")?"":forma.getPerito().getNombre());
		domain.setEstatusPerito(forma.getPerito().getEstatusPerito()==-1?"":String.valueOf(forma.getPerito().getEstatusPerito()));
		return domain;
	}

}

