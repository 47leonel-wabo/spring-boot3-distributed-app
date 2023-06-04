package com.wbt.fraud.fraud;

import com.wbt.fraud.fraud.dto.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/v1/fraud-check"})
@Slf4j
public record FraudController(FraudService fraudService) {

    @GetMapping(path = {"/{id}"})
    public FraudCheckResponse isFraudsterCustomer(final @PathVariable(name = "id") Long customerId) {
        log.info("Fraud check for customer {}", customerId);
        return new FraudCheckResponse(customerId, fraudService.isFraudsterCustomer(customerId));
    }
}
