package com.wbt.notification.notification.config.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internaleExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    // The Exchange
    @Bean
    public TopicExchange internalTopixExchange() {
        return new TopicExchange(this.internaleExchange);
    }

    // The Queue
    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }

    // Then binding Exchange and Queue
    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopixExchange())
                .with(this.internalNotificationRoutingKey);
    }

    public String getInternaleExchange() {
        return internaleExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getInternalNotificationRoutingKey() {
        return internalNotificationRoutingKey;
    }
}
