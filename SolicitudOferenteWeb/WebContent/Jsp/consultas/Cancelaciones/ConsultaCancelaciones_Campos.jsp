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
       $("#peticiones").attr("action","initConsultaCancelaciones.htm");
       $("#peticiones").submit();
     });
     
     $("#todosCamposCancelacion").click(function(){
    	if( this.checked )
    	{
    		$("[id^=\"camposCancelaciones\"]").each(function(index){
		  		var id = this.id;
		   		$("#"+id).prop("checked",true);
			});
    	}
    	if( !this.checked )
    	{
    	  $("[id^=\"camposCancelaciones\"]").each(function(index){
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
 <form:form modelAttribute="cancelacionForm" action="processConsultaCancelaciones.htm" method="post">
 <form:hidden path="claveUnidadValuacion"/><form:hidden path="nombreUnidadValuacion"/>
 <form:hidden path="idAvaluo"/><form:hidden path="idConviviencia"/>
 <form:hidden path="paquete"/><form:hidden path="viviendaInicio"/>
 <form:hidden path="viviendaFin"/><form:hidden path="fechaCancelacionInicio"/>
 <form:hidden path="fechaCancelacionFin"/><form:hidden path="fechaSolicitudInicio"/>
 <form:hidden path="fechaSolicitudFin"/><form:hidden path="fechaCierreInicio"/>
 <form:hidden path="fechaCierreFin"/><form:hidden path="valorConcluidoInicio"/>
 <form:hidden path="valorConcluidoFin"/><form:hidden path="estatusAvaluo"/>
   <table  width="100%" border=0 align="center">
    <caption><br><spring:message code="avaluos.consulta.cancelaciones.titulo"></spring:message><br><br></caption>
		<tr><td align="center"><form:errors path="errores"></form:errors> </td></tr>
		<tr>
			<td align="center">
			   <table>
			   	<tr>
			   	  <td align="center">
			   	   <input type="checkbox" id="todosCamposCancelacion" title="Todos los campos"/> <spring:message code="avaluos.consulta.cancelaciones.campos"></spring:message><br>
					<ul style="text-align: left"><form:checkboxes id="camposCancelaciones" element="li" items="${camposCancelaciones}" path="camposCancelaciones"/></ul>
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
