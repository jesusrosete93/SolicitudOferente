// enviar.js

// funcion que envia al controlador solo con el requerimiento
function enviar( form, requerimiento )
	{		
		forma.hdn_requerimiento.value = requerimiento;
		forma.submit( );
	} 
	
function enviarBusqueda( requerimiento ) 
	{
		frm_avaluosBusqueda.hdn_requerimiento.value = requerimiento;
		frm_avaluosBusqueda.submit( );
	}
	
function enviarBandeja( form, requerimiento, bandeja)
	{
		form.hdn_requerimiento.value 		= requerimiento;
		form.hdn_requerimiento_salida.value = bandeja;
		form.submit( );
	} 
		
function paginaSiguiente( form, requerimiento, num_pagina ) 
	{
		form.hdn_num_pagina.value = num_pagina + 1;
		enviar( form, requerimiento );
	}
function guardarMAI( form, accion )
	{
		
		var regreso;
// paq, calle, # ext, entre 1 y entre 2, cp, colonia, deleg o mun, edo, loc o pob
//		regreso = vtxtVacio(form.txt_calle, 'Calle');
//		if( regreso ) regreso = vtxtVacio(form.txt_exterior, 'No. ext');
//		if( regreso ) regreso = vtxtVacio(form.txt_entre_calle_1, 'Entre calle 1');
//		if( regreso ) regreso = vtxtVacio(form.txt_entre_calle_2, 'Entre calle 2');
//		if( regreso ) regreso = vtxtVacio(form.txt_cp, 'C.P.');
//		if( regreso ) regreso = vtxtVacio(form.txt_colonia,'Colonia');
//		if( regreso && form.txt_municipio.value == '' ) {
//			alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
//			form.txt_cp.focus();
//			regreso = false;
//		}		
		//if( regreso ) regreso = vtxtVacio(form.txt_localidad, 'Localidad');
		//if( regreso ) enviar( form, requerimiento);
		regreso=true;
		if ( regreso ){
			document.getElementById('frm_ro_mai_3').action = accion;
			frm_ro_mai_3.submit( );
		} 
	}
	
//Agregado LIII	
	
function guardarMAILIII( form, requerimiento )
	{
		var regreso;
// paq, calle, # ext, entre 1 y entre 2, cp, colonia, deleg o mun, edo, loc o pob
		regreso = vtxtVacio(form.txt_calle, 'Calle');
		//if( regreso ) regreso = vtxtVacio(form.txt_exterior, 'No. ext');
		if( regreso ) regreso = vtxtVacio(form.txt_entre_calle_1, 'Entre calle 1');
		if( regreso ) regreso = vtxtVacio(form.txt_entre_calle_2, 'Entre calle 2');
		if( regreso ) regreso = vtxtVacio(form.txt_cp, 'C.P.');
		if( regreso ) regreso = vtxtVacio(form.txt_colonia,'Colonia');
		if( regreso && form.txt_municipio.value == '' ) {
			alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
			form.txt_cp.focus();
			regreso = false;
		}		
		if( regreso ) regreso = vtxtVacio(form.txt_localidad, 'Localidad');
		if( regreso ) enviar( form, requerimiento);
	}
		
//	
function guardarUV( form, requerimiento )
	{
		
		var regreso;
		var regreso2;
		var slc_select = form.slc_permisosLinea.value;
		
		if (slc_select != -1)
		regreso2 = true;
		else {
			alert ("Debe seleccionar un permiso para ver las Líneas");
			regreso2 = false;
		}
		if (regreso2){		
			//regreso = vtxtLongitudExacta(form.UV, 4, 'Clave Unidad Valuadora');
			regreso = true;
						if( regreso ) regreso = vtxtLetra2( form.txt_siglas.value, 'Siglas',  form.txt_siglas);
			if( regreso ) regreso = vtxtLongitudExacta(form.txt_cve_shf, 5,'Registro SHF');
			//if( regreso ) regreso = vtxtNumero( form.UV, 'Clave Unidad Valuadora' );
			if( regreso ) regreso = vtxtNumero( form.txt_cve_shf, 'Registro SHF' );
			if( regreso ) regreso = vtxtNumero( form.txt_cve_shf, 'Registro SHF' );

			//if( regreso ) = vtxtVacio(form.txt_cve_shf, 'Registro SHF');
			//if( regreso ) regreso = vtxtLongitudExacta( form.txt_cve_shf, 5,'Registro SHF' )
			//if( regreso ) = vtxtLongitudExacta(form.txt_cve_shf, 5, 'Registro SHF');	
		
		  if( regreso )enviar( form, requerimiento);
	  }
	}
function vtxtLetra2( cajaTexto, des_campo, forma )
	{ 
		var regreso;
			regreso = true;
			
			if(cajaTexto.length <= 0){
				alert ("El campo "+des_campo+" es obligatorio");
				forma.focus();
				regreso=false;

			}
			if( !vLetras2( cajaTexto ) )
				{
					regreso = false;
					alert( "Caracter invalido en "+des_campo );
					forma.focus();
					//alert( "Caracter invalido en el campo Siglas" );
				}
			return regreso;
	}
	function vLetras2( cadena )
	{ 
	
		var longcad;
		var tope;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso = true;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( ( t >= "A" && t <= "Z" ) || ( t >= "a" && t <= "z" ) || 
						 ( t == "á" ) || ( t == "é" ) || ( t == "í" ) || ( t == "ó" ) || ( t == "ú" ) || 
						 ( t == "Á" ) || ( t == "É" ) || ( t == "Í" ) || ( t == "Ó" ) || ( t == "Ú" ) || 	
						 ( t == "ñ" ) || ( t == "Ñ" ) || ( t == " " )) )
						{
							regreso = false;
							break; 
					 	}
				}
		return regreso;
	}
	
function guardarSol( form, accion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, paterno, materno, nombre, rfc, nss

		regreso = vtxtVacio(document.frm_ro_mai_1.paterno, 'Apellido paterno');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.nombre, 'Nombre o Razon Social');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.rfc, 'R.F.C.');
		if( regreso ) regreso = vtxtRFC(document.frm_ro_mai_1.rfc, 'R.F.C.');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.nss, 'N.S.S.');
		if( regreso ) regreso = vtxtLongitudExacta(document.frm_ro_mai_1.nss, 11, 'N.S.S.');
		//if( regreso && document.frm_ro_mai_1.curp.length != 0) regreso = vtxtLongitudExacta(document.frm_ro_mai_1.curp, 18, 'C.U.R.P.');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.calle, 'Calle');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.no_exterior, 'No. ext');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.cp, 'C.P.');
		if( regreso ) {
			if (document.frm_ro_mai_1.slc_colonia.value == -1){
				 alert ("Debe ingresar un CP existente y seleccionar o capturar una Colonia");	
				 regreso=false;
			}
			else regreso = true;
		}
		//if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.colonia,'Colonia');
		//if( regreso && document.frm_ro_mai_1.municipio.length == 0 ) {
		//	alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
		//	document.frm_ro_mai_1.cp.focus();
		//	regreso = false;
		//}
		
		if ( regreso ){
			document.getElementById('frm_ro_mai_1').action = accion;
			frm_ro_mai_1.submit( );
		} 
	}
function guardarSolTerreno( form, accion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, paterno, materno, nombre, rfc, nss
		regreso = vtxtVacio(document.frm_ro_mai_LIII_1.apPaterno, 'Apellido paterno');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.nombre, 'Nombre o Razon Social');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.rfcSolicitante, 'R.F.C.');
		if( regreso ) regreso = vtxtRFC(document.frm_ro_mai_LIII_1.rfcSolicitante, 'R.F.C.');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.nss, 'N.S.S.');
		if( regreso ) regreso = vtxtLongitudExacta(document.frm_ro_mai_LIII_1.nss, 11, 'N.S.S.');


		//if( regreso && document.frm_ro_mai_1.curp.length != 0) regreso = vtxtLongitudExacta(document.frm_ro_mai_1.curp, 18, 'C.U.R.P.');


		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.calle, 'Calle');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.numeroExterior, 'No. ext');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_LIII_1.cp, 'C.P.');
		if( regreso ) {
			if (document.frm_ro_mai_LIII_1.slc_colonia.value == -1){
				 alert ("Debe ingresar un CP existente y seleccionar o capturar una Colonia");	
				 regreso=false;
			}
			else regreso = true;
		}
		//if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_1.colonia,'Colonia');
		//if( regreso && document.frm_ro_mai_1.municipio.length == 0 ) {
		//	alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
		//	document.frm_ro_mai_1.cp.focus();
		//	regreso = false;
		//}

		if ( regreso ){
			document.getElementById('frm_ro_mai_LIII_1').action = accion;
			frm_ro_mai_LIII_1.submit( );
		} 
	}
