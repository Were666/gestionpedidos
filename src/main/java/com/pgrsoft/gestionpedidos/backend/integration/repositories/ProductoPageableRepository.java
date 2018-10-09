package com.pgrsoft.gestionpedidos.backend.integration.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

public interface ProductoPageableRepository extends PagingAndSortingRepository<ProductoDTO, Long> {

}
