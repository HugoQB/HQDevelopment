package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetalleService {
	
	@Autowired
	DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle d) {
		detallesRepo.save(d);
	}

	@Override
	public void delete(int id) {
		detallesRepo.deleteById(id);
		
	}

}
