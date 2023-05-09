package com.wbt.customer.customer;

import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void register(final CustomerRegistrationRequest registrationRequest) {
        // todo: build customer
        final var buildedCustomer = Customer.builder()
                .name(registrationRequest.name())
                .email(registrationRequest.email())
                .build();
        // todo: check if customer exist
        // todo: check if email is valid
        // todo: check if email is taken
    }
}
