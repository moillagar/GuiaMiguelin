package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import services.IncidenciaService;
import services.OfertaService;

import domain.Incidencia;
import domain.Oferta;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@TransactionConfiguration(defaultRollback = false)
public class IncidenciaPositiveTest extends AbstractTest{

	
	@Autowired
	private IncidenciaService incidenciaService;
	@Autowired
	private OfertaService ofertaService;
	
	
	
	
	@Test
	public void testCrearIncidencia(){
		authenticate("estudiante4.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		Incidencia i = incidenciaService.create(oferta.getId());
		
		i.setDescripcion("descripcion");
		i.setTitulo("titulo");
		
		unauthenticate();
	}
	
	
}
