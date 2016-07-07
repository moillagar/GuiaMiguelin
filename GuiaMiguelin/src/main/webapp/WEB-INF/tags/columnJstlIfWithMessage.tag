<%--
 * column.tag
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@ tag language="java" body-content="empty" %>

<%-- Taglibs --%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%-- Attributes --%> 

<%@ attribute name="codeHeaderColumn" required="true" %>
<%@ attribute name="test" required="true" %>
<%@ attribute name="test2" required="false" %>
<%@ attribute name="test3" required="false" %>
<%@ attribute name="valueMessage" required="true" %>
<%@ attribute name="valueMessage2" required="false" %>
<%@ attribute name="valueMessage3" required="false" %>
<%@ attribute name="sortable" required="false" %>
<%@ attribute name="format" required="false" %>

<%-- Definition --%>

<div>
	<display:column titleKey="${codeHeaderColumn}" sortable="${sortable}" format="${format}">
		<jstl:if test="${test}">
			<spring:message code="${valueMessage}"/>
		</jstl:if>
		<jstl:if test="${test2}">
			<spring:message code="${valueMessage2}"/>
		</jstl:if>
		<jstl:if test="${test3}">
			<spring:message code="${valueMessage3}"/>
		</jstl:if>
	</display:column>

</div>