package mx.org.infonavit.solicitud.oferente.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import mx.org.infonavit.solicitud.oferente.persistence.vo.EnfoqueMercadoVo;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.*;



@Repository("EnfoqueMercadoDao")
public class EnfoqueMercadoDao extends AbstractDao<EnfoqueMercadoVo> {
	
	private static final String SELECT = "SELECT * FROM enfoque_mercado WITH(NOLOCK) ";
	private static final Logger LOGGER = LogManager.getLogger(EnfoqueMercadoDao.class);
	
	private class EnfoqueExtractor implements ResultSetExtractor<List<EnfoqueMercadoVo>>
	{
		@Override
		public List<EnfoqueMercadoVo> extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {
			List<EnfoqueMercadoVo> regreso = new ArrayList<EnfoqueMercadoVo>();
			while(resultSet.next())
			{
				regreso.add(new EnfoqueMercadoVo(resultSet.getInt("id_registro")
										,validar(resultSet.getString("id_avaluo"),"")
										,validar(resultSet.getString("id_paquete"),"")
										,resultSet.getInt("id_vivienda")
										,validar(resultSet.getString("edad"),"")
										,resultSet.getInt("id_conservacion")
										,validar(resultSet.getString("valor_oferta"),"")
										,validar(resultSet.getString("superficie_terreno"),"")
										,validar(resultSet.getString("superficie_construccion"),"")
										,validar(resultSet.getString("valor_unitario"),"")
										,validar(resultSet.getString("factor_fic"),"")
										,validar(resultSet.getString("factor_zona"),"")
										,validar(resultSet.getString("factor_ubicacion"),"")
										,validar(resultSet.getString("factor_superficie"),"")
										,validar(resultSet.getString("factor_edad"),"")
										,validar(resultSet.getString("factor_conservacion"),"")
										,validar(resultSet.getString("factor_otros"),"")
										,validar(resultSet.getString("factor_comercializacion"),"")
										,validar(resultSet.getString("factor_resultante"),"")
										));
			}
		 return regreso;
		}
		
	}

	private class EnfoqueMercadoMapper implements RowMapper<EnfoqueMercadoVo>
	{

		@Override
		public EnfoqueMercadoVo mapRow(ResultSet resultSet, int fecth)
				throws SQLException {
			// TODO Auto-generated method stub
			return new EnfoqueMercadoVo(resultSet.getInt("id_registro")
										,validar(resultSet.getString("id_avaluo"),"")
										,validar(resultSet.getString("id_paquete"),"")
										,resultSet.getInt("id_vivienda")
										,validar(resultSet.getString("edad"),"")
										,resultSet.getInt("id_conservacion")
										,validar(resultSet.getString("valor_oferta"),"")
										,validar(resultSet.getString("superficie_terreno"),"")
										,validar(resultSet.getString("superficie_construccion"),"")
										,validar(resultSet.getString("valor_unitario"),"")
										,validar(resultSet.getString("factor_fic"),"")
										,validar(resultSet.getString("factor_zona"),"")
										,validar(resultSet.getString("factor_ubicacion"),"")
										,validar(resultSet.getString("factor_superficie"),"")
										,validar(resultSet.getString("factor_edad"),"")
										,validar(resultSet.getString("factor_conservacion"),"")
										,validar(resultSet.getString("factor_otros"),"")
										,validar(resultSet.getString("factor_comercializacion"),"")
										,validar(resultSet.getString("factor_resultante"),"")
										);
		}
		
	}
	
