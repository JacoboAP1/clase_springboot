package com.breaze.clase_spring.controllers;

import com.breaze.clase_spring.dto.LibroDto;
import com.breaze.clase_spring.entities.Libro;
import com.breaze.clase_spring.exceptions.AutorNotFoundException;
import com.breaze.clase_spring.services.ILibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    private final ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }
    /**
     * Endpoint para crear un nuevo libro.
     * @param libro El objeto Libro a crear.
     * @return ResponseEntity con el libro creado.
     */
    @PostMapping("/crear")
    public ResponseEntity<Libro> crearLibro(@RequestBody LibroDto libro){
        try {
            return ResponseEntity.ok(this.libroService.crearLibro(libro));
        }
        catch (AutorNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para obtener todos los libros.
     * @return ResponseEntity con la lista de libros.
     */
    @GetMapping("/consultar")
    public ResponseEntity<List<Libro>> obtenerLibros(){
        List<Libro> libros = this.libroService.obtenerLibros();
        return ResponseEntity.ok(this.libroService.obtenerLibros());
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Libro> actualizarParcialmente(@PathVariable Long id,
                                                        @RequestBody Libro libro){
        return null;
    }

}
