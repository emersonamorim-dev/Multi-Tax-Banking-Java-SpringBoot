package com.Digital.MultiTaxBanking.models;

import java.math.BigDecimal;

public class EmprestimoRequest {
    private ImpostosTipos taxType; 
    private BigDecimal baseValue;
    private BigDecimal days;
    private BigDecimal annualProfit;

    public ImpostosTipos getTaxType() {
        return taxType;
    }

    public void setTaxType(ImpostosTipos taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(BigDecimal baseValue) {
        this.baseValue = baseValue;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }

    public BigDecimal getAnnualProfit() {
        return annualProfit;
    }

    public void setAnnualProfit(BigDecimal annualProfit) {
        this.annualProfit = annualProfit;
    }
}
