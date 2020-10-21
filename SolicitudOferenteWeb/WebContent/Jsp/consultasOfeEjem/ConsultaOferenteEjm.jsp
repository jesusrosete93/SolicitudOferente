<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link href="/TableroAvaluos/theme/Master.css" rel="stylesheet"
	type="text/css" />
<title>consultaReporte</title>
<style type="text/css">
.k-grid-toolbar a {
	float: right;
}
</style>
<script src="/TableroAvaluos/Js/InputsValidator.js"></script>
</head>
<body>
	<span class="tituloAzulGrande">Consulta</span>
	<form id="inicioForm" action="welcome.htm"></form>
	<form:form id="reporteECcoTecnologiaForm"
		modelAttribute="reporteEcoTec">
		<div id="errores" class="errorblock" align="center"
			style="display: none"></div>
		<div>
			<table align="center">
				<tr>
					<td align="right" colspan="2">Municipio</td>
					<td align="left"><form:input path="cveEcoTecnologia"
							cssClass="k-textbox" /></td>
				</tr>
				<tr>
					<td align="right" colspan="2">Numero oferente</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">RFC</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">NPR</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">ID OFERENTE</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">Razon Social</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="right" colspan="2">Especialidad</td>
					<td align="left"><form:input cssClass="k-textbox"
							path="desarrollador" />
					</td>
				</tr>
				<tr>
					<td align="left">Fecha de actualizacion</td>
					<td align="right"><spring:message
							code="avaluos.titulo.reportes.eco.rangos.de" />
					</td>
					<td align="left"><input id="fechaInicio"
						name="fechaSolicitudInicio" />
					</td>
					<td align="right"><spring:message
							code="avaluos.titulo.reportes.eco.rangos.a" />
					</td>
					<td align="left"><input id="fechaFin" name="fechaSolicitudFin" />
					</td>
				</tr>
				<tr>
					<td align="left">Fecha de aceptacion</td>
					<td align="right"><spring:message
							code="avaluos.titulo.reportes.eco.rangos.de" />
					</td>
					<td align="left"><input id="fechaIni"
						name="fechaSolicitudInicio" />
					</td>
					<td align="right"><spring:message
							code="avaluos.titulo.reportes.eco.rangos.a" />
					</td>
					<td align="left"><input id="fechaF" name="fechaSolicitudFin" />
					</td>
				</tr>

				<tr>

					<td colspan="5" align="center">
						<table>
							<tr>
								<td align="center"><button type="button" id="busqueda"
										class="k-button">
										<spring:message code="avaluos.titulo.generico.genera.reporte" />
									</button>
								</td>
								<td align="center"><button type="button" id="nuevaBusqueda"
										class="k-button">
										<spring:message
											code="avaluos.titulo.generico.boton.nuevo.reporte" />
									</button>
								</td>
								<td align="center"><button type="button" id="cancela"
										class="k-button">
										<spring:message code="avaluos.titulo.generico.boton.cancelar" />
									</button>
								</td>
							</tr>
						</table></td>
				</tr>

			</table>



			<br>
		</div>


		<table align="center"  border="1">
			<tr>
				<th scope="row">Calle</th>
				<th>Numero Interior</th>
				<th>Numero exterior</th>
				<th>Codigo Postal</th>
				<th>Colonia</th>
				<th>Localidad</th>
				<th>Estado</th>
				<th>Telefonos</th>
				<th>Estatus</th>
				<th>Grupo Corporativo</th>
				<th>Filiales</th>
				<th>Accionistas</th>
				<th>RFC Accionistas</th>
				<th>Precentantes Legales</th>
				<th>RFC REPRECENTANTES LEGALES</th>
				<th>Representantes Tecnicos</th>
				<th>RFC REPRESENTANTES TECNICOS</th>
			</tr>
			<tr>
				<th>Calle</th>
				<td>1</td>
				<td>1</td>
				<td>0000</td>
				<td>Colonia</td>
				<td>Localidad</td>
				<td>CDMX</td>
				<td>222321</td>
				<td>Estatus</td>
				<td>Grupo</td>
				<td>Filiales</td>
				<td>Accionistas</td>
				<td>RFC Ac</td>
				<td>Legales</td>
				<td>RFC</td>
				<td>Tecnicos</td>
				<td>RFC Tecnicos</td>
			</tr>
			
		</table>


		<div></div>
	</form:form>
	<div style="width: 1000px">
		<div id="resultadoConsulta" align="center" class="desc"
			style="display: none;"></div>
	</div>



	<script type="text/javascript">
		function setWidth(el) {
			var d = el;
			var p = d.data("kendoDropDownList").popup.element;
			var w = p.css("visibility", "hidden").show().outerWidth();
			p.hide().css("visibility", "visible");
			d.closest(".k-widget").width(w);
		}

		function displayLoading(target, mostrar) {
			var element = $(target);
			kendo.ui.progress(element, mostrar);
		}

		var gridEcoTec;

		$(document)
				.ready(
						function() {

							function adjustDropDownWidth(e) {
								var listContainer = e.sender.list
										.closest(".k-list-container");
								listContainer.width(listContainer.width()
										+ kendo.support.scrollbar());
							}
							$("[id^=\"fecha\"]").each(function(index) {
								var id = this.id;
								$("#" + id).kendoDatePicker({
									culture : "es-MX",
									format : "dd-MM-yyyy",
									interval : 30
								});
							});

							$("[id^=\"select\"]").each(
									function(index) {
										var id = this.id;
										$("#" + id).kendoDropDownList({
											open : adjustDropDownWidth
										});
										var localDropDown = $("#" + id).data(
												"kendoDropDownList");
										localDropDown.list.width("auto");
									});

							$("[id^=\"horaFechaAvance\"]").each(
									function(index) {
										var id = this.id;
										$("#" + id).kendoDateTimePicker({
											culture : "es-MX",
											format : "dd-MM-yyyy HH:mm tt",
											interval : 30
										});
									});
							$("[id^=\"horaFechaTecnologias\"]").each(
									function(index) {
										var id = this.id;
										$("#" + id).kendoDateTimePicker({
											culture : "es-MX",
											format : "dd-yyyy-MM HH:mm tt",
											interval : 30
										});
									});

							$("#nuevaBusqueda")
									.click(
											function() {
												//$('#resultadoConsulta').empty();
												console.log("gridEcoTec:"
														+ gridEcoTec);
												if (gridEcoTec != null) {
													$('#resultadoConsulta')
															.kendoGrid(
																	'destroy')
															.empty();
												}
												$('#errores').empty();
												$('#resultadoConsulta').hide();
												$('#errores').hide();
												$('#busqueda').show();
												gridEcoTec = null;
												$('#reporteECcoTecnologiaForm')[0]
														.reset();
											});

							$("#cancela").click(function() {
								$("#inicioForm").submit();
							});

							$("#busqueda")
									.click(
											function(e) {
												//Prevent default submission of form
												console.log("gridEcoTec:"
														+ gridEcoTec);
												if (gridEcoTec != null) {
													$('#resultadoConsulta')
															.kendoGrid(
																	'destroy')
															.empty();
												}
												e.preventDefault();
												$
														.ajax({
															type : 'POST',
															url : '/TableroAvaluos/reporteEcoTecnologias.json',
															data : $(
																	'#reporteECcoTecnologiaForm')
																	.serialize(),
															dataType : "json",
															beforeSend : function() {
																$("#errores")
																		.empty();
																$("#errores")
																		.hide();
																//console.log("Antes de enviar");
																displayLoading(
																		document.body,
																		true);
																$("#busqueda")
																		.prop(
																				"disabled",
																				true);
																$(
																		"#nuevaBusqueda")
																		.prop(
																				"disabled",
																				true);
																$("#cancela")
																		.prop(
																				"disabled",
																				true);
															},
															success : function(
																	res) {
																//console.log("Función success");
																displayLoading(
																		document.body,
																		false);
																$("#busqueda")
																		.prop(
																				"disabled",
																				false);
																$(
																		"#nuevaBusqueda")
																		.prop(
																				"disabled",
																				false);
																$("#cancela")
																		.prop(
																				"disabled",
																				false);
																if (res.errores) {
																	errorInfo = "";
																	//Set error messages
																	$
																			.each(
																					res.mensajesError,
																					function(
																							key,
																							value) {
																						//$('input[name='+key+']').after('<span class="errorBlock">'+value+'</span>___________________$tag__');
																						errorInfo += "_$tag_____________________$tag___$ta"
																								+ value;
																					});
																	$(
																			'#errores')
																			.html(
																					errorInfo);
																	//$('#info').hide('slow');
																	$(
																			'#errores')
																			.show();
																} else {
																	if (res.codigoRespuesta == "0000") {
																		//Set response
																		$(
																				'#resultadoConsulta')
																				.show();
																		$(
																				'#busqueda')
																				.hide();
																		//$('#resultadoconsulta').html('_$tag_____________________$tag___$ta_$tag________________________$tag_____________________$tag___$ta_$tag________________________$tag_');
																		gridEcoTec = $(
																				"#resultadoConsulta")
																				.kendoGrid(
																						{
																							toolbar : [ {
																								name : "excel",
																								text : "Exportar a Excel"
																							} ],
																							dataSource : {
																								data : res.listado,
																								pageSize : 10,
																								schema : {
																									model : {
																										fields : {
																											"tecnoDomain.paquete" : {
																												type : "string"
																											},
																											"tecnoDomain.claveTecnologia" : {
																												type : "string"
																											},
																											"tecnoDomain.anioMES" : {
																												type : "string"
																											},
																											"tecnoDomain.numecotec" : {
																												type : "String"
																											}

																										}
																									}
																								},
																								total : function(
																										response) {
																									return response.listado.size;
																								}
																							},
																							pageable : {
																								pageSizes : [
																										10,
																										20,
																										50,
																										100 ],
																								buttonCount : 5
																							},
																							columns : [
																									{
																										field : "tecnoDomain.paquete",
																										title : "Paquete",
																										width : 200
																									},
																									{
																										field : "tecnoDomain.claveTecnologia",
																										title : "Clave de tecnologia",
																										width : 200
																									},
																									{
																										field : "tecnoDomain.anioMES",
																										title : "Anio mes",
																										width : 120
																									},
																									{
																										field : "tecnoDomain.numecotec",
																										title : "Numero",
																										width : 80
																									}

																							],
																							excel : {
																								allPages : true,
																								fileName : "ReporteEcoTecnologia_"
																										+ kendo
																												.toString(
																														new Date(),
																														'yyyyMMdd_HHmm')
																										+ ".xlsx"
																							},
																							sortable : true,
																							filterable : true,
																							groupable : true,
																							resizable : true
																						})
																				.data(
																						"kendoGrid");
																	} else {
																		errorInfo = "_$tag_____________________$tag___$ta_$tag________________________$tag__$ta"
																				+ res.descripcionRespuesta;
	</script>


</body>
</html>