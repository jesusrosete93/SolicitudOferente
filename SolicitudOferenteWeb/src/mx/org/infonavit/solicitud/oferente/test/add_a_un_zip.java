package mx.org.infonavit.solicitud.oferente.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import mx.org.infonavit.solicitud.oferente.vo.Detalle_Avaluo;
import mx.org.infonavit.solicitud.oferente.vo.Detalle_equipamiento_urbano;
import mx.org.infonavit.solicitud.oferente.vo.Dtc;
import mx.org.infonavit.solicitud.oferente.vo.Elementos_adicionales;
import mx.org.infonavit.solicitud.oferente.vo.PaquetePrincipal;
import mx.org.infonavit.solicitud.oferente.vo.ViviendaVO;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class add_a_un_zip {

	  public  void add_a_un_zipa (List<Detalle_equipamiento_urbano> detalle_equipamiento_urbano, String string, 
			  					List<Elementos_adicionales> elementos_adicionales, String string2, 
			  					List<Detalle_Avaluo> detalle_avaluo, String string3, 
			  					List<ViviendaVO> vivienda, String string4, 
			  					List<PaquetePrincipal> paqueteVO, String string5) {
		  System.out.println("entro en el primer zip");
		  try {
			  System.out.println("crea archivo");
		   ZipFile zipFile = new ZipFile("C:/adjuntos/Isai1.zip");
		   
		   System.out.println("empieza a escribir");
		   ArrayList filesToAdd = new ArrayList();
		   System.out.println("agrega detalle_equipamiento_urbano : "+string );
		   System.out.println("agrega detalle_equipamiento_urbano : "+detalle_equipamiento_urbano.size() );
		   filesToAdd.add(escribir(string,detalle_equipamiento_urbano));
		   System.out.println("elementos adicionales");
		   filesToAdd.add(escribir2(string2,elementos_adicionales));
		   System.out.println("detalle avaluo");
		   filesToAdd.add(escribir3(string3,detalle_avaluo));
		   System.out.println("vivienda");
		   filesToAdd.add(escribir4(string4,vivienda));
		   System.out.println("paquete");
		   filesToAdd.add(escribir5(string5,paqueteVO));
		   
		   System.out.println("comprimiendo");
		   ZipParameters parameters = new ZipParameters();
		   parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
		   

		   parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
		   
		   System.out.println("agrega");
		   zipFile.addFiles(filesToAdd, parameters);
		                               
		  } catch (ZipException e) {
		   e.printStackTrace();
		  }  
		 }
	  
	  
	  private Object escribir5(String string5, List<PaquetePrincipal> paqueteVO) {
		  File f = new File(string5+".txt");
			//Escritura
			try{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  
			wr.print("id_paquete|id_uv|num_viviendas|nombre_frente|fecha_aprobacion_oferta|fecha_estimada_entrega|fecha_asignacion|id_regimen|rfc|id_estado|id_municipio|id_tipo_mercado|tipo_linea");
			wr.print("\n");
			if(paqueteVO.size()> 0){
				System.out.println("entro en el if");
				for (int a=0; a<paqueteVO.size(); a++){
					wr.print(paqueteVO.get(a).getId_paquete()+"|");
					wr.print(paqueteVO.get(a).getId_uv()+"|");
					wr.print(paqueteVO.get(a).getNum_viviendas()+"|");
					wr.print(paqueteVO.get(a).getNombre_frente()+"|");
					wr.print(paqueteVO.get(a).getFecha_aprobacion_oferta()+"|");
					wr.print(paqueteVO.get(a).getFecha_estimada_entrega()+"|");
					wr.print(paqueteVO.get(a).getFecha_asignacion()+"|");
					wr.print(paqueteVO.get(a).getId_regimen()+"|");
					wr.print(paqueteVO.get(a).getRfc()+"|");
					wr.print(paqueteVO.get(a).getId_estado()+"|");
					wr.print(paqueteVO.get(a).getId_municipio()+"|");
					wr.print(paqueteVO.get(a).getId_tipo_mercado()+"|");
					wr.print(paqueteVO.get(a).getTipo_linea()+"|");
					wr.print("\n"); 
				}
				System.out.println("temino");
			}
			wr.close();
			bw.close();
			}catch(IOException e){};
			return f;
	}


	private Object escribir4(String string4, List<ViviendaVO> vivienda) {
		  File f = new File(string4+".txt");
			//Escritura
			try{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  
			wr.print("id_avaluo|id_paquete|id_vivienda|id_tipo_mercado|tipo_linea|localidad|cp|colonia|supermanzana|manzana|lote|calle|entre_calle_1|entre_calle_2|num_exterior|num_interior|condominio|entrada|edificio|telefono|nivel|fecha_solicitud|estatus_avaluo|fecha_dtu|existe_dtu|NSS|fecha_compromiso_termino|precio_venta|cuv|tipo_vivienda|num_notario|nombre_notario|plaza|num_escritura|libro|volumen|vivienda_verde_costo|vivienda_verde_ahorro|niveles_edificio|niveles_vivienda");
			wr.print("\n");
			if(vivienda.size()> 0){
				System.out.println("entro en el if");
				for (int a=0; a<vivienda.size(); a++){
					wr.print(vivienda.get(a).getId_avaluo()+"|");
					wr.print(vivienda.get(a).getId_paquete()+"|");
					wr.print(vivienda.get(a).getId_vivienda()+"|");
					wr.print(vivienda.get(a).getId_tipo_mercado()+"|");
					wr.print(vivienda.get(a).getTipo_linea()+"|");
					wr.print(vivienda.get(a).getLocalidad()+"|");
					wr.print(vivienda.get(a).getCp()+"|");
					wr.print(vivienda.get(a).getColonia()+"|");
					wr.print(vivienda.get(a).getSupermanzana()+"|");
					wr.print(vivienda.get(a).getManzana()+"|");
					wr.print(vivienda.get(a).getLote()+"|");
					wr.print(vivienda.get(a).getCalle()+"|");
					wr.print(vivienda.get(a).getEntre_calle_1()+"|");
					wr.print(vivienda.get(a).getEntre_calle_2()+"|");
					wr.print(vivienda.get(a).getNum_exterior()+"|");
					wr.print(vivienda.get(a).getNum_interior()+"|");
					wr.print(vivienda.get(a).getCondominio()+"|");
					wr.print(vivienda.get(a).getEntrada()+"|");
					wr.print(vivienda.get(a).getEdificio()+"|");
					wr.print(vivienda.get(a).getTelefono()+"|");
					wr.print(vivienda.get(a).getNivel()+"|");
					wr.print(vivienda.get(a).getFecha_solicitud()+"|");
					wr.print(vivienda.get(a).getEstatus_avaluo()+"|");
					wr.print(vivienda.get(a).getFecha_dtu()+"|");
					wr.print(vivienda.get(a).getExiste_dtu()+"|");
					wr.print(vivienda.get(a).getNSS()+"|");
					wr.print(vivienda.get(a).getFecha_compromiso_termino()+"|");
					wr.print(vivienda.get(a).getPrecio_venta()+"|");
					wr.print(vivienda.get(a).getCuv()+"|");
					wr.print(vivienda.get(a).getTipo_vivienda()+"|");
					wr.print(vivienda.get(a).getNum_notario()+"|");
					wr.print(vivienda.get(a).getNombre_notario()+"|");
					wr.print(vivienda.get(a).getPlaza()+"|");
					wr.print(vivienda.get(a).getNum_escritura()+"|");
					wr.print(vivienda.get(a).getLibro()+"|");
					wr.print(vivienda.get(a).getVolumen()+"|");
					wr.print(vivienda.get(a).getVivienda_verde_costo()+"|");
					wr.print(vivienda.get(a).getVivienda_verde_ahorro()+"|");
					wr.print(vivienda.get(a).getNiveles_edificio()+"|");
					wr.print(vivienda.get(a).getNiveles_vivienda()+"|");
					wr.print("\n"); 
				}
				System.out.println("temino");
			}
			wr.close();
			bw.close();
			}catch(IOException e){};
			return f;
	}


	private Object escribir3(String string3, List<Detalle_Avaluo> detalle_avaluo) {
		  File f = new File(string3+".txt");
			//Escritura
			try{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);  
			wr.print("id_avaluo|id_paquete|id_vivienda|id_tipo_mercado|tipo_linea|clave_shf|clave_uv|fecha_avaluo|clave_unica_vivienda|clasificacion_zona|niveles_zona|construcciones_valor|id_rec_aguas_residuales|drenaje_pluvial_calle|drenaje_pluvial_zona|sist_mixto_drenaje|fosa_septica|elect_acometica_inmueble|id_material_vialidades|vialidades_valor|id_alumbrado_publico|id_material_banquetas|banqueta_valor|id_material_guarniciones|guarniciones_valor|nivel_infraestructura|id_gas_natural|id_sumin_telefonico|acometida_telefonico|nomenclatura_calles|trans_urbano_dist|trans_urbano_frec|trans_suburbano_dist|trans_suburbano_frec|rec_municipal_desechos|id_tipo_inmueble_valuado|tipo_inm_valuado_valor|domicilio_localidad_inmueble|codigo_postal_inmueble|colonia_inmueble|calle_inmueble|num_exterior_inmueble|num_interior_inmueble|id_conf_inmueble|id_topografia_inmueble|uso_suelo|cus|densidad_habitacional|uso_actual|num_recamaras|num_banios|num_estacionamiento|id_calidad_proyecto|id_clase_gral_inmueble|id_estado_conservacion|edad_contruccion|vida_util_remanente|niveles_construccion|grado_terminacion_obra|grado_avance_areas_comunes|superficie_terreno_vivienda|superficie_construida|superficie_accesorias|superficie_vendible|indivisos_construccion|indivisos_terreno|id_inst_hidraulicas|mat_inst_hidraulicas|id_inst_sanitarias|mat_inst_sanitarias|id_inst_electricas|id_elementos_adicionales|elementos_adicionales_valor|valor_comparativo_total|valor_comparativo_m2|valor_terreno_total|valor_terreno_m2|valor_construccion_total|valor_construccion_m2|valor_residual|valor_concluido|id_ubica_inmueble_terreno|superficie_terreno_conjunto|id_vigilancia|senalizacion_vial|id_suministro_electricidad|id_agua_potable|indice_saturacion_zona|id_uso_construcciones|id_ref_proximidad_urbana|id_clase_zona|id_perito_shf|id_densidad_poblacion|id_controlador_shf|longitud|latitud|altitud|otro_tipo_sistema|id_existencia_trans_urbano|id_existencia_tran_suburbano|rec_municipal_desechos_frec|id_nivel_infraurbana|id_existencia_iglesia|id_existencia_mercados|id_existencia_plaza_publica|id_existencia_parques_jardines|id_existencia_escuelas|id_existencia_hospitales|id_existencia_bancos|id_existencia_acceso_estacion_urbano|id_existenciaaccesoestacionsuburbano|id_existenciacentrocomunitario|idnivelequipamientourbano|reportedensidad|id_existe_espacio_uso_multiple|num_medios_banios|resultado_calidad_proyecto|comentarios_estado_conservacion|mat_inst_electricas|valor_hipotetico|densidadhabitacionalhabitantes|densidadhabitacionalviviendas|id_supermercados|id_locales_comerciales|num_locales_comerciales|id_existencia_parques|id_existencia_jardines|id_canchas_deportivas|id_centro_deportivo|id_escuelas_primarias|id_escuelas_secundarias|id_escuelas_preparatoria|id_universidad|id_otras_escuelas|id_servicios_salud_primer_nivel|id_servicios_salud_segundo_nivel|id_servicios_salud_tercer_nivel|id_terreno_colinda|id_terreno_ubicado|id_riesgo_social|id_riesgo_comercial");
			wr.print("\n");
			if(detalle_avaluo.size()> 0){
				System.out.println("entro en el if");
				for (int a=0; a<detalle_avaluo.size(); a++){
					wr.print(detalle_avaluo.get(a).getId_avaluo()+"|");
					wr.print(detalle_avaluo.get(a).getId_paquete()+"|");
					wr.print(detalle_avaluo.get(a).getId_vivienda()+"|");
					wr.print(detalle_avaluo.get(a).getId_tipo_mercado()+"|");
					wr.print(detalle_avaluo.get(a).getTipo_linea	()+"|");
					wr.print(detalle_avaluo.get(a).getClave_shf	()+"|");
					wr.print(detalle_avaluo.get(a).getClave_uv()+"|");
					wr.print(detalle_avaluo.get(a).getFecha_avaluo()+"|");
					wr.print(detalle_avaluo.get(a).getClave_unica_vivienda()+"|");
					wr.print(detalle_avaluo.get(a).getClasificacion_zona()+"|");
					wr.print(detalle_avaluo.get(a).getNiveles_zona	()+"|");
					wr.print(detalle_avaluo.get(a).getConstrucciones_valor()+"|");
					wr.print(detalle_avaluo.get(a).getId_rec_aguas_residuales	()+"|");
					wr.print(detalle_avaluo.get(a).getDrenaje_pluvial_calle()+"|");
					wr.print(detalle_avaluo.get(a).getDrenaje_pluvial_zona()+"|");
					wr.print(detalle_avaluo.get(a).getSist_mixto_drenaje()+"|");
					wr.print(detalle_avaluo.get(a).getFosa_septica()+"|");
					wr.print(detalle_avaluo.get(a).getElect_acometica_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getId_material_vialidades()+"|");
					wr.print(detalle_avaluo.get(a).getVialidades_valor()+"|");
					wr.print(detalle_avaluo.get(a).getId_alumbrado_publico()+"|");
					wr.print(detalle_avaluo.get(a).getId_material_banquetas()+"|");
					wr.print(detalle_avaluo.get(a).getBanqueta_valor()+"|");
					wr.print(detalle_avaluo.get(a).getId_material_guarniciones()+"|");
					wr.print(detalle_avaluo.get(a).getGuarniciones_valor()+"|");
					wr.print(detalle_avaluo.get(a).getNivel_infraestructura()+"|");
					wr.print(detalle_avaluo.get(a).getId_gas_natural()+"|");
					wr.print(detalle_avaluo.get(a).getId_sumin_telefonico()+"|");
					wr.print(detalle_avaluo.get(a).getAcometida_telefonico()+"|");
					wr.print(detalle_avaluo.get(a).getNomenclatura_calles()+"|");
					wr.print(detalle_avaluo.get(a).getTrans_urbano_dist()+"|");
					wr.print(detalle_avaluo.get(a).getTrans_urbano_frec()+"|");
					wr.print(detalle_avaluo.get(a).getTrans_suburbano_dist()+"|");
					wr.print(detalle_avaluo.get(a).getTrans_suburbano_frec()+"|");
					wr.print(detalle_avaluo.get(a).getRec_municipal_desechos()+"|");
					wr.print(detalle_avaluo.get(a).getId_tipo_inmueble_valuado()+"|");
					wr.print(detalle_avaluo.get(a).getTipo_inm_valuado_valor()+"|");
					wr.print(detalle_avaluo.get(a).getDomicilio_localidad_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getCodigo_postal_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getColonia_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getCalle_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getNum_exterior_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getNum_interior_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getId_conf_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getId_topografia_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getUso_suelo()+"|");
					wr.print(detalle_avaluo.get(a).getCus()+"|");
					wr.print(detalle_avaluo.get(a).getDensidad_habitacional()+"|");
					wr.print(detalle_avaluo.get(a).getUso_actual()+"|");
					wr.print(detalle_avaluo.get(a).getNum_recamaras()+"|");
					wr.print(detalle_avaluo.get(a).getNum_banios()+"|");
					wr.print(detalle_avaluo.get(a).getNum_estacionamiento()+"|");
					wr.print(detalle_avaluo.get(a).getId_calidad_proyecto()+"|");
					wr.print(detalle_avaluo.get(a).getId_clase_gral_inmueble()+"|");
					wr.print(detalle_avaluo.get(a).getId_estado_conservacion()+"|");
					wr.print(detalle_avaluo.get(a).getEdad_contruccion()+"|");
					wr.print(detalle_avaluo.get(a).getVida_util_remanente()+"|");
					wr.print(detalle_avaluo.get(a).getNiveles_construccion()+"|");
					wr.print(detalle_avaluo.get(a).getGrado_terminacion_obra()+"|");
					wr.print(detalle_avaluo.get(a).getGrado_avance_areas_comunes()+"|");
					wr.print(detalle_avaluo.get(a).getSuperficie_terreno_vivienda()+"|");
					wr.print(detalle_avaluo.get(a).getSuperficie_construida()+"|");
					wr.print(detalle_avaluo.get(a).getSuperficie_accesorias()+"|");
					wr.print(detalle_avaluo.get(a).getSuperficie_vendible	()+"|");
					wr.print(detalle_avaluo.get(a).getIndivisos_construccion()+"|");
					wr.print(detalle_avaluo.get(a).getIndivisos_terreno()+"|");
					wr.print(detalle_avaluo.get(a).getId_inst_hidraulicas()+"|");
					wr.print(detalle_avaluo.get(a).getMat_inst_hidraulicas()+"|");
					wr.print(detalle_avaluo.get(a).getId_inst_sanitarias()+"|");
					wr.print(detalle_avaluo.get(a).getMat_inst_sanitarias	()+"|");
					wr.print(detalle_avaluo.get(a).getId_inst_electricas()+"|");
					wr.print(detalle_avaluo.get(a).getId_elementos_adicionales()+"|");
					wr.print(detalle_avaluo.get(a).getElementos_adicionales_valor()+"|");
					wr.print(detalle_avaluo.get(a).getValor_comparativo_total()+"|");
					wr.print(detalle_avaluo.get(a).getValor_comparativo_m2()+"|");
					wr.print(detalle_avaluo.get(a).getValor_terreno_total()+"|");
					wr.print(detalle_avaluo.get(a).getValor_terreno_m2()+"|");
					wr.print(detalle_avaluo.get(a).getValor_construccion_total()+"|");
					wr.print(detalle_avaluo.get(a).getValor_construccion_m2()+"|");
					wr.print(detalle_avaluo.get(a).getValor_residual()+"|");
					wr.print(detalle_avaluo.get(a).getValor_concluido()+"|");
					wr.print(detalle_avaluo.get(a).getId_ubica_inmueble_terreno	()+"|");
					wr.print(detalle_avaluo.get(a).getSuperficie_terreno_conjunto()+"|");
					wr.print(detalle_avaluo.get(a).getId_vigilancia()+"|");
					wr.print(detalle_avaluo.get(a).getSenalizacion_vial	()+"|");
					wr.print(detalle_avaluo.get(a).getId_suministro_electricidad	()+"|");
					wr.print(detalle_avaluo.get(a).getId_agua_potable()+"|");
					wr.print(detalle_avaluo.get(a).getIndice_saturacion_zona()+"|");
					wr.print(detalle_avaluo.get(a).getId_uso_construcciones()+"|");
					wr.print(detalle_avaluo.get(a).getId_ref_proximidad_urbana	()+"|");
					wr.print(detalle_avaluo.get(a).getId_clase_zona()+"|");
					wr.print(detalle_avaluo.get(a).getId_perito_shf	()+"|");
					wr.print(detalle_avaluo.get(a).getId_densidad_poblacion	()+"|");
					wr.print(detalle_avaluo.get(a).getId_controlador_shf()+"|");
					wr.print(detalle_avaluo.get(a).getLongitud	()+"|");
					wr.print(detalle_avaluo.get(a).getLatitud()+"|");
					wr.print(detalle_avaluo.get(a).getAltitud()+"|");
					wr.print(detalle_avaluo.get(a).getOtro_tipo_sistema	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_trans_urbano	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_tran_suburbano	()+"|");
					wr.print(detalle_avaluo.get(a).getRec_municipal_desechos_frec	()+"|");
					wr.print(detalle_avaluo.get(a).getId_nivel_infraurbana	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_iglesia	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_mercados	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_plaza_publica	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_parques_jardines	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_escuelas	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_hospitales	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_bancos	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_acceso_estacion_urbano	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existenciaaccesoestacionsuburbano	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existenciacentrocomunitario	()+"|");
					wr.print(detalle_avaluo.get(a).getIdnivelequipamientourbano	()+"|");
					wr.print(detalle_avaluo.get(a).getReportedensidad	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existe_espacio_uso_multiple	()+"|");
					wr.print(detalle_avaluo.get(a).getNum_medios_banios	()+"|");
					wr.print(detalle_avaluo.get(a).getResultado_calidad_proyecto	()+"|");
					wr.print(detalle_avaluo.get(a).getComentarios_estado_conservacion()+"|");
					wr.print(detalle_avaluo.get(a).getMat_inst_electricas	()+"|");
					wr.print(detalle_avaluo.get(a).getValor_hipotetico	()+"|");
					wr.print(detalle_avaluo.get(a).getDensidadhabitacionalhabitantes	()+"|");
					wr.print(detalle_avaluo.get(a).getDensidadhabitacionalviviendas	()+"|");
					wr.print(detalle_avaluo.get(a).getId_supermercados	()+"|");
					wr.print(detalle_avaluo.get(a).getId_locales_comerciales	()+"|");
					wr.print(detalle_avaluo.get(a).getNum_locales_comerciales	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_parques	()+"|");
					wr.print(detalle_avaluo.get(a).getId_existencia_jardines	()+"|");
					wr.print(detalle_avaluo.get(a).getId_canchas_deportivas	()+"|");
					wr.print(detalle_avaluo.get(a).getId_centro_deportivo	()+"|");
					wr.print(detalle_avaluo.get(a).getId_escuelas_primarias	()+"|");
					wr.print(detalle_avaluo.get(a).getId_escuelas_secundarias	()+"|");
					wr.print(detalle_avaluo.get(a).getId_escuelas_preparatoria	()+"|");
					wr.print(detalle_avaluo.get(a).getId_universidad()+"|");
					wr.print(detalle_avaluo.get(a).getId_otras_escuelas	()+"|");
					wr.print(detalle_avaluo.get(a).getId_servicios_salud_primer_nivel	()+"|");
					wr.print(detalle_avaluo.get(a).getId_servicios_salud_segundo_nivel	()+"|");
					wr.print(detalle_avaluo.get(a).getId_servicios_salud_tercer_nivel	()+"|");
					wr.print(detalle_avaluo.get(a).getId_terreno_colinda	()+"|");
					wr.print(detalle_avaluo.get(a).getId_terreno_ubicado	()+"|");
					wr.print(detalle_avaluo.get(a).getId_riesgo_social	()+"|");
					wr.print(detalle_avaluo.get(a).getId_riesgo_comercial()+"|");
					wr.print("\n"); 
				}
				System.out.println("temino");
			}
			wr.close();
			bw.close();
			}catch(IOException e){};
			return f;
	}


	public File escribir(String nombreArchivo, List<Detalle_equipamiento_urbano> detalle_equipamiento_urbano)
	    {
	File f = new File(nombreArchivo+".txt");
	//Escritura
	try{
		System.out.println("tamaño de lista: "+detalle_equipamiento_urbano.size());
	FileWriter w = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(w);
	PrintWriter wr = new PrintWriter(bw);  
	wr.write("id_equipamiento_urbano|id_avaluo|id_vivienda|id_paquete|distancia|id_tipo_mercado|tipo_linea");
	wr.write("\n");
	
	if(detalle_equipamiento_urbano.size()> 0){
		System.out.println("entro en el if");
		for (int a=0; a<detalle_equipamiento_urbano.size(); a++){
			wr.write(detalle_equipamiento_urbano.get(a).getId_equipamiento_urbano()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getId_avaluo()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getId_vivienda()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getId_paquete()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getDistancia()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getId_tipo_mercado()+"|");
			wr.write(detalle_equipamiento_urbano.get(a).getTipo_linea()+"|");
			wr.write("\n"); 
		}
		System.out.println("temino");
	}
	wr.close();
	bw.close();
	}catch(IOException e){};
	return f;
	 }
	  
	  
	  public File escribir2(String nombreArchivo, List<Elementos_adicionales> elementos_adicionales)
	    {
	File f = new File(nombreArchivo+".txt");
	//Escritura
	try{
	FileWriter w = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(w);
	PrintWriter wr = new PrintWriter(bw);  
	
	wr.print("id_avaluo|id_paquete|id_vivienda|id_tipo_mercado|tipo_linea|id_sist_desc_agua_residuales|id_tratamiento_agua|id_sist_reuso_agua_restratada|id_trat_reut_aguas_jabonosas|id_sist_reuso_agua_jabonosa|id_captacion_agua_pluvial|id_separacion_basura|id_cont_elab_composta|id_foto_alumbrado_publico|id_red_agua_purificada|id_sen_braile_numonom_edificio|id_senbraile_calle_inter|id_num_piso_inc_fin_barandal|id_num_depto_por_piso|id_boton_eleva_braile|otro_tipo_insta_conjunto|id_wc_economiza_agua_seis|id_wc_economiza_agua_cinco|id_wc_economiza_agua_cuatro|id_econo_agua_doble_boton|id_regadera_ahorra_agua|id_sen_braile_agua_fria_cal_regadera|id_regadera_ahorra_agua_banio|id_sen_braile_agua_fria_cal_banio|id_regadera_ahorra_agua_cocina|id_sen_braile_agua_fria_cal_cocina|id_calentador_gas|id_calentador_paso|id_sen_braile_enciende_apaga_boiler|id_calentador_solar|id_aire_acondicionado|id_braile_aire_acondicionado|id_ubica_aire_acondicionado|id_aislan_termico_techo_nommx|id_aislante_rmicomurofide|id_aislan_termico_puerta_ventana|id_sist_encendido_luces|id_captacion_energia|id_voz_datos_internet|id_sumin_agua_purificada|id_interfon|id_circuitos_electricidad|id_protec_solar_ventana|instalacion_especial_vivienda_otro|id_caseta_vigilancia|id_locales_comerciales|id_barda_perimetral|id_elevador|id_estacionamiento_techado|id_estacionamiento_visitas|id_estacionamiento_discapacitados|id_rampa_banqueta_discapacitados|id_juegos_infantiles|id_canchas_deportivas|otro_tipo_obras_complementarias|id_estacionamiento_techado_vivienda|id_rampa_acceso_interior_vivienda|id_textura_especial_piso|id_accesoria|id_cisterna|id_ducto_clima|id_jaula_tendido|id_rejas_proteccion_ventanas|id_banio_discapacitados|id_banio_discapacitados_plantabaja|id_banio_discapacitados_regadera_sardinel|id_banio_discapacitados_piso_antiderrapante|id_banio_discapacitados_charola_regadera|id_banio_discapacitados_pendiente_rejilla_captacion|id_banio_discapacitados_salida_regadera_telefono|id_banio_discapacitados_adecuar_lavabo|id_banio_discapacitados_maneral_palanca|id_cocina_discapacitados_adecuar_tarja|id_marco_movible_discapacitados|id_banio_discapacitados_colocacion_espejo|id_banio_discapacitados_pasamanos|id_banio_discapacitados_areas_circulacion|id_pasillos|id_cocina|id_banio|id_recamara|id_accesos_vivienda_puerta|id_accesos_espacios_interiores|otro_tipo_obras_complementarias_vivienda|id_drenaje_pretratado_aguas_negras|id_captacion_solar_calentamiento_agua|id_reductor_sedimentos_calcificados_conjunto|id_camaras_seguridad|id_doble_descarga_inodoro_normal|id_llaves_ahorro_agua_lavabos_banio|id_reduccion_flujo_llaves_lavabo|id_regadera_ahorrador_integrado|id_reduccion_flujo_llave_cocina|id_valvula_regula_flujo_suministro|id_captacion_agua_pluvial_vivienda|id_calentador_solar_tubos_evacuados|id_calentador_solar_tubos_respaldo_gas|id_calentador_solar_plano_respaldo_gas_paso|id_calentador_solar_tubos_respaldo_electrico|id_calentador_solar_plano_respaldo_electrico|id_ventilador_solar_corriente_directa|id_ventilador_solar_corriente_alterna|id_ventilador_cuerda_alta_potencia|id_ventilador_cuerda_baja_potencia|id_focos_ahorradores|id_focos_led_luz_dirigida|id_focos_led_luz_difusa|id_iluminacion_natural|id_estabilizador_estatico|id_dispositivo_ahorrador_gas|id_mantenimiento_contratado_desarrollador|id_filtros_purificadores_agua|id_desinfeccion_agua_tinaco|id_reductor_sedimentos_calcificados_vivienda|id_pintura_reflejante_techo|id_pintura_reflejante_muro|id_aislante_tuberia|id_tuberia_termica|id_pintura_fotocatalitica|id_doble_vidrio_ventanas|id_vidrios_pelicula_reflectiva|id_vidrios_dobles_marco_pvc|id_vidrios_pelicula_reflectiva_marcos_pvc|id_hidromaceteros|num_hidromaceteros|id_optimizador_tension_electrica");
	wr.print("\n");
	
	if(elementos_adicionales.size()> 0){
		System.out.println("entro en el if");
		for (int a=0; a<elementos_adicionales.size(); a++){
			wr.print(elementos_adicionales.get(a).getId_avaluo()+"|");
			wr.print(elementos_adicionales.get(a).getId_paquete()+"|");
			wr.print(elementos_adicionales.get(a).getId_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_tipo_mercado()+"|");
			wr.print(elementos_adicionales.get(a).getTipo_linea()+"|");
			wr.print(elementos_adicionales.get(a).getId_sist_desc_agua_residuales()+"|");
			wr.print(elementos_adicionales.get(a).getId_tratamiento_agua()+"|");
			wr.print(elementos_adicionales.get(a).getId_sist_reuso_agua_restratada()+"|");
			wr.print(elementos_adicionales.get(a).getId_trat_reut_aguas_jabonosas()+"|");
			wr.print(elementos_adicionales.get(a).getId_sist_reuso_agua_jabonosa()+"|");
			wr.print(elementos_adicionales.get(a).getId_captacion_agua_pluvial()+"|");
			wr.print(elementos_adicionales.get(a).getId_separacion_basura()+"|");
			wr.print(elementos_adicionales.get(a).getId_cont_elab_composta()+"|");
			wr.print(elementos_adicionales.get(a).getId_foto_alumbrado_publico()+"|");
			wr.print(elementos_adicionales.get(a).getId_red_agua_purificada()+"|");
			wr.print(elementos_adicionales.get(a).getId_sen_braile_numonom_edificio()+"|");
			wr.print(elementos_adicionales.get(a).getId_senbraile_calle_inter()+"|");
			wr.print(elementos_adicionales.get(a).getId_num_piso_inc_fin_barandal()+"|");
			wr.print(elementos_adicionales.get(a).getId_num_depto_por_piso()+"|");
			wr.print(elementos_adicionales.get(a).getId_boton_eleva_braile()+"|");
			wr.print(elementos_adicionales.get(a).getOtro_tipo_insta_conjunto()+"|");
			wr.print(elementos_adicionales.get(a).getId_wc_economiza_agua_seis()+"|");
			wr.print(elementos_adicionales.get(a).getId_wc_economiza_agua_cinco()+"|");
			wr.print(elementos_adicionales.get(a).getId_wc_economiza_agua_cuatro()+"|");
			wr.print(elementos_adicionales.get(a).getId_econo_agua_doble_boton()+"|");
			wr.print(elementos_adicionales.get(a).getId_regadera_ahorra_agua()+"|");
			wr.print(elementos_adicionales.get(a).getId_sen_braile_agua_fria_cal_regadera()+"|");
			wr.print(elementos_adicionales.get(a).getId_regadera_ahorra_agua_banio()+"|");
			wr.print(elementos_adicionales.get(a).getId_sen_braile_agua_fria_cal_banio()+"|");
			wr.print(elementos_adicionales.get(a).getId_regadera_ahorra_agua_cocina()+"|");
			wr.print(elementos_adicionales.get(a).getId_sen_braile_agua_fria_cal_cocina()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_gas()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_paso()+"|");
			wr.print(elementos_adicionales.get(a).getId_sen_braile_enciende_apaga_boiler()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar()+"|");
			wr.print(elementos_adicionales.get(a).getId_aire_acondicionado()+"|");
			wr.print(elementos_adicionales.get(a).getId_braile_aire_acondicionado()+"|");
			wr.print(elementos_adicionales.get(a).getId_ubica_aire_acondicionado()+"|");
			wr.print(elementos_adicionales.get(a).getId_aislan_termico_techo_nommx()+"|");
			wr.print(elementos_adicionales.get(a).getId_aislante_rmicomurofide()+"|");
			wr.print(elementos_adicionales.get(a).getId_aislan_termico_puerta_ventana()+"|");
			wr.print(elementos_adicionales.get(a).getId_sist_encendido_luces()+"|");
			wr.print(elementos_adicionales.get(a).getId_captacion_energia()+"|");
			wr.print(elementos_adicionales.get(a).getId_voz_datos_internet()+"|");
			wr.print(elementos_adicionales.get(a).getId_sumin_agua_purificada()+"|");
			wr.print(elementos_adicionales.get(a).getId_interfon()+"|");
			wr.print(elementos_adicionales.get(a).getId_circuitos_electricidad()+"|");
			wr.print(elementos_adicionales.get(a).getId_protec_solar_ventana()+"|");
			wr.print(elementos_adicionales.get(a).getInstalacion_especial_vivienda_otro()+"|");
			wr.print(elementos_adicionales.get(a).getId_caseta_vigilancia()+"|");
			wr.print(elementos_adicionales.get(a).getId_locales_comerciales()+"|");
			wr.print(elementos_adicionales.get(a).getId_barda_perimetral()+"|");
			wr.print(elementos_adicionales.get(a).getId_elevador()+"|");
			wr.print(elementos_adicionales.get(a).getId_estacionamiento_techado()+"|");
			wr.print(elementos_adicionales.get(a).getId_estacionamiento_visitas()+"|");
			wr.print(elementos_adicionales.get(a).getId_estacionamiento_discapacitados()+"|");
			wr.print(elementos_adicionales.get(a).getId_rampa_banqueta_discapacitados()+"|");
			wr.print(elementos_adicionales.get(a).getId_juegos_infantiles()+"|");
			wr.print(elementos_adicionales.get(a).getId_canchas_deportivas()+"|");
			wr.print(elementos_adicionales.get(a).getOtro_tipo_obras_complementarias()+"|");
			wr.print(elementos_adicionales.get(a).getId_estacionamiento_techado_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_rampa_acceso_interior_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_textura_especial_piso()+"|");
			wr.print(elementos_adicionales.get(a).getId_accesoria()+"|");
			wr.print(elementos_adicionales.get(a).getId_cisterna()+"|");
			wr.print(elementos_adicionales.get(a).getId_ducto_clima()+"|");
			wr.print(elementos_adicionales.get(a).getId_jaula_tendido()+"|");
			wr.print(elementos_adicionales.get(a).getId_rejas_proteccion_ventanas()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_plantabaja()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_regadera_sardinel()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_piso_antiderrapante()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_charola_regadera()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_pendiente_rejilla_captacion()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_salida_regadera_telefono()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_adecuar_lavabo()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_maneral_palanca()+"|");
			wr.print(elementos_adicionales.get(a).getId_cocina_discapacitados_adecuar_tarja()+"|");
			wr.print(elementos_adicionales.get(a).getId_marco_movible_discapacitados()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_colocacion_espejo()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_pasamanos()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio_discapacitados_areas_circulacion()+"|");
			wr.print(elementos_adicionales.get(a).getId_pasillos()+"|");
			wr.print(elementos_adicionales.get(a).getId_cocina()+"|");
			wr.print(elementos_adicionales.get(a).getId_banio()+"|");
			wr.print(elementos_adicionales.get(a).getId_recamara()+"|");
			wr.print(elementos_adicionales.get(a).getId_accesos_vivienda_puerta()+"|");
			wr.print(elementos_adicionales.get(a).getId_accesos_espacios_interiores()+"|");
			wr.print(elementos_adicionales.get(a).getOtro_tipo_obras_complementarias_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_drenaje_pretratado_aguas_negras()+"|");
			wr.print(elementos_adicionales.get(a).getId_captacion_solar_calentamiento_agua()+"|");
			wr.print(elementos_adicionales.get(a).getId_reductor_sedimentos_calcificados_conjunto()+"|");
			wr.print(elementos_adicionales.get(a).getId_camaras_seguridad()+"|");
			wr.print(elementos_adicionales.get(a).getId_doble_descarga_inodoro_normal()+"|");
			wr.print(elementos_adicionales.get(a).getId_llaves_ahorro_agua_lavabos_banio()+"|");
			wr.print(elementos_adicionales.get(a).getId_reduccion_flujo_llaves_lavabo()+"|");
			wr.print(elementos_adicionales.get(a).getId_regadera_ahorrador_integrado()+"|");
			wr.print(elementos_adicionales.get(a).getId_reduccion_flujo_llave_cocina()+"|");
			wr.print(elementos_adicionales.get(a).getId_valvula_regula_flujo_suministro()+"|");
			wr.print(elementos_adicionales.get(a).getId_captacion_agua_pluvial_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar_tubos_evacuados()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar_tubos_respaldo_gas()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar_plano_respaldo_gas_paso()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar_tubos_respaldo_electrico()+"|");
			wr.print(elementos_adicionales.get(a).getId_calentador_solar_plano_respaldo_electrico()+"|");
			wr.print(elementos_adicionales.get(a).getId_ventilador_solar_corriente_directa()+"|");
			wr.print(elementos_adicionales.get(a).getId_ventilador_solar_corriente_alterna()+"|");
			wr.print(elementos_adicionales.get(a).getId_ventilador_cuerda_alta_potencia()+"|");
			wr.print(elementos_adicionales.get(a).getId_ventilador_cuerda_baja_potencia()+"|");
			wr.print(elementos_adicionales.get(a).getId_focos_ahorradores()+"|");
			wr.print(elementos_adicionales.get(a).getId_focos_led_luz_dirigida()+"|");
			wr.print(elementos_adicionales.get(a).getId_focos_led_luz_difusa()+"|");
			wr.print(elementos_adicionales.get(a).getId_iluminacion_natural()+"|");
			wr.print(elementos_adicionales.get(a).getId_estabilizador_estatico()+"|");
			wr.print(elementos_adicionales.get(a).getId_dispositivo_ahorrador_gas()+"|");
			wr.print(elementos_adicionales.get(a).getId_mantenimiento_contratado_desarrollador()+"|");
			wr.print(elementos_adicionales.get(a).getId_filtros_purificadores_agua()+"|");
			wr.print(elementos_adicionales.get(a).getId_desinfeccion_agua_tinaco()+"|");
			wr.print(elementos_adicionales.get(a).getId_reductor_sedimentos_calcificados_vivienda()+"|");
			wr.print(elementos_adicionales.get(a).getId_pintura_reflejante_techo()+"|");
			wr.print(elementos_adicionales.get(a).getId_pintura_reflejante_muro()+"|");
			wr.print(elementos_adicionales.get(a).getId_aislante_tuberia()+"|");
			wr.print(elementos_adicionales.get(a).getId_tuberia_termica()+"|");
			wr.print(elementos_adicionales.get(a).getId_pintura_fotocatalitica()+"|");
			wr.print(elementos_adicionales.get(a).getId_doble_vidrio_ventanas()+"|");
			wr.print(elementos_adicionales.get(a).getId_vidrios_pelicula_reflectiva()+"|");
			wr.print(elementos_adicionales.get(a).getId_vidrios_dobles_marco_pvc()+"|");
			wr.print(elementos_adicionales.get(a).getId_vidrios_pelicula_reflectiva_marcos_pvc()+"|");
			wr.print(elementos_adicionales.get(a).getId_hidromaceteros()+"|");
			wr.print(elementos_adicionales.get(a).getNum_hidromaceteros()+"|");
			wr.print(elementos_adicionales.get(a).getId_optimizador_tension_electrica()+"|");
			wr.print("\n"); 
		}
		System.out.println("temino");
	}
	wr.close();
	bw.close();
	}catch(IOException e){};
	return f;
	 }


	public void add_a_un_zipaMAI(
			List<Detalle_equipamiento_urbano> detalle_equipamiento_urbanomai,
			String string,
			List<Elementos_adicionales> elementos_adicionalesmai,
			String string2, List<Detalle_Avaluo> detalle_avaluomai,
			String string3, List<ViviendaVO> viviendamai, String string4,
			List<PaquetePrincipal> paquetemai, String string5,
			List<Dtc> dtcmai, String string6) {
		// TODO Apéndice de método generado automáticamente
		  try {
			   ZipFile zipFile = new ZipFile("C:/adjuntos/Isai1.zip");

			   ArrayList filesToAdd = new ArrayList();
			   filesToAdd.add(escribir(string,detalle_equipamiento_urbanomai));
			   filesToAdd.add(escribir2(string2,elementos_adicionalesmai));
			   filesToAdd.add(escribir3(string3,detalle_avaluomai));
			   filesToAdd.add(escribir4(string4,viviendamai));
			   filesToAdd.add(escribir5(string5,paquetemai));
			   filesToAdd.add(escribirMAI(string6,dtcmai));
			   
			   ZipParameters parameters = new ZipParameters();
			   parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set compression method to deflate compression
			   

			   parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); 
			   
			   
			   zipFile.addFiles(filesToAdd, parameters);
			                               
			  } catch (ZipException e) {
			   e.printStackTrace();
			  }  
			 }
	
	
	public File escribirMAI(String nombreArchivo, List<Dtc> dtcmai)
    {
File f = new File(nombreArchivo+".txt");
//Escritura
try{
FileWriter w = new FileWriter(f);
BufferedWriter bw = new BufferedWriter(w);
PrintWriter wr = new PrintWriter(bw);  
wr.write("id_avaluo|id_paquete|id_vivienda|id_tipo_mercado|tipo_linea|id_dtc|calificacion|estatus|zona_restricciones_motivo|id_zona_afectacion|zona_afectacion_motivo|id_zona_areas_inundable|zona_areas_inundable_motivo|id_vialidades_pavimentos|id_vialidades_guarniciones|id_vialidades_accesos|id_infraes_agua_potable|infraes_agua_potable_motivo|id_infraes_drenaje|infraes_drenaje_motivo|id_infraes_energia_electrica|infraes_energia_electrica_motivo|id_infraes_alumbrado_publico|id_obra_cimentacion|obra_cimentacion_motivo|id_obra_estructura|obra_estructura_motivo|id_obra_muros|obra_muros_motivo|id_obra_losas|obra_losas_motivo|id_obra_bardas|obra_bardas_motivo|obra_impermeabilizacion_motivo|id_infra_inst_hidraulicas|id_infra_inst_sanitaria|id_infra_inst_electrica|id_calidad_funcionalidad|calidad_estado_conservacion_motivo|id_vida_util_remanente|vida_util_remanente_motivo|id_equipamiento_educacion|id_equipamiento_salud|id_equipamiento_recreacion|id_equipamiento_transporte|id_equipamiento_vigilancia|id_equipamiento_rec_basura|id_obra_impermeabilizacion|id_calidad_estado_conservacion|id_equipamiento_abasto|id_infra_insta_gas|id_zona_restricciones|");
wr.write("\n");
if(dtcmai.size()> 0){
	System.out.println("entro en el if");
	for (int a=0; a<dtcmai.size(); a++){
		wr.write(dtcmai.get(a).getId_avaluo()+"|");
		wr.write(dtcmai.get(a).getId_paquete()+"|");
		wr.write(dtcmai.get(a).getId_vivienda()+"|");
		wr.write(dtcmai.get(a).getId_tipo_mercado()+"|");
		wr.write(dtcmai.get(a).getTipo_linea()+"|");
		wr.write(dtcmai.get(a).getId_dtc()+"|");
		wr.write(dtcmai.get(a).getCalificacion()+"|");
		wr.write(dtcmai.get(a).getEstatus()+"|");
		wr.write(dtcmai.get(a).getZona_restricciones_motivo()+"|");
		wr.write(dtcmai.get(a).getId_zona_afectacion()+"|");
		wr.write(dtcmai.get(a).getZona_afectacion_motivo()+"|");
		wr.write(dtcmai.get(a).getId_zona_areas_inundable()+"|");
		wr.write(dtcmai.get(a).getZona_areas_inundable_motivo()+"|");
		wr.write(dtcmai.get(a).getId_vialidades_pavimentos()+"|");
		wr.write(dtcmai.get(a).getId_vialidades_guarniciones()+"|");
		wr.write(dtcmai.get(a).getId_vialidades_accesos()+"|");
		wr.write(dtcmai.get(a).getId_infraes_agua_potable()+"|");
		wr.write(dtcmai.get(a).getInfraes_agua_potable_motivo()+"|");
		wr.write(dtcmai.get(a).getId_infraes_drenaje()+"|");
		wr.write(dtcmai.get(a).getInfraes_drenaje_motivo()+"|");
		wr.write(dtcmai.get(a).getId_infraes_energia_electrica()+"|");
		wr.write(dtcmai.get(a).getInfraes_energia_electrica_motivo()+"|");
		wr.write(dtcmai.get(a).getId_infraes_alumbrado_publico()+"|");
		wr.write(dtcmai.get(a).getId_obra_cimentacion()+"|");
		wr.write(dtcmai.get(a).getObra_cimentacion_motivo()+"|");
		wr.write(dtcmai.get(a).getId_obra_estructura()+"|");
		wr.write(dtcmai.get(a).getObra_estructura_motivo()+"|");
		wr.write(dtcmai.get(a).getId_obra_muros()+"|");
		wr.write(dtcmai.get(a).getObra_muros_motivo()+"|");
		wr.write(dtcmai.get(a).getId_obra_losas()+"|");
		wr.write(dtcmai.get(a).getObra_losas_motivo()+"|");
		wr.write(dtcmai.get(a).getId_obra_bardas()+"|");
		wr.write(dtcmai.get(a).getObra_bardas_motivo()+"|");
		wr.write(dtcmai.get(a).getObra_impermeabilizacion_motivo()+"|");
		wr.write(dtcmai.get(a).getId_infra_inst_hidraulicas()+"|");
		wr.write(dtcmai.get(a).getId_infra_inst_sanitaria()+"|");
		wr.write(dtcmai.get(a).getId_infra_inst_electrica()+"|");
		wr.write(dtcmai.get(a).getId_calidad_funcionalidad()+"|");
		wr.write(dtcmai.get(a).getCalidad_estado_conservacion_motivo()+"|");
		wr.write(dtcmai.get(a).getId_vida_util_remanente()+"|");
		wr.write(dtcmai.get(a).getVida_util_remanente_motivo()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_educacion()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_salud()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_recreacion()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_transporte()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_vigilancia()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_rec_basura()+"|");
		wr.write(dtcmai.get(a).getId_obra_impermeabilizacion()+"|");
		wr.write(dtcmai.get(a).getId_calidad_estado_conservacion()+"|");
		wr.write(dtcmai.get(a).getId_equipamiento_abasto()+"|");
		wr.write(dtcmai.get(a).getId_infra_insta_gas()+"|");
		wr.write(dtcmai.get(a).getId_zona_restricciones()+"|");
		wr.write("\n"); 
	}
	System.out.println("temino");
}
wr.close();
bw.close();
}catch(IOException e){};
return f;
 }
		 
//		 public static void main(String[] args) {
//		  add_a_un_zipa();
//		 }
		 
	  
	  
	
	  
		 
		}
