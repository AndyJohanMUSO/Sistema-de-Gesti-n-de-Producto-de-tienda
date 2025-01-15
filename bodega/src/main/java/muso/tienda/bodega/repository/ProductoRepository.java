package muso.tienda.bodega.repository;

import muso.tienda.bodega.entities.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    //notacion query
    @Query(" SELECT p FROM Producto p WHERE p.precio BETWEEN ?1 AND ?2")//JPQUERY
    List<Producto> findProductoByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    //query methods
    List<Producto> findProductoByPrecioBetween(BigDecimal minPrice, BigDecimal maxPrice);

    //Producto finProductoByMarca(String marca);

    @Query(" SELECT p FROM Producto p WHERE p.marca = ?1")
    Optional<Producto> findByMarca(String marca);

}
