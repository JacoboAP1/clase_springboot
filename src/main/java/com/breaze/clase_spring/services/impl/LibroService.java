package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.entities.Libro;
import com.breaze.clase_spring.exceptions.AutorNotFoundException;
import com.breaze.clase_spring.repositories.AutorRepository;
import com.breaze.clase_spring.repositories.LibroRepository;
import com.breaze.clase_spring.services.ILibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository,  AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public Libro crearLibro(Libro libro) throws AutorNotFoundException {
        if (autorRepository.findById(libro.getAutor().getId()).isPresent()) {
            return libroRepository.save(libro);
        }
        throw new AutorNotFoundException();
    }

    @Override
    public List<Libro> obtenerLibros() {
        List<Libro> libros = this.libroRepository.findAll();
        return libros;
    }

    @Override
    public Optional<Libro> actualizarParcialmente(Long id, Libro libro) {
        return Optional.empty();
    }
}
