package muso.tienda.bodega.controller;

import muso.tienda.bodega.controller.dto.ProductoDTO;
import muso.tienda.bodega.entities.Producto;
import muso.tienda.bodega.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Producto> productoOptional = productoService.findById(id);

        if(productoOptional.isPresent()){

            Producto producto = productoOptional.get();

            ProductoDTO productoDTO =  ProductoDTO.builder()
                    .id(producto.getId())
                    .marca( producto.getMarca() )
                    .categoria( producto.getCategoria() )
                    .precio(producto.getPrecio() )
                    .build();
            return ResponseEntity.ok(productoDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/finAll")
   public ResponseEntity<?> findAll(){

        List<ProductoDTO> productoList =  productoService.findAll()
        .stream()
        .map( producto -> ProductoDTO.builder()
        .id(producto.getId() )
        .marca( producto.getMarca() )
        .categoria(producto.getCategoria() )
        .precio(producto.getPrecio()  )
        .build() )
        .toList();
    return ResponseEntity.ok(productoList);
   }

   @PostMapping("/save")
   public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if( productoDTO.getMarca().isBlank() ){
            return ResponseEntity.badRequest().build();
        }

        productoService.save( 
            Producto.builder()
            .marca( productoDTO.getMarca() )
            .categoria(productoDTO.getCategoria())
            .precio(productoDTO.getPrecio())
            .build());
        return ResponseEntity.created(new URI( "api/producto/save" )).build();
   }

   @PutMapping("update/{id}")
   public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        Optional<Producto> productoOptional = productoService.findById(id);

        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            producto.setMarca(productoDTO.getMarca());
            producto.setCategoria(productoDTO.getCategoria());
            producto.setPrecio(productoDTO.getPrecio());
            productoService.save(producto);
            return ResponseEntity.ok("Registro Actualizado");
        } 

        return ResponseEntity.notFound().build();

   }


   @DeleteMapping("delete/{id}")
   public ResponseEntity<?> deteleBy(@PathVariable Long id){

    if( id != null ){
        productoService.deleteById(id);
        return ResponseEntity.ok("Registro eliminado");
    }

    return ResponseEntity.badRequest().build();
   }

   @GetMapping("/find/marca/{marca}")
   public ResponseEntity<?> findByMarca(@PathVariable String marca){

    Optional<Producto> produOptional = productoService.findByMarca(marca);

    if (produOptional.isPresent()) {
        Producto producto = produOptional.get();

        ProductoDTO productoDTO =  ProductoDTO.builder()
                    .id(producto.getId())
                    .marca( producto.getMarca() )
                    .categoria( producto.getCategoria() )
                    .precio(producto.getPrecio() )
                    .build();
            return ResponseEntity.ok(productoDTO);
    }
    return ResponseEntity.notFound().build();
   }


}
