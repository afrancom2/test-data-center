package com.data.center.api.controller;

import com.data.center.api.models.response.BaseResponse;
import com.data.center.domain.entity.Operator;
import com.data.center.domain.entity.Sale;
import com.data.center.infraestructure.abstract_services.ISaleService;
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
@RequestMapping("/sale")
public class SaleController {
    private final ISaleService saleService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<Sale>>> getAllSales() {

        List<Sale> sales = saleService.findAllSales();
        BaseResponse<List<Sale>> response = BaseResponse.of(
                sales,
                StatusHttp.GET_ALL_SALES.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
