package test;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import services.CalificacionOfertaService;
import services.OfertaService;

import domain.CalificacionOferta;
import domain.Oferta;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@TransactionConfiguration(defaultRollback = false)
public class CalificacionOfertaPositiveTest extends AbstractTest{

	@Autowired
	private CalificacionOfertaService  calificacionOfertaService;
	@Autowired
	private OfertaService ofertaService;
	
	
	
	
	@Test
	public void testCreateCalificacionOferta(){
		authenticate("estudiante4.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		
		unauthenticate();
	}
	
	
	@Test
	public void testSaveCalificacionOferta(){
		authenticate("estudiante4.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		calificacionOfertaService.save(calificacionOferta);
		unauthenticate();
	}
	
	
	
	
	
	
	
	
	
}
