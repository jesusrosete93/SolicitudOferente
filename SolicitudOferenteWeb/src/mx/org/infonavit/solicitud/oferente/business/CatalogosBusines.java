package mx.org.infonavit.solicitud.oferente.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import mx.org.infonavit.seguridad.servicios.utilerias.ServiciosSeguridad;
import mx.org.infonavit.solicitud.oferente.business.services.CatalogoBusinessService;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposBitacoraReasignacion;
import mx.org.infonavit.solicitud.oferente.catalogos.CamposInexGeneral;
import mx.org.infonavit.solicitud.oferente.catalogos.CatalogoEstadoConservacion;
import mx.org.infonavit.solicitud.oferente.catalogos.CatalogoMetodoConclusionAvaluo;
import mx.org.infonavit.solicitud.oferente.catalogos.Estado;
import mx.org.infonavit.solicitud.oferente.catalogos.Inex;
import mx.org.infonavit.solicitud.oferente.catalogos.TipoPaquete;
import mx.org.infonavit.solicitud.oferente.domain.UnidadValuacionDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CampoBdVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.CatalogoVO;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EstatusVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PuntoEntregaVO;
import mx.org.infonavit.solicitud.oferente.persistence.vo.TablaBdVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.UnidadValuacionVo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Esta clase realiza la consulta de todos los catalogos utilizados 
 * en el sistema de administración programa: FERUV, y los carga 
 * para que sean utilizados en el momento que se necesiten duarnte la operación.
 * 
 * @author Adrian Casas
 *
 */
@Service("CatalogosBusines")
public class CatalogosBusines {
	
	/**
	 * Envia mensajes al archivo log y consola del servidor 
	 */
	private static final  Logger LOGGER = LogManager.getLogger(CatalogosBusines.class);
	
	
	/**
	 * Catalogo de tablas de la base de datos de avaluos
	 */
	public static Map<Integer,TablaBdVo> CATALOGO_TABLAS_AVALUOS;
	/**
	 * Catalogo de campos de la taba que guarda los datos de las unidades de valuación
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_UV;

	/**
	 * Catalogo de campos de la taba que guarda los datos de cobertura 
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_COBERTURA;

	/**
	 * Catalogo de campos de la taba que guarda los datos de losc ontroladores
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_CONTROLADORES_UV;
	/**
	 * Catalogo de campos de la taba que guarda los datos de losc ontroladores
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_CONTROLADOR;
	/**
	 * Catalogo de campos de la taba que guarda los datos de los peritos 
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_PERITOS_UV;
	/**
	 * Catalogo de campos de la taba que guarda los datos de los peritos 
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_PERITO;
	/**
	 * Catalogo de campos de la taba que guarda los datos del paquete 
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_PAQUETE;
	/**
	 * Catalogo de campos de la taba que guarda los datos de Bitacora_Reasignacion
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_BITACORA_REASIGNACION;
	/**
	 * Catalogo de campos de la taba que guarda los datos de temporalasignaciones
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES;
	/**
	 * Catalogo de campos de la taba que guarda los datos de canclación de avaluos
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_CANCELACION_AVALUO;
	/**
	 * Catalogo de campos de la taba que guarda los datos del historico de valor concluido de avaluos
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO;
	/**
	 * Catalogo de campos de la taba que guarda los datos del respaldo de la cancelación de avaluos
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_CANCELACION_RESPALDO;
	/**
	 * Catalogo de campos de la tabla: Avaluo
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_AVALUO;
	/**
	 * Catalogo de campos de la tabla: Detalle avaluo
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_DETALLE_AVALUO;
	/**
	 * Catalogo de campos de la tabla: sancion
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_SANCION;
	/**
	 * Catalogo de campos de la tabla: cat_tipo_sancion
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_TIPO_SANCION;
	/**
	 * Catalogo de campos de la tabla: cat_sancionado
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_SANCIONADO;
	/**
	 * Catalogo de campos de la tabla: cat_sancionador
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_SANCIONADOR;
	/**
	 * Catalogo de campos de la tabla: cat_delegacion
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_DELEGACION;
	/**
	 * Catalogo de campos de la tabla: vivienda
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_VIVIENDA;
	/**
	 * Catalogo de campos de la tabla: cat_oferente
	 */
	public static Map<String,CampoBdVo> CATALOGO_CAMPOS_OFERENTE;
	/**
	 * Catalogo de los estatus que se tienen registrados en la base de avalúos.
	 */
	public static Map<String,String> CATALOGO_ESTATUS;
	
	
	/**
	 * Catalogo de delegaciones 
	 */
	public static Map<String,String> CATALOGO_DELEGACIONES;
	/**
	 * Catalogo de meses del año 
	 */
	public static Map<String,String> CATALOGO_MESES;
	/**
	 * Catalogo de unidades de valuación
	 */
	public static Map<String,String> CATALOGO_UNIDADES_VALUACION;
	/**
	 * Catalogo de unidades de valuación
	 */
	public static Map<Integer,UnidadValuacionDomain> UNIDADES_VALUACION;
	/**
	 * Catalogo de tipos de sanciones
	 */
	public static Map<Integer,String> CATALOGO_TIPO_SANCION;
	/**
	 * Catalogo de entidades que pueden ser sancionadas
	 */
	public static Map<Integer,String> CATALOGO_SANCIONADO;
	/**
	 * Catalogo de entidades que pueden aplicar una sanción
	 */
	public static Map<Integer,String> CATALOGO_SANCIONADOR;

