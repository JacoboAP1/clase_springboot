package com.breaze.clase_spring.repositories;

import com.breaze.clase_spring.entities.LibroCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroCategoriaRepository extends JpaRepository <LibroCategoria,Long> {
}
