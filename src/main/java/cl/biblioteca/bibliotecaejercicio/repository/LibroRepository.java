package cl.biblioteca.bibliotecaejercicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.biblioteca.bibliotecaejercicio.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

    default int totalLibros(){
        return (int) this.count();
    }

    List<Libro> findByAutor(String autor);
}


    
    