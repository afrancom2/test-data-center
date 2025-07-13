package com.data.center.api.infraestructure.abstract_services;

import com.data.center.api.domain.entity.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleService {
    List<Sale> findAllSales();
    Optional<Sale> findSaleById(Long id);
}
