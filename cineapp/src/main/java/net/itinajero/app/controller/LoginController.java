package net.itinajero.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		SecurityContextLogoutHandler logout = new SecurityContextLogoutHandler();
		logout.logout(req, null, null);
		
		return "redirect:/formLogin";
	}
	
	@GetMapping("/index")
	public String mostrarPrincipalAdmin(Authentication a) {
		System.out.println("UserName: " +a.getName());
		
		for(GrantedAuthority g: a.getAuthorities())
			System.out.println("Rol: " +g.getAuthority());
		return "admin";
	}
	
}
