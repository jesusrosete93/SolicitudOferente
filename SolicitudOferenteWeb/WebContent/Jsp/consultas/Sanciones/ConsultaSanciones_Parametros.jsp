<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
 <head></head>

 <body>
<form:form modelAttribute="sancionesForm" action="processParamSanciones.htm" method="post">
 <table width="100%">
  <tr>
	<td>
	    <!-- titulo -->
		<table width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><br><spring:message code="avaluos.sanciones.titulo"></spring:message><br><br></td>
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
					  <form:input path="unidad.claveUnidadValuacion" cssClass="k-textbox"  />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.unidad.valuacion"></spring:message> </td>
			<td width="60%" align="left">
				<form:select id="selectUV" path="unidad.nombreUnidadValuacion" >
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
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf" />  </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="unidad.claveSHF" size="30" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
			<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.siglas"/> </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="unidad.siglas" size="20" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td align="center" colspan="4"><spring:message code="avaluos.titulo.cobertura"/></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estado.cobertura"/></td>
			<td width="60%" align="left">
				<form:select id="selectEstadosCobertura" path="cobertura.estado">
				 <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
				 <form:options items="${estados}"/>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><spring:message code="avaluos.titulo.controlador"/> </td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf" /></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="controlador.claveSHF" onblur="upper(this);" size="30"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre" /> </td>
			<td width="60%" align="left">
			    <form:input id="apellidoPaternoControlador" cssClass="k-textbox" path="controlador.apellidoPaterno"  size="30" onblur="upper(this);"/> &nbsp; <form:input id="apellidoMaternoControlador" cssClass="k-textbox" path="controlador.apellidoMaterno" size="30" onblur="upper(this);"/> &nbsp; <form:input  id="nombreControlador" cssClass="k-textbox" path="controlador.nombre" onblur="upper(this);" size="30"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><spring:message code="avaluos.titulo.perito" /></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf"/></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="perito.claveSHF" onblur="upper(this);" size="30"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre"/> </td>
			<td width="60%" align="left">
			    <form:input id="apellidoPaternoPerito" cssClass="k-textbox" path="perito.apellidoPaterno" onblur="upper(this);" size="30"/> &nbsp; <form:input id="apellidoMaternoPerito" cssClass="k-textbox" path="perito.apellidoMaterno" onblur="upper(this);"  size="30"/> &nbsp; <form:input id="nombrePerito" cssClass="k-textbox" path="perito.nombre" onblur="upper(this);" size="30"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><spring:message code="avaluos.titulo.generico.sanciones" /></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.sanciones.fecha.sancion"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/>: <form:input id="fechaSancionInicio" path="sancion.fechaSancionInicio" size="10"/> <spring:message code="avaluos.titulo.generico.rangos.al"/>: <form:input id="fechaSancionFin"  path="sancion.fechaSancionFin" size="10" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.sanciones.tipo.sancion"/></td>
			<td width="60%" align="left">
				<form:select id="selectTipoSancion" path="sancion.tipoSancion">
				 <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
				 <form:options items="${tipoSancion}"/>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.sanciones.sancionado"/></td>
			<td width="60%" align="left">
				<form:select id="selectSancionado" path="sancion.sancionado">
				 <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
				 <form:options items="${sancionados}"/>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.sanciones.estatus.sancion"/></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusSancion" path="sancion.estatusSancion">
				 <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
				 <form:options items="${estatusSancion}"/>
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
	$("[id^=\"nombre\"]").each(function(index){
	   var id = this.id;
	   $("#"+id).attr("value","NOMBRE");
	});
	$("[id^=\"apellidoPaterno\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).attr("value","PATERNO");
	});
	$("[id^=\"apellidoMaterno\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).attr("value","MATERNO");
	});
	
	
});
</script>
 
</html>
