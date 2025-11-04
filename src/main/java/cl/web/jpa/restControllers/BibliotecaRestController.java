package cl.web.jpa.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.web.jpa.model.Autor;
import cl.web.jpa.model.Libro;
import cl.web.jpa.services.LibroServiceJpa;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaRestController {

    @Autowired
    private LibroServiceJpa libroServiceJpa;

    // AUTORES
    
    // Guardar un nuevo autor
    @PostMapping("/autores")
    public Autor crearAutor(@RequestBody Autor autor) {
        return libroServiceJpa.guardarAutor(autor);
    }

    // Actualizar un autor
    @PutMapping("/autores")
    public Autor actualizarAutor(@RequestBody Autor autor) {
        return libroServiceJpa.actualizarAutor(autor);
    }
    
    //Listar autores
    @GetMapping("/autores")
    public List<Autor> listarAutores() {
        return libroServiceJpa.listarAutores();
    }

    // LIBROS

    // Guardar un libro con autor (ya asociado en el body)
    @PostMapping("/libros")
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroServiceJpa.guardarLibro(libro);
    }

    // Guardar un libro junto con un nuevo autor
    @PostMapping("/libros/nuevoAutor")
    public Libro crearLibroConNuevoAutor(
            @RequestBody Libro libro) {

        if (libro.getAutor() == null) {
        	throw new IllegalArgumentException("Request debe traer el autor");
        }

        return libroServiceJpa.guardarLibroConNuevoAutor(libro.getAutor(), libro);
        
    }

    // Consultar todos los libros con sus autores
    @GetMapping("/libros")
    public List<Libro> listarLibros() {
        return libroServiceJpa.listarLibros();
    }

    // Eliminar un libro
    @DeleteMapping("/libros/{idLibro}")
    public String eliminarLibro(@PathVariable Long idLibro) {
        libroServiceJpa.eliminarLibro(idLibro);
        
        //Se asume que si no se genera excepción, la eliminación fue correcta.
        return "Libro eliminado correctamente";
    }
}
