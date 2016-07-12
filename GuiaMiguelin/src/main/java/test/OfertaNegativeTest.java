package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import services.EstablecimientoService;
import services.IncidenciaService;
import services.OfertaService;

import domain.Establecimiento;
import domain.Incidencia;
import domain.Oferta;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
public class OfertaNegativeTest extends AbstractTest{

	@Autowired
	private OfertaService ofertaService;
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearOfertaBuenaEstudiante(){
		
		authenticate("estudiante4.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(51);		
		Oferta oferta = ofertaService.create(establecimiento.getId());
		
		oferta.setDescripcion("oferta descripcion");
		oferta.setNombre("nombre pruebas");
		
		unauthenticate();
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearOfertaBuenaAdmi(){
		
		authenticate("admin1");
		
		Establecimiento establecimiento = establecimientoService.findOne(51);		
		Oferta oferta = ofertaService.create(establecimiento.getId());
		
		oferta.setDescripcion("oferta descripcion");
		oferta.setNombre("nombre pruebas");
		
		unauthenticate();
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearOferta(){
		
		
		
		Establecimiento establecimiento = establecimientoService.findOne(51);		
		Oferta oferta = ofertaService.create(establecimiento.getId());
		
		oferta.setDescripcion("oferta descripcion");
		oferta.setNombre("nombre pruebas");
		
		
	}
	
	
	
}
