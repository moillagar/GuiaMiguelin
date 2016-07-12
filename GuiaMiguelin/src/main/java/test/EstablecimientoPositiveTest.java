package test;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import domain.Establecimiento;

import services.EstablecimientoService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
@TransactionConfiguration(defaultRollback = false)
public class EstablecimientoPositiveTest extends AbstractTest{
	
	@Autowired
	EstablecimientoService establecimientoService;
	
	@Test
	public void testCrearEstablecimiento(){
		authenticate("proveedor3.1");
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
	
		
		unauthenticate();
	}
	
	
	
	@Test
	public void testSaveEstablecimiento(){
		authenticate("proveedor3.1");
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
	
		establecimientoService.save(e);
		unauthenticate();
	}
	
	
	@Test
	public void testPublicarEstablecimiento(){
		
		authenticate("admin1");
		
		Establecimiento establecimiento = establecimientoService.findOne(53);
		
		establecimientoService.publicarEstablecimiento(establecimiento);
		unauthenticate();
		
		
	}
	
	
	
	@Test
	public void testBloquearEstablecimiento(){
		
		authenticate("admin1");
		
		Establecimiento establecimiento = establecimientoService.findOne(54);
		
		establecimientoService.bloquearEstablecimiento(establecimiento);
		unauthenticate();
		
		
	}
	
	@Test
	public void testEstablecimientosPublicados(){
		
		authenticate("admin1");
		
	
		
		Collection<Establecimiento> establecimientos = establecimientoService.findPublicados();
		unauthenticate();
		
		
	}
	
	
	

}
