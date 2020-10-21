
package mx.org.infonavit.solicitud.oferente.persistence.vo;

import mx.org.infonavit.solicitud.oferente.utils.GenericValueObject;



public class ViviendaVo extends GenericValueObject {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5001722621224758020L;
	private int			id_vivienda;             
	private String		id_paquete;              
	private String		localidad;               
	private String		cp;                      
	private String		colonia;                 
	private String		supermanzana;            
	private String		manzana;                 
	private String		lote;                    
	private String		calle;                   
	private String		entre_calle_1;           
	private String		entre_calle_2;           
	private String		num_exterior;            
	private String		num_interior;            
	private String		condominio;              
	private String		entrada;                 
	private String		edificio;                
	private String		telefono;                
	private String		nivel;                   
	private String		fecha_solicitud;         
	private int			estatus_avaluo;          
	private String		fecha_dtu;               
	private String		existe_dtu;              
	private String		NSS;                     
	private String		fecha_compromiso_termino;
	private String		precio_venta;            
	private String		cuv;                     
	private String		tipo_vivienda;           
	private String		num_notario;             
	private String		nombre_notario;          
	private String		plaza;                   
	private String		num_escritura;           
	private String		libro;                   
	private String		volumen;                 
	private String		vivienda_verde_costo;    
	private String      vivienda_verde_ahorro;
	private String 		niveles_edificio;
	private String 		niveles_vivienda;
	private String		vivienda_recuperada;
	private String		cofinanciamiento;
	private String 		apoyo_infonavit;
	private String      subsidio;
	private String      idUv;  
	private String 		avaluos;

	
	/**
	 * 
	 */
	public ViviendaVo() {
		super();
	}

	
	

	public ViviendaVo(String id_paquete,int id_vivienda) {
		super();
		this.id_vivienda = id_vivienda;
		this.id_paquete = id_paquete;
	}
	
	
	public ViviendaVo(String avaluos)
	{
		this.avaluos=avaluos;
	}




