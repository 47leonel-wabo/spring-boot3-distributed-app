package com.wbt.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record RabbitMQMessageProducer(AmqpTemplate amqpTemplate) {
    /*
        This method helps to publish to an exchange by providing
        - exchange name
        - routing key
        - and payload
     */
    public void publish(final Object payload, final String exchange, final String routingKey) {
        log.info("Publishing to {} using routeKey {}, payload {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to {} using routeKey {}, payload {}", exchange, routingKey, payload);
    }
}
