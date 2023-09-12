package com.utn.jpatp1.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends Base{
    @Column(name = "numero")
    private int numero;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "descuento")
    private double descuento;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "total")
    private int total;
}
