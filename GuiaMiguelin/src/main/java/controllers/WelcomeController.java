/* WelcomeController.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
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
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Actor;
import domain.Administrator;
import domain.CalificacionOferta;
import domain.Establecimiento;
import domain.Estudiante;
import domain.Incidencia;
import domain.Oferta;
import domain.Proveedor;
import security.Authority;
import security.Credentials;
import services.ActorService;
import services.AdministratorService;
import services.CalificacionOfertaService;
import services.EstablecimientoService;
import services.EstudianteService;
import services.IncidenciaService;
import services.OfertaService;
import services.ProveedorService;

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends AbstractController {

	

	
	// Constructors -----------------------------------------------------------
	
	public WelcomeController() {
		super();
	}
		
	
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private ProveedorService proveedorService;
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private IncidenciaService incidenciaService;
	@Autowired
	private EstablecimientoService establecimientoService;
	@Autowired
	private ActorService actorService;
	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	@Autowired
	private OfertaService ofertaService;
	// Index ------------------------------------------------------------------		

	

	@RequestMapping(value = "/index")
	public ModelAndView index(@ModelAttribute Credentials credentials,
			BindingResult bindingResult,
			@RequestParam(required = false) boolean showError,
			@RequestParam(required = false) boolean autoLogin) {
		
		Assert.notNull(bindingResult);
		ModelAndView result = new ModelAndView("welcome/index");
		Estudiante estudiante=null;
		Administrator administrator=null;
		Proveedor proveedor=null;	
		
		
		
		
		try{
			estudiante=estudianteService.getLoggedSingle();
			proveedor=proveedorService.getLoggedProveedor();
			administrator=administratorService.getLoggedAdmin();
		}catch(Exception e){
			
		}
		
		
		
		if(estudiante!=null){
			if(estudiante.getCuentaDesactivada()==true){
				//la siguiente linea hay que modificarla. Aquí habrí aque poner
				//la recomendaciones
				Collection<Oferta> ofertas = ofertaService.findAll();
				result = new ModelAndView("welcome/index");
				result.addObject("credentials", credentials);
				result.addObject("showError", showError);
				result.addObject("autoLogin", autoLogin);
				result.addObject("index", true);
				result.addObject("estudiante", estudiante);
				result.addObject("ofertas", ofertas);
			}else{
				result = new ModelAndView("estudiante/activacionCuentaFallo");
			}
			Estudiante logged= estudianteService.getLoggedSingle();
			Assert.notNull(logged);
			
			
		
		}else if(proveedor!=null){
			Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoByProveedorId();
			Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findLastCalificacionOferta();
			result = new ModelAndView("welcome/index");
			
			result.addObject("showError", showError);
			result.addObject("credentials", credentials);
			result.addObject("autoLogin", autoLogin);
			result.addObject("index", true);
			result.addObject("establecimientos", establecimientos);
			result.addObject("calificacionOfertas", calificacionOfertas);
			
		}else
			
			
			if(administrator!=null){
			Collection<Incidencia> incidencias = incidenciaService.findIncidenciasPendientes();
			Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoNoPublicado();
			result = new ModelAndView("welcome/index");
			
			result.addObject("showError", showError);
			result.addObject("autoLogin", autoLogin);
			result.addObject("credentials", credentials);
			result.addObject("index", true);
			result.addObject("incidencias", incidencias);
			result.addObject("establecimientos", establecimientos);
		}else if(estudiante==null && proveedor==null && administrator==null){
			result.addObject("index", true);
			result.addObject("credentials", credentials);
			result.addObject("showError", showError);
			result.addObject("autoLogin", autoLogin);
			result.addObject("index", true);
		}
		return result;
	}
	

	@RequestMapping(value = "/cookies")
	public ModelAndView index1() {
		ModelAndView result;
		
				
		result = new ModelAndView("cookies/view");
		

		return result;
	}

	@RequestMapping("/legal")
	public ModelAndView legal() {
		ModelAndView res;

		res = new ModelAndView("welcome/legalAdvice");

		return res;
	}
		
	
	
	// LoginFailure -----------------------------------------------------------

		@RequestMapping("/loginFailure")
		public ModelAndView failure() {
			ModelAndView result;

			result = new ModelAndView("redirect:index.do?showError=true");
			result.addObject("showError",true);
			return result;
		}
	
}