package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import domain.Establecimiento;
import domain.Incidencia;

import services.EstablecimientoService;
import services.IncidenciaService;


@Controller
@RequestMapping("/incidencia/administrator")
public class IncidenciaAdministratorController {

	
	
	@Autowired
	private IncidenciaService incidenciaService;
	
	@Autowired
	private EstablecimientoService establecimientoService;
	
	//listar todas las incidencias, ordenadas por fecha de actualización
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;	
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciasOrder();
		result = new ModelAndView("incidencia/listAdmin");	
		result.addObject("incidencias", incidencias);
		result.addObject("requestURI","incidencia/administrator/list.do");		
		return result;
	}
	
	@RequestMapping(value = "/listPending",method=RequestMethod.GET)
	public ModelAndView listPending() {
		ModelAndView result;	
		Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
		result = new ModelAndView("incidencia/listPending");	
		result.addObject("incidencias", incidencias);
		result.addObject("requestURI","incidencia/administrator/list.do");		
		return result;
	}
	
	
	@RequestMapping(value = "/resolve", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int id) {
		ModelAndView result;
		Incidencia incidencia = incidenciaService.findOne(id);
		result = new ModelAndView("incidencia/resolve");
		
		result.addObject("incidencia", incidencia);
	
		result.addObject("requestURI", "incidencia/administrator/edit.do");

		return result;
	}
	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Incidencia incidencia, BindingResult binding) {
		ModelAndView result;
 
		incidenciaService.actualizaIncidence(incidencia);
		if (binding.hasErrors()) {
			result = createEditModelAndView(incidencia);

		} else {
			try {
				incidenciaService.actualizaIncidence(incidencia);
				incidenciaService.save(incidencia);
				Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
				Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoNoPublicado();
				result = new ModelAndView("welcome/index");
				
				result.addObject("incidencias", incidencias);
				result.addObject("establecimientos", establecimientos);
			} catch (Throwable oops) {
				result = createEditModelAndView(incidencia, "incidencia.commit.error");
			}
		}
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Incidencia e) {
		ModelAndView result;

		result = createEditModelAndView(e, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Incidencia e, String message) {
		ModelAndView result;
		result = new ModelAndView("incidencia/edit");
		result.addObject("incidencia", e);
		result.addObject("requestURI", "incidencia/administrator/edit.do");
		result.addObject("message", message);
		return result;
	}
	
}
