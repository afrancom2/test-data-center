package com.data.center.api.domain.repository;

import com.data.center.api.domain.entity.Recharge;
import com.data.center.api.domain.entity.Sale;
import com.data.center.api.domain.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    List<Recharge> findAllBySale(Sale sale);
    List<Recharge> findAllByOperator(Operator operator);
    List<Recharge> findAllByOperatorAndSale(Operator operator, Sale sale);
}
