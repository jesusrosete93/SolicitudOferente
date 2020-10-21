/**
 Este script muestra un calendario Dinamico el cual muestra un calendario en pantalla para que el usuario
seleccione una fecha de el y no tenga que teclearla directamente con lo que nos ahorramos las rutinas de
verificacion y con la ventaja de que se puede mostrar en pantalla de una manera y enviarse en el formulario
de otra manera, esto es se puede mostrar en el formato dd-mm-aaaa y enviar como aaaa/mm/dd.

Este script fue tomado de The JavaScript Source!!  en http://javascript.internet.com

 
*/

//Primero las Variables Globales para que el calendario pueda funcionar correctamente
var  diasFinDeSemana = [0,6];
var  colorDiasFinDeSemana = "#D20000";
var  tipoFuente = "Tahoma";
var tamanioFuente = "2"

//Obtenemos la fecha del sistema
var fechaActual = new Date();

//La variable que contiene el calendario, la usamos para poder imprimir el mismo.
var ventanaCalendario;

//Que tipo de navegador estamos usando?
isNav = (navigator.appName.indexOf("Netscape") != -1) ? true : false;
isIE = (navigator.appName.indexOf("Microsoft") != -1) ? true : false;

//Definimos los meses del calendario
Calendario.mesesCalendario = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio","Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

//Definimos los dias de cada mes de acuerdo a si el año es bisiesto o no
Calendario.diasDelMes = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
Calendario.diasDelMesBis = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];


//Definimos la clase calendario, esta se encarga de generar el contenido del calendario
//Tenemos su constructor.
function Calendario(p_item, p_WinCal, pMesMostrado, anioMostrado, formatoFecha) {

	//Si no especificamos el mes y el año no podemos construir el calendario
	if ((pMesMostrado == null) && (anioMostrado == null))	{
		return;
	}

	//Si todavia no se ha construido un objeto calendario asigmos el mismo
	if (p_WinCal == null)  {
		this.gWinCal = ventanaCalendario;
	}
	else {
		this.gWinCal = p_WinCal;
	}
	//Si no se especifica un mes, entonces el calendario consta de 12 meses
	if (pMesMostrado == null)  {
		this.gMonthName = null;
		this.gMonth = null;
		this.gYearly = true;
	}
	 else {
		this.gMonthName = Calendario.obtenMes(pMesMostrado);
		this.gMonth = new Number(pMesMostrado);
		this.gYearly = false;
	}

	//Asignamos los valores iniciales a las propiedades de mi objeto.
	//Aunque las definitivas se asignan mas adelante en el codigo.
	this.gYear = anioMostrado;
	this.gFormat = formatoFecha;
	this.gBGColor = "white";
	this.gFGColor = "black";
	this.gTextColor = "black";
	this.gHeaderColor = "black";
	this.gReturnItem = p_item;
}

//Asignamos los metodos de mi objeto
Calendario.obtenMes = obtenMesCalendario;
Calendario.obtenDiasDelMes = obtenDiasMesCalendario;
Calendario.calculaMesDelAnio = calculaMesAnioCalendario;
Calendario.imprime = imprimeCalendario;

//Definimos los metodos.
//Este metodo regresa el mes indicado en el paramentro, ya que el objeto establecio un arreglo con los nombres de los
//meses
function obtenMesCalendario(monthNo) {
	return Calendario.mesesCalendario[monthNo];
}

/*
Obtenemos los dias de cada mes dependiendo si el anio es bisiesto o no, los dias de los meses estan establecidos en
dos arreglos diferentes los cuales indican el numero de dias en cada caso.

Los criterios para saber si una año es bisiesto son:

		1. Todos los años que los cuales su division entre cuatro es entera, exepto por
			a.	De estos si division entre 100 es entera no son bisiestos exepto por:
					i. Si su division entre 400 es entera si es bisiesto:

Ejemplos:

 El año 1900 si lo divido entre 4 el resultado es 475 por lo tanto es bisiesto, pero si el año lo divido entre 100 el resultado
 es 190 por lo tanto no es bisiesto y  ademas dividido entre 400 es igual a 4.75 por lo que confirma que no es bisiesto.

  El año 2000 si lo divido entre 4 el resultado es 500 por lo tanto es bisiesto, pero si el año lo divido entre 100 el resultado
  es 200 por lo tanto no es bisiesto pero  ademas dividido entre 400 es igual a 5 por lo tanto es bisiesto.
	*/
