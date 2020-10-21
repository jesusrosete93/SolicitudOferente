package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.org.infonavit.solicitud.oferente.domain.BitacioraEnvioAvaluoMapDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.BitacoraEnvioAvaluoMapVo;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

@Service
public class BitacoraAvaluoMapBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(BitacoraAvaluoMapBusiness.class);
	private static final String PREFIJO = "[BAMB] - ";
	private static final String CONSULTA = " Consulta de bitacora ";
	private static final String REGISTRO = " Registro de bitacora ";
	
	@Autowired
	@Qualifier("BitacoraEnvioAvaluoMapDao")
	private AbstractDao<BitacoraEnvioAvaluoMapVo> persistence;
	
	
	/**
	 * 
	 * @param idAvaluo
	 * @param fechaRegistroInicio
	 * @param fechaRegistroFin
	 * @param resultado
	 * @param idOperacion
	 * @return
	 */
	public BitacioraEnvioAvaluoMapDomain consultarBitacora(String idAvaluo
																,String fechaRegistroInicio,String fechaRegistroFin
																,int resultado,int idOperacion)
	{
		BitacioraEnvioAvaluoMapDomain regreso = null;
		LOGGER.error(PREFIJO+CONSULTA+INICIO_OK);
		try
		{
			BitacoraEnvioAvaluoMapVo criterios = new BitacoraEnvioAvaluoMapVo();
			criterios.setFechaRegistroInicio(fechaRegistroInicio);
			criterios.setFechaRegistroFin(fechaRegistroFin);
			criterios.setResultado(resultado);
			criterios.setIdAvaluo(idAvaluo);
			criterios.setIdOperacion(idOperacion);
			BitacoraEnvioAvaluoMapVo registro = persistence.buscar(criterios);
			if( registro!=null )
			{
				LOGGER.info(PREFIJO+CONSULTA+FIN_OK);
				regreso = getObjetoDomain(registro);
			}
		}catch (Exception e) {
			LOGGER.info(PREFIJO+CONSULTA+FIN_NOK);
			LOGGER.info(PREFIJO+CONSULTA+ERROR,e);
			regreso = null;
		}
	 return regreso;	
	}
	
	/**
	 * 
	 * @param idAvaluo
	 * @param fechaRegistroInicio
	 * @param fechaRegistroFin
	 * @param resultado
	 * @param idOperacion
	 * @return
	 */
	public List<BitacioraEnvioAvaluoMapDomain> consultarBitacoras(String idAvaluo,String fechaRegistroInicio,String fechaRegistroFin,int resultado
			 													 ,int idOperacion)
	{
		List<BitacioraEnvioAvaluoMapDomain> regreso = null;
		LOGGER.error(PREFIJO+CONSULTA+INICIO_OK);
		try
		{
			BitacoraEnvioAvaluoMapVo criterios = new BitacoraEnvioAvaluoMapVo();
			criterios.setFechaRegistroInicio(fechaRegistroInicio);
			criterios.setFechaRegistroFin(fechaRegistroFin);
			criterios.setResultado(resultado);
			criterios.setIdAvaluo(idAvaluo);
			criterios.setIdOperacion(idOperacion);
			List<BitacoraEnvioAvaluoMapVo> registros = persistence.buscarLista(criterios);
			if( registros!=null && !registros.isEmpty() )
			{
				regreso = new ArrayList<BitacioraEnvioAvaluoMapDomain>();
				for(BitacoraEnvioAvaluoMapVo registro : registros )
				{
					regreso.add(getObjetoDomain(registro));
				}
			}
			LOGGER.info(PREFIJO+CONSULTA+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO+CONSULTA+FIN_NOK);
			LOGGER.info(PREFIJO+CONSULTA+ERROR,e);
			regreso = new ArrayList<BitacioraEnvioAvaluoMapDomain>();
		}
	 return regreso;	
	}
	
	/**
	 * 
	 * @param domain
	 * @return
	 */
	public boolean registroBitacora(BitacioraEnvioAvaluoMapDomain domain)
	{
		LOGGER.info(PREFIJO+REGISTRO+INICIO_OK);
		boolean regreso = false;
		try
		{
			BitacoraEnvioAvaluoMapVo registro = new BitacoraEnvioAvaluoMapVo(0,null,domain.getIdAvaluo(),domain.getIdOperacion(),domain.isResultadoOperacion(),domain.getDetalleResultado(),domain.getIdPeticion());
			regreso = persistence.guardar(registro);
			LOGGER.info(PREFIJO+REGISTRO+FIN_OK);
		}catch (Exception e) {
			LOGGER.info(PREFIJO+REGISTRO+FIN_NOK);
			LOGGER.info(PREFIJO+REGISTRO+ERROR,e);
		}
	 return regreso;
	}
	
	
	public static List<BitacioraEnvioAvaluoMapDomain> getListaDomain(List<BitacoraEnvioAvaluoMapVo> registros)
	{
		List<BitacioraEnvioAvaluoMapDomain> regreso = null;
		if( registros!=null && registros.isEmpty())
		{
			regreso = new ArrayList<BitacioraEnvioAvaluoMapDomain>();
			for(BitacoraEnvioAvaluoMapVo  registro : registros )
			{
				regreso.add(getObjetoDomain(registro));
			}
			return regreso;
		}else
		{
			return new ArrayList<BitacioraEnvioAvaluoMapDomain>();
		}
	}
	
	
	public static BitacioraEnvioAvaluoMapDomain getObjetoDomain(BitacoraEnvioAvaluoMapVo registro)
	{
		BitacioraEnvioAvaluoMapDomain regreso = null;
		if( registro!=null)
		{
			regreso = new  BitacioraEnvioAvaluoMapDomain();
			regreso.setIdRegistro(registro.getIdRegistro());
			regreso.setFechaRegistro(Fechas.getFecha_YYYYMMDDHHMMSS(registro.getFechaRegistro()));
			regreso.setIdOperacion(registro.getIdOperacion());
			regreso.setDescripcionOperacion("");
			regreso.setResultadoOperacion(registro.isResultadoOperacion());
			regreso.setDescripcionResultado(registro.isResultadoOperacion()?"Exitosa":"No exitosa");
			regreso.setDetalleResultado(registro.getDetalleResultado());
			return regreso;
		}else
		{
			return null;
		}
	}

}
