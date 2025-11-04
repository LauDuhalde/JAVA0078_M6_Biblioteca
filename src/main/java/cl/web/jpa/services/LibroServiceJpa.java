package cl.web.jpa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import cl.web.jpa.model.Autor;
import cl.web.jpa.model.Libro;
import cl.web.jpa.repositories.AutorRepository;
import cl.web.jpa.repositories.LibroRepository;

@Service
public class LibroServiceJpa {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    // Guardar nuevo autor
    public Autor guardarAutor(Autor autor) {
        if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío");
        }
        return autorRepository.save(autor);
    }

    // Guardar nuevo libro
    public Libro guardarLibro(Libro libro) {
        if (libro.getTitulo() == null || libro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede estar vacío");
        }
        return libroRepository.save(libro);
    }

    @Transactional
    // Guardar un libro junto con un nuevo autor
    public Libro guardarLibroConNuevoAutor(Autor autor, Libro libro) {
        Autor autorGuardado = guardarAutor(autor);
        libro.setAutor(autorGuardado);
        return guardarLibro(libro);
    }

    // Consultar todos los libros con sus autores
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // Eliminar libro por ID
    public void eliminarLibro(Long idLibro) {
        if (!libroRepository.existsById(idLibro)) {
            throw new IllegalArgumentException("No existe un libro con ID " + idLibro);
        }
        libroRepository.deleteById(idLibro);
    }

    // Actualizar un autor completo
    public Autor actualizarAutor(Autor autor) {
        if (!autorRepository.existsById(autor.getId())) {
            throw new IllegalArgumentException("No existe el autor con ID " + autor.getId());
        }
        return autorRepository.save(autor);
    }
}
