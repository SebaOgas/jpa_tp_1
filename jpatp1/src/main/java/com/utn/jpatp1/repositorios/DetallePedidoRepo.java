package com.utn.jpatp1.repositorios;

import com.utn.jpatp1.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepo extends JpaRepository<DetallePedido, Long> {
}
