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
	
	<form:form action="${requestURI}" modelAttribute="oferta">
		
		<div class="col-md-6">
		
		<form:hidden path="id" />
		<form:hidden path="version" />
		<form:hidden path="establecimiento" />
		<form:hidden path="codigo" />
		<form:hidden path="calificacionMedia" />
		
		<div class="form-group text-left">
		<form:label path="nombre">
		<spring:message code="oferta.nombre" />(*):
			</form:label>
	<form:input code="oferta.nombre" path="nombre"
		class="form-control blackL" />


	<form:errors path="nombre" cssClass="error" />
	</div>
	
	<div class="form-group text-left">
		<form:label path="descripcion">
		<spring:message code="oferta.descripcion" />(*):
			</form:label>
	<form:textarea code="oferta.descripcion" path="descripcion"
		class="form-control blackL datepicker" />


	<form:errors path="descripcion" cssClass="error" />
	</div>
		
		<div class="form-group text-left">
		<form:label path="precio">
		<spring:message code="oferta.precio" />:
			</form:label>
	<form:input code="precio.nombre" path="precio"
		class="form-control blackL" />


	<form:errors path="precio" cssClass="error" />
	</div>
		
		
		
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-5"></div>
		
		<img src="images/lapices (1).png"  >
		<br>
		<br>
		
		Los campos marcados con (*) son obligatorios
		<br>
			<input type="submit" name="save" class="btnAccept"
		value=Guardar />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	
	
	</form:form>





