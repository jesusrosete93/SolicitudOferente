/**
 Este script muestra un calendario Dinamico el cual muestra un calendario en pantalla para que el usuario
seleccione una fecha de el y no tenga que teclearla directamente con lo que nos ahorramos las rutinas de
verificacion y con la ventaja de que se puede mostrar en pantalla de una manera y enviarse en el formulario
de otra manera, esto es se puede mostrar en el formato dd-mm-aaaa y enviar como aaaa/mm/dd.

Este script fue tomado de The JavaScript Source!!  en http://javascript.internet.com


*/

//FUNCION QUE CARGA IMAGENES PARA QUE NO SE PUEDA ESTAR APRETANDO EL BOTON MAS D EUNA VEZ, SOLO PARAOGIN	
	
	function cargaElemtoSeleccionado(id,elemento,mensage,imagen)
{
	var mensaje=mensage;
	var div=document.getElementById(elemento);
	
	div.innerHTML='<IMG src="../imagenes/'+imagen+'.gif" height="40" width="40"><font face="Arial" size="2" color="orange"><strong>'+mensaje+'</strong></font>';

}	

// FUNCION QUE CARGA IMAGENES EN LOS JSP PARA QUE SE VEAN CARGANDO, EL JSP NO DEBE DE SER EL DE LOGIN
function cargaElemtoSeleccionado2(id,elemento,contexto,mensage,imagen)
	{
		var mensaje=mensage;

		regreso = checadosParaImagenes(document.frm_avaluos,'Debe seleccionar al menos un avalúo');
		
		if(regreso){
			var td=document.getElementById(elemento);
			td.innerHTML='<IMG src="'+contexto+'/imagenes/'+imagen+'.gif" height="40" width="40"><font face="Arial" size="2" color="orange"><strong>'+mensaje+'</strong></font>';
		}
	}
	
	// FUNCION QUE CARGA IMAGENES EN LOS JSP PARA QUE SE VEAN CARGANDO, en los jsp donde se guarden la vivienda y el terreno
function cargaElemtoParaGuardarVivivendaTerreno(id,elemento,contexto,mensage,imagen)
	{
		var mensaje=mensage;
			var td=document.getElementById(elemento);
			td.innerHTML='<IMG src="'+contexto+'/images/'+imagen+'.gif" height="40" width="40"><font face="Arial" size="2" color="orange"><strong>'+mensaje+'</strong></font>';
	}
	
	