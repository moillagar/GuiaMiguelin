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
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
	<div class="col-md-1"></div>
<div class="col-md-5">


<form:form action="${oferta}" modelAttribute="oferta">
<div class="qr"><img src='http://qrickit.com/api/qr?d=${oferta.codigo}'/> </div>
	<span class="text-uppercase petSitterRegister-text">${oferta.nombre}:</span>
	 		
	 		
			${oferta.descripcion} 
	<br>
	<jstl:if test="${not empty oferta.precio}">
	<span class="text-uppercase petSitterRegister-text">${oferta.precio} <img  src="images/moneda.png">  </span>
	</jstl:if>
			&nbsp;&nbsp;&nbsp;<jstl:if test="${oferta.calificacionMedia<2.0}">
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${oferta.calificacionMedia>=2.0 and oferta.calificacionMedia<4.0}">
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${oferta.calificacionMedia>=4.0 and oferta.calificacionMedia<6.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${oferta.calificacionMedia>=6.0 and oferta.calificacionMedia<8.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${oferta.calificacionMedia>=8.0 and oferta.calificacionMedia<10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${oferta.calificacionMedia==10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
					</jstl:if>
			
		<br>
	
	
	</form:form>
	<security:authorize access="hasRole('ESTUDIANTE')">
	<a href="incidencia/estudiante/create.do?id=${oferta.id}">
			<img  src="images/advertencia.png">
			</a>



<a href="calificacionOferta/estudiante/create.do?id=${oferta.id}">
			<img  src="images/charlar.png">
			</a>
	
	</security:authorize>
	
	<security:authorize access="hasRole('PROVEEDOR')">
	
	<a href="oferta/proveedor/edit.do?id=${oferta.id}">
			<img  src="images/editar.png">
			</a>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	<h2>Resolver Incidencias</h2>
<jstl:forEach var="incidencias" items="${incidencias}">



 		<div class="col-md-8-2 panel panel-default">
	 		<div class="wrap-2">
	 		<br>
	 		<c:set var="status" value="${incidencias.estado}"/>
	 		
	 		<c:if test="${fn:contains(status, 'PENDIENTE')}">
   				<a href="incidencia/administrator/resolve.do?id=${incidencias.id}">
			<img  src="images/bloqueado (1).png">
			</a>
   			</c:if>	
   				
	 		<span class="text-uppercase petSitterRegister-text">${incidencias.titulo}</span>
	 		<br>
	 		${incidencias.descripcion}
			
			
			
			</div>
	 	</div>
	 	</jstl:forEach>
	
	</security:authorize>
	


	
</div>
	
	<div class="col-md-1"></div>
	<div class="col-md-5">
	<h2>Comentarios</h2>
<jstl:forEach var="calificacionOfertas" items="${calificacionOfertas}">
 		<div class="col-md-8-2 panel panel-default">
	 		<div class="wrap-2">
	 		<br>
	 		<jstl:if test="${not empty calificacionOfertas.estudiante.photo}">
			<img src="estudiante/showImage.do?id=${calificacionOfertas.estudiante.id}" height="40" width="40" border="3">
		</jstl:if>
		<jstl:if test="${! not empty calificacionOfertas.estudiante.photo}">
			<img src="images/chico.png" height="30" width="30" border="3">
		</jstl:if>
	 		<span class="text-uppercase petSitterRegister-text">${calificacionOfertas.estudiante.apellidos},${calificacionOfertas.estudiante.nombre}</span>
	 		<br>
	 		<span class="text-uppercase petOwnerRegister-text"><strong>${calificacionOfertas.oferta.nombre}</strong></span>
			${calificacionOfertas.comentarios}
			
		
				<jstl:if test="${calificacionOfertas.calificacion<2.0}">
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${calificacionOfertas.calificacion>=2.0 and calificacionOfertas.calificacion<4.0}">
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${calificacionOfertas.calificacion>=4.0 and calificacionOfertas.calificacion<6.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${calificacionOfertas.calificacion>=6.0 and calificacionOfertas.calificacion<8.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${calificacionOfertas.calificacion>=8.0 and calificacionOfertas.calificacion<10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${calificacionOfertas.calificacion==10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
					</jstl:if>
			
			
			
			</div>
	 	</div>
 	</jstl:forEach>

	
	</div>



