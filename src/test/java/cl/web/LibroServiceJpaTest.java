package cl.web;

import cl.web.jpa.model.Autor;
import cl.web.jpa.model.Libro;
import cl.web.jpa.repositories.AutorRepository;
import cl.web.jpa.repositories.LibroRepository;
import cl.web.jpa.services.LibroServiceJpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LibroServiceJpaTest {

    @Autowired
    private LibroServiceJpa libroServiceJpa;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testGuardarLibroConNuevoAutor() {
        // Crear autor y libro
        Autor autor = new Autor();
        autor.setNombre("Julio Cortázar");

        Libro libro = new Libro();
        libro.setTitulo("Rayuela");
        libro.setAnioPublicacion(1963);

        // Ejecutar método transaccional
        Libro libroGuardado = libroServiceJpa.guardarLibroConNuevoAutor(autor, libro);

        // Verificar que se guardaron ambos
        Assertions.assertNotNull(libroGuardado.getId());
        Assertions.assertNotNull(libroGuardado.getAutor().getId());
        Assertions.assertEquals("Julio Cortázar", libroGuardado.getAutor().getNombre());
    }

    @Test
    public void testTransaccionConError_Rollback() {
        Autor autor = new Autor();
        autor.setNombre("Autor con error");

        Libro libro = new Libro();
        libro.setTitulo(null); // Provocará IllegalArgumentException (título vacío)
        libro.setAnioPublicacion(2020);

        long autoresAntes = autorRepository.count();
        long librosAntes = libroRepository.count();

        // Ejecutar y esperar excepción
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            libroServiceJpa.guardarLibroConNuevoAutor(autor, libro);
        });

        // Verificar que no se guardó nada (rollback)
        long autoresDespues = autorRepository.count();
        long librosDespues = libroRepository.count();

        Assertions.assertEquals(autoresAntes, autoresDespues);
        Assertions.assertEquals(librosAntes, librosDespues);
    }
}

