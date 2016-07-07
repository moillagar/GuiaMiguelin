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
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<style>
		html{
  height: 100%;
}

</style>
<div class="row">
    <div class="col-sm-12" >
    	<div class="widget-container widget_avatar boxed">
         <jstl:if test="${not empty actived and actived==true}">
         <h3 class="widget-title"></h3>
          <div class="paddin25" > <p class="lead">
			<h1><spring:message code="failed.ok"/></h1>
			
      	 </div>
      	 </jstl:if>
      	 <jstl:if test="${not empty actived and actived==false}">
         <h3 class="widget-title"></h3>
          <div class="paddin25" > <p class="lead">
			<h1><spring:message code="failed.fail"/></h1>
			
      	 </div>
      	 </jstl:if>
      	  <h3 class="widget-footer"><a href="j_spring_security_logout"><spring:message
							code="failed.redirection" /></a></h3>
    	</div>
	</div>
</div>
