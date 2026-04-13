package cl.biblioteca.bibliotecaejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.biblioteca.bibliotecaejercicio.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{

    default int totalLibros(){
        return (int) this.count();
    }
    
    // private final List<Libro> listaLibros = new ArrayList<>();

    // public List<Libro> obtenerLibros(){

    //     return listaLibros;
    // }

    // public Libro buscarPorId(int id){

    //     for (Libro libro : listaLibros){
    //         if(libro.getId() == id){

    //             return libro;
    //         }
    //     }
    //     return null;
    // }

    // public Libro guardar(Libro lib){

    //     listaLibros.add(lib);
    //     return lib;
    // }

    // public Libro actualizar(Libro lib){

    //     int id = 0;
    //     int idPosicion = 0;

    //     for (int i = 0; i < listaLibros.size(); i++) {
    //         if(listaLibros.get(1).getId() == lib.getId()){
    //             id = lib.getId();
    //             idPosicion = i;
    //         }
    //     }
        
    //     Libro libro1 = new Libro();
    //     libro1.setId(id);
    //     libro1.setTitulo(lib.getTitulo());
    //     libro1.setAutor(lib.getAutor());
    //     libro1.setFechaPublicacion(lib.getFechaPublicacion());
    //     libro1.setEditorial(lib.getEditorial());
    //     libro1.setIsbn(lib.getIsbn());

    //     listaLibros.set(idPosicion, libro1);
    //     return libro1;


    // }

    // public void eliminar(int id){

    //     Libro libro = buscarPorId(id);
    //     if(libro != null){
    //         listaLibros.remove(libro);
    //     }
    // }

    // public int totalLibros(){

    //     return listaLibros.size();
    // }

    // public Libro buscarPorIsbn(String isbn){

    //     for (Libro libro : listaLibros){
    //         if(libro.getIsbn().equals(isbn)){

    //             return libro;
    //         }
    //     }
    //     return null;
    // }
}