<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
    <head>
    <!-- CSS  -->
	<link  href="/SolicitudOferenteWeb/kendoUI/styles/kendo.common.min.css" rel="stylesheet"  type="text/css">
	<link  href="/SolicitudOferenteWeb/kendoUI/styles/kendo.blueopal.min.css" rel="stylesheet"  type="text/css" />
	<link  href="/SolicitudOferenteWeb/theme/Master.css" rel="stylesheet"  type="text/css" />
	
	<!-- JS-->
	<script src="/SolicitudOferenteWeb/kendoUI/js/jquery.min.js" type="text/javascript"></script>
	<script src="/SolicitudOferenteWeb/kendoUI/js/jszip.min.js"></script>
	<script src="/SolicitudOferenteWeb/kendoUI/js/kendo.all.min.js"></script>
    <script src="/SolicitudOferenteWeb/kendoUI/js/cultures/kendo.culture.es-MX.min.js"></script>
    <script src="/SolicitudOferenteWeb/kendoUI/js/messages/kendo.messages.es-ES.min.js"></script>
    <script src="/SolicitudOferenteWeb/Js/InputsValidator.js"></script>
    
	
   
     <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <script type="text/javascript">
    	$(document).ready(function () {
        	$("#salida").click(function(){
            	$("#salidaForm").submit();	
            });
    	});
    </script>
    </head>
    <body>
        <form action="logout.htm" id="salidaForm"></form>
        <table cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
            <tr>
		       <td colspan="2" height="10%" width="100%">
		          <tiles:insertAttribute name="header" />
		       </td>
	       </tr>
	       <tr >
	        <td></td>
	        <td  valign="top" align="left" >
	            <tiles:insertAttribute name="menu" />
                </td>
	       </tr>
            <tr>
                <td width="15%" valign="top">
                  <fieldset>
                   <table>
                     <tr>
                     	<td><b><spring:message code="avaluos.texto.usuario.id"/>:</b></td>
                     	<td><sec:authentication property="principal.idUsuario"/><br></td>
                     </tr>
                     <tr>
                      <td><b><spring:message code="avaluos.texto.usuario.nombre"/>:</b></td>
                      <td><sec:authentication property="principal.nombre"/></td>
                     </tr>
                     <tr>
                     	<td><button id="salida" class="k-button"><spring:message code="avaluos.reporteuvs.boton.salida.titulo"></spring:message> </button></td>
                     </tr>	
                   </table>
                   </fieldset>
                </td>
                <td  width="85%" height="80%" valign="top" align="center">
                 <fieldset>
	                        <tiles:insertAttribute name="body" />
	                  </fieldset>
                
                  
                </td>
            </tr>
     </table>
    </body>
</html>
