package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CalificacionOfertaService;
import services.EstablecimientoService;
import services.OfertaService;
import domain.CalificacionOferta;
import domain.Establecimiento;
import domain.Oferta;

@Controller
@RequestMapping("/oferta/estudiante")
public class OfertaEstudianteController extends AbstractController{
	
	@Autowired
	private EstablecimientoService establecimientoService;
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;	
		Collection<Oferta> ofertas = ofertaService.findAll();
		result = new ModelAndView("oferta/list");	
		result.addObject("ofertas", ofertas);
		result.addObject("requestURI","oferta/estudiante/list.do");		
		return result;
	}
	
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(Integer id) {
		ModelAndView result;
		
		Oferta oferta = ofertaService.findOne(id);
		Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findCalificacionOfertaByOfertaId(oferta.getId());
		result = new ModelAndView("oferta/view");
		result.addObject("oferta", oferta);
		result.addObject("calificacionOfertas", calificacionOfertas);
		result.addObject("id", id);
		result.addObject("requestURI", "oferta/estudiante/view.do");
		return result;
	}
	
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public ModelAndView listBuscar(@RequestParam String name) {
		ModelAndView result;	
		List<Oferta> its=new ArrayList<Oferta>(ofertaService.findOfertaByKeyword(name));
		result = new ModelAndView("oferta/ajax");
		
		result.addObject("ofertas",its);
		result.addObject("requestURI","oferta/search.do");
	

		return result;
	}

}
