package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

public class DetalleAvaluoVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2732435174825004922L;
	private String idAvaluo;
	private int idVivienda;
	private String idPaquete;
	private String claveShf;
	private String claveUv;
	private String fechaAvaluo;
	private String claveUnicaVivienda;
	private String clasificacionZona;
	private int nivelesZona;
	private String construccionesValor;
	private int idRecAguasResiduales;
	private String drenajePluvialCalle;
	private String drenajePluvialZona;
	private String sistMixtoDrenaje;
	private String fosaSeptica;
	private boolean electAcometicaInmueble;
	private int idMaterialVialidades;
	private String vialidadesValor;
	private int idAlumbradoPublico;
	private int idMaterialBanquetas;
	private String banquetaValor;
	private int idMaterialGuarniciones;
	private String guarnicionesValor;
	private String nivelInfraestructura;
	private int idGasNatural;
	private int idSuminTelefonico;
	private boolean acometidaTelefonico;
	private boolean nomenclaturaCalles;
	private int transUrbanoDist;
	private int transUrbanoFrec;
	private int transSuburbanoDist;
	private int transSuburbanoFrec;
	private boolean recMunicipalDesechos;
	private int idTipoInmuebleValuado;
	private String tipoInmValuadoValor;
	private String domicilioLocalidadInmueble;
	private String codigoPostalInmueble;
	private String coloniaInmueble;
	private String calleInmueble;
	private String numExteriorInmueble;
	private String numInteriorInmueble;
	private int idConfInmueble;
	private int idTopografiaInmueble;
	private String usoSuelo;
	private String cus;
	private String densidadHabitacional;
	private String usoActual;
	private int numRecamaras;
	private int numBanios;
	private int numEstacionamiento;
	private int idCalidadProyecto;
	private int idClaseGralInmueble;
	private int idEstadoConservacion;
	private int edadContruccion;
	private int vidaUtilRemanente;
	private int nivelesConstruccion;
	private String gradoTerminacionObra;
	private String gradoAvanceAreasComunes;
	private String superficieTerrenoVivienda;
	private String superficieConstruida;
	private String superficieAccesorias;
	private String superficieVendible;
	private String indivisosConstruccion;
	private String indivisosTerreno;
	private int idInstHidraulicas;
	private String matInstHidraulicas;
	private int idInstSanitarias;
	private String matInstSanitarias;
	private int idInstElectricas;
	private int idElementosAdicionales;
	private String elementosAdicionalesValor;
	private String valorComparativoTotal;
	private String valorComparativoM2;
	private String valorTerrenoTotal;
	private String valorTerrenoM2;
	private String valorConstruccionTotal;
	private String valorConstruccionM2;
	private String valorResidual;
	private String valorConcluido;
	private int idUbicaInmuebleTerreno;
	private String superficieTerrenoConjunto;
	private int idVigilancia;
	private boolean senalizacionVial;
	private int idSuministroElectricidad;
	private int idAguaPotable;
	private String indiceSaturacionZona;
	private int idUsoConstrucciones;
	private int idRefProximidadUrbana;
	private int idClaseZona;
	private String idPeritoShf;
	private int idDensidadPoblacion;
	private String idControladorShf;
	private String longitud;
	private String latitud;
	private String altitud;
	private String otroTipoSistema;
	private int idExistenciaTransUrbano;
	private int idExistenciaTranSuburbano;
	private int recMunicipalDesechosFrec;
	private int idNivelInfraurbana;
	private int idExistenciaIglesia;
	private int idExistenciaMercados;
	private int idExistenciaPlazaPublica;
	private int idExistenciaParquesJardines;
	private int idExistenciaEscuelas;
	private int idExistenciaHospitales;
	private int idExistenciaBancos;
	private int idExistenciaAccesoEstacionUrbano;
	private int idExistenciaAccesoEstacionSuburbano;
	private int idExistenciaCentroComunitario;
	private int idNivelEquipamientoUrbano;
	private int reporteDensidad;
	private int idExisteEspacioUsoMultiple;
	private int numMediosBanios;
	private String resultadoCalidadProyecto;
	private String comentariosEstadoConservacion;
	private String matInstElectricas;
	private String valorHipotetico;
	private int densidadHabitacionalHabitantes;
	private int densidadHabitacionalViviendas;
	private int idSupermercados;
	private int idLocalesComerciales;
	private int numLocalesComerciales;
	private int idExistenciaParques;
	private int idExistenciaJardines;
	private int idCanchasDeportivas;
	private int idCentroDeportivo;
	private int idEscuelasPrimarias;
	private int idEscuelasSecundarias;
	private int idEscuelasPreparatoria;
	private int idUniversidad;
	private int idOtrasEscuelas;
	private int idServiciosSaludPrimerNivel;
	private int idServiciosSaludSegundoNivel;
	private int idServiciosSaludTercerNivel;
	private int idTerrenoColinda;
	private int idTerrenoUbicado;
	private int idRiesgoSocial;
	private int idRiesgoComercial;
	private String fechaVisitaInmueble;
	private int idMetodoConclusionAvaluo;
	private String marcaViviendaUsadaMenorTres;
	
	private String valorOfertaMinimo;
	private String valorOfertaMaximo;
	private String superficieTerrenoMinimo;
	private String superficieTerrenoMaximo;
	private String superficieConstruccionMinimo;
	private String superficieConstruccionMaximo;
	private String avaluos;
	
	
	public DetalleAvaluoVo() {
		super();
	}
	
	
	
	
	public DetalleAvaluoVo(String idAvaluo) {
		super();
		this.idAvaluo = idAvaluo;
	}




	public DetalleAvaluoVo(int idMetodoConclusionAvaluo,
						   int edadConstruccion,
						   int idEstadoConservacion,
						   String valorOfertaMinimo,String valorOfertaMaximo,
						   String superficieTerrenoMinimo,String superficieTerrenoMaximo,
						   String superficieConstruccionMinimo,String superficieConstruccionMaximo,String avaluos) {
		super();
		this.idMetodoConclusionAvaluo = idMetodoConclusionAvaluo;
		this.edadContruccion = edadConstruccion;
		this.idEstadoConservacion = idEstadoConservacion;
		this.valorOfertaMinimo = valorOfertaMinimo;
		this.valorOfertaMaximo = valorOfertaMaximo;
		this.superficieTerrenoMinimo = superficieTerrenoMinimo;
		this.superficieTerrenoMaximo = superficieTerrenoMaximo;
		this.superficieConstruccionMinimo = superficieConstruccionMinimo;
		this.superficieConstruccionMaximo = superficieConstruccionMaximo;
		this.avaluos = avaluos;
	}




	public DetalleAvaluoVo(String idAvaluo, int idVivienda, String idPaquete,
						   String claveShf, String claveUv, String fechaAvaluo,
						   String claveUnicaVivienda, String clasificacionZona,
						   int nivelesZona, String construccionesValor,int idRecAguasResiduales,
						   String drenajePluvialCalle,String drenajePluvialZona, String sistMixtoDrenaje,
						   String fosaSeptica, boolean electAcometicaInmueble,int idMaterialVialidades,
						   String vialidadesValor, int idAlumbradoPublico, int idMaterialBanquetas,
			String banquetaValor, int idMaterialGuarniciones,
			String guarnicionesValor, String nivelInfraestructura,
			int idGasNatural, int idSuminTelefonico,
			boolean acometidaTelefonico, boolean nomenclaturaCalles,
			int transUrbanoDist, int transUrbanoFrec, int transSuburbanoDist,
			int transSuburbanoFrec, boolean recMunicipalDesechos,
			int idTipoInmuebleValuado, String tipoInmValuadoValor,
			String domicilioLocalidadInmueble, String codigoPostalInmueble,
			String coloniaInmueble, String calleInmueble,
			String numExteriorInmueble, String numInteriorInmueble,
			int idConfInmueble, int idTopografiaInmueble, String usoSuelo,
			String cus, String densidadHabitacional, String usoActual,
			int numRecamaras, int numBanios, int numEstacionamiento,
			int idCalidadProyecto, int idClaseGralInmueble,
			int idEstadoConservacion, int edadContruccion,
			int vidaUtilRemanente, int nivelesConstruccion,
			String gradoTerminacionObra, String gradoAvanceAreasComunes,
			String superficieTerrenoVivienda, String superficieConstruida,
			String superficieAccesorias, String superficieVendible,
			String indivisosConstruccion, String indivisosTerreno,
			int idInstHidraulicas, String matInstHidraulicas,
			int idInstSanitarias, String matInstSanitarias,
			int idInstElectricas, int idElementosAdicionales,
			String elementosAdicionalesValor, String valorComparativoTotal,
			String valorComparativoM2, String valorTerrenoTotal,
			String valorTerrenoM2, String valorConstruccionTotal,
			String valorConstruccionM2, String valorResidual,
			String valorConcluido, int idUbicaInmuebleTerreno,
			String superficieTerrenoConjunto, int idVigilancia,
			boolean senalizacionVial, int idSuministroElectricidad,
			int idAguaPotable, String indiceSaturacionZona,
			int idUsoConstrucciones, int idRefProximidadUrbana,
			int idClaseZona, String idPeritoShf, int idDensidadPoblacion,
			String idControladorShf, String longitud, String latitud,
			String altitud, String otroTipoSistema,
			int idExistenciaTransUrbano, int idExistenciaTranSuburbano,
			int recMunicipalDesechosFrec, int idNivelInfraurbana,
			int idExistenciaIglesia, int idExistenciaMercados,
			int idExistenciaPlazaPublica, int idExistenciaParquesJardines,
			int idExistenciaEscuelas, int idExistenciaHospitales,
			int idExistenciaBancos, int idExistenciaAccesoEstacionUrbano,
			int idExistenciaAccesoEstacionSuburbano,
			int idExistenciaCentroComunitario, int idNivelEquipamientoUrbano,
			int reporteDensidad, int idExisteEspacioUsoMultiple,
			int numMediosBanios, String resultadoCalidadProyecto,
			String comentariosEstadoConservacion, String matInstElectricas,
			String valorHipotetico, int densidadHabitacionalHabitantes,
			int densidadHabitacionalViviendas, int idSupermercados,
			int idLocalesComerciales, int numLocalesComerciales,
			int idExistenciaParques, int idExistenciaJardines,
			int idCanchasDeportivas, int idCentroDeportivo,
			int idEscuelasPrimarias, int idEscuelasSecundarias,
			int idEscuelasPreparatoria, int idUniversidad, int idOtrasEscuelas,
			int idServiciosSaludPrimerNivel, int idServiciosSaludSegundoNivel,
			int idServiciosSaludTercerNivel, int idTerrenoColinda,
			int idTerrenoUbicado, int idRiesgoSocial, int idRiesgoComercial,
			String fechaVisitaInmueble, int idMetodoConclusionAvaluo,
			String marcaViviendaUsadaMenorTres) {
		super();
		this.idAvaluo = idAvaluo;
		this.idVivienda = idVivienda;
		this.idPaquete = idPaquete;
		this.claveShf = claveShf;
		this.claveUv = claveUv;
		this.fechaAvaluo = fechaAvaluo;
		this.claveUnicaVivienda = claveUnicaVivienda;
		this.clasificacionZona = clasificacionZona;
		this.nivelesZona = nivelesZona;
		this.construccionesValor = construccionesValor;
		this.idRecAguasResiduales = idRecAguasResiduales;
		this.drenajePluvialCalle = drenajePluvialCalle;
		this.drenajePluvialZona = drenajePluvialZona;
		this.sistMixtoDrenaje = sistMixtoDrenaje;
		this.fosaSeptica = fosaSeptica;
		this.electAcometicaInmueble = electAcometicaInmueble;
		this.idMaterialVialidades = idMaterialVialidades;
		this.vialidadesValor = vialidadesValor;
		this.idAlumbradoPublico = idAlumbradoPublico;
		this.idMaterialBanquetas = idMaterialBanquetas;
		this.banquetaValor = banquetaValor;
		this.idMaterialGuarniciones = idMaterialGuarniciones;
		this.guarnicionesValor = guarnicionesValor;
		this.nivelInfraestructura = nivelInfraestructura;
		this.idGasNatural = idGasNatural;
		this.idSuminTelefonico = idSuminTelefonico;
		this.acometidaTelefonico = acometidaTelefonico;
		this.nomenclaturaCalles = nomenclaturaCalles;
		this.transUrbanoDist = transUrbanoDist;
		this.transUrbanoFrec = transUrbanoFrec;
		this.transSuburbanoDist = transSuburbanoDist;
		this.transSuburbanoFrec = transSuburbanoFrec;
		this.recMunicipalDesechos = recMunicipalDesechos;
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
		this.tipoInmValuadoValor = tipoInmValuadoValor;
		this.domicilioLocalidadInmueble = domicilioLocalidadInmueble;
		this.codigoPostalInmueble = codigoPostalInmueble;
		this.coloniaInmueble = coloniaInmueble;
		this.calleInmueble = calleInmueble;
		this.numExteriorInmueble = numExteriorInmueble;
		this.numInteriorInmueble = numInteriorInmueble;
		this.idConfInmueble = idConfInmueble;
		this.idTopografiaInmueble = idTopografiaInmueble;
		this.usoSuelo = usoSuelo;
		this.cus = cus;
		this.densidadHabitacional = densidadHabitacional;
		this.usoActual = usoActual;
		this.numRecamaras = numRecamaras;
		this.numBanios = numBanios;
		this.numEstacionamiento = numEstacionamiento;
		this.idCalidadProyecto = idCalidadProyecto;
		this.idClaseGralInmueble = idClaseGralInmueble;
		this.idEstadoConservacion = idEstadoConservacion;
		this.edadContruccion = edadContruccion;
		this.vidaUtilRemanente = vidaUtilRemanente;
		this.nivelesConstruccion = nivelesConstruccion;
		this.gradoTerminacionObra = gradoTerminacionObra;
		this.gradoAvanceAreasComunes = gradoAvanceAreasComunes;
		this.superficieTerrenoVivienda = superficieTerrenoVivienda;
		this.superficieConstruida = superficieConstruida;
		this.superficieAccesorias = superficieAccesorias;
		this.superficieVendible = superficieVendible;
		this.indivisosConstruccion = indivisosConstruccion;
		this.indivisosTerreno = indivisosTerreno;
		this.idInstHidraulicas = idInstHidraulicas;
		this.matInstHidraulicas = matInstHidraulicas;
		this.idInstSanitarias = idInstSanitarias;
		this.matInstSanitarias = matInstSanitarias;
		this.idInstElectricas = idInstElectricas;
		this.idElementosAdicionales = idElementosAdicionales;
		this.elementosAdicionalesValor = elementosAdicionalesValor;
		this.valorComparativoTotal = valorComparativoTotal;
		this.valorComparativoM2 = valorComparativoM2;
		this.valorTerrenoTotal = valorTerrenoTotal;
		this.valorTerrenoM2 = valorTerrenoM2;
		this.valorConstruccionTotal = valorConstruccionTotal;
		this.valorConstruccionM2 = valorConstruccionM2;
		this.valorResidual = valorResidual;
		this.valorConcluido = valorConcluido;
		this.idUbicaInmuebleTerreno = idUbicaInmuebleTerreno;
		this.superficieTerrenoConjunto = superficieTerrenoConjunto;
		this.idVigilancia = idVigilancia;
		this.senalizacionVial = senalizacionVial;
		this.idSuministroElectricidad = idSuministroElectricidad;
		this.idAguaPotable = idAguaPotable;
		this.indiceSaturacionZona = indiceSaturacionZona;
		this.idUsoConstrucciones = idUsoConstrucciones;
		this.idRefProximidadUrbana = idRefProximidadUrbana;
		this.idClaseZona = idClaseZona;
		this.idPeritoShf = idPeritoShf;
		this.idDensidadPoblacion = idDensidadPoblacion;
		this.idControladorShf = idControladorShf;
		this.longitud = longitud;
		this.latitud = latitud;
		this.altitud = altitud;
		this.otroTipoSistema = otroTipoSistema;
		this.idExistenciaTransUrbano = idExistenciaTransUrbano;
		this.idExistenciaTranSuburbano = idExistenciaTranSuburbano;
		this.recMunicipalDesechosFrec = recMunicipalDesechosFrec;
		this.idNivelInfraurbana = idNivelInfraurbana;
		this.idExistenciaIglesia = idExistenciaIglesia;
		this.idExistenciaMercados = idExistenciaMercados;
		this.idExistenciaPlazaPublica = idExistenciaPlazaPublica;
		this.idExistenciaParquesJardines = idExistenciaParquesJardines;
		this.idExistenciaEscuelas = idExistenciaEscuelas;
		this.idExistenciaHospitales = idExistenciaHospitales;
		this.idExistenciaBancos = idExistenciaBancos;
		this.idExistenciaAccesoEstacionUrbano = idExistenciaAccesoEstacionUrbano;
		this.idExistenciaAccesoEstacionSuburbano = idExistenciaAccesoEstacionSuburbano;
		this.idExistenciaCentroComunitario = idExistenciaCentroComunitario;
		this.idNivelEquipamientoUrbano = idNivelEquipamientoUrbano;
		this.reporteDensidad = reporteDensidad;
		this.idExisteEspacioUsoMultiple = idExisteEspacioUsoMultiple;
		this.numMediosBanios = numMediosBanios;
		this.resultadoCalidadProyecto = resultadoCalidadProyecto;
		this.comentariosEstadoConservacion = comentariosEstadoConservacion;
		this.matInstElectricas = matInstElectricas;
		this.valorHipotetico = valorHipotetico;
		this.densidadHabitacionalHabitantes = densidadHabitacionalHabitantes;
		this.densidadHabitacionalViviendas = densidadHabitacionalViviendas;
		this.idSupermercados = idSupermercados;
		this.idLocalesComerciales = idLocalesComerciales;
		this.numLocalesComerciales = numLocalesComerciales;
		this.idExistenciaParques = idExistenciaParques;
		this.idExistenciaJardines = idExistenciaJardines;
		this.idCanchasDeportivas = idCanchasDeportivas;
		this.idCentroDeportivo = idCentroDeportivo;
		this.idEscuelasPrimarias = idEscuelasPrimarias;
		this.idEscuelasSecundarias = idEscuelasSecundarias;
		this.idEscuelasPreparatoria = idEscuelasPreparatoria;
		this.idUniversidad = idUniversidad;
		this.idOtrasEscuelas = idOtrasEscuelas;
		this.idServiciosSaludPrimerNivel = idServiciosSaludPrimerNivel;
		this.idServiciosSaludSegundoNivel = idServiciosSaludSegundoNivel;
		this.idServiciosSaludTercerNivel = idServiciosSaludTercerNivel;
		this.idTerrenoColinda = idTerrenoColinda;
		this.idTerrenoUbicado = idTerrenoUbicado;
		this.idRiesgoSocial = idRiesgoSocial;
		this.idRiesgoComercial = idRiesgoComercial;
		this.fechaVisitaInmueble = fechaVisitaInmueble;
		this.idMetodoConclusionAvaluo = idMetodoConclusionAvaluo;
		this.marcaViviendaUsadaMenorTres = marcaViviendaUsadaMenorTres;
	}
	public String getIdAvaluo() {
		return idAvaluo;
	}
	public void setIdAvaluo(String idAvaluo) {
		this.idAvaluo = idAvaluo;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	public String getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(String idPaquete) {
		this.idPaquete = idPaquete;
	}
	public String getClaveShf() {
		return claveShf;
	}
	public void setClaveShf(String claveShf) {
		this.claveShf = claveShf;
	}
	public String getClaveUv() {
		return claveUv;
	}
	public void setClaveUv(String claveUv) {
		this.claveUv = claveUv;
	}
	public String getFechaAvaluo() {
		return fechaAvaluo;
	}
	public void setFechaAvaluo(String fechaAvaluo) {
		this.fechaAvaluo = fechaAvaluo;
	}
	public String getClaveUnicaVivienda() {
		return claveUnicaVivienda;
	}
	public void setClaveUnicaVivienda(String claveUnicaVivienda) {
		this.claveUnicaVivienda = claveUnicaVivienda;
	}
	public String getClasificacionZona() {
		return clasificacionZona;
	}
	public void setClasificacionZona(String clasificacionZona) {
		this.clasificacionZona = clasificacionZona;
	}
	public int getNivelesZona() {
		return nivelesZona;
	}
	public void setNivelesZona(int nivelesZona) {
		this.nivelesZona = nivelesZona;
	}
	public String getConstruccionesValor() {
		return construccionesValor;
	}
	public void setConstruccionesValor(String construccionesValor) {
		this.construccionesValor = construccionesValor;
	}
	public int getIdRecAguasResiduales() {
		return idRecAguasResiduales;
	}
	public void setIdRecAguasResiduales(int idRecAguasResiduales) {
		this.idRecAguasResiduales = idRecAguasResiduales;
	}
	public String getDrenajePluvialCalle() {
		return drenajePluvialCalle;
	}
	public void setDrenajePluvialCalle(String drenajePluvialCalle) {
		this.drenajePluvialCalle = drenajePluvialCalle;
	}
	public String getDrenajePluvialZona() {
		return drenajePluvialZona;
	}
	public void setDrenajePluvialZona(String drenajePluvialZona) {
		this.drenajePluvialZona = drenajePluvialZona;
	}
	public String getSistMixtoDrenaje() {
		return sistMixtoDrenaje;
	}
	public void setSistMixtoDrenaje(String sistMixtoDrenaje) {
		this.sistMixtoDrenaje = sistMixtoDrenaje;
	}
	public String getFosaSeptica() {
		return fosaSeptica;
	}
	public void setFosaSeptica(String fosaSeptica) {
		this.fosaSeptica = fosaSeptica;
	}
	public boolean isElectAcometicaInmueble() {
		return electAcometicaInmueble;
	}
	public void setElectAcometicaInmueble(boolean electAcometicaInmueble) {
		this.electAcometicaInmueble = electAcometicaInmueble;
	}
	public int getIdMaterialVialidades() {
		return idMaterialVialidades;
	}
	public void setIdMaterialVialidades(int idMaterialVialidades) {
		this.idMaterialVialidades = idMaterialVialidades;
	}
	public String getVialidadesValor() {
		return vialidadesValor;
	}
	public void setVialidadesValor(String vialidadesValor) {
		this.vialidadesValor = vialidadesValor;
	}
	public int getIdAlumbradoPublico() {
		return idAlumbradoPublico;
	}
	public void setIdAlumbradoPublico(int idAlumbradoPublico) {
		this.idAlumbradoPublico = idAlumbradoPublico;
	}
	public int getIdMaterialBanquetas() {
		return idMaterialBanquetas;
	}
	public void setIdMaterialBanquetas(int idMaterialBanquetas) {
		this.idMaterialBanquetas = idMaterialBanquetas;
	}
	public String getBanquetaValor() {
		return banquetaValor;
	}
	public void setBanquetaValor(String banquetaValor) {
		this.banquetaValor = banquetaValor;
	}
	public int getIdMaterialGuarniciones() {
		return idMaterialGuarniciones;
	}
	public void setIdMaterialGuarniciones(int idMaterialGuarniciones) {
		this.idMaterialGuarniciones = idMaterialGuarniciones;
	}
	public String getGuarnicionesValor() {
		return guarnicionesValor;
	}
	public void setGuarnicionesValor(String guarnicionesValor) {
		this.guarnicionesValor = guarnicionesValor;
	}
	public String getNivelInfraestructura() {
		return nivelInfraestructura;
	}
	public void setNivelInfraestructura(String nivelInfraestructura) {
		this.nivelInfraestructura = nivelInfraestructura;
	}
	public int getIdGasNatural() {
		return idGasNatural;
	}
	public void setIdGasNatural(int idGasNatural) {
		this.idGasNatural = idGasNatural;
	}
	public int getIdSuminTelefonico() {
		return idSuminTelefonico;
	}
	public void setIdSuminTelefonico(int idSuminTelefonico) {
		this.idSuminTelefonico = idSuminTelefonico;
	}
	public boolean isAcometidaTelefonico() {
		return acometidaTelefonico;
	}
	public void setAcometidaTelefonico(boolean acometidaTelefonico) {
		this.acometidaTelefonico = acometidaTelefonico;
	}
	public boolean isNomenclaturaCalles() {
		return nomenclaturaCalles;
	}
	public void setNomenclaturaCalles(boolean nomenclaturaCalles) {
		this.nomenclaturaCalles = nomenclaturaCalles;
	}
	public int getTransUrbanoDist() {
		return transUrbanoDist;
	}
	public void setTransUrbanoDist(int transUrbanoDist) {
		this.transUrbanoDist = transUrbanoDist;
	}
	public int getTransUrbanoFrec() {
		return transUrbanoFrec;
	}
	public void setTransUrbanoFrec(int transUrbanoFrec) {
		this.transUrbanoFrec = transUrbanoFrec;
	}
	public int getTransSuburbanoDist() {
		return transSuburbanoDist;
	}
	public void setTransSuburbanoDist(int transSuburbanoDist) {
		this.transSuburbanoDist = transSuburbanoDist;
	}
	public int getTransSuburbanoFrec() {
		return transSuburbanoFrec;
	}
	public void setTransSuburbanoFrec(int transSuburbanoFrec) {
		this.transSuburbanoFrec = transSuburbanoFrec;
	}
	public boolean isRecMunicipalDesechos() {
		return recMunicipalDesechos;
	}
	public void setRecMunicipalDesechos(boolean recMunicipalDesechos) {
		this.recMunicipalDesechos = recMunicipalDesechos;
	}
	public int getIdTipoInmuebleValuado() {
		return idTipoInmuebleValuado;
	}
	public void setIdTipoInmuebleValuado(int idTipoInmuebleValuado) {
		this.idTipoInmuebleValuado = idTipoInmuebleValuado;
	}
	public String getTipoInmValuadoValor() {
		return tipoInmValuadoValor;
	}
	public void setTipoInmValuadoValor(String tipoInmValuadoValor) {
		this.tipoInmValuadoValor = tipoInmValuadoValor;
	}
	public String getDomicilioLocalidadInmueble() {
		return domicilioLocalidadInmueble;
	}
	public void setDomicilioLocalidadInmueble(String domicilioLocalidadInmueble) {
		this.domicilioLocalidadInmueble = domicilioLocalidadInmueble;
	}
	public String getCodigoPostalInmueble() {
		return codigoPostalInmueble;
	}
	public void setCodigoPostalInmueble(String codigoPostalInmueble) {
		this.codigoPostalInmueble = codigoPostalInmueble;
	}
	public String getColoniaInmueble() {
		return coloniaInmueble;
	}
	public void setColoniaInmueble(String coloniaInmueble) {
		this.coloniaInmueble = coloniaInmueble;
	}
	public String getCalleInmueble() {
		return calleInmueble;
	}
	public void setCalleInmueble(String calleInmueble) {
		this.calleInmueble = calleInmueble;
	}
	public String getNumExteriorInmueble() {
		return numExteriorInmueble;
	}
	public void setNumExteriorInmueble(String numExteriorInmueble) {
		this.numExteriorInmueble = numExteriorInmueble;
	}
	public String getNumInteriorInmueble() {
		return numInteriorInmueble;
	}
	public void setNumInteriorInmueble(String numInteriorInmueble) {
		this.numInteriorInmueble = numInteriorInmueble;
	}
	public int getIdConfInmueble() {
		return idConfInmueble;
	}
	public void setIdConfInmueble(int idConfInmueble) {
		this.idConfInmueble = idConfInmueble;
	}
	public int getIdTopografiaInmueble() {
		return idTopografiaInmueble;
	}
	public void setIdTopografiaInmueble(int idTopografiaInmueble) {
		this.idTopografiaInmueble = idTopografiaInmueble;
	}
	public String getUsoSuelo() {
		return usoSuelo;
	}
	public void setUsoSuelo(String usoSuelo) {
		this.usoSuelo = usoSuelo;
	}
	public String getCus() {
		return cus;
	}
	public void setCus(String cus) {
		this.cus = cus;
	}
	public String getDensidadHabitacional() {
		return densidadHabitacional;
	}
	public void setDensidadHabitacional(String densidadHabitacional) {
		this.densidadHabitacional = densidadHabitacional;
	}
	public String getUsoActual() {
		return usoActual;
	}
	public void setUsoActual(String usoActual) {
		this.usoActual = usoActual;
	}
	public int getNumRecamaras() {
		return numRecamaras;
	}
	public void setNumRecamaras(int numRecamaras) {
		this.numRecamaras = numRecamaras;
	}
	public int getNumBanios() {
		return numBanios;
	}
	public void setNumBanios(int numBanios) {
		this.numBanios = numBanios;
	}
	public int getNumEstacionamiento() {
		return numEstacionamiento;
	}
	public void setNumEstacionamiento(int numEstacionamiento) {
		this.numEstacionamiento = numEstacionamiento;
	}
	public int getIdCalidadProyecto() {
		return idCalidadProyecto;
	}
	public void setIdCalidadProyecto(int idCalidadProyecto) {
		this.idCalidadProyecto = idCalidadProyecto;
	}
	public int getIdClaseGralInmueble() {
		return idClaseGralInmueble;
	}
	public void setIdClaseGralInmueble(int idClaseGralInmueble) {
		this.idClaseGralInmueble = idClaseGralInmueble;
	}
	public int getIdEstadoConservacion() {
		return idEstadoConservacion;
	}
	public void setIdEstadoConservacion(int idEstadoConservacion) {
		this.idEstadoConservacion = idEstadoConservacion;
	}
	public int getEdadContruccion() {
		return edadContruccion;
	}
	public void setEdadContruccion(int edadContruccion) {
		this.edadContruccion = edadContruccion;
	}
	public int getVidaUtilRemanente() {
		return vidaUtilRemanente;
	}
	public void setVidaUtilRemanente(int vidaUtilRemanente) {
		this.vidaUtilRemanente = vidaUtilRemanente;
	}
	public int getNivelesConstruccion() {
		return nivelesConstruccion;
	}
	public void setNivelesConstruccion(int nivelesConstruccion) {
		this.nivelesConstruccion = nivelesConstruccion;
	}
	public String getGradoTerminacionObra() {
		return gradoTerminacionObra;
	}
	public void setGradoTerminacionObra(String gradoTerminacionObra) {
		this.gradoTerminacionObra = gradoTerminacionObra;
	}
	public String getGradoAvanceAreasComunes() {
		return gradoAvanceAreasComunes;
	}
	public void setGradoAvanceAreasComunes(String gradoAvanceAreasComunes) {
		this.gradoAvanceAreasComunes = gradoAvanceAreasComunes;
	}
	public String getSuperficieTerrenoVivienda() {
		return superficieTerrenoVivienda;
	}
	public void setSuperficieTerrenoVivienda(String superficieTerrenoVivienda) {
		this.superficieTerrenoVivienda = superficieTerrenoVivienda;
	}
	public String getSuperficieConstruida() {
		return superficieConstruida;
	}
	public void setSuperficieConstruida(String superficieConstruida) {
		this.superficieConstruida = superficieConstruida;
	}
	public String getSuperficieAccesorias() {
		return superficieAccesorias;
	}
	public void setSuperficieAccesorias(String superficieAccesorias) {
		this.superficieAccesorias = superficieAccesorias;
	}
	public String getSuperficieVendible() {
		return superficieVendible;
	}
	public void setSuperficieVendible(String superficieVendible) {
		this.superficieVendible = superficieVendible;
	}
	public String getIndivisosConstruccion() {
		return indivisosConstruccion;
	}
	public void setIndivisosConstruccion(String indivisosConstruccion) {
		this.indivisosConstruccion = indivisosConstruccion;
	}
	public String getIndivisosTerreno() {
		return indivisosTerreno;
	}
	public void setIndivisosTerreno(String indivisosTerreno) {
		this.indivisosTerreno = indivisosTerreno;
	}
	public int getIdInstHidraulicas() {
		return idInstHidraulicas;
	}
	public void setIdInstHidraulicas(int idInstHidraulicas) {
		this.idInstHidraulicas = idInstHidraulicas;
	}
	public String getMatInstHidraulicas() {
		return matInstHidraulicas;
	}
	public void setMatInstHidraulicas(String matInstHidraulicas) {
		this.matInstHidraulicas = matInstHidraulicas;
	}
	public int getIdInstSanitarias() {
		return idInstSanitarias;
	}
	public void setIdInstSanitarias(int idInstSanitarias) {
		this.idInstSanitarias = idInstSanitarias;
	}
	public String getMatInstSanitarias() {
		return matInstSanitarias;
	}
	public void setMatInstSanitarias(String matInstSanitarias) {
		this.matInstSanitarias = matInstSanitarias;
	}
	public int getIdInstElectricas() {
		return idInstElectricas;
	}
	public void setIdInstElectricas(int idInstElectricas) {
		this.idInstElectricas = idInstElectricas;
	}
	public int getIdElementosAdicionales() {
		return idElementosAdicionales;
	}
	public void setIdElementosAdicionales(int idElementosAdicionales) {
		this.idElementosAdicionales = idElementosAdicionales;
	}
	public String getElementosAdicionalesValor() {
		return elementosAdicionalesValor;
	}
	public void setElementosAdicionalesValor(String elementosAdicionalesValor) {
		this.elementosAdicionalesValor = elementosAdicionalesValor;
	}
	public String getValorComparativoTotal() {
		return valorComparativoTotal;
	}
	public void setValorComparativoTotal(String valorComparativoTotal) {
		this.valorComparativoTotal = valorComparativoTotal;
	}
	public String getValorComparativoM2() {
		return valorComparativoM2;
	}
	public void setValorComparativoM2(String valorComparativoM2) {
		this.valorComparativoM2 = valorComparativoM2;
	}
	public String getValorTerrenoTotal() {
		return valorTerrenoTotal;
	}
	public void setValorTerrenoTotal(String valorTerrenoTotal) {
		this.valorTerrenoTotal = valorTerrenoTotal;
	}
	public String getValorTerrenoM2() {
		return valorTerrenoM2;
	}
	public void setValorTerrenoM2(String valorTerrenoM2) {
		this.valorTerrenoM2 = valorTerrenoM2;
	}
	public String getValorConstruccionTotal() {
		return valorConstruccionTotal;
	}
	public void setValorConstruccionTotal(String valorConstruccionTotal) {
		this.valorConstruccionTotal = valorConstruccionTotal;
	}
	public String getValorConstruccionM2() {
		return valorConstruccionM2;
	}
	public void setValorConstruccionM2(String valorConstruccionM2) {
		this.valorConstruccionM2 = valorConstruccionM2;
	}
	public String getValorResidual() {
		return valorResidual;
	}
	public void setValorResidual(String valorResidual) {
		this.valorResidual = valorResidual;
	}
	public String getValorConcluido() {
		return valorConcluido;
	}
	public void setValorConcluido(String valorConcluido) {
		this.valorConcluido = valorConcluido;
	}
	public int getIdUbicaInmuebleTerreno() {
		return idUbicaInmuebleTerreno;
	}
	public void setIdUbicaInmuebleTerreno(int idUbicaInmuebleTerreno) {
		this.idUbicaInmuebleTerreno = idUbicaInmuebleTerreno;
	}
	public String getSuperficieTerrenoConjunto() {
		return superficieTerrenoConjunto;
	}
	public void setSuperficieTerrenoConjunto(String superficieTerrenoConjunto) {
		this.superficieTerrenoConjunto = superficieTerrenoConjunto;
	}
	public int getIdVigilancia() {
		return idVigilancia;
	}
	public void setIdVigilancia(int idVigilancia) {
		this.idVigilancia = idVigilancia;
	}
	public boolean isSenalizacionVial() {
		return senalizacionVial;
	}
	public void setSenalizacionVial(boolean senalizacionVial) {
		this.senalizacionVial = senalizacionVial;
	}
	public int getIdSuministroElectricidad() {
		return idSuministroElectricidad;
	}
	public void setIdSuministroElectricidad(int idSuministroElectricidad) {
		this.idSuministroElectricidad = idSuministroElectricidad;
	}
	public int getIdAguaPotable() {
		return idAguaPotable;
	}
	public void setIdAguaPotable(int idAguaPotable) {
		this.idAguaPotable = idAguaPotable;
	}
	public String getIndiceSaturacionZona() {
		return indiceSaturacionZona;
	}
	public void setIndiceSaturacionZona(String indiceSaturacionZona) {
		this.indiceSaturacionZona = indiceSaturacionZona;
	}
	public int getIdUsoConstrucciones() {
		return idUsoConstrucciones;
	}
	public void setIdUsoConstrucciones(int idUsoConstrucciones) {
		this.idUsoConstrucciones = idUsoConstrucciones;
	}
	public int getIdRefProximidadUrbana() {
		return idRefProximidadUrbana;
	}
	public void setIdRefProximidadUrbana(int idRefProximidadUrbana) {
		this.idRefProximidadUrbana = idRefProximidadUrbana;
	}
	public int getIdClaseZona() {
		return idClaseZona;
	}
	public void setIdClaseZona(int idClaseZona) {
		this.idClaseZona = idClaseZona;
	}
	public String getIdPeritoShf() {
		return idPeritoShf;
	}
	public void setIdPeritoShf(String idPeritoShf) {
		this.idPeritoShf = idPeritoShf;
	}
	public int getIdDensidadPoblacion() {
		return idDensidadPoblacion;
	}
	public void setIdDensidadPoblacion(int idDensidadPoblacion) {
		this.idDensidadPoblacion = idDensidadPoblacion;
	}
	public String getIdControladorShf() {
		return idControladorShf;
	}
	public void setIdControladorShf(String idControladorShf) {
		this.idControladorShf = idControladorShf;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getAltitud() {
		return altitud;
	}
	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	public String getOtroTipoSistema() {
		return otroTipoSistema;
	}
	public void setOtroTipoSistema(String otroTipoSistema) {
		this.otroTipoSistema = otroTipoSistema;
	}
	public int getIdExistenciaTransUrbano() {
		return idExistenciaTransUrbano;
	}
	public void setIdExistenciaTransUrbano(int idExistenciaTransUrbano) {
		this.idExistenciaTransUrbano = idExistenciaTransUrbano;
	}
	public int getIdExistenciaTranSuburbano() {
		return idExistenciaTranSuburbano;
	}
	public void setIdExistenciaTranSuburbano(int idExistenciaTranSuburbano) {
		this.idExistenciaTranSuburbano = idExistenciaTranSuburbano;
	}
	public int getRecMunicipalDesechosFrec() {
		return recMunicipalDesechosFrec;
	}
	public void setRecMunicipalDesechosFrec(int recMunicipalDesechosFrec) {
		this.recMunicipalDesechosFrec = recMunicipalDesechosFrec;
	}
	public int getIdNivelInfraurbana() {
		return idNivelInfraurbana;
	}
	public void setIdNivelInfraurbana(int idNivelInfraurbana) {
		this.idNivelInfraurbana = idNivelInfraurbana;
	}
	public int getIdExistenciaIglesia() {
		return idExistenciaIglesia;
	}
	public void setIdExistenciaIglesia(int idExistenciaIglesia) {
		this.idExistenciaIglesia = idExistenciaIglesia;
	}
	public int getIdExistenciaMercados() {
		return idExistenciaMercados;
	}
	public void setIdExistenciaMercados(int idExistenciaMercados) {
		this.idExistenciaMercados = idExistenciaMercados;
	}
	public int getIdExistenciaPlazaPublica() {
		return idExistenciaPlazaPublica;
	}
	public void setIdExistenciaPlazaPublica(int idExistenciaPlazaPublica) {
		this.idExistenciaPlazaPublica = idExistenciaPlazaPublica;
	}
	public int getIdExistenciaParquesJardines() {
		return idExistenciaParquesJardines;
	}
	public void setIdExistenciaParquesJardines(int idExistenciaParquesJardines) {
		this.idExistenciaParquesJardines = idExistenciaParquesJardines;
	}
	public int getIdExistenciaEscuelas() {
		return idExistenciaEscuelas;
	}
	public void setIdExistenciaEscuelas(int idExistenciaEscuelas) {
		this.idExistenciaEscuelas = idExistenciaEscuelas;
	}
	public int getIdExistenciaHospitales() {
		return idExistenciaHospitales;
	}
	public void setIdExistenciaHospitales(int idExistenciaHospitales) {
		this.idExistenciaHospitales = idExistenciaHospitales;
	}
	public int getIdExistenciaBancos() {
		return idExistenciaBancos;
	}
	public void setIdExistenciaBancos(int idExistenciaBancos) {
		this.idExistenciaBancos = idExistenciaBancos;
	}
	public int getIdExistenciaAccesoEstacionUrbano() {
		return idExistenciaAccesoEstacionUrbano;
	}
	public void setIdExistenciaAccesoEstacionUrbano(
			int idExistenciaAccesoEstacionUrbano) {
		this.idExistenciaAccesoEstacionUrbano = idExistenciaAccesoEstacionUrbano;
	}
	public int getIdExistenciaAccesoEstacionSuburbano() {
		return idExistenciaAccesoEstacionSuburbano;
	}
	public void setIdExistenciaAccesoEstacionSuburbano(
			int idExistenciaAccesoEstacionSuburbano) {
		this.idExistenciaAccesoEstacionSuburbano = idExistenciaAccesoEstacionSuburbano;
	}
	public int getIdExistenciaCentroComunitario() {
		return idExistenciaCentroComunitario;
	}
	public void setIdExistenciaCentroComunitario(int idExistenciaCentroComunitario) {
		this.idExistenciaCentroComunitario = idExistenciaCentroComunitario;
	}
	public int getIdNivelEquipamientoUrbano() {
		return idNivelEquipamientoUrbano;
	}
	public void setIdNivelEquipamientoUrbano(int idNivelEquipamientoUrbano) {
		this.idNivelEquipamientoUrbano = idNivelEquipamientoUrbano;
	}
	public int getReporteDensidad() {
		return reporteDensidad;
	}
	public void setReporteDensidad(int reporteDensidad) {
		this.reporteDensidad = reporteDensidad;
	}
	public int getIdExisteEspacioUsoMultiple() {
		return idExisteEspacioUsoMultiple;
	}
	public void setIdExisteEspacioUsoMultiple(int idExisteEspacioUsoMultiple) {
		this.idExisteEspacioUsoMultiple = idExisteEspacioUsoMultiple;
	}
	public int getNumMediosBanios() {
		return numMediosBanios;
	}
	public void setNumMediosBanios(int numMediosBanios) {
		this.numMediosBanios = numMediosBanios;
	}
	public String getResultadoCalidadProyecto() {
		return resultadoCalidadProyecto;
	}
	public void setResultadoCalidadProyecto(String resultadoCalidadProyecto) {
		this.resultadoCalidadProyecto = resultadoCalidadProyecto;
	}
	public String getComentariosEstadoConservacion() {
		return comentariosEstadoConservacion;
	}
	public void setComentariosEstadoConservacion(
			String comentariosEstadoConservacion) {
		this.comentariosEstadoConservacion = comentariosEstadoConservacion;
	}
	public String getMatInstElectricas() {
		return matInstElectricas;
	}
	public void setMatInstElectricas(String matInstElectricas) {
		this.matInstElectricas = matInstElectricas;
	}
	public String getValorHipotetico() {
		return valorHipotetico;
	}
	public void setValorHipotetico(String valorHipotetico) {
		this.valorHipotetico = valorHipotetico;
	}
	public int getDensidadHabitacionalHabitantes() {
		return densidadHabitacionalHabitantes;
	}
	public void setDensidadHabitacionalHabitantes(int densidadHabitacionalHabitantes) {
		this.densidadHabitacionalHabitantes = densidadHabitacionalHabitantes;
	}
	public int getDensidadHabitacionalViviendas() {
		return densidadHabitacionalViviendas;
	}
	public void setDensidadHabitacionalViviendas(int densidadHabitacionalViviendas) {
		this.densidadHabitacionalViviendas = densidadHabitacionalViviendas;
	}
	public int getIdSupermercados() {
		return idSupermercados;
	}
	public void setIdSupermercados(int idSupermercados) {
		this.idSupermercados = idSupermercados;
	}
	public int getIdLocalesComerciales() {
		return idLocalesComerciales;
	}
	public void setIdLocalesComerciales(int idLocalesComerciales) {
		this.idLocalesComerciales = idLocalesComerciales;
	}
	public int getNumLocalesComerciales() {
		return numLocalesComerciales;
	}
	public void setNumLocalesComerciales(int numLocalesComerciales) {
		this.numLocalesComerciales = numLocalesComerciales;
	}
	public int getIdExistenciaParques() {
		return idExistenciaParques;
	}
	public void setIdExistenciaParques(int idExistenciaParques) {
		this.idExistenciaParques = idExistenciaParques;
	}
	public int getIdExistenciaJardines() {
		return idExistenciaJardines;
	}
	public void setIdExistenciaJardines(int idExistenciaJardines) {
		this.idExistenciaJardines = idExistenciaJardines;
	}
	public int getIdCanchasDeportivas() {
		return idCanchasDeportivas;
	}
	public void setIdCanchasDeportivas(int idCanchasDeportivas) {
		this.idCanchasDeportivas = idCanchasDeportivas;
	}
	public int getIdCentroDeportivo() {
		return idCentroDeportivo;
	}
	public void setIdCentroDeportivo(int idCentroDeportivo) {
		this.idCentroDeportivo = idCentroDeportivo;
	}
	public int getIdEscuelasPrimarias() {
		return idEscuelasPrimarias;
	}
	public void setIdEscuelasPrimarias(int idEscuelasPrimarias) {
		this.idEscuelasPrimarias = idEscuelasPrimarias;
	}
	public int getIdEscuelasSecundarias() {
		return idEscuelasSecundarias;
	}
	public void setIdEscuelasSecundarias(int idEscuelasSecundarias) {
		this.idEscuelasSecundarias = idEscuelasSecundarias;
	}
	public int getIdEscuelasPreparatoria() {
		return idEscuelasPreparatoria;
	}
	public void setIdEscuelasPreparatoria(int idEscuelasPreparatoria) {
		this.idEscuelasPreparatoria = idEscuelasPreparatoria;
	}
	public int getIdUniversidad() {
		return idUniversidad;
	}
	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
	public int getIdOtrasEscuelas() {
		return idOtrasEscuelas;
	}
	public void setIdOtrasEscuelas(int idOtrasEscuelas) {
		this.idOtrasEscuelas = idOtrasEscuelas;
	}
	public int getIdServiciosSaludPrimerNivel() {
		return idServiciosSaludPrimerNivel;
	}
	public void setIdServiciosSaludPrimerNivel(int idServiciosSaludPrimerNivel) {
		this.idServiciosSaludPrimerNivel = idServiciosSaludPrimerNivel;
	}
	public int getIdServiciosSaludSegundoNivel() {
		return idServiciosSaludSegundoNivel;
	}
	public void setIdServiciosSaludSegundoNivel(int idServiciosSaludSegundoNivel) {
		this.idServiciosSaludSegundoNivel = idServiciosSaludSegundoNivel;
	}
	public int getIdServiciosSaludTercerNivel() {
		return idServiciosSaludTercerNivel;
	}
	public void setIdServiciosSaludTercerNivel(int idServiciosSaludTercerNivel) {
		this.idServiciosSaludTercerNivel = idServiciosSaludTercerNivel;
	}
	public int getIdTerrenoColinda() {
		return idTerrenoColinda;
	}
	public void setIdTerrenoColinda(int idTerrenoColinda) {
		this.idTerrenoColinda = idTerrenoColinda;
	}
	public int getIdTerrenoUbicado() {
		return idTerrenoUbicado;
	}
	public void setIdTerrenoUbicado(int idTerrenoUbicado) {
		this.idTerrenoUbicado = idTerrenoUbicado;
	}
	public int getIdRiesgoSocial() {
		return idRiesgoSocial;
	}
	public void setIdRiesgoSocial(int idRiesgoSocial) {
		this.idRiesgoSocial = idRiesgoSocial;
	}
	public int getIdRiesgoComercial() {
		return idRiesgoComercial;
	}
	public void setIdRiesgoComercial(int idRiesgoComercial) {
		this.idRiesgoComercial = idRiesgoComercial;
	}
	public String getFechaVisitaInmueble() {
		return fechaVisitaInmueble;
	}
	public void setFechaVisitaInmueble(String fechaVisitaInmueble) {
		this.fechaVisitaInmueble = fechaVisitaInmueble;
	}
	public int getIdMetodoConclusionAvaluo() {
		return idMetodoConclusionAvaluo;
	}
	public void setIdMetodoConclusionAvaluo(int idMetodoConclusionAvaluo) {
		this.idMetodoConclusionAvaluo = idMetodoConclusionAvaluo;
	}
	public String getMarcaViviendaUsadaMenorTres() {
		return marcaViviendaUsadaMenorTres;
	}
	public void setMarcaViviendaUsadaMenorTres(String marcaViviendaUsadaMenorTres) {
		this.marcaViviendaUsadaMenorTres = marcaViviendaUsadaMenorTres;
	}

	public String getValorOfertaMinimo() {
		return valorOfertaMinimo;
	}

	public void setValorOfertaMinimo(String valorOfertaMinimo) {
		this.valorOfertaMinimo = valorOfertaMinimo;
	}

	public String getValorOfertaMaximo() {
		return valorOfertaMaximo;
	}

	public void setValorOfertaMaximo(String valorOfertaMaximo) {
		this.valorOfertaMaximo = valorOfertaMaximo;
	}

	public String getSuperficieTerrenoMinimo() {
		return superficieTerrenoMinimo;
	}

	public void setSuperficieTerrenoMinimo(String superficieTerrenoMinimo) {
		this.superficieTerrenoMinimo = superficieTerrenoMinimo;
	}

	public String getSuperficieTerrenoMaximo() {
		return superficieTerrenoMaximo;
	}

	public void setSuperficieTerrenoMaximo(String superficieTerrenoMaximo) {
		this.superficieTerrenoMaximo = superficieTerrenoMaximo;
	}

	public String getSuperficieConstruccionMinimo() {
		return superficieConstruccionMinimo;
	}

	public void setSuperficieConstruccionMinimo(String superficieConstruccionMinimo) {
		this.superficieConstruccionMinimo = superficieConstruccionMinimo;
	}

	public String getSuperficieConstruccionMaximo() {
		return superficieConstruccionMaximo;
	}

	public void setSuperficieConstruccionMaximo(String superficieConstruccionMaximo) {
		this.superficieConstruccionMaximo = superficieConstruccionMaximo;
	}




	/**
	 * @return the avaluos
	 */
	public String getAvaluos() {
		return avaluos;
	}




	/**
	 * @param avaluos the avaluos to set
	 */
	public void setAvaluos(String avaluos) {
		this.avaluos = avaluos;
	}

	
	

}
