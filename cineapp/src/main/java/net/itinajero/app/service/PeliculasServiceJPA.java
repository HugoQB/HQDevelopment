package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService{

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int id) {
		Optional<Pelicula> p = peliculasRepo.findById(id);
		if(p!=null)
		return p.get();
		else
			return null;
	}

	@Override
	public void insertarPelicula(Pelicula p) {
		peliculasRepo.save(p);		
	}

	@Override
	public List<String> buscarGeneros() {
		
		List<String> generos = new LinkedList<>();
		generos.add("Acción");
		generos.add("Aventuras");
		generos.add("Clasica");
		generos.add("Comedia romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Acción y Aventura");
		generos.add("Suspenso");
		generos.add("Romantica");
		generos.add("Ciencia Ficción");
		
		return generos;
	}

	@Override
	public void eliminar(int id) {
		peliculasRepo.deleteById(id);
		
	}

}
