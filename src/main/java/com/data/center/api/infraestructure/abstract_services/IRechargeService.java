package com.data.center.api.infraestructure.abstract_services;

import com.data.center.api.models.request.OperatorRequest;
import com.data.center.api.models.request.RechargeRequest;
import com.data.center.api.models.request.SaleRequest;
import com.data.center.api.models.response.RechargeResponse;
import com.data.center.api.domain.entity.Recharge;

import java.util.List;

public interface IRechargeService {
    RechargeResponse recharge(RechargeRequest rechargeRequest);
    List<Recharge> getAllRechargesBySale(SaleRequest saleRequest);
    List<Recharge> getAllRechargesByOperator(OperatorRequest operatorRequest);
    List<Recharge> getAllRechargesByOperatorAndSale(OperatorRequest operatorRequest, SaleRequest saleRequest);
    List<Recharge> getAllRecharges();
}