function obtenDiasMesCalendario(monthNo, anioMostrado) {
	if ((anioMostrado % 4) == 0)  {
		if ((anioMostrado % 100) == 0 && (anioMostrado % 400) != 0)  {
			//El ano es divisible entre 100 pero no entre 400, es normal
			return Calendario.diasDelMes[monthNo];
		}
		else {
			//El anio es divisibles entre 100 y entre 400, es bisiesto
			return Calendario.diasDelMesBis[monthNo];
		}
	}
	else {
		//El anio no es divisible entre 4 por lo que es normal
		return Calendario.diasDelMes[monthNo];
	}
}

/*
Cuando llegamos al principio del anio dentro del calendario y damos regresar un mes automaticamente estamos en el
anio anterior por lo que hay que determinar si estamos en un anio bisiesto o no, de igual manera sucede si estamos en
el final del anio y damos adelantar un mes por lo que automaticamente estamos en otro anio y hay que hacer los mismos
calculos.
Recibe como parametros el anio en el  que se encuentra y el mes asi como el incremento que puede ser -1/1
*/
function calculaMesAnioCalendario(pMesMostrado, anioMostrado, incr) {

	var ret_arr = new Array();

	// Regresamos un mes
	if (incr == -1) {
		//Si el mes es enero
		if (pMesMostrado == 0) {
			ret_arr[0] = 11; // El nuevo mes es diciembre
			ret_arr[1] = parseInt(anioMostrado) - 1; //y por lo tanto es el anio anterior
		}
		//Si es cualquier otro mes solo decrementamos el mes
		else {
			ret_arr[0] = parseInt(pMesMostrado) - 1;
			ret_arr[1] = parseInt(anioMostrado);
		}
	}
	//Adelantamos un mes
	else if (incr == 1)  {
		//Si el mes es Diciembre
		if (pMesMostrado == 11) {
			ret_arr[0] = 0; //El siguiente mes es Enero
			ret_arr[1] = parseInt(anioMostrado) + 1; //del siguiente anio
		}
		//Si es cualquier otro mes, solo adelantamos el mes
		else {
			ret_arr[0] = parseInt(pMesMostrado) + 1;
			ret_arr[1] = parseInt(anioMostrado);
		}
	}
	//regresamos el mes y el anio
	return ret_arr;
}

/* La siguiente funcion solo tiene el animo de imprimir el calendario en caso de que sea ¿necesario?
*/
function imprimeCalendario() {
	ventanaCalendario.print();
}

// Esta linea es para tener compatibilidad con Navigator 3,
//we have to create and discard one object before the prototype object exists.
new Calendario();

/*
Esta funcion se encarga de generar el cuerpo del calendario, es decir, solo los dias que componen
el mes asi como el encabezado que muestra el nombre de los dias
*/
Calendario.prototype.getMonthlyCalendarCode = function() {
	var vCode = "";
	var vHeader_Code = "";
	var vData_Code = "";

	// El codigo de la  tabla comienza aqui...
	//Esta linea mostrara el color de fondo, recordar que el lugar donde se personaliza es mas
	//adelante.
	vCode = vCode + "<table border=\"0\" bgcolor=\"" + this.gBGColor + "\">" ;
	//vCode = vCode + "<table border=\"0\" bgcolor=\"#DCDCDC\">";

	//Ponemos el mes
	vHeader_Code = this.cal_header();
	//Despues los dias del mes
	vData_Code = this.cal_data();
	vCode = vCode + vHeader_Code + vData_Code;
	//Cerramos la tabla
	vCode = vCode + "</table>";

	return vCode;
}

