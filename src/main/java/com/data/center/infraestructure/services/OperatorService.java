package com.data.center.infraestructure.services;

import com.data.center.domain.entity.Operator;
import com.data.center.domain.repository.OperatorRepository;
import com.data.center.infraestructure.abstract_services.IOperatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OperatorService implements IOperatorService {

    private final OperatorRepository operatorRepository;

    @Override
    public List<Operator> findAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Optional<Operator> findOperatorById(Long id) {
        return operatorRepository.findById(id);
    }
}
