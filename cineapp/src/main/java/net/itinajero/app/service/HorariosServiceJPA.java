package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorarioService {
	
	@Autowired
	HorariosRepository horarioRepo;

	@Override
	public List<Horario> buscarPeliculaPorId(int idPelicula, Date fecha) {
		return horarioRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}

	@Override
	public List<Horario> buscarPorFecha(Date fecha) {
		return horarioRepo.findByFecha(fecha);
	}
	
	@Override
	public List<Horario> buscarTodos() {
		return horarioRepo.findAll();
	}

}
