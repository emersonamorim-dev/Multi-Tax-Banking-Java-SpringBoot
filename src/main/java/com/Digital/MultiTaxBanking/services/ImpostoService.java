package com.Digital.MultiTaxBanking.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Digital.MultiTaxBanking.models.EmprestimoRequest;
import com.Digital.MultiTaxBanking.models.ImpostosResponse;
import com.Digital.MultiTaxBanking.models.ImpostosTipos;

@Service
public class ImpostoService {

    private final Map<ImpostosTipos, CalculadoraImpostosStrategy> taxStrategies = new HashMap<>();

    public ImpostoService() {
        initializeStrategies();
    }

    private void initializeStrategies() {
        taxStrategies.put(ImpostosTipos.IOF, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(days.doubleValue() * 0.000082)).add(baseValue.multiply(BigDecimal.valueOf(0.03)))
        );
    
        taxStrategies.put(ImpostosTipos.IPI, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.02))
        );
    
        taxStrategies.put(ImpostosTipos.IRPF, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.15))
        );
    
        taxStrategies.put(ImpostosTipos.IRPJ, (baseValue, days, profit) -> {
            BigDecimal basicTax = baseValue.multiply(BigDecimal.valueOf(0.15));
            BigDecimal additionalTax = profit.compareTo(BigDecimal.valueOf(50000)) > 0 ? baseValue.multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
            return basicTax.add(additionalTax);
        });
    
        taxStrategies.put(ImpostosTipos.COFINS, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.076))
        );
    
        taxStrategies.put(ImpostosTipos.PIS_PASEP, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.0165))
        );
    
        taxStrategies.put(ImpostosTipos.CSLL, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.09))
        );
    
        taxStrategies.put(ImpostosTipos.INSS, (baseValue, days, profit) -> 
            baseValue.multiply(BigDecimal.valueOf(0.14))
        );
    }
    

    public BigDecimal calculateSpecificTax(EmprestimoRequest loanRequest) {
        CalculadoraImpostosStrategy strategy = taxStrategies.get(loanRequest.getTaxType());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid tax type");
        }
        return strategy.calculate(loanRequest.getBaseValue(), loanRequest.getDays(), loanRequest.getAnnualProfit());
    }

    public ImpostosResponse calculateAllTaxes(EmprestimoRequest loanRequest) {
        Map<ImpostosTipos, BigDecimal> calculatedTaxes = new HashMap<>();

        for (ImpostosTipos type : ImpostosTipos.values()) {
            CalculadoraImpostosStrategy strategy = taxStrategies.get(type);
            calculatedTaxes.put(type, strategy.calculate(loanRequest.getBaseValue(), loanRequest.getDays(), loanRequest.getAnnualProfit()));
        }

        return new ImpostosResponse(calculatedTaxes);
    }
}
