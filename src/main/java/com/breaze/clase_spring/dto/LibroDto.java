package com.breaze.clase_spring.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibroDto {
    private String titulo;
    private int anioPublicacion;
    private Long autorId;

    private String isbn;
    private int numPaginas;
    private String idioma;

    private List<Long> categoriasIds;

}
