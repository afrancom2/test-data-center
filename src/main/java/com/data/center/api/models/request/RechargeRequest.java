package com.data.center.api.models.request;

import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RechargeRequest implements Serializable {
    private Long operatorId;
    private Long SaleId;
    @Digits(integer = 10, fraction = 2)
    @NotNull
    private BigDecimal amount;
}
