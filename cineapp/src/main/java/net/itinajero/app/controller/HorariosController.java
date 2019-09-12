package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario h, Model m) {
		
		List<Pelicula>peliculas = servicePeliculas.buscarTodas();
				
		m.addAttribute("peliculas", peliculas);
		
		return "horarios/formHorario";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario h, BindingResult br) {				
		
		if(br.hasErrors()) {
			System.out.println("Hay errores");
			for(ObjectError e: br.getAllErrors())
				System.out.println(e.getDefaultMessage());		
			return "horarios/formHorario";
		}
		System.out.println(h);

		return "redirect:/horarios/create";
	}
	
	@InitBinder
	public void validateDate(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));	
	}
	
}
