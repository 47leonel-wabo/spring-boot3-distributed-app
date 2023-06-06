package com.wbt.notification.notification;

import com.wbt.clients.notification.NotificationRequest;
import com.wbt.clients.notification.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1/notifications"})
@Slf4j
public record NotificationController(NotificationService notificationService) {

    @PostMapping
    public NotificationResponse notifyCustomer(final @RequestBody NotificationRequest request){
        log.info("Notification to: {} \n On: {} \n Message: {}", request.targetEmail(), request.subject(), request.message());
        return notificationService.send(request);
    }
}
