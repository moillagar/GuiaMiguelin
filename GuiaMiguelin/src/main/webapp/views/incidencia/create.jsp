<%--
 * edit.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
	
	<form:form action="${requestURI}" modelAttribute="incidencia">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<form:hidden path="estudiante" />
		<form:hidden path="estado" />
		<form:hidden path="oferta" />
		<form:hidden path="updateMoment" />
		
		<div class="col-md-12">
	<div class="col-md-6">
	
	<form:label path="titulo">
		Título(*):
			</form:label>
	<form:input code="incidencias.titulo2" path="titulo"
		class="form-control blackL" />


	<form:errors path="titulo" cssClass="error" />
	
	
	
	<form:label path="descripcion">
		Descripción(*):
			</form:label>
	<form:input code="incidencias.descripcion2" path="descripcion"
		class="form-control blackL" />


	<form:errors path="descripcion" cssClass="error" />
	
	</div>
	<div class="col-md-1 "></div>
<div class="col-md-5 ">
<img src="images/complaint.png" class="img-circle person" alt="Pet Sitter" width="255" height="255">

</div>
	</div>
		
		
		
				
		Los campos marcados con (*) son obligatorios
		<br>
		
			<input type="submit" name="save" class="btnAccept"
		value="Guardar" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	
	
	</form:form>





