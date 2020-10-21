package mx.org.infonavit.solicitud.oferente.procesos;

import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.ERROR;
import static mx.org.infonavit.solicitud.oferente.utils.Cadenas.INICIO_OK;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;

import mx.org.infonavit.solicitud.oferente.business.BitacoraAvaluoMapBusiness;
import mx.org.infonavit.solicitud.oferente.business.PeticionBusiness;
import mx.org.infonavit.solicitud.oferente.domain.AvaluoCerradoMaiDomain;
import mx.org.infonavit.solicitud.oferente.domain.BitacioraEnvioAvaluoMapDomain;
import mx.org.infonavit.solicitud.oferente.persistence.AbstractDao;
import mx.org.infonavit.solicitud.oferente.persistence.vo.FotoAvaluoVo;
import mx.org.infonavit.solicitud.oferente.persistence.vo.PeticionVo;
import mx.org.infonavit.solicitud.oferente.utils.Resources;

import org.apache.axis.client.Stub;
import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.nexura.qa_controlygestiongbt.WSFolioBindingStub;


public class ProcesoFotosAvaluo implements Callable<List<AvaluoCerradoMaiDomain>>
{
	private static final Logger LOGGER = Logger.getLogger(ProcesoFotosAvaluo.class);
	private static final String PREFIJO = "[PFA] - ";
	private static final String PROCESO = " Envio información avaluos ";
	private static final String ENVIO_AVA_INFO = " Información  ";
	private static final String ENVIO_AVA_DOCS = " Documento/Fotos  ";
	private List<AvaluoCerradoMaiDomain> avaluos;
	private AbstractDao<FotoAvaluoVo> persistenceFoto;
//	private String cadena = new String("");
//	private AbstractDao<DocumentoAvaluoVo> persistenceDocumento;
	private PeticionBusiness servicePeticion;
	private BitacoraAvaluoMapBusiness serviceBitacora;
	
