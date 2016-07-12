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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>




<h2>Establecimientos del sistema</h2>

	


<jstl:forEach var="establecimientos" items="${establecimientos}">
<div class="col-md-1"></div>
<div class="col-md-5">
 		<div class="col-md-8-2 panel panel-default">
	 		
	 	
   				<a href="establecimiento/administrator/bloquear.do?establecimientoId=${establecimientos.id}"><img class="max-h-4 img-left-2" src="images/fracaso.png"></a>
				
	 	
	 		
	 		
	 		
	 		<span class="text-uppercase petSitterRegister-text">${establecimientos.nombre}</span>
	 		<i>${establecimientos.web}</i>
	 		<br>
			${establecimientos.descripcion} <DIV ALIGN=right><img  src="images/marcador.png">   ${establecimientos.direccion}</DIV>
		
			
			
		
			
		
				
			
			
			
	 	</div>
	 	</div>
 	</jstl:forEach>

