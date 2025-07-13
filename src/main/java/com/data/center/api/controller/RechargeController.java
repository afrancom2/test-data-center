package com.data.center.api.controller;

import com.data.center.api.models.request.OperatorRequest;
import com.data.center.api.models.request.RechargeRequest;
import com.data.center.api.models.request.SaleRequest;
import com.data.center.api.models.response.BaseResponse;
import com.data.center.api.models.response.RechargeResponse;
import com.data.center.domain.entity.Recharge;
import com.data.center.infraestructure.abstract_services.IRechargeService;
import com.data.center.util.enums.StatusHttp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/recharge")
public class RechargeController {
    private final IRechargeService rechargeService;

    @PostMapping
    public ResponseEntity<BaseResponse<RechargeResponse>> recharge(@RequestBody RechargeRequest rechargeRequest) {
        RechargeResponse recharge = rechargeService.recharge(rechargeRequest);
        BaseResponse<RechargeResponse> response = BaseResponse.of(
                recharge,
                StatusHttp.RECHARGE_CREATED.getMessage(),
                HttpStatus.CREATED.value()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/by-sale")
    public ResponseEntity<BaseResponse<List<Recharge>>> getAllRechargesBySale(@ModelAttribute SaleRequest saleRequest) {
        List<Recharge> recharges = rechargeService.getAllRechargesBySale(saleRequest);
        BaseResponse<List<Recharge>> response = BaseResponse.of(
                recharges,
                StatusHttp.GET_ALL_RECHARGES.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/by-operator")
    public ResponseEntity<BaseResponse<List<Recharge>>> getAllRechargesByOperator(@ModelAttribute OperatorRequest operatorRequest) {
        List<Recharge> recharges = rechargeService.getAllRechargesByOperator(operatorRequest);
        BaseResponse<List<Recharge>> response = BaseResponse.of(
                recharges,
                StatusHttp.GET_ALL_RECHARGES.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/by-operator-and-sale")
    public ResponseEntity<BaseResponse<List<Recharge>>> getAllRechargesByOperatorAndSale(
            @ModelAttribute OperatorRequest operatorRequest,
            @ModelAttribute SaleRequest saleRequest) {
        List<Recharge> recharges = rechargeService.getAllRechargesByOperatorAndSale(operatorRequest, saleRequest);
        BaseResponse<List<Recharge>> response = BaseResponse.of(
                recharges,
                StatusHttp.GET_ALL_RECHARGES.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<Recharge>>> getAllRecharges() {
        List<Recharge> recharges = rechargeService.getAllRecharges();
        BaseResponse<List<Recharge>> response = BaseResponse.of(
                recharges,
                StatusHttp.GET_ALL_RECHARGES.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
