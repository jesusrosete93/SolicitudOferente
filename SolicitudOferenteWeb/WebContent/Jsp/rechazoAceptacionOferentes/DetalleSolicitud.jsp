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

<p style="font-family: Arial, sans-serif; font-size:11pt; font-style:small;" align="center">Solicitud de Cancelacion.</p>
<form id="inicioForm" action="welcome.htm"></form>
<form:form id="solicitudOferenteCancelacionForm" modelAttribute="solicitudCancelacion"> 
<div id="errores" class="errorblock" align="center" style="display: none">

</div>
</br>
</br>
<div cssStyle="width: 150%">
	<table align="center" cssStyle="width: 150%">
	
	
					<tr>
	     <td colspan="1" align="right" ><spring:message code="avaluos.texto.estado" /></td>
	  	  <td colspan="1" align="left" >
	  	  	<form:select id="selectEstado" path="id_estado" >
	  	  		<form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
	  	  		<form:options items="${estados}"/>
	  	  	</form:select>
	  	  </td>
  	 	</tr>
  	 	
  	 						<tr>
	     <td><spring:message code="solicitud.aceptacion.rechazo.seleccion" /></td>
<td>
				<form:select id="selectRecuperadaUV" path="">
					  <form:option value="-1"><spring:message code="avaluos.texto.generico.selects.default"/></form:option>
					  <form:option value="1">Aprobacion</form:option>
					  <form:option value="2">Rechazo</form:option>
				</form:select></td>
  	 	</tr>
	
	
  	 	<td height="21"></td>
  	 	<td height="21"/></td>

	<td height="21" style="height: 21px">
<p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">Datos Oferente</p>
					</td>
				</tr>
  	 	
  	 	  	 	  	 		  	 	<tr>

  	 	  	 	<td height="19"></td>
  	 	<td height="19"/></td>
  	 	
<td height="19"><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>

		<tr>
	      <td  ><spring:message code="solicitud.oferente.titulo.generico.atributo.idOferente" /></td>
	  	  <td  ><form:input path="id_oferente" cssClass="k-textbox" cssStyle="width: 150%" /></td>
	  	  
	  	  <td align="right"><spring:message code="avaluos.titulo.generico.rfc" /></td>
	  	  <td width="55"><form:input cssClass="k-textbox" path="rfc_oferente" cssStyle="width: 100%"  /></td>
	  	  
	  	  </tr>
	  	  
  	 	<tr>
	     <td ><spring:message code="solicitud.oferente.titulo.generico.genera.nombreOferente" /></td>
	  	  <td ><form:input cssClass="k-textbox" path="nombre_razon_social" cssStyle="width: 150%" /></td>
  	 	</tr>

  	 	
  	  	 	<tr>
  	 	<td></td>
  	 	<td /></td>
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">Datos de Oferta</p></td>
  	 	
  	 	</tr>
  	 	
  	 		<tr>

  	 	  	 	<td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center">

</p></td>
  	 	</tr>

  	 	<tr>
	     <td ><spring:message code="solicitud.oferente.titulo.generico.atributo.idOferta" /></td>
	  	  <td colspan="2" ><form:input path="id_oferta_vivienda" cssClass="k-textbox" cssStyle="width: 135%" /></td>

  	 	  
	  	  


  	 	<tr>
  	 	
	     <td ><spring:message code="solicitud.oferente.titulo.generico.atributo.nombreFrente" /></td>
	  	  <td colspan="2"><form:input cssClass="k-textbox" path="nombre_frente" cssStyle="width: 135%" /></td>

		
  	 	</tr>
  	 	
  	 	
  	 	<td ><spring:message code="solicitud.oferente.titulo.generico.atributo.ordenVerificacion" /></td>
	  	  <td colspan="2" ><form:input cssClass="k-textbox" path="id_orden_verificacion"  cssStyle="width: 135%" /></td>
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
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="center">Datos de Cancelación</p></td>
  	 	
  	 	</tr>
  	 	
 
  	 	

  	 	  	 		<tr>
	     <td ><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroPaquetes" /></td>
	  	  <td  ><form:input cssClass="k-textbox" path="id_paquete" cssStyle="width: 80%" /></td>

	<td ><spring:message code="solicitud.oferente.titulo.generico.atributo.numeroActualViviendas" /></td>
					<td width="55" style="width: 55px"><form:input
							cssClass="k-textbox" path="num_viviendas_declinacion_modificacion" />
					</td>

				</tr>
  	 	
 	<tr>
 	
 	<tr>
        <td></td>
  	 	<td /></td>
  	 	
<td ><p style="font-family: times, serif; font-size:10pt; font-style:normal;" align="center"></p>
         </td>
  	 	</tr>
 	
  	 	<td></td>
  	 	<td /></td>
  	 	
  	 <td ><p style="font-family: Arial, sans-serif; font-size:10pt; font-style:small;" align="left">Comentarios</p>
  	 </td>
  	 	</tr>
 
  	 	<tr>
	  	  <td colspan="4" align="center"> <textarea name="comentarios"rows="3" cols="100">Escribe aquí tus comentarios</textarea></td>
  	 	</tr>
  	 	
		<div  >
       <td > <textarea hidden=""  name="id_tipo_solicitud">4</textarea ></td>
       </div>
       

	
	 <tr>
	   <td colspan="4" align="center">
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


<div style="width: 1000px">
<div id="resultadoConsulta" align="center" class="desc" style="display:none;"></div>
</div>
</form:form>




<script type="text/javascript">



	function setWidth(el)
	{
	   
	}

	function displayLoading(target,mostrar) {
        var element = $(target);
        kendo.ui.progress(element,mostrar);
    }
    
       var gridEcoTec;
    
    
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
						,url:'/SolicitudOferenteWeb/insertarSolicitudCancelacion.json'
						,data: $('#solicitudOferenteCancelacionForm').serialize()
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
         								            
										           
								
								}		            	
            			});
					});
					
					
		
	
</script>
	

</body>
</html>