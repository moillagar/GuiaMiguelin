/* CustomerController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Credentials;
import services.ClientesService;

import domain.Clientes;
import domain.Estudiante;
import forms.EmailForm;
import forms.PasswordForm;

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public CustomerController() {
		super();
	}
	
	@Autowired
	private ClientesService clientesService;

	
	
	@RequestMapping(value = "/recuperarPass", method = RequestMethod.GET)
	public ModelAndView invite() {
		ModelAndView result;

		
		PasswordForm pForm;
		pForm=new PasswordForm();
		result = createInvitationModelAndView(pForm);
		
		
		return result;
	}

	@RequestMapping(value = "/recuperarPass", method = RequestMethod.POST)
	public ModelAndView sendIntation( @Valid PasswordForm pForm, @ModelAttribute Credentials credentials,
			BindingResult bindingResult,
			@RequestParam(required = false) boolean showError,
			@RequestParam(required = false) boolean autoLogin) {
		ModelAndView result;
		result = new ModelAndView();
		Clientes clientes;
		if (bindingResult.hasErrors()) {
			result = createInvitationModelAndView(pForm);
			
		} else {
			result = new ModelAndView("welcome/index");
			try {
				
				clientesService.changePassword( pForm);
				result.addObject("index", true);
				result.addObject("credentials", credentials);
				result.addObject("showError", showError);
				result.addObject("autoLogin", autoLogin);
			} catch (Exception e) {

				
				result.addObject("message", "error.changePassword");
			}
		}
		return result;
	}
	
	
	protected ModelAndView createInvitationModelAndView(PasswordForm passwordForm) {
		ModelAndView result;

		result = createInvitationModelAndView(passwordForm, null);
		
		return result;
	}
	
	protected ModelAndView createInvitationModelAndView(PasswordForm passwordForm, String message){
		ModelAndView result;
		
		result = new ModelAndView("customer/recuperarPass");
		result.addObject("passwordForm", passwordForm);
		result.addObject("message", message);
		result.addObject("requestURI", "customer/recuperaPass.do");
		return result;
	}
	
}