Calendario.prototype.show = function()  {
	var vCode = "";

	this.gWinCal.document.open();

	// Comienza la pagina...
	this.wwrite("<html>");
	this.wwrite("<head><title>Selecciona la Fecha</title>");
	this.wwrite("<script language=\"JavaScript\" type=\"text/javascript\">");
	this.wwrite("<!--");
	this.wwrite("function changefocus(){");
	this.wwrite("window.focus(); }");
	this.wwrite("window.onload = changefocus;");
	this.wwrite("window.onblur = changefocus;");
	this.wwrite("//-->");
	this.wwrite("</script>");
	this.wwrite("</head>");
	this.wwrite("<body " +
		"link=\""  + this.gLinkColor + "\" " +
		"vlink=\"" + this.gLinkColor + "\" " +
		"alink=\"" + this.gLinkColor + "\" " +
		"text=\""  + this.gTextColor + "\">");
	this.wwrite("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"white\" ><tr><td align=\"center\">");
	this.wwriteA("<font size=\"+1\" face=\"" + tipoFuente + "\" size=\""+ tamanioFuente + "\"><b>");
	this.wwriteA(this.gMonthName + " " + this.gYear);
	this.wwriteA("<\/b></td></tr></table>");

	// Mostramos los elementos de navegacion del calendario
	var prevMMYYYY = Calendario.calculaMesDelAnio(this.gMonth, this.gYear, -1);
	var prevMM = prevMMYYYY[0];
	var prevYYYY = prevMMYYYY[1];

	var nextMMYYYY = Calendario.calculaMesDelAnio(this.gMonth, this.gYear, 1);
	var nextMM = nextMMYYYY[0];
	var nextYYYY = nextMMYYYY[1];

	//Aqui podemos disponer el calendario de dos formas distintas:
	//Podemos poner la navegacion abajo del calendario o entre el mes y los dias del calendario.

	//Codigo de Siempre visible function changefocus(){   window.focus(); } window.onload = changefocus; window.onblur = changefocus;

	//Estas dos lineas generan el resto del calendario
	// Obtenemos el resto del calendario.
	vCode = this.getMonthlyCalendarCode();
	this.wwrite(vCode);

	//Agregamos un pequenio espacio
	this.wwrite("<br/ >");
	//Construimos la barra de navegacion, obs no debe haber espacios entre las imagenes
	this.wwrite("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"white\" ><tr><td align=\"center\">");
	//Un mes anterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" + this.gReturnItem + "', '" + prevMM  + "', '"
							 + prevYYYY + "', '" + this.gFormat + " ' );\">" +
							// "<img width=\"50\" height=\"31\" border=\"0\" src=\"..\/imagenes\/REGRESA2.gif\" title=\"Mes Anterior\"  ><\/a></td><td align=\"center\">");
							"<img width=\"50\" height=\"31\" border=\"0\" src=\"\/avaluos\/imagenes\/REGRESA2.gif\" title=\"Mes Anterior\"  ><\/a></td><td align=\"center\">");
	//Un anio anterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" + this.gReturnItem + "', '" + this.gMonth + "', '"
							 + (parseInt(this.gYear)-1) + "', '" + this.gFormat +  	" ' );" +
							 //"\"><img width=\"41\" height=\"31\" border=\"0\" src=\"..\/imagenes\/ANTANIO2.gif\"  title=\"Año Anterior\"  ><\/a></td><td align=\"center\">");
							"\"><img width=\"41\" height=\"31\" border=\"0\" src=\"\/avaluos/imagenes\/ANTANIO2.gif\"  title=\"Año Anterior\"  ><\/a></td><td align=\"center\">");
	//Un anio Posterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" + this.gReturnItem + "', '" + this.gMonth + "', '"
							 + (parseInt(this.gYear)+1) + "', '" + this.gFormat +" ' );" +
							 //"\"><img border=\"0\" width=\"41\" height=\"31\" src=\"..\/imagenes\/SIGANIO2.gif\" title=\"Siguiente Año\"  ><\/a></td><td align=\"center\">");
							 "\"><img border=\"0\" width=\"41\" height=\"31\" src=\"\/avaluos/imagenes\/SIGANIO2.gif\" title=\"Siguiente Año\"  ><\/a></td><td align=\"center\">");
	//Un mes posterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" +this.gReturnItem + "', '" + nextMM + "', '"
							 + nextYYYY + "', '" + this.gFormat + " ' );\">" +
							 //"<img border=\"0\" width=\"50\" height=\"31\" src=\"..\/imagenes\/ADELANTA2.gif\" title=\"Siguiente Mes\"  ><\/a></td></tr></table><br />");
							 "<img border=\"0\" width=\"50\" height=\"31\" src=\"\/avaluos\/imagenes\/ADELANTA2.gif\" title=\"Siguiente Mes\"  ><\/a></td></tr></table><br />");

	//O podemos ponerlo aqui

	this.wwrite("</body></html>");
	this.gWinCal.document.close();
}

