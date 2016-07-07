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
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<div class="col-md-1"></div>
<div class="col-md-5">


<form:form action="${establecimiento}" modelAttribute="establecimiento">
	<jstl:if test="${not empty establecimiento.photo}">
			<a href="establecimiento/proveedor/edit.do?id=${establecimiento.id}"><img src="establecimiento/proveedor/showImage.do?id=${establecimiento.id}" height="100" width="100" border="3"></a>
		</jstl:if>
		<jstl:if test="${! not empty establecimiento.photo}">
			<a href="establecimiento/proveedor/edit.do?id=${establecimiento.id}"><img src="images/imagen (1).png" height="100" width="100" border="3"></a>
		</jstl:if>
	<span class="text-uppercase petSitterRegister-text">${establecimiento.nombre}</span>
	<br>
	<span class="text-uppercase petOwnerRegister-text">${establecimiento.direccion}<img  src="images/marcador.png">   </span>
	 		<br>
	 		<i>${establecimiento.web}</i>
	 		<br>
			${establecimiento.descripcion} 
	
	
		
		<acme:label  text="${establecimiento.campus}" code="establecimiento.campus"></acme:label>		
		
	</form:form>
	
	
<security:authorize access="hasRole('ADMIN')">
	<h2>¿Publicar?</h2>

	<a href="establecimiento/administrator/publicar.do?establecimientoId=${establecimiento.id}"><img src="images/comprobado.png" height="50" width="50" border="3"></a>
	</security:authorize>

</div>


<div class="col-md-6">

<jstl:forEach var="ofertas" items="${ofertas}">
	<div class="col-md-8-2 panel panel-default">
	<div class="wrap3">
	<br>
	<security:authorize access="hasRole('PROVEEDOR')">
	<a href="oferta/proveedor/view.do?id=${ofertas.id}"><img src="images/ofertas.png" height="50" width="50" border="3"></a>
	<span class="text-uppercase petSitterRegister-text">${ofertas.nombre}:</span>
	 		
	 	</security:authorize>	
			${ofertas.descripcion} 
	<br>
	<jstl:if test="${not empty ofertas.precio}">
	<span class="text-uppercase petSitterRegister-text">${ofertas.precio} <img  src="images/moneda.png">  </span>
	</jstl:if>
			<jstl:if test="${ofertas.calificacionMedia<2.0}">
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${ofertas.calificacionMedia>=2.0 and ofertas.calificacionMedia<4.0}">
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${ofertas.calificacionMedia>=4.0 and ofertas.calificacionMedia<6.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${ofertas.calificacionMedia>=6.0 and ofertas.calificacionMedia<8.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${ofertas.calificacionMedia>=8.0 and ofertas.calificacionMedia<10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star-empty.png" />
					</jstl:if> <jstl:if test="${ofertas.calificacionMedia==10.0}">
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
						<img src="images/star.png" />
					</jstl:if>
			
		<br>
		</div>
		</div>
	</jstl:forEach>


</div>