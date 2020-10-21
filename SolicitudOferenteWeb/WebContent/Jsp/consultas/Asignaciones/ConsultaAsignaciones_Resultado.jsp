<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="mx.org.infonavit.solicitud.oferente.business.CatalogosBusines"%><html>
<head>
</head>
<style>

.k-grid-toolbar a {
    float:left;
}
</style>

<body>
<div style="width: 1000px;">
<table id="datos">
 <thead>
 	 <tr>
      <core:forEach items="${columnas}" var="columna">
        <th><core:out value="${columna}"></core:out></th>
      </core:forEach>
    </tr>
 </thead>
 <tbody>
 	<core:forEach items="${datos}" var="registros">
 	<tr>
    	<core:forEach var="entry" items="${registros}">
	 		<td><core:out value="${entry}"></core:out> </td>
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
    	sortable:true,
    	groupable:true,
    	filterable: true,
    	scrollable: true,
    	height: 400
    	
    	
  });
  

	var gridDatos = $("#datos").data("kendoGrid");
	for(var i=0;i<=gridDatos.columns.length;i++)
	{
		gridDatos.autoFitColumn(i);
	}


     $("#nuevaConsulta").click(function(){
     	$("#peticiones").attr("action","initConsultaAsignaciones.htm");
     	$("#peticiones").submit();
     });
     $("#cancelacion").click(function(){
     	$("#peticiones").attr("action","welcome.htm");
     	$("#peticiones").submit();
     });
});
</script>
</html>