	public ViviendaVo(int id_vivienda, String id_paquete, String localidad,
			String cp, String colonia, String supermanzana, String manzana,
			String lote, String calle, String entre_calle_1,
			String entre_calle_2, String num_exterior, String num_interior,
			String condominio, String entrada, String edificio,
			String telefono, String nivel, String fecha_solicitud,
			int estatus_avaluo, String fecha_dtu, String existe_dtu,
			String nss, String fecha_compromiso_termino, String precio_venta,
			String cuv, String tipo_vivienda, String num_notario,
			String nombre_notario, String plaza, String num_escritura,
			String libro, String volumen, String vivienda_verde_costo,
			String vivienda_verde_ahorro, String niveles_edificio,
			String niveles_vivienda, String vivienda_recuperada,
			String cofinanciamiento, String apoyo_infonavit) {
		super();
		this.id_vivienda = id_vivienda;
		this.id_paquete = id_paquete;
		this.localidad = localidad;
		this.cp = cp;
		this.colonia = colonia;
		this.supermanzana = supermanzana;
		this.manzana = manzana;
		this.lote = lote;
		this.calle = calle;
		this.entre_calle_1 = entre_calle_1;
		this.entre_calle_2 = entre_calle_2;
		this.num_exterior = num_exterior;
		this.num_interior = num_interior;
		this.condominio = condominio;
		this.entrada = entrada;
		this.edificio = edificio;
		this.telefono = telefono;
		this.nivel = nivel;
		this.fecha_solicitud = fecha_solicitud;
		this.estatus_avaluo = estatus_avaluo;
		this.fecha_dtu = fecha_dtu;
		this.existe_dtu = existe_dtu;
		this.NSS = nss;
		this.fecha_compromiso_termino = fecha_compromiso_termino;
		this.precio_venta = precio_venta;
		this.cuv = cuv;
		this.tipo_vivienda = tipo_vivienda;
		this.num_notario = num_notario;
		this.nombre_notario = nombre_notario;
		this.plaza = plaza;
		this.num_escritura = num_escritura;
		this.libro = libro;
		this.volumen = volumen;
		this.vivienda_verde_costo = vivienda_verde_costo;
		this.vivienda_verde_ahorro = vivienda_verde_ahorro;
		this.niveles_edificio = niveles_edificio;
		this.niveles_vivienda = niveles_vivienda;
		this.vivienda_recuperada = vivienda_recuperada;
		this.cofinanciamiento = cofinanciamiento;
		this.apoyo_infonavit = apoyo_infonavit;
	}



	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getCondominio() {
		return condominio;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getCuv() {
		return cuv;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getEdificio() {
		return edificio;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getEntrada() {
		return entrada;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getEntre_calle_1() {
		return entre_calle_1;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getEntre_calle_2() {
		return entre_calle_2;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public int getEstatus_avaluo() {
		return estatus_avaluo;
	}



	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getFecha_compromiso_termino() {
		return fecha_compromiso_termino;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getFecha_dtu() {
		return fecha_dtu;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getFecha_solicitud() {
		return fecha_solicitud;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getId_paquete() {
		return id_paquete;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public int getId_vivienda() {
		return id_vivienda;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getLibro() {
		return libro;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getManzana() {
		return manzana;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNombre_notario() {
		return nombre_notario;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNSS() {
		return NSS;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNum_escritura() {
		return num_escritura;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNum_exterior() {
		return num_exterior;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNum_interior() {
		return num_interior;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getNum_notario() {
		return num_notario;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getPlaza() {
		return plaza;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getPrecio_venta() {
		return precio_venta;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getSupermanzana() {
		return supermanzana;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getTipo_vivienda() {
		return tipo_vivienda;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getVivienda_verde_ahorro() {
		return vivienda_verde_ahorro;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getVivienda_verde_costo() {
		return vivienda_verde_costo;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getVolumen() {
		return volumen;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setCalle(String string) {
		calle = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setColonia(String string) {
		colonia = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setCondominio(String string) {
		condominio = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setCp(String string) {
		cp = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setCuv(String string) {
		cuv = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setEdificio(String string) {
		edificio = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setEntrada(String string) {
		entrada = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setEntre_calle_1(String string) {
		entre_calle_1 = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setEntre_calle_2(String string) {
		entre_calle_2 = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param i
	 */
	public void setEstatus_avaluo(int i) {
		estatus_avaluo = i;
	}



	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setFecha_compromiso_termino(String string) {
		fecha_compromiso_termino = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setFecha_dtu(String string) {
		fecha_dtu = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setFecha_solicitud(String string) {
		fecha_solicitud = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setId_paquete(String string) {
		id_paquete = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param i
	 */
	public void setId_vivienda(int i) {
		id_vivienda = i;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setLibro(String string) {
		libro = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setLocalidad(String string) {
		localidad = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setLote(String string) {
		lote = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setManzana(String string) {
		manzana = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNivel(String string) {
		nivel = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNombre_notario(String string) {
		nombre_notario = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNSS(String string) {
		NSS = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNum_escritura(String string) {
		num_escritura = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNum_exterior(String string) {
		num_exterior = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNum_interior(String string) {
		num_interior = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setNum_notario(String string) {
		num_notario = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setPlaza(String string) {
		plaza = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setPrecio_venta(String string) {
		precio_venta = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setSupermanzana(String string) {
		supermanzana = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setTelefono(String string) {
		telefono = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setTipo_vivienda(String string) {
		tipo_vivienda = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setVivienda_verde_ahorro(String string) {
		vivienda_verde_ahorro = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setVivienda_verde_costo(String string) {
		vivienda_verde_costo = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	19-may-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setVolumen(String string) {
		volumen = string;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	09-jun-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @return
	 */
	public String getExiste_dtu() {
		return existe_dtu;
	}

	/**
	 * Autor 	: 	Ing. Pablo Garcia
	 * <br>Empresa	:	Avansis Desarrollos S.A de C.V 
	 * <br>Creacion :  	09-jun-08 
	 * <br>
	 * <br>Descripcion : 
	 * <br>
	 * @param string
	 */
	public void setExiste_dtu(String string) {
		existe_dtu = string;
	}

	/*
	 * Autor 	: 	Ing. Gerardo Salinas <BR>
	 * Empresa	:	Avansis Desarrollos S.A de C.V <BR>
	 * Creacion :  	13-junio-08 <BR>
	 * 
	 * Método de negocio para ...
	 * @return ...
	*/
	public String getSubsidio() {
		return subsidio;
	}

	/*
	 * Autor 	: 	Ing. Gerardo Salinas <BR>
	 * Empresa	:	Avansis Desarrollos S.A de C.V <BR>
	 * Creacion :  	13-junio-08 <BR>
	 * 
	 * Método de negocio para ...
	 * @return ...
	*/
	public void setSubsidio(String string) {
		subsidio = string;
	}

	/**
	 * @return
	 */
	public String getIdUv() {
		return idUv;
	}

	/**
	 * @param string
	 */
	public void setIdUv(String string) {
		idUv = string;
	}

	/**
	 * @return the niveles_edificio
	 */
	public String getNiveles_edificio() {
		return niveles_edificio;
	}

	/**
	 * @param niveles_edificio the niveles_edificio to set
	 */
	public void setNiveles_edificio(String niveles_edificio) {
		this.niveles_edificio = niveles_edificio;
	}

	/**
	 * @return the niveles_vivienda
	 */
	public String getNiveles_vivienda() {
		return niveles_vivienda;
	}

	/**
	 * @param niveles_vivienda the niveles_vivienda to set
	 */
	public void setNiveles_vivienda(String niveles_vivienda) {
		this.niveles_vivienda = niveles_vivienda;
	}

	/**
	 * @return the vivienda_recuperada
	 */
	public String getVivienda_recuperada() {
		return vivienda_recuperada;
	}

	/**
	 * @param vivienda_recuperada the vivienda_recuperada to set
	 */
	public void setVivienda_recuperada(String vivienda_recuperada) {
		this.vivienda_recuperada = vivienda_recuperada;
	}

	/**
	 * @return the cofinanciamiento
	 */
	public String getCofinanciamiento() {
		return cofinanciamiento;
	}

	/**
	 * @param cofinanciamiento the cofinanciamiento to set
	 */
	public void setCofinanciamiento(String cofinanciamiento) {
		this.cofinanciamiento = cofinanciamiento;
	}

	/**
	 * @return the apoyo_infonavit
	 */
	public String getApoyo_infonavit() {
		return apoyo_infonavit;
	}

	/**
	 * @param apoyo_infonavit the apoyo_infonavit to set
	 */
	public void setApoyo_infonavit(String apoyo_infonavit) {
		this.apoyo_infonavit = apoyo_infonavit;
	}




	/**
	 * @return the avaluos
	 */
	public String getAvaluos() {
		return avaluos;
	}




	/**
	 * @param avaluos the avaluos to set
	 */
	public void setAvaluos(String avaluos) {
		this.avaluos = avaluos;
	}

}
