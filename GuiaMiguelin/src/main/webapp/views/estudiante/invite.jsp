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



<jstl:set var="action" value="estudiante/invite.do"/>
<form:form action="${action}" modelAttribute="invitationForm">
<div class="col-md-12">
<div class="col-md-1"></div>
<div class="col-md-5">
	<h2>Invita a tus amigos para que puedan disfrutar de nuestras ofertas</h2>
	
	<img  src="images/correo (1).png">
<br>
<br>
<br>
	
	
	
	
	</div>
	
	
	<div class="col-md-5">
	
	
	<form:label path="text">
		Email:
			</form:label>
	<form:input code="estudiante.email2" path="text"
		class="form-control blackL" />


	<form:errors path="text" cssClass="error" />
	
	<br>
	
	</div>
	<input type="submit" name="create" class="btnAccept"
		value="Invitar" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	</div>
</form:form>
	
