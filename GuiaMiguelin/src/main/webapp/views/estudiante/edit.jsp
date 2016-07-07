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


<form:form action="${requestURI}" modelAttribute="registerForm"
			enctype="multipart/form-data">

	<div class="col-md-12">
	<div class="col-md-6">
	
	<h3 class="widget-title">
		Crear estudiante
		</h3>
		
		<div class="inner">
		
			<form:hidden path="id" />


	
					

				<acme:textbox path="userName" code="estudiante_*user.name"></acme:textbox>
				<acme:password path="password" code="estudiante_*user.pass"></acme:password>
				<acme:password path="repeatedPassword" code="estudiante_*passRepeated"></acme:password>


				<acme:textbox path="nombre" code="estudiante_*nombre"></acme:textbox>

				<acme:textbox path="apellidos" code="estudiante_*apellidos"></acme:textbox>
	
	
	
	
	</div>
	</div>
	<div class="col-md-1 "></div>
<div class="col-md-5 ">
<div class="container-fluid text-center">

<img alt="" class="img-circle" src="images/equipo.png">
</div>
<acme:textbox path="email" code="estudiante_*email"></acme:textbox>
<div class="form-group">
				
					Titulaci�n:
				
				<form:select id="titulacion" path="titulacion" class="form-control">
					<form:option value="0" label="----" />
							<option value='Administraci�n y Direcci�n de Empresas'>Administraci�n y Direcci�n de Empresas</option>
							<option value='Administraci�n y Direcci�n de Empresas y en Derecho'>Administraci�n y Direcci�n de Empresas y en Derecho</option>
							<option value='Antropolog�a social y cultural'>Antropolog�a social y cultural</option>
							<option value='Arqueolog�a'>Arqueolog�a</option>
							<option value='Bellas artes'>Bellas artes</option>
							<option value='Biolog�a'>Biolog�a</option>
							<option value='Biomedicina B�sica y Experimental'>Biomedicina B�sica y Experimental</option>
							<option value='Bioqu�mica'>Bioqu�mica</option>
							<option value='Ciencias de la Actividad Fisica y del Deporte'>Ciencias de la Actividad Fisica y del Deporte</option>
							<option value='Ciencias del trabajo'>Ciencias del trabajo</option>
							<option value='Ciencias Empresariales'>Ciencias Empresariales</option>
							<option value='Ciencias Empresariales y Diplomado en Relaciones Laborales'>Ciencias Empresariales y Diplomado en Relaciones Laborales</option>
							<option value='Ciencias y t�cnicas estad�sticas'>Ciencias y t�cnicas estad�sticas</option>
							<option value='Comunicaci�n audiovisual'>Comunicaci�n audiovisual</option>
							<option value='Comunicaci�n Audiovisual '>Comunicaci�n Audiovisual</option>
							<option value='Conservaci�n y Restauraci�n de Bienes Culturales'>Conservaci�n y Restauraci�n de Bienes Culturales</option>
							<option value='Criminolog�a'>Criminolog�a</option>
							<option value='Derecho'>Derecho</option>
							<option value='Derecho + ADE'>Derecho + ADE</option>
							<option value='Derecho + Gesti�n y Administraci�n P�blica'>Derecho + Gesti�n y Administraci�n P�blica</option>
							<option value='Derecho y en Finanzas y Contabilidad'>Derecho y en Finanzas y Contabilidad</option>
							<option value='Derecho y Finanzas y Contabilidad'>Derecho y Finanzas y Contabilidad</option>
							<option value='Doble grado de Derecho y Econom�a'>Doble grado de Derecho y Econom�a</option>
							<option value='Econom�a'>Econom�a</option>
							<option value='Educacion especial'>Educacion especial</option>
							<option value='Educacion fisica'>Educacion fisica</option>
							<option value='Educacion Infantil'>Educacion Infantil</option>
							<option value='Educacion musical'>Educacion musical</option>
							<option value='Educaci�n Primaria'>Educaci�n Primaria</option>
							<option value='Enfermer�a'>Enfermer�a</option>
							<option value='Estad�stica'>Estad�stica</option>
							<option value='Estudios �rabes e Isl�micos'>Estudios �rabes e Isl�micos</option>
							<option value='Estudios de Asia Oriental'>Estudios de Asia Oriental</option>
							<option value='Estudios Franceses'>Estudios Franceses</option>
							<option value='Estudios Ingleses'>Estudios Ingleses</option>
							<option value='Farmacia'>Farmacia</option>
							<option value='Farmacia y en �ptica y Optometr�a'>Farmacia y en �ptica y Optometr�a</option>
							<option value='Filolog�a cl�sica'>Filolog�a cl�sica</option>
							<option value='Filolog�a hisp�nica'>Filolog�a hisp�nica</option>
							<option value='Filolog�a italiana'>Filolog�a italiana</option>
							<option value='Filosof�a'>Filosof�a</option>
							<option value='Finanzas y Contabilidad'>Finanzas y Contabilidad</option>
							<option value='Finanzas y Contabilidad + Relaciones Laborales y Recursos Humanos'>Finanzas y Contabilidad + Relaciones Laborales y Recursos Humanos</option>
							<option value='F�sica'>F�sica</option>
							<option value='F�sica y en Ingenier�a de Materiales'>F�sica y en Ingenier�a de Materiales</option>
							<option value='Fisioterapia'>Fisioterapia</option>
							<option value='Fundamentos de Arquitectura'>Fundamentos de Arquitectura</option>
							<option value='Geograf�a y Gesti�n del Territorio'>Geograf�a y Gesti�n del Territorio</option>
							<option value='Geograf�a y Gesti�n del Territorio + Historia'>Geograf�a y Gesti�n del Territorio + Historia</option>
							<option value='Gesti�n y Administraci�n P�blica'>Gesti�n y Administraci�n P�blica</option>
							<option value='Grado en �ptica y optiometr�a'>Grado en �ptica y optiometr�a</option>
							<option value='Historia'>Historia</option>
							<option value='Historia del arte'>Historia del arte</option>
							<option value='Ingenier�a Aeroespacial'>Ingenier�a Aeroespacial</option>
							<option value='Ingenier�a Agr�cola'>Ingenier�a Agr�cola</option>
							<option value='Ingenier�a Civil'>Ingenier�a Civil</option>
							<option value='Ingenier�a de Edificaci�n'>Ingenier�a de Edificaci�n</option>
							<option value='Ingenier�a de la Salud'>Ingenier�a de la Salud</option>
							<option value='Ingenier�a de las Tecnolog�as de Telecomunicaci�n'>Ingenier�a de las Tecnolog�as de Telecomunicaci�n</option>
							<option value='Ingenier�a de Tecnolog�as Industriales'>Ingenier�a de Tecnolog�as Industriales</option>
							<option value='Ingenier�a El�ctrica'>Ingenier�a El�ctrica</option>
							<option value='Ingenier�a El�ctrica + Ingenier�a Electr�nica Industrial'>Ingenier�a El�ctrica + Ingenier�a Electr�nica Industrial</option>
							<option value='Ingenier�a El�ctrica + Ingenier�a Mec�nica'>Ingenier�a El�ctrica + Ingenier�a Mec�nica</option>
							<option value='Ingenier�a Electr�nica Industrial'>Ingenier�a Electr�nica Industrial</option>
							<option value='Ingenier�a Electr�nica, Rob�tica y Mecatr�nica'>Ingenier�a Electr�nica, Rob�tica y Mecatr�nica</option>
							<option value='Ingenier�a en Dise�o Industrial y Desarrollo del Producto'>Ingenier�a en Dise�o Industrial y Desarrollo del Producto</option>
							<option value='Ingenier�a en Dise�o Industrial y Desarrollo del Producto + Ingenier�a Mec�nica'>Ingenier�a en Dise�o Industrial y Desarrollo del Producto + Ingenier�a Mec�nica</option>
							<option value='Ingenier�a en materiales'>Ingenier�a en materiales</option>
							<option value='Ingenier�a Inform�tica - Ingenier�a de Computadores'>Ingenier�a Inform�tica - Ingenier�a de Computadores</option>
							<option value='Ingenier�a Inform�tica - Ingenier�a del Software'>Ingenier�a Inform�tica - Ingenier�a del Software</option>
							<option value='Ingenier�a Inform�tica - Tecnolog�as Inform�ticas'>Ingenier�a Inform�tica - Tecnolog�as Inform�ticas</option>
							<option value='Ingenier�a Mec�nica'>Ingenier�a Mec�nica</option>
							<option value='Ingenier�a Qu�mica'>Ingenier�a Qu�mica</option>
							<option value='Ingenier�a Qu�mica Industrial'>Ingenier�a Qu�mica Industrial</option>
							<option value='Ingeniero de telecomunicacion'>Ingeniero de telecomunicacion</option>
							<option value='Ingeniero en automatica y electronica industrial'>Ingeniero en automatica y electronica industrial</option>
							<option value='Ingeniero en Electr�nica e Ingeniero en Organizaci�n Industrial'>Ingeniero en Electr�nica e Ingeniero en Organizaci�n Industrial</option>
							<option value='Ingeniero industrial'>Ingeniero industrial</option>
							<option value='Ingeniero t�cnico agr�cola - explotaciones agropecuarias'>Ingeniero t�cnico agr�cola - explotaciones agropecuarias</option>
							<option value='Ingeniero tecnico agricola - hortofruticultura y jardineria'>Ingeniero tecnico agricola - hortofruticultura y jardineria</option>
							<option value='Investigaci�n y Tecnicas de Mercado'>Investigaci�n y Tecnicas de Mercado</option>
							<option value='Lengua y Literatura Alemanas'>Lengua y Literatura Alemanas</option>
							<option value='Lengua y Literatura Alemanas y en Educaci�n Primaria'>Lengua y Literatura Alemanas y en Educaci�n Primaria</option>
							<option value='Marketing e Investigaci�n de Mercados'>Marketing e Investigaci�n de Mercados</option>
							<option value='Matem�ticas'>Matem�ticas</option>
							<option value='Medicina'>Medicina</option>
							<option value='Odontolog�a'>Odontolog�a</option>
							<option value='Optica y optometr�a'>Optica y optometr�a</option>
							<option value='Pedagog�a'>Pedagog�a</option>
							<option value='Periodismo'>Periodismo</option>							
							<option value='Periodismo'>Periodismo</option>
							<option value='Periodismo + Comunicaci�n Audiovisual'>Periodismo + Comunicaci�n Audiovisual</option>
							<option value='Podolog�a'>Podolog�a</option>
							<option value='Psicolog�a'>Psicolog�a</option>
							<option value='Publicidad y Relaciones P�blicas'>Publicidad y Relaciones P�blicas</option>
							<option value='Qu�mica'>Qu�mica</option>
							<option value='Relaciones Laborales y Recursos Humanos'>Relaciones Laborales y Recursos Humanos</option>
							<option value='Turismo'>Turismo</option>

							<option value='Ingeniero en Electr�nica e Ingeniero en Organizaci�n Industrial'>Ingeniero en Electr�nica e Ingeniero en Organizaci�n Industrial</option>
							
				</form:select>
				</div>
				
				<div class="form-group text-left">
				

				<form:label path="fechaNacimiento">
		Fecha de Nacimiento:
	</form:label>
	<form:input path="fechaNacimiento" type="text" value="dd/mm/yyy" onfocus="if (this.value=='dd/mm/yyy') this.value='';" 
	onblur="if (this.value=='') "/>
	<form:errors cssClass="error" path="fechaNacimiento" />
	<br />
</div>

			

	<input type="file" name="file" id="file">
</div>
				
	<br>



		
		
	
		
		
	
	
	
	
	
	</div>
	
	Los campos marcados con (*) son obligatorios
			<br>
			Si se registra, eso significa que acepta nuestras condiciones de uso.
			<a href="welcome/legal.do" target="_blank">Puede ver nuestras condiciones de uso aqu�</a>
					
					
			
			<br>
		
			<input type="submit" name="save" class="btnAccept"
		value="Registrarse" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	</form:form>
	


