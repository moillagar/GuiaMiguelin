package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.EstudianteService;
import services.IncidenciaService;
import services.OfertaService;

import domain.CalificacionOferta;
import domain.Estudiante;
import domain.Incidencia;
import domain.Oferta;


@Controller
@RequestMapping("/incidencia/estudiante")
public class IncidenciaEstudianteController {
	
	
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private IncidenciaService incidenciaService;
	@Autowired
	private EstudianteService estudianteService;
	

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciaByEstudiante();
		result = new ModelAndView("incidencia/list");
		result.addObject("incidencias", incidencias);
		result.addObject("requestURI", "incidencia/estudiante/list.do");
		return result;
	}
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam("id") int id) {
		ModelAndView result;
		result = new ModelAndView("incidencia/create");
		Incidencia incidencia = incidenciaService.create(id);
		Oferta oferta = ofertaService.findOne(id);
		//incidencia.setOferta(oferta);
		
		result.addObject("incidencia", incidencia);
		result.addObject("requestURI", "incidencia/estudiante/edit.do");
		return result;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Incidencia incidencia, BindingResult binding) {
		ModelAndView result;
		
		if (binding.hasErrors()) {
			result = createEditModelAndView(incidencia);

		} else {
			try {
				//la siguiente linea hay que modificarla. Aquí habrí aque poner
				//la recomendaciones
				Collection<Oferta> ofertas = ofertaService.findAll();
				Estudiante estudiante = estudianteService.getLoggedSingle();
				incidenciaService.save(incidencia);
				result = new ModelAndView("welcome/index");
				result.addObject("estudiante", estudiante);
				result.addObject("ofertas", ofertas);
			} catch (Throwable oops) {
				result = createEditModelAndView(incidencia, "incidencia.commit.error");
			}
		}
		return result;
	}
	
	

	protected ModelAndView createEditModelAndView(Incidencia incidencia) {
		ModelAndView result;

		result = createEditModelAndView(incidencia, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Incidencia incidencia, String message) {
		ModelAndView result;
		result = new ModelAndView("incidencia/create");
		result.addObject("incidencia", incidencia);
		result.addObject("requestURI", "incidencia/estudiante/edit.do");
		result.addObject("message", message);
		return result;
	}
	


}
