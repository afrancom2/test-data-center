package com.data.center.api.controller;

import com.data.center.api.models.response.BaseResponse;
import com.data.center.domain.entity.Operator;
import com.data.center.infraestructure.abstract_services.IOperatorService;
import com.data.center.util.enums.StatusHttp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/operator")
public class OperatorController {
    private final IOperatorService operatorService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<Operator>>> getAllOperators() {
        List<Operator> operators = operatorService.findAllOperators();
        BaseResponse<List<Operator>> response = BaseResponse.of(
                operators,
                StatusHttp.GET_ALL_OPERATORS.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
