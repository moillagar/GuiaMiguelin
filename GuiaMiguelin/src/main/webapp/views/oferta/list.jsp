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

<input type="text" id ="search"/>
		<input type="button" onclick="jsonSearch()" value="<spring:message code="oferta.search" />">
		&nbsp;&nbsp;&nbsp;

<script>
function checkUrl(){
	 var pathname = window.location.pathname;
	 if(pathname!="/GuiaMiguelin/oferta/search.do"){
		var keyword= $("#search").val();
		if(keyword == ""){
		window.location.replace('/GuiaMiguelin/oferta/list.do');
		}
		
		window.location.replace('/GuiaMiguelin/oferta/search.do?name='+keyword);
	 }
	
}
function jsonSearch(){
	 checkUrl();
	
	$("#row").remove();
	
	text = $("#search").val();
	$.getJSON( "oferta/ajax.do?name="+text, function( json ) {
		 cont=0;
		var table = $("<table id='row'></table>").addClass('displaytag');
		var t=$("<thead><tr> <th>Nombre</th><th>Descripcion</th></thead>");
		table.append(t);
		
		$.each( json, function( i, item) {
			css="even";
			if(cont%2==0){
				css="odd";
			}
			 td="<tr class='"+css+"'><td>"+gym.nombre+"</td><td>"+gym.descripcion+"</td></tr>";
			 table.append(td);//$(".displaytag  ").append(td);
			cont++;
		});
	   $("#main div").html(table);//añade la tabla con todos los elementos al pa pagina
	});
	}

</script>

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