function guardarOfe( form, accion, opcion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, razonSocial, rfc
  	regreso = vtxtVacio(document.frm_ro_mai_2.calle, 'Calle');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_2.no_exterior, 'No. ext');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_2.cp, 'C.P.');
		//if( regreso && document.frm_ro_mai_2.municipio.length == 0 ) {
		//	alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
		//	document.frm_ro_mai_2.cp.focus();
		//	regreso = false;
		//}
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_2.nombre_razon_social, 'Nombre o Razon Social');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_2.rfc, 'R.F.C.');
		if( regreso ) regreso = vtxtRFC(document.frm_ro_mai_2.rfc, 'R.F.C.');
		//if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_2.colonia,'Colonia');
		//if( regreso ) regreso = vtxtLongitudExacta(document.frm_ro_mai_2.rfc, 13 , 'R.F.C.');
		//if( regreso && document.frm_ro_mai_2.curp.length != 0) regreso = vtxtLongitudExacta(document.frm_ro_mai_2.curp, 18, 'C.U.R.P.');
		if( regreso ) {
			if (document.frm_ro_mai_2.slc_colonia.value == -1){
				 alert ("Debe ingresar un CP existente y seleccionar o capturar una Colonia");	
				 regreso=false;
			}
			else regreso = true;
		}
		if ( regreso ){
			document.frm_ro_mai_2.opcion.value=opcion;
			document.getElementById('frm_ro_mai_2').action = accion;
			frm_ro_mai_2.submit( );
		} 
	}
function guardarViv( form, accion, opcion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, razonSocial, rfc
		regreso = vtxtVacio(document.frm_ro_mai_3.calle, 'Calle');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.num_exterior, 'No. ext');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.cp, 'C.P.');
		if( regreso ) {
			if (document.frm_ro_mai_3.slc_colonia.value == -1){
				 alert ("Debe ingresar un CP existente y seleccionar o capturar una Colonia");	
				 regreso=false;
			}
			else regreso = true;
		}
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.entre_calle_1, 'Entre Calle 1');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.entre_calle_2, 'Entre Calle 2');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.localidad, 'localidad');
		if( regreso ) {
			if (document.frm_ro_mai_3.tipo_vivienda.value == -1){
				 alert ("Seleccione el tipo de Vivienda");	
				 regreso=false;
			}
			else regreso = true;
		}
		if (document.frm_ro_mai_3.tipo_vivienda.value == "usada" ){
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.num_notario, 'Número Notario');
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.nombre_notario, 'Nombre Notario');
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.plaza, 'Plaza');
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.escritura, 'Escritura');
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.libro, 'Libro');
			if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.volumen, 'Volumen');
		}
		//if( regreso && document.frm_ro_mai_3.municipio.length == 0 ) {
		//	alert( "El campo Municipio no puede ser vacio.\nIngrese un Codigo Postal valido y Oprima el boton de Consultar" );
		//	document.frm_ro_mai_3.cp.focus();
		//	regreso = false;
		//}
		//if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_3.colonia,'Colonia');
				
		if ( regreso ){
		
			document.frm_ro_mai_3.opcion.value=opcion;
			document.getElementById('frm_ro_mai_3').action = accion;
			frm_ro_mai_3.submit( );
		} 
	}
function guardarTerr( form, accion, opcion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, razonSocial, rfc
		regreso = vtxtVacio(document.frm_ro_mai_terreno_3.calle, 'Calle');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_3.entreCalle, 'Entre Calle 1');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_3.yCalle, 'Entre Calle 2');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_3.numeroOficial, 'No. Oficial');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_3.cp, 'C.P.');
		if( regreso ) {
			if (document.frm_ro_mai_terreno_3.slc_colonia.value == -1){
				 alert ("Debe ingresar un CP existente y seleccionar o capturar una Colonia");	
				 regreso=false;
			}
			else regreso = true;
		}
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_3.localidad, 'Localidad');

		if ( regreso ){
		
			document.frm_ro_mai_terreno_3.opcion.value=opcion;
			document.getElementById('frm_ro_mai_terreno_3').action = accion;
			frm_ro_mai_terreno_3.submit( );
		} 
	}
function guardarConstructor( form, accion, opcion )
	{
		var regreso;
// paq, calle, # ext, cp, colonia, deleg o mun, edo, razonSocial, rfc
		
		regreso = vtxtVacio(document.frm_ro_mai_terreno_2.nombreRazonSocial, 'Nombre o Razon Social');
		if( regreso ) regreso = vtxtVacio(document.frm_ro_mai_terreno_2.rfcConstructor, 'R.F.C.');
		//if( regreso ) regreso = vtxtRFC(form.txt_rfc, 'R.F.C.');
	
		//if( regreso && form.txt_curp.value != '') regreso = vtxtLongitudExacta(form.txt_curp, 18, 'C.U.R.P.');
		//if( regreso ) enviar( form, requerimiento);
		//regreso=true;
		if ( regreso ){
		
			document.frm_ro_mai_terreno_2.opcion.value=opcion;
			document.getElementById('frm_ro_mai_terreno_2').action = accion;
			frm_ro_mai_terreno_2.submit( );
		} 
	}


function valSeleccionPerito( form, requerimiento )
	{
		var regreso;

		regreso = vselNoSeleccion(form.idPerito, 'Perito');
		
		if( regreso ) enviar( form, requerimiento);
	}

function guardarPerito( form, requerimiento )
	{
		var regreso;
// id_shf, nombre, paterno, materno, curp, rfc, direccion, telefono, cedula, puesto, email

		if(requerimiento == "PERITOS_ALTA_SOLICITAR")
			regreso = vtxtVacio(form.txtIdPeritoSHF, 'ID SHF');			
		if( regreso ) regreso = vtxtLongitudExacta( form.txtIdPeritoSHF, 7,'ID SHF' );
		else
			regreso = true;
		
		if( regreso ) regreso = vtxtVacio(form.txtNombre, 'Nombre');
		if( regreso ) regreso = vtxtLetra(form.txtNombre, 'Nombre');
		if( regreso ) regreso = vtxtVacio(form.txtPaterno, 'Paterno');
		if( regreso ) regreso = vtxtLetra(form.txtPaterno, 'Paterno');
		if( regreso ) regreso = vtxtVacio(form.txtMaterno, 'Materno');
		if( regreso ) regreso = vtxtLetra(form.txtMaterno, 'Materno');
		if( regreso && form.txtCurp.value != '') regreso = vtxtLongitudExacta(form.txtCurp, 18, 'CURP');
		if( regreso ) regreso = vtxtVacio(form.txtRfc, 'RFC');
		if( regreso ) regreso = vtxtRFC(form.txtRfc, 'RFC');
	//	if( regreso ) regreso = vtxtLongitudExacta(form.txtRfc, 13, 'RFC');
		if( regreso ) regreso = vtxtVacio(form.txtDireccion, 'Dirección');
		if( regreso ) regreso = vtxtAlfa2(form.txtDireccion, 'Dirección');
		if( regreso ) regreso = vtxtVacio(form.txtTelefono, 'Teléfono');
		if( regreso ) regreso = vtxtTelefono(form.txtTelefono, 'Teléfono');
		if( regreso ) regreso = vtxtVacio(form.txtCedulaProfesional, 'Cédula Profesional');
		if( regreso ) regreso = vtxtVacio(form.txtPuesto, 'Puesto');
		if( regreso ) regreso = vtxtVacio(form.txtEmail, 'e-mail');
		if( regreso ) regreso = vtxtCorreoE(form.txtEmail, 'e-mail');
		
		if( regreso ) enviar( form, requerimiento);
	}
	
function valSeleccionControlador( form, requerimiento )
	{
		var regreso;
	
		regreso = vselNoSeleccion(form.idControlador, 'Controlador');
				
		if( regreso ) enviar( form, requerimiento);
	}

