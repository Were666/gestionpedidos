package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

@Repository
public interface ProductoPageableRepository extends PagingAndSortingRepository<ProductoDTO, Long> {

}
