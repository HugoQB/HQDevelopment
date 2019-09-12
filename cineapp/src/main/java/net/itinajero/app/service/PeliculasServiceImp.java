package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

//@Service
public class PeliculasServiceImp implements IPeliculasService {
	
	private List<Pelicula>peliculas = null;
	
	public PeliculasServiceImp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			peliculas = new LinkedList<>();
			Pelicula p1 = new Pelicula();
			p1.setId(1);
			p1.setTitulo("Power Rangers");
			p1.setDuracion(120);
			p1.setClasificacion("B");
			p1.setGenero("Aventura");
			p1.setFechaEstreno(sdf.parse("02-05-2017"));
			p1.setImagen("powerrangers.png");
			
			Pelicula p2 = new Pelicula();
			p2.setId(2);
			p2.setTitulo("La Bella y la Bestia");
			p2.setDuracion(132);
			p2.setClasificacion("A");
			p2.setGenero("Infantil");
			p2.setFechaEstreno(sdf.parse("20-05-2017"));
			p2.setImagen("bella_y_la_bestia.png");
			p2.setEstatus("Inactiva");
			
			Pelicula p3 = new Pelicula();
			p3.setId(3);
			p3.setTitulo("Contra Tiempo");
			p3.setDuracion(106);
			p3.setClasificacion("B");
			p3.setGenero("Thriller");
			p3.setFechaEstreno(sdf.parse("28-05-2017"));
			p3.setImagen("contratiempo.png");
			
			
			Pelicula p4 = new Pelicula();
			p4.setId(4);
			p4.setTitulo("En este rincon del mundo");
			p4.setDuracion(120);
			p4.setClasificacion("A");
			p4.setGenero("Thriller");
			p4.setFechaEstreno(sdf.parse("22-07-2017"));
			p4.setImagen("estreno1.png");
			p4.setEstatus("Inactiva");
			
			peliculas.add(p1);
			peliculas.add(p2);
			peliculas.add(p3);
			peliculas.add(p4);
		}catch(Exception e) {
			System.out.println("Something went wrong" + e.getMessage());
		}
	}	
	
	@Override
	public List<Pelicula> buscarTodas() {
		return peliculas;
	}

	@Override
	public Pelicula buscarPorId(int id) {
		for(Pelicula p: peliculas) {
			if(p.getId()==id) 
				return p;
		}
		return null;
	}

	@Override
	public void insertarPelicula(Pelicula p) {
		peliculas.add(p);
		
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
		// TODO Auto-generated method stub
		
	}

}
