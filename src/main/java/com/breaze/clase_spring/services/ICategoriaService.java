package com.breaze.clase_spring.services;

import com.breaze.clase_spring.entities.Categoria;
import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    public Categoria crearCategoria(Categoria categoria);
    public Optional<Categoria> obtenerCategoriaPorId(Long id);
    public List<Categoria> obtenerCategorias();
    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria);
    public Optional<Categoria> actualizarCategoriaParcial(Long id, Categoria categoria);
}
