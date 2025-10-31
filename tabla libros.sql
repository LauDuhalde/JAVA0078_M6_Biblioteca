CREATE TABLE libros (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    anio_publicacion INT NOT NULL
);

INSERT INTO libros (titulo, anio_publicacion) VALUES 
('Cien años de soledad', 1967),
('El señor de los anillos', 1954),
('1984', 1949);
