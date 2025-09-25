package com.breaze.clase_spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="detalle_libro")
public class DetalleLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "num_paginas")
    private int numeroPaginas;

    @Column(name = "idioma")
    private String idioma;

    @OneToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
