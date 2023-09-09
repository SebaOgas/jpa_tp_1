package com.utn.jpatp1.repositorios;

import com.utn.jpatp1.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepo extends JpaRepository<Factura, Long> {
}
