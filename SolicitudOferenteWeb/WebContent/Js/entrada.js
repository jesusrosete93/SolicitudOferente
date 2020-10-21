// entrada.js
// funcion que habilita la caja de texto para capturar una colonia

function validar_slc_colonia(form) {
	if (form.slc_colonia.value == '99999') {
		form.colonia.disabled="";
		form.colonia.value="";
		form.colonia.select(); 
		form.colonia.focus();
	}
	else {
		form.colonia.value="-----";
		form.colonia.disabled="disabled";
	}
}
// esta funcion despliega el erros y le da el foco al elemento.
function mensajeError( elemento, mensaje ) 
	{
		alert( mensaje );
		elemento.focus( );
		return;
	}
function convertirAMayusculas( form )
	 {
	 		var regreso;
			regreso = true;
		form.value = form.value.toUpperCase();
	 }
// esta funcion Cambia las letras de un campo a mayusculas
function getMayusculas( )
	 {
		 if( event.keyCode == 241 )
		 event.keyCode = 209
		 if( event.keyCode >= 97 && event.keyCode <= 122 ) 
		 event.keyCode = event.keyCode - 32;
		 if ( ( event.keyCode > 35 && event.keyCode < 46 ) || ( event.keyCode == 47 ) ||
		 	 ( event.keyCode > 57 && event.keyCode < 65 ) ||
		 ( event.keyCode < 32 ) || ( event.keyCode > 90 && event.keyCode < 209) || (event.keyCode == 33 ) ||
		 ( event.keyCode > 209 ) )
		 	event.returnValue = false;

	 }

	
//Funcion que valida una cadena alfanum con mayusculas,minusc, numeros, y letras con acento
//no acepta puntos ni comas.

function vAlfaNumerico( cadena )
	{ 
		var regreso;
		var longcad;							
		var t;
			longcad		= cadena.length;
			regreso 	= true;
			for( i = 0; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( ( t >= "A" && t <= "Z" ) || ( t >= "a" && t <= "z" ) || ( t >= 0 && t <= 9 ) || 
						 ( t == "á" ) || ( t == "é" ) || ( t == "í" ) || ( t == "ó" ) || ( t == "ú" ) || 	
						 ( t == "Á" ) || ( t == "É" ) || ( t == "Í" ) || ( t == "Ó" ) || ( t == "Ú" ) || 	
						 ( t == "ñ" ) || ( t == "Ñ" ) ) )
							{
								regreso = false;
								break;
							}
				}
			return regreso;
	}

//funcion que valida una cadena con letras may u minusc, numeros y tambien puntos, comas, etc.
//validar direcciones.
function vAlfaNumerico2( cadena )
	{ 
		var longcad;
		var regreso;
		var t;
			longcad = cadena.length;
			regreso = true;
			for( i=0; i<= longcad-1; i++ )
				{
					t = cadena.charAt( i );
					if( !( ( t >= "A" && t <= "Z" ) || ( t >= "a" && t <= "z" ) || ( t >= 0 && t <= 9 ) || 
							( t == "á" ) || ( t == "é" ) || ( t == "í" ) || ( t == "ó" ) || ( t == "ú" ) || 
							( t == "Á" ) || ( t == "É" ) || ( t == "Í" ) || ( t == "Ó" ) || ( t == "Ú" ) || 	
							( t == "ñ" ) || ( t == "Ñ" ) || ( t == "." ) || ( t == "," ) || ( t == ";" ) || 
							( t == "#" ) || ( t == "-" ) || ( t == "_" ) ) )
							{
								regreso = false
								break;
							}
				}
		return regreso;
	}

// funcion que solo valida que el textbox acepte solo numeros
function vNumeros( cadena )
	{ 
		var longcad;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso = true;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( t >= 0 && t <= 9 ) || ( t == " " ))
						{
							regreso = false;
							break; 
					 	}
				}
		return regreso;
	}

