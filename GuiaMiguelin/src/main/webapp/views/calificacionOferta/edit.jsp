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
	
	<form:form action="${requestURI}" modelAttribute="calificacionOferta">
		<form:hidden path="id" />
		<form:hidden path="version" />
		<form:hidden path="estudiante" />
		<form:hidden path="creationMoment" />
		<form:hidden path="oferta" />
		
		
		<div class="col-md-6">
		
		<form:label path="comentarios">
		Comentario:
			</form:label>
	<form:textarea code="comentarios" path="comentarios"
		class="form-control blackL" />


	<form:errors path="comentarios" cssClass="error" />
	
	
	
	
		
		
		
		
		<br>
		<spring:message code="calificacion" />(*)
		<form:select id="calificacion" path="calificacion" class="form-control">
					<form:option value="0" label="---" />
							<option value='0'>0</option>
							<option value='1'>1</option>
							<option value='2'>2</option>
							<option value='3'>3</option>
							<option value='4'>4</option>
							<option value='5'>5</option>
							<option value='6'>6</option>
							<option value='7'>7</option>
							<option value='8'>8</option>
							<option value='9'>9</option>
							<option value='10'>10</option>
						
							
				</form:select>
				</div>
				
				<div class="col-md-1 "></div>
<div class="col-md-5 ">
<img src="images/charlar (6).png" alt="Pet Sitter" width="255" height="255">
</div>
				
				<br>
				
		
		
			Los campos marcados con (*) son obligatorios
		<br>
		
			<input type="submit" name="save" class="btnAccept"
		value="Guardar" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	
	
	</form:form>





