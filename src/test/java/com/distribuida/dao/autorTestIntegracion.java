package com.distribuida.dao;

import com.distribuida.model.Autor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class autorTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void findAll() {
        List<Autor> autores = autorRepository.findAll();
        for (Autor item : autores) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Autor> autor = autorRepository.findById(1);
        System.out.println(autor.toString());
    }

    @Test
    public void save() {
        Autor autor = new Autor(0, "Alan1", "Brito1", "Chile1",
                "Av. abajo y a la izquierda2", "099632776", "abrito1@correo.com");
        autorRepository.save(autor);
    }

    @Test
    public void update() {
        Optional<Autor> autor = autorRepository.findById(4);

        autor.orElse(null).setNombre("Gabriel");
        autor.orElse(null).setApellido("Márquez");
        autor.orElse(null).setPais("México");
        autor.orElse(null).setDireccion("Nueva dirección");
        autor.orElse(null).setTelefono("0888888888");
        autor.orElse(null).setCorreo("gabriel@correo.com");

        autorRepository.save(autor.orElse(null));
    }

    @Test
    public void delete() {
        autorRepository.deleteById(1);
    }
}