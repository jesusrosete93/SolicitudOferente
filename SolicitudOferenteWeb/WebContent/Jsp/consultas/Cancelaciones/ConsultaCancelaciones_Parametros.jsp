<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head></head>

 <body>
 <form:form modelAttribute="cancelacionForm" action="processParamCancelaciones.htm" method="post">
   <table width="100%">
 <tr>
	<td>
	    <table width="100%">
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><br><spring:message code="avaluos.consulta.cancelaciones.titulo"></spring:message><br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr>
	<td>
	    <!-- Detalle -->
		<table  width="100%" border=0>
		<tr><td align="center" colspan="4"><form:errors cssClass="error" path="errores"></form:errors> </td></tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.unidad.valuacion"></spring:message> </td>
			<td width="60%" align="left">
					  <form:input path="claveUnidadValuacion" cssClass="k-textbox"  />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.unidad.valuacion"></spring:message> </td>
			<td width="60%" align="left">
				<form:select id="selectUV" path="nombreUnidadValuacion" >
					<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					<core:forEach items="${unidades}" var="elemento">
					  <form:option value="${elemento.value}"><core:out value="${elemento.key}"/>-<core:out value="${elemento.value}"/>  </form:option>
					</core:forEach>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.id.avaluo"/></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="idAvaluo" size="30"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.id.conviviencia"/></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="idConviviencia" size="20"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.paquete"/></td>
			<td width="60%" align="left"><form:input  cssClass="k-textbox" path="paquete" size="20"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.vivienda"/> </td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.de"/> <form:input path="viviendaInicio" cssClass="k-textbox" size="15"/> <spring:message code="avaluos.titulo.generico.rangos.a"/> <form:input path="viviendaFin" cssClass="k-textbox"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.cancelacion"/> </td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/><form:input  path="fechaCancelacionInicio" id="fechaCancelacionI" size="15"/><spring:message code="avaluos.titulo.generico.rangos.al"/><form:input path="fechaCancelacionFin" id="fechaCancelacionF" size="15"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.solicitud"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/><form:input path="fechaSolicitudInicio" id="fechaSolicitudI" size="15" /><spring:message code="avaluos.titulo.generico.rangos.al"/><form:input path="fechaSolicitudFin" id="fechaSolicitudF" size="15"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.cierre"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/><form:input path="fechaCierreInicio" id="fechaCierreI" size="15"/> <spring:message code="avaluos.titulo.generico.rangos.al"/> <form:input path="fechaCierreFin" id="fechaCierreF" size="15"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.valor.concluido"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.de"/><form:input cssClass="k-textbox" path="valorConcluidoInicio" size="20"/><spring:message code="avaluos.titulo.generico.rangos.a"/><form:input cssClass="k-textbox" path="valorConcluidoFin" size="20"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estatus.avaluo"/></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusAvaluo" path="estatusAvaluo">
				      <form:option value="0">Selecciona valor</form:option>
					  <form:option value="2">Solicitado</form:option>
					  <form:option value="3">Proceso</form:option>
					  <form:option value="4">Cerrado</form:option>
					  <form:option value="7">solicitud de pago</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr><td align="center" colspan="4"><button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button> </td> </tr>
		</table>
	</td>
 </tr>
 </table>
 </form:form>
 </body>
  <script type="text/javascript">
  function setWidth(el)
{
    var d = el;
    var p = d.data("kendoDropDownList").popup.element;
    var w = p.css("visibility","hidden").show().outerWidth();
    p.hide().css("visibility","visible");
    d.closest(".k-widget").width(w);
}
$(document).ready(function() {


	$("[id^=\"select\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDropDownList({
	   		filter :"contains"
	   });
	   setWidth($("#"+id));
	});
	
	
	$("[id^=\"fecha\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDatePicker({
	        		  culture: "es-MX",
				  	  format: "yyyy-MM-dd",
				  	  interval: 30
			         });
	});
	
	
	
});
</script>
 
</html>
