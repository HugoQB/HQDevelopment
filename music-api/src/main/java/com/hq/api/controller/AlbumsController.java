package com.hq.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hq.api.entity.Album;
import com.hq.api.service.IAlbumService;

@RestController
@RequestMapping("/api")
public class AlbumsController {

	@Autowired
	IAlbumService serviceAlbums;
	
	@GetMapping("/albums")
	public List<Album> obtenerTodos() {
		return serviceAlbums.buscarTodos();
	}
	
	@PostMapping("/albums")
	public Album guardar(@RequestBody Album a) {
		serviceAlbums.guardar(a);
		return a;
	}
	
	@PutMapping("/albums")
	public Album modificar(@RequestBody Album a) {
		serviceAlbums.guardar(a);
		return a;
	}
	
	@DeleteMapping("/albums/{id}")
	public String eliminar(@PathVariable("id") int id) {
		serviceAlbums.eliminar(id);
		return "EL album ha sido eliminado";
	}
}
