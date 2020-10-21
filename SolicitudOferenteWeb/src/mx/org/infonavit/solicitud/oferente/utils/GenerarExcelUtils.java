package mx.org.infonavit.solicitud.oferente.utils;

import java.util.List;

import mx.org.infonavit.solicitud.oferente.domain.AvaluoDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueCostoFisicoDomain;
import mx.org.infonavit.solicitud.oferente.domain.EnfoqueMercadoDomain;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GenerarExcelUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(GenerarExcelUtils.class);
	
	
	/**
	 * 
	 * @param listaAvaluos
	 * @return
	 */
	public static final HSSFWorkbook generarReporteComparativos(List<AvaluoDomain> listaAvaluos) {
		
		HSSFWorkbook comparativos = new HSSFWorkbook ();
		try{
			   HSSFSheet avaluos = comparativos.createSheet("Avaluos");
			   HSSFSheet mercado = comparativos.createSheet("Mercado");
			   HSSFSheet enfoque = comparativos.createSheet("Enfoque");
			   
			   HSSFRow  rowAvaluoTitulo  = avaluos.createRow(0);
			   rowAvaluoTitulo.createCell(1).setCellValue( new HSSFRichTextString ("Id_Acometida_Telefono"));
			   rowAvaluoTitulo.createCell(2).setCellValue( new HSSFRichTextString ("clasificacionzona"));
			   rowAvaluoTitulo.createCell(3).setCellValue( new HSSFRichTextString ("A_Gral_ClaveSHF"));
			   rowAvaluoTitulo.createCell(4).setCellValue( new HSSFRichTextString ("_kf_Id_UV_Infonavit"));
			   rowAvaluoTitulo.createCell(5).setCellValue( new HSSFRichTextString ("Observaciones_UV"));
			   rowAvaluoTitulo.createCell(6).setCellValue( new HSSFRichTextString ("cus"));
			   rowAvaluoTitulo.createCell(7).setCellValue( new HSSFRichTextString ("Id_DrenajeCalle"));
			   rowAvaluoTitulo.createCell(8).setCellValue( new HSSFRichTextString ("Id_DrenajeZona"));
			   rowAvaluoTitulo.createCell(9).setCellValue( new HSSFRichTextString ("EdadMeses"));
			   rowAvaluoTitulo.createCell(10).setCellValue( new HSSFRichTextString ("A_Gral_FechaAvaluo"));
			   rowAvaluoTitulo.createCell(11).setCellValue( new HSSFRichTextString ("AvanceObraComunes"));
			   rowAvaluoTitulo.createCell(12).setCellValue( new HSSFRichTextString ("AvanceObraInmueble"));
			   rowAvaluoTitulo.createCell(13).setCellValue( new HSSFRichTextString ("Id_AguaPotable"));
			   rowAvaluoTitulo.createCell(14).setCellValue( new HSSFRichTextString ("Id_AlumbradoPublico"));
			   rowAvaluoTitulo.createCell(15).setCellValue( new HSSFRichTextString ("A_Gral_Id_avaluo"));
			   rowAvaluoTitulo.createCell(16).setCellValue( new HSSFRichTextString ("Id_InmuebleClase"));
			   rowAvaluoTitulo.createCell(17).setCellValue( new HSSFRichTextString ("Id_ClaseZona"));
			   rowAvaluoTitulo.createCell(18).setCellValue( new HSSFRichTextString ("Id_Conf_Inmueble"));
			   rowAvaluoTitulo.createCell(19).setCellValue( new HSSFRichTextString ("_kf_Id_CTL_Infonavit"));
			   rowAvaluoTitulo.createCell(20).setCellValue( new HSSFRichTextString ("Id_estadoConservacion"));
			   rowAvaluoTitulo.createCell(21).setCellValue( new HSSFRichTextString ("Id_SUMid_gas_natural"));
			   rowAvaluoTitulo.createCell(22).setCellValue( new HSSFRichTextString ("Id_Acometida_ELectrica"));
			   rowAvaluoTitulo.createCell(23).setCellValue( new HSSFRichTextString ("Id_Banquetas"));
			   rowAvaluoTitulo.createCell(24).setCellValue( new HSSFRichTextString ("Id_Guarniciones"));
			   rowAvaluoTitulo.createCell(25).setCellValue( new HSSFRichTextString ("Id_MaterialVialidades"));
			   rowAvaluoTitulo.createCell(26).setCellValue( new HSSFRichTextString ("Id_NivelInfraestructura"));
			   rowAvaluoTitulo.createCell(27).setCellValue( new HSSFRichTextString ("A_Gral_Paquete"));
			   rowAvaluoTitulo.createCell(28).setCellValue( new HSSFRichTextString ("_kf_Id_VP_Infonavit"));
			   rowAvaluoTitulo.createCell(29).setCellValue( new HSSFRichTextString ("Id_AguasResiduales"));
			   rowAvaluoTitulo.createCell(30).setCellValue( new HSSFRichTextString ("Id_ProximidadUrbana"));
			   rowAvaluoTitulo.createCell(31).setCellValue( new HSSFRichTextString ("Id_RiesgoComercial"));
			   rowAvaluoTitulo.createCell(32).setCellValue( new HSSFRichTextString ("Id_RiesgoSocial"));
			   rowAvaluoTitulo.createCell(33).setCellValue( new HSSFRichTextString ("Id_TipoRedTelefono"));
			   rowAvaluoTitulo.createCell(34).setCellValue( new HSSFRichTextString ("Id_TipoRedElectrica"));
			   rowAvaluoTitulo.createCell(35).setCellValue( new HSSFRichTextString ("Id_InmuebleTipo"));
			   rowAvaluoTitulo.createCell(36).setCellValue( new HSSFRichTextString ("Id_LoteTopografia"));
			   rowAvaluoTitulo.createCell(37).setCellValue( new HSSFRichTextString ("Id_LoteUbicacion"));
			   rowAvaluoTitulo.createCell(38).setCellValue( new HSSFRichTextString ("A_Gral_Id_Vivienda"));
			   rowAvaluoTitulo.createCell(39).setCellValue( new HSSFRichTextString ("Id_NivelEquipamiento"));
			   rowAvaluoTitulo.createCell(40).setCellValue( new HSSFRichTextString ("indice_saturacion_zona"));
			   rowAvaluoTitulo.createCell(41).setCellValue( new HSSFRichTextString ("indivisos_terreno"));
			   rowAvaluoTitulo.createCell(42).setCellValue( new HSSFRichTextString ("Dir_Cord_Latitud_Avaluo"));
			   rowAvaluoTitulo.createCell(43).setCellValue( new HSSFRichTextString ("Dir_Cord_Longitud_Avaluo"));
			   rowAvaluoTitulo.createCell(44).setCellValue( new HSSFRichTextString ("NivelesConstruidos"));
			   rowAvaluoTitulo.createCell(45).setCellValue( new HSSFRichTextString ("Baños"));
			   rowAvaluoTitulo.createCell(46).setCellValue( new HSSFRichTextString ("CajonesEstacionamiento"));
			   rowAvaluoTitulo.createCell(47).setCellValue( new HSSFRichTextString ("MediosBaños"));
			   rowAvaluoTitulo.createCell(48).setCellValue( new HSSFRichTextString ("Recamaras"));
			   rowAvaluoTitulo.createCell(49).setCellValue( new HSSFRichTextString ("Id_Señalizacion"));
			   rowAvaluoTitulo.createCell(50).setCellValue( new HSSFRichTextString ("Id_SistemaMixto"));
			   rowAvaluoTitulo.createCell(51).setCellValue( new HSSFRichTextString ("Sup_Accesoria"));
			   rowAvaluoTitulo.createCell(52).setCellValue( new HSSFRichTextString ("Sup_Construida"));
			   rowAvaluoTitulo.createCell(53).setCellValue( new HSSFRichTextString ("Sup_TerrenoConjunto"));
			   rowAvaluoTitulo.createCell(54).setCellValue( new HSSFRichTextString ("Sup_TerrenoVivienda"));
			   rowAvaluoTitulo.createCell(55).setCellValue( new HSSFRichTextString ("Sup_Vendible"));
			   rowAvaluoTitulo.createCell(56).setCellValue( new HSSFRichTextString ("Uso_Actual"));
			   rowAvaluoTitulo.createCell(57).setCellValue( new HSSFRichTextString ("Uso_Suelo"));
			   rowAvaluoTitulo.createCell(58).setCellValue( new HSSFRichTextString ("Valor_Avaluo_Mercado_m2"));
			   rowAvaluoTitulo.createCell(59).setCellValue( new HSSFRichTextString ("Valor_Avaluo_Mercado_Total"));
			   rowAvaluoTitulo.createCell(60).setCellValue( new HSSFRichTextString ("Valor_Avaluo_Concluido"));
			   rowAvaluoTitulo.createCell(61).setCellValue( new HSSFRichTextString ("Valor_Avaluo_Construccion_M2"));
			   rowAvaluoTitulo.createCell(62).setCellValue( new HSSFRichTextString ("Valor_Avaluo_Construccion_Total"));
			   rowAvaluoTitulo.createCell(63).setCellValue( new HSSFRichTextString ("valor_avaluo_terreno_m2"));
			   rowAvaluoTitulo.createCell(64).setCellValue( new HSSFRichTextString ("valor_avaluo_terreno_total"));
			   rowAvaluoTitulo.createCell(65).setCellValue( new HSSFRichTextString ("VidaUtil_AvaluoA_Gral_NSS"));
			   rowAvaluoTitulo.createCell(66).setCellValue( new HSSFRichTextString ("Dir_Calle"));
			   rowAvaluoTitulo.createCell(67).setCellValue( new HSSFRichTextString ("Dir_Colonia"));
			   rowAvaluoTitulo.createCell(68).setCellValue( new HSSFRichTextString ("Dir_Condominio"));
			   rowAvaluoTitulo.createCell(69).setCellValue( new HSSFRichTextString ("Dir_CodigoPostal"));
			   rowAvaluoTitulo.createCell(70).setCellValue( new HSSFRichTextString ("Dir_Edificio"));
			   rowAvaluoTitulo.createCell(71).setCellValue( new HSSFRichTextString ("Dir_Entrada"));
			   rowAvaluoTitulo.createCell(72).setCellValue( new HSSFRichTextString ("Dir_entrecalle_01"));
			   rowAvaluoTitulo.createCell(73).setCellValue( new HSSFRichTextString ("Dir_entrecalle_02"));
			   rowAvaluoTitulo.createCell(74).setCellValue( new HSSFRichTextString ("Dir_lote"));
			   rowAvaluoTitulo.createCell(75).setCellValue( new HSSFRichTextString ("Dir_manzana"));
			   rowAvaluoTitulo.createCell(76).setCellValue( new HSSFRichTextString ("Dir_Nivel"));
			   rowAvaluoTitulo.createCell(77).setCellValue( new HSSFRichTextString ("Dir_NumExt"));
			   rowAvaluoTitulo.createCell(78).setCellValue( new HSSFRichTextString ("Dir_NumInt"));
			   rowAvaluoTitulo.createCell(79).setCellValue( new HSSFRichTextString ("Dir_Supermanzana"));
			   rowAvaluoTitulo.createCell(80).setCellValue( new HSSFRichTextString ("Id_ViviendaTipo"));
			   rowAvaluoTitulo.createCell(81).setCellValue( new HSSFRichTextString ("_kf_id_Entidad"));
			   rowAvaluoTitulo.createCell(82).setCellValue( new HSSFRichTextString ("_kf_Id_Municipio"));
			   rowAvaluoTitulo.createCell(83).setCellValue( new HSSFRichTextString ("Dir_Entidad"));
			   rowAvaluoTitulo.createCell(84).setCellValue( new HSSFRichTextString ("Dir_Municipio"));
			   rowAvaluoTitulo.createCell(85).setCellValue( new HSSFRichTextString ("id_convivencia"));
			   rowAvaluoTitulo.createCell(86).setCellValue( new HSSFRichTextString ("urlComparativaUno"));
			   rowAvaluoTitulo.createCell(87).setCellValue( new HSSFRichTextString ("urlComparativaDos"));
			   rowAvaluoTitulo.createCell(88).setCellValue( new HSSFRichTextString ("urlComparativaTres"));
			   rowAvaluoTitulo.createCell(89).setCellValue( new HSSFRichTextString ("urlComparativaCuatro"));
			   rowAvaluoTitulo.createCell(90).setCellValue( new HSSFRichTextString ("urlComparativaCinco"));
			   rowAvaluoTitulo.createCell(91).setCellValue( new HSSFRichTextString ("urlComparativaSeis"));
			   rowAvaluoTitulo.createCell(92).setCellValue( new HSSFRichTextString ("ladaUno"));
			   rowAvaluoTitulo.createCell(93).setCellValue( new HSSFRichTextString ("ladaDos"));
			   rowAvaluoTitulo.createCell(94).setCellValue( new HSSFRichTextString ("ladaTres"));
			   rowAvaluoTitulo.createCell(95).setCellValue( new HSSFRichTextString ("ladaCuatro"));
			   rowAvaluoTitulo.createCell(96).setCellValue( new HSSFRichTextString ("ladaCinco"));
			   rowAvaluoTitulo.createCell(97).setCellValue( new HSSFRichTextString ("ladaSeis"));
			   rowAvaluoTitulo.createCell(98).setCellValue( new HSSFRichTextString ("telefonoUno"));
			   rowAvaluoTitulo.createCell(99).setCellValue( new HSSFRichTextString ("telefonoDos"));
			   rowAvaluoTitulo.createCell(100).setCellValue( new HSSFRichTextString ("telefonoTres"));
			   rowAvaluoTitulo.createCell(101).setCellValue( new HSSFRichTextString ("telefonoCuatro"));
			   rowAvaluoTitulo.createCell(102).setCellValue( new HSSFRichTextString ("telefonoCinco"));
			   rowAvaluoTitulo.createCell(103).setCellValue( new HSSFRichTextString ("telefonoSeis"));
			   rowAvaluoTitulo.createCell(104).setCellValue( new HSSFRichTextString ("nombreVecinalUno"));
			   rowAvaluoTitulo.createCell(105).setCellValue( new HSSFRichTextString ("nombreVecinalDos"));
			   rowAvaluoTitulo.createCell(106).setCellValue( new HSSFRichTextString ("nombreVecinalTres"));
			   rowAvaluoTitulo.createCell(107).setCellValue( new HSSFRichTextString ("nombreVecinalCuatro"));
			   rowAvaluoTitulo.createCell(108).setCellValue( new HSSFRichTextString ("nombreVecinalCinco"));
			   rowAvaluoTitulo.createCell(109).setCellValue( new HSSFRichTextString ("nombreVecinalSeis"));

			   
			   HSSFRow  rowMercado  = mercado.createRow(0);
			   rowMercado.createCell(1).setCellValue( new HSSFRichTextString ("id_registro"));
			   rowMercado.createCell(2).setCellValue( new HSSFRichTextString ("id_avaluo"));
			   rowMercado.createCell(3).setCellValue( new HSSFRichTextString ("id_paquete"));
			   rowMercado.createCell(4).setCellValue( new HSSFRichTextString ("id_vivienda"));
			   rowMercado.createCell(5).setCellValue( new HSSFRichTextString ("edad"));
			   rowMercado.createCell(6).setCellValue( new HSSFRichTextString ("id_conservacion"));
			   rowMercado.createCell(7).setCellValue( new HSSFRichTextString ("valor_oferta"));
			   rowMercado.createCell(8).setCellValue( new HSSFRichTextString ("superficie_terreno"));
			   rowMercado.createCell(9).setCellValue( new HSSFRichTextString ("superficie_construccion"));
			   rowMercado.createCell(10).setCellValue( new HSSFRichTextString ("valor_unitario"));
			   rowMercado.createCell(11).setCellValue( new HSSFRichTextString ("factor_fic"));
			   rowMercado.createCell(12).setCellValue( new HSSFRichTextString ("factor_zona"));
			   rowMercado.createCell(13).setCellValue( new HSSFRichTextString ("factor_ubicacion"));
			   rowMercado.createCell(14).setCellValue( new HSSFRichTextString ("factor_superficie"));
			   rowMercado.createCell(15).setCellValue( new HSSFRichTextString ("factor_edad"));
			   rowMercado.createCell(16).setCellValue( new HSSFRichTextString ("factor_conservacion"));
			   rowMercado.createCell(17).setCellValue( new HSSFRichTextString ("factor_otros"));
			   rowMercado.createCell(18).setCellValue( new HSSFRichTextString ("factor_comercializacion"));
			   rowMercado.createCell(19).setCellValue( new HSSFRichTextString ("factor_resultante"));


			   HSSFRow  rowEnfoque  = enfoque.createRow(0);
			   rowEnfoque.createCell(1).setCellValue( new HSSFRichTextString ("id_registro"));
			   rowEnfoque.createCell(2).setCellValue( new HSSFRichTextString ("id_avaluo"));
			   rowEnfoque.createCell(3).setCellValue( new HSSFRichTextString ("id_paquete"));
			   rowEnfoque.createCell(4).setCellValue( new HSSFRichTextString ("id_vivienda"));
			   rowEnfoque.createCell(5).setCellValue( new HSSFRichTextString ("valor_oferta"));
			   rowEnfoque.createCell(6).setCellValue( new HSSFRichTextString ("superficie_terreno"));
			   rowEnfoque.createCell(7).setCellValue( new HSSFRichTextString ("valor_unitario"));
			   rowEnfoque.createCell(8).setCellValue( new HSSFRichTextString ("factor_zona"));
			   rowEnfoque.createCell(9).setCellValue( new HSSFRichTextString ("factor_ubicacion"));
			   rowEnfoque.createCell(10).setCellValue( new HSSFRichTextString ("factor_frente"));
			   rowEnfoque.createCell(11).setCellValue( new HSSFRichTextString ("factor_forma"));
			   rowEnfoque.createCell(12).setCellValue( new HSSFRichTextString ("factor_superficie"));
			   rowEnfoque.createCell(13).setCellValue( new HSSFRichTextString ("factor_comercializacion"));
			   rowEnfoque.createCell(14).setCellValue( new HSSFRichTextString ("factor_otros"));
			   rowEnfoque.createCell(15).setCellValue( new HSSFRichTextString ("factor_resultante"));


			   
			   int contadorAvaluos=1;
			   int contadorMercado=1;
			   int contadorEnfoque=1;
			   for ( AvaluoDomain avaluo : listaAvaluos )
			    {
			     HSSFRow row1 = avaluos.createRow(contadorAvaluos++);
			     row1.createCell(1).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().isAcometidaTelefonico())));
			     row1.createCell(2).setCellValue( new HSSFRichTextString ( avaluo.getDetalleAvaluo().getClasificacionZona() ));
			     row1.createCell(3).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getClaveShf()));
			     row1.createCell(4).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getClaveUv()));
			     row1.createCell(5).setCellValue( new HSSFRichTextString (""));//Observaciones_UV
			     row1.createCell(6).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getCus()));
			     row1.createCell(7).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getDrenajePluvialCalle()));
			     row1.createCell(8).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getDrenajePluvialZona()));
			     row1.createCell(9).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getEdadContruccion())));
			     row1.createCell(10).setCellValue( new HSSFRichTextString (avaluo.getFechaSolicitud()));
			     row1.createCell(11).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getGradoAvanceAreasComunes()));//AvanceObraComunes
			     row1.createCell(12).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getGradoTerminacionObra()));//AvanceObraInmueble
			     row1.createCell(13).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdAguaPotable())));
			     row1.createCell(14).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdAlumbradoPublico())));
			     row1.createCell(15).setCellValue( new HSSFRichTextString (avaluo.getIdAvaluo()));
			     row1.createCell(16).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdClaseGralInmueble())));
			     row1.createCell(17).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdClaseZona())));
			     row1.createCell(18).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdConfInmueble())));
			     row1.createCell(19).setCellValue( new HSSFRichTextString (String.valueOf("")));//_kf_Id_CTL_Infonavit
			     row1.createCell(20).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdEstadoConservacion())));
			     row1.createCell(21).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdGasNatural())));//id_SUM
			     row1.createCell(22).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().isElectAcometicaInmueble())));//idAcometida_Electrica
			     row1.createCell(23).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdMaterialBanquetas())));//Id_banqueta
			     row1.createCell(24).setCellValue( new HSSFRichTextString (avaluo.getDetalleAvaluo().getGuarnicionesValor()));//guarniciones
			     row1.createCell(25).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdMaterialVialidades())));//id_materiales
			     row1.createCell(26).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdNivelInfraurbana())));
			     row1.createCell(27).setCellValue( new HSSFRichTextString (avaluo.getPaquete()));
			     row1.createCell(28).setCellValue( new HSSFRichTextString (""));//_kf_Id_VP_Infonavit
			     row1.createCell(29).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdRecAguasResiduales())));
			     row1.createCell(30).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdRefProximidadUrbana())));
			     row1.createCell(31).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdRiesgoComercial())));
			     row1.createCell(32).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdRiesgoSocial())));
			     row1.createCell(33).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdSuminTelefonico())));//Id_TipoRedTelefono
			     row1.createCell(34).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdSuministroElectricidad())));//Id_TipoRedElectrica
			     row1.createCell(35).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdTipoInmuebleValuado())));
			     row1.createCell(36).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdTopografiaInmueble())));
			     row1.createCell(37).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdUbicaInmuebleTerreno())));
			     row1.createCell(38).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getVivienda())));
			     row1.createCell(39).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIdNivelEquipamientoUrbano())));
			     row1.createCell(40).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIndiceSaturacionZona())));
			     row1.createCell(41).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getIndivisosTerreno())));
			     row1.createCell(42).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getLatitud())));
			     row1.createCell(43).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getLongitud())));
			     row1.createCell(44).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getNivelesConstruccion())));
			     row1.createCell(45).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getNumBanios())));
			     row1.createCell(46).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getNumEstacionamiento())));
			     row1.createCell(47).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getNumMediosBanios())));
			     row1.createCell(48).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getNumRecamaras())));
			     row1.createCell(49).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().isSenalizacionVial())));
			     row1.createCell(50).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSistMixtoDrenaje())));
			     row1.createCell(51).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSuperficieAccesorias())));
			     row1.createCell(52).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSuperficieConstruida())));
			     row1.createCell(53).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSuperficieTerrenoConjunto())));
			     row1.createCell(54).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSuperficieTerrenoVivienda())));
			     row1.createCell(55).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getSuperficieVendible())));
			     row1.createCell(56).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getUsoActual())));
			     row1.createCell(57).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getUsoSuelo())));
			     row1.createCell(58).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorComparativoM2())));
			     row1.createCell(59).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorComparativoTotal())));//Valor_Avaluo_Mercado_Total
			     row1.createCell(60).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorConcluido())));
			     row1.createCell(61).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorConstruccionM2())));
			     row1.createCell(62).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorConstruccionTotal())));
			     row1.createCell(63).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorTerrenoM2())));
			     row1.createCell(64).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getValorTerrenoTotal())));
			     row1.createCell(65).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getDetalleAvaluo().getVidaUtilRemanente())));
			     row1.createCell(66).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getCalle())));
			     row1.createCell(67).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getColonia())));
			     row1.createCell(68).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getCondominio())));
			     row1.createCell(69).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getCp())));
			     row1.createCell(70).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getEdificio())));
			     row1.createCell(71).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getEntrada())));
			     row1.createCell(72).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getEntre_calle_1())));
			     row1.createCell(73).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getEntre_calle_2())));
			     row1.createCell(74).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getLote())));
			     row1.createCell(75).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getManzana())));
			     row1.createCell(76).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getNivel())));
			     row1.createCell(77).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getNum_exterior())));
			     row1.createCell(78).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getNum_interior())));
			     row1.createCell(79).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getSupermanzana())));
			     row1.createCell(80).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getViviendaD().getTipo_vivienda())));
			     row1.createCell(81).setCellValue( new HSSFRichTextString (String.valueOf("")));
			     row1.createCell(82).setCellValue( new HSSFRichTextString (String.valueOf("")));
			     row1.createCell(83).setCellValue( new HSSFRichTextString (""));
			     row1.createCell(84).setCellValue( new HSSFRichTextString (""));
			     row1.createCell(85).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getIConviviencia())));
			     row1.createCell(86).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaUno())));
			     row1.createCell(87).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaDos())));
			     row1.createCell(88).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaTres())));
			     row1.createCell(89).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaCuatro())));
			     row1.createCell(90).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaCinco())));
			     row1.createCell(91).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getUrlComparativaSeis())));
			     row1.createCell(92).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaUno())));
			     row1.createCell(93).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaDos())));
			     row1.createCell(94).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaTres())));
			     row1.createCell(95).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaCuatro())));
			     row1.createCell(96).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaCinco())));
			     row1.createCell(97).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getLadaSeis())));
			     row1.createCell(98).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoUno())));
			     row1.createCell(99).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoDos())));
			     row1.createCell(100).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoTres())));
			     row1.createCell(101).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoCuatro())));
			     row1.createCell(102).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoCinco())));
			     row1.createCell(103).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getTelefonoSeis())));
			     row1.createCell(104).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalUno())));
			     row1.createCell(105).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalDos())));
			     row1.createCell(106).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalTres())));
			     row1.createCell(107).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalCuatro())));
			     row1.createCell(108).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalCinco())));
			     row1.createCell(109).setCellValue( new HSSFRichTextString (String.valueOf(avaluo.getElementosAdicionales().getNombreVecinalSeis())));
			     


			     
			     
			 
			     
			     
			     
			     