function guardarControlador( form, requerimiento )
	{
		var regreso;
// id_shf, nombre, paterno, materno, curp, rfc, direccion, telefono, cedula, puesto, email
		
		if(requerimiento == "CONTROLADORES_ALTA_SOLICITAR")
			regreso = vtxtVacio(form.txtIdControladorSHF, 'ID SHF');
		if( regreso ) regreso = vtxtLongitudExacta( form.txtIdControladorSHF, 7,'ID SHF' );
		else
			regreso = true;
		
		if( regreso ) regreso = vtxtVacio(form.txtNombre, 'Nombre');
		if( regreso ) regreso = vtxtLetra(form.txtNombre, 'Nombre');
		if( regreso ) regreso = vtxtVacio(form.txtPaterno, 'Paterno');
		if( regreso ) regreso = vtxtLetra(form.txtPaterno, 'Paterno');
		if( regreso ) regreso = vtxtVacio(form.txtMaterno, 'Materno');
		if( regreso ) regreso = vtxtLetra(form.txtMaterno, 'Materno');
		if( regreso && form.txtCurp.value != '') regreso = vtxtLongitudExacta(form.txtCurp, 18, 'CURP');
		if( regreso ) regreso = vtxtVacio(form.txtRfc, 'RFC');
		if( regreso ) regreso = vtxtRFC(form.txtRfc, 'RFC');
	//	if( regreso ) regreso = vtxtLongitudExacta(form.txtRfc, 13, 'RFC');
		if( regreso ) regreso = vtxtVacio(form.txtDireccion, 'Dirección');
		if( regreso ) regreso = vtxtAlfa2(form.txtDireccion, 'Dirección');
		if( regreso ) regreso = vtxtVacio(form.txtTelefono, 'Teléfono');
		if( regreso ) regreso = vtxtTelefono(form.txtTelefono, 'Teléfono');
		if( regreso ) regreso = vtxtVacio(form.txtCedulaProfesional, 'Cédula Profesional');
		if( regreso ) regreso = vtxtVacio(form.txtPuesto, 'Puesto');
		if( regreso ) regreso = vtxtVacio(form.txtEmail, 'e-mail');
		if( regreso ) regreso = vtxtCorreoE(form.txtEmail, 'e-mail');
				
		if( regreso ) enviar( form, requerimiento);
	}

