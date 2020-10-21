package mx.org.infonavit.solicitud.oferente.business;



import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.CriteriosAsignacionesDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosCancelacioneaDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaCancelacionInexDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaInexDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaPaquetesDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaReasignacionInexDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaSolicitudesInex;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosConsultaUPCDomain;
import mx.org.infonavit.solicitud.oferente.domain.CriteriosSancionesDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractGenericoDao;
import mx.org.infonavit.solicitud.oferente.persistence.ConsultaAvaluosGenericaDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.RegistrosVo;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaAsignacionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaAvaluoUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaCancelacionInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaCancelacionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaInexGeneralUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaPaquetesInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaReasignacionInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaSancionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaSolicitudesInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.BuilderSQLConsultaUPCUtils;
import mx.org.infonavit.solicitud.oferente.utils.Cadenas;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposAsignacionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCUPCUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCancelacionInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposCancelacionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposConsultaAvaluosUtil;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposInexGeneralUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposPaquetesInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposReasignacionInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposSancionesUtils;
import mx.org.infonavit.solicitud.oferente.utils.OrdenamientoCamposSolicitudesInexUtils;
import mx.org.infonavit.solicitud.oferente.utils.Resources;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConsultaAvaluosGenericaBusiness {
	
	public static List<String> DATOS;
	
	
	private static final Logger LOGGER = LogManager.getLogger(ConsultaAvaluosGenericaBusiness.class);
	private static final String PREFIJO_LOG = "[CAGB] - ";
	
	/**
	 * 
	 */
	public List<List<String>> informacion;
	
	@Autowired
	@Qualifier("ConsultaAvaluosGenericaDao")
	private AbstractGenericoDao<List<String>> persistenceGeneric;
	
	@Autowired
	@Qualifier("RegistrosConsultaDao")
	private AbstractDao<RegistrosVo> persistenceRegistro;
	
	
	public int consultarInformacionUPC(CriteriosConsultaUPCDomain criterios)
	{
		int regreso  = 0;
		LOGGER.info(PREFIJO_LOG+"Consultando información de unidades peritos y controladores..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposCUPCUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaUPCUtils.generarSentencia(criterios);
		
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		RegistrosVo registro = persistenceRegistro.buscar(new RegistrosVo(Cadenas.reemplazar(ConsultaAvaluosGenericaDao.FIND,ConsultaAvaluosGenericaDao.FIND.substring(ConsultaAvaluosGenericaDao.FIND.indexOf("SELECT")+"SELECT".length(), ConsultaAvaluosGenericaDao.FIND.indexOf("FROM")-1), " COUNT(*) AS registros ")));
		
		if( registro !=null && registro.getRegistros()>Resources.REGISTROS_POR_CONSULTA)
		{
			regreso = 2;
		}else
		{
			regreso = 1;
			List<List<String>> registros= persistenceGeneric.buscarLista(null);
			setInformacion(registros);
		}
	  return regreso;
	}
	
	
	public List<List<String>> consultarInformacionAsignaciones(CriteriosAsignacionesDomain criterios)
	{
		LOGGER.info(PREFIJO_LOG+"Consultando información de asignaciones y reasignaciones..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposAsignacionesUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaAsignacionesUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	
	/**
	 * <p>
	 * Método que ejecuta la consulta del Inex general.
	 * </p>
	 * @param criterios criterios de búsqueda que el usuario captura para la consulta.
	 * @return información encontrada de acuerdo a los criterios capturados.
	 */
	public List<List<String>> consultarInformacionInexGeneral(CriteriosConsultaInexDomain criterios)
	{
		
		LOGGER.info(PREFIJO_LOG+"Consultando información de Inex general..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposInexGeneralUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaInexGeneralUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	
	public List<List<String>> consultarInformacionCancelacionAvaluos(CriteriosCancelacioneaDomain criterios)
	{
		LOGGER.info(PREFIJO_LOG+"Consultando información de cancelacion de avaluos..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposCancelacionesUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaCancelacionesUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	
	public int consultarInformacionAvaluo(CriteriosConsultaAvaluoDomain criterios)
	{
		int regreso = 0;
		LOGGER.info(PREFIJO_LOG+"Consultando información de avaluos...." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposConsultaAvaluosUtil.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaAvaluoUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		
		RegistrosVo registro = persistenceRegistro.buscar(new RegistrosVo(Cadenas.reemplazar(ConsultaAvaluosGenericaDao.FIND,ConsultaAvaluosGenericaDao.FIND.substring(ConsultaAvaluosGenericaDao.FIND.indexOf("SELECT")+"SELECT".length(), ConsultaAvaluosGenericaDao.FIND.indexOf("FROM")-1), " COUNT(*) AS registros ")));
		if( registro !=null && registro.getRegistros()>Resources.REGISTROS_POR_CONSULTA)
		{
			regreso = 2;
		}else
		{
			regreso = 1;
			List<List<String>> registros= persistenceGeneric.buscarLista(null);
			setInformacion(registros);
		}
	  return regreso;
	}
	
	public List<List<String>> consultarInformacionSanciones(CriteriosSancionesDomain criterios)
	{
		LOGGER.info(PREFIJO_LOG+"Consultando información de avaluos...." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposSancionesUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaSancionesUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	
	/**
	 * <p>
	 * Método que ejecuta la consulta de paquetes para el Inex de Unidades de valuación.
	 * </p>
	 * @param criterios criterios de búsqueda que el usuario captura para la consulta.
	 * @return información encontrada de acuerdo a los criterios capturados.
	 */
	public List<List<String>> consultarPaquetesInex(CriteriosConsultaPaquetesDomain criterios)
	{
		
		LOGGER.info(PREFIJO_LOG+"Consultando información de paquetes Inex..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposPaquetesInexUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaPaquetesInexUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}

	/**
	 * <p>
	 * Método que ejecuta la consulta de paquetes para el Inex de Unidades de valuación.
	 * </p>
	 * @param criterios criterios de búsqueda que el usuario captura para la consulta.
	 * @return información encontrada de acuerdo a los criterios capturados.
	 */
	public List<List<String>> consultarSolicitudesInex(CriteriosConsultaSolicitudesInex criterios)
	{
		
		LOGGER.info(PREFIJO_LOG+"Consultando información de solicitudes Inex..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposSolicitudesInexUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaSolicitudesInexUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	
	/**
	 * <p>
	 * Método que ejecuta la consulta de cancelaciones de avalúo para el Inex de Unidades de valuación.
	 * </p>
	 * @param criterios criterios de búsqueda que el usuario captura para la consulta.
	 * @return información encontrada de acuerdo a los criterios capturados.
	 */
	public List<List<String>> consultarCancelacionInex(CriteriosConsultaCancelacionInexDomain criterios)
	{
		
		LOGGER.info(PREFIJO_LOG+"Consultando información de solicitudes Inex..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposCancelacionInexUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaCancelacionInexUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}
	/**
	 * <p>
	 * Método que ejecuta la consulta a la bitacora de reasignación de unidades de valuación a los avalúos para el Inex de Unidades de valuación.
	 * </p>
	 * @param criterios criterios de búsqueda que el usuario captura para la consulta.
	 * @return información encontrada de acuerdo a los criterios capturados.
	 */
	public List<List<String>> consultarBitacoraReasignacionInex(CriteriosConsultaReasignacionInexDomain criterios)
	{
		
		LOGGER.info(PREFIJO_LOG+"Consultando información de solicitudes Inex..." );
		ConsultaAvaluosGenericaBusiness.DATOS = OrdenamientoCamposReasignacionInexUtils.ordenarCampos(ConsultaAvaluosGenericaBusiness.DATOS);
		ConsultaAvaluosGenericaDao.FIND = BuilderSQLConsultaReasignacionInexUtils.generarSentencia(criterios);
		LOGGER.info(PREFIJO_LOG+"Query: " + ConsultaAvaluosGenericaDao.FIND);
		List<List<String>> registros= persistenceGeneric.buscarLista(null);
		return registros;
	}

	/**
	 * @return El valor de: informacion
	 */
	public List<List<String>> getInformacion() {
		return informacion;
	}


	/**
	 * @param Valor: informacion a asignar en: informacion
	 */
	public void setInformacion(List<List<String>> informacion) {
		this.informacion = informacion;
	}

	
	
	
	
	
	
	

}
