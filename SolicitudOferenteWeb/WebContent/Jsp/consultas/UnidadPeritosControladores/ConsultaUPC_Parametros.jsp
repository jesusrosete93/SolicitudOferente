<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form:form  id="formaUPC" modelAttribute="consultaUPCForm" action="parametrosConsultaUPC.htm" method="POST">



<table width="100%">
  <tr>
	<td>
	   <table width="100%">
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><br><spring:message code="avaluos.consultas.upc.subtitulo"/><br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr><td align="center"><form:errors cssClass="error" path="errores"></form:errors> </td></tr>
 <tr>
	<td>
	    <!-- Detalle -->
		<table  width="100%" align="center">
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.unidad.valuacion"/> </td>
			<td width="60%" align="left"><form:input  cssClass="k-textbox" path="unidadValuacionForm.claveUnidadValuacion" size="10"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right" valign="middle"><spring:message code="avaluos.titulo.generico.unidad.valuacion.nombre"></spring:message> </td>
			<td width="60%" align="left">
				<table>
				 <tr>
				      <td><label><spring:message code="avaluos.texto.catalogo.unidades"></spring:message></label></td>
				 </tr>
				 <tr>
				  <td>
				  		<select id="catalogoUnidades" multiple="multiple" style="width:700px;">
						 <core:forEach items="${unidades}" var="unidad">
						  <option value="${unidad.key}"><core:out value="${unidad.key}"/>-<core:out value="${unidad.value}"/></option>
						 </core:forEach> 
						</select>
				  </td>
				 </tr>
				 <tr>
				  <td colspan="2" align="center">
				  	<button id="quitaTodoUV" class="k-button" type="button" title="Quitar estado">&lt;&lt;</button>
				  	<button id="quitaUV" class="k-button" type="button" title="Quitar todos">&lt;</button>
				  	<button id="agregaUV" class="k-button" type="button" title="Quitar estado">&gt;</button>
				  	<button id="agregaTodoUV" class="k-button" type="button" title="Agregar estado">&gt;&gt;</button>
				  </td>
				 </tr>
				 <tr>
				      <td><label><spring:message code="avaluos.texto.unidades.valuacion"></spring:message></label></td>
				 </tr>
				 <tr>
				  <td>
				  		<form:select id="unidadesValuacion" path="unidadValuacionForm.nombreUnidadValuacion" multiple="true" cssStyle="width:700px;" ></form:select>
				  </td>
				 </tr>
				</table>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estatus.unidad.valuacion" /> </td>
			<td width="60%" align="left">
				<form:select id="selectEstatusUV" path="unidadValuacionForm.estatusUnidadValuacion">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="19">Activo</form:option>
					  <form:option value="20">Inactivo</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.vigencia"></spring:message> </td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/>: <form:input  id="fechaVigenciaUnidadInicio" path="unidadValuacionForm.fechaVigenciaInicio" size="10"/> <spring:message code="avaluos.titulo.generico.rangos.al"/>: <form:input id="fechaVigenciaUnidadFin" path="unidadValuacionForm.fechaVigenciaFin" size="10"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf" />  </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="unidadValuacionForm.claveSHF" size="30" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.siglas"/> </td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="unidadValuacionForm.siglas" size="20" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.recuperada.unidad.valuacion" /> </td>
			<td width="60%" align="left">
				<form:select id="selectRecuperadaUV" path="unidadValuacionForm.unidadViviendaRecuperada">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="1">Si</form:option>
					  <form:option value="2">No</form:option>
				</form:select></td>
			<td width="10%" ></td>
		</tr>
		</table>
	 <!--  -->
		<table  width="100%">
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><spring:message code="avaluos.titulo.cobertura"/></td>
			<td width="10%" ></td>
		</tr>
		</table>

		<table  width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estado.cobertura"/></td>
			<td width="60%" align="left">
				<table>
				    <tr>
				      <td><label>Catalogo estados</label></td>
				      <td></td>
				      <td><label>Estados cobertura</label></td>
				    </tr>
				    <tr>
				    <td>
				        <select id="catalogoEstados" multiple="multiple" style="width:200px;">
						 <core:forEach items="${estados}" var="estado">
						  <option value="${estado.key}"><core:out value="${estado.value}"></core:out> </option>
						 </core:forEach> 
						</select>
				    </td>
				    <td>
				        <table>
				          <tr>
				              <td align="right">
				               <button id="quitaTodo" class="k-button" type="button" title="Quitar estado">&lt;&lt;</button>
				    		  </td>
				    		  <td align="left">
				    		  	<button id="agregaTodo" class="k-button" type="button" title="Agregar estado">&gt;&gt;</button>
				    		   </td>
				          </tr>
				          <tr>
				            <td align="right">
				              <button id="quitaEstado" class="k-button" type="button" title="Quitar todos">&lt;</button>
				            </td>
				            <td align="left">  
				    		  <button id="agregaEstado" class="k-button" type="button" title="Quitar estado">&gt;</button>
				            </td>
				          </tr>
				        </table>
				    </td>
				    <td><form:select id="estadosCobertura" path="coberturaForm.estados" multiple="true" cssStyle="width:200px;"></form:select></td>
				  </tr>
				</table>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estatus.cobertura"/> </td>
			<td width="60%" align="left">
				<form:select id="selectEstatusCobertura" path="coberturaForm.estatus">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="21">Activo</form:option>
					  <form:option value="22">Inactivo</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		</table>
		<table  width="100%">
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><spring:message code="avaluos.titulo.controlador"/> </td>
			<td width="10%" ></td>
		</tr>
		</table>
		<table  width="100%">
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf" /></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="controladorForm.claveSHF" onblur="upper(this);" size="30"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre" /> </td>
			<td width="60%" align="left">
			    <form:input id="apellidoPaternoControlador" cssClass="k-textbox" path="controladorForm.apellidoPaterno"  size="30" onblur="upper(this);"/> &nbsp; <form:input id="apellidoMaternoControlador" cssClass="k-textbox" path="controladorForm.apellidoMaterno" size="30" onblur="upper(this);"/> &nbsp; <form:input  id="nombreControlador" cssClass="k-textbox" path="controladorForm.nombre" onblur="upper(this);" size="30"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.curp" /></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="controladorForm.curp" size="40" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.rfc" /></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="controladorForm.rfc" size="30" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.vigencia"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/>: <form:input id="fechaVigenciaControladorInicio" path="controladorForm.fechaVigenciaInicio" size="10"/> <spring:message code="avaluos.titulo.generico.rangos.al"/>: <form:input id="fechaVigenciaControladorFin"  path="controladorForm.fechaVigenciaFin" size="10" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.controlador.estatus" /></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusControlador" path="controladorForm.estatusControlador">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default" /> </form:option>
					  <form:option value="50">Activo</form:option>
					  <form:option value="51">Inactivo</form:option>
				</form:select>
			</td>
		<td width="10%" ></td>
		</tr>
		</table>
		<table  width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><spring:message code="avaluos.titulo.perito" /></td>
			<td width="10%" ></td>
		</tr>
		</table>

		<table  width="100%" border=0>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf"/></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="peritoForm.claveSHF" onblur="upper(this);" size="30"/></td>
			<td width="10%" ></td>
		</tr>

		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre"/> </td>
			<td width="60%" align="left">
			    <form:input id="apellidoPaternoPerito" cssClass="k-textbox" path="peritoForm.apellidoPaterno" onblur="upper(this);" size="30"/> &nbsp; <form:input id="apellidoMaternoPerito" cssClass="k-textbox" path="peritoForm.apellidoMaterno" onblur="upper(this);"  size="30"/> &nbsp; <form:input id="nombrePerito" cssClass="k-textbox" path="peritoForm.nombre" onblur="upper(this);" size="30"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.curp"/></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="peritoForm.curp" onblur="upper(this);"  size="40"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.rfc"></spring:message></td>
			<td width="60%" align="left"><form:input cssClass="k-textbox" path="peritoForm.rfc" onblur="upper(this);" size="30"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.vigencia"/></td>
			<td width="60%" align="left"><spring:message code="avaluos.titulo.generico.rangos.del"/><form:input id="fechaVigenciaPeritoInicio" path="peritoForm.fechaVigenciaInicio" onblur="upper(this);" size="20"/><spring:message code="avaluos.titulo.generico.rangos.al"/><form:input id="fechaVigenciaPeritoFin"  path="peritoForm.fechaVigenciaFin" size="10" onblur="upper(this);"/></td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message  code="avaluos.titulo.generico.perito.estatus"/></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusP" path="peritoForm.estatusPerito">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="40">Activo</form:option>
					  <form:option value="41">Inactivo</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr><td align="center"><button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/> </button> </td> </tr>
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
function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
    }
    
