package com.utn.jpatp1.entidades;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends Base {
    private String calle;

    private String numero;

    private String localidad;
}
