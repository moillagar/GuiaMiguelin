package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.IncidenciaRepository;

import domain.Administrator;
import domain.CalificacionOferta;
import domain.Estudiante;
import domain.Incidencia;
import domain.Oferta;
import domain.Proveedor;


@Service
@Transactional
public class IncidenciaService {

	@Autowired
	private IncidenciaRepository incidenciaRepository;
	
	@Autowired
	private AdministratorService administratorService;
	
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private ProveedorService proveedorService;
	
	public Collection<Incidencia> findIncidenciasOrder() {
		
		return incidenciaRepository.findIncidenciasOrder();
	}

	public Incidencia findOne(Integer id) {
		// TODO Auto-generated method stub
		return incidenciaRepository.findOne(id);
	}

	public void save(Incidencia incidencia) {
	
		incidenciaRepository.save(incidencia);
	}

	public Collection<Incidencia> findIncidenciasPendientes() {
		// TODO Auto-generated method stub
		return incidenciaRepository.findIncidenciasPendientes();
	}
	public void actualizaIncidence(Incidencia incidencia){
		Administrator administrator = administratorService.getLoggedAdmin();
		incidencia.setAdministrator(administrator);
		incidencia.setUpdateMoment(new Date(System.currentTimeMillis()-1000));
	}

	public Incidencia create(Integer id) {
		Administrator administrator = administratorService.getLoggedAdmin();
		Proveedor proveedor = proveedorService.getLoggedProveedor();
		Estudiante estudiante = estudianteService.getLoggedSingle();
		Assert.isNull(proveedor, "No puede haber un proveedor logueado");
		Assert.isNull(administrator, "No puede haber un administrador logueado");
		Assert.notNull(estudiante,"Debe de haber un estudiante logueado");
		Oferta oferta = ofertaService.findOne(id);
		
		Incidencia result;
		result = new Incidencia();
		result.setUpdateMoment(new Date(System.currentTimeMillis()-1000));
		result.setEstudiante(estudiante);
		result.setOferta(oferta);
		result.setEstado("PENDIENTE");
		return result;
	}

	public Collection<Incidencia> findIncidenciaByEstudiante() {
		Estudiante estudiante = estudianteService.getLoggedSingle();
		return incidenciaRepository.findIncidenciaByEstudiante(estudiante.getId());
	}

	public Collection<Incidencia> findIncidenciaByOfertaId(int id) {
		// TODO Auto-generated method stub
		return incidenciaRepository.findIncidenciaByOfertaId(id);
	}

}
