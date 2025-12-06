package com.distribuida.service;

import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findOne(int id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        Optional<Libro> libro2 = libroRepository.findById(id);

        libro2.orElse(null).setTitulo(libro.getTitulo());
        libro2.orElse(null).setEditorial(libro.getEditorial());
        libro2.orElse(null).setNumPaginas(libro.getNumPaginas());
        libro2.orElse(null).setEdicion(libro.getEdicion());
        libro2.orElse(null).setIdioma(libro.getIdioma());
        libro2.orElse(null).setFechaPublicacion(libro.getFechaPublicacion());
        libro2.orElse(null).setDescripcion(libro.getDescripcion());
        libro2.orElse(null).setTipoPasta(libro.getTipoPasta());
        libro2.orElse(null).setIsbn(libro.getIsbn());
        libro2.orElse(null).setNumEjemplares(libro.getNumEjemplares());
        libro2.orElse(null).setPortada(libro.getPortada());
        libro2.orElse(null).setPresentacion(libro.getPresentacion());
        libro2.orElse(null).setPrecio(libro.getPrecio());
        libro2.orElse(null).setCategoria(libro.getCategoria());
        libro2.orElse(null).setAutor(libro.getAutor());

        return libroRepository.save(libro2.orElse(null));
    }

    @Override
    public void delete(int id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        }
    }
}
