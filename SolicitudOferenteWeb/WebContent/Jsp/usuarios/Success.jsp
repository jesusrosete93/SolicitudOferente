<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
function cancelar(){
  document.cancela.action="login.htm";
  document.cancela.submit();
}
</script>
<title>Success</title>
</head>
<body>
<table align="center">
<tr>
<td>
<div class="k-success-colored">
<div class="k-header k-inset">Resultado de la petición</div>
<core:out value="${mensaje}"></core:out>
</div>
</td>
</tr>
<tr>
 <td align="center">
  <input class="k-button" type="submit" name="buscar" value="<spring:message code="login.contrasenia.boton.acceder.texto"></spring:message>" onclick="javascript: cancelar();"/>
 </td>
</tr>
</table>
<form method="get" name="cancela"></form>
</body>
</html>