function guardarAvaluo( form, requerimiento )
	{
		var regreso;
		
		// Unidad Valuadora
		cambiarCapa('Unidad_Valuadora');
		
		regreso = vtxtVacio(form.txt_clave_avaluo_shf, 'Clave Avaluo Shf');
		if( regreso ) regreso = vtxtLongitudExacta(form.txt_clave_avaluo_shf, 17, 'Clave Avaluo Shf');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_avaluo_uv, 'Clave Avaluo de la Unidad de Valuacion');
		if( regreso ) regreso = vtxtVacio(form.txt_fecha_avaluo, 'Fecha Avaluo');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_unica_vivienda, 'Clave Unica Vivienda');
		if( regreso ) if( !vVacio(form.txt_clave_unica_vivienda) ) regreso = vtxtLongitudExacta(form.txt_clave_unica_vivienda, 16, 'Clave Unica Vivienda');
		if( regreso ) regreso = vtxtVacio(form.sel_controlador, 'Controlador');
		if( regreso ) regreso = vtxtVacio(form.sel_perito, 'Perito');
				
		// Vivienda
		if(regreso){
		cambiarCapa('Datos_Vivienda');
		if( regreso ) regreso = vtxtVacio(form.txt_clasificacion_zona, 'Clasificacion Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_referencia_proximidad, 'Referencia de proximidad Urbana');
		if( regreso ) regreso = vtxtVacio(form.sel_clase_inmuebles_zona, 'Clase General de inmuebles en la zona');
		if( regreso ) regreso = vtxtVacio(form.txt_niveles_zona, 'Niveles Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_construcciones, 'Uso de Construcciones');
		if( regreso ) if( form.sel_uso_construcciones.value=="5" ) regreso = vtxtVacio(form.txt_uso_construcciones_valor, 'Descripcion Uso de Construcciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_indice_saturacion_zona, 'Indice de Saturacion en la Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_densidad_poblacion, 'Densidad de Poblacion');
		if( regreso ) regreso = vtxtVacio(form.sel_distribucion_agua_potable, 'Distribucion de Agua Potable');
		if( regreso ) regreso = vtxtVacio(form.sel_red_aguas_residuales, 'Red de Recoleccion Aguas Residuales');
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_calle, 'Red Drenaje Pluvial Calle');
		
		
		// Vivienda1
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_zona, 'Red Drenaje Pluvial Zona');
		//if( regreso ) regreso = vtxtVacio(form.txt_sistema_mixto_drenaje, 'Sistema Mixto Drenaje');
		//if( regreso ) regreso = vtxtVacio(form.txt_fosa_septica, 'Fosa Septica');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_electrificacion, 'Suministro Electrificacion');
		if( regreso ) regreso = vtxtVacio(form.sel_electrificacion, 'Electrificacion con Acometida al inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_alumbrado_publico, 'Alumbrado Publico');
		if( regreso ) regreso = vtxtVacio(form.sel_material_vialidades, 'Material de Vialidades');
		if( regreso ) if( form.sel_material_vialidades.value=="6" ) regreso = vtxtVacio(form.txt_material_vialidades_valor, 'Descripcion Material de Vialidades (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_banquetas, 'Material de Banquetas');
		if( regreso ) if( form.sel_material_banquetas.value=="4" ) regreso = vtxtVacio(form.txt_material_banquetas_valor, 'Descripcion Material de Banquetas (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_guarniciones, 'Material de Guarniciones');
		if( regreso ) if( form.sel_material_guarniciones.value=="2" ) regreso = vtxtVacio(form.txt_material_guarniciones_valor, 'Descripcion Material de Guarniciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_nivel_infraestructura, 'Nivel Infraestructura en porcentaje');
		if( regreso ) regreso = vtxtVacio(form.sel_gas_natural, 'Gas Natural');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_telefonico, 'Suministro Telefonico');
		if( regreso ) regreso = vtxtVacio(form.sel_acometida_inmueble_telefonico, 'Acometida al inmueble telefonico');
		if( regreso ) regreso = vtxtVacio(form.sel_senializacion_vial, 'Señalizacion vial');
		if( regreso ) regreso = vtxtVacio(form.sel_nomenclatura_calles_circundantes, 'Nomenclatura de Calles Circundantes');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_distancia, 'Transporte Urbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_frecuencia, 'Transporte Urbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_distancia, 'Transporte Suburbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_frecuencia, 'Transporte Suburbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.sel_vigilancia, 'Vigilancia');
		if( regreso ) regreso = vtxtVacio(form.sel_recoleccion_desechos, 'Rec. municipal o privada de desechos');
		//if( regreso ) regreso = vtxtVacio(form.chk_equipamiento_urbano?, 'Equipamiento Urbano');
		if( regreso ) if( form.chk_equipamiento_urbano1.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano1, 'Distancia Equipamiento Urbano Iglesia');
		if( regreso ) if( form.chk_equipamiento_urbano2.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano2, 'Distancia Equipamiento Urbano Mercados');
		if( regreso ) if( form.chk_equipamiento_urbano3.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano3, 'Distancia Equipamiento Urbano Plazas publicas');
		if( regreso ) if( form.chk_equipamiento_urbano4.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano4, 'Distancia Equipamiento Urbano Parques y jardines');
		if( regreso ) if( form.chk_equipamiento_urbano5.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano5, 'Distancia Equipamiento Urbano Escuelas');
		if( regreso ) if( form.chk_equipamiento_urbano6.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano6, 'Distancia Equipamiento Urbano Hospitales');
		if( regreso ) if( form.chk_equipamiento_urbano7.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano7, 'Distancia Equipamiento Urbano Bancos');
		if( regreso ) if( form.chk_equipamiento_urbano8.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano8, 'Distancia Equipamiento Estacion de transporte');
		if( regreso ) regreso = vtxtVacio(form.sel_tipo_inmueble_valuado, 'Tipo inmueble valuado');
		if( regreso ) if( form.sel_tipo_inmueble_valuado.value=="5" ) regreso = vtxtVacio(form.txt_tipo_inmueble_valuado_valor, 'Descripcion Tipo inmueble valuado (Otro)');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_vivienda_paquete, 'Numero de vivienda en el paquete');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_reg_conjunto_infonavit, 'Numero de registro conjunto INFONAVIT');
		}
		
		// Inmueble
		if(regreso){
		cambiarCapa('Datos_Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_localidad_poblacion, 'Localidad o poblacion');
		//if( regreso ) regreso = vtxtVacio(form.txt_codigo_postal, 'Codigo Postal');
		if( regreso ) if( !vVacio(form.txt_codigo_postal) ) regreso = vtxtLongitudExacta(form.txt_codigo_postal, 5, 'Codigo Postal');
		//if( regreso ) regreso = vtxtVacio(form.txt_colonia, 'Colonia Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_calle, 'Calle Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_exterior, 'Num. Exterior Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_interior, 'Num. Interior Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_ubicacion, 'Ubicacion del Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_configuracion_inmueble, 'Configuracion del Immueble');
		if( regreso ) regreso = vtxtVacio(form.sel_topografia_inmueble, 'Topografia Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_suelo, 'Uso de Suelo');
		if( regreso ) regreso = vtxtVacio(form.txt_coeficiente_utilizacion_suelo, 'Coeficiente de Utilizacion de Suelo');
		if( regreso ) regreso = vtxtVacio(form.txt_densidad_habitacional, 'Densidad Habitacional');
		if( regreso ) regreso = vtxtVacio(form.txt_uso_actual, 'Uso Actual');
		if( regreso ) regreso = vtxtVacio(form.txt_num_recamaras, 'Num. de Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_num_banios, 'Num. de Baños');
		if( regreso ) regreso = vtxtVacio(form.txt_num_espacios_estacionamiento, 'Num. espacios Estacionamiento');
		if( regreso ) regreso = vtxtVacio(form.sel_calidad_proyecto, 'Calidad Proyecto');
		if( regreso ) regreso = vtxtVacio(form.sel_clase_gral_inmueble, 'Clase Gral Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_estado_conservacion, 'Estado Conservacion');
		if( regreso ) regreso = vtxtVacio(form.txt_edad_contruccion, 'Edad Contruccion');
		if( regreso ) regreso = vtxtVacio(form.txt_vida_util_remanente, 'Vida Util Remanente');
		if( regreso ) regreso = vtxtVacio(form.txt_niveles_construccion, 'Niveles de construccion');
		if( regreso ) regreso = vtxtVacio(form.txt_grado_terminacion_obra, 'Grado Terminacion Obra');
		//if( regreso ) regreso = vtxtVacio(form.txt_grado_avance_areas_comunes, 'Grado y Avance Areas Comunes');
		
		if( regreso ) regreso = vtxtVacio(form.sel_inst_hidraulicas, 'Instalaciones Hidraulicas');
		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_hidraulicas, 'Material Instalaciones Hidraulicas');
		if( regreso ) regreso = vtxtVacio(form.sel_inst_sanitarias, 'Instalaciones Sanitarias');
		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_sanitarias, 'Material Instalaciones Sanitarias');
		if( regreso ) regreso = vtxtVacio(form.sel_inst_electricas, 'Instalaciones Electricas');
		//if( regreso ) regreso = vtxtVacio(form.sel_elementos_adicionales, 'Elementos Adicionales');
		if( regreso ) if( form.sel_elementos_adicionales.value=="4" ) regreso = vtxtVacio(form.txt_elementos_adicionales_valor, 'Descripcion Elementos Adicionales (Otro)');
		}
		
		// Terreno
		if(regreso){
		cambiarCapa('Datos_Terreno');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_conjunto, 'Superficie Terreno Conjunto');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_vivienda, 'Superficie Terreno Vivienda');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_construida, 'Superficie Construida');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_accesorias, 'Superficie Accesorias');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_vendible, 'Superficie Vendible');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_construccion, 'Indivisos de la Contruccion');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_terreno, 'Indivisos del Terreno');
		}
		
		// Pisos
		if(regreso){
		cambiarCapa('Datos_Pisos');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_sala,'Pisos Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_recamaras,'Pisos Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_banio,'Pisos Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_cocina,'Pisos Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_patio_servicio,'Pisos Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_estacionamiento,'Pisos Estacionamiento');
		}
		
		// Muros
		if(regreso){
		cambiarCapa('Datos_Muros');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_sala,'Muros Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_recamaras,'Muros Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_banio,'Muros Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_cocina,'Muros Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_patio_servicio,'Muros Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_estacionamiento,'Muros Estacionamiento');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_fachada,'Muros Fachada');
		}
		
		// Plafones
		if(regreso){
		cambiarCapa('Datos_Plafones');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_sala,'Plafones Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_recamaras,'Plafones Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_banio,'Plafones Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_cocina,'Plafones Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_patio_servicio,'Plafones Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_estacionamiento,'Plafones Estacionamiento');
		}
		
		// Avaluo
		if(regreso){
		cambiarCapa('Datos_Avaluo');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_total, 'Valor Comparativo Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_m2, 'Valor Comparativo m2');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_total, 'Valor Terreno Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_m2, 'Valor Terreno M2');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_total, 'Valor Construccion Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_m2, 'Valor Construccion M2');
		//if( regreso ) regreso = vtxtVacio(form.txt_valor_residual, 'Valor Residual');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_concluido, 'Valor Concluido');
		}
		
		// DTC
		if(regreso){

		if(form.hdn_tipo_avaluo.value == "1")
			 enviar( form, requerimiento);	
			
			
			if(form.hdn_tipo_avaluo.value == "2"){	
			//alert(pregunto);	
			if(pregunto== true){
			if (!confirm('Para capturar el Dictamen Tecnico de Calidad, oprima Aceptar. \nPara enviar sin Dictamen Tecnico de Calidad, oprima Cancelar')){
							 
     	 		 enviar( form, requerimiento);				 				
				}else{	
							
				cambiarCapa('Datos_DTC');
				
				if( regreso ) regreso = vradVacio(form.rad_restricciones_zona, 'Restricciones');
				if( regreso ) if( vradValor( form.rad_restricciones_zona ) == "C") regreso = vtxtVacio(form.txt_restricciones_zona_motivo, 'Motivo de descalificacion por Restricciones');
				if( regreso ) regreso = vradVacio(form.rad_zonas_afectacion, 'Zonas de Afectacion');
				if( regreso ) if( vradValor( form.rad_zonas_afectacion ) == "C") regreso = vtxtVacio(form.txt_zonas_afectacion_motivo, 'Motivo de descalificacion por Zonas de Afectacion');
				if( regreso ) regreso = vradVacio(form.rad_areas_inundables, 'Areas Inundables');
				if( regreso ) if( vradValor( form.rad_areas_inundables ) == "C") regreso = vtxtVacio(form.txt_areas_inundables_motivo, 'Motivo de descalificacion por Areas Inundables');
				if( regreso ) regreso = vradVacio(form.rad_vialidades_pavimentos, 'Pavimentos');
				if( regreso ) regreso = vradVacio(form.rad_vialidades_guarniciones, 'Guarniciones, Banquetas y Andadores');
				if( regreso ) regreso = vradVacio(form.rad_vialidades_accesos, 'Accesos');
				if( regreso ) regreso = vradVacio(form.rad_infra_agua_potable, 'Agua Potable');
				if( regreso ) if( vradValor( form.rad_infra_agua_potable ) == "C") regreso = vtxtVacio(form.txt_infra_agua_potable_motivo, 'Motivo de descalificacion por Agua Potable');
				if( regreso ) regreso = vradVacio(form.rad_infra_drenaje, 'Drenaje');
				if( regreso ) if( vradValor( form.rad_infra_drenaje ) == "C") regreso = vtxtVacio(form.txt_infra_drenaje_motivo, 'Motivo de descalificacion por Drenaje');
				if( regreso ) regreso = vradVacio(form.rad_infra_electrica, 'Energia electrica');
				if( regreso ) if( vradValor( form.rad_infra_electrica ) == "C") regreso = vtxtVacio(form.txt_infra_electrica_motivo, 'Motivo de descalificacion por Energia Electrica');
				if( regreso ) regreso = vradVacio(form.rad_infra_alumbrado_publico, 'Alumbrado Publico');
				if( regreso ) regreso = vradVacio(form.rad_obra_cimentacion, 'Cimentacion');
				if( regreso ) if( vradValor( form.rad_obra_cimentacion ) == "C") regreso = vtxtVacio(form.txt_obra_cimentacion_motivo, 'Motivo de descalificacion por la Cimentacion');
				if( regreso ) regreso = vradVacio(form.rad_obra_estructura, 'Estructura');
				if( regreso ) if( vradValor( form.rad_obra_estructura ) == "C") regreso = vtxtVacio(form.txt_obra_estructura_motivo, 'Motivo de descalificacion por la Estructura');
				if( regreso ) regreso = vradVacio(form.rad_obra_muros, 'Muros');
				if( regreso ) if( vradValor( form.rad_obra_muros ) == "C") regreso = vtxtVacio(form.txt_obra_muros_motivo, 'Motivo de descalificacion por los Muros');
				if( regreso ) regreso = vradVacio(form.rad_obra_losas, 'Losas');
				if( regreso ) if( vradValor( form.rad_obra_losas ) == "C") regreso = vtxtVacio(form.txt_obra_losas_motivo, 'Motivo de descalificacion por las Losas');
				if( regreso ) regreso = vradVacio(form.rad_obra_bardas, 'Bardas');
				if( regreso ) if( vradValor( form.rad_obra_bardas ) == "C") regreso = vtxtVacio(form.txt_obra_bardas_motivo, 'Motivo de descalificacion por las Bardas');
				if( regreso ) regreso = vradVacio(form.rad_obra_impermeabilizacion, 'Impermeabilizacion');
				if( regreso ) if( vradValor( form.rad_obra_impermeabilizacion ) == "C") regreso = vtxtVacio(form.txt_obra_impermeabilizacion_motivo, 'Motivo de descalificacion por la impermeabilizacion');
				if( regreso ) regreso = vradVacio(form.rad_inst_hidraulica, 'Hidraulica');
				if( regreso ) regreso = vradVacio(form.rad_inst_sanitaria, 'Sanitaria');
				if( regreso ) regreso = vradVacio(form.rad_inst_electrica, 'Electrica');
				if( regreso ) regreso = vradVacio(form.rad_inst_gas, 'Gas');
				if( regreso ) regreso = vradVacio(form.rad_calidad_funcionalidad, 'Funcionalidad');
				if( regreso ) regreso = vradVacio(form.rad_calidad_edo_conservacion, 'Estado de conservacion');
				if( regreso ) if( vradValor( form.rad_calidad_edo_conservacion ) == "C") regreso = vtxtVacio(form.txt_calidad_edo_conservacion_motivo, 'Motivo de descalificacion por el Estado de conservacion');
				if( regreso ) regreso = vradVacio(form.rad_vida_util_remanente, 'Vida Util Remanente');
				if( regreso ) if( vradValor( form.rad_vida_util_remanente ) == "C") regreso = vtxtVacio(form.txt_vida_util_remanente_motivo, 'Motivo de descalificacion por la Vida Util Remanente');
				if( regreso ) regreso = vradVacio(form.rad_equipo_educacion, 'Educacion');
				if( regreso ) regreso = vradVacio(form.rad_equipo_salud, 'Salud');
				if( regreso ) regreso = vradVacio(form.rad_equipo_abasto, 'Abasto');
				if( regreso ) regreso = vradVacio(form.rad_equipo_recreacion, 'Recreacion');
				if( regreso ) regreso = vradVacio(form.rad_equipo_transporte, 'Transporte');
				if( regreso ) regreso = vradVacio(form.rad_equipo_vigilancia, 'Vigilancia');
				if( regreso ) regreso = vradVacio(form.rad_equipo_recoleccion_basura, 'Recoleccion de Basura');
				if( regreso ) enviar( form, requerimiento);
			}
			pregunto=false;
			}else {
			enviar( form, requerimiento);
			}
			}
			
		}
		
		
		
		//if (confirm('¿Desea omitir el DTC, pulse aceptar sino cancelar?')){ 
     	 	//	 enviar( form, requerimiento);
 			//	 }else{		
			//	cambiarCapa('Datos_DTC');
				//if (vradVacio!=null){	
				//alert(form.rad_restricciones_zona);	
	
	}
	
	
	function guardarAvaluoTerreno( form, requerimiento )
	{
		var regreso;
		
		// Unidad Valuadora
		cambiarCapa('Unidad_Valuadora');
		
		regreso = vtxtVacio(form.txt_clave_avaluo_shf, 'Clave Avaluo Shf');
		if( regreso ) regreso = vtxtLongitudExacta(form.txt_clave_avaluo_shf, 17, 'Clave Avaluo Shf');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_avaluo_uv, 'Clave Avaluo de la Unidad de Valuacion');
		if( regreso ) regreso = vtxtVacio(form.txt_fecha_avaluo, 'Fecha Avaluo');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_unica_vivienda, 'Clave Unica Vivienda');
		//+if( regreso ) if( !vVacio(form.txt_clave_unica_vivienda) ) regreso = vtxtLongitudExacta(form.txt_clave_unica_vivienda, 16, 'Clave Unica Vivienda');
		if( regreso ) regreso = vtxtVacio(form.sel_controlador, 'Controlador');
		if( regreso ) regreso = vtxtVacio(form.sel_perito, 'Perito');
				
		// Vivienda
		if(regreso){
		cambiarCapa('Datos_Vivienda');
		if( regreso ) regreso = vtxtVacio(form.txt_clasificacion_zona, 'Clasificacion Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_referencia_proximidad, 'Referencia de proximidad Urbana');
		if( regreso ) regreso = vtxtVacio(form.sel_clase_inmuebles_zona, 'Clase General de inmuebles en la zona');
		if( regreso ) regreso = vtxtVacio(form.txt_niveles_zona, 'Niveles Zona');
		if( regreso ) regreso = mayorZero(form.txt_niveles_zona, 'Niveles Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_construcciones, 'Uso de Construcciones');
		if( regreso ) if( form.sel_uso_construcciones.value=="5" ) regreso = vtxtVacio(form.txt_uso_construcciones_valor, 'Descripcion Uso de Construcciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_indice_saturacion_zona, 'Indice de Saturacion en la Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_densidad_poblacion, 'Densidad de Poblacion');
		if( regreso ) regreso = vtxtVacio(form.sel_distribucion_agua_potable, 'Distribucion de Agua Potable');
		if( regreso ) regreso = vtxtVacio(form.sel_red_aguas_residuales, 'Red de Recoleccion Aguas Residuales');
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_calle, 'Red Drenaje Pluvial Calle');
		
		
		// Vivienda1
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_zona, 'Red Drenaje Pluvial Zona');
		//if( regreso ) regreso = vtxtVacio(form.txt_sistema_mixto_drenaje, 'Sistema Mixto Drenaje');
		//if( regreso ) regreso = vtxtVacio(form.txt_fosa_septica, 'Fosa Septica');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_electrificacion, 'Suministro Electrificacion');
		if( regreso ) regreso = vtxtVacio(form.sel_electrificacion, 'Electrificacion con Acometida al inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_alumbrado_publico, 'Alumbrado Publico');
		if( regreso ) regreso = vtxtVacio(form.sel_material_vialidades, 'Material de Vialidades');
		if( regreso ) if( form.sel_material_vialidades.value=="6" ) regreso = vtxtVacio(form.txt_material_vialidades_valor, 'Descripcion Material de Vialidades (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_banquetas, 'Material de Banquetas');
		if( regreso ) if( form.sel_material_banquetas.value=="4" ) regreso = vtxtVacio(form.txt_material_banquetas_valor, 'Descripcion Material de Banquetas (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_guarniciones, 'Material de Guarniciones');
		if( regreso ) if( form.sel_material_guarniciones.value=="2" ) regreso = vtxtVacio(form.txt_material_guarniciones_valor, 'Descripcion Material de Guarniciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_nivel_infraestructura, 'Nivel Infraestructura en porcentaje');
		if( regreso ) regreso = vtxtVacio(form.sel_gas_natural, 'Gas Natural');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_telefonico, 'Suministro Telefonico');
//		if( regreso ) regreso = vtxtVacio(form.sel_acometida_inmueble_telefonico, 'Acometida al inmueble telefonico');
		if( regreso ) regreso = vtxtVacio(form.sel_senializacion_vial, 'Señalizacion vial');
		if( regreso ) regreso = vtxtVacio(form.sel_nomenclatura_calles_circundantes, 'Nomenclatura de Calles Circundantes');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_distancia, 'Transporte Urbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_frecuencia, 'Transporte Urbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_distancia, 'Transporte Suburbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_frecuencia, 'Transporte Suburbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.sel_vigilancia, 'Vigilancia');
		if( regreso ) regreso = vtxtVacio(form.sel_recoleccion_desechos, 'Rec. municipal o privada de desechos');
		//if( regreso ) regreso = vtxtVacio(form.chk_equipamiento_urbano?, 'Equipamiento Urbano');
		if( regreso ) if( form.chk_equipamiento_urbano1.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano1, 'Distancia Equipamiento Urbano Iglesia');
		if( regreso ) if( form.chk_equipamiento_urbano2.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano2, 'Distancia Equipamiento Urbano Mercados');
		if( regreso ) if( form.chk_equipamiento_urbano3.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano3, 'Distancia Equipamiento Urbano Plazas publicas');
		if( regreso ) if( form.chk_equipamiento_urbano4.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano4, 'Distancia Equipamiento Urbano Parques y jardines');
		if( regreso ) if( form.chk_equipamiento_urbano5.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano5, 'Distancia Equipamiento Urbano Escuelas');
		if( regreso ) if( form.chk_equipamiento_urbano6.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano6, 'Distancia Equipamiento Urbano Hospitales');
		if( regreso ) if( form.chk_equipamiento_urbano7.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano7, 'Distancia Equipamiento Urbano Bancos');
		if( regreso ) if( form.chk_equipamiento_urbano8.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano8, 'Distancia Equipamiento Estacion de transporte');
		if( regreso ) regreso = vtxtVacio(form.sel_tipo_inmueble_valuado, 'Tipo inmueble valuado');
		if( regreso ) if( form.sel_tipo_inmueble_valuado.value=="5" ) regreso = vtxtVacio(form.txt_tipo_inmueble_valuado_valor, 'Descripcion Tipo inmueble valuado (Otro)');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_vivienda_paquete, 'Numero de vivienda en el paquete');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_reg_conjunto_infonavit, 'Numero de registro conjunto INFONAVIT');
		}
		
		// Inmueble
		if(regreso){
		cambiarCapa('Datos_Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_localidad_poblacion, 'Localidad o poblacion');
		//if( regreso ) regreso = vtxtVacio(form.txt_codigo_postal, 'Codigo Postal');
		if( regreso ) if( !vVacio(form.txt_codigo_postal) ) regreso = vtxtLongitudExacta(form.txt_codigo_postal, 5, 'Codigo Postal');
		//if( regreso ) regreso = vtxtVacio(form.txt_colonia, 'Colonia Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_calle, 'Calle Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_exterior, 'Num. Exterior Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_interior, 'Num. Interior Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_ubicacion, 'Ubicacion del Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_configuracion_inmueble, 'Configuracion del Immueble');
		if( regreso ) regreso = vtxtVacio(form.sel_topografia_inmueble, 'Topografia Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_suelo, 'Uso de Suelo');
//		if( regreso ) regreso = vtxtVacio(form.txt_coeficiente_utilizacion_suelo, 'Coeficiente de Utilizacion de Suelo');
		if( regreso ) regreso = vtxtVacio(form.txt_densidad_habitacional, 'Densidad Habitacional');
		if( regreso ) regreso = vtxtVacio(form.txt_uso_actual, 'Uso Actual');
//		if( regreso ) regreso = vtxtVacio(form.txt_num_recamaras, 'Num. de Recamaras');
//		if( regreso ) regreso = vtxtVacio(form.txt_num_banios, 'Num. de Baños');
//		if( regreso ) regreso = vtxtVacio(form.txt_num_espacios_estacionamiento, 'Num. espacios Estacionamiento');
//		if( regreso ) regreso = vtxtVacio(form.sel_calidad_proyecto, 'Calidad Proyecto');
//		if( regreso ) regreso = vtxtVacio(form.sel_clase_gral_inmueble, 'Clase Gral Inmueble');
//		if( regreso ) regreso = vtxtVacio(form.sel_estado_conservacion, 'Estado Conservacion');
//		if( regreso ) regreso = vtxtVacio(form.txt_edad_contruccion, 'Edad Contruccion');
//		if( regreso ) regreso = vtxtVacio(form.txt_vida_util_remanente, 'Vida Util Remanente');
//		if( regreso ) regreso = vtxtVacio(form.txt_niveles_construccion, 'Niveles de construccion');
		if( regreso ) regreso = vtxtVacio(form.txt_grado_terminacion_obra, 'Grado Terminacion Obra');
		//if( regreso ) regreso = vtxtVacio(form.txt_grado_avance_areas_comunes, 'Grado y Avance Areas Comunes');
		
//		if( regreso ) regreso = vtxtVacio(form.sel_inst_hidraulicas, 'Instalaciones Hidraulicas');
//		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_hidraulicas, 'Material Instalaciones Hidraulicas');
//		if( regreso ) regreso = vtxtVacio(form.sel_inst_sanitarias, 'Instalaciones Sanitarias');
//		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_sanitarias, 'Material Instalaciones Sanitarias');
//		if( regreso ) regreso = vtxtVacio(form.sel_inst_electricas, 'Instalaciones Electricas');
		//if( regreso ) regreso = vtxtVacio(form.sel_elementos_adicionales, 'Elementos Adicionales');
//		if( regreso ) if( form.sel_elementos_adicionales.value=="4" ) regreso = vtxtVacio(form.txt_elementos_adicionales_valor, 'Descripcion Elementos Adicionales (Otro)');
		}
		
		// Terreno
		if(regreso){
		cambiarCapa('Datos_Terreno');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_conjunto, 'Superficie Terreno Conjunto');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_vivienda, 'Superficie Terreno Vivienda');
//		if( regreso ) regreso = vtxtVacio(form.txt_superficie_construida, 'Superficie Construida');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_accesorias, 'Superficie Accesorias');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_vendible, 'Superficie Vendible');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_construccion, 'Indivisos de la Contruccion');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_terreno, 'Indivisos del Terreno');
		}
		
		// Pisos
