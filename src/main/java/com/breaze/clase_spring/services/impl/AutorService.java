package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.entities.Autor;
import com.breaze.clase_spring.repositories.AutorRepository;
import com.breaze.clase_spring.services.IAutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Autor> obtenerAutorPorId(Long id) {
         return this.autorRepository.findById(id);
    }
    @Override
    public Autor crearAutor(Autor autor){
        return this.autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> actualizarAutor(Long id, Autor autor) {
        return this.autorRepository.findById(id).map(autorEncontrado -> {
            autorEncontrado.setNombre(autor.getNombre());
            autorEncontrado.setNacionalidad(autor.getNacionalidad());
            return autorRepository.save(autorEncontrado);
        } );
    }

    @Override
    public Optional<Autor> actualizarAutorParcial(Long id, Autor autor) {
        return this.autorRepository.findById(id)
                .map(autorEncontrado -> {
                    if(autor.getNombre() != null){
                        autorEncontrado.setNombre(autor.getNombre());
                    }
                    if(autor.getNacionalidad() != null){
                        autorEncontrado.setNacionalidad(autor.getNacionalidad());
                    }
                    return autorRepository.save(autorEncontrado);
                });
    }

}
