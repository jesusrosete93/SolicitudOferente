package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_NOK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.FIN_OK;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoCerradoMaiVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AvaluoMAIBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluoMAIBusiness.class);
	private static final String PREFIJO = "[AMB] - ";
	private static final String PROCESO_CAVC = " Proceso de consulta avalúo cerrados MAI ";
	
	@Autowired
	@Qualifier("AvaluoCerradoMAIDao")
	private AbstractDao<AvaluoCerradoMaiVo> persistence;

	/**
	 * 
	 * @param fechaCierreInicio
	 * @param fechaCierreFin
	 * @return
	 */
	public List<AvaluoCerradoMaiDomain> consultarAvaluosCerrados(String fechaCierreInicio,String fechaCierreFin)
	{
		List<AvaluoCerradoMaiDomain> regreso = null;
		List<AvaluoCerradoMaiVo> registros = null;
	    try
		{
	    	LOGGER.info(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"]" +INICIO_OK);
	    	
	    	registros = persistence.buscarLista(new AvaluoCerradoMaiVo(fechaCierreInicio,fechaCierreFin));
	    	if( registros != null && !registros.isEmpty() )
	    	{
	    	  LOGGER.info(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"] - Encontrados: "+(registros.size()));
	    	  regreso = getList(registros);
	    	}else
	    	{
	    		LOGGER.info(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"] - Encontrados: 0");
	    	}
	    	
	    	LOGGER.info(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"]" +FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"]" +FIN_NOK);
			LOGGER.error(PREFIJO + PROCESO_CAVC + "FCI["+fechaCierreInicio+"] FCF["+fechaCierreFin+"]" +ERROR,e);
		}
	 return regreso;
	}
	
	
	/**
	 * 
	 * @param idAvaluo
	 * @return
	 */
	public AvaluoCerradoMaiDomain consultarAvaluo(String idAvaluo)
	{
		AvaluoCerradoMaiDomain regreso = null;
		AvaluoCerradoMaiVo registro = null;
		try
		{
	    	LOGGER.info(PREFIJO + "IDAVA["+idAvaluo+"]" + INICIO_OK);
	    	registro = persistence.buscar(new AvaluoCerradoMaiVo(idAvaluo));
	    	if( registro != null)
	    	{
	    		regreso = getDomain(registro);
	    	}
	    	LOGGER.info(PREFIJO + "IDAVA["+idAvaluo+"]" + FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO + "IDAVA["+idAvaluo+"]" + FIN_NOK);
			LOGGER.error(PREFIJO + PROCESO_CAVC + "IDAVA["+idAvaluo+"]" +ERROR,e);
		}
	 return regreso;
	}
	
	/**
	 * 
	 * @param registros
	 * @return
	 */
	public static List<AvaluoCerradoMaiDomain> getList(List<AvaluoCerradoMaiVo> registros)
	{
		List<AvaluoCerradoMaiDomain> regreso = null;
		if( registros!=null && !registros.isEmpty() )
		{
			regreso = new ArrayList<AvaluoCerradoMaiDomain>();
			for( AvaluoCerradoMaiVo registro : registros )
			{
				regreso.add(getDomain(registro));
			}	
		}
	 return regreso;
	}
	
	/**
	 * 
	 * 
	 * @param registro
	 * @return
	 */
	public static AvaluoCerradoMaiDomain getDomain(AvaluoCerradoMaiVo registro)
	{
		if( registro!=null)
		{
		  AvaluoCerradoMaiDomain regreso = new AvaluoCerradoMaiDomain(registro.getFolioControl(),registro.getFechaEntrega()
											 ,String.valueOf(registro.getIdUv()),registro.getIdAvaluo(),registro.getIdConvivencia()
											 ,String.valueOf(registro.getIdEstatus())
											 ,registro.getFechaCierre()
											 ,registro.getFechaVisitaInmueble(),registro.getViviendaRecuperada()
											 ,String.valueOf(registro.getIdTipoInmuebleValuado()),String.valueOf(registro.getEstado())
											 ,registro.getLocalidad(),registro.getIdMunicipio()
											 ,registro.getCodigoPostal(),registro.getColonia()
											 ,registro.getCalle(),registro.getConjunto()
											 ,registro.getNumeroExterior(),registro.getEdificio()
											 ,registro.getNumeroInterior(),registro.getManzana()
											 ,registro.getSuperManzana(),registro.getLote()
											 ,registro.getCondominio(),registro.getNivelesVivienda()
											 ,registro.getNivelesEdificio(),registro.getEntreCalle1()
											 ,registro.getEntreCalle2(),registro.getLatitud()
											 ,registro.getLongitud(),registro.getAltitud()
											 ,String.valueOf(registro.getIdVialidades()),String.valueOf(registro.getIdMaterialBanquetas())
											 ,registro.getIdVialidadesAccesos(),registro.getIdInfraestructuraAguaPotable()
											 ,registro.getIdInfraestructuraEnergiaElectrica(),registro.getIdInfraestructuraAlumbradoPublico()
											 ,registro.getGradoTerminacionObra(),String.valueOf(registro.getIdEstadoConservación())
											 ,String.valueOf(registro.getIdUsoConstrucciones()),String.valueOf(registro.getIdSuministroTelefonico())
											 ,registro.getColindancias(),String.valueOf(registro.getNomenclaturaCalles())
											 ,String.valueOf(registro.getIdZonaRestricciones()),String.valueOf(registro.getIdZonaAfectacion())
											 ,String.valueOf(registro.getIdZonaAreasInundiable())
											 ,registro.getEdadConstruccion(),registro.getTipoVivienda()
											 );
		  	 if( regreso.getClasificacionVivienda().trim().equalsIgnoreCase("N"))
		  	 {
		  		 regreso.setClasificacionVivienda("Nueva");
		  	 }else
		  	 {
		  		 if( regreso.getClasificacionVivienda().trim().equalsIgnoreCase("U"))
			  	 {
			  		regreso.setClasificacionVivienda("Usada");
			  	 }
		  	 }
		  	
		  
			 return regreso;
		}else
		{
			return null;
		}
	}
}
