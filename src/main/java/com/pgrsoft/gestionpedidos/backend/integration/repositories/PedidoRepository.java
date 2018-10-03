package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDTO, Long>{

}
