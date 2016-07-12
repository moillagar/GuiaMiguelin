package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import controllers.EstablecimientoEstudianteController;

import repositories.EstablecimientoRepository;

import domain.Administrator;
import domain.Establecimiento;
import domain.Estudiante;
import domain.Proveedor;


@Service
@Transactional
public class EstablecimientoService {

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private AdministratorService administratorService;
	
	public Collection<Establecimiento> findEstablecimientoByProveedorId() {
		Collection<Establecimiento> res;
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		res = establecimientoRepository.findEstablecimientoByProveedorId(proveedor.getId());
		return res;
	}
	public Establecimiento create() {
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.notNull(proveedor, "Debe de haber un proveedor logueado");
		Assert.isNull(administrator, "No puede haber un administrador logueado");
		Assert.isNull(estudiante,"No haber un estudiante logueado");
		
		Establecimiento establecimiento;
		establecimiento = new Establecimiento();
	
		establecimiento.setProveedor(proveedor);
		establecimiento.setPublicado(false);
		return establecimiento;
	}
	public void save(Establecimiento establecimiento) {
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.notNull(proveedor, "Debe de haber un proveedor logueado");
		Assert.isNull(administrator, "No puede haber un administrador logueado");
		Assert.isNull(estudiante,"No haber un estudiante logueado");
		establecimientoRepository.save(establecimiento);
		
	}
	public Establecimiento findOne(Integer id) {
		
		return establecimientoRepository.findOne(id);
	}
	
	public Collection<Establecimiento> findAll(){
		Collection<Establecimiento> result;
		result = establecimientoRepository.findAllOrderByName();
		return result;
	}
	
	public Collection<Establecimiento> findEstablecimientoNoPublicado(){
		return establecimientoRepository.findEstablecimientoNoPublicado();
	}
	public void publicarEstablecimiento(Establecimiento establecimiento) {
		
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.isNull(proveedor, "No debe de haber un proveedor logueado");
		Assert.notNull(administrator, "Debe de haber un administrador logueado");
		Assert.isNull(estudiante,"No debe de haber un estudiante logueado");
		Assert.isTrue(establecimiento.getPublicado().equals(false), "El establecimiento debe de estar bloqueado");
		establecimiento.setPublicado(true);
		establecimientoRepository.save(establecimiento);
		
	}
	public void bloquearEstablecimiento(Establecimiento establecimiento) {
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.isNull(proveedor, "No debe de haber un proveedor logueado");
		Assert.notNull(administrator, "Debe de haber un administrador logueado");
		Assert.isNull(estudiante,"No debe de haber un estudiante logueado");
		Assert.isTrue(establecimiento.getPublicado().equals(true), "El establecimiento debe de estar publicado");
		establecimiento.setPublicado(false);
		establecimientoRepository.save(establecimiento);
		
	}
	public Collection<Establecimiento> findPublicados() {
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.isNull(proveedor, "No debe de haber un proveedor logueado");
		Assert.notNull(administrator, "Debe de haber un administrador logueado");
		Assert.isNull(estudiante,"No debe de haber un estudiante logueado");
		return establecimientoRepository.findPublicados();
	}
	

}
