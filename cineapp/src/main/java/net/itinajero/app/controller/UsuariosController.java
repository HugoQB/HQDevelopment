package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IPerfilesService;
import net.itinajero.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@Autowired
	private IPerfilesService perfilesService;

	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		String passw = "12345";
		String encripted = encoder.encode(passw);
		System.out.println("Password encriptado: " + encripted);
		return "usuarios/demo";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario u) {
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Usuario u, @RequestParam("perfil") String p) {
		System.out.println(u);
		String tempPwd = u.getPwd();
		String encripted = encoder.encode(tempPwd);
		System.out.println(encripted);
		u.setPwd(encripted);
		u.setActivo(1);
		usuariosService.guardar(u);
		
		Perfil per = new Perfil();
		per.setCuenta(u.getCuenta());
		per.setPerfil(p);
		
		perfilesService.guardar(per);
		
		System.out.println(p);
//		usuariosRepo.save(u);
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "usuarios/usuariosList";
	}

}
