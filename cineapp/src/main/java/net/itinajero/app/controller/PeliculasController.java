package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IDetalleService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("peliculas")
public class PeliculasController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IDetalleService serviceDetalles;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula>lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model m) {
		return "peliculas/formPeliculas";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam("archivoImagen")MultipartFile mpf, HttpServletRequest sr, @ModelAttribute Pelicula p,
			BindingResult br, RedirectAttributes ra) {

		if(br.hasErrors()) {
			System.out.println("Hay errores");
			for(ObjectError e: br.getAllErrors())
				System.out.println(e.getDefaultMessage());
			
			return "/peliculas/formPeliculas";
		}
		
		if(!mpf.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(mpf, sr);
			System.out.println(nombreImagen);
			p.setImagen(nombreImagen);
		}
		System.out.println("Objeto detalle antes: " + p.getDetalle());
		serviceDetalles.insertar(p.getDetalle());
		System.out.println("Objeto detalles despues: " + p.getDetalle());
		
		servicePeliculas.insertarPelicula(p);

		ra.addFlashAttribute("successSave", "El registro fue guardado");
//		return "peliculas/formPeliculas";
		return "redirect:/peliculas/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model m) {
		Pelicula p = servicePeliculas.buscarPorId(id);
		m.addAttribute("pelicula", p);
		return "peliculas/formPeliculas";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes ra) {
		Pelicula p = servicePeliculas.buscarPorId(id);
		servicePeliculas.eliminar(p.getDetalle().getId());
		serviceDetalles.delete(id);
		ra.addFlashAttribute("delMsg", "La pelicula fue eliminada");
		return "redirect:/peliculas/index";
	}
	
	// este metodo estara disponible en todo el controlador con el nombre de attributo generos
	@ModelAttribute("generos")
	public List<String>getGeneros(){
		 return servicePeliculas.buscarGeneros();
	}
	
	@InitBinder
	public void validateDate(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));	
	}
	
}
