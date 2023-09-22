package com.Digital.MultiTaxBanking.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digital.MultiTaxBanking.models.EmprestimoRequest;
import com.Digital.MultiTaxBanking.models.ImpostosResponse;
import com.Digital.MultiTaxBanking.services.ImpostoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private ImpostoService taxService;

    @PostMapping("/calcular-impostos")
    public ResponseEntity<Object> calculateSpecificTax(@RequestBody EmprestimoRequest loanRequest) {
        if (loanRequest.getTaxType() == null) {
            return ResponseEntity.badRequest().body("O tipo de imposto é obrigatório");
        }
        BigDecimal taxValue = taxService.calculateSpecificTax(loanRequest);
        return ResponseEntity.ok("Imposto calculado para " + loanRequest.getTaxType() + ": " + taxValue);
    }

    @PostMapping("/calcular-todos-impostos")
    public ResponseEntity<ImpostosResponse> calculateAllTaxes(@RequestBody EmprestimoRequest loanRequest) {
        return ResponseEntity.ok(taxService.calculateAllTaxes(loanRequest));
    }
}
