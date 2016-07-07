<%--
 * index.jsp
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<display:table name="calificacionOfertas" id="row" requestURI="${requestURI}"
	class="displaytag" keepStatus="true" pagesize="5" >
	
	<spring:message code="comentarios" var="nombreColumn" ></spring:message>
	<display:column property="comentarios" title="${nombreColumn}" />
	
	<spring:message code="calificacion" var="descColumn" ></spring:message>
	<display:column property="calificacion" title="${descColumn}" />
	
	<spring:message code="creationMoment" var="direccionColumn" ></spring:message>
	<display:column property="creationMoment" title="${direccionColumn}" />
	
	<spring:message code="estudiante" var="webColumn" ></spring:message>
	<display:column property="estudiante.nombre" title="${webColumn}" />
	
	
	
	

	
</display:table>
<a href="calificacionOferta/estudiante/create.do?id=${row.id}">
			<spring:message code="createCalificacion"/>
			</a>