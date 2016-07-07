package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.IncidenciaRepository;

import domain.Administrator;
import domain.CalificacionOferta;
import domain.Estudiante;
import domain.Incidencia;
import domain.Oferta;


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
		Oferta oferta = ofertaService.findOne(id);
		Estudiante estudiante = estudianteService.getLoggedSingle();
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
