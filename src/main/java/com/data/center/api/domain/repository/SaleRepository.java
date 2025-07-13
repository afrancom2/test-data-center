package com.data.center.api.domain.repository;

import com.data.center.api.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
