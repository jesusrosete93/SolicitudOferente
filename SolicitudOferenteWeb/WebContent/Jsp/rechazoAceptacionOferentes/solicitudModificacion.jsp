<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link  href="/SolicitudOferenteWeb/theme/Master.css" rel="stylesheet"  type="text/css" />
<title>consultaReporte</title>
<style type="text/css">
.k-grid-toolbar a {
    float:right;
}
</style>
<script src="/SolicitudOferenteWeb/Js/InputsValidator.js"></script>
</head>
<body>

<p style="font-family: Arial, sans-serif; font-size:11pt; font-style:small;" align="center">
Solicitud de Modificacion.
</p>

<form id="inicioForm" action="welcome.htm"></form>
<form:form id="solicitudOferenteModificacionForm" modelAttribute="solicitudModificacion"> 
<div id="errores" class="errorblock" align="center" style="display: none">
</div>
</br>
</br>
<div align="center">
	<table align="center">
	
					<tr>
	     <td colspan="1" align="center" ><spring:message code="avaluos.texto.estado" /></td>
	  	  <td colspan="1" align="left" >
	  	  	<form:select id="selectEstado" path="id_estado" >
	  	  		<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
	  	  		<form:options items="${estados}"/>
	  	  	</form:select>
	  	  </td>
  	 	</tr>
  	 	

	
	
	  	 	<tr>
  	 	<td></td>
  	 	<td /></td>
  	 	
  	 	
<td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Datos Oferente</p></td>
  	 	</tr>
  	 	
  	 	  	 	  	 		  	 	<tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 	


  	 	
  	 	<tr>
  	 	</tr>
	
		<tr>
	     <td ><spring:message code="solicitud.oferente.titulo.generico.atributo.idOferente" /></td>
	  	  <td  >
	  	  <td align="center" nowrap colspan="6"><B>ID oferente:</B> &nbsp; <core:out value="${solicitudOferenteDomain.id_oferente}"></core:out></td> 	
	  	  </td>
	  	  
	  	<td align="right"><spring:message code="avaluos.titulo.generico.rfc" /></td>
	  	<td align="center" nowrap colspan="6"><B>RFC:</B> &nbsp; <core:out value="${solicitudOferenteDomain.rfc}"></core:out></td>
	  	  
	  	  
  	 	<tr>
	     <td><spring:message code="solicitud.oferente.titulo.generico.genera.nombreOferente" /></td>
	  	  <td align="center" nowrap colspan="6"><B>Nombre Frente:</B> &nbsp; <core:out value="${solicitudOferenteDomain.nombre_razon_social}"></core:out></td>
  	 	</tr>
  	 	
  	 	<tr>
  	 	</tr>
  	 	
  	 	<tr>
  	 	<td></td>
  	 	<td /></td>
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Datos de oferta
</p></td>
  	 	
  	 	</tr>
  	 	
  	 		<tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 	
  	    <tr>
  	 	</tr>
  	 	
  	 	<tr>
	     <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.idOferta" /></td>
	  	  <td align="center" nowrap colspan="6"><B>ID Oferta:</B> &nbsp; <core:out value="${solicitudOferenteDomain.idOferta}"></core:out></td>

  	 	<tr>
  	 	
  	 	<tr>
  	 	<td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.ordenVerificacion" /></td>
	  	   <td align="center" nowrap colspan="6"><B>Orden Verificacion:</B> &nbsp; <core:out value="${solicitudOferenteDomain.ordenVerificacion}"></core:out></td>
  	 	
  	 	</tr>
  	 	
  	 	<tr>
	     <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.nombreFrente" /></td>
	  	   <td align="center" nowrap colspan="6"><B>Nombre Frente:</B> &nbsp; <core:out value="${solicitudOferenteDomain.nombreFrente}"></core:out></td>

  	 	</tr>
  	 	
  	 	<tr>
  	 	<td><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroViviendas" /></td>
			 <td align="center" nowrap colspan="6"><B>Numero viviendas:</B> &nbsp; <core:out value="${solicitudOferenteDomain.nombre_razon_social}"></core:out></td>
  	 	</tr>
  	 	
  	 	  	 	<tr>
  	 	</tr>
  	 	
  	 	<tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 		
  	 	  	 	<tr>
  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Datos de modificacion
</p></td>
					
  	 	</tr>
  		
  	 	
  	 	  	 		<tr>
	     <td ><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroPaquetes" /></td>
	  	 <td align="center" nowrap colspan="6"><B>Numero paquetes</B> &nbsp; <core:out value="${solicitudOferenteDomain.numeroPaquetes}"></core:out></td>

	<td ><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroActualViviendas" />
	</td>
	 <td align="center" nowrap colspan="6"><B>Numero Viviendas</B> &nbsp; <core:out value="${solicitudOferenteDomain.numeroActualViviendas}"></core:out></td>
	
  	 	</tr>
  	 	
  	 	<tr>


<td ><spring:message code="solicitud.oferente.titulo.generico.atributo.viviendasModificar" /></td>
<td  ><form:input cssClass="k-textbox" path="id_modificacion"  /></td>

<td><spring:message code="solicitud.oferente.titulo.generico.atributo.datosModificar" /></td>
<td>
				<form:select id="selectRecuperadaUV" path="">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="1">Colonia</form:option>
					  <form:option value="2">Calle</form:option>
				</form:select></td>
  	 	</tr>
  	 	
  	 		<tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 	
  	 	<tr>

  	 	<td rowspan="2"   colspan="7" align="center" ><spring:message code="solicitud.oferente.titulo.generico.atributo.Comentarios" /></td>
		<tr></tr>
					
  	 	</tr>
  	 	
  	 		 	  	 <tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 	
 
  	 	<tr>
	  	  <td colspan="7" align="center"> <textarea name="comentarios"rows="3" cols="95">Escribe aquí tus comentarios</textarea></td>
  	 	</tr>
  	 	
  	 		<div  >
       <td > <textarea hidden=""  name="id_tipo_solicitud">2</textarea ></td>
       </div>
	
	 <tr>
	   <td colspan="6" align="center">
	   	<table>
	   	 <tr>
	   	 	<td align="center"><button type="button" id="busqueda" class="k-button"><spring:message code="solicitud.oferente.titulo.generico.genera.guardar"/></button></td>
		
			<td align="center"><button type="button" id="cancela" class="k-button"><spring:message code="avaluos.titulo.generico.boton.cancelar"/></button></td>
	   	 </tr>
	  	</table>
	    </td>
	  </tr>
	</table>
	<br>
</div>
</form:form>
<div style="width: 1000px">
<div id="resultadoConsulta" align="center" class="desc" style="display:none;"></div>
</div>



<script type="text/javascript">


$(document).ready(function(){
    $("#busqueda").click(function(){
        $("#solicitudOferenteModificacionForm").trigger("reset");
    });
});


</script>

	

</body>
</html>