	/**
	 * Catalogo de estatus sanción
	 */
	public static Map<String,String> CATALOGO_ESTATUS_SANCION;
	/**
	 * Catalogo de estatus sanción
	 */
	public static Map<String,String> CATALOGO_TIPO_MERCADO;
	/**
	 * Catalogo de estatus sanción
	 */
	public static Map<String,String> CATALOGO_TIPO_LINEA;
	/**
	 * Catalogo de avaluos subvaluados
	 */
	public static Map<Integer,String> CATALOGO_SUBVALUADOS;
	/**
	 * Catalogo de tipo inmueble valuado
	 */
	public static Map<String,String> CATALOGO_TIPO_INMUEBLE_VALUADO;
	/**
	 * Catalogo de clase inmueble
	 */
	public static Map<String,String> CATALOGO_CLASE_INMUEBLE;
	
	
	
	/**
	 * Servicio del catalogo de metodo de conclusión de avaluo
	 */
	@Autowired
	@Qualifier("CatalogoMetodoConclusionAvaluo")
	private CatalogoMetodoConclusionAvaluo serviceCMCA;
	
	/**
	 * Servicio del catalogo de estado consevración
	 */
	@Autowired
	@Qualifier("CatalogoEstadoConservacion")
	private CatalogoEstadoConservacion serviceCEC;


	/**
	 * 
	 */
	@Autowired
	@Qualifier("PuntoEntregaDAO")
	private AbstractDao<PuntoEntregaVO> persistencePuntosEntrega;
	
	@Autowired
	@Qualifier("CatalogoCamposDao")
	private AbstractDao<CampoBdVo> persistenceCamposBd;
	@Autowired
	@Qualifier("CatalogoTablasDao")
	private AbstractDao<TablaBdVo> persistenceTablasBd;
	@Autowired
	@Qualifier("CatalogoUnidadValuacionDao")
	private AbstractDao<UnidadValuacionVo> persistenceUnidadValuacion;
	
	@Autowired
	@Qualifier("CatalogoEstatusDao")
	private AbstractDao<EstatusVo> persistenceEstatus;
	
	@Autowired
	@Qualifier("CatalogoTipoSancionDao")
	private AbstractDao<EstatusVo> persistenceTipoSancion;
	
	
	
	@Autowired
	@Qualifier("CatalogoSancionadoDao")
	private AbstractDao<EstatusVo> persistenceSancionado;
	
	@Autowired
	@Qualifier("CatalogoSancionadorDao")
	private AbstractDao<EstatusVo> persistenceSancionador;
	
	
	@Autowired
	@Qualifier("CatalogoTipoLineaDao")
	private AbstractDao<CatalogoVO> persistenceLinea;
	@Autowired
	@Qualifier("CatalogoTipoMercadoDao")
	private AbstractDao<CatalogoVO> persistenceMercado;
	
	@Autowired
	@Qualifier("CatalogoTipoInmuebleValuadoDao")
	private AbstractDao<CatalogoVO> persistenceCatalogoTipoInmueble;
	@Autowired
	@Qualifier("CatalogoClaseInmuebleDao")
	private AbstractDao<CatalogoVO> persistenceCatalogoClaseInmueble;
	
	@Autowired
	@Qualifier("Estado")
	private  Estado catalogoEstado;
	