// funcion que solo valida que el textbox acepte solo numeros con decimales
function vNumerosDecimales( cadena, enterosValidos, decimalesValidos )
	{ 
		var longcad;
		var t;
		var regreso;
		var iPunto;
		var enterosCadena;
		var decimalesCadena;
			longcad = cadena.length;
			regreso = true;
			hayPunto = false;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( t >= 0 && t <= 9 ) && (t != ".") )
						{
							regreso = false;
							break; 
					 	}
				}
			
			iPunto = cadena.indexOf(".");
			if (iPunto > -1){
				if (cadena.indexOf(".", iPunto+1) > -1){
					regreso = false;
				}
				else{
					enterosCadena = cadena.substring(0, iPunto).length;
					decimalesCadena = cadena.substring(iPunto+1).length;
					if(enterosCadena > enterosValidos)	regreso = false;
					else if(decimalesCadena > decimalesValidos)	regreso = false;
					else if(decimalesCadena==0)	regreso = false;
				}
			}
			else{
				if(longcad > enterosValidos)	regreso = false;
			}
			
		if(cadena == 100) regreso = true;
		
		return regreso;
		
	}

// funcion que valida que el una cadena contenga un telefono acepta numeros , -, ,(, )
function vTelefono( cadena )
	{ 
		var longcad;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso = true;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( ( t >= 0 && t <= 9 ) || ( t == " " ) || ( t == "(" ) || ( t == ")" ) || ( t == "-" ) ) )
						{
							regreso = false;
							break; 
					 	}
				}
		return regreso;
	}
// funcion que en una cadena no existan espacios
function vNoEspacios( cadena )
	{ 
		var longcad;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso = true;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( t == " " )
						{
							regreso = false;
							break; 
					 	}
				}
		return regreso;
	}
