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

import services.CalificacionOfertaService;
import services.EstudianteService;
import services.OfertaService;

import domain.CalificacionOferta;
import domain.Estudiante;
import domain.Incidencia;
import domain.Oferta;

@Controller
@RequestMapping("/calificacionOferta/estudiante")
public class CalificacionOfertaEstudianteController {

	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private EstudianteService estudianteService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int id) {
		ModelAndView result;
		Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findCalificacionOfertaByOfertaId(id);
		result = new ModelAndView("calificacionOferta/list");
		result.addObject("calificacionOfertas", calificacionOfertas);
		result.addObject("requestURI", "calificacionOferta/estudiante/list.do");
		return result;
	}
	
	
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam("id") int id) {
		ModelAndView result;
		result = new ModelAndView("calificacionOferta/edit");
		CalificacionOferta calificacionOferta = calificacionOfertaService.create(id);
		Oferta oferta = ofertaService.findOne(id);
		calificacionOferta.setOferta(oferta);
		
		result.addObject("calificacionOferta", calificacionOferta);
		result.addObject("requestURI", "calificacionOferta/estudiante/edit.do");
		return result;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid CalificacionOferta calificacionOferta, BindingResult binding) {
		ModelAndView result;
		
		if (binding.hasErrors()) {
			result = createEditModelAndView(calificacionOferta);

		} else {
			try {
				//la siguiente linea hay que modificarla. Aquí habrí aque poner
				//la recomendaciones
				Collection<Oferta> ofertas = ofertaService.findAll();
				Estudiante estudiante = estudianteService.getLoggedSingle();
				calificacionOfertaService.save(calificacionOferta);
				result = new ModelAndView("welcome/index");
				result.addObject("estudiante", estudiante);
				result.addObject("ofertas", ofertas);
			} catch (Throwable oops) {
				result = createEditModelAndView(calificacionOferta, "calificacionOferta.commit.error");
			}
		}
		return result;
	}
	
	

	protected ModelAndView createEditModelAndView(CalificacionOferta calificacionOferta) {
		ModelAndView result;

		result = createEditModelAndView(calificacionOferta, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(CalificacionOferta calificacionOferta, String message) {
		ModelAndView result;
		result = new ModelAndView("calificacionOferta/edit");
		result.addObject("calificacionOferta", calificacionOferta);
		result.addObject("requestURI", "calificacionOferta/estudiante/edit.do");
		result.addObject("message", message);
		return result;
	}
	

}