//Al parecer la siguiente funcion tiene el proposito de funcionar como capa en vez de ventana.
Calendario.prototype.showY = function() {
	var vCode = "";
	var i;
	var vr, vc, vx, vy;			// Row, Column, X-coord, Y-coord
	var vxf = 285;				// X-Factor
	var vyf = 200;				// Y-Factor
	var vxm = 10;			// X-margin
	var vym;					// Y-margin
	if (isIE)	 {
		vym = 75;
	}
	else if (isNav) {
		vym = 25;
	}
	this.gWinCal.document.open();

	this.wwrite("<html>");
	this.wwrite("<head><title>Calendario</title>");
	this.wwrite("<style type='text/css'>\n<!--");
	for (i=0; i<12; i++) {
		vc = i % 3;
		if (i>=0 && i<= 2)	vr = 0;
		if (i>=3 && i<= 5)	vr = 1;
		if (i>=6 && i<= 8)	vr = 2;
		if (i>=9 && i<= 11)	vr = 3;

		vx = parseInt(vxf * vc) + vxm;
		vy = parseInt(vyf * vr) + vym;

		this.wwrite(".lclass" + i + " {position:absolute;top:" + vy + ";left:" + vx + ";}");
	}
	this.wwrite("-->\n</style>");
	this.wwrite("</head>");

	this.wwrite("<body link=\"" + this.gLinkColor + "\"vlink=\"" + this.gLinkColor + "\" " +
								"alink=\"" + this.gLinkColor + "\" text=\"" + this.gTextColor + "\">");
	this.wwrite("<font face='" + tipoFuente + "' size=\"" + tamanioFuente + "\"><b>");
	this.wwrite("A&ntilde;o: " + this.gYear);
	this.wwrite("</b><br />");

	// Show navigation buttons
	var prevYYYY = parseInt(this.gYear) - 1;
	var nextYYYY = parseInt(this.gYear) + 1;

	this.wwrite("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"'#e0e0e0\" ><tr><td align=\"center\">");
	//Un año anterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" + this.gReturnItem + "',  null , '"
							 + prevYYYY + "', '" + this.gFormat + " ' );\">" +
							 "<img width=\"50\" height=\"31\" border=\"0\" src=\"..\/Imagenes\/prev.gif\" title=\"Año Anterior\"  ><\/a></td><td align=\"center\">");
	//Imprime, es conveniente guardar el mismo formato
	this.wwrite("<a href=\"javascript:window.print();\">" +
							"<img border=\"0\" width=\"41\" height=\"31\" src=\"..\/Imagenes\/impresora.gif\"  title=\"Imprime el calendario\"  ></a></td><td align=\"center\">");
	//Un año posterior
	this.wwrite("<a href=\"javascript:window.opener.Build('" +this.gReturnItem + "', null , '"
							 + nextYYYY + "', '" + this.gFormat + " ' );\">" +
							 "<img border=\"0\" width=\"50\" height=\"31\" src=\"..\/Imagenes\/next.gif\"><\/a></td></tr></table><br />");

	//Obtenemos la descripcion de cada mes, pero como estamos trabajando con capas debemos de emplear la
	//sintaxis adecuada de acuerdo a cada navegador.
	var j;
	for (i=11; i>=0; i--) {
		if (isIE)
			this.wwrite("<div id=\"layer" + i + "\" class=\"lclass" + i + "\">");
		else if (isNav)
			this.wwrite("<layer id=\"layer" + i + "\" class=\"lclass" + i + "\">");

		this.gMonth = i;
		this.gMonthName = Calendario.obtenMes(this.gMonth);
		vCode = this.getMonthlyCalendarCode();
		this.wwrite(this.gMonthName + "/" + this.gYear + "<br />");
		this.wwrite(vCode);

		if (isIE)
			this.wwrite("</div>");
		else if (isNav)
			this.wwrite("</layer>");
	}
	this.wwrite("</font><br></body></html>");
	this.gWinCal.document.close();
}