// funcion para validar la entrada de el cambio de contarseña.
function validaCambioContrasena2( form )
{
			var 	regreso	 	= 	false;
			
				regreso 	= 	vtxtVacio( form.usuario	, " * Usuario. " );
			if ( regreso )
				regreso 	= 	vtxtVacio( form.pwd_clave_anterior	, " * Contraseña anterior. " );				
			if( regreso )
				regreso 	= 	vtxtVacio( form.pwd_clave			, " * Nueva contraseña. " );				
			if( regreso )
				regreso 	= 	vtxtVacio( form.pwd_confirmacion	, " * Confirmar contraseña. " );
	
			if( regreso )
				regreso 	= 	vtxtLongitudExacta( form.pwd_clave_anterior	, 8, "Contraseña anterior" );
			if( regreso )
				regreso 	= 	vtxtLongitudExacta( form.pwd_clave			, 8, "Nueva contraseña" );
			if( regreso )
				regreso 	= 	vtxtLongitudExacta( form.pwd_confirmacion	, 8, "Confirmar contraseña" );
	
			if( regreso )
			{
				if( form.pwd_clave.value == form.pwd_clave_anterior.value )
				{
					mensajeError( form.pwd_clave , 'La Nueva contraseña debe ser DIFERENTE de la actual.' );
					regreso 	= 	false;
				}
				else if( form.pwd_clave.value != form.pwd_confirmacion.value )
				{
					mensajeError( form.pwd_clave , 'La Nueva contraseña y su confirmación NO son IGUALES."' );
					regreso 	= 	false;
				}
				else
				{
					regreso 	= 	contrasenaValida2( form.pwd_clave.value, form.usuario.value );
				}
			}
	
		return regreso;		
}
function contrasenaValida2( cadena, usuario )
{ 
		var longcad		=	0;
		var t			= 	'';
		var mensaje		= 	'';
		var regreso		= 	false;
		var unaMayus	= 	false;
		var	unaMinus	= 	false;
		var	unaNumero	= 	false;
		
		longcad = cadena.length;
	
		//	VALIDA AL MENOS UNA MAYUSCULA, UNA MINUSCULA, UN NUMERO.	
		for( i = 0 ; i <= longcad - 1 ; i++ )
		{
			t = cadena.charAt( i );
			
			if( ( t >= "A" && t <= "Z" ) || ( t=="Á" )|| ( t=="É" )|| ( t=="Í" )|| ( t=="Ó" )|| ( t=="Ú" )|| ( t=="Ñ" )	)
			{
				if(!unaMayus)	unaMayus	=	true;
				else			continue; 
			}
			if( ( t >= "a" && t <= "z" ) || ( t=="á" )|| ( t=="é" )|| ( t=="í" )|| ( t=="ó" )|| ( t=="ú" )|| ( t=="ñ" )	)	
			{	
				if(!unaMinus)	unaMinus	=	true;
				else			continue; 
			}
			if(  t >= 0 && t <= 9  )
			{
				if(!unaNumero)	unaNumero	=	true;
				else			continue; 
			}
		}
		
		if(	unaMayus && unaMinus && unaNumero )
		{	
			//	VALIDA AL MENOS UNA MAYUSCULA, UNA MINUSCULA, UN NUMERO.
				regreso		=	true;
			//	VALIDA QUE NO TENGA DATOS PERSONALES LA CONTRASEÑA
				if( regreso )	regreso	=	validaNoDatosPersonales( cadena , usuario );		
		}
		else
		{
			//	MUESTRA MENSAJE DE LO QUE NO CUMPLE LA CONTRASEÑA 
				regreso		=	false;
				mensaje		=	'La Nueva contraseña NO cumple con : \n';
				if(	!unaMayus )		mensaje += '\n * al menos una Mayúscula.';
				if(	!unaMinus )		mensaje += '\n * al menos una Minúscula.';
				if(	!unaNumero )	mensaje += '\n * al menos un  Número.';
				mensajeInfonavit ( mensaje );
		} 
	
		//alert ( 'Contraseña correcta : ' + regreso );
	
		return regreso;	
}
function validaNoDatosPersonales( cadena , usuario )
{
		var regreso		= 	false;
		var mensaje		= 	'';
	
		regreso	=	cadenaConPatron( cadena , usuario );
		if(regreso)
		{
			regreso	=	false;	
			mensaje	+=	 '\n * No debe usar su CLAVE DE USUARIO en la contraseña. ' ;
		}
	
		usuario	=	usuario.substr	( 2, usuario.length );
		regreso	=	cadenaConPatron	( cadena , usuario );
		if(regreso)
		{
			regreso	=	false;	
			mensaje	+=	 '\n * No debe usar PARTE DE SU CLAVE DE USUARIO en la contraseña. ' ;
		}
		if(!regreso && mensaje.length>0)
		{
			mensajeInfonavit( mensaje );
		}
		else
		{
		//	CONTRASEÑA SIN DATOS PERSONALES COMO ESTEN ALMACENADOS EN BD
			regreso	=	true;	
		}
	
		return regreso;	
}
function cadenaConPatron( cadGrande , patron )
{
		var	cg	=	''	+ cadGrande;
		var cc	=	''	+ patron;
		var	aux		=	-1;
		var	regreso	=	false;
	
		aux		=	cg.indexOf( cc );
	
		if( aux >=0 )	regreso = true;
	
		return regreso;
}
function mensajeInfonavit( mensaje ) 
{
			var msj		= 	'  INFONAVIT  \n'
						+	'________________________________________________\n\n'	
						+ 	mensaje + '\n\n'
						+	'________________________________________________\n';						
			alert( msj );
}	
// funcion que valida que una cadena tenga almenos un numero o una letra
function contrasenaValida( cadena )
	{ 
		var longcad;
		var tope;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso = false;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( ( t >= "A" && t <= "Z" ) || ( t >= "a" && t <= "z" ) || ( t == "á" ) || ( t == "é" ) || 
						 ( t == "í" ) || ( t == "ó" ) || ( t == "ú" ) || ( t == "ñ" ) || ( t == "Ñ" ) ||
						 ( t >= 0 && t <= 9 ) )
						{
							regreso = true;
							break; 
					 	}
				}
		return regreso;
		alert (regreso);
	}


// funcion que valida que el textbox acepte solo letras
function vLetras( cadena )
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

// verifica que el texto en un textbox tenga un alongitud determinada
function longitudExacta( cadena, longitud )
	{
		var regreso;
			regreso = false;
			if ( cadena.length == longitud )
				regreso = true;
		return regreso;
	}

//Funcion que valida una cadena con una direccion de correo

function vCorreoE( cadena )
	{ 
		var regreso;
		var aux;
			regreso = vNoEspacios( cadena );
			if( regreso )
				{
					aux = cadena.indexOf( "@" );
					if( ( aux == -1 ) || ( aux == 0 ) )	
						regreso = false;
				}
			if( regreso )
				{
					aux = cadena.lastIndexOf( "." );
					if( ( aux == -1 ) || ( aux == ( cadena.length - 1 ) ) )
						regreso = false;
				}
		return regreso;
	}

