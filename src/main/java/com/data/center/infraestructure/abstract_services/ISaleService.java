package com.data.center.infraestructure.abstract_services;

import com.data.center.domain.entity.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleService {
    List<Sale> findAllSales();
    Optional<Sale> findSaleById(Long id);
}
