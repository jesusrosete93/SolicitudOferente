package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;


public class AvaluoCerradoMaiVo extends GenericValueObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7163401415580037508L;
	private String folioControl;
	private String fechaEntrega;
	private int idUv;
	private String idAvaluo;
	private String idConvivencia;
	private int idEstatus;
	private String fechaCierre;
	private String fechaVisitaInmueble;
	private String viviendaRecuperada;
	private int idTipoInmuebleValuado;
	private int estado;
	private String localidad;
	private String idMunicipio;
	private String codigoPostal;
	private String colonia;
	private String calle;
	private String conjunto;
	private String numeroExterior;
	private String edificio;
	private String numeroInterior;
	private String manzana;
	private String superManzana;
	private String lote;
	private String condominio;
	private String nivelesVivienda;
	private String nivelesEdificio;
	private String entreCalle1;
	private String entreCalle2;
	private String tipoVivienda;
	private String latitud;
	private String longitud;
	private String altitud;
	private int idVialidades;
	private int idMaterialBanquetas;
	private String edadConstruccion;
	private String idVialidadesAccesos;
	private String idInfraestructuraAguaPotable;
	private String idInfraestructuraEnergiaElectrica;
	private String idInfraestructuraAlumbradoPublico;
	private String gradoTerminacionObra;
	private int idEstadoConservación;
	private int idUsoConstrucciones;
	private int idSuministroTelefonico;
	private String colindancias;
	private int nomenclaturaCalles;
	private String idZonaRestricciones;
	private String idZonaAfectacion;
	private String idZonaAreasInundiable;
	private String fechaCierreInicio;
	private String fechaCierreFin;
	
	public AvaluoCerradoMaiVo() {
		super();
	}
	
	
	
	
	public AvaluoCerradoMaiVo(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}




	public AvaluoCerradoMaiVo(String fechaCierreInicio, String fechaCierreFin) {
		super();
		this.fechaCierreInicio = fechaCierreInicio;
		this.fechaCierreFin = fechaCierreFin;
	}


	
	
	/**
	 * Crea un objeto de tipo {@link AvaluoCerradoMaiVo}
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
	 * @param tipoVivienda
	 * @param latitud
	 * @param longitud
	 * @param altitud
	 * @param idVialidades
	 * @param idMaterialBanquetas
	 * @param edadConstruccion
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
	 * @param fechaCierreInicio
	 * @param fechaCierreFin
	 */
	public AvaluoCerradoMaiVo(String folioControl, String fechaEntrega,
			int idUv, String idAvaluo, String idConvivencia, int idEstatus,
			String fechaCierre, String fechaVisitaInmueble,
			String viviendaRecuperada, int idTipoInmuebleValuado, int estado,
			String localidad, String idMunicipio, String codigoPostal,
			String colonia, String calle, String conjunto,
			String numeroExterior, String edificio, String numeroInterior,
			String manzana, String superManzana, String lote,
			String condominio, String nivelesVivienda, String nivelesEdificio,
			String entreCalle1, String entreCalle2, String tipoVivienda,
			String latitud, String longitud, String altitud, int idVialidades,
			int idMaterialBanquetas, String edadConstruccion,
			String idVialidadesAccesos, String idInfraestructuraAguaPotable,
			String idInfraestructuraEnergiaElectrica,
			String idInfraestructuraAlumbradoPublico,
			String gradoTerminacionObra, int idEstadoConservación,
			int idUsoConstrucciones, int idSuministroTelefonico,
			String colindancias, int nomenclaturaCalles,
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
		this.tipoVivienda = tipoVivienda;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
		this.idVialidades = idVialidades;
		this.idMaterialBanquetas = idMaterialBanquetas;
		this.edadConstruccion = edadConstruccion;
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
		this.fechaCierreInicio = fechaCierreInicio;
		this.fechaCierreFin = fechaCierreFin;
	}




	public AvaluoCerradoMaiVo(  String folioControl, String fechaEntrega,
								int idUv, String idAvaluo,String idConvivencia ,int idEstatus, String fechaCierre,
								String fechaVisitaInmueble, String viviendaRecuperada,
								int idTipoInmuebleValuado, int estado, String localidad,
								String idMunicipio, String codigoPostal, String colonia,
								String calle, String conjunto, String numeroExterior,
								String edificio, String numeroInterior, String manzana,
								String superManzana, String lote, String condominio,
								String nivelesVivienda,String nivelesEdificio, String entreCalle1, String entreCalle2,
								String latitud, String longitud, String altitud, int idVialidades,
								int idMaterialBanquetas, String idVialidadesAccesos,
								String idInfraestructuraAguaPotable,
								String idInfraestructuraEnergiaElectrica,
								String idInfraestructuraAlumbradoPublico, String gradoTerminacionObra,
								int idEstadoConservación, int idUsoConstrucciones,
								int idSuministroTelefonico, String colindancias,
								int nomenclaturaCalles, String idZonaRestricciones,
								String idZonaAfectacion, String idZonaAreasInundiable) {
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
	public String getFolioControl() {
		return folioControl;
	}
	public void setFolioControl(String folioControl) {
		this.folioControl = folioControl;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getIdUv() {
		return idUv;
	}
	public void setIdUv(int idUv) {
		this.idUv = idUv;
	}
	public String getIdAvaluo() {
		return idAvaluo;
	}
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	public int getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getFechaVisitaInmueble() {
		return fechaVisitaInmueble;
	}
	public void setFechaVisitaInmueble(String fechaVisitaInmueble) {
		this.fechaVisitaInmueble = fechaVisitaInmueble;
	}
	public String getViviendaRecuperada() {
		return viviendaRecuperada;
	}
	public void setViviendaRecuperada(String viviendaRecuperada) {
		this.viviendaRecuperada = viviendaRecuperada;
	}
	public int getIdTipoInmuebleValuado() {
		return idTipoInmuebleValuado;
	}
	public void setIdTipoInmuebleValuado(int idTipoInmuebleValuado) {
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getConjunto() {
		return conjunto;
	}
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getManzana() {
		return manzana;
	}
	public void setManzana(String manzana) {
		this.manzana = manzana;
	}
	public String getSuperManzana() {
		return superManzana;
	}
	public void setSuperManzana(String superManzana) {
		this.superManzana = superManzana;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getCondominio() {
		return condominio;
	}
	public void setCondominio(String condominio) {
		this.condominio = condominio;
	}
	public String getNivelesVivienda() {
		return nivelesVivienda;
	}
	public void setNivelesVivienda(String nivelesVivienda) {
		this.nivelesVivienda = nivelesVivienda;
	}
	public String getNivelesEdificio() {
		return nivelesEdificio;
	}




	public void setNivelesEdificio(String nivelesEdificio) {
		this.nivelesEdificio = nivelesEdificio;
	}




	public String getEntreCalle1() {
		return entreCalle1;
	}
	public void setEntreCalle1(String entreCalle1) {
		this.entreCalle1 = entreCalle1;
	}
	public String getEntreCalle2() {
		return entreCalle2;
	}
	public void setEntreCalle2(String entreCalle2) {
		this.entreCalle2 = entreCalle2;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public int getIdVialidades() {
		return idVialidades;
	}
	public void setIdVialidades(int idVialidades) {
		this.idVialidades = idVialidades;
	}
	public int getIdMaterialBanquetas() {
		return idMaterialBanquetas;
	}
	public void setIdMaterialBanquetas(int idMaterialBanquetas) {
		this.idMaterialBanquetas = idMaterialBanquetas;
	}
	public String getIdVialidadesAccesos() {
		return idVialidadesAccesos;
	}
	public void setIdVialidadesAccesos(String idVialidadesAccesos) {
		this.idVialidadesAccesos = idVialidadesAccesos;
	}
	public String getIdInfraestructuraAguaPotable() {
		return idInfraestructuraAguaPotable;
	}
	public void setIdInfraestructuraAguaPotable(String idInfraestructuraAguaPotable) {
		this.idInfraestructuraAguaPotable = idInfraestructuraAguaPotable;
	}
	public String getIdInfraestructuraEnergiaElectrica() {
		return idInfraestructuraEnergiaElectrica;
	}
	public void setIdInfraestructuraEnergiaElectrica(
			String idInfraestructuraEnergiaElectrica) {
		this.idInfraestructuraEnergiaElectrica = idInfraestructuraEnergiaElectrica;
	}
	public String getIdInfraestructuraAlumbradoPublico() {
		return idInfraestructuraAlumbradoPublico;
	}
	public void setIdInfraestructuraAlumbradoPublico(
			String idInfraestructuraAlumbradoPublico) {
		this.idInfraestructuraAlumbradoPublico = idInfraestructuraAlumbradoPublico;
	}
	public String getGradoTerminacionObra() {
		return gradoTerminacionObra;
	}
	public void setGradoTerminacionObra(String gradoTerminacionObra) {
		this.gradoTerminacionObra = gradoTerminacionObra;
	}
	public int getIdEstadoConservación() {
		return idEstadoConservación;
	}
	public void setIdEstadoConservación(int idEstadoConservación) {
		this.idEstadoConservación = idEstadoConservación;
	}
	public int getIdUsoConstrucciones() {
		return idUsoConstrucciones;
	}
	public void setIdUsoConstrucciones(int idUsoConstrucciones) {
		this.idUsoConstrucciones = idUsoConstrucciones;
	}
	public int getIdSuministroTelefonico() {
		return idSuministroTelefonico;
	}
	public void setIdSuministroTelefonico(int idSuministroTelefonico) {
		this.idSuministroTelefonico = idSuministroTelefonico;
	}
	public String getColindancias() {
		return colindancias;
	}
	public void setColindancias(String colindancias) {
		this.colindancias = colindancias;
	}
	public int getNomenclaturaCalles() {
		return nomenclaturaCalles;
	}
	public void setNomenclaturaCalles(int nomenclaturaCalles) {
		this.nomenclaturaCalles = nomenclaturaCalles;
	}
	public String getIdZonaRestricciones() {
		return idZonaRestricciones;
	}
	public void setIdZonaRestricciones(String idZonaRestricciones) {
		this.idZonaRestricciones = idZonaRestricciones;
	}
	public String getIdZonaAfectacion() {
		return idZonaAfectacion;
	}
	public void setIdZonaAfectacion(String idZonaAfectacion) {
		this.idZonaAfectacion = idZonaAfectacion;
	}
	public String getIdZonaAreasInundiable() {
		return idZonaAreasInundiable;
	}
	public void setIdZonaAreasInundiable(String idZonaAreasInundiable) {
		this.idZonaAreasInundiable = idZonaAreasInundiable;
	}

	public String getFechaCierreInicio() {
		return fechaCierreInicio;
	}

	public void setFechaCierreInicio(String fechaCierreInicio) {
		this.fechaCierreInicio = fechaCierreInicio;
	}

	public String getFechaCierreFin() {
		return fechaCierreFin;
	}

	public void setFechaCierreFin(String fechaCierreFin) {
		this.fechaCierreFin = fechaCierreFin;
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




	public String getTipoVivienda() {
		return tipoVivienda;
	}




	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}




	public String getEdadConstruccion() {
		return edadConstruccion;
	}




	public void setEdadConstruccion(String edadConstruccion) {
		this.edadConstruccion = edadConstruccion;
	}
	
	
	
	
	

}