//Funcion que valida una cadena con un RFC bien foprmado XXXX9999

function vRFC( cadena )
	{ 
		var regreso;
		var aux;
			regreso = vNoEspacios( cadena );
			if( regreso )
				if( cadena.lenght < 10 )
						regreso = false;
			if( regreso )
				if( !vLetras( cadena.substr( 0, 3 ) ) )
						regreso = false;
			if( regreso )
				if( !vNumeros( cadena.substr( 4, 6 ) ) )
						regreso = false;
		return regreso;
	}

//Funcion que regresa true si un textbox está vacío.

function vVacio( cajaTexto )
	{ 
		var regreso;
			regreso = false;
			if( cajaTexto.value == ''  )
				{
					regreso = true;
				}
			return regreso;
	}

//Funcion que valida que un textbox tenga una RFC bien formado.

function vtxtRFC( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			//if( cajaTexto.value != '' )
				//if( !vRFC( cajaTexto.value ) )
				//	{
					//	regreso = false;
					//	mensajeError( cajaTexto, "R.F.C. no valido." );
					//}
			return regreso;
	}



//Funcion que valida que un textbox trenga una direccion de e-mail.

function vtxtCorreoE( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( cajaTexto.value != '' )
				{
					if( !vCorreoE( cajaTexto.value ) )
						{
							regreso = false;
							mensajeError( cajaTexto, "Dirección de correo no valida." );
						}
				}
			return regreso;
	}

//Funcion que valida que un textbox tenga almenos un numero o una letra.

function vtxtContrasena( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !contrasenaValida( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "La contraseña debe contener almenos una letra o un numero." );
				}
			return regreso;
	}


//Funcion que valida que un textbox no etse vacio.

function vtxtVacio( cajaTexto, nombre )
	{ 
		var regreso;
			regreso = true;
			if( cajaTexto.value == '' )
				{
					regreso = false;
					mensajeError( cajaTexto, "El campo " + nombre +" no puede ser vacio." );
				}
			return regreso;
	}

//Funcion que valida que se haya seleccionado una opción de un select (combo box).

function vselNoSeleccion( select, nombre )
	{ 
		var regreso;
			regreso = true;
			if( select.value == '' )
				{
					regreso = false;
					mensajeError( select, "Debe seleccionar un " + nombre +"." );
				}
			return regreso;
	}

//Funcion que valida que un grupo de radios no esté vacio.

function vradVacio( grupoRadio, nombre )
	{ 
		var regreso;
			regreso = false;
			for(i=0;i<grupoRadio.length;i++)
        		if(grupoRadio[i].checked) regreso=true;
			
			if( !regreso )
				{
					mensajeError( grupoRadio[0], "El campo " + nombre +" no puede ser vacio." );
				}
			return regreso;
	}

//Funcion que regresa el valor seleccionado de un grupo de radios.

function vradValor( grupoRadio )
	{ 
		var regreso;
			regreso = null;
			for(i=0;i<grupoRadio.length;i++)
        		if(grupoRadio[i].checked) regreso = grupoRadio[i].value;
			
			return regreso;
	}


//Funcion que un textbox acepte mayusculas,minusc, numeros, y letras con acento
//no acepta puntos ni comas.

function vtxtAlfa( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vAlfaNumerico( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "Caracter invalido " );
				}
			return regreso;
	}

//funcion que valida un textbox acepta letras may u minusc, numeros y tambien puntos, comas, etc.
//validar direcciones.
function vtxtAlfa2( cajaTexto, desc_campo )
	{ 
		var regreso;
			regreso = true;
			if( !vAlfaNumerico2( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "Caracter invalido en " + desc_campo);
				}
			return regreso;
	}

// funcion que solo valida que el textbox acepte solo numeros
function vtxtNumero( cajaTexto, desc_campo )
	{ 
		var regreso;
			regreso = true;
			if( !vNumeros( cajaTexto.value ) )
				{
					mensajeError( cajaTexto, "Caracter invalido en " + desc_campo);
					regreso = false;
				}
			return regreso;
	}

