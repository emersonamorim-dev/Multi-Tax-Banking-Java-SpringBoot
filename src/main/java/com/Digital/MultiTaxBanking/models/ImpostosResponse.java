package com.Digital.MultiTaxBanking.models;

import java.math.BigDecimal;
import java.util.Map;

public class ImpostosResponse {
    private Map<ImpostosTipos, BigDecimal> taxes;

    public ImpostosResponse(Map<ImpostosTipos, BigDecimal> taxes) {
        this.taxes = taxes;
    }

    public Map<ImpostosTipos, BigDecimal> getTaxes() {
        return taxes;
    }

    public void setTaxes(Map<ImpostosTipos, BigDecimal> taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getTaxForType(ImpostosTipos taxType) {
        return taxes.get(taxType);
    }

    public void setTaxForType(ImpostosTipos taxType, BigDecimal value) {
        taxes.put(taxType, value);
    }
}
