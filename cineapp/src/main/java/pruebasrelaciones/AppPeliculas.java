package pruebasrelaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.PeliculasRepository;

public class AppPeliculas {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository peliculasRepo = context.getBean("peliculasRepository", PeliculasRepository.class);

		System.out.println(peliculasRepo.findById(1).get().getHorarios().size());
		
		
//		List<Pelicula> list = peliculasRepo.findAll();
//		
//		list.forEach(e->{
//			System.out.println(e);
//		});
		
		context.close();
		
	}

}
