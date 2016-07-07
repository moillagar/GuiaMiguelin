package controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ProveedorService;
import services.SendEmail;

import domain.Estudiante;
import domain.Proveedor;
import forms.EmailForm;
import forms.EstudianteForm;
import forms.ProveedorForm;


@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired
	private SendEmail sendEmail;
	
	@RequestMapping(value = "/activacionCuentaFallo", method = RequestMethod.GET)
	public ModelAndView activateAccountFailed() {
		ModelAndView result;
		Proveedor proveedor;

		proveedor = proveedorService.getLoggedProveedor();
		Assert.notNull(proveedor);		
		result = new ModelAndView("proveedor/activacionCuentaFallo");		
		return result;
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(required = false, value = "invitationCode") String invitationCode) {
		ModelAndView result;
		result = new ModelAndView("proveedor/edit");
		ProveedorForm proveedorForm;
		proveedorForm = proveedorService.createProveedorForm();
		
		result.addObject("requestURI", "proveedor/register.do");
		result.addObject("registerForm", proveedorForm);
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save( @Valid ProveedorForm proveedorForm,
			BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(proveedorForm);
			System.out.println(binding.getAllErrors());

		} else {
			try {
				Proveedor proveedor;
				proveedor = proveedorService.reconstruct(proveedorForm);
				proveedorService.register(proveedor);
				proveedorService.sendToActivate(proveedor);
				
				result = new ModelAndView("redirect:../security/login.do");
				result.addObject("redix", true);
			} catch (DataIntegrityViolationException oops) {
				result = createEditModelAndView(proveedorForm,
						"proveedor.error.alreadyexists");
				oops.printStackTrace();
			} catch (IllegalArgumentException oops) {
				result = createEditModelAndView(proveedorForm,
						"proveedor.error.passOrAccepted");
				oops.printStackTrace();
			} catch (Throwable oops) {

				result = createEditModelAndView(proveedorForm,
						"proveedor.error.operation");
				oops.printStackTrace();
			}

		}
		result.addObject("register", true);
		return result;
	}

	@RequestMapping(value = "/activateAccount", method = RequestMethod.GET)
	public ModelAndView activateAccount(@RequestParam String userCode) {
		ModelAndView result;

		try {
			Proveedor proveedor;
			proveedor = proveedorService.findProveedorByUserCode(userCode);
			Assert.notNull(proveedor);
			proveedor.setCuentaDesactivada(false);
			proveedorService.save(proveedor);
			result = new ModelAndView("proveedor/activateAccount");
			result.addObject("actived", true);
		} catch (Throwable oops) {
			result = new ModelAndView("estudiante/activateAccount");
			result.addObject("actived", false);
		}

		return result;
	}
	
	
	// Ancillary Methods----------------
		protected ModelAndView createEditModelAndView(ProveedorForm proveedorForm) {
			ModelAndView result;

			result = createEditModelAndView(proveedorForm, null);

			return result;
		}
	
	protected ModelAndView createEditModelAndView(ProveedorForm proveedorForm,String message) {
		ModelAndView result;
		result = new ModelAndView("proveedor/edit");
		proveedorForm.setPassword("");
		
		proveedorForm.setRepeatedPassword("");
		result.addObject("registerForm", proveedorForm);
		result.addObject("requestURI", "proveedor/register.do");
		
		
		return result;
	}
	
	
	protected ModelAndView createIndexView() {
		ModelAndView result;
		Proveedor proveedor;
		proveedor = proveedorService.getLoggedProveedor();
		ArrayList<Proveedor> proveedores;
		proveedores = new ArrayList<>(proveedorService.findAll());
		proveedores.remove(proveedor);
		Assert.notNull(proveedor);

		if (proveedor.getCuentaDesactivada()) {
			result = new ModelAndView("welcome/index");
		} else {
			result = new ModelAndView("proveedor/activacionCuentaFallo");
		}
		
		result.addObject("proveedor", proveedor);
		result.addObject("proveedores", proveedores);
		
		result.addObject("logged", proveedorService.getLoggedProveedor());
		
		return result;
	}
	
	
	
}
