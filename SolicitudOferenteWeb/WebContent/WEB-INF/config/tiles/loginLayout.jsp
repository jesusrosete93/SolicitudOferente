<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
    <!-- CSS  -->
	<link  href="/SolicitudOferenteWeb/kendoUI/styles/kendo.common.min.css" rel="stylesheet"  type="text/css"/>
	<link  href="/SolicitudOferenteWeb/kendoUI/styles/kendo.blueopal.min.css" rel="stylesheet"  type="text/css" />
	<link  href="/SolicitudOferenteWeb/theme/Master.css" rel="stylesheet"  type="text/css" />
	
	<!-- Jquery -->
	<script src="/SolicitudOferenteWeb/kendoUI/js/jquery.min.js" type="text/javascript"></script>
	<script src="/SolicitudOferenteWeb/kendoUI/js/kendo.all.min.js"></script>
	
	
	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>
        <table cellpadding="2" cellspacing="2" align="center" width="100%" height="100%">
            <tr>
		       <td colspan="2" height="10%" width="100%">
		          <tiles:insertAttribute name="header" />
		       </td>
	       </tr>
            <tr>
                <td width="100%" height="80%" valign="middle" align="left">
                  <fieldset>
                        <tiles:insertAttribute name="body" />
                  </fieldset>
                </td>
            </tr>
    
        </table>
    </body>
</html>