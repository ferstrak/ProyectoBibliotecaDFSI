package cl.biblioteca.bibliotecaejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.biblioteca.bibliotecaejercicio.model.Libro;
import cl.biblioteca.bibliotecaejercicio.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.findById(id).orElse(null);
    }

    public List<Libro> getLibroAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.deleteById(id);
        return "Libro eliminado";
    }

    public int totalLibros() {
        return (int) libroRepository.count();
    }

    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }
}
