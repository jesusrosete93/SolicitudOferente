<!DOCTYPE HTML>
<%@page	language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
    }

function cancelar(){
  document.cancela.action="login.htm";
  document.cancela.submit();
}


$(document).ready(function(){

	$("#formularioLogin").submit(function(){
	  displayLoading(document.body);
	});
	
	$("#cancelaForm").submit(function(){
	  displayLoading(document.body);
	});
	
	
});

</script>
</head>
<body >
<div align="center">
<form:form modelAttribute="loginForm" action="login.htm" method="post" id="formularioLogin" >



<table >
	<tbody>
	    <tr>
		    <td align="center" colspan="2"><form:errors  path="errores" cssClass="k-block k-error-colored"></form:errors></td>
		</tr>
		
<%-- 		 <tr>
	      <td><spring:message code="login.numeroOferente.titulo"></spring:message> </td>
	    </tr>
		<tr>
			<td align="left"><form:input cssClass="k-textbox"  path="user" size="20" maxlength="8" />
			                  <br>
			                 <form:errors  path="user" cssClass="k-block k-error-colored"> </form:errors>
						</td>
		</tr> --%>
		
	    <tr>
	      <td><spring:message code="login.usuario.titulo"></spring:message> </td>
	    </tr>
		<tr>
			<td align="left"><form:input cssClass="k-textbox"  path="user" size="20" maxlength="8" />
			                  <br>
			                 <form:errors  path="user" cssClass="k-block k-error-colored"> </form:errors>
						</td>
		</tr>
		<tr>
		   <td><spring:message code="login.contrasenia.titulo"></spring:message> </td>
		</tr>
		<tr>
		    <td align="left"><form:password cssClass="k-textbox" path="password" size="20" maxlength="12" />
			                  <br>
			                  <form:errors  path="password" cssClass="k-block k-error-colored"> </form:errors>
			 </td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input  class="k-button" type="submit" name="buscar" value="<spring:message code="login.contrasenia.boton.acceder.texto"></spring:message>"/>
			<input  class="k-button" type="button" name="buscar" value="<spring:message code="login.contrasenia.boton.cancelar.texto"></spring:message>" onclick="javascript: cancelar();"/>
			</td>
			
		</tr>
		
		</tbody>
</table>



</form:form>
</div>
<form method="get" name="cancela" id="cancelaForm"></form>
</body>
</html>