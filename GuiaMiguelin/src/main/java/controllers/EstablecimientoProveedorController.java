package controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
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

import services.CalificacionOfertaService;
import services.EstablecimientoService;
import services.OfertaService;
import domain.CalificacionOferta;
import domain.Establecimiento;
import domain.Oferta;


@Controller
@RequestMapping("/establecimiento/proveedor")
public class EstablecimientoProveedorController {

	@Autowired
	private EstablecimientoService establecimientoService;
	@Autowired
	private OfertaService ofertaService;
	@Autowired
	private CalificacionOfertaService calificacionOfertaService;
	
	
	
	
	@RequestMapping(value = "/showImage", method = RequestMethod.GET)
	public void showImage(@RequestParam Integer id,HttpServletResponse response)throws IOException {
		
		Establecimiento establecimiento = establecimientoService.findOne(id);
	    
	response.setContentType("image/jpeg");
			
			byte[] imagen=establecimiento.getPhoto();
			
			InputStream in1= new ByteArrayInputStream(imagen);
			IOUtils.copy(in1,response.getOutputStream());
		
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
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;	
		Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoByProveedorId();
		result = new ModelAndView("establecimiento/list");	
		result.addObject("establecimientos", establecimientos);
		result.addObject("requestURI","establecimiento/proveedor/list.do");		
		return result;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		result = new ModelAndView("establecimiento/create");
		Establecimiento establecimiento = establecimientoService.create();
		result.addObject("establecimiento", establecimiento);
	
		result.addObject("requestURI", "establecimiento/proveedor/edit.do");

		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Establecimiento establecimiento, BindingResult binding,@RequestParam("file") MultipartFile file) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(establecimiento);

		} else {
			try {
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
					establecimiento.setPhoto(IOUtils.toByteArray(file.getInputStream()));
				}
				establecimientoService.save(establecimiento);
				Collection<Establecimiento> establecimientos = establecimientoService.findEstablecimientoByProveedorId();
				Collection<CalificacionOferta> calificacionOfertas = calificacionOfertaService.findLastCalificacionOferta();
				result = new ModelAndView("welcome/index");
				result.addObject("establecimientos", establecimientos);
				result.addObject("calificacionOfertas", calificacionOfertas);
			} catch (Throwable oops) {
				result = createEditModelAndView(establecimiento, "establecimiento.commit.error");
			}
		}
		return result;
	}

	protected ModelAndView createEditModelAndView(Establecimiento e) {
		ModelAndView result;

		result = createEditModelAndView(e, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Establecimiento e, String message) {
		ModelAndView result;
		result = new ModelAndView("establecimiento/edit");
		result.addObject("establecimiento", e);
		result.addObject("requestURI", "establecimiento/proveedor/edit.do");
		result.addObject("message", message);
		return result;
	}
	
}