// funcion que solo valida que el textbox acepte un numero con decimales
function vtxtNumeroDecimal( cajaTexto, enteros, decimales, desc_campo )
	{ 
		var regreso;
			regreso = true;
			if( !vNumerosDecimales( cajaTexto.value, enteros, decimales ) )
				{
					mensajeError( cajaTexto, "Caracter invalido o formato incorrecto en " + desc_campo);
					regreso = false;
				}
			return regreso;
	}

// funcion que valida que el textbox acepte un numero telefonico separaro por espacios o guiones 
// y que permita el uso de parentesis para la lada
function vtxtTelefono( cajaTexto, desc_campo )
	{ 
		var regreso;
			regreso = true;
			if( !vTelefono( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "Catacter invalido en " + desc_campo);
				}
			return regreso;
	}

// funcion que valida que el textbox tenga numero de letras
function vtxtLongitudExacta( cajaTexto, longitud, desc_campo )
	{ 
			var regreso;
			regreso = false;
			if( longitudExacta( cajaTexto.value, longitud ) )
				{
					regreso = true;
				}
			else
				{
					mensajeError( cajaTexto, "La longitud de " + desc_campo + " debe ser de " + longitud + " caracteres." );
				}
			return regreso;
	}
	

// funcion que valida que el textbox acepte solo letras
function vtxtLetra( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vLetras( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "Caracter invalido." );
				}
			return regreso;
	}
	
// funcion que valida que el textbox no acepte espacios
function vtxtEspacios( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vNoEspacios( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "No debe contener espacios." );
				}
			return regreso;
	}	
	
//funcion para hacer que cuando se escoja un tregistro de un combo, se habilite un text.
function comboHabilitaTextbox( combo, clave, cajaTexto )
	{
		if( combo.value == clave )
			{
				cajaTexto.disabled 	= false;
				cajaTexto.value		= "";
				cajaTexto.focus( );
			}
		else
			{
				cajaTexto.disabled 	= true;
				cajaTexto.value		= "------";
			}
	}

// veerifica que se elija almenos un checkbox
function checados( form ) 
	{
		var regreso;
		var i;
		var elementos;
			regreso		= false;
			elementos 	= form.elements;
			for ( i=0 ; i < elementos.length ; i++ ) 
				{
					if ( elementos[ i ].type == "checkbox" )
						{
							if ( elementos[ i ].checked )
								{
									regreso = true;
									break;
								}
						}
				}
			if( !regreso )
				alert( "Debe seleccionar facultades para el perfil." );
				
		return regreso;
	}


// funcion para validar la entradaa de los datos de un usuario.
function entradaUsuario( form )
	{
		var regreso;
			regreso = true;
			regreso = vtxtVacio( form.txt_nombre, "Nombre" );
			if( regreso )
				regreso = vtxtVacio( form.txt_paterno, "Apellido Paterno" );
			if( regreso )
				regreso = vtxtVacio( form.txt_materno, "Apellido Materno" );
			if( regreso )
				if( form.slc_sLaboral.value == "SLIN" )
					{
						regreso = vtxtVacio( form.txt_nomina, "Numero de nomina" );
						if ( regreso )
							regreso = vtxtLongitudExacta( form.txt_nomina, 6 );
						if ( regreso )
							regreso = vtxtNumero( form.txt_nomina );
					}
				else regreso = vtxtVacio( form.txt_rfc, "R.F.C." );
			if( regreso )
				regreso = vtxtLetra( form.txt_nombre );
			if ( regreso )
				regreso = vtxtLetra( form.txt_paterno );
			if ( regreso )
				regreso = vtxtLetra( form.txt_materno );
			if ( regreso )
				regreso = vtxtTelefono( form.txt_telefono );
			if ( regreso )
				regreso = vtxtCorreoE( form.txt_mail );
			if ( regreso )
				regreso = vtxtRFC( form.txt_rfc );
		return regreso;
		
	}
