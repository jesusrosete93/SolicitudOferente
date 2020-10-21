package mx.org.infonavit.solicitud.oferente.utils;

import mx.org.infonavit.seguridad.servicios.controlAcceso.Usuario;
import mx.org.infonavit.solicitud.oferente.business.UsuarioBusiness;
import mx.org.infonavit.solicitud.oferente.domain.UsuarioDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public class AuthenticationProviderTA implements AuthenticationProvider {
	
	private static final Logger  LOGGER = LogManager.getLogger(AuthenticationProviderTA.class.getName());
	
	@Autowired
	@Qualifier("serviceUsuario")
    private UsuarioBusiness serviceUsuario;

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		Usuario user = null;
		LOGGER.info("[AP] - Autenticando...");
		int regreso = serviceUsuario.validarLoginUsuario((String)auth.getPrincipal(),(String)auth.getCredentials());
		if( regreso ==1 ){
			LOGGER.debug("[AP] - Autenticación exitosa, validando perfil...");
			 user = serviceUsuario.getUsuario();
			 UsuarioDomain usuarioDomain = serviceUsuario.buscarInformacionUsuario((String)auth.getPrincipal());
			 if( user.getIdPerfil().trim().equals("AGVI") && usuarioDomain!=null)
			 {
				 LOGGER.info("[AP] - Perfil correcto, asignando rol...");
				 Authentication _authAuthentication = new UsernamePasswordAuthenticationToken(
							usuarioDomain,
							auth.getCredentials(),
							AuthorityUtils.createAuthorityList(user.getIdPerfil(),"AVATAB_USER"));
//		           		    AuthorityUtils.createAuthorityList(user.getIdPerfil(),"ECO_USER"));
		          return _authAuthentication;
			 } 
			 	else	 if( user.getIdPerfil().trim().equals("No Disponible") )
			 {
				 LOGGER.info("[AP] - Perfil correcto, asignando rol Eco");
				 Authentication _authAuthentication = new UsernamePasswordAuthenticationToken(
							usuarioDomain,
							auth.getCredentials(),						
//		           		    AuthorityUtils.createAuthorityList(user.getIdPerfil(),"ECO_USER"));
				            AuthorityUtils.createAuthorityList("AGVI","ECO_USER"));
		          return _authAuthentication;
		          
			 }else{
				 if( !user.getIdPerfil().trim().equals("AGVI") )
				 {
					 throw new BadCredentialsException("El perfil del usuario no es valido para este aplicativo");
				 }else
				 {
					 LOGGER.info("[AP] - Perfil no valido");
					 throw new BadCredentialsException("Error al validar pefil y obtención de información de usuario"); 
				 }
				 
			 }	 
				 
				 
			 
			
	}else if(regreso==2){
		LOGGER.info("[AP] - Acceso NOK, validando si es necesario el cambio de contraeaña");
		user = serviceUsuario.getUsuario();
		if(serviceUsuario.validarCambioContraseña(user) || serviceUsuario.validarContraseñaCaduca(user) ){
			LOGGER.info("[AP] - Se requiere cambio de contraseña");
			throw new BadCredentialsException("CC");
		}else if(serviceUsuario.validarBloqueoUsuario(user)){
			LOGGER.info("[AP] - Usuario bloqueado");
			throw new BadCredentialsException("El usuario se encuentra bloqueado favor de reportar a su administrador");
		}else if(serviceUsuario.validarUsuarioContraseña(user)){
			LOGGER.info("[AP] - Usuario con contraseña invalida");
			throw new BadCredentialsException("La constraseña es invalida");
		}else {
			LOGGER.info("[AP] - Escenario sin considerar 1");
			throw new BadCredentialsException("Error al autenticar");
		}
	}else if(regreso == 9){
		LOGGER.info("[AP] - Error de comunicación con seguridad");
		throw new BadCredentialsException("Error de comunicación con el sistema de seguridad");
	}else{
		LOGGER.info("[AP] - Escenario sin considerar 2");
		throw new BadCredentialsException("Error al autenticar");
	}
		
		
		
//		if( auth.getPrincipal().toString().trim().equals("IN097328") && auth.getCredentials().toString().trim().equals("in097328") )
//		{
//			//System.out.println("Si paso la valicacion...");
//			Authentication _authAuthentication = new UsernamePasswordAuthenticationToken(
//								auth.getName(),
//								auth.getCredentials(),
//								AuthorityUtils.createAuthorityList("ATADMIN","AVATAB_USER"));
//			return _authAuthentication;
//			
//		}else
//		{
//			throw new BadCredentialsException("El usuario:"+auth.getPrincipal()+" no tiene acceso al aplicativo");
//		}
			
			

		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
	}

	

}
