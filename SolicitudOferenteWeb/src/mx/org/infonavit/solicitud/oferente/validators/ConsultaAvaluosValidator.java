package mx.org.infonavit.solicitud.oferente.validators;

import mx.org.infonavit.solicitud.oferente.forms.ConsultaAvaluosForm;
import mx.org.infonavit.solicitud.oferente.utils.Fechas;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("ConsultaAvaluosValidator")
public class ConsultaAvaluosValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return ConsultaAvaluosForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		ConsultaAvaluosForm forma = (ConsultaAvaluosForm)object;
		if( forma.getUnidadValuacion().getClaveUnidadValuacion()==0 && (forma.getUnidadValuacion().getNombreUnidadValuacion()==null || forma.getUnidadValuacion().getNombreUnidadValuacion().isEmpty() ) &&
			forma.getUnidadValuacion().getEstatusUnidadValuacion()==0 && forma.getUnidadValuacion().getUnidadViviendaRecuperada()==-1 &&
			(forma.getAvaluo().getEstados()==null || forma.getAvaluo().getEstados().isEmpty()) && forma.getVivienda().getCodigoPostal().trim().equals("") &&
			forma.getAvaluo().getIdAvaluo().trim().equals("") && forma.getAvaluo().getIdConviviencia().trim().equals("") && 
			forma.getAvaluo().getPaquete().trim().equals("") && forma.getAvaluo().getViviendaInicio()==0 && forma.getAvaluo().getViviendaFin()==0 &&
			forma.getVivienda().getNss().trim().equals("") && forma.getAvaluo().getFechaSolicitudInicio().trim().equals("") && forma.getAvaluo().getFechaSolicitudFin().trim().equals("") &&
			forma.getAvaluo().getFechaCierreInicio().trim().equals("") && forma.getAvaluo().getFechaCierreFin().trim().equals("") &&
			forma.getDetalleAvaluo().getValorConcluidoInicio().trim().equals("") && forma.getDetalleAvaluo().getValorConcluidoFin().trim().equals("") &&
			forma.getDetalleAvaluo().getMetrosConstruccionInicio().trim().equals("") && forma.getDetalleAvaluo().getMetrosConstruccionFin().trim().equals("") &&
			forma.getDetalleAvaluo().getMetrosTerrenoInicio().trim().equals("") && forma.getDetalleAvaluo().getMetrosTerrenoFin().trim().equals("") &&
			forma.getAvaluo().getEstatusAvaluo()==-1 && forma.getAvaluo().getTipoMercado()==-1 &&
			forma.getControlador().getClaveSHF().trim().equals("") && 
			( forma.getControlador().getApellidoPaterno().trim().equals("") || forma.getControlador().getApellidoPaterno().trim().equals("PATERNO")) &&
			( forma.getControlador().getApellidoMaterno().trim().equals("") || forma.getControlador().getApellidoMaterno().trim().equals("MATERNO") ) &&  
			( forma.getControlador().getNombre().trim().equals("") || forma.getControlador().getNombre().trim().equals("NOMBRE") ) && 
			forma.getControlador().getEstatusControlador()==-1 &&
			forma.getPerito().getClaveSHF().trim().equals("") && 
			( forma.getPerito().getApellidoPaterno().trim().equals("") || forma.getPerito().getApellidoPaterno().trim().equals("PATERNO")) &&
			( forma.getPerito().getApellidoMaterno().trim().equals("") || forma.getPerito().getApellidoMaterno().trim().equals("MATERNO") ) &&  
			( forma.getPerito().getNombre().trim().equals("") || forma.getPerito().getNombre().trim().equals("NOMBRE") ) &&  
			forma.getPerito().getEstatusPerito()==-1
		   )
		{
			errors.rejectValue("errores","error.general.mensaje",new Object[]{"Favor de capturar algun criterio de busqueda"},"");
		}else
		{
			if( !forma.getVivienda().getCodigoPostal().trim().equals(""))
			{
				if( !forma.getVivienda().getCodigoPostal().trim().matches("[0-9]{5}"))
				{
					errors.rejectValue("errores","error.campo.solonumero",new Object[]{"C.P"},"");
				}
			}else
			{
				if( !forma.getAvaluo().getIdAvaluo().trim().equals(""))
				{
					if( !forma.getAvaluo().getIdAvaluo().trim().matches("[0-9]{17}"))
					{
						errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Id Avalúo"},"");
					}
				}else
				{
					if( !forma.getAvaluo().getIdConviviencia().trim().equals(""))
					{
						if( !forma.getAvaluo().getIdConviviencia().trim().matches("[0-9]{10}"))
						{
							errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Id COnviviencia"},"");
						}
					}else
					{
						if( !forma.getAvaluo().getPaquete().trim().equals(""))
						{
							if( !forma.getAvaluo().getPaquete().trim().matches("[0-9]{16}"))
							{
								errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Paquete"},"");
							}
						}else
						{
							if( forma.getAvaluo().getViviendaInicio()!=0 && forma.getAvaluo().getViviendaFin()==0)
							{
								errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Vivienda"},"");
							}else if( forma.getAvaluo().getViviendaInicio()==0 && forma.getAvaluo().getViviendaFin()!=0 )
							{
								errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Vivienda"},"");
							}else if( forma.getAvaluo().getViviendaInicio()!=0 && forma.getAvaluo().getViviendaFin()!=0 )
							{
								if( forma.getAvaluo().getViviendaInicio()>forma.getAvaluo().getViviendaFin() )
								{
									errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getAvaluo().getViviendaInicio(),"Vivienda",forma.getAvaluo().getViviendaFin()},"");
								}
							}else
							{
								if( !forma.getVivienda().getNss().trim().equals("") )
								{
									if( !forma.getVivienda().getNss().matches("[0-9]{11}"))
									{
										errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Nss"},"");
									}
								}else
								{
									if( forma.getAvaluo().getFechaSolicitudInicio().trim().equals("") && !forma.getAvaluo().getFechaSolicitudFin().trim().equals(""))
									{
										errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
									}else if( !forma.getAvaluo().getFechaSolicitudInicio().trim().equals("") && forma.getAvaluo().getFechaSolicitudFin().trim().equals(""))
									{
										errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
									}else if( !forma.getAvaluo().getFechaSolicitudInicio().trim().equals("") && !forma.getAvaluo().getFechaSolicitudFin().trim().equals("") )
									{
										if( Fechas.getDate_YYYYMMDD(forma.getAvaluo().getFechaSolicitudFin()).before( Fechas.getDate_YYYYMMDD(forma.getAvaluo().getFechaSolicitudInicio()) ) )
										{
											errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getAvaluo().getFechaSolicitudFin(),"Fecha solicitud",forma.getAvaluo().getFechaSolicitudInicio()},"");
										}
									}else
									{
										if( forma.getAvaluo().getFechaCierreInicio().trim().equals("") && !forma.getAvaluo().getFechaCierreFin().trim().equals(""))
										{
											errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
										}else if( !forma.getAvaluo().getFechaCierreInicio().trim().equals("") && forma.getAvaluo().getFechaCierreFin().trim().equals(""))
										{
											errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Fecha solicitud"},"");
										}else if( !forma.getAvaluo().getFechaCierreInicio().trim().equals("") && !forma.getAvaluo().getFechaCierreFin().trim().equals("") )
										{
											if( Fechas.getDate_YYYYMMDD(forma.getAvaluo().getFechaCierreFin()).before( Fechas.getDate_YYYYMMDD(forma.getAvaluo().getFechaCierreInicio()) ) )
											{
												errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getAvaluo().getFechaCierreFin(),"Fecha solicitud",forma.getAvaluo().getFechaCierreInicio()},"");
											}
										}else
										{
											if( forma.getDetalleAvaluo().getValorConcluidoInicio().trim().equals("") && !forma.getDetalleAvaluo().getValorConcluidoFin().trim().equals(""))
											{
												errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Valor concluido"},"");
											}else if( !forma.getDetalleAvaluo().getValorConcluidoInicio().trim().equals("") && forma.getDetalleAvaluo().getValorConcluidoFin().trim().equals(""))
											{
												errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"Valor concluido"},"");
											}else if( !forma.getDetalleAvaluo().getValorConcluidoInicio().trim().equals("") && !forma.getDetalleAvaluo().getValorConcluidoFin().trim().equals("") )
											{
												if( Double.parseDouble(forma.getDetalleAvaluo().getValorConcluidoInicio()) > Double.parseDouble(forma.getDetalleAvaluo().getValorConcluidoFin()) )
												{
													errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getDetalleAvaluo().getValorConcluidoInicio(),"Valor concluido",forma.getDetalleAvaluo().getValorConcluidoFin()},"");
												}
											}else
											{
												if( forma.getDetalleAvaluo().getMetrosConstruccionInicio().trim().equals("") && !forma.getDetalleAvaluo().getMetrosConstruccionFin().trim().equals(""))
												{
													errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"m2 de Construcci&oacute;n"},"");
												}else if( !forma.getDetalleAvaluo().getMetrosConstruccionInicio().trim().equals("") && forma.getDetalleAvaluo().getMetrosConstruccionFin().trim().equals(""))
												{
													errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"m2 de Construcci&oacute;n"},"");
												}else if( !forma.getDetalleAvaluo().getMetrosConstruccionInicio().trim().equals("") && !forma.getDetalleAvaluo().getMetrosConstruccionFin().trim().equals("") )
												{
													if( Double.parseDouble(forma.getDetalleAvaluo().getMetrosConstruccionInicio()) > Double.parseDouble(forma.getDetalleAvaluo().getMetrosConstruccionFin()) )
													{
														errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getDetalleAvaluo().getMetrosConstruccionInicio(),"m2 de Construcci&oacute;n",forma.getDetalleAvaluo().getMetrosConstruccionFin()},"");
													}
												}else
												{
													if( forma.getDetalleAvaluo().getMetrosTerrenoInicio().trim().equals("") && !forma.getDetalleAvaluo().getMetrosTerrenoFin().trim().equals(""))
													{
														errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"m2 de Terreno"},"");
													}else if( !forma.getDetalleAvaluo().getMetrosTerrenoInicio().trim().equals("") && forma.getDetalleAvaluo().getMetrosTerrenoFin().trim().equals(""))
													{
														errors.rejectValue("errores","error.campos.valor.rango.vacios",new Object[]{"m2 de Terreno"},"");
													}else if( !forma.getDetalleAvaluo().getMetrosTerrenoInicio().trim().equals("") && !forma.getDetalleAvaluo().getMetrosTerrenoFin().trim().equals("") )
													{
														if( Double.parseDouble(forma.getDetalleAvaluo().getMetrosTerrenoInicio()) > Double.parseDouble(forma.getDetalleAvaluo().getMetrosTerrenoFin()) )
														{
															errors.rejectValue("errores","error.campos.valor.rango",new Object[]{forma.getDetalleAvaluo().getMetrosTerrenoInicio(),"m2 de Terreno",forma.getDetalleAvaluo().getMetrosTerrenoFin()},"");
														}
													}else
													{
														if( !forma.getControlador().getClaveSHF().trim().equals("") )
														{
														 if( !forma.getControlador().getClaveSHF().matches("[0-9]{7}"))
														 {
															 errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Clave SHF - Controlador"},"");
														 }
														}else
														{
															if( !forma.getControlador().getApellidoPaterno().trim().equals("") || !forma.getControlador().getApellidoPaterno().trim().equals("PATERNO") )
															{
																if(!forma.getControlador().getApellidoPaterno().matches("[A-Z]+"))
																{
																	errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Apellido Paterno - Controlador"},"");
																}
															}else
															{
																if( !forma.getControlador().getApellidoMaterno().trim().equals("") || !forma.getControlador().getApellidoMaterno().trim().equals("MATERNO"))
																{
																	if(!forma.getControlador().getApellidoMaterno().matches("[A-Z]+"))
																	{
																		errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Apellido Materno - Controlador"},"");
																	}
																}else
																{
																	if( !forma.getControlador().getNombre().trim().equals("") || !forma.getControlador().getNombre().trim().equals("NOMBRE"))
																	{
																		if(!forma.getControlador().getNombre().matches("[A-Z]+"))
																		{
																			errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Nombre - Controlador"},"");
																		}
																	}else
																	{
																		if( !forma.getPerito().getClaveSHF().trim().equals("") )
																		{
																			if( !forma.getPerito().getClaveSHF().trim().matches("[0-9]{7}") )
																			{
																				errors.rejectValue("errores","error.campo.solonumero",new Object[]{"Clave SHF - Perito"},"");
																			}
																		}else
																		{
																			if( !forma.getPerito().getApellidoPaterno().trim().equals("") || !forma.getPerito().getApellidoPaterno().trim().equals("PATERNO"))
																			{
																				if(!forma.getPerito().getApellidoPaterno().matches("[A-Z]+"))
																				{
																					errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Apellido Paterno - Perito"},"");
																				}
																			}else
																			{
																				if( !forma.getPerito().getApellidoMaterno().trim().equals("") || !forma.getPerito().getApellidoMaterno().trim().equals("MATERNO"))
																				{
																					if(!forma.getPerito().getApellidoMaterno().matches("[A-Z]+"))
																					{
																						errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Apellido Materno - Perito"},"");
																					}
																				}else
																				{
																					if( !forma.getPerito().getNombre().trim().equals("") || !forma.getPerito().getNombre().trim().equals("NOMBRE"))
																					{
																						if(!forma.getPerito().getNombre().matches("[A-Z]+"))
																						{
																							errors.rejectValue("errores","error.campo.sololetra",new Object[]{"Nombre - Perito"},"");
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
		}
		
	}

}
