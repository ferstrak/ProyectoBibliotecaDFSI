package cl.biblioteca.bibliotecaejercicio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.biblioteca.bibliotecaejercicio.dto.CreateLibroRequest;
import cl.biblioteca.bibliotecaejercicio.dto.UpdateLibroRequest;
import cl.biblioteca.bibliotecaejercicio.exception.ResourceNotFoundException;
import cl.biblioteca.bibliotecaejercicio.mapper.LibroMapper;
import cl.biblioteca.bibliotecaejercicio.model.Libro;
import cl.biblioteca.bibliotecaejercicio.service.LibroService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v3/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros(){
        List<Libro> libros = libroService.getLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id){
        Libro libro = libroService.getLibroId(id);

        if(libro==null){
            throw new ResourceNotFoundException("ID no corresponde a un libro");
        }
        return ResponseEntity.ok(libro);
    }

    @GetMapping("{autor}")
    public List<Libro> buscarLibroAutor(@RequestParam(name="autor", required=false) String autor){
        if (autor != null && !autor.isEmpty()){
            return libroService.getLibroAutor(autor);
        }
        return libroService.getLibros();
    }

    @PostMapping
    public ResponseEntity<Libro> agregaLibro(@Valid @RequestBody CreateLibroRequest request){
        Libro libro2 = libroService.saveLibro(LibroMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(libro2);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id, @Valid @RequestBody UpdateLibroRequest request){
        Libro libroactualizar = libroService.updateLibro(LibroMapper.toModel(id,request));
        return ResponseEntity.ok(libroactualizar);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/totalLibros")
    public ResponseEntity<Integer> totalLibros() {
        int total = libroService.totalLibros();
        return ResponseEntity.ok(total);
    }

    @GetMapping("/findByLibroCustom")
    public Libro findByLibroCustom(@RequestParam String titulo) {
        return libroService.findByLibroCustom(titulo);
    }
    
}
