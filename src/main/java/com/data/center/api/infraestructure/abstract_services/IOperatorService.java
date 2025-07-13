package com.data.center.api.infraestructure.abstract_services;

import com.data.center.api.domain.entity.Operator;

import java.util.List;
import java.util.Optional;

public interface IOperatorService {
    List<Operator> findAllOperators();
    Optional<Operator> findOperatorById(Long id);
}
