package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Horario;

public interface IHorarioService {

	List<Horario> buscarPeliculaPorId(int id, Date fecha);
	
	List<Horario> buscarPorFecha(Date fecha);

	List<Horario> buscarTodos();
	
}
