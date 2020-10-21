/**
 * 
 */
package mx.org.infonavit.solicitud.oferente.persistence;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.reemplazar;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.validar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import mx.org.infonavit.solicitud.oferente.persistence.vo.PaqueteVo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Atlas
 *
 */
@Repository("PaqueteDao")
public class PaqueteDao extends AbstractDao<PaqueteVo> {
	
	private static final Logger LOGGER = LogManager.getLogger(PaqueteDao.class);
	/**
	 * 
	 * @author Atlas
	 *
	 */
	private class PaqueteMapper implements RowMapper<PaqueteVo>
	{
		@Override
		public PaqueteVo mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			PaqueteVo paqueteVO = new PaqueteVo( );
			paqueteVO.setIdPaquete					( validar( rs.getString( "idNumeroCedula" ),"" ) );
			paqueteVO.setIdPropiedad				( validar( rs.getString( "idPropiedad" ),"" ) );
			paqueteVO.setIdOferente					( validar( rs.getString( "idOferente" ),"" ) );
			paqueteVO.setIdNumeroPlanMaestro		( validar( rs.getString( "idNumeroPlanMaestro" ),"" ) );
			paqueteVO.setEntidad					( validar( rs.getString( "entidad" ),"" ) );
			paqueteVO.setLocalidad					( validar( rs.getString( "localidad" ),"" ) );
			paqueteVO.setCalle						( validar( rs.getString( "calle" ),"" ) );
			paqueteVO.setColonia					( validar( rs.getString( "colonia" ),"" ) );
			paqueteVO.setNumeroExterior				( validar( rs.getString( "numeroExterior" ),"" ) );
			paqueteVO.setCodigoPostal				( validar( rs.getString( "codigoPostal" ),"" ) );
			paqueteVO.setFechaAlta					( validar( rs.getString( "fAlta" ),"" ) );
			paqueteVO.setNombreFrente				( validar( rs.getString( "frente" ),"" ) );
			paqueteVO.setNumeroViviendas			( validar( rs.getString( "numeroViviendas" ),"" ) );
			paqueteVO.setNumeroConjunto				( validar( rs.getString( "numeroConjunto" ),"" ) );
			paqueteVO.setNumeroSOFOL				( validar( rs.getString( "numeroSOFOL" ),"" ) );
			paqueteVO.setNombreSupervisora			( validar( rs.getString( "nombreSupervisora" ),"" ) );
			paqueteVO.setIdNumeroReferencia			( validar( rs.getString( "idNumeroReferencia" ),"" ) );
			paqueteVO.setObservaciones				( validar( rs.getString( "observaciones" ),"" ) );
			paqueteVO.setFechaInicioProgramado		( validar( rs.getString( "fechaInicioProgramado" ),"" ) );
			paqueteVO.setProceso					( validar( rs.getString( "proceso" ),"" ) );
			paqueteVO.setPorcentajeAvance			( validar( rs.getString( "porcentajeAvance" ),"" ) );
			paqueteVO.setPalzoTerminacion			( validar( rs.getString( "plazoParaTerminacion" ),"" ) );
			paqueteVO.setPaqueteoVivienda			( validar( rs.getString( "paqueteoVivienda" ),"" ) );
			paqueteVO.setRegistroOferente			( validar( rs.getString( "registroDeOferente" ),"" ) );
			paqueteVO.setNumeroCedulaProfesional	( validar( rs.getString( "numeroCedulaProfesional" ),"" ) );
			paqueteVO.setNombreResponsableCalculo	( validar( rs.getString( "nombreResponsableCalculo" ),"" ) );
			paqueteVO.setNumeroCedulaCalculo		( validar( rs.getString( "numeroCedulaCalculo" ),"" ) );
			paqueteVO.setNombreResponsableObra		( validar( rs.getString( "nombreResponsableObra" ),"" ) );
			paqueteVO.setNumeroRegistroDro			( validar( rs.getString( "numeroRegistroDro" ),"" ) );
			paqueteVO.setRegistroDroEmitidoPor		( validar( rs.getString( "registroDroEmitidoPor" ),"" ) );
			paqueteVO.setVigenciaDro				( validar( rs.getString( "vigenciaDro" ),"" ) );
			paqueteVO.setLocalidadEjercicio			( validar( rs.getString( "localidadEjercicio" ),"" ) );
			paqueteVO.setNumeroCedulaObra			( validar( rs.getString( "numeroCedulaObra" ),"" ) );
			paqueteVO.setNumeroLinea				( validar( rs.getString( "numLinea" ),"" ) );
			paqueteVO.setPrograma					( validar( rs.getString( "programa" ),"" ) );
			paqueteVO.setConstructor				( validar( rs.getString( "constructor" ),"" ) );
			paqueteVO.setTipoPropiedad				( validar( rs.getString( "tipoPropiedad"),"") );
			paqueteVO.setPropietario				( validar( rs.getString( "propietario" ),"" ) );
			paqueteVO.setDomicilio					( validar( rs.getString( "domicilio" ),"" ) );
			paqueteVO.setVolumenEscritura			( validar( rs.getString( "volumenEscritura" ),"" ) );
			paqueteVO.setNumeroEscritura			( validar( rs.getString( "numeroEscritura" ),"" ) );
			paqueteVO.setNumeroNotario				( validar( rs.getString( "numeroNotario" ),"" ) );
			paqueteVO.setTomo						( validar( rs.getString( "tomo" ),"" ) );
			paqueteVO.setAreaVendible				( validar( rs.getString( "areaVendible" ),"" ) );
			paqueteVO.setDensidadAprovada			( validar( rs.getString( "densidadAprovada" ),"" ) );
			paqueteVO.setDensidadPropuesta			( validar( rs.getString( "densidadPropuesta" ),"" ) );
			paqueteVO.setFechaExcrituracion			( validar( rs.getString( "fEscrituracion" ),"" ) );
			paqueteVO.setInscripcionRPP				( validar( rs.getString( "inscripcionRPP" ),"" ) );
			paqueteVO.setTiempoRPP					( validar( rs.getString( "tiempoRPP" ),"" ) );
			paqueteVO.setAvanceUrbanizacion			( validar( rs.getString( "avanceUrbanizacion" ),"" ) );
			paqueteVO.setGradoUrbanizacion			( validar( rs.getString( "gradoUrbanizacion" ),"" ) );
			paqueteVO.setUrbanizado					( validar( rs.getString( "urbanizado" ),"" ) );
			paqueteVO.setSuperficieNetaVendible		( validar( rs.getString( "superficieNetaVendible" ),"" ) );
			paqueteVO.setPlanMestro					( validar( rs.getString( "planMestro" ),"" ) );
			paqueteVO.setConstanciaInfonavit		( validar( rs.getString( "constanciaInfonavit" ),"" ) );
			paqueteVO.setPrecioM2					( validar( rs.getString( "precioM2" ),"" ) );
			paqueteVO.setPrecioTotal				( validar( rs.getString( "precioTotal" ),"" ) );
			paqueteVO.setNumeroRPP					( validar( rs.getString( "numeroRPP" ),"" ) );
			paqueteVO.setRevalidacion				( validar( rs.getString( "revalidacion" ),"" ) );
			paqueteVO.setEstatus					( validar( rs.getString( "estatus" ),"" ) );
			paqueteVO.setMandato					( validar( rs.getString( "mandato" ),"" ) );
			paqueteVO.setMdto_sucursalBanco			( validar( rs.getString( "mdto_sucursalBanco" ),"" ) );
			paqueteVO.setMdto_banco					( validar( rs.getString( "mdto_banco" ),"" ) );
			paqueteVO.setMdto_cuentaBanco			( validar( rs.getString( "mdto_cuentaBanco" ),"" ) );
			paqueteVO.setMdto_beneficiario			( validar( rs.getString( "mdto_beneficiario" ),"" ) );
			paqueteVO.setMdto_clabe					( validar( rs.getString( "mdto_clabe" ),"" ) );
			paqueteVO.setCveOferente				( validar( rs.getString( "cveOferente" ),"" ) );
			paqueteVO.setRfcOferente				( validar( rs.getString( "rfcOferente" ),"" ) );
			paqueteVO.setCambiocta					( validar( rs.getString( "cambiocta" ),"" ) );
			paqueteVO.setConstruccion				( validar( rs.getString( "construccion" ),"" ) );
			paqueteVO.setCveSupervisor				( validar( rs.getString( "cveSupervisor" ),"" ) );
			paqueteVO.setMdto_rfc					( validar( rs.getString( "mdto_rfc" ),"" ) );
			paqueteVO.setCuc						( validar( rs.getString( "CUC" ),"" ) );
			paqueteVO.setFechaEnvioCuv				( validar( rs.getString( "fhenvioCUV" ),"" ) );
			paqueteVO.setFechaRecepcionCuv			( validar( rs.getString( "fhrecepcionCUV" ),"" ) );
			paqueteVO.setIdEnvioCuc					( validar( rs.getString( "idEnvioCUC" ),"" ) );
			paqueteVO.setNumeroPoliza				( validar( rs.getString( "nopoliza" ),"" ) );
			paqueteVO.setIdCuenta					( validar( rs.getString( "idcuenta" ),"" ) );
			paqueteVO.setClaveAseguradora			( validar( rs.getString( "cveaseguradora" ),"" ) );
			paqueteVO.setSeguro						( validar( rs.getString( "seguro" ),"" ) );
			paqueteVO.setIncremento					( validar( rs.getString( "incremento" ),"" ) );
			paqueteVO.setVolanteCuc					( validar( rs.getString( "volanteCUC" ),"" ) );
			paqueteVO.setLatitud					( validar( rs.getString( "latitud" ),"" ) );
			paqueteVO.setLongitud					( validar( rs.getString( "longitud" ),"" ) );
			paqueteVO.setAltitud					( validar( rs.getString( "altitud" ),"" ) );
			paqueteVO.setDist_vertice				( validar( rs.getString( "dist_vertice" ),"" ) );
			paqueteVO.setIdOnavi					( validar( rs.getString( "idOnavi" ),"" ) );
			paqueteVO.setOfertaEcologica			( validar( rs.getString( "OFERTA_ECOLOGICA" ),"" ) );
			paqueteVO.setViviendasAprobadas			( validar( rs.getString( "VIVIENDAS_APROBADAS" ),"" ) );
			paqueteVO.setIdOrdenVerificacion		( validar( rs.getString( "idOrdenVerificacion" ),"" ) );
			
