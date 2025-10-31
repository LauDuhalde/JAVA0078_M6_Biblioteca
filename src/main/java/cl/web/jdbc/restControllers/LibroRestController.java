package cl.web.jdbc.restControllers;

import cl.web.jdbc.model.Libro;
import cl.web.jdbc.services.LibroServiceJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jdbc/libros")
public class LibroRestController {

    @Autowired
    private LibroServiceJdbc libroService;
    
    // POST /api/jdbc/libros
    @PostMapping
    public String crearLibro(@RequestBody Libro libro) {
        int filas = libroService.insertar(libro);
        return filas > 0 ? "Libro agregado correctamente" : "Error al agregar libro";
    }

    // GET /api/jdbc/libros
    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listar();
    }

    // GET /api/jdbc/libros/anio/{anio}
    @GetMapping("/anio/{anio}")
    public List<Libro> buscarPorAnio(@PathVariable int anio) {
        return libroService.buscarPorAnio(anio);
    }

    // PUT /api/jdbc/libros/{id}
    @PutMapping("/{id}")
    public String actualizarLibro(@PathVariable long id, @RequestBody Libro libro) {
        libro.setId(id);
        int filas = libroService.actualizar(libro);
        return filas > 0 ? "Libro actualizado correctamente" : "Error al actualizar libro";
    }

    // DELETE /api/jdbc/libros/{id}
    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable long id) {
        int filas = libroService.eliminar(id);
        return filas > 0 ? "Libro eliminado correctamente" : "Error al eliminar libro";
    }
}

