package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Establecimiento;
import domain.Incidencia;
import domain.Oferta;


import services.EstablecimientoService;
import services.IncidenciaService;
import services.OfertaService;



@Controller
@RequestMapping("/establecimiento/administrator")
public class EstablecimientoAdministratorController {

	@Autowired
	private EstablecimientoService establecimientoService;
	@Autowired
	private OfertaService ofertaService;
	
	@Autowired
	private IncidenciaService incidenciaService;
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;	
		
		Collection<Establecimiento> establecimientos = establecimientoService.findPublicados();
		result = new ModelAndView("establecimiento/list");	
		result.addObject("establecimientos", establecimientos);
		result.addObject("requestURI","establecimiento/administrator/list.do");		
		return result;
	}
	
	
	@RequestMapping(value="/publicar", method = RequestMethod.GET)
	public ModelAndView block(int establecimientoId){
		ModelAndView result;
		Establecimiento establecimiento;
		establecimiento = establecimientoService.findOne(establecimientoId);
		establecimientoService.publicarEstablecimiento(establecimiento);
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
		Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoNoPublicado();
		result = new ModelAndView("welcome/index");
		
		result.addObject("incidencias", incidencias);
		result.addObject("establecimientos", establecimientos);
		
		
		return result;
	}
	
	
	@RequestMapping(value="/bloquear", method = RequestMethod.GET)
	public ModelAndView bloquear(int establecimientoId){
		ModelAndView result;
		Establecimiento establecimiento;
		establecimiento = establecimientoService.findOne(establecimientoId);
		establecimientoService.bloquearEstablecimiento(establecimiento);
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
		Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoNoPublicado();
		result = new ModelAndView("welcome/index");
		
		result.addObject("incidencias", incidencias);
		result.addObject("establecimientos", establecimientos);
		
		
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
		result.addObject("requestURI", "establecimiento/proveedor/view.do");
		return result;
	}
	
	
	
}