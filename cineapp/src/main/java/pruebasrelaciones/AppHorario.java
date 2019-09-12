package pruebasrelaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.HorariosRepository;

public class AppHorario {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository horariosRepo = context.getBean("horariosRepository", HorariosRepository.class);
		
		
		
		horariosRepo.findAll().forEach(e->{
			System.out.println(e);
		});

	}

}
