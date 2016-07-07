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
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="${requestURI}" modelAttribute="registerForm">
	<form:hidden path="id" />


	
<div class="col-md-6">

	<fieldset>
		<legend>
			<spring:message code="administrator.userData" />

		</legend>

		<acme:textbox path="userName" code="administrator_*user.name"></acme:textbox>
		<acme:password path="password" code="administrator_*user.pass"></acme:password>
		<acme:password path="repeatedPassword" code="administrator.passRepeated"></acme:password>
		
		
		<acme:textbox path="nombre" code="administrator_*name"></acme:textbox>
		
		<acme:textbox path="apellidos" code="administrator_*surname"></acme:textbox>
		<acme:textbox path="email" code="administrator_*email"></acme:textbox>
		
		
	</fieldset>
	
</div>

<div class="col-md-6">

<img  src="images/empresarios.png">

</div>


	<br>
	<br>
	<br>
	<br>
	
	<input type="submit" name="save" class="btnAccept"
		value=Guardar />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />


</form:form>