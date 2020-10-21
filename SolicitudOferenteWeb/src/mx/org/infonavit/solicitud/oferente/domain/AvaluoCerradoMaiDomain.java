package mx.org.infonavit.solicitud.oferente.domain;

import java.io.StringWriter;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;


public class AvaluoCerradoMaiDomain extends GenericValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7163401415580037508L;
	
	@Element(name="FOLIO_CONTROL")
	private String folioControl;
	
	@Element(name="FECHA_ENTREGA")
	private String fechaEntrega;
	
	
	@Element(name="UNIDAD_VALUACION")
	private String idUv;
	
	@Element(name="FOLIO_AVALUO")
	private String idAvaluo;
	
	@Element(name="ESTATUS_AVALUO")
	private String idEstatus;
	
	@Element(name="FECHA_CIERRE_AVALUO")
	private String fechaCierre;
	
	@Element(name="FECHA_VISITA")
	private String fechaVisitaInmueble;
	
	@Element(name="VIV_REC")
	private String viviendaRecuperada;
	
	@Element(name="TIPO_VIVIENDA")
	private String idTipoInmuebleValuado;
	
	@Element(name="ESTADO")
	private String estado;
	
	@Element(name="LOCALIDAD_POBLACION")
	private String localidad;
	
	@Element(name="DELEGACION_MUNICIPIO")
	private String idMunicipio;
	
	@Element(name="CODIGO_POSTAL")
	private String codigoPostal;
	
	@Element(name="COLONIA")
	private String colonia;
	
	@Element(name="CALLE")
	private String calle;
	
	@Element(name="NOMBRE_CONJUNTO")
	private String conjunto;
	
	@Element(name="NUM_EXTERIOR")
	private String numeroExterior;
	
	@Element(name="EDIFICIO")
	private String edificio;
	
	@Element(name="NUM_INTERIOR")
	private String numeroInterior;
	
	@Element(name="MANZANA")
	private String manzana;

	@Element(name="SUPERMANZANA")
	private String superManzana;
	
	@Element(name="LOTE")
	private String lote;
	
	@Element(name="CONDOMINIO")
	private String condominio;
	
	@Element(name="NIVELES_VIVIENDA")
	private String nivelesVivienda;
	
	@Element(name="NIVELES_EDIFICIO")
	private String nivelesEdificio;
	
	@Element(name="ENTRE_CALLE_1")
	private String entreCalle1;
	
	@Element(name="ENTRE_CALLE_2")
	private String entreCalle2;
	
	@Element(name="COORDENADA_VISITA_LAT")
	private String latitud;
	
	@Element(name="COORDENADA_VISITA_LNG")
	private String longitud;
	
	@Element(name="COORDENADA_VISITA_ALT")
	private String altitud;
	
	@Element(name="VIALIDAD_PAVIMENTOS")
	private String idVialidades;
	
	@Element(name="BANQUETAS_ANDADORES")
	private String idMaterialBanquetas;
	
	@Element(name="ACCESOS")
	private String idVialidadesAccesos;
	
	@Element(name="AGUA_POTABLE")
	private String idInfraestructuraAguaPotable;
	
	@Element(name="ENERGIA_ELECTRICA")
	private String idInfraestructuraEnergiaElectrica;
	
	@Element(name="ELECTRIFICACION")
	private String idInfraestructuraAlumbradoPublico;
	
	@Element(name="GRADO_OBRA")
	private String gradoTerminacionObra;
	
	@Element(name="ESTADO_CONSERVACION")
	private String idEstadoConservación;
	
	@Element(name="USO_ACTUAL")
	private String idUsoConstrucciones;
	
	@Element(name="TELEFONICO")
	private String idSuministroTelefonico;
	
	@Element(name="COLINDANCIAS")
	private String colindancias;
	
	@Element(name="SENALIZACION_NOMENCLATURA_CALLE")
	private String nomenclaturaCalles;
	
	@Element(name="ZRIESGO_RESTRICCIONES")
	private String idZonaRestricciones;
	
	@Element(name="ZRIESGO_AFECTACION")
	private String idZonaAfectacion;
	
	@Element(name="ZRIESGO_AREAS_INUNDABLES")
	private String idZonaAreasInundiable;
	
	@Element(name="ID_CONVIVENCIA")
	private String idConvivencia;
	
	@Element(name="COORDENADA_CUV_LATITUD_RUV")
	private String latitudMaiCuv;
	
	@Element(name="COORDENADA_CUV_LONGITUD_RUV")
	private String longitudMaiCuv;
	
	@Element(name="COORDENADA_CUV_ALTITUD_RUV")
	private String altitudMaiCuv;
	
	@Element(name="EDAD_VIVIENDA")
	private String edadInmueble;
	
	@Element(name="CLASIFICACION_VIVIENDA")
	private String clasificacionVivienda;
	
	
	private String fechaCierreInicio;
	private String fechaCierreFin;
	private int    resultadoEnvio1;
	private String respuestaEnvio1;
	private int    resultadoEnvio2;
	private String respuestaEnvio2;
	private FotoDomain fotoFachada;
	private FotoDomain fotoEntorno;
	private DocumentoAvaluoDomain documento;
	private boolean envioAvaluo;
	private boolean envioFoto;
	
	
	public AvaluoCerradoMaiDomain() {
		super();
	}
	
	
	public AvaluoCerradoMaiDomain(String fechaCierreInicio,
			String fechaCierreFin) {
		super();
		this.fechaCierreInicio = fechaCierreInicio;
		this.fechaCierreFin = fechaCierreFin;
	}
	
	
	

	/**
	 * Crea un objeto tipo {@link AvaluoCerradoMaiDomain} de acuerdo a los parametros proporcionados
	 * @param folioControl
	 * @param fechaEntrega
	 * @param idUv
	 * @param idAvaluo
	 * @param idConvivencia
	 * @param idEstatus
	 * @param fechaCierre
	 * @param fechaVisitaInmueble
	 * @param viviendaRecuperada
	 * @param idTipoInmuebleValuado
	 * @param estado
	 * @param localidad
	 * @param idMunicipio
	 * @param codigoPostal
	 * @param colonia
	 * @param calle
	 * @param conjunto
	 * @param numeroExterior
	 * @param edificio
	 * @param numeroInterior
	 * @param manzana
	 * @param superManzana
	 * @param lote
	 * @param condominio
	 * @param nivelesVivienda
	 * @param nivelesEdificio
	 * @param entreCalle1
	 * @param entreCalle2
	 * @param latitud
	 * @param longitud
	 * @param altitud
	 * @param idVialidades
	 * @param idMaterialBanquetas
	 * @param idVialidadesAccesos
	 * @param idInfraestructuraAguaPotable
	 * @param idInfraestructuraEnergiaElectrica
	 * @param idInfraestructuraAlumbradoPublico
	 * @param gradoTerminacionObra
	 * @param idEstadoConservación
	 * @param idUsoConstrucciones
	 * @param idSuministroTelefonico
	 * @param colindancias
	 * @param nomenclaturaCalles
	 * @param idZonaRestricciones
	 * @param idZonaAfectacion
	 * @param idZonaAreasInundiable
	 * @param edadInmueble
	 * @param clasificacionVivienda
	 */
	public AvaluoCerradoMaiDomain(String folioControl, String fechaEntrega,
			String idUv, String idAvaluo,String idConvivencia, String idEstatus, String fechaCierre,
			String fechaVisitaInmueble, String viviendaRecuperada,
			String idTipoInmuebleValuado, String estado, String localidad,
			String idMunicipio, String codigoPostal, String colonia,
			String calle, String conjunto, String numeroExterior,
			String edificio, String numeroInterior, String manzana,
			String superManzana, String lote, String condominio,
			String nivelesVivienda, String nivelesEdificio, String entreCalle1,
			String entreCalle2, String latitud, String longitud,
			String altitud, String idVialidades, String idMaterialBanquetas,
			String idVialidadesAccesos, String idInfraestructuraAguaPotable,
			String idInfraestructuraEnergiaElectrica,
			String idInfraestructuraAlumbradoPublico,
			String gradoTerminacionObra, String idEstadoConservación,
			String idUsoConstrucciones, String idSuministroTelefonico,
			String colindancias, String nomenclaturaCalles,
			String idZonaRestricciones, String idZonaAfectacion,
			String idZonaAreasInundiable,
			String edadInmueble, String clasificacionVivienda) {
		super();
		this.folioControl = folioControl;
		this.fechaEntrega = fechaEntrega;
		this.idUv = idUv;
		this.idAvaluo = idAvaluo;
		this.idConvivencia=idConvivencia;
		this.idEstatus = idEstatus;
		this.fechaCierre = fechaCierre;
		this.fechaVisitaInmueble = fechaVisitaInmueble;
		this.viviendaRecuperada = viviendaRecuperada;
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
		this.estado = estado;
		this.localidad = localidad;
		this.idMunicipio = idMunicipio;
		this.codigoPostal = codigoPostal;
		this.colonia = colonia;
		this.calle = calle;
		this.conjunto = conjunto;
		this.numeroExterior = numeroExterior;
		this.edificio = edificio;
		this.numeroInterior = numeroInterior;
		this.manzana = manzana;
		this.superManzana = superManzana;
		this.lote = lote;
		this.condominio = condominio;
		this.nivelesVivienda = nivelesVivienda;
		this.nivelesEdificio = nivelesEdificio;
		this.entreCalle1 = entreCalle1;
		this.entreCalle2 = entreCalle2;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.idVialidades = idVialidades;
		this.idMaterialBanquetas = idMaterialBanquetas;
		this.idVialidadesAccesos = idVialidadesAccesos;
		this.idInfraestructuraAguaPotable = idInfraestructuraAguaPotable;
		this.idInfraestructuraEnergiaElectrica = idInfraestructuraEnergiaElectrica;
		this.idInfraestructuraAlumbradoPublico = idInfraestructuraAlumbradoPublico;
		this.gradoTerminacionObra = gradoTerminacionObra;
		this.idEstadoConservación = idEstadoConservación;
		this.idUsoConstrucciones = idUsoConstrucciones;
		this.idSuministroTelefonico = idSuministroTelefonico;
		this.colindancias = colindancias;
		this.nomenclaturaCalles = nomenclaturaCalles;
		this.idZonaRestricciones = idZonaRestricciones;
		this.idZonaAfectacion = idZonaAfectacion;
		this.idZonaAreasInundiable = idZonaAreasInundiable;
		this.clasificacionVivienda = clasificacionVivienda;
		this.edadInmueble = edadInmueble;
	}


	public AvaluoCerradoMaiDomain(String folioControl, String fechaEntrega,
			String idUv, String idAvaluo,String idConvivencia, String idEstatus, String fechaCierre,
			String fechaVisitaInmueble, String viviendaRecuperada,
			String idTipoInmuebleValuado, String estado, String localidad,
			String idMunicipio, String codigoPostal, String colonia,
			String calle, String conjunto, String numeroExterior,
			String edificio, String numeroInterior, String manzana,
			String superManzana, String lote, String condominio,
			String nivelesVivienda, String nivelesEdificio, String entreCalle1,
			String entreCalle2, String latitud, String longitud,
			String altitud, String idVialidades, String idMaterialBanquetas,
			String idVialidadesAccesos, String idInfraestructuraAguaPotable,
			String idInfraestructuraEnergiaElectrica,
			String idInfraestructuraAlumbradoPublico,
			String gradoTerminacionObra, String idEstadoConservación,
			String idUsoConstrucciones, String idSuministroTelefonico,
			String colindancias, String nomenclaturaCalles,
			String idZonaRestricciones, String idZonaAfectacion,
			String idZonaAreasInundiable) {
		super();
		this.folioControl = folioControl;
		this.fechaEntrega = fechaEntrega;
		this.idUv = idUv;
		this.idAvaluo = idAvaluo;
		this.idConvivencia = idConvivencia;
		this.idEstatus = idEstatus;
		this.fechaCierre = fechaCierre;
		this.fechaVisitaInmueble = fechaVisitaInmueble;
		this.viviendaRecuperada = viviendaRecuperada;
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
		this.estado = estado;
		this.localidad = localidad;
		this.idMunicipio = idMunicipio;
		this.codigoPostal = codigoPostal;
		this.colonia = colonia;
		this.calle = calle;
		this.conjunto = conjunto;
		this.numeroExterior = numeroExterior;
		this.edificio = edificio;
		this.numeroInterior = numeroInterior;
		this.manzana = manzana;
		this.superManzana = superManzana;
		this.lote = lote;
		this.condominio = condominio;
		this.nivelesVivienda = nivelesVivienda;
		this.nivelesEdificio = nivelesEdificio;
		this.entreCalle1 = entreCalle1;
		this.entreCalle2 = entreCalle2;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.idVialidades = idVialidades;
		this.idMaterialBanquetas = idMaterialBanquetas;
		this.idVialidadesAccesos = idVialidadesAccesos;
		this.idInfraestructuraAguaPotable = idInfraestructuraAguaPotable;
		this.idInfraestructuraEnergiaElectrica = idInfraestructuraEnergiaElectrica;
		this.idInfraestructuraAlumbradoPublico = idInfraestructuraAlumbradoPublico;
		this.gradoTerminacionObra = gradoTerminacionObra;
		this.idEstadoConservación = idEstadoConservación;
		this.idUsoConstrucciones = idUsoConstrucciones;
		this.idSuministroTelefonico = idSuministroTelefonico;
		this.colindancias = colindancias;
		this.nomenclaturaCalles = nomenclaturaCalles;
		this.idZonaRestricciones = idZonaRestricciones;
		this.idZonaAfectacion = idZonaAfectacion;
		this.idZonaAreasInundiable = idZonaAreasInundiable;
	}
	/**
	 * @return the folioControl
	 */
	public String getFolioControl() {
		return folioControl;
	}
	/**
	 * @param folioControl the folioControl to set
	 */
	public void setFolioControl(String folioControl) {
		this.folioControl = folioControl;
	}
	/**
	 * @return the fechaEntrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	/**
	 * @return the idUv
	 */
	public String getIdUv() {
		return idUv;
	}
	/**
	 * @param idUv the idUv to set
	 */
	public void setIdUv(String idUv) {
		this.idUv = idUv;
	}
	/**
	 * @return the idAvaluo
	 */
	public String getIdAvaluo() {
		return idAvaluo;
	}
	/**
	 * @param idAvaluo the idAvaluo to set
	 */
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	/**
	 * @return the idEstatus
	 */
	public String getIdEstatus() {
		return idEstatus;
	}
	/**
	 * @param idEstatus the idEstatus to set
	 */
	public void setIdEstatus(String idEstatus) {
		this.idEstatus = idEstatus;
	}
	/**
	 * @return the fechaCierre
	 */
	public String getFechaCierre() {
		return fechaCierre;
	}
	/**
	 * @param fechaCierre the fechaCierre to set
	 */
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	/**
	 * @return the fechaVisitaInmueble
	 */
	public String getFechaVisitaInmueble() {
		return fechaVisitaInmueble;
	}
	/**
	 * @param fechaVisitaInmueble the fechaVisitaInmueble to set
	 */
	public void setFechaVisitaInmueble(String fechaVisitaInmueble) {
		this.fechaVisitaInmueble = fechaVisitaInmueble;
	}
	/**
	 * @return the viviendaRecuperada
	 */
	public String getViviendaRecuperada() {
		return viviendaRecuperada;
	}
	/**
	 * @param viviendaRecuperada the viviendaRecuperada to set
	 */
	public void setViviendaRecuperada(String viviendaRecuperada) {
		this.viviendaRecuperada = viviendaRecuperada;
	}
	/**
	 * @return the idTipoInmuebleValuado
	 */
	public String getIdTipoInmuebleValuado() {
		return idTipoInmuebleValuado;
	}
	/**
	 * @param idTipoInmuebleValuado the idTipoInmuebleValuado to set
	 */
	public void setIdTipoInmuebleValuado(String idTipoInmuebleValuado) {
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the idMunicipio
	 */
	public String getIdMunicipio() {
		return idMunicipio;
	}
	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}
	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}
	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * @return the conjunto
	 */
	public String getConjunto() {
		return conjunto;
	}
	/**
	 * @param conjunto the conjunto to set
	 */
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	/**
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}
	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	/**
	 * @return the edificio
	 */
	public String getEdificio() {
		return edificio;
	}
	/**
	 * @param edificio the edificio to set
	 */
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	/**
	 * @return the numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}
	/**
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	/**
	 * @return the manzana
	 */
	public String getManzana() {
		return manzana;
	}
	/**
	 * @param manzana the manzana to set
	 */
	public void setManzana(String manzana) {
		this.manzana = manzana;
	}
	/**
	 * @return the superManzana
	 */
	public String getSuperManzana() {
		return superManzana;
	}
	/**
	 * @param superManzana the superManzana to set
	 */
	public void setSuperManzana(String superManzana) {
		this.superManzana = superManzana;
	}
	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	/**
	 * @return the condominio
	 */
	public String getCondominio() {
		return condominio;
	}
	/**
	 * @param condominio the condominio to set
	 */
	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}
	/**
	 * @return the nivelesVivienda
	 */
	public String getNivelesVivienda() {
		return nivelesVivienda;
	}
	/**
	 * @param nivelesVivienda the nivelesVivienda to set
	 */
	public void setNivelesVivienda(String nivelesVivienda) {
		this.nivelesVivienda = nivelesVivienda;
	}
	/**
	 * @return the nivelesEdificio
	 */
	public String getNivelesEdificio() {
		return nivelesEdificio;
	}
	/**
	 * @param nivelesEdificio the nivelesEdificio to set
	 */
	public void setNivelesEdificio(String nivelesEdificio) {
		this.nivelesEdificio = nivelesEdificio;
	}
	/**
	 * @return the entreCalle1
	 */
	public String getEntreCalle1() {
		return entreCalle1;
	}
	/**
	 * @param entreCalle1 the entreCalle1 to set
	 */
	public void setEntreCalle1(String entreCalle1) {
		this.entreCalle1 = entreCalle1;
	}
	/**
	 * @return the entreCalle2
	 */
	public String getEntreCalle2() {
		return entreCalle2;
	}
	/**
	 * @param entreCalle2 the entreCalle2 to set
	 */
	public void setEntreCalle2(String entreCalle2) {
		this.entreCalle2 = entreCalle2;
	}
	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	/**
	 * @return the altitud
	 */
	public String getAltitud() {
		return altitud;
	}
	/**
	 * @param altitud the altitud to set
	 */
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	/**
	 * @return the idVialidades
	 */
	public String getIdVialidades() {
		return idVialidades;
	}
	/**
	 * @param idVialidades the idVialidades to set
	 */
	public void setIdVialidades(String idVialidades) {
		this.idVialidades = idVialidades;
	}
	/**
	 * @return the idMaterialBanquetas
	 */
	public String getIdMaterialBanquetas() {
		return idMaterialBanquetas;
	}
	/**
	 * @param idMaterialBanquetas the idMaterialBanquetas to set
	 */
	public void setIdMaterialBanquetas(String idMaterialBanquetas) {
		this.idMaterialBanquetas = idMaterialBanquetas;
	}
	/**
	 * @return the idVialidadesAccesos
	 */
	public String getIdVialidadesAccesos() {
		return idVialidadesAccesos;
	}
	/**
	 * @param idVialidadesAccesos the idVialidadesAccesos to set
	 */
	public void setIdVialidadesAccesos(String idVialidadesAccesos) {
		this.idVialidadesAccesos = idVialidadesAccesos;
	}
	/**
	 * @return the idInfraestructuraAguaPotable
	 */
	public String getIdInfraestructuraAguaPotable() {
		return idInfraestructuraAguaPotable;
	}
	/**
	 * @param idInfraestructuraAguaPotable the idInfraestructuraAguaPotable to set
	 */
	public void setIdInfraestructuraAguaPotable(String idInfraestructuraAguaPotable) {
		this.idInfraestructuraAguaPotable = idInfraestructuraAguaPotable;
	}
	/**
	 * @return the idInfraestructuraEnergiaElectrica
	 */
	public String getIdInfraestructuraEnergiaElectrica() {
		return idInfraestructuraEnergiaElectrica;
	}
	/**
	 * @param idInfraestructuraEnergiaElectrica the idInfraestructuraEnergiaElectrica to set
	 */
	public void setIdInfraestructuraEnergiaElectrica(
			String idInfraestructuraEnergiaElectrica) {
		this.idInfraestructuraEnergiaElectrica = idInfraestructuraEnergiaElectrica;
	}
	/**
	 * @return the idInfraestructuraAlumbradoPublico
	 */
	public String getIdInfraestructuraAlumbradoPublico() {
		return idInfraestructuraAlumbradoPublico;
	}
	/**
	 * @param idInfraestructuraAlumbradoPublico the idInfraestructuraAlumbradoPublico to set
	 */
	public void setIdInfraestructuraAlumbradoPublico(
			String idInfraestructuraAlumbradoPublico) {
		this.idInfraestructuraAlumbradoPublico = idInfraestructuraAlumbradoPublico;
	}
	/**
	 * @return the gradoTerminacionObra
	 */
	public String getGradoTerminacionObra() {
		return gradoTerminacionObra;
	}
	/**
	 * @param gradoTerminacionObra the gradoTerminacionObra to set
	 */
	public void setGradoTerminacionObra(String gradoTerminacionObra) {
		this.gradoTerminacionObra = gradoTerminacionObra;
	}
	/**
	 * @return the idEstadoConservación
	 */
	public String getIdEstadoConservación() {
		return idEstadoConservación;
	}
	/**
	 * @param idEstadoConservación the idEstadoConservación to set
	 */
	public void setIdEstadoConservación(String idEstadoConservación) {
		this.idEstadoConservación = idEstadoConservación;
	}
	/**
	 * @return the idUsoConstrucciones
	 */
	public String getIdUsoConstrucciones() {
		return idUsoConstrucciones;
	}
	/**
	 * @param idUsoConstrucciones the idUsoConstrucciones to set
	 */
	public void setIdUsoConstrucciones(String idUsoConstrucciones) {
		this.idUsoConstrucciones = idUsoConstrucciones;
	}
	/**
	 * @return the idSuministroTelefonico
	 */
	public String getIdSuministroTelefonico() {
		return idSuministroTelefonico;
	}
	/**
	 * @param idSuministroTelefonico the idSuministroTelefonico to set
	 */
	public void setIdSuministroTelefonico(String idSuministroTelefonico) {
		this.idSuministroTelefonico = idSuministroTelefonico;
	}
	/**
	 * @return the colindancias
	 */
	public String getColindancias() {
		return colindancias;
	}
	/**
	 * @param colindancias the colindancias to set
	 */
	public void setColindancias(String colindancias) {
		this.colindancias = colindancias;
	}
	/**
	 * @return the nomenclaturaCalles
	 */
	public String getNomenclaturaCalles() {
		return nomenclaturaCalles;
	}
	/**
	 * @param nomenclaturaCalles the nomenclaturaCalles to set
	 */
	public void setNomenclaturaCalles(String nomenclaturaCalles) {
		this.nomenclaturaCalles = nomenclaturaCalles;
	}
	/**
	 * @return the idZonaRestricciones
	 */
	public String getIdZonaRestricciones() {
		return idZonaRestricciones;
	}
	/**
	 * @param idZonaRestricciones the idZonaRestricciones to set
	 */
	public void setIdZonaRestricciones(String idZonaRestricciones) {
		this.idZonaRestricciones = idZonaRestricciones;
	}
	/**
	 * @return the idZonaAfectacion
	 */
	public String getIdZonaAfectacion() {
		return idZonaAfectacion;
	}
	/**
	 * @param idZonaAfectacion the idZonaAfectacion to set
	 */
	public void setIdZonaAfectacion(String idZonaAfectacion) {
		this.idZonaAfectacion = idZonaAfectacion;
	}
	/**
	 * @return the idZonaAreasInundiable
	 */
	public String getIdZonaAreasInundiable() {
		return idZonaAreasInundiable;
	}
	/**
	 * @param idZonaAreasInundiable the idZonaAreasInundiable to set
	 */
	public void setIdZonaAreasInundiable(String idZonaAreasInundiable) {
		this.idZonaAreasInundiable = idZonaAreasInundiable;
	}
	/**
	 * @return the fechaCierreInicio
	 */
	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}
	/**
	 * @param fechaCierreInicio the fechaCierreInicio to set
	 */
	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}
	/**
	 * @return the fechaCierreFin
	 */
	public String getFechaCierreFin() {
		return fechaCierreFin;
	}
	/**
	 * @param fechaCierreFin the fechaCierreFin to set
	 */
	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idAvaluo == null) ? 0 : idAvaluo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof AvaluoCerradoMaiDomain)
		{
			if(obj!=null )
			{
				return ((AvaluoCerradoMaiDomain)obj).getIdAvaluo().trim().equals(this.idAvaluo.trim());
			}else
			{
				return false;
			}
		}else
		{
			return false;
		}
	}
	
	/**
	 * @return the resultadoEnvio1
	 */
	public int getResultadoEnvio1() {
		return resultadoEnvio1;
	}

	/**
	 * @param resultadoEnvio1 the resultadoEnvio1 to set
	 */
	public void setResultadoEnvio1(int resultadoEnvio1) {
		this.resultadoEnvio1 = resultadoEnvio1;
	}

	/**
	 * @return the respuestaEnvio1
	 */
	public String getRespuestaEnvio1() {
		return respuestaEnvio1;
	}

	/**
	 * @param respuestaEnvio1 the respuestaEnvio1 to set
	 */
	public void setRespuestaEnvio1(String respuestaEnvio1) {
		this.respuestaEnvio1 = respuestaEnvio1;
	}

	/**
	 * @return the resultadoEnvio2
	 */
	public int getResultadoEnvio2() {
		return resultadoEnvio2;
	}

	/**
	 * @param resultadoEnvio2 the resultadoEnvio2 to set
	 */
	public void setResultadoEnvio2(int resultadoEnvio2) {
		this.resultadoEnvio2 = resultadoEnvio2;
	}

	/**
	 * @return the respuestaEnvio2
	 */
	public String getRespuestaEnvio2() {
		return respuestaEnvio2;
	}
	
	public static AvaluoCerradoMaiDomain getDomainCamposVacios()
	{
		return new AvaluoCerradoMaiDomain("","","","","","","","","",""
				                         ,"","","","","","","","","",""
				                         ,"","","","","","","","","",""
				                         ,"","","","","","","","","",""
				                         ,"","","","","","");
	}	
		

	/**
	 * @param respuestaEnvio2 the respuestaEnvio2 to set
	 */
	public void setRespuestaEnvio2(String respuestaEnvio2) {
		this.respuestaEnvio2 = respuestaEnvio2;
	}

	/**
	 * @return the fotoFachada
	 */
	public FotoDomain getFotoFachada() {
		return fotoFachada;
	}


	/**
	 * @param fotoFachada the fotoFachada to set
	 */
	public void setFotoFachada(FotoDomain fotoFachada) {
		this.fotoFachada = fotoFachada;
	}


	/**
	 * @return the envioAvaluo
	 */
	public boolean isEnvioAvaluo() {
		return envioAvaluo;
	}


	/**
	 * @param envioAvaluo the envioAvaluo to set
	 */
	public void setEnvioAvaluo(boolean envioAvaluo) {
		this.envioAvaluo = envioAvaluo;
	}


	/**
	 * @return the envioFoto
	 */
	public boolean isEnvioFoto() {
		return envioFoto;
	}


	/**
	 * @param envioFoto the envioFoto to set
	 */
	public void setEnvioFoto(boolean envioFoto) {
		this.envioFoto = envioFoto;
	}
	
	


	/**
	 * @return the idConvivencia
	 */
	public String getIdConvivencia() {
		return idConvivencia;
	}


	/**
	 * @param idConvivencia the idConvivencia to set
	 */
	public void setIdConvivencia(String idConvivencia) {
		this.idConvivencia = idConvivencia;
	}
	
	
	/**
	 * @return the latitudMaiCuv
	 */
	public String getLatitudMaiCuv() {
		return latitudMaiCuv;
	}


	/**
	 * @param latitudMaiCuv the latitudMaiCuv to set
	 */
	public void setLatitudMaiCuv(String latitudMaiCuv) {
		this.latitudMaiCuv = latitudMaiCuv;
	}


	/**
	 * @return the longitudMaiCuv
	 */
	public String getLongitudMaiCuv() {
		return longitudMaiCuv;
	}


	/**
	 * @param longitudMaiCuv the longitudMaiCuv to set
	 */
	public void setLongitudMaiCuv(String longitudMaiCuv) {
		this.longitudMaiCuv = longitudMaiCuv;
	}


	/**
	 * @return the altitudMaiCuv
	 */
	public String getAltitudMaiCuv() {
		return altitudMaiCuv;
	}


	/**
	 * @param altitudMaiCuv the altitudMaiCuv to set
	 */
	public void setAltitudMaiCuv(String altitudMaiCuv) {
		this.altitudMaiCuv = altitudMaiCuv;
	}


	/**
	 * Método que da formato a los atributos del objeto para su envío
	 * al servicio web de Nexura
	 * @param domain objeto de tipo {@link AvaluoCerradoMaiDomain}
	 */
	public static void formatearObjeto(AvaluoCerradoMaiDomain domain)
	{
		domain.setFechaCierre(String.valueOf(Fechas.getUnixTimeStamp(domain.getFechaCierre())));
		domain.setFechaEntrega(String.valueOf(Fechas.getUnixTimeStamp(domain.getFechaEntrega())));
		domain.setFechaVisitaInmueble(String.valueOf(Fechas.getUnixTimeStamp(domain.getFechaVisitaInmueble())));
		domain.setLatitudMaiCuv("");
		domain.setAltitudMaiCuv("");
		domain.setLongitudMaiCuv("");
	}


	/**
	 * @return the fotoEntorno
	 */
	public FotoDomain getFotoEntorno() {
		return fotoEntorno;
	}


	/**
	 * @param fotoEntorno the fotoEntorno to set
	 */
	public void setFotoEntorno(FotoDomain fotoEntorno) {
		this.fotoEntorno = fotoEntorno;
	}


	/**
	 * @return the documento
	 */
	public DocumentoAvaluoDomain getDocumento() {
		return documento;
	}


	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(DocumentoAvaluoDomain documento) {
		this.documento = documento;
	}


	/**
	 * @return the edadInmueble
	 */
	public String getEdadInmueble() {
		return edadInmueble;
	}


	/**
	 * @param edadInmueble the edadInmueble to set
	 */
	public void setEdadInmueble(String edadInmueble) {
		this.edadInmueble = edadInmueble;
	}


	/**
	 * @return the clasificacionVivienda
	 */
	public String getClasificacionVivienda() {
		return clasificacionVivienda;
	}


	/**
	 * @param clasificacionVivienda the clasificacionVivienda to set
	 */
	public void setClasificacionVivienda(String clasificacionVivienda) {
		this.clasificacionVivienda = clasificacionVivienda;
	}


	public static void main (String args[]) throws Exception
	{
//		AvaluoCerradoMaiDomain d1 = new AvaluoCerradoMaiDomain();
//		d1.setIdAvaluo("12345");
//		AvaluoCerradoMaiDomain d2 = new AvaluoCerradoMaiDomain();
//		d2.setIdAvaluo("12345");
//		System.out.println("d1.equals(d2): "+(d1.equals(d2)?"Si":"No"));
		
		AvaluoCerradoMaiDomain d = AvaluoCerradoMaiDomain.getDomainCamposVacios();
		
		
		StringWriter writer = new StringWriter();

		Serializer serializer = new Persister();
		serializer.write(d, writer);
		String xmlEntrada = writer.toString().replace("<avaluoCerradoMaiDomain>","").replace("</avaluoCerradoMaiDomain>","");
		
		System.out.println("XMl entrada: "+xmlEntrada);
		
	}

}