//Las funciones empleadas para escribir en la ventana emergente, con retorno y sin retorno de carro(enter)
Calendario.prototype.wwrite = function(wtext) {
	this.gWinCal.document.writeln(wtext);
}

Calendario.prototype.wwriteA = function(wtext) {
	this.gWinCal.document.write(wtext);
}

/*
Esta funcion se encarga de formar el encabezado con los dias que forman el encabezado del calendario
*/
Calendario.prototype.cal_header = function() {
	var vCode = "";

	vCode = vCode + "<tr>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Dom</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Lun</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Mar</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Mie</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Jue</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Vie</b></font></td>";
	vCode = vCode + "<td align=\"center\" width=\"14%\"><font size=\"" + tamanioFuente + "\" face=\" "  + tipoFuente +
									"\" color='" + this.gHeaderColor + "'><b>Sab</b></font></td>";
	vCode = vCode + "</tr>";

	return vCode;
}

//Esta funcion se encarga de calcular todos los dias el mes, de acuerdo con la fecha actual o dependiendo de
//el mes establecido en la variable miembro especificada.
Calendario.prototype.cal_data = function()  {
	//Obtenemos la fecha actual del sistema.
	var vDate = new Date();

	//Establecemos  mis datos.
	vDate.setDate(1);
	vDate.setMonth(this.gMonth);
	vDate.setFullYear(this.gYear);

	//Obtenemos el dia y calculamos el numero de dias del mes.
	var vFirstDay=vDate.getDay();
	var vDay=1;
	var vLastDay=Calendario.obtenDiasDelMes(this.gMonth, this.gYear);
	var vOnLastDay=0;

	var vCode = "";

	//Obtenemos el primer dia del mes de acuerdo a la pareja mes/anio y rellenamos con
	//espacios en blanco las celdas de los dias que nos hacen falta.
	vCode = vCode + "<tr>";
	for (i=0; i<vFirstDay; i++) {
		vCode = vCode + "<td  align=\"center\" > </td>";
	}

	// escribimos el resto de los dias de la semana
	for (j=vFirstDay; j<7; j++) {
		vCode = vCode + "<td  align=\"center\" " + this.write_weekend_string(j)  +
										"><font size=\"" + tamanioFuente + "\" face='" + tipoFuente + "'><a href=\"#\" " +
										"onClick=\"self.opener.document." + this.gReturnItem + ".value='" + this.format_data(vDay) +
										"';window.close();\">" + this.format_day(vDay) + "</a></font></td>";
		vDay=vDay + 1;
	}
	vCode = vCode + "</tr>";

	// escribimos el resto de las semanas
	for (k=2; k<7; k++)  {
		vCode = vCode + "<tr>";
		for (j=0; j<7; j++)  {
			vCode = vCode + "<td align=\"center\" " + this.write_weekend_string(j) +
											"><font size=\"" + tamanioFuente + "\" face='" + tipoFuente + "'><a href=\"#\" " +
										"onClick=\"self.opener.document." + this.gReturnItem + ".value='" + this.format_data(vDay) +
										"';window.close();\">" + this.format_day(vDay) + "</a></font></td>";
			vDay=vDay + 1;
			if (vDay > vLastDay)  {
				vOnLastDay = 1;
				break;
			}
		}
		if (j == 6) {
			vCode = vCode + "</tr>";
		}
		if (vOnLastDay == 1)  {
			break;
		}
	}

	// rellenamos el resto del calendario con espacios en blanco
	//j es el numero de dias que si fueron validos.
	for (m=1; m<(7-j); m++) {
		if (this.gYearly) {
			vCode = vCode + "<td> </td>";
		}
		else {
			vCode = vCode + "<td> </td>";
		}
	}
	return vCode;
}

