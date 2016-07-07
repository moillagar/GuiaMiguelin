<%--
 * index.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<security:authorize access="isAnonymous()">
<div id="toptop">
</div>
<!-- Si no es movil -->
<div id="myCarousel" class="carousel slide zonaResponsiva" data-ride="carousel">
    <!-- Indicators -->

    <!-- Wrapper for slides -->
    <div id="alturaControlada" class="carousel-inner" role="listbox" >
      <div class="item active">
        <img class="todoAncho" src="images/slide1.jpg" alt="Presentation 1" >
      </div>

      <div class="item">
        <img class="todoAncho" src="images/slide2.jpg" alt="Presentation 2" >
      </div>
    
      <div class="item">
        <img class="todoAncho" src="images/slide2.jpg" alt="Presentation 3" >
      </div>
      
      <div class="item">
        <img class="todoAncho" src="images/slide3.jpg" alt="Presentation 4" >
      </div>
      
      <div class="item">
        <img class="todoAncho" src="images/slide4.jpg" alt="Presentation 5" >
      </div>
      
      <div class="item">
        <img class="todoAncho" src="images/slide5.jpg" alt="Presentation 6" >
      </div>
    
      <div class="item">
        <img class="todoAncho" src="images/slide6.jpg" alt="Presentation 7"  >
      </div>
      
      <div class="item">
        <img class="todoAncho" src="images/slide7.jpg" alt="Presentation 8" >
      </div>
      
      <div class="item">
        <img class="todoAncho" src="images/slide8.jpg" alt="Presentation 9" >
      </div>
      



 </div> 
 
</div>




<div id="users" class="container text-center noCortes">
  <!-- <h3><spring:message	code="master.page.petcare" /></h3> -->
  <img width="30%" src="images/logo.png" alt="PetCare"/>
  <br/>
  <br/>
  <p>Si necesitas comer y no sabes donde, ¡GuiaMiguelin es su lugar! En el encontrarás ofertas de todo tipo y valoraciones de nuestros usuarios. Entra y podras descubrir los mejores lugares cerca de ti. ¡Registrate ya!</p>
  <br>
  <div class="row">
    <div class="col-sm-6">
      <span class="text-uppercase petOwnerRegister-text"><strong>Estudiates</strong></span>
      <br>
      <a href="#demo" data-toggle="collapse">
        <img src="images/estudianteIndex.jpg" class="img-circle person" alt="Pet Owner" width="255" height="255">
      </a>
      <div id="demo" class="collapse">
        <p>
			¡Es fácil!
        	<span class="text-uppercase petOwnerRegister-text">Registrate</span>
        	
        	 y comienza a disfrutar
        	
        	<span class="text-uppercase petOwnerRegister-text">Encontrarás las mejores ofertas</span>
        
        	cerca de ti
        
		</p>
        
		<security:authorize access="!hasAnyRole('ESTUDIANTE','PROVEEDOR')">
		<a class="btnAcceptNoMargin text-uppercase" href="estudiante/register.do">¡REGISTRATE!</a>
      	</security:authorize>
      </div>
    </div>
    <div class="col-sm-6">
      <span class="text-uppercase petSitterRegister-text"><strong>Restauradores</strong></span>
      <br>
      <a href="#demo2" data-toggle="collapse">
        <img src="images/proveedorIndex.jpg" class="img-circle person" alt="Pet Sitter" width="255" height="255">
      </a>
      <div id="demo2" class="collapse">
        <p>
        	Aumente sus ventas
        	<span class="text-uppercase petSitterRegister-text">Registrese ya</span>
        	y publicitese entre
        	<span class="text-uppercase petSitterRegister-text">miles de usuarios</span>
        	
        	
        </p>
        <security:authorize access="!hasAnyRole('ESTUDIANTE','PROVEEDOR')">
		<a class="btnAcceptNoMargin text-uppercase" href="proveedor/register.do">¡REGISTRATE!</a>
      	</security:authorize>
      </div>
    </div>
    </div>
  </div>

 
<!-- 
<div id="googleMap"></div>
 -->

	 <!-- Modal -->
  <div class="modal fade" id="loginForm" role="dialog">
    <div class="modal-dialog">
    
    
    
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Registrarse</h4>
        </div>
        <jstl:if test="${showError==true}">
				<div class="alert alert-danger" id="danger-alert" onload="alert('hola');">
			    <button type="button" class="close" data-dismiss="alert">x</button>
			    <strong>Usuario y/o contraseña incorrectos</strong>
			    
				</div>
			</jstl:if>
        <div class="modal-body">
          <form:form action="j_spring_security_check" modelAttribute="credentials">
            <div class="form-group">
              <form:input class="form-control" path="username" placeholder="Username"/>	
				<form:errors class="error" path="username" />
            </div>
            <div class="form-group">
              <form:password class="form-control" path="password" placeholder="Password"/>	
				<form:errors class="error" path="password" />
            </div>
              <button type="submit" class="btnAcceptNoMargin btn-block">¡Ir! 
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form:form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btnCancelNoMargin pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Volver
          </button>
        </div>
      </div>
    </div>
  </div>

</security:authorize>



<security:authorize access="hasRole('ESTUDIANTE')">
<div class="col-md-12">
<div class="col-md-1">
</div>
<div class="col-md-5">

