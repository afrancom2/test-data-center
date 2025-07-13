package com.data.center.api.config;

import com.data.center.api.domain.entity.Operator;
import com.data.center.api.domain.entity.Recharge;
import com.data.center.api.domain.entity.Sale;
import com.data.center.api.domain.repository.OperatorRepository;
import com.data.center.api.domain.repository.RechargeRepository;
import com.data.center.api.domain.repository.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(
            OperatorRepository operatorRepository,
            SaleRepository saleRepository,
            RechargeRepository rechargeRepository
    ) {
        return args -> {
            if (operatorRepository.count() == 0 && saleRepository.count() == 0 && rechargeRepository.count() == 0) {

                Operator tigo = new Operator(null, "Tigo");
                Operator movistar = new Operator(null, "Movistar");
                Operator comcel = new Operator(null, "Comcel");
                Operator uff = new Operator(null, "Virgin Mobile");

                operatorRepository.saveAll(List.of(tigo, movistar, comcel, uff));

                Sale ana = new Sale(null, "Ana Martínez", "1010101010");
                Sale juan = new Sale(null, "Juan Pérez", "2020202020");
                Sale laura = new Sale(null, "Laura Gómez", "3030303030");

                saleRepository.saveAll(List.of(ana, juan, laura));

                Recharge r1 = new Recharge(null, tigo, ana, BigDecimal.valueOf(10000.0), LocalDateTime.of(2025, 7, 13, 8, 0));
                Recharge r2 = new Recharge(null, movistar, juan, BigDecimal.valueOf(5000.0), LocalDateTime.of(2025, 7, 13, 9, 30));
                Recharge r3 = new Recharge(null, comcel, ana, BigDecimal.valueOf(7000.0), LocalDateTime.of(2025, 7, 13, 10, 15));
                Recharge r4 = new Recharge(null, tigo, laura, BigDecimal.valueOf(12000.0), LocalDateTime.of(2025, 7, 13, 11, 0));
                Recharge r5 = new Recharge(null, uff, juan, BigDecimal.valueOf(8000.0), LocalDateTime.of(2025, 7, 13, 11, 45));
                Recharge r6 = new Recharge(null, movistar, laura, BigDecimal.valueOf(15000.0), LocalDateTime.of(2025, 7, 13, 13, 0));

                rechargeRepository.saveAll(List.of(r1, r2, r3, r4, r5, r6));
            }
        };
    }
}