/*		if(regreso){
		cambiarCapa('Datos_Pisos');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_sala,'Pisos Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_recamaras,'Pisos Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_banio,'Pisos Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_cocina,'Pisos Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_patio_servicio,'Pisos Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_estacionamiento,'Pisos Estacionamiento');
		}
		
		// Muros
		if(regreso){
		cambiarCapa('Datos_Muros');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_sala,'Muros Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_recamaras,'Muros Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_banio,'Muros Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_cocina,'Muros Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_patio_servicio,'Muros Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_estacionamiento,'Muros Estacionamiento');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_fachada,'Muros Fachada');
		}
		
		// Plafones
		if(regreso){
		cambiarCapa('Datos_Plafones');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_sala,'Plafones Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_recamaras,'Plafones Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_banio,'Plafones Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_cocina,'Plafones Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_patio_servicio,'Plafones Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_estacionamiento,'Plafones Estacionamiento');
		}*/
		
		// Avaluo
		if(regreso){
		cambiarCapa('Datos_Avaluo');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_total, 'Valor Comparativo Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_m2, 'Valor Comparativo m2');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_total, 'Valor Terreno Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_m2, 'Valor Terreno M2');
//		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_total, 'Valor Construccion Total');
//		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_m2, 'Valor Construccion M2');
		//if( regreso ) regreso = vtxtVacio(form.txt_valor_residual, 'Valor Residual');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_concluido, 'Valor Concluido');
		}
		
		
			if(regreso){
				enviar( form, requerimiento);
			}
			
			
		}
		
