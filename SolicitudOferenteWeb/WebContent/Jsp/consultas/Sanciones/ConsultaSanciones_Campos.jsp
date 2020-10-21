<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head>
  <script type="text/javascript">
$(document).ready(function () {
  $("#nuevaConsulta").click(function(){
       $("#peticiones").attr("action","initConsultaSanciones.htm");
       $("#peticiones").submit();
     });
     
     $("#todosCamposSancion").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposSancion\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposSancion\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",false);
			});
    	}
	}); 
	 $("#todosCamposUnidad").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposUnidad\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposUnidad\"]").each(function(index){
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
 <form:form modelAttribute="sancionesForm" action="processConsultaSanciones.htm" method="post">
   <table  width="100%" border=0 align="center">
    <caption><br><spring:message code="avaluos.sanciones.datos.sanciones"></spring:message><br><br></caption>
		<tr><td align="center" colspan="5"><form:errors path="errores" cssClass="error"></form:errors> </td></tr>
		<tr>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	   <input type="checkbox" id="todosCamposSancion" title="Todos los campos"/> <spring:message code="avaluos.sanciones.sanciones"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposSanciones" element="li" items="${camposSanciones}" path="sancion.camposSancion"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			</td>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	    <input type="checkbox" id="todosCamposUnidad" title="Todos los campos"/> <spring:message code="avaluos.titulo.generico.unidad.valuacion"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposUnidad" element="li" items="${camposUnidad}" path="unidad.camposUnidadValuacion"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			</td>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	   <input type="checkbox" id="todosCamposCobertura" title="Todos los campos"/> <spring:message code="avaluos.titulo.cobertura"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposCobertura" element="li" items="${camposDelegacion}" path="cobertura.camposCobertura"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			</td>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	     <input type="checkbox" id="todosCamposControlador" title="Todos los campos"/> <spring:message code="avaluos.titulo.controlador"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposControlador" element="li" items="${camposControlador}" path="controlador.camposControlador"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			</td>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	    <input type="checkbox" id="todosCamposPerito" title="Todos los campos"/> <spring:message code="avaluos.titulo.perito"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposPerito" element="li" items="${camposPerito}" path="perito.camposPerito"/></ul>
			   	  </td>
			   	</tr>
			   </table>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="5" >
			 <button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button>
			 <button class="k-button" type="button" id="nuevaConsulta"  ><spring:message code="avaluos.titulo.generico.boton.consulta.nueva"></spring:message></button> 
			</td>
		 </tr>
		</table>
</form:form>
 </body>
</html>
