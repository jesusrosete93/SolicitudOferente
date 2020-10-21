<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head>
  <title></title>
</head>

 <body>
 <form:form  id="consultaAsignacionesParametros" action="processParamAsignaciones.htm" modelAttribute="asignacionesForm">
 <table width="100%">
 <tr>
	<td>
	    <!-- titulo -->
		<table width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><br>Consulta de Datos Asignaciones y Reasignaciones<br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr>
	<td>
	    <!-- Detalle -->
		<table  width="100%" border=0>
		<tr><td align="center" colspan="4"><form:errors path="errores"></form:errors> </td></tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Paquete: </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="paquete"  size="20"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Unida de Valuacion: </td>
			<td width="60%" align="left">
				<form:select id="selectUv" path="claveUnidadValuacion">
					<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					<core:forEach items="${unidades}" var="elemento">
					  <form:option value="${elemento.key}"><core:out value="${elemento.key}"/>-<core:out value="${elemento.value}"/>  </form:option>
					</core:forEach>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Frente: </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="nombreFrente"  size="100"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">RFC del Oferente: </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="rfcOferente"  size="30"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Fecha Asignacion: </td>
			<td width="60%" align="left">del <form:input  id="fechaAI" path="fechaAsignacionInicio"  size="20"/> al <form:input id="fechaAF"   path="fechaAsignacionFin"  size="20"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Estado </td>
			<td width="60%" align="left">
				<form:select id="selectCveEstado" path="claveEstado">
					 <form:option value="-1">Selecciona estado</form:option>
					 <form:options items="${estados}"/>
				</form:select>

			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Unidad Anterior: </td>
			<td width="60%" align="left">
			<form:select id="selectUvA" path="claveUnidadValuacionAnterior">
					<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					<core:forEach items="${unidades}" var="elemento">
					  <form:option value="${elemento.key}"><core:out value="${elemento.key}"/>-<core:out value="${elemento.value}"/>  </form:option>
					</core:forEach>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Fecha Re-Asignacion: </td>
			<td width="60%" align="left">del <form:input id="fechaRI"  path="fechaReasignacionInicio"  size="20"/> al <form:input id="fechaRF"  path="fechaReasignacionFin"  size="20"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right">Tipo Re-Asignacion: </td>
			<td width="60%" align="left">
				<form:select id="selectTipoA" path="tipoReasignacion">
					  <form:option value="-1">Selecciona tipo</form:option>
					  <form:option value="19">Manual</form:option>
					  <form:option value="20">Automatica</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>

		</table>

	</td>
 </tr>
 <tr><td align="center"><button class="k-button" type="submit">Consultar</button> </td> </tr>
 </table>
</form:form>
 </body>
 <script type="text/javascript">
function setWidth(el)
{
    var d = el;
    var p = d.data("kendoDropDownList").popup.element;
    var w = p.css("visibility","hidden").show().outerWidth();
    p.hide().css("visibility","visible");
    d.closest(".k-widget").width(w);
}

 function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
    }
    
    
$(document).ready(function() {


	$("[id^=\"select\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDropDownList({
	   		filter: "contains"
	   });
	   setWidth($("#"+id));
	});
	$("[id^=\"fecha\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDatePicker({
	        		  culture: "es-MX",
				  	  format: "yyyy-MM-dd",
				  	  interval: 30
			         });
	});
	
	$("#consultaAsignacionesParametros").submit(function(){
	  displayLoading(document.body);
	});
	
});
</script>
</html>
