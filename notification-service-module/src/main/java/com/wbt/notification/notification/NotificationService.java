package com.wbt.notification.notification;

import com.wbt.clients.notification.NotificationRequest;
import com.wbt.clients.notification.NotificationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public NotificationResponse send(final NotificationRequest notificationRequest) {
        final var notification = Notification.builder()
                .subject(notificationRequest.subject())
                .message(notificationRequest.message())
                .toCustomerEmail(notificationRequest.targetEmail())
                .sender("wbt")
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.saveAndFlush(notification);
        return new NotificationResponse(notification.getSubject(), notification.getMessage(), notification.getSender(), notification.getToCustomerEmail());
    }
}
