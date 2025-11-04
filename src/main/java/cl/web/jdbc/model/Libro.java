package cl.web.jdbc.model;

public class Libro {
	private Long id;
    private String titulo;
    private int anioPublicacion;
    
    public Libro() {
		super();
	}

	public Libro(String titulo, int anioPublicacion) {
		super();
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
	}

	public Libro(Long id, String titulo, int anioPublicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
}
