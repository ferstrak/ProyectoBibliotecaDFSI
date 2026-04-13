package cl.biblioteca.bibliotecaejercicio.mapper;

import cl.biblioteca.bibliotecaejercicio.dto.CreateLibroRequest;
import cl.biblioteca.bibliotecaejercicio.dto.UpdateLibroRequest;
import cl.biblioteca.bibliotecaejercicio.model.Libro;

public class LibroMapper {

    public static Libro toModel(CreateLibroRequest request) {
        return new Libro(0, // ID temporal, será asignado por el service/repository
                request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
                request.autor());
    }

    public static Libro toModel(int id, UpdateLibroRequest request) {
        return new Libro(id, // ID del path parameter
                request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
                request.autor());
    }
}
