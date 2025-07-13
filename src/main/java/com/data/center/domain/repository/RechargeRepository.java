package com.data.center.domain.repository;

import com.data.center.domain.entity.Operator;
import com.data.center.domain.entity.Recharge;
import com.data.center.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    List<Recharge> findAllBySale(Sale sale);
    List<Recharge> findAllByOperator(Operator operator);
    List<Recharge> findAllByOperatorAndSale(Operator operator, Sale sale);
}