// funcion para validar la entradaa de los datos de un usuario.
function entradaUsuarioCambio( form )
	{
		var regreso;
			regreso = true;
			regreso = vtxtVacio( form.txt_nombre, "Nombre" );
			if( regreso )
				regreso = vtxtVacio( form.txt_paterno, "Apellido Paterno" );
			if( regreso )
				regreso = vtxtVacio( form.txt_materno, "Apellido Materno" );
			if( regreso )
				regreso = vtxtLetra( form.txt_nombre );
			if ( regreso )
				regreso = vtxtLetra( form.txt_paterno );
			if ( regreso )
				regreso = vtxtLetra( form.txt_materno );
			if ( regreso )
				regreso = vtxtTelefono( form.txt_telefono );
			if ( regreso )
				regreso = vtxtCorreoE( form.txt_mail );
			if ( regreso )
				regreso = vtxtRFC( form.txt_rfc );
		return regreso;
		
	}
// funcion para validar la entrada de nombre autorizao y de as facultades de un perfil.
function validaFacultades( form )
	{
		var regreso;
			regreso = true;
			if ( form.txt_autorizo.value == '' )
				{
					regreso = false;		
					mensajeError( form.txt_autorizo, "El campo Persona que Autoriza no puede ser vacio." );
				}
			if( regreso )
				regreso = vtxtAlfa2( form.txt_autorizo );		
			if ( regreso )
				regreso = checados( form );
			if( regreso )
				noPadres( );
		return regreso;		
	}

// funcion para validar la entrada de el nombre y la descripcion de una aplicacion, modulo y facultad.
function validaNombreDescripcion( form )
	{
		var regreso;
			regreso = vtxtAlfa2( form.txt_nombre );
			if ( regreso )
				regreso = vtxtAlfa2( form.txt_descripcion );
		return regreso;
			
	}
	
// funcion para validar la entrada de la clave de una aplicacion, modulo y facultad.
function validaClave( form )
	{
		var regreso;
			regreso = true;
			regreso = vtxtVacio( form.txt_clave, "Clave" );
			if ( regreso )
				regreso = vtxtLongitudExacta( form.txt_clave, 4 );			
			if ( regreso )
				regreso = vtxtEspacios( form.txt_clave );
			if( regreso )
				regreso = vtxtAlfa2( form.txt_clave );
		return regreso;		
	}

// funcion para validar la entrada de los de una aplicacion, modulo y facultad.
function validaAlta( form )
	{
		var regreso;
			regreso = true;
			regreso = validaClave( form );
			if ( regreso )
				regreso = validaNombreDescripcion( form );			
		return regreso;		
	}

// funcion para validar la entrada de los datos en un alta de perfil.
function validaAltaPerfil( form )
	{
		var regreso;
			regreso = true;
			regreso = validaAlta( form );
			if( regreso )
				regreso = validaFacultades( form );		
		return regreso;		
	}
// funcion para validar la entrada de los datos en un cambio de perfil.
function validaCambioPerfil( form )
	{
		var regreso;
			regreso = true;
			regreso = validaNombreDescripcion( form );
			if( regreso )
				regreso = validaFacultades( form );		
		return regreso;		
	}
// funcion para validar la entrada de el cambio de contarseña.
function validaCambioContrasena( form )
	{
		alert("aqui");
		var regreso;
			regreso = true;
			
			if ( form.usuario == '' )
				{
					regreso = false;
					alert( "Escriba su nombre de Usuario" );
				}
			if( regreso ){			
				regreso = vtxtLongitudExacta( form.usuario, 8 );	
				if(!regreso)
				   alert( "El usuario debe ser de 8 caracteres" );
			}
				
			if ( form.pwd_clave_anterior.value == '' )
				{
					regreso = false;
					alert( "Escriba la contraseña actual" );
				}
			if( regreso ){
				regreso = vtxtLongitudExacta( form.pwd_clave_anterior, 8 );
				if(!regreso)
				   alert( "La contraseña debe ser de 8 caracteres" );
				
			}
			if( regreso )
				regreso = vtxtContrasena( form.pwd_clave_anterior );
			if ( form.pwd_clave.value == '' )
				{
					regreso = false;
					alert( "La nueva contraseña no puede ser vacia" );
				}
			if( regreso ){
				regreso = vtxtLongitudExacta( form.pwd_clave, 8 );
				regreso = vtxtLongitudExacta( form.pwd_clave_anterior, 8 );
				if(!regreso)
				   alert( "La nueva contraseña debe ser de 8 caracteres" );
			}
			if( regreso )
				regreso = vtxtContrasena( form.pwd_clave );
			if( regreso )
				if( form.pwd_clave.value != form.pwd_confirmacion.value )
					{
						alert( "La confirmacion de contraseña no es correcta." );
						regreso = false;		
					}
		return regreso;	
		
		
		
	var message='No disponible';
	function clickIE() {
		if (document.all) {
		alert(message);return false;
			}
			}
	function clickNS(e) {
	if(document.layers||(document.getElementById&&!document.all)) {
		if (e.which==2||e.which==3) 
		{alert(message);return false;}}}
		if (document.layers){
			document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;}
		else{
			document.onmouseup=clickNS;document.oncontextmenu=clickIE;}
			document.oncontextmenu=new Function('return false')
			
	}
	
