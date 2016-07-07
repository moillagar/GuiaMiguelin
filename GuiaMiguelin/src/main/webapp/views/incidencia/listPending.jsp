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


<display:table name="incidencias" id="row" requestURI="${requestURI}"
	class="displaytag" keepStatus="true" pagesize="5" >
	
	<spring:message code="incidencias.titulo" var="tituloColumn" ></spring:message>
	<display:column property="titulo" title="${tituloColumn}" />
	
	<spring:message code="incidencias.descripcion" var="descColumn" ></spring:message>
	<display:column property="descripcion" title="${descColumn}" />
	
	
	<spring:message code="incidencias.resolve" var="resolveColumn" ></spring:message>
	<display:column title="${resolveColumn}">
	<a href="incidencia/administrator/resolve.do?id=${row.id}">
			<spring:message code="incidencias.resolve2"/>
			</a>
	</display:column>
	
</display:table>