//Esta funcion regresa el contenido de cada celda donde se encuentra la informacion del dia
Calendario.prototype.format_day = function(vday) {

	var vNowDay = fechaActual.getDate();
	var vNowMonth = fechaActual.getMonth();
	var vNowYear = fechaActual.getFullYear();

	if (vday == vNowDay && this.gMonth == vNowMonth && this.gYear == vNowYear)
		return ("<font color=\"red\" size=\"+1\"><b>" + vday + "</b></font>");
	else
		return (vday);
}

//Si es fin de semana sele pone otro color al calendario
Calendario.prototype.write_weekend_string = function(vday) {
	var i;
	// Return special formatting for the weekend day.
	for (i=0; i<diasFinDeSemana.length; i++) {
		if (vday == diasFinDeSemana[i])
			return (" bgcolor=\"" + colorDiasFinDeSemana + "\"");
	}
	return "";
}

/*
 Esta funcion se va a encargar de mostrar los diferentes tipos de formato de fechas que el calendario
va a atener disponibles, si tomamos un estandar esta funcion se puede minimizar por que hay formatos
nunca se utilizaran
*/
Calendario.prototype.format_data = function(p_day) {
	var vData;
	var vMonth = 1 + this.gMonth;
	vMonth = (vMonth.toString().length < 2) ? "0" + vMonth : vMonth;
	var vMon = Calendario.obtenMes(this.gMonth).substr(0,3).toUpperCase();
	var vFMon = Calendario.obtenMes(this.gMonth).toUpperCase();
	var vY4 = new String(this.gYear);
	var vY2 = new String(this.gYear.substr(2,2));
	var vDD = (p_day.toString().length < 2) ? "0" + p_day : p_day;

	switch (this.gFormat) {
		case "MM\/DD\/YYYY" :
			vData = vY4 + "\/" + vDD + "\/" + vMonth;
			break;
		case "MM\/DD\/YY" :
			vData = vMonth + "\/" + vDD + "\/" + vY2;
			break;
		case "MM-DD-YYYY" :
			vData = vMonth + "-" + vDD + "-" + vY4;
			break;
		case "MM-DD-YY" :
			vData = vMonth + "-" + vDD + "-" + vY2;
			break;
		case "DD\/MON\/YYYY" :
			vData = vDD + "\/" + vMon + "\/" + vY4;
			break;
		case "DD\/MON\/YY" :
			vData = vDD + "\/" + vMon + "\/" + vY2;
			break;
		case "DD-MON-YYYY" :
			vData = vDD + "-" + vMon + "-" + vY4;
			break;
		case "DD-MON-YY" :
			vData = vDD + "-" + vMon + "-" + vY2;
			break;
		case "DD\/MONTH\/YYYY" :
			vData = vDD + "\/" + vFMon + "\/" + vY4;
			break;
		case "DD\/MONTH\/YY" :
			vData = vDD + "\/" + vFMon + "\/" + vY2;
			break;
		case "DD-MONTH-YYYY" :
			vData = vDD + "-" + vFMon + "-" + vY4;
			break;
		case "DD-MONTH-YY" :
			vData = vDD + "-" + vFMon + "-" + vY2;
			break;
		case "DD\/MM\/YYYY" :
			vData =  vDD + "\/" + vMonth + "\/" +vY4 ;
			break;
		case "DD\/MM\/YY" :
			vData = vDD + "\/" + vMonth + "\/" + vY2;
			break;
		case "DD-MM-YYYY" :
			vData =vDD + "-" + vMonth + "-" + vY4 ;
			break;
	case "YYYY-MM-DD" :
			vData = vDD+ "/" + vMonth + "/" + vY4 ;
			break;
		case "DD-MM-YY" :
			vData = vDD + "-" + vMonth + "-" + vY2;
			break;
		default :
			vData = vDD+ "/" + vMonth + "/" + vY4 ;
	}
	return vData;
}

