<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<display:table name="ofertas" id="row" requestURI="${requestURI}"
	class="displaytag" keepStatus="true" pagesize="5" >
	
	<spring:message code="oferta.nombre" var="nombreColumn" ></spring:message>
	<display:column property="nombre" title="${nombreColumn}" />
	
	<spring:message code="oferta.descripcion" var="descColumn" ></spring:message>
	<display:column property="descripcion" title="${descColumn}" />
	
	<spring:message code="oferta.precio" var="precioColumn" ></spring:message>
	<display:column property="precio" title="${precioColumn}" />
	
	<spring:message code="oferta.establecimiento" var="establecimientoColumn" ></spring:message>
	<display:column property="establecimiento" title="${establecimientoColumn}" />
	
	<spring:message code="oferta.codigo" var="codigoColumn" ></spring:message>
	<display:column property="codigo" title="${codigoColumn}" />
	
	<spring:message code="oferta.calificacionMedia" var="calificacionMediaColumn" ></spring:message>
	<display:column property="calificacionMedia" title="${calificacionMediaColumn}" />
	
</display:table>