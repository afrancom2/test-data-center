package com.data.center.api.infraestructure.services;

import com.data.center.api.domain.entity.Sale;
import com.data.center.api.domain.repository.SaleRepository;
import com.data.center.api.infraestructure.abstract_services.ISaleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleService implements ISaleService {

    private final SaleRepository saleRepository;

    @Override
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findSaleById(Long id) {
        return saleRepository.findById(id);
    }
}
