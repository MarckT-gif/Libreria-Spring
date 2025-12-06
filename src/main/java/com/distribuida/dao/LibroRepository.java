package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // Buscar por título
    Libro findByTitulo(String titulo);


    List<Libro> findByTituloContaining(String palabra);

    // Buscar por editorial
    List<Libro> findByEditorial(String editorial);

    // Buscar por idioma
    List<Libro> findByIdioma(String idioma);


    // Buscar por precios
    List<Libro> findByPrecioBetween(double min, double max);

    // Buscar por categoría (ManyToOne)
    List<Libro> findByCategoria(Categoria categoria);

    // Buscar por autor (ManyToOne)
    List<Libro> findByAutor(Autor autor);

    // Buscar por fecha exacta de publicación
    List<Libro> findByFechaPublicacion(Date fecha);

    // Buscar por rango de fechas de publicación
    List<Libro> findByFechaPublicacionBetween(Date inicio, Date fin);
}
