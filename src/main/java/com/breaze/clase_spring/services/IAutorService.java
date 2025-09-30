package com.breaze.clase_spring.services;

import com.breaze.clase_spring.entities.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    public List<Autor> obtenerAutores();
    public Optional<Autor> obtenerAutorPorId(Long id);
    public Autor crearAutor(Autor autor);
    public Optional<Autor> actualizarAutor(Long id, Autor autor);
    public Optional<Autor> actualizarAutorParcial(Long id, Autor autor);
    public Optional<Autor> eliminarAutor(Long id);
}
