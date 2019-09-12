package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

public class AppDetalles {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		DetallesRepository detallesRepo = context.getBean("detallesRepository", DetallesRepository.class);
		
//		Detalle d = new Detalle();
//		
//		d.setActores("Matt damon, Jack Reacher");
//		d.setDirectores("Steven Spilberg");
//		d.setSinopsis("Aventura y diversion");
//		
//		Detalle d1 = new Detalle();
//		
//		d1.setActores("Brad Pitt, Hugh Jackman");
//		d1.setDirectores("James Cameron");
//		d1.setSinopsis("Acción");
//		
//		detallesRepo.save(d);
//		detallesRepo.save(d1);
		
		List<Detalle> list = detallesRepo.findAll();
		
		list.forEach(e->{
			System.out.println(e);
		});
		
		context.close();

	}

}
