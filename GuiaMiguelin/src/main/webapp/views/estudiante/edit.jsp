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
				
					Titulación:
				
				<form:select id="titulacion" path="titulacion" class="form-control">
					<form:option value="0" label="----" />
							<option value='Administración y Dirección de Empresas'>Administración y Dirección de Empresas</option>
							<option value='Administración y Dirección de Empresas y en Derecho'>Administración y Dirección de Empresas y en Derecho</option>
							<option value='Antropología social y cultural'>Antropología social y cultural</option>
							<option value='Arqueología'>Arqueología</option>
							<option value='Bellas artes'>Bellas artes</option>
							<option value='Biología'>Biología</option>
							<option value='Biomedicina Básica y Experimental'>Biomedicina Básica y Experimental</option>
							<option value='Bioquímica'>Bioquímica</option>
							<option value='Ciencias de la Actividad Fisica y del Deporte'>Ciencias de la Actividad Fisica y del Deporte</option>
							<option value='Ciencias del trabajo'>Ciencias del trabajo</option>
							<option value='Ciencias Empresariales'>Ciencias Empresariales</option>
							<option value='Ciencias Empresariales y Diplomado en Relaciones Laborales'>Ciencias Empresariales y Diplomado en Relaciones Laborales</option>
							<option value='Ciencias y técnicas estadísticas'>Ciencias y técnicas estadísticas</option>
							<option value='Comunicación audiovisual'>Comunicación audiovisual</option>
							<option value='Comunicación Audiovisual '>Comunicación Audiovisual</option>
							<option value='Conservación y Restauración de Bienes Culturales'>Conservación y Restauración de Bienes Culturales</option>
							<option value='Criminología'>Criminología</option>
							<option value='Derecho'>Derecho</option>
							<option value='Derecho + ADE'>Derecho + ADE</option>
							<option value='Derecho + Gestión y Administración Pública'>Derecho + Gestión y Administración Pública</option>
							<option value='Derecho y en Finanzas y Contabilidad'>Derecho y en Finanzas y Contabilidad</option>
							<option value='Derecho y Finanzas y Contabilidad'>Derecho y Finanzas y Contabilidad</option>
							<option value='Doble grado de Derecho y Economía'>Doble grado de Derecho y Economía</option>
							<option value='Economía'>Economía</option>
							<option value='Educacion especial'>Educacion especial</option>
							<option value='Educacion fisica'>Educacion fisica</option>
							<option value='Educacion Infantil'>Educacion Infantil</option>
							<option value='Educacion musical'>Educacion musical</option>
							<option value='Educación Primaria'>Educación Primaria</option>
							<option value='Enfermería'>Enfermería</option>
							<option value='Estadística'>Estadística</option>
							<option value='Estudios Árabes e Islámicos'>Estudios Árabes e Islámicos</option>
							<option value='Estudios de Asia Oriental'>Estudios de Asia Oriental</option>
							<option value='Estudios Franceses'>Estudios Franceses</option>
							<option value='Estudios Ingleses'>Estudios Ingleses</option>
							<option value='Farmacia'>Farmacia</option>
							<option value='Farmacia y en Óptica y Optometría'>Farmacia y en Óptica y Optometría</option>
							<option value='Filología clásica'>Filología clásica</option>
							<option value='Filología hispánica'>Filología hispánica</option>
							<option value='Filología italiana'>Filología italiana</option>
							<option value='Filosofía'>Filosofía</option>
							<option value='Finanzas y Contabilidad'>Finanzas y Contabilidad</option>
							<option value='Finanzas y Contabilidad + Relaciones Laborales y Recursos Humanos'>Finanzas y Contabilidad + Relaciones Laborales y Recursos Humanos</option>
							<option value='Física'>Física</option>
							<option value='Física y en Ingeniería de Materiales'>Física y en Ingeniería de Materiales</option>
							<option value='Fisioterapia'>Fisioterapia</option>
							<option value='Fundamentos de Arquitectura'>Fundamentos de Arquitectura</option>
							<option value='Geografía y Gestión del Territorio'>Geografía y Gestión del Territorio</option>
							<option value='Geografía y Gestión del Territorio + Historia'>Geografía y Gestión del Territorio + Historia</option>
							<option value='Gestión y Administración Pública'>Gestión y Administración Pública</option>
							<option value='Grado en óptica y optiometría'>Grado en óptica y optiometría</option>
							<option value='Historia'>Historia</option>
							<option value='Historia del arte'>Historia del arte</option>
							<option value='Ingeniería Aeroespacial'>Ingeniería Aeroespacial</option>
							<option value='Ingeniería Agrícola'>Ingeniería Agrícola</option>
							<option value='Ingeniería Civil'>Ingeniería Civil</option>
							<option value='Ingeniería de Edificación'>Ingeniería de Edificación</option>
							<option value='Ingeniería de la Salud'>Ingeniería de la Salud</option>
							<option value='Ingeniería de las Tecnologías de Telecomunicación'>Ingeniería de las Tecnologías de Telecomunicación</option>
							<option value='Ingeniería de Tecnologías Industriales'>Ingeniería de Tecnologías Industriales</option>
							<option value='Ingeniería Eléctrica'>Ingeniería Eléctrica</option>
							<option value='Ingeniería Eléctrica + Ingeniería Electrónica Industrial'>Ingeniería Eléctrica + Ingeniería Electrónica Industrial</option>
							<option value='Ingeniería Eléctrica + Ingeniería Mecánica'>Ingeniería Eléctrica + Ingeniería Mecánica</option>
							<option value='Ingeniería Electrónica Industrial'>Ingeniería Electrónica Industrial</option>
							<option value='Ingeniería Electrónica, Robótica y Mecatrónica'>Ingeniería Electrónica, Robótica y Mecatrónica</option>
							<option value='Ingeniería en Diseño Industrial y Desarrollo del Producto'>Ingeniería en Diseño Industrial y Desarrollo del Producto</option>
							<option value='Ingeniería en Diseño Industrial y Desarrollo del Producto + Ingeniería Mecánica'>Ingeniería en Diseño Industrial y Desarrollo del Producto + Ingeniería Mecánica</option>
							<option value='Ingeniería en materiales'>Ingeniería en materiales</option>
							<option value='Ingeniería Informática - Ingeniería de Computadores'>Ingeniería Informática - Ingeniería de Computadores</option>
							<option value='Ingeniería Informática - Ingeniería del Software'>Ingeniería Informática - Ingeniería del Software</option>
							<option value='Ingeniería Informática - Tecnologías Informáticas'>Ingeniería Informática - Tecnologías Informáticas</option>
							<option value='Ingeniería Mecánica'>Ingeniería Mecánica</option>
							<option value='Ingeniería Química'>Ingeniería Química</option>
							<option value='Ingeniería Química Industrial'>Ingeniería Química Industrial</option>
							<option value='Ingeniero de telecomunicacion'>Ingeniero de telecomunicacion</option>
							<option value='Ingeniero en automatica y electronica industrial'>Ingeniero en automatica y electronica industrial</option>
							<option value='Ingeniero en Electrónica e Ingeniero en Organización Industrial'>Ingeniero en Electrónica e Ingeniero en Organización Industrial</option>
							<option value='Ingeniero industrial'>Ingeniero industrial</option>
							<option value='Ingeniero técnico agrícola - explotaciones agropecuarias'>Ingeniero técnico agrícola - explotaciones agropecuarias</option>
							<option value='Ingeniero tecnico agricola - hortofruticultura y jardineria'>Ingeniero tecnico agricola - hortofruticultura y jardineria</option>
							<option value='Investigación y Tecnicas de Mercado'>Investigación y Tecnicas de Mercado</option>
							<option value='Lengua y Literatura Alemanas'>Lengua y Literatura Alemanas</option>
							<option value='Lengua y Literatura Alemanas y en Educación Primaria'>Lengua y Literatura Alemanas y en Educación Primaria</option>
							<option value='Marketing e Investigación de Mercados'>Marketing e Investigación de Mercados</option>
							<option value='Matemáticas'>Matemáticas</option>
							<option value='Medicina'>Medicina</option>
							<option value='Odontología'>Odontología</option>
							<option value='Optica y optometría'>Optica y optometría</option>
							<option value='Pedagogía'>Pedagogía</option>
							<option value='Periodismo'>Periodismo</option>							
							<option value='Periodismo'>Periodismo</option>
							<option value='Periodismo + Comunicación Audiovisual'>Periodismo + Comunicación Audiovisual</option>
							<option value='Podología'>Podología</option>
							<option value='Psicología'>Psicología</option>
							<option value='Publicidad y Relaciones Públicas'>Publicidad y Relaciones Públicas</option>
							<option value='Química'>Química</option>
							<option value='Relaciones Laborales y Recursos Humanos'>Relaciones Laborales y Recursos Humanos</option>
							<option value='Turismo'>Turismo</option>

							<option value='Ingeniero en Electrónica e Ingeniero en Organización Industrial'>Ingeniero en Electrónica e Ingeniero en Organización Industrial</option>
							
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
			<a href="welcome/legal.do" target="_blank">Puede ver nuestras condiciones de uso aquí</a>
					
					
			
			<br>
		
			<input type="submit" name="save" class="btnAccept"
		value="Registrarse" />


	<input type="button" name="cancel" class="btnCancel"
		value=" Cancelar"
		onclick="javascript: window.location.replace('welcome/index.do'); " />
	</form:form>
	


