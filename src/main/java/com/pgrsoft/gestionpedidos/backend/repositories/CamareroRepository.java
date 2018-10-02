package com.pgrsoft.gestionpedidos.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.model.Camarero;

@Repository
public interface CamareroRepository extends JpaRepository<Camarero,Long>{

}
