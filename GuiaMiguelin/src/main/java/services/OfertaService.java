package services;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.OfertaRepository;
import domain.CalificacionOferta;
import domain.Establecimiento;
import domain.Incidencia;
import domain.Oferta;
import domain.Proveedor;

@Service
@Transactional
public class OfertaService {
	
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	@Autowired
	ProveedorService proveedorService;
	
	public Oferta create(int id) {
		Oferta oferta;
		oferta = new Oferta();
		
		
		Collection<Incidencia> incidencias;
		incidencias = new ArrayList<Incidencia>();
		Collection<CalificacionOferta>calificacionOfertas = new ArrayList<CalificacionOferta>();
		
		
		oferta.setIncidencias(incidencias);
		oferta.setCalificacionOfertas(calificacionOfertas);
		Establecimiento establecimiento = establecimientoService.findOne(id);
		oferta.setEstablecimiento(establecimiento);
		oferta.setCodigo(RandomStringUtils.randomAlphanumeric(20));
		return oferta;
	}
	public void save(Oferta oferta) {
		ofertaRepository.save(oferta);
		
	}
	public Oferta findOne(Integer id) {
		
		return ofertaRepository.findOne(id);
	}
	
	public Collection<Oferta> findAll(){
	Collection<Oferta> result;
		result = ofertaRepository.findAll();
		return result;
	}
	
	public Collection<Oferta> findOfertaByKeyword(String key){
		Assert.notNull(key);
		Collection<Oferta> result = ofertaRepository.findOfertaByKeyword(key);
		return result;
	}
	public Collection<Oferta> findOfertaByEstablecimiento(Establecimiento establecimiento) {
		Integer id = establecimiento.getId();
		return ofertaRepository.findOfertaByEstablecimiento(id);
	}
	public Collection<Oferta> findOfertaByEstablecimientoId(Integer id) {
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		return ofertaRepository.findOfertaByEstablecimientoId(id);
	}
	public void delete(Oferta oferta) {
		ofertaRepository.delete(oferta.getId());
		
	}

}
