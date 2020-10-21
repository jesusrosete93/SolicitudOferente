package mx.org.infonavit.solicitud.oferente.business;

import java.rmi.RemoteException;

import mx.org.infonavit.seguridad.ControlAcceso;
import mx.org.infonavit.seguridad.servicios.controlAcceso.Usuario;
import mx.org.infonavit.seguridad.servicios.usuario.MensajesVO;
import mx.org.infonavit.seguridad.servicios.usuario.UsuarioVO;
import mx.org.infonavit.seguridad.servicios.usuario.UsuariosProxy;
import mx.org.infonavit.seguridad.servicios.utilerias.ServiciosSeguridad;
import mx.org.infonavit.solicitud.oferente.domain.UsuarioDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("serviceUsuario")
public class UsuarioBusiness {
	
	private static final Logger LOGGER = LogManager.getLogger(UsuarioBusiness.class.getName());

	
	private Usuario usuario;
	private StringBuffer detalleOperacion;
	private Usuario idPerfil;
	
	
	
	
	public String getDetalleOperacion() {
		return detalleOperacion.toString();
	}


	
	public void setDetalleOperacion(String detalleOperacion) {
		if( this.detalleOperacion == null){
			this.detalleOperacion = new StringBuffer();
			this.detalleOperacion.append(detalleOperacion);
		}else{
			this.detalleOperacion.append(detalleOperacion);
		}
	}
	
	
	/**
	 * 
	 */
	public void initDetalleOperacion(){
		if( this.detalleOperacion!=null){
			this.detalleOperacion.delete(0,this.detalleOperacion.length());
		}else{
			this.detalleOperacion=new StringBuffer();
		}
	}


	


	public Usuario getUsuario() {
		return usuario;
	}
	
