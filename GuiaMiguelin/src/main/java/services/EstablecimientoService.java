package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.EstablecimientoRepository;

import domain.Establecimiento;
import domain.Proveedor;


@Service
@Transactional
public class EstablecimientoService {

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Autowired
	private ProveedorService proveedorService;
	public Collection<Establecimiento> findEstablecimientoByProveedorId() {
		Collection<Establecimiento> res;
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		res = establecimientoRepository.findEstablecimientoByProveedorId(proveedor.getId());
		return res;
	}
	public Establecimiento create() {
		Establecimiento establecimiento;
		establecimiento = new Establecimiento();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		establecimiento.setProveedor(proveedor);
		establecimiento.setPublicado(false);
		return establecimiento;
	}
	public void save(Establecimiento establecimiento) {
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
		establecimiento.setPublicado(true);
		save(establecimiento);
		
	}
	public void bloquearEstablecimiento(Establecimiento establecimiento) {
		establecimiento.setPublicado(false);
		save(establecimiento);
		
	}
	public Collection<Establecimiento> findPublicados() {
		// TODO Auto-generated method stub
		return establecimientoRepository.findPublicados();
	}
	

}
