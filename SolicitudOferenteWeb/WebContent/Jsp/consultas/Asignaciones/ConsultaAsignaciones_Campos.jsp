<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
<script type="text/javascript">
function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
    }
    
    
$(document).ready(function () {
  $("#nuevaConsulta").click(function(){
       $("#peticiones").attr("action","initConsultaAsignaciones.htm");
       $("#peticiones").submit();
     });
     
       $("#todosCamposAsignaciones").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposAsignaciones\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposAsignaciones\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	
	
	$("#peticiones").submit(function(){
	  displayLoading(document.body);
	});
 });
 </script>
 </head>

<body>
<form id="peticiones" action=""></form>
<form:form modelAttribute="asignacionesForm" action="processConsultaAsignaciones.htm">
<h4><spring:message code="avaluos.titulo.generico.asignaciones"/></h4>
<table width="100%" align="center">
 <tr>
 	<td align="center">
 		<form:errors cssClass="error" path="errores"></form:errors> 
 	</td>
 </tr>
 <tr>
	<td align="center" valign="top">
		<table>
		     <tr>
		       <td>
				<input type="checkbox" id="todosCamposAsignaciones" title="Todos los campos"/> <spring:message code="avaluos.titulo.generico.asignaciones.reasignaciones"></spring:message> <br>
				<ul style="text-align: left"><form:checkboxes id="camposAsignaciones" element="li" items="${camposAR}" path="camposAsignaciones"/></ul>
			   </td>
			</tr> 
	   </table>
	</td>
 </tr>
 <tr>
    <td align="center">
        <button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button>
 		<button class="k-button" type="button" id="nuevaConsulta"  ><spring:message code="avaluos.titulo.generico.boton.consulta.nueva"></spring:message></button>
 	 </td> 
 </tr>
 </table>
</form:form>
 </body>
</html>