	public ProcesoFotosAvaluo(List<AvaluoCerradoMaiDomain> avaluos,PeticionBusiness servicePeticion,BitacoraAvaluoMapBusiness serviceBitacora)
	{
		this.avaluos = avaluos;
//		this.persistenceFoto = persistence;
//		this.persistenceDocumento = persistenceDocumento;
		this.servicePeticion = servicePeticion;
		this.serviceBitacora = serviceBitacora;
	}
	
	
	@Override
	public List<AvaluoCerradoMaiDomain> call() throws Exception {
		List<AvaluoCerradoMaiDomain> avaluosFotos = new ArrayList<AvaluoCerradoMaiDomain>();
		WSFolioBindingStub service = null;
		StringWriter writer = null;
		Serializer serializer = null;
//		StringWriter writerI = null;
//		Serializer serializerI = null;
		PeticionVo peticion1 = null;
//		PeticionVo peticion2 = null;
		BitacioraEnvioAvaluoMapDomain bitacora1;
//		BitacioraEnvioAvaluoMapDomain bitacora2;
		
		long inicio1 = 0L;
		long fin1 = 0L;
		
		String xmlEntrada="";

		
		LOGGER.info(PREFIJO+PROCESO+INICIO_OK);
		if( this.avaluos!=null && !this.avaluos.isEmpty())
		{
			
			service = new WSFolioBindingStub();
			LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Procesando: "+this.avaluos.size() + " avaluo(s)");
			int registro = 0;
			for (AvaluoCerradoMaiDomain avaluo : this.avaluos) 
	        {
				LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Registro["+registro+"]");
				peticion1 = new PeticionVo();
				bitacora1 = new BitacioraEnvioAvaluoMapDomain();

				
				IntHolder code = new IntHolder();
				StringHolder message = new StringHolder();
				

				
				writer = new StringWriter();
				serializer = new Persister();
	
				
	    	    try
	    	  		{
		    	    		
			    	    	serializer.write(avaluo, writer);
							xmlEntrada = writer.toString().replace("<avaluoCerradoMaiDomain>","").replace("</avaluoCerradoMaiDomain>","");
							
							//Anterior: http://qa-controlygestiongbt.nexura.com/loader.php?lServicio=Asignacion&lTipo=avaluosinfonavit&lFuncion=receivedData
							//Nueva(2018-08-10): http://qa-controlygestiongbt.nexura.com/loader.php?lServicio=AsignacionF2&lTipo=avaluosinfonavit&lFuncion=receivedData
							LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Avaluo["+avaluo.getIdAvaluo()+"] - EP["+Resources.EP_SERVICIO_NEXURA+"]");
							
							//Asignando id del avaluo para la bitacora - - - - -
							bitacora1.setIdAvaluo(avaluo.getIdAvaluo());
							
							//Asignando el end point y obteniendo el el servicio - - - -  
						    ((Stub)service)._setProperty(Stub.ENDPOINT_ADDRESS_PROPERTY, Resources.EP_SERVICIO_NEXURA);
						    
							LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Avaluo["+avaluo.getIdAvaluo()+"] - ["+xmlEntrada+"]");
							inicio1 = System.currentTimeMillis();
							service.gstServicesInfonavitValidation("1",xmlEntrada, code, message);
							fin1 = System.currentTimeMillis();
							
							LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Avaluo["+avaluo.getIdAvaluo()+"] - Respuesta  C:["+code.value+"] M:["+message.value+"]");
							avaluo.setResultadoEnvio1(code.value);
							avaluo.setRespuestaEnvio1(message.value);
							avaluo.setRespuestaEnvio2("No hay foto de fachada, no se envía información de imagen");
							avaluo.setEnvioAvaluo(true);
							
							
							bitacora1.setIdOperacion(22);
							
							if(code.value==1)
							{
								//Bitacora
								bitacora1.setResultadoOperacion(true);
								
								//Registrando peticion
								peticion1.setIdAplicacion(1);
								peticion1.setIdOperacion(22);
								peticion1.setResultadoPeticion(true);
								peticion1.setTiempoAtencion(String.format("%.3f",((fin1-inicio1)/1000.0f)));
								peticion1.setXmlRequest(xmlEntrada);
								peticion1.setXmlResponse("<codigo>"+code.value+"</codigo><mensaje>"+message.value+"</mensaje>");
								servicePeticion.guardarPeticion(peticion1);
								
								bitacora1.setIdPeticion(peticion1.getIdPeticion());
								bitacora1.setDetalleResultado("Se envian correctamente los datos del avaluo |RWS:"+message.value);
								serviceBitacora.registroBitacora(bitacora1);
								LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_INFO+" Avaluo["+avaluo.getIdAvaluo()+"] - Recepción de avaluo exitosa");
							}else
							{
								LOGGER.info(PREFIJO+PROCESO+ENVIO_AVA_DOCS+" Avaluo["+avaluo.getIdAvaluo()+"] - Recepción de avaluo no exiosa no se envia documentos ni fotos");
								peticion1.setIdAplicacion(1);
								peticion1.setIdOperacion(22);
								peticion1.setResultadoPeticion(false);
								peticion1.setTiempoAtencion(String.format("%.3f",((fin1-inicio1)/1000.0f)));
								peticion1.setXmlRequest(xmlEntrada);
								peticion1.setXmlResponse("<codigo>"+code.value+"</codigo><mensaje>"+message.value+"</mensaje>");
								servicePeticion.guardarPeticion(peticion1);
								
								
								bitacora1.setResultadoOperacion(false);
								bitacora1.setDetalleResultado("La recepción del avaluo no fue exitosa por lo que no se envian documentos ni fotos|RWS:"+message.value+"|Peticion:"+peticion1.getIdPeticion());
								bitacora1.setIdPeticion(peticion1.getIdPeticion());
								
								serviceBitacora.registroBitacora(bitacora1);
								
								avaluo.setEnvioFoto(false);
								avaluo.setResultadoEnvio2(-1);
								avaluo.setRespuestaEnvio2("La recepción del avaluo no fue exitosa por lo que no se envian documentos ni fotos");
							}
		    	    	continue;
		    		}catch(Exception exception)
	    	  		{
	    	  			LOGGER.error(PREFIJO+PROCESO+" Avaluo["+avaluo.getIdAvaluo()+"]"+ERROR,exception);
	    	  			peticion1.setIdAplicacion(1);
						peticion1.setIdOperacion(22);
						peticion1.setResultadoPeticion(false);
						peticion1.setTiempoAtencion(String.format("%.3f",((fin1-inicio1)/1000.0f)));
						peticion1.setXmlRequest(xmlEntrada);
						peticion1.setXmlResponse("<codigo>"+code.value+"</codigo><mensaje>"+message.value+"</mensaje>");
						servicePeticion.guardarPeticion(peticion1);
						
						
						bitacora1.setIdPeticion(peticion1.getIdPeticion());
						bitacora1.setResultadoOperacion(false);
						bitacora1.setDetalleResultado("Error en el envío del avalúo|RWS:"+message.value+"|Peticion:"+peticion1.getIdPeticion());
						
						serviceBitacora.registroBitacora(bitacora1);
						
						avaluo.setEnvioFoto(false);
						avaluo.setResultadoEnvio2(-1);
						avaluo.setRespuestaEnvio2("La recepción del avaluo no fue exitosa por lo que no se envian documentos ni fotos");
	    	  			avaluo.setFotoFachada(null);
	    	  			if( avaluo.getResultadoEnvio1()!=1 )
	    	  			{
	    	  				avaluo.setRespuestaEnvio1("Excepción en el proceso de envio del avaluo, se envio información:"+(avaluo.getResultadoEnvio1()==1?"Si":"No"));
	    	  			}
	    	  			if( avaluo.getResultadoEnvio2()!=1 )
	    	  			{
	    	  				avaluo.setRespuestaEnvio2("Excepción en el proceso de envio del avaluo, se envio documento/foto:"+(avaluo.getResultadoEnvio2()==1?"Si":"No"));
	    	  			}
	    	  			continue;
	    	  		}finally{
	    	  			avaluosFotos.add(avaluo);
	    	  			registro++;
	    	  		}
		   }
		}
      return avaluosFotos;
	}
	
	
   public List<AvaluoCerradoMaiDomain> getAvaluos() {
		return avaluos;
	}


	public void setAvaluos(List<AvaluoCerradoMaiDomain> avaluos) {
		this.avaluos = avaluos;
	}


	public AbstractDao<FotoAvaluoVo> getPersistenceFoto() {
		return persistenceFoto;
	}


	public void setPersistenceFoto(AbstractDao<FotoAvaluoVo> persistenceFoto) {
		this.persistenceFoto = persistenceFoto;
	}


	/**
	 * @return the servicePeticion
	 */
	public PeticionBusiness getServicePeticion() {
		return servicePeticion;
	}


	/**
	 * @param servicePeticion the servicePeticion to set
	 */
	public void setServicePeticion(PeticionBusiness servicePeticion) {
		this.servicePeticion = servicePeticion;
	}


	/**
	 * @return the serviceBitacora
	 */
	public BitacoraAvaluoMapBusiness getServiceBitacora() {
		return serviceBitacora;
	}


	/**
	 * @param serviceBitacora the serviceBitacora to set
	 */
	public void setServiceBitacora(BitacoraAvaluoMapBusiness serviceBitacora) {
		this.serviceBitacora = serviceBitacora;
	}
}