//Esta funcion construye el  calendario, aqui se debe de personalizar
function Build(p_item, pMesMostrado, anioMostrado, formatoFecha) {
	var p_WinCal = ventanaCalendario;
	gCal = new Calendario(p_item, p_WinCal, pMesMostrado, anioMostrado, formatoFecha);

	//Aqui se personaliza el calendario, (no todos los parametros se encuentran aqui).
	gCal.gBGColor="white";
	gCal.gLinkColor="black";
	gCal.gTextColor="black";
	gCal.gHeaderColor="black";
	gCal.tamanioFuente = "2";

	// Dependiendo del tipo de calendario se muestra uno u otro, hay que revisar la otra funcion contra el original
	//por que al parecer no funciona correctamente.
	if (gCal.gYearly)	gCal.showY();
	else	gCal.show();
}

/*
Esta funcion muestra el calendario es necesario especificar los parametros que acepta.
pMesMostrado : 0-11 para especificar cada uno de los meses o 12 para todos los meses del calendario
anioMostrado	: anio de 4 digitos
formatoFecha: El formato de la fecha, es una cadena que puede especificarse
p_item	: El item del formulario que manda llamar el calendario.
*/
function show_calendar() {
	p_item = arguments[0];
	if (arguments[1] == "" || arguments[1] == null) {
		pMesMostrado = new String(fechaActual.getMonth());
	}
	else {
		pMesMostrado = arguments[1];
	}
	if (arguments[2] == "" || arguments[2] == null) {
		anioMostrado = new String(fechaActual.getFullYear().toString());
	}
	else {
		anioMostrado = arguments[2];
	}
	if (arguments[3] == null) {
		formatoFecha = "YYYY-MM-DD";
	}
	else {
		formatoFecha = arguments[3];
	}
	vWinCal = window.open("", "Calendario",
		"width=240,height=250,status=no,resizable=no,top=200,left=200");
	vWinCal.opener = self;
	ventanaCalendario = vWinCal;
	Build(p_item, pMesMostrado, anioMostrado, formatoFecha);
}

/*
El Codigo de un calendario anual comienza aqui pero se debe de depurar por que genera un error
*/
function show_yearly_calendar(p_item, anioMostrado, formatoFecha) {
	// Load the defaults..
	if (anioMostrado == null || anioMostrado == "")
		anioMostrado = new String(fechaActual.getFullYear().toString());
	if (formatoFecha == null || formatoFecha == "")
		formatoFecha = "YYYY-MM-DD";

	var vWinCal = window.open("", "Calendario", "scrollbars=no");
	vWinCal.opener = self;
	ventanaCalendario = vWinCal;

	Build(p_item, null, anioMostrado, formatoFecha);
}

//Verifica si el argumento es un número o no

  function esNumero( numstr ) {
    
    if (numstr+"" == "undefined" || numstr+"" == "null" || numstr+"" == "") 
      return false;
  
    var isValid = true;
    var decCount = 0;   
  
    numstr += ""; 
  
    for (i = 0; i < numstr.length; i++) {
      if (numstr.charAt(i) == ".")
        decCount++;
  
          if (!((numstr.charAt(i) >= "0") && (numstr.charAt(i) <= "9") || (numstr.charAt(i) == "-") || (numstr.charAt(i) == "."))) {
              isValid = false;
              break;
      } else 
        if ((numstr.charAt(i) == "-" && i != 0) ||(numstr.charAt(i) == "." && numstr.length == 1) || (numstr.charAt(i) == "." && decCount > 1)) {
                isValid = false;
                break;
              }                            
  
    }   
     
        return isValid;
  }

