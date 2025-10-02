package com.breaze.clase_spring.services.impl;

import com.breaze.clase_spring.dto.LibroDto;
import com.breaze.clase_spring.entities.*;
import com.breaze.clase_spring.exceptions.AutorNotFoundException;
import com.breaze.clase_spring.repositories.*;
import com.breaze.clase_spring.services.ILibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService implements ILibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private final DetalleLibroRepository detalleLibroRepository;
    private final LibroCategoriaRepository libroCategoriaRepository;

    public LibroService(LibroRepository libroRepository,
                        AutorRepository autorRepository,
                        CategoriaRepository categoriaRepository,
                        DetalleLibroRepository detalleLibroRepository,
                        LibroCategoriaRepository libroCategoriaRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.detalleLibroRepository = detalleLibroRepository;
        this.libroCategoriaRepository = libroCategoriaRepository;
    }

    public Libro crearLibro(LibroDto dto) throws AutorNotFoundException {
        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new AutorNotFoundException("Autor no encontrado"));

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setAutor(autor);

        libro = libroRepository.save(libro);

        DetalleLibro detalle = new DetalleLibro();
        detalle.setIsbn(dto.getIsbn());
        detalle.setNumeroPaginas(dto.getNumPaginas());
        detalle.setIdioma(dto.getIdioma());
        detalle.setLibro(libro);

        detalleLibroRepository.save(detalle);

        if (dto.getCategoriasIds() != null) {
            for (LibroCategoria categoriaId : dto.getCategoriasIds()) {
                Categoria categoria = categoriaRepository.findById(categoriaId.getId())
                        .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

                LibroCategoria libroCategoria = new LibroCategoria();
                libroCategoria.setLibro(libro);
                libroCategoria.setCategoria(categoria);
                libroCategoriaRepository.save(libroCategoria);
            }
        }

        return libro;
    }

    @Override
    public List<Libro> obtenerLibros() {
        List<Libro> libros = this.libroRepository.findAll();
        return libros;
    }

    @Override
    public Optional<Libro> actualizar(Long id, LibroDto libro) {
        return this.libroRepository.findById(id)
                .map(libroEnc -> {
                    if (libro.getAutorId() != null) {
                        libroEnc.getAutor().setId(libro.getAutorId());
                    }
                    if (libro.getIsbn() != null) {
                        libroEnc.getDetalleLibro().setIsbn(libro.getIsbn());
                    }
                    if (libro.getIdioma() != null) {
                        libroEnc.getDetalleLibro().setIdioma(libro.getIdioma());
                    }
                    if (libro.getTitulo() != null) {
                        libroEnc.setTitulo(libro.getTitulo());
                    }
                    if (libro.getCategoriasIds() != null) {
                        libroEnc.setLibroCategorias(libro.getCategoriasIds());
                    }
                    if (libro.getNumPaginas() != null) {
                        libroEnc.getDetalleLibro().setNumeroPaginas(libro.getNumPaginas());
                    }
                    if (libro.getAnioPublicacion() != null) {
                        libroEnc.setAnioPublicacion(libro.getAnioPublicacion());
                    }
                    return libroRepository.save(libroEnc);
                });
    }

    @Override
    public Optional<Libro> eliminarLibro(Long id) {
        return this.libroRepository.findById(id)
                .map(libro -> {
                    this.libroRepository.delete(libro);
                    return libro;
                });
    }

}
