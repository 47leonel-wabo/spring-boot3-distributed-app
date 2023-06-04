package com.wbt.fraud.fraud;

import com.wbt.fraud.fraud.dto.FraudCheckResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/v1/fraud-check"})
public record FraudController(FraudService fraudService) {

    @GetMapping(path = {"/{id}"})
    public FraudCheckResponse isFraudsterCustomer(final @PathVariable(name = "id") Long customerId) {
        return new FraudCheckResponse(customerId, fraudService.isFraudsterCustomer(customerId));
    }
}