<h2>Información Personal</h2>
<form:form action="${estudiante}" modelAttribute="estudiante">
<jstl:if test="${not empty estudiante.photo}">
			<img src="estudiante/showImage.do?id=${estudiante.id}" height="50" width="50" border="3">
		</jstl:if>
		<jstl:if test="${! not empty estudiante.photo}">
			<img src="images/chico.png" height="50" width="50">
		</jstl:if>
		<span class="text-uppercase petSitterRegister-text">${estudiante.apellidos}, ${estudiante.nombre} (<fmt:formatDate  value="${estudiante.fechaNacimiento}" pattern="dd/MM/yyyy" />)</span>
		<br><span class="text-uppercase petOwnerRegister-text">${estudiante.titulacion}</span>
		
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
	<fieldset>
	<legend>¿No estas contento con nuestras recomenaciones?</legend>
	Pruebe a buscar otras ofertas
	<br>
	<input type="text" id ="search" placeholder="Buscar Ofertas"/>&nbsp;&nbsp;&nbsp;
	
		<input type="submit" id ="search" name="save" class="btnAccept" onclick="jsonSearch()"
		value="Buscar" />	
		


		</fieldset>
	
	</form:form>

</div>
<div class="col-md-5">
<h2>Ofertas recomendadas</h2>
<jstl:forEach var="ofertas" items="${ofertas}">
	<div class="col-md-8-2 panel panel-default">
	<div class="wrap3">
	<br>
	
	<a href="oferta/estudiante/view.do?id=${ofertas.id}"><img src="images/ojo.png" height="40" width="40" border="3"></a>
	<span class="text-uppercase petSitterRegister-text">${ofertas.nombre}:</span>
	 		
	 		
			${ofertas.descripcion} 
	<br>
	<jstl:if test="${not empty ofertas.precio}">
	<span class="text-uppercase petSitterRegister-text">${ofertas.precio} <img  src="images/moneda.png">  </span>
	</jstl:if>
			&nbsp;&nbsp;&nbsp;<jstl:if test="${ofertas.calificacionMedia<2.0}">
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
<div class="col-md-1">

</div>

</div>



</security:authorize>

<security:authorize access="hasRole('PROVEEDOR')">
<div class="col-md-12">
<div class="col-md-1"></div>
<div class="col-md-5">
<br>
<a href="establecimiento/proveedor/create.do"><img  src="images/iconoProveedorIndex.png" /></a>

<h2>Últimos comentarios</h2>
<jstl:forEach var="calificacionOfertas" items="${calificacionOfertas}">
 		<div class="col-md-8-2 panel panel-default">
	 		<div class="wrap-2">
	 		
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





<div class="col-md-5">
<h2>Tus establecimientos</h2>

<jstl:forEach var="establecimientos" items="${establecimientos}">
 		<div class="col-md-8-2 panel panel-default">
	 		
	 		<c:set var="status" value="${establecimientos.publicado}"/>
	 		<c:if test="${fn:contains(status, 'true')}">
   				<a href="establecimiento/proveedor/view.do?id=${establecimientos.id}"><img class="max-h-4 img-left-2" alt="Care Person" src="images/exito.png"></a>
				</c:if>
				
				<c:if test="${fn:contains(status, 'false')}">
   				<a href="establecimiento/proveedor/view.do?id=${establecimientos.id}"><img class="max-h-4 img-left-2" src="images/fracaso.png"></a>
				</c:if>
	 	
	 		
	 		
	 		
	 		<span class="text-uppercase petSitterRegister-text">${establecimientos.nombre}</span>
	 		<i>${establecimientos.web}</i>
	 		<br>
			${establecimientos.descripcion} <DIV ALIGN=right><img  src="images/marcador.png">   ${establecimientos.direccion}</DIV>
		
			
			
		
			
		
				
			
			
			
	 	</div>
 	</jstl:forEach>

</div>
<div class="col-md-1"></div>
</div>
.
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<div class="col-md-12">
<div class="col-md-1"></div>
<div class="col-md-5">
<h2>Resolver Incidencias</h2>
<jstl:forEach var="incidencias" items="${incidencias}">



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
   				<a href="oferta/view.do?id=${incidencias.oferta.id}"><img class="max-h-4 img-left-2" src="images/reloj.png"></a>
   			</c:if>	
   				
	 		<span class="text-uppercase petSitterRegister-text">${incidencias.titulo}</span>
	 		<br>
	 		${incidencias.descripcion}
			
			
			
			</div>
	 	</div>
	 	</jstl:forEach>
	 	</div>
 	

<div class="col-md-1"></div>
<div class="col-md-5">
<h2>Publicar establecimientos</h2>

<jstl:forEach var="establecimientos" items="${establecimientos}">
 		<div class="col-md-8-2 panel panel-default">
	 		
	 		<c:set var="status" value="${establecimientos.publicado}"/>
	 		<c:if test="${fn:contains(status, 'true')}">
   				<a href="establecimiento/administrator/view.do?id=${establecimientos.id}"><img class="max-h-4 img-left-2" alt="Care Person" src="images/exito.png"></a>
				</c:if>
				
				<c:if test="${fn:contains(status, 'false')}">
   				<a href="establecimiento/administrator/view.do?id=${establecimientos.id}"><img class="max-h-4 img-left-2" src="images/fracaso.png"></a>
				</c:if>
	 	
	 		
	 		
	 		
	 		<span class="text-uppercase petSitterRegister-text">${establecimientos.nombre}</span>
	 		<i>${establecimientos.web}</i>
	 		<br>
			${establecimientos.descripcion} <DIV ALIGN=right><img  src="images/marcador.png">   ${establecimientos.direccion}</DIV>
		
	 	</div>
 	</jstl:forEach>

</div>

</div>
.

</security:authorize>

<!-- Add Google Maps -->
<!-- 
<script src="http://maps.googleapis.com/maps/api/js"></script>
-->




<script>




function showEr(er){
    $("#danger-alert").hide();
    alert('hola');
    if(er==true){
        $("#danger-alert").alert();
        $("#danger-alert").fadeTo(2000, 500).slideUp(500, function(){
       $("#danger-alert").alert('close');
    });
    }
};

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

