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
       $("#peticiones").attr("action","initViewConsultaUPC.htm");
       $("#peticiones").submit();
     });
     
     $("#formaUPC").submit(function(){
	  displayLoading(document.body);
	});
	
	
	 $("#todosCamposUnidad").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposUnidadValuacion\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposUnidadValuacion\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	
	$("#todosCamposCobertura").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposCobertura\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposCobertura\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	 $("#todosCamposControlador").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposControlador\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposControlador\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	 $("#todosCamposPerito").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposPerito\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposPerito\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
 });
 </script>
</head>
<body>
<form id="peticiones" action=""></form>
<form:form id="formaUPC" modelAttribute="consultaUPCForm" action="processConsultaUPC.htm" method="POST">
<form:hidden path="unidadValuacionForm.claveUnidadValuacion"/><form:hidden path="unidadValuacionForm.nombreUnidadValuacion"/><form:hidden path="unidadValuacionForm.estatusUnidadValuacion"/><form:hidden path="unidadValuacionForm.fechaVigenciaInicio"/>
<form:hidden path="unidadValuacionForm.fechaVigenciaFin"/><form:hidden path="unidadValuacionForm.claveSHF"/><form:hidden path="unidadValuacionForm.siglas"/><form:hidden path="unidadValuacionForm.unidadViviendaRecuperada"/>
<form:hidden path="coberturaForm.estados"/><form:hidden path="coberturaForm.estatus"/><form:hidden path="controladorForm.claveSHF"/><form:hidden path="controladorForm.nombre"/><form:hidden path="controladorForm.apellidoMaterno"/><form:hidden path="controladorForm.apellidoPaterno"/><form:hidden path="controladorForm.curp"/>
<form:hidden path="controladorForm.rfc"/><form:hidden path="controladorForm.fechaVigenciaInicio"/><form:hidden path="controladorForm.fechaVigenciaFin"/><form:hidden path="controladorForm.estatusControlador"/>
<form:hidden path="peritoForm.claveSHF"/><form:hidden path="peritoForm.nombre"/><form:hidden path="peritoForm.apellidoMaterno"/><form:hidden path="peritoForm.apellidoPaterno"/><form:hidden path="peritoForm.curp"/>
<form:hidden path="peritoForm.rfc"/><form:hidden path="peritoForm.fechaVigenciaInicio"/><form:hidden path="peritoForm.fechaVigenciaFin"/><form:hidden path="peritoForm.estatusPerito"/>


	<br>
<table width="100%">

 <tr>
	<td>
	    <!-- titulo -->
		<table width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><br>Consulta de Datos de UV<br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr><td align="center"><form:errors cssClass="error" path="errores"></form:errors> </td></tr>
 <tr>
	<td>
	    <!-- Detalle -->
		<table  width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="15%" align="left">
				<input type="checkbox" id="todosCamposUnidad" title="Todos los campos"/> <spring:message code="avaluos.titulo.generico.unidad.valuacion"></spring:message><br>
				<ul><form:checkboxes id="camposUnidadValuacion" element="li" items="${camposUV}" path="unidadValuacionForm.camposUnidadValuacion"/></ul>
			</td>
			<td width="15%" align="left"><input type="checkbox" id="todosCamposCobertura" title="Todos los campos"/> <spring:message code="avaluos.titulo.cobertura"></spring:message><br>
				<ul><form:checkboxes id="camposCobertura" element="li" items="${camposCob}" path="coberturaForm.camposCobertura"/></ul>
			</td>
			 
			<td width="15%" align="left"><input type="checkbox" id="todosCamposControlador" title="Todos los campos"/> <spring:message code="avaluos.titulo.controlador"></spring:message><br>
				<ul><form:checkboxes  id="camposControlador" element="li" items="${camposControlador}" path="controladorForm.camposControlador"/></ul>
			</td>
			<td width="15%" align="left"><input type="checkbox" id="todosCamposPerito" title="Todos los campos"/> <spring:message code="avaluos.titulo.perito"></spring:message><br>
				<ul><form:checkboxes id="camposPerito" element="li" items="${camposPerito}" path="peritoForm.camposPerito"/></ul>
			</td>
			<td width="10%"></td>

		</tr>
		</table>


	</td>
 </tr>
 <tr><td align="center">
      <button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button>
      <button class="k-button" type="button" id="nuevaConsulta"  ><spring:message code="avaluos.titulo.generico.boton.consulta.nueva"></spring:message></button>
     </td>
 </tr>
 </table>
</form:form>
</body>
</html>