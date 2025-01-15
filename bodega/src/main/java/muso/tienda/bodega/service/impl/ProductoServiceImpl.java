package muso.tienda.bodega.service.impl;

import muso.tienda.bodega.entities.Producto;
import muso.tienda.bodega.persistence.ProductoDAO;
import muso.tienda.bodega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productoDAO.findByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Producto> findByMarca(String marca){
        return productoDAO.findByMarca(marca);
    }

}
