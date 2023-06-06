package com.wbt.notification.notification;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    private Long id;

    private String subject;
    private String message;
    private String sender;
    private String toCustomerEmail;
    private LocalDateTime sentAt;

    public Notification(String subject, String message, String sender, String toCustomerEmail, LocalDateTime sentAt) {
        this.subject = subject;
        this.message = message;
        this.sender = sender;
        this.toCustomerEmail = toCustomerEmail;
        this.sentAt = sentAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(subject, that.subject) && Objects.equals(message, that.message) && Objects.equals(sender, that.sender) && Objects.equals(toCustomerEmail, that.toCustomerEmail) && Objects.equals(sentAt, that.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, message, sender, toCustomerEmail, sentAt);
    }
}
