package mx.org.infonavit.solicitud.oferente.utils;

import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;

public class AvaluosUtils {
	
	public static String obtenerIdsAavaluos(List<AvaluoCerradoMaiDomain> avaluos)
	{
		List<String> ids = new ArrayList<String>();
		if( avaluos!=null && !avaluos.isEmpty() )
		{
			for(AvaluoCerradoMaiDomain avaluo : avaluos)
			{
				ids.add(avaluo.getIdAvaluo());
			}
			return ids.toString();
		}else
		{
			return ids.toString();
		}
	}
	/**
	 * 
	 * @param avaluos
	 * @return
	 */
	public static List<String> obtenerIds(List<AvaluoDomain> avaluos)
	{
		List<String> ids = new ArrayList<String>();
		if( avaluos!=null && !avaluos.isEmpty() )
		{
			for(AvaluoDomain avaluo : avaluos)
			{
				ids.add(avaluo.getIdAvaluo().trim());
			}
			return ids;
		}else
		{
			return ids;
		}
	}

}
