package com.data.center.api.domain.repository;

import com.data.center.api.domain.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {
}
