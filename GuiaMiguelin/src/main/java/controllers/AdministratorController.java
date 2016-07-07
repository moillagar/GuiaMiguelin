/* AdministratorController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import services.EstablecimientoService;
import services.IncidenciaService;
import services.OfertaService;
import domain.Administrator;
import domain.Establecimiento;
import domain.Incidencia;
import forms.AdministratorForm;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	// Constructors -----------------------------------------------------------
	
	public AdministratorController() {
		super();
	}
		
	@Autowired
	private AdministratorService administratorService;

	@Autowired
	private EstablecimientoService establecimientoService;

	
	@Autowired
	private IncidenciaService incidenciaService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView result;
		result = new ModelAndView("administrator/edit");
		AdministratorForm administratorForm;
		administratorForm = administratorService.createAdministratorForm();

		result.addObject("requestURI", "administrator/register.do");
		result.addObject("registerForm", administratorForm);

		return result;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@ModelAttribute("registerForm")@Valid AdministratorForm administratorForm,
			BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(administratorForm);
			System.out.println(binding.getAllErrors());
		} else {
			try {
				Administrator administrator;
				administrator = administratorService
						.reconstruct(administratorForm);
				administratorService.register(administrator);
				System.out.println(binding.getAllErrors());

				result = new ModelAndView("welcome/index");
				
				Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
				Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoNoPublicado();
				
				result.addObject("incidencias", incidencias);
				result.addObject("establecimientos", establecimientos);
				
			} catch (DataIntegrityViolationException oops) {
				result = createEditModelAndView(administratorForm,
						"administrator.error.alreadyexists");

			} catch (IllegalArgumentException oops) {
				result = createEditModelAndView(administratorForm,
						"administrator.error.passOrAccepted");

			} catch (Throwable oops) {

				result = createEditModelAndView(administratorForm,
						"administrator.error.operation");
			}

		}
		return result;
	}
	
	
	
	// Ancillary Methods----------------
		protected ModelAndView createEditModelAndView(
				AdministratorForm administratorForm) {
			ModelAndView result;

			result = createEditModelAndView(administratorForm, null);

			return result;
		}

		protected ModelAndView createEditModelAndView(
				AdministratorForm administratorForm, String message) {
			ModelAndView result;
			result = new ModelAndView("administrator/edit");
			administratorForm.setPassword("");
			administratorForm.setRepeatedPassword("");
			result.addObject("registerForm", administratorForm);
			result.addObject("requestURI", "administrator/register.do");
			result.addObject("message", message);
			return result;
		}
}