package com.breaze.clase_spring.services;

import com.breaze.clase_spring.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    public Libro crearLibro(Libro libro);
    public List<Libro> obtenerLibros();
    public Optional<Libro> actualizarParcialmente(Long id, Libro libro);
}
