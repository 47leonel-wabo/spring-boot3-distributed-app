package com.wbt.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "notification",
        path = "${clients.notification.url}"
)
public interface NotificationClient {
    @PostMapping
    NotificationResponse notifyCustomer(final @RequestBody NotificationRequest request);
}
