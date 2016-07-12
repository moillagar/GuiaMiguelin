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

import repositories.CalificacionOfertaRepository;
import services.CalificacionOfertaService;
import services.EstudianteService;
import services.OfertaService;

import domain.CalificacionOferta;
import domain.Oferta;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CalificacionOfertaNegativeTest extends AbstractTest{

	@Autowired
	private CalificacionOfertaService  calificacionOfertaService;
	@Autowired
	private OfertaService ofertaService;
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCalificacionOfertaAdmin(){
		authenticate("admin1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCalificacionOfertaProveedor(){
		authenticate("proveedor3.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateCalificacionOfertaAnonimo(){
	
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		
		
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveCalificacionOfertaAdmin(){
		authenticate("admin1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		calificacionOfertaService.save(calificacionOferta);
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveCalificacionOfertaProveedor(){
		authenticate("proveedor3.1");
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		calificacionOfertaService.save(calificacionOferta);
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveCalificacionOfertaAnonimo(){
		
		
		List<Oferta> ofertas = (List<Oferta>) ofertaService.findAll();
		Oferta oferta = ofertas.get(0);
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(oferta.getId());
		calificacionOferta.setCalificacion(5);
		calificacionOferta.setComentarios("prueba comentario positivo en test");
		calificacionOfertaService.save(calificacionOferta);
		
	}
	
	
	
}
