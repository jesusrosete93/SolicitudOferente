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

<form id="inicioForm" action="welcome.htm"></form>
<form:form id="solicitudOferenteBusquedaForm" modelAttribute="reporteSolicitudOferente"> 
<div id="errores" class="errorblock" align="center" style="display: none">
</div>
<div>
	<table align="center">
		<tr>
	     <td align="right" colspan="2"><spring:message code="solicitud.oferente.titulo.generico.atributo.estatus" /></td>
	  	  <td align="left" >
	  	  <form:input path="id_estatus" cssClass="k-textbox"  />	  	  	
	  	  </td>
  	 	</tr>
  	 	<tr>
	     <td align="right" colspan="2"><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroPaquetes" /></td>
	  	  <td align="left" ><form:input cssClass="k-textbox" path="id_paquete"  /></td>
  	 	</tr>
  	 	
  	 	<tr>
	     <td align="right" colspan="2"><spring:message code="solicitud.oferente.titulo.generico.atributo.tipo.solicitud" /></td>
	  	  <td align="left" ><form:input cssClass="k-textbox" path="id_tipo_solicitud"  /></td>
  	 	</tr>

  	 	 <tr>
	  	 <td align="left"><spring:message code="avaluos.titulo.reportes.eco.fecha.solicitud"/></td>
	  	 <td align="right"><spring:message code="avaluos.titulo.reportes.eco.rangos.de"/></td>
	  	 <td align="left"><input id="fechaInicio" name="fechaSolicitudInicio"/></td>
	  	 <td align="right"><spring:message code="avaluos.titulo.reportes.eco.rangos.a"/></td>
	  	 <td align="left"><input id="fechaFin" name="fechaSolicitudFin"/></td>
	  </tr>
	  
	  <td align="right" colspan="2"><spring:message code="avaluos.texto.estado" /></td>
	  	  <td align="left" colspan="3">
	  	  	<form:select id="selectEstado" path="id_estado" cssStyle="width: 100%">
	  	  		<form:option value=""><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
	  	  		<form:options items="${estados}"/>
	  	  	</form:select>
	  	  </td>

	  
	 <tr>
	   <td colspan="5" align="center">
	   	<table>
	   	 <tr>
	   	 	<td align="center"><button type="button" id="busqueda" class="k-button"><spring:message code="avaluos.titulo.generico.genera.reporte"/></button></td>
			<td align="center"><button type="button" id="nuevaBusqueda" class="k-button"><spring:message code="avaluos.titulo.generico.boton.nuevo.reporte"/></button></td>
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
    
     var gridSolOfe;
    

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
	      							
	      							
	      							
	      	 $(document).ready(function () {
          var crudServiceBaseUrl = "/SolicitudOferenteWeb",
              kendoGrid = new kendo.data.DataSource({
                transport: {
                  read:  {
                    url: crudServiceBaseUrl + "/Products",
                    dataType: "jsonp"
                  },
                  update: {
                    url: crudServiceBaseUrl + "/showDetailEmpresa.htm",
                    dataType: "json"
                  },
                  destroy: {
                    url: crudServiceBaseUrl + "/Products/Destroy",
                    dataType: "jsonp"
                  },
                  create: {
                    url: crudServiceBaseUrl + "/Products/Create",
                    dataType: "jsonp"
                  },
                  parameterMap: function(options, operation) {
                    if (operation !== "read" && options.models) {
                      return {models: kendo.stringify(options.models)};
                    }
                  }
                },
          
              });
			  
	      	






	
	
		$("#nuevaBusqueda").click(function(){
				//$('#resultadoConsulta').empty();
				console.log("gridSolOfe:"+gridSolOfe);
				if( gridSolOfe!=null)
            	 {
            	 	$('#resultadoConsulta').kendoGrid('destroy').empty();
            	 }
				$('#errores').empty();
				$('#resultadoConsulta').hide();
				$('#errores').hide();
				$('#busqueda').show();
				gridSolOfe=null;
            	$('#solicitudOferenteBusquedaForm')[0].reset();
            });
            
            $("#cancela").click(function(){
            	$("#inicioForm").submit();
            });
            
            $("#busqueda").click(function(e){
            	 //Prevent default submission of form
            	 console.log("gridSolOfe:"+gridSolOfe);
            	 if( gridSolOfe!=null)
            	 {
            	 	$('#resultadoConsulta').kendoGrid('destroy').empty();
            	 }
      			 e.preventDefault();
      			 $.ajax({
						type: 'POST'
						,url:'/SolicitudOferenteWeb/reporteSolicitudOfernte.json'
						,data: $('#solicitudOferenteBusquedaForm').serialize()
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
											               
		                             	 $("#Id").click(function(){
  											  var tr = $(this).closest('tr');
 												   var rowItem = grid.dataItem(tr);
  													 var id = rowItem.id;
  									  window.location.href = "/SolicitudOferenteWeb/showDetailEmpresa.htm?"+id;
																});		
											                
         						               
									               			gridSolOfe = $("#resultadoConsulta").kendoGrid({
									               	    										toolbar: [{name:"excel",text:"Exportar a Excel"}],
																			               		dataSource:{
																			               			data: res.listado
																			               			,pageSize:10
																			               			,schema:{
																			   	    					 model: {
																			   	    								fields:{  
																			   	    								          "solicitudOferenteDomain.id_solicitud":{type:"string"}
																			   	    										 ,"solicitudOferenteDomain.id_tipo_solicitud":{type:"string"}	
																			   	    										 ,"solicitudOferenteDomain.fecha_solicitud":{type:"string"}
																			   	    										  ,"solicitudOferenteDomain.id_oferente":{type:"string"}
																			   	    										  ,"solicitudOferenteDomain.nombre_razon_social":{type:"string"}
																			   	    										  ,"solicitudOferenteDomain.id_estado":{type:"string"}
																			   	    										   ,"solicitudOferenteDomain.id_paquete":{type:"string"}
																			   	    									       ,"solicitudOferenteDomain.id_oferta_vivienda":{type:"string"}
																			   	    										 ,"solicitudOferenteDomain.id_estatus":{type:"String"}																   	    										
																			   	    								
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
																												
																											 
																										     {field: "solicitudOferenteDomain.id_solicitud",title:"ID solicitud",width: 70}
										                   													,{field: "solicitudOferenteDomain.id_tipo_solicitud",title:"Tipo solicitud",width: 70}
										                   													,{field: "solicitudOferenteDomain.fecha_solicitud",title:"Fecha Solicitud",width: 100}
										                   													,{field: "solicitudOferenteDomain.id_oferente",title:"ID Oferente",width: 80}
										                   													,{field: "solicitudOferenteDomain.nombre_razon_social",title:"Razon Social",width: 100}
										                   													,{field: "solicitudOferenteDomain.id_estado",title:"Estado",width: 80}
										                   													,{field: "solicitudOferenteDomain.id_paquete",title:"Paquete",width: 60}
										                   													,{field: "solicitudOferenteDomain.id_oferta_vivienda",title:"Oferta",width: 60}
										                   													,{field: "solicitudOferenteDomain.id_estatus",title:"Estatus",width:  60},
										                   													
										                   												  ],
										                   												     editable: "inline"
										                   										,excel: {
										       															 allPages: true
										       															,fileName: "ConsultaSlicitudOferente_"+kendo.toString(new Date(), 'yyyyMMdd_HHmm')+".xlsx"
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
	
    });
	
	  
</script>
	
	
	
	
</body>
</html>