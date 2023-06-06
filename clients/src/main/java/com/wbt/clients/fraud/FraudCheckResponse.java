package com.wbt.clients.fraud;

public record FraudCheckResponse(Long customerId, Boolean isFraudster) {
}
