package mx.org.infonavit.solicitud.oferente.persistence.vo;

import java.sql.Timestamp;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;
/**
 * <p>Clase que encapsula la información de un registro de la tabla: inex_uv_gral</p> 
 * @author Adrian Casas
 *
 */
public class InexUvGeneralVo extends GenericValueObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1685147151572953462L;
	private int idInex;
	private Timestamp fecha;
	private int idUnidadValuacion;
	private String idEstado;
	private double variable1;
	private double variable2;
	private double variable3;
	private double variable4;
	private double variable5;
	private double desempate1;
	private double desempate2;
	private double calificacionTotal;
	private int orden;
	private int estatus;
	
	private InexUvGeneralVo(Builder builder) {
		this.idInex=builder.getIdInex();
		this.fecha=builder.getFecha();
		this.idUnidadValuacion=builder.getIdUnidadValuacion();
		this.idEstado=builder.getIdEstado();
		this.variable1=builder.getVariable1();
		this.variable2=builder.getVariable2();
		this.variable3=builder.getVariable3();
		this.variable4=builder.getVariable4();
		this.variable5=builder.getVariable5();
		this.desempate1=builder.getDesempate1();
		this.desempate2=builder.getDesempate2();
		this.calificacionTotal=builder.getCalificacionTotal();
		this.orden=builder.getOrden();
		this.estatus=builder.getEstatus();
	}
	public int getIdInex() {
		return idInex;
	}
	public void setIdInex(int idInex) {
		this.idInex = idInex;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public int getIdUnidadValuacion() {
		return idUnidadValuacion;
	}
	public void setIdUnidadValuacion(int idUnidadValuacion) {
		this.idUnidadValuacion = idUnidadValuacion;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public double getVariable1() {
		return variable1;
	}
	public void setVariable1(double variable1) {
		this.variable1 = variable1;
	}
	public double getVariable2() {
		return variable2;
	}
	public void setVariable2(double variable2) {
		this.variable2 = variable2;
	}
	public double getVariable3() {
		return variable3;
	}
	public void setVariable3(double variable3) {
		this.variable3 = variable3;
	}
	public double getVariable4() {
		return variable4;
	}
	public void setVariable4(double variable4) {
		this.variable4 = variable4;
	}
	public double getVariable5() {
		return variable5;
	}
	public void setVariable5(double variable5) {
		this.variable5 = variable5;
	}
	public double getDesempate1() {
		return desempate1;
	}
	public void setDesempate1(double desempate1) {
		this.desempate1 = desempate1;
	}
	public double getDesempate2() {
		return desempate2;
	}
	public void setDesempate2(double desempate2) {
		this.desempate2 = desempate2;
	}
	public double getCalificacionTotal() {
		return calificacionTotal;
	}
	public void setCalificacionTotal(double calificacionTotal) {
		this.calificacionTotal = calificacionTotal;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	public static class Builder
	{
		private int idInex;
		private Timestamp fecha;
		private int idUnidadValuacion;
		private String idEstado;
		private double variable1;
		private double variable2;
		private double variable3;
		private double variable4;
		private double variable5;
		private double desempate1;
		private double desempate2;
		private double calificacionTotal;
		private int orden;
		private int estatus;
		
		public Builder setIndInex(int idInex) {
			this.idInex = idInex;
			return this;
		}
		public Builder setFecha(Timestamp fecha) {
			this.fecha = fecha;
			return this;
		}
		public Builder setIdUnidadValuacion(int idUnidadValuacion) {
			this.idUnidadValuacion = idUnidadValuacion;
			return this;
		}
		public Builder setIdEstado(String idEstado) {
			this.idEstado = idEstado;
			return this;
		}
		public Builder setVariable1(double variable1) {
			this.variable1 = variable1;
			return this;
		}
		public Builder setVariable2(double variable2) {
			this.variable2 = variable2;
			return this;
		}
		public Builder setVariable3(double variable3) {
			this.variable3 = variable3;
			return this;
		}
		public Builder setVariable4(double variable4) {
			this.variable4 = variable4;
			return this;
		}
		public Builder setVariable5(double variable5) {
			this.variable5 = variable5;
			return this;
		}
		public Builder setDesempate1(double desempate1) {
			this.desempate1 = desempate1;
			return this;
		}
		public Builder setDesempate2(double desempate2) {
			this.desempate2 = desempate2;
			return this;
		}
		public Builder setCalificacionTotal(double calificacionTotal) {
			this.calificacionTotal = calificacionTotal;
			return this;
		}
		public Builder setOrden(int orden) {
			this.orden = orden;
			return this;
		}
		public Builder setEstatus(int estatus) {
			this.estatus = estatus;
			return this;
		}
		public int getIdInex() {
			return idInex;
		}
		public Timestamp getFecha() {
			return fecha;
		}
		public int getIdUnidadValuacion() {
			return idUnidadValuacion;
		}
		public String getIdEstado() {
			return idEstado;
		}
		public double getVariable1() {
			return variable1;
		}
		public double getVariable2() {
			return variable2;
		}
		public double getVariable3() {
			return variable3;
		}
		public double getVariable4() {
			return variable4;
		}
		public double getVariable5() {
			return variable5;
		}
		public double getDesempate1() {
			return desempate1;
		}
		public double getDesempate2() {
			return desempate2;
		}
		public double getCalificacionTotal() {
			return calificacionTotal;
		}
		public int getOrden() {
			return orden;
		}
		public int getEstatus() {
			return estatus;
		}
		
		public InexUvGeneralVo build()
		{
			return new InexUvGeneralVo(this);
		}
	}

}
