package muso.tienda.bodega.persistence.impl;

import muso.tienda.bodega.entities.Producto;
import muso.tienda.bodega.persistence.ProductoDAO;
import muso.tienda.bodega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements ProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productoRepository.findProductoByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public Optional<Producto> findByMarca(String marca){
        return productoRepository.findByMarca(marca);
    }
}
