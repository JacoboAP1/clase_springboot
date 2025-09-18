package com.breaze.clase_spring.controllers;


import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.services.IAutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/consultar_todos")
        public ResponseEntity<List<Autor>> obtenerAutores(){
        List<Autor> autores = autorService.obtenerAutores();
        return ResponseEntity.ok(autores);
    }


}
