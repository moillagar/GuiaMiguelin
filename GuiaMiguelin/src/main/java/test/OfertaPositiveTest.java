package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import domain.Establecimiento;
import domain.Oferta;

import services.EstablecimientoService;
import services.OfertaService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@TransactionConfiguration(defaultRollback = false)
public class OfertaPositiveTest extends AbstractTest{

	
	
	@Autowired
	private OfertaService ofertaService;
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	
	@Test
	public void testCrearOfertaBuena(){
		
		authenticate("proveedor3.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(51);		
		Oferta oferta = ofertaService.create(establecimiento.getId());
		
		oferta.setDescripcion("oferta descripcion");
		oferta.setNombre("nombre pruebas");
		
		unauthenticate();
		
	}

}
