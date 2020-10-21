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
	
	function setWidth(el)
	{
	    var d = el;
	    var p = d.data("kendoDropDownList").popup.element;
	    var w = p.css("visibility","hidden").show().outerWidth();
	    p.hide().css("visibility","visible");
	    d.closest(".k-widget").width(w);
	}
	
	 
	function displayLoading(target,mostrar) {
        var element = $(target);
        kendo.ui.progress(element,mostrar);
    }
    
     var gridEcoTec;
    

	$(document).ready(function () {
	
		
		function adjustDropDownWidth(e) {
		      var listContainer = e.sender.list.closest(".k-list-container");
		      listContainer.width(listContainer.width() + kendo.support.scrollbar());
		    } 
              $("[id^=\"fecha\"]").each(function(index)
                                        {
							 			  var id = this.id;
									   	  $("#"+id).kendoDatePicker({
														        		  culture: "es-MX",
																	  	  format: "dd-MM-yyyy",
																	  	  interval: 30
										         						});
		      							});
		      							
		    $("[id^=\"select\"]").each(function(index)
                                        {
							 			  var id = this.id;
									   	  $("#"+id).kendoDropDownList({
									   	  	open: adjustDropDownWidth
									   	  });
									   	  var localDropDown = $("#"+id).data("kendoDropDownList");
									      localDropDown.list.width("auto");
		      							});
		      						

       
		    
		      							
		      							
	        $("[id^=\"horaFechaAvance\"]").each(function(index)
                                       {
						 			    var id = this.id;
								   	  $("#"+id).kendoDateTimePicker({
													        		  culture: "es-MX",
																  	  format: "dd-MM-yyyy HH:mm tt",
																  	  interval: 30
									         						});
	      							});
	      	$("[id^=\"horaFechaTecnologias\"]").each(function(index)
                                       {
						 			    var id = this.id;
								   	  $("#"+id).kendoDateTimePicker({
													        		  culture: "es-MX",
																  	  format: "dd-yyyy-MM HH:mm tt",
																  	  interval: 30
									         						});
	      							});
		
	
	
		$("#nuevaBusqueda").click(function(){
				//$('#resultadoConsulta').empty();
				console.log("gridEcoTec:"+gridEcoTec);
				if( gridEcoTec!=null)
            	 {
            	 	$('#resultadoConsulta').kendoGrid('destroy').empty();
            	 }
				$('#errores').empty();
				$('#resultadoConsulta').hide();
				$('#errores').hide();
				$('#busqueda').show();
				gridEcoTec=null;
            	$('#reporteECcoTecnologiaForm')[0].reset();
            });
            
            $("#cancela").click(function(){
            	$("#inicioForm").submit();
            });
            
            $("#busqueda").click(function(e){
            	 //Prevent default submission of form
            	 console.log("gridEcoTec:"+gridEcoTec);
            	 if( gridEcoTec!=null)
            	 {
            	 	$('#resultadoConsulta').kendoGrid('destroy').empty();
            	 }
      			 e.preventDefault();
      			 $.ajax({
						type: 'POST'
						,url:'/SolicitudOferenteWeb/insertarSolicitudExtraccion.json'
						,data: $('#solicitudOferenteExtraccionForm').serialize()
						,dataType: "json"
						,beforeSend: function( )
						{
						    $("#errores").empty();
							$("#errores").hide();
							//console.log("Antes de enviar");
							displayLoading(document.body,true);
							$("#busqueda").prop( "disabled", true );
      			 			$("#nuevaBusqueda").prop( "disabled", true );
      			 			$("#cancela").prop( "disabled", true );		 
						}
						,success : function(res) {
							//console.log("Función success");
							displayLoading(document.body,false);
							$("#busqueda").prop( "disabled", false );
      			 			$("#nuevaBusqueda").prop( "disabled", false );
      			 			$("#cancela").prop( "disabled", false );
         								            if(res.errores)
         								            {
         								            	errorInfo = "";
	         								            	//Set error messages
											               	$.each(res.mensajesError,function(key,value){
											  	            	//$('input[name='+key+']').after('<span class="errorBlock">'+value+'</span>');
											  	            	errorInfo += "<br>" + value;
											  	            });
											  	            $('#errores').html(errorInfo);
											                //$('#info').hide('slow');
											                $('#errores').show();	
										            }else
										            {
										            	 if( res.codigoRespuesta == "0000" )
         								            	 {
		         								           //Set response
		         								           $('#resultadoConsulta').show();
											               $('#busqueda').hide();
											               //$('#resultadoconsulta').html('<div id="resultadoConsulta"></div>');
									               			gridEcoTec = $("#resultadoConsulta").kendoGrid({
									               	    										toolbar: [{name:"excel",text:"Exportar a Excel"}],
																			               		dataSource:{
																			               			data: res.listado
																			               			,pageSize:10
																			               			,schema:{
																			   	    					 model: {
																			   	    								fields:{
																			   	    										 "tecnoDomain.paquete":{type:"string"}
																			   	    										 ,"tecnoDomain.claveTecnologia":{type:"string"}	
																			   	    										 ,"tecnoDomain.anioMES":{type:"string"}
																			   	    										 ,"tecnoDomain.numecotec":{type:"String"}																   	    										
																			   	    								
																			   	    									   } 
																			   	    					 		}	
																			   	    					}
																			   	    				,total: function(response)
																			   	    				{
																			   	    					return response.listado.size;
																			   	    				}
																			               		}
																			               		,pageable: {
																									            pageSizes: [10,20,50,100],
																									            buttonCount: 5
																									        }
																									,columns: [
										                   													 {field: "tecnoDomain.paquete",title:"Paquete",width: 200}
										                   													,{field: "tecnoDomain.claveTecnologia",title:"Clave de tecnologia",width: 200}
										                   													,{field: "tecnoDomain.anioMES",title:"Anio mes",width: 120}
										                   													,{field: "tecnoDomain.numecotec",title:"Numero",width:  80}
										                   													
										                   												  ]
										                   										,excel: {
										       															 allPages: true
										       															,fileName: "ReporteEcoTecnologia_"+kendo.toString(new Date(), 'yyyyMMdd_HHmm')+".xlsx"
										   														}
										                   										,sortable: true
																						    	,filterable:true
																						    	,groupable:true
																						    	,resizable: true	
																			               }).data("kendoGrid");
         								            	 }else
         								            	 {
         								            	 	errorInfo = "<br>"+res.descripcionRespuesta;
											  	            $('#errores').html(errorInfo);
											                $('#errores').show();	
         								            	 }
										            }      			 
      								}
            			});
					});
					
					
		
	});
</script>


</body>
</html>