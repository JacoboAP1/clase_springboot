package com.breaze.clase_spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libro_categoria")
public class LibroCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @ManyToOne
    @JoinColumn(name="libro_id")
    private Libro libro;
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @Column(name = "prioridad")
    private Integer prioridad;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    @Column(name="comentario")
    private String comentario;

}
