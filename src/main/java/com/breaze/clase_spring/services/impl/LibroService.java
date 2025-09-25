package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.entities.Libro;
import com.breaze.clase_spring.repositories.LibroRepository;
import com.breaze.clase_spring.services.ILibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro crearLibro(Libro libro) {
        return this.libroRepository.save(libro);
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
