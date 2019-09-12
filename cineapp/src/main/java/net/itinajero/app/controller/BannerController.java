package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping(value="banners")
public class BannerController {
	
	@Autowired
	private IBannerService bannerService;
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model m) {
		m.addAttribute("bannersList", bannerService.getBannerList());
		return "banners/listBanners";
	}
	
	@GetMapping(value="/create")
	public String create() {
		return "/banners/formBanner";
	}
	
	@PostMapping(value="/save")
	public String saveBanner(@RequestParam("archivoImagen")MultipartFile mpf, HttpServletRequest sr, Banner b,
			BindingResult br, RedirectAttributes ra) {
		
		if(br.hasErrors()) {
			System.out.println("Hay errores");
			for(ObjectError e: br.getAllErrors())
				System.out.println(e.getDefaultMessage());
			
			return "banners/formBanner";
		}
		
		if(!mpf.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(mpf, sr);
			System.out.println(nombreImagen);
			b.setArchivo(nombreImagen);
		}
		
		bannerService.addBanner(b);
		ra.addFlashAttribute("bannerSaved", "El banner fue guardado con exito");
		return "redirect:/banners/index";
	}
	
	@InitBinder
	public void validateDate(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));	
	}
}
