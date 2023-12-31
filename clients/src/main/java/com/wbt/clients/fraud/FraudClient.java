package com.wbt.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fraud",
        url = "${clients.fraud.url}/api/v1/fraud-check"
)
public interface FraudClient {
    @GetMapping(path = {"/{id}"})
    FraudCheckResponse isFraudsterCustomer(final @PathVariable(name = "id") Long customerId);
}
