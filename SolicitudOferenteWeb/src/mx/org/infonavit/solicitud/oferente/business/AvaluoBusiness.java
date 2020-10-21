package mx.org.infonavit.solicitud.oferente.business;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.DetalleAvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ElementosAdicionalesDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueCostoFisicoDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueMercadoDomain;
import mx.org.infonavit.solicitud.oferente.domain.ViviendaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.DetalleAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ElementosAdicionalesVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueCostoFisicoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueMercadoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ViviendaVo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AvaluoBusiness {
	
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluoBusiness.class);
	
	
	
//	public void obteneriInformacionAvaluos(List<E>)
	
	/**
	 * Método que obtiene un listado tipo {@link AvaluoDomain} a partir de un listado tipo {@link AvaluoVo} 
	 * @param registros listado tipo {@link AvaluoVo}
	 * @return listado tipo {@link AvaluoDomain}
	 */
	public static List<AvaluoDomain> getListadoAvaluoDomain(List<AvaluoVo> registros)
	{
		List<AvaluoDomain> regreso = new ArrayList<AvaluoDomain>();
		if( registros!=null && !registros.isEmpty())
		{
			CollectionUtils.collect(registros,new Transformer(){
				@Override
				public Object transform(Object arg0) {
					// TODO Auto-generated method stub
					return getDomain((AvaluoVo)arg0);
				}},regreso);
//			for(AvaluoVo registro : registros )
//			{
//				if( !regreso.contains(new AvaluoDomain(registro.getIdAvaluo())) )
//				{
//					regreso.add(getDomain(registro));
//				}else
//				{
//					continue;
//				}
//			}
		}
	 return regreso;
	}
	
	/**
	 * 
	 * @param registros
	 * @return
	 */
	public static List<DetalleAvaluoDomain> getDetalleAvaluoDomain(List<DetalleAvaluoVo> registros)
	{
		List<DetalleAvaluoDomain> regreso = new ArrayList<DetalleAvaluoDomain>();
		if( registros!=null && !registros.isEmpty())
		{
			for(DetalleAvaluoVo registro : registros )
			{
				regreso.add(getDetalleAvaluoDomain(registro));
			}
		}
	 return regreso;
	}
	
	
	
	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static AvaluoDomain getDomain(AvaluoVo registro)
	{
		AvaluoDomain regreso = null;
		if( registro != null)
		{
//			regreso = new AvaluoDomain();
//			regreso.setIdAvaluo(registro.getIdAvaluo());
//			regreso.setUnidadValuacion(CatalogosBusines.UNIDADES_VALUACION.get(registro.getIdUv()));
//			regreso.setFechaSolicitud(registro.getFechaSolicitud());
//			regreso.setFechaDescarga(registro.getFechaDescarga());
//			regreso.setFechaEnvio(registro.getFechaEnvio());
//			regreso.setFechaCierre(registro.getFechaCierre());
//			regreso.setFechaAsociacionFactura(registro.getFechaAsociacionFactura());
//			regreso.setEstatus(registro.getIdEstatus());
//			regreso.setDescripcionEstatus(CatalogosBusines.CATALOGO_ESTATUS.get(registro.getIdEstatus()));
//			regreso.setVivienda(registro.getIdVivienda());
//			regreso.setPaquete(registro.getIdPaquete());
//			regreso.setNss(registro.getNss());
//			regreso.setRfc(registro.getRfc());
//			regreso.setIsai((registro.isIsai()?"1":"0"));
//			regreso.setIConviviencia(registro.getIdConviviencia());
			
			regreso = new AvaluoDomain( registro.getIdAvaluo()
									   ,CatalogosBusines.UNIDADES_VALUACION.get(registro.getIdUv())
									   ,registro.getFechaSolicitud()
									   ,registro.getFechaDescarga()
									   ,registro.getFechaEnvio()
									   ,registro.getFechaCierre()
									   ,registro.getFechaAsociacionFactura()
									   ,registro.getIdEstatus()
									   ,CatalogosBusines.CATALOGO_ESTATUS.get(registro.getIdEstatus())
									   ,registro.getIdVivienda()
									   ,registro.getIdPaquete()
									   ,registro.getNss()
									   ,registro.getRfc()
									   ,(registro.isIsai()?"1":"0")
									   ,registro.getIdConviviencia());
		}
	 return regreso;
	}
	
	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static DetalleAvaluoDomain getDetalleAvaluoDomain(DetalleAvaluoVo registro)
	{
		DetalleAvaluoDomain regreso = null;
		if( registro != null)
		{
			regreso = new DetalleAvaluoDomain();
			try {
				BeanUtils.copyProperties(regreso, registro);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			regreso = new DetalleAvaluoDomain();
		}
		return regreso;
	}

	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static EnfoqueMercadoDomain getEnfoqueMercadoDomain(
			EnfoqueMercadoVo registro) {
		EnfoqueMercadoDomain regreso = null;
		if (registro != null) {
			regreso = new EnfoqueMercadoDomain();
			regreso.setIdRegistro(registro.getIdRegistro());
			regreso.setIdAvaluo(registro.getIdAvaluo());
			regreso.setPaquete(registro.getIdPaquete());
			regreso.setViviendad(registro.getIdVivienda());
			regreso.setEdad(registro.getEdad());
			regreso.setIdConservacion(registro.getIdConservacion());
			regreso.setValorOferta(registro.getValorOferta());
			regreso.setSuperficieTerreno(registro.getSuperficieTerreno());
			regreso.setSuperficieConstruccion(registro.getSuperficieConstruccion());
			regreso.setValorUnitario(registro.getValorUnitario());
			regreso.setFactorFic(registro.getFactorFic());
			regreso.setFactorZona(registro.getFactorZona());
			regreso.setFactorUbicacion(registro.getFactorUbicacion());
			regreso.setFactorSuperficie(registro.getFactorSuperficie());
			regreso.setFactorEdad(registro.getFactorEdad());
			regreso.setFactorConservacion(registro.getFactorConservacion());
			regreso.setFactorOtros(registro.getFactorOtros());
			regreso.setFactorComercializacion(registro.getFactorComercializacion());
			regreso.setFactorResultante(registro.getFactorResultante());
		}
		return regreso;
	}

	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static List<EnfoqueMercadoDomain> getEnfoqueMercadoDomain(
			List<EnfoqueMercadoVo> registros) {
		List<EnfoqueMercadoDomain> regreso = null;
		if (registros != null) 
		{
			regreso = new ArrayList<EnfoqueMercadoDomain>();
			for (EnfoqueMercadoVo registro : registros) 
			{
				regreso.add(getEnfoqueMercadoDomain(registro));
			}
		}
		return regreso;
	}

	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static List<EnfoqueCostoFisicoDomain> getEnfoqueCostoDomain(
			List<EnfoqueCostoFisicoVo> registros) {
		List<EnfoqueCostoFisicoDomain> regreso = null;
		if (registros != null) {
			regreso = new ArrayList<EnfoqueCostoFisicoDomain>();
			for (EnfoqueCostoFisicoVo registro : registros) {
				regreso.add(getEnfoqueCostoFisicoDomain(registro));
			}
		}
		return regreso;
	}

	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static EnfoqueCostoFisicoDomain getEnfoqueCostoFisicoDomain(
			EnfoqueCostoFisicoVo registro) {
		EnfoqueCostoFisicoDomain regreso = null;
		if (registro != null) {
			regreso = new EnfoqueCostoFisicoDomain();
			regreso.setIdRegistro(registro.getIdRegistro());
			regreso.setIdAvaluo(registro.getIdAvaluo());
			regreso.setPaquete(registro.getIdPaquete());
			regreso.setVivieda(registro.getIdVivienda());
			regreso.setValorOferta(registro.getValorOferta());
			regreso.setSuperficieTerreno(registro.getSuperficieTerreno());
			regreso.setValorUnitario(regreso.getValorUnitario());
			regreso.setFactorZona(registro.getFactorZona());
			regreso.setFactorUbicacion(registro.getFactorUbicacion());
			regreso.setFactorFrente(registro.getFactorFrente());
			regreso.setFactorForma(registro.getFactorForma());
			regreso.setFactorSuperficie(registro.getFactorSuperficie());
			regreso.setFactorComercializacion(registro.getFactorComercializacion());
			regreso.setFactorOtros(registro.getFactorOtros());
			regreso.setFactorResultante(registro.getFactorResultante());
		}
		return regreso;
	}
	
	/**
	 * 
	 * @param registro
	 * @return
	 */
	public static ViviendaDomain getViviendaDomain(ViviendaVo registro)
	{
		ViviendaDomain domain = null;
		if( registro!=null)
		{
			domain = new ViviendaDomain();
			try {
				BeanUtils.copyProperties(domain,registro);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			domain = new ViviendaDomain();
		}
	 return domain;
	}
	
	/**
	 * 
	 * @param registros
	 * @return
	 */
	public static List<ViviendaDomain> getViviendaDomain(List<ViviendaVo> registros)
	{
		List<ViviendaDomain> regreso = null;
		if (registros != null && !registros.isEmpty()) {
			regreso = new ArrayList<ViviendaDomain>();
			for (ViviendaVo registro : registros) {
				regreso.add(getViviendaDomain(registro));
			}
		}
		return regreso;
	}
	
	
	public static ElementosAdicionalesDomain getElementosAdicionalesDomain(ElementosAdicionalesVo registro)
	{
		ElementosAdicionalesDomain regreso  = null;
		if( registro != null )
		{
			regreso  = new ElementosAdicionalesDomain();
			try {
				BeanUtils.copyProperties(regreso,registro);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			regreso = new ElementosAdicionalesDomain();
		}
	 return regreso;
	}
	
	/**
	 * 
	 * @param registros
	 * @return
	 */
	public static List<ElementosAdicionalesDomain> getElementosAdicionalesDomain(List<ElementosAdicionalesVo> registros)
	{
		List<ElementosAdicionalesDomain> regreso  = null;
		if( registros != null && !registros.isEmpty() )
		{
			regreso = new ArrayList<ElementosAdicionalesDomain>();
			for(ElementosAdicionalesVo registro : registros )
			{
				regreso.add(getElementosAdicionalesDomain(registro));
			}
			
		}
	 return regreso;
	}
}
