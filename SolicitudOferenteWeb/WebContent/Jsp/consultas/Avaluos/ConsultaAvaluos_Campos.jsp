<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head>
  <script type="text/javascript">
  function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
    }
$(document).ready(function () {
  $("#nuevaConsulta").click(function(){
       $("#peticiones").attr("action","initConsultaAvaluos.htm");
       $("#peticiones").submit();
     });
     
    $("#todosCamposUnidadValuacion").click(function(){
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
	
	$("#todosCamposVivienda").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposVivienda\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposVivienda\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	$("#todosCamposAvaluo").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposAvaluo\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposAvaluo\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	});
	$("#todosCamposDetalleAvaluo").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposDetalleAvaluo\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposDetalleAvaluo\"]").each(function(index){
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
	
	$("#formaAvaluosCampos").submit(function(){
	  displayLoading(document.body);
	});
 });
 </script>
 </head>
 <body>
 <form id="peticiones" action=""></form>
 <form:form  id="formaAvaluosCampos" modelAttribute="consultaAvaluosForm" action="findConsultaAvaluos.htm" method="post">
 <!-- titulo -->
		<table width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><h4><spring:message code="avaluos.consultas.avaluo.subtitulo"></spring:message></h4> <br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
  <table  width="100%" align="center">
    	<tr><td align="center"><form:errors path="errores"></form:errors> </td></tr>
		<tr>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center" valign="top">
			   	    <input type="checkbox" id="todosCamposUnidadValuacion" title="Todos los campos" ><spring:message code="avaluos.titulo.generico.unidad.valuacion"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposUnidadValuacion" element="li" items="${camposUnidadValuacion}" path="unidadValuacion.camposUnidadValuacion"/></ul>
			   	  </td>
			   	  <td rowspan="2" valign="top" align="center">
			   	    <input type="checkbox" id="todosCamposVivienda" title="Todos los campos" ><spring:message code="avaluos.titulo.generico.vivienda"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposVivienda" element="li" items="${camposVivienda}" path="vivienda.camposVivienda"/></ul>
			   	  </td>
			   	   <td rowspan="2" valign="top" align="center">
			   	    <input type="checkbox" id="todosCamposAvaluo" title="Todos los campos" ><spring:message code="avaluos.titulo.avaluo"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposAvaluo" element="li" items="${camposAvaluo}" path="avaluo.camposAvaluos"/></ul>
			   	  </td>
			   	  <td rowspan="2" valign="top" align="center">
			   	    <input type="checkbox" id="todosCamposDetalleAvaluo" title="Todos los campos" ><spring:message code="avaluos.titulo.detalle.avaluo"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposDetalleAvaluo" element="li" items="${camposDetalleAvaluo}" path="detalleAvaluo.camposDetalleAvaluo"/></ul>
			   	  </td>
			   	  <td align="center" valign="top">
			   	    <input type="checkbox" id="todosCamposControlador" title="Todos los campos" ><spring:message code="avaluos.titulo.controlador"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposControlador" element="li"  items="${camposControlador}" path="controlador.camposControlador"/></ul>
			   		<input type="checkbox" id="todosCamposPerito" title="Todos los campos" ><spring:message code="avaluos.titulo.perito"/>
			   		<ul style="text-align: left"><form:checkboxes id="camposPerito" element="li" items="${camposPerito}" path="perito.camposPerito"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			    
			</td>
		</tr>
		<tr>
			<td align="center" >
			 <button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button>
			 <button class="k-button" type="button" id="nuevaConsulta"  ><spring:message code="avaluos.titulo.generico.boton.consulta.nueva"></spring:message></button> 
			</td>
		 </tr>
		</table>
</form:form>
 </body>
 
</html>
