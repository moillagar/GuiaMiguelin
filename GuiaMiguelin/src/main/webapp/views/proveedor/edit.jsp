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
<link href="calendar/calendario_dw-estilos.css" type="text/css" rel="STYLESHEET">
<script type="text/javascript" src="calendar/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendar/calendario_dw.js"></script>


<form:form action="${requestURI}" modelAttribute="registerForm">
	<h3 class="widget-title">
		Crear restaurador
		
	</h3>
	
		
			<form:hidden path="id" />

	
		<div class="col-md-6">	
			

				<div class="form-group"><acme:textbox path="userName" code="proveedor_*user.name"></acme:textbox></div>
				<div class="form-group"><acme:password path="password" code="proveedor_*user.pass"></acme:password></div>
				<div class="form-group"><acme:password path="repeatedPassword" code="proveedor_*passRepeated"></acme:password></div>


				<div class="form-group"><acme:textbox path="nombre" code="proveedor_*nombre"></acme:textbox></div>

				<div class="form-group"><acme:textbox path="apellidos" code="proveedor_*apellidos"></acme:textbox></div>
				<div class="form-group"><acme:textbox path="email" code="proveedor_*email"></acme:textbox></div>
			</div>
			<div class="col-md-1 "></div>
<div class="col-md-5 ">
<div class="container-fluid text-center">

<img alt="" class="img-circle" src="images/equipo.png">
</div>
</div>
Los campos marcados con (*) son obligatorios
			<br>
			Si se registra, eso significa que acepta nuestras condiciones de uso.
			<a href="welcome/legal.do" target="_blank">Puede ver nuestras condiciones de uso aquí</a>
					
					
			
			<br>
		
			<input type="submit" name="save" class="btnAccept"
		value="Registrarse" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
					
			
			<br>
			

		</form:form>

