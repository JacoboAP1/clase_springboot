package com.breaze.clase_spring.repositories;

import com.breaze.clase_spring.entities.DetalleLibro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleLibroRepository extends JpaRepository<DetalleLibro,Long> {
}
