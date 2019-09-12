package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer>{

	// select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	// select * from Noticias where fecha = ?
	List<Noticia> findByFecha(String fecha);
	
	// select * from noticias where estatus =? and fecha = ? 
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	// select * from noticias where estatus =? or fecha = ? 
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
	// select fecha from noticias where between ? and ?
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	
	// select id from noticias where between ? and ?
		List<Noticia> findByIdBetween(int id1, int id2);
	
}
