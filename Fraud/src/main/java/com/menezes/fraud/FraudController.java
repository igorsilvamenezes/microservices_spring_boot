package com.menezes.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable Integer customerId ) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}