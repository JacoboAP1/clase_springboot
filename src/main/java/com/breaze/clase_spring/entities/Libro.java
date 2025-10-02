package com.breaze.clase_spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "libro",  cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<LibroCategoria> libroCategorias;

    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL,  orphanRemoval = true)
    private DetalleLibro detalleLibro;

}