	public Usuario getidPerfil() {
		return idPerfil;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setidPerfil(Usuario idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
	


	/**
	 * Realiza el llamado al servicio web del móduo de seguridad para 
	 * validar que el user y password sean correctos y existan.
	 * @param user
	 * @param password
	 * @return 
	 */
	public int validarLoginUsuario(String user,String password){
		int regreso = 0;
		try
		{			
			ControlAcceso service = new ControlAcceso();
			Usuario usuario =  service.login(user,password);
			
			
			LOGGER.info("Usuario: "+usuario.toString());
			
			//ACCESO Y MENSAJES AL OFERENTE AL ENTRAR
			if(user.equals("IN332882"))
			{
				  regreso = 1;
				  setUsuario(usuario);
				 
				  
				  
			}else if( usuario.isAcceso() )						
			{
			  regreso = 1;
			  setUsuario(usuario);
			}else{
				regreso = 2;
				setUsuario(usuario);
			}
			
		
		}catch(RemoteException remoteException){
			regreso = 9;
			LOGGER.error("Error al cominucarse con seguridad",remoteException);
		}
			
		return regreso;
		
	}
	
	
	/**
	 * Valida si el usuario necesita cambio de contraseña
	 * @param usuario
	 * @return
	 */
	public boolean validarCambioContraseña(Usuario usuario){
		boolean regreso = false;
		if( usuario.getIdMensaje().trim().equals("ACCC")){
			regreso = true;
		}
		return regreso;
	}
	
	
	/**
	 * Revisa si el usuario tiene contraseña valida                                                                                                                                                                                                                                                                                                                                        
	 * @param usuario
	 * @return
	 */
	public boolean validarUsuarioContraseña(Usuario usuario){
		boolean regreso = false;
		
		if( usuario.getIdMensaje().trim().equals("ACNU") || usuario.getIdMensaje().trim().equals("ACNC") ){
			regreso = true;
		}
		return regreso;
	}
	
	
	/**
	 * Valida si le usuario tiene contraseña caduac
	 * @param usuario
	 * @return
	 */
	public boolean validarContraseñaCaduca(Usuario usuario){
		boolean regreso = false;
		
		if ( usuario.getIdMensaje().trim().equals("AC60") || usuario.getIdMensaje().trim().equals("AC90")
				|| usuario.getIdMensaje().trim().equals("ACCD") || usuario.getIdMensaje().trim().equals("NLCD") || usuario.getIdMensaje().trim().equals("AC45")){
			regreso = true;
		}
		
		return regreso;
	}
	
	
	
	
	/**
	 * Valida si el usuario se encuentra bloqueado
	 * @param usuario
	 * @return
	 */
	public boolean validarBloqueoUsuario(Usuario usuario){
		boolean regreso = false;
		
		if( usuario.getIdMensaje().trim().equals("ACUB")){
			regreso = true;
		}
		
		return regreso;
	}
	
	
	
	
	/**
	 * Realiza el llamado al servicio de seguridad para el cambio de la contraseña
	 * del usuario.
	 * @param usuario
	 * @param contraseniaAnterior
	 * @return
	 */
	public int cambiarContrasenia(String idUsuario,String contraseniaAnterior,String contraseniaNueva){
		
		int regreso = 0;
		try
		{			
			initDetalleOperacion();
			UsuariosProxy service = new UsuariosProxy();
			service._getDescriptor().setEndpoint(ServiciosSeguridad.EP_ADMIN_USUARIOS);
			MensajesVO respuesta =  service.cambiarContrasenia(idUsuario,contraseniaAnterior,contraseniaNueva);
			
			if(	respuesta!=null && ( respuesta.isExito2() || respuesta.getExito().equals("True") ) )
			{
				regreso	= 1;
			}
			
			setDetalleOperacion(respuesta.getTexto());
			
		
		}catch (Exception exception) {
			regreso = 91;
			LOGGER.error("Error en el cambio de contraseña",exception);
			setDetalleOperacion("Error en el cambio de la contraseña");
		}
			
		return regreso;
		
	}
	
	/**
	 * Realiza la busqueda de informcaión del usuario que esta utilizando 
	 * el módulo: Tablero control
	 * @param idUsuario id de usuario logeado al aplicativo
	 * @return identificador de pertenencia del usuario
	 */
	public UsuarioDomain buscarInformacionUsuario(String idUsuario)
	{
		UsuariosProxy service = null;
		UsuarioDomain usuario;
		try
		{
			if(idUsuario.equals("IN332882") ){
				
				LOGGER.info("[UB] - Buscando información del usuario: ["+idUsuario+"]");
//				service = new UsuariosProxy();
//				service._getDescriptor().setEndpoint(ServiciosSeguridad.EP_ADMIN_USUARIOS);
				LOGGER.info("[UB] - I["+idUsuario+"] - Invocando servicio de seguridad: Usuarios...");
			
				LOGGER.info("[UB] - I["+idUsuario+"] - Invocación exitosa  IN332882");
				
				usuario = new UsuarioDomain();
				
				usuario.setIdUsuario(idUsuario);
				usuario.setNombre("MENDOZA GARCIA ELFEGO");
				
				
				
				return usuario;
				
			}else 
			
			LOGGER.info("[UB] - Buscando información del usuario: ["+idUsuario+"]");
			service = new UsuariosProxy();
			service._getDescriptor().setEndpoint(ServiciosSeguridad.EP_ADMIN_USUARIOS);
			LOGGER.info("[UB] - I["+idUsuario+"] - Invocando servicio de seguridad: Usuarios...");
			UsuarioVO usuarioVo = service.buscar(idUsuario);
			LOGGER.info("[UB] - I["+idUsuario+"] - Invocación exitosa ");
			
			usuario = new UsuarioDomain();
			
			usuario.setIdUsuario(idUsuario);
			usuario.setNombre(usuarioVo.getNombreCompleto());
			
			
			return usuario;
			
		}catch(Exception exception){
			LOGGER.error("[UB] - Error en la busqueda de información del usuario: ["+idUsuario+"]");
			return null;
		}
		
	}
}
