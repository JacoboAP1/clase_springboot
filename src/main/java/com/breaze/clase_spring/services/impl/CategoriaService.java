package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.entities.Categoria;
import com.breaze.clase_spring.repositories.CategoriaRepository;
import com.breaze.clase_spring.services.ICategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return this.categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria) {
        return this.categoriaRepository.findById(id)
                .map(categoriaEncontrada ->{
                    categoriaEncontrada.setNombre(categoria.getNombre());
                    return this.categoriaRepository.save(categoriaEncontrada);
                });
    }

    @Override
    public Optional<Categoria> actualizarCategoriaParcial(Long id, Categoria categoria) {
        return this.categoriaRepository.findById(id)
                .map(categoriaEncontrada -> {
                    if (categoria.getNombre() != null){
                        categoriaEncontrada.setNombre(categoria.getNombre());
                    }
                    return this.categoriaRepository.save(categoriaEncontrada);
                });
    }
}
