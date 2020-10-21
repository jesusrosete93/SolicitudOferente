<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>

<title>Fail</title>
<script type="text/javascript">
$(document).ready(function () {
  $("#regresar").click(function(){
       $("#peticiones").attr("action","welcome.htm");
       $("#peticiones").submit();
     });
 });
 </script>
</head>
<body>
<table align="center">
<tr>
<td>

<div class="k-block k-error-colored" align="center">
<div class="k-header k-inset">Respuesta de la consulta</div>
<core:out value="${mensaje}"></core:out>
</div>
</td>
</tr>
<tr>
 <td align="center"><button id="regresar" class="k-button"><spring:message code="avaluos.titulo.generico.boton.regresar" /></button> </td>
</tr>
</table>
<form id="peticiones" action=""></form>
</body>
</html>