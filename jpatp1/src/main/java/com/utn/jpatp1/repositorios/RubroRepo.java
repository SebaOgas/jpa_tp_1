package com.utn.jpatp1.repositorios;

import com.utn.jpatp1.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepo extends JpaRepository<Rubro, Long> {
}
