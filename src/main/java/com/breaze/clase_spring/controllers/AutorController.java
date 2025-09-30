package com.breaze.clase_spring.controllers;


import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.services.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    /**
     * Endpoint para obtener todos los autores.
     * @return ResponseEntity con la lista de autores.
     */
    @GetMapping("/consultar_todos")
        public ResponseEntity<List<Autor>> obtenerAutores(){
        List<Autor> autores = autorService.obtenerAutores();
        return ResponseEntity.ok(autores);
    }

    /**
     * Endpoint para consultar un autor por su ID.
     * @param id El ID del autor a consultar.
     * @return ResponseEntity con el autor si se encuentra, o un estado 404 si no se encuentra.
     */
    @GetMapping("/consultar/{id}")
    public ResponseEntity<Autor> consultarPorId(@PathVariable Long id){
        return this.autorService.obtenerAutorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    /**
     * Endpoint para crear un nuevo autor.
     * @param autor El objeto Autor a crear.
     * @return ResponseEntity con el autor creado.
     */
    @PostMapping("/crear")
    public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor){
        return ResponseEntity.ok(this.autorService.crearAutor(autor));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Long id,
                                                 @RequestBody Autor autor){
        return this.autorService.actualizarAutor(id, autor)
                .map( autorEditado -> ResponseEntity.ok()
                        .body(autorEditado))
                .orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/actualizar_parcial/{id}")
    public ResponseEntity<Autor> actualizarAutorParcial(@PathVariable Long id,
                                                 @RequestBody Autor autor){
        return this.autorService.actualizarAutorParcial(id, autor)
                .map( autorEditado -> ResponseEntity.ok()
                        .body(autorEditado))
                .orElse(ResponseEntity.notFound().build());
    }

}
