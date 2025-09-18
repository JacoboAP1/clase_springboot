package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.repositories.AutorRepository;
import com.breaze.clase_spring.services.IAutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IAutorService {
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }
    @Override
    public List<Autor> obtenerAutores() {
        return this.autorRepository.findAll();
    }
}
