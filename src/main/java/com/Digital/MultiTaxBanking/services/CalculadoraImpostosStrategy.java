package com.Digital.MultiTaxBanking.services;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculadoraImpostosStrategy {
    BigDecimal calculate(BigDecimal baseValue, BigDecimal days, BigDecimal annualProfit);
}