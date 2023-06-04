package com.wbt.customer.customer.dto;

public record FraudCheckResponse(Long customerId, Boolean isFraudster) {
}
