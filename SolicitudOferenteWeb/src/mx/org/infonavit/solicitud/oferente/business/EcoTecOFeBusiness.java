package mx.org.infonavit.solicitud.oferente.business;

import static mx.org.infonavit.solicitud.oferente.domain.utitls.EcoTecnologiasDomainUtils.getTecnologiaDomain;
import static mx.org.infonavit.solicitud.oferente.domain.utitls.OferenteDomainUtils.getObjetoOferenteDomainDeVo;

import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import mx.org.infonavit.solicitud.oferente.business.services.ECOOferenteService;
import mx.org.infonavit.solicitud.oferente.domain.EcoTecnologiasDomain;
import mx.org.infonavit.solicitud.oferente.domain.TecnologiaDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractECODao;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractReportesEcoDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.EcoTecnologiasVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.ReporteEcoTecnologiaVo;

@Service("EcoTecOFeBusiness")
public class EcoTecOFeBusiness implements ECOOferenteService {
	
	private static final Logger LOGGER = LogManager.getLogger(EcoTecOFeBusiness.class);
	
	@Autowired
	@Qualifier("ReporteEcoTecnologiasDao")
	private AbstractReportesEcoDao<ReporteEcoTecnologiaVo>  persistenceEco;

	@Override
	public TecnologiaDomain consultareECO(String claveTecnologia) {
		try
		{
			LOGGER.info("Consultando la información de la ecotecnologia:["+claveTecnologia+"]");

			ReporteEcoTecnologiaVo criterios = new ReporteEcoTecnologiaVo();
			criterios.setClaveTecnologia(claveTecnologia);
			//			return getObjetoOferenteDomainDeVo(persistenceEco.buscar(criterios));
			return getTecnologiaDomain(persistenceEco.buscarReporteEcoTecnologias(criterios));
		}catch (Exception e) {
			LOGGER.error("ERROR--- Consultando la información de la ecotecnologia:["+claveTecnologia+"]",e);
			return null;
		}
		
	}
	


	private static TecnologiaDomain getTecnologiaDomain(List<ReporteEcoTecnologiaVo> buscarReporteEcoTecnologias)
	{
//			if( buscarReporteEcoTecnologias!=null)
//			{
//				ReporteEcoTecnologiaVo regreso = new ReporteEcoTecnologiaVo(null, null,null,null);
//				regreso.setClaveTecnologia(buscarReporteEcoTecnologias.());
//				regreso.setPaquete(registro.getPaquete());
//				regreso.setanioMES(regreso.getanioMES());
//				regreso.setnumecotec(regreso.getanioMES());
//				
//				
//				return regreso;
//			}else
			{
				return null;
			}
	}

//	public static ReporteEcoTecnologiaVo getTecnologiaDomain(ReporteEcoTecnologiaVo registro)
//	{
//		if( registro!=null)
//		{
//			ReporteEcoTecnologiaVo regreso = new ReporteEcoTecnologiaVo(null, null,null,null);
//			regreso.setClaveTecnologia(registro.getClaveTecnologia());
//			regreso.setPaquete(registro.getPaquete());
//			regreso.setanioMES(regreso.getanioMES());
//			regreso.setnumecotec(regreso.getanioMES());
//			
//			
//			return regreso;
//		}else
//		{
//			return null;
//		}
//	}



}
