package test;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import services.EstablecimientoService;

import domain.Establecimiento;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml" })
public class EstablecimientoNegativeTest extends AbstractTest{

	
	@Autowired
	EstablecimientoService establecimientoService;
	
	
	
	
	
	
	
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearEstablecimientoAdmin(){
		authenticate("admin1");
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
	
		
		unauthenticate();
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearEstablecimientoEstudiante(){
		authenticate("estudiante4.1");
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
	
		
		unauthenticate();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCrearEstablecimientoAnonimo(){
		
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
	
		
	}
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveEstablecimientoAdmin(){
		authenticate("admin1");
		
		
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
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveEstablecimientoEstudiante(){
		authenticate("estudiante4.1");
		
		
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveEstablecimientoAnonimo(){
		
		
		
		Establecimiento e = establecimientoService.create();
		
		
		e.setCampus("SADUS");
		e.setDescripcion("creando establecimiento prueba positiva");
		e.setDireccion("direcion prueba positiva");
		e.setNombre("nombre prueba");
		e.setNumeroTelefono("954013648");
		e.setTipoEstablecimiento("BAR");
		establecimientoService.save(e);
		
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testPublicarEstablecimientoProveedor(){
		
		authenticate("proveedor3.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(53);
		
		establecimientoService.publicarEstablecimiento(establecimiento);
		unauthenticate();
		
		}
	

	@Test(expected = IllegalArgumentException.class)
	public void testPublicarEstablecimiento(){
		
		
		
		Establecimiento establecimiento = establecimientoService.findOne(53);
		
		establecimientoService.publicarEstablecimiento(establecimiento);
	
		
		
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testPublicarEstablecimientoEstudiante(){
		
		authenticate("estudiante4.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(53);
		
		establecimientoService.publicarEstablecimiento(establecimiento);
		unauthenticate();
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBloquearEstablecimiento(){
		
		
		Establecimiento establecimiento = establecimientoService.findOne(54);
		
		establecimientoService.bloquearEstablecimiento(establecimiento);
			
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBloquearEstablecimientoProveedor(){
		
		authenticate("proveedor3.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(54);
		
		establecimientoService.bloquearEstablecimiento(establecimiento);
		unauthenticate();
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBloquearEstablecimientoEstudiante(){
		
		authenticate("estudiante4.1");
		
		Establecimiento establecimiento = establecimientoService.findOne(54);
		
		establecimientoService.bloquearEstablecimiento(establecimiento);
		unauthenticate();
		
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void testEstablecimientosPublicados(){
		
		
		
	
		
		Collection<Establecimiento> establecimientos = establecimientoService.findPublicados();
		
		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEstablecimientosPublicadosProveedor(){
		
		authenticate("proveedor3.1");
		
	
		
		Collection<Establecimiento> establecimientos = establecimientoService.findPublicados();
		unauthenticate();
		
		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testEstablecimientosPublicadosEstudiante(){
		
		authenticate("estudiante4.1");
		
	
		
		Collection<Establecimiento> establecimientos = establecimientoService.findPublicados();
		unauthenticate();
		
		
	}
	
	
	
	
	
}
