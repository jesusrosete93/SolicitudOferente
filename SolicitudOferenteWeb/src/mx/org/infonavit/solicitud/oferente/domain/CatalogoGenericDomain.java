package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;

/**
 * <p>
 * Clase que representa un elemto que forma parte de un catalogo del sistema de electronico de avalúos.
 * </p>
 * @author Adrian Casas
 * @see GenericValueObject
 */
public class CatalogoGenericDomain extends GenericValueObject
{

	private static final long serialVersionUID = 2112594037997667349L;
	private int identificador;
	private String nombre;
	
	public CatalogoGenericDomain() {
		super();
	}

	public CatalogoGenericDomain(int identificador, String nombre) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
