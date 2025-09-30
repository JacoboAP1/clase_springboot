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
}
