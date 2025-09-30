package com.breaze.clase_spring.repositories;

import com.breaze.clase_spring.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
