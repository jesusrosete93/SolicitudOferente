package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.utils.ReporteAvaluosCerradosUtils.generarEstado;
import static mx.org.infonavit.solicitud.oferente.utils.ReporteAvaluosCerradosUtils.generarRangoLimiteFechas;
import static mx.org.infonavit.solicitud.oferente.utils.ReporteAvaluosCerradosUtils.ordenarReporte;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.ReporteAvaluoCerradoDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.ReporteAvaluoCerradoDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.AvaluoCerradoVo;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AvaluosCerradosBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(AvaluosCerradosBusiness.class);
	
	@Autowired
	@Qualifier("ReporteAvaluoCerradoDao")
	private AbstractDao<AvaluoCerradoVo> persistence;
	
	/**
	 * Valida si existe información para el reporte a generar
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return true si existe información de lo contrario regresa false.
	 */
	public boolean validarInformacionReporte( int tipoComparativa,
											  String anioInicio,String anioFin,
											  String mesAnio, String diaAnio,
											  String diaMes,
											  String fecha)
	{
		List<AvaluoCerradoVo> registros = null;
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);
		
		LOGGER.info("[ACB] - Validando existencia de información...");
		
		ReporteAvaluoCerradoDao.POR_ESTADO=false;
		ReporteAvaluoCerradoDao.POR_UNIDAD=false;
		ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
		
		registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1)));
		
		if( registros!=null && !registros.isEmpty())
		{
			LOGGER.info("[ACB] - Hay información");
			return true;
		}else
		{
			LOGGER.info("[ACB] - No hay información");
			return false;
		}
	}
	
	/**
	 * Valida si existe información para el reporte a generar
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return true si existe información de lo contrario regresa false.
	 */
	public boolean validarInformacionReporteEstado( int tipoComparativa,
													String anioInicio,String anioFin,
													String mesAnio, String diaAnio,
													String diaMes,
													String fecha,int estado)
	{
		List<AvaluoCerradoVo> registros = null;
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);

		LOGGER.info("[ACB] - Validando existencia de información por estado...");
		
		ReporteAvaluoCerradoDao.POR_ESTADO=true;
		ReporteAvaluoCerradoDao.POR_UNIDAD=false;
		ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
		
		registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),generarEstado(estado)));
		
		if( registros!=null && !registros.isEmpty())
		{
			LOGGER.info("[ACB] - Hay información por estado");
			return true;
		}else
		{
			LOGGER.info("[ACB] - No hay información por estado");
			return false;
		}
	}
	
	
	/**
	 * Valida si existe información para el reporte a generar
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return true si existe información de lo contrario regresa false.
	 */
	public boolean validarInformacionReporteUnidad(
											  		int tipoComparativa,
											  		String anioInicio,String anioFin,
											  		String mesAnio, String diaAnio,
											  		String diaMes,
											  		String fecha,int unidad)
	{
		List<AvaluoCerradoVo> registros = null;
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);
	
		ReporteAvaluoCerradoDao.POR_ESTADO=false;
		ReporteAvaluoCerradoDao.POR_UNIDAD=true;
		ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
		
		LOGGER.info("[ACB] - Validando existencia de información por unidad...");
		
		registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),unidad));
		
		if( registros!=null && !registros.isEmpty())
		{
			LOGGER.info("[ACB] - Hay información por unidad");
			return true;
		}else
		{
			LOGGER.info("[ACB] - No hay información por unidad");
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return
	 */
	public List<ReporteAvaluoCerradoDomain> generarReporteAvaluosCerrados(int tipoComparativa,
											  							  String anioInicio,String anioFin,
											  							  String mesAnio, String diaAnio,
											  							  String diaMes,String fecha)
	{
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);
		List<AvaluoCerradoVo> registros = null;
		List<ReporteAvaluoCerradoDomain> reporte = null;
		LOGGER.info("[ACB]- Generando reporte de avaluos cerrados, tipo comparativa["+tipoComparativa+"]...");
		
		switch (tipoComparativa) {
				case 1:
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
							 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1)));
							 ReporteAvaluoCerradoDao.POR_ESTADO=false;
							 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
							 if( registros!=null && !registros.isEmpty())
							 {
								 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
								 ReporteAvaluoCerradoDomain domain = null;
								 int inicio = Integer.parseInt(anioInicio);
							     int fin = (Integer.parseInt(fechas.get(2))+Integer.parseInt(anioInicio));
								 
								 for( int anio = inicio ; anio<=fin; anio++)
								 {
									 domain = new ReporteAvaluoCerradoDomain();
									 domain.setAnio(anio);
									 for(AvaluoCerradoVo registro : registros)
									 {
										 if( registro.getTituloCerrados().trim().equals(String.valueOf(anio).trim()))
										 {
											 domain.setUnidadTiempo("Año");
											 if( registro.getTipoMercado()==1)
											 {
												 domain.setCerradosPaquete(registro.getAvaluosCerrados());
											 }else if( registro.getTipoMercado()==2)
											 {
												 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
												 
											 }
										 }
									 }
									 reporte.add(domain);
								 }
							 }
						 break;
				case 2: 
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1)));
						 ReporteAvaluoCerradoDao.POR_ESTADO=false;
						 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int mes = 1 ; mes<=Integer.parseInt(fechas.get(2)); mes++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setMes(mes);
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(mes).trim()))
									 {
										 domain.setUnidadTiempo("Mes");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,1);
						CollectionUtils.forAllDo(reporte, new Closure(){

							@Override
							public void execute(Object arg0) {
								// TODO Auto-generated method stub
								((ReporteAvaluoCerradoDomain)arg0).setNombreMes(CatalogosBusines.CATALOGO_MESES.get(  String.valueOf(((ReporteAvaluoCerradoDomain)arg0).getMes())  ));
							}});
				break;
				case 3:
						ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1)));
						ReporteAvaluoCerradoDao.POR_ESTADO=false;
						ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int dia = 1 ; dia<=Integer.parseInt(fechas.get(2)); dia++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setDia(dia);
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(dia).trim()))
									 {
										 domain.setUnidadTiempo("Dia");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,2);
				break;
				case 4:
					ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
					registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1)));
					ReporteAvaluoCerradoDao.POR_ESTADO=false;
					ReporteAvaluoCerradoDao.POR_UNIDAD=false;
					ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
					 if( registros!=null && !registros.isEmpty())
					 {
						 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
						 ReporteAvaluoCerradoDomain domain = null;
						 for( int hora = 0 ; hora<=Integer.parseInt(fechas.get(2)); hora++)
						 {
							 domain = new ReporteAvaluoCerradoDomain();
							 domain.setHora((hora+1));
							 for(AvaluoCerradoVo registro : registros)
							 {
								 if( registro.getTituloCerrados().trim().equals(String.valueOf(hora).trim()))
								 {
									 domain.setUnidadTiempo("Hora");
									 if( registro.getTipoMercado()==1)
									 {
										 domain.setCerradosPaquete(registro.getAvaluosCerrados());
									 }else if( registro.getTipoMercado()==2)
									 {
										 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
									 } 
								 }
							 }
							reporte.add(domain);
						}
					}
					ordenarReporte(reporte,3);
				break;
				default:
					break;
				}
		
		if( reporte==null)
		{
			LOGGER.info("[ACB]- No hay  datos....");
			reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
		}
		LOGGER.info("[ACB]- Reporte de avaluos cerrados generado.");
		return reporte;
		
		
		
	}
	
	
	/**
	 * 
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return
	 */
	public List<ReporteAvaluoCerradoDomain> generarReporteAvaluosCerradosEstado(int tipoComparativa,
																			    String anioInicio,String anioFin,
																			    String mesAnio, String diaAnio,
																			    String diaMes,
																			    String fecha,int estado)
	{
		
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);
		List<AvaluoCerradoVo> registros = null;
		List<ReporteAvaluoCerradoDomain> reporte = null;
		String idEstado = generarEstado(estado);
		LOGGER.info("[ACB]- Generando reporte de avaluos cerrados por estado, tipo comparativa["+tipoComparativa+"]...");
		
		ReporteAvaluoCerradoDao.POR_ESTADO=true;
		ReporteAvaluoCerradoDao.POR_UNIDAD=false;
		
		switch (tipoComparativa) {
				case 1:
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
							 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),idEstado));
							 ReporteAvaluoCerradoDao.POR_ESTADO=false;
							 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
							 if( registros!=null && !registros.isEmpty())
							 {
								 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
								 ReporteAvaluoCerradoDomain domain = null;
								 int inicio = Integer.parseInt(anioInicio);
							     int fin = (Integer.parseInt(fechas.get(2))+Integer.parseInt(anioInicio));
								 
								 for( int anio = inicio ; anio<=fin; anio++)
								 {
									 domain = new ReporteAvaluoCerradoDomain();
									 domain.setAnio(anio);
									 domain.setEstado(idEstado);
									 for(AvaluoCerradoVo registro : registros)
									 {
										 if( registro.getTituloCerrados().trim().equals(String.valueOf(anio).trim()))
										 {
											 domain.setUnidadTiempo("Año");
											 if( registro.getTipoMercado()==1)
											 {
												 domain.setCerradosPaquete(registro.getAvaluosCerrados());
											 }else if( registro.getTipoMercado()==2)
											 {
												 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
												 
											 }
										 }
									 }
									 reporte.add(domain);
								 }
							 }
						 break;
				case 2: 
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),idEstado));
						 ReporteAvaluoCerradoDao.POR_ESTADO=false;
						 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int mes = 1 ; mes<=Integer.parseInt(fechas.get(2)); mes++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setMes(mes);
								 domain.setEstado(idEstado);
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(mes).trim()))
									 {
										 domain.setUnidadTiempo("Mes");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,1);
						CollectionUtils.forAllDo(reporte, new Closure(){

							@Override
							public void execute(Object arg0) {
								// TODO Auto-generated method stub
								((ReporteAvaluoCerradoDomain)arg0).setNombreMes(CatalogosBusines.CATALOGO_MESES.get(String.valueOf(((ReporteAvaluoCerradoDomain)arg0).getMes())));
							}});
				break;
				case 3:
						ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),idEstado));
						ReporteAvaluoCerradoDao.POR_ESTADO=false;
						 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int dia = 1 ; dia<=Integer.parseInt(fechas.get(2)); dia++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setDia(dia);
								 domain.setEstado(idEstado);
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(dia).trim()))
									 {
										 domain.setUnidadTiempo("Dia");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,2);
				break;
				case 4:
					ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
					registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),idEstado));
					ReporteAvaluoCerradoDao.POR_ESTADO=false;
					ReporteAvaluoCerradoDao.POR_UNIDAD=false;
					ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
					 if( registros!=null && !registros.isEmpty())
					 {
						 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
						 ReporteAvaluoCerradoDomain domain = null;
						 for( int hora = 0 ; hora<=Integer.parseInt(fechas.get(2)); hora++)
						 {
							 domain = new ReporteAvaluoCerradoDomain();
							 domain.setHora((hora+1));
							 domain.setEstado(idEstado);
							 for(AvaluoCerradoVo registro : registros)
							 {
								 if( registro.getTituloCerrados().trim().equals(String.valueOf(hora).trim()))
								 {
									 domain.setUnidadTiempo("Hora");
									 if( registro.getTipoMercado()==1)
									 {
										 domain.setCerradosPaquete(registro.getAvaluosCerrados());
									 }else if( registro.getTipoMercado()==2)
									 {
										 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
									 } 
								 }
							 }
							reporte.add(domain);
						}
					}
					ordenarReporte(reporte,3);
				break;
				default:
					break;
		}
		if( reporte==null)
		{
			LOGGER.info("[ACB]- No hay  datos....");
			reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
		}
		LOGGER.info("[ACB]- Reporte de avaluos cerrados por estado generado");
		return reporte;
		
		
		
	}
	
	
	
	
	/**
	 * 
	 * @param tipoReporte
	 * @param tipoComparativa
	 * @param anioInicio
	 * @param anioFin
	 * @param mesAnio
	 * @param diaAnio
	 * @param diaMes
	 * @param fecha
	 * @return
	 */
	public List<ReporteAvaluoCerradoDomain> generarReporteAvaluosCerradosUnidad(int tipoComparativa,
											  									String anioInicio,String anioFin,
											  									String mesAnio, String diaAnio,
											  									String diaMes,
											  									String fecha,int unidad)
	{
		List<String> fechas = generarRangoLimiteFechas(tipoComparativa, anioInicio, anioFin, mesAnio, diaAnio, diaMes, fecha);
		List<AvaluoCerradoVo> registros = null;
		List<ReporteAvaluoCerradoDomain> reporte = null;
		LOGGER.info("[ACB]- Generando reporte de avaluos cerrados por unidad, tipo comparativa["+tipoComparativa+"]...");
	
		ReporteAvaluoCerradoDao.POR_ESTADO=false;
		ReporteAvaluoCerradoDao.POR_UNIDAD=true;
		
	    switch (tipoComparativa) {
				case 1:
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
							 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),unidad));
							 ReporteAvaluoCerradoDao.POR_ESTADO=false;
							 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
							 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
							 if( registros!=null && !registros.isEmpty())
							 {
								 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
								 ReporteAvaluoCerradoDomain domain = null;
								 int inicio = Integer.parseInt(anioInicio);
							     int fin = (Integer.parseInt(fechas.get(2))+Integer.parseInt(anioInicio));
								 
								 for( int anio = inicio ; anio<=fin; anio++)
								 {
									 domain = new ReporteAvaluoCerradoDomain();
									 domain.setAnio(anio);
									 domain.setUnidadValuacion(String.valueOf(unidad));
									 for(AvaluoCerradoVo registro : registros)
									 {
										 if( registro.getTituloCerrados().trim().equals(String.valueOf(anio).trim()))
										 {
											 domain.setUnidadTiempo("Año");
											 if( registro.getTipoMercado()==1)
											 {
												 domain.setCerradosPaquete(registro.getAvaluosCerrados());
											 }else if( registro.getTipoMercado()==2)
											 {
												 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
												 
											 }
										 }
									 }
									 reporte.add(domain);
								 }
							 }
						 break;
				case 2: 
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						 registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),unidad));
						 ReporteAvaluoCerradoDao.POR_ESTADO=false;
						 ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						 ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int mes = 1 ; mes<=Integer.parseInt(fechas.get(2)); mes++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setMes(mes);
								 domain.setUnidadValuacion(String.valueOf(unidad));
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(mes).trim()))
									 {
										 domain.setUnidadTiempo("Mes");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,1);
						CollectionUtils.forAllDo(reporte, new Closure(){

							@Override
							public void execute(Object arg0) {
								// TODO Auto-generated method stub
								((ReporteAvaluoCerradoDomain)arg0).setNombreMes(CatalogosBusines.CATALOGO_MESES.get(String.valueOf(((ReporteAvaluoCerradoDomain)arg0).getMes())));
							}});
				break;
				case 3:
						ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
						registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),unidad));
						ReporteAvaluoCerradoDao.POR_ESTADO=false;
						ReporteAvaluoCerradoDao.POR_UNIDAD=false;
						ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
						 if( registros!=null && !registros.isEmpty())
						 {
							 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
							 ReporteAvaluoCerradoDomain domain = null;
							 for( int dia = 1 ; dia<=Integer.parseInt(fechas.get(2)); dia++)
							 {
								 domain = new ReporteAvaluoCerradoDomain();
								 domain.setDia(dia);
								 domain.setUnidadValuacion(String.valueOf(unidad));
								 for(AvaluoCerradoVo registro : registros)
								 {
									 if( registro.getTituloCerrados().trim().equals(String.valueOf(dia).trim()))
									 {
										 domain.setUnidadTiempo("Dia");
										 if( registro.getTipoMercado()==1)
										 {
											 domain.setCerradosPaquete(registro.getAvaluosCerrados());
										 }else if( registro.getTipoMercado()==2)
										 {
											 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
										 } 
									 }
								 }
								reporte.add(domain);
							}
						}
						ordenarReporte(reporte,2);
				break;
				case 4:
					ReporteAvaluoCerradoDao.TIPO_REPORTE = tipoComparativa;
					registros = persistence.buscarLista(new AvaluoCerradoVo((String)fechas.get(0),(String)fechas.get(1),unidad));
					ReporteAvaluoCerradoDao.POR_ESTADO=false;
					ReporteAvaluoCerradoDao.POR_UNIDAD=false;
					ReporteAvaluoCerradoDao.TIPO_REPORTE = -1;
					 if( registros!=null && !registros.isEmpty())
					 {
						 reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
						 ReporteAvaluoCerradoDomain domain = null;
						 for( int hora = 0 ; hora<=Integer.parseInt(fechas.get(2)); hora++)
						 {
							 domain = new ReporteAvaluoCerradoDomain();
							 domain.setHora((hora+1));
							 domain.setUnidadValuacion(String.valueOf(unidad));
							 for(AvaluoCerradoVo registro : registros)
							 {
								 if( registro.getTituloCerrados().trim().equals(String.valueOf(hora).trim()))
								 {
									 domain.setUnidadTiempo("Hora");
									 if( registro.getTipoMercado()==1)
									 {
										 domain.setCerradosPaquete(registro.getAvaluosCerrados());
									 }else if( registro.getTipoMercado()==2)
									 {
										 domain.setCerradosMercadoAbierto(registro.getAvaluosCerrados());
									 } 
								 }
							 }
							reporte.add(domain);
						}
					}
					ordenarReporte(reporte,3);
				break;
				default:
					break;
				}
		if( reporte==null)
		{
			LOGGER.info("[ACB]- No hay  datos....");
			reporte = new ArrayList<ReporteAvaluoCerradoDomain>();
		}
		LOGGER.info("[ACB]- Reporte de avaluos cerrados por unidad generado.");
		return reporte;
		
		
		
	}
	
	
}

