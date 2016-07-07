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
	
	<form:form action="${requestURI}" modelAttribute="establecimiento" enctype="multipart/form-data">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<form:hidden path="proveedor" />
		<div class="col-md-6">
		<div class="form-group text-left">

	<form:label path="nombre">
		<spring:message code="establecimiento.nombre" />(*):
			</form:label>
	<form:input code="establecimiento.nombre" path="nombre"
		class="form-control blackL" />


	<form:errors path="nombre" cssClass="error" />
	</div>
	
	<div class="form-group text-left">

	<form:label path="descripcion">
		<spring:message code="establecimiento.descripcion" />(*):
			</form:label>
	<form:textarea code="establecimiento.descripcion" path="descripcion"
		class="form-control blackL datepicker" />


	<form:errors path="descripcion" cssClass="error" />
	</div>
		
		<div class="form-group text-left">

	<form:label path="direccion">
		<spring:message code="establecimiento.direccion" />(*):
			</form:label>
	<form:input code="establecimiento.direccion" path="direccion"
		class="form-control blackL" />


	<form:errors path="direccion" cssClass="error" />
	</div>
	<div class="form-group text-left">

	<form:label path="web">
		<spring:message code="establecimiento.web" />:
			</form:label>
	<form:input code="establecimiento.web" path="web"
		class="form-control blackL" />


	<form:errors path="web" cssClass="error" />
	</div>
	<div class="form-group text-left">

	<form:label path="numeroTelefono">
		<spring:message code="establecimiento.numeroTelefono" />(*):
			</form:label>
	<form:input code="establecimiento.numeroTelefono" path="numeroTelefono"
		class="form-control blackL" />


	<form:errors path="numeroTelefono" cssClass="error" />
	</div>
		
		
		<br>
		<spring:message code="establecimiento.tipo" />
		<form:select id="tipoEstablecimiento" path="tipoEstablecimiento" class="form-control">
					<form:option value="0" label="---" />
							<option value='BAR'>BAR</option>
							<option value='RESTAURANTE'>RESTAURANTE</option>
							<option value='COMEDOR UNIVERSITARIO'>COMEDOR UNIVERSITARIO</option>
							<option value='OTROS'>OTROS</option>
						
							
				</form:select>
				<br>
				<spring:message code="establecimiento.campus" />
				<form:select id="campus" path="campus" class="form-control">
					<form:option value="0" label="---" />
							<option value='CAMPUS CARTUJA'>CAMPUS CARTUJA</option>
							<option value='CAMPUS MACARENA'>CAMPUS MACARENA</option>
							<option value='CAMPUS REINA MERCEDES'>CAMPUS REINA MERCEDES</option>
							<option value='CAMPUS RAMON Y CAJAL'>CAMPUS RAMON Y CAJAL</option>							
							<option value='ESCUELA POLITÉCNICA SUPERIOR'>ESCUELA POLITÉCNICA SUPERIOR</option>
							<option value='FACULTAD BELLAS ARTES'>FACULTAD BELLAS ARTES</option>
							<option value='SADUS'>SADUS</option>
							<option value='OTROS'>OTROS</option>
						
							
				</form:select>
		<br>
		<input type="file" name="file" id="file">
		<br>
		</div>
	
	<div class="col-md-1 "></div>
	<div class="col-md-5">	
		<img src="images/proveedorIndex.jpg" class="img-circle person" alt="Pet Sitter" width="255" height="255">
		
		</div>
		
		<br>
		Los campos marcados con (*) son obligatorios
		<br>
		<br>
			<input type="submit" name="save" class="btnAccept"
		value=Guardar />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	
	</form:form>





