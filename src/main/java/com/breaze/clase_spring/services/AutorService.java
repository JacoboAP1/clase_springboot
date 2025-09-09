package com.breaze.clase_spring.services;

import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.repositories.AutorRepository;
import com.breaze.clase_spring.servicesignature.AutorServiceSignature;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements AutorServiceSignature {

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    public List<Autor> obtenerAutores() {
        return this.autorRepository.findAll();
    }


}
