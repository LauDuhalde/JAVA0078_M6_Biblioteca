package cl.web.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.web.jdbc.model.Libro;
import cl.web.jdbc.rowmappers.LibroRowMapper;

@Repository
public class LibroDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	// INSERT
    public int insertar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, anio_publicacion) VALUES (?, ?)";
        return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAnioPublicacion());
    }
    
    //SELECT
    public List<Libro> listar() {
    	String sql = "SELECT id, titulo, anio_publicacion FROM libros";
        return jdbcTemplate.query(sql, new LibroRowMapper());
    }
    
    //SELECT
    public List<Libro> buscarPorAnio(int anio) {
    	String sql = "SELECT * FROM libros WHERE anio_publicacion = ?";
        return jdbcTemplate.query(sql, new LibroRowMapper(), anio);
    }
    
    // UPDATE
    public int actualizar(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, anio_publicacion = ? WHERE id = ?";
        return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAnioPublicacion(), libro.getId());
    }
    
    // DELETE
    public int eliminar(long id) {
        String sql = "DELETE FROM libros WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
