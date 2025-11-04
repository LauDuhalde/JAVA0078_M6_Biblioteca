package cl.web.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.web.jpa.model.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long> {
	
}
