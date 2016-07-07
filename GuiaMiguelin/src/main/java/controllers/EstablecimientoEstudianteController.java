package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.EstablecimientoService;
import services.OfertaService;
import domain.Establecimiento;
import domain.Oferta;

@Controller
@RequestMapping("/establecimiento/estudiante")
public class EstablecimientoEstudianteController {
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	@Autowired
	private OfertaService ofertaService;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;	
		Collection<Establecimiento> establecimientos = establecimientoService.findAll();
		result = new ModelAndView("establecimiento/list");	
		result.addObject("establecimientos", establecimientos);
		result.addObject("requestURI","establecimiento/estudiante/list.do");		
		return result;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(Integer id) {
		ModelAndView result;
		
		Establecimiento establecimiento = establecimientoService.findOne(id);
		Collection<Oferta> ofertas = ofertaService.findOfertaByEstablecimiento(establecimiento);
		result = new ModelAndView("establecimiento/view");
		result.addObject("establecimiento", establecimiento);
		result.addObject("ofertas", ofertas);
		result.addObject("requestURI", "establecimiento/estudiante/view.do");
		return result;
	}

}
