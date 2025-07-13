package com.data.center.infraestructure.services;

import com.data.center.api.models.request.OperatorRequest;
import com.data.center.api.models.request.RechargeRequest;
import com.data.center.api.models.request.SaleRequest;
import com.data.center.api.models.response.RechargeResponse;
import com.data.center.domain.entity.Operator;
import com.data.center.domain.entity.Recharge;
import com.data.center.domain.entity.Sale;
import com.data.center.domain.repository.RechargeRepository;
import com.data.center.infraestructure.abstract_services.IOperatorService;
import com.data.center.infraestructure.abstract_services.IRechargeService;
import com.data.center.infraestructure.abstract_services.ISaleService;
import com.data.center.util.enums.Classes;
import com.data.center.util.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RechargeService implements IRechargeService {

    private final RechargeRepository rechargeRepository;

    private final IOperatorService operatorService;
    private final ISaleService saleService;

    @Override
    public RechargeResponse recharge(RechargeRequest rechargeRequest) {
        Operator operator = operatorService.findOperatorById(rechargeRequest.getOperatorId())
                .orElseThrow(() -> new NotFoundException(Classes.OPERATOR.name(), rechargeRequest.getOperatorId().toString()));
        Sale sale = saleService.findSaleById(rechargeRequest.getSaleId())
                .orElseThrow(() -> new NotFoundException(Classes.SALE.name(), rechargeRequest.getSaleId().toString()));

        Recharge recharge = rechargeRepository.save(
                Recharge.builder()
                        .dateTime(LocalDateTime.now())
                        .operator(operator)
                        .sale(sale)
                        .amount(rechargeRequest.getAmount())
                        .build());

        return RechargeResponse.builder()
                .date(recharge.getDateTime())
                .amount(recharge.getAmount())
                .build();
    }

    @Override
    public List<Recharge> getAllRechargesBySale(SaleRequest saleRequest) {
        Sale sale = saleService.findSaleById(saleRequest.getSaleId()).orElseThrow(
                () -> new NotFoundException(Classes.SALE.name(), saleRequest.getSaleId().toString()));
        return rechargeRepository.findAllBySale(sale);
    }

    @Override
    public List<Recharge> getAllRechargesByOperator(OperatorRequest operatorRequest) {
        Operator operator = operatorService.findOperatorById(operatorRequest.getOperatorId()).orElseThrow(
                () -> new NotFoundException(Classes.OPERATOR.name(), operatorRequest.getOperatorId().toString()));
        return rechargeRepository.findAllByOperator(operator);
    }

    @Override
    public List<Recharge> getAllRechargesByOperatorAndSale(OperatorRequest operatorRequest, SaleRequest saleRequest) {
        Operator operator = operatorService.findOperatorById(operatorRequest.getOperatorId())
                .orElseThrow(() -> new NotFoundException(Classes.OPERATOR.name(), operatorRequest.getOperatorId().toString()));
        Sale sale = saleService.findSaleById(saleRequest.getSaleId())
                .orElseThrow(() -> new NotFoundException(Classes.SALE.name(), saleRequest.getSaleId().toString()));
        List<Recharge> recharges = rechargeRepository.findAllByOperatorAndSale(operator, sale);
        if (recharges.isEmpty()) {
            throw new NotFoundException(Classes.RECHARGE.name(), saleRequest.getSaleId().toString(), operatorRequest.getOperatorId().toString());
        }
        return recharges;
    }

    @Override
    public List<Recharge> getAllRecharges() {
        List<Recharge> recharges = rechargeRepository.findAll();
        return Optional.of(recharges)
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new NotFoundException(Classes.RECHARGE.name()));
    }
}
