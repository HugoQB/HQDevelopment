package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Horario;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService peliculasService;
	@Autowired
	private IBannerService bannerService;	
	@Autowired
	private IHorarioService horarioService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 

//	@RequestMapping(value="/search", method=RequestMethod.POST)
	@PostMapping(value="/search")
	public String buscar(@RequestParam("fecha")String fecha, Model model) {
		System.out.println("Getting movies in exibition for date: "+fecha);
		
		List<String>listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculasService.buscarTodas());
		
		return "home";
	}
	
//	@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping(value="/home")
	public String goHome(){
		return "home";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping(value="/")
	public String mostrarPrincipal(Model model){
		List<String>listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("fechaBusqueda",sdf.format(new Date()));
		model.addAttribute("peliculas", peliculasService.buscarTodas());
		List<Banner>list = bannerService.getBannerList();
		model.addAttribute("bannerList", list);
		return "home";
	}
	
//	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
//	public String mostrarDetalle( Model model,@PathVariable("id") int id,@PathVariable("fecha") String fecha) {
//	@RequestMapping(value="/detail", method=RequestMethod.GET)
	@GetMapping(value="/detail")
	public String mostrarDetalle( Model model, @RequestParam("id") int id, @RequestParam("fecha") Date fecha) {
		
//		List<Horario> horario = horarioService.buscarTodos();
		List<Horario> horario = horarioService.buscarPeliculaPorId(id, fecha);
//		try {
//			System.out.println("fecha normal " + fecha);
//			String formateada = sdf.format(fecha);
//			System.out.println("formateada " +formateada);
//			Date d = sdf.parse(formateada);
//			System.out.println("fecha parseada " +d);
//			horario = horarioService.buscarPeliculaPorId(id, d);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(horario);	
		model.addAttribute("pelicula", peliculasService.buscarPorId(id));
		model.addAttribute("fecha", sdf.format(fecha));
		model.addAttribute("horario", horario);
		return "detalle";
	}
	
	
	@GetMapping("/formLogin")
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@InitBinder
	public void validateDate(WebDataBinder wdb) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));	
	}
}
