package com.wbt.customer.customer;

import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import com.wbt.customer.customer.dto.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void register(final CustomerRegistrationRequest registrationRequest) {
        final var builtCustomer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();

        customerRepository.saveAndFlush(builtCustomer);

        // todo: check if customer exist
        // todo: check if email is valid

        final var response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                builtCustomer.getId()
        );

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        // todo: Send notification
    }
}
