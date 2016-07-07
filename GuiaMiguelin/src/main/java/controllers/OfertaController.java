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
import services.IncidenciaService;
import services.OfertaService;
import domain.CalificacionOferta;
import domain.Incidencia;
import domain.Oferta;

@Controller
@RequestMapping("/oferta")
public class OfertaController extends AbstractController{
	
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	@Autowired
	private IncidenciaService incidenciaService;
	
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public ModelAndView listBuscar(@RequestParam String name) {
		ModelAndView result;	
		List<Oferta> its=new ArrayList<Oferta>(ofertaService.findOfertaByKeyword(name));
		result = new ModelAndView("oferta/ajax");
		
		result.addObject("ofertas",its);
		result.addObject("requestURI","oferta/search.do");
	

		return result;
	}
	
	
	@RequestMapping(value = "/view",method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int id) {
		ModelAndView result;	
		Oferta oferta = ofertaService.findOne(id);
		Collection<CalificacionOferta>calificacionOfertas = calificacionOfertaService.findCalificacionOfertaByOfertaId(id);
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciaByOfertaId(id);
		result = new ModelAndView("oferta/view");
		
		result.addObject("oferta",oferta);
		result.addObject("calificacionOfertas",calificacionOfertas);
		result.addObject("incidencias",incidencias);
		result.addObject("requestURI","oferta/view.do");
	

		return result;
	}

}
