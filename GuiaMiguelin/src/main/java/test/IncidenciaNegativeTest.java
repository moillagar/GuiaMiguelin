package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import services.IncidenciaService;
import services.OfertaService;
import domain.Incidencia;
import domain.Oferta;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
public class IncidenciaNegativeTest extends AbstractTest{

	
	
	@Autowired
	private IncidenciaService incidenciaService;
	@Autowired
	private OfertaService ofertaService;
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearIncidenciaProveedor(){
		authenticate("proveedor3.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		Incidencia i = incidenciaService.create(oferta.getId());
		
		i.setDescripcion("descripcion");
		i.setTitulo("titulo");
		
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearIncidenciaAdmin(){
		authenticate("admin1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		Incidencia i = incidenciaService.create(oferta.getId());
		
		i.setDescripcion("descripcion");
		i.setTitulo("titulo");
		
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearIncidencia(){
		
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		Incidencia i = incidenciaService.create(oferta.getId());
		
		i.setDescripcion("descripcion");
		i.setTitulo("titulo");
		
	
	}
	
	
}
