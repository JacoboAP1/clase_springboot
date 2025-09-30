package com.breaze.clase_spring.controllers;

import com.breaze.clase_spring.entities.Categoria;
import com.breaze.clase_spring.services.ICategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final ICategoriaService  categoriaService;

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Endpoint para obtener todas las categorias
     * @return ResponseEntity con todas las categorias existentes
     */
    @GetMapping("/consultar_todas")
    public ResponseEntity<List<Categoria>> obtenerCategorias() {
        return ResponseEntity.ok(this.categoriaService.obtenerCategorias());
    }

    /**
     * Endpoint para obtener todas las categorias
     * @return ResponseEntity con todas las categorias existentes
     */
    @GetMapping("/consultar/{id}")
    public ResponseEntity<Categoria> obtenerCategoriasPorId(@PathVariable Long id) {
        return this.categoriaService.obtenerCategoriaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para crear una nueva categoria.
     * @param categoria El objeto Categoria a crear.
     * @return ResponseEntity con la categoria creada.
     */
    @PostMapping("/crear")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.crearCategoria(categoria));
    }

    /**
     * @param id
     * @param categoria
     * @return ResponseEntity con la categoria actualizada al 100%
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id,
                                                         @RequestBody Categoria categoria) {

        return this.categoriaService.actualizarCategoria(id, categoria)
                .map(categoriaEditada ->
                    ResponseEntity.ok().body(categoriaEditada))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * @param id
     * @param categoria
     * @return ResponseEntity con la categoria actualizada parcialmente
     */
    @PatchMapping("/actualizar_parcial/{id}")
    public ResponseEntity<Categoria> actualizarCategoriaParcial(@PathVariable Long id,
                                                                @RequestBody Categoria categoria) {

        return this.categoriaService.actualizarCategoriaParcial(id, categoria)
                .map(categoriaEditada -> ResponseEntity.ok()
                        .body(categoriaEditada))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable Long id) {
        return this.categoriaService.eliminarCategoria(id)
                .map(categoria ->  ResponseEntity.ok().body(categoria))
                .orElse(ResponseEntity.notFound().build());

    }

}
