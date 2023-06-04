package com.wbt.fraud.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudService(FraudRepository fraudRepository) {

    public Boolean isFraudsterCustomer(final Long customerId) {
        final var fraud = Fraud.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build();
        fraudRepository.save(fraud);
        return false;
    }
}
