package mx.org.infonavit.solicitud.oferente.domain;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaInexForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;
import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>
 * 	Clase que encapsula los criterios de búsqueda para la consulta del Inex.
 * </p> 
 * @author Adrian Casas
 */
public class CriteriosConsultaInexDomain extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7436707230151266090L;
	private int numeroInex;
	private String fechaInex;
	private int idUnidad;
	private String idEstado;
	
	
	public int getNumeroInex() {
		return numeroInex;
	}
	public void setNumeroInex(int numeroInex) {
		this.numeroInex = numeroInex;
	}
	public String getFechaInex() {
		return fechaInex;
	}
	public void setFechaInex(String fechaInex) {
		this.fechaInex = fechaInex;
	}
	public int getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	
	public static CriteriosConsultaInexDomain getObjetoDomain(ConsultaInexForm forma)
	{
		CriteriosConsultaInexDomain domain = new CriteriosConsultaInexDomain();
		if( forma.getIdUnidadValuacion()>0 )
		{
			domain.setIdUnidad(forma.getIdUnidadValuacion());
		}
		if( forma.getFecha()!=null && !forma.getFecha().trim().equals("") )
		{
			domain.setFechaInex(Fechas.cambiarFormatoFecha(forma.getFecha(),"dd-MM-yyyy","yyyy-MM-dd"));
		}
		if( forma.getNumeroInex()>0)
		{
			domain.setNumeroInex(forma.getNumeroInex());
		}
		if( forma.getIdEstado()>0 )
		{
			if( forma.getIdEstado()>=1 && forma.getIdEstado()<=9)
			{
				domain.setIdEstado("0"+String.valueOf(forma.getIdEstado())+"000");
			}
			if( forma.getIdEstado()>=10 )
			{
				domain.setIdEstado(String.valueOf(forma.getIdEstado())+"000");
			}
		}
	 return domain; 
	}

}
