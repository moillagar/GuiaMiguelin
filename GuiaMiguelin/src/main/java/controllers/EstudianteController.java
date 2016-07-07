package controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import domain.Establecimiento;
import domain.Estudiante;
import domain.Oferta;

import forms.EmailForm;
import forms.EstudianteForm;

import services.EstudianteService;
import services.OfertaService;
import services.PhotoService;
import services.SendEmail;


@Controller
@RequestMapping("/estudiante")
public class EstudianteController extends AbstractController{
	
	public EstudianteController(){
		super();
	}

	@Autowired
	private PhotoService photoService;
	@Autowired
	private SendEmail sendEmail;
	
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private OfertaService ofertaService;
	
	
	@RequestMapping(value = "/showImage", method = RequestMethod.GET)
	public void showImage(@RequestParam Integer id,HttpServletResponse response)throws IOException {
		
		Estudiante estudiante = estudianteService.findOne(id);
	    
	response.setContentType("image/jpeg");
			
			byte[] imagen=estudiante.getPhoto();
			
			InputStream in1= new ByteArrayInputStream(imagen);
			IOUtils.copy(in1,response.getOutputStream());
		
	}
	
	@RequestMapping(value = "/activacionCuentaFallo", method = RequestMethod.GET)
	public ModelAndView activateAccountFailed() {
		ModelAndView result;

		Estudiante estudiante;

		estudiante = estudianteService.getLoggedSingle();
		Assert.notNull(estudiante);

		
		result = new ModelAndView("estudiante/activacionCuentaFallo");

	
		
		return result;
	}
	
	@RequestMapping(value = "/invite", method = RequestMethod.GET)
	public ModelAndView invite() {
		ModelAndView result;

		
		EmailForm iForm;
		iForm=new EmailForm();
		result = createInvitationModelAndView(iForm);
		
		
		return result;
	}

	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	public ModelAndView sendIntation( @Valid EmailForm invitationForm, BindingResult binding) {
		ModelAndView result;
		result = new ModelAndView();
		Estudiante estudiante;
		estudiante = estudianteService.getLoggedSingle();
		if (binding.hasErrors()) {
			result = createInvitationModelAndView(invitationForm);
			
		} else {
			//la siguiente linea hay que modificarla. Aquí habrí aque poner
			//la recomendaciones
			Collection<Oferta> ofertas = ofertaService.findAll();
			
			result = new ModelAndView("welcome/index");
			result.addObject("estudiante", estudiante);
			result.addObject("ofertas", ofertas);
			try {
				
				sendEmail.sendToAFriend(estudiante, invitationForm.getText());

			} catch (Exception e) {

				
				result.addObject("message", "error.operationInvite");
			}
		}
		return result;
	}
	
	
	
	protected ModelAndView createInvitationModelAndView(EmailForm invitationForm) {
		ModelAndView result;

		result = createInvitationModelAndView(invitationForm, null);

		return result;
	}
	
	protected ModelAndView createInvitationModelAndView(EmailForm invitationForm, String message){
		ModelAndView result;
		
		result = new ModelAndView("estudiante/invite");
		
		result.addObject("invitationForm", invitationForm);
		result.addObject("message", message);
		result.addObject("requestURI", "estudiante/invite.do");
		
		return result;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam(required = false, value = "invitationCode") String invitationCode) {
		ModelAndView result;
		result = new ModelAndView("estudiante/edit");
		EstudianteForm estudianteForm;
		estudianteForm = estudianteService.createEstudianteForm();
		if (invitationCode != null) {
			estudianteForm.setInviteCode(invitationCode);

		}
		result.addObject("requestURI", "estudiante/register.do");
		result.addObject("registerForm", estudianteForm);
		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(
			@ModelAttribute("registerForm") @Valid EstudianteForm estudianteForm,
			BindingResult binding,@RequestParam("file") MultipartFile file) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(estudianteForm);
			System.out.println(binding.getAllErrors());

		} else {
			try {
				Estudiante organiser;
				organiser = estudianteService.reconstruct(estudianteForm);
				if (file != null && ! file.isEmpty()) {

					/*Photo avatar;
					avatar = new Photo();
					avatar.setContent(IOUtils.toByteArray(file.getInputStream()));
					avatar.setContentType(file.getContentType());
					avatar.setCreationMoment(new Date(System
							.currentTimeMillis() - 1000));
					avatar.setFilename(file.getOriginalFilename());
					avatar.setLenght(file.getSize());
					establecimiento.setPhoto(avatar);*/
					organiser.setPhoto(IOUtils.toByteArray(file.getInputStream()));
				}
				estudianteService.register(organiser);
				estudianteService.sendToActivate(organiser);
				
				result = new ModelAndView("redirect:../security/login.do");
				result.addObject("redix", true);
			} catch (DataIntegrityViolationException oops) {
				result = createEditModelAndView(estudianteForm,
						"estudiante.error.alreadyexists");
				oops.printStackTrace();
			} catch (IllegalArgumentException oops) {
				result = createEditModelAndView(estudianteForm,
						"estudiante.error.passOrAccepted");
				oops.printStackTrace();
			} catch (Throwable oops) {

				result = createEditModelAndView(estudianteForm,
						"estudiante.error.operation");
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
			Estudiante estudiante;
			estudiante = estudianteService.findSinglesByUserCode(userCode);
			Assert.notNull(estudiante);
			estudiante.setCuentaDesactivada(true);
			estudianteService.save(estudiante);
			result = new ModelAndView("estudiante/activateAccount");
			result.addObject("actived", true);
		} catch (Throwable oops) {
			result = new ModelAndView("estudiante/activateAccount");
			result.addObject("actived", false);
		}

		return result;
	}
	
	
	// Ancillary Methods----------------
		protected ModelAndView createEditModelAndView(EstudianteForm estudianteForm) {
			ModelAndView result;

			result = createEditModelAndView(estudianteForm, null);

			return result;
		}
	
	protected ModelAndView createEditModelAndView(EstudianteForm estudianteForm,String message) {
		ModelAndView result;
		result = new ModelAndView("estudiante/edit");
		estudianteForm.setPassword("");
		
		estudianteForm.setRepeatedPassword("");
		result.addObject("registerForm", estudianteForm);
		result.addObject("requestURI", "estudiante/register.do");
		
		
		return result;
	}
	
	
	protected ModelAndView createIndexView() {
		ModelAndView result;
		Estudiante estudiante;
		estudiante = estudianteService.getLoggedSingle();
		ArrayList<Estudiante> estudiantes;
		estudiantes = new ArrayList<>(estudianteService.findAll());
		estudiantes.remove(estudiante);
		Assert.notNull(estudiante);

		if (estudiante.getCuentaDesactivada()) {
			result = new ModelAndView("welcome/index");
		} else {
			result = new ModelAndView("estudiante/activacionCuentaFallo");
		}
		
		result.addObject("estudiante", estudiante);
		result.addObject("estudiantes", estudiantes);
		//result.addObject("avatar", photoService.getAvatar());
		result.addObject("logged", estudianteService.getLoggedSingle());
		
		return result;
	}
	
}
