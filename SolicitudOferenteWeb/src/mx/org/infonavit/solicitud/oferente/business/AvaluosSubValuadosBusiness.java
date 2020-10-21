package mx.org.infonavit.solicitud.oferente.business;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoSubValuadoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoSubValuadoVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Encapsula las reglas de neogcio 
 * para el proceso de busqueda de 
 * avaluos subvaluados.
 * 
 * @author Adrian Casas Avansis Desarrollos SA de CV 
 *
 */
@Component
public class AvaluosSubValuadosBusiness {
	
	/**
	 * Permite enviar a la consola y al archivo de log 
	 * mensajes de texto.
	 */
	private static Logger LOGGER = LogManager.getLogger(AvaluosCerradosBusiness.class); 
	
	/**
	 * Permite ejecutar cons
	 */
	@Autowired
	@Qualifier("AvaluoSubValuadoDao")
	private AbstractDao<AvaluoSubValuadoVo> persistence;
	
	
	
	/**
	 * Genera un reporte de avaluos subvaluados 
	 * con ciertas caracteristicas
	 * @param criterios
	 * @return listado de avaluos subvaluados
	 */
	public List<AvaluoSubValuadoDomain> buscarAvaluosSubvaluados(AvaluoSubValuadoVo criterios)
	{
		List<AvaluoSubValuadoDomain> regreso = null;
		try
		{
			List<AvaluoSubValuadoVo> registros = persistence.buscarLista(criterios);
			
			
			if( registros!=null && !registros.isEmpty())
			{
				regreso = new ArrayList<AvaluoSubValuadoDomain>();
				for( AvaluoSubValuadoVo registro: registros )
				{
					regreso.add( AvaluoSubValuadoDomain.getObjetoDomain(registro) );
				}
			}else
			{
				regreso = new ArrayList<AvaluoSubValuadoDomain>();
			}
		}catch(Exception e)
		{
			LOGGER.error("[ASVB] - Error al consultar los avaluos subvaluados",e);
		}
	 return regreso;
	}
	
	
	/**
	 * Generea un objeto de tipo {@link AvaluoSubValuadoVo} con valores asignados 
	 * @param idAvaluo
	 * @param idPaquete
	 * @param idVivienda
	 * @param idUnidadValuacion
	 * @param clasificacion
	 * @param codigoPostal
	 * @param fechaCierreInicio
	 * @param fechaCierreFin
	 * @return
	 */
	public static AvaluoSubValuadoVo generarObjetoAvaluoSubValuadoVo(String idAvaluo,String idPaquete,
																	 int idVivienda,int idUnidadValuacion,
																	 int clasificacion,String codigoPostal,
																	 int bandera,
																	 String fechaCierreInicio,String fechaCierreFin)
	{
		AvaluoSubValuadoVo regreso = new AvaluoSubValuadoVo();
		regreso.setIdAvaluo(idAvaluo.trim().equals("")?"":idAvaluo);
		regreso.setIdPaquete(idPaquete.trim().equals("")?"":idPaquete);
		regreso.setIdVivienda(idVivienda==0?0:idVivienda);
		regreso.setIdUnidadValuacion(idUnidadValuacion==0?0:idUnidadValuacion);
		regreso.setBandera(bandera==0?0:bandera);
		regreso.setCodigoPostal(codigoPostal.trim().equals("")?"":codigoPostal);
		regreso.setFechaCierreInicio(fechaCierreInicio.trim().equals("")?"":fechaCierreInicio+" 00:00:00");
		regreso.setFechaCierreFin(fechaCierreFin.trim().equals("")?"":fechaCierreFin+" 23:59:59");
		
		return regreso;
	}
	

}
