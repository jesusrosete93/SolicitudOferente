<!DOCTYPE HTML>
<%@page	language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
$(document).ready(function() {
});	

function procesar(){
  document.procesa.action="login.htm";
  document.procesa.submit();
}
</script>
</head>
<body>
<div class="k-header k-inset" align="center"><spring:message code="login.cambio.titulo"></spring:message> </div>
				
   <form:form  modelAttribute="cambioLoginForm"  action="cambioContrasenia.htm"  method="post" >
    <form:hidden path="idUsuario"/>
 	  <table align="center">
	     <TR>
			<TD align="right"><spring:message code="login.cambio.contrasenia.actual"></spring:message> </TD>
			<TD align="left">	
			 <form:password path="contraseniaActual" size="20" maxlength="8" />
			</TD>
		</TR>
		 <TR>
			<TD align="right"><spring:message code="login.cambio.contrasenia.nueva"></spring:message></TD>
			<TD align="left">	
			 <form:password path="contraseniaNueva" size="20" maxlength="8" />
			</TD>
		</TR>
		 <TR>
			<TD align="right"><spring:message code="login.cambio.contrasenia.nueva.confirma"></spring:message></TD>
			<TD align="left">	
			 <form:password path="contraseniaConfirma" size="20" maxlength="8" />
			</TD>
		</TR>	
		 <TR>
			<TD align="center" colspan="2">	
			 <form:errors path="errores" cssClass="k-block k-error-colored"/>
			</TD>
		</TR>							
    	  <tr>
			<td align="center" colspan="2">
			  	<INPUT type="submit" name="inscribe" value="<spring:message code="login.cambio.contrasenia.boton.actualiza.texto"></spring:message>" class="k-button">
			  	<input  class="k-button" type="button" value="<spring:message code="login.cambio.contrasenia.boton.cancelar.texto"></spring:message>" onclick="javascript: procesar('login.htm');"/>
			</td>
		  </tr>
	   </table>
</form:form>
<form method="get" name="procesa"></form>
</body>
</html>