package com.breaze.clase_spring.controllers;

import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.repositories.AutorRepository;
import com.breaze.clase_spring.servicesignature.AutorServiceSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorServiceSignature autorServiceSignature;

    public AutorController(AutorServiceSignature autorServiceSignature) {
        this.autorServiceSignature = autorServiceSignature;
    }

    @GetMapping("/obtenerAutores")
    public List<Autor> obtenerAutores() {
        return this.autorServiceSignature.obtenerAutores();
    }

    @PostMapping("/crearAutor")
    public Autor crearAutor(@RequestBody Autor autor) {
        //return this.autorServiceSignature.
        return null;
    }
}
