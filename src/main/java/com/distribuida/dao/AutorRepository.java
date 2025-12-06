package com.distribuida.dao;

import com.distribuida.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    // Métodos personalizados de búsqueda
    Autor findByNombre(String nombre);

    Autor findByApellido(String apellido);

    Autor findByNombreAndApellido(String nombre, String apellido);

    Autor findByPais(String pais);

    Autor findByCorreo(String correo);
}