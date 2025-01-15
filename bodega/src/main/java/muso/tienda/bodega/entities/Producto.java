package muso.tienda.bodega.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name= "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, name = "nombre")
    private String marca;

    @Column( nullable = false, name = "categoria")
    private String categoria;

    @Column( nullable = false, name = "precio")
    private double precio;

}
