package com.wbt.customer.customer;

import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void register(final CustomerRegistrationRequest registrationRequest) {
        final var builtCustomer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();
        // todo: check if customer exist
        // todo: check if email is valid
        customerRepository.save(builtCustomer);
    }
}
