package cl.web.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.web.jdbc.dao.LibroDAO;
import cl.web.jdbc.model.Libro;

@Service
public class LibroServiceJdbc {
	@Autowired
	private LibroDAO libroDao;
	
	public int insertar(Libro libro) {
        return libroDao.insertar(libro);
    }
    
    public List<Libro> listar() {
        return libroDao.listar();
    }
    
    public List<Libro> buscarPorAnio(int anio) {
    	return libroDao.buscarPorAnio(anio);
    }
    
    public int actualizar(Libro libro) {
        return libroDao.actualizar(libro);
    }
    
    // DELETE
    public int eliminar(long id) {
        return libroDao.eliminar(id);
    }
	
}
