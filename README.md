# JAVA0078_M6_Biblioteca

## Descripción del proyecto

**JAVA0078_M6_Biblioteca** es una aplicación desarrollada con **Spring Boot**, diseñada para gestionar el inventario de una biblioteca.  
Permite **registrar, consultar, actualizar y eliminar libros y autores**, aplicando dos enfoques de acceso a datos:  
- **JdbcTemplate**
- **JPA (Java Persistence API)**  

El objetivo es demostrar el uso de ambos mecanismos en un mismo proyecto, junto con la gestión de transacciones para mantener la consistencia de datos.

---

## Tecnologías utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- Spring JDBC (JdbcTemplate)  
- PostgreSQL  
- Maven  
- JUnit 5

---

## Estructura simplificada del proyecto

```
JAVA0078_M6_Biblioteca/
├── src/main/java/cl/web/
│   ├── jdbc/           # Módulo JDBC
│   │   ├── dao/
│   │   ├── model/
│   │   ├── rowmappers/
│   │   ├── restControllers/
│   │   └── services/
│   └── jpa/            # Módulo JPA
│       ├── model/
│       ├── repositories/
│       ├── restControllers/
│       └── services/
│
├── src/test/java/cl/web/
│   └── LibroServiceJpaTest.java
│
├── application.properties
├── pom.xml
├── tabla_libros.sql
├── Request api jdbc.txt
├── Request api jpa.txt
└── README.md
```

---

## Base de datos

### PostgreSQL

Base de datos: `java0078`  
Usuario: `postgres`  
Contraseña: `1234`  

### Tabla JDBC
```sql
CREATE TABLE libros (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    anio_publicacion INT NOT NULL
);
```

Las tablas JPA (`libros_jpa` y `autores`) se generan automáticamente con la propiedad:
```
spring.jpa.hibernate.ddl-auto=update
```

---

## Ejecución del proyecto

1. Clona este repositorio o cópialo a tu entorno de desarrollo.
2. Crea la base de datos PostgreSQL:
   ```sql
   CREATE DATABASE java0078;
   ```
3. Configura las credenciales en `application.properties`.
4. Ejecuta la aplicación desde **Spring Tool Suite (STS)** o con:
   ```bash
   mvn spring-boot:run
   ```
5. La API estará disponible en:  
   👉 [http://localhost:8081](http://localhost:8081)

---

## Endpoints principales

### Módulo JDBC
Base URL: `/api/jdbc/libros`

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| **POST** | `/api/jdbc/libros` | Insertar libro |
| **GET** | `/api/jdbc/libros` | Listar libros |
| **GET** | `/api/jdbc/libros/anio/{anio}` | Buscar libros por año |
| **PUT** | `/api/jdbc/libros/{id}` | Actualizar libro |
| **DELETE** | `/api/jdbc/libros/{id}` | Eliminar libro |

### Módulo JPA
Base URL: `/api/biblioteca`

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| **POST** | `/autores` | Crear autor |
| **PUT** | `/autores` | Actualizar autor |
| **POST** | `/libros` | Crear libro (autor existente) |
| **POST** | `/libros/nuevoAutor` | Crear libro con nuevo autor |
| **GET** | `/libros` | Listar libros |
| **DELETE** | `/libros/{idLibro}` | Eliminar libro |

---

## Pruebas

El archivo `LibroServiceJpaTest.java` valida:

- **Creación transaccional:** Guarda un autor y un libro juntos.  
- **Rollback:** Si ocurre un error (por ejemplo, título vacío), se deshace toda la transacción.

Ejecutar pruebas:
```bash
mvn test
```

---

## Autor

- Laura Duhalde