function guardarAvaluoEstudio( form, requerimiento )
	{
		var regreso;
		
		// Unidad Valuadora
		cambiarCapa('Unidad_Valuadora');
		
		regreso = vtxtVacio(form.txt_clave_avaluo_shf, 'Clave del Estudio Valor');
		if( regreso ) regreso = vtxtLongitudExacta(form.txt_clave_avaluo_shf, 17, 'Clave del Estudio Valor de la Unidad Valuadora');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_avaluo_uv, 'Clave Avaluo de la Unidad de Valuacion');
		if( regreso ) regreso = vtxtVacio(form.txt_fecha_avaluo, 'Fecha del Estudio Valor');
		//if( regreso ) regreso = vtxtVacio(form.txt_clave_unica_vivienda, 'Clave Unica Vivienda');
		//+if( regreso ) if( !vVacio(form.txt_clave_unica_vivienda) ) regreso = vtxtLongitudExacta(form.txt_clave_unica_vivienda, 16, 'Clave Unica Vivienda');
		if( regreso ) regreso = vtxtVacio(form.sel_controlador, 'Controlador');
		if( regreso ) regreso = vtxtVacio(form.sel_perito, 'Perito');
				
		// Vivienda
		if(regreso){
		cambiarCapa('Datos_Vivienda');
		if( regreso ) regreso = vtxtVacio(form.txt_clasificacion_zona, 'Clasificacion Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_referencia_proximidad, 'Referencia de proximidad Urbana');
		if( regreso ) regreso = vtxtVacio(form.sel_clase_inmuebles_zona, 'Clase General de inmuebles en la zona');
		if( regreso ) regreso = vtxtVacio(form.txt_niveles_zona, 'Niveles Zona');
		if( regreso ) regreso = mayorZero(form.txt_niveles_zona, 'Niveles Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_construcciones, 'Uso de Construcciones');
		if( regreso ) if( form.sel_uso_construcciones.value=="5" ) regreso = vtxtVacio(form.txt_uso_construcciones_valor, 'Descripcion Uso de Construcciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_indice_saturacion_zona, 'Indice de Saturacion en la Zona');
		if( regreso ) regreso = vtxtVacio(form.sel_densidad_poblacion, 'Densidad de Poblacion');
		if( regreso ) regreso = vtxtVacio(form.sel_distribucion_agua_potable, 'Distribucion de Agua Potable');
		if( regreso ) regreso = vtxtVacio(form.sel_red_aguas_residuales, 'Red de Recoleccion Aguas Residuales');
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_calle, 'Red Drenaje Pluvial Calle');
		
		
		// Vivienda1
		//if( regreso ) regreso = vtxtVacio(form.txt_red_drenaje_pluvial_zona, 'Red Drenaje Pluvial Zona');
		//if( regreso ) regreso = vtxtVacio(form.txt_sistema_mixto_drenaje, 'Sistema Mixto Drenaje');
		//if( regreso ) regreso = vtxtVacio(form.txt_fosa_septica, 'Fosa Septica');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_electrificacion, 'Suministro Electrificacion');
		if( regreso ) regreso = vtxtVacio(form.sel_electrificacion, 'Electrificacion con Acometida al inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_alumbrado_publico, 'Alumbrado Publico');
		if( regreso ) regreso = vtxtVacio(form.sel_material_vialidades, 'Material de Vialidades');
		if( regreso ) if( form.sel_material_vialidades.value=="6" ) regreso = vtxtVacio(form.txt_material_vialidades_valor, 'Descripcion Material de Vialidades (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_banquetas, 'Material de Banquetas');
		if( regreso ) if( form.sel_material_banquetas.value=="4" ) regreso = vtxtVacio(form.txt_material_banquetas_valor, 'Descripcion Material de Banquetas (Otro)');
		if( regreso ) regreso = vtxtVacio(form.sel_material_guarniciones, 'Material de Guarniciones');
		if( regreso ) if( form.sel_material_guarniciones.value=="2" ) regreso = vtxtVacio(form.txt_material_guarniciones_valor, 'Descripcion Material de Guarniciones (Otro)');
		if( regreso ) regreso = vtxtVacio(form.txt_nivel_infraestructura, 'Nivel Infraestructura en porcentaje');
		if( regreso ) regreso = vtxtVacio(form.sel_gas_natural, 'Gas Natural');
		if( regreso ) regreso = vtxtVacio(form.sel_suministro_telefonico, 'Suministro Telefonico');
//		if( regreso ) regreso = vtxtVacio(form.sel_acometida_inmueble_telefonico, 'Acometida al inmueble telefonico');
		if( regreso ) regreso = vtxtVacio(form.sel_senializacion_vial, 'Señalizacion vial');
		if( regreso ) regreso = vtxtVacio(form.sel_nomenclatura_calles_circundantes, 'Nomenclatura de Calles Circundantes');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_distancia, 'Transporte Urbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_urbano_frecuencia, 'Transporte Urbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_distancia, 'Transporte Suburbano Distancia');
		//if( regreso ) regreso = vtxtVacio(form.txt_transporte_suburbano_frecuencia, 'Transporte Suburbano Frecuencia');
		if( regreso ) regreso = vtxtVacio(form.sel_vigilancia, 'Vigilancia');
		if( regreso ) regreso = vtxtVacio(form.sel_recoleccion_desechos, 'Rec. municipal o privada de desechos');
		//if( regreso ) regreso = vtxtVacio(form.chk_equipamiento_urbano?, 'Equipamiento Urbano');
		if( regreso ) if( form.chk_equipamiento_urbano1.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano1, 'Distancia Equipamiento Urbano Iglesia');
		if( regreso ) if( form.chk_equipamiento_urbano2.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano2, 'Distancia Equipamiento Urbano Mercados');
		if( regreso ) if( form.chk_equipamiento_urbano3.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano3, 'Distancia Equipamiento Urbano Plazas publicas');
		if( regreso ) if( form.chk_equipamiento_urbano4.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano4, 'Distancia Equipamiento Urbano Parques y jardines');
		if( regreso ) if( form.chk_equipamiento_urbano5.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano5, 'Distancia Equipamiento Urbano Escuelas');
		if( regreso ) if( form.chk_equipamiento_urbano6.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano6, 'Distancia Equipamiento Urbano Hospitales');
		if( regreso ) if( form.chk_equipamiento_urbano7.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano7, 'Distancia Equipamiento Urbano Bancos');
		if( regreso ) if( form.chk_equipamiento_urbano8.checked) regreso = vtxtVacio(form.txt_distancia_equipamiento_urbano8, 'Distancia Equipamiento Estacion de transporte');
		if( regreso ) regreso = vtxtVacio(form.sel_tipo_inmueble_valuado, 'Tipo inmueble valuado');
		if( regreso ) if( form.sel_tipo_inmueble_valuado.value=="5" ) regreso = vtxtVacio(form.txt_tipo_inmueble_valuado_valor, 'Descripcion Tipo inmueble valuado (Otro)');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_vivienda_paquete, 'Numero de vivienda en el paquete');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_reg_conjunto_infonavit, 'Numero de registro conjunto INFONAVIT');
		}
		
		// Inmueble
		if(regreso){
		cambiarCapa('Datos_Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_localidad_poblacion, 'Localidad o poblacion');
		//if( regreso ) regreso = vtxtVacio(form.txt_codigo_postal, 'Codigo Postal');
		if( regreso ) if( !vVacio(form.txt_codigo_postal) ) regreso = vtxtLongitudExacta(form.txt_codigo_postal, 5, 'Codigo Postal');
		//if( regreso ) regreso = vtxtVacio(form.txt_colonia, 'Colonia Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_calle, 'Calle Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_exterior, 'Num. Exterior Inmueble');
		//if( regreso ) regreso = vtxtVacio(form.txt_num_interior, 'Num. Interior Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_ubicacion, 'Ubicacion del Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_configuracion_inmueble, 'Configuracion del Immueble');
		if( regreso ) regreso = vtxtVacio(form.sel_topografia_inmueble, 'Topografia Inmueble');
		if( regreso ) regreso = vtxtVacio(form.sel_uso_suelo, 'Uso de Suelo');
		if( regreso ) regreso = vtxtVacio(form.txt_coeficiente_utilizacion_suelo, 'Coeficiente de Utilizacion de Suelo');
		if( regreso ) regreso = vtxtVacio(form.txt_densidad_habitacional, 'Densidad Habitacional');
		if( regreso ) regreso = vtxtVacio(form.txt_uso_actual, 'Uso Actual');
		if( regreso ) regreso = vtxtVacio(form.txt_num_recamaras, 'Num. de Recamaras');
		if( regreso ) regreso = mayorZero(form.txt_num_recamaras, 'Num. de Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_num_banios, 'Num. de Baños');
		if( regreso ) regreso = mayorZero(form.txt_num_banios, 'Num. de Baños');
		if( regreso ) regreso = vtxtVacio(form.txt_num_espacios_estacionamiento, 'Num. espacios Estacionamiento');
		if( regreso ) regreso = vtxtVacio(form.sel_calidad_proyecto, 'Calidad Proyecto');
		if( regreso ) regreso = vtxtVacio(form.sel_clase_gral_inmueble, 'Clase Gral Inmueble');
//		if( regreso ) regreso = vtxtVacio(form.sel_estado_conservacion, 'Estado Conservacion');
//		if( regreso ) regreso = vtxtVacio(form.txt_edad_contruccion, 'Edad Contruccion');
//		if( regreso ) regreso = vtxtVacio(form.txt_vida_util_remanente, 'Vida Util Remanente');
		//if( regreso ) regreso = vtxtVacio(form.txt_niveles_construccion, 'Niveles de construccion');
//		if( regreso ) regreso = vtxtVacio(form.txt_grado_terminacion_obra, 'Grado Terminacion Obra');
		//if( regreso ) regreso = vtxtVacio(form.txt_grado_avance_areas_comunes, 'Grado y Avance Areas Comunes');
		
		if( regreso ) regreso = vtxtVacio(form.sel_inst_hidraulicas, 'Instalaciones Hidraulicas');
		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_hidraulicas, 'Material Instalaciones Hidraulicas');
		if( regreso ) regreso = vtxtVacio(form.sel_inst_sanitarias, 'Instalaciones Sanitarias');
		if( regreso ) regreso = vtxtVacio(form.txt_material_inst_sanitarias, 'Material Instalaciones Sanitarias');
		if( regreso ) regreso = vtxtVacio(form.sel_inst_electricas, 'Instalaciones Electricas');
		if( regreso ) regreso = vtxtVacio(form.sel_elementos_adicionales, 'Elementos Adicionales');
		if( regreso ) if( form.sel_elementos_adicionales.value=="4" ) regreso = vtxtVacio(form.txt_elementos_adicionales_valor, 'Descripcion Elementos Adicionales (Otro)');
		}
		
		// Terreno
		if(regreso){
		cambiarCapa('Datos_Terreno');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_conjunto, 'Superficie Terreno Conjunto');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_terreno_vivienda, 'Superficie Terreno Vivienda');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_construida, 'Superficie Construida');
		//if( regreso ) regreso = vtxtVacio(form.txt_superficie_accesorias, 'Superficie Accesorias');
		if( regreso ) regreso = vtxtVacio(form.txt_superficie_vendible, 'Superficie Vendible');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_construccion, 'Indivisos de la Contruccion');
		//if( regreso ) regreso = vtxtVacio(form.txt_indivisos_terreno, 'Indivisos del Terreno');
		}
		
		// Pisos
		if(regreso){
		cambiarCapa('Datos_Pisos');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_sala,'Pisos Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_recamaras,'Pisos Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_banio,'Pisos Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_pisos_cocina,'Pisos Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_patio_servicio,'Pisos Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_pisos_estacionamiento,'Pisos Estacionamiento');
		}
		
		// Muros
		if(regreso){
		cambiarCapa('Datos_Muros');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_sala,'Muros Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_recamaras,'Muros Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_banio,'Muros Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_cocina,'Muros Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_patio_servicio,'Muros Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_muros_estacionamiento,'Muros Estacionamiento');
		if( regreso ) regreso = vtxtVacio(form.txt_muros_fachada,'Muros Fachada');
		}
		
		// Plafones
		if(regreso){
		cambiarCapa('Datos_Plafones');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_sala,'Plafones Sala');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_recamaras,'Plafones Recamaras');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_banio,'Plafones Baño');
		if( regreso ) regreso = vtxtVacio(form.txt_plafones_cocina,'Plafones Cocina');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_patio_servicio,'Plafones Patio Servicio');
		//if( regreso ) regreso = vtxtVacio(form.txt_plafones_estacionamiento,'Plafones Estacionamiento');
		}
		
		// Avaluo
		if(regreso){
		cambiarCapa('Datos_Avaluo');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_total, 'Valor Comparativo Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_comparativo_m2, 'Valor Comparativo m2');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_total, 'Valor Terreno Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_terreno_m2, 'Valor Terreno M2');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_total, 'Valor Construccion Total');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_construccion_m2, 'Valor Construccion M2');
		//if( regreso ) regreso = vtxtVacio(form.txt_valor_residual, 'Valor Residual');
		if( regreso ) regreso = vtxtVacio(form.txt_valor_concluido, 'Valor Concluido');
		}
		
		
			if(regreso){
				enviar( form, requerimiento);
			}
			
			
		}
		
	
	
	
	function guardarAvaluoDTC( form, requerimiento )
	{
		var regreso = false;	
		// Unidad Valuadora
		cambiarCapa('Unidad_Valuadora');		
		regreso = vradVacio(form.rad_id_configuracion_terreno, 'Configuración del Terreno');
		if( regreso ) regreso =	vradVacio(form.rad_id_pendiente_terreno, 'Pendiente del Terreno');		
		if( regreso ) regreso = vradVacio(form.rad_restricciones_zona, 'Restricciones');
		if( regreso ) if( vradValor( form.rad_restricciones_zona ) == "C") regreso = vtxtVacio(form.txt_restricciones_zona_motivo, 'Motivo de descalificacion por Restricciones');		
		if( regreso ) regreso = vradVacio(form.rad_zonas_afectacion, 'Zonas de Afectacion');
		if( regreso ) if( vradValor( form.rad_zonas_afectacion ) == "C") regreso = vtxtVacio(form.txt_zonas_afectacion_motivo, 'Motivo de descalificacion por Zonas de Afectacion');
		if( regreso ) regreso = vradVacio(form.rad_areas_inundables, 'Areas Inundables');
		if( regreso ) if( vradValor( form.rad_areas_inundables ) == "C") regreso = vtxtVacio(form.txt_areas_inundables_motivo, 'Motivo de descalificacion por Areas Inundables');
		if( regreso ) regreso = vradVacio(form.rad_vialidades_pavimentos, 'Pavimentos');
		if( regreso ) regreso = vradVacio(form.rad_vialidades_guarniciones, 'Guarniciones, Banquetas y Andadores');
		if( regreso ) regreso = vradVacio(form.rad_vialidades_accesos, 'Accesos');
		if( regreso ) regreso = vradVacio(form.rad_infra_agua_potable, 'Agua Potable');
		if( regreso ) if( vradValor( form.rad_infra_agua_potable ) == "C") regreso = vtxtVacio(form.txt_infra_agua_potable_motivo, 'Motivo de descalificacion por Agua Potable');
		if( regreso ) regreso = vradVacio(form.rad_infra_drenaje, 'Drenaje');
		if( regreso ) if( vradValor( form.rad_infra_drenaje ) == "C") regreso = vtxtVacio(form.txt_infra_drenaje_motivo, 'Motivo de descalificacion por Drenaje');
		if( regreso ) regreso = vradVacio(form.rad_infra_electrica, 'Energia electrica');
		if( regreso ) if( vradValor( form.rad_infra_electrica ) == "C") regreso = vtxtVacio(form.txt_infra_electrica_motivo, 'Motivo de descalificacion por Energia Electrica');
		if( regreso ) regreso = vradVacio(form.rad_infra_alumbrado_publico, 'Alumbrado Publico');
		//if( regreso ) regreso = vradVacio(form.rad_obra_cimentacion, 'Cimentacion');
		//if( regreso ) if( vradValor( form.rad_obra_cimentacion ) == "C") regreso = vtxtVacio(form.txt_obra_cimentacion_motivo, 'Motivo de descalificacion por la Cimentacion');
		//if( regreso ) regreso = vradVacio(form.rad_obra_estructura, 'Estructura');
		//if( regreso ) if( vradValor( form.rad_obra_estructura ) == "C") regreso = vtxtVacio(form.txt_obra_estructura_motivo, 'Motivo de descalificacion por la Estructura');
		//if( regreso ) regreso = vradVacio(form.rad_obra_muros, 'Muros');
		//if( regreso ) if( vradValor( form.rad_obra_muros ) == "C") regreso = vtxtVacio(form.txt_obra_muros_motivo, 'Motivo de descalificacion por los Muros');
		//if( regreso ) regreso = vradVacio(form.rad_obra_losas, 'Losas');
		//if( regreso ) if( vradValor( form.rad_obra_losas ) == "C") regreso = vtxtVacio(form.txt_obra_losas_motivo, 'Motivo de descalificacion por las Losas');
		//if( regreso ) regreso = vradVacio(form.rad_obra_bardas, 'Bardas');
		//if( regreso ) if( vradValor( form.rad_obra_bardas ) == "C") regreso = vtxtVacio(form.txt_obra_bardas_motivo, 'Motivo de descalificacion por las Bardas');
		//if( regreso ) regreso = vradVacio(form.rad_obra_impermeabilizacion, 'Impermeabilizacion');
		//if( regreso ) if( vradValor( form.rad_obra_impermeabilizacion ) == "C") regreso = vtxtVacio(form.txt_obra_impermeabilizacion_motivo, 'Motivo de descalificacion por la impermeabilizacion');
		//if( regreso ) regreso = vradVacio(form.rad_inst_hidraulica, 'Hidraulica');
		//if( regreso ) regreso = vradVacio(form.rad_inst_sanitaria, 'Sanitaria');
		//if( regreso ) regreso = vradVacio(form.rad_inst_electrica, 'Electrica');
		//if( regreso ) regreso = vradVacio(form.rad_inst_gas, 'Gas');
		//if( regreso ) regreso = vradVacio(form.rad_calidad_funcionalidad, 'Funcionalidad');
		//if( regreso ) regreso = vradVacio(form.rad_calidad_edo_conservacion, 'Estado de conservacion');
		//if( regreso ) if( vradValor( form.rad_calidad_edo_conservacion ) == "C") regreso = vtxtVacio(form.txt_calidad_edo_conservacion_motivo, 'Motivo de descalificacion por el Estado de conservacion');
		//if( regreso ) regreso = vradVacio(form.rad_vida_util_remanente, 'Vida Util Remanente');
		//if( regreso ) if( vradValor( form.rad_vida_util_remanente ) == "C") regreso = vtxtVacio(form.txt_vida_util_remanente_motivo, 'Motivo de descalificacion por la Vida Util Remanente');		
		if( regreso ) regreso = vradVacio(form.rad_equipo_educacion, 'Educacion');
		if( regreso ) regreso = vradVacio(form.rad_equipo_salud, 'Salud');
		if( regreso ) regreso = vradVacio(form.rad_equipo_abasto, 'Abasto');
		if( regreso ) regreso = vradVacio(form.rad_equipo_recreacion, 'Recreacion');
		if( regreso ) regreso = vradVacio(form.rad_equipo_transporte, 'Transporte');
		//if( regreso ) regreso = vradVacio(form.rad_equipo_vigilancia, 'Vigilancia');
		//if( regreso ) regreso = vradVacio(form.rad_equipo_recoleccion_basura, 'Recoleccion de Basura');		
		if( regreso ) enviar( form, requerimiento);
	}
	
	function confirm(resultado){
			
		if(resultado=="OK")
			alert("EL DOCUMENTO SE HA VALIDADO SATISFACTORIAMENTE");
		else if ( resultado == "NO")
			alert("ERROR AL VALIDAR EL DOCUMENTO");

	}
	
	function mayorZero(num,texto){
		var numero = num.value;
		if (numero<1){
				alert("El campo "+texto+" tiene que ser mayor a cero");
				num.focus();
				return false;				
			}
		else
			return true;	
	}