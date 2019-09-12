package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppConexion {
	// La mayoria de ejemplos estan en la carpeta hq>cursos>jpa-hibernate.txt
	public static void main(String[] args) {

		Noticia n = new Noticia();
		n.setTitulo("Proximo estreno: Saw 8");
		n.setDetalle("Sera estrenada en el mes de septiembre");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository noticiasRepo = context.getBean("noticiasRepository", NoticiasRepository.class);

		context.close();

	}

}
