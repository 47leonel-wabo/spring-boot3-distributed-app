package com.wbt.notification;

//import com.wbt.amqp.RabbitMQMessageProducer;
//import com.wbt.notification.notification.config.amqp.NotificationConfig;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.wbt.notification", "com.wbt.amqp"})
@EnableDiscoveryClient
public class NotificationApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApp.class, args);
    }

//    @Bean
//    CommandLineRunner runner(final RabbitMQMessageProducer messageProducer, final NotificationConfig notificationConfig) {
//        return args -> {
//            messageProducer.publish(
//                    new Person("leonel ka", 30),
//                    notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//
//    record Person(String name, Integer age) {
//    }
}
