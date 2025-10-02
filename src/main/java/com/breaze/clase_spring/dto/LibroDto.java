package com.breaze.clase_spring.dto;

import com.breaze.clase_spring.entities.LibroCategoria;
import lombok.Data;

import java.util.Set;

@Data
public class LibroDto {
    private String titulo;
    private Integer anioPublicacion;
    private Long autorId;

    private String isbn;
    private Integer numPaginas;
    private String idioma;

    private Set<LibroCategoria> categoriasIds;

}