	@Autowired
	@Qualifier("CamposInexGeneral")
	private CatalogoBusinessService catalogoCamposInexGeneral;

	
	@Autowired
	@Qualifier("Inex")
	private CatalogoBusinessService catalogoInexs;
	
	@Autowired
	@Qualifier("TipoPaquete")
	private CatalogoBusinessService catalogoTipoPaquete;
	
	@Autowired
	@Qualifier("CamposBitacoraReasignacion")
	private CatalogoBusinessService catalogoCamposBitacoraReasignacion;
	

	/**
	 * Realiza la carga de los siguientes catalogos utilizados para FERUV:
	 *  	<ul>
	 *  		<li>Estatus vivienda</li>
	 *  		<li>Estatus oferente</li>
	 *          <li>Estatus pago</li>
	 *      </ul>
	 */
	public void cargarCatalogos()
	{
		LOGGER.info("[CB] - Cargando catalogos de reportes...");
		cargarCatalogoUnidadesValuacion();
		cargarCatalogoTablasAvaluos();
		cargarCatalogoPuntosEntregaSeguridad();
		cargarCatalogoDelegaciones();
		cargarCatalogoMeses();
		cargarCatalogoCamposUV();
		cargarCatalogoCamposCobertura();
		cargarCatalogoCamposControladoresUv();
		cargarCatalogoCamposPeritosUv();
		cargarCatalogoCamposControlador();
		cargarCatalogoCamposPerito();
		cargarCatalogoCamposPaquete();
		cargarCatalogoCamposOferente();
		cargarCatalogoCamposBitacoraReasigacion();
		cargarCatalogoCamposTemporalAsignaciones();
		cargarCatalogoCamposCancelacion();
		cargarCatalogoCamposCanelacionRespaldo();
		cargarCatalogoCamposHistoricoValorConcluido();
		cargarCatalogoCamposDetalleAvaluo();
		cargarCatalogoCamposAvaluo();
		cargarCatalogoCamposVivienda();
		cargarCatalogoEstatus();
		cargarCatalogoCamposSancion();
		cargarCatalogoCamposSancionado();
		cargarCatalogoCamposSancionadores();
		cargarCatalogoCamposTipoSancion();
		cargarCatalogoTipoSancion();
		cargarCatalogoSancionado();
		cargarCatalogoSancionador();
		cargarCatalogoDelegacion();
		cargarCatalogoTipoMercado();
		cargarCatalogoTipoLinea();
		cargarCatalogoAvaluosSubvaluados();
		cargarCatalogoTipoInmuebleValuado();
		cargarCatalogoClaseInmueble();
		serviceCMCA.cargarCatalogo();
		serviceCEC.cargarCatalogo();
		cargarCatalogoEstados();
		cargarCatalogoCamposInexGeneral();
		cargarCatalogoInexs();
		cargarCatalogoTipoPaquetesInex();
		cargarCatalogoCamposBitacoraReasignacionInex();
		LOGGER.info("[CB] - Catalogos de reportes cargados exitosamente.");
		displayInformation();
	}
	
	
	/**
	 * Obtiene las url's de los servicios web del módulo de seguridad 
	 */
	public void cargarCatalogoPuntosEntregaSeguridad()
	{
		
		List<PuntoEntregaVO> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando url's de seguridad inicio OK");
			PuntoEntregaVO seguridad = new PuntoEntregaVO();
			
			seguridad.setIdAplicacion(1);
			seguridad.setIdServicio(1);
			
			registros =  persistencePuntosEntrega.buscarLista(seguridad);
			
			for(PuntoEntregaVO registro : registros)
			{
				 if( registro.getIdOperacion()==1)
	    	      {
	    	    	  ServiciosSeguridad.EP_LOGIN = registro.getPuntoEntrega();
	    	      }
	    	      if( registro.getIdOperacion()==2)
	    	      {
	    	    	  ServiciosSeguridad.EP_PERFILES = registro.getPuntoEntrega();
	    	      }
	    	      if( registro.getIdOperacion()==3)
	    	      {
	    	    	  ServiciosSeguridad.EP_SITUACION_LABORAL= registro.getPuntoEntrega();
	    	      }
	    	      if( registro.getIdOperacion()==4)
	    	      {
	    	    	  ServiciosSeguridad.EP_ADMIN_USUARIOS = registro.getPuntoEntrega();
	    	      }
			}
			LOGGER.info("[CB] - Cargando url's de seguridad fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando url's de seguridad fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de puntos de entrega de seguridad",e);	
		}
		 
	}
	
	/**
	 * Obtiene las url's de los servicios web de: SAP 
	 */
	public void cargarCatalogoDelegaciones()
	{
		Map<String,String> delegaciones = new LinkedHashMap<String, String>();

			
		
		
		delegaciones.put("1","AGUASCALIENTES");
		delegaciones.put("2","BAJA CALIFORNIA");
		delegaciones.put("3","BAJA CALIFORNIA SUR");
		delegaciones.put("4","CAMPECHE");
		delegaciones.put("5","COAHUILA DE ZARAGOZA");
		delegaciones.put("6","COLIMA");
		delegaciones.put("7","CHIAPAS");
		delegaciones.put("8","CHIHUAHUA ");
		delegaciones.put("9","DISTRITO FEDERAL");
		delegaciones.put("10","DURANGO");
		delegaciones.put("11","GUANAJUATO");
		delegaciones.put("12","GUERRERO");
		delegaciones.put("13","HIDALGO");
		delegaciones.put("14","JALISCO");
		delegaciones.put("15","ESTADO DE MEXICO");
		delegaciones.put("16","MICHOACAN DE OCAMPO ");
		delegaciones.put("17","MORELOS");
		delegaciones.put("18","NAYARIT");
		delegaciones.put("19","NUEVO LEON");
		delegaciones.put("20","OAXACA");
		delegaciones.put("21","PUEBLA");
		delegaciones.put("22","QUERETARO DE ARTEAGA");
		delegaciones.put("23","QUINTANA ROO");
		delegaciones.put("24","SAN LUIS POTOSI");
		delegaciones.put("25","SINALOA ");
		delegaciones.put("26","SONORA");
		delegaciones.put("27","TABASCO ");
		delegaciones.put("28","TAMAULIPAS");
		delegaciones.put("29","TLAXCALA");
		delegaciones.put("30","VERACRUZ LLAVE");
		delegaciones.put("31","YUCATAN");
		delegaciones.put("32","ZACATECAS");
		
		CatalogosBusines.CATALOGO_DELEGACIONES = delegaciones;

	}
	
	/**
	 * Obtiene las url's de los servicios web de: SAP 
	 */
	public void cargarCatalogoMeses()
	{
//		Map<String,String> meses = new TreeMap<String, String>(new Comparator<String>(){
//
//			@Override
//			public int compare(String object1, String object2) {
//				 if( Integer.parseInt(object1) >= Integer.parseInt(object2) )
//				 {
//					 return 1;
//				 }else
//				 {
//					 return 0;
//				 }
//			}
//			
//		});
		Map<String,String> meses = new LinkedHashMap<String, String>();
		meses.put("1","Enero");
		meses.put("2","Febrero");
		meses.put("3","Marzo");
		meses.put("4","Abril");
		meses.put("5","Mayo");
		meses.put("6","Junio");
		meses.put("7","Julio");
		meses.put("8","Agosto ");
		meses.put("9","Septiembre");
		meses.put("10","Octubre");
		meses.put("11","Noviembre");
		meses.put("12","Diciembre");
		CatalogosBusines.CATALOGO_MESES = meses;
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoUnidadesValuacion()
	{
		List<UnidadValuacionVo> registros= null;
		List<UnidadValuacionVo> activas= new ArrayList<UnidadValuacionVo>();
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: uvs inicio OK");
			registros =  persistenceUnidadValuacion.buscarLista(null);
			
			if( registros!=null && !registros.isEmpty() )
			{
				CollectionUtils.select(registros,new Predicate(){
					@Override
					public boolean evaluate(Object arg0) {
						return ((UnidadValuacionVo)arg0).getEstatus()==19;
					}
			},activas);
				
			if(activas!=null && !activas.isEmpty())
			{
				Collections.sort(activas,new Comparator<UnidadValuacionVo>(){
														@Override
														public int compare(UnidadValuacionVo object1,
																UnidadValuacionVo object2) {
															return object1.getNombreUnidadValuacion().compareTo(object2.getNombreUnidadValuacion());
														}});
				Map<String,String> unidad = new LinkedHashMap<String,String>();
				CatalogosBusines.UNIDADES_VALUACION = new HashMap<Integer, UnidadValuacionDomain>();
				for(UnidadValuacionVo registro : activas)
				{
					unidad.put(String.valueOf(registro.getIdUnidadValuacion()),registro.getNombreUnidadValuacion());
					CatalogosBusines.UNIDADES_VALUACION.put(registro.getIdUnidadValuacion(),UnidadValuacionBusiness.getDomain(registro));
					
				}
				CatalogosBusines.CATALOGO_UNIDADES_VALUACION = unidad;
			}
				
				
			
			}	
			LOGGER.info("[CB] - Cargando catalogo de: uvs fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: uvs fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de uvs",e);	
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoTablasAvaluos()
	{
		List<TablaBdVo> registrosTablas= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: tablas de avaluo inicio OK");
			registrosTablas =  persistenceTablasBd.buscarLista(null);
			
			if( !registrosTablas.isEmpty() )
			{
				Map<Integer,TablaBdVo> tablas = new HashMap<Integer,TablaBdVo>();
				for(TablaBdVo registro : registrosTablas)
				{
					 tablas.put(registro.getIdTabla(),registro);
				}
				CatalogosBusines.CATALOGO_TABLAS_AVALUOS = tablas;
			}	
			LOGGER.info("[CB] - Cargando catalogo de: tablas de avaluo fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: tablas de avaluo fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de tablas avaluos",e);	
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposUV()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de uv inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(1);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos   = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
					
				}
				CatalogosBusines.CATALOGO_CAMPOS_UV = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de uv fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de uv fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de camos de uv",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposCobertura()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cobertura inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(2);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
				}
				CatalogosBusines.CATALOGO_CAMPOS_COBERTURA = campos;
				
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cobertura fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cobertura fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cobertura",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposControladoresUv()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de controladores uv inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(3);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
				}
				CatalogosBusines.CATALOGO_CAMPOS_CONTROLADORES_UV = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de controladores uv fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de controladores uv fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de controladores uv",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposPeritosUv()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de peritos uv inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(4);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
				}
				CatalogosBusines.CATALOGO_CAMPOS_PERITOS_UV = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de peritos uv fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de peritos uv fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de peritos uv",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposControlador()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de perito inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(5);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
				}
				CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de perito fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de perito fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de perito",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposPerito()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(6);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_PERITO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de sancion",e);	
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposPaquete()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de paquete inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(11);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_PAQUETE = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de paquete fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de paquete fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de paquete",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposOferente()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de oferente inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(23);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_OFERENTE = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de oferente fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de oferente fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de oferente",e);	
		}
	}
	
	
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposBitacoraReasigacion()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de bitacoraR inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(12);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de bitacoraR fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de bitacoraR fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de bitacoraR",e);	
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposTemporalAsignaciones()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de temporalA inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(13);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de temporalA fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de temporalA fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de temporalA",e);	
		}
	}
	
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposCancelacion()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelación inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(8);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelación fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelación fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cancelación",e);	
		}
	}
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposHistoricoValorConcluido()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de historico inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(9);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de historico fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de historico fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de historico",e);	
		}
	}
	
	
	/**
	 * 
	 */
	public void cargarCatalogoCamposCanelacionRespaldo()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelacion respaldo inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(10);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelacion respaldo fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cancelacion respaldo fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cancelacion respaldo",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposAvaluo()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(16);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_AVALUO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de avaluo",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposDetalleAvaluo()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(14);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de avaluo fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de avaluo",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoCamposVivienda()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de vivienda inicio OK");
			CampoBdVo criterio = new CampoBdVo();
			criterio.setIdTabla(15);
			registrosCampos =  persistenceCamposBd.buscarLista(criterio);
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de vivienda fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de vivienda fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de vivienda",e);	
		}
	}
	/**
	 * 
	 */
	public void cargarCatalogoEstatus()
	{
		List<EstatusVo> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: estatus inicio OK");
			registros =  persistenceEstatus.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<String,String> estatus = new HashMap<String, String>();
				for(EstatusVo registro : registros )
				{
					estatus.put(String.valueOf(registro.getIdEstatus()),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_ESTATUS = estatus;
			}
			LOGGER.info("[CB] - Cargando catalogo de: estatus fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: estatus fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de estatus",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: sanción
	 */
	public void cargarCatalogoCamposSancion()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion inicio OK");
			registrosCampos =  persistenceCamposBd.buscarLista(new CampoBdVo(7));
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_SANCION = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de sancion fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de sancion",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_sancionado
	 */
	public void cargarCatalogoCamposSancionado()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado inicio OK");
			registrosCampos =  persistenceCamposBd.buscarLista(new CampoBdVo(17));
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_sancionado",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_tipo_sancion
	 */
	public void cargarCatalogoCamposTipoSancion()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_tipo_sancion inicio OK");
			registrosCampos =  persistenceCamposBd.buscarLista(new CampoBdVo(18));
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_tipo_sancion fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_tipo_sancion fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_tipo_sancion",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_sancionador
	 */
	public void cargarCatalogoCamposSancionadores()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador inicio OK");
			registrosCampos =  persistenceCamposBd.buscarLista(new CampoBdVo(19));
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_sancionador",e);	
		}
	}
	/**
	 * Carga el catalogo de sancionadores
	 */
	public void cargarCatalogoSancionador()
	{
		List<EstatusVo> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador inicio OK");
			registros =  persistenceSancionador.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<Integer,String> sancionadores = new LinkedHashMap<Integer, String>();
				for(EstatusVo registro : registros )
				{
					sancionadores.put(registro.getIdEstatus(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_SANCIONADOR = sancionadores;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_sancionador",e);	
		}
	}
	/**
	 * Carga el catalogo de sancionados
	 * 	 */
	public void cargarCatalogoSancionado()
	{
		List<EstatusVo> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado inicio OK");
			registros =  persistenceSancionado.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<Integer,String> sancionados = new LinkedHashMap<Integer,String>();
				for(EstatusVo registro : registros )
				{
					sancionados.put(registro.getIdEstatus(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_SANCIONADO = sancionados;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionado fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_sancionado",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_sancionador
	 */
	public void cargarCatalogoDelegacion()
	{
		List<CampoBdVo> registrosCampos= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador inicio OK");
			registrosCampos =  persistenceCamposBd.buscarLista(new CampoBdVo(20));
			
			if( !registrosCampos.isEmpty() )
			{
				Map<String,CampoBdVo> campos = new LinkedHashMap<String, CampoBdVo>();
				for(CampoBdVo campo : registrosCampos )
				{
					campos.put(campo.getNombreColumna(),campo);
							}
				CatalogosBusines.CATALOGO_CAMPOS_DELEGACION = campos;
			}
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de: campos de cat_sancionador fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de campos de cat_sancionador",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_sancionador
	 */
	public void cargarCatalogoTipoSancion()
	{
		List<EstatusVo> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo sancion inicio OK");
			registros =  persistenceTipoSancion.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<Integer,String> tipos = new LinkedHashMap<Integer, String>();
				for(EstatusVo registro : registros )
				{
					tipos.put(registro.getIdEstatus(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_TIPO_SANCION = tipos;
			}
			LOGGER.info("[CB] - Cargando catalogo: tipo sancion fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo sancion fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de: tipo sancion",e);	
		}
	}
	/**
	 * Carga el catalogo de tipos de mercado
	 */
	public void cargarCatalogoTipoMercado()
	{
		List<CatalogoVO> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado inicio OK");
			registros =  persistenceMercado.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<String,String> tipos = new LinkedHashMap<String, String>();
				for(CatalogoVO registro : registros )
				{
					tipos.put(registro.getClave(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_TIPO_MERCADO = tipos;
			}
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de: tipo mercado",e);	
		}
	}
	/**
	 * Carga el catalogo de tipo linea
	 */
	public void cargarCatalogoTipoLinea()
	{
		List<CatalogoVO> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado inicio OK");
			registros =  persistenceLinea.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<String,String> tipos = new LinkedHashMap<String, String>();
				for(CatalogoVO registro : registros )
				{
					tipos.put(registro.getClave(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_TIPO_LINEA = tipos;
			}
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo mercado fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de: tipo mercado",e);	
		}
	}
	/**
	 * Carga el catalogo de tipo de inmueble valuado
	 */
	public void cargarCatalogoTipoInmuebleValuado()
	{
		List<CatalogoVO> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo inmueble valuado inicio OK");
			registros =  persistenceCatalogoTipoInmueble.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<String,String> tipos = new LinkedHashMap<String, String>();
				for(CatalogoVO registro : registros )
				{
					tipos.put(registro.getClave(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_TIPO_INMUEBLE_VALUADO = tipos;
			}
			LOGGER.info("[CB] - Cargando catalogo:tipo inmueble valuado fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo: tipo inmueble valuado fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de: tipo inmueble valuado",e);	
		}
	}
	/**
	 * Carga el catalogo de clase de inmueble 
	 */
	public void cargarCatalogoClaseInmueble()
	{
		List<CatalogoVO> registros= null;
		try
		{
			LOGGER.info("[CB] - Cargando catalogo: clase inmueble inicio OK");
			registros =  persistenceCatalogoClaseInmueble.buscarLista(null);
			
			if( !registros.isEmpty() )
			{
				Map<String,String> tipos = new LinkedHashMap<String, String>();
				for(CatalogoVO registro : registros )
				{
					tipos.put(registro.getClave(),registro.getDescripcion());
							}
				CatalogosBusines.CATALOGO_CLASE_INMUEBLE = tipos;
			}
			LOGGER.info("[CB] - Cargando catalogo: clase inmueble fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo: clase inmueble fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de: clase inmueble",e);	
		}
	}
	/**
	 * Carga los campos de la tabla: cat_sancionador
	 */
	public void cargarCatalogoEstatusSancion()
	{
		
		try
		{
			LOGGER.info("[CB] - Cargando catalogo de estatus sancion inicio OK");
			Map<Integer,String> catalogo = new HashMap<Integer, String>();
			
			catalogo.put(35,"Sancion Activa");
			catalogo.put(36,"Sancion Cumplida");
			
			
			LOGGER.info("[CB] - Cargando catalogo de estatus sancion fin OK");
		}catch(Exception e)
		{
			LOGGER.info("[CB] - Cargando catalogo de estatus sancion fin NOK");
			LOGGER.error("[CB] - Error en la carga del catalogo de estatus sancion",e);	
		}
	}
	
	/**
	 * <p>Método que realiza la carga del catalogo de los estados de la republica</p>
	 */
	public void cargarCatalogoEstados()
	{
		catalogoEstado.cargarCatalogoEstados();
	}
	
	
	/**
	 * Carga el catalogo de tipos de avaluos subvaluados.
	 */
	public void cargarCatalogoAvaluosSubvaluados()
	{
		LOGGER.info("[CB] - Cargando catalogo de subvaluados inicio - OK");
		CatalogosBusines.CATALOGO_SUBVALUADOS = new HashMap<Integer, String>();
		CatalogosBusines.CATALOGO_SUBVALUADOS.put(1, "Sub valuado");
		CatalogosBusines.CATALOGO_SUBVALUADOS.put(2, "Sobre valuado");
		CatalogosBusines.CATALOGO_SUBVALUADOS.put(3, "Superior a la inflación");
		LOGGER.info("[CB] - Cargando catalogo de subvaluados fin - OK");
	}
	
	/**
	 * Realiza la carga del catalogo de campos Inex General
	 */
	public void cargarCatalogoCamposInexGeneral()
	{
	  catalogoCamposInexGeneral.cargarCatalogo();
	}
	
	/**
	 * Realiza la carga del catalogo de Inex's registrados.
	 */
	public void cargarCatalogoInexs()
	{
		catalogoInexs.cargarCatalogo();
	}
	/**
	 * Realiza la carga del catalogo de los tipos de paquetes para Inex.
	 */
	public void cargarCatalogoTipoPaquetesInex()
	{
		catalogoTipoPaquete.cargarCatalogo();
	}
	
	/**
	 * Realiza la carga del catalogo de los campos de la tabla bitacora_reasignacion_inex.
	 */
	public void cargarCatalogoCamposBitacoraReasignacionInex()
	{
		catalogoCamposBitacoraReasignacion.cargarCatalogo();
	}
	
	
	

	/**
	 * Envia los datos cargados de los catalogos de FERUV al archivo log y consola del servidor 
	 */
	public static void displayInformation()
	{
		LOGGER.info("[CB] - Catalogo UVs: ["+CatalogosBusines.CATALOGO_UNIDADES_VALUACION+"]");
		LOGGER.info("[CB] - Catalogo UVs 1: ["+CatalogosBusines.UNIDADES_VALUACION+"]");
		LOGGER.info("[CB] - Catalogo tablas avaluos: ["+CatalogosBusines.CATALOGO_TABLAS_AVALUOS+"]");
		LOGGER.info("[CB] - Catalogo delegaciones: ["+CatalogosBusines.CATALOGO_DELEGACIONES+"]");
		LOGGER.info("[CB] - Catalogo meses: ["+CatalogosBusines.CATALOGO_MESES+"]");
		LOGGER.info("[CB] - Catalogo subvaluados: ["+CatalogosBusines.CATALOGO_SUBVALUADOS+"]");
		LOGGER.info("[CB] - Catalogo tipo inmueble valuado: ["+CatalogosBusines.CATALOGO_TIPO_INMUEBLE_VALUADO+"]");
		LOGGER.info("[CB] - Catalogo clase inmueble: ["+CatalogosBusines.CATALOGO_CLASE_INMUEBLE+"]");
		LOGGER.info("[CB] - Campos UV: ["+CatalogosBusines.CATALOGO_CAMPOS_UV+"]");
		LOGGER.info("[CB] - Campos Cobertura: ["+CatalogosBusines.CATALOGO_CAMPOS_COBERTURA+"]");
		LOGGER.info("[CB] - Campos Peritos UVs: ["+CatalogosBusines.CATALOGO_CAMPOS_PERITOS_UV+"]");
		LOGGER.info("[CB] - Campos Controladores UVs: ["+CatalogosBusines.CATALOGO_CAMPOS_CONTROLADORES_UV+"]");
		LOGGER.info("[CB] - Campos Perito: ["+CatalogosBusines.CATALOGO_CAMPOS_PERITO+"]");
		LOGGER.info("[CB] - Campos Controlador: ["+CatalogosBusines.CATALOGO_CAMPOS_CONTROLADOR+"]");
		LOGGER.info("[CB] - Campos Paquete: ["+CatalogosBusines.CATALOGO_CAMPOS_PAQUETE+"]");
		LOGGER.info("[CB] - Campos BitacoraAs: ["+CatalogosBusines.CATALOGO_CAMPOS_BITACORA_REASIGNACION+"]");
		LOGGER.info("[CB] - Campos Temporal: ["+CatalogosBusines.CATALOGO_CAMPOS_TEMPORAL_ASIGNACIONES+"]");
		LOGGER.info("[CB] - Campos Cancelación: ["+CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_AVALUO+"]");
		LOGGER.info("[CB] - Campos Historico: ["+CATALOGO_CAMPOS_HISTORICO_VALOR_CONCLUIDO+"]");
		LOGGER.info("[CB] - Campos Avaluo Resp: ["+CatalogosBusines.CATALOGO_CAMPOS_CANCELACION_RESPALDO+"]");
		LOGGER.info("[CB] - Campos estatus: ["+CatalogosBusines.CATALOGO_ESTATUS+"]");
		LOGGER.info("[CB] - Campos Detalle avaluo: ["+CatalogosBusines.CATALOGO_CAMPOS_DETALLE_AVALUO+"]");
		LOGGER.info("[CB] - Campos vivienda: ["+CatalogosBusines.CATALOGO_CAMPOS_VIVIENDA+"]");
		LOGGER.info("[CB] - Campos avaluo: ["+CatalogosBusines.CATALOGO_CAMPOS_AVALUO+"]");
		LOGGER.info("[CB] - Campos sancion: ["+CatalogosBusines.CATALOGO_CAMPOS_SANCION+"]");
		LOGGER.info("[CB] - Campos sancionado: ["+CatalogosBusines.CATALOGO_CAMPOS_SANCIONADO+"]");
		LOGGER.info("[CB] - Campos tipo sanción: ["+CatalogosBusines.CATALOGO_CAMPOS_TIPO_SANCION+"]");
		LOGGER.info("[CB] - Campos sancionador: ["+CatalogosBusines.CATALOGO_CAMPOS_SANCIONADOR+"]");
		LOGGER.info("[CB] - Campos delegacion: ["+CatalogosBusines.CATALOGO_CAMPOS_DELEGACION+"]");
		LOGGER.info("[CB] - Campos tipo linea: ["+CatalogosBusines.CATALOGO_TIPO_LINEA+"]");
		LOGGER.info("[CB] - Campos tipo mercado: ["+CatalogosBusines.CATALOGO_TIPO_MERCADO+"]");
		ServiciosSeguridad.displayInformation();
		CatalogoMetodoConclusionAvaluo.mostrarCatalogo();
		CatalogoEstadoConservacion.mostrarCatalogo();
		Estado.mostrarCatalogoEstados();
		CamposInexGeneral.mostrarCatalogo();
		Inex.mostrarCatalogo();
		TipoPaquete.mostrarCatalogo();
		CamposBitacoraReasignacion.mostrarCatalogo();
	}
	
	
	
	

	
}





