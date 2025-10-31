package cl.web.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.web.jdbc.model.Libro;

public class LibroRowMapper implements RowMapper<Libro> {
    @Override
    public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Libro libro = new Libro();
        libro.setId(rs.getLong("id"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAnioPublicacion(rs.getInt("anio_publicacion"));
        return libro;
    }
}