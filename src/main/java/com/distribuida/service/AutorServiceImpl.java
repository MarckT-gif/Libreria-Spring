package com.distribuida.service;

import com.distribuida.dao.AutorRepository;
import com.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findOne(int id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor update(int id, Autor autor) {
        Optional<Autor> autor2 = autorRepository.findById(id);

        autor2.orElse(null).setNombre(autor.getNombre());
        autor2.orElse(null).setApellido(autor.getApellido());
        autor2.orElse(null).setPais(autor.getPais());
        autor2.orElse(null).setDireccion(autor.getDireccion());
        autor2.orElse(null).setTelefono(autor.getTelefono());
        autor2.orElse(null).setCorreo(autor.getCorreo());

        return autorRepository.save(autor2.orElse(null));
    }

    @Override
    public void delete(int id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        }
    }
}