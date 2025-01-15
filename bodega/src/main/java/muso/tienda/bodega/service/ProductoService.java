package muso.tienda.bodega.service;

import muso.tienda.bodega.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(Long id);

    void save(Producto producto);

    void deleteById(Long id);

    List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    Optional<Producto> findByMarca(String marca);

}
