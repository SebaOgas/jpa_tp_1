package com.utn.jpatp1.repositorios;

import com.utn.jpatp1.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepo extends JpaRepository<Domicilio, Long> {
}
