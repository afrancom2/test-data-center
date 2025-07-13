package com.data.center.api.controller;

import com.data.center.api.models.response.BaseResponse;
import com.data.center.api.domain.entity.Sale;
import com.data.center.api.infraestructure.abstract_services.ISaleService;
import com.data.center.api.util.enums.StatusHttp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Gestión de Vendedores", description = "Controlador para operaciones de vendedores")
public class SaleController {
    private final ISaleService saleService;

    @GetMapping
    @Operation(summary = "Get All Sales")
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
