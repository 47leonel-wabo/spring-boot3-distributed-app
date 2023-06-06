package com.wbt.notification.notification;

import com.wbt.clients.notification.NotificationResponse;
import org.springframework.stereotype.Service;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public NotificationResponse createNotification(final String title, final String content) {
        final var notification = Notification.builder()
                .title(title)
                .content(content)
                .build();
        notificationRepository.saveAndFlush(notification);
        return new NotificationResponse(notification.getTitle(), notification.getContent());
    }
}
