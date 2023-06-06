package com.wbt.customer.customer;

import com.wbt.clients.fraud.FraudClient;
import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudClient fraudClient) {

    public void register(final CustomerRegistrationRequest registrationRequest) {
        final var builtCustomer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();

        customerRepository.saveAndFlush(builtCustomer);

        // todo: check if customer exist
        // todo: check if email is valid

//        final var response = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                builtCustomer.getId()
//        );

        final var response = fraudClient.isFraudsterCustomer(builtCustomer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        // todo: Send notification
    }
}
