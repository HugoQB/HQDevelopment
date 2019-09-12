package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Perfil;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {

}
