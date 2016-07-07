package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repositories.CalificacionOfertaRepository;
import domain.CalificacionOferta;
import domain.Estudiante;
import domain.Oferta;


@Service
@Transactional
public class CalificacionOfertaService {

	@Autowired
	private CalificacionOfertaRepository calificacionOfertaRepository;
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private EstudianteService estudianteService;

	public CalificacionOfertaService() {
		super();
	}

	public CalificacionOferta create(Integer id) {
		Oferta oferta = ofertaService.findOne(id);
		Estudiante estudiante = estudianteService.getLoggedSingle();
		CalificacionOferta result;
		result = new CalificacionOferta();
		result.setCreationMoment(new Date(System.currentTimeMillis()-1000));
		result.setEstudiante(estudiante);
		result.setOferta(oferta);
		return result;
	}

	public CalificacionOferta save(CalificacionOferta calificacionOferta) {
		CalificacionOferta result;
		result = calificacionOfertaRepository.saveAndFlush(calificacionOferta);
		return result;
	}

	public void delete(CalificacionOferta calificacionOferta) {
		calificacionOfertaRepository.delete(calificacionOferta);
	}

	public Collection<CalificacionOferta> findAll() {
		Collection<CalificacionOferta> result;
		result = calificacionOfertaRepository.findAll();
		return result;
	}

	public CalificacionOferta findOne(Integer id) {
		CalificacionOferta result;
		result = calificacionOfertaRepository.findOne(id);
		return result;
	}

	public Collection<CalificacionOferta> findCalificacionOfertaByOfertaId(int id) {
		// TODO Auto-generated method stub
		return calificacionOfertaRepository.findCalificacionOfertaByOfertaId(id);
	}

	public Collection<CalificacionOferta> findLastCalificacionOferta() {
		
		List<CalificacionOferta> calificacionOfertas = calificacionOfertaRepository.findLastCalificacionOfertaOrderBy();
		List<CalificacionOferta> result = new ArrayList<CalificacionOferta>();
		result.add(calificacionOfertas.get(0));
		result.add(calificacionOfertas.get(1));
		result.add(calificacionOfertas.get(2));
		return result;
	}
	
}