function enviarFiltros( accion, form, pertenencia ) 
		{

			if (document.FiltrosForm.buscarPaquete.checked==true && document.FiltrosForm.idpaquete.value==""){
				alert ("Debe ingresar  un número de paquete");
				return false;
			}
			var longuitud = longitudExacta(document.FiltrosForm.idpaquete.value, 16)
			if (document.FiltrosForm.buscarPaquete.checked==true && longuitud == false){
				alert ("La longuitud del paquete debe ser de 16 posiciones");
				return false;
			}
			var numerico = vNumeros(document.FiltrosForm.idpaquete.value);
			if (numerico == false){
				alert("Solo debe ingresar números en el paquete");
				return false;
			}
				
			//FIN VALIDAR OPCIONES DE ACUERDO A PERFIL

			document.FiltrosForm.tipo_busqueda.value=document.getElementById('tipoBusqueda').value;

			document.getElementById('FiltrosForm').action = accion;

			FiltrosForm.submit( );
		}
		
	function enviarFiltrosReporte( accion, form, pertenencia ) 
		{

			//FIN VALIDAR OPCIONES DE ACUERDO A PERFIL
alert("accion:"+accion);
			document.getElementById('FiltrosForm').action = accion;

			FiltrosForm.submit( );
		}	

function enviarModificarVivienda( )
	{
		
		if (document.FiltrosForm.idavaluo.value==""){
			alert ("Debe ingresar  un número de avaluo");
			return false;
			}
			
		var longuitud = longitudExacta(document.FiltrosForm.idavaluo.value, 17)
			if (longuitud == false){
				alert ("La longuitud del avaluo debe ser de 17 posiciones");
				return false;
			}
	
		var numerico = vNumeros(document.FiltrosForm.idavaluo.value);
			if (numerico == false){
				alert("Solo debe ingresar números en el avaluo");
				return false;
			}
			
		document.FiltrosForm.id_avaluo.value = document.getElementById('idavaluo').value;
		FiltrosForm.submit( );
	}
	
			
		