	@Override
	public EnfoqueMercadoVo buscar(EnfoqueMercadoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnfoqueMercadoVo> buscarLista(EnfoqueMercadoVo registro) {
//		return this.jdbcAvaluos.query("SELECT * FROM enfoque_mercado WITH(NOLOCK) WHERE id_avaluo=?", new EnfoqueMercadoMapper(),registro.getIdAvaluo());
		String regreso = "";
		StringBuilder sentencia = new StringBuilder();
		regreso  = generarCriterios(registro,null);
		if( regreso!=null && !regreso.equals("") )
		{
			sentencia.append(SELECT).append(WHERE).append(regreso);
		}
		LOGGER.info("Senetencia a ejecutar: "+sentencia.toString());
		return this.jdbcAvaluos.query(sentencia.toString(),new EnfoqueExtractor());
	}

	@Override
	public String generarCriterios(EnfoqueMercadoVo registro,List<Object> parametros) {
		StringBuilder regreso = new StringBuilder();
		if( registro.getValorUnitarioInicio()!=null && !registro.getValorUnitarioInicio().trim().equals("") && registro.getValorUnitarioMaximo()!=null && !registro.getValorUnitarioMaximo().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("valor_unitario").append(MAYOR_IGUAL).append(COMILLA).append(registro.getValorUnitarioInicio()).append(COMILLA).append(AND).append("valor_unitario").append(MENOR_IGUAL).append(COMILLA).append(registro.getValorUnitarioMaximo()).append(COMILLA);
			}else
			{
				regreso.append("valor_unitario").append(MAYOR_IGUAL).append(COMILLA).append(registro.getValorUnitarioInicio()).append(COMILLA).append(AND).append("valor_unitario").append(MENOR_IGUAL).append(COMILLA).append(registro.getValorUnitarioMaximo()).append(COMILLA);
			}
		}
		if( registro.getFactorFic()!=null && !registro.getFactorFic().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_fic").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorFic()).append(COMILLA);
			}else
			{
				regreso.append("factor_fic").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorFic()).append(COMILLA);
			}
		}
		if( registro.getFactorZona()!=null && !registro.getFactorZona().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_zona").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorZona()).append(COMILLA);
			}else
			{
				regreso.append("factor_zona").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorZona()).append(COMILLA);
			}
		}
		if( registro.getFactorUbicacion()!=null && !registro.getFactorUbicacion().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_ubicacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorUbicacion()).append(COMILLA);
			}else
			{
				regreso.append("factor_ubicacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorUbicacion()).append(COMILLA);
			}
		}
		if( registro.getFactorSuperficie()!=null && !registro.getFactorSuperficie().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_superficie").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorSuperficie()).append(COMILLA);
			}else
			{
				regreso.append("factor_superficie").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorSuperficie()).append(COMILLA);
			}
		}
		if( registro.getFactorEdad()!=null && !registro.getFactorEdad().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_edad").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorEdad()).append(COMILLA);
			}else
			{
				regreso.append("factor_edad").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorEdad()).append(COMILLA);
			}
		}
		if( registro.getFactorConservacion()!=null && !registro.getFactorConservacion().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_conservacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorConservacion()).append(COMILLA);
			}else
			{
				regreso.append("factor_conservacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorConservacion()).append(COMILLA);
			}
		}
		if( registro.getFactorOtros()!=null && !registro.getFactorOtros().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_otros").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorOtros()).append(COMILLA);
			}else
			{
				regreso.append("factor_otros").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorOtros()).append(COMILLA);
			}
		}
		if( registro.getFactorComercializacion()!=null && !registro.getFactorComercializacion().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_comercializacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorComercializacion()).append(COMILLA);
			}else
			{
				regreso.append("factor_comercializacion").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorComercializacion()).append(COMILLA);
			}
		}
		if( registro.getFactorResultante()!=null && !registro.getFactorResultante().trim().equals("") )
		{
			if( regreso.length()>0)
			{
				regreso.append(AND).append("factor_resultante").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorResultante()).append(COMILLA);
			}else
			{
				regreso.append("factor_resultante").append(MAYOR_IGUAL).append(COMILLA).append(registro.getFactorResultante()).append(COMILLA);
			}
		}
		
		if( registro.getIdAvaluo()!=null && !registro.getIdAvaluo().trim().equals(""))
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
			}else
			{
				regreso.append("id_avaluo").append(IGUAL).append(COMILLA).append(registro.getIdAvaluo()).append(COMILLA);
			}
		}
		
		if( registro.getAvaluos()!=null && !registro.getAvaluos().trim().equals(""))
		{
			if( regreso.length()>0 )
			{
				regreso.append(AND).append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}else
			{
				regreso.append("id_avaluo").append(IN).append(PARANETESIS_ABRE).append(registro.getAvaluos()).append(PARANETESIS_CIERRA);
			}
		}
		
		if( regreso==null || regreso.length()==0)
		{
			throw new IllegalArgumentException("No hay criterios para realizar la busqueda");
		}
		
	 return regreso.toString();
		
	}

	@Override
	public boolean guardar(EnfoqueMercadoVo registro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guardar(List<EnfoqueMercadoVo> registros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<EnfoqueMercadoVo> buscarUnicos(EnfoqueMercadoVo registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
