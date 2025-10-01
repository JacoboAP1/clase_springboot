package com.breaze.clase_spring.services;

import com.breaze.clase_spring.dto.LibroDto;
import com.breaze.clase_spring.entities.Libro;
import com.breaze.clase_spring.exceptions.AutorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    public Libro crearLibro(LibroDto dto) throws AutorNotFoundException;
    public List<Libro> obtenerLibros();
    public Optional<Libro> actualizarParcialmente(Long id, Libro libro);
}
