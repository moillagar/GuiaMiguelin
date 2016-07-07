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
import services.EstablecimientoService;
import services.OfertaService;
import services.ProveedorService;
import domain.CalificacionOferta;
import domain.Establecimiento;
import domain.Oferta;
import domain.Proveedor;

@Controller
@RequestMapping("/oferta/proveedor")
public class OfertaProveedorController extends AbstractController{
	
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;	
		Collection<Oferta> ofertas = ofertaService.findAll();
		result = new ModelAndView("oferta/list");	
		result.addObject("ofertas", ofertas);
		result.addObject("requestURI","oferta/proveedor/list.do");		
		return result;
	}
	
	
	@RequestMapping(value = "/view",method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int id) {
		ModelAndView result;
		Oferta  oferta = ofertaService.findOne(id);
		Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findCalificacionOfertaByOfertaId(id);
		
		result = new ModelAndView("oferta/view");	
		result.addObject("oferta", oferta);
		result.addObject("calificacionOfertas", calificacionOfertas);
		result.addObject("requestURI","oferta/proveedor/view.do");		
		return result;
	}
	
	
	@RequestMapping(value = "/listEstablecimientoId",method=RequestMethod.GET)
	public ModelAndView listEstablecimientoId(@RequestParam int id) {
		ModelAndView result;	
		Collection<Oferta> ofertas = ofertaService.findOfertaByEstablecimientoId(id);
		result = new ModelAndView("oferta/list");	
		result.addObject("ofertas", ofertas);
		result.addObject("requestURI","oferta/proveedor/listEstablecimientoId.do");		
		return result;
	}
	
	//crear
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam("id") int id) {
		ModelAndView result;
		result = new ModelAndView("oferta/create");
		Oferta oferta = ofertaService.create(id);
		result.addObject("oferta", oferta);
		result.addObject("requestURI", "oferta/proveedor/edit.do");
		return result;
	}
	
	
	// edicion -----------------------------------------
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView edit(@RequestParam("id") int id) {
			ModelAndView result;
			result = new ModelAndView("oferta/edit");
			result.addObject("oferta", ofertaService.findOne(id));
			result.addObject("requestURI", "oferta/proveedor/edit.do");

			return result;
		}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Oferta oferta, BindingResult binding) {
		ModelAndView result;
		Integer id = oferta.getEstablecimiento().getId();
		if (binding.hasErrors()) {
			result = createEditModelAndView(oferta);

		} else {
			try {
				ofertaService.save(oferta);
				Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoByProveedorId();
				Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findLastCalificacionOferta();
				result = new ModelAndView("welcome/index");
				result.addObject("establecimientos", establecimientos);
				result.addObject("calificacionOfertas", calificacionOfertas);
			} catch (Throwable oops) {
				result = createEditModelAndView(oferta, "oferta.commit.error");
			}
		}
		return result;
	}
	
	

	protected ModelAndView createEditModelAndView(Oferta e) {
		ModelAndView result;

		result = createEditModelAndView(e, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Oferta e, String message) {
		ModelAndView result;
		result = new ModelAndView("oferta/edit");
		result.addObject("oferta", e);
		result.addObject("requestURI", "oferta/proveedor/edit.do");
		result.addObject("message", message);
		return result;
	}

}