//			     row1.createCell(29).setCellValue( new HSSFRichTextString ());
			     if( avaluo.getEnfoquesMercado()!=null && !avaluo.getEnfoquesCFD().isEmpty() )
			     {
			    	 for(EnfoqueMercadoDomain em : avaluo.getEnfoquesMercado())
			    	 {
			    		 HSSFRow mercadoRow = mercado.createRow(contadorMercado++);
				    	 mercadoRow.createCell(1).setCellValue( new HSSFRichTextString (String.valueOf(em.getIdRegistro())));
					     mercadoRow.createCell(2).setCellValue( new HSSFRichTextString (em.getIdAvaluo()));
					     mercadoRow.createCell(3).setCellValue( new HSSFRichTextString (em.getPaquete()));
					     mercadoRow.createCell(4).setCellValue( new HSSFRichTextString (String.valueOf(em.getViviendad())));
					     mercadoRow.createCell(5).setCellValue( new HSSFRichTextString (em.getEdad()));
					     mercadoRow.createCell(6).setCellValue( new HSSFRichTextString (String.valueOf(em.getIdConservacion())));
					     mercadoRow.createCell(7).setCellValue( new HSSFRichTextString (em.getValorOferta()));
					     mercadoRow.createCell(8).setCellValue( new HSSFRichTextString (em.getSuperficieTerreno()));
					     mercadoRow.createCell(9).setCellValue( new HSSFRichTextString (em.getSuperficieConstruccion()));
					     mercadoRow.createCell(10).setCellValue( new HSSFRichTextString (em.getValorUnitario()));
					     mercadoRow.createCell(11).setCellValue( new HSSFRichTextString (em.getFactorFic()));
					     mercadoRow.createCell(12).setCellValue( new HSSFRichTextString (em.getFactorZona()));
					     mercadoRow.createCell(13).setCellValue( new HSSFRichTextString (em.getFactorUbicacion()));
					     mercadoRow.createCell(14).setCellValue( new HSSFRichTextString (em.getFactorSuperficie()));
					     mercadoRow.createCell(15).setCellValue( new HSSFRichTextString (em.getFactorEdad()));
					     mercadoRow.createCell(16).setCellValue( new HSSFRichTextString (em.getFactorConservacion()));
					     mercadoRow.createCell(17).setCellValue( new HSSFRichTextString (em.getFactorOtros()));
					     mercadoRow.createCell(18).setCellValue( new HSSFRichTextString (em.getFactorComercializacion()));
					     mercadoRow.createCell(19).setCellValue( new HSSFRichTextString (em.getFactorResultante()));
			    	 }
			     }
			     if( avaluo.getEnfoquesCFD()!=null && !avaluo.getEnfoquesCFD().isEmpty() )
			     {
			    	 for(EnfoqueCostoFisicoDomain ef : avaluo.getEnfoquesCFD())
			    	 {
			    		 HSSFRow enfoqueRow = enfoque.createRow(contadorEnfoque++);
			    		 enfoqueRow.createCell(1).setCellValue( new HSSFRichTextString (String.valueOf(ef.getIdRegistro())));
			    		 enfoqueRow.createCell(2).setCellValue( new HSSFRichTextString (ef.getIdAvaluo()));
			    		 enfoqueRow.createCell(3).setCellValue( new HSSFRichTextString (ef.getPaquete()));
					     enfoqueRow.createCell(4).setCellValue( new HSSFRichTextString (String.valueOf(ef.getVivieda())));
					     enfoqueRow.createCell(5).setCellValue( new HSSFRichTextString (ef.getValorOferta()));
					     enfoqueRow.createCell(6).setCellValue( new HSSFRichTextString (ef.getSuperficieTerreno()));
					     enfoqueRow.createCell(7).setCellValue( new HSSFRichTextString (ef.getValorUnitario()));
					     enfoqueRow.createCell(8).setCellValue( new HSSFRichTextString (ef.getFactorZona()));
					     enfoqueRow.createCell(9).setCellValue( new HSSFRichTextString (ef.getFactorUbicacion()));
					     enfoqueRow.createCell(10).setCellValue( new HSSFRichTextString (ef.getFactorSuperficie()));
					     enfoqueRow.createCell(11).setCellValue( new HSSFRichTextString (ef.getFactorFrente()));
					     enfoqueRow.createCell(12).setCellValue( new HSSFRichTextString (ef.getFactorForma()));
					     enfoqueRow.createCell(13).setCellValue( new HSSFRichTextString (ef.getFactorComercializacion()));
					     enfoqueRow.createCell(14).setCellValue( new HSSFRichTextString (ef.getFactorOtros()));
					     enfoqueRow.createCell(15).setCellValue( new HSSFRichTextString (ef.getFactorResultante()));
					     	
			    	 }
			     }
			    }
			   
			   return comparativos;
			  }catch (Exception e)
			  {
			   LOGGER.error("[GEU] - Error al generar el archivo de excel de comparativos",e);
			   return comparativos;
			  }
	}

}
