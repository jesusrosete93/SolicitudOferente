package mx.org.infonavit.solicitud.oferente.domain;


/**
 * <p>
 * Clase que encapusula los datos que identifican a un tipo de paquete de Inex.
 * </p>
 * @author Adrian Casas
 */
public class TipoPaqueteDomain extends CatalogoGenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7651339871053211606L;

	public TipoPaqueteDomain() {
		super();
	}

	public TipoPaqueteDomain(int identificador, String nombre) {
		super(identificador, nombre);
	}
}
