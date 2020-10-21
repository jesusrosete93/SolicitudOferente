<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
</head>
<style>
.k-grid-toolbar a {
    float:left;
}


</style>

<body>
<input type="hidden" id="columnas" value="<core:out value='${columnasJson}' />">
<input type="hidden" id="reporte" value="<core:out value='${registrosJson}' />">

<div style="width: 1100px">
<table id="datos">
 <thead>
 	 <tr>
      <core:forEach items="${columnas}" var="k">
        <th><core:out value="${k}"></core:out></th>
      </core:forEach>
    </tr>
 </thead>
 <tbody>
 	<core:forEach items="${registros}" var="registro">
 	<tr>
    	<core:forEach var="dato" items="${registro}">
	 		<td><core:out value="${dato}"></core:out> </td>
 		</core:forEach>
 	</tr>
 </core:forEach>
 </tbody>
 </table>
 <table>
 	<tr>
 		<td><button id="nuevaConsulta" class="k-button">Nueva consulta</button> </td>
 		<td><button id="cancelacion" class="k-button">Cancelar</button> </td>
 	</tr>
 </table>
 </div>
 <form id="peticiones" action=""></form>
</body>
<script>
$(document).ready(function () {

  $("#datos").kendoGrid({
  		toolbar: [
   	    {name:"excel",text:"Exportar a Excel"}],
   	    dataSource:{ pageSize:5},
   		pageable: {
            pageSizes: [5,10,50,100,200],
            buttonCount: 5
        },
  		excel: {
        	allPages: true
    	},
    	sortable: true,
    	groupable:true,
    	resizable: true
    	
   });
  
    
	
	
    
     
	 
    
	var gridDatos = $("#datos").data("kendoGrid");
	
	//alert("<gridDatos.columns.length"+gridDatos.columns.length);
	
	for(var i=1;i<=gridDatos.columns.length;i++)
	{
		gridDatos.autoFitColumn(i-1);
	}
	$("#nuevaConsulta").click(function(){
     	$("#peticiones").attr("action","initViewConsultaUPC.htm");
     	$("#peticiones").submit();
     });
     $("#cancelacion").click(function(){
     	$("#peticiones").attr("action","welcome.htm");
     	$("#peticiones").submit();
     });
});
</script>
</html>