package com.wbt.customer.customer;

import com.wbt.amqp.RabbitMQMessageProducer;
import com.wbt.clients.fraud.FraudClient;
import com.wbt.clients.notification.NotificationRequest;
import com.wbt.customer.customer.dto.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(
        CustomerRepository customerRepository,
        FraudClient fraudClient,
        RabbitMQMessageProducer messageProducer) {

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

        // Call for Fraud Service
        final var response = fraudClient.isFraudsterCustomer(builtCustomer.getId());

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        // Call for Notification Service (async way)
        NotificationRequest notificationRequest = new NotificationRequest(
                "Fraud Verification",
                "Customer with ID = %s is not a Fraudster!".formatted(builtCustomer.getId()),
                builtCustomer.getEmail());

        // Messaging using RabbitMQ (Async)
        messageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