function habilitar_deshabilitar(form,banderaTipoBusqueda, opcion, tipoBusqueda, pertenencia){


// Si banderaTipoBusqueda = 2			, se busca por paquete
// Si banderaTipoBusqueda = 3			, se busca por avaluo
// Si opcion			  = AUV o RUV	, se modifica el name del boton
	tipo_busqueda = document.getElementById('tipoBusqueda').value=tipoBusqueda;
	if (opcion == 'AUV'){
		document.FiltrosForm.btnConsultar.value="Asignar";
	}
	
	else if (opcion == 'RUV'){
		document.FiltrosForm.btnConsultar.value="Reasignar";
	}
	else if (opcion == 'CAS' || opcion == 'CAC'){
		document.FiltrosForm.btnConsultar.value="Consultar";
		document.FiltrosForm.buscarAvaluo.disabled=false;
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarFecha.disabled=false;
	}else if (opcion == 'CAE'){
		document.FiltrosForm.btnConsultar.value="Consultar";
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarFecha.disabled=true;
	}else if (opcion == 'CACN'){
		document.FiltrosForm.btnConsultar.value="Consultar";
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarFecha.disabled=true;
	
	}else if (opcion == 'SOPCERR' || opcion == 'SOPCANC'){
		document.FiltrosForm.btnConsultar.value="Consultar";
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarFecha.disabled=false;
	}
	if (banderaTipoBusqueda == 2){
		document.FiltrosForm.btnConsultar.disabled=false;
		document.FiltrosForm.idpaquete.disabled=false;
		if (pertenencia == "JAT" || pertenencia == "GVI" || opcion == "SOPCERR" || opcion == "SOPCANC"){
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.iduv.disabled=false;
		}else if(pertenencia == "UV" && opcion == "CAE"){
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.iduv.disabled=true;
		}else if(pertenencia == "UV" && opcion == "CACN"){
		document.FiltrosForm.buscarPaquete.disabled=false;
		document.FiltrosForm.buscarAvaluo.disabled=true;
		document.FiltrosForm.iduv.disabled=true;
		}else {
		document.FiltrosForm.buscarAvaluo.disabled=false;
		document.FiltrosForm.iduv.disabled=true;
		}
		document.FiltrosForm.idavaluo.disabled=true;
		document.FiltrosForm.idavaluo.value="";
		document.FiltrosForm.idpaquete.focus();
		document.FiltrosForm.fechaInicio.disabled=true;
		document.FiltrosForm.fechaInicio.value="";
		document.FiltrosForm.fechaFin.disabled=true;
		document.FiltrosForm.fechaFin.value="";
		document.FiltrosForm.calendarioInicio.disabled=true;
		document.FiltrosForm.clearInicio.disabled=true;
		document.FiltrosForm.calendarioFin.disabled=true;
		document.FiltrosForm.clearFin.disabled=true;
		document.FiltrosForm.buscarFecha.checked=false;
		document.FiltrosForm.buscarAvaluo.checked=false;
	}
	if (banderaTipoBusqueda == 3){
		document.FiltrosForm.btnConsultar.disabled=false;
		document.FiltrosForm.idavaluo.disabled=false;
		document.FiltrosForm.idpaquete.disabled=true;
		document.FiltrosForm.idpaquete.value="";
		document.FiltrosForm.idavaluo.focus();
		document.FiltrosForm.iduv.disabled=true;
		document.FiltrosForm.fechaInicio.disabled=true;
		document.FiltrosForm.fechaInicio.value="";
		document.FiltrosForm.fechaFin.disabled=true;
		document.FiltrosForm.fechaFin.value="";
		document.FiltrosForm.calendarioInicio.disabled=true;
		document.FiltrosForm.clearInicio.disabled=true;
		document.FiltrosForm.calendarioFin.disabled=true;
		document.FiltrosForm.clearFin.disabled=true;
		document.FiltrosForm.buscarFecha.checked=false;
		document.FiltrosForm.buscarPaquete.checked=false;
	}
	if (banderaTipoBusqueda == 4){
		document.FiltrosForm.btnConsultar.disabled=false;
		document.FiltrosForm.idpaquete.disabled=true;
		if (pertenencia == "JAT" || pertenencia == "AGVI" || opcion == "SOPCERR" || opcion == "SOPCANC"){
			document.FiltrosForm.buscarAvaluo.disabled=true;
		}else{
			document.FiltrosForm.buscarAvaluo.disabled=false;
		}
		document.FiltrosForm.idavaluo.disabled=true;
		document.FiltrosForm.idavaluo.value="";
		document.FiltrosForm.idpaquete.value="";
		if ( pertenencia == "UV" ){
			document.FiltrosForm.iduv.disabled=true;
		}
		else{
			document.FiltrosForm.iduv.disabled=false;
		}
		document.FiltrosForm.fechaInicio.disabled=false;
		document.FiltrosForm.fechaFin.disabled=false;
		document.FiltrosForm.calendarioInicio.disabled=false;
		document.FiltrosForm.clearInicio.disabled=false;
		document.FiltrosForm.calendarioFin.disabled=false;
		document.FiltrosForm.clearFin.disabled=false;
		document.FiltrosForm.buscarPaquete.checked=false;
		document.FiltrosForm.buscarAvaluo.checked=false;
	}
	
	
	function enviarBusqueda( accion ) 
	{
		alert ("Function...");	
		alert("Action  1 :"+document.getElementById('FiltrosForm').action.value);
		document.getElementById('FiltrosForm').action = accion;

		FiltrosForm.submit( );
		
	}
}

	