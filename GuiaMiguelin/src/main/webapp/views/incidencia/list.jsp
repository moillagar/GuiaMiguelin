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
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<h2>Incidencias</h2>
<jstl:forEach var="incidencias" items="${incidencias}">

<div class="col-md-1"></div>
<div class="col-md-5">

 		<div class="col-md-8-2 panel panel-default">
	 		<div class="wrap-2">
	 		<br>
	 		<c:set var="status" value="${incidencias.estado}"/>
	 		<c:if test="${fn:contains(status, 'ACEPTADA')}">
   				<img class="max-h-4 img-left-2" alt="Care Person" src="images/exito.png">
				</c:if>
				
				<c:if test="${fn:contains(status, 'RECHAZADA')}">
   				<img class="max-h-4 img-left-2" src="images/fracaso.png">
				</c:if>
	 		
	 		
	 		<c:if test="${fn:contains(status, 'PENDIENTE')}">
   				<img class="max-h-4 img-left-2" src="images/reloj.png">
   			</c:if>	
   				
	 		<span class="text-uppercase petSitterRegister-text">${incidencias.titulo}</span>
	 		<br>
	 		${incidencias.descripcion}
			
			
			
			</div>
	 	</div>
	 	</div>
 	</jstl:forEach>






