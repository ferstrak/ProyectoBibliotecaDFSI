package cl.biblioteca.bibliotecaejercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import cl.biblioteca.bibliotecaejercicio.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

    default int totalLibros(){
        return (int) this.count();
    }

    List<Libro> findByAutor(String autor);

    @Query(value = "SELECT * FROM libros WHERE titulo = :titulo", nativeQuery = true)
    Libro findByLibroCustom(@Param("titulo") String titulo);
    

}


    
    