		  return paqueteVO;	
		}
	}
	@Override
	public PaqueteVo buscar(PaqueteVo registro) {
		LOGGER.debug("[CVD] - Buscando información en la tabla: cedulapresentacion, generando criterios de busqueda...");
		String criterios = generarCriterios(registro,null);
		String query     = "";
		if( criterios ==null || criterios.length()==0)
			throw new IllegalArgumentException("No hay cirterios para realizar la busqueda");
		try
		{
			query = reemplazar("SELECT * FROM cedulapresentacion WITH(NOLOCK) WHERE CRITERIOS","CRITERIOS",criterios);
			LOGGER.debug("[CVD] - Query ha ejecutar: "+query);
			return this.jdbcVivienda.queryForObject(query,new PaqueteMapper());
		}catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	@Override
	public List<PaqueteVo> buscarLista(PaqueteVo registro) {
		
		return null;
	}
	@Override
	public Set<PaqueteVo> buscarUnicos(PaqueteVo registro) {
		
		return null;
	}
	@Override
	public String generarCriterios(PaqueteVo criterios, List<Object> parametros) {

		StringBuffer regreso = new StringBuffer();
		
		if( criterios.getIdPaquete()!=null && !criterios.getIdPaquete().trim().equals(""))
		{
			if( regreso.length()>0)
			{
				regreso.append(" AND idNumerocedula='"+criterios.getIdPaquete()+"'");
			}else
			{
				regreso.append(" idNumerocedula='"+criterios.getIdPaquete()+"'");
				
			}
			
		}
		if( criterios.getIdOrdenVerificacion()!=null && !criterios.getIdOrdenVerificacion().trim().equals(""))
		{
			if( regreso.length()>0)
			{
				regreso.append(" AND idOrdenVerificacion='"+criterios.getIdOrdenVerificacion()+"'");
			}else
			{
				regreso.append(" idOrdenVerificacion='"+criterios.getIdOrdenVerificacion()+"'");
			}
			
		}
		if( criterios.getIdOferente()!=null && !criterios.getIdOferente().trim().equals(""))
		{
			if( regreso.length()>0)
			{
				regreso.append(" AND idOferente='"+criterios.getIdOferente()+"'");
			}else
			{
				regreso.append(" idOferente='"+criterios.getIdOferente()+"'");
				
			}
			
		}
		if( criterios.getCveSupervisor()!=null && !criterios.getCveSupervisor().trim().equals(""))
		{
			if( regreso.length()>0)
			{
				regreso.append(" AND cveSupervisor='"+criterios.getCveSupervisor()+"'");
			}else
			{
				regreso.append(" cveSupervisor='"+criterios.getCveSupervisor()+"'");
			}
			
		}
		return regreso.toString();
	}
	@Override
	public boolean guardar(PaqueteVo registro) {
		
		return false;
	}
	@Override
	public boolean guardar(List<PaqueteVo> registros) {
		
		return false;
	}
	
		

	

	


	

}
