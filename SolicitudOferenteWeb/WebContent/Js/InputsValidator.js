// entrada.js

// esta funcion despliega el erros y le da el foco al elemento.
function mensajeError( elemento, mensaje ) 
	{
		var msj		= 	'  INFONAVIT  \n'
					+	'_________________________________________\n\n'	
					+ 	mensaje + '\n\n'
					+	'_________________________________________\n';						
		alert( msj )
		elemento.focus( );
		return;
	}

 	
 	/**
	 * Creación: 28 Abril 2009
	 * Autor: Adrian Casas
	 * Descripción esta funcion limita la captura de un campo a que sean solo numeros
	 */
	function acceptNum(window,evt)
	{
	 var nav4 = window.Event ? true : false;
	 var key = nav4 ? evt.which : evt.keyCode; 
	 return (key <= 13 || (key >= 48 && key <= 57));
	}
	
	/**
	 * Creación: 25 Octubre 2010
	 * Autor: Adrian Casas
	 * Limita la captura de un campo a numeros y letras.
	 */
	function acceptAlfaNumerico( event, evt )
	{
	 var nav4 = window.Event ? true : false;
	 var key = nav4 ? evt.which : evt.keyCode;
	 return ( ( key >= 97 && key <= 122 ) || ( key >= 65 && key <= 90 ) || ( key >= 48 && key <= 57 ) || key == 32 || key == 46 || key == 38 || key == 35);
	}
	
	/**
	 * Creación: 25 Octubre 2010
	 * Autor: Adrian Casas
	 * Limita la captura de un campo a numeros y letras.
	 */
	function acceptLetras( event, evt )
	{
	 var nav4 = window.Event ? true : false;
	 var key = nav4 ? evt.which : evt.keyCode;
	 return ( ( key >= 97 && key <= 122 ) || ( key >= 65 && key <= 90 ) || key == 32 || key == 46 || key == 38 || key == 35);
	}
	
	
	/**
	 * Creacion: 2010-10-25
	 * Autor: Avansis Desarrollos - Adrian Casas
	 * Valida que el valor del objeto ( caja de texto ) solo tenga numeros
	 * en caso de tener caracteres especiales estos son mostrados al usuario
	 */
	function validarDigito( objeto )
	{
	 var cadena = objeto.value;
	 var re = /\D+/g;
     if( cadena != '' )
     {
      if( cadena.search( re )>=0 )
	  {
		alert( "Los siguientes caracteres no son permitidos: ["+cadena.match( re )+ "], favor de validar" );
		objeto.focus();
		return false;
	  }else
	  {
	    return true;
	  }
     }
	}
	
	
	/**
	 * Creacion: 2010-10-25
	 * Autor: Avansis Desarrollos - Adrian Casas
	 * Valida que el valor del objeto no contenga caracteres especiales
	 */
	function validarAlfaNumerico ( objeto )
	{
	 var cadena = objeto.value;
	 var re = /\W+/g;

     if( cadena != '' )
     {
      if( cadena.search( re )>=0 )
	  {
		alert( "Los siguientes caracteres no son permitidos: [ "+cadena.match( re )+ " ], favor de validar" );
		objeto.focus();
		return false;
	  }else
	  {
	    return true;
	  }
     }
	}
	
    /**
	 * Creacion: 2010-10-25
	 * Autor: Avansis Desarrollos - Adrian Casas
	 * Convierte el valor de un objeto a mayusculas.
	 */
	function upper( objeto )
	{
	 var cadena = objeto.value;
	 if( cadena != '' )
	 {
	    objeto.value= objeto.value.toUpperCase();
	 }
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
			regreso =  true;			
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

// funcion que valida que el una cadena contenga un telefono acepta numeros , -, ,(, )
function vTelefono( cadena )
	{ 
		var longcad;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso =  true;			
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

// funcion que valida que el una cadena contenga un telefono acepta numeros , -, ,(, )
function vTelefono( cadena )
	{ 
		var longcad;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso =  true;			
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
			regreso =  true;			
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

// funcion que valida que una cadena tenga almenos un numero o una letra
function contrasenaValida( cadena )
	{ 
		var longcad;
		var tope;
		var t;
		var regreso;
			longcad = cadena.length;
			regreso =  false;			
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
			regreso =  true;			
			for( i = 0 ; i <= longcad - 1 ; i++ )
				{
					t = cadena.charAt( i );
					if( !( ( t >= "A" && t <= "Z" ) || ( t >= "a" && t <= "z" ) || ( t == "á" ) || ( t == "é" ) || 
						   ( t == "í" ) || ( t == "ó" ) || ( t == "ú" ) || ( t == "ñ" ) || ( t == "Ñ" ) || ( t == " " )) )
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

// verifica que el texto en un textbox tenga un alongitud determinada
function longitudMenorIgual( cadena, longitud )
	{
		var regreso;
			regreso = false;
			if ( cadena.length <= longitud )
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

//Funcion que valida una cadena con un RFC bien foprmado XXXX999999XXX

function vRFC( cadena )
	{ 
		var txt_rfc_pf 		= /([a-z]|[A-Z]|(Ñ-ñ)){4}[0-9][0-9][0-1][0-9][0-3][0-9]/;
		var txt_rfc_pf_hc 	= /([a-z]|[A-Z]|(Ñ-ñ)){4}[0-9][0-9][0-1][0-9][0-3][0-9]([0-9]|[(a-z)|(A-Z)|(Ñ-ñ)]){3}/;	
		var regreso;
		
		regreso = vNoEspacios( cadena );
		
		if( regreso )
			if( cadena.lenght < 10 )
					regreso = false;
		if( regreso )
			if( !vLetras( cadena.substr( 0, 4 ) ) )
					regreso = false;
		if( regreso )
			if( !vNumeros( cadena.substr( 4, 6 ) ) )
					regreso = false;
		if( regreso && ( !txt_rfc_pf.test( cadena ) || !txt_rfc_pf.test( cadena ) )  )
			regreso = false;
						
		return regreso;
	}

//Funcion que valida que un textbox tenga una RFC bien formado.

function vtxtRFC( cajaTexto )
	{ 
		var	mensaje		=	' R.F.C. no valido.:\n\n'+
							'  El  RFC  necesita el siguiente formato.\n\n'+
							'  ejemplo: ABCD780228ABC ó ABCD780228 \n\n'+
							'  Favor de verificar la información';	
		var regreso;
			regreso = true;
			if( cajaTexto.value != '' )
				if( !vRFC( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, mensaje );
				}
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
function vtxtAlfa2( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vAlfaNumerico2( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, "Caracter invalido " );
				}
			return regreso;
	}

// funcion que solo valida que el textbox acepte solo numeros
function vtxtNumero( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vNumeros( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, " Caracter invalido. \n\n  * No use letras ni signos de puntuación" );
				}
			return regreso;
	}

// funcion que valida que el textbox acepte un numero telefonico separaro por espacios o guiones 
// y que permita el uso de parentesis para la lada
function vtxtTelefono( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vTelefono( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, " Caracter invalido. \n\n  * No use letras ni signos de puntuación" );
				}
			return regreso;
	}

// funcion que valida que el textbox tenga numero de letras
function vtxtLongitudExacta( cajaTexto, longitud )
	{ 
		var regreso;
			regreso = false;
			if( longitudExacta( cajaTexto.value, longitud ) )
				{
					regreso = true;
				}
			else mensajeError( cajaTexto, "La longitud debe ser de " + longitud + " caracteres." );
			
			return regreso;
	}
	
// funcion que valida que el textbox tenga numero de letras
function vtxtLongitudMenorIgual( cajaTexto, longitud )
	{ 
		var regreso;
			regreso = false;
			if( longitudMenorIgual( cajaTexto.value, longitud ) )
				{
					regreso = true;
				}
			else mensajeError( cajaTexto, "La longitud debe ser de " + longitud + " caracteres." );
	}
			
		

// funcion que valida que el textbox acepte solo letras
function vtxtLetra( cajaTexto )
	{ 
		var regreso;
			regreso = true;
			if( !vLetras( cajaTexto.value ) )
				{
					regreso = false;
					mensajeError( cajaTexto, " Caracter invalido. \n\n  * No use números ni signos de puntuación" );
				}
			return regreso;
	}
	
// funcion que valida que el textbox no acepte espacios
function  vtxtEspacios( cajaTexto )
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
		var regreso 		= true;

						regreso = vtxtVacio( form.txt_nombre, 	"Nombre" );
		if( regreso )	regreso = vtxtLetra( form.txt_nombre );	


		if( regreso && form.txt_paterno.value.length>0	)
		{
			if( regreso )	regreso = vtxtVacio( form.txt_paterno,	"Apellido Paterno" );
			if( regreso )	regreso = vtxtLetra( form.txt_paterno );		
		}	 		
		 
		if( regreso && form.txt_materno.value.length>0	)
		{
			if( regreso )	regreso = vtxtVacio( form.txt_materno,	"Apellido Materno" );
			if( regreso )	regreso = vtxtLetra( form.txt_materno );		
		}

		if( regreso && form.txt_paterno.value.length==0 && form.txt_materno.value.length==0 )
		{
			regreso		=	false;
			mensajeError( form.txt_paterno, "Debe capturar un Apellido, no pueden ser vacios." );
		}

 		if( regreso )	regreso = vtxtVacio( form.txt_correo_e ,"Correo-e" );
		if( regreso )	regreso = vtxtCorreoE( form.txt_correo_e );				
			
		if( regreso )	regreso = vtxtVacio( form.txt_telefono, "Teléfono" );
		if( regreso )	regreso = vtxtTelefono( form.txt_telefono );	

		if( regreso )	regreso = vtxtVacio( form.txt_rfc , 	"R.F.C." );			
		if( regreso )	regreso = vtxtRFC( form.txt_rfc );
		
		if( regreso )	regreso = vtxtVacio	( form.txt_curp , 	"C.U.R.P." );
		if( regreso )	regreso = vtxtLongitudExacta( form.txt_curp, 18 );
		
		if( regreso )	regreso = validaPerfil	( form );

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
				regreso = vtxtCorreoE( form.txt_correo_e );
		//	if ( regreso )
		//		regreso = vtxtRFC( form.txt_rfc );				
			if( regreso && form.txt_curp.value.length > 0 )
			{
				if( regreso )	regreso = vtxtVacio	( form.txt_curp , 	"C.U.R.P." );			
				if( regreso )	regreso = vtxtLongitudExacta( form.txt_curp, 18 );		
			}

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
				regreso = vtxtLongitudMenorIgual( form.txt_clave, 10 );			
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
		var regreso = true;
		
		if ( form.pwd_clave_anterior.value == '' )
		{
			regreso = false;
			mensajeError( form.pwd_clave_anterior, "Escriba la contraseña actual" ) ;
		}
		if( regreso )			regreso = vtxtLongitudExacta( form.pwd_clave_anterior, 8 );
		if( regreso )			regreso = vtxtContrasena( form.pwd_clave_anterior );
		if( regreso )
			if ( form.pwd_clave.value == '' )
				{
					regreso = false;
					mensajeError( form.pwd_clave,	"La nueva contraseña no puede ser vacia" ) ;
				}
		if( regreso )			regreso = vtxtLongitudExacta( form.pwd_clave, 8 );
		if( regreso )			regreso = vtxtContrasena( form.pwd_clave );
		if( regreso )
			if( form.pwd_clave.value != form.pwd_confirmacion.value )
				{
					mensajeError( form.pwd_clave,	"La confirmacion de contraseña no es correcta."  ) ;
					regreso = false;		
				}
		if( regreso )
			if( form.pwd_clave.value == form.pwd_clave_anterior.value )
				{
					mensajeError( form.pwd_clave,	"La nueva contraseña debe ser distinta de su contraseña actual."  ) ;
					regreso = false;		
				}
		if( regreso )
			if( form.pwd_clave.value == form.claveOperador.value )
				{
					mensajeError( form.pwd_clave,	"La nueva contraseña debe ser distinta de su clave de operador."  ) ;
					regreso = false;		
				}
				
		return regreso;		
	}
	
	//	OCULTA O MUESTRA  SOBRE  ID EN OBJETOS
	function oculta_o_muestra(  ID_A_OCULTAR  ) 
	{
		var	obj		= document.getElementById( ID_A_OCULTAR );
		
		if(obj.style.display == '') 	obj.style.display 	= 'none';
		else 							obj.style.display 	= '';
	}

	//valida k el perfil de asesor certificado cambiara la informacion por la obtenida de la base de datos
	function validaPerfil( form )
	{	
		var		mensaje		=	'';
		var		salida		=	false;
		
        if( form.slc_perfil.value == '' )
        {
    		mensaje	=	' Debe seleccionar un PERFIL para el usuario.\n';
    		mensajeError( form.slc_perfil , mensaje );
        } 
        else
        if( form.slc_perfil.value == 'OCIINSCR' && form.txt_curp.value=='') // Operador asesor certificado
        {
    		mensaje	=	'\t******   I M P O R T A N T E  ****** \n\n'
    				+	' Este PERFIL requiere el CURP para validarlo en el \n'
    				+	'  - Sistema de Asesores Certificados ( SAC )\n\n'
    				+	' El CURP validado incluira el Nombre y Apellidos que existan en SAC.'
    				;        
        	mensajeInfonavit( mensaje );
        }
        else
        {
        	salida	=	true;
        }
        
        return 	salida;
	}
	
	// esta funcion despliega el erros y le da el foco al elemento.
	function mensajeInfonavit( mensaje ) 
	{
			var msj		= 	'  INFONAVIT  \n'
						+	'________________________________________________\n\n'	
						+ 	mensaje + '\n\n'
						+	'________________________________________________\n';						
			alert( msj );
	}	