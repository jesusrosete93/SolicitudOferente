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
Solicitud de Extracción.
</p>
<form id="inicioForm" action="welcome.htm"></form>
<form:form id="solicitudOferenteExtraccionForm" modelAttribute="solicitudExtraccion"> 
<div id="errores" class="errorblock" align="center" style="display: none">
</div>
</br>
</br>
<div>
	<table align="center">
	
		<tr>
	     <td colspan="1" align="left" ><spring:message code="avaluos.texto.estado" /></td>
	  	  <td colspan="1" align="left" >
	  	  	<form:select id="selectEstado" path="id_estado" >
	  	  		<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
	  	  		<form:options items="${estados}"/>
	  	  	</form:select>
	  	  </td>
  	 	</tr>
	
	  	 		<tr>
  	 	
  	 	<td /></td>
  	 	
  	 	
<td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Datos oferente
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
	     <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.idOferente" /></td>
	  	  <td  >
	  	  <form:input path="id_oferente" cssClass="k-textbox" cssStyle="width: 100%" />	  	  	
	  	  </td>
	  	  
	  	<td align="right" ><spring:message code="avaluos.titulo.generico.rfc" /></td>
	  	  <td  ><form:input cssClass="k-textbox" path="rfc_oferente"  cssClass="k-textbox" /></td>
	  	  
	  	  
  	 	<tr>
	     <td  ><spring:message code="solicitud.oferente.titulo.generico.genera.nombreOferente" /></td>
	  	  <td  ><form:input cssClass="k-textbox" path="nombre_razon_social" cssClass="k-textbox"  cssStyle="width: 100%" /></td>
  	 	</tr>
  	 	
  	 	<tr>
  	 	</tr>
  	 	
  	 	<tr>
  	 	</tr>
  	 	
  	 	<tr>
  	 	<td></td>
  	 	
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Datos de Oferta
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
	  	  <td  colspan="2"><form:input path="id_oferta_vivienda" cssClass="k-textbox" cssStyle="width: 143%" /></td>
			</tr>
			
			<tr>
			
  	 	  <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.ordenVerificacion" /></td>
	  	  <td  colspan="2"><form:input cssClass="k-textbox" path="id_orden_verificacion" cssStyle="width: 143%" /></td>
			</tr>
			
  	 	<tr>
  	 	
	     <td  height="19"><spring:message code="solicitud.oferente.titulo.generico.atributo.nombreFrente" /></td>
	  	  <td  height="19" colspan="2"><form:input cssClass="k-textbox" path="nombre_frente" cssStyle="width: 143%" /></td>

					

  	 	</tr>
  	 	
  	 	<tr>
  	 	<td height="19" style="height: 19px"><spring:message
							code="solicitud.oferente.titulo.generico.atributo.numeroViviendas" />
					</td>
					<td height="19" colspan="2"><form:input cssClass="k-textbox" path="num_viviendas" cssStyle="width: 143%" /></td>
  	 	
  	 	</tr>
  	 	
  	 	  	 	<tr>
  	 	</tr>
  	 	
  	 		
  	 	  	 	<tr>
  	 	</tr>
  	 	
  	 	<tr>
  	 	<td></td>
  	 	
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">
Documentos opcionales
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
  	 	</tr>
  	 	
  	 	  	 		<tr>
	     <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.documentoUno" /></td>
	  	  <td  ><form:input type="file"  path="nombre_archivo"  /></td>


	
  	 	</tr>
  	 	<tr>
  	 	
  <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.documentoDos" />
	</td>
	<td  ><form:input type="file"  path=""  /></td>
  	 	
  	 	</tr>
  	 	
  	 	<tr>


<td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.documentoTres" /></td>
<td  ><form:input type="file"  path=""  /></td>
  	 	</tr>
  	 	
  	 	
  	 		 	  	 <tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>
  	 		 	
  	 	
  	 	<tr>

  	 	<td rowspan="2"   colspan="4" align="center" ><spring:message code="solicitud.oferente.titulo.generico.atributo.Comentarios" /></td>
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
       <td > <textarea hidden=""  name="id_tipo_solicitud">1</textarea ></td>
       </div>
  	 	
	
	 <tr>
	   <td colspan="7" align="center">
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



	function adjustDropDownWidth(e) {
		      var listContainer = e.sender.list.closest(".k-list-container");
		      listContainer.width(listContainer.width() + kendo.support.scrollbar());
		    } 
             
		      							
		    $("[id^=\"select\"]").each(function(index)
                                        {
							 			  var id = this.id;
									   	  $("#"+id).kendoDropDownList({
									   	  	open: adjustDropDownWidth
									   	  });
									   	  var localDropDown = $("#"+id).data("kendoDropDownList");
									      localDropDown.list.width("auto");
		      							});
		      						



</script>


</body>
</html>