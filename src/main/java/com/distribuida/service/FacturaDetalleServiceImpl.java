package com.distribuida.service;

import com.distribuida.model.FacturaDetalle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    // Lista en memoria simulando una "base de datos"
    private List<FacturaDetalle> detalles = new ArrayList<>();

    @Override
    public List<FacturaDetalle> findAll() {
        return detalles;
    }

    @Override
    public Optional<FacturaDetalle> findOne(int id) {
        return detalles.stream()
                .filter(d -> d.getIdFacturaDetalle() == id)
                .findFirst();
    }

    @Override
    public FacturaDetalle save(FacturaDetalle facturaDetalle) {
        detalles.add(facturaDetalle);
        return facturaDetalle;
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle facturaDetalle) {
        Optional<FacturaDetalle> det = findOne(id);

        det.orElse(null).setCantidad(facturaDetalle.getCantidad());
        det.orElse(null).setSubtotal(facturaDetalle.getSubtotal());
        det.orElse(null).setFactura(facturaDetalle.getFactura());
        det.orElse(null).setLibro(facturaDetalle.getLibro());

        return det.orElse(null);
    }

    @Override
    public void delete(int id) {
        detalles.removeIf(d -> d.getIdFacturaDetalle() == id);
    }
}