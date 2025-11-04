package cl.web.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.web.jpa.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {
	
}
