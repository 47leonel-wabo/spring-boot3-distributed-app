package com.wbt.clients.notification;

public record NotificationRequest(String subject, String message, String targetEmail) {
}
