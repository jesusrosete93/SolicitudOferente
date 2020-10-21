package mx.org.infonavit.solicitud.oferente.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;




/**
 * @author 	Adrian Casas
 * @version 1.0
 * 
 * <b>GenericValueObject</b>
 * Gestiona la construcción de la representación del objeto de 1 maneras:
 * 	1) Método toString() para la traza en la bitácora.
 */
public abstract class 		GenericValueObject 
				implements 	java.io.Serializable 
	{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4719496770603137879L;

	//	Métodos     - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public java.lang.String toString() 
	{
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}
		

	public boolean equals(Object object)
	{
		return false;
	}
	
	
	
	
	public int hashCode(){
		return 0;
	}
	
}