$(document).ready(function() {
	
		$("[id^=\"select\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDropDownList({
	   		filter: "conatins"
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
	
	function ordenarUnidades(elemento){
		 //alert("iniciando ordenamiento....");
		 var options = $(elemento +" option");
    	 var arr = options.map(function(_, o) {
    	 						return {
    	                        	t: $(o).text(),
    	                        	v: o.value
						        };
    		}).get();
    	arr.sort(function(o1, o2) {
    	//alert("o1: "+o1.t+ " o2: "+o2.t);
    	//alert("texto a ordenar: "+o1.t.substring(o1.t.indexOf("-")+1,o1.t.length) + " y "+o2.t.substring(o2.t.indexOf("-")+1,o2.t.length));
        //return o1.t > o2.t ? 1 : o1.t < o2.t ? -1 : 0;
        return o1.t.substring(o1.t.indexOf("-")+1,o1.t.length) > o2.t.substring(o2.t.indexOf("-")+1,o2.t.length) ? 1 : o1.t.substring(o1.t.indexOf("-")+1,o1.t.length) < o2.t.substring(o2.t.indexOf("-")+1,o2.t.length) ? -1 : 0;
    	});
	    options.each(function(i, o) {
	        //alert(i);
	        o.value = arr[i].v;
	        $(o).text(arr[i].t);
	    });
	}
	
	function ordenarEstados(elemento){
		 //alert("iniciando ordenamiento....");
		 var options = $(elemento +" option");
    	 var arr = options.map(function(_, o) {
						        return {
						            t: $(o).text(),
						            v: o.value
						        };
    		}).get();
    	arr.sort(function(o1, o2) {
        return o1.t > o2.t ? 1 : o1.t < o2.t ? -1 : 0;
    	});
	    options.each(function(i, o) {
	        //alert(i);
	        o.value = arr[i].v;
	        $(o).text(arr[i].t);
	    });
	}
	 
    function moverElemento(origen,destino){
        $(origen).find(":selected").appendTo(destino);	
	}
	function moverTodos(origen,destino){
		$(origen).children().appendTo(destino);	
	}
	
	function marcarTodo(elemento){
		 $(elemento+" option").prop("selected", true);
	}
	function desMarcarTodo(elemento){
		 $(elemento+" option").prop("selected", false);
	}
	
	
	//Estados de cobertura - - - - - - - - - - - - - 
	$("#quitaTodo").click(function(){
	    moverTodos("#estadosCobertura","#catalogoEstados");
	    ordenarUnidades("#catalogoEstados");
		marcarTodo("#estadosCobertura");
		desMarcarTodo("#catalogoEstados");
	   
	});
	$("#agregaTodo").click(function(){
		moverTodos("#catalogoEstados","#estadosCobertura");
		ordenarUnidades("#estadosCobertura");
		marcarTodo("#estadosCobertura");
		desMarcarTodo("#catalogoEstados");
		
	});
	$("#quitaEstado").click(function(){
		moverElemento("#estadosCobertura","#catalogoEstados");
		ordenarEstados("#catalogoEstados");
		marcarTodo("#estadosCobertura");
		desMarcarTodo("#catalogoEstados");
	});
	$("#agregaEstado").click(function(){
		moverElemento("#catalogoEstados","#estadosCobertura");
		ordenarEstados("#estadosCobertura");
		marcarTodo("#estadosCobertura");
		desMarcarTodo("#catalogoEstados");
	});
	
	//Unidades valuación - - - - -
	$("#quitaTodoUV").click(function(){
	    moverTodos("#unidadesValuacion","#catalogoUnidades");
	    ordenarUnidades("#catalogoUnidades");
		marcarTodo("#unidadesValuacion");
		desMarcarTodo("#catalogoUnidades");
	});
	$("#agregaTodoUV").click(function(){
		moverTodos("#catalogoUnidades","#unidadesValuacion");
		ordenarUnidades("#unidadesValuacion");
		marcarTodo("#unidadesValuacion");
		desMarcarTodo("#catalogoUnidades");
	});
	$("#quitaUV").click(function(){
		moverElemento("#unidadesValuacion","#catalogoUnidades");
		ordenarUnidades("#catalogoUnidades");
		marcarTodo("#unidadesValuacion");
		desMarcarTodo("#catalogoUnidades");
	});
	$("#agregaUV").click(function(){
		moverElemento("#catalogoUnidades","#unidadesValuacion");
		ordenarUnidades("#unidadesValuacion");
		marcarTodo("#unidadesValuacion");
		desMarcarTodo("#catalogoUnidades");
	});
	
	
	
	
	
	
	 
	
	$("#formaUPC").submit(function(){
		marcarTodo("#unidadesValuacion");
		marcarTodo("#estadosCobertura");
		desMarcarTodo("#catalogoUnidades");
		desMarcarTodo("#catalogoEstados");
	  displayLoading(document.body);
	});
	
});
</script>
</html>