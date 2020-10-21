<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC>
<html>
<head></head>
<body>
<form:form id="formaAvaluos" modelAttribute="consultaAvaluosForm" action="consultaAvaluosParametros.htm" method="post">
<table width="100%">
 <tr>
	<td>
	    <!-- titulo -->
		<table width="100%" border=0>
		<tr>
			<td width="10%"></td>
			<td width="80%" align="center"><h4><spring:message code="avaluos.consultas.avaluo.subtitulo"></spring:message></h4> <br><br></td>
			<td width="10%"></td>
		</tr>
		</table>
	</td>
 </tr>
 <tr>
	<td>
		<table  width="100%" border=0>
		<caption><spring:message code="avaluos.titulo.generico.unidad.valuacion"/></caption>
		<tr><td align="center" colspan="4"><form:errors cssClass="error" path="errores"></form:errors> </td></tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.unidad.valuacion"></spring:message> </td>
			<td width="60%" align="left">
					  <form:input path="unidadValuacion.claveUnidadValuacion" cssClass="k-textbox"  />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.unidad.valuacion.nombre"></spring:message> </td>
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
				  	<button id="quitaTodoUV" class="k-button" type="button" title="Quitar todas las unidades">&lt;&lt;</button>
				  	<button id="quitaUV" class="k-button" type="button" title="Quitar unidad de valuaci&oacute;n">&lt;</button>
				  	<button id="agregaUV" class="k-button" type="button" title="Agregar unidad valuaci&oacute;n">&gt;</button>
				  	<button id="agregaTodoUV" class="k-button" type="button" title="Agregar todas las unidades">&gt;&gt;</button>
				  </td>
				 </tr>
				 <tr>
				      <td><label><spring:message code="avaluos.texto.unidades.valuacion"></spring:message></label></td>
				 </tr>
				 <tr>
				  <td>
				  		<form:select id="unidadesValuacion" path="unidadValuacion.nombreUnidadValuacion" multiple="true" cssStyle="width:700px;" ></form:select>
				  </td>
				 </tr>
				</table>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.recuperada.unidad.valuacion"/></td>
			<td width="60%" align="left"><form:select id="selectRecuperadaUV" path="unidadValuacion.unidadViviendaRecuperada">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="1">Si</form:option>
					  <form:option value="2">No</form:option>
				</form:select>
		    </td>
			<td width="10%" ></td>
		</tr>
		</table>
		<br>
		<table width="100%">
		<caption><spring:message code="avaluos.texto.estados.avaluo"></spring:message> </caption>
		<tr>
		 <td width="10%"></td>
				<td width="20%" align="right"></td>
				<td width="60%" align="left">
					<table>
				    <tr>
				      <td><label><spring:message code="avaluos.texto.catalogo.estados"></spring:message></label></td>
				      <td></td>
				      <td><label><spring:message code="avaluos.texto.estados"></spring:message></label></td>
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
				    <td><form:select id="estadosAvaluo" path="avaluo.estados" multiple="true" cssStyle="width:200px;"></form:select></td>
				  </tr>
				</table>
				</td>
		 <td width="10%" ></td>
		</tr>
		</table>
		<br>
		<table width="100%">
		<caption><spring:message code="avaluos.titulo.avaluo"/></caption>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.codigo.postal"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="vivienda.codigoPostal" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.id.avaluo"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="avaluo.idAvaluo" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.id.conviviencia"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="avaluo.idConviviencia" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.paquete"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="avaluo.paquete" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.vivienda"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" />: <form:input path="avaluo.viviendaInicio" cssClass="k-textbox" />
				<spring:message code="avaluos.titulo.generico.rangos.a" />: <form:input path="avaluo.viviendaFin" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nss"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="vivienda.nss" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.solicitud"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" /><form:input id="fechaSolicitudInicio" path="avaluo.fechaSolicitudInicio" />
				<spring:message code="avaluos.titulo.generico.rangos.a" /><form:input id="fechaSolicitudFin" path="avaluo.fechaSolicitudFin"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.fecha.cierre"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" /><form:input  id="fechaCierreInicio" path="avaluo.fechaCierreInicio" />
				<spring:message code="avaluos.titulo.generico.rangos.a" /><form:input  id="fechaCierreFin" path="avaluo.fechaCierreFin"  />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.valor.concluido"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" /><form:input  path="detalleAvaluo.valorConcluidoInicio" cssClass="k-textbox" />
				<spring:message code="avaluos.titulo.generico.rangos.a" /><form:input   path="detalleAvaluo.valorConcluidoFin" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.metros.terreno"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" /><form:input  path="detalleAvaluo.metrosTerrenoInicio" cssClass="k-textbox" />
				<spring:message code="avaluos.titulo.generico.rangos.a" /><form:input   path="detalleAvaluo.metrosTerrenoFin" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.metros.construccion"></spring:message></td>
			<td width="60%" align="left">
				<spring:message code="avaluos.titulo.generico.rangos.de" /><form:input  path="detalleAvaluo.metrosConstruccionInicio" cssClass="k-textbox" />
				<spring:message code="avaluos.titulo.generico.rangos.a" /><form:input   path="detalleAvaluo.metrosConstruccionFin" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.estatus.avaluo"></spring:message></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusAvaluo" path="avaluo.estatusAvaluo">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					  <form:option value="2">Solicitado</form:option>
					  <form:option value="3">Proceso</form:option>
					  <form:option value="4">Cerrado</form:option>
					  <form:option value="7">solicitud de pago</form:option>

					  
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.tipo.mercado"></spring:message></td>
			<td width="60%" align="left">
				<form:select id="selectTipoMercado" path="avaluo.tipoMercado">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					  <form:option value="1">Paquete</form:option>
					  <form:option value="2">Mercado Abierto</form:option>
					  <form:option value="3">Linea III</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		</table>
		<br>
		<table width="100%">
		<caption><spring:message code="avaluos.titulo.controlador"/></caption>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="controlador.claveSHF" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre"></spring:message></td>
			<td width="60%" align="left">
				<form:input id="apellidoPaternoControlador" path="controlador.apellidoPaterno" cssClass="k-textbox" onblur="upper(this);"/> <form:input id="apellidoMaternoControlador" path="controlador.apellidoMaterno" cssClass="k-textbox" onblur="upper(this);" /> <form:input id="nombreControlador" path="controlador.nombre" cssClass="k-textbox" onblur="upper(this);" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.controlador.estatus"></spring:message></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusControlador" path="controlador.estatusControlador">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					  <form:option value="19">Activo</form:option>
					  <form:option value="20">Inactivo</form:option>
				</form:select>
			</td>
			<td width="10%" ></td>
		</tr>
		</table>
		<br>
		<table width="100%">
		<caption><spring:message code="avaluos.titulo.perito"/></caption>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.clave.shf"></spring:message></td>
			<td width="60%" align="left">
				<form:input path="perito.claveSHF" cssClass="k-textbox" />
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.nombre"></spring:message></td>
			<td width="60%" align="left">
				<form:input  id="apellidoPaternoPerito" path="perito.apellidoPaterno" cssClass="k-textbox" onblur="upper(this);" /> <form:input id="apellidoMaternoPerito" path="perito.apellidoMaterno" cssClass="k-textbox" onblur="upper(this);" /> <form:input  id="nombrePerito" path="perito.nombre" cssClass="k-textbox"  onblur="upper(this);"/>
			</td>
			<td width="10%" ></td>
		</tr>
		<tr>
			<td width="10%"></td>
			<td width="20%" align="right"><spring:message code="avaluos.titulo.generico.perito.estatus"></spring:message></td>
			<td width="60%" align="left">
				<form:select id="selectEstatusPerito" path="perito.estatusPerito">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"></spring:message></form:option>
					  <form:option value="19">Activo</form:option>
					  <form:option value="20">Inactivo</form:option>
				</form:select>			</td>
			<td width="10%" ></td>
		</tr>
		</table>	
		</td>
		</tr>
	<tr><td align="center" colspan="4"><button class="k-button" type="submit"><spring:message code="avaluos.titulo.generico.boton.consultar"/></button> </td> </tr>		
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

	  /*$("#selectUV").kendoDropDownList({
	        filter: "contains"
	   });
	   setWidth($("#selectUV"));*/
	$("[id^=\"select\"]").each(function(index){
	
	   var id = this.id;
	   $("#"+id).kendoDropDownList({
	   		filter: "contains"
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
	
	
	$("#quitaTodo").click(function(){
	    moverTodos("#estadosAvaluo","#catalogoEstados");
	    ordenarUnidades("#catalogoEstados");
		marcarTodo("#estadosAvaluo");
		desMarcarTodo("#catalogoEstados");
	});
	$("#agregaTodo").click(function(){
		moverTodos("#catalogoEstados","#estadosAvaluo");
		ordenarUnidades("#estadosAvaluo");
		marcarTodo("#estadosAvaluo");
		desMarcarTodo("#catalogoEstados");
	});
	$("#quitaEstado").click(function(){
		moverElemento("#estadosAvaluo","#catalogoEstados");
		ordenarEstados("#catalogoEstados");
		marcarTodo("#estadosAvaluo");
		desMarcarTodo("#catalogoEstados");
	});
	$("#agregaEstado").click(function(){
		moverElemento("#catalogoEstados","#estadosAvaluo");
		ordenarEstados("#estadosAvaluo");
		marcarTodo("#estadosAvaluo");
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
	
	
	$("#formaAvaluos").submit(function(){
		marcarTodo("#unidadesValuacion");
		marcarTodo("#estadosAvaluo");
		desMarcarTodo("#catalogoUnidades");
		desMarcarTodo("#catalogoEstados");
	  displayLoading(document.body);
	});
});
</script>

</html>
