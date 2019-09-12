package net.itinajero.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePeliculas;

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute Contacto c, Model m) {
		m.addAttribute("generos", servicePeliculas.buscarGeneros());
		m.addAttribute("notificacionesList", getNotificaciones());
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute Contacto c) {
		System.out.println(c);
		return "redirect:/contacto";
	}
	
	public List<String>getNotificaciones(){
		List<String> tipos =  new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		return tipos;
	}
	
}
