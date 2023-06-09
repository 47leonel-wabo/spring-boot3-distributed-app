package com.wbt.notification.notification.config.amqp.rabbitmq;

import com.wbt.clients.notification.NotificationRequest;
import com.wbt.notification.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public record NotificationConsumer(NotificationService notificationService) {

    @RabbitListener(queues = {"${rabbitmq.queues.notification}"})
    public void consumer(final NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
