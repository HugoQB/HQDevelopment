package pruebasjparepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class App {

	public static void main(String[] args) {
		// La mayoria de ejemplos estan en la carpeta hq>cursos>jpa-hibernate.txt

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			
			NoticiasRepository noticiasRepo = context.getBean("noticiasRepository", NoticiasRepository.class);
			
			try {
				noticiasRepo.findByFechaBetween(sdf.parse("02-08-2019"), sdf.parse("05-08-2019")).forEach(e->{
					System.out.println(e);
				});
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			context.close();
	}

}
