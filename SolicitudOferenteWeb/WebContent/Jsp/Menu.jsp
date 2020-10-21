<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<HEAD>

</HEAD>
<style>
body
{
    min-height: 100%;
    margin: 0;
    font: 14px sans-serif;
}
div.k-loading-mask
{
    z-index: 3; /* must be larger than the z-index:2 of #container */
}
</style>
<script type="text/javascript">

function displayLoading(target) {
        var element = $(target);
        kendo.ui.progress(element, true);
}

function enviar(valor)
{
    displayLoading(document.body);
	$("#menuForm").attr("action",valor);
    $("#menuForm").submit();
}

$(document).ready(function () {
	$("#menu").kendoMenu({
	   orientation: "horizontal"
	   /*select: function(e) {
	   			 console.log("Texto: "+$(e.item).text() + $(e.item).hasClass( "opcion" ));
	   			 if( $(e.item).hasClass( "opcion" ) )
	   			 {
	   			   displayLoading(document.body);
	   			 }

          	   }*/
	 });
});
</script>
<BODY class="k-content">
<form id="menuForm" method="get">
<ul id="menu">
 <sec:authorize access="hasAnyRole('AVATAB_USER')">
     <li><spring:message code="oferentes.texto.envio.SolicitudOferente.solicitud" />
          <ul>
		  
			<li class="opcion" onclick="enviar('initSolicitudExtraccionOferente.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.solicitud.extraccion" /></li>
			
			<li class="opcion" onclick="enviar('initSolicitudModificacionOferente.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.solicitud.modificacion" /></li>
			
			<li class="opcion" onclick="enviar('initSolicitudDeclinacionOferente.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.solicitud.declinacion" /></li>
			
             <li class="opcion" onclick="enviar('initSolicitudCancelacionOferente.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.solicitud.cancelacion" /></li>
             
          </ul>
    </li> 
    
    		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.consultas" />
          <ul>
             <li class="opcion" onclick="enviar('initSolicitudConsulta.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.consultas" /></li>
          </ul>
    </li> 
    
    <li width: 100px ><spring:message code="oferentes.texto.envio.SolicitudOferente.rechazos" />
          <ul>
             <li class="opcion" onclick="enviar('initSolicitudRechazoAceptacion.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.rechazos" /></li>
          </ul>
    </li> 
	
	
		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.modificacion" />
          <ul>
             <li class="opcion" onclick="enviar('initEnvioAvaluoMai.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.modificacion" /></li>
          </ul>
    </li> 
	
		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.declinacion" />
          <ul>
             <li class="opcion" onclick="enviar('initEnvioAvaluoMai.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.declinacion" /></li>
          </ul>
    </li> 
	
		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.cancelacion" />
          <ul>
             <li class="opcion" onclick="enviar('initEnvioAvaluoMai.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.cancelacion" /></li>
          </ul>
    </li> 
	
		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.reportes" />
          <ul>
             <li class="opcion" onclick="enviar('initEnvioAvaluoMai.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.reportes" /></li>
          </ul>
    </li> 
	
		<li><spring:message code="oferentes.texto.envio.SolicitudOferente.observaciones" />
          <ul>
             <li class="opcion" onclick="enviar('initEnvioAvaluoMai.htm');"><spring:message code="oferentes.texto.envio.SolicitudOferente.observaciones" /></li>
          </ul>
    </li> 



     </sec:authorize>
</ul>

</form>
</BODY>
</html>

