<%--
 * edit.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>




<form:form  action="${requestURI}" modelAttribute="incidencia">
			<form:hidden path="id" />
			<form:hidden path="version" />
			<form:hidden path="administrator" />
			<form:hidden path="descripcion" />
			<form:hidden path="titulo" />
			<form:hidden path="estudiante" />
			<form:hidden path="oferta" />
			<form:hidden path="updateMoment" />
	
	<div class="col-md-6">
	
	<acme:label text="${incidencia.titulo}" code="incidencias.titulo"></acme:label>
	<acme:label text="${incidencia.descripcion}" code="incidencias.descripcion"></acme:label>
	
	
	
</div>
		<div class="col-md-6">
	<spring:message code="incidencia.status" />
				<form:select id="estado" path="estado" class="form-control">
					<form:option value="0" label="---" />
							<option value='RECHAZADA'>RECHAZADA</option>
							<option value='ACEPTADA'>ACEPTADA</option>
							
						
							
				</form:select>
</div>
<br>
<br>
<br>	
	<input type="submit" name="save" class="btnAccept"
		value=Guardar />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	
</form:form>
	