// encapsula las funciones de java script para la consulta de avaluos.


// habilita y deshabilita los campos de entrada cuando se selecciona Clave SHF como entrada.
// recibe el formulario con las cajas de texto de entrada.
function seleccionarSHF( form )
	{
		form.shf.value 				= "";
		form.apellido.value 		= "";
		form.rfc.value 				= "";
		form.shf.disabled			= "";
		form.apellido.disabled		= "disabled";
		form.rfc.disabled			= "disabled";
		form.shf.focus( );
	}
// habilita y deshabilita los campos de entrada cuando se selecciona Clave Apellido como entrada.
// recibe el formulario con las cajas de texto de entrada.
function seleccionarApellido( form )
	{
		form.shf.value 				= "";
		form.apellido.value 		= "";
		form.rfc.value 				= "";
		form.shf.disabled			= "disabled";
		form.apellido.disabled		= "";
		form.rfc.disabled			= "disabled";
		form.apellido.focus( );
	}
// habilita y deshabilita los campos de entrada cuando se selecciona Clave RFC como entrada.
// recibe el formulario con las cajas de texto de entrada.
function seleccionarRFC( form )
	{
		form.shf.value 				= "";
		form.apellido.value 		= "";
		form.rfc.value 				= "";
		form.shf.disabled			= "disabled";
		form.apellido.disabled		= "disabled";
		form.rfc.disabled			= "";
		form.rfc.focus( );
	}
// valida la entrada de datos para la consulta de avaluos, dependiendo de la entrada de datos seleccionada	
// recibe el formulario con las cajas de texto de entrada y el radio boton de la selleccion de campo.
// devuelva true si la entrada es valida, false en caso contrario y muestra un mensaje con el error en al entrada de datos
function validarEntrada( form, requerimiento )
	{
	
		var regreso;
			if( form.apellido.disabled && form.rfc.disabled )
				{
					
					regreso = validarSHF( form.shf );
				}
			else if ( form.shf.disabled && form.rfc.disabled )
				{
					
					regreso = validarApellido( form.apellido );
				}
			else
				{
					
					regreso = validarRFC( form.rfc );
				}
		
		if( regreso ) enviar( form, requerimiento);
	}


//valida que el RFC no este vacio 
// recibe la caja de texto con el rfc
// devuelva true si la entrada es valida, false en caso contrario y muestra un mensaje descriptivo del error.

function validarRFC( rfc )
	{
		
		var regreso;
			regreso = false;
			if( vtxtVacio( rfc, " rfc " ) )
				{
					regreso = true;
				}
		return regreso;
	}


//valida que el Apellido no este vacio y no contenga caracteres especiales
// recibe la caja de texto con el apellido
// devuelva true si la entrada es valida, false en caso contrario y muestra un mensaje descriptivo del error.

function validarApellido( apellido )
	{
		
		var regreso;
			regreso = false;
			if( vtxtVacio( apellido, " Apellido " ) )
				{
					if( vtxtAlfa2( apellido, " Apellido " ) )
						{
							regreso = true;
						}
				}
		return regreso;
	}


//valida que la clave shf sean de 7 posiciones y sea numerico
// recibe la caja de texto con la clave shf.
// devuelva true si la entrada es valida, false en caso contrario y muestra un mensaje descriptivo del error.

function validarSHF( shf )
	{
	
		var regreso;
			regreso = false;
			if( vtxtLongitudExacta( shf, 7, " SHF " ) )
				{
					if( vtxtNumero( shf, " SHF " ) )
						{
							regreso = true;
						}
				}
		return regreso;
	}

//envia la peticion para hacer la consulta de avaluos.
//recibe un formulario con el que se hace el reenvio para hecer la consulta de avaluo.
function reenviarResultado( form )
	{
		var padre;
		var paquete;
		var vivienda;
		var avaluo;
			padre 		= window.opener;
			paquete		= padre.document.form_consultas.txt_paquete.value;
			vivienda 	= padre.document.form_consultas.txt_vivienda.value;
			avaluo	 	= padre.document.form_consultas.txt_avaluo.value;
			form.id_paquete.value	= paquete;
			form.id_vivienda.value	= vivienda;
			form.id_avaluo.value	= avaluo;
			form.submit( );
	}
	

function checar( form, requerimiento )
    {

        var f1;
        var f2;
        var aux;
        var aux1;
        var index = 1;
        var mensaje;
        var regreso;
        var checaP;
	        mensaje = "";
        	aux   	= "";
        	aux1  	= "";
			regreso = true;

 	           index 	= document.frm_menuCambioSolicitados.slc_uv.selectedIndex;	           
	           mensaje 	= "Debe elegir una unidad valuadora";
	           if( index == 0 )
			    	regreso = false;
 	           
 	           if(regreso){
	 	           index 	= document.frm_menuCambioSolicitados.busquedaCambio.selectedIndex;
		           mensaje 	= "Debe elegir un Cambio a Buscar";
		           if( index == 0 )
						regreso = false;
				}
			
 
	    if( regreso ) 
	    	enviar( form, requerimiento);
		else
			alert( mensaje );			
        return regreso;
	}

function validar_tipo_vivienda( )
	{
		if(document.frm_ro_mai_3.tipo_vivienda.value == "nueva" || document.frm_ro_mai_3.tipo_vivienda.value == "Seleccione una Opcion"){
			document.frm_ro_mai_3.num_notario.value 			= "";
			document.frm_ro_mai_3.nombre_notario.value 		= "";
			document.frm_ro_mai_3.plaza.value 				= "";
			document.frm_ro_mai_3.escritura.value			= "";
			document.frm_ro_mai_3.libro.value				= "";
			document.frm_ro_mai_3.volumen.value				= "";
			
			document.frm_ro_mai_3.num_notario.disabled		= "disabled";
			document.frm_ro_mai_3.nombre_notario.disabled	= "disabled";
			document.frm_ro_mai_3.plaza.disabled 			= "disabled";
			document.frm_ro_mai_3.escritura.disabled			= "disabled";
			document.frm_ro_mai_3.libro.disabled				= "disabled";
			document.frm_ro_mai_3.volumen.disabled			= "disabled";
			
		}
		else if(document.frm_ro_mai_3.tipo_vivienda.value == "usada"){
			document.frm_ro_mai_3.num_notario.value 			= "";
			document.frm_ro_mai_3.nombre_notario.value 		= "";
			document.frm_ro_mai_3.plaza.value 				= "";
			document.frm_ro_mai_3.escritura.value			= "";
			document.frm_ro_mai_3.libro.value				= "";
			document.frm_ro_mai_3.volumen.value				= "";
			
			document.frm_ro_mai_3.num_notario.disabled		= "";
			document.frm_ro_mai_3.nombre_notario.disabled	= "";
			document.frm_ro_mai_3.plaza.disabled 			= "";
			document.frm_ro_mai_3.escritura.disabled			= "";
			document.frm_ro_mai_3.libro.disabled				= "";
			document.frm_ro_mai_3.volumen.disabled			= "";
			
			document.frm_ro_mai_3.num_notario.focus( );
		}
		
	}
	
	
function validar_cuentasBancarias( form )
	{
		
		if( form.cuentasBancarias.value ==  "Seleccione una Cuenta" ){
			
			document.getElementById('marca').disabled		= "disabled";
			form.num_factura.disabled						= "disabled";
			
		}
		else{
			document.getElementById('marca').disabled		= "";
			form.num_factura.disabled						= "";
		}
		
	}	
	