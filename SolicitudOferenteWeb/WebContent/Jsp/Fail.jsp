<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>Fail</title>
</head>
<body>
<table align="center">
<tr>
<td>

<div class="k-block k-error-colored" align="center">
<div class="k-header k-inset">Error al procesar la petición</div>
<core:out value="${mensaje}"></core:out>
</div>
</td>
</tr>
</table>

</body>
</html>