/*
 * 
 * Autor: Infonavit
 *
 * Derechos Reservados Infonavit 2011
 * 
 * El presente Software es información confidencial y propietaria de Infonavit
 * No se debe revelar tal información y solo debera utilizarse de acuerdo
 * con los términos del contrato celebrado entre el Desarrolador ( Avansis Desarrollos S.A de C.V ) e
 * Infonavit.
 * 
 */
/**
 * 
 * @version 1.0  18/10/2011
 * @author Avansis Desarrollos SA de CV - Adrian Casas
 */
package mx.org.infonavit.solicitud.oferente.utils;

/**
 * @author Adrian
 *
 */
public interface ValidadorBeanUtils<T> {
		
	String validar(T runtime,T saved)throws Exception;
}
