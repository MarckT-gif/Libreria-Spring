package com.distribuida.dao;

import com.distribuida.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Métodos personalizados de búsqueda
    Categoria findByCategoria(String categoria);

    Categoria findByDescripcion(String descripcion);

    Categoria findByCategoriaAndDescripcion(String categoria, String descripcion);
}
